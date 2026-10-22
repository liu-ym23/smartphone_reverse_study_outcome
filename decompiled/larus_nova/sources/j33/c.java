package j33;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor;

/* JADX INFO: loaded from: classes12.dex */
public interface c {
    void a(SlcKeyboardMonitor.c r100);

    View b(View r100, String r101);

    void c(com.bytedance.android.shopping.skubuy.platform.module.a.C2723a r100);

    void clearFocus(boolean r100);

    void dispatchTouchEvent(MotionEvent r100);
}
