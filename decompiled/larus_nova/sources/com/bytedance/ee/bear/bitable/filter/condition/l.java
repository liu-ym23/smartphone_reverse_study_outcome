package com.bytedance.ee.bear.bitable.filter.condition;

import android.content.Context;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionView;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterOptions;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class l extends a<Object> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f211865p;

    @Override // com.bytedance.ee.bear.bitable.filter.condition.a, com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.a
    public final List<ConditionListView.b> e() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.a, com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.c
    public final void a(ConditionView r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionView");
        super.a(r100);
        boolean r101 = true;
        if (this.f211865p <= 1) goto L5;
        String r102 = xo5.a.c(getContext(), R.string.Bitable_AdvancedPermission_NoPermToAccessFieldDueToInaccessibleNumFilterCondition, "num", String.valueOf(this.f211846d));
    L6:
        Intrinsics.checkNotNull(r102);
        r100.setConditionTitle(r102);
        int r103 = com.bytedance.ee.util.ui.n.f(getContext(), 16);
        r100.setPadding(r103, r103, r103, r103);
        if (this.f211865p > 1) goto L10;
        r101 = false;
    L10:
        r100.setConditionCloseVisible(r101);
        return;
    L5:
        r102 = getContext().getString(R.string.Bitable_AdvancedPermission_NoPermToAccessFieldDueToInaccessibleFilterCondition_Tooltip);
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.k
    public final List<com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a> b(Object r100) {
        return CollectionsKt.emptyList();
    }

    public l(Context r100, FilterCondition r101, FilterOptions r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "condition");
        super(r100, r101, r102, r103);
        this.f211865p = r104;
    }
}
