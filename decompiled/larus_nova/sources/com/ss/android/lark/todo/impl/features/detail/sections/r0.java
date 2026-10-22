package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;
import com.bytedance.lark.pb.todo.v1.TaskSection;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.common.helper.OperationToastHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class r0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f443428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f443429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DetailTaskListsAdapter f443430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o1 f443431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DetailTaskListsAdapter.ViewHolder f443432e;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f443428a;
        long r102 = System.currentTimeMillis();
        this.f443428a = r102;
        if ((r102 - r101) >= 500) goto L6;
        return;
    L6:
        if (this.f443429b == false) goto L15;
        DetailTaskListsAdapter.a r103 = this.f443430c.f443230d;
        if (r103 == null) goto L17;
        o1 r104 = this.f443431d;
        String r105 = r104.f443414a.guid;
        TaskSection r106 = r104.f443415b;
        if (r106 == null) goto L13;
        String r107 = r106.guid;
        if (r107 == null) goto L13;
    L14:
        r103.a(r105, r107);
        return;
    L13:
        r107 = "";
        goto L14
    L17:
        return;
    L15:
        OperationToastHelper r108 = OperationToastHelper.f442443a;
        OperationToastHelper.c(this.f443432e.f443232a.getContext(), R.string.Todo_TaskList_TaskCardNoPermissionToEdit_Hover, null, 60);
    }

    public r0(boolean r100, DetailTaskListsAdapter r101, o1 r102, DetailTaskListsAdapter.ViewHolder r103) {
        this.f443429b = r100;
        this.f443430c = r101;
        this.f443431d = r102;
        this.f443432e = r103;
    }
}
