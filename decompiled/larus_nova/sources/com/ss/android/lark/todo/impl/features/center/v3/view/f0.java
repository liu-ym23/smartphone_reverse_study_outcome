package com.ss.android.lark.todo.impl.features.center.v3.view;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class f0 implements UDListDialogController.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCenterEventsView f442026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<String> f442027b;

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
    public final void onItemClick(int r100) {
        this.f442026a.f441918d.handleAction(com.ss.android.lark.todo.impl.features.tasklist.events.e.a.f444069a, ListProtector.get(this.f442027b, r100));
    }

    public f0(TaskCenterEventsView r100, List<String> r101) {
        this.f442026a = r100;
        this.f442027b = r101;
    }
}
