package com.bytedance.ee.bear.bitable.pro;

import android.view.View;
import com.larksuite.component.universe_design.toast.UDToast;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ Role c;
    public final /* synthetic */ BitableProAdapter d;

    public final void a(View r4) {
        if (this.c.disableEditMembers() == false) goto L5;
        UDToast.show(BitableProAdapter.y2(this.d), 2131886152, 2131256189);
        return;
    L5:
        i0 r5 = this.d.a;
        if (r5 == null) goto L8;
        r5.HB(this.c);
    L8:
        int r6 = d.a;
        String r7 = this.c.getRoleId();
        JSONObject r0 = new JSONObject();
        r0.put("click", "manage_collaborator");
        r0.put("target", "ccm_bitable_premium_permission_manage_collaborator_view");
        if (r7 == null) goto L11;
        r0.put("role_id", r7);
    L11:
        r0.put("is_template", "false");
        d.b("ccm_bitable_premium_permission_setting_click", r0);
    }

    public a(Role r1, BitableProAdapter r2) {
        this.c = r1;
        this.d = r2;
    }
}
