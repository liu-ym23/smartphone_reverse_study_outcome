package lib;

import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KeyboardFunctionEditText f509472a;

    public k(KeyboardFunctionEditText r100) {
        this.f509472a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (this.f509472a.canScrollVertically(1) == false) goto L5;
    L6:
        r100.getParent().requestDisallowInterceptTouchEvent(true);
        if (r101.getAction() != 1) goto L9;
        r100.getParent().requestDisallowInterceptTouchEvent(false);
    L9:
        return false;
    L5:
        if (this.f509472a.canScrollVertically(-1) == false) goto L9;
        goto L6
    }
}
