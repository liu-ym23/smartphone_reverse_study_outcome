package com.bytedance.ee.bear.wikiv2.home2.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T, R> implements Function {
    public final /* synthetic */ WikiHomeRepositoryImpl a;

    public static final class a<V> implements Callable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ WikiHomeRepositoryImpl b;

        public a(Object r1, WikiHomeRepositoryImpl r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            WikiSpaceFilterInfo r0 = (WikiSpaceFilterInfo) this.a;
            WikiHomeRepositoryImpl.j(this.b).b("last_filter_option_empty", Boolean.valueOf(r0.isEmptyFilterOption()));
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public f(WikiHomeRepositoryImpl r1) {
        this.a = r1;
    }

    public final T apply(T r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Flowable.fromCallable(new a(r4, this.a)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
        return r4;
    }
}
