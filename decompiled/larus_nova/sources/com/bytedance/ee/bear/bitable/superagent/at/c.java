package com.bytedance.ee.bear.bitable.superagent.at;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableSuperAgentAtView f215851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitableSuperAgentAtView.d.e f215852b;

    public c(BitableSuperAgentAtView r100, BitableSuperAgentAtView.d.e r101) {
        this.f215851a = r100;
        this.f215852b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BitableSuperAgentAtView.a(this.f215851a, BitableSuperAgentAtViewModel.Section.TABLE, this.f215852b.f215804a);
    }
}
