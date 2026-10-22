package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class MainFeedInitializer$initRecyclerView$4 extends FunctionReferenceImpl implements Function1<View, Boolean> {
    public MainFeedInitializer$initRecyclerView$4(d r8) {
        super(1, r8, d.class, "needDecoration", "needDecoration(Landroid/view/View;)Z", 0);
    }

    public final boolean invoke(View r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        d r0 = (d) ((CallableReference) this).receiver;
        int r1 = r0.k.getChildAdapterPosition(r6);
        if (r1 < 0) goto L38;
        ProductDetailInfoAdapter r2 = r0.a;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L8:
        if (r1 >= r2.getItemCount()) goto L38;
        ProductDetailInfoAdapter r3 = r0.a;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L12:
        com.bytedance.android.shopping.anchorv4.dto.business.a r4 = null;
        com.bytedance.android.ecom.arch.slice.adapter.b r5 = (com.bytedance.android.ecom.arch.slice.adapter.b) DiffableAdapter.DefaultImpls.getItem$default(r3, r1, false, 2, null);
        if ((r5 instanceof com.bytedance.android.shopping.anchorv4.voavhs.lynx.a) == true) goto L15;
        com.bytedance.android.ecom.arch.slice.adapter.b r7 = null;
    L16:
        com.bytedance.android.shopping.anchorv4.voavhs.lynx.a r8 = (com.bytedance.android.shopping.anchorv4.voavhs.lynx.a) r7;
        if (r8 == null) goto L19;
        com.bytedance.android.shopping.anchorv4.dto.business.a r9 = r8.g;
    L20:
        if (r9 == null) goto L22;
        return false;
    L22:
        if ((r5 instanceof com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice.c) == true) goto L24;
        com.bytedance.android.ecom.arch.slice.adapter.b r10 = null;
    L25:
        com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice.c r11 = (com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice.c) r10;
        if (r11 == null) goto L28;
        com.bytedance.android.shopping.anchorv4.dto.business.a r12 = r11.e;
    L29:
        if (r12 == null) goto L31;
        return false;
    L31:
        if ((r5 instanceof com.bytedance.android.shopping.anchorv4.voavhs.car.b) == true) goto L33;
        r5 = null;
    L33:
        com.bytedance.android.shopping.anchorv4.voavhs.car.b r13 = (com.bytedance.android.shopping.anchorv4.voavhs.car.b) r5;
        if (r13 == null) goto L36;
        r4 = r13.e;
    L36:
        if (r4 == null) goto L38;
        return false;
    L28:
        r12 = null;
        goto L29
    L24:
        r10 = r5;
        goto L25
    L19:
        r9 = null;
        goto L20
    L15:
        r7 = r5;
    L38:
        StaggeredGridDoubleColumnDecoration.g.getClass();
        return StaggeredGridDoubleColumnDecoration.a.a(r6);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((View) r1));
    }
}
