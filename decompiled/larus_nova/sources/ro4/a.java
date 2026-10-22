package ro4;

import android.content.Context;
import com.bytedance.ee.bear.bitable.c;
import com.bytedance.ee.bear.bitable.preload.k;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.b;
import com.bytedance.ee.bear.route.d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends b {

    /* JADX INFO: renamed from: ro4.a$a, reason: collision with other inner class name */
    public static final class C7508a {
    }

    static {
    }

    public a() {
        super(new d[0]);
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        if (c.q() == false) goto L6;
        return "/doc/detail/activity";
    L6:
        return "/bitable/baseadd/activity";
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        if (r101 != null) goto L4;
        return false;
    L4:
        if (Intrinsics.areEqual(e.f541299j.getType(), r101.f222560a) == true) goto L6;
        return false;
    L6:
        if (g(r100, r101, r102) == true) goto L30;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L15
        k r104 = (k) org.koin.java.a.c(k.class, null, null, 6);     // Catch: Throwable -> L15
        if (r104.a() == false) goto L13;
        String r105 = r101.f222564e;     // Catch: Throwable -> L15
        if (r105 != null) goto L12;
        r105 = "";
    L12:
        r104.preload(r105);     // Catch: Throwable -> L15
    L13:
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L20;
        tt5.a.l("BaseAddInterceptor", "preload Bitable data failed", r107);
    L20:
        PostCard r108 = d(r101, r102);
        r108.i("url", r101.f222564e).o("bear_url", r101);
        if (r100 != null) goto L23;
        r108.m(268435456);
    L23:
        r108.e();
        return true;
    L15:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L30:
        return false;
    }
}
