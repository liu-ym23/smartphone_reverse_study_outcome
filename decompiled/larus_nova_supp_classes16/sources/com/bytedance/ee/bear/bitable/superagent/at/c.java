package com.bytedance.ee.bear.bitable.superagent.at;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ BitableSuperAgentAtView a;
    public final /* synthetic */ BitableSuperAgentAtView.d.e b;

    public c(BitableSuperAgentAtView r1, BitableSuperAgentAtView.d.e r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        BitableSuperAgentAtView.a(this.a, BitableSuperAgentAtViewModel.Section.TABLE, this.b.a);
    }
}
