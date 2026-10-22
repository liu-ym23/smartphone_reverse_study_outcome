package d45;

import android.view.MotionEvent;
import android.view.View;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WheelView f466823a;

    public a(WheelView r100) {
        this.f466823a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        this.f466823a.getParent().requestDisallowInterceptTouchEvent(false);
    L11:
        return false;
    L10:
        this.f466823a.getParent().requestDisallowInterceptTouchEvent(true);
        goto L11
    L5:
        if (r101.getAction() != 1) goto L7;
        r102 = true;
        goto L8
    }
}
