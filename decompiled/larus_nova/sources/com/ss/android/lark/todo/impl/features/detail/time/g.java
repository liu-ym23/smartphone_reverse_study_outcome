package com.ss.android.lark.todo.impl.features.detail.time;

import com.larus.nova.R;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.utils.UIHelper;
import com.ss.bytertc.engine.type.ErrorCode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<Integer> f443558a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<Integer> f443559b = null;

    static {
        f443558a = CollectionsKt.arrayListOf(new Integer[]{0, 5, 15, 30, 60, 120, 1440, 2880, 10080});
        f443559b = CollectionsKt.arrayListOf(new Integer[]{Integer.valueOf(ErrorCode.ERROR_CODE_OVER_STREAM_PUBLISH_LIMIT), 900, 2340, 9540});
    }

    public static String a(long r110) {
        Date r100 = new Date((((long) 60) * r110) * ((long) 1000));
        c7c.a r111 = new c7c.a(null, null, null, null, null, false, false, false, false, 2047);
        Intrinsics.checkNotNullParameter("UTC", "<set-?>");
        r111.f22677a = "UTC";
        r111.d(TimePreciseness.MINUTE);
        r111.f22684h = !TodoDependencyHolder.a().timeFormatDependency().c();
        return c7c.b.i(TodoDependencyHolder.a().settingDependency().getContext(), r100, r111);
    }

    public static String b(int r100, boolean r110) {
        if (r100 == (-1)) goto L5;
        boolean r101 = true;
        if (r110 == false) goto L27;
        int r111 = r100 / 1440;
        if ((r100 % 1440) == 0) goto L11;
        r111 = r111 + 1;
    L11:
        int r102 = r111 / 7;
        int r103 = (r111 * 1440) - r100;
        if (r100 > 0) goto L18;
        if (TodoDependencyHolder.b().f2210a.a("todo.task_reminder_optimize", false) == false) goto L16;
        HashMap r104 = new HashMap();
        r104.put("TimeBefore", com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_CreateTaskAlert_AllDayTimePicker_OnDueDate_Text));
        r104.put("Time", a(r103));
        String r105 = UIHelper.mustacheFormat(R.string.Todo_Task_AlertTimeXBeforeAt, r104);
    L26:
        Intrinsics.checkNotNull(r105);
        return r105;
    L16:
        com.ss.android.lark.todo.impl.utils.i r112 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r105 = com.ss.android.lark.todo.impl.utils.i.d(R.string.Todo_Task_AlertTimeOnTheDayAt, "time", a(-r100));
        goto L26
    L18:
        if ((r111 % 7) == 0) goto L21;
        r101 = false;
    L21:
        if (r101 == false) goto L24;
        if (r102 <= 0) goto L24;
        String r106 = com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNWeeksBefore, r102);
    L25:
        HashMap r113 = new HashMap();
        r113.put("TimeBefore", r106);
        r113.put("Time", a(r103));
        r105 = UIHelper.mustacheFormat(R.string.Todo_Task_AlertTimeXBeforeAt, r113);
    L24:
        r106 = com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNDaysBefore, r111);
        goto L25
    L27:
        if (r100 == 0) goto L51;
        if (r100 < 0) goto L52;
        int r114 = r100 / 10080;
        int r107 = r100 % 10080;
        int r108 = r100 / 1440;
        int r109 = r100 % 1440;
        int r115 = r100 / 60;
        int r116 = r100 % 60;
        if (r114 <= 0) goto L35;
        if (r107 != 0) goto L35;
        return com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNWeeksBefore, r114);
    L35:
        if (r108 <= 0) goto L41;
        if (r109 == 0) goto L54;
        if (r109 == 0) goto L41;
        if (r114 <= 0) goto L41;
        return com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNDaysBefore, r108 + 1);
    L54:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNDaysBefore, r108);
    L41:
        if (r115 <= 0) goto L49;
        if (r116 == 0) goto L56;
        if (r116 == 0) goto L49;
        if (r108 <= 0) goto L49;
        return com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNHoursBefore, r115 + 1);
    L56:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNHoursBefore, r115);
    L49:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNMinutesBefore, r100);
    L52:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Task_AlertTimeNoAlert);
    L51:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Task_AlertTimeAtTimeOfEvent);
    L5:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Task_AlertTimeNoAlert);
    }
}
