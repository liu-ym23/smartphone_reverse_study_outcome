package xa8;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f563092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f563093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f563094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f563095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f563096e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f563092a, r101.f563092a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f563093b, r101.f563093b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f563094c, r101.f563094c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f563095d, r101.f563095d) == true) goto L21;
        return false;
    L21:
        if (this.f563096e == r101.f563096e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f563092a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f563093b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f563094c.hashCode()) * 31;
        Bundle r107 = this.f563095d;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        if (this.f563096e == false) goto L17;
        int r109 = 1231;
    L19:
        return r108 + r109;
    L17:
        r109 = 1237;
        goto L19
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenContinuousTalkParams(enterMethod=" + this.f563092a + ", callID=" + this.f563093b + ", isOpenVlm=" + this.f563094c + ", originalArguments=" + this.f563095d + ", isFromAsrSlide=" + this.f563096e + ')';
    }

    public e(String r100, String r101, String r102, Bundle r103, boolean r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r102 = "";
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 16) == 0) goto L11;
        r104 = false;
    L11:
        Intrinsics.checkNotNullParameter(r102, "isOpenVlm");
        this.f563092a = r100;
        this.f563093b = r101;
        this.f563094c = r102;
        this.f563095d = r103;
        this.f563096e = r104;
    }
}
