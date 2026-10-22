package com.bytedance.ee.bear.bitable.superagent;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements View.OnFocusChangeListener {
    public final /* synthetic */ BitableSuperAgentPanel a;

    public j(BitableSuperAgentPanel r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r4, boolean r5) {
        tt5.a.h(this.a.t, "onInputFocusChange: hasFocus=" + r5);
        if (r5 == false) goto L5;
        rcb.c.h(r4, null);
    L5:
        BitableSuperAgentPanel r6 = this.a;
        r6.getClass();
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        r1.put("isFocused", Boolean.valueOf(r5));
        Unit r7 = Unit.INSTANCE;
        r0.put("data", r1);
        r6.ia0("bitable.update.composerFocus", r0);
        this.a.ka0();
    }
}
