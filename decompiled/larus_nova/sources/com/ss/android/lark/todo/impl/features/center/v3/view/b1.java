package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import com.bytedance.lark.pb.todo.v1.CustomComplete;
import com.bytedance.lark.pb.todo.v1.TodoLaunchScreen;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class b1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskNoticeView f442010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TodoLaunchScreen f442011b;

    public b1(TaskNoticeView r100, TodoLaunchScreen r101) {
        this.f442010a = r100;
        this.f442011b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        TaskNoticeView r101 = this.f442010a;
        CustomComplete r102 = this.f442011b.button_action;
        r101.getClass();
        if (r102 == null) goto L8;
        CustomComplete.Action r103 = r102.f253769android;
        if (r103 == null) goto L9;
        int r104 = com.ss.android.lark.todo.impl.features.common.helper.a.f442447a;
        com.ss.android.lark.todo.impl.features.common.helper.a.a(((UDNotice) r101.f441976a.findViewById(R.id.todo_notice_view)).getContext(), r103, new c1(r101));
        return;
    L9:
        return;
    }
}
