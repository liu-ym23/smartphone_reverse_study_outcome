package com.bytedance.ee.bear.bitable.superagent.at;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableSuperAgentAtView f215848a;

    public a(BitableSuperAgentAtView r100) {
        this.f215848a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BitableSuperAgentAtView r101 = this.f215848a;
        int r102 = BitableSuperAgentAtView.f215782h;
        r101.getClass();
        tt5.a.h("BitableSuperAgentAtView", "onBackClick");
        BitableSuperAgentAtViewModel r103 = r101.f215784b;
        if (r103 == null) goto L6;
        r103.f215835o.setValue(BitableSuperAgentAtViewModel.ViewMode.DEFAULT);
        return;
    }
}
