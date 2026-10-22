package com.bytedance.ee.bear.more.protocol3.extension;

import com.bytedance.ee.bear.DocObjInfo;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class n<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n<T1, T2, R> f234838a = null;

    static {
        f234838a = new n();
    }

    public n() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        DocObjInfo r102 = (DocObjInfo) r100;
        DocObjInfo r103 = (DocObjInfo) r101;
        Intrinsics.checkNotNullParameter(r102, "objInfo");
        Intrinsics.checkNotNullParameter(r103, "wikiStateInfo");
        r102.setPined(r103.isPined());
        r102.setStared(r103.isStared());
        return r102;
    }
}
