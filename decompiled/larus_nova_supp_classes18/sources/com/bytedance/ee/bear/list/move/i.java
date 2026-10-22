package com.bytedance.ee.bear.list.move;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ f a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ io.reactivex.disposables.a e;
    public final /* synthetic */ nc5.a<Boolean> f;

    public i(f r1, String r2, String r3, int r4, io.reactivex.disposables.a r5, nc5.a<Boolean> r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.e(this.a.b, "move unified poll error, taskId=" + this.b + ", taskType=" + this.c + ", times=" + this.d, r5, false);
        this.e.dispose();
        nc5.a<Boolean> r0 = this.f;
        Intrinsics.checkNotNull(r5);
        r0.onFailure(r5);
    }
}
