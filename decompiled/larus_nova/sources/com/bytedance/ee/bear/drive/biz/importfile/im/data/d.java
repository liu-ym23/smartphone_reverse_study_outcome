package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.CreateResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T, R> f223049a = null;

    static {
        f223049a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Result r101 = (Result) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if (TextUtils.isEmpty(((CreateResult) r101.data).getTicket()) == true) goto L7;
        return (CreateResult) r101.data;
    L7:
        throw new IllegalStateException("CreateResult ticket is null");
    }
}
