package com.ss.android.lark.todo.impl.features.detail.time;

import com.bytedance.lark.pb.todo.v1.TodoReminder;
import com.larus.nova.R;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.utils.UIHelper;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<Integer> f443555a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<Integer> f443556b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f443557a = null;

        static {
            int[] r100 = new int[TodoReminder.Type.values().length];
            r100[TodoReminder.Type.ABSOLUTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f443557a = r100;
        }
    }

    static {
        f443555a = CollectionsKt.arrayListOf(new Integer[]{-1, 0, 5, 15, 30, 60, 120, 1440, 2880, 10080});
        f443556b = CollectionsKt.arrayListOf(new Integer[]{-1, Integer.valueOf(NetError.ERR_TTNET_POST_MD5_HEADER_NOT_FOUND), 900, 2340, 9540});
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

    public static String b(int r100) {
        if (r100 == 0) goto L4;
        if (r100 < 0) goto L7;
        int r101 = r100 / 10080;
        int r102 = r100 % 10080;
        int r103 = r100 / 1440;
        int r104 = r100 % 1440;
        int r105 = r100 / 60;
        int r106 = r100 % 60;
        if (r101 <= 0) goto L13;
        if (r102 != 0) goto L13;
        return com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNWeeksBefore, r101);
    L13:
        if (r103 > 0) goto L15;
    L22:
        if (r105 <= 0) goto L32;
        if (r106 == 0) goto L26;
        if (r106 == 0) goto L32;
        if (r103 <= 0) goto L32;
        return com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNHoursBefore, r105 + 1);
    L26:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNHoursBefore, r105);
    L32:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNMinutesBefore, r100);
    L15:
        if (r104 == 0) goto L17;
        if (r104 == 0) goto L22;
        if (r101 <= 0) goto L22;
        return com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNDaysBefore, r103 + 1);
    L17:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNDaysBefore, r103);
    L7:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Task_AlertTimeNoAlert);
    L4:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Task_AlertTimeAtTimeOfEvent);
    }

    public static String c(int r100, boolean r101) {
        if (r100 == (-1)) goto L5;
        if (r101 == false) goto L19;
        if (r100 > 0) goto L9;
        com.ss.android.lark.todo.impl.utils.i r102 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        return com.ss.android.lark.todo.impl.utils.i.d(R.string.Todo_Task_AlertTimeOnTheDayAt, "time", a(-r100));
    L9:
        boolean r103 = true;
        int r104 = (r100 / 1440) + 1;
        int r105 = (r104 * 1440) - r100;
        int r106 = r104 / 7;
        if ((r104 % 7) == 0) goto L13;
        r103 = false;
    L13:
        if (r103 == false) goto L16;
        if (r106 <= 0) goto L16;
        String r107 = com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNWeeksBefore, r106);
    L17:
        HashMap r108 = new HashMap();
        r108.put("TimeBefore", r107);
        r108.put("Time", a(r105));
        return UIHelper.mustacheFormat(R.string.Todo_Task_AlertTimeXBeforeAt, r108);
    L16:
        r107 = com.ss.android.lark.todo.impl.utils.i.f444291a.f(R.plurals.Todo_Task_AlertTimeNDaysBefore, r104);
        goto L17
    L19:
        return b(r100);
    L5:
        return com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Task_AlertTimeNoAlert);
    }
}
