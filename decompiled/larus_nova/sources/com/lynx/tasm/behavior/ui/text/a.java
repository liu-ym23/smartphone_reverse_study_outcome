package com.lynx.tasm.behavior.ui.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.e;
import z6a.c;

/* JADX INFO: loaded from: classes32.dex */
public abstract class a extends z6a.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f383080p = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f383081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f383082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f383083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f383084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f383085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f383086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f383087l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f383088m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e f383089n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable.Callback f383090o;

    public abstract Drawable c();

    public void d() {
    }

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    @Override // z6a.a
    public final int a() {
        return this.f383081f + this.f383086k;
    }

    public final int b(Paint.FontMetricsInt r100) {
        int r101 = r100.descent;
        int r102 = r100.ascent;
        int r103 = r101 - r102;
        int r104 = this.f383081f + this.f383086k;
        switch(this.f570552a) {
            case 1: goto L12;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L14;
            case 7: goto L16;
            case 8: goto L16;
            case 9: goto L6;
            case 10: goto L5;
            default: goto L14;
        };
    L5:
        int r105 = -r104;
        float r106 = (this.f570553b * r103) / 100.0f;
    L15:
        return r105 - ((int) r106);
    L6:
        r105 = -r104;
        r106 = this.f570553b;
        goto L15
    L13:
        return r102;
    L14:
        return r102 + ((r103 - r104) / 2);
    L16:
        return r101 - r104;
    L17:
        return r102 + ((int) (r103 * 0.1f));
    L18:
        return (r101 - r104) - ((int) (r103 * 0.1f));
    L12:
        return -r104;
    }

    public void j(Drawable.Callback r100) {
        this.f383090o = r100;
    }

    public static void i(Spanned r100, Drawable.Callback r101) {
        int r102 = 0;
        a[] r103 = (a[]) r100.getSpans(0, r100.length(), a.class);
        int r104 = r103.length;
    L3:
        if (r102 >= r104) goto L5;
        a r105 = r103[r102];
        r105.e();
        r105.j(r101);
        r102 = r102 + 1;
        goto L3
    }

    public a(int r100, int r101, int[] r102) {
        this.f383087l = 0;
        this.f383088m = 0.0f;
        this.f383082g = r100;
        this.f383081f = r101;
        int r103 = r102[0];
        this.f383083h = r103;
        int r104 = r102[1];
        this.f383084i = r104;
        this.f383085j = r103 + r102[2];
        this.f383086k = r104 + r102[3];
        this.f570552a = 0;
        this.f570553b = 0.0f;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        if ((r101 instanceof SpannableStringBuilder) == false) goto L6;
    L8:
        boolean r105 = false;
    L9:
        if (r105 == false) goto L11;
        return 0;
    L11:
        if (r104 == null) goto L35;
        if (r104.descent != r104.ascent) goto L16;
        r104.ascent = r100.getFontMetricsInt().ascent;
        r104.descent = r100.getFontMetricsInt().descent;
    L16:
        if (this.f570556e == false) goto L21;
        float r106 = -(this.f383081f + this.f383086k);
        c r107 = this.f570555d;
        if (r107 == null) goto L20;
        r106 = r107.a(this.f570552a, this.f570553b, r106, 0.0f);
    L20:
        this.f570554c = (int) r106;
    L22:
        int r108 = r104.ascent;
        int r109 = this.f570554c;
        if (r108 <= r109) goto L25;
        r104.ascent = r109;
    L25:
        int r110 = r104.descent;
        int r111 = (r109 + this.f383081f) + this.f383086k;
        if (r110 >= r111) goto L28;
        r104.descent = r111;
    L28:
        int r112 = r104.top;
        int r113 = r104.ascent;
        if (r112 <= r113) goto L31;
        r104.top = r113;
    L31:
        int r114 = r104.bottom;
        int r115 = r104.descent;
        if (r114 >= r115) goto L35;
        r104.bottom = r115;
        goto L35
    L21:
        this.f570554c = b(r104);
    L35:
        return this.f383082g + this.f383085j;
    L6:
        if (r101.charAt(r102) == "I".charAt(0)) goto L8;
        r105 = true;
        goto L9
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r110) {
        boolean r108 = false;
        if ((r101 instanceof SpannableStringBuilder) == false) goto L6;
    L8:
        if (r108 == false) goto L11;
        return;
    L11:
        if (c() != null) goto L13;
        return;
    L13:
        Drawable r109 = c();
        r100.save();
        Paint.FontMetricsInt r111 = r110.getFontMetricsInt();
        int r112 = this.f570552a;
        if (r112 != 4) goto L16;
        int r113 = r105;
    L31:
        if (this.f383087l == 0) goto L33;
        Rect r114 = new Rect(Math.round(r104), Math.round(r105 + this.f383088m), Math.round(r109.getBounds().width() + r104), Math.round(r107 + this.f383088m));
        Paint r115 = new Paint();
        r115.setStyle(Paint.Style.FILL);
        r115.setColor(this.f383087l);
        r100.drawRect(r114, r115);
    L33:
        r100.translate(r104 + this.f383083h, (r113 + this.f383084i) + this.f383088m);
        e r116 = this.f383089n;
        if (r116 == null) goto L40;
        BackgroundDrawable r117 = (BackgroundDrawable) r116.f383142b;
        if (r117 == null) goto L40;
        r117.draw(r100);
        if (((BackgroundDrawable) this.f383089n.f383142b).l() == null) goto L40;
        r100.clipPath(((BackgroundDrawable) this.f383089n.f383142b).l());
    L40:
        r109.draw(r100);
        r100.restore();
        return;
    L16:
        if (r112 != 7) goto L18;
        r113 = (r107 - this.f383081f) - this.f383086k;
        goto L31
    L18:
        if (r112 != 11) goto L20;
        r113 = (((r107 + r105) - this.f383081f) - this.f383086k) / 2;
        goto L31
    L20:
        if (this.f570556e == false) goto L23;
        int r118 = this.f570554c;
    L26:
        r113 = r118 + r106;
        goto L31
    L23:
        if (r112 != 6) goto L25;
        r113 = (((r107 + r105) - this.f383081f) - this.f383086k) / 2;
        goto L31
    L25:
        r118 = b(r111);
        goto L26
    L6:
        if (r101.charAt(r102) == "I".charAt(0)) goto L8;
        r108 = true;
        goto L8
    }
}
