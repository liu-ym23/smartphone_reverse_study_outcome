package com.bytedance.retrofit2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.cache.ICacheServer;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.ttnet.TTInternalInterceptor;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class CallServerInterceptor<T> implements TTInternalInterceptor, IMetricsCollect, IRequestInfo {
    private volatile boolean mCanceled;

    @Nullable
    private Throwable mCreationFailure;
    private volatile boolean mExecuted;
    private Request mOriginalRequest;

    @Nullable
    private volatile SsCall mRawCall;
    private final RequestFactory<T> mRequestFactory;
    private volatile long mThrottleNetSpeed;

    public void cancel() {
        this.mCanceled = true;
        if (this.mRawCall == null) goto L6;
        this.mRawCall.cancel();
        return;
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
    }

    public synchronized boolean isExecuted() {
        monitor-enter(this);
        boolean r100 = this.mExecuted;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void resetExecuted() {
        monitor-enter(this);
        this.mExecuted = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        if ((this.mRawCall instanceof IRequestInfo) == true) goto L5;
        return null;
    L5:
        return ((IRequestInfo) this.mRawCall).getRequestInfo();
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public Request request() {
        return this.mOriginalRequest;
    }

    public CallServerInterceptor(RequestFactory<T> r100) {
        this.mRequestFactory = r100;
    }

    private SsCall createRawCall(Request r100) throws IOException {
        return this.mRequestFactory.clientProvider.get().newSsCall(r100);
    }

    private Response executeCall(SsCall r100) throws IOException {
        return r100.execute();
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse intercept(Interceptor.Chain r100) throws Exception {
        Request r101 = r100.request();
        this.mOriginalRequest = r101;
        r101.getMetrics().callServerInterceptorStart();
        this.mOriginalRequest.getMetrics().setPriorityLevel(this.mOriginalRequest.getPriorityLevel());
        RetrofitMetrics r102 = this.mOriginalRequest.getMetrics();
        r102.requestPriorityLevel = this.mOriginalRequest.getRequestPriorityLevel();
        monitor-enter(this);
    L63:
        th = move-exception;
        throw th;
    L5:
        if (this.mExecuted == true) goto L62;
        this.mExecuted = true;     // Catch: Throwable -> L63
        monitor-exit(this);     // Catch: Throwable -> L63
        Throwable r103 = this.mCreationFailure;
        if (r103 != null) goto L11;
        ICacheServer r104 = this.mRequestFactory.cacheServer;
        if (r104 == null) goto L19;
        Response r105 = r104.getCacheResponse(this.mOriginalRequest);
    L20:
        if (r105 == null) goto L23;
        this.mOriginalRequest.getMetrics().recordInterceptorRequestEnd();
        this.mOriginalRequest.getMetrics().lowestInterceptorRequestEnd();
    L23:
        if (r105 == null) goto L69;
    L56:
        List<Header> r106 = r105.headers("content-encoding");
        if (r106 == null) goto L60;
        RetrofitMetrics r107 = this.mOriginalRequest.getMetrics();
        r107.responseCompressType = ((Header) ListProtector.get(r106, 0)).getValue();
    L60:
        return parseResponse(r105, this.mOriginalRequest.getMetrics());
    L69:
        this.mRawCall = createRawCall(this.mOriginalRequest);     // Catch: Throwable -> L44 RuntimeException -> L51 IOException -> L53
        if (this.mThrottleNetSpeed <= 0) goto L28;
        this.mRawCall.setThrottleNetSpeed(this.mThrottleNetSpeed);     // Catch: Throwable -> L44 RuntimeException -> L51 IOException -> L53
    L28:
        if (this.mCanceled == false) goto L30;
        this.mRawCall.cancel();
    L30:
        List<Header> r108 = this.mOriginalRequest.headers("content-encoding");
        if (r108 != null) goto L33;
    L66:
        this.mOriginalRequest.getMetrics().recordInterceptorRequestEnd();     // Catch: Throwable -> L41
        this.mOriginalRequest.getMetrics().lowestInterceptorRequestEnd();     // Catch: Throwable -> L41
        this.mOriginalRequest.getMetrics().executeSsCallStart();     // Catch: Throwable -> L41
        r105 = executeCall(this.mRawCall);     // Catch: Throwable -> L41
        this.mOriginalRequest.getMetrics().executeSsCallEnd();
        this.mOriginalRequest.getMetrics().lowestInterceptorResponseStart();
        this.mOriginalRequest.getMetrics().recordInterceptorResponseStart(this);
        this.mOriginalRequest.getMetrics().retrofit.misc.executeSsCallSuccess = true;
        ICacheServer r109 = this.mRequestFactory.cacheServer;
        if (r109 == null) goto L56;
        Response r110 = r109.putCacheResponse(this.mOriginalRequest, r105);
        if (r110 == null) goto L56;
        r105 = r110;
    L41:
        th = move-exception;
        this.mOriginalRequest.getMetrics().executeSsCallEnd();
        this.mOriginalRequest.getMetrics().lowestInterceptorResponseStart();
        this.mOriginalRequest.getMetrics().recordInterceptorResponseStart(this);
        throw th;
    L33:
        if (r108.size() <= 0) goto L66;
        RetrofitMetrics r111 = this.mOriginalRequest.getMetrics();
        r111.requestCompressType = ((Header) ListProtector.get(this.mOriginalRequest.headers("content-encoding"), 0)).getValue();
    L53:
        e = e;
    L54:
        this.mCreationFailure = e;
        throw e;
    L51:
        e = e;
    L44:
        th = move-exception;
        this.mCreationFailure = th;
        if ((th instanceof Exception) == false) goto L50;
        throw th;
    L50:
        throw new Exception(th);
    L19:
        r105 = null;
        goto L20
    L11:
        if ((r103 instanceof IOException) == false) goto L15;
        throw ((IOException) r103);
    L15:
        throw new Exception(this.mCreationFailure);
    L62:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L63
    }

    public boolean setThrottleNetSpeed(long r100) {
        this.mThrottleNetSpeed = r100;
        if (this.mRawCall != null) goto L5;
        return false;
    L5:
        return this.mRawCall.setThrottleNetSpeed(r100);
    }

    public SsResponse<T> parseResponse(Response r100, RetrofitMetrics r101) throws IOException {
        if (r100 == null) goto L35;
        TypedInput r102 = r100.getBody();
        int r103 = r100.getStatus();
        if (r103 < 200) goto L33;
        if (r103 >= 300) goto L33;
        if (r103 == 204) goto L31;
        if (r103 == 205) goto L31;
        if (r101 == null) goto L37;
        r101.toSsResponseStart();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (r101 == null) goto L29;
        r101.responseConvertSuccess = false;
    L29:
        throw th;
    L37:
        T r104 = this.mRequestFactory.toResponse(r102);     // Catch: Throwable -> L23
        if (r101 == null) goto L22;
        r101.toSsResponseEnd();     // Catch: Throwable -> L16
    L22:
        return SsResponse.success(r104, r100);
    L23:
        th = move-exception;
        if (r101 == null) goto L26;
        r101.toSsResponseEnd();     // Catch: Throwable -> L16
    L26:
        throw th;     // Catch: Throwable -> L16
    L31:
        return SsResponse.success(null, r100);
    L33:
        return SsResponse.error(r102, r100);
    L35:
        throw new IOException("SsResponse is null");
    }

    public void cancelNormalRequest(boolean r100, Throwable r101, boolean r102) {
        cancel();
        this.mCanceled = r100;
    }
}
