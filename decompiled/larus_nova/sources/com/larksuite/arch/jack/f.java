package com.larksuite.arch.jack;

import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes24.dex */
public interface f {

    public static final class a {
        public static void h(f r100, JackViewModel r101, Function1 r102) {
            r100.nH(r101, new l(), r102);
        }

        public static void e(f r100, JackViewModel r101, PropertyReference1Impl r102, Function1 r103) {
            r100.Ik(r101, r102, new l(), r103);
        }

        public static <S extends j> c g(f r100, JackViewModel<S> r101, l<S> r102, Function1<? super S, Unit> r103) {
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "config");
            Intrinsics.checkNotNullParameter(r103, "subscriber");
            return r101.subscribeInternal$jack_release(r100.getLifecycleOwnerHolder().getLifecycleOwner(), r102, r103);
        }

        public static <S extends j, A> c a(f r100, JackViewModel<S> r101, KProperty1<S, ? extends A> r102, l<n<A>> r103, Function1<? super S, Unit> r104) {
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "prop1");
            Intrinsics.checkNotNullParameter(r103, "config");
            Intrinsics.checkNotNullParameter(r104, "subscriber");
            return r101.selectSubscribeInternal$jack_release(r100.getLifecycleOwnerHolder().getLifecycleOwner(), r102, r103, r104);
        }

        public static void f(f r100, JackViewModel r101, PropertyReference1Impl r102, PropertyReference1Impl r103, Function1 r110) {
            r100.Ki(r101, r102, r103, new l(), r110);
        }

        public static <S extends j, A, B> c b(f r100, JackViewModel<S> r101, KProperty1<S, ? extends A> r102, KProperty1<S, ? extends B> r103, l<o<A, B>> r110, Function1<? super S, Unit> r111) {
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "prop1");
            Intrinsics.checkNotNullParameter(r103, "prop2");
            Intrinsics.checkNotNullParameter(r110, "config");
            Intrinsics.checkNotNullParameter(r111, "subscriber");
            return r101.selectSubscribeInternal$jack_release(r100.getLifecycleOwnerHolder().getLifecycleOwner(), r102, r103, r110, r111);
        }

        public static void d(f r100, FilePickerViewModel r101, PropertyReference1Impl r102, PropertyReference1Impl r110, PropertyReference1Impl r111, Function1 r112) {
            r100.O60(r101, r102, r110, r111, new l(), r112);
        }

        public static <S extends j, A, B, C> c c(f r100, JackViewModel<S> r101, KProperty1<S, ? extends A> r102, KProperty1<S, ? extends B> r110, KProperty1<S, ? extends C> r111, l<p<A, B, C>> r112, Function1<? super S, Unit> r113) {
            Intrinsics.checkNotNullParameter(r101, "$receiver");
            Intrinsics.checkNotNullParameter(r102, "prop1");
            Intrinsics.checkNotNullParameter(r110, "prop2");
            Intrinsics.checkNotNullParameter(r111, "prop3");
            Intrinsics.checkNotNullParameter(r112, "config");
            Intrinsics.checkNotNullParameter(r113, "subscriber");
            return r101.selectSubscribeInternal$jack_release(r100.getLifecycleOwnerHolder().getLifecycleOwner(), r102, r110, r111, r112, r113);
        }
    }

    c Ik(JackViewModel r100, PropertyReference1Impl r101, l r102, Function1 r103);

    c Ki(JackViewModel r100, PropertyReference1Impl r101, PropertyReference1Impl r102, l r103, Function1 r104);

    c O60(FilePickerViewModel r100, PropertyReference1Impl r101, PropertyReference1Impl r102, PropertyReference1Impl r103, l r104, Function1 r105);

    i getLifecycleOwnerHolder();

    <S extends j> c nH(JackViewModel<S> r100, l<S> r101, Function1<? super S, Unit> r102);
}
