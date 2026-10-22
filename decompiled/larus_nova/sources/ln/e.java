package ln;

import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
public final class e {
    public static final boolean a(View r100, Rect r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$isVisibleInArea");
        Intrinsics.checkNotNullParameter(r101, "recyclerViewRectCache");
        float r103 = RangesKt.coerceIn(r102, 0.0f, 1.0f);
        Rect r104 = new Rect();
        r100.getGlobalVisibleRect(r104);
        if (r104.intersect(r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (((RangesKt.coerceAtMost(r104.bottom, r101.bottom) - RangesKt.coerceAtLeast(r104.top, r101.top)) / RangesKt.coerceAtMost(r100.getHeight(), r101.height())) < r103) goto L7;
        return true;
    }
}
