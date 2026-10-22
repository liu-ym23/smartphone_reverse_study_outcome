package osb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f526595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f526596b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f526595a, r101.f526595a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f526596b, r101.f526596b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f526595a.hashCode() * 31) + this.f526596b.hashCode();
    }

    public final String toString() {
        return "AISceneObject(objectId=" + this.f526595a + ", objectType=" + this.f526596b + ')';
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "objectId");
        Intrinsics.checkNotNullParameter(r101, "objectType");
        this.f526595a = r100;
        this.f526596b = r101;
    }
}
