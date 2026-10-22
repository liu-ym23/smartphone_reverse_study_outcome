package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q0<T, R> implements Function {
    public final /* synthetic */ ce5.a a;
    public final /* synthetic */ WikiInfo b;

    public static final class a<V> implements Callable {
        public final /* synthetic */ Object a;
        public final /* synthetic */ ce5.a b;
        public final /* synthetic */ WikiInfo c;

        public a(Object r1, ce5.a r2, WikiInfo r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            up5.b r0 = (up5.b) this.a;
            int r1 = p0.a;
            p0.a(this.b, this.c);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public q0(ce5.a r1, WikiInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    public final T apply(T r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Flowable.fromCallable(new a(r4, this.a, this.b)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
        return r4;
    }
}
