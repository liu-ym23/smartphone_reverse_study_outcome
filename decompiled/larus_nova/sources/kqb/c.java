package kqb;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final void a(ListView r100) {
        Intrinsics.checkNotNullParameter(r100, "listView");
        ListAdapter r101 = r100.getAdapter();
        if (r101 != null) goto L5;
        return;
    L5:
        Iterator<Integer> r102 = RangesKt.until(0, r101.getCount()).iterator();
        int r103 = 0;
    L7:
        if (r102.hasNext() == false) goto L9;
        View r104 = r101.getView(((IntIterator) r102).nextInt(), null, r100);
        r104.measure(0, 0);
        r103 = r103 + r104.getMeasuredHeight();
        goto L7
    L9:
        int r105 = r101.getCount();
        ViewGroup.LayoutParams r106 = r100.getLayoutParams();
        r106.height = r103 + (r100.getDividerHeight() * r105);
        r100.setLayoutParams(r106);
    }
}
