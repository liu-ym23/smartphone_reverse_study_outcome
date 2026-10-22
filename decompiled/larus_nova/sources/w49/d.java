package w49;

import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlGestureType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HeadControlGestureType f558271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f558272b;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f558271a == r101.f558271a) goto L12;
        return false;
    L12:
        if (this.f558272b == r101.f558272b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f558271a.hashCode() * 31;
        if (this.f558272b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "HeadControlPracticeState(expectedGesture=" + this.f558271a + ", isSuccess=" + this.f558272b + ')';
    }

    public /* synthetic */ d(int r100) {
        this(HeadControlGestureType.NOD, false);
    }

    public d(HeadControlGestureType r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "expectedGesture");
        this.f558271a = r100;
        this.f558272b = r101;
    }
}
