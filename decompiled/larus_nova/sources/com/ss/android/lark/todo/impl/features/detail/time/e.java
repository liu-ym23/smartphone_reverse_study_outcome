package com.ss.android.lark.todo.impl.features.detail.time;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskTimeContainer f443554a;

    public e(TaskTimeContainer r100) {
        this.f443554a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TaskTimeContainer.a r101 = this.f443554a.f443518z;
        if (r101 == null) goto L6;
        r101.d();
        return;
    }
}
