package k86;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.bytedance.ies.xelement.pickview.view.WheelView;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f502095a;

    public a(WheelView r100) {
        this.f502095a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r110, float r111) {
        WheelView r102 = this.f502095a;
        r102.a();
        r102.f250319i = r102.f250318h.scheduleWithFixedDelay(new l86.a(r102, r111), 0, 5, TimeUnit.MILLISECONDS);
        return true;
    }
}
