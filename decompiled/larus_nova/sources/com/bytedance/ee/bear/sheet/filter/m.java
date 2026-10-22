package com.bytedance.ee.bear.sheet.filter;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterPanelColorView f237863a;

    public m(FilterPanelColorView r100) {
        this.f237863a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UDCheckBox r101 = this.f237863a.f237696b;
        UDCheckBox r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r101 = null;
    L6:
        if (r101.isChecked() == true) goto L12;
        UDCheckBox r103 = this.f237863a.f237696b;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
    L11:
        r102.setChecked(true);
        return;
    L10:
        r102 = r103;
        goto L11
    L12:
        FilterPanelColorView.c r104 = this.f237863a.getOnCheckedChangeListener();
        if (r104 == null) goto L17;
        r104.a();
        return;
    }
}
