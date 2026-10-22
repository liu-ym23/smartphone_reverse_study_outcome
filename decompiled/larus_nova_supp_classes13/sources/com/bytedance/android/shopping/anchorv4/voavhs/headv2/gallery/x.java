package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class x<T> implements Observer {
    public final /* synthetic */ t a;

    public x(t r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (((Integer) r2).intValue() < 0) goto L9;
        t r3 = this.a;
        List r0 = (List) r3.d.f.getThumbList().getValue();
        if (r0 != null) goto L7;
        r0 = CollectionsKt.emptyList();
    L7:
        t.c(r3, r0);
        return;
    }
}
