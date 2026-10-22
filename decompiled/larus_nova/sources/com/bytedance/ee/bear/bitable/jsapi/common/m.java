package com.bytedance.ee.bear.bitable.jsapi.common;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class m<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m<T, R> f214419a = null;

    static {
        f214419a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Result r101 = (Result) r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        return (CommonAttachmentPanel.AuthCodeResult) r101.getData();
    }
}
