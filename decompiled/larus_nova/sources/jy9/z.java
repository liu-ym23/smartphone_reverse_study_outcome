package jy9;

import com.larus.bmhome.actionbar.model.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0 f501067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f501068b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f501067a, r101.f501067a) == true) goto L12;
        return false;
    L12:
        if (this.f501068b == r101.f501068b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        z0 r100 = this.f501067a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f501068b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "EditorDependency(customActionBar=" + this.f501067a + ", openNewChatPage=" + this.f501068b + ')';
    }

    public z(z0 r100, boolean r101) {
        this.f501067a = r100;
        this.f501068b = r101;
    }
}
