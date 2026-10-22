package com.ss.android.lark.todo.impl.features.detail.assignee.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.AssigneeBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00100\u001a\u00020\u0019H\u0002J\u001c\u00101\u001a\u00020\u00192\f\u00102\u001a\b\u0012\u0004\u0012\u000204032\u0006\u0010%\u001a\u00020$J\u0006\u00105\u001a\u00020\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/assignee/list/AssigneeRecycleFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "listener", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/list/TodoAssigneeAdapter$AssigneeAdapterListener;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/detail/assignee/list/TodoAssigneeAdapter$AssigneeAdapterListener;)V", "emptyContainerFromXml", "Landroid/widget/RelativeLayout;", "getEmptyContainerFromXml", "()Landroid/widget/RelativeLayout;", "setEmptyContainerFromXml", "(Landroid/widget/RelativeLayout;)V", "tvEmptyListFromXml", "Landroid/widget/TextView;", "getTvEmptyListFromXml", "()Landroid/widget/TextView;", "setTvEmptyListFromXml", "(Landroid/widget/TextView;)V", "assigneeListFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getAssigneeListFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setAssigneeListFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "clearFromXmlViewCache", "", "onDestroyView", "title", "", "adapter", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/list/TodoAssigneeAdapter;", "getAdapter", "()Lcom/ss/android/lark/todo/impl/features/detail/assignee/list/TodoAssigneeAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "isEmpty", "", "isDoing", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initRecyclerView", "setData", "assignees", "", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/AssigneeBean;", "getTitle", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssigneeRecycleFragment extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TodoAssigneeAdapter.a f442663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RelativeLayout f442664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f442665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f442666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f442667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f442668i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f442669j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f442670k;

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f442664e = null;
        this.f442665f = null;
        this.f442666g = null;
    }

    public AssigneeRecycleFragment(TodoAssigneeAdapter.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f442663d = r100;
        this.f442667h = "";
        this.f442668i = LazyKt.lazy(new AssigneeRecycleFragment$adapter$2(this));
        this.f442670k = true;
    }

    public final void S90(List<AssigneeBean> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "assignees");
        TodoAssigneeAdapter r102 = (TodoAssigneeAdapter) this.f442668i.getValue();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "list");
        r102.f442672b = r100;
        r102.notifyDataSetChanged();
        if (r101 == false) goto L5;
        com.ss.android.lark.todo.impl.utils.i r103 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        String r104 = com.ss.android.lark.todo.impl.utils.i.d(R.string.Todo_CollabTask_IncompleteTitleNum, "num", String.valueOf(((ArrayList) r100).size()));
    L6:
        this.f442667h = r104;
        this.f442669j = CollectionUtils.isEmpty(r100);
        this.f442670k = r101;
        View r105 = this.f442664e;
        if (r105 != null) goto L13;
        View r106 = getView();
        if (r106 == null) goto L11;
        r105 = r106.findViewById(R.id.empty_container);
    L12:
        this.f442664e = (RelativeLayout) r105;
        goto L13
    L11:
        r105 = null;
    L13:
        RelativeLayout r107 = (RelativeLayout) r105;
        if (r107 == null) goto L17;
        com.larksuite.framework.section.utils.a.d(r107, this.f442669j);
        return;
    L17:
        return;
    L5:
        com.ss.android.lark.todo.impl.utils.i r108 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r104 = com.ss.android.lark.todo.impl.utils.i.d(R.string.Todo_CollabTask_CompletedTitleNum, "num", String.valueOf(((ArrayList) r100).size()));
        goto L6
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        LinearLayoutManager r102 = new LinearLayoutManager(getContext());
        r102.setOrientation(1);
        View r103 = this.f442666g;
        View r104 = null;
        if (r103 != null) goto L9;
        View r105 = getView();
        if (r105 == null) goto L7;
        r103 = r105.findViewById(R.id.assignee_list);
    L8:
        this.f442666g = (RecyclerView) r103;
        goto L9
    L7:
        r103 = null;
    L9:
        ((RecyclerView) r103).setLayoutManager(r102);
        View r106 = this.f442666g;
        if (r106 != null) goto L16;
        View r107 = getView();
        if (r107 == null) goto L14;
        r106 = r107.findViewById(R.id.assignee_list);
    L15:
        this.f442666g = (RecyclerView) r106;
        goto L16
    L14:
        r106 = null;
    L16:
        ((RecyclerView) r106).setAdapter((TodoAssigneeAdapter) this.f442668i.getValue());
        View r108 = this.f442664e;
        if (r108 != null) goto L23;
        View r109 = getView();
        if (r109 == null) goto L21;
        r108 = r109.findViewById(R.id.empty_container);
    L22:
        this.f442664e = (RelativeLayout) r108;
        goto L23
    L21:
        r108 = null;
    L23:
        com.larksuite.framework.section.utils.a.d((RelativeLayout) r108, this.f442669j);
        View r110 = this.f442665f;
        if (r110 != null) goto L29;
        View r111 = getView();
        if (r111 == null) goto L28;
        r104 = r111.findViewById(R.id.tv_empty_list);
    L28:
        this.f442665f = (TextView) r104;
        r110 = r104;
    L29:
        TextView r112 = (TextView) r110;
        if (this.f442670k == false) goto L32;
        String r113 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_AssigneePage_AllAssigneesHaveComleted_EmptyState);
    L33:
        r112.setText(r113);
        return;
    L32:
        r113 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_AssigneePage_NoAssigneesCompletedTask_EmptyState);
        goto L33
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.todo_detail_assignee_fragment_recyle, null, false);
    }
}
