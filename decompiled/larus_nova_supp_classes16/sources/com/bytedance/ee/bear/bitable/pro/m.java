package com.bytedance.ee.bear.bitable.pro;

import androidx.lifecycle.Observer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ BitableProFragment a;

    public m(BitableProFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        PermEffectFieldData r7 = (PermEffectFieldData) r6;
        BitableProViewModel r0 = this.a.D;
        ArrayList<PermEffectFieldData.IEffectFormulaDetailInfo> r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        boolean r4 = true;
        if (r0.getUpdateStatus().getValue() != PermissionUpdateStatus.ReadyToUpdate) goto L13;
        BitableProFragment r1 = this.a;
        if (r7 == null) goto L12;
        PermEffectFieldData.IEffectFormulaInfo r8 = r7.getEffectFormulaInfo();
        if (r8 == null) goto L12;
        r2 = r8.getFormulaInfo();
    L12:
        BitableProFragment.X90(r1, true, r2);
        return;
    L13:
        BitableProViewModel r3 = this.a.D;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L17:
        if (r3.getUpdateStatus().getValue() != PermissionUpdateStatus.Updated) goto L33;
        sk5.c r5 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        if (r5 != null) goto L21;
    L23:
        r4 = false;
    L24:
        if (r4 == false) goto L34;
        BitableProFragment r9 = this.a;
        if (r7 == null) goto L30;
        PermEffectFieldData.IEffectFormulaInfo r10 = r7.getEffectFormulaInfo();
        if (r10 == null) goto L30;
        r2 = r10.getFormulaInfo();
    L30:
        BitableProFragment.X90(r9, false, r2);
        return;
    L34:
        return;
    L21:
        if (r5.f("bitable_permission_upgrade_ssc") == true) goto L23;
    }
}
