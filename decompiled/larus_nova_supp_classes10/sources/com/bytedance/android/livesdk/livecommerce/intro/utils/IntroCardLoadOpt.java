package com.bytedance.android.livesdk.livecommerce.intro.utils;

import android.content.Context;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IntroCardLoadOpt {
    public static final boolean f = false;
    public static final int g = 0;
    public static final boolean h = false;
    public static final boolean i = false;
    public static final boolean j = false;
    public static final boolean k = false;
    public static final boolean l = false;
    public static final boolean m = false;
    public static boolean n;
    public static Boolean o;
    public volatile LiveIntroResponse a;
    public volatile boolean b;
    public volatile boolean c;
    public Function1<? super LiveIntroResponse, Unit> d;
    public ECContext e;

    public static final class a {
        public static void a(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_KMP_UI() == false) goto L5;
            int r0 = ph2.h.o;
            int r1 = nh2.a.a;
        L5:
            dm.a.a("IntroCardLoadOpt").i("asyncInflate intro card layout");
            ShoppingAsyncInflater.a r2 = ShoppingAsyncInflater.e;
            Context r4 = th.a.e(r3, true);
            r2.getClass();
            com.bytedance.android.ec.opt.asyncInflate.d r5 = ShoppingAsyncInflater.a.a(r4).a();
            r5.c(2131560748, 1, "ec_intro_card_layout");
            r5.c(2131560747, 1, "ec_intro_card_atmosphere_widget");
            r5.commit();
        }
    }

    public IntroCardLoadOpt() {
    }

    static {
        boolean r0 = false;
        if (((Number) EComABUtils.getLiveSettingValue("ecom_live_opt_card_load_2", 0)).intValue() != 1) goto L5;
        boolean r1 = true;
    L6:
        f = r1;
        int r2 = EComABUtils.cardLoadOptV2Request();
        g = r2;
        if (r2 <= 0) goto L9;
        boolean r3 = true;
    L10:
        h = r3;
        if (EComABUtils.cardLoadOptV2Bind() != 1) goto L13;
        boolean r4 = true;
    L14:
        i = r4;
        if (EComABUtils.cardLoadOptV2Show() != 1) goto L17;
        boolean r5 = true;
    L18:
        j = r5;
        if (EComABUtils.cardLoadOptV2CardDoFrame() != 1) goto L21;
        boolean r6 = true;
    L22:
        k = r6;
        if (EComABUtils.cardLoadOptV2PicPreLoad() != 1) goto L25;
        boolean r7 = true;
    L26:
        l = r7;
        if (EComABUtils.cardLoadOptV2PicDoFrame() != 1) goto L29;
        r0 = true;
    L29:
        m = r0;
        EComABUtils.cardLoadOptV2Coupon();
        return;
    L25:
        r7 = false;
        goto L26
    L21:
        r6 = false;
        goto L22
    L17:
        r5 = false;
        goto L18
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public final boolean a(String r8, final Function1<? super LiveIntroResponse, Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        boolean r2 = false;
        if (cg4.a.a(r8) == false) goto L32;
        f.o.getClass();
        if (f.j == false) goto L32;
        final f r10 = f.n.get(r8);
        if (r10 == null) goto L32;
        dm.a.a("IntroCardLoadOpt").a("consumeCachedIntro, isLoading=" + r10.a + " isCacheAvailable=" + r10.e);
        if (r10.a == false) goto L12;
        r10.g = new IntroCardLoadOpt$consumeCachedIntro$$inlined$let$lambda$1(r10, this, r9);
    L20:
        boolean r0 = true;
    L22:
        if (r0 == false) goto L32;
        ECContext r11 = this.e;
        if (r11 == null) goto L30;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r12 = r11.getEcLivePerformanceMonitor();
        if (r12 == null) goto L30;
        ECLivePerformanceMonitor r13 = (ECLivePerformanceMonitor) r12.getValue();
        if (r13 == null) goto L30;
        r13.C(r10.e);
    L30:
        OptCardUtil.b(null, "enterload consumeCachedIntro isLoading=" + r10.a + " isCacheAvailable=" + r10.e);
        return true;
    L12:
        if (r10.e == false) goto L21;
        r9.invoke(r10.d);
        ECContext r1 = this.e;
        if (r1 == null) goto L20;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r3 = r1.getEcLivePerformanceMonitor();
        if (r3 == null) goto L20;
        ECLivePerformanceMonitor r4 = (ECLivePerformanceMonitor) r3.getValue();
        if (r4 == null) goto L20;
        r4.f(r10.b, r10.c);
        goto L20
    L21:
        r0 = false;
    L32:
        OptCardUtil.b(null, "consumeCachedIntro isCacheAvailable=" + this.b);
        if (f == true) goto L36;
    L49:
        ECContext r14 = this.e;
        if (r14 == null) goto L56;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r15 = r14.getEcLivePerformanceMonitor();
        if (r15 == null) goto L56;
        ECLivePerformanceMonitor r16 = (ECLivePerformanceMonitor) r15.getValue();
        if (r16 == null) goto L56;
        r16.C(this.b);
    L56:
        return r2;
    L36:
        if (this.c == false) goto L39;
        this.d = r9;
    L48:
        r2 = true;
        goto L49
    L39:
        if (this.b == false) goto L49;
        ECContext r17 = this.e;
        if (r17 == null) goto L47;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r18 = r17.getEcLivePerformanceMonitor();
        if (r18 == null) goto L47;
        ECLivePerformanceMonitor r19 = (ECLivePerformanceMonitor) r18.getValue();
        if (r19 == null) goto L47;
        r19.C(true);
    L47:
        r9.invoke(this.a);
        goto L48
    }
}
