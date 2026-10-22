package k73;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import ti.l;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f501998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f501999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f502000c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f501998a, r101.f501998a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f501999b, r101.f501999b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f502000c, r101.f502000c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        View r100 = this.f501998a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        l r104 = this.f501999b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f502000c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoCtrlLynxComponent(lynxView=" + this.f501998a + ", component=" + this.f501999b + ", lynxId=" + this.f502000c + ")";
    }

    public e(View r100, l r101, String r102) {
        this.f501998a = r100;
        this.f501999b = r101;
        this.f502000c = r102;
    }
}
