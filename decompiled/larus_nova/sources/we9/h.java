package we9;

import kotlin.jvm.internal.Intrinsics;
import ve9.o;
import ve9.p;

/* JADX INFO: loaded from: classes30.dex */
public final class h implements xe9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ve9.f f559426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f559427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f559428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ve9.a f559429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ve9.e f559430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ve9.n f559431f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f559426a, r101.f559426a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f559427b, r101.f559427b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f559428c, r101.f559428c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f559429d, r101.f559429d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f559430e, r101.f559430e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f559431f, r101.f559431f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f559426a.hashCode() * 31) + this.f559427b.hashCode()) * 31) + this.f559428c.hashCode()) * 31) + this.f559429d.hashCode()) * 31) + this.f559430e.hashCode()) * 31) + this.f559431f.hashCode();
    }

    public final String toString() {
        return "StartCall(connectConfig=" + this.f559426a + ", sessionConfig=" + this.f559427b + ", ttsConfig=" + this.f559428c + ", asrConfig=" + this.f559429d + ", commonConfig=" + this.f559430e + ", modeConfig=" + this.f559431f + ')';
    }

    public h(ve9.f r100, o r101, p r102, ve9.a r103, ve9.e r104, ve9.n r105) {
        Intrinsics.checkNotNullParameter(r100, "connectConfig");
        Intrinsics.checkNotNullParameter(r101, "sessionConfig");
        Intrinsics.checkNotNullParameter(r102, "ttsConfig");
        Intrinsics.checkNotNullParameter(r103, "asrConfig");
        Intrinsics.checkNotNullParameter(r104, "commonConfig");
        Intrinsics.checkNotNullParameter(r105, "modeConfig");
        this.f559426a = r100;
        this.f559427b = r101;
        this.f559428c = r102;
        this.f559429d = r103;
        this.f559430e = r104;
        this.f559431f = r105;
    }
}
