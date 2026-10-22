package com.ss.android.lark.todo.impl.features.setting;

import android.view.View;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoSettingFragment f443992a;

    public n(TodoSettingFragment r100) {
        this.f443992a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a9c.b.b(a9c.b.f2313a, "setting_todo_click", new JSONObject().put("click", "default_alert_time").put(PickerReporterConstants.KEY.TARGET, "setting_todo_default_alert_time_view"), 4);
        TodoSettingFragment r101 = this.f443992a;
        int r102 = TodoSettingFragment.f443968m;
        r101.S90().onReminderContainerClicked();
    }
}
