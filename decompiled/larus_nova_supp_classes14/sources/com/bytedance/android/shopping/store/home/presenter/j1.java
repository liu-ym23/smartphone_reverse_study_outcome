package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j1<T> implements Observer {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;

    public j1(View r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r5) {
        Integer r6 = (Integer) r5;
        dm.a.a("paomadeng").a("marqueeOffset:" + r6);
        wg.a.f(this.a, com.bytedance.android.shopping.extensions.b.b(8), RangesKt.coerceAtLeast(r6.intValue(), this.b + com.bytedance.android.shopping.extensions.b.b(44)), 0, 0);
    }
}
