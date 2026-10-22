package com.bytedance.android.shopping.deepfeed.weights;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "text", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DeepFeedAiContainerView$checkViewState$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ InFeedProductV2 $data;
    final /* synthetic */ com.bytedance.android.shopping.deepfeed.action.i $parentAbility;

    public DeepFeedAiContainerView$checkViewState$1(com.bytedance.android.shopping.deepfeed.action.i r1, InFeedProductV2 r2) {
        this.$parentAbility = r1;
        this.$data = r2;
        super(1);
    }

    public final void invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        if (this.$parentAbility.isCardVisible() == true) goto L5;
        return;
    L5:
        if (this.$data.getDynamicData().m.contains(r2) == true) goto L9;
        this.$parentAbility.T2(r2);
        this.$data.getDynamicData().m.add(r2);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
