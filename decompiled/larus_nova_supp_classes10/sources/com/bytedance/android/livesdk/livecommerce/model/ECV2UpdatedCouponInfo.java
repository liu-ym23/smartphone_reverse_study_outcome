package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("live.UpdatedCouponInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UpdatedCouponInfo;", "", "()V", "couponApplet", "", "couponMetaId", "couponUrl", "isValid", "", LocationMonitorConst.TAG, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECV2UpdatedCouponInfo {

    @SerializedName("coupon_applet")
    public String couponApplet;

    @SerializedName("coupon_meta_id")
    public String couponMetaId;

    @SerializedName("coupon_url")
    public String couponUrl;

    @SerializedName(LocationMonitorConst.IS_VALID)
    public boolean isValid;

    @SerializedName(LocationMonitorConst.TAG)
    public String tag;

    public ECV2UpdatedCouponInfo() {
    }
}
