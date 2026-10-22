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
public final class n extends a<Object> {
    @Override // com.bytedance.ee.bear.bitable.filter.condition.a, com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.a
    public final List<ConditionListView.b> e() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.a, com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.c
    public final void a(ConditionView r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionView");
        super.a(r100);
        r100.setWarningInfoVisible(true);
        r100.setWarningInfo(getContext().getString(R.string.Bitable_Record_FieldNotSupported));
        r100.setConditionCloseVisible(false);
    }

    @Override // com.bytedance.ee.bear.bitable.filter.condition.k
    public final List<com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a> b(Object r100) {
        return CollectionsKt.emptyList();
    }

    public n(Context r100, FilterCondition r101, FilterOptions r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "condition");
        super(r100, r101, r102, r103);
    }
}
