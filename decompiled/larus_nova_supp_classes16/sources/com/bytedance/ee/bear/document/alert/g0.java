package com.bytedance.ee.bear.document.alert;

import android.content.DialogInterface;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Map<String, UDCheckBox> a;
    public final /* synthetic */ r b;
    public final /* synthetic */ AlertModel.ButtonsBean c;
    public final /* synthetic */ tb5.m d;

    public g0(Map<String, UDCheckBox> r1, r r2, AlertModel.ButtonsBean r3, tb5.m r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r10, int r11) {
        Map<String, UDCheckBox> r12 = this.a;
        AlertModel.ButtonsBean r13 = this.c;
        Iterator<Map.Entry<String, UDCheckBox>> r14 = r12.entrySet().iterator();
        String r7 = null;
    L4:
        if (r14.hasNext() == false) goto L8;
        Map.Entry<String, UDCheckBox> r0 = r14.next();
        String r1 = r0.getKey();
        if (r0.getValue().isChecked() == false) goto L4;
        tt5.a.h("OopsPopWindow", "showRadioDialog() ,click btn.id = " + r13.getId() + ",selectedOptionId: " + r1);
        r7 = r1;
        goto L4
    L8:
        r.c(this.b, this.c.getId(), null, this.d, this.c.isAutoDismiss(), null, r7, 16);
    }
}
