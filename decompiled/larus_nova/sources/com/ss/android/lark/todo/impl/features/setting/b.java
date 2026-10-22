package com.ss.android.lark.todo.impl.features.setting;

import com.ss.android.lark.todo.impl.features.setting.widget.TodoSwitchView;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements TodoSwitchView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoBadgeSettingFragment f443980a;

    @Override // com.ss.android.lark.todo.impl.features.setting.widget.TodoSwitchView.b
    public final void a() {
        a9c.b.f2313a.g(false);
        TodoBadgeSettingFragment r100 = this.f443980a;
        int r101 = TodoBadgeSettingFragment.f443955o;
        TodoBadgeSettingViewModel.updateBadgeSetting$default(r100.V90(), false, null, 2, null);
    }

    @Override // com.ss.android.lark.todo.impl.features.setting.widget.TodoSwitchView.b
    public final void b() {
        a9c.b.f2313a.g(true);
        TodoBadgeSettingFragment r100 = this.f443980a;
        int r101 = TodoBadgeSettingFragment.f443955o;
        TodoBadgeSettingViewModel.updateBadgeSetting$default(r100.V90(), true, null, 2, null);
    }

    public b(TodoBadgeSettingFragment r100) {
        this.f443980a = r100;
    }
}
