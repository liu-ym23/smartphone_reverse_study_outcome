package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements nc5.b {
    public final /* synthetic */ e<Result<?>> a;
    public final /* synthetic */ Ref.ObjectRef<Disposable> b;

    @Override // nc5.b
    public final void cancel() {
        tt5.a.h(this.a.n(), "cancel: " + this.b.element);
        Disposable r0 = (Disposable) this.b.element;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = (Disposable) this.b.element;
        if (r1 == null) goto L9;
        this.a.a.remove(r1);
        return;
    }

    public d(e<Result<?>> r1, Ref.ObjectRef<Disposable> r2) {
        this.a = r1;
        this.b = r2;
    }
}
