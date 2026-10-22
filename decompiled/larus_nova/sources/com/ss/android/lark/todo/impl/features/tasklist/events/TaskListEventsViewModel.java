package com.ss.android.lark.todo.impl.features.tasklist.events;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.locallife.dito.data.DitoNode;
import com.larksuite.arch.jack.j;
import com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u0002H\u0014J%\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u0001H\rH\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\fH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListEventsViewModel;", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListEventsState;", "Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListEventsAction;", "subModel", "Lcom/ss/android/lark/todo/impl/features/tasklist/events/ITaskListEventModel;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/tasklist/events/ITaskListEventModel;)V", "getSubModel", "()Lcom/ss/android/lark/todo/impl/features/tasklist/events/ITaskListEventModel;", "defaultState", "handleAction", "", ExifInterface.GPS_DIRECTION_TRUE, "action", "actionData", "(Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListEventsAction;Ljava/lang/Object;)V", DitoNode.LOAD_MORE, "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskListEventsViewModel extends SubViewModel<g, e> {
    private final b subModel;

    private final void loadMore() {
        getSubModel().loadTaskListEvent(false);
    }

    @Override // com.larksuite.arch.jack.JackViewModel
    public g defaultState() {
        return getSubModel().getTaskListEventsState();
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public /* bridge */ /* synthetic */ com.ss.android.lark.todo.impl.features.center.v3.arch.a getSubModel() {
        return getSubModel();
    }

    @Override // com.larksuite.arch.jack.JackViewModel
    public /* bridge */ /* synthetic */ j defaultState() {
        return defaultState();
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public b getSubModel() {
        return this.subModel;
    }

    public TaskListEventsViewModel(b r100) {
        Intrinsics.checkNotNullParameter(r100, "subModel");
        this.subModel = r100;
    }

    public <T> void handleAction(e r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(r100, e.b.f444070a) == false) goto L6;
        loadMore();
        return;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public /* bridge */ /* synthetic */ void handleAction(com.ss.android.lark.todo.impl.features.center.v3.arch.b r100, Object r101) {
        handleAction((e) r100, r101);
    }
}
