package rp5;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.bytedance.ee.bear.widgets.wheelview.view.WheelView;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {
    public final WheelView a;

    public a(WheelView r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r8, MotionEvent r9, float r10, float r11) {
        WheelView r12 = this.a;
        r12.a();
        r12.j = r12.i.scheduleWithFixedDelay(new sp5.a(r12, r11), 0, 5, TimeUnit.MILLISECONDS);
        return true;
    }
}
