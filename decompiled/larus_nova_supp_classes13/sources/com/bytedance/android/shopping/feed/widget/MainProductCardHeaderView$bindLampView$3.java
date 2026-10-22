package com.bytedance.android.shopping.feed.widget;

import android.view.View;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final class MainProductCardHeaderView$bindLampView$3 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Function3 $detailOnClickListener;
    final /* synthetic */ PromotionProductStruct $promotion;
    final /* synthetic */ MainProductCardHeaderView this$0;

    public MainProductCardHeaderView$bindLampView$3(MainProductCardHeaderView r1, PromotionProductStruct r2, Function3 r3) {
        this.this$0 = r1;
        this.$promotion = r2;
        this.$detailOnClickListener = r3;
        super(1);
    }

    public final void invoke(View r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        if (this.$promotion == null) goto L6;
        this.$detailOnClickListener.invoke(this.this$0, "click", "pic");
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
