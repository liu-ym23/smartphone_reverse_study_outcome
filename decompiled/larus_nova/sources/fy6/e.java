package fy6;

import com.bytedance.locallife.model.poi.resp.PoiDistanceModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016R\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010'\u001a\u0004\b+\u0010)R\u001c\u0010,\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)¨\u0006."}, d2 = {"Lfy6/e;", "", "", "Lfy6/h;", "leftItems", "Ljava/util/List;", "getLeftItems", "()Ljava/util/List;", "rightItems", "getRightItems", "Lfy6/i;", "richInfo", "Lfy6/i;", "getRichInfo", "()Lfy6/i;", "Leo6/c;", "moreOptionItems", "getMoreOptionItems", "", "morePopSchema", "Ljava/lang/String;", "getMorePopSchema", "()Ljava/lang/String;", "Lfy6/g;", "poiFeedbackIcon", "Lfy6/g;", "getPoiFeedbackIcon", "()Lfy6/g;", "poiImageUploadIcon", "e", "userType", "getUserType", "Lcom/google/gson/JsonObject;", "naviActionGroup", "Lcom/google/gson/JsonObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/google/gson/JsonObject;", "Lcom/bytedance/locallife/model/poi/resp/PoiDistanceModel;", "naviBgStartOffset", "Lcom/bytedance/locallife/model/poi/resp/PoiDistanceModel;", "c", "()Lcom/bytedance/locallife/model/poi/resp/PoiDistanceModel;", "naviBgEndOffset", "b", "naviIconChangeOffset", "d", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("left_items")
    private final List<h> leftItems;

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

    @SerializedName("navi_icon_change_offset")
    private final PoiDistanceModel naviIconChangeOffset;

    @SerializedName("poi_feedback_icon")
    private final g poiFeedbackIcon;

    @SerializedName("poi_image_upload_icon")
    private final g poiImageUploadIcon;

    @SerializedName("rich_info")
    private final i richInfo;

    @SerializedName("right_items")
    private final List<h> rightItems;

    @SerializedName("user_type")
    private final String userType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.leftItems, r101.leftItems) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightItems, r101.rightItems) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.richInfo, r101.richInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.moreOptionItems, r101.moreOptionItems) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.morePopSchema, r101.morePopSchema) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.poiFeedbackIcon, r101.poiFeedbackIcon) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.poiImageUploadIcon, r101.poiImageUploadIcon) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.userType, r101.userType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.naviActionGroup, r101.naviActionGroup) == true) goto L36;
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
        List<h> r100 = this.leftItems;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<h> r104 = this.rightItems;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        i r107 = this.richInfo;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<eo6.c> r110 = this.moreOptionItems;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.morePopSchema;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        g r116 = this.poiFeedbackIcon;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        g r119 = this.poiImageUploadIcon;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.userType;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        JsonObject r125 = this.naviActionGroup;
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
        return "PoiDetailNavigationData(leftItems=" + this.leftItems + ", rightItems=" + this.rightItems + ", richInfo=" + this.richInfo + ", moreOptionItems=" + this.moreOptionItems + ", morePopSchema=" + this.morePopSchema + ", poiFeedbackIcon=" + this.poiFeedbackIcon + ", poiImageUploadIcon=" + this.poiImageUploadIcon + ", userType=" + this.userType + ", naviActionGroup=" + this.naviActionGroup + ", naviBgStartOffset=" + this.naviBgStartOffset + ", naviBgEndOffset=" + this.naviBgEndOffset + ", naviIconChangeOffset=" + this.naviIconChangeOffset + ')';
    }

    public e() {
        g r100 = new g(0);
        g r101 = new g(0);
        this.leftItems = null;
        this.rightItems = null;
        this.richInfo = null;
        this.moreOptionItems = null;
        this.morePopSchema = null;
        this.poiFeedbackIcon = r100;
        this.poiImageUploadIcon = r101;
        this.userType = null;
        this.naviActionGroup = null;
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
        return this.naviIconChangeOffset;
    }

    public final g e() {
        return this.poiImageUploadIcon;
    }
}
