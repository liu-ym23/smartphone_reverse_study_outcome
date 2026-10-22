package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a2<T, R> implements Function {
    public final /* synthetic */ WikiTreeModel a;
    public final /* synthetic */ String b;

    public static final class a<V> implements Callable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ WikiTreeModel b;
        public final /* synthetic */ String c;

        public a(Object r1, WikiTreeModel r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            Boolean r0 = (Boolean) this.a;
            WikiTreeModel r1 = this.b;
            Intrinsics.checkNotNull(this.c);
            t1.l(r1, this.c);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public a2(WikiTreeModel r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final T apply(T r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Flowable.fromCallable(new a(r4, this.a, this.b)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
        return r4;
    }
}
