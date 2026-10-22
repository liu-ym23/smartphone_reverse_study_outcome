package com.bytedance.ee.bear.list;

import android.app.Activity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.util.io.FileUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s0 implements com.bytedance.ee.bear.contract.c0.b {
    public final /* synthetic */ Activity a;

    public s0(Activity r1) {
        this.a = r1;
    }

    public final void a(boolean r2) {
        if (r2 == true) goto L4;
        return;
    L4:
        if (com.bytedance.ee.util.ui.b.a(this.a) == true) goto L7;
        tt5.a.d("DocumentUtils", "onDownloadStatusChange(), activity isFinishing()");
        return;
    L7:
        Toast.showText(this.a, 2131887754);
    }

    public final void b(final Document r4, long r5, final kd5.b2 r7) {
        if (com.bytedance.ee.util.ui.b.a(this.a) == true) goto L6;
        tt5.a.d("DocumentUtils", "onManualOfflineDoc(), activity isFinishing()");
        return;
    L6:
        String r0 = this.a.getString(2131887791);
        String r6 = xo5.a.c(this.a, 2131887796, "size", FileUtils.A(r5));
        Activity r8 = this.a;
        Intrinsics.checkNotNullParameter(r8, "context");
        UDDialogBuilder r1 = new UDDialogBuilder(r8);
        r1.autoDismiss(true);
        Intrinsics.checkNotNullParameter(r0, "value");
        r1.title(r0);
        Intrinsics.checkNotNullParameter(r6, "value");
        r1.message(r6);
        r1.messageGravity(8388611);
        BearUDDialogBuilder.ActionBottomOrientation r9 = BearUDDialogBuilder.ActionBottomOrientation.VERTICAL;
        Intrinsics.checkNotNullParameter(r9, "value");
        if (r9 != BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL) goto L9;
        UDBaseDialogBuilder.ActionBottomOrientation r10 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
    L10:
        r1.actionButtonOrientation(r10);
        r1.addActionButton(2131391777, 2131887799, new q0(r7, r4));
        r1.addActionButton(2131391778, 2131887797, new r0(r7, r4));
        r1.addActionButton(2131391779, 2131887716, null);
        UDDialog r11 = r1.build();
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r11);
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        return;
    L9:
        r10 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
        goto L10
    }
}
