package z6a;

import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes32.dex */
public final class n extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f570601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f570602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f570603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f570604i;

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
    }

    public n() {
        if (this.f570556e == false) goto L5;
        this.f570552a = 1;
    L6:
        this.f570553b = 0.0f;
        return;
    L5:
        this.f570552a = 0;
        goto L6
    }

    @Override // z6a.a
    public final int a() {
        return this.f570601f;
    }

    public final int b(int r100, int r101, int r102, int r103) {
        if (this.f570556e == false) goto L5;
        int r104 = this.f570552a;
        if (r104 != 4) goto L9;
        return r100;
    L9:
        if (r104 == 7) goto L15;
        if (r104 == 11) goto L18;
        return (r100 - r102) + this.f570554c;
    L18:
        return ((r101 + r100) - this.f570601f) / 2;
    L15:
        return r101 - this.f570601f;
    L5:
        return (r101 - r103) - this.f570601f;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        if (r104 == null) goto L40;
        if (r104.descent != r104.ascent) goto L7;
        r104.ascent = r100.getFontMetricsInt().ascent;
        r104.descent = r100.getFontMetricsInt().descent;
    L7:
        if (this.f570556e == false) goto L17;
        int r105 = this.f570552a;
        if (r105 != 1) goto L13;
        int r106 = this.f570603h;
        if (r106 == 0) goto L13;
        this.f570554c = -r106;
    L27:
        int r107 = r104.ascent;
        int r108 = this.f570554c;
        if (r107 <= r108) goto L30;
        r104.ascent = r108;
    L30:
        int r109 = r104.descent;
        int r110 = r108 + this.f570601f;
        if (r109 >= r110) goto L33;
        r104.descent = r110;
    L33:
        int r111 = r104.top;
        int r112 = r104.ascent;
        if (r111 <= r112) goto L36;
        r104.top = r112;
    L36:
        int r113 = r104.bottom;
        int r114 = r104.descent;
        if (r113 >= r114) goto L40;
        r104.bottom = r114;
    L13:
        float r115 = -this.f570601f;
        c r116 = this.f570555d;
        if (r116 == null) goto L16;
        r115 = r116.a(r105, this.f570553b, r115, 0.0f);
    L16:
        this.f570554c = (int) r115;
        goto L27
    L17:
        int r117 = r104.descent;
        int r118 = r104.ascent;
        int r119 = r117 - r118;
        int r120 = this.f570601f;
        switch(this.f570552a) {
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L26;
            case 5: goto L26;
            case 6: goto L19;
            case 7: goto L21;
            case 8: goto L21;
            case 9: goto L20;
            default: goto L19;
        };
    L19:
        r118 = r118 + ((r119 - r120) / 2);
        goto L26
    L20:
        int r121 = -r120;
        float r122 = this.f570553b;
    L24:
        r118 = r121 - ((int) r122);
        goto L26
    L21:
        r118 = r117 - r120;
        goto L26
    L22:
        r118 = r118 + ((int) (r119 * 0.1f));
        goto L26
    L23:
        r121 = r117 - r120;
        r122 = r119 * 0.1f;
        goto L24
    L25:
        r118 = -r120;
    L26:
        this.f570554c = r118;
    L40:
        return this.f570602g;
    }
}
