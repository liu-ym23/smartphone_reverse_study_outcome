package com.ss.android.lark.todo.impl.features.detail.create;

import com.bytedance.lark.pb.todo.v1.ContainerSection;
import com.bytedance.lark.pb.todo.v1.Todo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/create/CreateTodoDocxParams;", "", "<init>", "()V", "task", "Lcom/bytedance/lark/pb/todo/v1/Todo;", "getTask", "()Lcom/bytedance/lark/pb/todo/v1/Todo;", "setTask", "(Lcom/bytedance/lark/pb/todo/v1/Todo;)V", "taskListSection", "Lcom/bytedance/lark/pb/todo/v1/ContainerSection;", "getTaskListSection", "()Lcom/bytedance/lark/pb/todo/v1/ContainerSection;", "setTaskListSection", "(Lcom/bytedance/lark/pb/todo/v1/ContainerSection;)V", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateTodoDocxParams {
    private Todo task;
    private ContainerSection taskListSection;

    public CreateTodoDocxParams() {
    }

    public final Todo getTask() {
        return this.task;
    }

    public final ContainerSection getTaskListSection() {
        return this.taskListSection;
    }

    public final void setTask(Todo r100) {
        this.task = r100;
    }

    public final void setTaskListSection(ContainerSection r100) {
        this.taskListSection = r100;
    }
}
