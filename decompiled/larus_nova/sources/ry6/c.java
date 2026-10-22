package ry6;

import com.bytedance.locallife.model.poi.resp.PoiDistanceModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import fy6.g;
import fy6.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$R\u001c\u0010'\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$R\u001c\u0010)\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\"\u001a\u0004\b*\u0010$R\u001c\u0010+\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\"\u001a\u0004\b,\u0010$¨\u0006-"}, d2 = {"Lry6/c;", "", "", "Leo6/c;", "moreOptionItems", "Ljava/util/List;", "getMoreOptionItems", "()Ljava/util/List;", "Lfy6/i;", "richInfo", "Lfy6/i;", "getRichInfo", "()Lfy6/i;", "", "morePopSchema", "Ljava/lang/String;", "getMorePopSchema", "()Ljava/lang/String;", "Lfy6/g;", "poiFeedbackIcon", "Lfy6/g;", "getPoiFeedbackIcon", "()Lfy6/g;", "poiImgUploadIcon", "getPoiImgUploadIcon", "userType", "getUserType", "Lcom/google/gson/JsonObject;", "naviActionGroup", "Lcom/google/gson/JsonObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/google/gson/JsonObject;", "Lcom/bytedance/locallife/model/poi/resp/PoiDistanceModel;", "naviStartOffset", "Lcom/bytedance/locallife/model/poi/resp/PoiDistanceModel;", "f", "()Lcom/bytedance/locallife/model/poi/resp/PoiDistanceModel;", "naviEndOffset", "d", "naviBgStartOffset", "c", "naviBgEndOffset", "b", "naviIconChangeOffset", "e", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("more_option_items")
    private final List<eo6.c> moreOptionItems;

    @SerializedName("more_option_pop_schema")
    private final String morePopSchema;

    @SerializedName("navi_action_group")
    private final JsonObject naviActionGroup;

    @SerializedName("navi_bg_end_offset")
    private final PoiDistanceModel naviBgEndOffset;

    @SerializedName("navi_bg_start_offset")
    private final PoiDistanceModel naviBgStartOffset;

    @SerializedName("navi_end_offset")
    private final PoiDistanceModel naviEndOffset;

    @SerializedName("navi_icon_change_offset")
    private final PoiDistanceModel naviIconChangeOffset;

    @SerializedName("navi_start_offset")
    private final PoiDistanceModel naviStartOffset;

    @SerializedName("poi_feedback_icon")
    private final g poiFeedbackIcon;

    @SerializedName("poi_image_upload_icon")
    private final g poiImgUploadIcon;

    @SerializedName("rich_info")
    private final i richInfo;

    @SerializedName("user_type")
    private final String userType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.moreOptionItems, r101.moreOptionItems) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.richInfo, r101.richInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.morePopSchema, r101.morePopSchema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.poiFeedbackIcon, r101.poiFeedbackIcon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.poiImgUploadIcon, r101.poiImgUploadIcon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.userType, r101.userType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.naviActionGroup, r101.naviActionGroup) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.naviStartOffset, r101.naviStartOffset) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.naviEndOffset, r101.naviEndOffset) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.naviBgStartOffset, r101.naviBgStartOffset) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.naviBgEndOffset, r101.naviBgEndOffset) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.naviIconChangeOffset, r101.naviIconChangeOffset) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        List<eo6.c> r100 = this.moreOptionItems;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        i r104 = this.richInfo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.morePopSchema;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        g r110 = this.poiFeedbackIcon;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        g r113 = this.poiImgUploadIcon;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.userType;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        JsonObject r119 = this.naviActionGroup;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        PoiDistanceModel r122 = this.naviStartOffset;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        PoiDistanceModel r125 = this.naviEndOffset;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        PoiDistanceModel r128 = this.naviBgStartOffset;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        PoiDistanceModel r131 = this.naviBgEndOffset;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        PoiDistanceModel r134 = this.naviIconChangeOffset;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
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

    public final String toString() {
        return "PoiHeaderData(moreOptionItems=" + this.moreOptionItems + ", richInfo=" + this.richInfo + ", morePopSchema=" + this.morePopSchema + ", poiFeedbackIcon=" + this.poiFeedbackIcon + ", poiImgUploadIcon=" + this.poiImgUploadIcon + ", userType=" + this.userType + ", naviActionGroup=" + this.naviActionGroup + ", naviStartOffset=" + this.naviStartOffset + ", naviEndOffset=" + this.naviEndOffset + ", naviBgStartOffset=" + this.naviBgStartOffset + ", naviBgEndOffset=" + this.naviBgEndOffset + ", naviIconChangeOffset=" + this.naviIconChangeOffset + ')';
    }

    public c() {
        g r100 = new g(0);
        g r101 = new g(0);
        this.moreOptionItems = null;
        this.richInfo = null;
        this.morePopSchema = null;
        this.poiFeedbackIcon = r100;
        this.poiImgUploadIcon = r101;
        this.userType = null;
        this.naviActionGroup = null;
        this.naviStartOffset = null;
        this.naviEndOffset = null;
        this.naviBgStartOffset = null;
        this.naviBgEndOffset = null;
        this.naviIconChangeOffset = null;
    }

    public final JsonObject a() {
        return this.naviActionGroup;
    }

    public final PoiDistanceModel b() {
        return this.naviBgEndOffset;
    }

    public final PoiDistanceModel c() {
        return this.naviBgStartOffset;
    }

    public final PoiDistanceModel d() {
        return this.naviEndOffset;
    }

    public final PoiDistanceModel e() {
        return this.naviIconChangeOffset;
    }

    public final PoiDistanceModel f() {
        return this.naviStartOffset;
    }
}
