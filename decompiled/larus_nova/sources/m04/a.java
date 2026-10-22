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

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DampScrollableLayout f511484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static FeedRecyclerListViewModel f511485b;

    static {
    }

    public static void a(int r100, RecyclerView r101) {
        if (r101 == null) goto L30;
        Intrinsics.checkNotNull(r101);
        RecyclerView.LayoutManager r102 = r101.getLayoutManager();
        Intrinsics.checkNotNull(r102);
        View r103 = r102.findViewByPosition(r100);
        if (r103 == null) goto L16;
        int[] r104 = new int[2];
        r103.getLocationOnScreen(r104);
        Context r105 = r101.getContext();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.app.Activity");
        Activity r106 = (Activity) r105;
        if (r106 == null) goto L9;
        Display r107 = r106.getWindowManager().getDefaultDisplay();
        DisplayMetrics r108 = new DisplayMetrics();
        r107.getRealMetrics(r108);
        int r109 = r108.heightPixels;
    L10:
        int r110 = r109 - r104[1];
        if (r103.getHeight() <= 0) goto L16;
        if (((r110 * 1.0f) / r103.getHeight()) <= 0.4f) goto L16;
        boolean r111 = false;
    L17:
        if (r111 == false) goto L31;
        FeedRecyclerListViewModel r112 = f511485b;
        if (r112 == null) goto L25;
        int r113 = (r112.dataSize() - (r100 + 1)) / 3;
        if (r101.canScrollVertically(1) == true) goto L23;
    L24:
        r112.loadMore();
        goto L25
    L23:
        if (r113 < 5) goto L24;
    L25:
        DampScrollableLayout r114 = f511484a;
        if (r114 == null) goto L28;
        Float r115 = Float.valueOf(1.0f);
        Pair r116 = new Pair(r115, r115);
        Pair r117 = new Pair(r115, Float.valueOf(-3000.0f));
        int r118 = xx3.a.f565326a;
        Intrinsics.checkNotNullParameter(r114, "targetView");
        Intrinsics.checkNotNullParameter(r116, "fromPosition");
        Intrinsics.checkNotNullParameter(r117, "toPosition");
        r114.dispatchTouchEvent(xx3.a.C8282a.a(0, ((Number) r116.getFirst()).floatValue(), ((Number) r116.getSecond()).floatValue()));
        r114.dispatchTouchEvent(xx3.a.C8282a.a(2, ((Number) r117.getFirst()).floatValue(), ((Number) r117.getSecond()).floatValue()));
        r114.dispatchTouchEvent(xx3.a.C8282a.a(1, ((Number) r117.getFirst()).floatValue(), ((Number) r117.getSecond()).floatValue()));
    L28:
        RecyclerView.LayoutManager r119 = r101.getLayoutManager();
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        ((GridLayoutManager) r119).scrollToPositionWithOffset(r100, 0);
        return;
    L31:
        return;
    L9:
        r109 = d0.c(r106);
    L16:
        r111 = true;
        goto L17
    }
}
