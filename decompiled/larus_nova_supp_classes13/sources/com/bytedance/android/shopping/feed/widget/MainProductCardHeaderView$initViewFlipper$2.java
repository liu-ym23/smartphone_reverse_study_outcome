package com.bytedance.android.shopping.feed.widget;

import android.view.ViewGroup;
import com.bytedance.android.shopping.feed.view.LampItemView;
import com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/shopping/feed/widget/MainProductCardHeaderView$initViewFlipper$2", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperAdapter;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MainProductCardHeaderView$initViewFlipper$2 extends ECViewFlipper.ECViewFlipperAdapter {
    public MainProductCardHeaderView$initViewFlipper$2() {
        throw null;
    }

    public final int getFlipperItemCount() {
        throw null;
    }

    public final void onBindViewFlipperHolder(ECViewFlipper.ECViewFlipperHolder r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "holder");
        throw null;
    }

    public final ECViewFlipper.ECViewFlipperHolder onCreateViewFlipperHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ECViewFlipper.ECViewFlipperHolder(new LampItemView(null, null, 6, 0));
    }
}
