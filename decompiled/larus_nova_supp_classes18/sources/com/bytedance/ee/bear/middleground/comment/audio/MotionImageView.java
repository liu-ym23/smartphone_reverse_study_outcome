package com.bytedance.ee.bear.middleground.comment.audio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MotionImageView extends AppCompatImageView {
    public b a;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.ImageView*/.onDetachedFromWindow();
        b r0 = this.a;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    public MotionImageView(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r2) {
        if (this.a == null) goto L8;
        if (isEnabled() == false) goto L8;
        this.a.d(r2);
    L8:
        return super/*android.widget.ImageView*/.onTouchEvent(r2);
    }

    public void setMotionCallbackListener(b r1) {
        this.a = r1;
    }

    public MotionImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public MotionImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
