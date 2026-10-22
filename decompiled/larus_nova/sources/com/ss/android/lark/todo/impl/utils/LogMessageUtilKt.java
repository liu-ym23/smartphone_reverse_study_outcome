package com.ss.android.lark.todo.impl.utils;

import com.bytedance.lark.pb.basic.v1.RichContent;
import com.bytedance.lark.pb.basic.v1.RichText;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.bytedance.lark.pb.todo.v1.TodoAssignee;
import com.bytedance.lark.pb.todo.v1.TodoFollower;
import com.bytedance.lark.pb.todo.v1.TodoItemPermission;
import com.bytedance.lark.pb.todo.v1.TodoOrigin;
import com.bytedance.lark.pb.todo.v1.TodoReminder;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class LogMessageUtilKt {
    public static final String a(Todo r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        StringBuilder r100 = new StringBuilder();
        r100.append("Todo{guid=");     // Catch: Exception -> L32
        r100.append(r110.guid);     // Catch: Exception -> L32
        r100.append(", ancestor_guid=");     // Catch: Exception -> L32
        r100.append(r110.ancestor_guid);     // Catch: Exception -> L32
        r100.append(", mode=");     // Catch: Exception -> L32
        r100.append(r110.mode);     // Catch: Exception -> L32
        r100.append(", summary=");     // Catch: Exception -> L32
        RichContent r101 = r110.rich_summary;     // Catch: Exception -> L32
        Boolean r102 = null;
        if (r101 == null) goto L6;
        RichText r103 = r101.rich_text;     // Catch: Exception -> L32
    L7:
        r100.append(com.ss.android.lark.widget.richtext.i.l(j8c.c.a(r103)));     // Catch: Exception -> L32
        r100.append(", description=");     // Catch: Exception -> L32
        RichContent r104 = r110.rich_description;     // Catch: Exception -> L32
        if (r104 == null) goto L10;
        RichText r105 = r104.rich_text;     // Catch: Exception -> L32
    L11:
        r100.append(com.ss.android.lark.widget.richtext.i.l(j8c.c.a(r105)));     // Catch: Exception -> L32
        r100.append(", start_time=");     // Catch: Exception -> L32
        r100.append(r110.start_milli_time.longValue());     // Catch: Exception -> L32
        r100.append(", due_time=");     // Catch: Exception -> L32
        r100.append(r110.due_time.longValue());     // Catch: Exception -> L32
        r100.append(", is_all_day=");     // Catch: Exception -> L32
        r100.append(r110.is_all_day.booleanValue());     // Catch: Exception -> L32
        r100.append(", completed_milli_time=");     // Catch: Exception -> L32
        r100.append(r110.completed_milli_time.longValue());     // Catch: Exception -> L32
        r100.append(", deleted_milli_time=");     // Catch: Exception -> L32
        r100.append(r110.deleted_milli_time.longValue());     // Catch: Exception -> L32
        r100.append(", creator_id=");     // Catch: Exception -> L32
        r100.append(r110.creator_id);     // Catch: Exception -> L32
        r100.append(", create_milli_time=");     // Catch: Exception -> L32
        r100.append(String.valueOf(r110.create_milli_time));     // Catch: Exception -> L32
        r100.append(", is_not_mine=");     // Catch: Exception -> L32
        r100.append(String.valueOf(r110.is_not_mine));     // Catch: Exception -> L32
        r100.append(", item_max_version=");     // Catch: Exception -> L32
        r100.append(r110.item_max_version);     // Catch: Exception -> L32
        r100.append(", assignees=");     // Catch: Exception -> L32
        List<TodoAssignee> r106 = r110.assignees;     // Catch: Exception -> L32
        if (r106 == null) goto L14;
        String r107 = CollectionsKt.joinToString$default(r106, null, null, null, 0, null, LogMessageUtilKt$logInfo$1.INSTANCE, 31, null);     // Catch: Exception -> L32
    L15:
        r100.append(r107);     // Catch: Exception -> L32
        r100.append(", followers=");     // Catch: Exception -> L32
        List<TodoFollower> r108 = r110.followers;     // Catch: Exception -> L32
        if (r108 == null) goto L18;
        String r109 = CollectionsKt.joinToString$default(r108, null, null, null, 0, null, LogMessageUtilKt$logInfo$2.INSTANCE, 31, null);     // Catch: Exception -> L32
    L19:
        r100.append(r109);     // Catch: Exception -> L32
        r100.append(", source=");     // Catch: Exception -> L32
        r100.append(r110.source);     // Catch: Exception -> L32
        r100.append(", origin=");     // Catch: Exception -> L32
        TodoOrigin r111 = r110.origin;     // Catch: Exception -> L32
        if (r111 == null) goto L22;
        TodoOrigin.Type r112 = r111.type;     // Catch: Exception -> L32
    L23:
        r100.append(r112);     // Catch: Exception -> L32
        r100.append(", reminders=");     // Catch: Exception -> L32
        List<TodoReminder> r113 = r110.reminders;     // Catch: Exception -> L32
        if (r113 == null) goto L26;
        String r114 = CollectionsKt.joinToString$default(r113, null, null, null, 0, null, LogMessageUtilKt$logInfo$3.INSTANCE, 31, null);     // Catch: Exception -> L32
    L27:
        r100.append(r114);     // Catch: Exception -> L32
        r100.append(", self_permission=");     // Catch: Exception -> L32
        TodoItemPermission r115 = r110.self_permission;     // Catch: Exception -> L32
        if (r115 == null) goto L30;
        r102 = r115.is_editable;     // Catch: Exception -> L32
    L30:
        r100.append(r102);     // Catch: Exception -> L32
        r100.append(", task_list=");     // Catch: Exception -> L32
        r100.append(r110.related_task_list_guids.size());     // Catch: Exception -> L32
        r100.append(", attachments=");     // Catch: Exception -> L32
        r100.append(r110.attachments.size());     // Catch: Exception -> L32
    L34:
        r100.append('}');
        return r100.toString();
    L26:
        r114 = null;
        goto L27
    L22:
        r112 = null;
        goto L23
    L18:
        r109 = null;
        goto L19
    L14:
        r107 = null;
        goto L15
    L10:
        r105 = null;
        goto L11
    L6:
        r103 = null;
    L32:
        e = move-exception;
        r100.append(e.getMessage());
        goto L34
    }

    public static final String b(List<Todo> r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        StringBuilder r100 = new StringBuilder();
        Iterator<Todo> r111 = r110.iterator();     // Catch: Exception -> L12
    L4:
        if (r111.hasNext() == false) goto L14;
        Todo r101 = r111.next();     // Catch: Exception -> L12
        r100.append("Todo{guid=");     // Catch: Exception -> L12
        r100.append(r101.guid);     // Catch: Exception -> L12
        r100.append(", due_time=");     // Catch: Exception -> L12
        r100.append(r101.due_time.longValue());     // Catch: Exception -> L12
        r100.append(", completed_milli_time=");     // Catch: Exception -> L12
        r100.append(r101.completed_milli_time.longValue());     // Catch: Exception -> L12
        r100.append(", deleted_milli_time=");     // Catch: Exception -> L12
        r100.append(r101.deleted_milli_time.longValue());     // Catch: Exception -> L12
        r100.append(", creator_id=");     // Catch: Exception -> L12
        r100.append(r101.creator_id);     // Catch: Exception -> L12
        r100.append(", reminders=");     // Catch: Exception -> L12
        List<TodoReminder> r102 = r101.reminders;     // Catch: Exception -> L12
        if (r102 == null) goto L9;
        String r103 = CollectionsKt.joinToString$default(r102, null, null, null, 0, null, LogMessageUtilKt$logInfo$4.INSTANCE, 31, null);     // Catch: Exception -> L12
    L10:
        r100.append(r103);     // Catch: Exception -> L12
        goto L4
    L9:
        r103 = null;
    L14:
        r100.append('}');
        return r100.toString();
    L12:
        e = move-exception;
        r100.append(e.getMessage());
        goto L14
    }
}
