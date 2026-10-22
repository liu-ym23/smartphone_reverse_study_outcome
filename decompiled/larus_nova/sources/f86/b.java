package f86;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.bytedance.ies.xelement.picker.view.WheelView;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f475883a;

    public b(WheelView r100) {
        this.f475883a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r110, float r111) {
        WheelView r102 = this.f475883a;
        r102.a();
        r102.f250241i = r102.f250240h.scheduleWithFixedDelay(new g86.a(r102, r111), 0, 5, TimeUnit.MILLISECONDS);
        return true;
    }
}
