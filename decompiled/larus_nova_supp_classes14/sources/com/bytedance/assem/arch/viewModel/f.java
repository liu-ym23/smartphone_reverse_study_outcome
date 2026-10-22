package com.bytedance.assem.arch.viewModel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.assem.arch.viewModel.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface f<S extends h> {
    void a(Function1<? super S, ? extends S> r1);

    void b(KProperty1 r1, i r2, Function0 r3, Function1 r4, Function0 r5, Function1 r6);

    void c(Function1<? super S, Unit> r1);

    void d(LifecycleOwner r1, i r2, Function1 r3, Function1 r4);

    void e(CoroutineScope r1);

    void f(S r1);

    void g(KProperty1 r1, i r2, Function0 r3, Function1 r4);

    S getState();

    void h(Function1<? super S, ? extends S> r1);

    void onClear();
}
