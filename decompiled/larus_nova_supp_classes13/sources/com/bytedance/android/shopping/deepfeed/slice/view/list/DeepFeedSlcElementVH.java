package com.bytedance.android.shopping.deepfeed.slice.view.list;

import com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/list/DeepFeedSlcElementVH;", "Lcom/bytedance/android/shopping/deepfeed/slice/view/list/DeepFeedSlcListVH;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedSlcElementVH extends DeepFeedSlcListVH {
    public final SlcItemView a;

    public DeepFeedSlcElementVH(SlcItemView r2) {
        Intrinsics.checkNotNullParameter(r2, "itemRootView");
        super(r2);
        this.a = r2;
    }
}
