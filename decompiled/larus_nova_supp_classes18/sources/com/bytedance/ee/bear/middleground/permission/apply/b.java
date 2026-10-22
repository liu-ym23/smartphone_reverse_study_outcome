package com.bytedance.ee.bear.middleground.permission.apply;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ ApplyAuditEscapePanel c;

    public b(ApplyAuditEscapePanel r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r8) {
        ApplyAuditEscapePanel r9 = this.c;
        int r0 = ApplyAuditEscapePanel.m;
        r9.getClass();
        tt5.a.h("ApplyAuditEscapePanel", "sendRequest()...");
        UDEditText r1 = r9.h;
        if (r1 != null) goto L9;
        View r2 = r9.getView();
        if (r2 == null) goto L7;
        r1 = r2.findViewById(2131381012);
    L8:
        r9.h = (SpaceEditText) r1;
        goto L9
    L7:
        r1 = null;
    L9:
        Editable r3 = ((SpaceEditText) r1).getText();
        String r4 = "";
        if (r3 == null) goto L13;
        String r5 = r3.toString();
        if (r5 == null) goto L13;
    L14:
        String r6 = r9.j;
        if (r6 == null) goto L18;
        r4 = r6;
    L18:
        NetService r7 = (NetService) e0c.k.a(LarkContext.getApplication(), NetService.class);
        Context r10 = r9.getContext();
        Context r11 = r9.getContext();
        if (r11 == null) goto L21;
        String r12 = r11.getString(2131889694);
    L22:
        Toast.showLoading(r10, r12);
        a r13 = r9.k;
        int r14 = r9.i;
        r13.getClass();
        r9.l.add(a.b(r4, r14, r5, 2, r7).observeOn(fo5.d.e()).subscribeOn(fo5.d.d()).subscribe(new d(r9), new e(r9)));
        com.bytedance.ee.bear.middleground.permission.c.f(r5, "admin_forbidden", null);
        return;
    L21:
        r12 = null;
    L13:
        r5 = "";
        goto L14
    }
}
