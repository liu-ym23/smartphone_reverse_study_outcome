package w45;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558254a;

    /* JADX INFO: renamed from: w45.a$a, reason: collision with other inner class name */
    public static final class C8066a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f558254a, ((a) r100).f558254a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f558254a.hashCode();
    }

    public final String toString() {
        return "DriveMorePanelOpenParams(source=" + this.f558254a + ')';
    }

    public a() {
        this("external");
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f558254a = r100;
    }
}
