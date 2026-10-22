package com.bytedance.android.shopping.store.router.hybridpage.view;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ View b;

    public d(b r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ECHybridListEngine r4 = this.a.I3;
        if (r4 == null) goto L16;
        ECHybridRecyclerView r5 = r4.b;
        if (r5 == null) goto L17;
        r5.stopScroll();
        LinearLayoutManager r0 = r5.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        r0.scrollToPositionWithOffset(0, -1);
    L14:
        this.b.setVisibility(8);
        return;
    L13:
        r5.scrollToPosition(0);
        goto L14
    L17:
        return;
    }
}
