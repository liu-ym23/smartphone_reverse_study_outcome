package com.larus.dora.obric.device_management.setting.g;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class p<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricGSettingsFragment f340596a;

    public p(DoraObricGSettingsFragment r100) {
        this.f340596a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        u r102 = (u) r100;
        DoraObricGSettingsFragment r103 = this.f340596a;
        int r104 = DoraObricGSettingsFragment.f340242m;
        r103.ca0();
        return Unit.INSTANCE;
    }
}
