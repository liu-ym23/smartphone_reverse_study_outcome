package com.ss.android.widget.slider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes40.dex */
public class UndergroundView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<View> f456073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f456074b;

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f456073a.get() == null) goto L6;
        this.f456073a.clear();
        return;
    }

    public UndergroundView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        View r101 = this.f456073a.get();     // Catch: Throwable -> L9
        int r102 = getWidth();     // Catch: Throwable -> L9
        int r103 = getHeight();     // Catch: Throwable -> L9
        if (r101 == null) goto L5;
        r101.draw(r100);     // Catch: Throwable -> L9
    L5:
        Drawable r104 = this.f456074b;     // Catch: Throwable -> L9
        if (r104 == null) goto L14;
        r104.setBounds(0, 0, r102, r103);     // Catch: Throwable -> L9
        this.f456074b.draw(r100);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public void setHostView(View r100) {
        if (this.f456073a.get() != r100) goto L5;
        return;
    L5:
        this.f456073a.clear();
        this.f456073a = new WeakReference(r100);
    }

    public UndergroundView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public UndergroundView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f456073a = new WeakReference(null);
    }
}
