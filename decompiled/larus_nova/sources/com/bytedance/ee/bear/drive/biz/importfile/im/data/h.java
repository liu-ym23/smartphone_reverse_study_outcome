package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.biz.importfile.im.entity.ImportResult;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h<T> implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h<T> f223054a = null;

    static {
        f223054a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object r100) {
        ImportResult.Detail r101 = (ImportResult.Detail) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return !TextUtils.isEmpty(r101.getUrl());
    }
}
