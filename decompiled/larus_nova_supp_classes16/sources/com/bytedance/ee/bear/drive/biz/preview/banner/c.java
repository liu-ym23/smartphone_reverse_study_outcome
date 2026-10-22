package com.bytedance.ee.bear.drive.biz.preview.banner;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Integer r3 = (Integer) r2;
        a r0 = this.a;
        Intrinsics.checkNotNull(r3);
        r0.r = r3.intValue();
        this.a.c();
    }
}
