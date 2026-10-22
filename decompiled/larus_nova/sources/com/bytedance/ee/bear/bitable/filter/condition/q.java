package com.bytedance.ee.bear.bitable.filter.condition;

import android.content.Context;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionCellView;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterOptions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class q extends a<Object> {
    @Override // com.bytedance.ee.bear.bitable.filter.condition.k
    public final List<com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a> b(Object r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L8;
        if (m() == false) goto L25;
        r101.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(null, this.f211848f, null, false, 13));
    L25:
        return r101;
    L8:
        if ((r100 instanceof List) == false) goto L13;
        if ((!((Collection) r100).isEmpty()) == false) goto L13;
        Object r102 = ListProtector.get((List) r100, 0);
    L23:
        if ((r102 instanceof String) == false) goto L25;
        r101.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a((CharSequence) r102, this.f211848f, null, false, 12));
    L13:
        if ((r100 instanceof Object[]) == false) goto L21;
        Object[] r103 = (Object[]) r100;
        if (r103.length != 0) goto L17;
        boolean r104 = true;
    L19:
        if ((!r104) == false) goto L21;
        r102 = r103[0];
        goto L23
    L17:
        r104 = false;
    L21:
        r102 = null;
        goto L23
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.a, com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.c
    public final void d(ConditionCellView r100, int r101, ConditionListView.b r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "conditionItem");
        super.d(r100, r101, r102);
        if (r101 != 2) goto L6;
        r100.setRightIconVisible(false);
        return;
    }

    public q(Context r100, FilterCondition r101, FilterOptions r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "condition");
        super(r100, r101, r102, r103);
    }
}
