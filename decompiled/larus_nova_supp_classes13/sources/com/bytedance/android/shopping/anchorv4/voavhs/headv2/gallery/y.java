package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import androidx.lifecycle.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class y<T> implements Observer {
    public final /* synthetic */ t a;

    public y(t r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        t r0 = this.a;
        t.c(r0, (List) r2);
    }
}
