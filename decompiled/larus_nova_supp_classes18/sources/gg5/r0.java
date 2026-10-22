package gg5;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r0 extends LinearLayoutManager {
    public final /* synthetic */ i0 a;

    public r0(i0 r1, Context r2) {
        this.a = r1;
        super(r2);
    }

    public final void onItemsAdded(RecyclerView r3, int r4, int r5) {
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onItemsAdded(r3, r4, r5);
        r3.postDelayed(new q0(this), 500);
    }
}
