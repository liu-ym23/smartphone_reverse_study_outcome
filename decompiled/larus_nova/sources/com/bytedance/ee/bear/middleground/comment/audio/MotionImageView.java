package com.bytedance.ee.bear.middleground.comment.audio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes18.dex */
public class MotionImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f230292a;

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b r100 = this.f230292a;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    public MotionImageView(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f230292a == null) goto L8;
        if (isEnabled() == false) goto L8;
        this.f230292a.d(r100);
    L8:
        return super.onTouchEvent(r100);
    }

    public void setMotionCallbackListener(b r100) {
        this.f230292a = r100;
    }

    public MotionImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public MotionImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
