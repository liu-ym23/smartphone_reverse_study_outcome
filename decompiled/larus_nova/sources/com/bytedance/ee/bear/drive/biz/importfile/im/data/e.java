package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import com.bytedance.ee.bear.drive.biz.importfile.im.entity.CreateResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T> f223050a = null;

    static {
        f223050a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        CreateResult r101 = (CreateResult) r100;
        tt5.a.h("ImImportFileModel", "createImportTask done");
    }
}
