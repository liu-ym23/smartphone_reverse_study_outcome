package com.bytedance.ee.bear.drive.biz.importfile.request;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Predicate;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Predicate<Result<StartImportRequesterManagerImplV2.CheckImportResult>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f223073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f223074b;

    public c(int r100) {
        this.f223074b = r100;
        this.f223073a = 1;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Result<StartImportRequesterManagerImplV2.CheckImportResult> r100) {
        Result<StartImportRequesterManagerImplV2.CheckImportResult> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        tt5.a.b("StartImportRequesterManagerImplV2", "takeUtil，status = " + ((StartImportRequesterManagerImplV2.CheckImportResult) r101.data).getJob_status());
        if (((StartImportRequesterManagerImplV2.CheckImportResult) r101.data).getJob_status() != 0) goto L6;
        return true;
    L6:
        if (((StartImportRequesterManagerImplV2.CheckImportResult) r101.data).getJob_status() > 2) goto L14;
        int r102 = this.f223073a;
        if (r102 >= this.f223074b) goto L12;
        this.f223073a = r102 + 3;
        return false;
    L12:
        throw new IOException("polling time out");
    L14:
        throw new NetService.ServerErrorException(((StartImportRequesterManagerImplV2.CheckImportResult) r101.data).getJob_status(), ((StartImportRequesterManagerImplV2.CheckImportResult) r101.data).getJob_error_msg(), ((StartImportRequesterManagerImplV2.CheckImportResult) r101.data).toString(), r101.toString());
    }
}
