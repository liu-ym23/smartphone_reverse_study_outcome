package com.bytedance.android.shopping.store.search.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ zm.b a;

    public h(zm.b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        zm.b r0 = this.a;
        r0.setData((List) r2);
    }
}
