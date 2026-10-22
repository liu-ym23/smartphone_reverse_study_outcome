package com.bytedance.android.shopping.prepurchase.arch.container.component;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface j {
    void a(f r1);

    <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> void b(T r1);

    void c(f r1);

    j d(String r1, Function0<? extends List<? extends Class<?>>> r2);

    <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> Object e(Class<T> r1, Continuation<? super T> r2);

    <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> void f(Class<T> r1, T r2, boolean r3);

    <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> T getService(Class<T> r1);
}
