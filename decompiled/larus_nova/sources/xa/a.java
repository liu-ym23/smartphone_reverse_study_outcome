package xa;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f563019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f563020b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f563019a, r101.f563019a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f563020b, r101.f563020b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f563019a.hashCode() * 31) + this.f563020b.hashCode();
    }

    public final String toString() {
        return "FullSceneInfo(sceneId=" + this.f563019a + ", fullUrls=" + this.f563020b + ')';
    }

    public a(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        Intrinsics.checkNotNullParameter(r101, "fullUrls");
        this.f563019a = r100;
        this.f563020b = r101;
    }
}
