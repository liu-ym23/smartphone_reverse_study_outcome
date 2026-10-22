package ww6;

import com.bytedance.locallife.dito.data.DitoPage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DitoPage f561633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f561634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f561635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f561636d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f561633a, r101.f561633a) == true) goto L12;
        return false;
    L12:
        if (this.f561634b == r101.f561634b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f561635c, r101.f561635c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f561636d, r101.f561636d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f561633a.hashCode() * 31;
        if (this.f561634b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.f561635c.hashCode()) * 31) + this.f561636d.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DitoPageCacheInfo(ditoPage=" + this.f561633a + ", needHookLynxLifecycle=" + this.f561634b + ", scene=" + this.f561635c + ", cachePageSecondarySource=" + this.f561636d + ')';
    }

    public f(DitoPage r100, boolean r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "ditoPage");
        Intrinsics.checkNotNullParameter(r102, "scene");
        Intrinsics.checkNotNullParameter(r103, "cachePageSecondarySource");
        this.f561633a = r100;
        this.f561634b = r101;
        this.f561635c = r102;
        this.f561636d = r103;
    }

    public /* synthetic */ f(DitoPage r100, boolean r101, String r102, String r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = "";
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = "";
    L11:
        this(r100, r101, r102, r103);
    }
}
