package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v<T> implements Observer {
    public final /* synthetic */ t a;

    public v(t r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        this.a.h(true);
    }
}
