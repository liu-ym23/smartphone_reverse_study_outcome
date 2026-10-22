package y82;

import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.livesdk.interactivity.medialink.ui.player.utils.LiveType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.dtf.face.config.IConstValues;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f566856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f566857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveType f566858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DeviceType f566859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f566860e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L16;
        f r101 = (f) r100;
        if (this.f566856a == r101.f566856a) goto L8;
        return false;
    L8:
        if (this.f566857b == r101.f566857b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f566858c, r101.f566858c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566859d, r101.f566859d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f566860e, r101.f566860e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    public final int hashCode() {
        boolean r100 = this.f566856a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f566857b;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (r103 + r101) * 31;
        LiveType r106 = this.f566858c;
        int r107 = 0;
        if (r106 == null) goto L12;
        int r108 = r106.hashCode();
    L13:
        int r109 = (r105 + r108) * 31;
        DeviceType r110 = this.f566859d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        DataCenter r113 = this.f566860e;
        if (r113 == null) goto L21;
        r107 = r113.hashCode();
    L21:
        return r112 + r107;
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    }

    public final String toString() {
        return "MediaLayoutCreatorParam(isAnchor=" + this.f566856a + ", isPortrait=" + this.f566857b + ", liveType=" + this.f566858c + ", deviceType=" + this.f566859d + ", dataCenter=" + this.f566860e + ")";
    }

    public f(boolean r100, boolean r101, LiveType r102, DeviceType r103, DataCenter r104) {
        Intrinsics.checkNotNullParameter(r102, "liveType");
        Intrinsics.checkNotNullParameter(r103, IConstValues.DEVICE_TYPE);
        Intrinsics.checkNotNullParameter(r104, "dataCenter");
        this.f566856a = r100;
        this.f566857b = r101;
        this.f566858c = r102;
        this.f566859d = r103;
        this.f566860e = r104;
    }
}
