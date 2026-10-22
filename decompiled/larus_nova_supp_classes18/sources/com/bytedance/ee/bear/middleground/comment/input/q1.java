package com.bytedance.ee.bear.middleground.comment.input;

import android.text.Editable;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import java.util.ArrayList;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q1 implements View.OnClickListener {
    public final /* synthetic */ InputComment a;

    public q1(InputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a.i0.f == false) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.contract.j r5 = com.bytedance.ee.bear.contract.j.a.a;
        if (r5 != null) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == true) goto L14;
        Toast.showFailureText(this.a.s.getContext(), 2131887323);
        return;
    L14:
        Editable r7 = this.a.p.getText();
        if (r7 != null) goto L17;
    L20:
        boolean r8 = true;
    L21:
        if (r8 == true) goto L23;
    L24:
        InputComment r9 = this.a;
        r9.i0.f = true;
        r9.Q(false, null);
        return;
    L23:
        if ((!((ArrayList) this.a.i0.k).isEmpty()) == true) goto L24;
        return;
    L17:
        if (StringsKt.isBlank(r7) == true) goto L20;
        r8 = false;
        goto L21
    L8:
        if (r5.getNetworkState().a() != true) goto L10;
        r6 = true;
        goto L11
    }
}
