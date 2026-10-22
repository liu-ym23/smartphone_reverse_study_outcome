package com.bytedance.live.datacontext;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class ConstantKt {

    public static final class a implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f255053a;

        public a(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f255053a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f255053a.invoke(r100);
        }
    }

    public static /* synthetic */ p c(DataContext r100) {
        return b(r100, ConstantKt$constant$1.INSTANCE);
    }

    public static final <T> p<j<T>> b(DataContext r100, Function1<? super ConstantMemberConfig<T>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "config");
        ConstantMemberConfig r102 = new ConstantMemberConfig(r100.getOnCleared(), ConstantKt$constant$2.INSTANCE);
        r101.invoke(r102);
        return new p(new ConstantNullable(r102));
    }

    public static /* synthetic */ p d(DataContext r100, Object r101) {
        return a(r100, r101, ConstantKt$constant$3.INSTANCE);
    }

    public static final <T> p<i<T>> a(DataContext r100, final T r101, Function1<? super ConstantMemberConfig<T>, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        Intrinsics.checkNotNullParameter(r102, "config");
        ConstantMemberConfig r103 = new ConstantMemberConfig(r100.getOnCleared(), new ConstantKt$constant$4(r101));
        r102.invoke(r103);
        return new p(new com.bytedance.live.datacontext.a(r103));
    }
}
