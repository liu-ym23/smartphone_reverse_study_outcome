package com.bytedance.ee.bear.drive.biz.importfile.request;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import io.reactivex.functions.Predicate;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Predicate<Result<StartImportRequesterManagerImplV2.CheckImportResult>> {
    public int a;
    public final /* synthetic */ int b;

    public c(int r1) {
        this.b = r1;
        this.a = 1;
    }

    public final boolean test(Object r5) {
        Result r6 = (Result) r5;
        Intrinsics.checkNotNullParameter(r6, TipCallBackData.RESULT);
        tt5.a.b("StartImportRequesterManagerImplV2", "takeUtil，status = " + ((StartImportRequesterManagerImplV2.CheckImportResult) r6.data).getJob_status());
        if (((StartImportRequesterManagerImplV2.CheckImportResult) r6.data).getJob_status() != 0) goto L6;
        return true;
    L6:
        if (((StartImportRequesterManagerImplV2.CheckImportResult) r6.data).getJob_status() > 2) goto L14;
        int r7 = this.a;
        if (r7 >= this.b) goto L12;
        this.a = r7 + 3;
        return false;
    L12:
        throw new IOException("polling time out");
    L14:
        throw new NetService.ServerErrorException(((StartImportRequesterManagerImplV2.CheckImportResult) r6.data).getJob_status(), ((StartImportRequesterManagerImplV2.CheckImportResult) r6.data).getJob_error_msg(), ((StartImportRequesterManagerImplV2.CheckImportResult) r6.data).toString(), r6.toString());
    }
}
