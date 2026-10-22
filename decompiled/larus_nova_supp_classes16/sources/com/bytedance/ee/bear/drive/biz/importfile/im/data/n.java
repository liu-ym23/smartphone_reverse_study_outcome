package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ a a;

    public n(a r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        a r0 = this.a;
        r0.e.j(r0.d, "check_import_result");
        tt5.a.d("ImImportFileModel", "error - " + ((Throwable) r4));
    }
}
