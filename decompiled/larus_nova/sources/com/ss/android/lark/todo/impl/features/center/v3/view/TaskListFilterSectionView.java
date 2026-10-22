package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import com.bytedance.lark.pb.todo.v1.TaskContainerFilter;
import com.larksuite.arch.jack.JackViewModel;
import com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView;
import com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel;
import com.ss.android.lark.todo.impl.features.center.v3.viewmodel.FilterSectionViewModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001%B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R7\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015`\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010#\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u000f¨\u0006&"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListFilterSectionView;", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/ISubView;", "contentView", "Landroid/view/View;", "viewLifecycle", "Landroidx/lifecycle/Lifecycle;", "viewModel", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "Lcom/ss/android/lark/todo/impl/features/center/v3/viewstate/FilterSectionViewState;", "Lcom/ss/android/lark/todo/impl/features/center/v3/action/FilterSectionViewAction;", "<init>", "(Landroid/view/View;Landroidx/lifecycle/Lifecycle;Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;)V", "getContentView", "()Landroid/view/View;", "getViewLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getViewModel", "()Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "textTabs", "Ljava/util/HashMap;", "Lcom/bytedance/lark/pb/todo/v1/TaskContainerFilter$TabFilter$TaskContainerTabCategory;", "Landroid/widget/TextView;", "Lkotlin/collections/HashMap;", "getTextTabs", "()Ljava/util/HashMap;", "textTabs$delegate", "Lkotlin/Lazy;", "initView", "", "initViewAction", "initViewObserver", "initViewState", "selectFilter", "selectTabCategory", "resetFilter", NewBroadcastMonitor.STAGE.LIFECYCLE, "getLifecycle", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskListFilterSectionView implements ISubView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f441971e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f441972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lifecycle f441973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SubViewModel<t7c.c, m7c.d> f441974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f441975d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView
    public final void MD() {
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView
    public final void S10() {
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
    public final void oM() {
        com.larksuite.arch.jack.f.a.e(this, this.f441974c, TaskListFilterSectionView$initViewState$1.INSTANCE, new TaskListFilterSectionView$initViewState$2(this));
        com.larksuite.arch.jack.f.a.e(this, this.f441974c, TaskListFilterSectionView$initViewState$3.INSTANCE, new TaskListFilterSectionView$initViewState$4(this));
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f441973b;
    }

    public final void a(TaskContainerFilter.TabFilter.TaskContainerTabCategory r100) {
        Iterator r101 = ((HashMap) this.f441975d.getValue()).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Map.Entry r102 = (Map.Entry) r101.next();
        TaskContainerFilter.TabFilter.TaskContainerTabCategory r103 = (TaskContainerFilter.TabFilter.TaskContainerTabCategory) r102.getKey();
        TextView r104 = (TextView) r102.getValue();
        if (r103 != r100) goto L8;
        boolean r105 = true;
    L9:
        r104.setSelected(r105);
        r104.getPaint().setFakeBoldText(r105);
        goto L4
    L8:
        r105 = false;
        goto L9
    }

    public TaskListFilterSectionView(View r100, Lifecycle r101, FilterSectionViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        Intrinsics.checkNotNullParameter(r101, "viewLifecycle");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        this.f441972a = r100;
        this.f441973b = r101;
        this.f441974c = r102;
        this.f441975d = LazyKt.lazy(new TaskListFilterSectionView$textTabs$2(this));
    }

    @Override // com.larksuite.arch.jack.f
    public final <S extends com.larksuite.arch.jack.j> com.larksuite.arch.jack.c nH(JackViewModel<S> r100, com.larksuite.arch.jack.l<S> r101, Function1<? super S, Unit> r102) {
        return ISubView.a.e(this, r100, r101, r102);
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
