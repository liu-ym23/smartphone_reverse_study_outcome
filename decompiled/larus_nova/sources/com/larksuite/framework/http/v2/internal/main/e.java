package com.larksuite.framework.http.v2.internal.main;

import com.ss.android.lark.log.Log;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements Interceptor {
    public e() {
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        Request r101 = r100.request();
        Response r102 = r100.proceed(r101);     // Catch: Throwable -> L6 IOException -> L8
        Intrinsics.checkNotNull(r101);
        a(r101, r102, null);
        return r102;
    L8:
        IOException e100 = e;
        throw e100;     // Catch: Throwable -> L10
    L10:
        Throwable th10 = th;
    L11:
        Intrinsics.checkNotNull(r101);
        a(r101, null, e100);
        throw th10;
    L6:
        th = move-exception;
        th10 = th;
        e100 = null;
        goto L11
    }

    public static void a(Request r100, Response r101, IOException r102) {
        StringBuilder r103 = new StringBuilder();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r104 = r100.header("X-BaseRequest-ID");
        if (r104 == null) goto L5;
        r103.append("[request_id:" + r104 + ']');
    L5:
        if (r101 == null) goto L7;
        r103.append("[status_code:" + r101.code() + ']');
    L7:
        r103.append(String.valueOf(r100));
        if (r102 == null) goto L11;
        r103.append(", Error{error='" + r102.getMessage() + "'}");
    L11:
        if (r102 == null) goto L13;
        Log.e("lark_http", r103.toString(), r102);
        return;
    L13:
        Log.i("lark_http", r103.toString());
    }
}
