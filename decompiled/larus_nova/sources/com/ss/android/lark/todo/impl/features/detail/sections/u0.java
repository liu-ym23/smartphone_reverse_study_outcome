package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class u0 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DetailTaskListsAdapter f443451a;

    public u0(DetailTaskListsAdapter r100) {
        this.f443451a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        DetailTaskListsAdapter.a r102 = this.f443451a.f443230d;
        if (r102 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNull(r101);
        r102.b(r100, r101);
        return false;
    L7:
        return false;
    }
}
