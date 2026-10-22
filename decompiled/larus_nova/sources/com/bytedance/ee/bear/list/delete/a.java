package com.bytedance.ee.bear.list.delete;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements nc5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeleteExecutor f227846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Disposable f227847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ io.reactivex.disposables.a f227848c;

    @Override // nc5.b
    public final void cancel() {
        tt5.a.h(this.f227846a.f227814b, " cancel");
        this.f227847b.dispose();
        this.f227848c.dispose();
    }

    public a(DeleteExecutor r100, Disposable r101, io.reactivex.disposables.a r102) {
        this.f227846a = r100;
        this.f227847b = r101;
        this.f227848c = r102;
    }
}
