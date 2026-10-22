package com.bytedance.ee.bear.sheet.filter;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ FilterPanelColorView a;

    public m(FilterPanelColorView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        UDCheckBox r4 = this.a.b;
        UDCheckBox r0 = null;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r4 = null;
    L6:
        if (r4.isChecked() == true) goto L12;
        UDCheckBox r5 = this.a.b;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
    L11:
        r0.setChecked(true);
        return;
    L10:
        r0 = r5;
        goto L11
    L12:
        FilterPanelColorView.c r6 = this.a.getOnCheckedChangeListener();
        if (r6 == null) goto L17;
        r6.a();
        return;
    }
}
