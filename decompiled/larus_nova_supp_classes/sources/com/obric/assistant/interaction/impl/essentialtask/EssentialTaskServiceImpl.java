package com.obric.assistant.interaction.impl.essentialtask;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.util.EventsUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.shadowhook.ShadowHook;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.q0;
import com.obric.assistant.IObricAvailableManager;
import com.obric.assistant.interaction.api.essentialtask.ExecuteState;
import com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService;
import com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask;
import com.obric.assistant.interaction.impl.essentialtask.base.ParallelTaskGroup;
import com.obric.assistant.interaction.impl.essentialtask.base.SequentialTaskGroup;
import com.obric.assistant.interaction.impl.essentialtask.loading.ObricLoadingDialog;
import com.obric.assistant.interaction.impl.essentialtask.task.InstallInternalPluginTask;
import com.obric.assistant.interaction.impl.essentialtask.task.SecurityProvisionCheckTask;
import com.obric.assistant.interaction.impl.essentialtask.task.migration.DataMigrationTask;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.zeus.plugin.IZeusPluginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import kotlinx.coroutines.sync.a;
import org.xmlpull.v1.XmlPullParser;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0013\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cH\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001cH\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u000eH\u0016J\u001e\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00160,H\u0016J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/EssentialTaskServiceImpl;", "Lcom/obric/assistant/interaction/api/essentialtask/IEssentialTaskService;", "<init>", "()V", "context", "Landroid/content/Context;", "isMainProcess", XmlPullParser.NO_NAMESPACE, "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "workScope", "pendingTaskList", XmlPullParser.NO_NAMESPACE, "Lkotlin/Pair;", "Ljava/lang/Runnable;", "pendingTaskMutex", "Lkotlinx/coroutines/sync/Mutex;", "needExecute", "appBackGroundListener", "com/obric/assistant/interaction/impl/essentialtask/EssentialTaskServiceImpl$appBackGroundListener$1", "Lcom/obric/assistant/interaction/impl/essentialtask/EssentialTaskServiceImpl$appBackGroundListener$1;", "preInit", XmlPullParser.NO_NAMESPACE, "init", "Landroid/app/Application;", "startExecute", "ensureHookLibraryLoaded", "isExecuteSucceedState", "Lkotlinx/coroutines/flow/StateFlow;", "fakeSubProcessExecuteState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState$NotStarted;", "getFakeSubProcessExecuteState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "fakeSubProcessExecuteState$delegate", "Lkotlin/Lazy;", "getExecuteState", "Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState;", "doAfterExecuteSucceed", "action", "showLoadingUI", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "onLoadSucceed", "Lkotlin/Function0;", "composeRootTask", "Lcom/obric/assistant/interaction/impl/essentialtask/base/EssentialTask;", "executePendingTaskWhenFinished", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class EssentialTaskServiceImpl implements IEssentialTaskService {
    public static final Companion Companion = null;
    private static final String TAG = "EssentialTaskService";
    private final EssentialTaskServiceImpl$appBackGroundListener$1 appBackGroundListener;
    private Context context;
    private final Lazy fakeSubProcessExecuteState$delegate;
    private volatile boolean isMainProcess;
    private final CoroutineScope mainScope;
    private volatile boolean needExecute;
    private final List<Pair<Boolean, Runnable>> pendingTaskList;
    private final a pendingTaskMutex;
    private final CoroutineScope workScope;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/EssentialTaskServiceImpl$Companion;", XmlPullParser.NO_NAMESPACE, "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.essentialtask.EssentialTaskServiceImpl$doAfterExecuteSucceed$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", XmlPullParser.NO_NAMESPACE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.EssentialTaskServiceImpl$doAfterExecuteSucceed$1", f = "EssentialTaskServiceImpl.kt", i = {0}, l = {257}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Runnable $action;
        final /* synthetic */ boolean $isMainThread;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        final /* synthetic */ EssentialTaskServiceImpl this$0;

        public AnonymousClass1(EssentialTaskServiceImpl r1, Runnable r2, boolean r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$action = r2;
            this.$isMainThread = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$action, this.$isMainThread, r5);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            boolean r2 = this.Z$0;
            Runnable r4 = (Runnable) this.L$2;
            EssentialTaskServiceImpl r5 = (EssentialTaskServiceImpl) this.L$1;
            a r6 = (a) this.L$0;
            ResultKt.throwOnFailure(r8);
        L26:
        L23:
            th = move-exception;
            r6.unlock(null);
            throw th;
        L13:
            if (r5.isExecuteSucceedState().getValue().booleanValue() == false) goto L15;
            r4.run();     // Catch: Throwable -> L23
        L20:
            Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L23
            r6.unlock(null);
            return Unit.INSTANCE;
        L15:
            List r10 = EssentialTaskServiceImpl.access$getPendingTaskList$p(r5);     // Catch: Throwable -> L23
            if (r2 == true) goto L19;
            r3 = false;
        L19:
            Boxing.boxBoolean(r10.add(TuplesKt.to(Boxing.boxBoolean(r3), r4)));     // Catch: Throwable -> L23
            goto L20
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            r6 = EssentialTaskServiceImpl.access$getPendingTaskMutex$p(this.this$0);
            r5 = this.this$0;
            r4 = this.$action;
            boolean r11 = this.$isMainThread;
            this.L$0 = r6;
            this.L$1 = r5;
            this.L$2 = r4;
            this.Z$0 = r11;
            this.label = 1;
            if (r6.a(null, this) != r0) goto L11;
            return r0;
        L11:
            r2 = r11;
            goto L26
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.essentialtask.EssentialTaskServiceImpl$executePendingTaskWhenFinished$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", XmlPullParser.NO_NAMESPACE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.EssentialTaskServiceImpl$executePendingTaskWhenFinished$1", f = "EssentialTaskServiceImpl.kt", i = {1}, l = {220, 257}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    public static final class C00171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ EssentialTaskServiceImpl this$0;

        /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.essentialtask.EssentialTaskServiceImpl$executePendingTaskWhenFinished$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", XmlPullParser.NO_NAMESPACE, "it"}, k = 3, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
        @DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.EssentialTaskServiceImpl$executePendingTaskWhenFinished$1$1", f = "EssentialTaskServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00071 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
            /* synthetic */ boolean Z$0;
            int label;

            public C00071(Continuation<? super C00071> r2) {
                super(2, r2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                C00071 r0 = new C00071(r3);
                r0.Z$0 = ((Boolean) r2).booleanValue();
                return r0;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean r1, Continuation<? super Boolean> r2) {
                return invoke(r1.booleanValue(), r2);
            }

            public final Object invoke(boolean r1, Continuation<? super Boolean> r2) {
                return ((C00071) create(Boolean.valueOf(r1), r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return Boxing.boxBoolean(this.Z$0);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C00171(EssentialTaskServiceImpl r1, Continuation<? super C00171> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C00171(this.this$0, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C00171) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r25) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r6 = this.label;
            if (r6 == 0) goto L10;
            if (r6 == 1) goto L9;
            if (r6 != 2) goto L8;
            EssentialTaskServiceImpl r7 = (EssentialTaskServiceImpl) this.L$1;
            a r8 = (a) this.L$0;
            ResultKt.throwOnFailure(r25);
        L33:
            FLogger.a.i(EssentialTaskServiceImpl.TAG, "pending task size " + EssentialTaskServiceImpl.access$getPendingTaskList$p(r7).size());     // Catch: Throwable -> L30
            Iterator r4 = EssentialTaskServiceImpl.access$getPendingTaskList$p(r7).iterator();     // Catch: Throwable -> L30
        L22:
            if (r4.hasNext() == false) goto L27;
            Pair r9 = (Pair) r4.next();     // Catch: Throwable -> L30
            boolean r10 = ((Boolean) r9.component1()).booleanValue();     // Catch: Throwable -> L30
            Runnable r11 = (Runnable) r9.component2();     // Catch: Throwable -> L30
            if (r10 == true) goto L25;
            BuildersKt.launch$default(EssentialTaskServiceImpl.access$getWorkScope$p(r7), null, null, new 2.1.1(r11, null), 3, null);     // Catch: Throwable -> L30
            goto L22
        L25:
            FLogger r12 = FLogger.a;     // Catch: Throwable -> L30
            r12.i(EssentialTaskServiceImpl.TAG, "start execute uiThread pending task: " + r11);     // Catch: Throwable -> L30
            TaskUtils r13 = TaskUtils.INSTANCE;     // Catch: Throwable -> L30
            TaskUtils.systemLog$default(r13, EssentialTaskServiceImpl.TAG, "start execute uiThread pending task: " + r11, null, 4, null);     // Catch: Throwable -> L30
            long r14 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L30
            r11.run();     // Catch: Throwable -> L30
            long r15 = SystemClock.elapsedRealtime() - r14;     // Catch: Throwable -> L30
            r12.i(EssentialTaskServiceImpl.TAG, "finish execute uiThread pending task: " + r11 + ", usedTime: " + r15);     // Catch: Throwable -> L30
            TaskUtils.systemLog$default(r13, EssentialTaskServiceImpl.TAG, "finish execute uiThread pending task: " + r11 + ", usedTime: " + r15, null, 4, null);     // Catch: Throwable -> L30
            goto L22
        L27:
            EssentialTaskServiceImpl.access$getPendingTaskList$p(r7).clear();     // Catch: Throwable -> L30
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L30
            r8.unlock(null);
            return Unit.INSTANCE;
        L30:
            th = move-exception;
            r8.unlock(null);
            throw th;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r25);
        L15:
            FLogger.a.i(EssentialTaskServiceImpl.TAG, "executeSucceed, execute pending tasks");
        L16:
            r8 = EssentialTaskServiceImpl.access$getPendingTaskMutex$p(this.this$0);
            EssentialTaskServiceImpl r16 = this.this$0;
            this.L$0 = r8;
            this.L$1 = r16;
            this.label = 2;
            if (r8.a(null, this) != r5) goto L19;
            return r5;
        L19:
            r7 = r16;
            goto L33
        L10:
            ResultKt.throwOnFailure(r25);
            if (EssentialTaskServiceImpl.access$getNeedExecute$p(this.this$0) == false) goto L16;
            FLogger.a.i(EssentialTaskServiceImpl.TAG, "will wait execute until succeed");
            i1<Boolean> r17 = this.this$0.isExecuteSucceedState();
            C00071 r18 = new C00071(null);
            this.label = 1;
            if (e.t(r17, r18, this) != r5) goto L15;
            return r5;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(EssentialTaskServiceImpl r0) {
        startExecute$lambda$0(r0);
    }

    public static /* synthetic */ z0 b() {
        return fakeSubProcessExecuteState_delegate$lambda$1();
    }

    private final EssentialTask composeRootTask() {
        Context r0 = this.context;
        Context r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r0 = null;
    L5:
        EssentialTask[] r4 = new EssentialTask[2];
        Context r6 = this.context;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r6 = null;
    L8:
        r4[0] = new SecurityProvisionCheckTask(r6);
        Context r5 = this.context;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r5 = null;
    L11:
        EssentialTask[] r3 = new EssentialTask[2];
        Context r8 = this.context;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r8 = null;
    L14:
        r3[0] = new InstallInternalPluginTask(r8);
        Context r7 = this.context;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r7 = null;
    L17:
        List r9 = CollectionsKt.createListBuilder();
        if (b.a().e() == true) goto L23;
        Context r10 = this.context;
        if (r10 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r10 = null;
    L22:
        r9.add(new DataMigrationTask.Memory(r10));
    L23:
        Context r11 = this.context;
        if (r11 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L27:
        r9.add(new DataMigrationTask.AiAgent(r1));
        Unit r2 = Unit.INSTANCE;
        r3[1] = new ParallelTaskGroup(r7, "data_migration", CollectionsKt.build(r9));
        r4[1] = new SequentialTaskGroup(r5, "plugin", CollectionsKt.listOf(r3));
        return new ParallelTaskGroup(r0, "root_task", CollectionsKt.listOf(r4));
    L26:
        r1 = r11;
        goto L27
    }

    private final void ensureHookLibraryLoaded() {
        if (Build.VERSION.SDK_INT <= 25) goto L5;
        return;
    L5:
        ShadowHook.init();
        ByteHook.init();
    }

    private final void executePendingTaskWhenFinished() {
        BuildersKt.launch$default(this.mainScope, null, null, new C00171(this, null), 3, null);
    }

    private static final z0 fakeSubProcessExecuteState_delegate$lambda$1() {
        return j1.a(new ExecuteState.NotStarted());
    }

    private final z0<ExecuteState.NotStarted> getFakeSubProcessExecuteState() {
        return (z0) this.fakeSubProcessExecuteState$delegate.getValue();
    }

    @Override // com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService
    public i1<ExecuteState> getExecuteState() {
        if (this.isMainProcess == true) goto L7;
        FLogger.a.e(TAG, "getExecuteState: not in main process");
        return getFakeSubProcessExecuteState();
    L7:
        return EssentialTaskManager.INSTANCE.getExecuteState();
    }

    @Override // com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService
    public i1<Boolean> isExecuteSucceedState() {
        if (this.isMainProcess == false) goto L6;
        return EssentialTaskManager.INSTANCE.getExecuteSucceedState();
    L6:
        return SubProcessTaskManager.INSTANCE.getExecuteSucceedState();
    }

    @Override // com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService
    public void startExecute() {
        if (this.isMainProcess == false) goto L16;
        IObricAvailableManager r0 = (IObricAvailableManager) ServiceManager.get().getService(IObricAvailableManager.class);
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == true) goto L11;
        doAfterExecuteSucceed(new d(this));
    L13:
        if (this.needExecute == false) goto L17;
        EssentialTaskManager.INSTANCE.startExecuteRootTask();
        return;
    L17:
        return;
    L11:
        FLogger.a.w(TAG, "skip load plugin，not default assistant");
        goto L13
    L7:
        if (r0.b() == true) goto L9;
        r1 = true;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.assistant.interaction.impl.essentialtask.EssentialTaskServiceImpl$appBackGroundListener$1] */
    public EssentialTaskServiceImpl() {
        this.mainScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.workScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.pendingTaskList = new ArrayList();
        this.pendingTaskMutex = kotlinx.coroutines.sync.b.a();
        this.needExecute = true;
        this.appBackGroundListener = new EssentialTaskServiceImpl$appBackGroundListener$1(this);
        this.fakeSubProcessExecuteState$delegate = LazyKt.lazy(new c());
    }

    @Override // com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService
    public boolean isExecuteSucceed() {
        return IEssentialTaskService.DefaultImpls.isExecuteSucceed(this);
    }

    public static final /* synthetic */ void access$ensureHookLibraryLoaded(EssentialTaskServiceImpl r0) {
        r0.ensureHookLibraryLoaded();
    }

    public static final /* synthetic */ boolean access$getNeedExecute$p(EssentialTaskServiceImpl r0) {
        return r0.needExecute;
    }

    public static final /* synthetic */ List access$getPendingTaskList$p(EssentialTaskServiceImpl r0) {
        return r0.pendingTaskList;
    }

    public static final /* synthetic */ a access$getPendingTaskMutex$p(EssentialTaskServiceImpl r0) {
        return r0.pendingTaskMutex;
    }

    public static final /* synthetic */ CoroutineScope access$getWorkScope$p(EssentialTaskServiceImpl r0) {
        return r0.workScope;
    }

    public static final /* synthetic */ boolean access$isMainProcess$p(EssentialTaskServiceImpl r0) {
        return r0.isMainProcess;
    }

    private static final void startExecute$lambda$0(EssentialTaskServiceImpl r6) {
        BuildersKt.launch$default(r6.workScope, null, null, new startExecute.1.1(r6, null), 3, null);
    }

    @Override // com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService
    public void doAfterExecuteSucceed(Runnable r9) {
        Intrinsics.checkNotNullParameter(r9, "action");
        if (isExecuteSucceedState().getValue().booleanValue() == false) goto L5;
        r9.run();
        return;
    L5:
        boolean r0 = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
        if (r0 == false) goto L8;
        CoroutineScope r1 = this.mainScope;
    L9:
        BuildersKt.launch$default(r1, null, null, new AnonymousClass1(this, r9, r0, null), 3, null);
        return;
    L8:
        r1 = this.workScope;
        goto L9
    }

    @Override // com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService
    public void init(Application r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        FLogger r0 = FLogger.a;
        r0.i(TAG, "init");
        this.context = r5;
        IZeusPluginService r1 = (IZeusPluginService) ServiceManager.get().getService(IZeusPluginService.class);
        if (r1 == null) goto L6;
        r1.init(r5);
    L6:
        if (this.isMainProcess == false) goto L8;
        EssentialTaskManager.INSTANCE.setRootTask(composeRootTask());
        AppHost.a.a().j(this.appBackGroundListener);
    L9:
        this.needExecute = !isExecuteSucceedState().getValue().booleanValue();
        r0.i(TAG, "needExecute = " + this.needExecute);
        executePendingTaskWhenFinished();
        return;
    L8:
        SubProcessTaskManager.INSTANCE.init(r5);
        goto L9
    }

    @Override // com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService
    public void preInit(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.context = r3;
        this.isMainProcess = q0.c(r3);
        FLogger.a.i(TAG, "preInit: isMainProcess=" + this.isMainProcess);
    }

    @Override // com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService
    public void showLoadingUI(FragmentManager r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "onLoadSucceed");
        ObricLoadingDialog r0 = new ObricLoadingDialog();
        r0.setOnLoadSucceedCallback(r3);
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_essentialtask_EssentialTaskServiceImpl_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r0, r2, "obric_loading_dialog");
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_essentialtask_EssentialTaskServiceImpl_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(ObricLoadingDialog r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        ObricLoadingDialog r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
