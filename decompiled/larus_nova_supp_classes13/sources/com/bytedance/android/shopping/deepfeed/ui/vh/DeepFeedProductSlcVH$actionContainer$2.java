package com.bytedance.android.shopping.deepfeed.ui.vh;

import com.bytedance.android.shopping.deepfeed.slice.DeepFeedSlcCardContainer;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/shopping/deepfeed/slice/DeepFeedSlcCardContainer;", "invoke"}, k = 3, mv = {1, 4, 3})
final class DeepFeedProductSlcVH$actionContainer$2 extends Lambda implements Function0<DeepFeedSlcCardContainer> {
    final /* synthetic */ DeepFeedProductSlcVH this$0;

    public DeepFeedProductSlcVH$actionContainer$2(DeepFeedProductSlcVH r1) {
        this.this$0 = r1;
        super(0);
    }

    public final DeepFeedSlcCardContainer invoke() {
        DeepFeedProductSlcVH r1 = this.this$0;
        DeepFeedProductViewModel r2 = r1.i4();
        this.this$0.getClass();
        return new DeepFeedSlcCardContainer(r1, r2, null);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m817invoke() {
        return invoke();
    }
}
