package t75;

import android.app.Application;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final a a(PluginHost r5) {
        if (r5 == null) goto L17;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl((a) r5.getUserComponent().a(a.class));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L11;
        tt5.a.e("CcmDriveAIProviders", "resolve provider from host userScope failed", r2, false);
    L11:
        if (Result.exceptionOrNull-impl(r1) == null) goto L15;
        r1 = b(r5);
    L15:
        return (a) r1;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    L17:
        return b(null);
    }

    public static a b(PluginHost r4) {
        Application r0 = LarkContext.getApplication();
        Intrinsics.checkNotNull(r0);
        j r1 = (j) k.a(r0, j.class);
        v r2 = (v) k.a(r0, v.class);
        UserSession r3 = r1.b();
        if (r3 != null) goto L5;
        r3 = ContainerConstsKt.a();
    L5:
        StringBuilder r5 = new StringBuilder("fallback to foreground session, host=");
        if (r4 == null) goto L8;
        String r6 = r4.getClass().getSimpleName();
    L9:
        r5.append(r6);
        r5.append(", session=");
        r5.append(r3.a);
        tt5.a.k("CcmDriveAIProviders", r5.toString());
        return (a) k.b(r2.c(r3), a.class);
    L8:
        r6 = null;
        goto L9
    }
}
