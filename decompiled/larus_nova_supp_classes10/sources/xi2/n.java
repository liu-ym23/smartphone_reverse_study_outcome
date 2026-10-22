package xi2;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class n extends com.bytedance.android.ec.model.g {

    @SerializedName("allow_set_coupons")
    public boolean allowSetCoupons;

    @SerializedName("coupon_explain")
    public String couponExplain;

    @SerializedName("coupon_metas")
    public List<l> couponList;

    @SerializedName("current_coupon_id")
    public String distributeId;

    @SerializedName("extra")
    public a extra;

    @SerializedName("has_more")
    public boolean hasMore;

    @SerializedName("page")
    public int page;

    public static class a {

        @SerializedName("coupon_bind_notice")
        public String couponBindNotice;

        @SerializedName("coupon_cipher_text")
        public String couponCipherText;

        @SerializedName("coupon_detail_notice")
        public String couponDetailNotice;

        @SerializedName("end_coupon_notice")
        public String endCouponNotice;

        @SerializedName("end_coupon_toast")
        public String endCouponToast;

        public a() {
        }
    }

    public n() {
    }
}
