package com.larus.dora.impl.onboarding.lite;

import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.dora.impl.view.DoraItemTextToggleSubTitle;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class n<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraLiteOnboardingKeepAliveFragment f336982a;

    public n(DoraLiteOnboardingKeepAliveFragment r100) {
        this.f336982a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        boolean r102 = ((Boolean) r100).booleanValue();
        DoraItemTextToggleSubTitle r103 = this.f336982a.f336889r;
        if (r103 == null) goto L8;
        CustomSwitchCompat r104 = r103.getToggleView();
        if (r104 == null) goto L8;
        r104.setChecked(r102);
    L8:
        return Unit.INSTANCE;
    }
}
