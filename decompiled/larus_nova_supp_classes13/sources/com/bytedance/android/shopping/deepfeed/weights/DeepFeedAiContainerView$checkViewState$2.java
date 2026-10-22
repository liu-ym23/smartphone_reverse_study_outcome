package com.bytedance.android.shopping.deepfeed.weights;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "text", "", "features", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DeepFeedAiContainerView$checkViewState$2 extends Lambda implements Function2<String, List<? extends String>, Unit> {
    final /* synthetic */ InFeedProductV2 $data;
    final /* synthetic */ com.bytedance.android.shopping.deepfeed.action.h $dfContext;
    final /* synthetic */ com.bytedance.android.shopping.deepfeed.action.i $parentAbility;
    final /* synthetic */ DeepFeedAiContainerView this$0;

    public DeepFeedAiContainerView$checkViewState$2(DeepFeedAiContainerView r1, com.bytedance.android.shopping.deepfeed.action.h r2, InFeedProductV2 r3, com.bytedance.android.shopping.deepfeed.action.i r4) {
        this.this$0 = r1;
        this.$dfContext = r2;
        this.$data = r3;
        this.$parentAbility = r4;
        super(2);
    }

    public final void invoke(String r4, List<String> r5) {
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.checkNotNullParameter(r5, "features");
        this.$dfContext.m();
        this.$parentAbility.z1(new com.bytedance.android.shopping.deepfeed.action.a.C0049a(r4, r5, true));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (List) r2);
        return Unit.INSTANCE;
    }
}
