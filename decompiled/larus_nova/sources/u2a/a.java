package u2a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f548488b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f548487a, r101.f548487a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f548488b, r101.f548488b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f548487a.hashCode() * 31) + this.f548488b.hashCode();
    }

    public final String toString() {
        return "VoiceCheckSuccessData(filePath=" + this.f548487a + ", freeTalkContent=" + this.f548488b + ')';
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        Intrinsics.checkNotNullParameter(r101, "freeTalkContent");
        this.f548487a = r100;
        this.f548488b = r101;
    }
}
