package com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes19.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f252303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f252304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f252305c;

    public l(r r100, long r101, boolean r102) {
        this.f252303a = r100;
        this.f252304b = r101;
        this.f252305c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        r.a(this.f252303a, this.f252304b, false);
        if (this.f252305c == false) goto L5;
        this.f252303a.f252317e.remove(Long.valueOf(this.f252304b));
        return;
    L5:
        this.f252303a.f252317e.add(Long.valueOf(this.f252304b));
    }
}
