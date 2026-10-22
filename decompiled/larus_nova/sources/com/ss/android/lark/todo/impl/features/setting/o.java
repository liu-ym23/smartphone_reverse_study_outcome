package com.ss.android.lark.todo.impl.features.setting;

import com.ss.android.lark.todo.impl.features.setting.widget.TodoReminderPickerMenu;

/* JADX INFO: loaded from: classes38.dex */
public final class o implements TodoReminderPickerMenu.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoSettingFragment f443993a;

    public o(TodoSettingFragment r100) {
        this.f443993a = r100;
    }

    @Override // com.ss.android.lark.todo.impl.features.setting.widget.TodoReminderPickerMenu.a
    public final void a(int r100) {
        TodoSettingFragment r101 = this.f443993a;
        int r102 = TodoSettingFragment.f443968m;
        r101.S90().onReminderDialogItemClicked(r100);
    }
}
