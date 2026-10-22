package mn5;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements View.OnTouchListener {
    public GestureDetector a;

    public c() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        GestureDetector r3 = this.a;
        if (r3 != null) goto L5;
        return false;
    L5:
        return r3.onTouchEvent(r2);
    }
}
