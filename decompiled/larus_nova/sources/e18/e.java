package e18;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f470711a;

    public e(WheelView r100) {
        Intrinsics.checkNotNullParameter(r100, "loopView");
        this.f470711a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        if (r100 != null) goto L6;
        return false;
    L6:
        this.f470711a.scrollBy(r103);
        return true;
    }
}
