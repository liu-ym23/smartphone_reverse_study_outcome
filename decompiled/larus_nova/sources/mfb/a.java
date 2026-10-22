package mfb;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f513679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f513680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f513681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f513682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f513683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f513684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f513685g;

    /* JADX INFO: renamed from: mfb.a$a, reason: collision with other inner class name */
    public static final class C6813a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f513686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f513687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f513688c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f513689d;

        public C6813a() {
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f513679a, r101.f513679a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f513680b, r101.f513680b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f513681c, r101.f513681c) == 0) goto L18;
        return false;
    L18:
        if (this.f513682d == r101.f513682d) goto L21;
        return false;
    L21:
        if (Float.compare(this.f513683e, r101.f513683e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f513684f, r101.f513684f) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.f513685g, r101.f513685g) == 0) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f513679a.hashCode() * 31) + Float.floatToIntBits(this.f513680b)) * 31) + Float.floatToIntBits(this.f513681c)) * 31;
        if (this.f513682d == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((((r100 + r101) * 31) + Float.floatToIntBits(this.f513683e)) * 31) + Float.floatToIntBits(this.f513684f)) * 31) + Float.floatToIntBits(this.f513685g);
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DrawableProperty(drawable=" + this.f513679a + ", vWidth=" + this.f513680b + ", vHeight=" + this.f513681c + ", isVideo=" + this.f513682d + ", translateX=" + this.f513683e + ", translateY=" + this.f513684f + ", scale=" + this.f513685g + ')';
    }

    public a(Drawable r100, float r101, float r102, boolean r103, float r104, float r105, float r106) {
        this.f513679a = r100;
        this.f513680b = r101;
        this.f513681c = r102;
        this.f513682d = r103;
        this.f513683e = r104;
        this.f513684f = r105;
        this.f513685g = r106;
    }
}
