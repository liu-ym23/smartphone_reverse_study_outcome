package mn5;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GestureDetector f514544a;

    public c() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        GestureDetector r102 = this.f514544a;
        if (r102 != null) goto L5;
        return false;
    L5:
        return r102.onTouchEvent(r101);
    }
}
