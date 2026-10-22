package com.bytedance.android.shopping.mall.feed.help;

import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.shopping.mall.settings.MallRefreshGuideConfigKt;
import com.bytedance.keva.Keva;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r {
    public boolean a;
    public int b;
    public Long c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public final Keva h;
    public final String i;

    public static final class a {
    }

    static {
    }

    public r(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneID");
        this.i = r2;
        this.f = -1;
        Keva r3 = Keva.getRepo("ec_mall_refresh_guide_storage", 1);     // Catch: Exception -> L5
    L7:
        this.h = r3;
        return;
    L5:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e.getMessage());
        r3 = null;
        goto L7
    }

    public final void a(String r25) {
        if (this.g == false) goto L39;
        return;
    L39:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L36
        if (this.h != null) goto L8;
        return;
    L8:
        com.bytedance.android.shopping.mall.homepage.tools.q.b();     // Catch: Throwable -> L36
        int r5 = 0;
        String[] r6 = this.h.getStringArray("show_time_array", new String[0]);     // Catch: Throwable -> L36
        if (r6.length != 0) goto L12;
        boolean r7 = true;
    L14:
        if ((!r7) == true) goto L16;
    L22:
        long r11 = this.h.getLong("not_show_from", 0);     // Catch: Throwable -> L36
        if (r11 > 0) goto L25;
    L27:
        long r8 = this.h.getLong("first_show_time", 0);     // Catch: Throwable -> L36
        int r9 = this.h.getInt("show_num_one_day", 0);     // Catch: Throwable -> L36
        if (((-1) - r8) <= 86400000) goto L30;
        this.h.storeLong("first_show_time", -1);     // Catch: Throwable -> L36
    L34:
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.event.popupShowRefreshToast", System.currentTimeMillis(), this.i, false, MapsKt.mapOf(TuplesKt.to("reason", r25)), false, 32));     // Catch: Throwable -> L36
        this.g = true;     // Catch: Throwable -> L36
        this.h.storeInt("show_num_one_day", r5 + 1);     // Catch: Throwable -> L36
        this.h.storeStringArray("show_time_array", (String[]) ArraysKt.plus(r6, String.valueOf(-1)));     // Catch: Throwable -> L36
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L36
        return;
    L30:
        if (r9 < ((aa3.d) MallRefreshGuideConfigKt.a.getValue()).a()) goto L32;
        return;
    L32:
        r5 = r9;
        goto L34
    L25:
        if (((-1) - r11) > 1209600000) goto L27;
        return;
    L16:
        if (r6.length < ((aa3.d) MallRefreshGuideConfigKt.a.getValue()).b()) goto L22;
        String r10 = (String) ArraysKt.lastOrNull(r6);     // Catch: Throwable -> L36
        if (r10 == null) goto L22;
        Long r12 = StringsKt.toLongOrNull(r10);     // Catch: Throwable -> L36
        if (r12 == null) goto L22;
        this.h.storeLong("not_show_from", r12.longValue());     // Catch: Throwable -> L36
        this.h.storeStringArray("show_time_array", new String[0]);     // Catch: Throwable -> L36
        goto L22
    L12:
        r7 = false;
    L36:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
