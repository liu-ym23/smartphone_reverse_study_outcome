package sma;

import android.graphics.LinearGradient;
import android.text.TextUtils;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f542597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f542598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final char[] f542599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f542600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f542601e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextUtils.TruncateAt f542602f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f542603g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f542604h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f542605i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearGradient f542606j;

    public final String toString() {
        return "TextLayoutCache(text=" + this.f542597a + ", displayText=" + this.f542598b + ", chars=" + Arrays.toString(this.f542599c) + ", widths=" + Arrays.toString(this.f542600d) + ", contentWidth=" + this.f542601e + ", ellipsize=" + this.f542602f + ", textSizePx=" + this.f542603g + ", baseTotalWidth=" + this.f542604h + ", baseStartX=" + this.f542605i + ", gradientShader=" + this.f542606j + ')';
    }

    public final int hashCode() {
        int r100 = ((((((((this.f542597a.hashCode() * 31) + this.f542598b.hashCode()) * 31) + Arrays.hashCode(this.f542599c)) * 31) + Arrays.hashCode(this.f542600d)) * 31) + Float.floatToIntBits(this.f542601e)) * 31;
        TextUtils.TruncateAt r101 = this.f542602f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((((r100 + r103) * 31) + Float.floatToIntBits(this.f542603g)) * 31) + Float.floatToIntBits(this.f542604h)) * 31) + Float.floatToIntBits(this.f542605i)) * 31;
        LinearGradient r105 = this.f542606j;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f542597a, r101.f542597a) == true) goto L11;
    L41:
        return false;
    L11:
        if (Intrinsics.areEqual(this.f542598b, r101.f542598b) == false) goto L41;
        if (Arrays.equals(this.f542599c, r101.f542599c) == false) goto L41;
        if (Arrays.equals(this.f542600d, r101.f542600d) == false) goto L41;
        if (this.f542601e != r101.f542601e) goto L19;
        boolean r102 = true;
    L20:
        if (r102 == false) goto L41;
        if (this.f542602f != r101.f542602f) goto L41;
        if (this.f542603g != r101.f542603g) goto L26;
        boolean r103 = true;
    L27:
        if (r103 == false) goto L41;
        if (this.f542604h != r101.f542604h) goto L31;
        boolean r104 = true;
    L32:
        if (r104 == false) goto L41;
        if (this.f542605i != r101.f542605i) goto L36;
        boolean r105 = true;
    L37:
        if (r105 == false) goto L41;
        if (Intrinsics.areEqual(this.f542606j, r101.f542606j) == false) goto L41;
        return true;
    L36:
        r105 = false;
        goto L37
    L31:
        r104 = false;
        goto L32
    L26:
        r103 = false;
        goto L27
    L19:
        r102 = false;
        goto L20
    }

    public c(CharSequence r100, CharSequence r101, char[] r102, float[] r103, float r104, TextUtils.TruncateAt r105, float r106, float r107, float r110) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "displayText");
        Intrinsics.checkNotNullParameter(r102, "chars");
        Intrinsics.checkNotNullParameter(r103, "widths");
        this.f542597a = r100;
        this.f542598b = r101;
        this.f542599c = r102;
        this.f542600d = r103;
        this.f542601e = r104;
        this.f542602f = r105;
        this.f542603g = r106;
        this.f542604h = r107;
        this.f542605i = r110;
        this.f542606j = null;
    }
}
