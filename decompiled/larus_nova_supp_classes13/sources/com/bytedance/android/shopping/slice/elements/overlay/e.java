package com.bytedance.android.shopping.slice.elements.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.extensions.j;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends LinearLayout {
    public e(Context r18, List r19, com.bytedance.android.ecom.arch.slice.render.context.b r20) {
        Intrinsics.checkNotNullParameter(r20, "slcDisplayMetrics");
        super(r18, null, 0);
        RoundingParams r3 = new RoundingParams();
        r3.setCornersRadius(SlcDimensExtensionsKt.c(4, r20));
        GenericDraweeHierarchyBuilder r5 = new GenericDraweeHierarchyBuilder(getResources());
        Iterator r6 = r19.iterator();
        int r7 = 0;
    L4:
        if (r6.hasNext() == false) goto L32;
        Object r8 = r6.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        d r10 = (d) r8;
        if (r7 != (r19.size() - 1)) goto L11;
        boolean r11 = true;
    L12:
        b r12 = r10.b;
        if (r12 == null) goto L25;
        if (r18 == null) goto L25;
        a r13 = new a(r18);
        SimpleDraweeView r14 = r13.getSkuImgView();
        if (r14 == null) goto L18;
        r14.setImageURI(r12.a);
    L18:
        ViewGroup.MarginLayoutParams r15 = new ViewGroup.MarginLayoutParams(SlcDimensExtensionsKt.a(Integer.valueOf(r12.b), r20), SlcDimensExtensionsKt.a(Integer.valueOf(r12.c), r20));
        if (r11 == true) goto L21;
        r15.rightMargin = SlcDimensExtensionsKt.a(8, r20);
    L21:
        SimpleDraweeView r16 = r13.getSkuImgView();
        if (r16 == null) goto L24;
        GenericDraweeHierarchy r17 = r5.build();
        r17.setRoundingParams(r3);
        Unit r110 = Unit.INSTANCE;
        r16.setHierarchy(r17);
    L24:
        r13.setLayoutParams(r15);
        Unit r111 = Unit.INSTANCE;
        addView(r13);
    L25:
        String r21 = r10.a;
        if (r21 == null) goto L31;
        ViewGroup.MarginLayoutParams r112 = new ViewGroup.MarginLayoutParams(-2, -2);
        if (r11 == true) goto L30;
        r112.rightMargin = SlcDimensExtensionsKt.a(8, r20);
    L30:
        TextView r22 = new TextView(r18);
        r22.setBackgroundResource(2131231287);
        r22.setSingleLine(true);
        r22.setPadding(SlcDimensExtensionsKt.a(9, r20), SlcDimensExtensionsKt.a(5, r20), SlcDimensExtensionsKt.a(9, r20), SlcDimensExtensionsKt.a(5, r20));
        r22.setTextColor(j.b(2131106172));
        r22.setTextSize(2, 12.0f);
        r22.setText(r21);
        r22.setGravity(17);
        r22.setLayoutParams(r112);
        Unit r23 = Unit.INSTANCE;
        addView(r22);
    L31:
        r7 = r9;
        goto L4
    L11:
        r11 = false;
        goto L12
    }
}
