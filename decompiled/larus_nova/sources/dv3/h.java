package dv3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
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

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.distanceToOrigin, r101.distanceToOrigin) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.distanceToCurrent, r101.distanceToCurrent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.turnDescription, r101.turnDescription) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.distanceToOrigin;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.distanceToCurrent;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.position;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        g r110 = this.turnDescription;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "NavigationVisualInstruction(distanceToOrigin=" + this.distanceToOrigin + ", distanceToCurrent=" + this.distanceToCurrent + ", position=" + this.position + ", turnDescription=" + this.turnDescription + ')';
    }

    public h(Integer r100, Integer r101, b r102, g r103) {
        this.distanceToOrigin = r100;
        this.distanceToCurrent = r101;
        this.position = r102;
        this.turnDescription = r103;
    }
}
