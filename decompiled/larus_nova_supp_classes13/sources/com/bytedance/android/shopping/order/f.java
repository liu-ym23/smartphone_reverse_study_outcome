package com.bytedance.android.shopping.order;

import android.content.Context;
import android.os.Handler;
import cg3.k;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ Context a;
    public final /* synthetic */ cg3.f b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Function2 f;

    public f(Context r1, cg3.f r2, String r3, String r4, Function2 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = null;
        this.f = r5;
    }

    public final void accept(Object r10) {
        Handler r0 = PublishUtil.a;
        PublishUtil.e(this.a, new k(((cg3.c) r10).a, this.b, this.c, this.d, this.e, this.f), true);
    }
}
