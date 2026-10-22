package com.bytedance.ee.bear.bitable.common.widgets.conditioncard;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConditionListView f209924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConditionListView.a f209925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f209926c;

    public c(ConditionListView r100, ConditionListView.a r101, int r102) {
        this.f209924a = r100;
        this.f209925b = r101;
        this.f209926c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ConditionListView.d r101 = this.f209924a.getOnConditionListener();
        if (r101 == null) goto L6;
        r101.Fi(this.f209925b, this.f209926c);
        return;
    }
}
