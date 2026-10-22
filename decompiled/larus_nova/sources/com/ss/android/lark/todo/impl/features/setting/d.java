package com.ss.android.lark.todo.impl.features.setting;

import android.view.View;
import com.bytedance.lark.pb.todo.v1.TodoBadgeConfig;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoBadgeSettingFragment f443982a;

    public d(TodoBadgeSettingFragment r100) {
        this.f443982a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f443982a.S90().setVisibility(8);
        this.f443982a.T90().setVisibility(0);
        this.f443982a.U90().setVisibility(8);
        this.f443982a.V90().updateBadgeSetting(true, TodoBadgeConfig.BadgeType.OVERDUE_AND_TODAY);
        a9c.b.f2313a.h(true);
    }
}
