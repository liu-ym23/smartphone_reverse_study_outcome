package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.AnchorV4SimpleLinkView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.b<h83.d> {
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.j
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.m g(com.bytedance.android.shopping.anchorv4.voavhs.head.c r8) {
        Intrinsics.checkNotNullParameter(r8, "nodeVO");
        return new h83.d(r8.p, r8.b, r8.d, r8.e, r8.u);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final View w(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r7) {
        final h83.d r8 = (h83.d) r7;
        ViewGroup.LayoutParams r2 = null;
        AnchorV4SimpleLinkView r0 = new AnchorV4SimpleLinkView(getContext(), null, 6, 0);
        if (r8 == null) goto L5;
        ECUrlModel r1 = r8.c;
    L6:
        if (r8 == null) goto L8;
        String r3 = r8.e;
    L9:
        Function0<Unit> r5 = new SimpleLinkHolderBuilder$layerView$1(this, r8);
        Intrinsics.checkNotNullParameter(r5, "clickListener");
        if (r1 == null) goto L28;
        SimpleDraweeView r9 = r0.a;
        if (r9 == null) goto L14;
        r9.setVisibility(0);
    L14:
        y.a(r0.a, r1);
        SimpleDraweeView r10 = r0.a;
        if (r10 == null) goto L21;
        ViewGroup.LayoutParams r4 = r10.getLayoutParams();
        if (r4 == null) goto L19;
        r4.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r1.getWidth()));
        r4.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r1.getHeight()));
        Unit r6 = Unit.INSTANCE;
        r2 = r4;
    L19:
        r10.setLayoutParams(r2);
    L21:
        if (com.bytedance.android.ec.core.utils.a.c() == true) goto L25;
        SimpleDraweeView r11 = r0.a;
        if (r11 == null) goto L31;
        r11.setOnClickListener(new com.bytedance.android.shopping.anchorv4.voavhs.head.view.h(r5));
    L31:
        return r0;
    L25:
        ((FrameLayout) r0.findViewById(2131384822)).setOnClickListener(new com.bytedance.android.shopping.anchorv4.voavhs.head.view.i(r5));
        if (r3 == null) goto L31;
        ((FrameLayout) r0.findViewById(2131384822)).setContentDescription(r3);
        goto L31
    L28:
        SimpleDraweeView r12 = r0.a;
        if (r12 == null) goto L31;
        r12.setVisibility(8);
        Unit r13 = Unit.INSTANCE;
        goto L31
    L8:
        r3 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public n(Context r2, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
