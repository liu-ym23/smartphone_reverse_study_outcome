package com.bytedance.ee.bear.sheet.exportimage.preview;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareView;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ SheetImagePreviewFragment a;

    public b(SheetImagePreviewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        Boolean r8 = (Boolean) r7;
        ExternalShareView r0 = this.a.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r8, Boolean.TRUE) == false) goto L19;
        SheetImagePreviewFragment r9 = this.a;
        xu5.b.a r3 = r9.g;
        if (r3 == null) goto L9;
        r3.d(2131100548, true);
    L9:
        BaseTitleBar r4 = r9.i;
        if (r4 == null) goto L12;
        r4.setBackgroundColor(r9.getResources().getColor(2131100548));
    L12:
        BaseTitleBar r5 = r9.i;
        if (r5 == null) goto L15;
        r5.setMainTitleColor(r9.getResources().getColor(2131106622));
    L15:
        BaseTitleBar r10 = r9.i;
        if (r10 == null) goto L18;
        r10.setActionIconTint(2131102418);
    L18:
        cj5.c r11 = (cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6);
        SheetImagePreviewFragment r1 = this.a;
        r11.H9(r1, SharePanelState.SHOWING, r1.U90());
        int r12 = 0;
    L20:
        r0.setVisibility(r12);
        return;
    L19:
        cj5.c r13 = (cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6);
        SheetImagePreviewFragment r2 = this.a;
        r13.H9(r2, SharePanelState.NOT_SHOW, r2.U90());
        r12 = 4;
        goto L20
    }
}
