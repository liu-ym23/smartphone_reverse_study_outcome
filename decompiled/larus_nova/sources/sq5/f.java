package sq5;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f543028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f543029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f543030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f543031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f543032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f543033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f543034g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f543035h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f543028a, r101.f543028a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f543029b, r101.f543029b) == true) goto L15;
        return false;
    L15:
        if (this.f543030c == r101.f543030c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f543031d, r101.f543031d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f543032e, r101.f543032e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f543033f, r101.f543033f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f543034g, r101.f543034g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f543035h, r101.f543035h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Context r100 = this.f543028a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f543029b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f543030c) * 31;
        String r107 = this.f543031d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f543032e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f543033f;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return ((((r112 + r101) * 31) + this.f543034g.hashCode()) * 31) + this.f543035h.hashCode();
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "WikiCopy2WikiVMInitParams(context=" + this.f543028a + ", srcToken=" + this.f543029b + ", srcObjType=" + this.f543030c + ", srcSpaceId=" + this.f543031d + ", srcParentToken=" + this.f543032e + ", srcTitle=" + this.f543033f + ", destSpaceId=" + this.f543034g + ", destParentToken=" + this.f543035h + ')';
    }

    public final Context getContext() {
        return this.f543028a;
    }

    public f(Context r100, String r101, int r102, String r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r106, "destSpaceId");
        Intrinsics.checkNotNullParameter(r107, "destParentToken");
        this.f543028a = r100;
        this.f543029b = r101;
        this.f543030c = r102;
        this.f543031d = r103;
        this.f543032e = r104;
        this.f543033f = r105;
        this.f543034g = r106;
        this.f543035h = r107;
    }
}
