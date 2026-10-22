package com.bytedance.android.shopping.prepurchase.business.pdp;

import com.bytedance.android.ec.model.live.LiveClearScreenMode;
import com.bytedance.android.ec.model.live.LiveScreenMoveMode;
import com.bytedance.android.ec.model.live.s;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/LiveProductDetailHalfFragmentV2;", "Lcom/bytedance/android/shopping/prepurchase/business/pdp/ProductDetailHalfFragmentV2;", "Lcom/bytedance/android/ec/model/live/s;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveProductDetailHalfFragmentV2 extends ProductDetailHalfFragmentV2 implements s {
    public LiveProductDetailHalfFragmentV2() {
    }

    public final LiveScreenMoveMode AC() {
        return LiveScreenMoveMode.LIVE_SCREEN_MOVE_UP;
    }

    public final LiveClearScreenMode cy() {
        return LiveClearScreenMode.CLEAR_SCREEN_MODE_FULL;
    }
}
