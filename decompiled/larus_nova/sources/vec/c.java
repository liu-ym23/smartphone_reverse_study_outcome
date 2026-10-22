package vec;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f554544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f554545b;

    public final void b() {
        this.f554544a.removeAllViews();
    }

    public c(Context r100) {
        FrameLayout r101 = new FrameLayout(r100);
        this.f554544a = r101;
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public final void a(View r100) {
        this.f554545b = r100;
        this.f554544a.addView(r100);
    }
}
