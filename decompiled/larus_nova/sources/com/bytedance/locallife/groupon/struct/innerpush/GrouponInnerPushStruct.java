package com.bytedance.locallife.groupon.struct.innerpush;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.locallife.groupon.struct.FrequencyInfo;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0017\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010HÆ\u0003J\u0092\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0007HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00065"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/innerpush/GrouponInnerPushStruct;", "", "icon", "", "title", "tagText", "topBannerType", "", "description", "button", "Lcom/bytedance/locallife/groupon/struct/innerpush/Button;", "action", "Lcom/bytedance/locallife/groupon/struct/innerpush/Action;", "frequencyData", "Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "trackParams", "", "moduleType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/innerpush/Button;Lcom/bytedance/locallife/groupon/struct/innerpush/Action;Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;Ljava/util/Map;Ljava/lang/String;)V", "getAction", "()Lcom/bytedance/locallife/groupon/struct/innerpush/Action;", "getButton", "()Lcom/bytedance/locallife/groupon/struct/innerpush/Button;", "getDescription", "()Ljava/lang/String;", "getFrequencyData", "()Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "getIcon", "getModuleType", "getTagText", "getTitle", "getTopBannerType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTrackParams", "()Ljava/util/Map;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/innerpush/Button;Lcom/bytedance/locallife/groupon/struct/innerpush/Action;Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;Ljava/util/Map;Ljava/lang/String;)Lcom/bytedance/locallife/groupon/struct/innerpush/GrouponInnerPushStruct;", "equals", "", "other", "hashCode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GrouponInnerPushStruct {

    @SerializedName("action")
    private final Action action;

    @SerializedName("button")
    private final Button button;

    @SerializedName("description")
    private final String description;

    @SerializedName("frequency_data")
    private final FrequencyInfo frequencyData;

    @SerializedName("icon")
    private final String icon;

    @SerializedName(a.KEY_MODULE_TYPE)
    private final String moduleType;

    @SerializedName("tag_text")
    private final String tagText;

    @SerializedName("title")
    private final String title;

    @SerializedName("top_banner_type")
    private final Integer topBannerType;

    @SerializedName("track_params")
    private final Map<String, String> trackParams;

    public GrouponInnerPushStruct() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GrouponInnerPushStruct copy$default(GrouponInnerPushStruct r110, String r111, String r112, String r113, Integer r114, String r115, Button r116, Action r117, FrequencyInfo r118, Map r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.icon;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.title;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.tagText;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Integer r103 = r110.topBannerType;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.description;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Button r105 = r110.button;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Action r106 = r110.action;
    L31:
        if ((r212 & 128) == 0) goto L33;
        FrequencyInfo r107 = r110.frequencyData;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Map r119 = r110.trackParams;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r108 = r110.moduleType;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.icon;
    }

    public final String component10() {
        return this.moduleType;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.tagText;
    }

    public final Integer component4() {
        return this.topBannerType;
    }

    public final String component5() {
        return this.description;
    }

    public final Button component6() {
        return this.button;
    }

    public final Action component7() {
        return this.action;
    }

    public final FrequencyInfo component8() {
        return this.frequencyData;
    }

    public final Map<String, String> component9() {
        return this.trackParams;
    }

    public final GrouponInnerPushStruct copy(String r110, String r111, String r112, Integer r113, String r114, Button r115, Action r116, FrequencyInfo r210, Map<String, String> r211, String r212) {
        return new GrouponInnerPushStruct(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GrouponInnerPushStruct) == true) goto L8;
        return false;
    L8:
        GrouponInnerPushStruct r101 = (GrouponInnerPushStruct) r100;
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tagText, r101.tagText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.topBannerType, r101.topBannerType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.button, r101.button) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.frequencyData, r101.frequencyData) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.moduleType, r101.moduleType) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.icon;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.tagText;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.topBannerType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.description;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Button r116 = this.button;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Action r119 = this.action;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        FrequencyInfo r122 = this.frequencyData;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Map<String, String> r125 = this.trackParams;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.moduleType;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
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
        return "GrouponInnerPushStruct(icon=" + this.icon + ", title=" + this.title + ", tagText=" + this.tagText + ", topBannerType=" + this.topBannerType + ", description=" + this.description + ", button=" + this.button + ", action=" + this.action + ", frequencyData=" + this.frequencyData + ", trackParams=" + this.trackParams + ", moduleType=" + this.moduleType + ')';
    }

    public final Action getAction() {
        return this.action;
    }

    public final Button getButton() {
        return this.button;
    }

    public final String getDescription() {
        return this.description;
    }

    public final FrequencyInfo getFrequencyData() {
        return this.frequencyData;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getModuleType() {
        return this.moduleType;
    }

    public final String getTagText() {
        return this.tagText;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getTopBannerType() {
        return this.topBannerType;
    }

    public final Map<String, String> getTrackParams() {
        return this.trackParams;
    }

    public GrouponInnerPushStruct(String r100, String r101, String r102, Integer r103, String r104, Button r105, Action r106, FrequencyInfo r107, Map<String, String> r108, String r110) {
        this.icon = r100;
        this.title = r101;
        this.tagText = r102;
        this.topBannerType = r103;
        this.description = r104;
        this.button = r105;
        this.action = r106;
        this.frequencyData = r107;
        this.trackParams = r108;
        this.moduleType = r110;
    }

    public /* synthetic */ GrouponInnerPushStruct(String r110, String r111, String r112, Integer r113, String r114, Button r115, Action r116, FrequencyInfo r117, Map r210, String r211, int r212, DefaultConstructorMarker r213) {
        String r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Button r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Action r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        FrequencyInfo r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Map r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
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
}
