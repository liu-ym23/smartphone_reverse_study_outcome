package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f223048a = null;

    static {
        f223048a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ImportResult.Detail r101 = (ImportResult.Detail) r100;
        tt5.a.h("ImImportFileModel", "checkImportResult");
    }
}
