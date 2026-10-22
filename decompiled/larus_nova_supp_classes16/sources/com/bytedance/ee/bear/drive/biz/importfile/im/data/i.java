package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ a a;

    public i(a r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        a r0 = this.a;
        r0.e.j(r0.d, "check_import_result");
        a r1 = this.a;
        r1.e.i("success", "DEC0", r1.d);
        tt5.a.h("ImImportFileModel", "loopImportResult done, status=" + ((ImportResult.Detail) r5).getJob_status());
    }
}
