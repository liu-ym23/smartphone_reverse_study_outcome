package com.bytedance.live.datacontext;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes19.dex */
public final class v implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f255100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f255101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DataContext f255102c;

    public v(u r100, Object r101, DataContext r102) {
        this.f255100a = r100;
        this.f255101b = r101;
        this.f255102c = r102;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        u r100 = this.f255100a;
        Object r101 = this.f255101b;
        DataContext r102 = this.f255102c;
        monitor-enter(r100);
        u.a r103 = r100.f255097a.get(r101);     // Catch: Throwable -> L16
        if (r103 == null) goto L7;
        DataContext r104 = r103.f255098a;     // Catch: Throwable -> L16
    L8:
        if (r104 != r102) goto L14;
        u.a r105 = r100.f255097a.remove(r101);     // Catch: Throwable -> L16
        if (r105 == null) goto L14;
        Disposable r106 = r105.f255099b;     // Catch: Throwable -> L16
        if (r106 == null) goto L14;
        r106.dispose();     // Catch: Throwable -> L16
    L14:
        monitor-exit(r100);
        return;
    L7:
        r104 = null;
    L16:
        th = move-exception;
        throw th;
    }
}
