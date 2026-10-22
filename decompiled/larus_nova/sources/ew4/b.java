package ew4;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final z a(PluginHost r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        if (r100 == null) goto L8;
        vo5.a r103 = r100.getUserComponent();     // Catch: Throwable -> L11
        if (r103 == null) goto L8;
        z r104 = (z) r103.a(z.class);     // Catch: Throwable -> L11
    L9:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r105) == true) goto L17;
        r101 = r105;
    L17:
        z r106 = (z) r101;
        if (r106 == null) goto L20;
        return r106;
    L20:
        return t.f474598a;
    L8:
        r104 = null;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
