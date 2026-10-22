package is8;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f495696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f495697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f495698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f495699d;

    public l() {
        Integer r100 = null;
        this(r100, r100, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f495696a, r101.f495696a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495697b, r101.f495697b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495698c, r101.f495698c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495699d, r101.f495699d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f495696a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f495697b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f495698c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.f495699d.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UploadedMediaMeta(width=" + this.f495696a + ", height=" + this.f495697b + ", durationMs=" + this.f495698c + ", extra=" + this.f495699d + ')';
    }

    public /* synthetic */ l(Integer r100, Integer r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r102 & 8) == 0) goto L11;
        Map r103 = MapsKt.emptyMap();
    L12:
        this(r100, r101, null, r103);
        return;
    L11:
        r103 = null;
        goto L12
    }

    public l(Integer r100, Integer r101, Long r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r103, "extra");
        this.f495696a = r100;
        this.f495697b = r101;
        this.f495698c = r102;
        this.f495699d = r103;
    }
}
