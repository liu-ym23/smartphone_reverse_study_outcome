package com.bytedance.locallife.live.goodsshelves.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR \u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR \u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR \u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR \u0010+\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\"\u0010.\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R \u00105\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\b¨\u00068"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/TicketInfo;", "Ljava/io/Serializable;", "()V", "assignRecordId", "", "getAssignRecordId", "()Ljava/lang/String;", "setAssignRecordId", "(Ljava/lang/String;)V", "benefitId", "getBenefitId", "setBenefitId", "benefitType", "getBenefitType", "setBenefitType", "couponRule", "getCouponRule", "setCouponRule", "couponStatus", "", "getCouponStatus", "()Ljava/lang/Integer;", "setCouponStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "couponType", "getCouponType", "setCouponType", "couponTypeNumber", "getCouponTypeNumber", "setCouponTypeNumber", "idempotentId", "getIdempotentId", "setIdempotentId", "launchId", "getLaunchId", "setLaunchId", "launchIdV2", "getLaunchIdV2", "setLaunchIdV2", "launchType", "getLaunchType", "setLaunchType", "postTicketPrice", "getPostTicketPrice", "setPostTicketPrice", "supportAutoCollect", "", "getSupportAutoCollect", "()Ljava/lang/Boolean;", "setSupportAutoCollect", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "ticketMerchantId", "getTicketMerchantId", "setTicketMerchantId", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class TicketInfo implements Serializable {

    @SerializedName("assign_record_id")
    private String assignRecordId;

    @SerializedName("benefit_id")
    private String benefitId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_BENEFIT_TYPE)
    private String benefitType;

    @SerializedName("coupon_rule")
    private String couponRule;

    @SerializedName("coupon_status")
    private Integer couponStatus;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE)
    private String couponType;

    @SerializedName("coupon_type_number")
    private Integer couponTypeNumber;

    @SerializedName("idempotent_id")
    private String idempotentId;

    @SerializedName("launch_id")
    private String launchId;

    @SerializedName("launch_id_v2")
    private String launchIdV2;

    @SerializedName(BdpAppEventConstant.PARAMS_LAUNCH_TYPE)
    private String launchType;

    @SerializedName("post_ticket_price")
    private String postTicketPrice;

    @SerializedName("support_auto_collect")
    private Boolean supportAutoCollect;

    @SerializedName("ticket_merchant_id")
    private String ticketMerchantId;

    public TicketInfo() {
        this.supportAutoCollect = Boolean.FALSE;
        this.couponStatus = 3;
        this.couponTypeNumber = 0;
    }

    public final String getAssignRecordId() {
        return this.assignRecordId;
    }

    public final String getBenefitId() {
        return this.benefitId;
    }

    public final String getBenefitType() {
        return this.benefitType;
    }

    public final String getCouponRule() {
        return this.couponRule;
    }

    public final Integer getCouponStatus() {
        return this.couponStatus;
    }

    public final String getCouponType() {
        return this.couponType;
    }

    public final Integer getCouponTypeNumber() {
        return this.couponTypeNumber;
    }

    public final String getIdempotentId() {
        return this.idempotentId;
    }

    public final String getLaunchId() {
        return this.launchId;
    }

    public final String getLaunchIdV2() {
        return this.launchIdV2;
    }

    public final String getLaunchType() {
        return this.launchType;
    }

    public final String getPostTicketPrice() {
        return this.postTicketPrice;
    }

    public final Boolean getSupportAutoCollect() {
        return this.supportAutoCollect;
    }

    public final String getTicketMerchantId() {
        return this.ticketMerchantId;
    }

    public final void setAssignRecordId(String r100) {
        this.assignRecordId = r100;
    }

    public final void setBenefitId(String r100) {
        this.benefitId = r100;
    }

    public final void setBenefitType(String r100) {
        this.benefitType = r100;
    }

    public final void setCouponRule(String r100) {
        this.couponRule = r100;
    }

    public final void setCouponStatus(Integer r100) {
        this.couponStatus = r100;
    }

    public final void setCouponType(String r100) {
        this.couponType = r100;
    }

    public final void setCouponTypeNumber(Integer r100) {
        this.couponTypeNumber = r100;
    }

    public final void setIdempotentId(String r100) {
        this.idempotentId = r100;
    }

    public final void setLaunchId(String r100) {
        this.launchId = r100;
    }

    public final void setLaunchIdV2(String r100) {
        this.launchIdV2 = r100;
    }

    public final void setLaunchType(String r100) {
        this.launchType = r100;
    }

    public final void setPostTicketPrice(String r100) {
        this.postTicketPrice = r100;
    }

    public final void setSupportAutoCollect(Boolean r100) {
        this.supportAutoCollect = r100;
    }

    public final void setTicketMerchantId(String r100) {
        this.ticketMerchantId = r100;
    }
}
