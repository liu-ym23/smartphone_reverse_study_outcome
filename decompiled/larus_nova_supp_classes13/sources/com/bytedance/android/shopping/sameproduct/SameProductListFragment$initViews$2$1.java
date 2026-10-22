package com.bytedance.android.shopping.sameproduct;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class SameProductListFragment$initViews$2$1 extends FunctionReferenceImpl implements Function1<View, Boolean> {
    public SameProductListFragment$initViews$2$1(StaggeredGridDoubleColumnDecoration.a r8) {
        super(1, r8, StaggeredGridDoubleColumnDecoration.a.class, "needDecoration", "needDecoration(Landroid/view/View;)Z", 0);
    }

    public final boolean invoke(View r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((StaggeredGridDoubleColumnDecoration.a) ((CallableReference) this).receiver).getClass();
        return StaggeredGridDoubleColumnDecoration.a.a(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((View) r1));
    }
}
