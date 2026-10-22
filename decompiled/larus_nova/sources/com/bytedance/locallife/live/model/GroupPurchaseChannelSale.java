package com.bytedance.locallife.live.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010\u001c\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\"\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017¨\u0006)"}, d2 = {"Lcom/bytedance/locallife/live/model/GroupPurchaseChannelSale;", "Ljava/io/Serializable;", "()V", "couponId", "", "getCouponId", "()Ljava/lang/String;", "setCouponId", "(Ljava/lang/String;)V", "couponName", "getCouponName", "setCouponName", "couponText", "getCouponText", "setCouponText", "couponType", "getCouponType", "setCouponType", "endTime", "", "getEndTime", "()Ljava/lang/Long;", "setEndTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "initQuantity", "getInitQuantity", "setInitQuantity", "leftQuantity", "getLeftQuantity", "setLeftQuantity", "postPrice", "", "getPostPrice", "()Ljava/lang/Integer;", "setPostPrice", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GroupPurchaseChannelSale implements Serializable {

    @SerializedName("coupon_id")
    private String couponId;

    @SerializedName(a.KEY_COUPON_NAME)
    private String couponName;

    @SerializedName("coupon_text")
    private String couponText;

    @SerializedName(a.KEY_COUPON_TYPE)
    private String couponType;

    @SerializedName("end_time")
    private Long endTime;

    @SerializedName("init_quantity")
    private Long initQuantity;

    @SerializedName("left_quantity")
    private Long leftQuantity;

    @SerializedName("post_price")
    private Integer postPrice;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private Long startTime;

    public GroupPurchaseChannelSale() {
    }

    public final String getCouponId() {
        return this.couponId;
    }

    public final String getCouponName() {
        return this.couponName;
    }

    public final String getCouponText() {
        return this.couponText;
    }

    public final String getCouponType() {
        return this.couponType;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final Long getInitQuantity() {
        return this.initQuantity;
    }

    public final Long getLeftQuantity() {
        return this.leftQuantity;
    }

    public final Integer getPostPrice() {
        return this.postPrice;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final void setCouponId(String r100) {
        this.couponId = r100;
    }

    public final void setCouponName(String r100) {
        this.couponName = r100;
    }

    public final void setCouponText(String r100) {
        this.couponText = r100;
    }

    public final void setCouponType(String r100) {
        this.couponType = r100;
    }

    public final void setEndTime(Long r100) {
        this.endTime = r100;
    }

    public final void setInitQuantity(Long r100) {
        this.initQuantity = r100;
    }

    public final void setLeftQuantity(Long r100) {
        this.leftQuantity = r100;
    }

    public final void setPostPrice(Integer r100) {
        this.postPrice = r100;
    }

    public final void setStartTime(Long r100) {
        this.startTime = r100;
    }
}
