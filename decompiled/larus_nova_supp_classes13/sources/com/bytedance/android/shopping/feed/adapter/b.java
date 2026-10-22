package com.bytedance.android.shopping.feed.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public RecyclerView a;
    public ProductFeedViewModel b;
    public boolean c;
    public final IgnorePosPagerSnapHelper d;
    public boolean e;
    public boolean f;
    public boolean g;

    public b() {
        this.c = true;
        this.d = new IgnorePosPagerSnapHelper();
    }

    public final void a(int r3) {
        IgnorePosPagerSnapHelper r0 = this.d;
        ((ArrayList) r0.a).clear();
        List<Integer> r1 = r0.a;
        ArrayList r2 = (ArrayList) r1;
        r2.add(Integer.valueOf(r3));
    }
}
