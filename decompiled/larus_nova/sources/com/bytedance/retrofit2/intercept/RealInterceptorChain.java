package com.bytedance.retrofit2.intercept;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallServerInterceptor;
import com.bytedance.retrofit2.RetrofitLogger;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RealInterceptorChain implements Interceptor.Chain {
    private static volatile boolean proceedWithoutHookEnabled;
    private static boolean sLogObjectRefineEnabled;
    private final Call call;
    private int calls;
    private final int index;
    private final List<Interceptor> interceptors;
    private final Request prevRequest;

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public RetrofitMetrics metrics() {
        return this.prevRequest.getMetrics();
    }

    public static boolean isProceedWithoutHookEnabled() {
        return proceedWithoutHookEnabled;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public Request request() {
        return this.prevRequest;
    }

    public static void setLogObjectRefineEnabled(boolean r100) {
        sLogObjectRefineEnabled = r100;
    }

    public static void setProceedWithoutHookEnabled(boolean r100) {
        proceedWithoutHookEnabled = r100;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public SsResponse proceed(Request r100) throws Exception {
        r100.setMetrics(this.prevRequest.getMetrics());
        if (r100.getMetrics() == null) goto L6;
        r100.getMetrics().recordInterceptorRequestEnd();
    L6:
        if (this.index >= this.interceptors.size()) goto L58;
        int r101 = this.calls + 1;
        this.calls = r101;
        if (r101 <= 1) goto L15;
        Iterator<Interceptor> r102 = this.interceptors.iterator();
    L11:
        if (r102.hasNext() == false) goto L15;
        Interceptor r103 = r102.next();
        if ((r103 instanceof CallServerInterceptor) == false) goto L11;
        ((CallServerInterceptor) r103).resetExecuted();
    L15:
        RealInterceptorChain r104 = new RealInterceptorChain(this.interceptors, this.index + 1, r100, this.call);
        Interceptor r105 = (Interceptor) ListProtector.get(this.interceptors, this.index);
        if (sLogObjectRefineEnabled == true) goto L23;
        StringBuilder r106 = new StringBuilder("interceptor = ");
        if (r105 == null) goto L20;
        String r107 = r105.toString();
    L21:
        r106.append(r107);
        r106.append(" url = ");
        r106.append(r100.getUrl());
        RetrofitLogger.d("RealInterceptorChain", r106.toString());
        goto L23
    L20:
        r107 = "";
    L23:
        if (r105 == null) goto L56;
        if (r100.getMetrics() == null) goto L60;
        r100.getMetrics().recordInterceptorRequestStart(r105);
        r100.getMetrics().beforeInterceptorExecute(r105);
    L60:
        SsResponse r108 = r105.intercept(r104);     // Catch: Throwable -> L43 Exception -> L45
        if (r108 == null) goto L42;
        if (r108.raw() == null) goto L40;
        if (r100.getMetrics() == null) goto L38;
        r100.getMetrics().recordInterceptorResponseEnd(null);
        if (this.index <= 0) goto L37;
        r100.getMetrics().recordInterceptorResponseStart((Interceptor) ListProtector.get(this.interceptors, this.index - 1));
    L37:
        request().getMetrics().afterInterceptorExecute(null);
    L38:
        return r108;
    L40:
        throw new IllegalStateException("interceptor " + r105 + " returned a ssResponse with no body");     // Catch: Throwable -> L43 Exception -> L45
    L42:
        throw new NullPointerException("interceptor " + r105 + " returned null");     // Catch: Throwable -> L43 Exception -> L45
    L45:
        e = move-exception;
        throw e;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        if (r100.getMetrics() == null) goto L54;
        r100.getMetrics().recordInterceptorResponseEnd(null);
        if (this.index <= 0) goto L53;
        r100.getMetrics().recordInterceptorResponseStart((Interceptor) ListProtector.get(this.interceptors, this.index - 1));
    L53:
        request().getMetrics().afterInterceptorExecute(null);
    L54:
        throw th;
    L56:
        throw new NullPointerException("interceptor " + this.index + " is null");
    L58:
        throw new AssertionError();
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public SsResponse proceedWithoutHook(Request r100) throws Exception {
        r100.setMetrics(this.prevRequest.getMetrics());
        if (r100.getMetrics() == null) goto L6;
        r100.getMetrics().recordInterceptorRequestEnd();
    L6:
        if (this.index >= this.interceptors.size()) goto L58;
        int r101 = this.calls + 1;
        this.calls = r101;
        if (r101 <= 1) goto L15;
        Iterator<Interceptor> r102 = this.interceptors.iterator();
    L11:
        if (r102.hasNext() == false) goto L15;
        Interceptor r103 = r102.next();
        if ((r103 instanceof CallServerInterceptor) == false) goto L11;
        ((CallServerInterceptor) r103).resetExecuted();
    L15:
        RealInterceptorChain r104 = new RealInterceptorChain(this.interceptors, this.index + 1, r100, this.call);
        Interceptor r105 = (Interceptor) ListProtector.get(this.interceptors, this.index);
        if (sLogObjectRefineEnabled == true) goto L23;
        StringBuilder r106 = new StringBuilder("interceptor = ");
        if (r105 == null) goto L20;
        String r107 = r105.toString();
    L21:
        r106.append(r107);
        r106.append(" url = ");
        r106.append(r100.getUrl());
        RetrofitLogger.d("RealInterceptorChain", r106.toString());
        goto L23
    L20:
        r107 = "";
    L23:
        if (r105 == null) goto L56;
        if (r100.getMetrics() == null) goto L60;
        r100.getMetrics().recordInterceptorRequestStart(r105);
        r100.getMetrics().beforeInterceptorExecute(r105);
    L60:
        SsResponse r108 = r105.intercept(r104);     // Catch: Throwable -> L43 Exception -> L45
        if (r108 == null) goto L42;
        if (r108.raw() == null) goto L40;
        if (r100.getMetrics() == null) goto L38;
        r100.getMetrics().recordInterceptorResponseEnd(null);
        if (this.index <= 0) goto L37;
        r100.getMetrics().recordInterceptorResponseStart((Interceptor) ListProtector.get(this.interceptors, this.index - 1));
    L37:
        request().getMetrics().afterInterceptorExecute(null);
    L38:
        return r108;
    L40:
        throw new IllegalStateException("interceptor " + r105 + " returned a ssResponse with no body");     // Catch: Throwable -> L43 Exception -> L45
    L42:
        throw new NullPointerException("interceptor " + r105 + " returned null");     // Catch: Throwable -> L43 Exception -> L45
    L45:
        e = move-exception;
        throw e;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        if (r100.getMetrics() == null) goto L54;
        r100.getMetrics().recordInterceptorResponseEnd(null);
        if (this.index <= 0) goto L53;
        r100.getMetrics().recordInterceptorResponseStart((Interceptor) ListProtector.get(this.interceptors, this.index - 1));
    L53:
        request().getMetrics().afterInterceptorExecute(null);
    L54:
        throw th;
    L56:
        throw new NullPointerException("interceptor " + this.index + " is null");
    L58:
        throw new AssertionError();
    }

    public RealInterceptorChain(List<Interceptor> r100, int r101, Request r102, Call r103) {
        this.interceptors = r100;
        this.index = r101;
        this.prevRequest = r102;
        this.call = r103;
    }
}
