package com.bytedance.ee.bear.wikiv2.home2.model;

import com.bytedance.ee.bear.wikiv2.home.api.GetSpaceClassificationPuller;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T, R> implements Function {
    public static final h<T, R> a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final Object apply(Object r4) {
        GetSpaceClassificationPuller.Result r5 = (GetSpaceClassificationPuller.Result) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        List r6 = r5.class_list;
        if (r6 != null) goto L6;
        r6 = new ArrayList();
    L6:
        if ((!r6.isEmpty()) == false) goto L8;
        ListProtector.add(r6, 0, new WikiSpaceClassification("all", eu5.b.a.getString(2131889792)));
    L8:
        return r6;
    }
}
