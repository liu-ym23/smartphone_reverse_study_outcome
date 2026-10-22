package com.bytedance.ee.bear.bitable.filter.condition;

import android.content.Context;
import android.text.TextUtils;
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
public final class f extends a<Object> {
    @Override // com.bytedance.ee.bear.bitable.filter.condition.a, com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.c
    public final void a(ConditionView r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionView");
        super.a(r100);
        r100.setWarningInfoVisible(true);
        r100.setWarningInfo(getContext().getString(R.string.Bitable_Relation_FieldDeletedTip_Mobile));
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.k
    public final List<com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a> b(Object r100) {
        ArrayList r101 = new ArrayList();
        if (m() == false) goto L5;
        r101.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(null, this.f211848f, null, false, 13));
    L5:
        return r101;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.a, com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.c
    public final void d(ConditionCellView r100, int r110, ConditionListView.b r111) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r111, "conditionItem");
        super.d(r100, r110, r111);
        int r112 = 0;
        if (r110 != 0) goto L5;
        r100.setCellPlaceHolderText(getContext().getString(R.string.Bitable_Relation_FieldWasDeleted_Mobile));
        r100.setLeftIconVisible(false);
        return;
    L5:
        if (r110 != 1) goto L7;
        FilterCondition r113 = this.f211844b;
        FilterOptions r101 = this.f211845c;
        String r102 = null;
        if (r101 == null) goto L33;
        FilterFieldOption[] r103 = r101.getFieldOptions();
        if (r103 == null) goto L33;
        int r104 = r103.length;
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L23;
        FilterFieldOption r106 = r103[r105];
        if (r106.getFieldCompositeType().getType().getValue() != r113.getFieldType()) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == true) goto L24;
        r105 = r105 + 1;
    L24:
        if (r106 == null) goto L33;
        FilterFieldOption.OperatorOption[] r108 = r106.getAvaliableOperatorOption();
        if (r108 == null) goto L33;
        int r109 = r108.length;
    L28:
        if (r112 >= r109) goto L33;
        FilterFieldOption.OperatorOption r114 = r108[r112];
        if (TextUtils.equals(r114.getValue(), r113.getOperator()) == false) goto L32;
        r102 = r114.getText();
    L32:
        r112 = r112 + 1;
        goto L28
    L19:
        r107 = false;
        goto L20
    L23:
        r106 = null;
    L33:
        if (r102 != null) goto L35;
    L38:
        r100.setCellHintText(this.f211848f);
    L39:
        r100.setOnClickListener(new d(this));
        return;
    L35:
        if (TextUtils.isEmpty(r102) == true) goto L38;
        r100.setCellDisableText(r102);
        goto L39
    L7:
        if (r110 != 2) goto L49;
        r100.setCellDisableText(this.f211848f);
        r100.setOnClickListener(new e(this));
        return;
    }

    public f(Context r100, FilterCondition r101, FilterOptions r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "condition");
        super(r100, r101, r102, r103);
    }
}
