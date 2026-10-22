package com.bytedance.ee.bear.middleground.comment.audio;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f230343a;

    public k(TextView r100) {
        this.f230343a = r100;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        TextView r101 = this.f230343a;
        if (r101 == null) goto L6;
        r101.invalidate();
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        TextView r102 = this.f230343a;
        if (r102 == null) goto L6;
        r102.removeCallbacks(r101);
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        TextView r103 = this.f230343a;
        if (r103 == null) goto L6;
        r103.postDelayed(r101, r102);
        return;
    }
}
