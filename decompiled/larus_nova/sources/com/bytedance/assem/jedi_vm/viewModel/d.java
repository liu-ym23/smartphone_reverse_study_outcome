package com.bytedance.assem.jedi_vm.viewModel;

import com.bytedance.assem.arch.extensions.j;
import com.bytedance.assem.arch.viewModel.h;
import io.reactivex.functions.Function;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes14.dex */
public final class d<T, R> implements Function<T, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KProperty1 f193129a;

    public d(KProperty1 r100) {
        this.f193129a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        KProperty1 r101 = this.f193129a;
        return new j(r101.get((h) r100));
    }
}
