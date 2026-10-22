package com.bytedance.ee.bear.document.alert;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f0 implements View.OnClickListener {
    public final /* synthetic */ UDCheckBox a;
    public final /* synthetic */ AlertModel.RadioOptions b;
    public final /* synthetic */ Map<String, UDCheckBox> c;

    public f0(UDCheckBox r1, AlertModel.RadioOptions r2, Map<String, UDCheckBox> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        UDCheckBox r5 = this.a;
        if (r5 != null) goto L5;
        return;
    L5:
        String r0 = this.b.getId();
        if (r0 != null) goto L8;
        return;
    L8:
        r5.setChecked(true);
        Iterator<Map.Entry<String, UDCheckBox>> r6 = this.c.entrySet().iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        Map.Entry<String, UDCheckBox> r1 = r6.next();
        String r2 = r1.getKey();
        UDCheckBox r3 = r1.getValue();
        if (Intrinsics.areEqual(r2, r0) == true) goto L10;
        r3.setChecked(false);
        goto L10
    }
}
