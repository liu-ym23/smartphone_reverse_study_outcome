package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jn\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u0010¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/TabIcon;", "", "width", "", "height", "lightIcon", "", "darkIcon", "selectedLightIcon", "selectedDarkIcon", "selectedToolbarLightColor", "selectedToolbarDarkColor", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDarkIcon", "()Ljava/lang/String;", "getHeight", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLightIcon", "getSelectedDarkIcon", "getSelectedLightIcon", "getSelectedToolbarDarkColor", "getSelectedToolbarLightColor", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/model/TabIcon;", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabIcon {

    @SerializedName("dark_icon")
    private final String darkIcon;

    @SerializedName("height")
    private final Long height;

    @SerializedName("light_icon")
    private final String lightIcon;

    @SerializedName("selected_dark_icon")
    private final String selectedDarkIcon;

    @SerializedName("selected_light_icon")
    private final String selectedLightIcon;

    @SerializedName("selected_toolbar_dark_color")
    private final String selectedToolbarDarkColor;

    @SerializedName("selected_toolbar_light_color")
    private final String selectedToolbarLightColor;

    @SerializedName("width")
    private final Long width;

    public TabIcon() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ TabIcon copy$default(TabIcon r9, Long r10, Long r11, String r12, String r13, String r14, String r15, String r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        Long r2 = r9.width;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Long r3 = r9.height;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.lightIcon;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.darkIcon;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.selectedLightIcon;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.selectedDarkIcon;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.selectedToolbarLightColor;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.selectedToolbarDarkColor;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final Long component1() {
        return this.width;
    }

    public final Long component2() {
        return this.height;
    }

    public final String component3() {
        return this.lightIcon;
    }

    public final String component4() {
        return this.darkIcon;
    }

    public final String component5() {
        return this.selectedLightIcon;
    }

    public final String component6() {
        return this.selectedDarkIcon;
    }

    public final String component7() {
        return this.selectedToolbarLightColor;
    }

    public final String component8() {
        return this.selectedToolbarDarkColor;
    }

    public final TabIcon copy(Long r11, Long r12, String r13, String r14, String r15, String r16, String r17, String r18) {
        return new TabIcon(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof TabIcon) == false) goto L22;
        TabIcon r4 = (TabIcon) r3;
        if (Intrinsics.areEqual(this.width, r4.width) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.height, r4.height) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lightIcon, r4.lightIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.darkIcon, r4.darkIcon) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.selectedLightIcon, r4.selectedLightIcon) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.selectedDarkIcon, r4.selectedDarkIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectedToolbarLightColor, r4.selectedToolbarLightColor) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.selectedToolbarDarkColor, r4.selectedToolbarDarkColor) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        Long r0 = this.width;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.height;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.lightIcon;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.darkIcon;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.selectedLightIcon;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.selectedDarkIcon;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.selectedToolbarLightColor;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.selectedToolbarDarkColor;
        if (r22 == null) goto L34;
        r1 = r22.hashCode();
    L34:
        return r21 + r1;
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
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
        return "TabIcon(width=" + this.width + ", height=" + this.height + ", lightIcon=" + this.lightIcon + ", darkIcon=" + this.darkIcon + ", selectedLightIcon=" + this.selectedLightIcon + ", selectedDarkIcon=" + this.selectedDarkIcon + ", selectedToolbarLightColor=" + this.selectedToolbarLightColor + ", selectedToolbarDarkColor=" + this.selectedToolbarDarkColor + ")";
    }

    public final String getDarkIcon() {
        return this.darkIcon;
    }

    public final Long getHeight() {
        return this.height;
    }

    public final String getLightIcon() {
        return this.lightIcon;
    }

    public final String getSelectedDarkIcon() {
        return this.selectedDarkIcon;
    }

    public final String getSelectedLightIcon() {
        return this.selectedLightIcon;
    }

    public final String getSelectedToolbarDarkColor() {
        return this.selectedToolbarDarkColor;
    }

    public final String getSelectedToolbarLightColor() {
        return this.selectedToolbarLightColor;
    }

    public final Long getWidth() {
        return this.width;
    }

    public TabIcon(Long r1, Long r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        this.width = r1;
        this.height = r2;
        this.lightIcon = r3;
        this.darkIcon = r4;
        this.selectedLightIcon = r5;
        this.selectedDarkIcon = r6;
        this.selectedToolbarLightColor = r7;
        this.selectedToolbarDarkColor = r8;
    }

    public /* synthetic */ TabIcon(Long r10, Long r11, String r12, String r13, String r14, String r15, String r16, String r17, int r18, DefaultConstructorMarker r19) {
        String r2 = null;
        if ((r18 & 1) == 0) goto L5;
        Long r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Long r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
