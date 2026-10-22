package com.bytedance.ee.bear.document.export.net.exportV2;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Predicate;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Predicate<Result<GetExportResultParserV2.ExportResultV2>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f219838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f219839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ rw4.a f219840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f219841d;

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Result<GetExportResultParserV2.ExportResultV2> r100) {
        Result<GetExportResultParserV2.ExportResultV2> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "exportResultResult");
        tt5.a.h("DocumentExportExecutorImplV2", "takeUtil，status = " + ((GetExportResultParserV2.ExportResultV2) r101.data).getJob_status());
        rw4.a r102 = this.f219840c;
        int r103 = this.f219839b;
        this.f219839b = r103 + 1;
        r102.onPolling(r103);
        if (((GetExportResultParserV2.ExportResultV2) r101.data).getJob_status() != 0) goto L6;
        return true;
    L6:
        if (((GetExportResultParserV2.ExportResultV2) r101.data).getJob_status() > 2) goto L14;
        int r104 = this.f219838a;
        if (r104 >= this.f219841d) goto L12;
        this.f219838a = r104 + 3;
        return false;
    L12:
        throw new IOException("polling time out");
    L14:
        throw new NetService.ServerErrorException(((GetExportResultParserV2.ExportResultV2) r101.data).getJob_status(), ((GetExportResultParserV2.ExportResultV2) r101.data).getJob_error_msg(), ((GetExportResultParserV2.ExportResultV2) r101.data).toString(), r101.toString());
    }

    public c(rw4.a r100, int r101) {
        this.f219840c = r100;
        this.f219841d = r101;
        this.f219838a = 1;
    }
}
