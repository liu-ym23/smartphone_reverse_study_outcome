package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.content.Context;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.ScrollMoreText;
import com.bytedance.android.shopping.anchorv4.voavhs.head.sku.SkuImageAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.b<h83.f> {
    public ViewPager i;
    public List<String> j;
    public final int k;
    public int l;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b, com.bytedance.android.shopping.anchorv4.voavhs.head.base.n
    public final boolean n() {
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.j
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.m g(com.bytedance.android.shopping.anchorv4.voavhs.head.c r8) {
        Intrinsics.checkNotNullParameter(r8, "nodeVO");
        List<ECUrlModel> r1 = r8.x;
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        List<ECUrlModel> r2 = r1;
        List<String> r3 = r8.y;
        if (r3 != null) goto L8;
        r3 = CollectionsKt.emptyList();
    L8:
        List<String> r4 = r3;
        ScrollMoreText r5 = r8.t;
        boolean r6 = r8.v;
        List<String> r9 = r8.z;
        if (r9 != null) goto L12;
        r9 = CollectionsKt.emptyList();
    L12:
        return new h83.f(r2, r4, r5, r6, r9);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final void y(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r3) {
        final h83.f r4 = (h83.f) r3;
        Intrinsics.checkNotNullParameter(r4, "nodeVO");
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r0 = this.g;
        if (r0 != null) goto L5;
    L9:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r1 = this.g;
        if (r1 == null) goto L15;
        g83.a r2 = r1.q();
        if (r2 == null) goto L16;
        r2.b(new SkuSpecBuilder$logicDoneBeforeRenderView$1(this, r4));
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (r0.m() != true) goto L9;
        if (r4.d == true) goto L9;
    }

    public p(Context r2, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.k = k1.n(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final List v(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r18, Function0 r19) {
        h83.f r0 = (h83.f) r18;
        Intrinsics.checkNotNullParameter(r19, "rootView");
        if (r0 == null) goto L18;
        List<ECUrlModel> r1 = r0.a;
        if (r1 == null) goto L18;
        List<ECUrlModel> r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
        int r5 = 0;
    L8:
        if (r4.hasNext() == false) goto L22;
        Object r6 = r4.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        ECUrlModel r8 = (ECUrlModel) r6;
        List<String> r9 = r0.b;
        if (r9 == null) goto L15;
        String r10 = (String) CollectionsKt.getOrNull(r9, r5);
    L16:
        r3.add(new com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f(null, r8, r10, null, (String) CollectionsKt.getOrNull(r0.e, r5), null, false, null, null, 2009));
        r5 = r7;
        goto L8
    L15:
        r10 = null;
        goto L16
    L22:
        return r3;
    L18:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final View x(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r10, final Integer r11, int r12) {
        final h83.f r13 = (h83.f) r10;
        ScrollMoreText r14 = null;
        if (r13 == null) goto L5;
        List<String> r0 = r13.b;
    L6:
        this.j = r0;
        o r1 = new o(this, r13);
        Intrinsics.checkNotNullParameter(r1, "listener");
        ((ArrayList) this.a).add(r1);
        final ViewPager r2 = new ViewPager(getContext());
        if (r13 == null) goto L10;
        List<ECUrlModel> r3 = r13.a;
        if (r3 == null) goto L10;
    L11:
        List<ECUrlModel> r4 = r3;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.i r5 = u(r13, r11);
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r6 = this.g;
        if (r13 == null) goto L14;
        r14 = r13.c;
    L14:
        ScrollMoreText r7 = r14;
        if (r6 == null) goto L19;
        boolean r8 = true;
        if (r6.n() != true) goto L19;
    L20:
        r2.setAdapter(new SkuImageAdapter(r4, (com.bytedance.android.shopping.anchorv4.voavhs.head.base.c) r5, r6, r7, r8, new SkuSpecBuilder$layerView$$inlined$apply$lambda$1(this, r13, r11)));
        r2.addOnPageChangeListener(new SkuSpecBuilder$layerView$$inlined$apply$lambda$2(r2, this, r13));
        PagerAdapter r9 = r2.getAdapter();
        if (r9 == null) goto L23;
        int r15 = r9.getCount();
    L24:
        int r16 = this.l;
        if (r16 < 0) goto L30;
        if (r15 <= r16) goto L30;
        r2.setCurrentItem(r16, false);
    L30:
        if (com.bytedance.android.shopping.anchorv4.voavhs.head.j.a() == true) goto L36;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r17 = this.g;
        if (r17 == null) goto L36;
        g83.a r18 = r17.q();
        if (r18 == null) goto L36;
        r18.b(new SkuSpecBuilder$layerView$$inlined$apply$lambda$3(r2, this, r13, r11));
    L36:
        Unit r19 = Unit.INSTANCE;
        this.i = r2;
        return r2;
    L23:
        r15 = 0;
    L19:
        r8 = false;
    L10:
        r3 = CollectionsKt.emptyList();
        goto L11
    L5:
        r0 = null;
        goto L6
    }
}
