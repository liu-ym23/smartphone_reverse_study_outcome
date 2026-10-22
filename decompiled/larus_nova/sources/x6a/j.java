package x6a;

import android.graphics.Rect;
import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: loaded from: classes32.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f562749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f562750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f562751c;

    public final Rect a() {
        RectF r100 = this.f562749a;
        return new Rect((int) r100.left, (int) r100.top, (int) r100.right, (int) r100.bottom);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        RectF r102 = this.f562749a;
        if (r102 != null) goto L11;
    L23:
        if (r102 == null) goto L25;
    L32:
        if (r102 == null) goto L41;
        RectF r103 = r101.f562749a;
        if (r103 == null) goto L41;
        if (this.f562751c == true) goto L41;
        if (r101.f562751c == true) goto L41;
        return r102.equals(r103);
    L41:
        if (r102 == null) goto L43;
    L49:
        return false;
    L43:
        if (r101.f562749a != null) goto L49;
        if (this.f562751c == true) goto L49;
        if (r101.f562751c == true) goto L49;
        return true;
    L25:
        if (r101.f562749a != null) goto L32;
        if (this.f562751c == false) goto L32;
        if (r101.f562751c == false) goto L32;
        return Arrays.equals(this.f562750b, r101.f562750b);
    L11:
        if (this.f562750b == null) goto L23;
        if (this.f562751c == false) goto L23;
        if (r101.f562751c == false) goto L23;
        if (r102.equals(r101.f562749a) == true) goto L19;
    L21:
        return false;
    L19:
        if (Arrays.equals(this.f562750b, r101.f562750b) == false) goto L21;
        return true;
    }

    public j(RectF r100, float[] r101) {
        boolean r102 = false;
        this.f562751c = false;
        this.f562749a = r100;
        this.f562750b = r101;
        if (r101 != null) goto L6;
    L14:
        this.f562751c = r102;
        return;
    L6:
        if (r101.length != 8) goto L14;
        int r103 = r101.length;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L14;
        if (r101[r104] > 0.0f) goto L12;
        r104 = r104 + 1;
        goto L9
    L12:
        r102 = true;
        goto L14
    }
}
