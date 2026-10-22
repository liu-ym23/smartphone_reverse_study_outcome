package com.ss.android.lark.todo.impl.features.setting;

import android.view.View;
import com.bytedance.lark.pb.todo.v1.TodoBadgeConfig;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoBadgeSettingFragment f443981a;

    public c(TodoBadgeSettingFragment r100) {
        this.f443981a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f443981a.S90().setVisibility(0);
        this.f443981a.T90().setVisibility(8);
        this.f443981a.U90().setVisibility(8);
        this.f443981a.V90().updateBadgeSetting(true, TodoBadgeConfig.BadgeType.OVERDUE);
        a9c.b.f2313a.h(false);
    }
}
