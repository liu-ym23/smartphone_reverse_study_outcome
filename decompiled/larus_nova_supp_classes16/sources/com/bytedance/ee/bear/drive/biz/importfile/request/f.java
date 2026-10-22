package com.bytedance.ee.bear.drive.biz.importfile.request;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.biz.importfile.request.error.ImportFailedType;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ StartImportRequesterManagerImplV2 a;

    public f(StartImportRequesterManagerImplV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        StartImportRequesterManagerImplV2 r0 = this.a;
        r0.d.j(r0.f.a, "check_import_result");
        tt5.a.h("StartImportRequesterManagerImplV2", "checkImportResult throwable = " + r5);
        if ((r5 instanceof NetService.ServerErrorException) == true) goto L5;
        ImportFailedType r6 = ImportFailedType.FailedCanRetry;
    L11:
        ((k55.h) this.a.i).j(r6, -1);
        return;
    L5:
        if (com.bytedance.ee.bear.middleground.permission.b.c() == true) goto L7;
    L9:
        r6 = m55.a.a(((NetService.ServerErrorException) r5).getCode());
        Intrinsics.checkNotNull(r6);
        goto L11
    L7:
        if (m55.a.b(((NetService.ServerErrorException) r5).getCode()) == false) goto L9;
        r6 = ImportFailedType.FailedImportDriveFileEncrypted;
        goto L11
    }
}
