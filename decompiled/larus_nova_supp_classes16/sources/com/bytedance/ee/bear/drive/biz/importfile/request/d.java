package com.bytedance.ee.bear.drive.biz.importfile.request;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d<T> implements Predicate {
    public static final d<T> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final boolean test(Object r3) {
        Result r4 = (Result) r3;
        Intrinsics.checkNotNullParameter(r4, "checkResult");
        tt5.a.b("StartImportRequesterManagerImplV2", "filter，status = " + ((StartImportRequesterManagerImplV2.CheckImportResult) r4.data).getJob_status());
        if (((StartImportRequesterManagerImplV2.CheckImportResult) r4.data).getJob_status() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
