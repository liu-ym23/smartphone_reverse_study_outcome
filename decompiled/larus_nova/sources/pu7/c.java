package pu7;

import com.github.alexzhirkevich.customqrgenerator.QrErrorCorrectionLevel;
import com.github.alexzhirkevich.customqrgenerator.d;
import com.github.alexzhirkevich.customqrgenerator.style.h;
import com.github.alexzhirkevich.customqrgenerator.style.i;
import com.github.alexzhirkevich.customqrgenerator.vector.style.g;
import com.github.alexzhirkevich.customqrgenerator.vector.style.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f530742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f530743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f530744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f530745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f530746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.github.alexzhirkevich.customqrgenerator.vector.style.i f530747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.github.alexzhirkevich.customqrgenerator.vector.style.c f530748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final QrErrorCorrectionLevel f530749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f530750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f530751j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f530752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i.a f530753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g f530754c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.github.alexzhirkevich.customqrgenerator.vector.style.i f530755d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.github.alexzhirkevich.customqrgenerator.vector.style.c f530756e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public QrErrorCorrectionLevel f530757f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f530758g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final d f530759h;

        public a() {
            this.f530752a = new h();
            new n(null, null, null, 31);
            this.f530753b = i.a.f274268a;
            this.f530754c = new g(0);
            this.f530755d = new com.github.alexzhirkevich.customqrgenerator.vector.style.i(0);
            this.f530756e = new com.github.alexzhirkevich.customqrgenerator.vector.style.c(0);
            this.f530757f = QrErrorCorrectionLevel.Auto;
            this.f530759h = new d(0);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(Float.valueOf(this.f530742a), Float.valueOf(r101.f530742a)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f530743b, r101.f530743b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f530744c, r101.f530744c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f530745d, r101.f530745d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f530746e, r101.f530746e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f530747f, r101.f530747f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f530748g, r101.f530748g) == true) goto L30;
        return false;
    L30:
        if (this.f530749h == r101.f530749h) goto L33;
        return false;
    L33:
        if (this.f530750i == r101.f530750i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f530751j, r101.f530751j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    public final int hashCode() {
        int r100 = ((((((((((((((Float.floatToIntBits(this.f530742a) * 31) + this.f530743b.hashCode()) * 31) + this.f530744c.hashCode()) * 31) + this.f530745d.hashCode()) * 31) + this.f530746e.hashCode()) * 31) + this.f530747f.hashCode()) * 31) + this.f530748g.hashCode()) * 31) + this.f530749h.hashCode()) * 31;
        boolean r101 = this.f530750i;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return ((r100 + r102) * 31) + this.f530751j.hashCode();
    }

    public final String toString() {
        return "QrVectorOptions(padding=" + this.f530742a + ", offset=" + this.f530743b + ", shapes=" + this.f530744c + ", codeShape=" + this.f530745d + ", colors=" + this.f530746e + ", logo=" + this.f530747f + ", background=" + this.f530748g + ", errorCorrectionLevel=" + this.f530749h + ", fourthEyeEnabled=" + this.f530750i + ", highlighting=" + this.f530751j + ')';
    }

    public c(h r100, n r101, i.a r102, g r103, com.github.alexzhirkevich.customqrgenerator.vector.style.i r104, com.github.alexzhirkevich.customqrgenerator.vector.style.c r105, QrErrorCorrectionLevel r106, boolean r107, d r110) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        Intrinsics.checkNotNullParameter(r101, "shapes");
        Intrinsics.checkNotNullParameter(r102, "codeShape");
        Intrinsics.checkNotNullParameter(r103, "colors");
        Intrinsics.checkNotNullParameter(r104, "logo");
        Intrinsics.checkNotNullParameter(r105, "background");
        Intrinsics.checkNotNullParameter(r106, "errorCorrectionLevel");
        Intrinsics.checkNotNullParameter(r110, "highlighting");
        this.f530742a = 0.0f;
        this.f530743b = r100;
        this.f530744c = r101;
        this.f530745d = r102;
        this.f530746e = r103;
        this.f530747f = r104;
        this.f530748g = r105;
        this.f530749h = r106;
        this.f530750i = r107;
        this.f530751j = r110;
    }
}
