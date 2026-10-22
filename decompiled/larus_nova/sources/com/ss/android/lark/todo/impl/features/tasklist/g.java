package com.ss.android.lark.todo.impl.features.tasklist;

import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.ui.CommonTitleBar;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommonTitleBar f444107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskListNameFragment f444108b;

    public g(CommonTitleBar r100, TaskListNameFragment r101) {
        this.f444107a = r100;
        this.f444108b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        KeyboardUtils.hideKeyboard(this.f444107a.getContext());
        zab.a.a(this.f444108b);
    }
}
