package n83;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.feed.view.InflowFeedCouponUrgeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface j {
    void a(PromotionProductCouponsStruct r1, AnchorV3Param r2);

    void b();

    InflowFeedCouponUrgeView i();

    void setCountDownFinishCallback(Function0<Unit> r1);
}
