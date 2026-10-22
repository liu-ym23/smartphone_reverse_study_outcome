package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486817a;

    public x4() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x4) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f486817a, ((x4) r100).f486817a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f486817a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "UserAvatarImgConfig(authBgImgUrl=" + this.f486817a + ')';
    }

    public x4(String r100) {
        this.f486817a = r100;
    }
}
