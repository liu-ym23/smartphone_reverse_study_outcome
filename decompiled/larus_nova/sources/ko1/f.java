package ko1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f extends ScaleGestureDetector {
    @Override // android.view.ScaleGestureDetector
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return super.onTouchEvent(r100);
    }

    public f(Context r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scaleGestureListener");
        super(r100, r101);
        new ScaleGestureDetector(r100, r101);
    }
}
