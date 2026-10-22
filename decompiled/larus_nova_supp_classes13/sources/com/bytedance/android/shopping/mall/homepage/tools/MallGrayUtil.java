package com.bytedance.android.shopping.mall.homepage.tools;

import android.view.View;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.model.BackgroundWrapper;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.api.mall.model.HomepageExtra;
import com.bytedance.android.shopping.api.mall.model.PendantWrapper;
import com.bytedance.android.shopping.api.mall.model.SingleCardData;
import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallGrayUtil {
    public boolean a;
    public final Lazy b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;

    public static final class a {
    }

    public static final class b {
        public final View a;
        public final View b;
        public final View c;
        public final View d;
        public final View e;
        public final View f;

        public b() {
            this(null, null, null, null, null, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L18;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            View r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            View r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            View r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            View r10 = this.d;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            View r13 = this.e;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            View r16 = this.f;
            if (r16 == null) goto L26;
            r1 = r16.hashCode();
        L26:
            return r15 + r1;
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "GrayView(globalView=" + this.a + ", popupView=" + this.b + ", topBarView=" + this.c + ", pendPopupView=" + this.d + ", shortBg=" + this.e + ", longBg=" + this.f + ")";
        }

        public b(View r1, View r2, View r3, View r4, View r5, View r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    static {
    }

    public MallGrayUtil() {
        this.b = LazyKt.lazy(MallGrayUtil$refreshGray$2.INSTANCE);
    }

    public static boolean d(Boolean r1) {
        if (r1 != null) goto L4;
    L7:
        return true;
    L4:
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == true) goto L7;
        return false;
    }

    public final void e(b r2) {
        if (this.f == false) goto L12;
        View r0 = r2.f;
        if (r0 == null) goto L7;
        com.bytedance.android.ec.hybrid.list.a.a(r0);
    L7:
        View r3 = r2.e;
        if (r3 == null) goto L10;
        com.bytedance.android.ec.hybrid.list.a.a(r3);
    L10:
        this.f = false;
        return;
    }

    public final void f(b r2) {
        if (this.d == false) goto L8;
        View r3 = r2.d;
        if (r3 == null) goto L9;
        com.bytedance.android.ec.hybrid.list.a.a(r3);
        this.d = false;
        return;
    L9:
        return;
    }

    public final void g(b r2) {
        if (this.c == false) goto L8;
        View r3 = r2.b;
        if (r3 == null) goto L9;
        com.bytedance.android.ec.hybrid.list.a.a(r3);
        this.c = false;
        return;
    L9:
        return;
    }

    public final void h(b r2) {
        if (this.e == false) goto L8;
        View r3 = r2.c;
        if (r3 == null) goto L9;
        com.bytedance.android.ec.hybrid.list.a.a(r3);
        this.e = false;
        return;
    L9:
        return;
    }

    public final void a(HomePageDTO r6, b r7) {
        HomePageBffDTO r0 = r6.getBff();
        String r1 = null;
        if (r0 == null) goto L7;
        SingleCardData r2 = r0.getPopup();
        if (r2 == null) goto L7;
        String r3 = r2.getExtra();
    L8:
        boolean r4 = false;
        if (r3 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == true) goto L17;
    L19:
        HomePageBffDTO r8 = r6.getBff();
        if (r8 == null) goto L39;
        SingleCardData r9 = r8.getPopup();
        if (r9 == null) goto L39;
        String r10 = r9.getExtra();
        if (r10 == null) goto L39;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L36
        Gson r12 = com.bytedance.android.shopping.api.mall.common.tools.p.a;     // Catch: Throwable -> L36
        ECNAMallCardExtra r13 = (ECNAMallCardExtra) com.bytedance.android.shopping.api.mall.common.tools.p.a(r10, ECNAMallCardExtra.class);     // Catch: Throwable -> L36
        if (r13 != null) goto L28;
    L33:
        Unit r14 = null;
    L34:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L36
    L38:
        Result.box-impl(r15);
        goto L39
    L28:
        if (Intrinsics.areEqual(r13.getGrayEnable(), Boolean.TRUE) == false) goto L32;
        View r16 = r7.b;     // Catch: Throwable -> L36
        if (r16 == null) goto L33;
        com.bytedance.android.ec.hybrid.list.a.b(r16);     // Catch: Throwable -> L36
        this.c = true;     // Catch: Throwable -> L36
        r14 = Unit.INSTANCE;     // Catch: Throwable -> L36
        goto L34
    L32:
        g(r7);     // Catch: Throwable -> L36
        r14 = Unit.INSTANCE;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L39:
        HomePageBffDTO r18 = r6.getBff();
        if (r18 == null) goto L44;
        PendantWrapper r19 = r18.getPendantWrapper();
        if (r19 == null) goto L44;
        String r20 = r19.getExtra();
    L45:
        if (r20 != null) goto L47;
    L50:
        boolean r21 = true;
    L51:
        if (r21 == true) goto L53;
    L55:
        HomePageBffDTO r22 = r6.getBff();
        if (r22 == null) goto L69;
        PendantWrapper r23 = r22.getPendantWrapper();
        if (r23 == null) goto L69;
        String r24 = r23.getExtra();
        if (r24 == null) goto L69;
        Gson r25 = com.bytedance.android.shopping.api.mall.common.tools.p.a;
        ECNAMallCardExtra r26 = (ECNAMallCardExtra) com.bytedance.android.shopping.api.mall.common.tools.p.a(r24, ECNAMallCardExtra.class);
        if (r26 == null) goto L69;
        if (Intrinsics.areEqual(r26.getGrayEnable(), Boolean.TRUE) == false) goto L68;
        View r27 = r7.d;
        if (r27 == null) goto L69;
        com.bytedance.android.ec.hybrid.list.a.b(r27);
        this.d = true;
        goto L69
    L68:
        f(r7);
    L69:
        HomePageBffDTO r28 = r6.getBff();
        if (r28 == null) goto L74;
        BackgroundWrapper r29 = r28.getBackground();
        if (r29 == null) goto L74;
        String r30 = r29.getExtra();
    L75:
        if (r30 != null) goto L77;
    L80:
        boolean r31 = true;
    L81:
        if (r31 == true) goto L83;
    L85:
        HomePageBffDTO r32 = r6.getBff();
        if (r32 == null) goto L103;
        BackgroundWrapper r33 = r32.getBackground();
        if (r33 == null) goto L103;
        String r34 = r33.getExtra();
        if (r34 == null) goto L103;
        Gson r35 = com.bytedance.android.shopping.api.mall.common.tools.p.a;
        ECNAMallCardExtra r36 = (ECNAMallCardExtra) com.bytedance.android.shopping.api.mall.common.tools.p.a(r34, ECNAMallCardExtra.class);
        if (r36 == null) goto L103;
        if (Intrinsics.areEqual(r36.getGrayEnable(), Boolean.TRUE) == false) goto L102;
        View r37 = r7.f;
        if (r37 == null) goto L98;
        com.bytedance.android.ec.hybrid.list.a.b(r37);
    L98:
        View r38 = r7.e;
        if (r38 == null) goto L101;
        com.bytedance.android.ec.hybrid.list.a.b(r38);
    L101:
        this.f = true;
        goto L103
    L102:
        e(r7);
    L103:
        HomePageBffDTO r39 = r6.getBff();
        if (r39 == null) goto L108;
        SingleCardData r40 = r39.getTopBar();
        if (r40 == null) goto L108;
        r1 = r40.getExtra();
    L108:
        if (r1 != null) goto L110;
    L111:
        r4 = true;
    L112:
        if (r4 == true) goto L114;
    L116:
        HomePageBffDTO r41 = r6.getBff();
        if (r41 == null) goto L134;
        SingleCardData r42 = r41.getTopBar();
        if (r42 == null) goto L135;
        String r43 = r42.getExtra();
        if (r43 == null) goto L136;
        Gson r44 = com.bytedance.android.shopping.api.mall.common.tools.p.a;
        ECNAMallCardExtra r45 = (ECNAMallCardExtra) com.bytedance.android.shopping.api.mall.common.tools.p.a(r43, ECNAMallCardExtra.class);
        if (r45 != null) goto L125;
        return;
    L125:
        if (Intrinsics.areEqual(r45.getGrayEnable(), Boolean.TRUE) == false) goto L129;
        View r46 = r7.c;
        if (r46 == null) goto L138;
        com.bytedance.android.ec.hybrid.list.a.b(r46);
        this.e = true;
        return;
    L138:
        return;
    L129:
        h(r7);
        return;
    L136:
        return;
    L135:
        return;
    L134:
        return;
    L114:
        if (this.e == false) goto L116;
        h(r7);
        return;
    L110:
        if (r1.length() != 0) goto L112;
    L83:
        if (this.f == false) goto L85;
        e(r7);
        goto L103
    L77:
        if (r30.length() == 0) goto L80;
        r31 = false;
    L74:
        r30 = null;
        goto L75
    L53:
        if (this.d == false) goto L55;
        f(r7);
        goto L69
    L47:
        if (r20.length() == 0) goto L50;
        r21 = false;
    L44:
        r20 = null;
        goto L45
    L17:
        if (this.c == false) goto L19;
        g(r7);
        goto L39
    L11:
        if (r3.length() == 0) goto L14;
        r5 = false;
    L7:
        r3 = null;
        goto L8
    }

    public final boolean b(HomePageDTO r4, b r5) {
        HomePageBffDTO r0 = r4.getBff();
        Boolean r1 = null;
        if (r0 == null) goto L7;
        HomepageExtra r2 = r0.getExtra();
        if (r2 == null) goto L7;
        Boolean r3 = r2.getGrayEnable();
    L9:
        if (d(r3) == false) goto L15;
        if (this.a == false) goto L15;
        int r6 = com.bytedance.android.ec.hybrid.list.a.a;
        com.bytedance.android.ec.hybrid.list.a.a(r5.a);
        this.a = false;
        return false;
    L15:
        if (this.a == true) goto L25;
        HomePageBffDTO r7 = r4.getBff();
        if (r7 == null) goto L22;
        HomepageExtra r8 = r7.getExtra();
        if (r8 == null) goto L22;
        r1 = r8.getGrayEnable();
    L22:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L25;
        Lazy r9 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "mall gray, use global gray");
        int r10 = com.bytedance.android.ec.hybrid.list.a.a;
        com.bytedance.android.ec.hybrid.list.a.b(r5.a);
        this.a = true;
        return true;
    L25:
        return false;
    L7:
        r3 = null;
        goto L9
    }

    public final void c(HomePageDTO r4, boolean r5, b r6) {
        Intrinsics.checkNotNullParameter(r4, "homePage");
        Intrinsics.checkNotNullParameter(r6, "grayView");
        Lazy r0 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.k.a r1 = com.bytedance.android.ec.hybrid.log.mall.k.a.b;
        ECMallLogUtil.c(r1, "start mall gray, is refresh: " + r5);
        if (r5 == true) goto L10;
        if (b(r4, r6) == false) goto L7;
        return;
    L7:
        a(r4, r6);
        return;
    L10:
        if (d((Boolean) this.b.getValue()) == false) goto L20;
        boolean r7 = false;
        if (this.a == true) goto L14;
    L16:
        if (r7 == false) goto L18;
        return;
    L18:
        e(r6);
        g(r6);
        f(r6);
        h(r6);
        return;
    L14:
        if (d((Boolean) this.b.getValue()) == false) goto L16;
        ECMallLogUtil.c(r1, "mall gray recover, use global gray");
        int r8 = com.bytedance.android.ec.hybrid.list.a.a;
        com.bytedance.android.ec.hybrid.list.a.a(r6.a);
        this.a = false;
        r7 = true;
        goto L16
    L20:
        if (b(r4, r6) == false) goto L22;
        return;
    L22:
        a(r4, r6);
    }
}
