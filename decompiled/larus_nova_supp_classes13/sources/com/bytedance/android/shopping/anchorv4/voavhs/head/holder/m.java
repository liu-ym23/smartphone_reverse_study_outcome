package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.TransSmallComponent;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.AnchorV4SizeView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.b<h83.e> {
    public AnchorV4SizeView i;
    public final Function0<Boolean> j;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.j
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.m g(com.bytedance.android.shopping.anchorv4.voavhs.head.c r3) {
        Intrinsics.checkNotNullParameter(r3, "nodeVO");
        return new h83.e(r3.b, r3.u);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b, com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void i(float r5) {
        if (com.bytedance.android.shopping.anchorv3.detail.utils.a.a() == false) goto L8;
        AnchorV4SizeView r0 = this.i;
        if (r0 == null) goto L9;
        int r1 = TransSmallComponent.r;
        int r2 = TransSmallComponent.Companion.a(r0.getContext());
        r0.a.post(new com.bytedance.android.shopping.anchorv4.voavhs.head.view.m(r0, r2 + ((k1.n(r0.getContext()) - r2) * r5)));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final View w(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r6) {
        h83.e r7 = (h83.e) r6;
        ECUrlModel r4 = null;
        AnchorV4SizeView r0 = new AnchorV4SizeView(getContext(), null, 6, 0);
        if (r7 == null) goto L5;
        r4 = r7.a;
    L5:
        Function0<Boolean> r8 = this.j;
        Intrinsics.checkNotNullParameter(r8, "smallModeQuery");
        if (r4 == null) goto L18;
        float r1 = r4.getHeight() / r4.getWidth();
        r0.c = r1;
        if (((Boolean) r8.invoke()).booleanValue() == false) goto L11;
        int r9 = TransSmallComponent.r;
        int r10 = TransSmallComponent.Companion.a(r0.getContext());
    L12:
        y.a(r0.a, r4);
        r0.a.post(new com.bytedance.android.shopping.anchorv4.voavhs.head.view.j(r0, r10, r1));
        if (r4.getWidth() != 0) goto L15;
    L17:
        r0.a.post(new com.bytedance.android.shopping.anchorv4.voavhs.head.view.l(r0));
        r0.b.setVisibility(8);
        goto L18
    L15:
        if (r1 <= 1.0f) goto L17;
        r0.b.post(new com.bytedance.android.shopping.anchorv4.voavhs.head.view.k(r0, r10));
        goto L18
    L11:
        r10 = k1.n(r0.getContext());
    L18:
        this.i = r0;
        return r0;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final List v(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r13, Function0 r14) {
        h83.e r15 = (h83.e) r13;
        Intrinsics.checkNotNullParameter(r14, "rootView");
        if (r15 == null) goto L5;
        ECUrlModel r3 = r15.a;
    L7:
        if (r15 == null) goto L9;
        String r7 = r15.b;
    L11:
        return CollectionsKt.listOf(new com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f(null, r3, null, null, null, r7, false, null, null, 1981));
    L9:
        r7 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public m(Context r2, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r3, Function0<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "smallModeQuery");
        super(r2, r3);
        this.j = r4;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final void z(Context r1, View r2, com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r3, int r4) {
        h83.e r5 = (h83.e) r3;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r5, "headNodeVO");
        String r6 = r5.b;
        if (r6 != null) goto L6;
        r6 = "图片，商品尺码";
    L6:
        r2.setContentDescription(r6);
    }
}
