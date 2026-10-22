package xi2;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class l {

    @SerializedName("avatar")
    public String avatar;

    @SerializedName("can_continue_apply")
    public boolean canApply;

    @SerializedName("channel_id")
    public int channelId;

    @SerializedName("coupon_meta_id")
    public String couponMetaId;

    @SerializedName("coupon_name")
    public String couponName;

    @SerializedName("coupon_reset")
    public boolean couponReset;

    @SerializedName("coupon_source")
    public int couponSource;

    @SerializedName("coupon_status")
    public boolean couponStatus;

    @SerializedName("coupon_string")
    public String couponString;

    @SerializedName("credit")
    public int credit;

    @SerializedName("discount")
    public double discount;

    @SerializedName("end_apply_time")
    public String endApplyTime;

    @SerializedName("expire_time")
    public String expireTime;

    @SerializedName("expire_time_timestamp")
    public long expireTimeStamp;

    @SerializedName("has_applied")
    public int hasApplied;

    @SerializedName("has_available_goods")
    public boolean hasAvailableGoods;

    @SerializedName("is_show")
    public int isShow;

    @SerializedName("kol_uid")
    public long kolUid;

    @SerializedName("kol_user_tag")
    public long kolUserTag;

    @SerializedName("left_amount")
    public int leftAmount;

    @SerializedName("live_coupon_status")
    public int liveCouponStatus;

    @SerializedName("max_apply_times")
    public int maxApplyTimes;

    @SerializedName("max_discount_limit")
    public int maxDiscountLimit;

    @SerializedName("pay_type")
    public int payType;

    @SerializedName("period_type")
    public int periodType;

    @SerializedName("platform_sub_type")
    public long platformSubType;

    @SerializedName("product_ids")
    public List<Long> productIds;

    @SerializedName("shop_id")
    public String shopId;

    @SerializedName("shop_logo")
    public String shopLogo;

    @SerializedName("shop_name")
    public String shopName;

    @SerializedName("start_apply_time")
    public String startApplyTime;

    @SerializedName("start_time")
    public String startTime;

    @SerializedName("start_time_timestamp")
    public long startTimeStamp;

    @SerializedName("status")
    public int status;

    @SerializedName("threshold")
    public int threshold;

    @SerializedName("total_amount")
    public int totalAmount;

    @SerializedName(LocationMonitorConst.TYPE)
    public int type;

    @SerializedName("type_detail")
    public String typeDetail;

    @SerializedName("type_icon")
    public String typeIcon;

    @SerializedName("type_icon_height")
    public long typeIconHeight;

    @SerializedName("type_icon_width")
    public long typeIconWidth;

    @SerializedName("type_string")
    public String typeString;

    @SerializedName("type_title")
    public String typeTitle;

    @SerializedName("url")
    public String url;

    @SerializedName("valid_period")
    public int validPeriod;

    @SerializedName("what_coupon")
    public String whatCoupon;

    public l() {
    }
}
