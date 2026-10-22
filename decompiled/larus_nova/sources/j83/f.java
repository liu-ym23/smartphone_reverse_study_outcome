package j83;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f497697a;

    public f(a r100) {
        this.f497697a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        return this.f497697a.f497673a.b(r101);
    }
}
