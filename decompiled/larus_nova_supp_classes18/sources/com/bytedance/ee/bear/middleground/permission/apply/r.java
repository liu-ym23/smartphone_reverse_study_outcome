package com.bytedance.ee.bear.middleground.permission.apply;

import android.text.Editable;
import android.view.View;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.edittext.UDEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ ApplyPermissionPanel c;

    public r(ApplyPermissionPanel r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r10) {
        ApplyPermissionPanel r11 = this.c;
        int r0 = ApplyPermissionPanel.p;
        r11.getClass();
        tt5.a.h("ApplyPermissionPanel", "sendRequest()...");
        boolean r1 = true;
        r11.o = true;
        UDEditText r2 = r11.h;
        String r3 = null;
        if (r2 != null) goto L9;
        View r4 = r11.getView();
        if (r4 == null) goto L7;
        r2 = r4.findViewById(2131381012);
    L8:
        r11.h = (SpaceEditText) r2;
        goto L9
    L7:
        r2 = null;
    L9:
        Editable r5 = ((SpaceEditText) r2).getText();
        if (r5 == null) goto L13;
        String r6 = r5.toString();
        if (r6 == null) goto L13;
    L14:
        ApplyDocPermPuller r7 = new ApplyDocPermPuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        String r8 = r11.j;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException(ResourceData.KEY_TOKEN);
        r8 = null;
    L17:
        r11.n.add(r7.a(new ApplyDocPermPuller.Params(r8, String.valueOf(r11.i), r6, String.valueOf(PermApplyViewModel.PermType.EDIT.getCode()))).subscribe(new t(r11, r6), new u(r11, r6)));
        String r9 = r11.j;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException(ResourceData.KEY_TOKEN);
        r9 = null;
    L21:
        if (r11.i == sbb.e.q.b) goto L24;
        r1 = false;
    L24:
        if (r1 == false) goto L26;
        r3 = r9;
    L26:
        com.bytedance.ee.bear.middleground.permission.c.f(r6, "apply_permission", r3);
        return;
    L13:
        r6 = "";
        goto L14
    }
}
