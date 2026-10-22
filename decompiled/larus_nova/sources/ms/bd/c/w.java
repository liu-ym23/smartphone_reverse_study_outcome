package ms.bd.c;

import android.view.MotionEvent;
import android.view.Window;
import androidx.appcompat.view.WindowCallbackWrapper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class w extends WindowCallbackWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f515411a;

    public w(Window.Callback r100) {
        super(r100);
    }

    @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        int r101 = this.f515411a;
        this.f515411a = r101 + 1;
        if ((r101 % 4) != 0) goto L9;
        s0 r102 = new s0(r100.getDeviceId(), (int) r100.getX(), (int) r100.getY());
        ArrayList r103 = s2.f515364c;
        if (r103.size() != 300) goto L7;
        ListProtector.remove(r103, 299);
    L7:
        ListProtector.add(r103, 0, r102);
    L9:
        return super.dispatchTouchEvent(r100);
    }
}
