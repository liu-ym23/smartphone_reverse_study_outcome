package com.ss.android.lark.todo.impl.features.center.v3.viewmodel;

import com.bytedance.lark.pb.todo.v1.TaskContainerFilter;
import com.ss.android.lark.todo.impl.features.center.v3.view.tasklist.manage.TaskListDisplayItem;
import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J-\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/viewmodel/TaskListDisplayData;", "Ljava/io/Serializable;", "taskListDisplayItems", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/tasklist/manage/TaskListDisplayItem;", "archiveCategory", "Lcom/bytedance/lark/pb/todo/v1/TaskContainerFilter$StatusFilter$TaskContainerArchiveCategory;", "tabCategory", "Lcom/bytedance/lark/pb/todo/v1/TaskContainerFilter$TabFilter$TaskContainerTabCategory;", "<init>", "(Ljava/util/concurrent/CopyOnWriteArrayList;Lcom/bytedance/lark/pb/todo/v1/TaskContainerFilter$StatusFilter$TaskContainerArchiveCategory;Lcom/bytedance/lark/pb/todo/v1/TaskContainerFilter$TabFilter$TaskContainerTabCategory;)V", "getTaskListDisplayItems", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setTaskListDisplayItems", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "getArchiveCategory", "()Lcom/bytedance/lark/pb/todo/v1/TaskContainerFilter$StatusFilter$TaskContainerArchiveCategory;", "setArchiveCategory", "(Lcom/bytedance/lark/pb/todo/v1/TaskContainerFilter$StatusFilter$TaskContainerArchiveCategory;)V", "getTabCategory", "()Lcom/bytedance/lark/pb/todo/v1/TaskContainerFilter$TabFilter$TaskContainerTabCategory;", "setTabCategory", "(Lcom/bytedance/lark/pb/todo/v1/TaskContainerFilter$TabFilter$TaskContainerTabCategory;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskListDisplayData implements Serializable {
    private TaskContainerFilter.StatusFilter.TaskContainerArchiveCategory archiveCategory;
    private TaskContainerFilter.TabFilter.TaskContainerTabCategory tabCategory;
    private CopyOnWriteArrayList<TaskListDisplayItem> taskListDisplayItems;

    public TaskListDisplayData() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskListDisplayData copy$default(TaskListDisplayData r100, CopyOnWriteArrayList r101, TaskContainerFilter.StatusFilter.TaskContainerArchiveCategory r102, TaskContainerFilter.TabFilter.TaskContainerTabCategory r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.taskListDisplayItems;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.archiveCategory;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.tabCategory;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final CopyOnWriteArrayList<TaskListDisplayItem> component1() {
        return this.taskListDisplayItems;
    }

    public final TaskContainerFilter.StatusFilter.TaskContainerArchiveCategory component2() {
        return this.archiveCategory;
    }

    public final TaskContainerFilter.TabFilter.TaskContainerTabCategory component3() {
        return this.tabCategory;
    }

    public final TaskListDisplayData copy(CopyOnWriteArrayList<TaskListDisplayItem> r100, TaskContainerFilter.StatusFilter.TaskContainerArchiveCategory r101, TaskContainerFilter.TabFilter.TaskContainerTabCategory r102) {
        Intrinsics.checkNotNullParameter(r100, "taskListDisplayItems");
        Intrinsics.checkNotNullParameter(r101, "archiveCategory");
        Intrinsics.checkNotNullParameter(r102, "tabCategory");
        return new TaskListDisplayData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TaskListDisplayData) == true) goto L8;
        return false;
    L8:
        TaskListDisplayData r101 = (TaskListDisplayData) r100;
        if (Intrinsics.areEqual(this.taskListDisplayItems, r101.taskListDisplayItems) == true) goto L12;
        return false;
    L12:
        if (this.archiveCategory == r101.archiveCategory) goto L15;
        return false;
    L15:
        if (this.tabCategory == r101.tabCategory) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.taskListDisplayItems.hashCode() * 31) + this.archiveCategory.hashCode()) * 31) + this.tabCategory.hashCode();
    }

    public String toString() {
        return "TaskListDisplayData(taskListDisplayItems=" + this.taskListDisplayItems + ", archiveCategory=" + this.archiveCategory + ", tabCategory=" + this.tabCategory + ')';
    }

    public final TaskContainerFilter.StatusFilter.TaskContainerArchiveCategory getArchiveCategory() {
        return this.archiveCategory;
    }

    public final TaskContainerFilter.TabFilter.TaskContainerTabCategory getTabCategory() {
        return this.tabCategory;
    }

    public final CopyOnWriteArrayList<TaskListDisplayItem> getTaskListDisplayItems() {
        return this.taskListDisplayItems;
    }

    public final void setArchiveCategory(TaskContainerFilter.StatusFilter.TaskContainerArchiveCategory r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.archiveCategory = r100;
    }

    public final void setTabCategory(TaskContainerFilter.TabFilter.TaskContainerTabCategory r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabCategory = r100;
    }

    public final void setTaskListDisplayItems(CopyOnWriteArrayList<TaskListDisplayItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.taskListDisplayItems = r100;
    }

    public TaskListDisplayData(CopyOnWriteArrayList<TaskListDisplayItem> r100, TaskContainerFilter.StatusFilter.TaskContainerArchiveCategory r101, TaskContainerFilter.TabFilter.TaskContainerTabCategory r102) {
        Intrinsics.checkNotNullParameter(r100, "taskListDisplayItems");
        Intrinsics.checkNotNullParameter(r101, "archiveCategory");
        Intrinsics.checkNotNullParameter(r102, "tabCategory");
        this.taskListDisplayItems = r100;
        this.archiveCategory = r101;
        this.tabCategory = r102;
    }

    public /* synthetic */ TaskListDisplayData(CopyOnWriteArrayList r100, TaskContainerFilter.StatusFilter.TaskContainerArchiveCategory r101, TaskContainerFilter.TabFilter.TaskContainerTabCategory r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = new CopyOnWriteArrayList();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = TaskContainerFilter.StatusFilter.TaskContainerArchiveCategory.TASK_CONTAINER_UNARCHIVED;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = TaskContainerFilter.TabFilter.TaskContainerTabCategory.TASK_CONTAINER_ALL;
    L11:
        this(r100, r101, r102);
    }
}
