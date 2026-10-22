package com.bytedance.ee.bear.drive.biz.importfile.request;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.drive.biz.importfile.request.error.ImportFailedType;
import com.bytedance.ee.bear.quoto.t;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ StartImportRequesterManagerImplV2 a;

    public i(StartImportRequesterManagerImplV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        Throwable r9 = (Throwable) r8;
        StartImportRequesterManagerImplV2 r0 = this.a;
        r0.d.j(r0.f.a, "start_import_file");
        tt5.a.h("StartImportRequesterManagerImplV2", "startImport throwable = " + r9);
        if ((r9 instanceof NetService.ServerErrorException) == false) goto L33;
        t r1 = (t) org.koin.java.a.c(t.class, null, null, 6);
        NetService.ServerErrorException r3 = (NetService.ServerErrorException) r9;
        int r4 = r3.getCode();
        if (r4 != 900004230) goto L7;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L19;
        if (r3.getCode() != 900004230) goto L17;
        ImportFailedType r2 = ImportFailedType.FailedMigateDoc;
    L32:
        int r6 = r3.getCode();
    L35:
        if (TextUtils.isEmpty(((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.d.class, null, null, 6)).f("", "CCM_EXPORT", k0.a(r9))) == true) goto L37;
        ((k55.h) this.a.i).j(ImportFailedType.FailedDlpError, k0.a(r9));
        return;
    L37:
        ((k55.h) this.a.i).j(r2, r6);
        return;
    L17:
        r2 = ImportFailedType.FailedMigateBrand;
        goto L32
    L19:
        if (r1.o(r3.getCode()) == false) goto L21;
    L31:
        r2 = ImportFailedType.FailedQuotaLimit;
        goto L32
    L21:
        if (r1.k(r3.getCode()) == true) goto L31;
        if (r1.s(r3.getCode()) == true) goto L31;
        if (com.bytedance.ee.bear.middleground.permission.b.c() == true) goto L28;
    L30:
        r2 = m55.a.a(r3.getCode());
        goto L32
    L28:
        if (m55.a.b(r3.getCode()) == false) goto L30;
        r2 = ImportFailedType.FailedImportDriveFileEncrypted;
        goto L32
    L7:
        if (r4 == 900004511) goto L12;
        if (r4 == 900004510) goto L12;
        r5 = false;
        goto L13
    L33:
        r2 = ImportFailedType.FailedCanRetry;
        r6 = -1;
        goto L35
    }
}
