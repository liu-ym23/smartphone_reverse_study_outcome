package com.bytedance.ee.bear.bitable.pro;

import android.view.View;
import com.larksuite.component.universe_design.toast.UDToast;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ Role c;
    public final /* synthetic */ BitableProAdapter d;

    public final void a(View r5) {
        if (this.c.isFaType() == false) goto L5;
        UDToast.show(BitableProAdapter.y2(this.d), 2131886211, 2131256189);
        return;
    L5:
        i0 r6 = this.d.a;
        if (r6 == null) goto L8;
        r6.pJ(this.c);
    L8:
        int r7 = d.a;
        String r8 = this.c.getRoleId();
        Boolean r0 = Boolean.valueOf(this.c.isTemplate());
        JSONObject r1 = new JSONObject();
        r1.put("click", "permission_rulesetting");
        r1.put("target", "ccm_bitable_premium_permission_rulesetting_view");
        if (r8 == null) goto L11;
        r1.put("role_id", r8);
    L11:
        if (r0 == null) goto L13;
        r1.put("is_template", r0.toString());
    L13:
        d.b("ccm_bitable_premium_permission_setting_click", r1);
    }

    public b(Role r1, BitableProAdapter r2) {
        this.c = r1;
        this.d = r2;
    }
}
