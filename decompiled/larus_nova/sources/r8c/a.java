package r8c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.lark.pb.todo.v1.PushTodoReminder;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.remind.reminder.b;
import com.ss.android.lark.todo.impl.features.remind.reminder.c;
import com.ss.android.lark.todo.impl.features.remind.reminder.d;
import com.ss.android.lark.todo.impl.features.remind.reminder.entity.OverallReminderData;
import com.ss.android.lark.todo.impl.utils.g;
import com.ss.android.lark.todo.impl.utils.i;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import g7c.p;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import yoc.h;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements com.ss.android.lark.todo.impl.rustadapter.push.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f536677a;

    public a(d r100) {
        this.f536677a = r100;
    }

    @Override // com.ss.android.lark.todo.impl.rustadapter.push.a
    public final void a(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "pushData");
        Log.i("OverallReminderManager", g.j("pushReminder"));
        Object r111 = r110.get("todo_overall_reminder");
        if ((r111 instanceof PushTodoReminder) == false) goto L5;
        PushTodoReminder r112 = (PushTodoReminder) r111;
    L6:
        if (r112 == null) goto L27;
        d r100 = this.f536677a;
        OverallReminderData r101 = new OverallReminderData(r112, SystemClock.elapsedRealtime());
        r100.f443949a.a();
        com.ss.android.lark.todo.impl.features.remind.reminder.a r113 = r100.f443951c;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r101, "reminderData");
        c r102 = new c(new b(r113));
        r102.f443947b = r101;
        h r103 = yoc.a.f568693a;
        if (r103.c8() != 0) goto L11;
        ((ArrayList) r113.f443942b).clear();
        ((ArrayList) r113.f443943c).clear();
    L11:
        if ((!((ArrayList) r113.f443942b).isEmpty()) == true) goto L13;
    L15:
        r103.ra(r102);
        ((ArrayList) r113.f443942b).add(r101);
        ((ArrayList) r113.f443943c).add(r102);
        a9c.b r114 = a9c.b.f2313a;
        String r115 = r101.getTodoReminder().guid;
        Intrinsics.checkNotNullParameter(r115, DBDefinition.TASK_ID);
        a9c.b.a("todo_event_notification_view", new org.json.JSONObject(), r115);
        String r116 = String.valueOf(Math.abs(r101.getTodoReminder().guid.hashCode()));
        int r104 = com.ss.android.lark.todo.impl.features.common.helper.b.f442448a;
        i r105 = i.f444291a;
        String r106 = i.d(R.string.Todo_Task_DueAt2, "time", com.ss.android.lark.todo.impl.features.common.helper.b.b(LarkContext.getApplication(), r101.getTodoReminder().due_time.longValue() * ((long) 1000), r101.getTodoReminder().is_all_day.booleanValue(), TodoDependencyHolder.a().timeFormatDependency().c()).getEndTimeStr());
        if (TextUtils.isEmpty(r101.getTodoReminder().summary) == false) goto L18;
        String r107 = r105.g(R.string.Todo_Task_NoTitlePlaceholder);
    L19:
        Intrinsics.checkNotNull(r107);
        String r108 = i.d(R.string.Todo_Task_TaskIs, "task", r107);
        p r109 = TodoDependencyHolder.a().pushDependency();
        int r117 = q8c.a.f532066a;
        Intrinsics.checkNotNullParameter(r101, "overallReminder");
        if (TextUtils.isEmpty(r101.getTodoReminder().summary) == false) goto L22;
        String r118 = r105.g(R.string.Todo_Task_NoTitlePlaceholder);
    L23:
        String r119 = r118;
        String r120 = r101.getTodoReminder().guid;
        if (r120 != null) goto L26;
        r120 = "";
    L26:
        Intrinsics.checkNotNull(r119);
        r109.a(new f7c.a(r120, r119, r101.getTodoReminder().due_time.longValue(), r101.getTodoReminder().due_timezone), r116, r106, r108);
        return;
    L22:
        r118 = r101.getTodoReminder().summary;
        goto L23
    L18:
        r107 = r101.getTodoReminder().summary;
        goto L19
    L13:
        if (((ArrayList) r113.f443942b).contains(r101) == false) goto L15;
        return;
    L27:
        Log.e("OverallReminderManager", g.j("overallReminder_is_null"));
        return;
    L5:
        r112 = null;
        goto L6
    }
}
