package com.larksuite.arch.jack;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/larksuite/arch/jack/JackView;", "Lcom/larksuite/arch/jack/IdentitySubscriber;", "jack_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface JackView extends IdentitySubscriber {

    public static final class a {
        public static <S extends j> c d(JackView r100, JackViewModel<S> r101, l<S> r102, Function1<? super S, Unit> r103) {
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "config");
            Intrinsics.checkNotNullParameter(r103, "subscriber");
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "config");
            Intrinsics.checkNotNullParameter(r103, "subscriber");
            return f.a.g(r100, r101, r102, r103);
        }

        public static <S extends j, A> c a(JackView r100, JackViewModel<S> r101, KProperty1<S, ? extends A> r102, l<n<A>> r103, Function1<? super S, Unit> r104) {
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "prop1");
            Intrinsics.checkNotNullParameter(r103, "config");
            Intrinsics.checkNotNullParameter(r104, "subscriber");
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "prop1");
            Intrinsics.checkNotNullParameter(r103, "config");
            Intrinsics.checkNotNullParameter(r104, "subscriber");
            return f.a.a(r100, r101, r102, r103, r104);
        }

        public static <S extends j, A, B> c b(JackView r100, JackViewModel<S> r101, KProperty1<S, ? extends A> r102, KProperty1<S, ? extends B> r103, l<o<A, B>> r104, Function1<? super S, Unit> r110) {
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "prop1");
            Intrinsics.checkNotNullParameter(r103, "prop2");
            Intrinsics.checkNotNullParameter(r104, "config");
            Intrinsics.checkNotNullParameter(r110, "subscriber");
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "prop1");
            Intrinsics.checkNotNullParameter(r103, "prop2");
            Intrinsics.checkNotNullParameter(r104, "config");
            Intrinsics.checkNotNullParameter(r110, "subscriber");
            return f.a.b(r100, r101, r102, r103, r104, r110);
        }

        public static <S extends j, A, B, C> c c(JackView r100, JackViewModel<S> r101, KProperty1<S, ? extends A> r102, KProperty1<S, ? extends B> r103, KProperty1<S, ? extends C> r110, l<p<A, B, C>> r111, Function1<? super S, Unit> r112) {
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "prop1");
            Intrinsics.checkNotNullParameter(r103, "prop2");
            Intrinsics.checkNotNullParameter(r110, "prop3");
            Intrinsics.checkNotNullParameter(r111, "config");
            Intrinsics.checkNotNullParameter(r112, "subscriber");
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "prop1");
            Intrinsics.checkNotNullParameter(r103, "prop2");
            Intrinsics.checkNotNullParameter(r110, "prop3");
            Intrinsics.checkNotNullParameter(r111, "config");
            Intrinsics.checkNotNullParameter(r112, "subscriber");
            return f.a.c(r100, r101, r102, r103, r110, r111, r112);
        }
    }
}
