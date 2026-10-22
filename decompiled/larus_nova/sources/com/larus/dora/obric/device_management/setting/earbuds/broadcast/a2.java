package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import com.obric.oui.button.OButton;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class a2<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricEarbudsCustomBroadcastRulesFragment f339826a;

    public a2(DoraObricEarbudsCustomBroadcastRulesFragment r100) {
        this.f339826a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        boolean r102 = ((Boolean) r100).booleanValue();
        DoraObricEarbudsCustomBroadcastRulesFragment r103 = this.f339826a;
        r103.f339790l = r102;
        OButton r104 = r103.f339789k;
        if (r104 == null) goto L9;
        if (r102 == false) goto L6;
        float r105 = 1.0f;
    L7:
        r104.setAlpha(r105);
        goto L9
    L6:
        r105 = 0.3f;
    L9:
        return Unit.INSTANCE;
    }
}
