package com.ss.android.lark.todo.impl.features.center.v3.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.locallife.dito.data.DitoNode;
import com.larksuite.arch.jack.j;
import com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel;
import com.ss.android.lark.todo.impl.features.center.v3.arch.c;
import com.ss.android.lark.todo.impl.features.tasklist.events.e;
import com.ss.android.lark.todo.impl.features.tasklist.events.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0014J%\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u0001H\u0013H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/viewmodel/TaskCenterEventsViewModel;", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListEventsState;", "Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListEventsAction;", "subModel", "Lcom/ss/android/lark/todo/impl/features/tasklist/events/ITaskListEventModel;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/tasklist/events/ITaskListEventModel;)V", "getSubModel", "()Lcom/ss/android/lark/todo/impl/features/tasklist/events/ITaskListEventModel;", "viewEventStore", "Lcom/ss/android/lark/todo/impl/features/center/v3/viewmodel/TaskCenterEventsViewModel$TaskListAllEventsStore;", "getViewEventStore", "()Lcom/ss/android/lark/todo/impl/features/center/v3/viewmodel/TaskCenterEventsViewModel$TaskListAllEventsStore;", "viewEventStore$delegate", "Lkotlin/Lazy;", "defaultState", "handleAction", "", ExifInterface.GPS_DIRECTION_TRUE, "action", "actionData", "(Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListEventsAction;Ljava/lang/Object;)V", DitoNode.LOAD_MORE, "TaskListAllEventsStore", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskCenterEventsViewModel extends SubViewModel<g, e> {
    private final com.ss.android.lark.todo.impl.features.tasklist.events.b subModel;
    private final Lazy viewEventStore$delegate;

    public static final class a implements com.ss.android.lark.todo.impl.features.center.v3.viewmodel.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MutableLiveData<Boolean> f442183a;

        public a() {
            this.f442183a = new MutableLiveData(Boolean.TRUE);
        }

        @Override // com.ss.android.lark.todo.impl.features.center.v3.viewmodel.a
        public final MutableLiveData a() {
            return this.f442183a;
        }
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public a getViewEventStore() {
        return (a) this.viewEventStore$delegate.getValue();
    }

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
    public com.ss.android.lark.todo.impl.features.tasklist.events.b getSubModel() {
        return this.subModel;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public /* bridge */ /* synthetic */ c getViewEventStore() {
        return getViewEventStore();
    }

    public TaskCenterEventsViewModel(com.ss.android.lark.todo.impl.features.tasklist.events.b r100) {
        Intrinsics.checkNotNullParameter(r100, "subModel");
        this.subModel = r100;
        this.viewEventStore$delegate = LazyKt.lazy(TaskCenterEventsViewModel$viewEventStore$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void handleAction(e r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(r100, e.b.f444070a) == false) goto L6;
        loadMore();
        return;
    L6:
        if (Intrinsics.areEqual(r100, e.a.f444069a) == false) goto L16;
        com.ss.android.lark.todo.impl.features.tasklist.events.b r102 = getSubModel();
        if ((r101 instanceof String) == false) goto L10;
        String r103 = (String) r101;
    L11:
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        r102.goTaskListActivity(r103);
        return;
    L10:
        r103 = null;
        goto L11
    L16:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public /* bridge */ /* synthetic */ void handleAction(com.ss.android.lark.todo.impl.features.center.v3.arch.b r100, Object r101) {
        handleAction((e) r100, r101);
    }
}
