package dv3;

import com.bytedance.apm.constant.UploadTypeInf;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rHÆ\u0003J\u0085\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rHÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\bHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001f¨\u00062"}, d2 = {"Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationRoute;", "", "routeId", "", UploadTypeInf.START, "Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationPoint;", "end", "distance", "", "duration", "remainDistance", "remainDuration", "steps", "", "Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationStepInfo;", "tag", "visualInstructions", "Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationVisualInstruction;", "<init>", "(Ljava/lang/String;Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationPoint;Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationPoint;IIIILjava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getRouteId", "()Ljava/lang/String;", "getStart", "()Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationPoint;", "getEnd", "getDistance", "()I", "getDuration", "getRemainDistance", "getRemainDuration", "getSteps", "()Ljava/util/List;", "getTag", "getVisualInstructions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    @SerializedName(UploadTypeInf.START)
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

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.routeId, r6.routeId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.start, r6.start) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.end, r6.end) == true) goto L18;
        return false;
    L18:
        if (this.distance == r6.distance) goto L21;
        return false;
    L21:
        if (this.duration == r6.duration) goto L24;
        return false;
    L24:
        if (this.remainDistance == r6.remainDistance) goto L27;
        return false;
    L27:
        if (this.remainDuration == r6.remainDuration) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.steps, r6.steps) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.tag, r6.tag) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.visualInstructions, r6.visualInstructions) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r0 = this.routeId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        b r4 = this.start;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        b r7 = this.end;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((((((((r6 + r8) * 31) + this.distance) * 31) + this.duration) * 31) + this.remainDistance) * 31) + this.remainDuration) * 31;
        List<f> r10 = this.steps;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.tag;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<h> r16 = this.visualInstructions;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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
        return "NavigationRoute(routeId=" + this.routeId + ", start=" + this.start + ", end=" + this.end + ", distance=" + this.distance + ", duration=" + this.duration + ", remainDistance=" + this.remainDistance + ", remainDuration=" + this.remainDuration + ", steps=" + this.steps + ", tag=" + this.tag + ", visualInstructions=" + this.visualInstructions + ')';
    }

    public d(String r5, b r6, b r7, int r8, int r9, List r10, String r11, List r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r6 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r7 = null;
    L11:
        int r2 = 0;
        if ((r13 & 8) == 0) goto L15;
        r8 = 0;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r9 = 0;
    L18:
        if ((r13 & 32) == 0) goto L20;
        int r0 = r8;
    L22:
        if ((r13 & 64) == 0) goto L25;
        r2 = r9;
    L25:
        if ((r13 & 128) == 0) goto L28;
        r10 = null;
    L28:
        if ((r13 & 256) == 0) goto L31;
        r11 = null;
    L31:
        if ((r13 & 512) == 0) goto L33;
        r12 = null;
    L33:
        this.routeId = r5;
        this.start = r6;
        this.end = r7;
        this.distance = r8;
        this.duration = r9;
        this.remainDistance = r0;
        this.remainDuration = r2;
        this.steps = r10;
        this.tag = r11;
        this.visualInstructions = r12;
        return;
    L20:
        r0 = 0;
        goto L22
    }
}
