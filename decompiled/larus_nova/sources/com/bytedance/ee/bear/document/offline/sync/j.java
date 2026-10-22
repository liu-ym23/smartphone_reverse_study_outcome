package com.bytedance.ee.bear.document.offline.sync;

import com.baidu.platform.comapi.map.MapBundleKey;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class j<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j<T, R> f220607a = null;

    static {
        f220607a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        z05.g r101 = (z05.g) r100;
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        return r101.f569617a;
    }
}
