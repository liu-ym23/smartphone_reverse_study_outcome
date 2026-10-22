package com.bytedance.ee.bear.bitable.homepage.chart.add;

import androidx.lifecycle.Observer;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Unit;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AddChartContainerFragment f212408a;

    public c(AddChartContainerFragment r100) {
        this.f212408a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Unit r101 = (Unit) r100;
        this.f212408a.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L12;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
