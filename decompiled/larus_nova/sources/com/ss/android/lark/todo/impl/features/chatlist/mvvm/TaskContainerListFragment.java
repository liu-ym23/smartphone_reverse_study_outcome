package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView;
import com.ss.android.lark.todo.impl.features.center.v3.view.CreateView;
import com.ss.android.lark.todo.impl.features.center.v3.view.FilterSectionView;
import com.ss.android.lark.todo.impl.features.center.v3.view.ListView;
import com.ss.android.lark.todo.impl.features.center.v3.view.TaskListContainerTabView;
import com.ss.android.lark.todo.impl.features.center.v3.viewmodel.ContainerSingleTaskListViewModel;
import com.ss.android.lark.todo.impl.features.center.v3.viewmodel.CreateViewModel;
import com.ss.android.lark.todo.impl.features.center.v3.viewmodel.FilterSectionViewModel;
import com.ss.android.lark.todo.impl.features.center.v3.viewmodel.ListViewModel;
import com.ss.android.lark.todo.impl.features.common.helper.OperationToastHelper;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0016J&\u0010/\u001a\u0004\u0018\u00010\u000b2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u001a\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\"\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020&H\u0002J\"\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010D\u001a\u00020#H\u0016J\b\u0010E\u001a\u00020#H\u0016J\b\u0010F\u001a\u00020#H\u0016J\b\u0010[\u001a\u00020#H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u001b\u0010G\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010.\u001a\u0004\bI\u0010JR\u001b\u0010L\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010.\u001a\u0004\bN\u0010OR\u001b\u0010Q\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010.\u001a\u0004\bS\u0010TR\u001b\u0010V\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010.\u001a\u0004\bX\u0010Y¨\u0006]"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TaskContainerListFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "fragmentContainerFromXml", "Landroid/widget/FrameLayout;", "getFragmentContainerFromXml", "()Landroid/widget/FrameLayout;", "setFragmentContainerFromXml", "(Landroid/widget/FrameLayout;)V", "containerFromXml", "Landroid/view/View;", "getContainerFromXml", "()Landroid/view/View;", "setContainerFromXml", "(Landroid/view/View;)V", "filterContainerFromXml", "getFilterContainerFromXml", "setFilterContainerFromXml", "listContentContainerFromXml", "Landroid/widget/RelativeLayout;", "getListContentContainerFromXml", "()Landroid/widget/RelativeLayout;", "setListContentContainerFromXml", "(Landroid/widget/RelativeLayout;)V", "taskCreateContainerFromXml", "getTaskCreateContainerFromXml", "setTaskCreateContainerFromXml", "backIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getBackIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setBackIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "clearFromXmlViewCache", "", "onDestroyView", "isFragmentShowing", "", "permissionFragment", "Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TaskListPermissionFragment;", "modelManager", "Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TaskContainerListModelManager;", "getModelManager", "()Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TaskContainerListModelManager;", "modelManager$delegate", "Lkotlin/Lazy;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showNoPermissionFragmentLogic", "containerGuid", "", "owner", "Lcom/bytedance/lark/pb/todo/v1/TodoUser;", "fragmentIsShow", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onResume", "onPause", LiveCommonConstants.REASON_ON_DEDTROY, "containerTabViewModel", "Lcom/ss/android/lark/todo/impl/features/center/v3/viewmodel/ContainerSingleTaskListViewModel;", "getContainerTabViewModel", "()Lcom/ss/android/lark/todo/impl/features/center/v3/viewmodel/ContainerSingleTaskListViewModel;", "containerTabViewModel$delegate", "filterSectionViewModel", "Lcom/ss/android/lark/todo/impl/features/center/v3/viewmodel/FilterSectionViewModel;", "getFilterSectionViewModel", "()Lcom/ss/android/lark/todo/impl/features/center/v3/viewmodel/FilterSectionViewModel;", "filterSectionViewModel$delegate", "listViewModel", "Lcom/ss/android/lark/todo/impl/features/center/v3/viewmodel/ListViewModel;", "getListViewModel", "()Lcom/ss/android/lark/todo/impl/features/center/v3/viewmodel/ListViewModel;", "listViewModel$delegate", "createViewModel", "Lcom/ss/android/lark/todo/impl/features/center/v3/viewmodel/CreateViewModel;", "getCreateViewModel", "()Lcom/ss/android/lark/todo/impl/features/center/v3/viewmodel/CreateViewModel;", "createViewModel$delegate", "initView", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TaskContainerListFragment extends BaseFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f442271q = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f442272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f442273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f442274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RelativeLayout f442275g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RelativeLayout f442276h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AppCompatImageView f442277i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f442278j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TaskListPermissionFragment f442279k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f442280l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f442281m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f442282n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f442283o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f442284p;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskContainerListFragment f442285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f442286b;

        public b(TaskContainerListFragment r100, String r101) {
            this.f442285a = r100;
            this.f442286b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            Context r100 = this.f442285a.getContext();
            if (r100 == null) goto L6;
            String r101 = this.f442286b;
            TaskContainerListFragment r102 = this.f442285a;
            com.ss.android.lark.todo.impl.features.detail.a.d(com.ss.android.lark.todo.impl.features.detail.a.f442563a, r100, r101, r102, false, null, null, null, null, false, 504);
            return;
        }
    }

    static {
    }

    public final c S90() {
        return (c) this.f442280l.getValue();
    }

    public TaskContainerListFragment() {
        this.f442280l = LazyKt.lazy(new TaskContainerListFragment$modelManager$2(this));
        this.f442281m = LazyKt.lazy(new TaskContainerListFragment$containerTabViewModel$2(this));
        this.f442282n = LazyKt.lazy(new TaskContainerListFragment$filterSectionViewModel$2(this));
        this.f442283o = LazyKt.lazy(new TaskContainerListFragment$listViewModel$2(this));
        this.f442284p = LazyKt.lazy(new TaskContainerListFragment$createViewModel$2(this));
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        c r100 = S90();
        ListViewModel r101 = r100.f442372k;
        if (r101 == null) goto L5;
        r101.onClear();
    L5:
        ContainerSingleTaskListViewModel r102 = r100.f442369h;
        if (r102 == null) goto L8;
        r102.onClear();
    L8:
        ExecutorService r103 = r100.f442374m;
        if (r103 == null) goto L12;
        r103.shutdownNow();
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f442272d = null;
        this.f442273e = null;
        this.f442274f = null;
        this.f442275g = null;
        this.f442276h = null;
        this.f442277i = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        c r100 = S90();
        ListViewModel r101 = r100.f442372k;
        if (r101 == null) goto L5;
        r101.onPause();
    L5:
        ListViewModel r102 = r100.f442372k;
        if (r102 == null) goto L9;
        r102.cancelScheduled();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ListViewModel r100 = S90().f442372k;
        if (r100 == null) goto L6;
        r100.startScheduled();
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        View r112 = this.f442273e;
        View r100 = null;
        if (r112 != null) goto L9;
        View r113 = getView();
        if (r113 == null) goto L7;
        r112 = r113.findViewById(R.id.container);
    L8:
        this.f442273e = r112;
        goto L9
    L7:
        r112 = null;
    L9:
        ISubView.a.a(new TaskListContainerTabView(r112, this, getLifecycle(), (ContainerSingleTaskListViewModel) this.f442281m.getValue()));
        View r114 = this.f442274f;
        if (r114 != null) goto L16;
        View r115 = getView();
        if (r115 == null) goto L14;
        r114 = r115.findViewById(R.id.filter_container);
    L15:
        this.f442274f = r114;
        goto L16
    L14:
        r114 = null;
    L16:
        new FilterSectionView(r114, getLifecycle(), (FilterSectionViewModel) this.f442282n.getValue()).e();
        View r116 = this.f442275g;
        if (r116 != null) goto L23;
        View r117 = getView();
        if (r117 == null) goto L21;
        r116 = r117.findViewById(R.id.list_content_container);
    L22:
        this.f442275g = (RelativeLayout) r116;
        goto L23
    L21:
        r116 = null;
    L23:
        ISubView.a.a(new ListView((RelativeLayout) r116, null, this, getLifecycle(), (ListViewModel) this.f442283o.getValue()));
        View r118 = this.f442276h;
        if (r118 != null) goto L30;
        View r119 = getView();
        if (r119 == null) goto L28;
        r118 = r119.findViewById(R.id.task_create_container);
    L29:
        this.f442276h = (RelativeLayout) r118;
        goto L30
    L28:
        r118 = null;
    L30:
        new CreateView((RelativeLayout) r118, getLifecycle(), (CreateViewModel) this.f442284p.getValue()).b();
        c r120 = S90();
        ContainerSingleTaskListViewModel r121 = r120.f442369h;
        if (r121 == null) goto L33;
        r121.setComputeThread(r120.f442374m);
    L33:
        CreateViewModel r122 = r120.f442370i;
        if (r122 == null) goto L36;
        r122.setComputeThread(r120.f442374m);
    L36:
        ListViewModel r123 = r120.f442372k;
        if (r123 == null) goto L39;
        r123.setComputeThread(r120.f442374m);
    L39:
        FilterSectionViewModel r124 = r120.f442371j;
        if (r124 == null) goto L42;
        r124.setComputeThread(r120.f442374m);
    L42:
        View r125 = this.f442277i;
        if (r125 != null) goto L48;
        View r126 = getView();
        if (r126 == null) goto L47;
        r100 = r126.findViewById(R.id.back_icon);
    L47:
        this.f442277i = (AppCompatImageView) r100;
        r125 = r100;
    L48:
        ((AppCompatImageView) r125).setOnClickListener(new com.ss.android.lark.todo.impl.features.chatlist.mvvm.a(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r110, int r111, Intent r112) {
        super.onActivityResult(r110, r111, r112);
        if (r111 == (-1)) goto L5;
    L14:
        ListViewModel r100 = S90().f442372k;
        if (r100 == null) goto L20;
        r100.registerActivityResult(r110, r111, r112);
        return;
    L20:
        return;
    L5:
        if (r110 != 33) goto L14;
        if (r112 == null) goto L13;
        Bundle r101 = r112.getExtras();
        if (r101 == null) goto L18;
        String r102 = r101.getString("message_alert_todo_guid");
        if (r102 == null) goto L19;
        OperationToastHelper.f442443a.e(getContext(), R.string.Todo_common_CreatedSuccessfully, null, 0, null, com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Task_ViewDetails), new b(this, r102));
        goto L14
    L19:
        return;
    L18:
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.task_container_list_activity, r101, false);
    }
}
