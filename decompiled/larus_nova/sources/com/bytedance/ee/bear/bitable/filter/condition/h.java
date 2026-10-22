package com.bytedance.ee.bear.bitable.filter.condition;

import android.content.Context;
import android.widget.CompoundButton;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionCellView;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionView;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.bitable.filter.model.FilterOptions;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h extends b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FilterFieldOption f211862q;

    public final boolean n() {
        FilterFieldOption r100 = this.f211857o;
        if (r100 == null) goto L5;
        EFieldType r101 = r100.getValueFieldType();
    L7:
        if (r101 != EFieldType.CHECKBOX) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    public final FilterFieldOption o() {
        FilterFieldOption r100 = this.f211862q;
        if (r100 == null) goto L5;
        return r100;
    L5:
        FilterFieldOption r101 = this.f211857o;
        if (r101 == null) goto L9;
        this.f211862q = r101;
        return r101;
    L9:
        FilterOptions r102 = this.f211845c;
        FilterFieldOption r103 = null;
        if (r102 == null) goto L20;
        FilterFieldOption[] r104 = r102.getFieldOptions();
        if (r104 == null) goto L20;
        if (r104.length != 0) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == true) goto L20;
        r103 = r104[0];
        goto L20
    L16:
        r105 = false;
    L20:
        this.f211862q = r103;
        return r103;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.a, com.bytedance.ee.bear.bitable.filter.condition.k
    public final FilterCondition g() {
        FilterFieldOption r100 = o();
        FilterCondition r101 = this.f211844b.copy();
        if (r100 == null) goto L9;
        FieldCompositeType r102 = r100.getFieldCompositeType();
        if (r102 == null) goto L9;
        EFieldType r103 = r102.getType();
        if (r103 == null) goto L9;
    L10:
        r101.setFieldType(r103.getValue());
        FilterFieldOption.OperatorOption r104 = p();
        if (r104 == null) goto L13;
        String r105 = r104.getValue();
    L14:
        r101.setOperator(r105);
        r101.setValue(null);
        return r101;
    L13:
        r105 = null;
    L9:
        r103 = EFieldType.NOT_SUPPORT;
        goto L10
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.a
    public final Integer j() {
        FilterFieldOption r100 = o();
        if (r100 == null) goto L6;
        FieldCompositeType r101 = r100.getFieldCompositeType();
        if (r101 == null) goto L6;
    L8:
        return Integer.valueOf(r101.getIcon());
    L6:
        r101 = new FieldCompositeType();
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.a
    public final String k() {
        FilterFieldOption.OperatorOption r100 = p();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getText();
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.a
    public final boolean l() {
        FilterFieldOption r100 = o();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isSync();
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.a
    public final boolean m() {
        FilterFieldOption.OperatorOption r100 = p();
        if (r100 == null) goto L5;
        String r101 = r100.getValue();
    L7:
        return !com.bytedance.ee.bear.bitable.filter.model.a.a(r101);
    L5:
        r101 = null;
        goto L7
    }

    public final FilterFieldOption.OperatorOption p() {
        FilterFieldOption r100 = o();
        if (r100 != null) goto L5;
        return null;
    L5:
        FilterFieldOption.OperatorOption[] r101 = r100.getAvaliableOperatorOption();
        boolean r102 = true;
        if (r101 != null) goto L8;
    L14:
        if (r102 == false) goto L16;
        return null;
    L16:
        return r101[0];
    L8:
        if (r101.length != 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L14;
        r102 = false;
        goto L14
    L10:
        r103 = false;
        goto L11
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.a, com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.c
    public final void a(ConditionView r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionView");
        super.a(r100);
        r100.setWarningInfoVisible(true);
        r100.setWarningInfo(getContext().getString(R.string.Bitable_Relation_FieldTypeChangedTip_Mobile));
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.b, com.bytedance.ee.bear.bitable.filter.condition.k
    public final List<com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a> b(Object r100) {
        if (n() == true) goto L5;
        ArrayList r101 = new ArrayList();
        if (m() == false) goto L9;
        r101.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(null, this.f211848f, null, false, 13));
    L9:
        return r101;
    L5:
        return super.b(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.b, android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        ConditionView r102 = this.f211847e;
        if (r102 == null) goto L6;
        r102.setWarningInfoVisible(false);
    L6:
        if (n() == true) goto L8;
        return;
    L8:
        FilterFieldOption r103 = o();
        if (r103 == null) goto L15;
        this.f211844b.setFieldType(r103.getFieldCompositeType().getType().getValue());
        FilterCondition r104 = this.f211844b;
        FilterFieldOption.OperatorOption r105 = p();
        if (r105 == null) goto L13;
        String r106 = r105.getValue();
    L14:
        r104.setOperator(r106);
        goto L15
    L13:
        r106 = null;
    L15:
        super.onCheckedChanged(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.b, com.bytedance.ee.bear.bitable.filter.condition.a, com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.c
    public final void d(ConditionCellView r100, int r101, ConditionListView.b r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "conditionItem");
        if (n() == false) goto L7;
        super.d(r100, r101, r102);
        return;
    L7:
        if (r101 != 1) goto L9;
        String r103 = k();
        if (r103 == null) goto L20;
        r100.setCellText(r103);
        return;
    L20:
        return;
    L9:
        if (r101 != 2) goto L21;
        r100.setCellDisableText(this.f211848f);
        if (o() != null) goto L18;
        r100.setOnClickListener(new g(this));
        return;
    L18:
        return;
    }

    public h(Context r100, FilterCondition r101, FilterOptions r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "condition");
        super(r100, r101, r102, r103);
    }
}
