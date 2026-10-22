package com.ss.android.lark.widget.span;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.style.ImageSpan;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class n extends ImageSpan implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f448708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f448709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f448710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f448711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f448712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f448713f;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
    }

    public Drawable a() {
        if (this.f448712e != null) goto L6;
        Drawable r100 = getDrawable();
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f448712e = r100;
    L6:
        return this.f448712e;
    }

    @Override // com.ss.android.lark.widget.span.t
    public final int getPaddingBottom() {
        return this.f448711d;
    }

    @Override // com.ss.android.lark.widget.span.t
    public final int getPaddingLeft() {
        return this.f448708a;
    }

    @Override // com.ss.android.lark.widget.span.t
    public final int getPaddingRight() {
        return this.f448709b;
    }

    @Override // com.ss.android.lark.widget.span.t
    public final int getPaddingTop() {
        return this.f448710c;
    }

    public n(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT < 29) goto L5;
        int r101 = 2;
    L6:
        super(r100, R.drawable.chat_window_image_item_holder, r101);
        this.f448713f = new Rect();
        return;
    L5:
        r101 = 0;
        goto L6
    }

    public n(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        if (Build.VERSION.SDK_INT < 29) goto L5;
        int r101 = 2;
    L6:
        super(r100, r101);
        this.f448713f = new Rect();
        this.f448712e = r100;
        return;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Drawable r105 = a();
        if (r105 != null) goto L5;
        return 0;
    L5:
        Rect r106 = this.f448713f;
        r106.set(r105.getBounds());
        t.a.a(this, r106);
        if (r104 == null) goto L9;
        int r107 = -r106.bottom;
        r104.ascent = r107;
        r104.descent = 0;
        r104.top = r107;
        r104.bottom = 0;
    L9:
        return r106.right;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r110) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r110, "paint");
        Drawable r108 = this.f448712e;
        if (r108 != null) goto L5;
        return;
    L5:
        r100.save();
        Rect r109 = this.f448713f;
        r109.set(r108.getBounds());
        t.a.a(this, r109);
        int r111 = (r107 - r109.bottom) + this.f448710c;
        int r112 = ((ImageSpan) this).mVerticalAlignment;
        if (r112 != 1) goto L9;
        r111 = r111 - r110.getFontMetricsInt().descent;
    L11:
        r100.translate(r104 + this.f448708a, r111);
        r108.draw(r100);
        r100.restore();
        return;
    L9:
        if (r112 != 2) goto L11;
        r111 = (r105 + ((r107 - r105) / 2)) - (r109.height() / 2);
        goto L11
    }
}
