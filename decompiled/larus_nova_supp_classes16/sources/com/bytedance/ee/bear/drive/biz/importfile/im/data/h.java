package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h<T> implements Predicate {
    public static final h<T> a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final boolean test(Object r2) {
        ImportResult.Detail r3 = (ImportResult.Detail) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return !TextUtils.isEmpty(r3.getUrl());
    }
}
