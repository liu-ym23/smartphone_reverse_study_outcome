package com.bytedance.assem.jedi_vm.viewModel;

import com.bytedance.assem.arch.viewModel.h;
import com.bytedance.assem.arch.viewModel.i;
import io.reactivex.functions.Predicate;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final class e<T> implements Predicate<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f193130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f193131b;

    public e(Function0 r100, i r101) {
        this.f193130a = r100;
        this.f193131b = r101;
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(h r100) {
        Function0 r101 = this.f193130a;
        if (r101 == null) goto L7;
        this.f193131b.getClass();
        Boolean r102 = (Boolean) r101.invoke();
        if (r102 == null) goto L7;
        return r102.booleanValue();
    L7:
        return true;
    }
}
