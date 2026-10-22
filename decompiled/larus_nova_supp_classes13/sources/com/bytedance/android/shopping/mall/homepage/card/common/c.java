package com.bytedance.android.shopping.mall.homepage.card.common;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ ECLynxCardMonitorHolder a;

    public c(ECLynxCardMonitorHolder r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        ECLynxCardMonitorHolder r0 = this.a;
        r0.H0 = ((Float) r2).floatValue();
        this.a.N4(null);
    }
}
