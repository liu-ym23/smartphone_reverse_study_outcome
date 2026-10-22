package com.larus.home.impl.main.side_bar.feed.arch;

import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<RecyclerView, String> f344618a = null;

    static {
        f344618a = new WeakHashMap();
    }

    public static final void a(final RecyclerView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "reason");
        if (r100.isComputingLayout() == false) goto L8;
        WeakHashMap<RecyclerView, String> r102 = f344618a;
        boolean r103 = !r102.containsKey(r100);
        r102.put(r100, r101);
        if (r103 == false) goto L22;
        r100.postOnAnimation(new i(r100));
        return;
    L22:
        return;
    L8:
        f344618a.remove(r100);
        RecyclerView.Adapter r104 = r100.getAdapter();
        if (r104 != null) goto L11;
        return;
    L11:
        r100.stopScroll();
        RecyclerView.LayoutManager r105 = r100.getLayoutManager();
        if (r105 == null) goto L14;
        Parcelable r106 = r105.onSaveInstanceState();
    L15:
        r100.setAdapter(r104);
        r100.getRecycledViewPool().clear();
        if (r106 == null) goto L20;
        RecyclerView.LayoutManager r107 = r100.getLayoutManager();
        if (r107 == null) goto L20;
        r107.onRestoreInstanceState(r106);
    L20:
        int r108 = t.f344637a;
        t.c("root_structure_reset", "rv=" + t.e(r100) + " root=" + t.e(r104) + " reason=" + r101);
        return;
    L14:
        r106 = null;
        goto L15
    }
}
