package com.bytedance.ee.bear.bitable.common.widgets.item;

import android.view.View;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableCheckboxItemView f210016a;

    public a(BitableCheckboxItemView r100) {
        this.f210016a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UDCheckBox r101 = this.f210016a.f209978a;
        UDCheckBox r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("checkCB");
        r101 = null;
    L6:
        if (r101.isChecked() == false) goto L8;
        return;
    L8:
        UDCheckBox r103 = this.f210016a.f209978a;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("checkCB");
    L12:
        r102.setChecked(true);
        this.f210016a.getClass();
        return;
    L11:
        r102 = r103;
        goto L12
    }
}
