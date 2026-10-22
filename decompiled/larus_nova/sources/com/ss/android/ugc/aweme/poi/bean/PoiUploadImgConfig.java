package com.ss.android.ugc.aweme.poi.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/bean/PoiUploadImgConfig;", "", "", "rewardTip", "Ljava/lang/String;", "getRewardTip", "()Ljava/lang/String;", "rewardIcon", "getRewardIcon", "subTitle", "getSubTitle", "exampleText", "getExampleText", "exampleUrl", "getExampleUrl", "ruleDescription", "getRuleDescription", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiUploadImgConfig {

    @SerializedName("example_text")
    private final String exampleText;

    @SerializedName("example_url")
    private final String exampleUrl;

    @SerializedName("reward_icon")
    private final String rewardIcon;

    @SerializedName("reward_tip")
    private final String rewardTip;

    @SerializedName("rule_description")
    private final String ruleDescription;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private final String subTitle;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiUploadImgConfig) == true) goto L8;
        return false;
    L8:
        PoiUploadImgConfig r101 = (PoiUploadImgConfig) r100;
        if (Intrinsics.areEqual(this.rewardTip, r101.rewardTip) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rewardIcon, r101.rewardIcon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.exampleText, r101.exampleText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.exampleUrl, r101.exampleUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ruleDescription, r101.ruleDescription) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.rewardTip;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.rewardIcon;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.subTitle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.exampleText;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.exampleUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.ruleDescription;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiUploadImgConfig(rewardTip=" + this.rewardTip + ", rewardIcon=" + this.rewardIcon + ", subTitle=" + this.subTitle + ", exampleText=" + this.exampleText + ", exampleUrl=" + this.exampleUrl + ", ruleDescription=" + this.ruleDescription + ')';
    }

    public PoiUploadImgConfig() {
        this.rewardTip = null;
        this.rewardIcon = null;
        this.subTitle = null;
        this.exampleText = null;
        this.exampleUrl = null;
        this.ruleDescription = null;
    }
}
