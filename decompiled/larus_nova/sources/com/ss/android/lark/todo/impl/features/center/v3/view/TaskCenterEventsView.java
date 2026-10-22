package com.ss.android.lark.todo.impl.features.center.v3.view;

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
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.adapterhelper.TaskBaseQuickAdapter;
import com.ss.android.lark.todo.impl.features.center.v3.TaskMainCompatFragment;
import com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView;
import com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel;
import com.ss.android.lark.todo.impl.features.center.v3.viewmodel.TaskCenterEventsViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskCenterEventsView;", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/ISubView;", "view", "Landroid/view/View;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "viewLifecycle", "Landroidx/lifecycle/Lifecycle;", "viewModel", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListEventsState;", "Lcom/ss/android/lark/todo/impl/features/tasklist/events/TaskListEventsAction;", "<init>", "(Landroid/view/View;Landroidx/fragment/app/Fragment;Landroidx/lifecycle/Lifecycle;Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;)V", "getView", "()Landroid/view/View;", "getFragment", "()Landroidx/fragment/app/Fragment;", "getViewLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getViewModel", "()Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "eventsAdapter", "Lcom/ss/android/lark/todo/impl/adapterhelper/TaskBaseQuickAdapter;", "getEventsAdapter", "()Lcom/ss/android/lark/todo/impl/adapterhelper/TaskBaseQuickAdapter;", "eventsAdapter$delegate", "Lkotlin/Lazy;", "initViewAction", "", "initViewObserver", "initViewState", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskCenterEventsView implements ISubView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f441915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f441916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lifecycle f441917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SubViewModel<com.ss.android.lark.todo.impl.features.tasklist.events.g, com.ss.android.lark.todo.impl.features.tasklist.events.e> f441918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f441919e;

    public static final class a implements j7c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskCenterEventsView f441920a;

        @Override // j7c.a
        public final void onLoadMore() {
            this.f441920a.f441918d.handleAction(com.ss.android.lark.todo.impl.features.tasklist.events.e.b.f444070a, null);
        }

        public a(TaskCenterEventsView r100) {
            this.f441920a = r100;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskCenterEventsView f441921a;

        public b(TaskCenterEventsView r100) {
            this.f441921a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.larksuite.framework.section.utils.a.d(this.f441921a.f441915a, !((Boolean) r100).booleanValue());
            TaskBaseQuickAdapter.z2((TaskBaseQuickAdapter) this.f441921a.f441919e.getValue(), CollectionsKt.emptyList(), null, 6);
        }
    }

    @Override // com.larksuite.arch.jack.i
    public final LifecycleOwner getLifecycleOwner() {
        return this;
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.i getLifecycleOwnerHolder() {
        return this;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView
    public final void MD() {
        com.ss.android.lark.todo.impl.features.center.v3.viewmodel.a r100 = (com.ss.android.lark.todo.impl.features.center.v3.viewmodel.a) this.f441918d.getSubViewEventStore();
        if (r100 == null) goto L6;
        r100.a().observe(this, new b(this));
        return;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView
    public final void S10() {
        RecyclerView r100 = (RecyclerView) this.f441915a.findViewById(R.id.recycler_view);
        final Context r101 = this.f441915a.getContext();
        StableLinearLayoutManager r102 = new TaskCenterEventsView$initViewAction$1(r101);
        r102.setOrientation(1);
        r100.setLayoutManager(r102);
        RecyclerView r103 = (RecyclerView) this.f441915a.findViewById(R.id.recycler_view);
        TaskBaseQuickAdapter r104 = (TaskBaseQuickAdapter) this.f441919e.getValue();
        r104.f441364b = true;
        r104.f441365c = true;
        j7c.b r105 = r104.f441367e;
        r105.f497659c = true;
        r105.f497660d = 20;
        a r106 = new a(this);
        Intrinsics.checkNotNullParameter(r106, "listener");
        r105.f497658b = r106;
        r103.setAdapter(r104);
        ((RecyclerView) this.f441915a.findViewById(R.id.recycler_view)).addItemDecoration(new TaskCenterEventsItemDecoration());
        RecyclerView.ItemAnimator r107 = ((RecyclerView) this.f441915a.findViewById(R.id.recycler_view)).getItemAnimator();
        if (r107 == null) goto L5;
        r107.setAddDuration(0);
    L5:
        if (r107 == null) goto L7;
        r107.setChangeDuration(0);
    L7:
        if (r107 == null) goto L9;
        r107.setMoveDuration(0);
    L9:
        if (r107 == null) goto L12;
        r107.setRemoveDuration(0);
    L12:
        if ((r107 instanceof SimpleItemAnimator) == false) goto L14;
        ((SimpleItemAnimator) r107).setSupportsChangeAnimations(false);
    L14:
        ((RecyclerView) this.f441915a.findViewById(R.id.recycler_view)).setItemAnimator(r107);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView
    public final void oM() {
        SubViewModel<com.ss.android.lark.todo.impl.features.tasklist.events.g, com.ss.android.lark.todo.impl.features.tasklist.events.e> r100 = this.f441918d;
        com.larksuite.arch.jack.l r101 = new com.larksuite.arch.jack.l();
        r101.f282807b = true;
        r101.f282806a = false;
        Unit r102 = Unit.INSTANCE;
        ISubView.a.e(this, r100, r101, new TaskCenterEventsView$initViewState$2(this));
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return a();
    }

    public final Lifecycle a() {
        return this.f441917c;
    }

    @Override // com.larksuite.arch.jack.f
    public final <S extends com.larksuite.arch.jack.j> com.larksuite.arch.jack.c nH(JackViewModel<S> r100, com.larksuite.arch.jack.l<S> r101, Function1<? super S, Unit> r102) {
        return ISubView.a.e(this, r100, r101, r102);
    }

    public TaskCenterEventsView(View r100, TaskMainCompatFragment r101, Lifecycle r102, TaskCenterEventsViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "viewLifecycle");
        Intrinsics.checkNotNullParameter(r103, "viewModel");
        this.f441915a = r100;
        this.f441916b = r101;
        this.f441917c = r102;
        this.f441918d = r103;
        this.f441919e = LazyKt.lazy(new TaskCenterEventsView$eventsAdapter$2(this));
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c Ik(JackViewModel r100, PropertyReference1Impl r101, com.larksuite.arch.jack.l r102, Function1 r103) {
        return ISubView.a.b(this, r100, r101, r102, r103);
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c Ki(JackViewModel r100, PropertyReference1Impl r101, PropertyReference1Impl r102, com.larksuite.arch.jack.l r103, Function1 r104) {
        return ISubView.a.c(this, r100, r101, r102, r103, r104);
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c O60(FilePickerViewModel r100, PropertyReference1Impl r101, PropertyReference1Impl r102, PropertyReference1Impl r103, com.larksuite.arch.jack.l r104, Function1 r105) {
        return ISubView.a.d(this, r100, r101, r102, r103, r104, r105);
    }
}
