package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l2<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l2<T1, T2, R> f241951a = null;

    static {
        f241951a = new l2();
    }

    public l2() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        WikiRelation r102 = (WikiRelation) r100;
        SpacePerm r103 = (SpacePerm) r101;
        Intrinsics.checkNotNullParameter(r102, "relation");
        Intrinsics.checkNotNullParameter(r103, "rootPermInfo");
        r102.space_perm = r103;
        if (r102.isValid() == false) goto L5;
        r102.init();
    L5:
        return r102;
    }
}
