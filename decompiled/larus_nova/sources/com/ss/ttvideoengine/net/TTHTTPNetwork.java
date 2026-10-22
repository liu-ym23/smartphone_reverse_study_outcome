package com.ss.ttvideoengine.net;

import android.os.SystemClock;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class TTHTTPNetwork extends TTVNetClient {
    private static final int HTTP_MAX_RETRY_TIME_OUT = 10;
    private static final int HTTP_TIME_OUT = 10;
    public static final MediaType JSON = null;
    private static final int STATUS_CANCEL = 3;
    private static final int STATUS_FINISHED = 2;
    private static final int STATUS_RUNNING = 1;
    private static final int STATUS_UNKNOWN = 0;
    private static final String TAG = "TTHTTPNetwork";
    private static OkHttpClient mClient;
    private static boolean mClientParamsChanged;
    private static boolean mIsRetryWhenFail;
    private static int mMaxRetryTimeOut;
    private static boolean mTLSv1_2;
    private Call mCall;
    private long mStartTime;
    private int mStatus;

    static {
        JSON = MediaType.parse("application/json");
        mIsRetryWhenFail = true;
        mMaxRetryTimeOut = 10;
        mTLSv1_2 = false;
        mClientParamsChanged = false;
    }

    private void setupClient() {
        if (mClientParamsChanged == false) goto L6;
        mClient = null;
    L6:
        if (mClient != null) goto L16;
        OkHttpClient.Builder r100 = new OkHttpClient.Builder();
        TimeUnit r101 = TimeUnit.SECONDS;
        OkHttpClient.Builder r102 = r100.connectTimeout(10, r101).writeTimeout(10, r101).readTimeout(10, r101);
        if (mTLSv1_2 == true) goto L14;
    L12:
        mClient = r102.build();
        mClientParamsChanged = false;
        return;
    L14:
        SSLContext r103 = SSLContext.getInstance("TLS");     // Catch: Exception -> L11
        r103.init(null, null, null);     // Catch: Exception -> L11
        TrustManagerFactory r104 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());     // Catch: Exception -> L11
        r104.init(null);     // Catch: Exception -> L11
        X509TrustManager r105 = (X509TrustManager) r104.getTrustManagers()[0];     // Catch: Exception -> L11
        f r106 = new f(new f.a(f.f523840e));     // Catch: Exception -> L11
        ArrayList r107 = new ArrayList();     // Catch: Exception -> L11
        r107.add(r106);     // Catch: Exception -> L11
        r107.add(f.f523841f);     // Catch: Exception -> L11
        r107.add(f.f523842g);     // Catch: Exception -> L11
        r102.connectionSpecs(r107);     // Catch: Exception -> L11
        r102.sslSocketFactory(new TLSSocketFactory(r103.getSocketFactory()), r105);     // Catch: Exception -> L11
        TTVideoEngineLog.i(TAG, "tls1.2 enabled");     // Catch: Exception -> L11
    L11:
        TTVideoEngineLog.e(TAG, "enable tls1.2 error");
        goto L12
    }

    @Override // com.ss.ttvideoengine.net.TTVNetClient
    public void cancel() {
        Call r100 = this.mCall;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isCanceled() == true) goto L9;
        this.mCall.cancel();
        return;
    }

    public TTHTTPNetwork() {
        this.mStatus = 0;
        if (mClient == null) goto L7;
        if (mClientParamsChanged == true) goto L7;
        return;
    L7:
        monitor-enter(TTHTTPNetwork.class);
        setupClient();     // Catch: Throwable -> L11
        monitor-exit(TTHTTPNetwork.class);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ int access$000(TTHTTPNetwork r100) {
        return r100.mStatus;
    }

    public static void enableTLSv1_2(boolean r100) {
        if (mTLSv1_2 == r100) goto L6;
        mTLSv1_2 = r100;
        mClientParamsChanged = true;
        return;
    }

    public static void isRetryWhenFail(int r100) {
        TTVideoEngineLog.d(TAG, "isRetryWhenFail:" + r100);
        if (r100 < 0) goto L12;
        boolean r101 = true;
        if (r100 > 1) goto L13;
        if (r100 == 1) goto L10;
        r101 = false;
    L10:
        mIsRetryWhenFail = r101;
        return;
    L13:
        return;
    }

    public static void setMaxRetryTimeOut(int r100) {
        TTVideoEngineLog.d(TAG, "setMaxRetryTimeOut:" + r100);
        if (r100 >= 0) goto L5;
    L8:
        mMaxRetryTimeOut = 10;
        return;
    L5:
        if (r100 > 60) goto L8;
        mMaxRetryTimeOut = r100;
    }

    private void _startTask(Request r100, final TTVNetClient.CompletionListener r101) {
        monitor-enter(TTHTTPNetwork.class);
        int r102 = this.mStatus;     // Catch: Throwable -> L16
        if (r102 != 3) goto L7;
    L13:
        TTVideoEngineLog.i(TAG, "_startTask status error, return. " + this.mStatus);     // Catch: Throwable -> L16
        monitor-exit(TTHTTPNetwork.class);     // Catch: Throwable -> L16
        return;
    L7:
        if (r102 == 1) goto L13;
        this.mStatus = 1;     // Catch: Throwable -> L16
        monitor-exit(TTHTTPNetwork.class);     // Catch: Throwable -> L16
        Call r103 = mClient.newCall(r100);
        this.mCall = r103;
        r103.enqueue(new AnonymousClass2(this, r101));
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ int access$002(TTHTTPNetwork r100, int r101) {
        r100.mStatus = r101;
        return r101;
    }

    @Override // com.ss.ttvideoengine.net.TTVNetClient
    public void startTask(String r100, final TTVNetClient.CompletionListener r101) {
        monitor-enter(TTHTTPNetwork.class);
        setupClient();     // Catch: Throwable -> L8
        monitor-exit(TTHTTPNetwork.class);     // Catch: Throwable -> L8
        Request r102 = new Request.Builder().url(r100).build();
        Call r103 = mClient.newCall(r102);
        this.mCall = r103;
        r103.enqueue(new AnonymousClass1(this, r101));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void _receivedError(Call r100, IOException r110, TTVNetClient.CompletionListener r111) {
        if (mIsRetryWhenFail == true) goto L6;
        r111.onCompletion(null, new Error("", Error.HTTPNotOK, r110.toString()));
        return;
    L6:
        Request r101 = r100.request();
        if ((SystemClock.elapsedRealtime() - this.mStartTime) < ((mMaxRetryTimeOut * 1000) - 500)) goto L16;
        r111.onCompletion(null, new Error("", Error.HTTPNotOK, r110.toString()));
        return;
    L16:
        Thread.sleep(1000);     // Catch: InterruptedException -> L11
    L13:
        _startTask(r101, r111);
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    @Override // com.ss.ttvideoengine.net.TTVNetClient
    public void startTask(String r100, Map<String, String> r101, TTVNetClient.CompletionListener r102) {
        monitor-enter(TTHTTPNetwork.class);
        setupClient();     // Catch: Throwable -> L18
        monitor-exit(TTHTTPNetwork.class);     // Catch: Throwable -> L18
        Request.Builder r103 = new Request.Builder().url(r100);
        if (r101 == null) goto L16;
        Iterator<Map.Entry<String, String>> r104 = r101.entrySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L16;
        Map.Entry<String, String> r105 = r104.next();
        if (r105.getKey() == null) goto L10;
        if (r105.getValue() == null) goto L10;
        r103.header(r105.getKey(), r105.getValue());
    L16:
        _startTask(r103.build(), r102);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.ttvideoengine.net.TTVNetClient
    public void startTask(String r100, Map<String, String> r101, JSONObject r102, int r103, final TTVNetClient.RawCompletionListener r104) {
        monitor-enter(TTHTTPNetwork.class);
        setupClient();     // Catch: Throwable -> L23
        monitor-exit(TTHTTPNetwork.class);     // Catch: Throwable -> L23
        Request.Builder r105 = new Request.Builder().url(r100);
        if (r101 == null) goto L19;
        if (r101.size() <= 0) goto L19;
        Iterator<Map.Entry<String, String>> r106 = r101.entrySet().iterator();
    L12:
        if (r106.hasNext() == false) goto L19;
        Map.Entry<String, String> r107 = r106.next();
        if (r107.getKey() == null) goto L12;
        if (r107.getValue() == null) goto L12;
        r105.addHeader(r107.getKey(), r107.getValue());
    L19:
        if (r103 != 1) goto L21;
        r105.post(RequestBody.create(JSON, String.valueOf(r102)));
    L21:
        Call r108 = mClient.newCall(r105.build());
        this.mCall = r108;
        r108.enqueue(new AnonymousClass3(this, r104));
        return;
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.ttvideoengine.net.TTVNetClient
    public void startTask(String r100, Map<String, String> r101, JSONObject r102, int r103, TTVNetClient.CompletionListener r104) {
        monitor-enter(TTHTTPNetwork.class);
        setupClient();     // Catch: Throwable -> L23
        monitor-exit(TTHTTPNetwork.class);     // Catch: Throwable -> L23
        Request.Builder r105 = new Request.Builder().url(r100);
        if (r101 == null) goto L19;
        if (r101.size() <= 0) goto L19;
        Iterator<Map.Entry<String, String>> r106 = r101.entrySet().iterator();
    L12:
        if (r106.hasNext() == false) goto L19;
        Map.Entry<String, String> r107 = r106.next();
        if (r107.getKey() == null) goto L12;
        if (r107.getValue() == null) goto L12;
        r105.addHeader(r107.getKey(), r107.getValue());
    L19:
        if (r103 != 1) goto L21;
        r105.post(RequestBody.create(JSON, String.valueOf(r102)));
    L21:
        _startTask(r105.build(), r104);
        return;
    L23:
        th = move-exception;
        throw th;
    }
}
