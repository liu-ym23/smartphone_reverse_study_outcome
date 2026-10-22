package com.bytedance.ee.bear.bitable.filter.condition;

import android.content.Context;
import android.widget.CompoundButton;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionCellView;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterOptions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class b extends a<Object> implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Object f211858p;

    @Override // com.bytedance.ee.bear.bitable.filter.condition.k
    public List<com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a> b(Object r110) {
        ArrayList r100 = new ArrayList();
        if (r110 == null) goto L5;
        this.f211858p = r110;
        if ((r110 instanceof List) == false) goto L13;
        if ((!((Collection) r110).isEmpty()) == false) goto L13;
        r110 = ListProtector.get((List) r110, 0);
    L26:
        if ((r110 instanceof Boolean) == false) goto L28;
        r100.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(String.valueOf(((Boolean) r110).booleanValue()), null, null, false, 14));
    L29:
        return r100;
    L28:
        r100.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a("false", null, null, false, 14));
    L13:
        if ((r110 instanceof Object[]) == false) goto L22;
        Object[] r101 = (Object[]) r110;
        if (r101.length != 0) goto L17;
        boolean r102 = true;
    L19:
        if ((true ^ r102) == false) goto L22;
        r110 = r101[0];
        goto L26
    L17:
        r102 = false;
    L22:
        if ((r110 instanceof Boolean) == true) goto L26;
        r110 = null;
        goto L26
    L5:
        if (m() == false) goto L29;
        r100.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(null, null, null, false, 14));
        goto L29
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        Boolean[] r102 = {Boolean.valueOf(r101)};
        if (Intrinsics.areEqual(this.f211844b.getValue(), r102) == true) goto L8;
        this.f211844b.setValue(r102);
        k.a r103 = this.f211849g;
        if (r103 == null) goto L9;
        r103.a(this.f211844b);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.a, com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.c
    public void d(ConditionCellView r100, int r101, ConditionListView.b r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "conditionItem");
        super.d(r100, r101, r102);
        boolean r103 = false;
        if (r101 != 1) goto L7;
        r100.setClickable(false);
        r100.setBackgroundColor(getContext().getResources().getColor(R.color.lkui_transparent));
        r100.setLeftIconVisible(false);
        r100.setRightIconVisible(false);
        return;
    L7:
        if (r101 != 2) goto L16;
        r100.setClickable(false);
        r100.setPadding(0, com.bytedance.ee.util.ui.n.d(6), 0, com.bytedance.ee.util.ui.n.d(6));
        r100.setBackgroundColor(getContext().getResources().getColor(R.color.lkui_transparent));
        r100.setLeftIconVisible(false);
        r100.setCellTextVisible(false);
        r100.setRightIconVisible(false);
        CharSequence r104 = r102.getTitle();
        r103 = Boolean.parseBoolean(String.valueOf(r104));     // Catch: Exception -> L11
    L12:
        this.f211844b.setValue(Boolean.valueOf(r103));
        r100.setCheckBoxChecked(r103);
        r100.setOnCheckBoxListener(this);
        return;
    L11:
        tt5.a.d("FilterConditionView", "onCellViewCreate fail title = " + r104);
        goto L12
    }

    public b(Context r100, FilterCondition r101, FilterOptions r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "condition");
        super(r100, r101, r102, r103);
    }
}
