package com.ss.android.ugc.aweme.base.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"livebusiness_base_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class IBaseServiceKt {
    public static final <T extends IBaseService> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$get");
        ServiceCache.f449998c.getClass();
        return (T) ServiceCache.b(r100);
    }
}
