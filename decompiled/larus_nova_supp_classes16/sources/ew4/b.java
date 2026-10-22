package ew4;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final z a(PluginHost r2) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        vo5.a r3 = r2.getUserComponent();     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        z r4 = (z) r3.a(z.class);     // Catch: Throwable -> L11
    L9:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == true) goto L17;
        r0 = r5;
    L17:
        z r6 = (z) r0;
        if (r6 == null) goto L20;
        return r6;
    L20:
        return t.a;
    L8:
        r4 = null;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
