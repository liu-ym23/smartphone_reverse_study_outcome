package xi2;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.common.data.DataHolder;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class l {

    @SerializedName("avatar")
    public String avatar;

    @SerializedName("can_continue_apply")
    public boolean canApply;

    @SerializedName("channel_id")
    public int channelId;

    @SerializedName("coupon_meta_id")
    public String couponMetaId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COUPON_NAME)
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

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW)
    public int isShow;

    @SerializedName("kol_uid")
    public long kolUid;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_KOL_USER_TAG)
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

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    public String shopId;

    @SerializedName("shop_logo")
    public String shopLogo;

    @SerializedName("shop_name")
    public String shopName;

    @SerializedName("start_apply_time")
    public String startApplyTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    public String startTime;

    @SerializedName("start_time_timestamp")
    public long startTimeStamp;

    @SerializedName("status")
    public int status;

    @SerializedName("threshold")
    public int threshold;

    @SerializedName("total_amount")
    public int totalAmount;

    @SerializedName("type")
    public int type;

    @SerializedName("type_detail")
    public String typeDetail;

    @SerializedName("type_icon")
    public String typeIcon;

    @SerializedName("type_icon_height")
    public long typeIconHeight;

    @SerializedName("type_icon_width")
    public long typeIconWidth;

    @SerializedName(DataHolder.TYPE_STRING)
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
