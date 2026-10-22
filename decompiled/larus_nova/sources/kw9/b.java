package kw9;

import androidx.fragment.app.FragmentActivity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f506418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f506419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<jr9.a> f506420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.b f506421d;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f506418a, r101.f506418a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506419b, r101.f506419b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506420c, r101.f506420c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506421d, r101.f506421d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f506418a.hashCode() * 31) + this.f506419b.hashCode()) * 31;
        List<jr9.a> r101 = this.f506420c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        com.larus.bmhome.share.panel.b r105 = this.f506421d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DriveShareContext(fragmentActivity=" + this.f506418a + ", shareParams=" + this.f506419b + ", shareItems=" + this.f506420c + ", shareContent=" + this.f506421d + ')';
    }

    public b(FragmentActivity r100, d r101, com.larus.bmhome.share.panel.b r102) {
        Intrinsics.checkNotNullParameter(r100, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r101, "shareParams");
        this.f506418a = r100;
        this.f506419b = r101;
        this.f506420c = null;
        this.f506421d = r102;
    }
}
