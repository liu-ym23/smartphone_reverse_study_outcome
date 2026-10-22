package rcc;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public abstract class c implements View.OnClickListener {
    public abstract void a(View r100);

    public c() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        e.a.f537201a.getClass();
        r100.getLocationInWindow(new int[2]);
        r100.getTop();
        r100.getRight();
        r100.getWidth();
        r100.getHeight();
        r100.getLocationOnScreen(new int[2]);
        a(r100);
    }
}
