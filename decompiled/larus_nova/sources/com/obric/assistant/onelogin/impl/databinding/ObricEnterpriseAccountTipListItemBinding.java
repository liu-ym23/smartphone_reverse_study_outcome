package com.obric.assistant.onelogin.impl.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.dialog.v2.common.ODialogListItemView;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricEnterpriseAccountTipListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ODialogListItemView f390937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ODialogListItemView f390938b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f390937a;
    }

    public static ObricEnterpriseAccountTipListItemBinding a(View r100) {
        ODialogListItemView r101 = (ODialogListItemView) r100;
        return new ObricEnterpriseAccountTipListItemBinding(r101, r101);
    }

    public ObricEnterpriseAccountTipListItemBinding(ODialogListItemView r100, ODialogListItemView r101) {
        this.f390937a = r100;
        this.f390938b = r101;
    }
}
