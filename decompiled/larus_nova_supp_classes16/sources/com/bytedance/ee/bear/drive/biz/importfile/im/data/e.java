package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import com.bytedance.ee.bear.drive.biz.importfile.im.entity.CreateResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T> implements Consumer {
    public static final e<T> a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r2) {
        CreateResult r3 = (CreateResult) r2;
        tt5.a.h("ImImportFileModel", "createImportTask done");
    }
}
