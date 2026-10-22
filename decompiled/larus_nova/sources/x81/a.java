package x81;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.room.incentiveinfo.IncentiveInfoLayout;
import com.bytedance.android.live.room.view.InterceptFrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u81.d;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    public static final IncentiveInfoLayout.LayoutParams a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$incentiveLp");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof IncentiveInfoLayout.LayoutParams) == true) goto L6;
        r101 = null;
    L6:
        return (IncentiveInfoLayout.LayoutParams) r101;
    }

    public static final InterceptFrameLayout b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$interceptFrameLayout");
        if ((r100 instanceof InterceptFrameLayout) == true) goto L6;
        r100 = null;
    L6:
        return (InterceptFrameLayout) r100;
    }

    public static final w81.a c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$itemData");
        IncentiveInfoLayout.LayoutParams r101 = a(r100.a());
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.f99616b;
    L7:
        if ((r103 instanceof w81.a) == false) goto L11;
        r102 = r103;
    L11:
        return (w81.a) r102;
    L5:
        r103 = null;
        goto L7
    }

    public static final <T> T d(List<? extends T> r100, int r101) {
        if (r100 == null) goto L9;
        if (r101 >= 0) goto L6;
        return null;
    L6:
        if (r101 < r100.size()) goto L8;
        return null;
    L8:
        return (T) ListProtector.get(r100, r101);
    L9:
        return null;
    }
}
