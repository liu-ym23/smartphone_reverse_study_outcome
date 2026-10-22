package com.bytedance.locallife.poi.poidetail.container.plugin.perf;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.locallife.dito.core.BaseDitoView;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class q {
    public static final List a(BaseDitoView r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        ArrayList r101 = new ArrayList();
        b(r101, r100, 0, CollectionsKt.emptyList());
        return r101;
    }

    public static final void b(List<r> r110, View r111, int r112, List<Integer> r113) {
        if ((r111 instanceof ViewGroup) == true) goto L5;
        return;
    L5:
        ViewGroup r100 = (ViewGroup) r111;
        int r101 = r100.getChildCount();
        int r102 = 0;
        boolean r103 = false;
    L6:
        if (r102 >= r101) goto L11;
        View r104 = r100.getChildAt(r102);
        if ((r104 instanceof ViewGroup) == false) goto L10;
        List r105 = CollectionsKt.plus(r113, Integer.valueOf(r102));
        b(r110, r104, r112 + 1, r105);
        r103 = true;
    L10:
        r102 = r102 + 1;
        goto L6
    L11:
        if (r103 == true) goto L17;
        ArrayList r114 = (ArrayList) r110;
        r114.add(new r(r112, r113, r100.getChildCount(), r100.getId(), r111.getClass().getName()));
        return;
    }
}
