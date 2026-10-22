package org.jetbrains.compose.resources;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f525868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f525869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThemeQualifier f525870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DensityQualifier f525871d;

    public final int hashCode() {
        return (((((this.f525868a.hashCode() * 31) + this.f525869b.hashCode()) * 31) + this.f525870c.hashCode()) * 31) + this.f525871d.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L23:
        return false;
    L8:
        if (q.class != r100.getClass()) goto L23;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f525868a, r101.f525868a) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f525869b, r101.f525869b) == true) goto L17;
        return false;
    L17:
        if (this.f525870c == r101.f525870c) goto L20;
        return false;
    L20:
        if (this.f525871d == r101.f525871d) goto L22;
        return false;
    L22:
        return true;
    }

    public q(k r100, m r101, ThemeQualifier r102, DensityQualifier r103) {
        Intrinsics.checkNotNullParameter(r100, "language");
        Intrinsics.checkNotNullParameter(r101, EffectConfiguration.KEY_REGION);
        Intrinsics.checkNotNullParameter(r102, "theme");
        Intrinsics.checkNotNullParameter(r103, "density");
        this.f525868a = r100;
        this.f525869b = r101;
        this.f525870c = r102;
        this.f525871d = r103;
    }
}
