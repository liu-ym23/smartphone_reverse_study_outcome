package com.bytedance.ee.bear.middleground.permission.transfer.executor;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T, R> f234302a = null;

    static {
        f234302a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        OwnerTransferApplyExecutor.PresenterFolderResult r101 = (OwnerTransferApplyExecutor.PresenterFolderResult) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return Boolean.valueOf(r101.isPresenter());
    }
}
