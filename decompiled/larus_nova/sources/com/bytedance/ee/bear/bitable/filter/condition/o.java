package com.bytedance.ee.bear.bitable.filter.condition;

import android.content.Context;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionCellView;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterOptions;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class o extends a<String[]> {
    @Override // com.bytedance.ee.bear.bitable.filter.condition.k
    public final List b(Object r110) {
        String[] r111 = (String[]) r110;
        String[] r100 = this.f211844b.getDisplayValue();
        int r101 = 0;
        String r102 = null;
        if (r100 != null) goto L5;
    L21:
        ArrayList r103 = new ArrayList();
        if (r111 != null) goto L24;
    L30:
        boolean r104 = true;
    L31:
        if (r104 == true) goto L33;
        ArrayList r105 = new ArrayList();
        int r106 = r111.length;
    L36:
        if (r101 >= r106) goto L39;
        r105.add(r111[r101]);
        r101 = r101 + 1;
        goto L36
    L39:
        if ((!r105.isEmpty()) == false) goto L41;
        r102 = yu5.c.l(r105, ", ");
    L41:
        r103.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(r102, this.f211848f, null, false, 12));
    L42:
        return r103;
    L33:
        if (m() == false) goto L42;
        r103.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(null, this.f211848f, null, false, 13));
        goto L42
    L24:
        if (r111.length != 0) goto L26;
        boolean r107 = true;
    L27:
        if (r107 == true) goto L30;
        r104 = false;
        goto L31
    L26:
        r107 = false;
        goto L27
    L5:
        if (r100.length != 0) goto L7;
        boolean r108 = true;
    L9:
        if ((!r108) == false) goto L14;
        if (r111 != null) goto L12;
    L13:
        boolean r109 = true;
    L15:
        if (r109 == true) goto L18;
        r100 = null;
    L18:
        if (r100 == null) goto L21;
        r111 = r100;
        goto L21
    L12:
        if (r100.length == r111.length) goto L13;
    L14:
        r109 = false;
        goto L15
    L7:
        r108 = false;
        goto L9
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

    public o(Context r100, FilterCondition r101, FilterOptions r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "condition");
        super(r100, r101, r102, r103);
    }
}
