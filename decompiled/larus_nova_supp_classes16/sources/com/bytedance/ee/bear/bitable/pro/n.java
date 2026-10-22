package com.bytedance.ee.bear.bitable.pro;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ BitableProFragment a;

    public n(BitableProFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        int r6 = d.a;
        com.bytedance.ee.bear.document.bitable.c r7 = this.a.B;
        BitableProViewModel r0 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proInfo");
        r7 = null;
    L5:
        Boolean r8 = Boolean.valueOf(r7.a);
        JSONObject r1 = new JSONObject();
        r1.put("click", "upgrade");
        r1.put("target", "none");
        if (r8 == null) goto L8;
        r1.put("is_template", r8.toString());
    L8:
        d.b("ccm_bitable_premium_permission_setting_click", r1);
        BitableProViewModel r9 = this.a.D;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        r0.fetchUpdateEffectData();
        return;
    L11:
        r0 = r9;
        goto L12
    }
}
