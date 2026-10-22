package com.bytedance.ee.bear.bitable.common.widgets.conditioncard;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConditionListView f209929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConditionListView.a f209930b;

    public e(ConditionListView r100, ConditionListView.a r101) {
        this.f209929a = r100;
        this.f209930b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ConditionListView.d r101 = this.f209929a.getOnConditionListener();
        if (r101 == null) goto L6;
        r101.ys(this.f209930b);
        return;
    }
}
