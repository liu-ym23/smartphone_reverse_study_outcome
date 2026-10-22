package dp7;

import android.view.View;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends cp7.c.e<ProgressBar> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f469609a = null;

    static {
        f469609a = new c();
    }

    public c() {
    }

    @Override // cp7.c.e
    public final View b(View r100) {
        if ((r100 instanceof ProgressBar) == true) goto L6;
        r100 = null;
    L6:
        return (ProgressBar) r100;
    }

    @Override // cp7.c.e
    public final int c(View r100) {
        return cp7.c.a.C5565a.b(((ProgressBar) r100).getProgressDrawable());
    }
}
