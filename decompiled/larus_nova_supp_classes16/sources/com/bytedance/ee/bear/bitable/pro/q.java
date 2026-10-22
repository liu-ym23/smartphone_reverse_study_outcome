package com.bytedance.ee.bear.bitable.pro;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q<T> implements Observer {
    public final /* synthetic */ BitableProFragment a;

    public q(BitableProFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        Boolean r8 = (Boolean) r7;
        BitableProViewModel r0 = this.a.D;
        BitableProViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        Boolean r2 = (Boolean) r0.getIsPro().getValue();
        tt5.a.b(this.a.v, "oprate result " + r8 + ' ' + r2);
        if (r2 == null) goto L35;
        if (r8 != null) goto L9;
        return;
    L9:
        if (r8.booleanValue() == true) goto L11;
        Toast.cancelLoading();
        if (r2.booleanValue() == true) goto L33;
        final BitableProFragment r9 = this.a;
        r9.la0(2131886097, new BitableProFragment$observeUpgradeProSuccess$1$1(r9));
        return;
    L33:
        final BitableProFragment r10 = this.a;
        r10.la0(2131886096, new BitableProFragment$observeUpgradeProSuccess$1$2(r10));
        return;
    L11:
        if (r2.booleanValue() == false) goto L29;
        int r11 = d.a;
        JSONObject r12 = new JSONObject();
        r12.put(JSEventListener.ACTION, "open");
        d.b("ccm_bitable_premium_permission_entrance", r12);
        final BitableProFragment r13 = this.a;
        if (r13.E == false) goto L20;
        r13.E = false;
        BitableProViewModel r3 = r13.D;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        r1.removeAllMembers(new BitableProFragment$removeAllMembers$1(r13));
        return;
    L17:
        r1 = r3;
        goto L18
    L20:
        if (r13.L == true) goto L22;
    L28:
        Toast.cancelLoading();
        BitableProFragment.Y90(this.a, 2131886101, 2131256306);
        return;
    L22:
        if (r13.M == false) goto L28;
        r13.M = false;
        BitableProViewModel r14 = r13.D;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L27:
        r1.fetchProData();
        goto L28
    L26:
        r1 = r14;
        goto L27
    L29:
        Toast.cancelLoading();
        BitableProFragment.Y90(this.a, 2131886100, 2131256306);
        return;
    }
}
