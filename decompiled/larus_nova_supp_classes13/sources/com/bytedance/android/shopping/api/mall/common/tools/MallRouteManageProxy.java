package com.bytedance.android.shopping.api.mall.common.tools;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallRouteManageProxy implements yj.p {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    public MallRouteManageProxy() {
        this.a = LazyKt.lazy(MallRouteManageProxy$routerService$2.INSTANCE);
    }

    public static boolean e(String r3) {
        if (MallServiceUtil.a() != null) goto L5;
        return true;
    L5:
        if (r3 != null) goto L27;
    L21:
        yj.u r4 = MallServiceUtil.a();
        if (r4 != null) goto L24;
        return false;
    L24:
        return r4.a();
    L27:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L18
        String r5 = UriProtector.parse(r3).getHost();     // Catch: Throwable -> L18
        List r1 = null;
        if (r5 == null) goto L16;
        yj.u r2 = MallServiceUtil.a();     // Catch: Throwable -> L18
        if (r2 == null) goto L11;
        r1 = r2.c();     // Catch: Throwable -> L18
    L11:
        if (r1 != null) goto L13;
    L15:
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L18
        goto L16
    L13:
        if (r1.contains(r5) == false) goto L15;
        return true;
    L16:
        Object r6 = Result.constructor-impl(r1);     // Catch: Throwable -> L18
    L20:
        Result.box-impl(r6);
    L18:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public final boolean c(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        if (e(r2.toString()) == true) goto L5;
        return false;
    L5:
        return ((yj.p) this.a.getValue()).c(r2);
    }

    public final void a(final Context r2, final String r3, final Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        f(r3, r2, new MallRouteManageProxy$openSchemaWithAnimation$1(this, r2, r3, r4), MallRouteManageProxy$openSchemaWithAnimation$2.INSTANCE);
    }

    public final boolean b(Context r2, Uri r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if (e(String.valueOf(r3)) == true) goto L5;
        return false;
    L5:
        return ((yj.p) this.a.getValue()).b(r2, r3, r4);
    }

    public final void d(final Context r2, final String r3, final Map<String, Object> r4) {
        f(r3, r2, new MallRouteManageProxy$openSchema$1(this, r2, r3, r4), MallRouteManageProxy$openSchema$2.INSTANCE);
    }

    public static void f(String r2, final Context r3, final Function0 r4, final Function0 r5) {
        if (e(r2) == false) goto L6;
        r4.invoke();
        return;
    L6:
        final yj.u r6 = MallServiceUtil.a();
        if (r6 == null) goto L12;
        h.b.getIHybridHostAppInfo().isDebug();
        if (r3 == null) goto L13;
        r6.b(r3, new MallRouteManageProxy$pluginCheckAndInstall$$inlined$let$lambda$1(r6, r3, r4, r5), new MallRouteManageProxy$pluginCheckAndInstall$$inlined$let$lambda$2(r6, r3, r4, r5));
        return;
    L13:
        return;
    }
}
