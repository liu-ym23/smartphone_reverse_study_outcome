package com.bytedance.android.shopping.card_list.slice.viewmanagers;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.card_list.slice.widgets.BottomButtonContainerView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends BaseSlcViewManager<BottomButtonContainerView> {
    public final SlcTemplateContext H3;

    public b(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "slcTemplateContext");
        super(r2);
        this.H3 = r2;
    }

    public final View A0(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new BottomButtonContainerView(r3, this.H3);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [android.widget.LinearLayout, com.bytedance.android.shopping.card_list.slice.widgets.BottomButtonContainerView, java.lang.Object] */
    public final void H0(Map<String, ? extends Object> r22) {
        Intrinsics.checkNotNullParameter(r22, "props");
        Object r0 = r22.get("bottom_buttons");
        if ((r0 instanceof List) == true) goto L5;
        r0 = null;
    L5:
        List r1 = (List) r0;
        ?? r2 = (BottomButtonContainerView) getView();
        com.bytedance.android.ecom.arch.slice.render.context.b r11 = ((BaseSlcViewManager) this).a.w.f;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r11, "displayMetrics");
        r2.removeAllViews();
        if (r1 == null) goto L78;
        Iterator r12 = r1.iterator();
    L9:
        if (r12.hasNext() == false) goto L82;
        Map r3 = (Map) r12.next();
        if (r3 == null) goto L13;
        Object r4 = r3.get("text");
    L15:
        if ((r4 instanceof String) == true) goto L17;
        r4 = null;
    L17:
        String r5 = (String) r4;
        if (r3 == null) goto L20;
        Object r6 = r3.get("fontSize");
    L22:
        if ((r6 instanceof Float) == true) goto L24;
        r6 = null;
    L24:
        Float r7 = (Float) r6;
        if (r3 == null) goto L27;
        Object r8 = r3.get("bold");
    L29:
        if ((r8 instanceof Integer) == true) goto L31;
        r8 = null;
    L31:
        Integer r9 = (Integer) r8;
        if (r3 == null) goto L34;
        Object r10 = r3.get("color");
    L36:
        if ((r10 instanceof String) == true) goto L38;
        r10 = null;
    L38:
        String r13 = (String) r10;
        if (r3 == null) goto L41;
        Object r14 = r3.get("bg");
    L43:
        if ((r14 instanceof String) == true) goto L45;
        r14 = null;
    L45:
        String r15 = (String) r14;
        if (r3 == null) goto L48;
        Object r16 = r3.get("url");
    L50:
        if ((r16 instanceof String) == true) goto L52;
        r16 = null;
    L52:
        String r17 = (String) r16;
        if (r3 == null) goto L55;
        Object r18 = r3.get("key");
    L57:
        if ((r18 instanceof String) == true) goto L59;
        r18 = null;
    L59:
        String r19 = (String) r18;
        LinearLayout r20 = new LinearLayout(r2.getContext());
        r20.setOrientation(1);
        r20.setLayoutParams(new LinearLayout.LayoutParams(SlcDimensExtensionsKt.a(Integer.valueOf(r2.b), r11), -1));
        Integer r21 = s.b(r15);
        if (r21 == null) goto L62;
        r20.setBackgroundColor(r21.intValue());
    L62:
        ECDraweeView r23 = new ECDraweeView(r20.getContext(), null, 0, 6, null);
        r23.setId(2131374718);
        r23.setLayoutParams(new LinearLayout.LayoutParams(SlcDimensExtensionsKt.a(20, r11), SlcDimensExtensionsKt.a(20, r11)));
        r20.setGravity(17);
        d2.d(r23, 0, 0, 0, SlcDimensExtensionsKt.a(2, r11));
        h0.e(r23, r17, null, null, null, 120);
        TextView r110 = new TextView(r20.getContext());
        r110.setId(2131388772);
        r110.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r110.setText(r5);
        Integer r24 = s.b(r13);
        if (r24 == null) goto L65;
        r110.setTextColor(r24.intValue());
    L65:
        if (r7 == null) goto L67;
        float r25 = SlcDimensExtensionsKt.e(r7, r11);
    L68:
        r110.setTextSize(0, r25);
        r110.setGravity(17);
        if (r9 != null) goto L72;
    L73:
        if (r9 == null) goto L76;
        int r26 = r9.intValue();
    L77:
        ViewExtensionsKt.e(r110, r110.getPaint(), r26);
        r20.addView(r23);
        r20.addView(r110);
        r20.setOnClickListener(new com.bytedance.android.shopping.card_list.slice.widgets.a(r20, r15, r19, r2, r11, r1));
        r2.addView(r20);
    L76:
        r26 = 500;
        goto L77
    L72:
        if (r9.intValue() == 0) goto L76;
    L67:
        r25 = SlcDimensExtensionsKt.e(14, r11);
        goto L68
    L55:
        r18 = null;
        goto L57
    L48:
        r16 = null;
        goto L50
    L41:
        r14 = null;
        goto L43
    L34:
        r10 = null;
        goto L36
    L27:
        r8 = null;
        goto L29
    L20:
        r6 = null;
        goto L22
    L13:
        r4 = null;
        goto L15
    L82:
        return;
    }
}
