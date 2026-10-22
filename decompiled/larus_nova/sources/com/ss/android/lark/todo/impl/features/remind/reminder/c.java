package com.ss.android.lark.todo.impl.features.remind.reminder;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.features.remind.reminder.entity.OverallReminderData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import yoc.g;
import yoc.h;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements yoc.c, g, yoc.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OverallReminderView.b f443946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OverallReminderData f443947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OverallReminderView f443948c;

    public static final class a {
    }

    static {
    }

    @Override // yoc.c
    public final void getPriority() {
    }

    @Override // yoc.c
    public int getType() {
        return R.id.todo_reminder_handler_type_overall;
    }

    @Override // yoc.c
    public final String getId() {
        OverallReminderData r100 = this.f443947b;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getId();
    }

    @Override // yoc.g
    public final boolean isValid() {
        OverallReminderData r100 = this.f443947b;
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((SystemClock.elapsedRealtime() - r100.getArriveTime()) > 1800000) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // yoc.e
    public final void c() {
        Log.i("OverallReminderView", com.ss.android.lark.todo.impl.utils.g.i("reminderCard"));
        this.f443946a.a(this.f443947b);
        h r100 = yoc.a.f568693a;
        int r101 = getType();
        OverallReminderData r102 = this.f443947b;
        if (r102 == null) goto L6;
        String r103 = r102.getId();
        if (r103 == null) goto L6;
    L7:
        r100.y2(r101, r103);
        return;
    L6:
        r103 = "";
        goto L7
    }

    public c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "mClickListener");
        this.f443946a = r100;
    }

    @Override // yoc.c
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        OverallReminderView r101 = new OverallReminderView(r100, null, 6, 0);
        this.f443948c = r101;
        OverallReminderData r102 = this.f443947b;
        if (r102 == null) goto L5;
        r101.setReminderData(r102);
    L5:
        OverallReminderView r103 = this.f443948c;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mReminderView");
        r103 = null;
    L8:
        r103.setReminderClickListener(this.f443946a);
        OverallReminderView r104 = this.f443948c;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mReminderView");
        return null;
    L12:
        return r104;
    }
}
