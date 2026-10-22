package com.bytedance.ee.bear.middleground.comment.control;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m<T, R> implements Function {
    public final /* synthetic */ Ref.ObjectRef<List<String>> a;

    public m(Ref.ObjectRef<List<String>> r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        com.bytedance.ee.bear.contract.x r5 = (com.bytedance.ee.bear.contract.x) r4;
        Intrinsics.checkNotNullParameter(r5, "hostService");
        Ref.ObjectRef<List<String>> r0 = this.a;
        r0.element = r5.f();
        return new Triple(r5.f(), r5.h(), r5.a());
    }
}
