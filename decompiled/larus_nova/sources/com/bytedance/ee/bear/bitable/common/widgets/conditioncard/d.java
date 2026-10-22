package com.bytedance.ee.bear.bitable.common.widgets.conditioncard;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements ConditionView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConditionListView f209927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConditionListView.a f209928b;

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionView.b
    public final void onRemove() {
        ConditionListView r100 = this.f209927a;
        if (r100.f209904a == null) goto L8;
        ConditionListView.a r101 = this.f209928b;
        ConditionListView.d r102 = r100.getOnConditionListener();
        if (r102 == null) goto L9;
        r102.YS(r101);
        return;
    L9:
        return;
    }

    public d(ConditionListView r100, ConditionListView.a r101) {
        this.f209927a = r100;
        this.f209928b = r101;
    }
}
