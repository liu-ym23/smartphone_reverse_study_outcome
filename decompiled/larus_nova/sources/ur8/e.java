package ur8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f551388a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f551388a, ((e) r100).f551388a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f551388a.hashCode();
    }

    public final String toString() {
        return "MentionSearchChangeEvent(searchString=" + this.f551388a + ')';
    }

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "searchString");
        this.f551388a = r100;
    }
}
