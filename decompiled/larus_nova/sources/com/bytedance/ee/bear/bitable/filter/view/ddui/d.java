package com.bytedance.ee.bear.bitable.filter.view.ddui;

import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements ConditionListView.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterInfoViewV2 f212096a;

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.d
    public final void ys(ConditionListView.a r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionConfig");
    }

    public d(FilterInfoViewV2 r100) {
        this.f212096a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.d
    public final void Cj(ConditionListView.b r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionItem");
        Function1<? super String, Unit> r101 = this.f212096a.f212091g;
        if (r101 == null) goto L6;
        r101.invoke(r100.getCallbackId());
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.d
    public final void YS(ConditionListView.a r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionConfig");
        if ((r100 instanceof cs4.a) == false) goto L5;
        cs4.a r101 = (cs4.a) r100;
    L6:
        if (r101 == null) goto L11;
        Function1<? super String, Unit> r102 = this.f212096a.f212091g;
        if (r102 == null) goto L12;
        r102.invoke(r101.getCallbackId());
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.d
    public final void Fi(ConditionListView.a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "conditionConfig");
        List<ConditionListView.b> r102 = r100.e();
        if (r102 != null) goto L5;
    L11:
        tt5.a.d("FilterInfoView", "onConditionItemClick, index over size");
        return;
    L5:
        if (r102.size() <= r101) goto L11;
        ConditionListView.b r103 = (ConditionListView.b) ListProtector.get(r102, r101);
        Function1<? super String, Unit> r104 = this.f212096a.f212091g;
        if (r104 == null) goto L13;
        r104.invoke(r103.getCallbackId());
        return;
    }
}
