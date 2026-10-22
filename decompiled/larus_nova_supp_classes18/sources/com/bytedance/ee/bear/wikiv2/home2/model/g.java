package com.bytedance.ee.bear.wikiv2.home2.model;

import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T1, T2, R> implements BiFunction {
    public static final g<T1, T2, R> a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final Object apply(Object r8, Object r9) {
        List r10 = (List) r8;
        List r11 = (List) r9;
        Intrinsics.checkNotNullParameter(r10, "spaceTypes");
        Intrinsics.checkNotNullParameter(r11, "spaceClassifications");
        WikiSpaceFilterOption r3 = new WikiSpaceFilterOption(r10, r11);
        WikiSpaceFilterInfo.Companion.getClass();
        return new WikiSpaceFilterInfo(WikiSpaceFilterInfo.access$getNoFilter$cp(), r3, false, 4, null);
    }
}
