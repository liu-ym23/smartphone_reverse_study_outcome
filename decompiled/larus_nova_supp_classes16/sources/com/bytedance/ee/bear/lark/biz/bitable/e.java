package com.bytedance.ee.bear.lark.biz.bitable;

import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.create.q0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ BitableTabFragment a;
    public final /* synthetic */ int b;

    public e(BitableTabFragment r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r17) {
        DocumentCreateInfo r6 = (DocumentCreateInfo) r17;
        Intrinsics.checkNotNullParameter(r6, "documentCreateInfo");
        lc5.f.a r7 = lc5.f.a;
        String r9 = this.a.m6();
        String r12 = r6.b;
        String r13 = this.a.m6();
        String r14 = this.a.W9();
        String r16 = this.a.ba0();
        this.a.getClass();
        r7.q("lark_workspace_bitable_landing", r9, "new_base", "ccm_bitable_content_page_view", r12, r13, r14, r16);
        tt5.a.d("BitableTabFragment", "createBlankDocument createOnlineDocument()...success, type = " + this.b);
        BitableTabFragment r1 = this.a;
        String r5 = r6.d;
        if (r1.F == false) goto L5;
        String r2 = "base_hp_workbench_empty_base";
    L6:
        String r4 = r2;
        if (com.bytedance.ee.bear.bitable.c.j() == true) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L14;
        BitableTabFragment r8 = r1;
    L15:
        Toast.cancelLoading();
        q0.e(new com.bytedance.ee.bear.list.create.b(r1.getContext(), "tab_create", r4, r5, r6, r8));
        return;
    L14:
        r8 = null;
        goto L15
    L9:
        if (ForsetiHelper.s(r1) == false) goto L11;
        r3 = true;
        goto L12
    L5:
        r2 = "base_hp_larktab_empty_base";
        goto L6
    }
}
