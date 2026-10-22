package com.bytedance.ee.bear.sheet.filter;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterPanelColorView f237862a;

    public l(FilterPanelColorView r100) {
        this.f237862a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UDCheckBox r101 = this.f237862a.f237696b;
        UDCheckBox r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r101 = null;
    L5:
        boolean r103 = r101.isChecked();
        UDCheckBox r104 = this.f237862a.f237696b;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r104 = null;
    L8:
        r104.setChecked(!r103);
        UDCheckBox r105 = this.f237862a.f237696b;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        r105 = null;
    L12:
        if (r105.isChecked() == true) goto L18;
        UDCheckBox r106 = this.f237862a.f237696b;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
    L17:
        r102.setChecked(true);
        return;
    L16:
        r102 = r106;
        goto L17
    L18:
        FilterPanelColorView.c r107 = this.f237862a.getOnCheckedChangeListener();
        if (r107 == null) goto L23;
        r107.a();
        return;
    }
}
