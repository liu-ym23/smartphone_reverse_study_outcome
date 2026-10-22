package com.bytedance.ee.bear.bitable.pro;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o implements BitableProViewModel.ActionPanelListener {
    public final /* synthetic */ BitableProFragment a;

    public o(BitableProFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BitableProViewModel.ActionPanelListener
    public final void a(BitableProViewModel.ActionPanelListener.Action r5) {
        Intrinsics.checkNotNullParameter(r5, JSEventListener.ACTION);
        int r1 = d.a;
        Intrinsics.checkNotNullParameter(r5, JSEventListener.ACTION);
        JSONObject r0 = new JSONObject();
        int r2 = d.a.a[r5.ordinal()];
        if (r2 != 1) goto L5;
        r0.put("click", "known");
    L13:
        d.b("ccm_bitable_premium_permission_calculation_type_click", r0);
        if (r5 != BitableProViewModel.ActionPanelListener.Action.TO_UPGRADE) goto L22;
        BitableProViewModel r6 = this.a.D;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r6 = null;
    L18:
        BitableProViewModel.c r7 = r6.getDelegate();
        if (r7 == null) goto L23;
        ((BitableProPlugin.a) r7).a.upgradeSSC();
        return;
    L23:
        return;
    L22:
        return;
    L5:
        if (r2 != 2) goto L7;
        r0.put("click", "upgrade");
        goto L13
    L7:
        if (r2 != 3) goto L10;
        r0.put("click", "cancel");
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
