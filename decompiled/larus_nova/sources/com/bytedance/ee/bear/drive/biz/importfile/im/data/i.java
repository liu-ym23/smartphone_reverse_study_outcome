package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f223055a;

    public i(a r100) {
        this.f223055a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        a r101 = this.f223055a;
        r101.f223046e.j(r101.f223045d, "check_import_result");
        a r102 = this.f223055a;
        r102.f223046e.i("success", "DEC0", r102.f223045d);
        tt5.a.h("ImImportFileModel", "loopImportResult done, status=" + ((ImportResult.Detail) r100).getJob_status());
    }
}
