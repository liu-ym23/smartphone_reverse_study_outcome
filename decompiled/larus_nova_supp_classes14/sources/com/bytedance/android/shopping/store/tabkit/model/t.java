package com.bytedance.android.shopping.store.tabkit.model;

import com.bytedance.android.shopping.store.tabkit.TabKitAbilityConfig;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(MutablePropertyReference0Impl r3, e r4) {
        if (r3.get() != null) goto L9;
        if (r4 == null) goto L7;
        e r0 = (e) GsonProtectorUtils.fromJson(new Gson(), com.bytedance.android.ec.hybrid.list.util.k.d(r4), e.class);
        if (r0 == null) goto L7;
    L8:
        r3.set(r0);
    L7:
        r0 = new e();
    L9:
        e r1 = (e) r3.get();
        Boolean r2 = null;
        if (r1 == null) goto L19;
        e r5 = (e) r3.get();
        if (r5 == null) goto L15;
        g r6 = r5.b();
        if (r6 == null) goto L15;
    L18:
        r1.e(r6);
    L15:
        if (r4 == null) goto L17;
        r6 = r4.b();
        goto L18
    L17:
        r6 = null;
    L19:
        e r7 = (e) r3.get();
        if (r7 == null) goto L29;
        e r8 = (e) r3.get();
        if (r8 == null) goto L25;
        List<f> r9 = r8.c();
        if (r9 == null) goto L25;
    L28:
        r7.f(r9);
    L25:
        if (r4 == null) goto L27;
        r9 = r4.c();
        goto L28
    L27:
        r9 = null;
    L29:
        e r10 = (e) r3.get();
        if (r10 == null) goto L41;
        e r11 = (e) r3.get();
        if (r11 == null) goto L37;
        Boolean r12 = r11.a();
        if (r12 == null) goto L37;
        r2 = r12;
    L39:
        r10.d(r2);
        return;
    L37:
        if (r4 == null) goto L39;
        r2 = r4.a();
        goto L39
    }

    public static void b(k r4, j r5) {
        Integer r1 = null;
        if (r4.k() != null) goto L8;
        if (r5 == null) goto L6;
        j r0 = (j) GsonProtectorUtils.fromJson(new Gson(), com.bytedance.android.ec.hybrid.list.util.k.d(r5), j.class);
    L7:
        r4.v(r0);
        goto L8
    L6:
        r0 = null;
    L8:
        j r2 = r4.k();
        if (r2 == null) goto L11;
        Integer r3 = r2.a();
    L12:
        if (r3 != null) goto L15;
        return;
    L15:
        if (r3.intValue() != 0) goto L22;
        j r6 = r4.k();
        if (r6 == null) goto L23;
        if (r5 == null) goto L20;
        r1 = r5.a();
    L20:
        r6.b(r1);
        return;
    L23:
        return;
    L22:
        return;
    L11:
        r3 = null;
        goto L12
    }

    public static void c(o r2, o r3) {
        Integer r0 = null;
        if (r2 == null) goto L10;
        String r1 = r2.e();
        if (r1 != null) goto L9;
        if (r3 == null) goto L8;
        r1 = r3.e();
        goto L9
    L8:
        r1 = null;
    L9:
        r2.j(r1);
    L10:
        if (r2 == null) goto L17;
        Integer r4 = r2.a();
        if (r4 != null) goto L16;
        if (r3 == null) goto L15;
        r4 = r3.a();
        goto L16
    L15:
        r4 = null;
    L16:
        r2.f(r4);
    L17:
        if (r2 == null) goto L24;
        Integer r5 = r2.b();
        if (r5 != null) goto L23;
        if (r3 == null) goto L22;
        r5 = r3.b();
        goto L23
    L22:
        r5 = null;
    L23:
        r2.g(r5);
    L24:
        if (r2 == null) goto L31;
        Integer r6 = r2.c();
        if (r6 != null) goto L30;
        if (r3 == null) goto L29;
        r6 = r3.c();
        goto L30
    L29:
        r6 = null;
    L30:
        r2.h(r6);
    L31:
        if (r2 == null) goto L39;
        Integer r7 = r2.d();
        if (r7 != null) goto L36;
        if (r3 == null) goto L37;
        r0 = r3.d();
    L37:
        r2.i(r0);
        return;
    L36:
        r0 = r7;
        goto L37
    }

    public static void d(MutablePropertyReference0Impl r4, p r5) {
        if (r4.get() != null) goto L9;
        if (r5 == null) goto L7;
        p r0 = (p) GsonProtectorUtils.fromJson(new Gson(), com.bytedance.android.ec.hybrid.list.util.k.d(r5), p.class);
        if (r0 == null) goto L7;
    L8:
        r4.set(r0);
    L7:
        r0 = new p();
    L9:
        p r6 = (p) r4.get();
        if (r6 == null) goto L82;
        o r1 = r6.i();
        Integer r2 = null;
        if (r1 != null) goto L18;
        if (r5 == null) goto L17;
        o r3 = r5.i();
        if (r3 == null) goto L17;
        r1 = (o) GsonProtectorUtils.fromJson(new Gson(), com.bytedance.android.ec.hybrid.list.util.k.d(r3), o.class);
    L17:
        r1 = null;
    L18:
        r6.r(r1);
        o r7 = r6.g();
        if (r7 != null) goto L25;
        if (r5 == null) goto L24;
        o r8 = r5.g();
        if (r8 == null) goto L24;
        r7 = (o) GsonProtectorUtils.fromJson(new Gson(), com.bytedance.android.ec.hybrid.list.util.k.d(r8), o.class);
    L24:
        r7 = null;
    L25:
        r6.p(r7);
        o r9 = r6.i();
        if (r5 == null) goto L28;
        o r10 = r5.i();
    L29:
        c(r9, r10);
        o r11 = r6.g();
        if (r5 == null) goto L32;
        o r12 = r5.g();
    L33:
        c(r11, r12);
        n r13 = r6.e();
        if (r13 != null) goto L40;
        if (r5 == null) goto L39;
        n r14 = r5.e();
        if (r14 == null) goto L39;
        r13 = (n) GsonProtectorUtils.fromJson(new Gson(), com.bytedance.android.ec.hybrid.list.util.k.d(r14), n.class);
    L39:
        r13 = null;
    L40:
        r6.n(r13);
        if (r6.a() == null) goto L47;
        Integer r15 = r6.a();
        if (r15 != null) goto L46;
    L51:
        Integer r16 = r6.d();
        if (r16 != null) goto L56;
        if (r5 == null) goto L55;
        r16 = r5.d();
        goto L56
    L55:
        r16 = null;
    L56:
        r6.m(r16);
        Integer r17 = r6.f();
        if (r17 != null) goto L61;
        if (r5 == null) goto L60;
        r17 = r5.f();
        goto L61
    L60:
        r17 = null;
    L61:
        r6.o(r17);
        Integer r18 = r6.h();
        if (r18 != null) goto L66;
        if (r5 == null) goto L65;
        r18 = r5.h();
        goto L66
    L65:
        r18 = null;
    L66:
        r6.q(r18);
        String r19 = r6.b();
        if (r19 != null) goto L71;
        if (r5 == null) goto L70;
        r19 = r5.b();
        goto L71
    L70:
        r19 = null;
    L71:
        r6.k(r19);
        if (r6.c() == null) goto L78;
        Integer r20 = r6.c();
        if (r20 != null) goto L77;
        return;
    L77:
        if (r20.intValue() == 0) goto L78;
        return;
    L78:
        if (r5 == null) goto L80;
        r2 = r5.c();
    L80:
        r6.l(r2);
        return;
    L46:
        if (r15.intValue() != 0) goto L51;
    L47:
        if (r5 == null) goto L49;
        Integer r21 = r5.a();
    L50:
        r6.j(r21);
        goto L51
    L49:
        r21 = null;
        goto L50
    L32:
        r12 = null;
        goto L33
    L28:
        r10 = null;
        goto L29
    }

    public static void e(p r2, q r3) {
        Integer r0 = null;
        if (r2 == null) goto L5;
        Integer r1 = r2.a();
    L6:
        if (r1 == null) goto L12;
        Integer r4 = r2.a();
        if (r4 != null) goto L11;
    L17:
        if (r2 == null) goto L19;
        Integer r5 = r2.c();
    L20:
        if (r5 == null) goto L26;
        Integer r6 = r2.c();
        if (r6 != null) goto L25;
    L31:
        if (r2 == null) goto L59;
        n r7 = r2.e();
        if (r7 != null) goto L37;
        if (r3 == null) goto L36;
        r7 = r3.f();
        goto L37
    L36:
        r7 = null;
    L37:
        r2.n(r7);
        String r8 = r2.b();
        if (r8 != null) goto L42;
        if (r3 == null) goto L41;
        r8 = r3.b();
        goto L42
    L41:
        r8 = null;
    L42:
        r2.k(r8);
        Integer r9 = r2.d();
        if (r9 != null) goto L47;
        if (r3 == null) goto L46;
        r9 = r3.e();
        goto L47
    L46:
        r9 = null;
    L47:
        r2.m(r9);
        Integer r10 = r2.f();
        if (r10 != null) goto L52;
        if (r3 == null) goto L51;
        r10 = r3.g();
        goto L52
    L51:
        r10 = null;
    L52:
        r2.o(r10);
        Integer r11 = r2.h();
        if (r11 != null) goto L56;
        if (r3 == null) goto L57;
        r0 = r3.h();
    L57:
        r2.q(r0);
        return;
    L56:
        r0 = r11;
        goto L57
    L59:
        return;
    L25:
        if (r6.intValue() != 0) goto L31;
    L26:
        if (r2 == null) goto L31;
        if (r3 == null) goto L29;
        Integer r12 = r3.c();
    L30:
        r2.l(r12);
        goto L31
    L29:
        r12 = null;
        goto L30
    L19:
        r5 = null;
        goto L20
    L11:
        if (r4.intValue() != 0) goto L17;
    L12:
        if (r2 == null) goto L17;
        if (r3 == null) goto L15;
        Integer r13 = r3.a();
    L16:
        r2.j(r13);
        goto L17
    L15:
        r13 = null;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public static void f(MutablePropertyReference0Impl r4, q r5) {
        p r1 = null;
        if (r4.get() != null) goto L8;
        if (r5 == null) goto L6;
        q r0 = (q) GsonProtectorUtils.fromJson(new Gson(), com.bytedance.android.ec.hybrid.list.util.k.d(r5), q.class);
    L7:
        r4.set(r0);
        goto L8
    L6:
        r0 = null;
    L8:
        final q r6 = (q) r4.get();
        if (r6 != null) goto L11;
        return;
    L11:
        if (r6.c() == null) goto L17;
        Integer r2 = r6.c();
        if (r2 != null) goto L16;
    L21:
        n r3 = r6.f();
        if (r3 != null) goto L28;
        if (r5 == null) goto L27;
        n r7 = r5.f();
        if (r7 == null) goto L27;
        r3 = (n) GsonProtectorUtils.fromJson(new Gson(), com.bytedance.android.ec.hybrid.list.util.k.d(r7), n.class);
    L27:
        r3 = null;
    L28:
        r6.o(r3);
        String r8 = r6.b();
        if (r8 != null) goto L33;
        if (r5 == null) goto L32;
        r8 = r5.b();
        goto L33
    L32:
        r8 = null;
    L33:
        r6.k(r8);
        Integer r9 = r6.e();
        if (r9 != null) goto L38;
        if (r5 == null) goto L37;
        r9 = r5.e();
        goto L38
    L37:
        r9 = null;
    L38:
        r6.n(r9);
        Integer r10 = r6.g();
        if (r10 != null) goto L43;
        if (r5 == null) goto L42;
        r10 = r5.g();
        goto L43
    L42:
        r10 = null;
    L43:
        r6.p(r10);
        Integer r11 = r6.h();
        if (r11 != null) goto L48;
        if (r5 == null) goto L47;
        r11 = r5.h();
        goto L48
    L47:
        r11 = null;
    L48:
        r6.q(r11);
        if (r6.a() == null) goto L55;
        Integer r12 = r6.a();
        if (r12 != null) goto L54;
    L59:
        MutablePropertyReference0Impl r13 = new TabKitModelHelper$completeTabBarStyleMultiStateConfig$1$1(r6);
        if (r5 == null) goto L62;
        p r14 = r5.d();
    L63:
        d(r13, r14);
        MutablePropertyReference0Impl r15 = new TabKitModelHelper$completeTabBarStyleMultiStateConfig$1$2(r6);
        if (r5 == null) goto L66;
        r1 = r5.i();
    L66:
        d(r15, r1);
        e(r6.d(), r6);
        e(r6.i(), r6);
        return;
    L62:
        r14 = null;
        goto L63
    L54:
        if (r12.intValue() != 0) goto L59;
    L55:
        if (r5 == null) goto L57;
        Integer r16 = r5.a();
    L58:
        r6.j(r16);
        goto L59
    L57:
        r16 = null;
        goto L58
    L16:
        if (r2.intValue() != 0) goto L21;
    L17:
        if (r5 == null) goto L19;
        Integer r17 = r5.c();
    L20:
        r6.l(r17);
        goto L21
    L19:
        r17 = null;
        goto L20
    }

    public static boolean i(String r3, TabKitAbilityConfig r4) {
        if (r4 != null) goto L5;
    L6:
        int r5 = hk3.b.a;
        cl.d.a.getClass();
        cl.d r6 = cl.d.a.b();
        if (r6 == null) goto L10;
        r6.n();
    L10:
        if (r3 == null) goto L22;
        String r7 = com.bytedance.android.shopping.store.utils.n.b(r3);
        if (r7 == null) goto L22;
        if ((!StringsKt.isBlank(r7)) == true) goto L17;
        r7 = null;
    L17:
        if (r7 == null) goto L22;
        if (hk3.b.g(hk3.b.h().a(), hk3.b.j().a(), r7) <= 0) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == true) goto L28;
        return false;
    L28:
        return true;
    L22:
        r8 = false;
        goto L23
    L5:
        if (r4.b("tabkit_anniex_force") != true) goto L6;
        return true;
    }

    public static void g(z r17, TabKitViewModel r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r17, "resp");
        q r3 = r17.l();
        Object r4 = null;
        if (r3 == null) goto L5;
        p r5 = r3.i();
    L6:
        if (r5 != null) goto L13;
        if (r3 == null) goto L13;
        p r6 = r3.d();
        if (r6 == null) goto L11;
        p r7 = (p) GsonProtectorUtils.fromJson(new Gson(), com.bytedance.android.ec.hybrid.list.util.k.d(r6), p.class);
    L12:
        r3.r(r7);
        goto L13
    L11:
        r7 = null;
    L13:
        q r8 = r17.d();
        if (r8 == null) goto L16;
        p r9 = r8.i();
    L17:
        if (r9 != null) goto L24;
        if (r8 == null) goto L24;
        p r10 = r8.d();
        if (r10 == null) goto L22;
        p r11 = (p) GsonProtectorUtils.fromJson(new Gson(), com.bytedance.android.ec.hybrid.list.util.k.d(r10), p.class);
    L23:
        r8.r(r11);
        goto L24
    L22:
        r11 = null;
    L24:
        if (r3 == null) goto L26;
        p r12 = r3.d();
    L27:
        e(r12, r3);
        if (r3 == null) goto L30;
        p r13 = r3.i();
    L31:
        e(r13, r3);
        if (r8 == null) goto L34;
        p r14 = r8.d();
    L35:
        e(r14, r8);
        if (r8 == null) goto L38;
        p r15 = r8.i();
    L39:
        e(r15, r8);
        List<k> r16 = r17.j();
        if (r16 == null) goto L57;
        Iterator<T> r20 = r16.iterator();
        int r21 = 0;
    L43:
        if (r20.hasNext() == false) goto L57;
        Object r22 = r20.next();
        int r110 = r21 + 1;
        if (r21 >= 0) goto L47;
        CollectionsKt.throwIndexOverflow();
    L47:
        final k r23 = (k) r22;
        a(new TabKitModelHelper$doPostProcess$1$1(r23), r17.f());
        Pair<Integer, Integer> r111 = new Pair(Integer.valueOf(r21), r4);
        r23.getClass();
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r23.b = r111;
        f(new TabKitModelHelper$doPostProcess$1$2(r23), r3);
        f(new TabKitModelHelper$doPostProcess$1$3(r23), r8);
        b(r23, r17.h());
        List<k> r112 = r23.m();
        if (r112 == null) goto L56;
        Iterator<T> r113 = r112.iterator();
        int r114 = 0;
    L51:
        if (r113.hasNext() == false) goto L56;
        Object r115 = r113.next();
        int r116 = r114 + 1;
        if (r114 >= 0) goto L55;
        CollectionsKt.throwIndexOverflow();
    L55:
        final k r117 = (k) r115;
        r117.a = r23;
        Pair<Integer, Integer> r24 = new Pair(Integer.valueOf(r21), Integer.valueOf(r114));
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r117.b = r24;
        a(new TabKitModelHelper$doPostProcess$1$4$1(r117), r23.i());
        f(new TabKitModelHelper$doPostProcess$1$4$2(r117), r23.p());
        b(r117, r23.k());
        h(r117, r18, r17.a(), r19);
        r114 = r116;
    L56:
        h(r23, r18, r17.a(), r19);
        r21 = r110;
        r4 = null;
    L57:
        if (r18 == null) goto L81;
        m r2 = r17.k();
        if (r2 == null) goto L65;
        m r25 = r17.k();
        if (r25 == null) goto L63;
        String r26 = r25.a();
    L64:
        String r27 = null;
        boolean r28 = false;
        r2.c(TabKitViewModel.buildBundleUrlWithRouterParams$default(r18, r26, false, 2, null));
    L66:
        m r29 = r17.c();
        if (r29 == null) goto L73;
        m r30 = r17.c();
        if (r30 == null) goto L71;
        String r31 = r30.a();
    L72:
        r29.c(TabKitViewModel.buildBundleUrlWithRouterParams$default(r18, r31, r28, 2, r27));
        goto L73
    L71:
        r31 = r27;
    L73:
        h r32 = r17.g();
        if (r32 == null) goto L81;
        List<i> r33 = r32.a();
        if (r33 == null) goto L81;
        Iterator<T> r34 = r33.iterator();
    L79:
        if (r34.hasNext() == false) goto L81;
        i r35 = (i) r34.next();
        r35.d(TabKitViewModel.buildBundleUrlWithRouterParams$default(r18, r35.a(), false, 2, null));
        goto L79
    L63:
        r26 = null;
        goto L64
    L65:
        r27 = null;
        r28 = false;
    L81:
        r17.a = true;
        return;
    L38:
        r15 = null;
        goto L39
    L34:
        r14 = null;
        goto L35
    L30:
        r13 = null;
        goto L31
    L26:
        r12 = null;
        goto L27
    L16:
        r9 = null;
        goto L17
    L5:
        r5 = null;
        goto L6
    }

    public static void h(k r1, TabKitViewModel r2, Integer r3, boolean r4) {
        if (r2 == null) goto L17;
        boolean r5 = Intrinsics.areEqual(r3, r1.n());
        s r0 = r1.f();
        if (r0 == null) goto L6;
        String r6 = r0.b();
    L7:
        String r7 = r2.buildBundleUrlWithRouterParams(r6, r5);
        s r8 = r1.f();
        if (r8 == null) goto L10;
        r8.f(r7);
    L10:
        boolean r9 = i(r7, r2.getAbilityConfig());
        v r10 = r2.getTabState(r1.n());
        if (r10 == null) goto L13;
        r10.f = r9;
    L13:
        if (r9 == false) goto L17;
        s r11 = r1.f();
        if (r11 == null) goto L17;
        r11.h(1);
        goto L17
    L6:
        r6 = null;
    L17:
        if (r4 == false) goto L26;
        r1.d = com.bytedance.android.ec.hybrid.list.util.k.d(r1);
        e r12 = r1.i();
        if (r12 == null) goto L28;
        List<f> r13 = r12.c();
        if (r13 == null) goto L29;
        Iterator<T> r14 = r13.iterator();
    L24:
        if (r14.hasNext() == false) goto L30;
        f r15 = (f) r14.next();
        r15.a = com.bytedance.android.ec.hybrid.list.util.k.d(r15);
        goto L24
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }
}
