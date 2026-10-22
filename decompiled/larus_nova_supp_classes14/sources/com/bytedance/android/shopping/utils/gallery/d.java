package com.bytedance.android.shopping.utils.gallery;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements Runnable {
    public final /* synthetic */ e a;

    public d(e r1) {
        this.a = r1;
    }

    public final void a() {
        this.a.getClass();
        e r0 = this.a;
        int r1 = r0.f;
        int r2 = ((r0.g + r1) * 0) + (r1 / 2);
        r0.e += r2;
        RecyclerView r3 = r0.b;
        if (r3 == null) goto L5;
        r3.scrollBy(r2, 0);
    L5:
        RecyclerView r4 = this.a.b;
        RecyclerView.Adapter r5 = null;
        if (r4 == null) goto L8;
        RecyclerView.Adapter r6 = r4.getAdapter();
    L10:
        if ((r6 instanceof BannerAdapter) == false) goto L13;
        r5 = r6;
    L13:
        BannerAdapter r7 = (BannerAdapter) r5;
        if (r7 == null) goto L16;
        r7.y2(this.a.e);
    L16:
        RecyclerView r8 = this.a.b;
        if (r8 == null) goto L19;
        r8.setVisibility(0);
    L19:
        View r9 = this.a.c;
        if (r9 == null) goto L23;
        r9.setVisibility(0);
        return;
    L23:
        return;
    L8:
        r6 = null;
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
