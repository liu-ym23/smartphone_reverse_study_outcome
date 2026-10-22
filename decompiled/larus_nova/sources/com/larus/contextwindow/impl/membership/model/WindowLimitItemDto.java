package com.larus.contextwindow.impl.membership.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003Jn\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\tHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/WindowLimitItemDto;", "", "windowType", "Lcom/google/gson/JsonElement;", "itemType", "usedPercent", "lessThanOnePercent", "", "usedAmount", "", "totalAmount", "endTime", "exemption", "Lcom/larus/contextwindow/impl/membership/model/WindowLimitExemptionDto;", "<init>", "(Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;Lcom/larus/contextwindow/impl/membership/model/WindowLimitExemptionDto;)V", "getWindowType", "()Lcom/google/gson/JsonElement;", "getItemType", "getUsedPercent", "getLessThanOnePercent", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUsedAmount", "()Ljava/lang/String;", "getTotalAmount", "getEndTime", "getExemption", "()Lcom/larus/contextwindow/impl/membership/model/WindowLimitExemptionDto;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;Lcom/larus/contextwindow/impl/membership/model/WindowLimitExemptionDto;)Lcom/larus/contextwindow/impl/membership/model/WindowLimitItemDto;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowLimitItemDto {

    @SerializedName("end_time")
    private final JsonElement endTime;

    @SerializedName("exemption")
    private final WindowLimitExemptionDto exemption;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private final JsonElement itemType;

    @SerializedName("less_than_one_percent")
    private final Boolean lessThanOnePercent;

    @SerializedName("total_amount")
    private final String totalAmount;

    @SerializedName("used_amount")
    private final String usedAmount;

    @SerializedName("used_percent")
    private final JsonElement usedPercent;

    @SerializedName("window_type")
    private final JsonElement windowType;

    public WindowLimitItemDto() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ WindowLimitItemDto copy$default(WindowLimitItemDto r100, JsonElement r110, JsonElement r111, JsonElement r112, Boolean r113, String r114, String r115, JsonElement r116, WindowLimitExemptionDto r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        JsonElement r101 = r100.windowType;
    L7:
        if ((r118 & 2) == 0) goto L9;
        JsonElement r102 = r100.itemType;
    L11:
        if ((r118 & 4) == 0) goto L13;
        JsonElement r103 = r100.usedPercent;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Boolean r104 = r100.lessThanOnePercent;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.usedAmount;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.totalAmount;
    L27:
        if ((r118 & 64) == 0) goto L29;
        JsonElement r107 = r100.endTime;
    L31:
        if ((r118 & 128) == 0) goto L33;
        WindowLimitExemptionDto r108 = r100.exemption;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final JsonElement component1() {
        return this.windowType;
    }

    public final JsonElement component2() {
        return this.itemType;
    }

    public final JsonElement component3() {
        return this.usedPercent;
    }

    public final Boolean component4() {
        return this.lessThanOnePercent;
    }

    public final String component5() {
        return this.usedAmount;
    }

    public final String component6() {
        return this.totalAmount;
    }

    public final JsonElement component7() {
        return this.endTime;
    }

    public final WindowLimitExemptionDto component8() {
        return this.exemption;
    }

    public final WindowLimitItemDto copy(JsonElement r110, JsonElement r111, JsonElement r112, Boolean r113, String r114, String r115, JsonElement r116, WindowLimitExemptionDto r117) {
        return new WindowLimitItemDto(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WindowLimitItemDto) == true) goto L8;
        return false;
    L8:
        WindowLimitItemDto r101 = (WindowLimitItemDto) r100;
        if (Intrinsics.areEqual(this.windowType, r101.windowType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemType, r101.itemType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.usedPercent, r101.usedPercent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lessThanOnePercent, r101.lessThanOnePercent) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.usedAmount, r101.usedAmount) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.totalAmount, r101.totalAmount) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.exemption, r101.exemption) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        JsonElement r100 = this.windowType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        JsonElement r104 = this.itemType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        JsonElement r107 = this.usedPercent;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.lessThanOnePercent;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.usedAmount;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.totalAmount;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        JsonElement r119 = this.endTime;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        WindowLimitExemptionDto r122 = this.exemption;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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

    public String toString() {
        return "WindowLimitItemDto(windowType=" + this.windowType + ", itemType=" + this.itemType + ", usedPercent=" + this.usedPercent + ", lessThanOnePercent=" + this.lessThanOnePercent + ", usedAmount=" + this.usedAmount + ", totalAmount=" + this.totalAmount + ", endTime=" + this.endTime + ", exemption=" + this.exemption + ')';
    }

    public final JsonElement getEndTime() {
        return this.endTime;
    }

    public final WindowLimitExemptionDto getExemption() {
        return this.exemption;
    }

    public final JsonElement getItemType() {
        return this.itemType;
    }

    public final Boolean getLessThanOnePercent() {
        return this.lessThanOnePercent;
    }

    public final String getTotalAmount() {
        return this.totalAmount;
    }

    public final String getUsedAmount() {
        return this.usedAmount;
    }

    public final JsonElement getUsedPercent() {
        return this.usedPercent;
    }

    public final JsonElement getWindowType() {
        return this.windowType;
    }

    public WindowLimitItemDto(JsonElement r100, JsonElement r101, JsonElement r102, Boolean r103, String r104, String r105, JsonElement r106, WindowLimitExemptionDto r107) {
        this.windowType = r100;
        this.itemType = r101;
        this.usedPercent = r102;
        this.lessThanOnePercent = r103;
        this.usedAmount = r104;
        this.totalAmount = r105;
        this.endTime = r106;
        this.exemption = r107;
    }

    public /* synthetic */ WindowLimitItemDto(JsonElement r110, JsonElement r111, JsonElement r112, Boolean r113, String r114, String r115, JsonElement r116, WindowLimitExemptionDto r117, int r118, DefaultConstructorMarker r119) {
        WindowLimitExemptionDto r100 = null;
        if ((r118 & 1) == 0) goto L5;
        JsonElement r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        JsonElement r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        JsonElement r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Boolean r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        JsonElement r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
