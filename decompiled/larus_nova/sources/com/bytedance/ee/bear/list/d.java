package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements nc5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e<Result<?>> f227806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Disposable> f227807b;

    @Override // nc5.b
    public final void cancel() {
        tt5.a.h(this.f227806a.n(), "cancel: " + this.f227807b.element);
        Disposable r100 = this.f227807b.element;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.f227807b.element;
        if (r101 == null) goto L9;
        this.f227806a.f227916a.remove(r101);
        return;
    }

    public d(e<Result<?>> r100, Ref.ObjectRef<Disposable> r101) {
        this.f227806a = r100;
        this.f227807b = r101;
    }
}
