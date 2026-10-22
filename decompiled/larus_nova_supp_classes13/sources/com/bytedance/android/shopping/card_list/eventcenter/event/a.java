package com.bytedance.android.shopping.card_list.eventcenter.event;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ RecyclerView a;

    public a(RecyclerView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewExtensionsKt.d(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
