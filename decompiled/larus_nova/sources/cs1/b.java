package cs1;

import android.view.MotionEvent;
import com.bytedance.android.livesdk.tetris.e;

/* JADX INFO: loaded from: classes8.dex */
public interface b {

    public interface a {
        void c(MotionEvent r100);
    }

    void a(e r100);

    void b(e r100);

    MotionEvent c();

    boolean d(MotionEvent r100);

    float getViewTouchSlop();
}
