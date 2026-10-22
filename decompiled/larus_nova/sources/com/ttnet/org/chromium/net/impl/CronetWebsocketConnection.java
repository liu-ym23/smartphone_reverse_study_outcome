package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
@JNINamespace("cronet")
public final class CronetWebsocketConnection extends TTWebsocketConnection {
    private static final String TAG = null;
    private int mAppId;
    private String mAppKey;
    private String mAppToken;
    private int mAppVersion;
    private final TTWebsocketConnection.Callback mCallback;
    private long mDeviceId;
    private final Executor mExecutor;
    private int mFpid;
    private Map<String, String> mHeaders;
    private long mInstallId;
    private Map<String, String> mParams;
    private final CronetUrlRequestContext mRequestContext;
    private String mSessionId;
    private boolean mSharedConnection;
    private AtomicInteger mState;
    private List<String> mUrlList;
    private boolean mUseFrontier;
    private long mWebsocketAdapter;
    private final Object mWebsocketAdapterLock;

    public interface Natives {
        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void addGetParam(long r100, CronetWebsocketConnection r101, String r102, String r103);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void addHeader(long r100, CronetWebsocketConnection r101, String r102, String r103);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void addUrl(long r100, CronetWebsocketConnection r101, String r102);

        long createWebsocketConnectionAdapter(CronetWebsocketConnection r100, long r101);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void destroy(long r100, CronetWebsocketConnection r101);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void sendBinary(long r100, CronetWebsocketConnection r101, ByteBuffer r102);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void sendText(long r100, CronetWebsocketConnection r101, String r102);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void startWithFrontier(long r100, CronetWebsocketConnection r101, int r102, String r103, long r104, int r105, long r106, String r110, int r111, String r112, boolean r113);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void startWithWSChannel(long r100, CronetWebsocketConnection r101, boolean r102);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void stop(long r100, CronetWebsocketConnection r101);
    }

    static {
        TAG = "CronetWebsocketConnection";
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void destroyConnection() {
        Object r100 = this.mWebsocketAdapterLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mWebsocketAdapter != 0) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        CronetWebsocketConnectionJni.get().destroy(this.mWebsocketAdapter, this);     // Catch: Throwable -> L11
        this.mWebsocketAdapter = 0;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public boolean isConnected() {
        if (this.mState.get() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void startConnection() {
        Object r110 = this.mWebsocketAdapterLock;
        monitor-enter(r110);
    L37:
        th = th;
        r110 = r110;
    L39:
        monitor-exit(r110);     // Catch: Throwable -> L41
        throw th;
    L5:
        if (this.mWebsocketAdapter != 0) goto L7;
        this.mWebsocketAdapter = CronetWebsocketConnectionJni.get().createWebsocketConnectionAdapter(this, this.mRequestContext.getUrlRequestContextAdapter());     // Catch: Throwable -> L37
    L7:
        Iterator<String> r100 = this.mUrlList.iterator();     // Catch: Throwable -> L37
    L9:
        if (r100.hasNext() == false) goto L11;
        String r101 = r100.next();     // Catch: Throwable -> L37
        CronetWebsocketConnectionJni.get().addUrl(this.mWebsocketAdapter, this, r101);     // Catch: Throwable -> L37
        goto L9
    L11:
        Map<String, String> r102 = this.mParams;     // Catch: Throwable -> L37
        if (r102 == null) goto L17;
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();     // Catch: Throwable -> L37
    L15:
        if (r103.hasNext() == false) goto L17;
        Map.Entry<String, String> r104 = r103.next();     // Catch: Throwable -> L37
        CronetWebsocketConnectionJni.get().addGetParam(this.mWebsocketAdapter, this, r104.getKey(), r104.getValue());     // Catch: Throwable -> L37
    L17:
        Map<String, String> r105 = this.mHeaders;     // Catch: Throwable -> L37
        if (r105 == null) goto L23;
        Iterator<Map.Entry<String, String>> r106 = r105.entrySet().iterator();     // Catch: Throwable -> L37
    L21:
        if (r106.hasNext() == false) goto L23;
        Map.Entry<String, String> r107 = r106.next();     // Catch: Throwable -> L37
        CronetWebsocketConnectionJni.get().addHeader(this.mWebsocketAdapter, this, r107.getKey(), r107.getValue());     // Catch: Throwable -> L37
    L23:
        if (this.mUseFrontier == true) goto L46;
        Natives r108 = CronetWebsocketConnectionJni.get();     // Catch: Throwable -> L35
        r108.startWithWSChannel(this.mWebsocketAdapter, this, this.mSharedConnection);     // Catch: Throwable -> L41
    L33:
        monitor-exit(r110);     // Catch: Throwable -> L41
        return;
    L46:
        CronetWebsocketConnectionJni.get().startWithFrontier(this.mWebsocketAdapter, this, this.mAppId, this.mAppKey, this.mDeviceId, this.mFpid, this.mInstallId, this.mSessionId, this.mAppVersion, this.mAppToken, this.mSharedConnection);     // Catch: Throwable -> L35
    L28:
        th = th;
        r110 = r110;
    L35:
        th = th;
    L41:
        th = th;
        goto L39
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void stopConnection() {
        Object r100 = this.mWebsocketAdapterLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mWebsocketAdapter != 0) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        CronetWebsocketConnectionJni.get().stop(this.mWebsocketAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ TTWebsocketConnection.Callback access$000(CronetWebsocketConnection r100) {
        return r100.mCallback;
    }

    private ByteBuffer clone(ByteBuffer r100) {
        ByteBuffer r101 = ByteBuffer.allocate(r100.capacity());
        r100.rewind();
        r101.put(r100);
        r101.flip();
        return r101;
    }

    private void onFeedbackLog(final String r100) {
        Log.v(TAG, "OnFeedbackLog", new Object[0]);
        postTaskToExecutor(new AnonymousClass4(this, r100));
    }

    private void postTaskToExecutor(Runnable r100) {
        this.mExecutor.execute(r100);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Exception posting task to executor", new Object[]{e});
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void asyncSendBinary(ByteBuffer r100) {
        Object r101 = this.mWebsocketAdapterLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mWebsocketAdapter != 0) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        CronetWebsocketConnectionJni.get().sendBinary(this.mWebsocketAdapter, this, r100);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void asyncSendText(String r100) {
        Object r101 = this.mWebsocketAdapterLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mWebsocketAdapter != 0) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        CronetWebsocketConnectionJni.get().sendText(this.mWebsocketAdapter, this, r100);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    private void onConnectionStateChanged(final int r100, final String r101) {
        Log.d(TAG, "onConnectionStateChanged: state = " + r100 + ", url = " + r101, new Object[0]);
        this.mState.set(r100);
        postTaskToExecutor(new AnonymousClass1(this, r100, r101));
    }

    private void onMessageReceived(ByteBuffer r100, final int r101) {
        Log.v(TAG, "onMessageReceived", new Object[0]);
        final ByteBuffer r102 = clone(r100);
        postTaskToExecutor(new AnonymousClass3(this, r102, r101));
    }

    private void onConnectionError(final int r100, final String r101, final String r102) {
        Log.d(TAG, "onConnectionError: " + r102, new Object[0]);
        this.mState.set(r100);
        postTaskToExecutor(new AnonymousClass2(this, r100, r101, r102));
    }

    private void onTrafficChanged(final String r110, final long r111, final long r112, final boolean r113) {
        Log.v(TAG, "OnTrafficChanged", new Object[0]);
        postTaskToExecutor(new AnonymousClass5(this, r110, r111, r112, r113));
    }

    public CronetWebsocketConnection(CronetUrlRequestContext r100, TTWebsocketConnection.Callback r101, Executor r102, List<String> r103, Map<String, String> r104, Map<String, String> r105, boolean r106) {
        this.mUseFrontier = true;
        this.mWebsocketAdapterLock = new Object();
        this.mState = new AtomicInteger(-1);
        this.mRequestContext = r100;
        this.mCallback = r101;
        this.mExecutor = r102;
        this.mUrlList = r103;
        this.mParams = r104;
        this.mHeaders = r105;
        this.mSharedConnection = r106;
        this.mUseFrontier = false;
    }

    public CronetWebsocketConnection(CronetUrlRequestContext r100, TTWebsocketConnection.Callback r101, Executor r102, List<String> r103, int r104, String r105, long r110, int r111, long r112, String r113, int r114, String r115, Map<String, String> r116, Map<String, String> r117, boolean r210) {
        this.mUseFrontier = true;
        this.mWebsocketAdapterLock = new Object();
        this.mState = new AtomicInteger(-1);
        this.mRequestContext = r100;
        this.mCallback = r101;
        this.mExecutor = r102;
        this.mUrlList = r103;
        this.mAppId = r104;
        this.mAppKey = r105;
        this.mDeviceId = r110;
        this.mFpid = r111;
        this.mInstallId = r112;
        this.mSessionId = r113;
        this.mAppVersion = r114;
        this.mAppToken = r115;
        this.mParams = r116;
        this.mHeaders = r117;
        this.mSharedConnection = r210;
    }
}
