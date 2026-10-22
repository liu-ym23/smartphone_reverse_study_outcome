package com.bytedance.android.shopping.skubuy.ability;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.b;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.abscontainer.arch.platform.toast.PlatformToast;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import com.gyf.barlibrary.ImmersionBar;
import j33.e;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import l33.c;
import p33.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuBuyUiAbility implements e {
    public final c a;
    public final a b;
    public final AndroidYaTaInstance c;

    public final View d(String r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (r4.hashCode() == (-1920148655)) goto L9;
        return null;
    L9:
        if (r4.equals("main_scroll_view") == false) goto L14;
        a r5 = this.b;
        if (r5 != null) goto L13;
        return null;
    L13:
        return r5.a;
    L14:
        return null;
    }

    public final View e(final Map<String, ?> r6) {
        boolean r0 = false;
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        return null;
    L12:
        com.bytedance.kmp.ec.yata.store.node.c r7 = (com.bytedance.kmp.ec.yata.store.node.c) CollectionsKt.firstOrNull(this.c.q(new SkuBuyUiAbility$findSliceView$targetNodeKey$1(r6)));
        if (r7 == null) goto L15;
        String r8 = r7.getKey();
    L16:
        if (r8 != null) goto L18;
    L19:
        r0 = true;
    L20:
        if (r0 == false) goto L23;
        return null;
    L23:
        return this.c.K(r8);
    L18:
        if (r8.length() != 0) goto L20;
    L15:
        r8 = null;
        goto L16
    L5:
        if (r6.isEmpty() == true) goto L8;
        r2 = false;
        goto L10
    }

    public final void f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "theme");
        int r0 = r3.hashCode();
        if (r0 == 3075958) goto L15;
        if (r0 == 102970646) goto L8;
        return;
    L8:
        if (r3.equals("light") == false) goto L22;
        ImmersionBar r4 = ImmersionBar.with(this.a.getContainerContext());
        if (r4 == null) goto L23;
        ImmersionBar r5 = r4.statusBarDarkFont(true);
        if (r5 == null) goto L24;
        r5.init();
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L15:
        if (r3.equals("dark") == false) goto L26;
        ImmersionBar r6 = ImmersionBar.with(this.a.getContainerContext());
        if (r6 == null) goto L27;
        ImmersionBar r7 = r6.statusBarDarkFont(false);
        if (r7 == null) goto L28;
        r7.init();
        return;
    L28:
        return;
    L27:
        return;
    }

    public final Pair<Integer, String> h(Map<String, ?> r14) {
        if (r14 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        String r3 = null;
        if (r2 == false) goto L12;
        return null;
    L12:
        List r4 = this.c.n("body");
        int r5 = -1;
        if (r4 == null) goto L34;
        Iterator r6 = r4.iterator();
        int r7 = 0;
    L16:
        if (r6.hasNext() == false) goto L34;
        com.bytedance.kmp.ec.yata.store.node.c r8 = (com.bytedance.kmp.ec.yata.store.node.c) r6.next();
        if (r14.isEmpty() == false) goto L20;
    L19:
        boolean r9 = true;
    L31:
        if (r9 == true) goto L32;
        r7 = r7 + 1;
        goto L16
    L32:
        r5 = r7;
        goto L34
    L20:
        Iterator<Map.Entry<String, ?>> r10 = r14.entrySet().iterator();
    L22:
        if (r10.hasNext() == false) goto L19;
        Map.Entry<String, ?> r11 = r10.next();
        String r12 = r11.getKey();
        p r13 = r8.b.b;
        if (r13 == null) goto L27;
        Object r15 = q.b(r13, Reflection.getOrCreateKotlinClass(Object.class), r12);
        if ((r15 instanceof Object) == false) goto L27;
    L29:
        if (Intrinsics.areEqual(r15, r11.getValue()) == true) goto L22;
        r9 = false;
    L27:
        r15 = null;
    L34:
        if (r4 == null) goto L39;
        com.bytedance.kmp.ec.yata.store.node.c r16 = (com.bytedance.kmp.ec.yata.store.node.c) CollectionsKt.getOrNull(r4, r5);
        if (r16 == null) goto L39;
        r3 = r16.getKey();
    L39:
        return TuplesKt.to(Integer.valueOf(r5), r3);
    L5:
        if (r14.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public final Map<String, Float> i(View r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        ConstraintLayout r1 = this.a.getRootView();
        SlcRenderContext r2 = (SlcRenderContext) this.c.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
        if (r2 == null) goto L12;
        b r3 = r2.f;
        if (r3 == null) goto L12;
        int r0 = com.bytedance.android.shopping.buynow.utils.q.a(r7, r1);
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("width", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(r7.getWidth()), r3))), TuplesKt.to("height", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(r7.getHeight()), r3))), TuplesKt.to("top", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(com.bytedance.android.shopping.buynow.utils.q.b(r7, r1)), r3))), TuplesKt.to("left", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(r0), r3)))});
    L12:
        return null;
    }

    public final void showToast(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        int r0 = PlatformToast.a;
        PlatformToast.a(this.a.getContainerContext(), r2);
    }

    public SkuBuyUiAbility(c r2, a r3, AndroidYaTaInstance r4) {
        Intrinsics.checkNotNullParameter(r2, "platformContainerDelegate");
        Intrinsics.checkNotNullParameter(r4, "yataInstance");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final void g(final View r19, View r20, Integer r21, Map<String, ?> r22, final String r23, final Function0<Unit> r24) {
        if (r19 != null) goto L7;
        Unit r1 = (Unit) r24.invoke();
        return;
    L7:
        if (r20 == null) goto L97;
        if (r23 != null) goto L11;
    L95:
        Unit r2 = (Unit) r24.invoke();
        return;
    L11:
        switch(r23.hashCode()) {
            case -1383228885: goto L30;
            case 115029: goto L26;
            case 3317767: goto L23;
            case 108511772: goto L20;
            case 364851518: goto L16;
            case 939658448: goto L14;
            default: goto L95;
        };
    L16:
        char r16 = 1;
        if (r23.equals("vertical_center") == false) goto L95;
        int[] r13 = {0, r20.getHeight() / 2};
    L33:
        switch(r23.hashCode()) {
            case -1383228885: goto L51;
            case 115029: goto L48;
            case 3317767: goto L45;
            case 108511772: goto L42;
            case 364851518: goto L39;
            case 939658448: goto L36;
            default: goto L93;
        };
    L93:
        Unit r3 = (Unit) r24.invoke();
        return;
    L36:
        if (r23.equals("horizontal_center") == false) goto L93;
        int[] r4 = new int[2];
        r4[0] = r19.getWidth() / 2;
        r4[r16] = 0;
    L53:
        if (r22 == null) goto L55;
        Object r5 = r22.get("x");
    L57:
        if ((r5 instanceof Integer) == true) goto L59;
        r5 = null;
    L59:
        Integer r6 = (Integer) r5;
        if (r6 == null) goto L62;
        int r7 = r6.intValue();
    L63:
        SlcRenderContext r8 = (SlcRenderContext) this.c.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
        if (r8 == null) goto L68;
        b r9 = r8.f;
        if (r9 == null) goto L68;
        int r10 = (int) SlcDimensExtensionsKt.c(Integer.valueOf(r7), r9);
    L69:
        if (r22 == null) goto L71;
        Object r11 = r22.get("y");
    L73:
        if ((r11 instanceof Integer) == true) goto L75;
        r11 = null;
    L75:
        Integer r12 = (Integer) r11;
        if (r12 == null) goto L78;
        int r14 = r12.intValue();
    L79:
        SlcRenderContext r15 = (SlcRenderContext) this.c.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
        if (r15 == null) goto L84;
        b r17 = r15.f;
        if (r17 == null) goto L84;
        int r18 = (int) SlcDimensExtensionsKt.c(Integer.valueOf(r14), r17);
    L85:
        int r25 = r19.getScrollY();
        int r26 = ((com.bytedance.android.shopping.buynow.utils.q.a(r20, r19) + r13[0]) - (r4[0] + r19.getScrollX())) - r10;
        int r27 = ((com.bytedance.android.shopping.buynow.utils.q.b(r20, r19) + r13[1]) - (r4[1] + r25)) - r18;
        if ((r19 instanceof RecyclerView) == true) goto L88;
        View r28 = null;
    L89:
        RecyclerView r29 = (RecyclerView) r28;
        if (r29 == null) goto L92;
        r29.stopScroll();
    L92:
        r19.scrollBy(r26, r27);
        Unit r30 = (Unit) r24.invoke();
        return;
    L88:
        r28 = r19;
    L84:
        r18 = 0;
        goto L85
    L78:
        r14 = 0;
        goto L79
    L71:
        r11 = null;
    L68:
        r10 = 0;
        goto L69
    L62:
        r7 = 0;
        goto L63
    L55:
        r5 = null;
        goto L57
    L39:
        if (r23.equals("vertical_center") == false) goto L93;
        r4 = new int[2];
        r4[0] = 0;
        r4[r16] = r19.getHeight() / 2;
        goto L53
    L42:
        if (r23.equals("right") == false) goto L93;
        r4 = new int[2];
        r4[0] = r19.getWidth();
        r4[r16] = 0;
        goto L53
    L45:
        if (r23.equals("left") == false) goto L93;
        r4 = new int[]{0, 0};
        goto L53
    L48:
        if (r23.equals("top") == false) goto L93;
        r4 = new int[]{0, 0};
        goto L53
    L51:
        if (r23.equals("bottom") == false) goto L93;
        r4 = new int[]{0, r19.getHeight()};
        goto L53
    L14:
        if (r23.equals("horizontal_center") == false) goto L95;
        r16 = 1;
        r13 = new int[]{r20.getWidth() / 2, 0};
        goto L33
    L20:
        if (r23.equals("right") == false) goto L95;
        r13 = new int[]{r20.getWidth(), 0};
    L28:
        r16 = 1;
        goto L33
    L23:
        if (r23.equals("left") == false) goto L95;
        r13 = new int[]{0, 0};
        goto L28
    L26:
        if (r23.equals("top") == false) goto L95;
        r13 = new int[]{0, 0};
        goto L28
    L30:
        if (r23.equals("bottom") == false) goto L95;
        r16 = 1;
        r13 = new int[]{0, r20.getHeight()};
        goto L33
    L97:
        boolean r31 = true;
        if (r21 != null) goto L100;
        return;
    L100:
        if ((r19 instanceof RecyclerView) == true) goto L103;
        Unit r32 = (Unit) r24.invoke();
        return;
    L103:
        if (r22 == null) goto L105;
        Object r33 = r22.get("x");
    L107:
        if ((r33 instanceof Integer) == true) goto L109;
        r33 = null;
    L109:
        Integer r34 = (Integer) r33;
        if (r34 == null) goto L112;
        int r35 = r34.intValue();
    L113:
        SlcRenderContext r36 = (SlcRenderContext) this.c.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
        if (r36 == null) goto L118;
        b r37 = r36.f;
        if (r37 == null) goto L118;
        final int r38 = (int) SlcDimensExtensionsKt.c(Integer.valueOf(r35), r37);
    L119:
        if (r22 == null) goto L121;
        Object r39 = r22.get("y");
    L123:
        if ((r39 instanceof Integer) == true) goto L125;
        r39 = null;
    L125:
        Integer r40 = (Integer) r39;
        if (r40 == null) goto L128;
        int r41 = r40.intValue();
    L129:
        SlcRenderContext r42 = (SlcRenderContext) this.c.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
        if (r42 == null) goto L134;
        b r43 = r42.f;
        if (r43 == null) goto L134;
        int r44 = (int) SlcDimensExtensionsKt.c(Integer.valueOf(r41), r43);
    L136:
        if (Intrinsics.areEqual(r23, "top") == false) goto L138;
    L143:
        if (r31 == false) goto L145;
        r38 = r44;
    L145:
        RecyclerView r45 = (RecyclerView) r19;
        final Context r46 = r45.getContext();
        LinearSmoothScroller r47 = new SkuBuyUiAbility$scrollToComponent$smoothScroller$1(r23, r38, r19, r46);
        r47.setTargetPosition(r21.intValue());
        LinearLayoutManager r48 = r45.getLayoutManager();
        if ((r48 instanceof LinearLayoutManager) == true) goto L148;
        LinearLayoutManager r49 = null;
    L149:
        LinearLayoutManager r50 = r49;
        if (r50 == null) goto L152;
        r50.startSmoothScroll(r47);
    L152:
        r45.addOnScrollListener(new SkuBuyUiAbility$scrollToComponent$itemScrollListener$1(r24));
        return;
    L148:
        r49 = r48;
        goto L149
    L138:
        if (Intrinsics.areEqual(r23, "bottom") == true) goto L143;
        if (Intrinsics.areEqual(r23, "vertical_center") == true) goto L143;
        r31 = false;
    L134:
        r44 = 0;
        goto L136
    L128:
        r41 = 0;
        goto L129
    L121:
        r39 = null;
    L118:
        r38 = 0;
        goto L119
    L112:
        r35 = 0;
        goto L113
    L105:
        r33 = null;
        goto L107
    }
}
