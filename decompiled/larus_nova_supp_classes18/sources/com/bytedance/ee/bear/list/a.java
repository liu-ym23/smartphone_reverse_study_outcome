package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements Action {
    public final /* synthetic */ Ref.ObjectRef<Disposable> a;
    public final /* synthetic */ e<Result<?>> b;

    public a(Ref.ObjectRef<Disposable> r1, e<Result<?>> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        Disposable r0 = (Disposable) this.a.element;
        if (r0 == null) goto L6;
        this.b.a.remove(r0);
        return;
    }
}
