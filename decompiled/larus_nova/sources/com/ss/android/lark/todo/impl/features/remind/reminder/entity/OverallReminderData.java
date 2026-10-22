package com.ss.android.lark.todo.impl.features.remind.reminder.entity;

import com.bytedance.lark.pb.todo.v1.PushTodoReminder;
import com.bytedance.lark.pb.todo.v1.TodoReminder;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0000J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0000H\u0002J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/remind/reminder/entity/OverallReminderData;", "Ljava/io/Serializable;", "todoReminder", "Lcom/bytedance/lark/pb/todo/v1/PushTodoReminder;", "arriveTime", "", "<init>", "(Lcom/bytedance/lark/pb/todo/v1/PushTodoReminder;J)V", "getTodoReminder", "()Lcom/bytedance/lark/pb/todo/v1/PushTodoReminder;", "setTodoReminder", "(Lcom/bytedance/lark/pb/todo/v1/PushTodoReminder;)V", "getArriveTime", "()J", "setArriveTime", "(J)V", "equals", "", "other", "", "equalExceptRemindMinute", "overallReminderUnit", "getId", "", "isSameWithoutTodoReminder", "component1", "component2", "copy", "hashCode", "", "toString", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OverallReminderData implements Serializable {
    private long arriveTime;
    private PushTodoReminder todoReminder;

    public static /* synthetic */ OverallReminderData copy$default(OverallReminderData r100, PushTodoReminder r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.todoReminder;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.arriveTime;
    L9:
        return r100.copy(r101, r102);
    }

    public final PushTodoReminder component1() {
        return this.todoReminder;
    }

    public final long component2() {
        return this.arriveTime;
    }

    public final OverallReminderData copy(PushTodoReminder r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "todoReminder");
        return new OverallReminderData(r100, r101);
    }

    public int hashCode() {
        int r100 = this.todoReminder.hashCode() * 31;
        long r101 = this.arriveTime;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public String toString() {
        return "OverallReminderData(todoReminder=" + this.todoReminder + ", arriveTime=" + this.arriveTime + ')';
    }

    public final String getId() {
        return this.todoReminder.guid + "_" + this.todoReminder.summary + "_" + this.todoReminder.due_time.longValue() + "_" + this.todoReminder.due_timezone;
    }

    public final long getArriveTime() {
        return this.arriveTime;
    }

    public final PushTodoReminder getTodoReminder() {
        return this.todoReminder;
    }

    public final boolean a(OverallReminderData r100) {
        if (Intrinsics.areEqual(this.todoReminder.guid, r100.todoReminder.guid) == true) goto L5;
    L13:
        return false;
    L5:
        if (Intrinsics.areEqual(this.todoReminder.summary, r100.todoReminder.summary) == false) goto L13;
        if (Intrinsics.areEqual(this.todoReminder.due_time, r100.todoReminder.due_time) == false) goto L13;
        if (Intrinsics.areEqual(this.todoReminder.due_timezone, r100.todoReminder.due_timezone) == false) goto L13;
        if (Intrinsics.areEqual(this.todoReminder.is_all_day, r100.todoReminder.is_all_day) == false) goto L13;
        return true;
    }

    public final boolean equalExceptRemindMinute(OverallReminderData r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        return a(r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof OverallReminderData) == true) goto L8;
        return false;
    L8:
        if (this != r100) goto L10;
        return true;
    L10:
        OverallReminderData r101 = (OverallReminderData) r100;
        if (this.arriveTime == r101.arriveTime) goto L13;
        return false;
    L13:
        if (a(r101) == false) goto L27;
        TodoReminder r102 = this.todoReminder.reminder;
        Long r103 = null;
        if (r102 == null) goto L17;
        Long r104 = r102.time;
    L18:
        TodoReminder r105 = r101.todoReminder.reminder;
        if (r105 == null) goto L22;
        r103 = r105.time;
    L22:
        if (Intrinsics.areEqual(r104, r103) == false) goto L28;
        return true;
    L28:
        return false;
    L17:
        r104 = null;
        goto L18
    L27:
        return false;
    }

    public final void setArriveTime(long r100) {
        this.arriveTime = r100;
    }

    public final void setTodoReminder(PushTodoReminder r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.todoReminder = r100;
    }

    public OverallReminderData(PushTodoReminder r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "todoReminder");
        this.todoReminder = r100;
        this.arriveTime = r101;
    }
}
