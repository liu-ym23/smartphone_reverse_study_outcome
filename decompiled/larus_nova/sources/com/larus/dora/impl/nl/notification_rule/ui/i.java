package com.larus.dora.impl.nl.notification_rule.ui;

import android.widget.ProgressBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.larus.dora.impl.databinding.LarusDoraFragmentAddRuleInputBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class i<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AddRuleInputFragment f336355a;

    public i(AddRuleInputFragment r100) {
        this.f336355a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        boolean r102 = ((Boolean) r100).booleanValue();
        LarusDoraFragmentAddRuleInputBinding r103 = this.f336355a.f336296d;
        if (r103 == null) goto L7;
        LinearLayoutCompat r104 = r103.f332555f;
        if (r104 == null) goto L7;
        r104.setEnabled(!r102);
    L7:
        LarusDoraFragmentAddRuleInputBinding r105 = this.f336355a.f336296d;
        if (r105 == null) goto L16;
        ProgressBar r106 = r105.f332556g;
        if (r106 == null) goto L16;
        if (r102 == false) goto L13;
        int r107 = 0;
    L14:
        r106.setVisibility(r107);
        goto L16
    L13:
        r107 = 8;
    L16:
        return Unit.INSTANCE;
    }
}
