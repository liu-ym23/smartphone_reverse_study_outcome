package d45;

import android.view.MotionEvent;
import android.view.View;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnTouchListener {
    public final /* synthetic */ WheelView a;

    public a(WheelView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L10;
        this.a.getParent().requestDisallowInterceptTouchEvent(false);
    L11:
        return false;
    L10:
        this.a.getParent().requestDisallowInterceptTouchEvent(true);
        goto L11
    L5:
        if (r3.getAction() != 1) goto L7;
        r4 = true;
        goto L8
    }
}
