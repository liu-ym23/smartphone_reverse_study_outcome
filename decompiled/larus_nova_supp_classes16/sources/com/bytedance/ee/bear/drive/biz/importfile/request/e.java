package com.bytedance.ee.bear.drive.biz.importfile.request;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ StartImportRequesterManagerImplV2 a;

    public e(StartImportRequesterManagerImplV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Result r6 = (Result) r5;
        StartImportRequesterManagerImplV2 r0 = this.a;
        r0.d.j(r0.f.a, "check_import_result");
        StartImportRequesterManagerImplV2 r1 = this.a;
        r1.d.i("success", "DEC0", r1.f.a);
        tt5.a.h("StartImportRequesterManagerImplV2", "checkImportResult token = " + yu5.c.j(((StartImportRequesterManagerImplV2.CheckImportResult) r6.data).getToken()));
        b.a r2 = this.a.i;
        String r3 = ((StartImportRequesterManagerImplV2.CheckImportResult) r6.data).getType();
        String r4 = ((StartImportRequesterManagerImplV2.CheckImportResult) r6.data).getToken();
        String r7 = ((StartImportRequesterManagerImplV2.CheckImportResult) r6.data).getUrl();
        k55.h r8 = (k55.h) r2;
        if (r8.a != 0) goto L5;
        return;
    L5:
        if (sbb.e.o.getType().equalsIgnoreCase(r3) == true) goto L7;
    L9:
        r7 = p.a().ua(r3, r4, "imported_file_create");
    L10:
        ((o55.b) r8.a).Cm(r7);
        return;
    L7:
        if (TextUtils.isEmpty(r7) == true) goto L9;
        goto L9
    }
}
