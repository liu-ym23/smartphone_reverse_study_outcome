package com.bytedance.ee.bear.bitable.superagent.at;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ BitableSuperAgentAtView a;

    public a(BitableSuperAgentAtView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        BitableSuperAgentAtView r4 = this.a;
        int r0 = BitableSuperAgentAtView.h;
        r4.getClass();
        tt5.a.h("BitableSuperAgentAtView", "onBackClick");
        BitableSuperAgentAtViewModel r5 = r4.b;
        if (r5 == null) goto L6;
        r5.o.setValue(BitableSuperAgentAtViewModel.ViewMode.DEFAULT);
        return;
    }
}
