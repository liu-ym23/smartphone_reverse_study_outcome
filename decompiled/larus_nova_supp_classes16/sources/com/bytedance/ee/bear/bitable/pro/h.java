package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.pro.accessconfig.DefaultAccessConfig;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ BitableProFragment a;
    public final /* synthetic */ int b;

    public h(BitableProFragment r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r8) {
        DefaultAccessConfig r9 = (DefaultAccessConfig) r8;
        if (r9 != null) goto L5;
    L7:
        int r0 = 8;
        if (r9 != null) goto L10;
    L62:
        this.a.aa0().setVisibility(8);
        return;
    L10:
        if (r9.isSystemRole() == true) goto L62;
        this.a.aa0().setVisibility(0);
        Context r1 = this.a.getContext();
        com.bytedance.ee.bear.document.bitable.c r3 = null;
        if (r1 == null) goto L14;
        String r2 = r1.getString(2131886222);
    L15:
        DefaultConfig r4 = r9.getDefaultConfig();
        if (r4 == null) goto L30;
        BitableProFragment r5 = this.a;
        if (r4.isValid() == false) goto L30;
        if (r4.getAccessStrategy() != 0) goto L25;
        Context r6 = r5.getContext();
        if (r6 == null) goto L29;
        r2 = r6.getString(2131886215);
    L29:
        r2 = null;
        goto L30
    L25:
        if (r4.getAccessStrategy() != 1) goto L30;
        Role r7 = r4.getBindRole();
        if (r7 == null) goto L29;
        r2 = r7.getName();
    L30:
        this.a.ca0().setText(r2);
        int r10 = this.b;
        int r11 = com.bytedance.ee.bear.bitable.core.usercomponent.d.a;
        Intrinsics.checkNotNullParameter("bitable.big.screen.impro.disable", "key");
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("bitable.big.screen.impro.disable") == true) goto L34;
        r10 = (this.a.ha0().getWidth() - y9c.d.a(64)) / y9c.d.a(40);
    L34:
        if (r10 <= 0) goto L48;
        ArrayList<MultiItemEntity> r12 = r9.getMemberList(r10);
        RecyclerView r13 = this.a.ea0();
        com.bytedance.ee.bear.document.bitable.c r14 = this.a.B;
        if (r14 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("proInfo");
        r14 = null;
    L39:
        if (r14.a == false) goto L41;
    L44:
        r13.setVisibility(r0);
        BaseQuickAdapter r16 = this.a.H;
        if (r16 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("defaultMemberAdapter");
        r16 = null;
    L47:
        r16.setNewData(r12);
        goto L48
    L41:
        if (r12.isEmpty() == true) goto L44;
        r0 = 0;
    L48:
        BitableProViewModel r17 = this.a.D;
        if (r17 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r17 = null;
    L51:
        Boolean r18 = (Boolean) r17.getIsPro().getValue();
        BitableProFragment r19 = this.a;
        if (r19.G == false) goto L65;
        com.bytedance.ee.bear.document.bitable.c r20 = r19.B;
        if (r20 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("proInfo");
    L58:
        if (r3.a == false) goto L60;
        return;
    L60:
        if (Intrinsics.areEqual(r18, Boolean.TRUE) == false) goto L67;
        BitableProFragment r21 = this.a;
        r21.G = false;
        BitableProFragment.W90(r21);
        return;
    L67:
        return;
    L56:
        r3 = r20;
        goto L58
    L65:
        return;
    L14:
        r2 = null;
        goto L15
    L5:
        if (r9.isSystemRole() == false) goto L7;
        BitableProFragment r22 = this.a;
        int r23 = BitableProFragment.N;
        r22.ka0();
    }
}
