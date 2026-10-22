package nrb;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f520272a;

    public c(View.OnClickListener r100) {
        this.f520272a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101.getAction() != 1) goto L7;
        View.OnClickListener r102 = this.f520272a;
        if (r102 == null) goto L7;
        r102.onClick(r100);
    L7:
        return true;
    }
}
