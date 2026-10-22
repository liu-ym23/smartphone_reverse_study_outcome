package com.bytedance.android.shopping.store.search.presenter;

import android.os.SystemClock;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ ShopSearchGroupPresenter a;
    public final /* synthetic */ LinearLayout b;
    public final /* synthetic */ RecyclerView c;

    public a(ShopSearchGroupPresenter r1, LinearLayout r2, RecyclerView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r3) {
        if (com.bytedance.android.shopping.extensions.k.c((String) r3) == false) goto L5;
        ExtensionsKt.gone(this.b);
        return;
    L5:
        this.a.E().setPageDuration(0);
        this.a.E().setMiddlePageStartTime(SystemClock.elapsedRealtime());
        ExtensionsKt.visible(this.b);
        ExtensionsKt.gone(this.c);
    }
}
