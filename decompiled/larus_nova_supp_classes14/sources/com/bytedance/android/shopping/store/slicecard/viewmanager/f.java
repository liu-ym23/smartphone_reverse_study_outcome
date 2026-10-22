package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ec.store.view.ECAutoScrollHorizontalScrollView;
import com.bytedance.android.ec.store.view.ECScrollTagListView;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends com.bytedance.android.ecom.arch.slice.render.elements.b<ECScrollTagListView> {
    public String H3;
    public Integer I3;
    public Long J3;
    public Integer K3;
    public Integer L3;
    public float M3;

    public static final class a {
    }

    static {
    }

    public f(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.H3 = "";
    }

    public final void H0(Map<String, ? extends Object> r20) {
        Intrinsics.checkNotNullParameter(r20, "props");
        if (k1() != null) goto L5;
        return;
    L5:
        String r3 = "ShopScrollTagListViewManager";
        dm.a.a("ShopScrollTagListViewManager").a("onUpdateProp, props: " + r20 + '}');
        String r0 = this.H3;
        Iterator<Map.Entry<String, ? extends Object>> r4 = r20.entrySet().iterator();
    L6:
        String r6 = "";
        if (r4.hasNext() == false) goto L42;
        Map.Entry<String, ? extends Object> r5 = r4.next();
        String r7 = r5.getKey();
        Object r8 = r5.getValue();
        switch(r7.hashCode()) {
            case -764061149: goto L36;
            case -396084139: goto L30;
            case 31373223: goto L24;
            case 978230908: goto L18;
            case 1349322996: goto L12;
            default: goto L6;
        };
    L12:
        if (r7.equals("scroll_start_delay") == false) goto L6;
        if (r8 == null) goto L6;
        Integer r9 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r8);
        if (r9 == null) goto L6;
        this.J3 = Long.valueOf(((long) r9.intValue()) * 1000);
        goto L6
    L18:
        if (r7.equals("scroll_padding_right") == false) goto L6;
        if (r8 == null) goto L6;
        Integer r10 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r8);
        if (r10 == null) goto L6;
        this.L3 = Integer.valueOf(r10.intValue());
        goto L6
    L24:
        if (r7.equals("scroll_padding_left") == false) goto L6;
        if (r8 == null) goto L6;
        Integer r11 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r8);
        if (r11 == null) goto L6;
        this.K3 = Integer.valueOf(r11.intValue());
        goto L6
    L30:
        if (r7.equals("scroll_speed") == false) goto L6;
        if (r8 == null) goto L6;
        Integer r12 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r8);
        if (r12 == null) goto L6;
        this.I3 = Integer.valueOf(r12.intValue() * 3);
        goto L6
    L36:
        if (r7.equals("tag_list") == false) goto L6;
        if (r8 == null) goto L40;
        r0 = com.bytedance.android.ec.hybrid.list.util.k.d(r8);
        if (r0 != null) goto L6;
    L40:
        r0 = "";
        goto L6
    L42:
        if (r0.length() <= 0) goto L44;
        boolean r13 = true;
    L45:
        if (r13 == true) goto L47;
    L119:
        r3 = "ShopScrollTagListViewManager";
    L120:
        Object r1 = r20.get("color_animation_percent");
        if (r1 == null) goto L123;
        Float r14 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r1);
    L124:
        dm.a.a(r3).a("onUpdateColor, updateColorPercent: " + r14 + ", colorAnimationPercent: " + this.M3);
        if (r14 != null) goto L127;
        return;
    L127:
        if ((!Intrinsics.areEqual(r14, this.M3)) == false) goto L182;
        this.M3 = r14.floatValue();
        ECScrollTagListView r2 = k1();
        if (r2 == null) goto L183;
        float r15 = this.M3;
        if (r2.getVisibility() != 0) goto L185;
        ECTagListView r16 = r2.c;
        if (r16 == null) goto L184;
        r16.k(r15);
        return;
    L184:
        return;
    L185:
        return;
    L183:
        return;
    L182:
        return;
    L123:
        r14 = null;
        goto L124
    L47:
        if ((!Intrinsics.areEqual(r0, this.H3)) == false) goto L119;
        dm.a.a("ShopScrollTagListViewManager").a("update taglist data and bind");
        this.H3 = r0;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L51
        Object r18 = Result.constructor-impl((ECTagListDTO) u0.b(r0, ECTagListDTO.class));     // Catch: Throwable -> L51
    L54:
        if (Result.isFailure-impl(r18) == false) goto L56;
        r18 = null;
    L56:
        ECTagListDTO r19 = (ECTagListDTO) r18;
        if (r19 == null) goto L111;
        SlcTemplateContext r21 = ((BaseSlcViewManager) this).a;
        String r22 = r21.g;
        if (r22 == null) goto L62;
        r6 = r22;
    L62:
        Object r23 = r21.o(r6);
        if ((r23 instanceof gk3.a) == true) goto L65;
        r23 = null;
    L65:
        gk3.a r24 = (gk3.a) r23;
        if (r24 == null) goto L68;
        k1();
        com.bytedance.android.ec.store.view.j r25 = r24.b(r19);
    L69:
        ECScrollTagListView r26 = k1();
        if (r26 == null) goto L111;
        if (r25 == null) goto L73;
        String r27 = r25.a;
    L74:
        r19.setScene(r27);
        Unit r28 = Unit.INSTANCE;
        Integer r29 = this.I3;
        Long r30 = this.J3;
        Integer r110 = this.K3;
        Integer r111 = this.L3;
        if (r25 == null) goto L77;
        Function0 r112 = r25.f;
    L78:
        if (r25 == null) goto L80;
        Integer r113 = r25.b;
    L81:
        if (r25 == null) goto L83;
        Map r114 = r25.c;
    L84:
        if (r25 == null) goto L86;
        Function0 r31 = r25.d;
    L87:
        if (r25 == null) goto L89;
        xm.c r32 = r25.e;
    L90:
        int r115 = ECScrollTagListView.h;
        ShoppingAsyncInflater.a r116 = ShoppingAsyncInflater.e;
        Context r117 = r26.getContext();
        r116.getClass();
        ShoppingAsyncInflater.a.a(r117).aU(2131560956, r26, true);
        wg.a.i(r26.findViewById(2131385231), ExtensionsKt.a(Integer.valueOf(com.bytedance.android.shopping.extensions.k.g(r110, 0))));
        wg.a.i(r26.findViewById(2131385235), ExtensionsKt.a(Integer.valueOf(com.bytedance.android.shopping.extensions.k.g(r111, 0))));
        ECAutoScrollHorizontalScrollView r33 = r26.findViewById(2131371152);
        r26.d = r33;
        if (r33 == null) goto L96;
        r33.setOverScrollMode(2);
        ECAutoScrollHorizontalScrollView r34 = r26.d;
        if (r34 == null) goto L95;
        r34.setOnScrollChangeListener(r26.g);
    L95:
        r33.setOnMovedByHandListener(r112);
    L96:
        if (r29 == null) goto L100;
        int r35 = r29.intValue();
        ECAutoScrollHorizontalScrollView r36 = r26.d;
        if (r36 == null) goto L100;
        r36.setAutoScrollSpeed(r35);
    L100:
        if (r30 == null) goto L102;
        r30.longValue();
        r26.e = r30.longValue();
    L102:
        ECTagListView r37 = r26.findViewById(2131371153);
        if (r37 == null) goto L105;
        r37.setSubTagNeedClip(true);
    L106:
        r26.c = r37;
        ECTagListView r38 = r26.c;
        if (r38 == null) goto L109;
        r38.b(r19, r113, r114, r31, r32, null);
    L109:
        r26.f.postDelayed(new com.bytedance.android.ec.store.view.c(r26), r26.e);
        goto L111
    L105:
        r37 = null;
        goto L106
    L89:
        r32 = null;
        goto L90
    L86:
        r31 = null;
        goto L87
    L83:
        r114 = null;
        goto L84
    L80:
        r113 = null;
        goto L81
    L77:
        r112 = null;
        goto L78
    L73:
        r27 = null;
        goto L74
    L68:
        r25 = null;
    L111:
        ECScrollTagListView r39 = k1();
        if (r39 == null) goto L120;
        float r40 = this.M3;
        if (r39.getVisibility() != 0) goto L120;
        ECTagListView r41 = r39.c;
        if (r41 == null) goto L120;
        r41.k(r40);
    L51:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L54
    L44:
        r13 = false;
        goto L45
    }

    public final View n1(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new ECScrollTagListView(r5, null, 6, 0);
    }
}
