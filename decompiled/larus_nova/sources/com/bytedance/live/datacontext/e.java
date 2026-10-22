package com.bytedance.live.datacontext;

import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    public static final class a implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f255081a;

        public a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f255081a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final /* synthetic */ Object apply(Object r100) {
            return this.f255081a.invoke(r100);
        }
    }

    public static final class b implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f255082a;

        public b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f255082a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final /* synthetic */ boolean test(Object r100) {
            return ((Boolean) this.f255082a.invoke(r100)).booleanValue();
        }
    }

    public static /* synthetic */ p b(DataContext r100) {
        return a(r100, EventKt$event$1.INSTANCE);
    }

    public static final <T> p<k<T>> a(DataContext r100, Function1<? super f<T>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "config");
        f r102 = new f(r100.getOnCleared());
        r101.invoke(r102);
        return new p(new EventMember(r102));
    }
}
