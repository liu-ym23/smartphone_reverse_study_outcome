package ww6;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f561627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f561628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f561629c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f561627a == r101.f561627a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f561628b, r101.f561628b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f561629c, r101.f561629c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f561627a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        List<String> r102 = this.f561628b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        List<String> r106 = this.f561629c;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ConflictDetectConfig(enable=" + this.f561627a + ", valueDiffWhiteList=" + this.f561628b + ", valueDiffBlackList=" + this.f561629c + ')';
    }

    public b(List r100, List r101) {
        this.f561627a = true;
        this.f561628b = r100;
        this.f561629c = r101;
    }
}
