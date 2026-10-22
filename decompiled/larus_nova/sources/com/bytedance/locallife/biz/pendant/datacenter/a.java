package com.bytedance.locallife.biz.pendant.datacenter;

import bo6.f;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes21.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PendantViewModel f256790a;

    public a(PendantViewModel r100) {
        this.f256790a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        f r101 = (f) r100;
        if (r101 == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L11;
        PendantViewModel r103 = this.f256790a;
        r103.f256789h = r101;
        c r104 = r103.f256782a;
        if (r104 == null) goto L12;
        r104.b(r101);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
