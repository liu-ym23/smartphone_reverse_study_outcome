package com.larus.home.impl.main.side_bar.feed.arch;

import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g {
    /* JADX WARN: Multi-variable type inference failed */
    public static final int a(RecyclerView.Adapter<?> r100, int r101, Function1<? super RecyclerView.Adapter<?>, Integer> r102) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r102, "localPositionResolver");
        int r103 = r102.invoke(r100).intValue();
        if (r103 >= 0) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L12;
        return r101 + r103;
    L12:
        if ((r100 instanceof ConcatAdapter) == false) goto L21;
        Iterator<T> r105 = ((ConcatAdapter) r100).getAdapters().iterator();
    L15:
        if (r105.hasNext() == false) goto L31;
        RecyclerView.Adapter r106 = (RecyclerView.Adapter) r105.next();
        Intrinsics.checkNotNull(r106);
        int r107 = a(r106, r101, r102);
        if (r107 != (-1)) goto L18;
        r101 = r101 + r106.getItemCount();
        goto L15
    L18:
        return r107;
    L31:
        return -1;
    L21:
        if ((r100 instanceof h) == true) goto L23;
        return -1;
    L23:
        if (r100.getItemCount() != 0) goto L26;
        return -1;
    L26:
        return a(((h) r100).getWrappedAdapter(), r101, r102);
    L5:
        if (r103 >= r100.getItemCount()) goto L7;
        r104 = true;
        goto L8
    }
}
