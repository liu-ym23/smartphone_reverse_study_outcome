package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListMembersFragment f442387a;

    public g(TaskListMembersFragment r100) {
        this.f442387a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        this.f442387a.S90().clearFocus();
        Context r102 = this.f442387a.getContext();
        if (r102 == null) goto L5;
        Object r103 = r102.getSystemService("input_method");
    L6:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r103).hideSoftInputFromWindow(this.f442387a.S90().getWindowToken(), 0);
        return false;
    L5:
        r103 = null;
        goto L6
    }
}
