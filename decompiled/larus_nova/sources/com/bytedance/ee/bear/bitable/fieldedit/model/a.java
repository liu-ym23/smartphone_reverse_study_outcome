package com.bytedance.ee.bear.bitable.fieldedit.model;

import android.text.TextUtils;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionCellView;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionView;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.selectField.DynamicPropertyEditViewHolder;
import com.bytedance.ee.bear.bitable.fieldedit.viewmodel.DynamicFieldViewModel;
import com.bytedance.ee.bear.bitable.fieldedit.viewmodel.d;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.bitable.filter.model.SelectFieldCondition;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements ConditionListView.a, ConditionListView.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f211140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SelectFieldCondition f211141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f211142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f211143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f211144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f211145f;

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.a
    public final /* synthetic */ String getCallbackId() {
        throw null;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.a
    public final List<ConditionListView.b> e() {
        ArrayList r100 = new ArrayList();
        ((ArrayList) this.f211142c).clear();
        boolean r101 = false;
        this.f211143d = false;
        String r102 = this.f211141b.getFieldId();
        FilterFieldOption r103 = null;
        if (r102 == null) goto L16;
        FilterFieldOption r104 = this.f211140a.getConditionTargetFieldById(r102);
        if (r104.isPartialDenied() == null) goto L8;
        this.f211144e = Boolean.valueOf(r104.isDeniedField());
    L8:
        if ((r104 instanceof DynamicFieldViewModel.DeleteField) == false) goto L13;
        String r105 = r104.getId();
        if (r105 == null) goto L17;
        ((ArrayList) this.f211142c).add(r105);
    L17:
        r100.add(new FieldConditionCell(r104, R.string.Bitable_SingleOption_FieldInTargetTable));
        if (this.f211145f == true) goto L20;
    L22:
        r100.add(new OperatorConditionCell(this.f211140a.getOperatorByCondition(this.f211141b)));
        if (com.bytedance.ee.bear.bitable.filter.model.a.a(this.f211141b.getOperator()) == true) goto L32;
        String r106 = this.f211141b.getValue();
        if (r106 == null) goto L31;
        r103 = this.f211140a.getConditionCurrentFieldById(r106);
        if ((r103 instanceof DynamicFieldViewModel.DeleteField) == false) goto L31;
        String r107 = r103.getId();
        if (r107 == null) goto L31;
        ((ArrayList) this.f211142c).add(r107);
    L31:
        r100.add(new FieldConditionCell(r103, R.string.Bitable_SingleOption_FieldInCurrentTable));
    L32:
        return r100;
    L20:
        if (Intrinsics.areEqual(this.f211144e, Boolean.TRUE) == false) goto L22;
        return null;
    L13:
        if (r104.getFieldCompositeType().getType().getValue() == this.f211141b.getFieldType()) goto L15;
        r101 = true;
    L15:
        this.f211143d = r101;
        goto L17
    L16:
        r104 = null;
        goto L17
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.c
    public final void a(ConditionView r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionView");
        int r101 = this.f211140a.mo8313getConditionList().indexOf(this) + 1;
        int r102 = this.f211140a.mo8313getConditionList().size();
        if (this.f211145f == true) goto L5;
    L10:
        r100.setConditionTitle(UIHelper.mustacheFormat(R.string.Bitable_SingleOption_DefaultConditionName_Mobile, "num", String.valueOf(r101)));
        if ((!this.f211142c.isEmpty()) == false) goto L13;
    L16:
        r100.setWarningInfo(UIHelper.getString(R.string.Bitable_SingleOption_ConditionSettingsChangedTip_Mobile));
        return;
    L13:
        if (this.f211143d == true) goto L16;
        r100.setWarningInfoVisible(false);
        return;
    L5:
        if (Intrinsics.areEqual(this.f211144e, Boolean.TRUE) == false) goto L10;
        if (r102 <= 1) goto L8;
        String r103 = UIHelper.mustacheFormat(R.string.Bitable_AdvancedPermission_NoPermToAccessFieldDueToInaccessibleNumReferenceCondition, "num", String.valueOf(r101));
    L9:
        Intrinsics.checkNotNull(r103);
        r100.setConditionTitle(r103);
        int r104 = n.d(16);
        r100.setPadding(r104, r104, r104, r104);
        return;
    L8:
        r103 = r100.getContext().getString(R.string.Bitable_AdvancedPermission_NoPermToAccessFieldDueToInaccessibleReferencedData_Tooltip);
        goto L9
    }

    public a(DynamicFieldViewModel r100, SelectFieldCondition r101) {
        Intrinsics.checkNotNullParameter(r100, "fieldDataSource");
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterSheetItem.Id.FILTER_CONDITION);
        this.f211140a = r100;
        this.f211141b = r101;
        this.f211142c = new ArrayList();
        this.f211145f = c.a.f206237a.h("ccm.bitable.mobile.support_remote_compute");
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.c
    public final void d(ConditionCellView r100, int r101, ConditionListView.b r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "conditionItem");
        if (this.f211145f == false) goto L6;
        int r103 = DynamicPropertyEditViewHolder.f211531o;
        r100.setCellDisable(DynamicPropertyEditViewHolder.a.a(this.f211140a.getTargetTable(), this.f211140a.getTargetField()));
    L6:
        if (r101 != 0) goto L14;
        FieldEditPanelData.TableBean r104 = this.f211140a.getTargetTable();
        if (r104 != null) goto L10;
    L12:
        boolean r105 = false;
    L13:
        r100.setEnabled(!r105);
        goto L14
    L10:
        if (r104.getReadPerimission() == true) goto L12;
        r105 = true;
    L14:
        if (r101 != 1) goto L17;
        r100.setEnabled(!TextUtils.isEmpty(this.f211141b.getFieldId()));
        return;
    }
}
