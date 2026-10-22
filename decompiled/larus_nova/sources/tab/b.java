package tab;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f545221a;

    public b(WheelView r100) {
        this.f545221a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r110, float r111) {
        WheelView r102 = this.f545221a;
        r102.a();
        r102.I = r102.f420363d.scheduleWithFixedDelay(new sab.a(r102, r111), 0, 5, TimeUnit.MILLISECONDS);
        return true;
    }
}
