package cc3;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements View.OnTouchListener {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        r2.getParent().getParent().requestDisallowInterceptTouchEvent(true);
        r2.getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }
}
