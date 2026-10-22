package m04;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.FeedRecyclerListViewModel;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static DampScrollableLayout a;
    public static FeedRecyclerListViewModel b;

    static {
    }

    public static void a(int r8, RecyclerView r9) {
        if (r9 == null) goto L30;
        Intrinsics.checkNotNull(r9);
        RecyclerView.LayoutManager r0 = r9.getLayoutManager();
        Intrinsics.checkNotNull(r0);
        View r1 = r0.findViewByPosition(r8);
        if (r1 == null) goto L16;
        int[] r5 = new int[2];
        r1.getLocationOnScreen(r5);
        Context r6 = r9.getContext();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.app.Activity");
        Activity r7 = (Activity) r6;
        if (r7 == null) goto L9;
        Display r10 = r7.getWindowManager().getDefaultDisplay();
        DisplayMetrics r11 = new DisplayMetrics();
        r10.getRealMetrics(r11);
        int r12 = r11.heightPixels;
    L10:
        int r13 = r12 - r5[1];
        if (r1.getHeight() <= 0) goto L16;
        if (((r13 * 1.0f) / r1.getHeight()) <= 0.4f) goto L16;
        boolean r2 = false;
    L17:
        if (r2 == false) goto L31;
        FeedRecyclerListViewModel r3 = b;
        if (r3 == null) goto L25;
        int r14 = (r3.dataSize() - (r8 + 1)) / 3;
        if (r9.canScrollVertically(1) == true) goto L23;
    L24:
        r3.loadMore();
        goto L25
    L23:
        if (r14 < 5) goto L24;
    L25:
        DampScrollableLayout r4 = a;
        if (r4 == null) goto L28;
        Float r15 = Float.valueOf(1.0f);
        Pair r16 = new Pair(r15, r15);
        Pair r17 = new Pair(r15, Float.valueOf(-3000.0f));
        int r18 = xx3.a.a;
        Intrinsics.checkNotNullParameter(r4, "targetView");
        Intrinsics.checkNotNullParameter(r16, "fromPosition");
        Intrinsics.checkNotNullParameter(r17, "toPosition");
        r4.dispatchTouchEvent(xx3.a.C0187a.a(0, ((Number) r16.getFirst()).floatValue(), ((Number) r16.getSecond()).floatValue()));
        r4.dispatchTouchEvent(xx3.a.C0187a.a(2, ((Number) r17.getFirst()).floatValue(), ((Number) r17.getSecond()).floatValue()));
        r4.dispatchTouchEvent(xx3.a.C0187a.a(1, ((Number) r17.getFirst()).floatValue(), ((Number) r17.getSecond()).floatValue()));
    L28:
        GridLayoutManager r19 = r9.getLayoutManager();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        r19.scrollToPositionWithOffset(r8, 0);
        return;
    L31:
        return;
    L9:
        r12 = d0.c(r7);
    L16:
        r2 = true;
        goto L17
    }
}
