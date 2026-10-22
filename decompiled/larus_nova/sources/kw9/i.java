package kw9;

import androidx.fragment.app.FragmentActivity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f506476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<jr9.a> f506477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.b f506478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f506479d;

    public i() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f506476a, r101.f506476a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506477b, r101.f506477b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506478c, r101.f506478c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506479d, r101.f506479d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f506476a.hashCode() * 31;
        List<jr9.a> r101 = this.f506477b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        com.larus.bmhome.share.panel.b r105 = this.f506478c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.f506479d.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SlideShareContext(fragmentActivity=" + this.f506476a + ", shareItems=" + this.f506477b + ", shareContent=" + this.f506478c + ", shareParams=" + this.f506479d + ')';
    }

    public i(FragmentActivity r100, com.larus.bmhome.share.panel.b r101, j r102) {
        Intrinsics.checkNotNullParameter(r100, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r102, "shareParams");
        this.f506476a = r100;
        this.f506477b = null;
        this.f506478c = r101;
        this.f506479d = r102;
    }
}
