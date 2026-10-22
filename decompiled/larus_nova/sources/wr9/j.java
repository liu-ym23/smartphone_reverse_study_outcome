package wr9;

import com.bytedance.crash.dumper.Scraps;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f560894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f560895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f560896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f560897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f560898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f560899f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f560894a == r101.f560894a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f560895b, r101.f560895b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f560896c, r101.f560896c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f560897d, r101.f560897d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f560898e, r101.f560898e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f560899f, r101.f560899f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f560894a;
        return (((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f560895b.hashCode()) * 31) + this.f560896c.hashCode()) * 31) + this.f560897d.hashCode()) * 31) + this.f560898e.hashCode()) * 31) + this.f560899f.hashCode();
    }

    public final String toString() {
        return "PowerStateSnapshot(capturedAtElapsedRealtimeMs=" + this.f560894a + ", thermal=" + this.f560895b + ", cpu=" + this.f560896c + ", memory=" + this.f560897d + ", battery=" + this.f560898e + ", staticCpu=" + this.f560899f + ')';
    }

    public j(long r100, l r101, b r102, c r103, a r104, k r105) {
        Intrinsics.checkNotNullParameter(r101, "thermal");
        Intrinsics.checkNotNullParameter(r102, "cpu");
        Intrinsics.checkNotNullParameter(r103, "memory");
        Intrinsics.checkNotNullParameter(r104, Scraps.BATTERY);
        Intrinsics.checkNotNullParameter(r105, "staticCpu");
        this.f560894a = r100;
        this.f560895b = r101;
        this.f560896c = r102;
        this.f560897d = r103;
        this.f560898e = r104;
        this.f560899f = r105;
    }

    public static j a(j r100, long r101, l r110, c r111, a r112, k r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r101 = r100.f560894a;
    L5:
        long r102 = r101;
        if ((r114 & 2) == 0) goto L8;
        r110 = r100.f560895b;
    L8:
        l r103 = r110;
        if ((r114 & 4) == 0) goto L11;
        b r104 = r100.f560896c;
    L12:
        b r105 = r104;
        if ((r114 & 8) == 0) goto L15;
        r111 = r100.f560897d;
    L15:
        c r106 = r111;
        if ((r114 & 16) == 0) goto L18;
        r112 = r100.f560898e;
    L18:
        a r107 = r112;
        if ((r114 & 32) == 0) goto L21;
        r113 = r100.f560899f;
    L21:
        k r108 = r113;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "thermal");
        Intrinsics.checkNotNullParameter(r105, "cpu");
        Intrinsics.checkNotNullParameter(r106, "memory");
        Intrinsics.checkNotNullParameter(r107, Scraps.BATTERY);
        Intrinsics.checkNotNullParameter(r108, "staticCpu");
        return new j(r102, r103, r105, r106, r107, r108);
    L11:
        r104 = null;
        goto L12
    }
}
