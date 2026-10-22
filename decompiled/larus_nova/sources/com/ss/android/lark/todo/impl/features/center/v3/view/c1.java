package com.ss.android.lark.todo.impl.features.center.v3.view;

import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.common.helper.OperationToastHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c1 implements com.ss.android.lark.todo.impl.features.common.helper.a.InterfaceC5344a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskNoticeView f442014a;

    public c1(TaskNoticeView r100) {
        this.f442014a = r100;
    }

    @Override // com.ss.android.lark.todo.impl.features.common.helper.a.InterfaceC5344a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tipsStr");
        OperationToastHelper r101 = OperationToastHelper.f442443a;
        OperationToastHelper.c(((UDNotice) this.f442014a.f441976a.findViewById(R.id.todo_notice_view)).getContext(), 0, r100, 56);
    }
}
