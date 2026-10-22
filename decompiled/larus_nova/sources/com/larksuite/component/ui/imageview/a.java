package com.larksuite.component.ui.imageview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import h18.e;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f284168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f284169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f284170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f284171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f284172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f284173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f284174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f284175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f284176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f284177j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f284178k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f284179l;

    /* JADX INFO: renamed from: com.larksuite.component.ui.imageview.a$a, reason: collision with other inner class name */
    public static final class C3912a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f284180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f284181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Drawable f284182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f284183d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Drawable f284184e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f284185f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Context f284186g;

        public C3912a(Context r100) {
            this.f284183d = -1;
            this.f284186g = r100;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void a() {
        if (TextUtils.isEmpty(this.f284168a) == true) goto L8;
        int r100 = (int) this.f284174g.measureText(this.f284168a.toString());
        int r101 = (int) (this.f284174g.getFontMetrics().bottom - this.f284174g.getFontMetrics().top);
        if (this.f284168a.length() != 1) goto L7;
        int r102 = (int) (Math.max(r100, r101) + (this.f284173f * 2.0f));
        this.f284178k = r102;
        this.f284177j = r102;
    L9:
        Drawable r103 = this.f284172e;
        if (r103 == null) goto L20;
        int r104 = r103.getIntrinsicWidth();
        int r105 = this.f284172e.getIntrinsicWidth();
        this.f284172e.setBounds(0, 0, r104, r105);
        int r106 = this.f284177j;
        if (r106 == 0) goto L15;
        r104 = r106;
    L15:
        this.f284177j = r104;
        int r107 = this.f284178k;
        if (r107 == 0) goto L19;
        r105 = r107;
    L19:
        this.f284178k = r105;
    L20:
        Drawable r108 = this.f284170c;
        if (r108 == null) goto L30;
        int r109 = this.f284177j;
        if (r109 != 0) goto L25;
        r109 = r108.getIntrinsicWidth();
    L25:
        this.f284177j = r109;
        int r110 = this.f284178k;
        if (r110 != 0) goto L28;
        r110 = this.f284170c.getIntrinsicHeight();
    L28:
        this.f284178k = r110;
        this.f284170c.setBounds(0, 0, this.f284177j, r110);
        return;
    L30:
        return;
    L7:
        int r111 = com.larksuite.framework.utils.autoscale.a.f285947a;
        float r112 = r100 + (this.f284173f * 2.0f);
        Resources r113 = Resources.getSystem();
        this.f284177j = (int) (r112 + ((WindowDisplayMetricsOverride.apply(r113, r113.getDisplayMetrics()).density * 8.0f) + 0.5f));
        this.f284178k = (int) (r101 + (this.f284173f * 2.0f));
        goto L9
    L8:
        this.f284177j = 0;
        this.f284178k = 0;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f284178k;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f284177j;
    }

    public a(C3912a r100) {
        this.f284175h = false;
        this.f284176i = false;
        this.f284179l = new Rect();
        Context r101 = r100.f284186g;
        this.f284168a = r100.f284180a;
        float r102 = r100.f284181b;
        if (r102 > 0.0f) goto L6;
        r102 = this.f284169b;
    L6:
        this.f284169b = r102;
        this.f284171d = r100.f284183d;
        Drawable r103 = r100.f284182c;
        if (r103 != null) goto L10;
        r103 = new ColorDrawable(-65536);
    L10:
        this.f284170c = r103;
        this.f284172e = r100.f284184e;
        float r104 = r100.f284185f;
        if (r104 >= 0.0f) goto L14;
        r104 = this.f284173f;
    L14:
        this.f284173f = r104;
        TextPaint r105 = new TextPaint();
        this.f284174g = r105;
        r105.setAntiAlias(true);
        r105.setColor(this.f284171d);
        r105.setTextSize(this.f284169b);
        r105.setTextAlign(Paint.Align.CENTER);
        r105.setStyle(Paint.Style.FILL);
        r105.setAlpha(255);
        int r106 = e.f483540a;
        r105.setTypeface(e.b(r100.f284186g, 1));
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Rect r101 = getBounds();
        Drawable r102 = this.f284170c;
        if (r102 == null) goto L6;
        Rect r103 = r102.getBounds();
        int r104 = r103.width();
        int r105 = r103.height();
        r100.save();
        r100.translate((r101.width() - r104) / 2, (r101.height() - r105) / 2);
        this.f284170c.draw(r100);
        r100.restore();
    L6:
        if (this.f284172e == null) goto L9;
        r100.save();
        r100.translate((r101.width() - this.f284172e.getBounds().width()) / 2, (r101.height() - this.f284172e.getBounds().width()) / 2);
        this.f284172e.draw(r100);
        r100.restore();
        return;
    L9:
        if (TextUtils.isEmpty(this.f284168a) == true) goto L13;
        String r106 = this.f284168a.toString();
        float r107 = r101.centerX();
        this.f284174g.getTextBounds(r106, 0, this.f284168a.length(), this.f284179l);
        r100.drawText(r106, r107, r101.centerY() - this.f284179l.exactCenterY(), this.f284174g);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f284174g.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f284174g.setColorFilter(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r100, int r101, int r102, int r103) {
        super.setBounds(r100, r101, r102, r103);
        a();
    }
}
