package com.larus.dora.impl.nl;

import com.larus.dora.impl.databinding.LarusDoraPageProactiveBinding;
import com.larus.utils.e1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class v0<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusDoraPageProactiveBinding f336400a;

    public v0(LarusDoraPageProactiveBinding r100) {
        this.f336400a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        Boolean r102 = (Boolean) r100;
        if (r102 != null) goto L5;
        e1.o(this.f336400a.f333220u);
        e1.o(this.f336400a.f333221v);
    L7:
        return Unit.INSTANCE;
    L5:
        e1.x(this.f336400a.f333220u);
        e1.x(this.f336400a.f333221v);
        this.f336400a.f333219t.getToggleView().setChecked(r102.booleanValue());
        goto L7
    }
}
