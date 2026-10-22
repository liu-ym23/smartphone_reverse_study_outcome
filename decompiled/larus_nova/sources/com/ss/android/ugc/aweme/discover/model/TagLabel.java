package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.locallife.groupon.struct.bubble.model.ElementGuideBubbleStruct;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u00ad\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010=\u001a\u00020\u0006HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001d¨\u0006?"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/TagLabel;", "Ljava/io/Serializable;", "lightIconUrl", "", "darkIconUrl", "height", "", "width", "labelPosition", "Lcom/ss/android/ugc/aweme/discover/model/LabelPosition;", "text", "logInfo", "", "", "LabelBusinessInfo", "Lcom/ss/android/ugc/aweme/discover/model/LabelBusinessInfo;", "mainPictureLabel", "tagType", "tagIcon", "Lcom/ss/android/ugc/aweme/discover/model/TagIcon;", "iconText", "Lcom/ss/android/ugc/aweme/discover/model/IconText;", "schema", "(Ljava/lang/String;Ljava/lang/String;IILcom/ss/android/ugc/aweme/discover/model/LabelPosition;Ljava/lang/String;Ljava/util/Map;Lcom/ss/android/ugc/aweme/discover/model/LabelBusinessInfo;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/ugc/aweme/discover/model/TagIcon;Lcom/ss/android/ugc/aweme/discover/model/IconText;Ljava/lang/String;)V", "getLabelBusinessInfo", "()Lcom/ss/android/ugc/aweme/discover/model/LabelBusinessInfo;", "getDarkIconUrl", "()Ljava/lang/String;", "getHeight", "()I", "getIconText", "()Lcom/ss/android/ugc/aweme/discover/model/IconText;", "getLabelPosition", "()Lcom/ss/android/ugc/aweme/discover/model/LabelPosition;", "getLightIconUrl", "getLogInfo", "()Ljava/util/Map;", "getMainPictureLabel", "getSchema", "getTagIcon", "()Lcom/ss/android/ugc/aweme/discover/model/TagIcon;", "getTagType", "getText", "getWidth", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TagLabel implements Serializable {

    @SerializedName("business_info")
    private final LabelBusinessInfo LabelBusinessInfo;

    @SerializedName("dark_icon_url")
    private final String darkIconUrl;

    @SerializedName("height")
    private final int height;

    @SerializedName(ElementGuideBubbleStruct.STYLE_ICON_TEXT_BUBBLE)
    private final IconText iconText;

    @SerializedName("position")
    private final LabelPosition labelPosition;

    @SerializedName("light_icon_url")
    private final String lightIconUrl;

    @SerializedName("log_info")
    private final Map<String, Object> logInfo;

    @SerializedName("main_picture_label")
    private final String mainPictureLabel;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("tag_icon")
    private final TagIcon tagIcon;

    @SerializedName(a.KEY_TAG_TYPE)
    private final String tagType;

    @SerializedName("text")
    private final String text;

    @SerializedName("width")
    private final int width;

    public TagLabel() {
        this(null, null, 0, 0, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TagLabel copy$default(TagLabel r110, String r111, String r112, int r113, int r114, LabelPosition r115, String r210, Map r211, LabelBusinessInfo r212, String r213, String r214, TagIcon r215, IconText r216, String r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = r110.lightIconUrl;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r101 = r110.darkIconUrl;
    L11:
        if ((r218 & 4) == 0) goto L13;
        int r102 = r110.height;
    L15:
        if ((r218 & 8) == 0) goto L17;
        int r103 = r110.width;
    L19:
        if ((r218 & 16) == 0) goto L21;
        LabelPosition r104 = r110.labelPosition;
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r105 = r110.text;
    L27:
        if ((r218 & 64) == 0) goto L29;
        Map r106 = r110.logInfo;
    L31:
        if ((r218 & 128) == 0) goto L33;
        LabelBusinessInfo r107 = r110.LabelBusinessInfo;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r116 = r110.mainPictureLabel;
    L39:
        if ((r218 & 512) == 0) goto L41;
        String r117 = r110.tagType;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        TagIcon r118 = r110.tagIcon;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        IconText r119 = r110.iconText;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        String r108 = r110.schema;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
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
        return this.lightIconUrl;
    }

    public final String component10() {
        return this.tagType;
    }

    public final TagIcon component11() {
        return this.tagIcon;
    }

    public final IconText component12() {
        return this.iconText;
    }

    public final String component13() {
        return this.schema;
    }

    public final String component2() {
        return this.darkIconUrl;
    }

    public final int component3() {
        return this.height;
    }

    public final int component4() {
        return this.width;
    }

    public final LabelPosition component5() {
        return this.labelPosition;
    }

    public final String component6() {
        return this.text;
    }

    public final Map<String, Object> component7() {
        return this.logInfo;
    }

    public final LabelBusinessInfo component8() {
        return this.LabelBusinessInfo;
    }

    public final String component9() {
        return this.mainPictureLabel;
    }

    public final TagLabel copy(String r110, String r111, int r112, int r113, LabelPosition r210, String r211, Map<String, ? extends Object> r212, LabelBusinessInfo r213, String r214, String r215, TagIcon r216, IconText r217, String r218) {
        return new TagLabel(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TagLabel) == false) goto L32;
        TagLabel r101 = (TagLabel) r100;
        if (Intrinsics.areEqual(this.lightIconUrl, r101.lightIconUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.darkIconUrl, r101.darkIconUrl) == true) goto L10;
        return false;
    L10:
        if (this.height == r101.height) goto L12;
        return false;
    L12:
        if (this.width == r101.width) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.labelPosition, r101.labelPosition) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.logInfo, r101.logInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.LabelBusinessInfo, r101.LabelBusinessInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.mainPictureLabel, r101.mainPictureLabel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tagType, r101.tagType) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.tagIcon, r101.tagIcon) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.iconText, r101.iconText) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        String r100 = this.lightIconUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.darkIconUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((r103 + r105) * 31) + this.height) * 31) + this.width) * 31;
        LabelPosition r107 = this.labelPosition;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.text;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.logInfo;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        LabelBusinessInfo r116 = this.LabelBusinessInfo;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.mainPictureLabel;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.tagType;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        TagIcon r125 = this.tagIcon;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        IconText r128 = this.iconText;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.schema;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "TagLabel(lightIconUrl=" + this.lightIconUrl + ", darkIconUrl=" + this.darkIconUrl + ", height=" + this.height + ", width=" + this.width + ", labelPosition=" + this.labelPosition + ", text=" + this.text + ", logInfo=" + this.logInfo + ", LabelBusinessInfo=" + this.LabelBusinessInfo + ", mainPictureLabel=" + this.mainPictureLabel + ", tagType=" + this.tagType + ", tagIcon=" + this.tagIcon + ", iconText=" + this.iconText + ", schema=" + this.schema + ")";
    }

    public final String getDarkIconUrl() {
        return this.darkIconUrl;
    }

    public final int getHeight() {
        return this.height;
    }

    public final IconText getIconText() {
        return this.iconText;
    }

    public final LabelBusinessInfo getLabelBusinessInfo() {
        return this.LabelBusinessInfo;
    }

    public final LabelPosition getLabelPosition() {
        return this.labelPosition;
    }

    public final String getLightIconUrl() {
        return this.lightIconUrl;
    }

    public final Map<String, Object> getLogInfo() {
        return this.logInfo;
    }

    public final String getMainPictureLabel() {
        return this.mainPictureLabel;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final TagIcon getTagIcon() {
        return this.tagIcon;
    }

    public final String getTagType() {
        return this.tagType;
    }

    public final String getText() {
        return this.text;
    }

    public final int getWidth() {
        return this.width;
    }

    public TagLabel(String r100, String r101, int r102, int r103, LabelPosition r104, String r105, Map<String, ? extends Object> r106, LabelBusinessInfo r107, String r108, String r110, TagIcon r111, IconText r112, String r113) {
        this.lightIconUrl = r100;
        this.darkIconUrl = r101;
        this.height = r102;
        this.width = r103;
        this.labelPosition = r104;
        this.text = r105;
        this.logInfo = r106;
        this.LabelBusinessInfo = r107;
        this.mainPictureLabel = r108;
        this.tagType = r110;
        this.tagIcon = r111;
        this.iconText = r112;
        this.schema = r113;
    }

    public /* synthetic */ TagLabel(String r110, String r111, int r112, int r113, LabelPosition r114, String r210, Map r211, LabelBusinessInfo r212, String r213, String r214, TagIcon r215, IconText r216, String r217, int r218, DefaultConstructorMarker r219) {
        String r100 = "";
        if ((r218 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r102 = "";
    L10:
        int r103 = 0;
        if ((r218 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r218 & 8) != 0) goto L18;
        r103 = r113;
    L18:
        String r105 = null;
        if ((r218 & 16) == 0) goto L21;
        LabelPosition r106 = null;
    L23:
        if ((r218 & 32) != 0) goto L27;
        r100 = r210;
    L27:
        if ((r218 & 64) == 0) goto L29;
        Map r107 = null;
    L31:
        if ((r218 & 128) == 0) goto L33;
        LabelBusinessInfo r108 = null;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r115 = null;
    L39:
        if ((r218 & 512) == 0) goto L41;
        String r116 = null;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        TagIcon r117 = null;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        IconText r118 = null;
    L51:
        if ((r218 & 4096) != 0) goto L54;
        r105 = r217;
    L54:
        this(r101, r102, r104, r103, r106, r100, r107, r108, r115, r116, r117, r118, r105);
        return;
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L21:
        r106 = r114;
        goto L23
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
