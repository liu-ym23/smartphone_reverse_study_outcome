package com.bytedance.ee.bear.bitable.pro;

import android.view.View;
import androidx.lifecycle.Observer;
import com.larksuite.component.universe_design.notice.UDNotice;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l<T> implements Observer {
    public final /* synthetic */ BitableProFragment a;

    public l(BitableProFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        PermissionUpdateStatus r5 = (PermissionUpdateStatus) r4;
        BitableProFragment r0 = this.a;
        View r1 = r0.k;
        if (r1 != null) goto L9;
        View r2 = r0.getView();
        if (r2 == null) goto L7;
        r1 = r2.findViewById(2131382179);
    L8:
        r0.k = (UDNotice) r1;
        goto L9
    L7:
        r1 = null;
    L9:
        UDNotice r3 = (UDNotice) r1;
        PermissionUpdateStatus r6 = PermissionUpdateStatus.ReadyToUpdate;
        if (r5 != r6) goto L12;
        int r7 = 0;
    L13:
        r3.setVisibility(r7);
        if (r5 != r6) goto L17;
        int r8 = d.a;
        d.b("ccm_bitable_premium_permission_backend_upgrade_tips_view", new JSONObject());
        return;
    L17:
        return;
    L12:
        r7 = 8;
        goto L13
    }
}
