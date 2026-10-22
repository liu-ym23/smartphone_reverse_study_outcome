package com.bytedance.android.window.shop.search.presenter;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;
import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.bytedance.android.ec.window.base.status.WindowSearchProductLoadingStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s<T> implements Observer {
    public final /* synthetic */ t a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ WindowLazyStatusView c;
    public final /* synthetic */ Context d;

    public s(t r1, ViewGroup r2, WindowLazyStatusView r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void onChanged(Object r4) {
        WindowLoadStatus r5 = (WindowLoadStatus) r4;
        this.b.setVisibility(0);
        if (this.a.g == false) goto L6;
        WindowLazyStatusView r0 = this.c;
        Map r1 = new WindowSearchProductLoadingStatusView(this.d).a();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "viewCreators");
        r0.removeAllViews();
        ((LinkedHashMap) r0.b).clear();
        r0.a.putAll(r1);
    L6:
        if (r5 == null) goto L16;
        int r6 = q.a[r5.ordinal()];
        if (r6 != 1) goto L11;
        this.c.b(com.bytedance.android.ec.window.base.status.c.d.a);
    L21:
        this.a.g = true;
        return;
    L11:
        if (r6 != 2) goto L13;
        this.b.setVisibility(8);
        goto L21
    L13:
        if (r6 != 3) goto L15;
        this.c.b(com.bytedance.android.ec.window.base.status.c.c.a);
        goto L21
    L15:
        if (r6 != 4) goto L16;
        this.c.b(com.bytedance.android.ec.window.base.status.c.b.a);
    L16:
        this.b.setVisibility(8);
        goto L21
    }
}
