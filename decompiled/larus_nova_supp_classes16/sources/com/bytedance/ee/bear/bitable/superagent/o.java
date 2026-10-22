package com.bytedance.ee.bear.bitable.superagent;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ BitableSuperAgentPanel a;

    public o(BitableSuperAgentPanel r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        tt5.a.h(this.a.t, "onAddChatClick");
        this.a.ha0(MobileSuperAgentAction.START_NEW_CONVERSATION.getValue(), null);
    }
}
