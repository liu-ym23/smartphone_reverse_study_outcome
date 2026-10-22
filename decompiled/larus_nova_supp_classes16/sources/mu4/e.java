package mu4;

import android.content.Context;
import com.bytedance.ee.bear.bitable.preload.k;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends com.bytedance.ee.bear.route.b {
    public final String b;

    public e() {
        super(new com.bytedance.ee.bear.route.d[0]);
        this.b = "ShareBaseInterceptor";
    }

    public final String e(BearUrl r1, RouteBean r2) {
        return "/doc/detail/activity";
    }

    public final boolean b(Context r6, BearUrl r7, RouteBean r8) {
        if (r7 == null) goto L35;
        String r1 = r7.e;
        if (r1 == null) goto L35;
        if (StringsKt.contains$default(r1, "share/base", false, 2, null) == false) goto L35;
        String r2 = r7.a;
        if (r2 != null) goto L11;
    L34:
        tt5.a.d(this.b, "get no bitable config and return...");
        goto L35
    L11:
        if (Intrinsics.areEqual(r2, sbb.e.e.getType()) == true) goto L34;
        if (g(r6, r7, r8) == true) goto L35;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L24
        k r3 = (k) org.koin.java.a.c(k.class, null, null, 6);     // Catch: Throwable -> L24
        if (r3.a() == false) goto L22;
        String r4 = r7.e;     // Catch: Throwable -> L24
        if (r4 != null) goto L21;
        r4 = "";
    L21:
        r3.preload(r4);     // Catch: Throwable -> L24
    L22:
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r9 = Result.exceptionOrNull-impl(r5);
        if (r9 == null) goto L29;
        tt5.a.l(this.b, "preload Bitable data failed", r9);
    L29:
        PostCard r10 = d(r7, r8);
        r10.i("url", r7.e);
        if (((h) org.koin.java.a.c(h.class, null, null, 6)).getCurrentActivity() != null) goto L32;
        r10.m(268435456);
    L32:
        r10.e();
        return true;
    L24:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L35:
        return false;
    }
}
