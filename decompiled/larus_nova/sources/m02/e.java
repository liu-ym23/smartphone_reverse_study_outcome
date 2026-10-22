package m02;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class e {
    public static final int a(LinearLayoutManager r100, RecyclerView r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$findFirstVisibleItem");
        Intrinsics.checkNotNullParameter(r101, "rvPercentage");
        return b(r100, r101, r102, new IntRange(r100.findFirstVisibleItemPosition(), r100.findLastVisibleItemPosition()), r103);
    }

    public static final int c(LinearLayoutManager r100, RecyclerView r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$findLastVisibleItem");
        Intrinsics.checkNotNullParameter(r101, "rvPercentage");
        int r104 = r100.findFirstVisibleItemPosition();
        return b(r100, r101, r102, RangesKt.downTo(r100.findLastVisibleItemPosition(), r104), r103);
    }

    public static final int b(LinearLayoutManager r100, RecyclerView r101, int r102, IntProgression r103, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "layoutManager");
        Intrinsics.checkNotNullParameter(r101, "rvPercentage");
        Intrinsics.checkNotNullParameter(r103, FilterData.FilterOptionItem.Type.RANGE);
        Rect r104 = new Rect();
        r101.getGlobalVisibleRect(r104);
        Iterator<Integer> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L21;
        int r106 = r105.next().intValue();
        Rect r107 = new Rect();
        View r108 = r100.findViewByPosition(r106);
        if (r108 == null) goto L4;
        r108.getGlobalVisibleRect(r107);
        int r109 = 100;
        if (r110 == false) goto L12;
        if (r107.height() < ((r108.getHeight() * r102) / 100)) goto L4;
    L12:
        int r111 = r107.bottom;
        int r112 = r104.bottom;
        if (r111 < r112) goto L15;
        int r113 = ((r112 - r107.top) * 100) / r108.getHeight();
    L16:
        if (r113 > 100) goto L19;
        r109 = r113;
    L19:
        if (r109 <= r102) goto L4;
        return r106;
    L15:
        r113 = ((r111 - r104.top) * 100) / r108.getHeight();
        goto L16
    L21:
        return -1;
    }
}
