package com.ss.android.lark.todo.impl.rustadapter.push;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.todo.v1.PushContainerSectionItemsChangedNotification;
import com.bytedance.lark.pb.todo.v1.PushContainerSectionsChangedNotification;
import com.bytedance.lark.pb.todo.v1.PushListTasksChangedNotification;
import com.bytedance.lark.pb.todo.v1.PushTaskContainerRefsNotification;
import com.bytedance.lark.pb.todo.v1.PushTaskListsChangedNotification;
import com.bytedance.lark.pb.todo.v1.PushTaskSectionNotification;
import com.bytedance.lark.pb.todo.v1.PushTodoBadgeChangedNotification;
import com.bytedance.lark.pb.todo.v1.PushTodoComment;
import com.bytedance.lark.pb.todo.v1.PushTodoCommentReaction;
import com.bytedance.lark.pb.todo.v1.PushTodoExtraInfoChangedNotification;
import com.bytedance.lark.pb.todo.v1.PushTodoReminder;
import com.bytedance.lark.pb.todo.v1.PushTodoSettingChangeNotification;
import com.bytedance.lark.pb.todo.v1.PushTodosChangedNotification;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.g;
import com.ss.android.lark.todo.impl.rustadapter.push.entity.TodoChangeNotificationUnit;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f444233a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Command, a> f444234b = null;

    public static final class a implements g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Command f444235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CopyOnWriteArrayList<WeakReference<com.ss.android.lark.todo.impl.rustadapter.push.a>> f444236b;

        public a(Command r100) {
            Intrinsics.checkNotNullParameter(r100, "cmd");
            this.f444235a = r100;
            this.f444236b = new CopyOnWriteArrayList();
        }

        @Override // com.ss.android.lark.sdk.g.b
        public final void a(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "request");
            Intrinsics.checkNotNullParameter("", WsConstants.KEY_SESSION_ID);
            c r101 = c.f444233a;
            Command r102 = this.f444235a;
            if (Intrinsics.areEqual(r102, Command.PUSH_TODOS_CHANGED_NOTIFICATION) == false) goto L13;
            JSONObject r103 = new JSONObject();
            PushTodosChangedNotification r104 = PushTodosChangedNotification.ADAPTER.decode(r100);     // Catch: IOException -> L10
            if (r104 == null) goto L133;
            r103.put("todo_change_notification", new TodoChangeNotificationUnit(r104.changed_todos, r104.refresh_all.booleanValue()));     // Catch: IOException -> L10
        L133:
            CoreThreadPool.getDefault().getUIExecutor().execute(new b(this, r103));
            return;
        L10:
            e = move-exception;
            Log.e(e.getMessage(), e);
            goto L133
        L13:
            if (Intrinsics.areEqual(r102, Command.PUSH_TODO_REMINDER_NOTIFICATION) == false) goto L23;
            r103 = new JSONObject();
            PushTodoReminder r105 = PushTodoReminder.ADAPTER.decode(r100);     // Catch: IOException -> L20
            if (r105 == null) goto L133;
            r103.put("todo_overall_reminder", r105);     // Catch: IOException -> L20
        L20:
            e = move-exception;
            Log.e(e.getMessage(), e);
            goto L133
        L23:
            if (Intrinsics.areEqual(r102, Command.PUSH_TODO_SETTING_CHANGE_NOTIFICATION) == false) goto L33;
            r103 = new JSONObject();
            PushTodoSettingChangeNotification r106 = PushTodoSettingChangeNotification.ADAPTER.decode(r100);     // Catch: IOException -> L30
            if (r106 == null) goto L133;
            r103.put("todo_setting_push", r106.setting);     // Catch: IOException -> L30
        L30:
            e = move-exception;
            Log.e(e.getMessage(), e);
            goto L133
        L33:
            if (Intrinsics.areEqual(r102, Command.PUSH_TODO_COMMENT_NOTIFICATION) == false) goto L43;
            r103 = new JSONObject();
            PushTodoComment r107 = PushTodoComment.ADAPTER.decode(r100);     // Catch: IOException -> L40
            if (r107 == null) goto L133;
            r103.put("todo_comment_notification", r107);     // Catch: IOException -> L40
        L40:
            e = move-exception;
            Log.e(e.getMessage(), e);
            goto L133
        L43:
            if (Intrinsics.areEqual(r102, Command.PUSH_TODO_COMMENT_REACTION_NOTIFICATION) == false) goto L53;
            r103 = new JSONObject();
            PushTodoCommentReaction r108 = PushTodoCommentReaction.ADAPTER.decode(r100);     // Catch: IOException -> L50
            if (r108 == null) goto L133;
            r103.put("todo_comment_reaction_notification", r108);     // Catch: IOException -> L50
        L50:
            e = move-exception;
            Log.e(e.getMessage(), e);
            goto L133
        L53:
            if (Intrinsics.areEqual(r102, Command.PUSH_TODO_BADGE_NOTIFICATION) == false) goto L63;
            r103 = new JSONObject();
            PushTodoBadgeChangedNotification r109 = PushTodoBadgeChangedNotification.ADAPTER.decode(r100);     // Catch: IOException -> L60
            if (r109 == null) goto L133;
            r103.put("todo_badge_changed", r109.count);     // Catch: IOException -> L60
        L60:
            e = move-exception;
            Log.e(e.getMessage(), e);
            goto L133
        L63:
            if (Intrinsics.areEqual(r102, Command.PUSH_TODO_EXTRA_INFO_NOTIFICATION) == false) goto L73;
            r103 = new JSONObject();
            PushTodoExtraInfoChangedNotification r110 = PushTodoExtraInfoChangedNotification.ADAPTER.decode(r100);     // Catch: IOException -> L70
            if (r110 == null) goto L133;
            r103.put("todo_extra_change_notification", r110.extra_infos);     // Catch: IOException -> L70
        L70:
            e = move-exception;
            Log.e(e.getMessage(), e);
            goto L133
        L73:
            if (Intrinsics.areEqual(r102, Command.PUSH_TASK_SECTION_NOTIFICATION) == false) goto L83;
            r103 = new JSONObject();
            PushTaskSectionNotification r111 = PushTaskSectionNotification.ADAPTER.decode(r100);     // Catch: IOException -> L80
            if (r111 == null) goto L133;
            r103.put("task_section_change_notification", r111.task_sections);     // Catch: IOException -> L80
        L80:
            e = move-exception;
            Log.e(e.getMessage(), e);
            goto L133
        L83:
            if (Intrinsics.areEqual(r102, Command.PUSH_TASK_CONTAINER_REFS_NOTIFICATION) == false) goto L93;
            r103 = new JSONObject();
            PushTaskContainerRefsNotification r112 = PushTaskContainerRefsNotification.ADAPTER.decode(r100);     // Catch: IOException -> L90
            if (r112 == null) goto L133;
            r103.put("task_container_refs_notification", r112.task_container_refs);     // Catch: IOException -> L90
        L90:
            e = move-exception;
            Log.e(e.getMessage(), e);
            goto L133
        L93:
            if (Intrinsics.areEqual(r102, Command.PUSH_TASK_LISTS_CHANGED_NOTIFICATION) == false) goto L103;
            r103 = new JSONObject();
            PushTaskListsChangedNotification r113 = PushTaskListsChangedNotification.ADAPTER.decode(r100);     // Catch: IOException -> L100
            if (r113 == null) goto L133;
            r103.put("task_lists_changed_notification", r113);     // Catch: IOException -> L100
        L100:
            e = move-exception;
            Log.e(e.getMessage(), e);
            goto L133
        L103:
            if (Intrinsics.areEqual(r102, Command.PUSH_LIST_TASKS_CHANGED_NOTIFICATION) == false) goto L113;
            r103 = new JSONObject();
            PushListTasksChangedNotification r114 = PushListTasksChangedNotification.ADAPTER.decode(r100);     // Catch: IOException -> L110
            if (r114 == null) goto L133;
            r103.put("list_tasks_changed_notification", r114.task_infos);     // Catch: IOException -> L110
        L110:
            e = move-exception;
            Log.e(e.getMessage(), e);
            goto L133
        L113:
            if (Intrinsics.areEqual(r102, Command.PUSH_CONTAINER_SECTIONS_CHANGED_NOTIFICATION) == false) goto L123;
            r103 = new JSONObject();
            PushContainerSectionsChangedNotification r115 = PushContainerSectionsChangedNotification.ADAPTER.decode(r100);     // Catch: IOException -> L120
            if (r115 == null) goto L133;
            r103.put("task_container_sections", r115);     // Catch: IOException -> L120
        L120:
            e = move-exception;
            Log.e(e.getMessage(), e);
            goto L133
        L123:
            if (Intrinsics.areEqual(r102, Command.PUSH_CONTAINER_SECTION_REFS_CHANGED_NOTIFICATION) == false) goto L132;
            r103 = new JSONObject();
            PushContainerSectionItemsChangedNotification r116 = PushContainerSectionItemsChangedNotification.ADAPTER.decode(r100);     // Catch: IOException -> L130
            if (r116 == null) goto L133;
            r103.put("task_container_section_items", r116);     // Catch: IOException -> L130
        L130:
            e = move-exception;
            Log.e(e.getMessage(), e);
            goto L133
        L132:
            r103 = new JSONObject();
            goto L133
        }
    }

    public c() {
    }

    static {
        f444233a = new c();
        f444234b = new LinkedHashMap();
    }

    public final synchronized void a(Command r100, com.ss.android.lark.todo.impl.rustadapter.push.a r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "command");     // Catch: Throwable -> L12
        Log.i("TodoPushProcess", "registerPushServiceListener : " + r100);     // Catch: Throwable -> L12
        if (r101 == null) goto L10;
        Map<Command, a> r102 = f444234b;     // Catch: Throwable -> L12
        a r103 = (a) ((LinkedHashMap) r102).get(r100);     // Catch: Throwable -> L12
        if (r103 == null) goto L9;
        Intrinsics.checkNotNullParameter(r101, "listener");     // Catch: Throwable -> L12
        r103.f444236b.add(new WeakReference(r101));     // Catch: Throwable -> L12
        goto L10
    L9:
        a r104 = new a(r100);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r101, "listener");     // Catch: Throwable -> L12
        r104.f444236b.add(new WeakReference(r101));     // Catch: Throwable -> L12
        r102.put(r100, r104);     // Catch: Throwable -> L12
        g.e.f439875a.b(r100, r104);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(Command r100, final com.ss.android.lark.todo.impl.rustadapter.push.a r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "command");     // Catch: Throwable -> L13
        Log.i("TodoPushProcess", "unRegisterPushServiceListener : " + r100);     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        Map<Command, a> r102 = f444234b;     // Catch: Throwable -> L13
        a r103 = (a) ((LinkedHashMap) r102).get(r100);     // Catch: Throwable -> L13
        if (r103 == null) goto L11;
        Intrinsics.checkNotNullParameter(r101, "listener");     // Catch: Throwable -> L13
        CollectionsKt.removeAll(r103.f444236b, new TodoPushProcess$TodoPushHandler$removeListener$1(r101));     // Catch: Throwable -> L13
        if (r103.f444236b.size() != 0) goto L11;
        g.e.f439875a.c(r103.f444235a);     // Catch: Throwable -> L13
        r102.remove(r103.f444235a);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
