package rv3;

import com.bytedance.applet.aibridge.navi.NavigationPageFrom;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b?\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001f\u0010 J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010D\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010E\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010J\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010O\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010*J\u0013\u0010P\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009e\u0002\u0010T\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010UJ\u0013\u0010V\u001a\u00020\u00122\b\u0010W\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010X\u001a\u00020\u000bHÖ\u0001J\t\u0010Y\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b,\u0010*R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b-\u0010*R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00102\u001a\u0004\b\u0011\u00101R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b3\u0010*R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\"R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b7\u0010*R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010+\u001a\u0004\b8\u0010*R \u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\"R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\"R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\"¨\u0006Z"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/NavigationPageData;", "", "mode", "", "startPoint", "Lcom/bytedance/applet/aibridge/navi/NavigationPagePoint;", "endPoint", "from", "Lcom/bytedance/applet/aibridge/navi/NavigationPageFrom;", "routeMode", "routePlanType", "", "prefer", "verbalMode", "navigateUniqueId", "botId", "conversationId", "isQuickRestart", "", "ridingType", "businessId", "poiId", "poiType", "coordType", "rotationChangeMinInterval", "waypoints", "", "Lcom/bytedance/applet/aibridge/navi/NavigationPageWaypoint;", "endPoiId", "endPoiIdType", "outlinkId", "<init>", "(Ljava/lang/String;Lcom/bytedance/applet/aibridge/navi/NavigationPagePoint;Lcom/bytedance/applet/aibridge/navi/NavigationPagePoint;Lcom/bytedance/applet/aibridge/navi/NavigationPageFrom;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMode", "()Ljava/lang/String;", "getStartPoint", "()Lcom/bytedance/applet/aibridge/navi/NavigationPagePoint;", "getEndPoint", "getFrom", "()Lcom/bytedance/applet/aibridge/navi/NavigationPageFrom;", "getRouteMode", "getRoutePlanType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPrefer", "getVerbalMode", "getNavigateUniqueId", "getBotId", "getConversationId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRidingType", "getBusinessId", "getPoiId", "getPoiType", "getCoordType", "getRotationChangeMinInterval", "getWaypoints", "()Ljava/util/List;", "getEndPoiId", "getEndPoiIdType", "getOutlinkId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(Ljava/lang/String;Lcom/bytedance/applet/aibridge/navi/NavigationPagePoint;Lcom/bytedance/applet/aibridge/navi/NavigationPagePoint;Lcom/bytedance/applet/aibridge/navi/NavigationPageFrom;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/applet/aibridge/navi/NavigationPageData;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    @SerializedName("botId")
    private final String botId;

    @SerializedName("businessId")
    private final String businessId;

    @SerializedName("conversationId")
    private final String conversationId;

    @SerializedName("coordType")
    private final Integer coordType;

    @SerializedName("endPoiId")
    private final String endPoiId;

    @SerializedName("endPoiIdType")
    private final String endPoiIdType;

    @SerializedName("endPoint")
    private final j endPoint;

    @SerializedName("from")
    private final NavigationPageFrom from;

    @SerializedName("isQuickRestart")
    private final Boolean isQuickRestart;

    @SerializedName("mode")
    private final String mode;

    @SerializedName("navigateUniqueId")
    private final String navigateUniqueId;

    @SerializedName("outlinkId")
    private final String outlinkId;

    @SerializedName("poiId")
    private final String poiId;

    @SerializedName("poiType")
    private final String poiType;

    @SerializedName("prefer")
    private final Integer prefer;

    @SerializedName("ridingType")
    private final Integer ridingType;

    @SerializedName("rotationChangeMinInterval")
    private final Integer rotationChangeMinInterval;

    @SerializedName("routeMode")
    private final String routeMode;

    @SerializedName("routePlanType")
    private final Integer routePlanType;

    @SerializedName("startPoint")
    private final j startPoint;

    @SerializedName("verbalMode")
    private final Integer verbalMode;

    @SerializedName("waypoints")
    private final List<l> waypoints;

    public i() {
        this(null, null, null, null, null, null, null, null, null, 4194303);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.mode, r101.mode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.startPoint, r101.startPoint) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.endPoint, r101.endPoint) == true) goto L18;
        return false;
    L18:
        if (this.from == r101.from) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.routeMode, r101.routeMode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.routePlanType, r101.routePlanType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.prefer, r101.prefer) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.verbalMode, r101.verbalMode) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.navigateUniqueId, r101.navigateUniqueId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.isQuickRestart, r101.isQuickRestart) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.ridingType, r101.ridingType) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.businessId, r101.businessId) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.poiId, r101.poiId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.poiType, r101.poiType) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.coordType, r101.coordType) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.rotationChangeMinInterval, r101.rotationChangeMinInterval) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.waypoints, r101.waypoints) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.endPoiId, r101.endPoiId) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.endPoiIdType, r101.endPoiIdType) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.outlinkId, r101.outlinkId) == true) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        String r100 = this.mode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        j r104 = this.startPoint;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        j r107 = this.endPoint;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        NavigationPageFrom r110 = this.from;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.routeMode;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.routePlanType;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.prefer;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.verbalMode;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.navigateUniqueId;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.botId;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.conversationId;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.isQuickRestart;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.ridingType;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.businessId;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.poiId;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.poiType;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Integer r149 = this.coordType;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        Integer r152 = this.rotationChangeMinInterval;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        List<l> r155 = this.waypoints;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.endPoiId;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        String r161 = this.endPoiIdType;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        String r164 = this.outlinkId;
        if (r164 == null) goto L91;
        r101 = r164.hashCode();
    L91:
        return r163 + r101;
    L85:
        r162 = r161.hashCode();
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
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
        return "NavigationPageData(mode=" + this.mode + ", startPoint=" + this.startPoint + ", endPoint=" + this.endPoint + ", from=" + this.from + ", routeMode=" + this.routeMode + ", routePlanType=" + this.routePlanType + ", prefer=" + this.prefer + ", verbalMode=" + this.verbalMode + ", navigateUniqueId=" + this.navigateUniqueId + ", botId=" + this.botId + ", conversationId=" + this.conversationId + ", isQuickRestart=" + this.isQuickRestart + ", ridingType=" + this.ridingType + ", businessId=" + this.businessId + ", poiId=" + this.poiId + ", poiType=" + this.poiType + ", coordType=" + this.coordType + ", rotationChangeMinInterval=" + this.rotationChangeMinInterval + ", waypoints=" + this.waypoints + ", endPoiId=" + this.endPoiId + ", endPoiIdType=" + this.endPoiIdType + ", outlinkId=" + this.outlinkId + ')';
    }

    public final String b() {
        return this.endPoiId;
    }

    public final String c() {
        return this.endPoiIdType;
    }

    public final j d() {
        return this.endPoint;
    }

    public final String e() {
        return this.mode;
    }

    public final String f() {
        return this.outlinkId;
    }

    public final j g() {
        return this.startPoint;
    }

    public final List<l> h() {
        return this.waypoints;
    }

    public static i a(i r210, j r211, j r212, NavigationPageFrom r310, String r311, List r312, int r313) {
        String r100 = null;
        if ((r313 & 1) == 0) goto L5;
        String r101 = r210.mode;
    L7:
        if ((r313 & 2) == 0) goto L9;
        j r102 = r210.startPoint;
    L11:
        if ((r313 & 4) == 0) goto L13;
        j r103 = r210.endPoint;
    L15:
        if ((r313 & 8) == 0) goto L17;
        NavigationPageFrom r104 = r210.from;
    L19:
        if ((r313 & 16) == 0) goto L21;
        String r105 = r210.routeMode;
    L23:
        if ((r313 & 32) == 0) goto L25;
        Integer r110 = r210.routePlanType;
    L27:
        if ((r313 & 64) == 0) goto L29;
        Integer r111 = r210.prefer;
    L31:
        if ((r313 & 128) == 0) goto L33;
        Integer r112 = r210.verbalMode;
    L35:
        if ((r313 & 256) == 0) goto L37;
        String r113 = r210.navigateUniqueId;
    L39:
        if ((r313 & 512) == 0) goto L41;
        String r114 = r210.botId;
    L43:
        if ((r313 & 1024) == 0) goto L45;
        String r115 = r210.conversationId;
    L47:
        if ((r313 & 2048) == 0) goto L49;
        Boolean r116 = r210.isQuickRestart;
    L51:
        if ((r313 & 4096) == 0) goto L53;
        Integer r117 = r210.ridingType;
    L55:
        if ((r313 & 8192) == 0) goto L57;
        String r118 = r210.businessId;
    L59:
        if ((r313 & 16384) == 0) goto L61;
        String r119 = r210.poiId;
    L63:
        if ((32768 & r313) == 0) goto L65;
        String r213 = r210.poiType;
    L67:
        if ((65536 & r313) == 0) goto L69;
        Integer r214 = r210.coordType;
    L71:
        if ((131072 & r313) == 0) goto L73;
        Integer r215 = r210.rotationChangeMinInterval;
    L75:
        if ((262144 & r313) == 0) goto L77;
        List r216 = r210.waypoints;
    L79:
        if ((524288 & r313) == 0) goto L81;
        String r217 = r210.endPoiId;
    L83:
        if ((1048576 & r313) == 0) goto L85;
        String r218 = r210.endPoiIdType;
    L87:
        if ((r313 & 2097152) == 0) goto L89;
        r100 = r210.outlinkId;
    L89:
        r210.getClass();
        return new i(r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r213, r214, r215, r216, r217, r218, r100);
    L85:
        r218 = null;
        goto L87
    L81:
        r217 = null;
        goto L83
    L77:
        r216 = r312;
        goto L79
    L73:
        r215 = null;
        goto L75
    L69:
        r214 = null;
        goto L71
    L65:
        r213 = null;
        goto L67
    L61:
        r119 = null;
        goto L63
    L57:
        r118 = null;
        goto L59
    L53:
        r117 = null;
        goto L55
    L49:
        r116 = null;
        goto L51
    L45:
        r115 = null;
        goto L47
    L41:
        r114 = null;
        goto L43
    L37:
        r113 = null;
        goto L39
    L33:
        r112 = null;
        goto L35
    L29:
        r111 = null;
        goto L31
    L25:
        r110 = null;
        goto L27
    L21:
        r105 = r311;
        goto L23
    L17:
        r104 = r310;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ i(String r210, j r211, j r212, NavigationPageFrom r213, String r310, List r311, String r312, String r313, String r314, int r315) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r315 & 2) == 0) goto L9;
        j r101 = null;
    L11:
        if ((r315 & 4) == 0) goto L13;
        j r102 = null;
    L15:
        if ((r315 & 8) == 0) goto L17;
        NavigationPageFrom r103 = null;
    L19:
        if ((r315 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r315 & 262144) == 0) goto L25;
        List r214 = null;
    L27:
        if ((r315 & 524288) == 0) goto L29;
        String r215 = null;
    L31:
        if ((r315 & 1048576) == 0) goto L33;
        String r216 = null;
    L35:
        if ((r315 & 2097152) == 0) goto L37;
        String r217 = null;
    L38:
        this(r100, r101, r102, r103, r104, null, null, null, null, null, null, null, null, null, null, null, null, null, r214, r215, r216, r217);
        return;
    L37:
        r217 = r314;
        goto L38
    L33:
        r216 = r313;
        goto L35
    L29:
        r215 = r312;
        goto L31
    L25:
        r214 = r311;
        goto L27
    L21:
        r104 = r310;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public i(String r100, j r101, j r102, NavigationPageFrom r103, String r104, Integer r105, Integer r106, Integer r110, String r111, String r112, String r113, Boolean r114, Integer r115, String r116, String r117, String r118, Integer r119, Integer r210, List<l> r211, String r212, String r213, String r214) {
        this.mode = r100;
        this.startPoint = r101;
        this.endPoint = r102;
        this.from = r103;
        this.routeMode = r104;
        this.routePlanType = r105;
        this.prefer = r106;
        this.verbalMode = r110;
        this.navigateUniqueId = r111;
        this.botId = r112;
        this.conversationId = r113;
        this.isQuickRestart = r114;
        this.ridingType = r115;
        this.businessId = r116;
        this.poiId = r117;
        this.poiType = r118;
        this.coordType = r119;
        this.rotationChangeMinInterval = r210;
        this.waypoints = r211;
        this.endPoiId = r212;
        this.endPoiIdType = r213;
        this.outlinkId = r214;
    }
}
