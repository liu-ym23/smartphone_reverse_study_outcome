package com.bytedance.retrofit2;

import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.IInterceptorProperty;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class SsHttpCall<T> implements Call<T>, IMetricsCollect, IRequestInfo {

    @Nullable
    private static ICustomInterceptorControl sCustomInterceptorControl;
    private static IHttpCallPriorityControl sPriorityControl;

    @Nullable
    private static IRequestFlagHandler sRequestFlagHandler;
    private static IHttpCallThrottleControl sThrottleControl;
    private final Object[] args;
    private final CallServerInterceptor callServerInterceptor;
    private Request delayRequest;
    private final RetrofitMetrics metrics;
    private Request originalRequest;

    @Nullable
    private Throwable requestException;
    private final RequestFactory<T> requestFactory;

    public class AsyncRequestRunnable implements SsRunnable {
        private final Callback<T> callback;
        private final ExpandCallback expandCallback;
        final /* synthetic */ SsHttpCall this$0;

        @Override // com.bytedance.retrofit2.SsRunnable
        public int getRequestDelayTime() {
            return 0;
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public RetrofitMetrics getRetrofitMetrics() {
            return this.this$0.getRetrofitMetrics();
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public boolean isStreaming() {
            return SsHttpCall.access$800(this.this$0).booleanValue();
        }

        @Override // java.lang.Runnable
        public void run() {
            SsHttpCall.access$000(this.this$0).requestRealStart();     // Catch: Throwable -> L15
            SsResponse r100 = this.this$0.getResponseWithInterceptorChain();     // Catch: Throwable -> L15
            if (SsHttpCall.access$200() == null) goto L6;
            SsHttpCall.access$200().notifyRequestCompleted(SsHttpCall.access$300(this.this$0));
        L6:
            SsHttpCall.access$000(this.this$0).bizReceiveResponseHeader();
            SsHttpCall.access$000(this.this$0).enqueueCallbackStart();
        L12:
            th = move-exception;
            SsHttpCall.access$000(this.this$0).enqueueCallbackEnd();
            throw th;
        L8:
            if (SsHttpCall.access$100(this.this$0) == null) goto L10;
            callFailure(SsHttpCall.access$100(this.this$0));     // Catch: Throwable -> L12
        L53:
        L11:
            SsHttpCall.access$000(this.this$0).enqueueCallbackEnd();
            SsHttpCall.access$000(this.this$0).markRetrofitLayerLogCollected();
            return;
        L10:
            callSuccess(r100);     // Catch: Throwable -> L12
        L15:
            th = move-exception;
            SsHttpCall.access$102(this.this$0, th);     // Catch: Throwable -> L31
            RetrofitLayerMetrics.Misc r101 = SsHttpCall.access$000(this.this$0).retrofit.misc;     // Catch: Throwable -> L31
            r101.requestException = new WeakReference(th);     // Catch: Throwable -> L31
            if (SsHttpCall.access$200() == null) goto L21;
            SsHttpCall.access$200().notifyRequestCompleted(SsHttpCall.access$300(this.this$0));
        L21:
            SsHttpCall.access$000(this.this$0).bizReceiveResponseHeader();
            SsHttpCall.access$000(this.this$0).enqueueCallbackStart();
        L28:
            th = move-exception;
            SsHttpCall.access$000(this.this$0).enqueueCallbackEnd();
            throw th;
        L23:
            if (SsHttpCall.access$100(this.this$0) == null) goto L25;
            callFailure(SsHttpCall.access$100(this.this$0));     // Catch: Throwable -> L28
        L50:
            goto L11
        L25:
            callSuccess(null);     // Catch: Throwable -> L28
        L31:
            th = move-exception;
            if (SsHttpCall.access$200() == null) goto L35;
            SsHttpCall.access$200().notifyRequestCompleted(SsHttpCall.access$300(this.this$0));
        L35:
            SsHttpCall.access$000(this.this$0).bizReceiveResponseHeader();
            SsHttpCall.access$000(this.this$0).enqueueCallbackStart();
        L42:
            th = move-exception;
            SsHttpCall.access$000(this.this$0).enqueueCallbackEnd();
            throw th;
        L37:
            if (SsHttpCall.access$100(this.this$0) == null) goto L39;
            callFailure(SsHttpCall.access$100(this.this$0));     // Catch: Throwable -> L42
        L40:
            SsHttpCall.access$000(this.this$0).enqueueCallbackEnd();
            SsHttpCall.access$000(this.this$0).markRetrofitLayerLogCollected();
            throw th;
        L39:
            callSuccess(null);     // Catch: Throwable -> L42
            goto L40
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public int priority() {
            if (SsHttpCall.access$400() == null) goto L9;
            int r100 = SsHttpCall.access$400().getPriorityInContext(SsHttpCall.access$500(this.this$0));
            if (r100 == (-999)) goto L9;
            SsHttpCall.access$000(this.this$0).setPriorityLevel(r100);
            return r100;
        L9:
            if (SsHttpCall.access$600() == null) goto L15;
            if (SsHttpCall.access$500(this.this$0) == null) goto L15;
            int r101 = SsHttpCall.access$600().getPriority(SsHttpCall.access$500(this.this$0).getPath(), SsHttpCall.access$700(this.this$0).priorityLevel);
            SsHttpCall.access$000(this.this$0).setPriorityLevel(r101);
            return r101;
        L15:
            if (SsHttpCall.access$500(this.this$0) == null) goto L19;
            return SsHttpCall.access$500(this.this$0).getPriorityLevel();
        L19:
            return SsHttpCall.access$700(this.this$0).priorityLevel;
        }

        private void callFailure(Throwable r100) {
            this.callback.onFailure(this.this$0, r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        private void callSuccess(SsResponse<T> r100) {
            this.callback.onResponse(this.this$0, r100);     // Catch: Throwable -> L6
            ExpandCallback r101 = this.expandCallback;     // Catch: Throwable -> L6
            if (r101 == null) goto L11;
            r101.onAsyncResponse(this.this$0, r100);     // Catch: Throwable -> L6
            return;
        L11:
            return;
        L6:
            th = move-exception;
            th.printStackTrace();
        }

        public AsyncRequestRunnable(SsHttpCall r100, Callback<T> r101) {
            this.this$0 = r100;
            this.callback = r101;
            if ((r101 instanceof ExpandCallback) == false) goto L5;
            ExpandCallback r102 = (ExpandCallback) r101;
        L6:
            this.expandCallback = r102;
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface ICustomInterceptorControl {
        List<Interceptor> getInterceptors(Request r100, List<Interceptor> r101);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface IHttpCallPriorityControl {
        int getPriority(String r100, int r101);
    }

    public interface IRequestFlagHandler {
        int getPriorityInContext(Request r100);

        Request handleFlag(Request r100);

        boolean shouldBypassInterceptor(Request r100);

        boolean shouldUseCustomInterceptor(Request r100);
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
    }

    @Override // com.bytedance.retrofit2.Call
    public synchronized boolean isExecuted() {
        monitor-enter(this);
        CallServerInterceptor r100 = this.callServerInterceptor;     // Catch: Throwable -> L11
        if (r100 == null) goto L8;
        if (r100.isExecuted() == false) goto L8;
        boolean r101 = true;
    L9:
        monitor-exit(this);
        return r101;
    L8:
        r101 = false;
    L11:
        th = move-exception;
        throw th;
    }

    private List<Interceptor> constructInterceptorList() {
        LinkedList r100 = new LinkedList();
        IRequestFlagHandler r101 = sRequestFlagHandler;
        if (r101 == null) goto L6;
        this.originalRequest = r101.handleFlag(this.originalRequest);
    L6:
        if (sCustomInterceptorControl == null) goto L15;
        IRequestFlagHandler r102 = sRequestFlagHandler;
        if (r102 == null) goto L15;
        if (r102.shouldUseCustomInterceptor(this.originalRequest) == false) goto L15;
        List<Interceptor> r103 = sCustomInterceptorControl.getInterceptors(this.originalRequest, this.requestFactory.interceptors);
        if (r103 == null) goto L20;
        r100.addAll(r103);
    L20:
        r100.add(this.callServerInterceptor);
        return r100;
    L15:
        if (shouldAddInterceptors(this.originalRequest) == false) goto L18;
        r100.addAll(this.requestFactory.interceptors);
        goto L20
    L18:
        if (this.originalRequest.isPureRequest() == false) goto L20;
        appendBypassPureModeInterceptors(r100, this.requestFactory.interceptors);
        goto L20
    }

    private Boolean isStreaming() {
        return Boolean.valueOf(this.requestFactory.isResponseStreaming);
    }

    @Override // com.bytedance.retrofit2.Call
    public void cancel() {
        CallServerInterceptor r100 = this.callServerInterceptor;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    @Override // com.bytedance.retrofit2.Call
    public SsHttpCall<T> clone() {
        return new SsHttpCall(this.requestFactory, this.args);
    }

    @Override // com.bytedance.retrofit2.Call
    public SsResponse<T> execute() throws Exception {
        this.metrics.ssHttpCallApiStart(false);
        ensureOriginalRequestCreated();
        IHttpCallThrottleControl r100 = sThrottleControl;     // Catch: Throwable -> L12
        if (r100 == null) goto L6;
        Request r101 = r100.setOriginalRequestProperties(this.originalRequest);     // Catch: Throwable -> L12
        this.originalRequest = r101;     // Catch: Throwable -> L12
        this.delayRequest = r101;     // Catch: Throwable -> L12
        sThrottleControl.maybeDropRequestOrBlockingDelay(r101);     // Catch: Throwable -> L12
    L6:
        this.metrics.requestRealStart();     // Catch: Throwable -> L12
        SsResponse<T> r102 = getResponseWithInterceptorChain();     // Catch: Throwable -> L12
        IHttpCallThrottleControl r103 = sThrottleControl;
        if (r103 == null) goto L10;
        r103.notifyRequestCompleted(this.delayRequest);
    L10:
        this.metrics.bizReceiveResponseHeader();
        this.metrics.ssHttpCallApiEnd();
        this.metrics.markRetrofitLayerLogCollected();
        return r102;
    L12:
        th = move-exception;
        this.requestException = th;     // Catch: Throwable -> L15
        RetrofitLayerMetrics.Misc r104 = this.metrics.retrofit.misc;     // Catch: Throwable -> L15
        r104.requestException = new WeakReference(th);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        IHttpCallThrottleControl r105 = sThrottleControl;
        if (r105 == null) goto L19;
        r105.notifyRequestCompleted(this.delayRequest);
    L19:
        this.metrics.bizReceiveResponseHeader();
        this.metrics.ssHttpCallApiEnd();
        this.metrics.markRetrofitLayerLogCollected();
        throw th;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        CallServerInterceptor r100 = this.callServerInterceptor;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getRequestInfo();
    }

    @Override // com.bytedance.retrofit2.Call
    public boolean isCanceled() {
        CallServerInterceptor r100 = this.callServerInterceptor;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isCanceled() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.retrofit2.Call
    public Request request() {
        CallServerInterceptor r100 = this.callServerInterceptor;
        if (r100 == null) goto L7;
        Request r101 = r100.request();
        if (r101 == null) goto L7;
        return r101;
    L7:
        ensureOriginalRequestCreated();
        return this.originalRequest;
    }

    private synchronized void ensureOriginalRequestCreated() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.originalRequest == null) goto L24;
        monitor-exit(this);
        return;
    L24:
        this.metrics.toRequestStart();     // Catch: IOException -> L17 Throwable -> L20
        this.originalRequest = this.requestFactory.toRequest(null, this.args);     // Catch: IOException -> L17 Throwable -> L20
        this.metrics.toRequestEnd();     // Catch: IOException -> L17 Throwable -> L20
        Request r100 = this.originalRequest;     // Catch: IOException -> L17 Throwable -> L20
        if (r100 == null) goto L16;
        r100.setMetrics(this.metrics);     // Catch: IOException -> L17 Throwable -> L20
        if (Logger.debug() == false) goto L13;
        Logger.d("ToRequestLog", "originalRequest build success, path: " + this.originalRequest.getPath());     // Catch: IOException -> L17 Throwable -> L20
    L13:
        monitor-exit(this);
        return;
    L16:
        throw new RuntimeException("Unable to create request.");     // Catch: IOException -> L17 Throwable -> L20
    L17:
        e = move-exception;
        throw new RuntimeException("Unable to create request.", e);     // Catch: Throwable -> L20
    }

    public SsResponse getResponseWithInterceptorChain() throws Exception {
        if (Logger.debug() == false) goto L5;
        Logger.d("SsHttpCall", "real send " + this.originalRequest.getPath());
    L5:
        List<Interceptor> r100 = constructInterceptorList();
        if (Logger.debug() == false) goto L8;
        this.originalRequest = addDebugMetricsInfoToRequest(this.originalRequest);
    L8:
        RealInterceptorChain r101 = new RealInterceptorChain(r100, 0, this.originalRequest, this);
        if (RealInterceptorChain.isProceedWithoutHookEnabled() == false) goto L11;
        SsResponse r102 = r101.proceedWithoutHook(this.originalRequest);
    L12:
        r102.setRetrofitMetrics(this.metrics);
        return r102;
    L11:
        r102 = r101.proceed(this.originalRequest);
        goto L12
    }

    public static /* synthetic */ IHttpCallThrottleControl access$200() {
        return sThrottleControl;
    }

    public static /* synthetic */ IRequestFlagHandler access$400() {
        return sRequestFlagHandler;
    }

    public static /* synthetic */ IHttpCallPriorityControl access$600() {
        return sPriorityControl;
    }

    public RetrofitMetrics getRetrofitMetrics() {
        return this.metrics;
    }

    @Override // com.bytedance.retrofit2.Call
    public /* bridge */ /* synthetic */ Call clone() {
        return clone();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8522clone() throws CloneNotSupportedException {
        return clone();
    }

    public static /* synthetic */ RetrofitMetrics access$000(SsHttpCall r100) {
        return r100.metrics;
    }

    public static /* synthetic */ Throwable access$100(SsHttpCall r100) {
        return r100.requestException;
    }

    public static /* synthetic */ Request access$300(SsHttpCall r100) {
        return r100.delayRequest;
    }

    public static /* synthetic */ Request access$500(SsHttpCall r100) {
        return r100.originalRequest;
    }

    public static /* synthetic */ RequestFactory access$700(SsHttpCall r100) {
        return r100.requestFactory;
    }

    public static /* synthetic */ Boolean access$800(SsHttpCall r100) {
        return r100.isStreaming();
    }

    private Request addDebugMetricsInfoToRequest(Request r100) {
        if (r100.getMetrics().stateDelayTime < 0) goto L6;
        Request.Builder r101 = r100.newBuilder();
        ArrayList r102 = new ArrayList();
        r102.addAll(r100.getHeaders());
        r102.add(new Header("state-delay", String.valueOf(r100.getMetrics().stateDelayTime)));
        r101.headers(r102);
        return r101.build();
    L6:
        return r100;
    }

    public static void setCustomInterceptorControl(ICustomInterceptorControl r100) {
        sCustomInterceptorControl = r100;
    }

    public static void setPriorityControl(IHttpCallPriorityControl r100) {
        sPriorityControl = r100;
    }

    public static void setRequestFlagHandler(IRequestFlagHandler r100) {
        sRequestFlagHandler = r100;
    }

    public static void setThrottleControl(IHttpCallThrottleControl r100) {
        sThrottleControl = r100;
    }

    private boolean shouldAddInterceptors(Request r100) {
        if (r100.isPureRequest() == false) goto L5;
        return false;
    L5:
        IRequestFlagHandler r101 = sRequestFlagHandler;
        if (r101 != null) goto L8;
    L9:
        return true;
    L8:
        if (r101.shouldBypassInterceptor(r100) == false) goto L9;
        return false;
    }

    @Override // com.bytedance.retrofit2.Call
    public void enqueue(Callback<T> r100) {
        if (r100 == null) goto L39;
        if (isExecuted() == true) goto L37;
        this.metrics.ssHttpCallApiStart(true);
        AsyncRequestRunnable r101 = new AsyncRequestRunnable(this, r100);
        ensureOriginalRequestCreated();     // Catch: Throwable -> L18
        IHttpCallThrottleControl r102 = sThrottleControl;     // Catch: Throwable -> L18
        if (r102 == null) goto L14;
        Request r103 = r102.setOriginalRequestProperties(this.originalRequest);     // Catch: Throwable -> L18
        this.originalRequest = r103;     // Catch: Throwable -> L18
        this.delayRequest = r103;     // Catch: Throwable -> L18
        if (sThrottleControl.maybeDropRequestOrAsyncDelay(r103, this.requestFactory.httpExecutor, r101) == false) goto L14;
        this.metrics.ssHttpCallApiEnd();
        if (this.requestException == null) goto L45;
        this.metrics.markNetworkKernelLogCollected();
        this.metrics.markRetrofitLayerLogCollected();
        return;
    L45:
        return;
    L14:
        this.requestFactory.httpExecutor.execute(r101);     // Catch: Throwable -> L18
        this.metrics.ssHttpCallApiEnd();
        if (this.requestException == null) goto L27;
    L17:
        this.metrics.markNetworkKernelLogCollected();
        this.metrics.markRetrofitLayerLogCollected();
        return;
    L27:
        return;
    L18:
        th = move-exception;
        this.requestException = th;     // Catch: Throwable -> L31
        th.printStackTrace();     // Catch: Throwable -> L31
        RetrofitLayerMetrics.Misc r104 = this.metrics.retrofit.misc;     // Catch: Throwable -> L31
        r104.requestException = new WeakReference(th);     // Catch: Throwable -> L31
        this.metrics.enqueueCallbackStart();     // Catch: Throwable -> L31
        r100.onFailure(this, th);     // Catch: Throwable -> L28
        this.metrics.enqueueCallbackEnd();     // Catch: Throwable -> L31
        IHttpCallThrottleControl r105 = sThrottleControl;     // Catch: Throwable -> L31
        if (r105 == null) goto L24;
        r105.notifyRequestCompleted(this.delayRequest);     // Catch: Throwable -> L31
    L24:
        this.metrics.ssHttpCallApiEnd();
        if (this.requestException != null) goto L17;
        return;
    L28:
        th = move-exception;
        this.metrics.enqueueCallbackEnd();     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        this.metrics.ssHttpCallApiEnd();
        if (this.requestException == null) goto L35;
        this.metrics.markNetworkKernelLogCollected();
        this.metrics.markRetrofitLayerLogCollected();
    L35:
        throw th;
    L37:
        throw new IllegalStateException("Already executed.");
    L39:
        throw new NullPointerException("callback == null");
    }

    public boolean setThrottleNetSpeed(long r100) {
        CallServerInterceptor r101 = this.callServerInterceptor;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.setThrottleNetSpeed(r100);
    }

    public T toResponseBody(TypedInput r100) throws IOException {
        return this.requestFactory.toResponse(r100);
    }

    public SsHttpCall(RequestFactory<T> r100, Object[] r101) {
        this.delayRequest = null;
        this.requestException = null;
        this.requestFactory = r100;
        this.args = r101;
        this.callServerInterceptor = new CallServerInterceptor(r100);
        RetrofitMetrics r102 = r100.getRetrofitMetrics().cloneMetrics();
        this.metrics = r102;
        r102.bizInvokeRetrofitRequestInterfaceEnd();
    }

    public static /* synthetic */ Throwable access$102(SsHttpCall r100, Throwable r101) {
        r100.requestException = r101;
        return r101;
    }

    private static void appendBypassPureModeInterceptors(List<Interceptor> r100, List<Interceptor> r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.isEmpty() == true) goto L22;
        Iterator<Interceptor> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L23;
        Interceptor r103 = r102.next();
        if ((r103 instanceof IInterceptorProperty) == false) goto L8;
        if (((IInterceptorProperty) r103).shouldRunInPureMode() == false) goto L8;
        r100.add(r103);
        goto L8
    L23:
        return;
    }

    public void cancelNormalRequest(boolean r100, Throwable r101, boolean r102) {
        CallServerInterceptor r103 = this.callServerInterceptor;
        if (r103 == null) goto L6;
        r103.cancelNormalRequest(r100, r101, r102);
        return;
    }
}
