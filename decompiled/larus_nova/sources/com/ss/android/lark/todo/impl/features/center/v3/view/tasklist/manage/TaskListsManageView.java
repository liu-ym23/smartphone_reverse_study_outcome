package com.ss.android.lark.todo.impl.features.center.v3.view.tasklist.manage;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.lark.pb.todo.v1.TaskContainerFilter;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.arch.jack.i;
import com.larksuite.arch.jack.j;
import com.larksuite.arch.jack.l;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.adapterhelper.TaskBaseQuickAdapter;
import com.ss.android.lark.todo.impl.features.center.v3.TaskMainCompatFragment;
import com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView;
import com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel;
import com.ss.android.lark.todo.impl.features.center.v3.view.TaskCenterEventsItemDecoration;
import com.ss.android.lark.todo.impl.features.center.v3.viewmodel.TaskListManageViewModel;
import com.ss.android.lark.todo.impl.features.tasklist.events.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\f\u0010\rJ\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f¨\u0006*"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/tasklist/manage/TaskListsManageView;", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/ISubView;", "view", "Landroid/view/View;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "viewLifecycle", "Landroidx/lifecycle/Lifecycle;", "viewModel", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/tasklist/manage/TaskListManageState;", "Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListManageAction;", "<init>", "(Landroid/view/View;Landroidx/fragment/app/Fragment;Landroidx/lifecycle/Lifecycle;Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;)V", "getView", "()Landroid/view/View;", "getFragment", "()Landroidx/fragment/app/Fragment;", "getViewLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getViewModel", "()Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "displayTabCategory", "Lcom/bytedance/lark/pb/todo/v1/TaskContainerFilter$TabFilter$TaskContainerTabCategory;", "displayArchivedCategory", "Lcom/bytedance/lark/pb/todo/v1/TaskContainerFilter$StatusFilter$TaskContainerArchiveCategory;", "scrollToTopRunnable", "Ljava/lang/Runnable;", "taskListsManageAdapter", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/tasklist/manage/TaskListsManageAdapter;", "getTaskListsManageAdapter", "()Lcom/ss/android/lark/todo/impl/features/center/v3/view/tasklist/manage/TaskListsManageAdapter;", "taskListsManageAdapter$delegate", "Lkotlin/Lazy;", "initViewAction", "", "initViewObserver", "initViewState", "scrollToTopWhenChanged", "taskListDisplayData", "Lcom/ss/android/lark/todo/impl/features/center/v3/viewmodel/TaskListDisplayData;", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskListsManageView implements ISubView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f442100i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f442101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f442102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lifecycle f442103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SubViewModel<com.ss.android.lark.todo.impl.features.center.v3.view.tasklist.manage.b, h> f442104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TaskContainerFilter.TabFilter.TaskContainerTabCategory f442105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TaskContainerFilter.StatusFilter.TaskContainerArchiveCategory f442106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f442107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f442108h;

    public static final class a {
    }

    public static final class b implements j7c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskListsManageView f442109a;

        @Override // j7c.a
        public final void onLoadMore() {
            this.f442109a.f442104d.handleAction(h.b.f444075a, null);
        }

        public b(TaskListsManageView r100) {
            this.f442109a = r100;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskListsManageView f442110a;

        public c(TaskListsManageView r100) {
            this.f442110a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.larksuite.framework.section.utils.a.d(this.f442110a.f442101a, !((Boolean) r100).booleanValue());
            TaskBaseQuickAdapter.z2((com.ss.android.lark.todo.impl.features.center.v3.view.tasklist.manage.d) this.f442110a.f442108h.getValue(), CollectionsKt.emptyList(), null, 6);
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskListsManageView f442111a;

        public d(TaskListsManageView r100) {
            this.f442111a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.larksuite.framework.section.utils.a.d(this.f442111a.f442101a, !((Boolean) r100).booleanValue());
            TaskBaseQuickAdapter.z2((com.ss.android.lark.todo.impl.features.center.v3.view.tasklist.manage.d) this.f442111a.f442108h.getValue(), CollectionsKt.emptyList(), null, 6);
        }
    }

    static {
    }

    @Override // com.larksuite.arch.jack.i
    public final LifecycleOwner getLifecycleOwner() {
        return this;
    }

    @Override // com.larksuite.arch.jack.f
    public final i getLifecycleOwnerHolder() {
        return this;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView
    public final void MD() {
        this.f442103c.addObserver(new TaskListsManageView$initViewObserver$1(this));
        com.ss.android.lark.todo.impl.features.center.v3.viewmodel.b r100 = (com.ss.android.lark.todo.impl.features.center.v3.viewmodel.b) this.f442104d.getSubViewEventStore();
        if (r100 == null) goto L5;
        r100.a().observe(this, new c(this));
    L5:
        com.ss.android.lark.todo.impl.features.center.v3.viewmodel.b r101 = (com.ss.android.lark.todo.impl.features.center.v3.viewmodel.b) this.f442104d.getSubViewEventStore();
        if (r101 == null) goto L9;
        r101.a().observe(this, new d(this));
        return;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView
    public final void S10() {
        Context r100 = this.f442101a.getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        RecyclerView r101 = (RecyclerView) this.f442101a.findViewById(R.id.task_list_manage_lists);
        StableLinearLayoutManager r102 = new StableLinearLayoutManager(r100);
        r102.setOrientation(1);
        r101.setLayoutManager(r102);
        RecyclerView r103 = (RecyclerView) this.f442101a.findViewById(R.id.task_list_manage_lists);
        com.ss.android.lark.todo.impl.features.center.v3.view.tasklist.manage.d r104 = (com.ss.android.lark.todo.impl.features.center.v3.view.tasklist.manage.d) this.f442108h.getValue();
        r104.f441364b = true;
        r104.f441365c = true;
        j7c.b r105 = r104.f441367e;
        r105.f497659c = true;
        r105.f497660d = 50;
        b r106 = new b(this);
        Intrinsics.checkNotNullParameter(r106, "listener");
        r105.f497658b = r106;
        r103.setAdapter(r104);
        ((RecyclerView) this.f442101a.findViewById(R.id.task_list_manage_lists)).addItemDecoration(new TaskCenterEventsItemDecoration());
        RecyclerView.ItemAnimator r107 = ((RecyclerView) this.f442101a.findViewById(R.id.task_list_manage_lists)).getItemAnimator();
        if (r107 == null) goto L8;
        r107.setAddDuration(0);
    L8:
        if (r107 == null) goto L10;
        r107.setChangeDuration(0);
    L10:
        if (r107 == null) goto L12;
        r107.setMoveDuration(0);
    L12:
        if (r107 == null) goto L15;
        r107.setRemoveDuration(0);
    L15:
        if ((r107 instanceof SimpleItemAnimator) == false) goto L17;
        ((SimpleItemAnimator) r107).setSupportsChangeAnimations(false);
    L17:
        ((RecyclerView) this.f442101a.findViewById(R.id.task_list_manage_lists)).setItemAnimator(r107);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView
    public final void oM() {
        SubViewModel<com.ss.android.lark.todo.impl.features.center.v3.view.tasklist.manage.b, h> r100 = this.f442104d;
        l r101 = new l();
        r101.f282807b = true;
        r101.f282806a = false;
        Unit r102 = Unit.INSTANCE;
        ISubView.a.e(this, r100, r101, new TaskListsManageView$initViewState$2(this));
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return a();
    }

    public final Lifecycle a() {
        return this.f442103c;
    }

    @Override // com.larksuite.arch.jack.f
    public final <S extends j> com.larksuite.arch.jack.c nH(JackViewModel<S> r100, l<S> r101, Function1<? super S, Unit> r102) {
        return ISubView.a.e(this, r100, r101, r102);
    }

    public TaskListsManageView(View r100, TaskMainCompatFragment r101, Lifecycle r102, TaskListManageViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "viewLifecycle");
        Intrinsics.checkNotNullParameter(r103, "viewModel");
        this.f442101a = r100;
        this.f442102b = r101;
        this.f442103c = r102;
        this.f442104d = r103;
        this.f442105e = TaskContainerFilter.TabFilter.TaskContainerTabCategory.TASK_CONTAINER_ALL;
        this.f442106f = TaskContainerFilter.StatusFilter.TaskContainerArchiveCategory.TASK_CONTAINER_UNARCHIVED;
        this.f442107g = new e(this);
        this.f442108h = LazyKt.lazy(new TaskListsManageView$taskListsManageAdapter$2(this));
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c Ik(JackViewModel r100, PropertyReference1Impl r101, l r102, Function1 r103) {
        return ISubView.a.b(this, r100, r101, r102, r103);
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c Ki(JackViewModel r100, PropertyReference1Impl r101, PropertyReference1Impl r102, l r103, Function1 r104) {
        return ISubView.a.c(this, r100, r101, r102, r103, r104);
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c O60(FilePickerViewModel r100, PropertyReference1Impl r101, PropertyReference1Impl r102, PropertyReference1Impl r103, l r104, Function1 r105) {
        return ISubView.a.d(this, r100, r101, r102, r103, r104, r105);
    }
}
