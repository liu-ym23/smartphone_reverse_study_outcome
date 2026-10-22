package com.bytedance.android.shopping.commentv3.uitree.p000float;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import lc3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        b r3 = (b) r2;
        this.a.e(new FloatWindowLogic$observeStat$1$1(this));
    }
}
