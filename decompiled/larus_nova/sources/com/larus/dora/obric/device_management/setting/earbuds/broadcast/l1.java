package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import com.obric.oui.button.OButton;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class l1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricEarbudsConfirmRulesSheet f339902a;

    public l1(DoraObricEarbudsConfirmRulesSheet r100) {
        this.f339902a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        boolean r102 = ((Boolean) r100).booleanValue();
        OButton r103 = this.f339902a.f339781e;
        if (r103 == null) goto L5;
        r103.setEnabled(!r102);
    L5:
        OButton r104 = this.f339902a.f339781e;
        float r105 = 1.0f;
        if (r104 == null) goto L11;
        if (r102 == false) goto L9;
        float r106 = 0.3f;
    L10:
        r104.setAlpha(r106);
        goto L11
    L9:
        r106 = 1.0f;
    L11:
        OButton r107 = this.f339902a.f339782f;
        if (r107 == null) goto L14;
        r107.setEnabled(!r102);
    L14:
        OButton r108 = this.f339902a.f339782f;
        if (r108 == null) goto L20;
        if (r102 == false) goto L18;
        r105 = 0.3f;
    L18:
        r108.setAlpha(r105);
    L20:
        return Unit.INSTANCE;
    }
}
