package com.bytedance.apm.agent.instrumentation.interceptor;

import android.text.TextUtils;
import is3.d;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class AddHeaderInterceptor implements Interceptor {
    public static final String X_TT_TRACE_LOG = "x-tt-trace-log";

    public AddHeaderInterceptor() {
    }

    public Response intercept(Interceptor.Chain r6) throws IOException {
        Request r0 = r6.request();
        Request.Builder r1 = r0.newBuilder();
        if (TextUtils.isEmpty(r0.header(X_TT_TRACE_LOG)) == false) goto L17;
        d r2 = d.a.a;
        if (r2.q == false) goto L17;
        if (r2.j() == false) goto L12;
        if (r2.h == false) goto L12;
        r1.addHeader(X_TT_TRACE_LOG, "01");
    L12:
        if (r2.g != 1) goto L17;
        if (r2.h == false) goto L17;
        r1.addHeader(X_TT_TRACE_LOG, "02");
    L17:
        return r6.proceed(r1.build());
    }
}
