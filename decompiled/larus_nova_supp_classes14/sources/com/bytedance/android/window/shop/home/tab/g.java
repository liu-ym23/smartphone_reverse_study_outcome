package com.bytedance.android.window.shop.home.tab;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public g(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r3) {
        b r4 = (b) r3;
        if (r4 == null) goto L6;
        r4.a(this.a, this.b);
        return;
    }
}
