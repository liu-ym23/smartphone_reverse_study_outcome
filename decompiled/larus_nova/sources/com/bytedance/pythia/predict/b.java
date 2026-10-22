package com.bytedance.pythia.predict;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n87.a f267120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n87.a f267121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n87.a f267122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n87.a f267123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n87.a f267124e;

    public final int hashCode() {
        n87.a r100 = this.f267120a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        n87.a r104 = this.f267121b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        n87.a r107 = this.f267122c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        n87.a r110 = this.f267123d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        n87.a r113 = this.f267124e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PerfProfileImpl(main=" + this.f267120a + ", compute=" + this.f267121b + ", memory=" + this.f267122c + ", network=" + this.f267123d + ", power=" + this.f267124e + ")";
    }

    public b(a r100) {
        Intrinsics.checkNotNullParameter(r100, PullConfiguration.PROCESS_NAME_MAIN);
        this.f267120a = r100;
        this.f267121b = null;
        this.f267122c = null;
        this.f267123d = null;
        this.f267124e = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f267120a, r101.f267120a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f267121b, r101.f267121b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f267122c, r101.f267122c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f267123d, r101.f267123d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f267124e, r101.f267124e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }
}
