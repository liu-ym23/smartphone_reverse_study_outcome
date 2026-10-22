package qq6;

import com.bytedance.locallife.dito.host.ui.LoadingMode;
import com.bytedance.locallife.dito.host.ui.SkinMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoadingMode f534491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SkinMode f534492b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f534491a == r101.f534491a) goto L12;
        return false;
    L12:
        if (this.f534492b == r101.f534492b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f534491a.hashCode() * 31) + this.f534492b.hashCode();
    }

    public final String toString() {
        return "LoadingOptions(mode=" + this.f534491a + ", skinMode=" + this.f534492b + ')';
    }

    public c(LoadingMode r100, SkinMode r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, "skinMode");
        this.f534491a = r100;
        this.f534492b = r101;
    }
}
