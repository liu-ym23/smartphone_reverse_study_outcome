package com.bytedance.ee.bear.drive.biz.importfile.request;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.drive.biz.importfile.exception.DriveStartImportException;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g<T, R> implements Function {
    public static final g<T, R> a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final Object apply(Object r2) {
        Result r3 = (Result) r2;
        if (r3 == null) goto L11;
        if (r3.code != 0) goto L11;
        if (r3.getData() == null) goto L11;
        return (StartImportRequesterManagerImplV2.StartImportResult) r3.getData();
    L11:
        throw new DriveStartImportException();
    }
}
