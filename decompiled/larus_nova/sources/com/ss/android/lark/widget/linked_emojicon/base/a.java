package com.ss.android.lark.widget.linked_emojicon.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.LKUILightTextView;
import java.lang.ref.WeakReference;
import java.util.Objects;
import qsb.b;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends DynamicDrawableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f446372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f446373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f446374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f446375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f446376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f446377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f446378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeakReference<Drawable> f446379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IGetDataCallback<Boolean> f446380i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f446381j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f446382k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f446383l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f446384m;

    /* JADX INFO: renamed from: com.ss.android.lark.widget.linked_emojicon.base.a$a, reason: collision with other inner class name */
    public interface InterfaceC5401a {
        void a();

        void b();
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{0, Integer.valueOf(this.f446373b), Integer.valueOf(this.f446374c), Integer.valueOf(this.f446375d), Integer.valueOf(this.f446376e), Integer.valueOf(this.f446377f), this.f446381j});
    }

    public final Drawable a() {
        if (this.f446382k == false) goto L5;
        WeakReference<Drawable> r100 = this.f446379h;
        if (r100 != null) goto L9;
    L10:
        this.f446379h = new WeakReference(getDrawable());
    L12:
        return this.f446379h.get();
    L9:
        if (r100.get() != null) goto L12;
    L5:
        return getDrawable();
    }

    @Override // android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        Drawable r100 = this.f446378g;     // Catch: Exception -> L9
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = this.f446373b;     // Catch: Exception -> L9
        this.f446375d = r101;     // Catch: Exception -> L9
        int r102 = (r101 * r100.getIntrinsicWidth()) / this.f446378g.getIntrinsicHeight();     // Catch: Exception -> L9
        this.f446376e = r102;     // Catch: Exception -> L9
        int r103 = this.f446374c;     // Catch: Exception -> L9
        int r104 = this.f446375d;     // Catch: Exception -> L9
        int r105 = (r103 - r104) / 2;     // Catch: Exception -> L9
        this.f446377f = r105;     // Catch: Exception -> L9
        this.f446378g.setBounds(0, r105, r102, r104 + r105);     // Catch: Exception -> L9
    L8:
        return this.f446378g;
    }

    public final void b(LKUILightTextView.f r100) {
        final WeakReference r101 = new WeakReference(r100);
        IGetDataCallback<Boolean> r102 = new EmojiconSpan$2(this, r101);
        this.f446380i = r102;
        EmojiHandler.c(this.f446381j, null, r102);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        r101.getClass();
        if (this.f446373b == r101.f446373b) goto L11;
    L21:
        return false;
    L11:
        if (this.f446374c != r101.f446374c) goto L21;
        if (this.f446375d != r101.f446375d) goto L21;
        if (this.f446376e != r101.f446376e) goto L21;
        if (this.f446377f != r101.f446377f) goto L21;
        if (Objects.equals(this.f446381j, r101.f446381j) == false) goto L21;
        return true;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        if (b.a().i7(this.f446381j) == true) goto L5;
        Drawable r105 = a();
        if (r105 == null) goto L9;
        Rect r106 = r105.getBounds();
        Paint.FontMetrics r107 = r100.getFontMetrics();
        int r108 = (int) Math.min(r107.top, r107.bottom - (r106.bottom - r106.top));
        if (r104 == null) goto L14;
        r104.ascent = r108;
        r104.top = r108;
        r104.descent = (int) r107.descent;
        r104.bottom = (int) r107.bottom;
    L14:
        return r106.right + (this.f446383l * 2);
    L9:
        return (int) r100.measureText(r101.toString(), r102, r103);
    L5:
        return ((int) r100.measureText(r101.toString(), r102, r103)) + (this.f446383l * 2);
    }

    public a(Context r100, Drawable r101, String r102, int r103, int r104, int r105) {
        int r106 = UIHelper.dp2px(1.0f);
        super(r104);
        this.f446382k = true;
        this.f446372a = new WeakReference(r100);
        this.f446378g = r101;
        this.f446373b = r103;
        this.f446375d = r103;
        this.f446376e = r103;
        this.f446374c = r105;
        this.f446381j = r102;
        this.f446383l = r106;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r114, int r115, int r116, int r117, Paint r118) {
        if (b.a().i7(this.f446381j) == true) goto L5;
        Drawable r100 = a();
        r110.save();
        if (r100 != null) goto L16;
        r110.drawText(r111, r112, r113, r114, r116, r118);
    L25:
        r110.restore();
        return;
    L16:
        int r101 = r117 - r100.getBounds().bottom;
        int r102 = ((DynamicDrawableSpan) this).mVerticalAlignment;
        if (r102 != 1) goto L19;
        r101 = ((((r117 - r115) / 2) + r115) - ((r100.getBounds().bottom - r100.getBounds().top) / 2)) - this.f446377f;
    L24:
        r110.translate(this.f446383l + r114, r101);
        r100.draw(r110);
        goto L25
    L19:
        if (r102 != 2) goto L22;
        Paint.FontMetricsInt r103 = r118.getFontMetricsInt();
        r101 = ((((r103.descent + r116) + r116) + r103.ascent) / 2) - (r100.getBounds().bottom / 2);
        goto L24
    L22:
        if (r102 != 3) goto L24;
        r101 = ((r117 - r115) - (r100.getBounds().bottom - r100.getBounds().top)) / 2;
        goto L24
    L5:
        if (this.f446384m != null) goto L11;
        this.f446384m = new Paint(r118);
        Context r104 = this.f446372a.get();
        if (r104 != null) goto L9;
        int r105 = UIHelper.getColor(R.color.text_caption);
    L10:
        this.f446384m.setColor(r105);
        goto L11
    L9:
        r105 = UIUtils.getColor(r104, R.color.text_caption);
    L11:
        r110.drawText(r111, r112, r113, r114 + this.f446383l, r116, this.f446384m);
    }
}
