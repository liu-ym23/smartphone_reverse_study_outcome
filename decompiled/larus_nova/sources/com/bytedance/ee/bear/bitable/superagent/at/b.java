package com.bytedance.ee.bear.bitable.superagent.at;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableSuperAgentAtView f215849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitableSuperAgentAtView.d.c f215850b;

    public b(BitableSuperAgentAtView r100, BitableSuperAgentAtView.d.c r101) {
        this.f215849a = r100;
        this.f215850b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BitableSuperAgentAtView r101 = this.f215849a;
        BitableSuperAgentAtViewModel.Section r102 = this.f215850b.f215800a;
        int r103 = BitableSuperAgentAtView.f215782h;
        r101.getClass();
        tt5.a.h("BitableSuperAgentAtView", "onMoreClick: section=" + r102);
        BitableSuperAgentAtViewModel r104 = r101.f215784b;
        if (r104 == null) goto L14;
        Intrinsics.checkNotNullParameter(r102, "section");
        MutableLiveData<BitableSuperAgentAtViewModel.ViewMode> r105 = r104.f215835o;
        int r106 = BitableSuperAgentAtViewModel.c.f215847a[r102.ordinal()];
        if (r106 != 1) goto L7;
        BitableSuperAgentAtViewModel.ViewMode r107 = BitableSuperAgentAtViewModel.ViewMode.USERS_ONLY;
    L12:
        r105.setValue(r107);
        return;
    L7:
        if (r106 != 2) goto L10;
        r107 = BitableSuperAgentAtViewModel.ViewMode.TABLES_ONLY;
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
