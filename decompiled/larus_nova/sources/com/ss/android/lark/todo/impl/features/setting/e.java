package com.ss.android.lark.todo.impl.features.setting;

import android.view.View;
import com.bytedance.lark.pb.todo.v1.TodoBadgeConfig;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoBadgeSettingFragment f443983a;

    public e(TodoBadgeSettingFragment r100) {
        this.f443983a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f443983a.S90().setVisibility(8);
        this.f443983a.T90().setVisibility(8);
        this.f443983a.U90().setVisibility(0);
        this.f443983a.V90().updateBadgeSetting(true, TodoBadgeConfig.BadgeType.OWNED_BY_ME_UNFINISHED);
    }
}
