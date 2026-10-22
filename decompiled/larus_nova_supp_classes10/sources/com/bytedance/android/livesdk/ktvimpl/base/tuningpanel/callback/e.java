package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ j a;

    public e(j r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Boolean r2 = (Boolean) r1;
        this.a.d();
    }
}
