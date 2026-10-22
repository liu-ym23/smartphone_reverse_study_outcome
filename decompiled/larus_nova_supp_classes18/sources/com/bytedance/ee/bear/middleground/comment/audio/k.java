package com.bytedance.ee.bear.middleground.comment.audio;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements Drawable.Callback {
    public final TextView a;

    public k(TextView r1) {
        this.a = r1;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r1) {
        TextView r2 = this.a;
        if (r2 == null) goto L6;
        r2.invalidate();
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r1, Runnable r2) {
        TextView r3 = this.a;
        if (r3 == null) goto L6;
        r3.removeCallbacks(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        TextView r4 = this.a;
        if (r4 == null) goto L6;
        r4.postDelayed(r2, r3);
        return;
    }
}
