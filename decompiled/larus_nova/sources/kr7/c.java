package kr7;

import android.graphics.drawable.Drawable;
import com.bytedance.xelement.markdown.MarkdownShadowNode;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m0 f505726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<MarkdownShadowNode> f505727b;

    public c() {
        this.f505726a = null;
        this.f505727b = null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        m0 r101 = this.f505726a;
        if (r101 == null) goto L6;
        r101.postInvalidate();
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        UIThreadUtils.removeCallbacks(r101, r100);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        UIThreadUtils.runOnUiThreadAtTime(r101, r100, r102);
    }
}
