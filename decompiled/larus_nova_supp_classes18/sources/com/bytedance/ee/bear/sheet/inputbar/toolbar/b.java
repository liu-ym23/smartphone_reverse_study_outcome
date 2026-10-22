package com.bytedance.ee.bear.sheet.inputbar.toolbar;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.sheet.inputbar.OfficeSheetEditFragment;
import com.bytedance.ee.bear.widgets.t;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import eu5.h;
import sbb.e;
import wm5.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends t {
    public final /* synthetic */ com.bytedance.ee.bear.sheet_core.inputbar.toolbar.ToolbarItemEnum c;
    public final /* synthetic */ ToolbarItemView d;
    public final /* synthetic */ int e;
    public final /* synthetic */ OfficeToolbarItemAdapter f;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r5) {
        if (this.c.adminLimit == true) goto L5;
        h.a(this.d.getContext(), 10, 50);
        this.f.y2(this.e);
    L5:
        OfficeToolbarItemAdapter.a r6 = this.f.a;
        if (r6 == null) goto L27;
        com.bytedance.ee.bear.sheet_core.inputbar.toolbar.ToolbarItemEnum r0 = this.c;
        d0 r7 = (d0) r6;
        if (r7.a == false) goto L14;
        if (r0.adminLimit == true) goto L12;
        OfficeSheetEditFragment.U90(r7.d, r0);
    L12:
        r7.b.getCallback().a(r7.d.getContext(), r7.b);
        return;
    L14:
        if (r0.adminLimit == true) goto L16;
        OfficeSheetEditFragment.U90(r7.d, r0);
        return;
    L16:
        OfficeSheetEditFragment r1 = r7.d;
        gj5.c r8 = r7.c;
        int r2 = OfficeSheetEditFragment.F;
        r1.getClass();
        int r9 = OfficeSheetEditFragment.a.a[r8.b.ordinal()];
        if (r9 != 1) goto L19;
        Toast.showText(r1.getContext(), 2131887246);
        return;
    L19:
        if (r9 != 2) goto L21;
        ((gj5.b) org.koin.java.a.a(gj5.b.class)).c("CCM_ATTACHMENT_UPLOAD", FileBizDomain.FileBizDomainCCM, e.l.b, "");
        return;
    L21:
        if (r9 == 3) goto L23;
        tt5.a.d("SheetEditFragment", "handleValidateSource : UnKnown type");
        return;
    L23:
        tt5.a.d("SheetEditFragment", "handleValidateSource validateResult: UNKNOWN");
        Toast.showText(r1.getContext(), 2131887246);
        return;
    }

    public b(OfficeToolbarItemAdapter r1, com.bytedance.ee.bear.sheet_core.inputbar.toolbar.ToolbarItemEnum r2, ToolbarItemView r3, int r4) {
        this.f = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }
}
