package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.CreateResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d<T, R> implements Function {
    public static final d<T, R> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Object apply(Object r2) {
        Result r3 = (Result) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (TextUtils.isEmpty(((CreateResult) r3.data).getTicket()) == true) goto L7;
        return (CreateResult) r3.data;
    L7:
        throw new IllegalStateException("CreateResult ticket is null");
    }
}
