package fm4;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f477812a;

    public a(float r100) {
        this.f477812a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 != 0) goto L5;
        r100.setAlpha(this.f477812a);
        return false;
    L5:
        if (r102 != 1) goto L7;
    L9:
        r100.setAlpha(1.0f);
        return false;
    L7:
        if (r102 == 3) goto L9;
        return false;
    }
}
