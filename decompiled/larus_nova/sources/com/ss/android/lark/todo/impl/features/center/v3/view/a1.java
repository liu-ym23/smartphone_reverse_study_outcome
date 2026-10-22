package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import com.bytedance.lark.pb.todo.v1.TodoLaunchScreen;

/* JADX INFO: loaded from: classes38.dex */
public final class a1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskNoticeView f442004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoLaunchScreen f442005b;

    public a1(TaskNoticeView r100, TodoLaunchScreen r101) {
        this.f442004a = r100;
        this.f442005b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TaskNoticeView.a(this.f442004a, null);
        this.f442004a.f441978c.handleAction(m7c.k.a.f512428a, this.f442005b);
    }
}
