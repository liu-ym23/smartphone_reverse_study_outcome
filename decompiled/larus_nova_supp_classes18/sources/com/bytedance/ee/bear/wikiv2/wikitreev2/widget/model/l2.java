package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l2<T1, T2, R> implements BiFunction {
    public static final l2<T1, T2, R> a = null;

    static {
        a = new l2();
    }

    public l2() {
    }

    public final Object apply(Object r2, Object r3) {
        WikiRelation r4 = (WikiRelation) r2;
        SpacePerm r5 = (SpacePerm) r3;
        Intrinsics.checkNotNullParameter(r4, "relation");
        Intrinsics.checkNotNullParameter(r5, "rootPermInfo");
        r4.space_perm = r5;
        if (r4.isValid() == false) goto L5;
        r4.init();
    L5:
        return r4;
    }
}
