package com.bytedance.ee.bear.list.move;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f228870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f228871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f228872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f228873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ io.reactivex.disposables.a f228874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ nc5.a<Boolean> f228875f;

    public i(f r100, String r101, String r102, int r103, io.reactivex.disposables.a r104, nc5.a<Boolean> r105) {
        this.f228870a = r100;
        this.f228871b = r101;
        this.f228872c = r102;
        this.f228873d = r103;
        this.f228874e = r104;
        this.f228875f = r105;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.e(this.f228870a.f228853b, "move unified poll error, taskId=" + this.f228871b + ", taskType=" + this.f228872c + ", times=" + this.f228873d, r101, false);
        this.f228874e.dispose();
        nc5.a<Boolean> r102 = this.f228875f;
        Intrinsics.checkNotNull(r101);
        r102.onFailure(r101);
    }
}
