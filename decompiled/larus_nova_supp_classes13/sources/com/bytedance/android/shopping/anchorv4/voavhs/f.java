package com.bytedance.android.shopping.anchorv4.voavhs;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements com.bytedance.android.ecom.arch.slice.f {
    public final RecyclerView a;
    public final com.bytedance.android.ecom.arch.slice.slices.b<List<com.bytedance.android.ecom.arch.slice.g>> b;

    public final RecyclerView.LayoutParams a(boolean r5) {
        if (this.a.getLayoutManager() == null) goto L5;
        boolean r0 = true;
    L6:
        nq.a.e(r0, RecyclerViewDelegate$createSliceLayoutParam$1.INSTANCE, 2);
        RecyclerView.LayoutManager r1 = this.a.getLayoutManager();
        if (r1 == null) goto L11;
        RecyclerView.LayoutParams r2 = r1.generateDefaultLayoutParams();
        if (r2 == null) goto L11;
        ((ViewGroup.MarginLayoutParams) r2).width = -1;
        ((ViewGroup.MarginLayoutParams) r2).height = -2;
    L12:
        if (r5 == true) goto L14;
    L16:
        return r2;
    L14:
        if ((r2 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L16;
        ((StaggeredGridLayoutManager.LayoutParams) r2).setFullSpan(true);
    L11:
        r2 = null;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    public f(RecyclerView r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "provider");
        this.a = r2;
        this.b = r3;
    }
}
