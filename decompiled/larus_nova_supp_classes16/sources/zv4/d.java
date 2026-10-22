package zv4;

import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface d {
    void a(int r1, int r2, boolean r3, boolean r4);

    void b(c r1);

    View[] c();

    void d();

    void onAttachedToWindow();

    void onDetachedFromWindow();

    boolean onTouchEvent(MotionEvent r1);

    ActionMode.Callback prepareActionMode(ActionMode.Callback r1);
}
