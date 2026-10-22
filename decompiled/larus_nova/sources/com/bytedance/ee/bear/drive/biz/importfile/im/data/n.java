package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f223060a;

    public n(a r100) {
        this.f223060a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        a r101 = this.f223060a;
        r101.f223046e.j(r101.f223045d, "check_import_result");
        tt5.a.d("ImImportFileModel", "error - " + ((Throwable) r100));
    }
}
