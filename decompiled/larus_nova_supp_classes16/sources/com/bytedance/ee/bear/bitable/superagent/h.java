package com.bytedance.ee.bear.bitable.superagent;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ BitableSuperAgentPanel a;
    public final /* synthetic */ BitableAtEditText b;

    public h(BitableSuperAgentPanel r1, BitableAtEditText r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        tt5.a.h(this.a.t, "onAtClick");
        this.b.requestFocus();
        rcb.c.h(this.b, null);
        this.b.J();
        BitableSuperAgentPanel r5 = this.a;
        JSONObject r0 = new JSONObject();
        r0.put("type", "click");
        r0.put(JSEventListener.ACTION, "reference");
        Unit r1 = Unit.INSTANCE;
        r5.ia0("bitable.superagent.track", r0);
    }
}
