package com.bytedance.ee.bear.imageviewer;

import android.net.Uri;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class w1 implements Consumer {
    public final /* synthetic */ c3.f a;

    public /* synthetic */ w1(c3.f r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.onSuccess((Uri) r2);
    }
}
