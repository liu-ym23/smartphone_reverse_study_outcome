package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.behavior.shadow.MeasureMode;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f382299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MeasureMode f382300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MeasureMode f382301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f382302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f382303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f382304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f382305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f382306h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f382307i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f382308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.lynx.tasm.behavior.shadow.text.a f382309b;

        public final int hashCode() {
            CharSequence r100 = this.f382308a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            com.lynx.tasm.behavior.shadow.text.a r104 = this.f382309b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof a) == true) goto L5;
            return false;
        L5:
            a r101 = (a) r100;
            CharSequence r102 = this.f382308a;
            if (r102 == null) goto L8;
        L10:
            if (r102 != null) goto L12;
        L14:
            com.lynx.tasm.behavior.shadow.text.a r103 = this.f382309b;
            if (r103 == null) goto L17;
        L19:
            if (r103 != null) goto L21;
        L22:
            return true;
        L21:
            if (r103.equals(r101.f382309b) == true) goto L22;
            return false;
        L17:
            if (r101.f382309b == null) goto L19;
            return false;
        L12:
            if (r102.equals(r101.f382308a) == true) goto L14;
            return false;
        L8:
            if (r101.f382308a == null) goto L10;
            return false;
        }

        public a(CharSequence r100, com.lynx.tasm.behavior.shadow.text.a r101) {
            this.f382308a = r100;
            this.f382309b = r101;
        }
    }

    public final int hashCode() {
        return (((((((((((((((this.f382299a.hashCode() * 31) + this.f382300b.hashCode()) * 31) + this.f382301c.hashCode()) * 31) + Float.floatToIntBits(this.f382302d)) * 31) + Float.floatToIntBits(this.f382303e)) * 31) + this.f382304f) * 31) + (this.f382305g ? 1 : 0)) * 31) + (this.f382306h ? 1 : 0)) * 31) + (this.f382307i ? 1 : 0);
    }

    public final String toString() {
        return this.f382299a.f382308a + " " + this.f382302d + " " + this.f382303e;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof f) == true) goto L5;
        return false;
    L5:
        f r101 = (f) r100;
        if (this.f382299a.equals(r101.f382299a) == true) goto L8;
        return false;
    L8:
        if (this.f382300b == r101.f382300b) goto L10;
        return false;
    L10:
        if (this.f382301c == r101.f382301c) goto L12;
        return false;
    L12:
        if (this.f382302d == r101.f382302d) goto L14;
        return false;
    L14:
        if (this.f382303e == r101.f382303e) goto L16;
        return false;
    L16:
        if (this.f382304f == r101.f382304f) goto L18;
        return false;
    L18:
        if (this.f382305g == r101.f382305g) goto L20;
        return false;
    L20:
        if (this.f382306h == r101.f382306h) goto L22;
        return false;
    L22:
        if (this.f382307i != r101.f382307i) goto L33;
        return true;
    L33:
        return false;
    }

    public f(CharSequence r100, com.lynx.tasm.behavior.shadow.text.a r101, MeasureMode r102, MeasureMode r103, float r104, float r105, int r106, boolean r107, boolean r110, boolean r111) {
        this.f382299a = new a(r100, r101);
        this.f382302d = r104;
        this.f382303e = r105;
        this.f382300b = r102;
        this.f382301c = r103;
        this.f382304f = r106;
        this.f382305g = r107;
        this.f382306h = r110;
        this.f382307i = r111;
    }
}
