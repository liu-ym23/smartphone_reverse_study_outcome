package kc8;

import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExpandCardViewMode f502518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f502519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f502520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j0 f502521d;

    public k0() {
        this(null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (this.f502518a == r101.f502518a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502519b, r101.f502519b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502520c, r101.f502520c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f502521d, r101.f502521d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f502518a.hashCode() * 31;
        z r101 = this.f502519b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        z r105 = this.f502520c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        j0 r108 = this.f502521d;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PureVideoConfig(msgExpandMode=" + this.f502518a + ", viewLongClickHandler=" + this.f502519b + ", videoCoverLongClickHandler=" + this.f502520c + ", columnGridDecorationConfig=" + this.f502521d + ')';
    }

    public /* synthetic */ k0(ExpandCardViewMode r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = ExpandCardViewMode.NORMAL;
    L5:
        this(r100, null, null, null);
    }

    public k0(ExpandCardViewMode r100, z r101, z r102, j0 r103) {
        Intrinsics.checkNotNullParameter(r100, "msgExpandMode");
        this.f502518a = r100;
        this.f502519b = r101;
        this.f502520c = r102;
        this.f502521d = r103;
    }
}
