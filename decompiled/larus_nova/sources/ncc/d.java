package ncc;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes38.dex */
public class d implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f518723a;

    public d(View r100) {
        this.f518723a = new WeakReference(r100);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r100) {
        if (this.f518723a.get() == null) goto L6;
        this.f518723a.get().invalidate();
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        if (this.f518723a.get() == null) goto L6;
        this.f518723a.get().removeCallbacks(r101);
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        if (this.f518723a.get() == null) goto L6;
        this.f518723a.get().postDelayed(r101, r102);
        return;
    }
}
