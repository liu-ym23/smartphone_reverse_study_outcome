package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class t0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f443444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f443445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DetailTaskListsAdapter f443446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o1 f443447d;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f443444a;
        long r102 = System.currentTimeMillis();
        this.f443444a = r102;
        if ((r102 - r101) >= 500) goto L6;
        return;
    L6:
        if (this.f443445b == false) goto L11;
        DetailTaskListsAdapter.a r103 = this.f443446c.f443230d;
        if (r103 == null) goto L12;
        r103.d(this.f443447d.f443414a.guid);
        return;
    L12:
        return;
    }

    public t0(boolean r100, DetailTaskListsAdapter r101, o1 r102) {
        this.f443445b = r100;
        this.f443446c = r101;
        this.f443447d = r102;
    }
}
