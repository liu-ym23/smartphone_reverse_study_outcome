package com.bytedance.assem.jedi_vm.viewModel;

import com.bytedance.assem.arch.extensions.j;
import com.bytedance.assem.arch.viewModel.h;
import io.reactivex.functions.Function;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d<T, R> implements Function<T, R> {
    public final /* synthetic */ KProperty1 a;

    public d(KProperty1 r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        KProperty1 r1 = this.a;
        return new j(r1.get((h) r3));
    }
}
