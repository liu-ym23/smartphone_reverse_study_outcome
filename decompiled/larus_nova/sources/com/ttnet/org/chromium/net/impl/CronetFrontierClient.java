package com.ttnet.org.chromium.net.impl;

import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("cronet")
public class CronetFrontierClient {
    private static final int STATE_BUILDING = 1;
    private static final int STATE_CLOSE = 4;
    private static final int STATE_ESTABLISHED = 2;
    private static final int STATE_FAILED = 3;
    private static final int STATE_NONE = 0;
    private static final String TAG = null;
    private int mAppId;
    private String mAppKey;
    private String mAppVersion;
    private IConnectionCallback mCallback;
    private String mDeviceId;
    private String mEnv;
    private int mFpid;
    private long mFrontierClientAdapter;
    private final Object mFrontierClientAdapterLock;
    private Map<String, String> mHeaders;
    private String mHost;
    private TransportMode mMode;
    private String mPath;
    private int mPingInterval;
    private int mPort;
    private boolean mProxy;
    private String mQuery;
    private Map<Integer, TTServiceInfo> mServiceInfoMap;
    private AtomicInteger mState;
    private int mTimeout;
    private List<Integer> mUniqueServiceIdList;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.CronetFrontierClient$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private int appId;
        private String appKey;
        private String appVersion;
        private IConnectionCallback callback;
        private String deviceId;
        private String env;
        private int fpid;
        private Map<String, String> headers;
        private String host;
        private TransportMode mode;
        private String path;
        private int pingInterval;
        private int port;
        private boolean proxy;
        private String query;
        private int timeout;
        private List<Integer> uniqueServiceIdList;

        public CronetFrontierClient build() {
            return new CronetFrontierClient(this, null);
        }

        public static /* synthetic */ int access$000(Builder r100) {
            return r100.appId;
        }

        public static /* synthetic */ int access$100(Builder r100) {
            return r100.fpid;
        }

        public static /* synthetic */ Map access$1000(Builder r100) {
            return r100.headers;
        }

        public static /* synthetic */ TransportMode access$1100(Builder r100) {
            return r100.mode;
        }

        public static /* synthetic */ IConnectionCallback access$1200(Builder r100) {
            return r100.callback;
        }

        public static /* synthetic */ List access$1300(Builder r100) {
            return r100.uniqueServiceIdList;
        }

        public static /* synthetic */ String access$1400(Builder r100) {
            return r100.query;
        }

        public static /* synthetic */ String access$1500(Builder r100) {
            return r100.path;
        }

        public static /* synthetic */ boolean access$1600(Builder r100) {
            return r100.proxy;
        }

        public static /* synthetic */ String access$200(Builder r100) {
            return r100.host;
        }

        public static /* synthetic */ int access$300(Builder r100) {
            return r100.port;
        }

        public static /* synthetic */ String access$400(Builder r100) {
            return r100.appVersion;
        }

        public static /* synthetic */ String access$500(Builder r100) {
            return r100.deviceId;
        }

        public static /* synthetic */ String access$600(Builder r100) {
            return r100.appKey;
        }

        public static /* synthetic */ String access$700(Builder r100) {
            return r100.env;
        }

        public static /* synthetic */ int access$800(Builder r100) {
            return r100.pingInterval;
        }

        public static /* synthetic */ int access$900(Builder r100) {
            return r100.timeout;
        }

        public Builder callback(IConnectionCallback r100) {
            this.callback = r100;
            return this;
        }

        public Builder env(String r100) {
            this.env = r100;
            return this;
        }

        public Builder headers(Map<String, String> r100) {
            this.headers = r100;
            return this;
        }

        public Builder path(String r100) {
            this.path = r100;
            return this;
        }

        public Builder pingInterval(int r100) {
            this.pingInterval = r100;
            return this;
        }

        public Builder proxy(boolean r100) {
            this.proxy = r100;
            return this;
        }

        public Builder query(String r100) {
            this.query = r100;
            return this;
        }

        public Builder timeout(int r100) {
            this.timeout = r100;
            return this;
        }

        public Builder transportMode(TransportMode r100) {
            this.mode = r100;
            return this;
        }

        public Builder uniqueServiceIdList(List<Integer> r100) {
            this.uniqueServiceIdList = r100;
            return this;
        }

        public Builder(int r100, int r101, String r102, int r103, String r104, String r105, String r106) {
            this.mode = TransportMode.UNKNOWN;
            if (r100 <= 0) goto L19;
            if (r101 <= 0) goto L19;
            if (r103 <= 0) goto L19;
            if (TextUtils.isEmpty(r102) == true) goto L17;
            if (TextUtils.isEmpty(r104) == true) goto L17;
            if (TextUtils.isEmpty(r105) == true) goto L17;
            if (TextUtils.isEmpty(r106) == true) goto L17;
            this.appId = r100;
            this.fpid = r101;
            this.port = r103;
            this.host = r102;
            this.appVersion = r104;
            this.deviceId = r105;
            this.appKey = r106;
            return;
        L17:
            throw new IllegalArgumentException("Host, appVersion, appKey and deviceId must not be empty.");
        L19:
            throw new IllegalArgumentException("Appid, fpid and port must be set greater than 0.");
        }

        public static Builder create(int r100, int r110, String r111, int r112, String r113, String r114, String r115) {
            return new Builder(r100, r110, r111, r112, r113, r114, r115);
        }
    }

    public interface IConnectionCallback {
        void onConnectionError(int r100, String r101, String r102);

        void onConnectionStateChanged(int r100, String r101);

        void onTrafficChanged(String r100, long r101, long r102, boolean r103);
    }

    public interface IServiceMessageReceiver {
        void onError(int r100, int r101, String r102);

        void onReceivedAck(int r100, long r101, String r102, Boolean r103);

        void onReceivedMessage(int r100, Map<String, String> r101, byte[] r102);

        void onServiceReady(int r100, String r101);
    }

    public interface Natives {
        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void addHeader(long r100, CronetFrontierClient r101, String r102, String r103);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void addServiceId(long r100, CronetFrontierClient r101, int r102);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void configParams(long r100, CronetFrontierClient r101, int r102, int r103, String r104, int r105, String r106, String r107, String r110, String r111, int r112, int r113, int r114, boolean r115, String r116, String r117);

        long createFrontierClientAdapter(CronetFrontierClient r100);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void destroy(long r100, CronetFrontierClient r101);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        boolean isServiceReady(long r100, CronetFrontierClient r101, int r102);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void registerService(long r100, CronetFrontierClient r101, String[] r102, ByteBuffer r103, int r104, int r105, boolean r106);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void reportAppStateChange(long r100, CronetFrontierClient r101, boolean r102);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void sendMessage(long r100, CronetFrontierClient r101, int r102, String[] r103, ByteBuffer r104);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void unregisterService(long r100, CronetFrontierClient r101, int r102);
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final enum TransportMode extends Enum<TransportMode> {
        private static final /* synthetic */ TransportMode[] $VALUES = null;
        public static final TransportMode HTTP2 = null;
        public static final TransportMode QUIC = null;
        public static final TransportMode SPDY = null;
        public static final TransportMode TLS = null;
        public static final TransportMode UNKNOWN = null;
        final int mode;

        static {
            TransportMode r100 = new TransportMode("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            TransportMode r101 = new TransportMode("QUIC", 1, 0);
            QUIC = r101;
            TransportMode r102 = new TransportMode("TLS", 2, 1);
            TLS = r102;
            TransportMode r103 = new TransportMode("HTTP2", 3, 2);
            HTTP2 = r103;
            TransportMode r104 = new TransportMode("SPDY", 4, 3);
            SPDY = r104;
            $VALUES = new TransportMode[]{r100, r101, r102, r103, r104};
        }

        public static TransportMode[] values() {
            return (TransportMode[]) $VALUES.clone();
        }

        public int getValue() {
            return this.mode;
        }

        public static TransportMode valueOf(String r100) {
            return (TransportMode) a.a(TransportMode.class, r100);
        }

        private TransportMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.mode = r102;
        }
    }

    public void setMaxPacketSize(int r100, int r101) {
    }

    public void setMsgCursor(int r100, int r101) {
    }

    static {
        TAG = "CronetFrontierClient";
    }

    private void createNativeFrontierClient() {
        Object r110 = this.mFrontierClientAdapterLock;
        monitor-enter(r110);
    L28:
        th = th;
    L26:
        monitor-exit(r110);     // Catch: Throwable -> L28
        throw th;
    L24:
        th = th;
        goto L26
    L5:
        if (this.mFrontierClientAdapter != 0) goto L7;
        this.mFrontierClientAdapter = CronetFrontierClientJni.get().createFrontierClientAdapter(this);     // Catch: Throwable -> L24
    L7:
        Map<String, String> r100 = this.mHeaders;     // Catch: Throwable -> L24
        if (r100 == null) goto L13;
        Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();     // Catch: Throwable -> L24
    L11:
        if (r101.hasNext() == false) goto L13;
        Map.Entry<String, String> r102 = r101.next();     // Catch: Throwable -> L24
        CronetFrontierClientJni.get().addHeader(this.mFrontierClientAdapter, this, r102.getKey(), r102.getValue());     // Catch: Throwable -> L24
    L13:
        List<Integer> r103 = this.mUniqueServiceIdList;     // Catch: Throwable -> L24
        if (r103 == null) goto L19;
        Iterator<Integer> r104 = r103.iterator();     // Catch: Throwable -> L24
    L17:
        if (r104.hasNext() == false) goto L19;
        Integer r105 = r104.next();     // Catch: Throwable -> L24
        CronetFrontierClientJni.get().addServiceId(this.mFrontierClientAdapter, this, r105.intValue());     // Catch: Throwable -> L24
    L19:
        CronetFrontierClientJni.get().configParams(this.mFrontierClientAdapter, this, this.mAppId, this.mFpid, this.mHost, this.mPort, this.mAppVersion, this.mDeviceId, this.mAppKey, this.mEnv, this.mPingInterval, this.mTimeout, this.mMode.getValue(), this.mProxy, this.mQuery, this.mPath);     // Catch: Throwable -> L28
        monitor-exit(r110);     // Catch: Throwable -> L28
    }

    public void destroy() {
        Object r100 = this.mFrontierClientAdapterLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        CronetFrontierClientJni.get().destroy(this.mFrontierClientAdapter, this);     // Catch: Throwable -> L11
        this.mFrontierClientAdapter = 0;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
    }

    public boolean isConnected() {
        if (this.mState.get() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private CronetFrontierClient(Builder r100) {
        this.mMode = TransportMode.UNKNOWN;
        this.mServiceInfoMap = new ConcurrentHashMap();
        this.mFrontierClientAdapterLock = new Object();
        this.mState = new AtomicInteger(0);
        this.mAppId = Builder.access$000(r100);
        this.mFpid = Builder.access$100(r100);
        this.mHost = Builder.access$200(r100);
        this.mPort = Builder.access$300(r100);
        this.mAppVersion = Builder.access$400(r100);
        this.mDeviceId = Builder.access$500(r100);
        this.mAppKey = Builder.access$600(r100);
        this.mEnv = Builder.access$700(r100);
        this.mPingInterval = Builder.access$800(r100);
        this.mTimeout = Builder.access$900(r100);
        this.mHeaders = Builder.access$1000(r100);
        this.mMode = Builder.access$1100(r100);
        this.mCallback = Builder.access$1200(r100);
        this.mUniqueServiceIdList = Builder.access$1300(r100);
        this.mQuery = Builder.access$1400(r100);
        this.mPath = Builder.access$1500(r100);
        this.mProxy = Builder.access$1600(r100);
        createNativeFrontierClient();
    }

    public TTServiceInfo getServiceInfoById(int r100) {
        return this.mServiceInfoMap.get(Integer.valueOf(r100));
    }

    public boolean isServiceExisted(int r100) {
        return this.mServiceInfoMap.containsKey(Integer.valueOf(r100));
    }

    public boolean isServiceReady(int r100) {
        Object r101 = this.mFrontierClientAdapterLock;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L15
        return false;
    L8:
        TTServiceInfo r102 = this.mServiceInfoMap.get(Integer.valueOf(r100));     // Catch: Throwable -> L15
        if (r102 != null) goto L12;
        monitor-exit(r101);     // Catch: Throwable -> L15
        return false;
    L12:
        boolean r103 = r102.connected;     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        return r103;
    }

    public void reportAppStateChange(boolean r100) {
        Object r101 = this.mFrontierClientAdapterLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        CronetFrontierClientJni.get().reportAppStateChange(this.mFrontierClientAdapter, this, r100);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    public void unregisterService(int r100) {
        Object r101 = this.mFrontierClientAdapterLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        this.mServiceInfoMap.remove(Integer.valueOf(r100));     // Catch: Throwable -> L11
        CronetFrontierClientJni.get().unregisterService(this.mFrontierClientAdapter, this, r100);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    public /* synthetic */ CronetFrontierClient(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    private void onConnectionStateChanged(int r100, String r101) {
        this.mState.set(r100);
        this.mCallback.onConnectionStateChanged(r100, r101);     // Catch: Exception -> L5
        return;
    }

    private void onServiceReady(int r100, String r101) {
        TTServiceInfo r102 = this.mServiceInfoMap.get(Integer.valueOf(r100));
        if (r102 != null) goto L5;
        return;
    L5:
        r102.connected = true;
        r102.listener.onServiceReady(r100, r101);
    }

    private void onConnectionError(int r100, String r101, String r102) {
        this.mState.set(r100);
        this.mCallback.onConnectionError(r100, r101, r102);     // Catch: Exception -> L5
        return;
    }

    private void onError(int r100, int r101, String r102) {
        TTServiceInfo r103 = this.mServiceInfoMap.get(Integer.valueOf(r100));
        if (r103 != null) goto L5;
        return;
    L5:
        r103.connected = false;
        r103.listener.onError(r100, r101, r102);
    }

    public void registerService(TTServiceInfo r110, ByteBuffer r111, String[] r112) {
        Object r100 = this.mFrontierClientAdapterLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        this.mServiceInfoMap.put(Integer.valueOf(r110.identity), r110);     // Catch: Throwable -> L11
        CronetFrontierClientJni.get().registerService(this.mFrontierClientAdapter, this, r112, r111, r110.identity, r110.priority.getValue(), r110.sequence);     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
    }

    public void sendMessage(int r100, String[] r110, ByteBuffer r111) {
        Object r101 = this.mFrontierClientAdapterLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        CronetFrontierClientJni.get().sendMessage(this.mFrontierClientAdapter, this, r100, r110, r111);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    private void onReceivedAck(int r100, long r101, String r110, boolean r111) {
        if (r111 == false) goto L4;
        return;
    L4:
        TTServiceInfo r102 = this.mServiceInfoMap.get(Integer.valueOf(r100));
        if (r102 != null) goto L7;
        return;
    L7:
        r102.listener.onReceivedAck(r100, r101, r110, Boolean.valueOf(r111));
    }

    private void onReceivedMessage(int r100, String[] r101, ByteBuffer r102, int r110) {
        TTServiceInfo r103 = this.mServiceInfoMap.get(Integer.valueOf(r100));
        if (r103 != null) goto L5;
        return;
    L5:
        int r104 = r101.length;
        if ((r104 % 2) != 0) goto L8;
        HashMap r105 = new HashMap();
        int r106 = 0;
    L10:
        if (r106 >= r104) goto L17;
        if (TextUtils.isEmpty(r101[r106]) == true) goto L16;
        int r107 = r106 + 1;
        if (TextUtils.isEmpty(r101[r107]) == true) goto L16;
        r105.put(r101[r106], r101[r107]);
    L16:
        r106 = r106 + 2;
        goto L10
    L17:
        byte[] r108 = new byte[r102.capacity()];
        r102.get(r108);
        if (r110 < 0) goto L20;
        r100 = r110;
    L20:
        r103.listener.onReceivedMessage(r100, r105, r108);
        return;
    }

    private void onTrafficChanged(String r100, long r101, long r110, boolean r111) {
        this.mCallback.onTrafficChanged(r100, r101, r110, r111);     // Catch: Exception -> L4
        return;
    }
}
