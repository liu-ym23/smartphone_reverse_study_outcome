package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("live.CouponInfo")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2CouponInfo;", "", "", "metaId", "J", "serverTime", "countDown", "", "activity", "Ljava/lang/String;", "", "couponType", "I", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2CouponActivityData;", "activityData", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2CouponActivityData;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2CouponMeta;", "couponMeta", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2CouponMeta;", "metaIdString", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECV2CouponInfo {

    @SerializedName("activity_json_str")
    public String activity;

    @SerializedName("activity_info")
    public ECV2CouponActivityData activityData;

    @SerializedName("countdown")
    public long countDown;

    @SerializedName("coupon_meta")
    public ECV2CouponMeta couponMeta;

    @SerializedName("coupon_type")
    public int couponType;

    @SerializedName("meta_id")
    public long metaId;

    @SerializedName("meta_id_str")
    public String metaIdString;

    @SerializedName("server_time")
    public long serverTime;

    public ECV2CouponInfo() {
    }
}
