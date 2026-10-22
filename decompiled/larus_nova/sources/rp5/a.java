package rp5;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.bytedance.ee.bear.widgets.wheelview.view.WheelView;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f538850a;

    public a(WheelView r100) {
        this.f538850a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r110, float r111) {
        WheelView r102 = this.f538850a;
        r102.a();
        r102.f240435j = r102.f240434i.scheduleWithFixedDelay(new sp5.a(r102, r111), 0, 5, TimeUnit.MILLISECONDS);
        return true;
    }
}
