package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR \u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECShopShareInfoModuleDTO;", "Ljava/io/Serializable;", "()V", "animationStyle", "", "getAnimationStyle", "()Ljava/lang/Integer;", "setAnimationStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "bubbleDismissTime", "", "getBubbleDismissTime", "()Ljava/lang/Long;", "setBubbleDismissTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "bubbleMaxShowTimes", "getBubbleMaxShowTimes", "setBubbleMaxShowTimes", "bubbleText", "", "getBubbleText", "()Ljava/lang/String;", "setBubbleText", "(Ljava/lang/String;)V", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "shareQrCodeStyle", "getShareQrCodeStyle", "setShareQrCodeStyle", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopShareInfoModuleDTO implements Serializable {

    @SerializedName("animation_style")
    private Integer animationStyle;

    @SerializedName("bubble_dismiss_time")
    private Long bubbleDismissTime;

    @SerializedName("bubble_max_show_times")
    private Long bubbleMaxShowTimes;

    @SerializedName("bubble_text")
    private String bubbleText;

    @SerializedName("icon")
    private ECUrlModel icon;

    @SerializedName("share_qr_code_style")
    private Integer shareQrCodeStyle;

    public ECShopShareInfoModuleDTO() {
    }

    public final Integer getAnimationStyle() {
        return this.animationStyle;
    }

    public final Long getBubbleDismissTime() {
        return this.bubbleDismissTime;
    }

    public final Long getBubbleMaxShowTimes() {
        return this.bubbleMaxShowTimes;
    }

    public final String getBubbleText() {
        return this.bubbleText;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final Integer getShareQrCodeStyle() {
        return this.shareQrCodeStyle;
    }

    public final void setAnimationStyle(Integer r1) {
        this.animationStyle = r1;
    }

    public final void setBubbleDismissTime(Long r1) {
        this.bubbleDismissTime = r1;
    }

    public final void setBubbleMaxShowTimes(Long r1) {
        this.bubbleMaxShowTimes = r1;
    }

    public final void setBubbleText(String r1) {
        this.bubbleText = r1;
    }

    public final void setIcon(ECUrlModel r1) {
        this.icon = r1;
    }

    public final void setShareQrCodeStyle(Integer r1) {
        this.shareQrCodeStyle = r1;
    }
}
