package xh0;

import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IncompatibleTag f563844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f563845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f563846c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L12;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f563844a, r101.f563844a) == true) goto L8;
        return false;
    L8:
        if (this.f563845b == r101.f563845b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f563846c, r101.f563846c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        IncompatibleTag r100 = this.f563844a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f563845b) * 31;
        String r104 = this.f563846c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IncompatibleSource(tag=" + this.f563844a + ", key=" + this.f563845b + ", toastString=" + this.f563846c + ")";
    }

    public /* synthetic */ f(IncompatibleTag r100, int r101) {
        this(r100, r101, "");
    }

    public f(IncompatibleTag r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f563844a = r100;
        this.f563845b = r101;
        this.f563846c = r102;
    }
}
