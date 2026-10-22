package com.bytedance.ee.bear.bitable.superagent.at;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableSuperAgentAtView f215853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitableSuperAgentAtView.d.f f215854b;

    public d(BitableSuperAgentAtView r100, BitableSuperAgentAtView.d.f r101) {
        this.f215853a = r100;
        this.f215854b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BitableSuperAgentAtView.a(this.f215853a, BitableSuperAgentAtViewModel.Section.USERS_AND_GROUPS, this.f215854b.f215806a);
    }
}
