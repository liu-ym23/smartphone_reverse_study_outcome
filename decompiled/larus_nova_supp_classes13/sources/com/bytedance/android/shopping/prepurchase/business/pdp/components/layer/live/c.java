package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv3.i;
import com.bytedance.android.shopping.anchorv3.utils.o;
import com.bytedance.android.shopping.anchorv4.topbanner.TopBannerVO;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ LiveSearchComponent c;
    public final /* synthetic */ i d;
    public final /* synthetic */ TopBannerVO e;

    @Override // java.lang.Runnable
    public final void run() {
        LiveSearchComponent r0 = this.c;
        i r1 = this.d;
        TopBannerVO r2 = this.e;
        if (r0.t == true) goto L6;
        if (r2 != null) goto L6;
        return;
    L6:
        r0.t = true;
        if (r0.m != null) goto L9;
        r0.m = r0.O1().e().r().l0();
    L9:
        r0.p = r1;
        r0.r = r2;
        if (r1 == null) goto L12;
        String r3 = r1.a;
    L14:
        if (r3 != null) goto L16;
        int r9 = 0;
    L31:
        r0.q = new hn.c(r3, r9);
        Pair[] r5 = new Pair[1];
        Pair[] r7 = new Pair[2];
        r7[0] = TuplesKt.to("suggest_key", r3);
        hn.c r4 = r0.q;
        if (r4 == null) goto L34;
        Integer r6 = Integer.valueOf(r4.a);
    L35:
        r7[1] = TuplesKt.to("suggest_key_character_count", r6);
        r5[0] = TuplesKt.to("search_entrance", MapsKt.mapOf(r7));
        Map<String, ? extends Object> r8 = MapsKt.mutableMapOf(r5);
        ECHotAtmosphere r10 = r0.o;
        if (r10 != null) goto L54;
        String r11 = r0.g2().getNativeParams().getLiveHotSaleComponent();
        if (r11 != null) goto L41;
    L44:
        boolean r12 = true;
    L45:
        if (r12 == false) goto L88;
    L53:
        r10 = null;
        goto L54
    L88:
        ECHotAtmosphere r13 = (ECHotAtmosphere) GsonProtectorUtils.fromJson(o.a(), r11, ECHotAtmosphere.class);     // Catch: Throwable -> L52
        if (r0.i2(r13) == false) goto L50;
        r0.o = r13;     // Catch: Throwable -> L52
    L50:
        r10 = r0.o;     // Catch: Throwable -> L52
    L41:
        if (r11.length() == 0) goto L44;
        r12 = false;
    L54:
        if (r10 == null) goto L56;
        r8.put("live_hot_sale_component", r10);
    L56:
        if (r2 == null) goto L58;
        com.bytedance.android.ecom.arch.slice.g r14 = r2.getSlice();
    L59:
        if (r14 == null) goto L98;
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r15 = r0.m;
        if (r15 == null) goto L64;
        r15.b(r14, r8, "header_top_banner");
    L64:
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g r16 = r0.m;
        if (r16 == null) goto L87;
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.c r17 = r16.asView();
        if (r17 == null) goto L93;
        View r18 = r0.e2();
        if (r18 == null) goto L86;
        ((ViewGroup) r18).removeAllViews();
        View r19 = r0.e2();
        if (r19 == null) goto L84;
        ((ViewGroup) r19).addView(r17, -1, -2);
        d2.b(r17, 80);
        ViewGroup.LayoutParams r20 = r17.getLayoutParams();
        if ((r20 instanceof ViewGroup.MarginLayoutParams) == true) goto L75;
        r20 = null;
    L75:
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r20;
        if (r21 == null) goto L78;
        r21.bottomMargin = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r0.O1())).b.b;
        r21.topMargin = 0;
        r17.setLayoutParams(r21);
    L78:
        r17.requestLayout();
        if (r0.v == true) goto L94;
        r0.v = true;
        IAction r22 = r14.getShowAction();
        if (r22 == null) goto L95;
        r0.O1().e().r().O0(r14, r22, r17, null);
        return;
    L95:
        return;
    L94:
        return;
    L84:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L86:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L93:
        return;
    L87:
        return;
    L98:
        return;
    L58:
        r14 = null;
        goto L59
    L34:
        r6 = null;
        goto L35
    L16:
        int r23 = r3.length();
        int r24 = 0;
        r9 = 0;
    L17:
        if (r24 >= r23) goto L31;
        Character.UnicodeBlock r110 = Character.UnicodeBlock.of(r3.charAt(r24));
        if (Intrinsics.areEqual(r110, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) == false) goto L21;
    L26:
        boolean r111 = true;
    L27:
        if (r111 == false) goto L29;
        r9 = r9 + 2;
    L30:
        r24 = r24 + 1;
        goto L17
    L29:
        r9 = r9 + 1;
        goto L30
    L21:
        if (Intrinsics.areEqual(r110, Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) == true) goto L26;
        if (Intrinsics.areEqual(r110, Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) == true) goto L26;
        r111 = false;
        goto L27
    L12:
        r3 = null;
        goto L14
    }

    public c(LiveSearchComponent r1, i r2, TopBannerVO r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        super("bind_live_search_banner");
    }
}
