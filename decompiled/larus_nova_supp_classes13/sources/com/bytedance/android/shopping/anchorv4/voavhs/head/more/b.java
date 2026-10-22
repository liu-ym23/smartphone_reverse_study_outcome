package com.bytedance.android.shopping.anchorv4.voavhs.head.more;

import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.android.ec.core.utils.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<T> implements y.c {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;

    public b(View r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        this.a.post(new a(this, (Bitmap) r3));
    }
}
