package z79;

import ic8.d;
import jy9.p;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f570680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f570681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f570682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f570683d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f570680a, r101.f570680a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f570681b, r101.f570681b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f570682c, r101.f570682c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f570683d, r101.f570683d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f570680a.hashCode() * 31) + this.f570681b.hashCode()) * 31) + this.f570682c.hashCode()) * 31) + this.f570683d.hashCode();
    }

    public final String toString() {
        return "DriveGalleryAiEditParam(aiImageToVideoParam=" + this.f570680a + ", aiImageEditParam=" + this.f570681b + ", aiImageSharpnessParam=" + this.f570682c + ", aiImageEraseParam=" + this.f570683d + ')';
    }

    public a() {
        boolean r110 = false;
        Function1 r111 = null;
        Function1 r112 = null;
        boolean r113 = false;
        Function0 r114 = null;
        p r115 = null;
        int r116 = 63;
        this(new d(false, null, null, false, null, null, 63), new d(r110, r111, r112, r113, r114, r115, r116), new d(false, null, null, false, null, null, 63), new d(r110, r111, r112, r113, r114, r115, r116));
    }

    public a(d r100, d r101, d r102, d r103) {
        Intrinsics.checkNotNullParameter(r100, "aiImageToVideoParam");
        Intrinsics.checkNotNullParameter(r101, "aiImageEditParam");
        Intrinsics.checkNotNullParameter(r102, "aiImageSharpnessParam");
        Intrinsics.checkNotNullParameter(r103, "aiImageEraseParam");
        this.f570680a = r100;
        this.f570681b = r101;
        this.f570682c = r102;
        this.f570683d = r103;
    }
}
