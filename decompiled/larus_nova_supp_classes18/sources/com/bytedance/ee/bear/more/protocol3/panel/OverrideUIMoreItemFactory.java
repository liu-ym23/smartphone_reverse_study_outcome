package com.bytedance.ee.bear.more.protocol3.panel;

import android.view.View;
import com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ILoadingSwitchMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OverrideUIMoreItemFactory implements com.bytedance.ee.bear.more.protocol3.l {
    public static final c f = null;
    public static final b g = null;
    public static final a h = null;
    public static final d i = null;
    public final com.bytedance.ee.bear.more.protocol3.l a;
    public final t b;
    public final Function0<x> c;
    public ItemUIStyle d;
    public final Map<String, k> e;

    public static final class a implements com.bytedance.ee.bear.more.protocol3.a {
        public a() {
        }

        @Override // com.bytedance.ee.bear.more.protocol3.a
        public final View.OnClickListener a() {
            return null;
        }

        @Override // com.bytedance.ee.bear.more.protocol3.a
        public final String b() {
            return "";
        }

        @Override // com.bytedance.ee.bear.more.protocol3.a
        public final boolean isEnable() {
            return false;
        }
    }

    public static final class b implements com.bytedance.ee.bear.more.protocol3.a {
        public b() {
        }

        @Override // com.bytedance.ee.bear.more.protocol3.a
        public final View.OnClickListener a() {
            return null;
        }

        @Override // com.bytedance.ee.bear.more.protocol3.a
        public final String b() {
            return "";
        }

        @Override // com.bytedance.ee.bear.more.protocol3.a
        public final boolean isEnable() {
            return true;
        }
    }

    public static final class c implements com.bytedance.ee.bear.more.protocol3.m {
        public c() {
        }

        @Override // com.bytedance.ee.bear.more.protocol3.m
        public final boolean isVisible() {
            return true;
        }
    }

    public static final class d implements ISwitchMoreItem.a {
        public d() {
        }

        @Override // com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem.a
        public final void notifyItemChanged() {
        }
    }

    public static final class e {
    }

    static {
        f = new c();
        g = new b();
        h = new a();
        i = new d();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.l
    public final com.bytedance.ee.bear.more.protocol3.g buildHeader() {
        return this.a.buildHeader();
    }

    public OverrideUIMoreItemFactory(com.bytedance.ee.bear.more.protocol3.panel.e r3, Function0 r4) {
        com.bytedance.ee.bear.more.view3.d r0 = com.bytedance.ee.bear.more.view3.d.a;
        Intrinsics.checkNotNullParameter(r0, "real");
        Intrinsics.checkNotNullParameter(r3, "registry");
        Intrinsics.checkNotNullParameter(r4, "contextProvider");
        this.a = r0;
        this.b = r3;
        this.c = r4;
        this.d = ItemUIStyle.FEISHU;
        this.e = new LinkedHashMap();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.l
    public final com.bytedance.ee.bear.more.protocol3.k a(final IBaseMoreItem r24, com.bytedance.ee.bear.more.protocol3.a r25, com.bytedance.ee.bear.more.protocol3.m r26) {
        Intrinsics.checkNotNullParameter(r24, "moreItem");
        Intrinsics.checkNotNullParameter(r25, "extendEnableChecker");
        Intrinsics.checkNotNullParameter(r26, "extendVisibleChecker");
        Map<String, String> r0 = s.a;
        final String r12 = s.a(r24.getId());
        if (r24.isVisible() == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        boolean r15 = r24 instanceof IGridMoreItem;
        if (r15 == false) goto L16;
        if (((IGridMoreItem) r24).isEnable() == true) goto L13;
    L22:
        final boolean r9 = false;
    L31:
        k r8 = (k) ((LinkedHashMap) this.e).get(r12);
        Function0<Boolean> r1 = new OverrideUIMoreItemFactory$buildV2$1(this, r24, r9);
        x r7 = (x) this.c.invoke();
        if (r8 == null) goto L34;
        q r4 = r8.a;
    L35:
        if (r4 == null) goto L40;
        if (r7 == null) goto L40;
        if (y.a() == true) goto L40;
        boolean r6 = true;
    L42:
        if (r6 == false) goto L44;
        y.c("buildV2", r12);
    L44:
        if (r6 == false) goto L46;
        r4 = null;
    L46:
        this.b.b(r12, new com.bytedance.ee.bear.more.protocol3.panel.a(r12, r3, r9, r1));
        String r13 = "OverrideUIMoreItemFactory";
        if (r4 == null) goto L54;
        if (r7 == null) goto L54;
        boolean r2 = r4.b(r7, r3);     // Catch: Throwable -> L51
    L53:
        final boolean r14 = r2;
    L55:
        if (r14 == true) goto L57;
        tt5.a.h("OverrideUIMoreItemFactory", "buildV2: visible=false after host override, itemId=".concat(r12));
        return null;
    L57:
        if (r4 == null) goto L64;
        if (r7 == null) goto L64;
        boolean r5 = r4.c(r7, r9);     // Catch: Throwable -> L61
    L65:
        if (r3 == true) goto L68;
        if (r14 == false) goto L68;
        com.bytedance.ee.bear.more.protocol3.m r10 = f;
    L69:
        boolean r11 = r24 instanceof ITextMoreItem;
        if (r11 == false) goto L72;
        boolean r18 = r11;
        com.bytedance.ee.bear.more.protocol3.m r16 = r10;
        final boolean r17 = r14;
        final q r19 = r4;
        final boolean r20 = r5;
        boolean r21 = r6;
        final x r27 = r7;
        k r22 = r8;
        IBaseMoreItem r23 = new OverrideUIMoreItemFactory$wrapLegacyMoreItem$1(r24, r17, r20, this, r12, r19, r27);
        r13 = "OverrideUIMoreItemFactory";
        r9 = r9;
        String r28 = "buildV2";
    L89:
        if (r9 != r5) goto L91;
        com.bytedance.ee.bear.more.protocol3.a r29 = r25;
    L98:
        com.bytedance.ee.bear.more.protocol3.k r30 = this.a.a(r23, r29, r16);
        if (r30 != null) goto L101;
        tt5.a.k(r13, "buildV2: real factory returned null, itemId=".concat(r12));
        return null;
    L101:
        x r31 = r27;
        k r32 = r22;
        String r33 = r13;
        String r34 = g(r12, r28, r31, r32);
        Integer r35 = e(r12, r28, r31, r32);
        Integer r36 = f(r12, r28, r31, r32);
        Integer r37 = d(r12, r28, r31, r32);
        if (r32 == null) goto L105;
        ItemUIStyle r38 = r32.f;
        if (r38 == null) goto L105;
    L106:
        r30.d = r38;
        if (r34 != null) goto L111;
        if (r35 != null) goto L111;
        if (r36 != null) goto L111;
        if (r37 != null) goto L111;
    L112:
        StringBuilder r39 = new StringBuilder("buildV2: built itemId=");
        r39.append(r12);
        r39.append(", title=");
        r39.append(r34);
        r39.append(", icon=");
        r39.append(r35);
        r39.append(", iconTint=");
        r39.append(r36);
        r39.append(", disableIconTint=");
        r39.append(r37);
        r39.append(", baselineEnabled=");
        r39.append(r9);
        r39.append(", finalEnabled=");
        r39.append(r5);
        r39.append(", hasDelegate=");
        if (r19 == null) goto L115;
        boolean r110 = true;
    L116:
        r39.append(r110);
        r39.append(", delegateDowngraded=");
        r39.append(r21);
        tt5.a.h(r33, r39.toString());
        return r30;
    L115:
        r110 = false;
    L111:
        r30.c = new h0(r35, r36, r37, r34);
    L105:
        r38 = this.d;
        goto L106
    L91:
        r29 = g;
        if (r15 == true) goto L98;
        if (r18 == true) goto L98;
        if (r5 == true) goto L98;
        r29 = h;
        goto L98
    L72:
        r18 = r11;
        r16 = r10;
        r19 = r4;
        r21 = r6;
        r27 = r7;
        r22 = r8;
        if (r15 == false) goto L82;
        final IGridMoreItem r40 = (IGridMoreItem) r24;
        if ((r40 instanceof sj5.a) == false) goto L77;
        sj5.a r41 = (sj5.a) r40;
    L78:
        if (r41 == null) goto L80;
        IBaseMoreItem r111 = new OverrideUIMoreItemFactory$wrapGridMoreItem$1(r40, r41, r14, r5, this, r12, r19, r27);
        r28 = "buildV2";
    L81:
        r23 = r111;
        goto L89
    L80:
        r28 = "buildV2";
        final boolean r42 = r14;
        final boolean r43 = r5;
        r111 = new OverrideUIMoreItemFactory$wrapGridMoreItem$2(r40, r42, r43, this, r12, r19, r27);
        goto L81
    L77:
        r41 = null;
        goto L78
    L82:
        r13 = "OverrideUIMoreItemFactory";
        r9 = r9;
        r28 = "buildV2";
        if ((r24 instanceof ILoadingSwitchMoreItem) == false) goto L86;
        final boolean r44 = r14;
        r23 = new OverrideUIMoreItemFactory$wrapLegacyMoreItem$2(r24, r44, this, r12, r19, r27);
        goto L89
    L86:
        if ((r24 instanceof ISwitchMoreItem) == false) goto L88;
        final boolean r45 = r14;
        r23 = new OverrideUIMoreItemFactory$wrapLegacyMoreItem$3(r24, r45, this, r12, r19, r27);
        goto L89
    L88:
        r23 = new OverrideUIMoreItemFactory$wrapLegacyMoreItem$4(r24, r14);
    L68:
        r10 = r26;
    L61:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", "buildV2: hostDelegate.isEnabled error, itemId=".concat(r12), th, false);
    L64:
        r5 = r9;
    L51:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", "buildV2: hostDelegate.isVisible error, itemId=".concat(r12), th, false);
        r2 = false;
    L54:
        r14 = r3;
    L40:
        r6 = false;
        goto L42
    L34:
        r4 = null;
        goto L35
    L13:
        if (r25.isEnable() == false) goto L22;
    L30:
        r9 = true;
        goto L31
    L16:
        if ((r24 instanceof ITextMoreItem) == false) goto L24;
        if (((ITextMoreItem) r24).isEnable() == false) goto L22;
        if (r25.isEnable() == false) goto L22;
    L24:
        if ((r24 instanceof ILoadingSwitchMoreItem) == false) goto L27;
        boolean r46 = r25.isEnable();
    L29:
        r9 = r46;
        goto L31
    L27:
        if ((r24 instanceof ISwitchMoreItem) == false) goto L30;
        r46 = r25.isEnable();
        goto L29
    L5:
        if (r26.isVisible() == false) goto L7;
        r3 = true;
        goto L8
    }

    public static final boolean c(OverrideUIMoreItemFactory r1, String r2, q r3, x r4) {
        r1.getClass();
        if (r3 == null) goto L19;
        if (r4 == null) goto L22;
        i r5 = r3.a(r4);     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(r5, i.a.a) == false) goto L10;
        return true;
    L10:
        if (Intrinsics.areEqual(r5, i.b.a) == false) goto L13;
        return false;
    L13:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", "dispatchHostClick: hostDelegate.onClick error, itemId=" + r2, th, false);
        return false;
    L22:
        return false;
    L19:
        return false;
    }

    public static Integer d(String r2, String r3, x r4, k r5) {
        if (r5 == null) goto L18;
        Function1<x, Integer> r6 = r5.e;
        if (r6 != null) goto L8;
        return null;
    L8:
        if (r4 != null) goto L16;
        tt5.a.k("OverrideUIMoreItemFactory", r3 + ": skip disableIconTint override, context is null, itemId=" + r2);
        return null;
    L16:
        return (Integer) r6.invoke(r4);
    L13:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", r3 + ": disableIconTintProvider error, itemId=" + r2, th, false);
        return null;
    L18:
        return null;
    }

    public static Integer e(String r2, String r3, x r4, k r5) {
        if (r5 == null) goto L18;
        Function1<x, Integer> r6 = r5.c;
        if (r6 != null) goto L8;
        return null;
    L8:
        if (r4 != null) goto L16;
        tt5.a.k("OverrideUIMoreItemFactory", r3 + ": skip icon override, context is null, itemId=" + r2);
        return null;
    L16:
        return (Integer) r6.invoke(r4);
    L13:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", r3 + ": iconProvider error, itemId=" + r2, th, false);
        return null;
    L18:
        return null;
    }

    public static Integer f(String r2, String r3, x r4, k r5) {
        if (r5 == null) goto L18;
        Function1<x, Integer> r6 = r5.d;
        if (r6 != null) goto L8;
        return null;
    L8:
        if (r4 != null) goto L16;
        tt5.a.k("OverrideUIMoreItemFactory", r3 + ": skip iconTint override, context is null, itemId=" + r2);
        return null;
    L16:
        return (Integer) r6.invoke(r4);
    L13:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", r3 + ": iconTintProvider error, itemId=" + r2, th, false);
        return null;
    L18:
        return null;
    }

    public static String g(String r2, String r3, x r4, k r5) {
        if (r5 == null) goto L18;
        Function1<x, String> r6 = r5.b;
        if (r6 != null) goto L8;
        return null;
    L8:
        if (r4 != null) goto L16;
        tt5.a.k("OverrideUIMoreItemFactory", r3 + ": skip title override, context is null, itemId=" + r2);
        return null;
    L16:
        return (String) r6.invoke(r4);
    L13:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", r3 + ": titleProvider error, itemId=" + r2, th, false);
        return null;
    L18:
        return null;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.l
    public final com.bytedance.ee.bear.more.protocol3.k b(com.bytedance.ee.bear.more.protocol3.f r23, com.bytedance.ee.bear.more.protocol3.e r24, List<? extends com.bytedance.ee.bear.more.protocol3.m> r25, List<? extends com.bytedance.ee.bear.more.protocol3.a> r26, View.OnClickListener r27) {
        Intrinsics.checkNotNullParameter(r23, ResourceData.KEY_TYPE);
        Intrinsics.checkNotNullParameter(r24, "style");
        Map<String, String> r0 = s.a;
        String r10 = s.a(r23.a);
        if (r25 == null) goto L17;
        List<? extends com.bytedance.ee.bear.more.protocol3.m> r1 = r25;
        if ((r1 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        if (((com.bytedance.ee.bear.more.protocol3.m) r2.next()).isVisible() == true) goto L11;
        boolean r3 = false;
    L16:
        boolean r4 = r3;
    L18:
        if (r26 == null) goto L32;
        List<? extends com.bytedance.ee.bear.more.protocol3.a> r5 = r26;
        if ((r5 instanceof Collection) == true) goto L22;
    L24:
        Iterator<T> r6 = r5.iterator();
    L26:
        if (r6.hasNext() == false) goto L30;
        if (((com.bytedance.ee.bear.more.protocol3.a) r6.next()).isEnable() == true) goto L26;
        boolean r7 = false;
    L31:
        boolean r13 = r7;
    L33:
        k r14 = (k) ((LinkedHashMap) this.e).get(r10);
        final View.OnClickListener r8 = r27;
        Function0<Boolean> r9 = new OverrideUIMoreItemFactory$build$1(this, r8);
        x r15 = (x) this.c.invoke();
        if (r14 == null) goto L36;
        q r11 = r14.a;
    L37:
        if (r11 == null) goto L42;
        if (r15 == null) goto L42;
        if (y.a() == true) goto L42;
        boolean r12 = true;
    L43:
        String r16 = "build";
        if (r12 == false) goto L46;
        y.c("build", r10);
    L46:
        if (r12 == false) goto L48;
        q r17 = null;
    L49:
        this.b.b(r10, new com.bytedance.ee.bear.more.protocol3.panel.a(r10, r4, r13, r9));
        if (r17 == null) goto L57;
        if (r15 == null) goto L57;
        boolean r18 = r17.b(r15, r4);     // Catch: Throwable -> L54
    L56:
        boolean r19 = r18;
    L58:
        if (r19 == true) goto L60;
        tt5.a.h("OverrideUIMoreItemFactory", "build: visible=false after host override, itemId=".concat(r10));
        return null;
    L60:
        if (r17 == null) goto L67;
        if (r15 == null) goto L67;
        boolean r20 = r17.c(r15, r13);     // Catch: Throwable -> L64
        r16 = "build";
    L68:
        if (r4 == true) goto L71;
        if (r19 == false) goto L71;
        List<? extends com.bytedance.ee.bear.more.protocol3.m> r110 = null;
    L72:
        if (r13 != r20) goto L74;
        List<? extends com.bytedance.ee.bear.more.protocol3.a> r111 = r26;
    L78:
        if (r17 == null) goto L82;
        if (r15 == null) goto L82;
        q r21 = r17;
        r8 = new d0(this, r10, r21, r15, r27);
    L83:
        com.bytedance.ee.bear.more.protocol3.k r22 = this.a.b(r23, r24, r110, r111, r8);
        if (r22 != null) goto L86;
        tt5.a.k("OverrideUIMoreItemFactory", "build: real factory returned null, itemId=".concat(r10));
        return null;
    L86:
        String r28 = g(r10, r16, r15, r14);
        Integer r29 = e(r10, r16, r15, r14);
        Integer r30 = f(r10, r16, r15, r14);
        Integer r31 = d(r10, r16, r15, r14);
        if (r14 == null) goto L90;
        ItemUIStyle r32 = r14.f;
        if (r32 == null) goto L90;
    L91:
        r22.d = r32;
        if (r28 != null) goto L96;
        if (r29 != null) goto L96;
        if (r30 != null) goto L96;
        if (r31 != null) goto L96;
    L97:
        StringBuilder r33 = new StringBuilder("build: built itemId=");
        r33.append(r10);
        r33.append(", title=");
        r33.append(r28);
        r33.append(", icon=");
        r33.append(r29);
        r33.append(", iconTint=");
        r33.append(r30);
        r33.append(", disableIconTint=");
        r33.append(r31);
        r33.append(", baselineEnabled=");
        r33.append(r13);
        r33.append(", finalEnabled=");
        r33.append(r20);
        r33.append(", hasDelegate=");
        if (r21 == null) goto L100;
        boolean r34 = true;
    L101:
        r33.append(r34);
        r33.append(", delegateDowngraded=");
        r33.append(r12);
        tt5.a.h("OverrideUIMoreItemFactory", r33.toString());
        return r22;
    L100:
        r34 = false;
    L96:
        r22.c = new h0(r29, r30, r31, r28);
    L90:
        r32 = this.d;
    L82:
        r21 = r17;
        goto L83
    L74:
        if (r20 == false) goto L76;
        List<? extends com.bytedance.ee.bear.more.protocol3.a> r35 = null;
    L77:
        r111 = r35;
        goto L78
    L76:
        r35 = CollectionsKt.listOf(h);
    L71:
        r110 = r25;
    L64:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", "build: hostDelegate.isEnabled error, itemId=".concat(r10), th, false);
    L67:
        r20 = r13;
    L54:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", "build: hostDelegate.isVisible error, itemId=".concat(r10), th, false);
        r18 = false;
    L57:
        r19 = r4;
        goto L58
    L48:
        r17 = r11;
    L42:
        r12 = false;
        goto L43
    L36:
        r11 = null;
    L30:
        r7 = true;
        goto L31
    L22:
        if (r5.isEmpty() == false) goto L24;
    L32:
        r13 = true;
    L15:
        r3 = true;
        goto L16
    L7:
        if (r1.isEmpty() == false) goto L9;
    L17:
        r4 = true;
        goto L18
    }
}
