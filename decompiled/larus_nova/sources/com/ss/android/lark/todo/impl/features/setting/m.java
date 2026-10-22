package com.ss.android.lark.todo.impl.features.setting;

import com.ss.android.lark.todo.impl.features.setting.widget.TodoSwitchView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class m implements TodoSwitchView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoSettingFragment f443991a;

    @Override // com.ss.android.lark.todo.impl.features.setting.widget.TodoSwitchView.b
    public final void a() {
        int r100 = a9c.c.f2314a;
        a9c.c.b("todo_daily_reminder_settings", new JSONObject().put("is_on", "false"));
        a9c.b.f2313a.p(false);
        TodoSettingFragment r101 = this.f443991a;
        int r102 = TodoSettingFragment.f443968m;
        r101.S90().updateReminderStatus(false);
    }

    @Override // com.ss.android.lark.todo.impl.features.setting.widget.TodoSwitchView.b
    public final void b() {
        int r100 = a9c.c.f2314a;
        a9c.c.b("todo_daily_reminder_settings", new JSONObject().put("is_on", "true"));
        a9c.b.f2313a.p(true);
        TodoSettingFragment r101 = this.f443991a;
        int r102 = TodoSettingFragment.f443968m;
        r101.S90().updateReminderStatus(true);
    }

    public m(TodoSettingFragment r100) {
        this.f443991a = r100;
    }
}
