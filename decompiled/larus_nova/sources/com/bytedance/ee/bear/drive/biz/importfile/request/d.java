package com.bytedance.ee.bear.drive.biz.importfile.request;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f223075a = null;

    static {
        f223075a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        Result r101 = (Result) r100;
        Intrinsics.checkNotNullParameter(r101, "checkResult");
        tt5.a.b("StartImportRequesterManagerImplV2", "filter，status = " + ((StartImportRequesterManagerImplV2.CheckImportResult) r101.data).getJob_status());
        if (((StartImportRequesterManagerImplV2.CheckImportResult) r101.data).getJob_status() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
