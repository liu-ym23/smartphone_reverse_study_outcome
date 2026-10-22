package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi2.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bE\u0010FJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eHÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eHÆ\u0003J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003JÒ\u0001\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b%\u0010&J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\t\u0010(\u001a\u00020\u0002HÖ\u0001J\u0013\u0010+\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u00101R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b2\u00101R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b3\u0010.R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b4\u00101R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\b6\u00107R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00108\u001a\u0004\b9\u0010:R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b;\u00101R(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010<\u001a\u0004\b=\u0010>R(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010<\u001a\u0004\b?\u0010>R\u001c\u0010!\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010@\u001a\u0004\bA\u0010\u0013R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010@\u001a\u0004\bB\u0010\u0013R\u001c\u0010#\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010/\u001a\u0004\bC\u00101R\u001c\u0010$\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010/\u001a\u0004\bD\u00101¨\u0006G"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionEntry;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "component4", "component5", "Lxi2/y;", "component6", "", "component7", "component8", "", "component9", "component10", "", "component11", "()Ljava/lang/Boolean;", "component12", "component13", "component14", LocationMonitorConst.TYPE, "title", "icon", "iconRadius", "url", "iconSize", "subEntries", "trackName", "trackParams", "businessParams", "showSmallWindow", "showDisclaimer", "color", "schemaParamsType", "copy", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lxi2/y;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionEntry;", "toString", "hashCode", "", "other", "equals", "I", "getType", "()I", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "getIcon", "getIconRadius", "getUrl", "Lxi2/y;", "getIconSize", "()Lxi2/y;", "Ljava/util/List;", "getSubEntries", "()Ljava/util/List;", "getTrackName", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "getBusinessParams", "Ljava/lang/Boolean;", "getShowSmallWindow", "getShowDisclaimer", "getColor", "getSchemaParamsType", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lxi2/y;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionEntry implements Serializable {

    @SerializedName("business_params")
    private final Map<String, String> businessParams;

    @SerializedName("color")
    private final String color;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("icon_radius")
    private final int iconRadius;

    @SerializedName("icon_size")
    private final y iconSize;

    @SerializedName("schema_params_type")
    private final String schemaParamsType;

    @SerializedName("show_disclaimer")
    private final Boolean showDisclaimer;

    @SerializedName("show_small_window")
    private final Boolean showSmallWindow;

    @SerializedName("sub_entries")
    private final List<ECPromotionEntry> subEntries;

    @SerializedName("title")
    private final String title;

    @SerializedName("track_name")
    private final String trackName;

    @SerializedName("track_params")
    private final Map<String, String> trackParams;

    @SerializedName(LocationMonitorConst.TYPE)
    private final int type;

    @SerializedName("url")
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECPromotionEntry copy$default(ECPromotionEntry r15, int r16, String r17, String r18, int r19, String r20, y r21, List r22, String r23, Map r24, Map r25, Boolean r26, Boolean r27, String r28, String r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        int r2 = r15.type;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r3 = r15.title;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r4 = r15.icon;
    L15:
        if ((r30 & 8) == 0) goto L17;
        int r5 = r15.iconRadius;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r6 = r15.url;
    L23:
        if ((r30 & 32) == 0) goto L25;
        y r7 = r15.iconSize;
    L27:
        if ((r30 & 64) == 0) goto L29;
        List r8 = r15.subEntries;
    L31:
        if ((r30 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        String r9 = r15.trackName;
    L35:
        if ((r30 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        Map r10 = r15.trackParams;
    L39:
        if ((r30 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        Map r11 = r15.businessParams;
    L43:
        if ((r30 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L45;
        Boolean r12 = r15.showSmallWindow;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        Boolean r13 = r15.showDisclaimer;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        String r14 = r15.color;
    L55:
        if ((r30 & 8192) == 0) goto L57;
        String r1 = r15.schemaParamsType;
    L59:
        return r15.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1);
    L57:
        r1 = r29;
        goto L59
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final int component1() {
        return this.type;
    }

    public final Map<String, String> component10() {
        return this.businessParams;
    }

    public final Boolean component11() {
        return this.showSmallWindow;
    }

    public final Boolean component12() {
        return this.showDisclaimer;
    }

    public final String component13() {
        return this.color;
    }

    public final String component14() {
        return this.schemaParamsType;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.icon;
    }

    public final int component4() {
        return this.iconRadius;
    }

    public final String component5() {
        return this.url;
    }

    public final y component6() {
        return this.iconSize;
    }

    public final List<ECPromotionEntry> component7() {
        return this.subEntries;
    }

    public final String component8() {
        return this.trackName;
    }

    public final Map<String, String> component9() {
        return this.trackParams;
    }

    public final ECPromotionEntry copy(int r17, String r18, String r19, int r20, String r21, y r22, List<ECPromotionEntry> r23, String r24, Map<String, String> r25, Map<String, String> r26, Boolean r27, Boolean r28, String r29, String r30) {
        return new ECPromotionEntry(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECPromotionEntry) == false) goto L34;
        ECPromotionEntry r4 = (ECPromotionEntry) r3;
        if (this.type == r4.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L12;
        return false;
    L12:
        if (this.iconRadius == r4.iconRadius) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.url, r4.url) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.iconSize, r4.iconSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subEntries, r4.subEntries) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.trackName, r4.trackName) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.trackParams, r4.trackParams) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.businessParams, r4.businessParams) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.showSmallWindow, r4.showSmallWindow) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.showDisclaimer, r4.showDisclaimer) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.color, r4.color) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.schemaParamsType, r4.schemaParamsType) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public int hashCode() {
        int r0 = this.type * 31;
        String r1 = this.title;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.icon;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (((r4 + r6) * 31) + this.iconRadius) * 31;
        String r8 = this.url;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        y r11 = this.iconSize;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        List<ECPromotionEntry> r14 = this.subEntries;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.trackName;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        Map<String, String> r20 = this.trackParams;
        if (r20 == null) goto L29;
        int r21 = r20.hashCode();
    L30:
        int r22 = (r19 + r21) * 31;
        Map<String, String> r23 = this.businessParams;
        if (r23 == null) goto L33;
        int r24 = r23.hashCode();
    L34:
        int r25 = (r22 + r24) * 31;
        Boolean r26 = this.showSmallWindow;
        if (r26 == null) goto L37;
        int r27 = r26.hashCode();
    L38:
        int r28 = (r25 + r27) * 31;
        Boolean r29 = this.showDisclaimer;
        if (r29 == null) goto L41;
        int r30 = r29.hashCode();
    L42:
        int r31 = (r28 + r30) * 31;
        String r32 = this.color;
        if (r32 == null) goto L45;
        int r33 = r32.hashCode();
    L46:
        int r34 = (r31 + r33) * 31;
        String r35 = this.schemaParamsType;
        if (r35 == null) goto L50;
        r2 = r35.hashCode();
    L50:
        return r34 + r2;
    L45:
        r33 = 0;
        goto L46
    L41:
        r30 = 0;
        goto L42
    L37:
        r27 = 0;
        goto L38
    L33:
        r24 = 0;
        goto L34
    L29:
        r21 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "ECPromotionEntry(type=" + this.type + ", title=" + this.title + ", icon=" + this.icon + ", iconRadius=" + this.iconRadius + ", url=" + this.url + ", iconSize=" + this.iconSize + ", subEntries=" + this.subEntries + ", trackName=" + this.trackName + ", trackParams=" + this.trackParams + ", businessParams=" + this.businessParams + ", showSmallWindow=" + this.showSmallWindow + ", showDisclaimer=" + this.showDisclaimer + ", color=" + this.color + ", schemaParamsType=" + this.schemaParamsType + ")";
    }

    public final Map<String, String> getBusinessParams() {
        return this.businessParams;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getIconRadius() {
        return this.iconRadius;
    }

    public final y getIconSize() {
        return this.iconSize;
    }

    public final String getSchemaParamsType() {
        return this.schemaParamsType;
    }

    public final Boolean getShowDisclaimer() {
        return this.showDisclaimer;
    }

    public final Boolean getShowSmallWindow() {
        return this.showSmallWindow;
    }

    public final List<ECPromotionEntry> getSubEntries() {
        return this.subEntries;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTrackName() {
        return this.trackName;
    }

    public final Map<String, String> getTrackParams() {
        return this.trackParams;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public ECPromotionEntry(int r1, String r2, String r3, int r4, String r5, y r6, List<ECPromotionEntry> r7, String r8, Map<String, String> r9, Map<String, String> r10, Boolean r11, Boolean r12, String r13, String r14) {
        this.type = r1;
        this.title = r2;
        this.icon = r3;
        this.iconRadius = r4;
        this.url = r5;
        this.iconSize = r6;
        this.subEntries = r7;
        this.trackName = r8;
        this.trackParams = r9;
        this.businessParams = r10;
        this.showSmallWindow = r11;
        this.showDisclaimer = r12;
        this.color = r13;
        this.schemaParamsType = r14;
    }

    public /* synthetic */ ECPromotionEntry(int r15, String r16, String r17, int r18, String r19, y r20, List r21, String r22, Map r23, Map r24, Boolean r25, Boolean r26, String r27, String r28, int r29, DefaultConstructorMarker r30) {
        String r2 = null;
        if ((r29 & 2) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r29 & 4) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r29 & 8) == 0) goto L13;
        int r4 = 0;
    L15:
        if ((r29 & 16) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r29 & 32) == 0) goto L21;
        y r6 = null;
    L23:
        if ((r29 & 64) == 0) goto L25;
        List r7 = null;
    L27:
        if ((r29 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r29 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L33;
        Map r9 = null;
    L35:
        if ((r29 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L37;
        Map r10 = null;
    L39:
        if ((r29 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L41;
        Boolean r11 = null;
    L43:
        if ((r29 & 2048) == 0) goto L45;
        Boolean r12 = null;
    L47:
        if ((r29 & 4096) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r29 & 8192) != 0) goto L54;
        r2 = r28;
    L54:
        this(r15, r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r2);
        return;
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}
