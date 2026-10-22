package com.ss.android.lark.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.ss.android.lark.log.Log;
import pl.droidsonroids.gif.GifImageView;

/* JADX INFO: loaded from: classes38.dex */
public class AutoRecycleGifImageView extends GifImageView {
    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public AutoRecycleGifImageView(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("GifImageView draw failed", e, true);
    }

    public AutoRecycleGifImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public AutoRecycleGifImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
