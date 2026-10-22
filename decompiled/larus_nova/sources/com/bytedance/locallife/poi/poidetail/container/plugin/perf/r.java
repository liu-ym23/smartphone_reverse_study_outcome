package com.bytedance.locallife.poi.poidetail.container.plugin.perf;

import com.vivo.push.PushClientConstants;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f264172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f264173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f264174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f264175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f264176e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (this.f264172a == r101.f264172a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f264173b, r101.f264173b) == true) goto L15;
        return false;
    L15:
        if (this.f264174c == r101.f264174c) goto L18;
        return false;
    L18:
        if (this.f264175d == r101.f264175d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f264176e, r101.f264176e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f264172a * 31) + this.f264173b.hashCode()) * 31) + this.f264174c) * 31) + this.f264175d) * 31) + this.f264176e.hashCode();
    }

    public final String toString() {
        return "ViewGroupInfo(level=" + this.f264172a + ", indexPath=" + this.f264173b + ", childCount=" + this.f264174c + ", viewId=" + this.f264175d + ", className=" + this.f264176e + ')';
    }

    public r(int r100, List<Integer> r101, int r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "indexPath");
        Intrinsics.checkNotNullParameter(r104, PushClientConstants.TAG_CLASS_NAME);
        this.f264172a = r100;
        this.f264173b = r101;
        this.f264174c = r102;
        this.f264175d = r103;
        this.f264176e = r104;
    }
}
