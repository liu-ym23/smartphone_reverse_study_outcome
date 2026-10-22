package com.bytedance.ee.bear.bitable.common.widgets.conditioncard;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConditionListView f209922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConditionListView.b f209923b;

    public b(ConditionListView r100, ConditionListView.b r101) {
        this.f209922a = r100;
        this.f209923b = r101;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        ConditionListView.d r102 = this.f209922a.getOnConditionListener();
        if (r102 == null) goto L6;
        r102.Cj(this.f209923b);
        return;
    }
}
