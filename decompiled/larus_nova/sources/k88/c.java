package k88;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.uaigc.api.a f502110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f502111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f502112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f502113d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f502110a, r101.f502110a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502111b, r101.f502111b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f502110a.hashCode() * 31;
        e r101 = this.f502111b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DigitalAvatarMaterialGalleryContext(data=" + this.f502110a + ", extraInfo=" + this.f502111b + ')';
    }

    public c(com.larus.uaigc.api.a r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f502110a = r100;
        this.f502111b = r101;
        this.f502112c = LazyKt.lazy(new a(this));
        this.f502113d = LazyKt.lazy(new b(this));
    }
}
