package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;
import com.ss.android.lark.todo.impl.features.detail.dependent.TaskDependentSearchViewModel;

/* JADX INFO: loaded from: classes38.dex */
public final class m1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f443396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SummarySection f443397b;

    public m1(SummarySection r100) {
        this.f443397b = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f443396a;
        long r102 = System.currentTimeMillis();
        this.f443396a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        this.f443397b.b().f(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.z.f443800a, TaskDependentSearchViewModel.Companion.TaskDependentType.NEXT.getValue());
    }
}
