package com.bytedance.ee.bear.middleground.permission.transfer.executor;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T, R> implements Function {
    public static final e<T, R> a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object apply(Object r2) {
        OwnerTransferApplyExecutor.PresenterFolderResult r3 = (OwnerTransferApplyExecutor.PresenterFolderResult) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Boolean.valueOf(r3.isPresenter());
    }
}
