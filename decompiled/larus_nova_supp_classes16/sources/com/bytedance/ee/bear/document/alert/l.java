package com.bytedance.ee.bear.document.alert;

import android.text.TextUtils;
import android.widget.TextView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l implements UDCheckBox.c {
    public final /* synthetic */ AlertModel.RadioOptions a;
    public final /* synthetic */ TextView b;

    public l(AlertModel.RadioOptions r1, TextView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(UDCheckBox r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        if (TextUtils.isEmpty(this.a.getInfo()) == true) goto L11;
        TextView r4 = this.b;
        if (r4 == null) goto L12;
        if (r3 == false) goto L8;
        int r5 = 0;
    L9:
        r4.setVisibility(r5);
        return;
    L8:
        r5 = 8;
        goto L9
    L12:
        return;
    }
}
