package y58;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f566278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f566279c;

    public c() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f566277a, r101.f566277a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566278b, r101.f566278b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f566279c, r101.f566279c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f566277a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f566278b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f566279c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AsrResultDataExtra(audioDataTosUri=" + this.f566277a + ", audioEventResp=" + this.f566278b + ", logId=" + this.f566279c + ')';
    }

    public c(String r100, String r101, String r102) {
        this.f566277a = r100;
        this.f566278b = r101;
        this.f566279c = r102;
    }
}
