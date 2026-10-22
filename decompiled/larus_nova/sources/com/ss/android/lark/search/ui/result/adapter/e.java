package com.ss.android.lark.search.ui.result.adapter;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f<?>> f440291a;

    public e(int r100) {
        ArrayList r101 = new ArrayList();
        Intrinsics.checkNotNullParameter(r101, "types");
        this.f440291a = r101;
    }

    public final <T> f<T> getType(int r100) {
        Object r101 = ListProtector.get(this.f440291a, r100);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.search.ui.result.adapter.Type<T of com.ss.android.lark.search.ui.result.adapter.MutableTypes.getType>");
        return (f) r101;
    }
}
