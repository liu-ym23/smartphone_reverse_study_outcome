package com.ss.android.lark.todo.impl.features.detail.dependent;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.todo.v1.SearchTaskRequest;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.todo.impl.rustadapter.service.TodoRustCommon;
import com.ss.android.lark.todo.impl.rustadapter.service.a0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u001ej\b\u0012\u0004\u0012\u00020\u000f`\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/dependent/TaskDependentSearchViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "dependentType", "Lcom/ss/android/lark/todo/impl/features/detail/dependent/TaskDependentSearchViewModel$Companion$TaskDependentType;", "dependentTypeLv", "Landroidx/lifecycle/MutableLiveData;", "getDependentTypeLv", "()Landroidx/lifecycle/MutableLiveData;", "setDependentTypeLv", "(Landroidx/lifecycle/MutableLiveData;)V", "storeQueryStr", "", "searchTasks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/lark/pb/todo/v1/Todo;", "searchTasksLv", "getSearchTasksLv", "setSearchTasksLv", "selectTasks", "selectTasksLv", "getSelectTasksLv", "setSelectTasksLv", "isQueryEndLv", "", "setQueryEndLv", "ignoreGuids", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "selectTaskGuids", "", "taskGuid", "queryStr", "initData", "bundle", "Landroid/os/Bundle;", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskDependentSearchViewModel extends AndroidViewModel {
    public static final Companion Companion = null;
    private static final int QUERY_COUNT = 100;
    private static final String TAG = "TaskDependentSearchViewModel";
    private Companion.TaskDependentType dependentType;
    private MutableLiveData<Companion.TaskDependentType> dependentTypeLv;
    private ArrayList<String> ignoreGuids;
    private MutableLiveData<Boolean> isQueryEndLv;
    private CopyOnWriteArrayList<Todo> searchTasks;
    private MutableLiveData<CopyOnWriteArrayList<Todo>> searchTasksLv;
    private CopyOnWriteArrayList<Todo> selectTasks;
    private MutableLiveData<CopyOnWriteArrayList<Todo>> selectTasksLv;
    private String storeQueryStr;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/dependent/TaskDependentSearchViewModel$Companion$TaskDependentType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TYPE", "PREV", "NEXT", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum TaskDependentType extends Enum<TaskDependentType> {
            public static final a Companion = null;
            public static final TaskDependentType NEXT = null;
            public static final TaskDependentType PREV = null;
            public static final TaskDependentType UNKNOWN_TYPE = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ TaskDependentType[] f443056a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f443057b = null;
            private final int value;

            public static final class a {
                public a() {
                }

                public static TaskDependentType a(int r100) {
                    if (r100 == 0) goto L11;
                    if (r100 == 1) goto L14;
                    if (r100 == 2) goto L13;
                    return TaskDependentType.UNKNOWN_TYPE;
                L13:
                    return TaskDependentType.NEXT;
                L14:
                    return TaskDependentType.PREV;
                L11:
                    return TaskDependentType.UNKNOWN_TYPE;
                }
            }

            public static EnumEntries<TaskDependentType> getEntries() {
                return f443057b;
            }

            static {
                TaskDependentType r100 = new TaskDependentType("UNKNOWN_TYPE", 0, 0);
                UNKNOWN_TYPE = r100;
                TaskDependentType r101 = new TaskDependentType("PREV", 1, 1);
                PREV = r101;
                TaskDependentType r102 = new TaskDependentType("NEXT", 2, 2);
                NEXT = r102;
                TaskDependentType[] r103 = {r100, r101, r102};
                f443056a = r103;
                f443057b = EnumEntriesKt.enumEntries(r103);
                Companion = new a();
            }

            public static TaskDependentType[] values() {
                return (TaskDependentType[]) f443056a.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static TaskDependentType valueOf(String r100) {
                return (TaskDependentType) r27.a.a(TaskDependentType.class, r100);
            }

            public TaskDependentType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public Companion() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.detail.dependent.TaskDependentSearchViewModel$searchTasks$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.todo.impl.features.detail.dependent.TaskDependentSearchViewModel$searchTasks$1", f = "TaskDependentSearchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $queryStr;
        int label;
        final /* synthetic */ TaskDependentSearchViewModel this$0;

        public AnonymousClass1(String r100, TaskDependentSearchViewModel r101, Continuation<? super AnonymousClass1> r102) {
            this.$queryStr = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$queryStr, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            TodoRustCommon r101 = TodoRustCommon.f444251a;
            String r102 = this.$queryStr;
            final TaskDependentSearchViewModel r103 = this.this$0;
            UIGetDataCallback r104 = new UIGetDataCallback(new C53501(r103));
            Intrinsics.checkNotNullParameter(r102, "queryStr");
            Intrinsics.checkNotNullParameter(r104, "callback");
            SearchTaskRequest.Builder r105 = new SearchTaskRequest.Builder().query(r102).token("").count(100).range(SearchTaskRequest.DataRange.CAN_READ);
            SdkSender.asynSendRequestNonWrap(Command.SEARCH_TASKS, r105, r104, a0.f444254a);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new Companion();
    }

    public final MutableLiveData<Companion.TaskDependentType> getDependentTypeLv() {
        return this.dependentTypeLv;
    }

    public final MutableLiveData<CopyOnWriteArrayList<Todo>> getSearchTasksLv() {
        return this.searchTasksLv;
    }

    public final MutableLiveData<CopyOnWriteArrayList<Todo>> getSelectTasksLv() {
        return this.selectTasksLv;
    }

    public final MutableLiveData<Boolean> isQueryEndLv() {
        return this.isQueryEndLv;
    }

    public TaskDependentSearchViewModel(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        super(r100);
        this.dependentType = Companion.TaskDependentType.UNKNOWN_TYPE;
        this.dependentTypeLv = new MutableLiveData(this.dependentType);
        this.searchTasks = new CopyOnWriteArrayList();
        this.searchTasksLv = new MutableLiveData(this.searchTasks);
        this.selectTasks = new CopyOnWriteArrayList();
        this.selectTasksLv = new MutableLiveData(this.selectTasks);
        this.isQueryEndLv = new MutableLiveData(Boolean.TRUE);
        this.ignoreGuids = new ArrayList();
    }

    public static final /* synthetic */ ArrayList access$getIgnoreGuids$p(TaskDependentSearchViewModel r100) {
        return r100.ignoreGuids;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getSearchTasks$p(TaskDependentSearchViewModel r100) {
        return r100.searchTasks;
    }

    public static final /* synthetic */ String access$getStoreQueryStr$p(TaskDependentSearchViewModel r100) {
        return r100.storeQueryStr;
    }

    public final void initData(Bundle r100) {
        if (r100 == null) goto L17;
        Serializable r101 = r100.getSerializable("custom_task_dependent_type");
        ArrayList<String> r102 = null;
        if ((r101 instanceof Integer) == false) goto L6;
        Integer r103 = (Integer) r101;
    L7:
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L10:
        ArrayList<String> r105 = r100.getStringArrayList("custom_task_dependent_ignore_ids");
        if ((r105 instanceof ArrayList) == false) goto L13;
        r102 = r105;
    L13:
        if (r102 != null) goto L15;
        r102 = new ArrayList();
    L15:
        this.ignoreGuids = r102;
        Companion.TaskDependentType.Companion.getClass();
        Companion.TaskDependentType r106 = Companion.TaskDependentType.a.a(r104);
        this.dependentType = r106;
        this.dependentTypeLv.postValue(r106);
        return;
    L9:
        r104 = 0;
        goto L10
    L6:
        r103 = null;
        goto L7
    }

    public final void searchTasks(String r100) {
        this.storeQueryStr = r100;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        this.isQueryEndLv.postValue(Boolean.TRUE);
        return;
    L12:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r100, this, null), 3, null);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void selectTaskGuids(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        Iterator<T> r102 = this.selectTasks.iterator();
    L11:
        Object r103 = null;
        if (r102.hasNext() == false) goto L16;
        Object r104 = r102.next();
        if (Intrinsics.areEqual(((Todo) r104).guid, r100) == false) goto L11;
    L17:
        Todo r105 = (Todo) r104;
        if (r105 == null) goto L20;
        this.selectTasks.remove(r105);
    L29:
        this.selectTasksLv.postValue(this.selectTasks);
        return;
    L20:
        Iterator<T> r106 = this.searchTasks.iterator();
    L22:
        if (r106.hasNext() == false) goto L26;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((Todo) r107).guid, r100) == false) goto L22;
        r103 = r107;
    L26:
        Todo r108 = (Todo) r103;
        if (r108 == null) goto L29;
        this.selectTasks.add(r108);
        goto L29
    L16:
        r104 = null;
        goto L17
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public final void setDependentTypeLv(MutableLiveData<Companion.TaskDependentType> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dependentTypeLv = r100;
    }

    public final void setQueryEndLv(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.isQueryEndLv = r100;
    }

    public final void setSearchTasksLv(MutableLiveData<CopyOnWriteArrayList<Todo>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.searchTasksLv = r100;
    }

    public final void setSelectTasksLv(MutableLiveData<CopyOnWriteArrayList<Todo>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.selectTasksLv = r100;
    }

    public static final /* synthetic */ void access$setSearchTasks$p(TaskDependentSearchViewModel r100, CopyOnWriteArrayList r101) {
        r100.searchTasks = r101;
    }
}
