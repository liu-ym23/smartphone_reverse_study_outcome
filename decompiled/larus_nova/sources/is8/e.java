package is8;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f495660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f495661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f495662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f495663e;

    public e() {
        this(null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f495659a, r101.f495659a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495660b, r101.f495660b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495661c, r101.f495661c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495662d, r101.f495662d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495663e, r101.f495663e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f495659a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f495660b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f495661c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f495662d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((r109 + r101) * 31) + this.f495663e.hashCode();
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UploadMetadata(fileName=" + this.f495659a + ", fileSize=" + this.f495660b + ", mimeType=" + this.f495661c + ", md5=" + this.f495662d + ", extras=" + this.f495663e + ')';
    }

    public e(String r100, Map r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 16) == 0) goto L8;
        r101 = MapsKt.emptyMap();
    L8:
        Intrinsics.checkNotNullParameter(r101, "extras");
        this.f495659a = r100;
        this.f495660b = null;
        this.f495661c = null;
        this.f495662d = null;
        this.f495663e = r101;
    }
}
