package io.noties.markwon.ext.tables;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes41.dex */
public final class n implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TableRowSpan2 f492541a;

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
    }

    public n(TableRowSpan2 r100) {
        this.f492541a = r100;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        a.InterfaceC6318a r101 = this.f492541a.f492506a;
        if (r101 == null) goto L6;
        p r102 = (p) r101;
        r102.f492544b.removeCallbacks(r102.f492543a);
        r102.f492544b.post(r102.f492543a);
        return;
    }
}
