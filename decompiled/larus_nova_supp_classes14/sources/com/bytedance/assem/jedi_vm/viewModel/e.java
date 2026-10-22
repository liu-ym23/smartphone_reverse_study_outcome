package com.bytedance.assem.jedi_vm.viewModel;

import com.bytedance.assem.arch.viewModel.h;
import com.bytedance.assem.arch.viewModel.i;
import io.reactivex.functions.Predicate;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e<T> implements Predicate<h> {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ i b;

    public e(Function0 r1, i r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean test(Object r2) {
        h r3 = (h) r2;
        Function0 r4 = this.a;
        if (r4 == null) goto L7;
        this.b.getClass();
        Boolean r5 = (Boolean) r4.invoke();
        if (r5 == null) goto L7;
        return r5.booleanValue();
    L7:
        return true;
    }
}
