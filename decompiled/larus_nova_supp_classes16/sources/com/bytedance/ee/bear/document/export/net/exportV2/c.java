package com.bytedance.ee.bear.document.export.net.exportV2;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Predicate;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Predicate<Result<GetExportResultParserV2.ExportResultV2>> {
    public int a;
    public int b;
    public final /* synthetic */ rw4.a c;
    public final /* synthetic */ int d;

    public final boolean test(Object r5) {
        Result r6 = (Result) r5;
        Intrinsics.checkNotNullParameter(r6, "exportResultResult");
        tt5.a.h("DocumentExportExecutorImplV2", "takeUtil，status = " + ((GetExportResultParserV2.ExportResultV2) r6.data).getJob_status());
        rw4.a r0 = this.c;
        int r1 = this.b;
        this.b = r1 + 1;
        r0.onPolling(r1);
        if (((GetExportResultParserV2.ExportResultV2) r6.data).getJob_status() != 0) goto L6;
        return true;
    L6:
        if (((GetExportResultParserV2.ExportResultV2) r6.data).getJob_status() > 2) goto L14;
        int r7 = this.a;
        if (r7 >= this.d) goto L12;
        this.a = r7 + 3;
        return false;
    L12:
        throw new IOException("polling time out");
    L14:
        throw new NetService.ServerErrorException(((GetExportResultParserV2.ExportResultV2) r6.data).getJob_status(), ((GetExportResultParserV2.ExportResultV2) r6.data).getJob_error_msg(), ((GetExportResultParserV2.ExportResultV2) r6.data).toString(), r6.toString());
    }

    public c(rw4.a r1, int r2) {
        this.c = r1;
        this.d = r2;
        this.a = 1;
    }
}
