package com.larus.dora.impl.onboarding.othersmart;

import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.dora.impl.view.DoraItemTextToggleSubTitle;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class g<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraExternalOnboardingKeepAliveFragment f337144a;

    public g(DoraExternalOnboardingKeepAliveFragment r100) {
        this.f337144a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        boolean r102 = ((Boolean) r100).booleanValue();
        DoraItemTextToggleSubTitle r103 = this.f337144a.f337051s;
        if (r103 == null) goto L8;
        CustomSwitchCompat r104 = r103.getToggleView();
        if (r104 == null) goto L8;
        r104.setChecked(r102);
    L8:
        return Unit.INSTANCE;
    }
}
