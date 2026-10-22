package ul9;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u001e\u001a\u00020\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\u0013\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u0013\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\fHÆ\u0003Ju\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\fHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\tHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c¨\u0006-"}, d2 = {"Lcom/larus/navigation/api/baidu/bean/BaiduNaviRouteInfo;", "", "routeId", "", "tag", "start", "Lcom/larus/navigation/api/baidu/bean/BaiduNaviGeoPoint;", "end", "distance", "", "duration", "steps", "", "Lcom/larus/navigation/api/baidu/bean/BaiduNaviRouteStep;", "guideInfo", "Lcom/larus/navigation/api/baidu/bean/BaiduNaviGuideInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/navigation/api/baidu/bean/BaiduNaviGeoPoint;Lcom/larus/navigation/api/baidu/bean/BaiduNaviGeoPoint;IILjava/util/List;Ljava/util/List;)V", "getRouteId", "()Ljava/lang/String;", "getTag", "getStart", "()Lcom/larus/navigation/api/baidu/bean/BaiduNaviGeoPoint;", "getEnd", "getDistance", "()I", "getDuration", "getSteps", "()Ljava/util/List;", "getGuideInfo", "toSimpleString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("distance")
    private final int distance;

    @SerializedName("duration")
    private final int duration;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_DESTINATION)
    private final a end;

    @SerializedName("guide_info")
    private final List<b> guideInfo;

    @SerializedName("route_id")
    private final String routeId;

    @SerializedName(PlayerResolution.SDKKEY.ORIGIN)
    private final a start;

    @SerializedName("steps")
    private final List<h> steps;

    @SerializedName("tag")
    private final String tag;

    public e() {
        this(null, 0, 0, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.routeId, r101.routeId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.start, r101.start) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.end, r101.end) == true) goto L21;
        return false;
    L21:
        if (this.distance == r101.distance) goto L24;
        return false;
    L24:
        if (this.duration == r101.duration) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.steps, r101.steps) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.guideInfo, r101.guideInfo) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.routeId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.tag;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.start;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        a r110 = this.end;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((((r109 + r111) * 31) + this.distance) * 31) + this.duration) * 31;
        List<h> r113 = this.steps;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<b> r116 = this.guideInfo;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "BaiduNaviRouteInfo(routeId=" + this.routeId + ", tag=" + this.tag + ", start=" + this.start + ", end=" + this.end + ", distance=" + this.distance + ", duration=" + this.duration + ", steps=" + this.steps + ", guideInfo=" + this.guideInfo + ')';
    }

    public final String i() {
        List<h> r100 = this.steps;
        Object r101 = null;
        if (r100 == null) goto L7;
        h r102 = (h) CollectionsKt.firstOrNull(r100);
        if (r102 == null) goto L7;
        d r103 = r102.a();
    L8:
        if (r103 == null) goto L12;
        List<vl9.d> r104 = r103.b();
        if (r104 == null) goto L12;
        vl9.d r105 = (vl9.d) CollectionsKt.firstOrNull(r104);
    L13:
        if (r103 == null) goto L17;
        List<vl9.c> r106 = r103.a();
        if (r106 == null) goto L17;
        vl9.c r107 = (vl9.c) CollectionsKt.firstOrNull(r106);
    L19:
        if (tl9.b.a() == false) goto L25;
        StringBuilder r108 = new StringBuilder("routeId:");
        r108.append(this.routeId);
        r108.append(";distance:");
        r108.append(this.distance);
        r108.append(";duration:");
        r108.append(this.duration);
        r108.append(";step_size:");
        List<h> r109 = this.steps;
        if (r109 == null) goto L23;
        r101 = Integer.valueOf(r109.size());
    L23:
        r108.append(r101);
        r108.append(";visual:");
        r108.append(r105);
        r108.append(";verbal:");
        r108.append(r107);
        return r108.toString();
    L25:
        if (r107 == null) goto L29;
        List<vl9.b> r110 = r107.b();
        if (r110 == null) goto L29;
        vl9.b r111 = (vl9.b) CollectionsKt.firstOrNull(r110);
    L30:
        StringBuilder r112 = new StringBuilder("routeId:");
        r112.append(this.routeId);
        r112.append(";distance:");
        r112.append(this.distance);
        r112.append(";duration:");
        r112.append(this.duration);
        r112.append(";step_size:");
        List<h> r113 = this.steps;
        if (r113 == null) goto L33;
        Integer r114 = Integer.valueOf(r113.size());
    L34:
        r112.append(r114);
        r112.append(";visual:[d2C:");
        if (r105 == null) goto L37;
        Integer r115 = Integer.valueOf(r105.a());
    L38:
        r112.append(r115);
        r112.append(",d2O:");
        if (r105 == null) goto L41;
        Integer r116 = Integer.valueOf(r105.b());
    L42:
        r112.append(r116);
        r112.append(",turnKind:");
        if (r105 == null) goto L47;
        vl9.a r117 = r105.d();
        if (r117 == null) goto L47;
        Integer r118 = Integer.valueOf(r117.a());
    L48:
        r112.append(r118);
        r112.append("];verbal:[d2O:");
        if (r107 == null) goto L51;
        Integer r119 = Integer.valueOf(r107.a());
    L52:
        r112.append(r119);
        r112.append(",d2G:");
        if (r111 == null) goto L55;
        Integer r120 = Integer.valueOf(r111.b());
    L56:
        r112.append(r120);
        r112.append(",d2S:");
        if (r111 == null) goto L59;
        Integer r121 = Integer.valueOf(r111.c());
    L60:
        r112.append(r121);
        r112.append("alreadySent:");
        if (r111 == null) goto L63;
        r101 = Boolean.valueOf(r111.a());
    L63:
        r112.append(r101);
        r112.append(']');
        return r112.toString();
    L59:
        r121 = null;
        goto L60
    L55:
        r120 = null;
        goto L56
    L51:
        r119 = null;
    L47:
        r118 = null;
        goto L48
    L41:
        r116 = null;
        goto L42
    L37:
        r115 = null;
        goto L38
    L33:
        r114 = null;
    L29:
        r111 = null;
    L17:
        r107 = null;
    L12:
        r105 = null;
    L7:
        r103 = null;
        goto L8
    }

    public final int a() {
        return this.distance;
    }

    public final int b() {
        return this.duration;
    }

    public final a c() {
        return this.end;
    }

    public final List<b> d() {
        return this.guideInfo;
    }

    public final String e() {
        return this.routeId;
    }

    public final a f() {
        return this.start;
    }

    public final List<h> g() {
        return this.steps;
    }

    public final String h() {
        return this.tag;
    }

    public e(String r100, int r101, int r102, List r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 16) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 32) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 64) == 0) goto L14;
        r103 = null;
    L14:
        this.routeId = r100;
        this.tag = null;
        this.start = null;
        this.end = null;
        this.distance = r101;
        this.duration = r102;
        this.steps = r103;
        this.guideInfo = null;
    }
}
