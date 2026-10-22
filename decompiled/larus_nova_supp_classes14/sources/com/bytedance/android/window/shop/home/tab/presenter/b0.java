package com.bytedance.android.window.shop.home.tab.presenter;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.window.shop.widget.ECShopRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ String b;
    public final /* synthetic */ JSONObject c;

    public b0(RecyclerView r1, JSONObject r2) {
        this.a = r1;
        this.b = "ecom.window.card_state_transform";
        this.c = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<T> r0 = c0.e((ECShopRecyclerView) this.a).iterator();     // Catch: Throwable -> L7
    L4:
        if (r0.hasNext() == false) goto L16;
        ((ECLynxCard) r0.next()).o(this.b, this.c);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
