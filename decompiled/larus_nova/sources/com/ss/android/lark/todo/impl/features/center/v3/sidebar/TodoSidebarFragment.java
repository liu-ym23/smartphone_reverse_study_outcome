package com.ss.android.lark.todo.impl.features.center.v3.sidebar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.lark.pb.todo.v1.TaskContainer;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 h2\u00020\u0001:\u0001hB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u000201H\u0016J\b\u00103\u001a\u000201H\u0002J\u0010\u0010K\u001a\u0002012\u0006\u0010L\u001a\u00020MH\u0002J&\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u001a\u0010V\u001a\u0002012\u0006\u0010W\u001a\u00020O2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\b\u0010X\u001a\u000201H\u0002J\u0012\u0010Y\u001a\u0002012\b\u0010Z\u001a\u0004\u0018\u00010[H\u0002J\u0012\u0010\\\u001a\u0002012\b\u0010Z\u001a\u0004\u0018\u00010[H\u0002J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020;H\u0002J\b\u0010`\u001a\u000201H\u0002J\b\u0010a\u001a\u000201H\u0002J\u0006\u0010b\u001a\u000201J\u0006\u0010c\u001a\u000201J\"\u0010d\u001a\u0002012\u0006\u0010e\u001a\u00020;2\u0006\u0010f\u001a\u00020;2\b\u0010Z\u001a\u0004\u0018\u00010gH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001e\u0010!\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001e\u0010$\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001e\u0010'\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R\u001e\u0010*\u001a\u0004\u0018\u00010+8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b6\u00107R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u00109\u001a\u0004\b>\u0010?R\u001d\u0010A\u001a\u0004\u0018\u00010B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u00109\u001a\u0004\bC\u0010DR\u001b\u0010F\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u00109\u001a\u0004\bH\u0010I¨\u0006i"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/TodoSidebarFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "menuController", "Lcom/ss/android/lark/maincore/IMenuController;", "<init>", "(Lcom/ss/android/lark/maincore/IMenuController;)V", "containerPtrLayoutFromXml", "Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;", "getContainerPtrLayoutFromXml", "()Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;", "setContainerPtrLayoutFromXml", "(Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;)V", "buttonMeOwnerFromXml", "Landroid/widget/LinearLayout;", "getButtonMeOwnerFromXml", "()Landroid/widget/LinearLayout;", "setButtonMeOwnerFromXml", "(Landroid/widget/LinearLayout;)V", "textOwnedFromXml", "Landroid/widget/TextView;", "getTextOwnedFromXml", "()Landroid/widget/TextView;", "setTextOwnedFromXml", "(Landroid/widget/TextView;)V", "buttonFollowedFromXml", "getButtonFollowedFromXml", "setButtonFollowedFromXml", "textFollowedFromXml", "getTextFollowedFromXml", "setTextFollowedFromXml", "buttonAllEventsFromXml", "getButtonAllEventsFromXml", "setButtonAllEventsFromXml", "textAllEventsFromXml", "getTextAllEventsFromXml", "setTextAllEventsFromXml", "textOwnerCountFromXml", "getTextOwnerCountFromXml", "setTextOwnerCountFromXml", "textFollowCountFromXml", "getTextFollowCountFromXml", "setTextFollowCountFromXml", "rvContainerListFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getRvContainerListFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setRvContainerListFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "clearFromXmlViewCache", "", "onDestroyView", "closeDrawer", "viewModel", "Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/TodoSidebarViewModel;", "getViewModel", "()Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/TodoSidebarViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "collaboratorMaxCount", "", "shareDialogController", "Lcom/ss/android/lark/todo/impl/features/common/dialog/TaskListShareDialogController;", "getShareDialogController", "()Lcom/ss/android/lark/todo/impl/features/common/dialog/TaskListShareDialogController;", "shareDialogController$delegate", "shareDialogBuilder", "Lcom/ss/android/lark/todo/impl/features/common/dialog/TaskListShareDialogBuilder;", "getShareDialogBuilder", "()Lcom/ss/android/lark/todo/impl/features/common/dialog/TaskListShareDialogBuilder;", "shareDialogBuilder$delegate", "containerAdapter", "Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerAdapter;", "getContainerAdapter", "()Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerAdapter;", "containerAdapter$delegate", "goCreateTaskList", "fromPlusButton", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initObserver", "updateOwnerView", "data", "Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerItemData;", "updateFollowView", "generateItemCountStr", "", "itemCount", "initView", "initPtr", "onDrawerWillShow", "onDrawerClose", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoSidebarFragment extends BaseFragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f441665s = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LKUIPtrClassicFrameLayout f441666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f441667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f441668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f441669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f441670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f441671i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f441672j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f441673k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f441674l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RecyclerView f441675m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f441676n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f441677o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f441678p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f441679q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f441680r;

    public static final class a {
    }

    static {
    }

    public TodoSidebarFragment() {
        Intrinsics.checkNotNullParameter(null, "menuController");
        final Function0<Fragment> r100 = new TodoSidebarFragment$special$$inlined$viewModels$default$1(this);
        this.f441676n = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TodoSidebarViewModel.class), new TodoSidebarFragment$special$$inlined$viewModels$default$2(r100), new TodoSidebarFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f441677o = 3;
        this.f441678p = LazyKt.lazy(new TodoSidebarFragment$shareDialogController$2(this));
        this.f441679q = LazyKt.lazy(new TodoSidebarFragment$shareDialogBuilder$2(this));
        this.f441680r = LazyKt.lazy(new TodoSidebarFragment$containerAdapter$2(this));
    }

    public final LinearLayout T90() {
        View r100 = this.f441671i;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.button_all_events);
    L8:
        this.f441671i = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    public final LinearLayout U90() {
        View r100 = this.f441669g;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.button_followed);
    L8:
        this.f441669g = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    public final LinearLayout V90() {
        View r100 = this.f441667e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.button_me_owner);
    L8:
        this.f441667e = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    public final ContainerAdapter W90() {
        return (ContainerAdapter) this.f441680r.getValue();
    }

    public final LKUIPtrClassicFrameLayout X90() {
        View r100 = this.f441666d;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.container_ptr_layout);
    L8:
        this.f441666d = (LKUIPtrClassicFrameLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LKUIPtrClassicFrameLayout) r100;
    }

    public final TextView Y90() {
        View r100 = this.f441672j;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.text_all_events);
    L8:
        this.f441672j = (TextView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (TextView) r100;
    }

    public final TextView Z90() {
        View r100 = this.f441670h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.text_followed);
    L8:
        this.f441670h = (TextView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (TextView) r100;
    }

    public final TextView aa0() {
        View r100 = this.f441668f;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.text_owned);
    L8:
        this.f441668f = (TextView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (TextView) r100;
    }

    public final TodoSidebarViewModel ba0() {
        return (TodoSidebarViewModel) this.f441676n.getValue();
    }

    public final void S90() {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L6;
        com.ss.android.lark.base.embedded.b.b(r100);
    L6:
        throw null;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f441666d = null;
        this.f441667e = null;
        this.f441668f = null;
        this.f441669g = null;
        this.f441670h = null;
        this.f441671i = null;
        this.f441672j = null;
        this.f441673k = null;
        this.f441674l = null;
        this.f441675m = null;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        V90().setOnClickListener(new t(this));
        U90().setOnClickListener(new u(this));
        T90().setOnClickListener(new v(this));
        View r102 = this.f441675m;
        if (r102 != null) goto L9;
        View r103 = getView();
        if (r103 == null) goto L7;
        r102 = r103.findViewById(R.id.rv_container_list);
    L8:
        this.f441675m = (RecyclerView) r102;
        goto L9
    L7:
        r102 = null;
    L9:
        RecyclerView r104 = (RecyclerView) r102;
        r104.setLayoutManager(new LinearLayoutManager(r104.getContext(), 1, false));
        r104.setAdapter(W90());
        zdc.h.a(r104);
        ChatWindowPtrLoadingHeader r105 = new ChatWindowPtrLoadingHeader(getContext());
        X90().setHeaderView(r105);
        X90().addPtrUIHandler(r105);
        ChatWindowPtrLoadingHeader r106 = new ChatWindowPtrLoadingHeader(getContext());
        X90().setFooterView(r106);
        X90().addPtrUIHandler(r106);
        X90().setMode(LKUIPtrFrameLayout.Mode.LOAD_MORE);
        X90().setPtrHandler(new s(this));
        com.larksuite.framework.section.utils.a.d(T90(), true);
        ba0().getContainerListLv().observe(getViewLifecycleOwner(), new h(this));
        ba0().getSelectTaskListLv().observe(getViewLifecycleOwner(), new i(this));
        ba0().getSelectTaskAllEvents().observe(getViewLifecycleOwner(), new j(this));
        ba0().getSelectTaskListManageLv().observe(getViewLifecycleOwner(), new k(this));
        ba0().getSelectContainerLv().observe(getViewLifecycleOwner(), new l(this));
        ba0().getShowTaskListMoreDialog().observe(getViewLifecycleOwner(), new n(this));
        ba0().getShowSectionMoreDialog().observe(getViewLifecycleOwner(), new p(this));
        ba0().getShowCreateSectionDialog().observe(getViewLifecycleOwner(), new q(this));
        ba0().getSuccessToastLv().observe(getViewLifecycleOwner(), new r(this));
        ba0().getErrorToastLv().observe(getViewLifecycleOwner(), new f(this));
        ba0().getShareCollaboratorsLv().observe(getViewLifecycleOwner(), new g(this));
        ba0().initData();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r101 == (-1)) goto L5;
        return;
    L5:
        byte[] r103 = null;
        if (r100 != 48) goto L8;
        if (r102 == null) goto L16;
        byte[] r104 = r102.getByteArrayExtra("result.task.list.container");
    L17:
        TaskContainer r105 = TaskContainer.ADAPTER.decode(r104);
        TodoSidebarViewModel r106 = ba0();
        Intrinsics.checkNotNull(r105);
        r106.upsertTaskList(r105);
        ba0().updateSelectedTaskList(r105.guid);
        S90();
        throw null;
    L16:
        r104 = null;
        goto L17
    L8:
        if (r100 != 49) goto L19;
        if (r102 == null) goto L12;
        r103 = r102.getByteArrayExtra("result.task.list.container");
    L12:
        TaskContainer r107 = TaskContainer.ADAPTER.decode(r103);
        TodoSidebarViewModel r108 = ba0();
        Intrinsics.checkNotNull(r107);
        r108.upsertTaskList(r107);
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.todo_fragment_sidebar, r101, false);
    }
}
