package si2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lsi2/u;", "", "", "shareCouponUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setShareCouponUrl", "(Ljava/lang/String;)V", "auctionResultUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAuctionResultUrl", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("live_commerce_auction_result_url")
    private String auctionResultUrl;

    @SerializedName("live_commerce_fission_coupon_result_url")
    private String shareCouponUrl;

    public u() {
        this.shareCouponUrl = "sslocal://webcast_lynxview?type=popup&gravity=center&width_percent=100&height_percent=100&load_taro=0&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_lynx_commerce_fission_coupon%2Fresult_panel%2Ftemplate.js?";
        this.auctionResultUrl = "sslocal://webcast_lynxview?type=popup&gravity=center&width_percent=100&height_percent=100&load_taro=0&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fecom%2Flynx%2Ffe_lynx_commerce_ecom_auction%2Fresult_panel%2Ftemplate.js";
    }

    public final String a() {
        return this.auctionResultUrl;
    }

    public final String b() {
        return this.shareCouponUrl;
    }
}
