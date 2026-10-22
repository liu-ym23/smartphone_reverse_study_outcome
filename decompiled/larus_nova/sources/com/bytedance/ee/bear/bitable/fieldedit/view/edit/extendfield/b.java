package com.bytedance.ee.bear.bitable.fieldedit.view.edit.extendfield;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendConfig;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendOrigin;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends ExtendFieldListView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f211398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExtendFieldTypeExtendFieldSelectionView f211399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FieldExtendConfig f211400c;

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.extendfield.ExtendFieldListView.b
    public final void c(View r100, ExtendFieldListView.a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (r101.f211358a.isChecked() == false) goto L5;
        Toast.showText(this.f211398a.getContext(), xo5.a.c(this.f211398a.getContext(), R.string.Bitable_PeopleField_FieldHasCreated_Tooltip, "fieldName", r101.f211358a.getFieldName()));
        return;
    L5:
        ExtendFieldTypeExtendFieldSelectionView r102 = this.f211399b;
        FieldExtendOrigin r103 = r102.f211396a;
        if (r103 == null) goto L12;
        FieldExtendConfig r104 = this.f211400c;
        ExtendFieldTypeExtendFieldSelectionView.a r105 = r102.getOnItemListener();
        if (r105 == null) goto L13;
        r105.a(r100, r103, r104, r101.f211358a);
        return;
    L13:
        return;
    }

    public b(View r100, ExtendFieldTypeExtendFieldSelectionView r101, FieldExtendConfig r102) {
        this.f211398a = r100;
        this.f211399b = r101;
        this.f211400c = r102;
    }
}
