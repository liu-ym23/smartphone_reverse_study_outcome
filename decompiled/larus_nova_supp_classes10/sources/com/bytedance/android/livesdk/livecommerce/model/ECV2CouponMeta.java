package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("live.CouponMetaInfoMessage")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2CouponMeta;", "", "()V", "avatar", "", "canContinueApply", "", "channelId", "", "couponMetaId", "couponName", "couponReset", "couponSource", "", "couponStatus", "couponString", "credit", "discount", "", "endApplyTime", "expireTime", "expireTimeStamp", "extraData", "hasApplied", "hasAvailableGoods", "isShow", "kolUid", "kolUserTag", "leftAmount", "liveCouponStatus", "maxApplyTimes", "maxDiscountLimit", "payType", "periodType", "platformSubType", "productIds", "", "shopId", "shopLogo", "shopName", "startApplyTime", "startTime", "startTimeStamp", "status", "threshold", "totalAmount", LocationMonitorConst.TYPE, "typeDetail", "typeString", "typeTitle", "url", "userApplyTimes", "validPeriod", "whatCoupon", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECV2CouponMeta {

    @SerializedName("avatar")
    public String avatar;

    @SerializedName("can_continue_apply")
    public boolean canContinueApply;

    @SerializedName("channel_id")
    public long channelId;

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
    public long credit;

    @SerializedName("discount")
    public double discount;

    @SerializedName("end_apply_time")
    public String endApplyTime;

    @SerializedName("expire_time")
    public String expireTime;

    @SerializedName("expire_time_timestamp")
    public long expireTimeStamp;

    @SerializedName("extra_data")
    public String extraData;

    @SerializedName("has_applied")
    public long hasApplied;

    @SerializedName("has_available_goods")
    public boolean hasAvailableGoods;

    @SerializedName("is_show")
    public long isShow;

    @SerializedName("kol_uid")
    public long kolUid;

    @SerializedName("kol_user_tag")
    public long kolUserTag;

    @SerializedName("left_amount")
    public long leftAmount;

    @SerializedName("live_coupon_status")
    public int liveCouponStatus;

    @SerializedName("max_apply_times")
    public long maxApplyTimes;

    @SerializedName("max_discount_limit")
    public long maxDiscountLimit;

    @SerializedName("pay_type")
    public long payType;

    @SerializedName("period_type")
    public long periodType;

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
    public long status;

    @SerializedName("threshold")
    public long threshold;

    @SerializedName("total_amount")
    public long totalAmount;

    @SerializedName(LocationMonitorConst.TYPE)
    public long type;

    @SerializedName("type_detail")
    public String typeDetail;

    @SerializedName("type_string")
    public String typeString;

    @SerializedName("type_title")
    public String typeTitle;

    @SerializedName("url")
    public String url;

    @SerializedName("user_apply_times")
    public long userApplyTimes;

    @SerializedName("valid_period")
    public long validPeriod;

    @SerializedName("what_coupon")
    public String whatCoupon;

    public ECV2CouponMeta() {
    }
}
