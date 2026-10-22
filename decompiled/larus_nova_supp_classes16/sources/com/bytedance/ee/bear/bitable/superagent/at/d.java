package com.bytedance.ee.bear.bitable.superagent.at;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ BitableSuperAgentAtView a;
    public final /* synthetic */ BitableSuperAgentAtView.d.f b;

    public d(BitableSuperAgentAtView r1, BitableSuperAgentAtView.d.f r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        BitableSuperAgentAtView.a(this.a, BitableSuperAgentAtViewModel.Section.USERS_AND_GROUPS, this.b.a);
    }
}
