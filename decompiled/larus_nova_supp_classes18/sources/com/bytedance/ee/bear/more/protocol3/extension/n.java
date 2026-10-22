package com.bytedance.ee.bear.more.protocol3.extension;

import com.bytedance.ee.bear.DocObjInfo;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n<T1, T2, R> implements BiFunction {
    public static final n<T1, T2, R> a = null;

    static {
        a = new n();
    }

    public n() {
    }

    public final Object apply(Object r2, Object r3) {
        DocObjInfo r4 = (DocObjInfo) r2;
        DocObjInfo r5 = (DocObjInfo) r3;
        Intrinsics.checkNotNullParameter(r4, "objInfo");
        Intrinsics.checkNotNullParameter(r5, "wikiStateInfo");
        r4.setPined(r5.isPined());
        r4.setStared(r5.isStared());
        return r4;
    }
}
