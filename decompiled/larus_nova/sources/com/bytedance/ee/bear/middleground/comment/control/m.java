package com.bytedance.ee.bear.middleground.comment.control;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class m<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<List<String>> f231230a;

    public m(Ref.ObjectRef<List<String>> r100) {
        this.f231230a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.ee.bear.contract.x r101 = (com.bytedance.ee.bear.contract.x) r100;
        Intrinsics.checkNotNullParameter(r101, "hostService");
        Ref.ObjectRef<List<String>> r102 = this.f231230a;
        r102.element = (T) r101.f();
        return new Triple(r101.f(), r101.h(), r101.a());
    }
}
