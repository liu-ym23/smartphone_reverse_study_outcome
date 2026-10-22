package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class y1 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoDetailMainSection f443471a;

    public y1(TodoDetailMainSection r100) {
        this.f443471a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        this.f443471a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.y2.f443798a);
        if (Intrinsics.areEqual(this.f443471a.e().getTaskListShowEnable().getValue(), Boolean.TRUE) == false) goto L7;
        this.f443471a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.l3.f443732a);
        return false;
    L7:
        return false;
    }
}
