package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Disposable> f227601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e<Result<?>> f227602b;

    public a(Ref.ObjectRef<Disposable> r100, e<Result<?>> r101) {
        this.f227601a = r100;
        this.f227602b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        Disposable r100 = this.f227601a.element;
        if (r100 == null) goto L6;
        this.f227602b.f227916a.remove(r100);
        return;
    }
}
