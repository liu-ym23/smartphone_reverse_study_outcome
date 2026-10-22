package com.ss.android.lark.keyboard.edittext2.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.ss.android.lark.utils.UIHelper;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f429210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f429211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<Drawable> f429212c;

    public d(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        super(r100, 2);
        this.f429210a = UIHelper.dp2px(3.0f);
        this.f429211b = UIHelper.dp2px(3.0f);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return (this.f429210a + super.getSize(r100, r101, r102, r103, r104)) + this.f429211b;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        WeakReference<Drawable> r109 = this.f429212c;
        if (r109 == null) goto L5;
        Drawable r110 = r109.get();
    L6:
        if (r110 != null) goto L8;
        r110 = getDrawable();
        this.f429212c = new WeakReference(r110);
    L8:
        r100.save();
        if (r110 == null) goto L17;
        int r111 = r107 - r110.getBounds().bottom;
        int r112 = ((ImageSpan) this).mVerticalAlignment;
        if (r112 != 1) goto L14;
        r111 = r111 - r108.getFontMetricsInt().descent;
    L16:
        r100.translate(this.f429210a + r104, r111);
        r110.draw(r100);
        goto L17
    L14:
        if (r112 != 2) goto L16;
        Paint.FontMetricsInt r113 = r108.getFontMetricsInt();
        r111 = (r106 + ((r113.descent + r113.ascent) / 2)) - (r110.getBounds().height() / 2);
    L17:
        r100.restore();
        return;
    L5:
        r110 = null;
        goto L6
    }
}
