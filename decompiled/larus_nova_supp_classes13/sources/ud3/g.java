package ud3;

import com.bytedance.android.shopping.feed.repository.api.AnchorV3Api;
import com.bytedance.android.shopping.feed.repository.dto.PromotionAutoApplyCouponRequestParam;
import com.bytedance.android.shopping.feed.repository.dto.PromotionAutoApplyCouponResponse;
import com.bytedance.jedi.model.fetcher.SimpleFetcher;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends SimpleFetcher<PromotionAutoApplyCouponRequestParam, PromotionAutoApplyCouponResponse> {
    public g() {
    }

    public final Observable g(Object r10) {
        PromotionAutoApplyCouponRequestParam r11 = (PromotionAutoApplyCouponRequestParam) r10;
        Intrinsics.checkNotNullParameter(r11, "req");
        AnchorV3Api.a.getClass();
        Intrinsics.checkNotNullParameter(r11, "param");
        AnchorV3Api r1 = AnchorV3Api.a.a;
        if (r1 == null) goto L6;
        Observable<PromotionAutoApplyCouponResponse> r12 = r1.applyCouponAuto(r11.getProductId(), r11.getShopId(), r11.getPrice(), r11.getMarketChannel(), r11.getAuthorId(), r11.getSecAuthorId());
        if (r12 == null) goto L6;
    L8:
        return r12.subscribeOn(Schedulers.io());
    L6:
        r12 = Observable.error(new Throwable());
        goto L8
    }
}
