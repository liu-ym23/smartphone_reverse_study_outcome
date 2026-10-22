package com.bytedance.android.window.shop.home.tab.presenter;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a0 implements Runnable {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ String b;
    public final /* synthetic */ JSONObject c;

    public a0(RecyclerView r1, JSONObject r2) {
        this.a = r1;
        this.b = "ecom.window.card_state_transform";
        this.c = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<T> r0 = c0.d(this.a).iterator();     // Catch: Throwable -> L9
    L4:
        if (r0.hasNext() == false) goto L21;
        ECWindowLynxMonitorHolder r1 = (ECWindowLynxMonitorHolder) r0.next();     // Catch: Throwable -> L9
        String r2 = this.b;     // Catch: Throwable -> L9
        JSONObject r3 = this.c;     // Catch: Throwable -> L9
        r1.getClass();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r2, "eventName");     // Catch: Throwable -> L9
        ECLynxCard r4 = ((ECLynxCardHolder) r1).t;     // Catch: Throwable -> L9
        if (r4 == null) goto L4;
        r4.o(r2, r3);     // Catch: Throwable -> L9
        goto L4
    L21:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }
}
