package com.bytedance.ee.bear.drive.biz.importfile.request;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.drive.biz.importfile.exception.DriveStartImportException;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes16.dex */
public final class g<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T, R> f223079a = null;

    static {
        f223079a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Result r101 = (Result) r100;
        if (r101 == null) goto L11;
        if (r101.code != 0) goto L11;
        if (r101.getData() == null) goto L11;
        return (StartImportRequesterManagerImplV2.StartImportResult) r101.getData();
    L11:
        throw new DriveStartImportException();
    }
}
