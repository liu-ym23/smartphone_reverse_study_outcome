package lx9;

import com.larus.suggest.impl.wcb.model.WcbSurface;
import com.larus.suggest.impl.wcb.scene.WcbMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WcbSurface f511241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WcbMode f511242b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f511241a == r101.f511241a) goto L12;
        return false;
    L12:
        if (this.f511242b == r101.f511242b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f511241a.hashCode() * 31) + this.f511242b.hashCode();
    }

    public final String toString() {
        return "WcbSceneKey(surface=" + this.f511241a + ", mode=" + this.f511242b + ')';
    }

    public d(WcbSurface r100, WcbMode r101) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        Intrinsics.checkNotNullParameter(r101, "mode");
        this.f511241a = r100;
        this.f511242b = r101;
    }
}
