package com.bytedance.ee.bear.list.recent;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Document a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ a1.a c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public c1(Document r1, Context r2, a1.a r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = "recent";
        this.f = r5;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r10, int r11) {
        if (((a4) org.koin.java.a.c(a4.class, null, null, 6)).c(this.a.d) == false) goto L10;
        int r12 = a1.a;
        BearUDDialogBuilder r1 = new BearUDDialogBuilder(this.b);
        r1.a.title(2131889601);
        r1.a.titleSize(16);
        r1.a.titleGravity(8388611);
        r1.a.message(2131889603);
        r1.a.messageTextSize(14);
        r1.a.messageGravity(8388611);
        BearUDDialogBuilder.a r13 = new BearUDDialogBuilder.a();
        r13.a = 2131391778;
        r13.d = 2131106622;
        r13.b = 2131889600;
        r1.d(r13);
        Dialog r14 = r1.e();
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(r14);
    L9:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).s(r14);
    L11:
        lc5.f.a r15 = lc5.f.a;
        String r0 = this.d;
        if (r0 != null) goto L14;
        String r2 = "";
    L15:
        String r3 = this.e;
        Document r4 = this.a;
        String r5 = r4.d;
        int r6 = r4.getType();
        String r7 = this.a.F;
        String r8 = this.f;
        if (r8 != null) goto L18;
        String r9 = "";
    L19:
        r15.S(new lc5.v(r2, r3, r5, r6, r7, "delete", r9));
        return;
    L18:
        r9 = r8;
        goto L19
    L14:
        r2 = r0;
        goto L15
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L8:
        DialogLancet.beforeDialogShow(r14);
        r14.show();
        DialogLancet.afterDialogShow(r14);
        goto L9
    L10:
        this.c.S6(this.a);
        goto L11
    }
}
