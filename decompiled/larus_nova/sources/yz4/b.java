package yz4;

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

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final a a(PluginHost r100) {
        if (r100 == null) goto L17;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl((a) r100.getUserComponent().a(a.class));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        tt5.a.e("CcmDocAIProviders", "resolve provider from host userScope failed", r103, false);
    L11:
        if (Result.m9452exceptionOrNullimpl(r102) == null) goto L15;
        r102 = b(r100);
    L15:
        return (a) r102;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    L17:
        return b(null);
    }

    public static a b(PluginHost r100) {
        Application r101 = LarkContext.getApplication();
        Intrinsics.checkNotNull(r101);
        j r102 = (j) k.a(r101, j.class);
        v r103 = (v) k.a(r101, v.class);
        UserSession r104 = r102.b();
        if (r104 != null) goto L5;
        r104 = ContainerConstsKt.a();
    L5:
        StringBuilder r105 = new StringBuilder("fallback to foreground session, host=");
        if (r100 == null) goto L8;
        String r106 = r100.getClass().getSimpleName();
    L9:
        r105.append(r106);
        r105.append(", session=");
        r105.append(r104.f438137a);
        tt5.a.k("CcmDocAIProviders", r105.toString());
        return (a) k.b(r103.c(r104), a.class);
    L8:
        r106 = null;
        goto L9
    }
}
