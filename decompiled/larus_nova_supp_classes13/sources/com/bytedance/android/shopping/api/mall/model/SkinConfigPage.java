package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfigPage;", "", "bgUrl", "", "bgUrlFold", "bgColor", "bgGradientConfig", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBgColor", "()Ljava/lang/String;", "getBgGradientConfig", "getBgUrl", "getBgUrlFold", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkinConfigPage {

    @SerializedName("bg_color")
    private final String bgColor;

    @SerializedName("bg_gradient_config")
    private final String bgGradientConfig;

    @SerializedName("bg_url")
    private final String bgUrl;

    @SerializedName("bg_url_fold")
    private final String bgUrlFold;

    public SkinConfigPage() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SkinConfigPage copy$default(SkinConfigPage r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.bgUrl;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.bgUrlFold;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.bgColor;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.bgGradientConfig;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.bgUrl;
    }

    public final String component2() {
        return this.bgUrlFold;
    }

    public final String component3() {
        return this.bgColor;
    }

    public final String component4() {
        return this.bgGradientConfig;
    }

    public final SkinConfigPage copy(String r2, String r3, String r4, String r5) {
        return new SkinConfigPage(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SkinConfigPage) == false) goto L14;
        SkinConfigPage r4 = (SkinConfigPage) r3;
        if (Intrinsics.areEqual(this.bgUrl, r4.bgUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bgUrlFold, r4.bgUrlFold) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bgColor, r4.bgColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgGradientConfig, r4.bgGradientConfig) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.bgUrl;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.bgUrlFold;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.bgColor;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.bgGradientConfig;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "SkinConfigPage(bgUrl=" + this.bgUrl + ", bgUrlFold=" + this.bgUrlFold + ", bgColor=" + this.bgColor + ", bgGradientConfig=" + this.bgGradientConfig + ")";
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getBgGradientConfig() {
        return this.bgGradientConfig;
    }

    public final String getBgUrl() {
        return this.bgUrl;
    }

    public final String getBgUrlFold() {
        return this.bgUrlFold;
    }

    public SkinConfigPage(String r1, String r2, String r3, String r4) {
        this.bgUrl = r1;
        this.bgUrlFold = r2;
        this.bgColor = r3;
        this.bgGradientConfig = r4;
    }

    public /* synthetic */ SkinConfigPage(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
