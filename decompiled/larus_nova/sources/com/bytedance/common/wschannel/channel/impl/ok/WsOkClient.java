package com.bytedance.common.wschannel.channel.impl.ok;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.alipay.sdk.m.p.e;
import com.baidu.mapapi.SDKInitializer;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy;
import com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatRealWebSocket;
import com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatWebSocket;
import com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener;
import com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy;
import com.bytedance.common.wschannel.heartbeat.CompensateHeartBeatManager;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.heartbeat.normal.NormalHeartBeatMeta;
import com.bytedance.common.wschannel.heartbeat.normal.NormalHeartBeatPolicy;
import com.bytedance.common.wschannel.model.Frame;
import com.bytedance.common.wschannel.server.NetworkUtils;
import com.bytedance.common.wschannel.utils.Utils;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLRequest;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.huawei.hms.framework.common.ContainerUtils;
import com.squareup.wire.Wire;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;
import okhttp3.WebSocket;
import okhttp3.f;
import okio.ByteString;

/* JADX INFO: loaded from: classes15.dex */
class WsOkClient implements WeakHandler.IHandler {
    private boolean isManualClose;
    private CompensateHeartBeatManager mCompensateHeartBeatManager;
    private final Config mConfig;
    private Map<String, Object> mConfigMap;
    private final Context mContext;
    private CustomHeartBeatRealWebSocket mCurrentSocket;
    private int mCurrentStatus;
    private Handler mHandler;
    private BaseHeartBeatPolicy mHeartBeatPolicy;
    private WebSocketListener mListener;
    private OkHttpClient mOkHttpClient;
    private boolean mPendingConnectAfterClosed;
    private WsPolicy mPolicy;
    private Request mRequest;
    private WsStatusListener mWsStatusListener;

    public static final class Builder {
        private Context mContext;
        private BaseHeartBeatPolicy mHeartBeatPolicy;
        private OkHttpClient mOkHttpClient;
        private RetryPolicy mRetryPolicy;
        private List<String> wsUrls;

        public WsOkClient build() {
            return new WsOkClient(new Config(this.mContext, this.wsUrls, this.mOkHttpClient, this.mRetryPolicy, this.mHeartBeatPolicy), null);
        }

        public Builder(Context r100) {
            this.mContext = r100;
        }

        public Builder heartBeatPolicy(BaseHeartBeatPolicy r100) {
            if (r100 == null) goto L4;
            this.mHeartBeatPolicy = r100;
        L4:
            return this;
        }

        public Builder retryPolicy(RetryPolicy r100) {
            this.mRetryPolicy = r100;
            return this;
        }
    }

    public static final class Config {
        private Context mContext;
        private BaseHeartBeatPolicy mHeartBeatPolicy;
        private OkHttpClient mOkHttpClient;
        private RetryPolicy mRetryPolicy;
        private List<String> wsUrls;

        public String toString() {
            return "Config{mHeartBeatPolicy=" + this.mHeartBeatPolicy + ", mContext=" + this.mContext + ", wsUrls=" + this.wsUrls + ", mOkHttpClient=" + this.mOkHttpClient + ", mRetryPolicy=" + this.mRetryPolicy + '}';
        }

        public static /* synthetic */ Context access$100(Config r100) {
            return r100.mContext;
        }

        public static /* synthetic */ OkHttpClient access$200(Config r100) {
            return r100.mOkHttpClient;
        }

        public static /* synthetic */ BaseHeartBeatPolicy access$300(Config r100) {
            return r100.mHeartBeatPolicy;
        }

        public static /* synthetic */ List access$800(Config r100) {
            return r100.wsUrls;
        }

        public static /* synthetic */ RetryPolicy access$900(Config r100) {
            return r100.mRetryPolicy;
        }

        public static /* synthetic */ List access$802(Config r100, List r101) {
            r100.wsUrls = r101;
            return r101;
        }

        public Config(Context r100, List<String> r101, OkHttpClient r102, RetryPolicy r103, BaseHeartBeatPolicy r104) {
            this.mContext = r100;
            this.wsUrls = r101;
            this.mOkHttpClient = r102;
            this.mRetryPolicy = r103;
            this.mHeartBeatPolicy = r104;
        }
    }

    public class WsListener extends WebSocketListener {
        final /* synthetic */ WsOkClient this$0;

        private boolean canRetry(int r100) {
            if (r100 > 0) goto L4;
        L13:
            return true;
        L4:
            if (r100 == 414) goto L13;
            if (r100 == 511) goto L13;
            if (r100 == 512) goto L13;
            if (r100 == 513) goto L13;
            return false;
        }

        private WsListener(WsOkClient r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ WsListener(WsOkClient r100, AnonymousClass1 r101) {
            this(r100);
        }

        public static /* synthetic */ boolean access$2700(WsListener r100, int r101) {
            return r100.canRetry(r101);
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener
        public void onMessage(CustomHeartBeatWebSocket r100, final String r101) {
            WsOkClient.access$1700(this.this$0, new AnonymousClass3(this, r101));
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener
        public void onOpen(final CustomHeartBeatWebSocket r100, final Response r101) {
            Runnable r102 = new AnonymousClass1(this, r100, r101);
            WsOkClient.access$1700(this.this$0, r102);
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener
        public void onPong(final CustomHeartBeatWebSocket r100, ByteString r101) {
            WsOkClient.access$1700(this.this$0, new AnonymousClass7(this, r100));
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener
        public void onMessage(CustomHeartBeatWebSocket r100, final ByteString r101) {
            WsOkClient.access$1700(this.this$0, new AnonymousClass2(this, r101));
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener
        public void onClosed(final CustomHeartBeatWebSocket r100, final int r110, final String r111) {
            final String r101 = WsOkClient.access$1900(this.this$0, r100);
            WsOkClient.access$1700(this.this$0, new AnonymousClass5(this, r100, r101, r110, r111));
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener
        public void onClosing(CustomHeartBeatWebSocket r100, int r101, String r102) {
            super.onClosing(r100, r101, r102);
            WsOkClient.access$1700(this.this$0, new AnonymousClass4(this));
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener
        public void onFailure(final CustomHeartBeatWebSocket r100, Throwable r110, Response r111) {
            final String r101 = WsOkClient.access$1900(this.this$0, r100);
            final int r102 = WsOkClient.access$2400(this.this$0, r111);
            String r103 = WsOkClient.access$2500(this.this$0, r102);
            if (StringUtils.isEmpty(r103) == true) goto L5;
            final String r104 = r103;
        L10:
            final Pair<String, Long> r105 = WsOkClient.access$2100(this.this$0).getRetryUrlAndInterval(r111);
            WsOkClient.access$2600(this.this$0, r111);
            WsOkClient.access$1700(this.this$0, new AnonymousClass6(this, r101, r102, r104, r100, r105));
            return;
        L5:
            if (StringUtils.isEmpty(r110.getMessage()) == false) goto L7;
            String r112 = Log.getStackTraceString(r110);
        L8:
            r104 = r112;
            goto L10
        L7:
            r112 = r110.getMessage();
            goto L8
        }
    }

    public interface WsStatusListener {
        void onClosed(String r100, int r101, String r102);

        void onConnecting(String r100);

        void onFailure(String r100, int r101, String r102);

        void onMessage(String r100);

        void onMessage(ByteString r100);

        void onOpen(Response r100);
    }

    private String getErrorReason(int r100) {
        if (r100 != 0) goto L5;
        return "success";
    L5:
        if (r100 != 404) goto L8;
        return "uri not found";
    L8:
        if (r100 != 409) goto L11;
        return "fpid not registered";
    L11:
        if (r100 != 410) goto L14;
        return "invalid device id";
    L14:
        if (r100 != 411) goto L17;
        return "appid not registered";
    L17:
        if (r100 != 412) goto L20;
        return "websocket protocol not support";
    L20:
        if (r100 != 413) goto L23;
        return "the device already connected";
    L23:
        if (r100 != 414) goto L26;
        return "server can't accept more connection,try again later";
    L26:
        if (r100 != 415) goto L29;
        return "device was blocked";
    L29:
        if (r100 != 416) goto L32;
        return "parameter error";
    L32:
        if (r100 != 417) goto L35;
        return "authentication failed";
    L35:
        if (r100 != 510) goto L38;
        return "server internal error";
    L38:
        if (r100 != 511) goto L41;
        return "server is busy，try again later";
    L41:
        if (r100 != 512) goto L44;
        return "server is shutting down";
    L44:
        if (r100 != 513) goto L47;
        return "auth server is error";
    L47:
        if (r100 != 514) goto L49;
        return "auth return error";
    L49:
        return "";
    }

    public synchronized int getCurrentStatus() {
        monitor-enter(this);
        int r100 = this.mCurrentStatus;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    private void ensureWebSocketClosed() {
        CustomHeartBeatRealWebSocket r100 = this.mCurrentSocket;
        if (r100 == null) goto L6;
        r100.closeQuietly(1000, "normal close");
        return;
    }

    private int networkType() {
        NetworkUtils.NetworkType r100 = NetworkUtils.getNetworkType(this.mContext);
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100 != NetworkUtils.NetworkType.NONE) goto L9;
        return 0;
    L9:
        if (r100 != NetworkUtils.NetworkType.WIFI) goto L13;
        return 1;
    L13:
        if (r100 != NetworkUtils.NetworkType.MOBILE_2G) goto L17;
        return 2;
    L17:
        if (r100 != NetworkUtils.NetworkType.MOBILE_3G) goto L20;
        return 3;
    L20:
        return 4;
    }

    private void reactOnHeartBeatTimeout() {
        Request r100 = this.mRequest;
        if (r100 == null) goto L7;
        WsStatusListener r101 = this.mWsStatusListener;
        if (r101 == null) goto L7;
        r101.onFailure(r100.url().toString(), 3, "heatbeat timeout");
    L7:
        Pair<String, Long> r102 = this.mPolicy.getRetryUrlAndInterval(null);
        stopConnectInternal();
        ensureWebSocketClosed();
        tryReconnect(0, (String) r102.first, true);
    }

    private void reactOnSendPing() {
        this.mHandler.post(new AnonymousClass6(this));
    }

    private void resetPolicy() {
        WsPolicy r100 = this.mPolicy;
        if (r100 == null) goto L6;
        r100.reset();
        return;
    }

    private void stopConnectInternal() {
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(5);
        cancelReconnect();
        disconnect();
    }

    public void destroy() {
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(5);
        runOnHandlerThread(new AnonymousClass5(this));
    }

    public void stopConnect() {
        runOnHandlerThread(new AnonymousClass3(this));
    }

    private void cancelReconnect() {
        resetPolicy();
        this.mHandler.removeMessages(1);
    }

    private boolean disconnect() {
        int r100 = getCurrentStatus();
        if (r100 != 3) goto L5;
        return true;
    L5:
        if (r100 != 2) goto L7;
        return true;
    L7:
        if (r100 == 5) goto L23;
        this.mHeartBeatPolicy.onDisconnected();
        CustomHeartBeatRealWebSocket r101 = this.mCurrentSocket;
        if (r101 == null) goto L22;
        Message r102 = this.mHandler.obtainMessage(6, r101);
        this.mHandler.sendMessageDelayed(r102, 1000);
        if (r100 != 4) goto L15;
        this.mCurrentSocket.close(1000, "normal close");
        setStatus(6);
        return false;
    L15:
        this.mCurrentSocket.cancel();
        setStatus(3);
        if (r100 != 1) goto L24;
        return false;
    L24:
        return true;
    L22:
        return true;
    L23:
        return true;
    }

    public boolean isConnected() {
        if (getCurrentStatus() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    private WsOkClient(Config r100) {
        this.mCurrentStatus = 3;
        this.mConfigMap = new ConcurrentHashMap();
        this.mHandler = new WeakHandler(Looper.myLooper(), this);
        this.mListener = new WsListener(this, null);
        this.mConfig = r100;
        this.mContext = Config.access$100(r100);
        this.mOkHttpClient = Config.access$200(r100);
        BaseHeartBeatPolicy r101 = Config.access$300(r100);
        this.mHeartBeatPolicy = r101;
        if (r101 != null) goto L5;
        this.mHeartBeatPolicy = new NormalHeartBeatPolicy(new NormalHeartBeatMeta().provideDefaultMeta());
    L5:
        this.mHeartBeatPolicy.init(new AnonymousClass1(this), this.mHandler);
        this.mCompensateHeartBeatManager = new CompensateHeartBeatManager(new AnonymousClass2(this), this.mHandler);
    }

    public static /* synthetic */ Handler access$1000(WsOkClient r100) {
        return r100.mHandler;
    }

    public static /* synthetic */ CustomHeartBeatRealWebSocket access$1100(WsOkClient r100) {
        return r100.mCurrentSocket;
    }

    public static /* synthetic */ BaseHeartBeatPolicy access$1200(WsOkClient r100) {
        return r100.mHeartBeatPolicy;
    }

    public static /* synthetic */ void access$1500(WsOkClient r100) {
        r100.cancelReconnect();
    }

    public static /* synthetic */ WsStatusListener access$1600(WsOkClient r100) {
        return r100.mWsStatusListener;
    }

    public static /* synthetic */ boolean access$2000(WsOkClient r100) {
        return r100.mPendingConnectAfterClosed;
    }

    public static /* synthetic */ WsPolicy access$2100(WsOkClient r100) {
        return r100.mPolicy;
    }

    public static /* synthetic */ void access$2800(WsOkClient r100) {
        r100.resetPolicy();
    }

    public static /* synthetic */ CompensateHeartBeatManager access$2900(WsOkClient r100) {
        return r100.mCompensateHeartBeatManager;
    }

    public static /* synthetic */ void access$400(WsOkClient r100) {
        r100.reactOnHeartBeatTimeout();
    }

    public static /* synthetic */ void access$500(WsOkClient r100) {
        r100.reactOnSendPing();
    }

    public static /* synthetic */ boolean access$600(WsOkClient r100) {
        return r100.isManualClose;
    }

    public static /* synthetic */ void access$700(WsOkClient r100) {
        r100.stopConnectInternal();
    }

    private String doUrlDispatch(String r100) throws Exception {
        if (URLDispatcher.inst().isDispatchActionsEmpty() == true) goto L19;
        URLRequest r101 = new URLRequest(r100, "GET");
        DispatchResult r102 = URLDispatcher.inst().getDispatchResultForUrl(r101);
        if (r102 != null) goto L7;
    L24:
        return r100;
    L7:
        if (r100.equals(r102.mDispatchedURL) == true) goto L24;
        if (r102.mDispatchedURL.isEmpty() == false) goto L16;
        if (r102.mActionRuleIdList.isEmpty() == true) goto L16;
        throw new Exception(WsConstants.TTNET_TRAFFIC_CONTROL_DROP);
    L16:
        if (UrlUtils.isValidUrl(r102.mDispatchedURL) == false) goto L24;
        return r102.mDispatchedURL;
    L19:
        Logger.d("WsChannelSdk_ok", "fallback to host replace map");
        String r103 = URLDispatcher.inst().handleHostMapping(r100);
        if (r100.equals(r103) == true) goto L24;
        if (UrlUtils.isValidUrl(r103) == false) goto L24;
        return r103;
    }

    private static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder r100) {
        if (Build.VERSION.SDK_INT < 22) goto L11;
    L9:
        return r100;
    L11:
        SSLContext r101 = SSLContext.getInstance("TLSv1.2");     // Catch: Exception -> L10
        r101.init(null, null, null);     // Catch: Exception -> L10
        r100 = enableTls12WithTwoParamsMethod(r100, r101);     // Catch: Exception -> L7
    L8:
        f.a r102 = new f.a(f.f523840e);     // Catch: Exception -> L10
        r102.d(new TlsVersion[]{TlsVersion.TLS_1_2});     // Catch: Exception -> L10
        f r103 = new f(r102);     // Catch: Exception -> L10
        ArrayList r104 = new ArrayList();     // Catch: Exception -> L10
        r104.add(r103);     // Catch: Exception -> L10
        r104.add(f.f523841f);     // Catch: Exception -> L10
        r104.add(f.f523842g);     // Catch: Exception -> L10
        r100.connectionSpecs(r104);     // Catch: Exception -> L10
        goto L9
    L7:
        r100.sslSocketFactory(new Tls12SocketFactory(r101.getSocketFactory()));     // Catch: Exception -> L10
        goto L8
    }

    private int getErrorCode(Response r100) {
        if (r100 != null) goto L9;
        return -1;
    L9:
        return CastIntegerProtector.parseInt(r100.header("Handshake-Status"));
    L11:
        return -1;
    }

    private void initAndConnect(String r100) throws Exception {
        if (this.mOkHttpClient != null) goto L5;
        OkHttpClient.Builder r101 = new OkHttpClient.Builder();
        r101.protocols(Collections.singletonList(Protocol.HTTP_1_1));
        this.mOkHttpClient = enableTls12OnPreLollipop(r101).build();
    L5:
        Map<String, Object> r102 = this.mConfigMap;
        String r103 = createUrl(r100, r102);
        if (r102 == null) goto L8;
        Map r104 = (Map) r102.get(WsConstants.KEY_HEADERS);
    L10:
        if (StringUtils.isEmpty(r103) == false) goto L13;
        Logger.e("WsChannelSdk_ok", "url is empty,cancel connect");
        return;
    L13:
        ensureWebSocketClosed();
        Logger.d("WsChannelSdk_ok", "try tu open socket:" + r103);
        Request r105 = this.mRequest;
        if (r105 != null) goto L16;
    L17:
        Request.Builder r106 = new Request.Builder().addHeader("Sec-Websocket-Protocol", "pbbp").addHeader("x-support-ack", "1").url(r103);
        if (r104 == null) goto L23;
        Iterator r107 = r104.entrySet().iterator();
    L21:
        if (r107.hasNext() == false) goto L23;
        Map.Entry r108 = (Map.Entry) r107.next();
        r106.addHeader((String) r108.getKey(), (String) r108.getValue());
    L23:
        this.mRequest = r106.build();
    L24:
        setStatus(1);
        CustomHeartBeatRealWebSocket r109 = CustomHeartBeatRealWebSocket.create(this.mRequest, WsChannelSettings.inst(this.mContext).getSocketReadLimitSize(), this.mListener);
        this.mCurrentSocket = r109;
        r109.connect(this.mOkHttpClient);
        this.mCompensateHeartBeatManager.setWebSocket(this.mCurrentSocket);
        WsStatusListener r110 = this.mWsStatusListener;
        if (r110 == null) goto L29;
        r110.onConnecting(r103);
        return;
    L29:
        return;
    L16:
        if (r103.equals(r105.url().toString()) == true) goto L24;
    L8:
        r104 = null;
        goto L10
    }

    private boolean isNetworkConnected(Context r100) {
        return NetworkUtils.isNetworkAvailable(r100);
    }

    private void runOnHandlerThread(Runnable r100) {
        this.mHandler.post(r100);
    }

    private void safeClose(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    private String safeGetUrl(WebSocket r100) {
        if (r100 == null) goto L9;
        Request r101 = r100.request();
        if (r101 == null) goto L11;
        HttpUrl r102 = r101.url();
        if (r102 != null) goto L8;
        return "";
    L8:
        return r102.toString();
    L11:
        return "";
    L9:
        return "";
    }

    private boolean send(Object r100) {
        Logger.d("WsChannelSdk_ok", "send msg : " + r100);
        if (this.mCurrentSocket != null) goto L5;
    L12:
        return false;
    L5:
        if (isConnected() == false) goto L12;
        if ((r100 instanceof String) == false) goto L10;
        return this.mCurrentSocket.send((String) r100);
    L10:
        if ((r100 instanceof ByteString) == false) goto L12;
        return this.mCurrentSocket.send((ByteString) r100);
    }

    private void sendMessageAckIfNeeded(byte[] r100) throws IOException {
        Logger.d("WsChannelSdk_ok", "enter sendMessageAckIfNeeded");
        Frame r101 = Frame.ADAPTER.decode(r100);
        List r102 = (List) Wire.get(r101.headers, Collections.emptyList());
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.size() <= 0) goto L41;
        Iterator r103 = r102.iterator();
        boolean r104 = false;
        String r105 = null;
    L9:
        if (r103.hasNext() == false) goto L23;
        Frame.ExtendedEntry r106 = (Frame.ExtendedEntry) r103.next();
        if (r106.key.equals(WsConstants.KEY_NEED_ACK) == false) goto L16;
        if (r106.value.equals("1") == false) goto L16;
        r104 = true;
    L16:
        if (r106.key.equals(WsConstants.KEY_FRONTIER_MSGID) == true) goto L18;
    L20:
        if (r104 == false) goto L9;
        if (TextUtils.isEmpty(r105) == true) goto L9;
    L18:
        if (TextUtils.isEmpty(r106.value) == true) goto L20;
        r105 = r106.value;
    L23:
        if (r104 == true) goto L25;
        return;
    L25:
        ArrayList r107 = new ArrayList();
        r107.add(new Frame.ExtendedEntry.Builder().key(WsConstants.KEY_IS_ACK).value("1").build());
        r107.add(new Frame.ExtendedEntry.Builder().key(WsConstants.KEY_ACK_ID).value((String) Wire.get(r101.logidnew, "")).build());
        r107.add(new Frame.ExtendedEntry.Builder().key(WsConstants.KEY_ACK_CODE).value("0").build());
        if (TextUtils.isEmpty(r105) == true) goto L28;
        r107.add(new Frame.ExtendedEntry.Builder().key(WsConstants.KEY_FRONTIER_MSGID).value(r105).build());
    L28:
        Frame.Builder r108 = new Frame.Builder().seqid((Long) Wire.get(r101.seqid, Frame.DEFAULT_SEQID)).logid((Long) Wire.get(r101.logid, Frame.DEFAULT_LOGID)).service((Integer) Wire.get(r101.service, Frame.DEFAULT_SERVICE)).method((Integer) Wire.get(r101.method, Frame.DEFAULT_METHOD)).logidnew((String) Wire.get(r101.logidnew, "")).headers(r107);
        sendMessage(Frame.ADAPTER.encode(r108.build()));
        return;
    }

    private synchronized void setStatus(int r100) {
        monitor-enter(this);
        this.mCurrentStatus = r100;     // Catch: Throwable -> L25
        String r101 = "";
        if (r100 != 1) goto L8;
        r101 = PTYSocketStateCallback.CONNECTING;
    L22:
        Logger.d("WsChannelSdk_ok", "current status is :".concat(r101));     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L8:
        if (r100 != 2) goto L11;
        r101 = "connect failed";
        goto L22
    L11:
        if (r100 != 3) goto L14;
        r101 = "connection close ";
        goto L22
    L14:
        if (r100 != 4) goto L17;
        r101 = PTYSocketStateCallback.CONNECTED;
        goto L22
    L17:
        if (r100 != 5) goto L20;
        r101 = "retry...";
        goto L22
    L20:
        if (r100 != 6) goto L22;
        r101 = "half-close status";
    L25:
        th = move-exception;
        throw th;
    }

    private void tryConnect(String r100) {
        if (isNetworkConnected(this.mContext) == true) goto L6;
        notifyFailedAndReset(r100, 1, SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR, true);
        return;
    L6:
        int r101 = getCurrentStatus();
        if (r101 == 4) goto L24;
        if (r101 == 1) goto L25;
        initAndConnect(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        if (this.mWsStatusListener == null) goto L16;
        this.mWsStatusListener.onFailure(r100, 4, Log.getStackTraceString(th));
    L16:
        if (WsConstants.TTNET_TRAFFIC_CONTROL_DROP.equals(th.getMessage()) == false) goto L26;
        String r102 = this.mPolicy.getNextUrl();
        if (TextUtils.isEmpty(r102) == true) goto L20;
        Logger.d("WsChannelSdk_ok", th.getMessage() + ":" + r100 + ", try next url:" + r102);
        tryReconnect(0, r102, true);
        return;
    L20:
        Logger.d("WsChannelSdk_ok", "All urls are dropped, stop retry.");
        this.mPolicy.reset();
        return;
    L26:
        return;
    L25:
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.what;
        if (r101 != 1) goto L11;
        if (isConnected() == false) goto L9;
        return;
    L9:
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        tryConnect((String) r100.obj);
        return;
    L11:
        if (r101 != 2) goto L17;
        this.mHandler.removeMessages(2);     // Catch: Throwable -> L14
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L14
        Config.access$802(this.mConfig, (List) r100.obj);     // Catch: Throwable -> L14
        this.isManualClose = false;     // Catch: Throwable -> L14
        this.mPolicy = new WsPolicy(Config.access$800(this.mConfig), Config.access$900(this.mConfig));     // Catch: Throwable -> L14
        cancelReconnect();     // Catch: Throwable -> L14
        tryConnect(this.mPolicy.getUrl());     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L17:
        if (r101 != 3) goto L32;
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(1);
        if (isConnected() == false) goto L21;
        return;
    L21:
        cancelReconnect();
        if (isNetworkConnected(this.mContext) == true) goto L24;
        Logger.d("WsChannelSdk_ok", "network changed! but the network is not available，do not retry");
        return;
    L24:
        if (disconnect() == false) goto L29;
        WsPolicy r102 = this.mPolicy;
        if (r102 != null) goto L28;
        return;
    L28:
        tryConnect(r102.getUrl());
        return;
    L29:
        this.mPendingConnectAfterClosed = true;
        return;
    L32:
        if (r101 != 5) goto L39;
        if (((Boolean) r100.obj).booleanValue() == false) goto L36;
        AppState r103 = AppState.STATE_FOREGROUND;
    L37:
        this.mCompensateHeartBeatManager.updateCurrentAppState(r103);
        this.mHeartBeatPolicy.onAppStateUpdate(r103);
        return;
    L36:
        r103 = AppState.STATE_BACKGROUND;
        goto L37
    L39:
        if (r101 != 7) goto L60;
        this.mHandler.removeMessages(2);     // Catch: Throwable -> L45
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L45
        Config.access$802(this.mConfig, (List) r100.obj);     // Catch: Throwable -> L45
        this.isManualClose = false;     // Catch: Throwable -> L45
        this.mPolicy = new WsPolicy(Config.access$800(this.mConfig), Config.access$900(this.mConfig));     // Catch: Throwable -> L45
        cancelReconnect();     // Catch: Throwable -> L45
        if (disconnect() == false) goto L43;
        tryConnect(this.mPolicy.getUrl());     // Catch: Throwable -> L45
    L50:
        return;
    L43:
        this.mPendingConnectAfterClosed = true;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void onAppStateChanged(boolean r100) {
        this.mHandler.obtainMessage(5, Boolean.valueOf(r100)).sendToTarget();
    }

    public void onNetworkStateChanged(int r100) {
        this.mHandler.obtainMessage(3, Integer.valueOf(r100)).sendToTarget();
    }

    public boolean sendMessage(byte[] r100) {
        return sendMessage(ByteString.of(r100));
    }

    public void setConfigMap(Map<String, Object> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.remove("channel_id");
        this.mConfigMap.putAll(r100);
    }

    public void setWsStatusListener(WsStatusListener r100) {
        this.mWsStatusListener = r100;
    }

    private boolean sendMessage(ByteString r100) {
        return send(r100);
    }

    public /* synthetic */ WsOkClient(Config r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static /* synthetic */ CustomHeartBeatRealWebSocket access$1102(WsOkClient r100, CustomHeartBeatRealWebSocket r101) {
        r100.mCurrentSocket = r101;
        return r101;
    }

    public static /* synthetic */ void access$1400(WsOkClient r100, int r101) {
        r100.setStatus(r101);
    }

    public static /* synthetic */ void access$1700(WsOkClient r100, Runnable r101) {
        r100.runOnHandlerThread(r101);
    }

    public static /* synthetic */ void access$1800(WsOkClient r100, byte[] r101) throws IOException {
        r100.sendMessageAckIfNeeded(r101);
    }

    public static /* synthetic */ String access$1900(WsOkClient r100, WebSocket r101) {
        return r100.safeGetUrl(r101);
    }

    public static /* synthetic */ boolean access$2002(WsOkClient r100, boolean r101) {
        r100.mPendingConnectAfterClosed = r101;
        return r101;
    }

    public static /* synthetic */ void access$2200(WsOkClient r100, String r101) {
        r100.tryConnect(r101);
    }

    public static /* synthetic */ int access$2400(WsOkClient r100, Response r101) {
        return r100.getErrorCode(r101);
    }

    public static /* synthetic */ String access$2500(WsOkClient r100, int r101) {
        return r100.getErrorReason(r101);
    }

    public static /* synthetic */ void access$2600(WsOkClient r100, Closeable r101) {
        r100.safeClose(r101);
    }

    public static /* synthetic */ boolean access$602(WsOkClient r100, boolean r101) {
        r100.isManualClose = r101;
        return r101;
    }

    private String createUrl(String r100, Map<String, Object> r110) throws Exception {
        if (TextUtils.isEmpty(r100) == true) goto L44;
        if (r110 == null) goto L44;
        String r101 = Utils.md5(String.valueOf(r110.get(WsConstants.KEY_FPID)) + String.valueOf(r110.get("app_key")) + String.valueOf(r110.get("device_id")) + WsConstants.SALT).toLowerCase();
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        Iterator<Map.Entry<String, Object>> r103 = r110.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L29;
        Map.Entry<String, Object> r104 = r103.next();
        if (r104 == null) goto L8;
        if (TextUtils.isEmpty(r104.getKey()) == true) goto L8;
        if (TextUtils.equals(r104.getKey(), WsConstants.KEY_HEADERS) == true) goto L8;
        if (r104.getValue() != null) goto L20;
        String r105 = "";
    L21:
        String r106 = r104.getKey();
        if (StringUtils.equal("app_key", r106) == true) goto L8;
        if (StringUtils.equal(r106, "extra") == true) goto L8;
        if (StringUtils.equal("app_version", r106) == true) goto L27;
        r102.appendQueryParameter(r106, r105);
        goto L8
    L27:
        r102.appendQueryParameter("version_code", r105);
        goto L8
    L20:
        r105 = r104.getValue().toString();
        goto L21
    L29:
        String r111 = (String) r110.get("extra");
        if (StringUtils.isEmpty(r111) == true) goto L39;
        String[] r112 = r111.split("&");
        int r107 = r112.length;
        int r108 = 0;
    L32:
        if (r108 >= r107) goto L39;
        String r109 = r112[r108];
        if (TextUtils.isEmpty(r109) == true) goto L38;
        String[] r113 = r109.split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r113.length != 2) goto L38;
        r102.appendQueryParameter(r113[0], Uri.decode(r113[1]));
    L38:
        r108 = r108 + 1;
    L39:
        r102.appendQueryParameter("access_key", r101);
        r102.appendQueryParameter("ne", String.valueOf(networkType()));
        String r114 = r102.build().toString();
        Logger.d("WsChannelSdk_ok", "origin url: " + r114);
        String r115 = doUrlDispatch(r114);     // Catch: Exception -> L42
        Logger.d("WsChannelSdk_ok", "Dispatch final url: " + r115);     // Catch: Exception -> L42
        return r115;
    L42:
        e = move-exception;
        throw e;
    L44:
        return "";
    }

    private static OkHttpClient.Builder enableTls12WithTwoParamsMethod(OkHttpClient.Builder r100, SSLContext r101) throws Exception {
        TrustManagerFactory r102 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r102.init(null);
        TrustManager[] r103 = r102.getTrustManagers();
        if (r103.length != 1) goto L9;
        TrustManager r104 = r103[0];
        if ((r104 instanceof X509TrustManager) == false) goto L9;
        r100.sslSocketFactory(new Tls12SocketFactory(r101.getSocketFactory()), (X509TrustManager) r104);
        return r100;
    L9:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r103));
    }

    public void connect(final Map<String, Object> r100, final List<String> r101) {
        if (r101.isEmpty() == false) goto L6;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L6:
        runOnHandlerThread(new AnonymousClass4(this, r100, r101));
    }

    public void onParameterChange(final Map<String, Object> r100, final List<String> r101) {
        if (r101.isEmpty() == false) goto L6;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L6:
        runOnHandlerThread(new AnonymousClass7(this, r100, r101));
    }

    private void tryReconnect(long r100, String r101, boolean r102) {
        this.mHandler.removeMessages(1);
        if (isNetworkConnected(this.mContext) == true) goto L7;
        notifyFailedAndReset(r101, 1, SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR, r102);
        Logger.d("WsChannelSdk_ok", "network not available，cancel retry");
        return;
    L7:
        if (this.isManualClose == false) goto L11;
        Logger.d("WsChannelSdk_ok", "close manually");
        return;
    L11:
        if (r100 != (-1)) goto L13;
    L16:
        Logger.d("WsChannelSdk_ok", "retry finished ---> interval: " + r100 + " , url :" + r101);
        Logger.d("WsChannelSdk_ok", "retry finished，waiting the next time to reconnect");
        Bundle r103 = new Bundle();
        r103.putString(e.f25671s, "tryReconnect");
        r103.putLong(VideoThumbInfo.KEY_INTERVAL, r100);
        notifyFailedAndReset(r101, 2, "retry failed", r102);
        r101 = this.mPolicy.getUrl();
    L17:
        Logger.d("WsChannelSdk_ok", "the next time to reconnect is " + Utils.getTimeFormat(System.currentTimeMillis() + r100));
        Message r104 = new Message();
        r104.what = 1;
        r104.obj = r101;
        this.mHandler.sendMessageDelayed(r104, r100);
        return;
    L13:
        if (StringUtils.isEmpty(r101) == true) goto L16;
        setStatus(5);
        goto L17
    }

    public static /* synthetic */ void access$2300(WsOkClient r100, long r101, String r102, boolean r103) {
        r100.tryReconnect(r101, r102, r103);
    }

    private void notifyFailedAndReset(String r100, int r101, String r102, boolean r103) {
        setStatus(2);
        resetPolicy();
        WsStatusListener r104 = this.mWsStatusListener;
        if (r104 == null) goto L7;
        if (r103 == false) goto L8;
        r104.onFailure(r100, r101, r102);
        return;
    L8:
        return;
    }
}
