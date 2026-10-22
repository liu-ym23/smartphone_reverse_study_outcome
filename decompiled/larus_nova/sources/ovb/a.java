package ovb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f526980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f526981b;

    /* JADX INFO: renamed from: ovb.a$a, reason: collision with other inner class name */
    public static final class C7119a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f526980a, r101.f526980a) == true) goto L12;
        return false;
    L12:
        if (this.f526981b == r101.f526981b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f526980a.hashCode() * 31) + this.f526981b;
    }

    public final String toString() {
        return "MmAudioFileMetaInfo(audioSegmentFilePath=" + this.f526980a + ", segIndex=" + this.f526981b + ')';
    }

    public a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "audioSegmentFilePath");
        this.f526980a = r100;
        this.f526981b = r101;
    }
}
