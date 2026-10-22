package com.ss.android.lark.todo.impl.features.center.v3.viewmodel;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.crash.Npth;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.todo.v1.DeleteTaskSectionRequest;
import com.bytedance.lark.pb.todo.v1.TaskContainer;
import com.bytedance.lark.pb.todo.v1.TaskSection;
import com.bytedance.lark.pb.todo.v1.TaskSectionUpdateEntity;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.bytedance.lark.pb.todo.v1.TodoReminder;
import com.bytedance.lark.pb.todo.v1.UpsertTaskSectionsRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larksuite.arch.jack.j;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.h0;
import com.larus.nova.R;
import com.ss.android.eventbus.EventBus;
import com.ss.android.eventbus.Subscribe;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskContainerData;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskSectionData;
import com.ss.android.lark.todo.impl.features.center.v3.entity.TodoFetchStatus;
import com.ss.android.lark.todo.impl.features.common.helper.OperationToastHelper;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.TimeBean;
import com.ss.android.lark.todo.impl.rustadapter.service.RustLog;
import com.ss.android.lark.todo.impl.rustadapter.service.TodoRustCRUD;
import com.ss.android.lark.todo.impl.rustadapter.service.q;
import com.ss.android.lark.todo.impl.rustadapter.service.u;
import com.ss.android.lark.todo.impl.utils.i;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttm.player.MediaPlayer;
import g7c.t;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import m7c.f;
import m7c.g;
import m7c.h;
import m7c.l;
import m7c.m;
import me.ele.lancet.base.annotations.Skip;
import q7c.e;
import t7c.d;
import z5c.p3;
import z5c.r;
import z5c.r3;
import z5c.y3;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 w2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002wxB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\b\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\u0002H\u0014J%\u0010&\u001a\u00020\"\"\u0004\b\u0000\u0010'2\u0006\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u0001H'H\u0016¢\u0006\u0002\u0010*J*\u0010+\u001a\u00020\"2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110/H\u0002J$\u00100\u001a\u00020\"2\f\u00101\u001a\b\u0012\u0004\u0012\u000203022\f\u00104\u001a\b\u0012\u0004\u0012\u0002030-H\u0002J(\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u0011H\u0002J\b\u0010:\u001a\u00020\"H\u0002J\u0010\u0010;\u001a\u00020\"2\u0006\u00106\u001a\u00020\u0011H\u0002J\u0010\u0010<\u001a\u00020\"2\u0006\u00106\u001a\u00020\u0011H\u0002J\u0010\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020\u0011H\u0002J\u0010\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0002J\u0018\u0010F\u001a\u00020\"2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u000203H\u0002J\u0010\u0010J\u001a\u00020\"2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010M\u001a\u00020\"2\u0006\u0010N\u001a\u00020\u0011H\u0002J\u0010\u0010O\u001a\u00020\"2\u0006\u0010N\u001a\u00020\u0011H\u0002J\u0010\u0010P\u001a\u00020\"2\u0006\u0010Q\u001a\u00020RH\u0002J\u0010\u0010S\u001a\u00020\"2\u0006\u0010N\u001a\u00020\u0011H\u0002J\u0010\u0010T\u001a\u00020\"2\u0006\u0010N\u001a\u00020\u0011H\u0002J\u0010\u0010U\u001a\u00020\"2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010X\u001a\u00020\"2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0010\u0010[\u001a\u00020\"2\u0006\u0010\\\u001a\u00020]H\u0007J.\u0010^\u001a\u00020\"2\u0006\u0010_\u001a\u00020\u00112\b\b\u0002\u0010`\u001a\u00020\u00112\b\b\u0002\u0010>\u001a\u00020\u00112\b\b\u0002\u0010a\u001a\u00020\u0011H\u0002J\"\u0010b\u001a\u00020\"2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020d2\b\u0010f\u001a\u0004\u0018\u00010gH\u0016J\b\u0010h\u001a\u00020\"H\u0002J\b\u0010i\u001a\u00020\"H\u0002J\b\u0010j\u001a\u00020\"H\u0002J\b\u0010k\u001a\u00020\"H\u0002J\b\u0010l\u001a\u00020\"H\u0002J\b\u0010m\u001a\u00020\"H\u0002J\b\u0010n\u001a\u00020\"H\u0002J\b\u0010o\u001a\u00020\"H\u0002J\b\u0010p\u001a\u00020\"H\u0002J\b\u0010q\u001a\u00020\"H\u0002J\b\u0010r\u001a\u00020\"H\u0002J\b\u0010s\u001a\u00020\"H\u0002J\u0006\u0010t\u001a\u00020\"J\b\u0010u\u001a\u00020\"H\u0016J\b\u0010v\u001a\u00020\"H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/viewmodel/ListViewModel;", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "Lcom/ss/android/lark/todo/impl/features/center/v3/viewstate/ListViewState;", "Lcom/ss/android/lark/todo/impl/features/center/v3/action/ListViewAction;", "subModel", "Lcom/ss/android/lark/todo/impl/features/center/v3/model/IListModel;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/center/v3/model/IListModel;)V", "getSubModel", "()Lcom/ss/android/lark/todo/impl/features/center/v3/model/IListModel;", "viewEventStore", "Lcom/ss/android/lark/todo/impl/features/center/v3/eventstore/ListViewEventStore;", "getViewEventStore", "()Lcom/ss/android/lark/todo/impl/features/center/v3/eventstore/ListViewEventStore;", "viewEventStore$delegate", "Lkotlin/Lazy;", "operationId", "", "modifyTodo", "Lcom/bytedance/lark/pb/todo/v1/Todo;", "todoChangedNotification", "Lcom/ss/android/lark/todo/impl/rustadapter/push/TodoPushHandleCallBack;", "todoExtraChangeNotification", "sectionChangedNotification", "taskContainerRefChangeNotification", "timeFormatChangeListener", "Lcom/ss/android/lark/todo/dependency/idependency/ITimeFormatDependency$ITimeFormatChangeListener;", "isTimezoneRegister", "", "todoTimeZoneReceiver", "Landroid/content/BroadcastReceiver;", "listScheduledFuture", "Lcom/ss/android/lark/todo/impl/features/center/v3/schedule/TodoListSchedule;", "startScheduled", "", "cancelScheduled", "initViewModel", "defaultState", "handleAction", ExifInterface.GPS_DIRECTION_TRUE, "action", "actionData", "(Lcom/ss/android/lark/todo/impl/features/center/v3/action/ListViewAction;Ljava/lang/Object;)V", "sectionSortSave", "sectionGuids", "", "sectionRankMap", "", "updateTaskSections", "oldSections", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/lark/pb/todo/v1/TaskSection;", "newSections", "taskItemDrag", "taskGuid", "toSectionGuid", "beforeTaskGuid", "afterTaskGuid", "cancelArchiveTaskList", "scrollPositionAction", "goDetailActivity", "deleteSection", "sectionGuid", "createInline", "sectionInlineData", "Lcom/ss/android/lark/todo/impl/features/center/v3/action/SectionInlineData;", "createPrevSection", "sectionCreateData", "Lcom/ss/android/lark/todo/impl/features/center/v3/action/SectionCreateData;", "createNextSection", "addNewDefinedSection", "containerData", "Lcom/ss/android/lark/todo/impl/features/center/v3/data/TaskContainerData;", "section", "sectionRename", "sectionRenameData", "Lcom/ss/android/lark/todo/impl/features/center/v3/action/SectionRenameData;", "modifyOwner", "guid", "modifyDueTime", "shareTodo", "shareData", "Lcom/ss/android/lark/todo/impl/features/center/v3/action/TaskShareData;", "quitTodo", "deleteTodo", "sectionExpand", "titleClickData", "Lcom/ss/android/lark/todo/impl/features/center/v3/action/TitleClickData;", "checkBoxClick", "checkBoxClickData", "Lcom/ss/android/lark/todo/impl/features/center/v3/action/CheckBoxClickData;", "onAddTodoEvent", "addTodoEvent", "Lcom/ss/android/lark/todo/impl/framework/busevents/AddTodoEvent;", "addTodoRef", "todoGuid", "containerGuid", "rank", "registerActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "registerTaskSectionNotificationPush", "registerTodoChangeNotificationPush", "registerTaskContainerRefsNotificationPush", "registerTodoExtraChangeNotificationPush", "unRegisterTodoChangeNotificationPush", "unRegisterTaskSectionNotificationPush", "unRegisterTaskContainerRefsNotificationPush", "unRegisterTodoExtraChangeNotificationPush", "registerSystemTimeZoneReceiver", "unRegisterSystemTimeZoneReceiver", "registerTimeFormatChangePush", "unRegisterTimeFormatChangePush", "clearList", "onPause", "onClear", "Companion", "IListViewEventStore", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListViewModel extends SubViewModel<d, g> {
    public static final a Companion = null;
    private static final String TAG = "ListViewModel";
    private boolean isTimezoneRegister;
    private r7c.a listScheduledFuture;
    private Todo modifyTodo;
    private final String operationId;
    private com.ss.android.lark.todo.impl.rustadapter.push.a sectionChangedNotification;
    private final e subModel;
    private com.ss.android.lark.todo.impl.rustadapter.push.a taskContainerRefChangeNotification;
    private t.a timeFormatChangeListener;
    private com.ss.android.lark.todo.impl.rustadapter.push.a todoChangedNotification;
    private com.ss.android.lark.todo.impl.rustadapter.push.a todoExtraChangeNotification;
    private final BroadcastReceiver todoTimeZoneReceiver;
    private final Lazy viewEventStore$delegate;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.center.v3.viewmodel.ListViewModel$addNewDefinedSection$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.todo.impl.features.center.v3.viewmodel.ListViewModel$addNewDefinedSection$1", f = "ListViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TaskContainerData $containerData;
        final /* synthetic */ TaskSection $section;
        int label;
        final /* synthetic */ ListViewModel this$0;

        public AnonymousClass1(TaskSection r100, ListViewModel r101, TaskContainerData r102, Continuation<? super AnonymousClass1> r103) {
            this.$section = r100;
            this.this$0 = r101;
            this.$containerData = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$section, this.this$0, this.$containerData, r101);
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
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            final RustLog.b r103 = (RustLog.b) r100;
            if (r103.f444239b == null) goto L14;
            this.this$0.getViewEventStore().f522294a.postValue(new n7c.a(R.string.Todo_common_SthWentWrongTryLater, OperationToastHelper.ToastType.FAIL, null));
        L16:
            return Unit.INSTANCE;
        L14:
            final ListViewModel r104 = this.this$0;
            final TaskContainerData r105 = this.$containerData;
            r104.modifyModelData(new C53311(r103, r104, r105));
            this.this$0.getViewEventStore().f522294a.postValue(new n7c.a(R.string.Todo_CollabTask_Successful, OperationToastHelper.ToastType.SUCCESS, null));
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            int r106 = com.ss.android.lark.todo.impl.rustadapter.service.t.f444263a;
            TaskSection r107 = this.$section;
            this.label = 1;
            r100 = com.ss.android.lark.todo.impl.rustadapter.service.t.a(null, r107, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    public interface b extends com.ss.android.lark.todo.impl.features.center.v3.arch.c {
        MutableLiveData a();

        MutableLiveData b();

        MutableLiveData c();

        MutableLiveData d();

        MutableLiveData e();

        MutableLiveData f();

        MutableLiveData g();

        MutableLiveData i();

        MutableLiveData j();
    }

    public static final class c implements t.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListViewModel f442175a;

        public c(ListViewModel r100) {
            this.f442175a = r100;
        }

        @Override // g7c.t.a
        public final void a() {
            Log.i(ListViewModel.TAG, com.ss.android.lark.todo.impl.utils.g.j("pushTimeFormatChange"));
            this.f442175a.refreshViewState();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.center.v3.viewmodel.ListViewModel$deleteSection$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.todo.impl.features.center.v3.viewmodel.ListViewModel$deleteSection$1", f = "ListViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE}, m = "invokeSuspend", n = {}, s = {})
    public static final class C122011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TaskContainerData $curContainer;
        final /* synthetic */ String $sectionGuid;
        int label;
        final /* synthetic */ ListViewModel this$0;

        public C122011(String r100, TaskContainerData r101, ListViewModel r102, Continuation<? super C122011> r103) {
            this.$sectionGuid = r100;
            this.$curContainer = r101;
            this.this$0 = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C122011(this.$sectionGuid, this.$curContainer, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C122011) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            if (((RustLog.b) r100).f444239b == null) goto L14;
            this.this$0.getViewEventStore().f522294a.postValue(new n7c.a(R.string.Todo_common_SthWentWrongTryLater, OperationToastHelper.ToastType.FAIL, null));
        L16:
            return Unit.INSTANCE;
        L14:
            this.this$0.getViewEventStore().f522294a.postValue(new n7c.a(R.string.Todo_CollabTask_Successful, OperationToastHelper.ToastType.SUCCESS, null));
            final ListViewModel r103 = this.this$0;
            final TaskContainerData r104 = this.$curContainer;
            final String r105 = this.$sectionGuid;
            r103.modifyModelData(new C53331(r104, r105, r103));
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            int r106 = com.ss.android.lark.todo.impl.rustadapter.service.t.f444263a;
            String r107 = this.$sectionGuid;
            String r108 = this.$curContainer.f441458b;
            this.label = 1;
            DeleteTaskSectionRequest.Builder r109 = new DeleteTaskSectionRequest.Builder().section_guid(r107).container_guid(r108);
            int r110 = RustLog.f444237a;
            Command r111 = Command.DELETE_TASK_SECTION;
            Intrinsics.checkNotNull(r109);
            r100 = RustLog.a(r111, r109, new q(r107), "", this);
            if (r100 != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.center.v3.viewmodel.ListViewModel$registerActivityResult$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.todo.impl.features.center.v3.viewmodel.ListViewModel$registerActivityResult$1", f = "ListViewModel.kt", i = {}, l = {640}, m = "invokeSuspend", n = {}, s = {})
    public static final class C122071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TimeBean $timeBean;
        int label;
        final /* synthetic */ ListViewModel this$0;

        public C122071(ListViewModel r100, TimeBean r101, Continuation<? super C122071> r102) {
            this.this$0 = r100;
            this.$timeBean = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C122071(this.this$0, this.$timeBean, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C122071) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L19:
            ListViewModel.access$setModifyTodo$p(this.this$0, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            if (ListViewModel.access$getModifyTodo$p(this.this$0) == null) goto L11;
            TodoRustCRUD r103 = TodoRustCRUD.f444248a;
            Todo r104 = ListViewModel.access$getModifyTodo$p(this.this$0);
            Intrinsics.checkNotNull(r104);
            Todo r105 = ListViewModel.access$getModifyTodo$p(this.this$0);
            Intrinsics.checkNotNull(r105);
            Todo.Builder r106 = r105.newBuilder().due_time(Boxing.boxLong(this.$timeBean.getDueTimeMillis() / ((long) 1000))).start_milli_time(Boxing.boxLong(this.$timeBean.getStartTimeMillis())).rrule(this.$timeBean.getRRule()).is_all_day(Boxing.boxBoolean(this.$timeBean.isAllDay()));
            TimeBean r107 = this.$timeBean;
            if (r107.getReminderRelativeTime() != (-1)) goto L15;
            List<TodoReminder> r108 = new ArrayList();
        L16:
            Todo r109 = r106.reminders(r108).build();
            this.label = 1;
            if (TodoRustCRUD.r(r104, r109, this) != r101) goto L19;
            return r101;
        L15:
            r108 = CollectionsKt.mutableListOf(new TodoReminder[]{new TodoReminder.Builder().is_all_day(Boxing.boxBoolean(r107.isAllDay())).time(Boxing.boxLong(r107.getReminderRelativeTime())).type(TodoReminder.Type.RELATIVE).build()});
            goto L16
        L11:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.center.v3.viewmodel.ListViewModel$registerActivityResult$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.todo.impl.features.center.v3.viewmodel.ListViewModel$registerActivityResult$2", f = "ListViewModel.kt", i = {}, l = {662}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ListViewModel this$0;

        public AnonymousClass2(ListViewModel r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L15:
            ListViewModel.access$setModifyTodo$p(this.this$0, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            if (ListViewModel.access$getModifyTodo$p(this.this$0) == null) goto L11;
            TodoRustCRUD r103 = TodoRustCRUD.f444248a;
            Todo r104 = ListViewModel.access$getModifyTodo$p(this.this$0);
            Intrinsics.checkNotNull(r104);
            Todo r105 = ListViewModel.access$getModifyTodo$p(this.this$0);
            Intrinsics.checkNotNull(r105);
            Todo r106 = r105.newBuilder().build();
            this.label = 1;
            if (TodoRustCRUD.r(r104, r106, this) != r101) goto L15;
            return r101;
        L11:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.center.v3.viewmodel.ListViewModel$updateTaskSections$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.todo.impl.features.center.v3.viewmodel.ListViewModel$updateTaskSections$1", f = "ListViewModel.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
    public static final class C122161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<TaskSection> $newSections;
        final /* synthetic */ CopyOnWriteArrayList<TaskSection> $oldSections;
        int label;
        final /* synthetic */ ListViewModel this$0;

        public C122161(CopyOnWriteArrayList<TaskSection> r100, List<TaskSection> r101, ListViewModel r102, Continuation<? super C122161> r103) {
            this.$oldSections = r100;
            this.$newSections = r101;
            this.this$0 = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C122161(this.$oldSections, this.$newSections, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C122161) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L27:
            RustLog.b r111 = (RustLog.b) r110;
            if (r111 == null) goto L33;
            if (r111.f444239b == null) goto L33;
            ListViewModel r112 = this.this$0;
            CopyOnWriteArrayList<TaskSection> r102 = this.$oldSections;
            r112.getSubModel().getCurSelectContainer().c(r102);
            r112.getSubModel().reviseDefinedSectionData(r102);
            OperationToastHelper r113 = OperationToastHelper.f442443a;
            i r114 = i.f444291a;
            OperationToastHelper.b(LarkContext.getApplication(), R.string.Todo_common_ActionFailedTryAgainLater, null, null, null, 60);
        L33:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            int r115 = com.ss.android.lark.todo.impl.rustadapter.service.t.f444263a;
            CopyOnWriteArrayList<TaskSection> r116 = this.$oldSections;
            List<TaskSection> r103 = this.$newSections;
            this.label = 1;
            ArrayList r104 = new ArrayList();
            Iterator<T> r117 = r116.iterator();
        L10:
            if (r117.hasNext() == false) goto L24;
            TaskSection r105 = (TaskSection) r117.next();
            Iterator<TaskSection> r106 = r103.iterator();
            int r107 = 0;
        L13:
            if (r106.hasNext() == false) goto L18;
            if (Intrinsics.areEqual(r106.next().guid, r105.guid) == true) goto L19;
            r107 = r107 + 1;
        L19:
            if (r107 != (-1)) goto L21;
            TaskSectionUpdateEntity r108 = null;
        L22:
            if (r108 == null) goto L10;
            r104.add(r108);
            goto L10
        L21:
            r108 = new TaskSectionUpdateEntity.Builder().old_section(r105).new_section((TaskSection) ListProtector.get(r103, r107)).build();
            goto L22
        L18:
            r107 = -1;
            goto L19
        L24:
            UpsertTaskSectionsRequest.Builder r118 = new UpsertTaskSectionsRequest.Builder().update_entities(r104);
            int r109 = RustLog.f444237a;
            Command r119 = Command.UPSERT_TASK_SECTIONS;
            Intrinsics.checkNotNull(r118);
            r110 = RustLog.a(r119, r118, new u(r103), "", this);
            if (r110 != r100) goto L27;
            return r100;
        }
    }

    static {
        Companion = new a();
    }

    private final void cancelArchiveTaskList() {
        int r100 = a9c.a.f2310a;
        a9c.a.h(getSubModel().getCurSelectContainer().f441457a, false, true);
        getSubModel().archiveTaskList();
    }

    private final void registerSystemTimeZoneReceiver() {
        IntentFilter r100 = new IntentFilter();
        r100.addAction("android.intent.action.TIMEZONE_CHANGED");
        i r101 = i.f444291a;     // Catch: Exception -> L8
        Application r102 = LarkContext.getApplication();     // Catch: Exception -> L8
        if (r102 == null) goto L6;
        INVOKEVIRTUAL_com_ss_android_lark_todo_impl_features_center_v3_viewmodel_ListViewModel_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r102, this.todoTimeZoneReceiver, r100);     // Catch: Exception -> L8
    L6:
        this.isTimezoneRegister = true;     // Catch: Exception -> L8
        return;
    L8:
        Log.e(TAG, com.ss.android.lark.todo.impl.utils.g.g("RegisterReceiver failed"));
    }

    private final void registerTaskContainerRefsNotificationPush() {
        this.taskContainerRefChangeNotification = new C122081(this);
        com.ss.android.lark.todo.impl.rustadapter.push.c.f444233a.a(Command.PUSH_TASK_CONTAINER_REFS_NOTIFICATION, this.taskContainerRefChangeNotification);
    }

    private final void registerTaskSectionNotificationPush() {
        this.sectionChangedNotification = new C122091(this);
        com.ss.android.lark.todo.impl.rustadapter.push.c.f444233a.a(Command.PUSH_TASK_SECTION_NOTIFICATION, this.sectionChangedNotification);
    }

    private final void registerTimeFormatChangePush() {
        this.timeFormatChangeListener = new c(this);
        TodoDependencyHolder.a().timeFormatDependency().b(this.timeFormatChangeListener);
    }

    private final void registerTodoChangeNotificationPush() {
        this.todoChangedNotification = new C122101(this);
        com.ss.android.lark.todo.impl.rustadapter.push.c.f444233a.a(Command.PUSH_TODOS_CHANGED_NOTIFICATION, this.todoChangedNotification);
    }

    private final void registerTodoExtraChangeNotificationPush() {
        this.todoExtraChangeNotification = new C122111(this);
        com.ss.android.lark.todo.impl.rustadapter.push.c.f444233a.a(Command.PUSH_TODO_EXTRA_INFO_NOTIFICATION, this.todoExtraChangeNotification);
    }

    private final void unRegisterSystemTimeZoneReceiver() {
        if (this.isTimezoneRegister == false) goto L13;
        i r100 = i.f444291a;     // Catch: Exception -> L9
        Application r101 = LarkContext.getApplication();     // Catch: Exception -> L9
        if (r101 == null) goto L7;
        INVOKEVIRTUAL_com_ss_android_lark_todo_impl_features_center_v3_viewmodel_ListViewModel_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r101, this.todoTimeZoneReceiver);     // Catch: Exception -> L9
    L7:
        this.isTimezoneRegister = false;     // Catch: Exception -> L9
        return;
    L9:
        Log.e(TAG, com.ss.android.lark.todo.impl.utils.g.g("UnregisterReceiver failed"));
        return;
    }

    private final void unRegisterTaskContainerRefsNotificationPush() {
        com.ss.android.lark.todo.impl.rustadapter.push.a r100 = this.taskContainerRefChangeNotification;
        if (r100 == null) goto L6;
        com.ss.android.lark.todo.impl.rustadapter.push.c.f444233a.b(Command.PUSH_TASK_CONTAINER_REFS_NOTIFICATION, r100);
        return;
    }

    private final void unRegisterTaskSectionNotificationPush() {
        com.ss.android.lark.todo.impl.rustadapter.push.a r100 = this.sectionChangedNotification;
        if (r100 == null) goto L6;
        com.ss.android.lark.todo.impl.rustadapter.push.c.f444233a.b(Command.PUSH_TASK_SECTION_NOTIFICATION, r100);
        return;
    }

    private final void unRegisterTimeFormatChangePush() {
        if (this.timeFormatChangeListener == null) goto L6;
        TodoDependencyHolder.a().timeFormatDependency().a(this.timeFormatChangeListener);
        return;
    }

    private final void unRegisterTodoChangeNotificationPush() {
        com.ss.android.lark.todo.impl.rustadapter.push.a r100 = this.todoChangedNotification;
        if (r100 == null) goto L6;
        com.ss.android.lark.todo.impl.rustadapter.push.c.f444233a.b(Command.PUSH_TODOS_CHANGED_NOTIFICATION, r100);
        return;
    }

    private final void unRegisterTodoExtraChangeNotificationPush() {
        com.ss.android.lark.todo.impl.rustadapter.push.a r100 = this.todoExtraChangeNotification;
        if (r100 == null) goto L6;
        com.ss.android.lark.todo.impl.rustadapter.push.c.f444233a.b(Command.PUSH_TODO_EXTRA_INFO_NOTIFICATION, r100);
        return;
    }

    public final void cancelScheduled() {
        r7c.a r100 = this.listScheduledFuture;
        r100.getClass();
        Log.e("TodoListSchedule", com.ss.android.lark.todo.impl.utils.g.h("cancelScheduleRefreshMaskView"));
        ScheduledFuture<?> r101 = r100.f536485b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isCancelled() != true) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L16;
        ScheduledFuture<?> r103 = r100.f536485b;
        if (r103 == null) goto L13;
        r103.cancel(true);
    L13:
        r100.f536485b = null;
        return;
    L16:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public final void clearList() {
        setState(C121971.INSTANCE);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public o7c.b getViewEventStore() {
        return (o7c.b) this.viewEventStore$delegate.getValue();
    }

    public final void startScheduled() {
        r7c.a r100 = this.listScheduledFuture;
        r100.getClass();
        Log.e("TodoListSchedule", com.ss.android.lark.todo.impl.utils.g.h("startScheduleRefreshMaskView"));
        ScheduledFuture<?> r101 = r100.f536485b;
        if (r101 != null) goto L5;
    L7:
        ScheduledExecutorService r102 = CoreThreadPool.getDefault().getScheduleThreadPool();
        r7c.b r103 = new r7c.b(r100);
        Calendar r104 = Calendar.getInstance(TimeZone.getDefault());
        long r105 = r104.getTime().getTime();
        r104.add(12, 1);
        r104.set(13, 0);
        r104.set(14, 0);
        r100.f536485b = r102.scheduleWithFixedDelay(r103, r104.getTime().getTime() - r105, 60000, TimeUnit.MILLISECONDS);
        return;
    L5:
        if ((!r101.isCancelled()) == false) goto L7;
    }

    @Override // com.larksuite.arch.jack.JackViewModel
    public d defaultState() {
        long r100 = System.currentTimeMillis();
        d r101 = getSubModel().getListViewState();
        Log.i(TAG, "refresh list view state, time = " + (System.currentTimeMillis() - r100));
        return r101;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public /* bridge */ /* synthetic */ com.ss.android.lark.todo.impl.features.center.v3.arch.a getSubModel() {
        return getSubModel();
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public void initViewModel() {
        super.initViewModel();
        registerTodoChangeNotificationPush();
        registerTodoExtraChangeNotificationPush();
        registerSystemTimeZoneReceiver();
        registerTimeFormatChangePush();
        EventBus.getDefault().register(this);
        registerTaskSectionNotificationPush();
        registerTaskContainerRefsNotificationPush();
        getViewEventStore().f522299f.postValue(TodoFetchStatus.LOADING);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public void onClear() {
        unRegisterTodoChangeNotificationPush();
        unRegisterTodoExtraChangeNotificationPush();
        unRegisterSystemTimeZoneReceiver();
        unRegisterTimeFormatChangePush();
        unRegisterTaskSectionNotificationPush();
        unRegisterTaskContainerRefsNotificationPush();
        cancelScheduled();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public void onPause() {
        getViewEventStore().f522298e.postValue(Boolean.TRUE);
    }

    @Override // com.larksuite.arch.jack.JackViewModel
    public /* bridge */ /* synthetic */ j defaultState() {
        return defaultState();
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public e getSubModel() {
        return this.subModel;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public /* bridge */ /* synthetic */ com.ss.android.lark.todo.impl.features.center.v3.arch.c getViewEventStore() {
        return getViewEventStore();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.todo.impl.features.center.v3.viewmodel.ListViewModel$listScheduledFuture$1] */
    public ListViewModel(e r100) {
        Intrinsics.checkNotNullParameter(r100, "subModel");
        this.subModel = r100;
        this.viewEventStore$delegate = LazyKt.lazy(ListViewModel$viewEventStore$2.INSTANCE);
        this.operationId = TodoDependencyHolder.a().loginDependency().getUserId();
        this.todoTimeZoneReceiver = new ListViewModel$todoTimeZoneReceiver$1(this);
        this.listScheduledFuture = new r7c.a(new ListViewModel$listScheduledFuture$1(this));
    }

    public static final /* synthetic */ Todo access$getModifyTodo$p(ListViewModel r100) {
        return r100.modifyTodo;
    }

    public static final /* synthetic */ String access$getOperationId$p(ListViewModel r100) {
        return r100.operationId;
    }

    private final void checkBoxClick(final m7c.a r100) {
        modifyModelData(new C121961(r100, this));
    }

    private final void createInline(final m7c.i r100) {
        modifyModelData(new C121981(this, r100));
    }

    private final void createNextSection(final h r100) {
        modifyModelData(new C121991(this, r100));
    }

    private final void createPrevSection(final h r100) {
        modifyModelData(new C122001(this, r100));
    }

    private final void deleteSection(String r110) {
        int r100 = a9c.a.f2310a;
        TaskContainer r101 = getSubModel().getCurSelectContainer().f441457a;
        Intrinsics.checkNotNullParameter(r101, "taskContainer");
        s5c.a r102 = r.H0;
        s5c.a r103 = p3.f570282c;
        r102.getClass();
        a9c.a.c("todo_center_task_list_click", s5c.d.b.b(r102, r103).plus(y3.f570417i).plus(a9c.a.a(r101)).toJson());
        TaskContainerData r104 = getSubModel().getCurSelectContainer();
        Iterator<T> r105 = r104.f441481y.iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((TaskSectionData) r106).f441515c, r110) == false) goto L4;
    L10:
        if (((TaskSectionData) r106) != null) goto L12;
        return;
    L12:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C122011(r110, r104, this, null), 3, null);
        return;
    L8:
        r106 = null;
        goto L10
    }

    private final void deleteTodo(final String r100) {
        int r101 = a9c.a.f2310a;
        a9c.a.g(r100, getSubModel().getCurSelectContainer().f441457a);
        modifyModelData(new C122021(this, r100));
    }

    private final void goDetailActivity(String r100) {
        int r101 = a9c.a.f2310a;
        TaskContainer r102 = getSubModel().getCurSelectContainer().f441457a;
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "taskContainer");
        s5c.a r103 = r.f570353y;
        s5c.a r104 = r3.f570361c.a(r100);
        r103.getClass();
        a9c.a.c("todo_center_task_list_click", s5c.d.b.b(r103, r104).plus(p3.f570288i).plus(a9c.a.a(r102)).toJson());
    }

    private final void modifyDueTime(final String r100) {
        modifyModelData(new C122031(r100, this));
    }

    private final void modifyOwner(final String r100) {
        modifyModelData(new C122041(r100, this));
    }

    private final void quitTodo(final String r100) {
        modifyModelData(new C122061(r100, this));
    }

    private final void scrollPositionAction(String r100) {
        getSubModel().scrollPositionTaskGuid(r100);
    }

    private final void sectionExpand(final m r100) {
        modifyModelData(new C122121(this, r100));
    }

    private final void sectionRename(m7c.j r100) {
        final String r101 = r100.f512426a;
        final String r102 = r100.f512427b;
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return;
    L5:
        modifyModelData(new C122131(this, r102, r101));
    }

    private final void shareTodo(l r100) {
        TaskContainerData r101 = getSubModel().getCurSelectContainer();
        if (r101 == null) goto L5;
        int r102 = a9c.a.f2310a;
        String r103 = r100.f512429a;
        TaskContainer r104 = r101.f441457a;
        Intrinsics.checkNotNullParameter(r103, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r104, "taskContainer");
        s5c.a r105 = r.f570351x1;
        s5c.a r106 = r3.f570361c.a(r103);
        r105.getClass();
        a9c.a.c("todo_center_task_list_click", s5c.d.b.b(r105, r106).plus(p3.f570289j).plus(a9c.a.a(r104)).toJson());
    L5:
        getSubModel().goShareActivity(r100.f512429a, r100.f512430b);
    }

    @Subscribe
    public final void onAddTodoEvent(final x8c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "addTodoEvent");
        modifyModelData(new C122051(this, r100));
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ss_android_lark_todo_impl_features_center_v3_viewmodel_ListViewModel_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    public static final /* synthetic */ void access$setModifyTodo$p(ListViewModel r100, Todo r101) {
        r100.modifyTodo = r101;
    }

    private final void addNewDefinedSection(TaskContainerData r100, TaskSection r101) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r101, this, r100, null), 3, null);
    }

    private final void sectionSortSave(List<String> r100, final Map<String, String> r101) {
        StringBuilder r102 = new StringBuilder("Task List Sections ReSort: ");
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L11;
        String r105 = (String) r104.next();
        StringBuilder r106 = new StringBuilder();
        r106.append(r105);
        r106.append(": ");
        String r107 = r101.get(r105);
        if (r107 != null) goto L8;
        r107 = "";
    L8:
        r106.append(r107);
        String r108 = r106.toString();
        if (r108 == null) goto L4;
        r103.add(r108);
        goto L4
    L11:
        r102.append(r103);
        Log.i(TAG, r102.toString());
        int r109 = a9c.a.f2310a;
        TaskContainer r110 = getSubModel().getCurSelectContainer().f441457a;
        Intrinsics.checkNotNullParameter(r110, "taskContainer");
        s5c.a r111 = r.f570338p0;
        s5c.a r112 = p3.f570282c;
        r111.getClass();
        a9c.a.c("todo_center_task_list_click", s5c.d.b.b(r111, r112).plus(a9c.a.a(r110)).toJson());
        modifyModelData(new C122142(this, r101));
    }

    private final void updateTaskSections(CopyOnWriteArrayList<TaskSection> r100, List<TaskSection> r101) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C122161(r100, r101, this, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void handleAction(g r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        f r102 = null;
        m r103 = null;
        m7c.a r104 = null;
        String r105 = null;
        String r106 = null;
        l r107 = null;
        String r108 = null;
        String r109 = null;
        m7c.j r110 = null;
        h r111 = null;
        h r112 = null;
        m7c.i r113 = null;
        String r114 = null;
        String r115 = null;
        String r116 = null;
        m7c.e r117 = null;
        if (Intrinsics.areEqual(r100, g.f.f512409a) == false) goto L10;
        if ((r101 instanceof m) == false) goto L7;
        r103 = (m) r101;
    L7:
        if (r103 == null) goto L131;
        sectionExpand(r103);
        return;
    L131:
        return;
    L10:
        if (Intrinsics.areEqual(r100, g.l.f512415a) == true) goto L12;
        String r118 = "";
        if (Intrinsics.areEqual(r100, g.m.f512416a) == false) goto L26;
        if ((r101 instanceof String) == false) goto L21;
        r105 = (String) r101;
    L21:
        if (r105 == null) goto L24;
        r118 = r105;
    L24:
        deleteTodo(r118);
        return;
    L26:
        if (Intrinsics.areEqual(r100, g.q.f512420a) == false) goto L35;
        if ((r101 instanceof String) == false) goto L30;
        r106 = (String) r101;
    L30:
        if (r106 == null) goto L33;
        r118 = r106;
    L33:
        quitTodo(r118);
        return;
    L35:
        if (Intrinsics.areEqual(r100, g.r.f512421a) == false) goto L42;
        if ((r101 instanceof l) == false) goto L39;
        r107 = (l) r101;
    L39:
        if (r107 == null) goto L137;
        shareTodo(r107);
        return;
    L137:
        return;
    L42:
        if (Intrinsics.areEqual(r100, g.o.f512418a) == false) goto L51;
        if ((r101 instanceof String) == false) goto L46;
        r108 = (String) r101;
    L46:
        if (r108 == null) goto L49;
        r118 = r108;
    L49:
        modifyDueTime(r118);
        return;
    L51:
        if (Intrinsics.areEqual(r100, g.p.f512419a) == false) goto L60;
        if ((r101 instanceof String) == false) goto L55;
        r109 = (String) r101;
    L55:
        if (r109 == null) goto L58;
        r118 = r109;
    L58:
        modifyOwner(r118);
        return;
    L60:
        if (Intrinsics.areEqual(r100, g.k.f512414a) == false) goto L67;
        if ((r101 instanceof m7c.j) == false) goto L64;
        r110 = (m7c.j) r101;
    L64:
        if (r110 == null) goto L141;
        sectionRename(r110);
        return;
    L141:
        return;
    L67:
        if (Intrinsics.areEqual(r100, g.j.f512413a) == false) goto L74;
        if ((r101 instanceof h) == false) goto L71;
        r111 = (h) r101;
    L71:
        if (r111 == null) goto L143;
        createPrevSection(r111);
        return;
    L143:
        return;
    L74:
        if (Intrinsics.areEqual(r100, g.i.f512412a) == false) goto L81;
        if ((r101 instanceof h) == false) goto L78;
        r112 = (h) r101;
    L78:
        if (r112 == null) goto L145;
        createNextSection(r112);
        return;
    L145:
        return;
    L81:
        if (Intrinsics.areEqual(r100, g.h.f512411a) == false) goto L88;
        if ((r101 instanceof m7c.i) == false) goto L85;
        r113 = (m7c.i) r101;
    L85:
        if (r113 == null) goto L147;
        createInline(r113);
        return;
    L147:
        return;
    L88:
        if (Intrinsics.areEqual(r100, g.C6781g.f512410a) == false) goto L95;
        if ((r101 instanceof String) == false) goto L92;
        r114 = (String) r101;
    L92:
        if (r114 == null) goto L149;
        deleteSection(r114);
        return;
    L149:
        return;
    L95:
        if (Intrinsics.areEqual(r100, g.b.f512405a) == false) goto L98;
        getSubModel().reloadList();
        return;
    L98:
        if (Intrinsics.areEqual(r100, g.n.f512417a) == false) goto L105;
        if ((r101 instanceof String) == false) goto L102;
        r115 = (String) r101;
    L102:
        if (r115 == null) goto L152;
        goDetailActivity(r115);
        return;
    L152:
        return;
    L105:
        if (Intrinsics.areEqual(r100, g.c.f512406a) == false) goto L112;
        if ((r101 instanceof String) == false) goto L109;
        r116 = (String) r101;
    L109:
        if (r116 == null) goto L154;
        scrollPositionAction(r116);
        return;
    L154:
        return;
    L112:
        if (Intrinsics.areEqual(r100, g.d.f512407a) == false) goto L119;
        if ((r101 instanceof m7c.e) == false) goto L116;
        r117 = (m7c.e) r101;
    L116:
        if (r117 == null) goto L156;
        taskItemDrag(r117.f512398a, r117.f512399b, r117.f512400c, r117.f512401d);
        return;
    L156:
        return;
    L119:
        if (Intrinsics.areEqual(r100, g.e.f512408a) == false) goto L126;
        if ((r101 instanceof f) == false) goto L123;
        r102 = (f) r101;
    L123:
        if (r102 == null) goto L158;
        sectionSortSave(r102.f512402a, r102.f512403b);
        return;
    L158:
        return;
    L126:
        if (Intrinsics.areEqual(r100, g.a.f512404a) == false) goto L130;
        cancelArchiveTaskList();
        return;
    L130:
        throw new NoWhenBranchMatchedException();
    L12:
        if ((r101 instanceof m7c.a) == false) goto L14;
        r104 = (m7c.a) r101;
    L14:
        if (r104 == null) goto L133;
        checkBoxClick(r104);
        return;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public /* bridge */ /* synthetic */ void handleAction(com.ss.android.lark.todo.impl.features.center.v3.arch.b r100, Object r101) {
        handleAction((g) r100, r101);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_android_lark_todo_impl_features_center_v3_viewmodel_ListViewModel_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }

    public static final /* synthetic */ void access$addNewDefinedSection(ListViewModel r100, TaskContainerData r101, TaskSection r102) {
        r100.addNewDefinedSection(r101, r102);
    }

    public static final /* synthetic */ void access$updateTaskSections(ListViewModel r100, CopyOnWriteArrayList r101, List r102) {
        r100.updateTaskSections(r101, r102);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel
    public void registerActivityResult(int r100, int r101, Intent r110) {
        if (r101 == (-1)) goto L6;
        return;
    L6:
        if (r100 != 33) goto L57;
        if (r110 == null) goto L11;
        Bundle r102 = r110.getExtras();
        if (r102 == null) goto L11;
        Object r103 = r102.get("message_alert_todo_guid");
    L13:
        if ((r103 instanceof String) == false) goto L15;
        String r104 = (String) r103;
    L17:
        if (TextUtils.isEmpty(r104) == false) goto L19;
        return;
    L19:
        if (r110 == null) goto L23;
        Bundle r105 = r110.getExtras();
        if (r105 == null) goto L23;
        Object r106 = r105.get("todo_create_detail_container_guid");
    L25:
        if ((r106 instanceof String) == false) goto L27;
        String r107 = (String) r106;
    L28:
        if (r110 == null) goto L32;
        Bundle r108 = r110.getExtras();
        if (r108 == null) goto L32;
        Object r109 = r108.get("todo_create_detail_section_guid");
    L34:
        if ((r109 instanceof String) == false) goto L36;
        String r111 = (String) r109;
    L37:
        if (r110 == null) goto L41;
        Bundle r112 = r110.getExtras();
        if (r112 == null) goto L41;
        Object r113 = r112.get("todo_create_detail_rank");
    L43:
        if ((r113 instanceof String) == false) goto L45;
        String r114 = (String) r113;
    L47:
        if (r104 != null) goto L49;
        r104 = "";
    L49:
        if (r107 != null) goto L51;
        r107 = "";
    L51:
        if (r111 != null) goto L53;
        r111 = "";
    L53:
        if (r114 != null) goto L55;
        r114 = "";
    L55:
        addTodoRef(r104, r107, r111, r114);
        goto L57
    L45:
        r114 = null;
    L41:
        r113 = null;
        goto L43
    L36:
        r111 = null;
    L32:
        r109 = null;
        goto L34
    L27:
        r107 = null;
    L23:
        r106 = null;
        goto L25
    L15:
        r104 = null;
    L11:
        r103 = null;
    L57:
        if (r100 != 64) goto L72;
        if (r110 == null) goto L62;
        Bundle r115 = r110.getExtras();
        if (r115 == null) goto L62;
        Object r116 = r115.get("todo_due_time_chosen_data");
    L64:
        if ((r116 instanceof TimeBean) == false) goto L66;
        TimeBean r117 = (TimeBean) r116;
    L67:
        if (r117 != null) goto L69;
        return;
    L69:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C122071(this, r117, null), 3, null);
        return;
    L66:
        r117 = null;
    L62:
        r116 = null;
        goto L64
    L72:
        if (r100 != 6) goto L85;
        h0 r118 = h0.a.f285998a;
        if (r110 == null) goto L76;
        String r119 = r110.getStringExtra("todo_add_member_chosen_data");
    L77:
        ArrayList r120 = (ArrayList) r118.a(r119);
        if (r120 != null) goto L81;
        r120 = new ArrayList();
    L81:
        if (((SearchBaseInfo) CollectionsKt.getOrNull(r120, 0)) != null) goto L83;
        return;
    L83:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, null), 3, null);
        return;
    L76:
        r119 = null;
        goto L77
    }

    private final void addTodoRef(final String r100, final String r101, final String r110, final String r111) {
        modifyModelData(new C121951(r101, this, r100, r111, r110));
    }

    private final void taskItemDrag(final String r100, final String r101, final String r110, final String r111) {
        modifyModelData(new C122151(this, r100, r110, r111, r101));
    }

    public static /* synthetic */ void addTodoRef$default(ListViewModel r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = "";
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = "";
    L11:
        r100.addTodoRef(r101, r102, r103, r104);
    }
}
