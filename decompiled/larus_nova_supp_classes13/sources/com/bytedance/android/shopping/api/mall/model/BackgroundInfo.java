package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/BackgroundInfo;", "", "bgColor", "", "bgUrl", "baseBgColor", "headerBgUrl", "bgGradientConfig", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBaseBgColor", "()Ljava/lang/String;", "getBgColor", "getBgGradientConfig", "getBgUrl", "getHeaderBgUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BackgroundInfo {

    @SerializedName("base_bg_color")
    private final String baseBgColor;

    @SerializedName("bg_color")
    private final String bgColor;

    @SerializedName("bg_gradient_config")
    private final String bgGradientConfig;

    @SerializedName("bg_url")
    private final String bgUrl;

    @SerializedName("header_bg_url")
    private final String headerBgUrl;

    public BackgroundInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ BackgroundInfo copy$default(BackgroundInfo r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.bgColor;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.bgUrl;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.baseBgColor;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.headerBgUrl;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.bgGradientConfig;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.bgColor;
    }

    public final String component2() {
        return this.bgUrl;
    }

    public final String component3() {
        return this.baseBgColor;
    }

    public final String component4() {
        return this.headerBgUrl;
    }

    public final String component5() {
        return this.bgGradientConfig;
    }

    public final BackgroundInfo copy(String r8, String r9, String r10, String r11, String r12) {
        return new BackgroundInfo(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof BackgroundInfo) == false) goto L16;
        BackgroundInfo r4 = (BackgroundInfo) r3;
        if (Intrinsics.areEqual(this.bgColor, r4.bgColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bgUrl, r4.bgUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.baseBgColor, r4.baseBgColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.headerBgUrl, r4.headerBgUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bgGradientConfig, r4.bgGradientConfig) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.bgColor;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.bgUrl;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.baseBgColor;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.headerBgUrl;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.bgGradientConfig;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
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
        return "BackgroundInfo(bgColor=" + this.bgColor + ", bgUrl=" + this.bgUrl + ", baseBgColor=" + this.baseBgColor + ", headerBgUrl=" + this.headerBgUrl + ", bgGradientConfig=" + this.bgGradientConfig + ")";
    }

    public final String getBaseBgColor() {
        return this.baseBgColor;
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

    public final String getHeaderBgUrl() {
        return this.headerBgUrl;
    }

    public BackgroundInfo(String r1, String r2, String r3, String r4, String r5) {
        this.bgColor = r1;
        this.bgUrl = r2;
        this.baseBgColor = r3;
        this.headerBgUrl = r4;
        this.bgGradientConfig = r5;
    }

    public /* synthetic */ BackgroundInfo(String r5, String r6, String r7, String r8, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        String r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
