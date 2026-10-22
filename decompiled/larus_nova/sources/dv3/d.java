package dv3;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rHÆ\u0003J\u0085\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rHÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\bHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001f¨\u00062"}, d2 = {"Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationRoute;", "", "routeId", "", "start", "Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationPoint;", "end", "distance", "", "duration", "remainDistance", "remainDuration", "steps", "", "Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationStepInfo;", "tag", "visualInstructions", "Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationVisualInstruction;", "<init>", "(Ljava/lang/String;Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationPoint;Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationPoint;IIIILjava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getRouteId", "()Ljava/lang/String;", "getStart", "()Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationPoint;", "getEnd", "getDistance", "()I", "getDuration", "getRemainDistance", "getRemainDuration", "getSteps", "()Ljava/util/List;", "getTag", "getVisualInstructions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("distance")
    private final int distance;

    @SerializedName("duration")
    private final int duration;

    @SerializedName("end")
    private final b end;

    @SerializedName("remainDistance")
    private final int remainDistance;

    @SerializedName("remainDuration")
    private final int remainDuration;

    @SerializedName("routeID")
    private final String routeId;

    @SerializedName("start")
    private final b start;

    @SerializedName("steps")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<f> steps;

    @SerializedName("tag")
    private final String tag;

    @SerializedName("visualInstructions")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<h> visualInstructions;

    public d() {
        this(null, null, null, 0, 0, null, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.routeId, r101.routeId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.start, r101.start) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.end, r101.end) == true) goto L18;
        return false;
    L18:
        if (this.distance == r101.distance) goto L21;
        return false;
    L21:
        if (this.duration == r101.duration) goto L24;
        return false;
    L24:
        if (this.remainDistance == r101.remainDistance) goto L27;
        return false;
    L27:
        if (this.remainDuration == r101.remainDuration) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.steps, r101.steps) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.visualInstructions, r101.visualInstructions) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r100 = this.routeId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        b r104 = this.start;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.end;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((((((((r106 + r108) * 31) + this.distance) * 31) + this.duration) * 31) + this.remainDistance) * 31) + this.remainDuration) * 31;
        List<f> r110 = this.steps;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.tag;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<h> r116 = this.visualInstructions;
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
        return "NavigationRoute(routeId=" + this.routeId + ", start=" + this.start + ", end=" + this.end + ", distance=" + this.distance + ", duration=" + this.duration + ", remainDistance=" + this.remainDistance + ", remainDuration=" + this.remainDuration + ", steps=" + this.steps + ", tag=" + this.tag + ", visualInstructions=" + this.visualInstructions + ')';
    }

    public d(String r100, b r101, b r102, int r103, int r104, List r110, String r111, List r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r113 & 4) == 0) goto L11;
        r102 = null;
    L11:
        int r105 = 0;
        if ((r113 & 8) == 0) goto L15;
        r103 = 0;
    L15:
        if ((r113 & 16) == 0) goto L18;
        r104 = 0;
    L18:
        if ((r113 & 32) == 0) goto L20;
        int r106 = r103;
    L22:
        if ((r113 & 64) == 0) goto L25;
        r105 = r104;
    L25:
        if ((r113 & 128) == 0) goto L28;
        r110 = null;
    L28:
        if ((r113 & 256) == 0) goto L31;
        r111 = null;
    L31:
        if ((r113 & 512) == 0) goto L33;
        r112 = null;
    L33:
        this.routeId = r100;
        this.start = r101;
        this.end = r102;
        this.distance = r103;
        this.duration = r104;
        this.remainDistance = r106;
        this.remainDuration = r105;
        this.steps = r110;
        this.tag = r111;
        this.visualInstructions = r112;
        return;
    L20:
        r106 = 0;
        goto L22
    }
}
