package zv4;

import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public interface d {
    void a(int r100, int r101, boolean r102, boolean r103);

    void b(c r100);

    View[] c();

    void d();

    void onAttachedToWindow();

    void onDetachedFromWindow();

    boolean onTouchEvent(MotionEvent r100);

    ActionMode.Callback prepareActionMode(ActionMode.Callback r100);
}
