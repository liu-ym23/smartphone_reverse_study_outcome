package com.bytedance.ee.bear.sheet.filter;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ FilterPanelColorView a;

    public l(FilterPanelColorView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        UDCheckBox r6 = this.a.b;
        UDCheckBox r0 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r6 = null;
    L5:
        boolean r7 = r6.isChecked();
        UDCheckBox r2 = this.a.b;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r2 = null;
    L8:
        r2.setChecked(!r7);
        UDCheckBox r8 = this.a.b;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r8 = null;
    L12:
        if (r8.isChecked() == true) goto L18;
        UDCheckBox r9 = this.a.b;
        if (r9 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
    L17:
        r0.setChecked(true);
        return;
    L16:
        r0 = r9;
        goto L17
    L18:
        FilterPanelColorView.c r10 = this.a.getOnCheckedChangeListener();
        if (r10 == null) goto L23;
        r10.a();
        return;
    }
}
