package com.bytedance.android.shopping.sameproduct;

import android.content.Context;
import com.bytedance.android.shopping.feed.event.c0;
import com.bytedance.android.shopping.sameproduct.adapter.SameProductListAdapter;
import com.bytedance.android.shopping.sameproduct.viewmodel.SameProductState;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import dh3.d;
import eh3.b;
import eh3.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/android/shopping/sameproduct/viewmodel/SameProductState;", "invoke"}, k = 3, mv = {1, 4, 3})
final class SameProductListFragment$notifyListChanged$1 extends Lambda implements Function1<SameProductState, Unit> {
    final /* synthetic */ SameProductListFragment this$0;

    public SameProductListFragment$notifyListChanged$1(SameProductListFragment r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(SameProductState r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        if ((!r6.a.isEmpty()) == false) goto L20;
        SameProductListAdapter r0 = this.this$0.u;
        if (r0 == null) goto L24;
        List<Object> r2 = r6.a;
        ArrayList r3 = new ArrayList();
        r3.add(new b());
        Unit r4 = Unit.INSTANCE;
        List r5 = CollectionsKt.plus(CollectionsKt.plus(r2, r3), r6.b);
        ArrayList r7 = new ArrayList();
        if (r6.b.isEmpty() == true) goto L9;
    L15:
        List r8 = CollectionsKt.plus(r5, r7);
        ArrayList r9 = new ArrayList();
        if (r6.g == false) goto L18;
        r9.add(new c());
    L18:
        r0.submitList(CollectionsKt.plus(r8, r9));
        goto L24
    L9:
        if (r6.d == true) goto L15;
        if (r6.f == true) goto L15;
        if (r6.e == true) goto L15;
        r7.add(new eh3.a());
    L24:
        SameProductListFragment r1 = this.this$0;
        int r10 = SameProductListFragment.w;
        if (r1.aa0().getHasFirstLoadedProductList() == false) goto L31;
        this.this$0.aa0().setHasFirstLoadedProductList(false);
        int r11 = d.a;
        Context r12 = this.this$0.getContext();
        boolean r13 = !r6.b.isEmpty();
        c0 r14 = new c0();
        if (r13 == true) goto L29;
        r14.d = 1;
    L29:
        Unit r15 = Unit.INSTANCE;
        d.c(r14, r12);
        return;
    L31:
        return;
    L20:
        if (r6.f == false) goto L24;
        SameProductListAdapter r16 = this.this$0.u;
        if (r16 == null) goto L24;
        ArrayList r17 = new ArrayList();
        r17.add(new c());
        Unit r18 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r17, "list");
        DiffableAdapter.DefaultImpls.submitList(r16, r17);
        goto L24
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((SameProductState) r1);
        return Unit.INSTANCE;
    }
}
