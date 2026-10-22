package hq9;

import com.larus.platform.model.LarkSocialImModuleState;
import com.larus.platform.model.LarkSocialSnapshotState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarkSocialSnapshotState f486672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v2 f486673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f486675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v2 f486676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LarkSocialImModuleState f486677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v2 f486678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v2 f486679h;

    public m2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m2) == true) goto L8;
        return false;
    L8:
        m2 r101 = (m2) r100;
        if (this.f486672a == r101.f486672a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486673b, r101.f486673b) == true) goto L15;
        return false;
    L15:
        if (this.f486674c == r101.f486674c) goto L18;
        return false;
    L18:
        if (this.f486675d == r101.f486675d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f486676e, r101.f486676e) == true) goto L24;
        return false;
    L24:
        if (this.f486677f == r101.f486677f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f486678g, r101.f486678g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f486679h, r101.f486679h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f486672a.hashCode() * 31;
        v2 r101 = this.f486673b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.f486674c == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f486675d == true) goto L14;
        r105 = 1237;
    L14:
        int r108 = (r107 + r105) * 31;
        v2 r109 = this.f486676e;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (((r108 + r110) * 31) + this.f486677f.hashCode()) * 31;
        v2 r112 = this.f486678g;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        v2 r115 = this.f486679h;
        if (r115 == null) goto L27;
        r102 = r115.hashCode();
    L27:
        return r114 + r102;
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "LarkSocialCapabilityState(snapshotState=" + this.f486672a + ", session=" + this.f486673b + ", desiredEnabled=" + this.f486674c + ", activeEnabled=" + this.f486675d + ", officeUserReadySession=" + this.f486676e + ", imModuleState=" + this.f486677f + ", imReadySession=" + this.f486678g + ", imFailureSession=" + this.f486679h + ')';
    }

    public /* synthetic */ m2(int r110) {
        this(LarkSocialSnapshotState.UNKNOWN, null, false, false, null, LarkSocialImModuleState.NOT_LOADED, null, null);
    }

    public m2(LarkSocialSnapshotState r100, v2 r101, boolean r102, boolean r103, v2 r104, LarkSocialImModuleState r105, v2 r106, v2 r107) {
        Intrinsics.checkNotNullParameter(r100, "snapshotState");
        Intrinsics.checkNotNullParameter(r105, "imModuleState");
        this.f486672a = r100;
        this.f486673b = r101;
        this.f486674c = r102;
        this.f486675d = r103;
        this.f486676e = r104;
        this.f486677f = r105;
        this.f486678g = r106;
        this.f486679h = r107;
    }
}
