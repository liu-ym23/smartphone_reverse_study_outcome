package com.ss.android.ugc.aweme.discover.model.commodity.coupon;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponIndustry;", "Ljava/io/Serializable;", "()V", "actionButton", "Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponActionButton;", "getActionButton", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponActionButton;", "background", "", "getBackground", "()Ljava/lang/String;", RXScreenCaptureService.KEY_CONTENT_TEXT, "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponText;", "getContentText", "()Ljava/util/List;", "couponType", "getCouponType", "dataId", "getDataId", "endTime", "", "getEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "headIcon", "Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponActionIcon;", "getHeadIcon", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponActionIcon;", "headText", "getHeadText", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/coupon/CouponText;", "rebackParams", "", "getRebackParams", "()Ljava/util/Map;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponIndustry implements Serializable {

    @SerializedName("action_button")
    private final CouponActionButton actionButton;

    @SerializedName("background")
    private final String background;

    @SerializedName("content_text")
    private final List<CouponText> contentText;

    @SerializedName(a.KEY_COUPON_TYPE)
    private final String couponType;

    @SerializedName("data_id")
    private final String dataId;

    @SerializedName("end_time")
    private final Long endTime;

    @SerializedName("head_icon")
    private final CouponActionIcon headIcon;

    @SerializedName("head_text")
    private final CouponText headText;

    @SerializedName("reback_params")
    private final Map<String, String> rebackParams;

    public CouponIndustry() {
    }

    public final CouponActionButton getActionButton() {
        return this.actionButton;
    }

    public final String getBackground() {
        return this.background;
    }

    public final List<CouponText> getContentText() {
        return this.contentText;
    }

    public final String getCouponType() {
        return this.couponType;
    }

    public final String getDataId() {
        return this.dataId;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final CouponActionIcon getHeadIcon() {
        return this.headIcon;
    }

    public final CouponText getHeadText() {
        return this.headText;
    }

    public final Map<String, String> getRebackParams() {
        return this.rebackParams;
    }
}
