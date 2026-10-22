package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Consumer {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r2) {
        ImportResult.Detail r3 = (ImportResult.Detail) r2;
        tt5.a.h("ImImportFileModel", "checkImportResult");
    }
}
