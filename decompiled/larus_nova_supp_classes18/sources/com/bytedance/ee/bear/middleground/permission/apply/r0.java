package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r0 implements View.OnFocusChangeListener {
    public static final r0 a = null;

    static {
        a = new r0();
    }

    public r0() {
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r2, boolean r3) {
        if (r3 == false) goto L5;
        int r4 = com.bytedance.ee.bear.bitable.pro.d.a;
        JSONObject r5 = new JSONObject();
        r5.put("click", "comment");
        com.bytedance.ee.bear.bitable.pro.d.b("ccm_bitable_premium_permission_application_click", r5);
        return;
    }
}
