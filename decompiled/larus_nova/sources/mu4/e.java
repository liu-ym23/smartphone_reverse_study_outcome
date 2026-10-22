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

/* JADX INFO: loaded from: classes16.dex */
public final class e extends com.bytedance.ee.bear.route.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f515751b;

    public e() {
        super(new com.bytedance.ee.bear.route.d[0]);
        this.f515751b = "ShareBaseInterceptor";
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        return "/doc/detail/activity";
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        if (r101 == null) goto L35;
        String r103 = r101.f222564e;
        if (r103 == null) goto L35;
        if (StringsKt.contains$default(r103, "share/base", false, 2, null) == false) goto L35;
        String r104 = r101.f222560a;
        if (r104 != null) goto L11;
    L34:
        tt5.a.d(this.f515751b, "get no bitable config and return...");
        goto L35
    L11:
        if (Intrinsics.areEqual(r104, sbb.e.f541294e.getType()) == true) goto L34;
        if (g(r100, r101, r102) == true) goto L35;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L24
        k r106 = (k) org.koin.java.a.c(k.class, null, null, 6);     // Catch: Throwable -> L24
        if (r106.a() == false) goto L22;
        String r107 = r101.f222564e;     // Catch: Throwable -> L24
        if (r107 != null) goto L21;
        r107 = "";
    L21:
        r106.preload(r107);     // Catch: Throwable -> L24
    L22:
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L29;
        tt5.a.l(this.f515751b, "preload Bitable data failed", r109);
    L29:
        PostCard r110 = d(r101, r102);
        r110.i("url", r101.f222564e);
        if (((h) org.koin.java.a.c(h.class, null, null, 6)).getCurrentActivity() != null) goto L32;
        r110.m(268435456);
    L32:
        r110.e();
        return true;
    L24:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L35:
        return false;
    }
}
