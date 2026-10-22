package dv3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationVisualInstruction;", "", "distanceToOrigin", "", "distanceToCurrent", "position", "Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationPoint;", "turnDescription", "Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationTurnDescription;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationPoint;Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationTurnDescription;)V", "getDistanceToOrigin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDistanceToCurrent", "getPosition", "()Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationPoint;", "getTurnDescription", "()Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationTurnDescription;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationPoint;Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationTurnDescription;)Lcom/bytedance/applet/aibridge/baidunavi/bean/NavigationVisualInstruction;", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h {

    @SerializedName("distanceToCurrent")
    private final Integer distanceToCurrent;

    @SerializedName("distanceToOrigin")
    private final Integer distanceToOrigin;

    @SerializedName("position")
    private final b position;

    @SerializedName("turnDescription")
    private final g turnDescription;

    public h() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.distanceToOrigin, r6.distanceToOrigin) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.distanceToCurrent, r6.distanceToCurrent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.position, r6.position) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.turnDescription, r6.turnDescription) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.distanceToOrigin;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.distanceToCurrent;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        b r7 = this.position;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        g r10 = this.turnDescription;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "NavigationVisualInstruction(distanceToOrigin=" + this.distanceToOrigin + ", distanceToCurrent=" + this.distanceToCurrent + ", position=" + this.position + ", turnDescription=" + this.turnDescription + ')';
    }

    public h(Integer r1, Integer r2, b r3, g r4) {
        this.distanceToOrigin = r1;
        this.distanceToCurrent = r2;
        this.position = r3;
        this.turnDescription = r4;
    }
}
