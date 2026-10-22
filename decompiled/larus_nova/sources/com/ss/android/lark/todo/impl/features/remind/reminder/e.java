package com.ss.android.lark.todo.impl.features.remind.reminder;

import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.features.remind.reminder.entity.OverallReminderData;
import com.ss.android.lark.todo.impl.utils.g;
import yoc.h;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OverallReminderView f443952a;

    public e(OverallReminderView r100) {
        this.f443952a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Log.i("OverallReminderView", g.i("reminderClose"));
        OverallReminderView r101 = this.f443952a;
        OverallReminderView.b r102 = r101.f443939e;
        if (r102 == null) goto L5;
        r102.b(r101.f443940f);
    L5:
        h r103 = yoc.a.f568693a;
        OverallReminderData r104 = this.f443952a.f443940f;
        if (r104 == null) goto L9;
        String r105 = r104.getId();
        if (r105 == null) goto L9;
    L10:
        r103.y2(R.id.todo_reminder_handler_type_overall, r105);
        return;
    L9:
        r105 = "";
        goto L10
    }
}
