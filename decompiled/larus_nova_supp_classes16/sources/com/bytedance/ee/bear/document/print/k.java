package com.bytedance.ee.bear.document.print;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.more.PageViewResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k<T, R> implements Function {
    public static final k<T, R> a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final Object apply(Object r2) {
        PageViewResult r3 = (PageViewResult) r2;
        Intrinsics.checkNotNullParameter(r3, TipCallBackData.RESULT);
        if (r3.commentsCount <= 0) goto L5;
        boolean r4 = true;
    L7:
        return Boolean.valueOf(r4);
    L5:
        r4 = false;
        goto L7
    }
}
