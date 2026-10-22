package com.larksuite.component.card.component.text;

import com.lynx.tasm.behavior.shadow.MeasureMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f283602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MeasureMode f283603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MeasureMode f283604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f283605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f283606e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f283607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f283608b;

        public final int hashCode() {
            return (this.f283607a.hashCode() * 31) + this.f283608b.hashCode();
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof a) == true) goto L5;
            return false;
        L5:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f283607a, r101.f283607a) == true) goto L9;
            return false;
        L9:
            return Intrinsics.areEqual(this.f283608b, r101.f283608b);
        }

        public a(CharSequence r100, d r101) {
            Intrinsics.checkNotNullParameter(r100, "text");
            Intrinsics.checkNotNullParameter(r101, "attributes");
            this.f283607a = r100;
            this.f283608b = r101;
        }
    }

    public final int hashCode() {
        return (((((((this.f283602a.hashCode() * 31) + this.f283603b.hashCode()) * 31) + this.f283604c.hashCode()) * 31) + Float.floatToIntBits(this.f283605d)) * 31) + Float.floatToIntBits(this.f283606e);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f283602a.f283607a);
        r100.append(' ');
        r100.append(this.f283605d);
        r100.append(' ');
        r100.append(this.f283606e);
        return r100.toString();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == true) goto L5;
        return false;
    L5:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f283602a, r101.f283602a) == true) goto L8;
        return false;
    L8:
        if (this.f283603b == r101.f283603b) goto L10;
        return false;
    L10:
        if (this.f283604c == r101.f283604c) goto L12;
        return false;
    L12:
        if (this.f283605d != r101.f283605d) goto L14;
        boolean r102 = true;
    L15:
        if (r102 == true) goto L17;
        return false;
    L17:
        if (this.f283606e != r101.f283606e) goto L19;
        boolean r103 = true;
    L20:
        if (r103 == false) goto L27;
        return true;
    L27:
        return false;
    L19:
        r103 = false;
        goto L20
    L14:
        r102 = false;
        goto L15
    }

    public b(CharSequence r100, d r101, MeasureMode r102, MeasureMode r103, float r104, float r105) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "attributes");
        Intrinsics.checkNotNullParameter(r102, "widthMode");
        Intrinsics.checkNotNullParameter(r103, "heightMode");
        this.f283602a = new a(r100, r101);
        this.f283605d = r104;
        this.f283606e = r105;
        this.f283603b = r102;
        this.f283604c = r103;
    }
}
