package com.bytedance.locallife.groupon.struct.bubble.model;

import androidx.core.provider.FontsContractCompat;
import com.bytedance.locallife.dito.common.data.UrlModel;
import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0001>B\u0093\u0001\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b;\u0010<J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\t\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\u000eHÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u0095\u0001\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u0006HÆ\u0001J\t\u0010!\u001a\u00020\u0002HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\u0013\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b)\u0010(R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b*\u0010(R\u001a\u0010\u0016\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b.\u0010(R\u001a\u0010\u0018\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b/\u0010-R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u00102R\u001a\u0010\u001a\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b3\u0010-R\u001a\u0010\u001b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b4\u0010-R\u001a\u0010\u001c\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\b6\u00107R\u001a\u0010\u001d\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b8\u0010-R\u001a\u0010\u001e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b9\u0010-R\u001a\u0010\u001f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010+\u001a\u0004\b:\u0010-¨\u0006?"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/bubble/model/TagDesc;", "", "", "component1", "component2", "component3", "", "component4", "component5", "component6", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "component7", "component8", "component9", "", "component10", "component11", "component12", "component13", "type", "text", "color", "fontSize", LynxResourceModule.FONT_TYPE, "fontWeight", "imageUrl", "marginLeft", "marginRight", "timestamp", "width", "height", "cornerRadius", "copy", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "getText", "getColor", "I", "getFontSize", "()I", "getFont", "getFontWeight", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "getImageUrl", "()Lcom/bytedance/locallife/dito/common/data/UrlModel;", "getMarginLeft", "getMarginRight", "J", "getTimestamp", "()J", "getWidth", "getHeight", "getCornerRadius", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILcom/bytedance/locallife/dito/common/data/UrlModel;IIJIII)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class TagDesc {
    public static final a Companion = null;
    public static final String STYLE_COUNT_DOWN = "count_down";
    public static final String STYLE_IMAGE = "image";
    public static final String STYLE_TEXT = "text";

    @SerializedName("color")
    private final String color;

    @SerializedName("corner_radius")
    private final int cornerRadius;

    @SerializedName(LynxResourceModule.FONT_TYPE)
    private final String font;

    @SerializedName("font_size")
    private final int fontSize;

    @SerializedName(FontsContractCompat.Columns.WEIGHT)
    private final int fontWeight;

    @SerializedName("height")
    private final int height;

    @SerializedName(VideoThumbInfo.KEY_IMG_URL)
    private final UrlModel imageUrl;

    @SerializedName("margin_left")
    private final int marginLeft;

    @SerializedName("margin_right")
    private final int marginRight;

    @SerializedName("text")
    private final String text;

    @SerializedName("timestamp")
    private final long timestamp;

    @SerializedName("type")
    private final String type;

    @SerializedName("width")
    private final int width;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public TagDesc() {
        this(null, null, null, 0, null, 0, null, 0, 0, 0, 0, 0, 0, 8191, null);
    }

    public static /* synthetic */ TagDesc copy$default(TagDesc r110, String r111, String r112, String r113, int r114, String r210, int r211, UrlModel r212, int r213, int r214, long r215, int r216, int r217, int r218, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = r110.type;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = r110.text;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = r110.color;
    L15:
        if ((r310 & 8) == 0) goto L17;
        int r103 = r110.fontSize;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.font;
    L23:
        if ((r310 & 32) == 0) goto L25;
        int r105 = r110.fontWeight;
    L27:
        if ((r310 & 64) == 0) goto L29;
        UrlModel r106 = r110.imageUrl;
    L31:
        if ((r310 & 128) == 0) goto L33;
        int r107 = r110.marginLeft;
    L35:
        if ((r310 & 256) == 0) goto L37;
        int r115 = r110.marginRight;
    L39:
        if ((r310 & 512) == 0) goto L41;
        long r116 = r110.timestamp;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        int r117 = r110.width;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        int r118 = r110.height;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        int r108 = r110.cornerRadius;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r108);
    L53:
        r108 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
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
        return this.type;
    }

    public final long component10() {
        return this.timestamp;
    }

    public final int component11() {
        return this.width;
    }

    public final int component12() {
        return this.height;
    }

    public final int component13() {
        return this.cornerRadius;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.color;
    }

    public final int component4() {
        return this.fontSize;
    }

    public final String component5() {
        return this.font;
    }

    public final int component6() {
        return this.fontWeight;
    }

    public final UrlModel component7() {
        return this.imageUrl;
    }

    public final int component8() {
        return this.marginLeft;
    }

    public final int component9() {
        return this.marginRight;
    }

    public final TagDesc copy(String r110, String r111, String r112, int r210, String r211, int r212, UrlModel r213, int r214, int r215, long r216, int r217, int r218, int r310) {
        return new TagDesc(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TagDesc) == true) goto L8;
        return false;
    L8:
        TagDesc r101 = (TagDesc) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L18;
        return false;
    L18:
        if (this.fontSize == r101.fontSize) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.font, r101.font) == true) goto L24;
        return false;
    L24:
        if (this.fontWeight == r101.fontWeight) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L30;
        return false;
    L30:
        if (this.marginLeft == r101.marginLeft) goto L33;
        return false;
    L33:
        if (this.marginRight == r101.marginRight) goto L36;
        return false;
    L36:
        if (this.timestamp == r101.timestamp) goto L39;
        return false;
    L39:
        if (this.width == r101.width) goto L42;
        return false;
    L42:
        if (this.height == r101.height) goto L45;
        return false;
    L45:
        if (this.cornerRadius == r101.cornerRadius) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.text;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.color;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.fontSize) * 31;
        String r110 = this.font;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.fontWeight) * 31;
        UrlModel r113 = this.imageUrl;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (((((r112 + r101) * 31) + this.marginLeft) * 31) + this.marginRight) * 31;
        long r115 = this.timestamp;
        return ((((((r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31) + this.width) * 31) + this.height) * 31) + this.cornerRadius;
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
        return "TagDesc(type=" + this.type + ", text=" + this.text + ", color=" + this.color + ", fontSize=" + this.fontSize + ", font=" + this.font + ", fontWeight=" + this.fontWeight + ", imageUrl=" + this.imageUrl + ", marginLeft=" + this.marginLeft + ", marginRight=" + this.marginRight + ", timestamp=" + this.timestamp + ", width=" + this.width + ", height=" + this.height + ", cornerRadius=" + this.cornerRadius + ')';
    }

    public final String getColor() {
        return this.color;
    }

    public final int getCornerRadius() {
        return this.cornerRadius;
    }

    public final String getFont() {
        return this.font;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final int getFontWeight() {
        return this.fontWeight;
    }

    public final int getHeight() {
        return this.height;
    }

    public final UrlModel getImageUrl() {
        return this.imageUrl;
    }

    public final int getMarginLeft() {
        return this.marginLeft;
    }

    public final int getMarginRight() {
        return this.marginRight;
    }

    public final String getText() {
        return this.text;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    public TagDesc(String r100, String r101, String r102, int r103, String r104, int r105, UrlModel r106, int r107, int r108, long r110, int r111, int r112, int r113) {
        this.type = r100;
        this.text = r101;
        this.color = r102;
        this.fontSize = r103;
        this.font = r104;
        this.fontWeight = r105;
        this.imageUrl = r106;
        this.marginLeft = r107;
        this.marginRight = r108;
        this.timestamp = r110;
        this.width = r111;
        this.height = r112;
        this.cornerRadius = r113;
    }

    public /* synthetic */ TagDesc(String r110, String r111, String r112, int r113, String r210, int r211, UrlModel r212, int r213, int r214, long r215, int r216, int r217, int r218, int r310, DefaultConstructorMarker r311) {
        UrlModel r100 = null;
        if ((r310 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r103 = null;
    L14:
        int r104 = 0;
        if ((r310 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        int r107 = 0;
    L27:
        if ((r310 & 64) != 0) goto L31;
        r100 = r212;
    L31:
        if ((r310 & 128) == 0) goto L33;
        int r108 = 0;
    L35:
        if ((r310 & 256) == 0) goto L37;
        int r114 = 0;
    L39:
        if ((r310 & 512) == 0) goto L41;
        long r115 = 0;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        int r116 = 0;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        int r117 = 0;
    L51:
        if ((r310 & 4096) != 0) goto L54;
        r104 = r218;
    L54:
        this(r101, r102, r103, r105, r106, r107, r100, r108, r114, r115, r116, r117, r104);
        return;
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L25:
        r107 = r211;
        goto L27
    L21:
        r106 = r210;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
