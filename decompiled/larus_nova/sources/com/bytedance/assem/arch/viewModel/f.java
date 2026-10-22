package com.bytedance.assem.arch.viewModel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.assem.arch.viewModel.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes14.dex */
public interface f<S extends h> {
    void a(Function1<? super S, ? extends S> r100);

    void b(KProperty1 r100, i r101, Function0 r102, Function1 r103, Function0 r104, Function1 r105);

    void c(Function1<? super S, Unit> r100);

    void d(LifecycleOwner r100, i r101, Function1 r102, Function1 r103);

    void e(CoroutineScope r100);

    void f(S r100);

    void g(KProperty1 r100, i r101, Function0 r102, Function1 r103);

    S getState();

    void h(Function1<? super S, ? extends S> r100);

    void onClear();
}
