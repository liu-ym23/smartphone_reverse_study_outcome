package com.ss.android.lark.todo.impl.features.remind.reminder;

import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.features.remind.reminder.entity.OverallReminderData;
import com.ss.android.lark.todo.impl.utils.g;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;
import yoc.h;

/* JADX INFO: loaded from: classes38.dex */
public final class f extends b8c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OverallReminderView f443953b;

    public f(OverallReminderView r100) {
        this.f443953b = r100;
    }

    @Override // b8c.a
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Log.i("OverallReminderView", g.i("reminderDetail"));
        OverallReminderView r101 = this.f443953b;
        OverallReminderView.b r102 = r101.f443939e;
        if (r102 == null) goto L5;
        r102.a(r101.f443940f);
    L5:
        h r103 = yoc.a.f568693a;
        OverallReminderData r104 = this.f443953b.f443940f;
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
