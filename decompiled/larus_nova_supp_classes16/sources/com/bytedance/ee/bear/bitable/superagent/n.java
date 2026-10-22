package com.bytedance.ee.bear.bitable.superagent;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ BitableSuperAgentPanel a;

    public n(BitableSuperAgentPanel r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        tt5.a.h(this.a.t, "onHistoryClick");
        this.a.ha0(MobileSuperAgentAction.ENTER_CONVERSATION_MANAGER.getValue(), null);
        BitableSuperAgentPanel r5 = this.a;
        JSONObject r0 = new JSONObject();
        r0.put("type", "click");
        r0.put(JSEventListener.ACTION, "history_record");
        Unit r1 = Unit.INSTANCE;
        r5.ia0("bitable.superagent.track", r0);
    }
}
