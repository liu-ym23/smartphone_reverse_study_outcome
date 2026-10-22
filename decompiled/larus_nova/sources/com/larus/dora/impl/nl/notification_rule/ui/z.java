package com.larus.dora.impl.nl.notification_rule.ui;

import android.widget.LinearLayout;
import com.larus.dora.impl.databinding.LarusDoraFragmentCustomBroadcastRulesBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class z<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomBroadcastRulesFragment f336376a;

    public z(CustomBroadcastRulesFragment r100) {
        this.f336376a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        boolean r102 = ((Boolean) r100).booleanValue();
        LarusDoraFragmentCustomBroadcastRulesBinding r103 = this.f336376a.f336301d;
        if (r103 == null) goto L11;
        LinearLayout r104 = r103.f332562b;
        if (r104 == null) goto L11;
        if (r102 == false) goto L8;
        float r105 = 1.0f;
    L9:
        r104.setAlpha(r105);
        goto L11
    L8:
        r105 = 0.3f;
    L11:
        return Unit.INSTANCE;
    }
}
