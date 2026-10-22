package j80;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {
    public static final d a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$pos");
        return new d(r100.getX(), r100.getY());
    }

    public static final e b(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$pos");
        return new e(r100.left, r100.top);
    }

    public static final d c(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$rawPos");
        return new d(r100.getRawX(), r100.getRawY());
    }

    public static final void d(Rect r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$pos");
        Intrinsics.checkNotNullParameter(r101, "value");
        r100.offsetTo(r101.a().intValue(), r101.b().intValue());
    }

    public static final void e(View r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$pos");
        Intrinsics.checkNotNullParameter(r101, "value");
        r100.setX(r101.a().floatValue());
        r100.setY(r101.b().floatValue());
    }
}
