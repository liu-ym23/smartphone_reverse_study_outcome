package wj0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f559934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f559935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f559936c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L12;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f559934a, r101.f559934a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f559935b, r101.f559935b) == true) goto L10;
        return false;
    L10:
        if (this.f559936c == r101.f559936c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f559934a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f559935b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f559936c;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TalkRoomSoundEvent(id=" + this.f559934a + ", url=" + this.f559935b + ", interceptStopSound=" + this.f559936c + ")";
    }

    public f(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f559934a = r100;
        this.f559935b = r101;
        this.f559936c = r102;
    }
}
