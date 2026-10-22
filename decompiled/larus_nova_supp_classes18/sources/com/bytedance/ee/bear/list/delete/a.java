package com.bytedance.ee.bear.list.delete;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements nc5.b {
    public final /* synthetic */ DeleteExecutor a;
    public final /* synthetic */ Disposable b;
    public final /* synthetic */ io.reactivex.disposables.a c;

    @Override // nc5.b
    public final void cancel() {
        tt5.a.h(this.a.b, " cancel");
        this.b.dispose();
        this.c.dispose();
    }

    public a(DeleteExecutor r1, Disposable r2, io.reactivex.disposables.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
