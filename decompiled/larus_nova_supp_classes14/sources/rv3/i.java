package rv3;

import com.bytedance.applet.aibridge.navi.NavigationPageFrom;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
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

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.mode, r6.mode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.startPoint, r6.startPoint) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.endPoint, r6.endPoint) == true) goto L18;
        return false;
    L18:
        if (this.from == r6.from) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.routeMode, r6.routeMode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.routePlanType, r6.routePlanType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.prefer, r6.prefer) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.verbalMode, r6.verbalMode) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.navigateUniqueId, r6.navigateUniqueId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.isQuickRestart, r6.isQuickRestart) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.ridingType, r6.ridingType) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.businessId, r6.businessId) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.poiId, r6.poiId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.poiType, r6.poiType) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.coordType, r6.coordType) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.rotationChangeMinInterval, r6.rotationChangeMinInterval) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.waypoints, r6.waypoints) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.endPoiId, r6.endPoiId) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.endPoiIdType, r6.endPoiIdType) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.outlinkId, r6.outlinkId) == true) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        String r0 = this.mode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        j r4 = this.startPoint;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        j r7 = this.endPoint;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        NavigationPageFrom r10 = this.from;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.routeMode;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.routePlanType;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.prefer;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.verbalMode;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.navigateUniqueId;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.botId;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.conversationId;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Boolean r34 = this.isQuickRestart;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Integer r37 = this.ridingType;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.businessId;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.poiId;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.poiType;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        Integer r49 = this.coordType;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        Integer r52 = this.rotationChangeMinInterval;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        List<l> r55 = this.waypoints;
        if (r55 != null) goto L77;
        int r56 = 0;
    L78:
        int r57 = (r54 + r56) * 31;
        String r58 = this.endPoiId;
        if (r58 != null) goto L81;
        int r59 = 0;
    L82:
        int r60 = (r57 + r59) * 31;
        String r61 = this.endPoiIdType;
        if (r61 != null) goto L85;
        int r62 = 0;
    L86:
        int r63 = (r60 + r62) * 31;
        String r64 = this.outlinkId;
        if (r64 == null) goto L91;
        r1 = r64.hashCode();
    L91:
        return r63 + r1;
    L85:
        r62 = r61.hashCode();
        goto L86
    L81:
        r59 = r58.hashCode();
        goto L82
    L77:
        r56 = r55.hashCode();
        goto L78
    L73:
        r53 = r52.hashCode();
        goto L74
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
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

    public static i a(i r27, j r28, j r29, NavigationPageFrom r30, String r31, List r32, int r33) {
        String r3 = null;
        if ((r33 & 1) == 0) goto L5;
        String r5 = r27.mode;
    L7:
        if ((r33 & 2) == 0) goto L9;
        j r6 = r27.startPoint;
    L11:
        if ((r33 & 4) == 0) goto L13;
        j r7 = r27.endPoint;
    L15:
        if ((r33 & 8) == 0) goto L17;
        NavigationPageFrom r8 = r27.from;
    L19:
        if ((r33 & 16) == 0) goto L21;
        String r9 = r27.routeMode;
    L23:
        if ((r33 & 32) == 0) goto L25;
        Integer r10 = r27.routePlanType;
    L27:
        if ((r33 & 64) == 0) goto L29;
        Integer r11 = r27.prefer;
    L31:
        if ((r33 & 128) == 0) goto L33;
        Integer r12 = r27.verbalMode;
    L35:
        if ((r33 & 256) == 0) goto L37;
        String r13 = r27.navigateUniqueId;
    L39:
        if ((r33 & 512) == 0) goto L41;
        String r14 = r27.botId;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        String r15 = r27.conversationId;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        Boolean r16 = r27.isQuickRestart;
    L51:
        if ((r33 & 4096) == 0) goto L53;
        Integer r17 = r27.ridingType;
    L55:
        if ((r33 & 8192) == 0) goto L57;
        String r18 = r27.businessId;
    L59:
        if ((r33 & 16384) == 0) goto L61;
        String r19 = r27.poiId;
    L63:
        if ((32768 & r33) == 0) goto L65;
        String r20 = r27.poiType;
    L67:
        if ((65536 & r33) == 0) goto L69;
        Integer r21 = r27.coordType;
    L71:
        if ((131072 & r33) == 0) goto L73;
        Integer r22 = r27.rotationChangeMinInterval;
    L75:
        if ((262144 & r33) == 0) goto L77;
        List r23 = r27.waypoints;
    L79:
        if ((524288 & r33) == 0) goto L81;
        String r24 = r27.endPoiId;
    L83:
        if ((1048576 & r33) == 0) goto L85;
        String r25 = r27.endPoiIdType;
    L87:
        if ((r33 & 2097152) == 0) goto L89;
        r3 = r27.outlinkId;
    L89:
        r27.getClass();
        return new i(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r3);
    L85:
        r25 = null;
        goto L87
    L81:
        r24 = null;
        goto L83
    L77:
        r23 = r32;
        goto L79
    L73:
        r22 = null;
        goto L75
    L69:
        r21 = null;
        goto L71
    L65:
        r20 = null;
        goto L67
    L61:
        r19 = null;
        goto L63
    L57:
        r18 = null;
        goto L59
    L53:
        r17 = null;
        goto L55
    L49:
        r16 = null;
        goto L51
    L45:
        r15 = null;
        goto L47
    L41:
        r14 = null;
        goto L43
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = null;
        goto L27
    L21:
        r9 = r31;
        goto L23
    L17:
        r8 = r30;
        goto L19
    L13:
        r7 = r29;
        goto L15
    L9:
        r6 = r28;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public /* synthetic */ i(String r26, j r27, j r28, NavigationPageFrom r29, String r30, List r31, String r32, String r33, String r34, int r35) {
        if ((r35 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r35 & 2) == 0) goto L9;
        j r4 = null;
    L11:
        if ((r35 & 4) == 0) goto L13;
        j r5 = null;
    L15:
        if ((r35 & 8) == 0) goto L17;
        NavigationPageFrom r6 = null;
    L19:
        if ((r35 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r35 & 262144) == 0) goto L25;
        List r21 = null;
    L27:
        if ((r35 & 524288) == 0) goto L29;
        String r22 = null;
    L31:
        if ((r35 & 1048576) == 0) goto L33;
        String r23 = null;
    L35:
        if ((r35 & 2097152) == 0) goto L37;
        String r24 = null;
    L38:
        this(r3, r4, r5, r6, r7, null, null, null, null, null, null, null, null, null, null, null, null, null, r21, r22, r23, r24);
        return;
    L37:
        r24 = r34;
        goto L38
    L33:
        r23 = r33;
        goto L35
    L29:
        r22 = r32;
        goto L31
    L25:
        r21 = r31;
        goto L27
    L21:
        r7 = r30;
        goto L23
    L17:
        r6 = r29;
        goto L19
    L13:
        r5 = r28;
        goto L15
    L9:
        r4 = r27;
        goto L11
    L5:
        r3 = r26;
        goto L7
    }

    public i(String r3, j r4, j r5, NavigationPageFrom r6, String r7, Integer r8, Integer r9, Integer r10, String r11, String r12, String r13, Boolean r14, Integer r15, String r16, String r17, String r18, Integer r19, Integer r20, List<l> r21, String r22, String r23, String r24) {
        this.mode = r3;
        this.startPoint = r4;
        this.endPoint = r5;
        this.from = r6;
        this.routeMode = r7;
        this.routePlanType = r8;
        this.prefer = r9;
        this.verbalMode = r10;
        this.navigateUniqueId = r11;
        this.botId = r12;
        this.conversationId = r13;
        this.isQuickRestart = r14;
        this.ridingType = r15;
        this.businessId = r16;
        this.poiId = r17;
        this.poiType = r18;
        this.coordType = r19;
        this.rotationChangeMinInterval = r20;
        this.waypoints = r21;
        this.endPoiId = r22;
        this.endPoiIdType = r23;
        this.outlinkId = r24;
    }
}
