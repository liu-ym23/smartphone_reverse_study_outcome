package m0a;

import com.larus.ugc.feed.impl.spi.CommunityCreateNavigatorAndroidImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0a.c f511496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g0a.e f511497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0a.d f511498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f511499d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f511496a, r101.f511496a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f511497b, r101.f511497b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f511498c, r101.f511498c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f511499d, r101.f511499d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f511496a.hashCode() * 31) + this.f511497b.hashCode()) * 31) + this.f511498c.hashCode()) * 31) + this.f511499d.hashCode();
    }

    public final String toString() {
        return "CommunityCreateInitDependencyKmp(navigator=" + this.f511496a + ", tracker=" + this.f511497b + ", settings=" + this.f511498c + ", tabListRepository=" + this.f511499d + ')';
    }

    public d(CommunityCreateNavigatorAndroidImpl r100, g0a.e r101, com.larus.ugc.feed.impl.spi.a r102, y0a.e r103) {
        Intrinsics.checkNotNullParameter(r100, "navigator");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        Intrinsics.checkNotNullParameter(r102, "settings");
        Intrinsics.checkNotNullParameter(r103, "tabListRepository");
        this.f511496a = r100;
        this.f511497b = r101;
        this.f511498c = r102;
        this.f511499d = r103;
    }
}
