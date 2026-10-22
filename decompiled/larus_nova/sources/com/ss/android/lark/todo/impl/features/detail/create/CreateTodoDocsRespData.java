package com.ss.android.lark.todo.impl.features.detail.create;

import com.bytedance.lark.pb.todo.v1.TaskContainerRef;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/create/CreateTodoDocsRespData;", "", "<init>", "()V", IOfflineExtraParser.ParserType.TODO, "Lcom/bytedance/lark/pb/todo/v1/Todo;", "getTodo", "()Lcom/bytedance/lark/pb/todo/v1/Todo;", "setTodo", "(Lcom/bytedance/lark/pb/todo/v1/Todo;)V", "taskListContainerRefs", "", "Lcom/bytedance/lark/pb/todo/v1/TaskContainerRef;", "getTaskListContainerRefs", "()Ljava/util/List;", "setTaskListContainerRefs", "(Ljava/util/List;)V", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateTodoDocsRespData {
    private List<TaskContainerRef> taskListContainerRefs;
    private Todo todo;

    public CreateTodoDocsRespData() {
        this.taskListContainerRefs = CollectionsKt.emptyList();
    }

    public final List<TaskContainerRef> getTaskListContainerRefs() {
        return this.taskListContainerRefs;
    }

    public final Todo getTodo() {
        return this.todo;
    }

    public final void setTaskListContainerRefs(List<TaskContainerRef> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.taskListContainerRefs = r100;
    }

    public final void setTodo(Todo r100) {
        this.todo = r100;
    }
}
