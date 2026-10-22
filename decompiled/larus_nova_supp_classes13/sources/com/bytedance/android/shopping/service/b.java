package com.bytedance.android.shopping.service;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.g;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ Ref.ObjectRef a;

    public b(Ref.ObjectRef r1) {
        this.a = r1;
    }

    public final void a() {
        Exception r1 = (Exception) this.a.element;     // Catch: Exception -> L12
        if (r1 == null) goto L6;
        String r2 = r1.getMessage();     // Catch: Exception -> L12
    L7:
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L12
        r3.put("EVENT_ORIGIN_FEATURE", "TEMAI");     // Catch: Exception -> L12
        r3.put("error_msg", r2);     // Catch: Exception -> L12
        g.a.logV3("slice_sdk_init_error", r3);     // Catch: Exception -> L12
        Object r4 = this.a.element;     // Catch: Exception -> L12
        if (((Exception) r4) != null) goto L10;
        ECExceptionMonitor.c("slice_sdk_exception:tryGetSliceInitServiceByReflect result is null");     // Catch: Exception -> L12
        return;
    L10:
        ECExceptionMonitor.f((Exception) r4, "slice_sdk_exception:tryGetSliceInitServiceByReflect result is null. e: " + r2);     // Catch: Exception -> L12
        return;
    L6:
        r2 = null;
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
