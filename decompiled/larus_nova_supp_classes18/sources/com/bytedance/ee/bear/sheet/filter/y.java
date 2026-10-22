package com.bytedance.ee.bear.sheet.filter;

import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y implements FilterPanelColorView.c {
    public final /* synthetic */ OfficeSubFilterColorFragment a;

    @Override // com.bytedance.ee.bear.sheet.filter.FilterPanelColorView.c
    public final void a() {
        UDCheckBox r0 = this.a.p;
        FilterPanelColorView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
        r0 = null;
    L5:
        r0.setChecked(false);
        FilterPanelColorView r2 = this.a.s;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("foregroundColorView");
    L9:
        r1.setChecked(false);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public y(OfficeSubFilterColorFragment r1) {
        this.a = r1;
    }
}
