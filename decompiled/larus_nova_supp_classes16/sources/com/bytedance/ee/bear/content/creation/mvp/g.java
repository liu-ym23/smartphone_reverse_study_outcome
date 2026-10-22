package com.bytedance.ee.bear.content.creation.mvp;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ h b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.a.getChildCount() <= 0) goto L7;
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        SelectCreationMenuViewModel r0 = this.b.n;
        if (r0 == null) goto L7;
        r0.setSelectCreationMenuState(1);
    L7:
        return true;
    }

    public g(h r1, RecyclerView r2) {
        this.b = r1;
        this.a = r2;
    }
}
