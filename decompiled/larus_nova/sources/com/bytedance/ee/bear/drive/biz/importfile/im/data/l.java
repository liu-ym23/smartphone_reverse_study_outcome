package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f223058a;

    public l(a r100) {
        this.f223058a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        a r102 = this.f223058a;
        r102.f223046e.j(r102.f223045d, "start_import_file");
    }
}
