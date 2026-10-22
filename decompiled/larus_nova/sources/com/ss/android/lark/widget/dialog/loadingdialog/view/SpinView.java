package com.ss.android.lark.widget.dialog.loadingdialog.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.larus.nova.R;
import gcc.b;
import hcc.a;

/* JADX INFO: loaded from: classes38.dex */
public class SpinView extends ImageView implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f445827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f445828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f445829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f445830d;

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        this.f445829c = false;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f445829c = true;
        post(this.f445830d);
    }

    public SpinView(Context r100) {
        super(r100);
        setImageResource(R.drawable.loading_dialog_spinner);
        this.f445828b = 83;
        this.f445830d = new a(this);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        r100.rotate(this.f445827a, getWidth() / 2, getHeight() / 2);
        super.onDraw(r100);
    }

    @Override // gcc.b
    public void setAnimationSpeed(float r100) {
        this.f445828b = (int) (83.0f / r100);
    }

    public SpinView(Context r100, AttributeSet r101) {
        super(r100, r101);
        setImageResource(R.drawable.loading_dialog_spinner);
        this.f445828b = 83;
        this.f445830d = new a(this);
    }
}
