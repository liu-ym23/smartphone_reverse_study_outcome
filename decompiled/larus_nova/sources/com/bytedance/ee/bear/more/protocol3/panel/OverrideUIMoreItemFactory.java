package com.bytedance.ee.bear.more.protocol3.panel;

import android.view.View;
import com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.IGridMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ILoadingSwitchMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ISwitchMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
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

/* JADX INFO: loaded from: classes18.dex */
public final class OverrideUIMoreItemFactory implements com.bytedance.ee.bear.more.protocol3.l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f234915f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f234916g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f234917h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f234918i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.more.protocol3.l f234919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f234920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<x> f234921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ItemUIStyle f234922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, k> f234923e;

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
        f234915f = new c();
        f234916g = new b();
        f234917h = new a();
        f234918i = new d();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.l
    public final com.bytedance.ee.bear.more.protocol3.g buildHeader() {
        return this.f234919a.buildHeader();
    }

    public OverrideUIMoreItemFactory(com.bytedance.ee.bear.more.protocol3.panel.e r100, Function0 r101) {
        com.bytedance.ee.bear.more.view3.d r102 = com.bytedance.ee.bear.more.view3.d.f235024a;
        Intrinsics.checkNotNullParameter(r102, "real");
        Intrinsics.checkNotNullParameter(r100, "registry");
        Intrinsics.checkNotNullParameter(r101, "contextProvider");
        this.f234919a = r102;
        this.f234920b = r100;
        this.f234921c = r101;
        this.f234922d = ItemUIStyle.FEISHU;
        this.f234923e = new LinkedHashMap();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.l
    public final com.bytedance.ee.bear.more.protocol3.k a(final IBaseMoreItem r210, com.bytedance.ee.bear.more.protocol3.a r211, com.bytedance.ee.bear.more.protocol3.m r212) {
        Intrinsics.checkNotNullParameter(r210, "moreItem");
        Intrinsics.checkNotNullParameter(r211, "extendEnableChecker");
        Intrinsics.checkNotNullParameter(r212, "extendVisibleChecker");
        Map<String, String> r100 = s.f235002a;
        final String r110 = s.a(r210.getId());
        if (r210.isVisible() == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        boolean r111 = r210 instanceof IGridMoreItem;
        if (r111 == false) goto L16;
        if (((IGridMoreItem) r210).isEnable() == true) goto L13;
    L22:
        final boolean r102 = false;
    L31:
        k r103 = (k) ((LinkedHashMap) this.f234923e).get(r110);
        Function0<Boolean> r104 = new OverrideUIMoreItemFactory$buildV2$1(this, r210, r102);
        x r105 = this.f234921c.invoke();
        if (r103 == null) goto L34;
        q r106 = r103.f234984a;
    L35:
        if (r106 == null) goto L40;
        if (r105 == null) goto L40;
        if (y.a() == true) goto L40;
        boolean r107 = true;
    L42:
        if (r107 == false) goto L44;
        y.c("buildV2", r110);
    L44:
        if (r107 == false) goto L46;
        r106 = null;
    L46:
        this.f234920b.b(r110, new com.bytedance.ee.bear.more.protocol3.panel.a(r110, r101, r102, r104));
        String r112 = "OverrideUIMoreItemFactory";
        if (r106 == null) goto L54;
        if (r105 == null) goto L54;
        boolean r108 = r106.b(r105, r101);     // Catch: Throwable -> L51
    L53:
        final boolean r113 = r108;
    L55:
        if (r113 == true) goto L57;
        tt5.a.h("OverrideUIMoreItemFactory", "buildV2: visible=false after host override, itemId=".concat(r110));
        return null;
    L57:
        if (r106 == null) goto L64;
        if (r105 == null) goto L64;
        boolean r109 = r106.c(r105, r102);     // Catch: Throwable -> L61
    L65:
        if (r101 == true) goto L68;
        if (r113 == false) goto L68;
        com.bytedance.ee.bear.more.protocol3.m r114 = f234915f;
    L69:
        boolean r115 = r210 instanceof ITextMoreItem;
        if (r115 == false) goto L72;
        boolean r116 = r115;
        com.bytedance.ee.bear.more.protocol3.m r117 = r114;
        final boolean r118 = r113;
        final q r119 = r106;
        final boolean r120 = r109;
        boolean r213 = r107;
        final x r214 = r105;
        k r215 = r103;
        IBaseMoreItem r121 = new OverrideUIMoreItemFactory$wrapLegacyMoreItem$1(r210, r118, r120, this, r110, r119, r214);
        r112 = "OverrideUIMoreItemFactory";
        r102 = r102;
        String r122 = "buildV2";
    L89:
        if (r102 != r109) goto L91;
        com.bytedance.ee.bear.more.protocol3.a r123 = r211;
    L98:
        com.bytedance.ee.bear.more.protocol3.k r124 = this.f234919a.a(r121, r123, r117);
        if (r124 != null) goto L101;
        tt5.a.k(r112, "buildV2: real factory returned null, itemId=".concat(r110));
        return null;
    L101:
        x r125 = r214;
        k r126 = r215;
        String r127 = r112;
        String r128 = g(r110, r122, r125, r126);
        Integer r129 = e(r110, r122, r125, r126);
        Integer r130 = f(r110, r122, r125, r126);
        Integer r131 = d(r110, r122, r125, r126);
        if (r126 == null) goto L105;
        ItemUIStyle r132 = r126.f234989f;
        if (r132 == null) goto L105;
    L106:
        r124.f234904d = r132;
        if (r128 != null) goto L111;
        if (r129 != null) goto L111;
        if (r130 != null) goto L111;
        if (r131 != null) goto L111;
    L112:
        StringBuilder r133 = new StringBuilder("buildV2: built itemId=");
        r133.append(r110);
        r133.append(", title=");
        r133.append(r128);
        r133.append(", icon=");
        r133.append(r129);
        r133.append(", iconTint=");
        r133.append(r130);
        r133.append(", disableIconTint=");
        r133.append(r131);
        r133.append(", baselineEnabled=");
        r133.append(r102);
        r133.append(", finalEnabled=");
        r133.append(r109);
        r133.append(", hasDelegate=");
        if (r119 == null) goto L115;
        boolean r134 = true;
    L116:
        r133.append(r134);
        r133.append(", delegateDowngraded=");
        r133.append(r213);
        tt5.a.h(r127, r133.toString());
        return r124;
    L115:
        r134 = false;
    L111:
        r124.f234903c = new h0(r129, r130, r131, r128);
    L105:
        r132 = this.f234922d;
        goto L106
    L91:
        r123 = f234916g;
        if (r111 == true) goto L98;
        if (r116 == true) goto L98;
        if (r109 == true) goto L98;
        r123 = f234917h;
        goto L98
    L72:
        r116 = r115;
        r117 = r114;
        r119 = r106;
        r213 = r107;
        r214 = r105;
        r215 = r103;
        if (r111 == false) goto L82;
        final IGridMoreItem r135 = (IGridMoreItem) r210;
        if ((r135 instanceof sj5.a) == false) goto L77;
        sj5.a r136 = (sj5.a) r135;
    L78:
        if (r136 == null) goto L80;
        IBaseMoreItem r137 = new OverrideUIMoreItemFactory$wrapGridMoreItem$1(r135, r136, r113, r109, this, r110, r119, r214);
        r122 = "buildV2";
    L81:
        r121 = r137;
        goto L89
    L80:
        r122 = "buildV2";
        final boolean r138 = r113;
        final boolean r139 = r109;
        r137 = new OverrideUIMoreItemFactory$wrapGridMoreItem$2(r135, r138, r139, this, r110, r119, r214);
        goto L81
    L77:
        r136 = null;
        goto L78
    L82:
        r112 = "OverrideUIMoreItemFactory";
        r102 = r102;
        r122 = "buildV2";
        if ((r210 instanceof ILoadingSwitchMoreItem) == false) goto L86;
        final boolean r140 = r113;
        r121 = new OverrideUIMoreItemFactory$wrapLegacyMoreItem$2(r210, r140, this, r110, r119, r214);
        goto L89
    L86:
        if ((r210 instanceof ISwitchMoreItem) == false) goto L88;
        final boolean r141 = r113;
        r121 = new OverrideUIMoreItemFactory$wrapLegacyMoreItem$3(r210, r141, this, r110, r119, r214);
        goto L89
    L88:
        r121 = new OverrideUIMoreItemFactory$wrapLegacyMoreItem$4(r210, r113);
    L68:
        r114 = r212;
    L61:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", "buildV2: hostDelegate.isEnabled error, itemId=".concat(r110), th, false);
    L64:
        r109 = r102;
    L51:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", "buildV2: hostDelegate.isVisible error, itemId=".concat(r110), th, false);
        r108 = false;
    L54:
        r113 = r101;
    L40:
        r107 = false;
        goto L42
    L34:
        r106 = null;
        goto L35
    L13:
        if (r211.isEnable() == false) goto L22;
    L30:
        r102 = true;
        goto L31
    L16:
        if ((r210 instanceof ITextMoreItem) == false) goto L24;
        if (((ITextMoreItem) r210).isEnable() == false) goto L22;
        if (r211.isEnable() == false) goto L22;
    L24:
        if ((r210 instanceof ILoadingSwitchMoreItem) == false) goto L27;
        boolean r142 = r211.isEnable();
    L29:
        r102 = r142;
        goto L31
    L27:
        if ((r210 instanceof ISwitchMoreItem) == false) goto L30;
        r142 = r211.isEnable();
        goto L29
    L5:
        if (r212.isVisible() == false) goto L7;
        r101 = true;
        goto L8
    }

    public static final boolean c(OverrideUIMoreItemFactory r100, String r101, q r102, x r103) {
        r100.getClass();
        if (r102 == null) goto L19;
        if (r103 == null) goto L22;
        i r104 = r102.a(r103);     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(r104, i.a.f234979a) == false) goto L10;
        return true;
    L10:
        if (Intrinsics.areEqual(r104, i.b.f234980a) == false) goto L13;
        return false;
    L13:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", "dispatchHostClick: hostDelegate.onClick error, itemId=" + r101, th, false);
        return false;
    L22:
        return false;
    L19:
        return false;
    }

    public static Integer d(String r100, String r101, x r102, k r103) {
        if (r103 == null) goto L18;
        Function1<x, Integer> r104 = r103.f234988e;
        if (r104 != null) goto L8;
        return null;
    L8:
        if (r102 != null) goto L16;
        tt5.a.k("OverrideUIMoreItemFactory", r101 + ": skip disableIconTint override, context is null, itemId=" + r100);
        return null;
    L16:
        return r104.invoke(r102);
    L13:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", r101 + ": disableIconTintProvider error, itemId=" + r100, th, false);
        return null;
    L18:
        return null;
    }

    public static Integer e(String r100, String r101, x r102, k r103) {
        if (r103 == null) goto L18;
        Function1<x, Integer> r104 = r103.f234986c;
        if (r104 != null) goto L8;
        return null;
    L8:
        if (r102 != null) goto L16;
        tt5.a.k("OverrideUIMoreItemFactory", r101 + ": skip icon override, context is null, itemId=" + r100);
        return null;
    L16:
        return r104.invoke(r102);
    L13:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", r101 + ": iconProvider error, itemId=" + r100, th, false);
        return null;
    L18:
        return null;
    }

    public static Integer f(String r100, String r101, x r102, k r103) {
        if (r103 == null) goto L18;
        Function1<x, Integer> r104 = r103.f234987d;
        if (r104 != null) goto L8;
        return null;
    L8:
        if (r102 != null) goto L16;
        tt5.a.k("OverrideUIMoreItemFactory", r101 + ": skip iconTint override, context is null, itemId=" + r100);
        return null;
    L16:
        return r104.invoke(r102);
    L13:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", r101 + ": iconTintProvider error, itemId=" + r100, th, false);
        return null;
    L18:
        return null;
    }

    public static String g(String r100, String r101, x r102, k r103) {
        if (r103 == null) goto L18;
        Function1<x, String> r104 = r103.f234985b;
        if (r104 != null) goto L8;
        return null;
    L8:
        if (r102 != null) goto L16;
        tt5.a.k("OverrideUIMoreItemFactory", r101 + ": skip title override, context is null, itemId=" + r100);
        return null;
    L16:
        return r104.invoke(r102);
    L13:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", r101 + ": titleProvider error, itemId=" + r100, th, false);
        return null;
    L18:
        return null;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.l
    public final com.bytedance.ee.bear.more.protocol3.k b(com.bytedance.ee.bear.more.protocol3.f r210, com.bytedance.ee.bear.more.protocol3.e r211, List<? extends com.bytedance.ee.bear.more.protocol3.m> r212, List<? extends com.bytedance.ee.bear.more.protocol3.a> r213, View.OnClickListener r214) {
        Intrinsics.checkNotNullParameter(r210, "type");
        Intrinsics.checkNotNullParameter(r211, "style");
        Map<String, String> r100 = s.f235002a;
        String r110 = s.a(r210.f234853a);
        if (r212 == null) goto L17;
        List<? extends com.bytedance.ee.bear.more.protocol3.m> r101 = r212;
        if ((r101 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L15;
        if (((com.bytedance.ee.bear.more.protocol3.m) r102.next()).isVisible() == true) goto L11;
        boolean r103 = false;
    L16:
        boolean r104 = r103;
    L18:
        if (r213 == null) goto L32;
        List<? extends com.bytedance.ee.bear.more.protocol3.a> r105 = r213;
        if ((r105 instanceof Collection) == true) goto L22;
    L24:
        Iterator<T> r106 = r105.iterator();
    L26:
        if (r106.hasNext() == false) goto L30;
        if (((com.bytedance.ee.bear.more.protocol3.a) r106.next()).isEnable() == true) goto L26;
        boolean r107 = false;
    L31:
        boolean r111 = r107;
    L33:
        k r112 = (k) ((LinkedHashMap) this.f234923e).get(r110);
        final View.OnClickListener r108 = r214;
        Function0<Boolean> r109 = new OverrideUIMoreItemFactory$build$1(this, r108);
        x r113 = this.f234921c.invoke();
        if (r112 == null) goto L36;
        q r114 = r112.f234984a;
    L37:
        if (r114 == null) goto L42;
        if (r113 == null) goto L42;
        if (y.a() == true) goto L42;
        boolean r115 = true;
    L43:
        String r116 = "build";
        if (r115 == false) goto L46;
        y.c("build", r110);
    L46:
        if (r115 == false) goto L48;
        q r117 = null;
    L49:
        this.f234920b.b(r110, new com.bytedance.ee.bear.more.protocol3.panel.a(r110, r104, r111, r109));
        if (r117 == null) goto L57;
        if (r113 == null) goto L57;
        boolean r118 = r117.b(r113, r104);     // Catch: Throwable -> L54
    L56:
        boolean r119 = r118;
    L58:
        if (r119 == true) goto L60;
        tt5.a.h("OverrideUIMoreItemFactory", "build: visible=false after host override, itemId=".concat(r110));
        return null;
    L60:
        if (r117 == null) goto L67;
        if (r113 == null) goto L67;
        boolean r120 = r117.c(r113, r111);     // Catch: Throwable -> L64
        r116 = "build";
    L68:
        if (r104 == true) goto L71;
        if (r119 == false) goto L71;
        List<? extends com.bytedance.ee.bear.more.protocol3.m> r121 = null;
    L72:
        if (r111 != r120) goto L74;
        List<? extends com.bytedance.ee.bear.more.protocol3.a> r122 = r213;
    L78:
        if (r117 == null) goto L82;
        if (r113 == null) goto L82;
        q r215 = r117;
        r108 = new d0(this, r110, r215, r113, r214);
    L83:
        com.bytedance.ee.bear.more.protocol3.k r123 = this.f234919a.b(r210, r211, r121, r122, r108);
        if (r123 != null) goto L86;
        tt5.a.k("OverrideUIMoreItemFactory", "build: real factory returned null, itemId=".concat(r110));
        return null;
    L86:
        String r124 = g(r110, r116, r113, r112);
        Integer r125 = e(r110, r116, r113, r112);
        Integer r126 = f(r110, r116, r113, r112);
        Integer r127 = d(r110, r116, r113, r112);
        if (r112 == null) goto L90;
        ItemUIStyle r128 = r112.f234989f;
        if (r128 == null) goto L90;
    L91:
        r123.f234904d = r128;
        if (r124 != null) goto L96;
        if (r125 != null) goto L96;
        if (r126 != null) goto L96;
        if (r127 != null) goto L96;
    L97:
        StringBuilder r129 = new StringBuilder("build: built itemId=");
        r129.append(r110);
        r129.append(", title=");
        r129.append(r124);
        r129.append(", icon=");
        r129.append(r125);
        r129.append(", iconTint=");
        r129.append(r126);
        r129.append(", disableIconTint=");
        r129.append(r127);
        r129.append(", baselineEnabled=");
        r129.append(r111);
        r129.append(", finalEnabled=");
        r129.append(r120);
        r129.append(", hasDelegate=");
        if (r215 == null) goto L100;
        boolean r130 = true;
    L101:
        r129.append(r130);
        r129.append(", delegateDowngraded=");
        r129.append(r115);
        tt5.a.h("OverrideUIMoreItemFactory", r129.toString());
        return r123;
    L100:
        r130 = false;
    L96:
        r123.f234903c = new h0(r125, r126, r127, r124);
    L90:
        r128 = this.f234922d;
    L82:
        r215 = r117;
        goto L83
    L74:
        if (r120 == false) goto L76;
        List<? extends com.bytedance.ee.bear.more.protocol3.a> r131 = null;
    L77:
        r122 = r131;
        goto L78
    L76:
        r131 = CollectionsKt.listOf(f234917h);
    L71:
        r121 = r212;
    L64:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", "build: hostDelegate.isEnabled error, itemId=".concat(r110), th, false);
    L67:
        r120 = r111;
    L54:
        th = move-exception;
        tt5.a.e("OverrideUIMoreItemFactory", "build: hostDelegate.isVisible error, itemId=".concat(r110), th, false);
        r118 = false;
    L57:
        r119 = r104;
        goto L58
    L48:
        r117 = r114;
    L42:
        r115 = false;
        goto L43
    L36:
        r114 = null;
    L30:
        r107 = true;
        goto L31
    L22:
        if (r105.isEmpty() == false) goto L24;
    L32:
        r111 = true;
    L15:
        r103 = true;
        goto L16
    L7:
        if (r101.isEmpty() == false) goto L9;
    L17:
        r104 = true;
        goto L18
    }
}
