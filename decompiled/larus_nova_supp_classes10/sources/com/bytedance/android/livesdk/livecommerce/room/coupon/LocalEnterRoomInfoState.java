package com.bytedance.android.livesdk.livecommerce.room.coupon;

import com.bytedance.android.ec.model.response.LocalApplyCouponState;
import com.bytedance.android.ec.model.response.LocalIconState;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/coupon/LocalEnterRoomInfoState;", "Ljava/io/Serializable;", "()V", "applyCoupon", "Lcom/bytedance/android/ec/model/response/LocalApplyCouponState;", "getApplyCoupon", "()Lcom/bytedance/android/ec/model/response/LocalApplyCouponState;", "setApplyCoupon", "(Lcom/bytedance/android/ec/model/response/LocalApplyCouponState;)V", "iconMap", "", "", "Lcom/bytedance/android/ec/model/response/LocalIconState;", "getIconMap", "()Ljava/util/Map;", "setIconMap", "(Ljava/util/Map;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LocalEnterRoomInfoState implements Serializable {

    @SerializedName("apply_coupon")
    private LocalApplyCouponState applyCoupon;

    @SerializedName("icons")
    private Map<String, LocalIconState> iconMap;

    public LocalEnterRoomInfoState() {
    }

    public final LocalApplyCouponState getApplyCoupon() {
        return this.applyCoupon;
    }

    public final Map<String, LocalIconState> getIconMap() {
        return this.iconMap;
    }

    public final void setApplyCoupon(LocalApplyCouponState r1) {
        this.applyCoupon = r1;
    }

    public final void setIconMap(Map<String, LocalIconState> r1) {
        this.iconMap = r1;
    }
}
