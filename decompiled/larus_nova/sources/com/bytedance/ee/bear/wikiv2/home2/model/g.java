package com.bytedance.ee.bear.wikiv2.home2.model;

import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T1, T2, R> f240931a = null;

    static {
        f240931a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        List r102 = (List) r100;
        List r103 = (List) r101;
        Intrinsics.checkNotNullParameter(r102, "spaceTypes");
        Intrinsics.checkNotNullParameter(r103, "spaceClassifications");
        WikiSpaceFilterOption r104 = new WikiSpaceFilterOption(r102, r103);
        WikiSpaceFilterInfo.Companion.getClass();
        return new WikiSpaceFilterInfo(WikiSpaceFilterInfo.access$getNoFilter$cp(), r104, false, 4, null);
    }
}
