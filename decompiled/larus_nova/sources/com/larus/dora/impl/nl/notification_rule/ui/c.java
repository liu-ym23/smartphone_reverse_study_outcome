package com.larus.dora.impl.nl.notification_rule.ui;

import android.widget.ProgressBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.larus.dora.impl.databinding.LarusDoraFragmentAddRuleClarificationBinding;
import com.larus.dora.impl.view.DoraTextView;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class c<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AddRuleClarificationFragment f336338a;

    public c(AddRuleClarificationFragment r100) {
        this.f336338a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        boolean r102 = ((Boolean) r100).booleanValue();
        LarusDoraFragmentAddRuleClarificationBinding r103 = this.f336338a.f336290d;
        if (r103 == null) goto L7;
        LinearLayoutCompat r104 = r103.f332544b;
        if (r104 == null) goto L7;
        r104.setEnabled(!r102);
    L7:
        LarusDoraFragmentAddRuleClarificationBinding r105 = this.f336338a.f336290d;
        if (r105 == null) goto L15;
        ProgressBar r106 = r105.f332545c;
        if (r106 == null) goto L15;
        if (r102 == false) goto L13;
        int r107 = 0;
    L14:
        r106.setVisibility(r107);
        goto L15
    L13:
        r107 = 8;
    L15:
        LarusDoraFragmentAddRuleClarificationBinding r108 = this.f336338a.f336290d;
        if (r108 == null) goto L21;
        DoraTextView r109 = r108.f332549g;
        if (r109 == null) goto L21;
        r109.setEnabled(!r102);
    L21:
        return Unit.INSTANCE;
    }
}
