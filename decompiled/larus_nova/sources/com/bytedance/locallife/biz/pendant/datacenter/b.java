package com.bytedance.locallife.biz.pendant.datacenter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes21.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PendantViewModel f256791a;

    public b(PendantViewModel r100) {
        this.f256791a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        c r102 = this.f256791a.f256782a;
        if (r102 == null) goto L9;
        String r103 = r101.getMessage();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r102.a(r103);
        return;
    }
}
