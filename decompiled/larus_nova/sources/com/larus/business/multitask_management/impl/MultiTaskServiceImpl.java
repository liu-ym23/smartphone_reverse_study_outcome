package com.larus.business.multitask_management.impl;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.a0;
import com.larus.bmhome.b0;
import com.larus.business.multitask_management.api.IMultiTaskInitEvent;
import com.larus.business.multitask_management.api.IMultiTaskService;
import com.larus.business.multitask_management.impl.floatwindow.TaskManagementFloatWindowView;
import com.larus.business.multitask_management.impl.fullscreen.MultiTaskManagementFullscreenFragment;
import com.larus.business.multitask_management.impl.pad.MultiTaskManagementPadDialogFragment;
import com.larus.business.multitask_management.impl.sheet.MultiTaskManagementDialogFragment;
import com.larus.business.multitask_management.impl.view.QuickAccessNodeDefaultIcons;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.floatwindow.view.SingleFloatWindowState;
import com.larus.platform.api.m4;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.e2;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import e19.t;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kl9.u;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\f\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J\b\u0010!\u001a\u00020\u000fH\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u001cH\u0016J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\u0018H\u0016J\u0019\u0010(\u001a\u0004\u0018\u00010\t2\b\u0010)\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010*J\u000e\u0010+\u001a\u0004\u0018\u00010\u001a*\u00020,H\u0002J\"\u0010-\u001a\u0004\u0018\u00010\u001a*\u00020,2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001c0/H\u0002J\u0016\u00100\u001a\u0004\u0018\u00010\u001a*\u00020,2\u0006\u00101\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u00063"}, d2 = {"Lcom/larus/business/multitask_management/impl/MultiTaskServiceImpl;", "Lcom/larus/business/multitask_management/api/IMultiTaskService;", "<init>", "()V", "currentRequest", "Lcom/larus/business/multitask_management/impl/floatwindow/TaskManagementFloatRequest;", "inited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastScreenWidth", "", "Ljava/lang/Integer;", "screenSizeCallbacks", "com/larus/business/multitask_management/impl/MultiTaskServiceImpl$screenSizeCallbacks$1", "Lcom/larus/business/multitask_management/impl/MultiTaskServiceImpl$screenSizeCallbacks$1;", "init", "", "handleScreenSizeChanged", "newConfig", "Landroid/content/res/Configuration;", "updateMultiTaskFloatWindowWidth", "getScreenWidth", "getMultiTaskManagementFragment", "Landroidx/fragment/app/DialogFragment;", "enterFrom", "", "getMultiTaskManagementFullscreenFragment", "Landroidx/fragment/app/Fragment;", "isMultiTaskManagementAccountEligible", "", "isMultiTaskManagementEntranceEnabled", "isMultiTaskManagementFloatWindowEnabled", "isMultiTaskManagementEnabled", "showMultiTaskFloatWindow", "hideMultiTaskFloatWindow", "expandMultiTaskFloatWindow", "animate", "collapseMultiTaskFloatWindow", "isMultiTaskFloatWindowExpanded", "presentingTaskListType", "closeMultiTaskPage", "resolveLocalIconResource", "uri", "(Ljava/lang/String;)Ljava/lang/Integer;", "findMultiTaskManagementFragment", "Landroidx/fragment/app/FragmentManager;", "findFragmentDeep", "predicate", "Lkotlin/Function1;", "findFragmentByTagDeep", "tag", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiTaskServiceImpl implements IMultiTaskService {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f320734e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.larus.business.multitask_management.impl.floatwindow.a f320735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f320736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f320737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f320738d;

    public static final class a {
    }

    public static final class b implements m4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiTaskServiceImpl f320739a;

        @Override // com.larus.platform.api.m4
        public final void S1() {
            this.f320739a.c();
        }

        @Override // com.larus.platform.api.m4
        public final void b1() {
            il9.a r100 = (il9.a) ServiceManager.get().getService(il9.a.class);
            if (r100 == null) goto L11;
            StateFlowImpl r101 = r100.I0();
            if (r101 == null) goto L11;
            List r102 = (List) r101.getValue();
            if (r102 == null) goto L11;
            boolean r103 = true;
            if ((!r102.isEmpty()) != true) goto L11;
        L12:
            if (r103 == false) goto L15;
            this.f320739a.e();
            return;
        L15:
            return;
        L11:
            r103 = false;
            goto L12
        }

        public b(MultiTaskServiceImpl r100) {
            this.f320739a = r100;
        }
    }

    public static final class c implements com.larus.platform.api.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiTaskServiceImpl f320740a;

        public c(MultiTaskServiceImpl r100) {
            this.f320740a = r100;
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            il9.a r101 = (il9.a) ServiceManager.get().getService(il9.a.class);
            if (r101 == null) goto L11;
            StateFlowImpl r102 = r101.I0();
            if (r102 == null) goto L11;
            List r103 = (List) r102.getValue();
            if (r103 == null) goto L11;
            boolean r104 = true;
            if ((!r103.isEmpty()) != true) goto L11;
        L12:
            if (r104 == false) goto L15;
            this.f320740a.e();
            return;
        L15:
            return;
        L11:
            r104 = false;
            goto L12
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f320740a.c();
        }
    }

    public static final class d implements ComponentCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiTaskServiceImpl f320741a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public d(MultiTaskServiceImpl r100) {
            this.f320741a = r100;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
            Intrinsics.checkNotNullParameter(r100, "newConfig");
            MultiTaskServiceImpl r101 = this.f320741a;
            int r102 = MultiTaskServiceImpl.f320734e;
            r101.getClass();
            int r103 = r100.screenWidthDp;
            Integer r104 = r101.f320737c;
            r101.f320737c = Integer.valueOf(r103);
            if (r104 != null) goto L5;
            return;
        L5:
            if (r104.intValue() != r103) goto L8;
            return;
        L8:
            if (r101.f320735a != null) goto L11;
            return;
        L11:
            if (r101.d() == false) goto L45;
            il9.a r105 = (il9.a) ServiceManager.get().getService(il9.a.class);
            boolean r106 = false;
            if (r105 == null) goto L22;
            StateFlowImpl r107 = r105.I0();
            if (r107 == null) goto L22;
            List r108 = (List) r107.getValue();
            if (r108 == null) goto L22;
            if (r108.isEmpty() == true) goto L22;
            boolean r109 = true;
        L23:
            if (r109 == false) goto L46;
            com.larus.business.multitask_management.impl.floatwindow.a r110 = r101.f320735a;
            if (r110 == null) goto L41;
            t r111 = t.f470740j;
            t r112 = t.a.a();
            if (r112 != null) goto L30;
        L32:
            if (r106 == false) goto L36;
            t r113 = t.a.a();
            if (r113 == null) goto L36;
            r113.n(r110);
        L36:
            TaskManagementFloatWindowView r114 = r110.f320890b;
            if (r114 == null) goto L42;
            r114.l();
            return;
        L42:
            return;
        L30:
            if (r112.j(r110) != true) goto L32;
            r106 = true;
            goto L32
        L41:
            return;
        L46:
            return;
        L22:
            r109 = false;
            goto L23
        }
    }

    /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.MultiTaskServiceImpl$init$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.business.multitask_management.impl.MultiTaskServiceImpl$init$2", f = "MultiTaskServiceImpl.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ il9.a $multiTaskManager;
        int label;
        final /* synthetic */ MultiTaskServiceImpl this$0;

        /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.MultiTaskServiceImpl$init$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MultiTaskServiceImpl f320742a;

            public AnonymousClass1(MultiTaskServiceImpl r100) {
                this.f320742a = r100;
            }

            public final Object a(List<u> r100, Continuation<? super Unit> r101) {
                if ((r101 instanceof MultiTaskServiceImpl$init$2$1$emit$1) == false) goto L7;
                MultiTaskServiceImpl$init$2$1$emit$1 r102 = (MultiTaskServiceImpl$init$2$1$emit$1) r101;
                int r103 = r102.label;
                if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
                r102.label = r103 - Integer.MIN_VALUE;
            L8:
                Object r104 = r102.result;
                Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r106 = r102.label;
                boolean r107 = true;
                if (r106 == 0) goto L14;
                if (r106 != 1) goto L13;
                ResultKt.throwOnFailure(r104);
            L24:
                il9.a r108 = (il9.a) ServiceManager.get().getService(il9.a.class);
                if (r108 == null) goto L33;
                StateFlowImpl r109 = r108.I0();
                if (r109 == null) goto L33;
                List r110 = (List) r109.getValue();
                if (r110 == null) goto L33;
                if (r110.isEmpty() != true) goto L33;
            L34:
                if (r107 == false) goto L37;
                this.f320742a.c();
            L37:
                return Unit.INSTANCE;
            L33:
                r107 = false;
                goto L34
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r104);
                FLogger.f375446a.i("multitask-MultiTaskServiceImpl", "getTaskRecordList " + r100.size());
                if (this.f320742a.d() == true) goto L19;
                this.f320742a.c();
                return Unit.INSTANCE;
            L19:
                if ((!r100.isEmpty()) == false) goto L21;
                this.f320742a.e();
                goto L37
            L21:
                r102.label = 1;
                if (DelayKt.delay(250, r102) != r105) goto L24;
                return r105;
            L7:
                r102 = new MultiTaskServiceImpl$init$2$1$emit$1(this, r101);
                goto L8
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
                return a((List) r100, r101);
            }
        }

        public AnonymousClass2(il9.a r100, MultiTaskServiceImpl r101, Continuation<? super AnonymousClass2> r102) {
            this.$multiTaskManager = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.$multiTaskManager, this.this$0, r101);
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
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            StateFlowImpl r103 = this.$multiTaskManager.I0();
            AnonymousClass1 r104 = new AnonymousClass1(this.this$0);
            this.label = 1;
            if (r103.collect(r104, this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    public final void c() {
        com.larus.business.multitask_management.impl.floatwindow.a r100 = this.f320735a;
        if (r100 == null) goto L7;
        t r101 = t.f470740j;
        t r102 = t.a.a();
        if (r102 == null) goto L7;
        r102.m(r100);
    L7:
        this.f320735a = null;
    }

    public final boolean d() {
        if (z2.f365865a.getAppsFrameworkConfig().f486664c == true) goto L5;
    L7:
        return false;
    L5:
        if (q() == false) goto L7;
        return true;
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final String i() {
        Activity r100 = AppHost.f326268a.a().getCurrentActivity();
        Fragment r101 = null;
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r102 = (FragmentActivity) r100;
    L6:
        if (r102 == null) goto L8;
        FragmentManager r103 = r102.getSupportFragmentManager();
    L9:
        if (r103 == null) goto L14;
        Fragment r104 = a(r103);
        if (r104 == null) goto L13;
        r101 = r104;
        goto L14
    L13:
        r101 = b(r103, new com.larus.business.multitask_management.impl.a());
    L14:
        boolean r105 = false;
        if (r101 != null) goto L17;
    L19:
        boolean r106 = false;
    L20:
        if (r106 == false) goto L24;
        return "multi_task_manage";
    L24:
        if (this.f320735a == null) goto L33;
        t r107 = t.f470740j;
        t r108 = t.a.a();
        if (r108 != null) goto L28;
    L30:
        if (r105 == false) goto L35;
        return "task_float_window";
    L35:
        return "";
    L28:
        if (r108.j(this.f320735a) != true) goto L30;
        r105 = true;
        goto L30
    L33:
        return "";
    L17:
        if (r101.isAdded() != true) goto L19;
        r106 = true;
        goto L20
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final void init() {
        if (this.f320736b.get() == false) goto L5;
        return;
    L5:
        il9.a r100 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r100 != null) goto L10;
        FLogger.f375446a.i("multitask-MultiTaskServiceImpl", "init skipped: IMultiTaskManager is not ready");
        return;
    L10:
        if (this.f320736b.compareAndSet(false, true) == false) goto L18;
        this.f320737c = Integer.valueOf(AppHost.f326268a.getApplication().getResources().getConfiguration().screenWidthDp);
        r100.init();
        Iterator r101 = ServiceManager.get().getServices(IMultiTaskInitEvent.class).iterator();
    L13:
        if (r101.hasNext() == false) goto L15;
        ((IMultiTaskInitEvent) r101.next()).onInit();
        goto L13
    L15:
        AppHost.Companion r102 = AppHost.f326268a;
        r102.getApplication().registerComponentCallbacks(this.f320738d);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass2(r100, this, null), 3, null);
        AccountService r103 = AccountService.f365697a;
        r103.H(new b(this));
        r103.E(new c(this));
        r102.a().j(new AnonymousClass5(this));
        return;
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final String m() {
        Activity r100 = AppHost.f326268a.a().getCurrentActivity();
        ww8.a r101 = null;
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r102 = (FragmentActivity) r100;
    L6:
        if (r102 == null) goto L8;
        FragmentManager r103 = r102.getSupportFragmentManager();
    L9:
        if (r103 == null) goto L14;
        Fragment r104 = a(r103);
        if (r104 != null) goto L15;
        r104 = b(r103, new com.larus.business.multitask_management.impl.a());
    L15:
        boolean r105 = true;
        if (r104 != null) goto L18;
    L20:
        boolean r106 = false;
    L21:
        if (r106 == false) goto L24;
        String r107 = "multi_task_manage";
    L35:
        if ((r104 instanceof DialogFragment) == false) goto L44;
        ((DialogFragment) r104).dismissAllowingStateLoss();     // Catch: Exception -> L39
    L50:
        p(false);
        return r107;
    L39:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r108 = DialogFragmentLancet.sLastShowStack;
        if (r108 == null) goto L50;
        com.bytedance.crash.d.d(r108, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L50
    L44:
        if ((r104 instanceof MultiTaskManagementFullscreenFragment) == false) goto L50;
        a0 r109 = b0.a(r104);
        if ((r109 instanceof ww8.a) == false) goto L48;
        r101 = (ww8.a) r109;
    L48:
        if (r101 == null) goto L50;
        r101.Gx();
        goto L50
    L24:
        if (this.f320735a == null) goto L33;
        t r110 = t.f470740j;
        t r111 = t.a.a();
        if (r111 != null) goto L28;
    L30:
        r105 = false;
    L31:
        if (r105 == false) goto L33;
        r107 = "task_float_window";
        goto L35
    L28:
        if (r111.j(this.f320735a) != true) goto L30;
    L33:
        r107 = "";
        goto L35
    L18:
        if (r104.isAdded() != true) goto L20;
        r106 = true;
        goto L21
    L14:
        r104 = null;
        goto L15
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final boolean n() {
        com.larus.business.multitask_management.impl.floatwindow.a r100 = this.f320735a;
        if (r100 != null) goto L5;
        return false;
    L5:
        t r101 = t.f470740j;
        t r102 = t.a.a();
        if (r102 != null) goto L8;
    L14:
        SingleFloatWindowState r103 = null;
    L16:
        if (r103 != SingleFloatWindowState.MAXIMIZE) goto L19;
        return true;
    L19:
        return false;
    L8:
        if (Intrinsics.areEqual(r102.f470742b.f470733a, r100) == false) goto L14;
        if (r102.f470744d == false) goto L14;
        r103 = r102.f470743c.f327489c.d();
        goto L16
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final void o() {
        if (this.f320735a == null) goto L15;
        t r100 = t.f470740j;
        t r101 = t.a.a();
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L16;
        t r103 = t.a.a();
        if (r103 == null) goto L17;
        r103.c(SingleFloatWindowState.MAXIMIZE, true);
        return;
    L17:
        return;
    L16:
        return;
    L7:
        if (r101.j(this.f320735a) != true) goto L9;
        r102 = true;
        goto L10
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final boolean q() {
        AccountService r100 = AccountService.f365697a;
        if (r100.a() == false) goto L5;
    L9:
        return false;
    L5:
        if (i3.f365750a.f() == true) goto L9;
        if (r100.isLogin().booleanValue() == false) goto L9;
        return true;
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final boolean u() {
        if (z2.f365865a.getAppsFrameworkConfig().f486665d == true) goto L5;
    L7:
        return false;
    L5:
        if (q() == false) goto L7;
        return true;
    }

    public MultiTaskServiceImpl() {
        this.f320736b = new AtomicBoolean(false);
        this.f320738d = new d(this);
    }

    public final void e() {
        if (d() == true) goto L6;
        return;
    L6:
        if (this.f320735a != null) goto L10;
        Activity r100 = AppHost.f326268a.a().getCurrentActivity();
        if (r100 == null) goto L10;
        this.f320735a = new com.larus.business.multitask_management.impl.floatwindow.a(r100);
    L10:
        com.larus.business.multitask_management.impl.floatwindow.a r101 = this.f320735a;
        if (r101 == null) goto L23;
        t r102 = t.f470740j;
        t r103 = t.a.a();
        if (r103 != null) goto L15;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == false) goto L24;
        t r105 = t.a.a();
        if (r105 == null) goto L25;
        r105.e(r101);
        return;
    L25:
        return;
    L24:
        return;
    L15:
        if (r103.j(this.f320735a) == true) goto L17;
        r104 = true;
        goto L18
    }

    public static Fragment a(FragmentManager r100) {
        Fragment r101 = r100.findFragmentByTag("multi_task_management");
        if (r101 == null) goto L5;
        return r101;
    L5:
        Iterator<T> r102 = r100.getFragments().iterator();
    L6:
        Fragment r103 = null;
        Object r104 = null;
        if (r102.hasNext() == false) goto L22;
        Fragment r105 = (Fragment) r102.next();
        if (r105.isAdded() == false) goto L6;
        if (r105.isDetached() == true) goto L6;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L14
        Object r107 = Result.m9449constructorimpl(a(r105.getChildFragmentManager()));     // Catch: Throwable -> L14
    L17:
        if (Result.m9455isFailureimpl(r107) == true) goto L20;
        r104 = r107;
    L20:
        r103 = (Fragment) r104;
        if (r103 == null) goto L6;
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L22:
        return r103;
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final void p(boolean r100) {
        if (this.f320735a == null) goto L15;
        t r101 = t.f470740j;
        t r102 = t.a.a();
        if (r102 == null) goto L9;
        boolean r103 = true;
        if (r102.j(this.f320735a) != true) goto L9;
    L10:
        if (r103 == false) goto L16;
        t r104 = t.a.a();
        if (r104 == null) goto L17;
        r104.c(SingleFloatWindowState.MINIMIZE, r100);
        return;
    L17:
        return;
    L16:
        return;
    L9:
        r103 = false;
        goto L10
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final Integer r(String r100) {
        Iterator<QuickAccessNodeDefaultIcons> r101 = QuickAccessNodeDefaultIcons.getEntries().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        QuickAccessNodeDefaultIcons r102 = r101.next();
        if (Intrinsics.areEqual(r102.getUri(), r100) == false) goto L4;
    L9:
        QuickAccessNodeDefaultIcons r103 = r102;
        if (r103 != null) goto L12;
        return null;
    L12:
        return Integer.valueOf(r103.getResId());
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final DialogFragment s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        if (e2.f365734a.isPad() == false) goto L5;
        MultiTaskManagementPadDialogFragment r101 = new MultiTaskManagementPadDialogFragment();
        Bundle r102 = new Bundle();
        r102.putString("enter_from", r100);
        r101.setArguments(r102);
        return r101;
    L5:
        MultiTaskManagementDialogFragment r103 = new MultiTaskManagementDialogFragment();
        Bundle r104 = new Bundle();
        r104.putString("enter_from", r100);
        r103.setArguments(r104);
        return r103;
    }

    @Override // com.larus.business.multitask_management.api.IMultiTaskService
    public final MultiTaskManagementFullscreenFragment t(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        MultiTaskManagementFullscreenFragment r101 = new MultiTaskManagementFullscreenFragment();
        Bundle r102 = new Bundle();
        r102.putString("enter_from", r100);
        r101.setArguments(r102);
        return r101;
    }

    public static Fragment b(FragmentManager r100, com.larus.business.multitask_management.impl.a r101) {
        Iterator<T> r102 = r100.getFragments().iterator();
    L4:
        if (r102.hasNext() == false) goto L15;
        Fragment r103 = (Fragment) r102.next();
        if (r103.isAdded() == false) goto L4;
        if (r103.isDetached() == true) goto L4;
        Intrinsics.checkNotNull(r103);
        if (((Boolean) r101.invoke(r103)).booleanValue() == true) goto L11;
        Fragment r104 = b(r103.getChildFragmentManager(), r101);
        if (r104 == null) goto L4;
        return r104;
    L11:
        return r103;
    L15:
        return null;
    }
}
