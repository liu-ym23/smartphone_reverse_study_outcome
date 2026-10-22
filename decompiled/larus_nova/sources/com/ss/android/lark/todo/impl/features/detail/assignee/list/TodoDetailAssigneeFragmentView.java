package com.ss.android.lark.todo.impl.features.detail.assignee.list;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.lark.pb.todo.v1.TaskMode;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.AssigneeBean;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoData;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.p;
import com.ss.android.lark.ui.CommonTitleBar;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoDetailAssigneeFragmentView extends com.larksuite.framework.section.h<p> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f442677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FragmentManager f442678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larksuite.framework.section.e<p> f442679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f442680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f442681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f442682g;

    @Override // com.larksuite.framework.section.h
    public final void i() {
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        ViewPager r100 = (ViewPager) this.f442677b.findViewById(R.id.assignee_viewPager);
        final FragmentManager r101 = this.f442678c;
        r100.setAdapter(new TodoDetailAssigneeFragmentView$initViewPager$1(this, r101));
        new UDTabLayoutCoordinator((UDTabLayout) this.f442677b.findViewById(R.id.assignee_tabLayout), (ViewPager) this.f442677b.findViewById(R.id.assignee_viewPager)).attach();
        p r102 = e();
        k(r102.getAssigneeFragmentShowAdd(), new TodoDetailAssigneeFragmentView$initViewObserver$1$1(this));
        k(r102.getAssigneeMultiStrategy(), new TodoDetailAssigneeFragmentView$initViewObserver$1$2(this));
        k(r102.getAssignees(), new TodoDetailAssigneeFragmentView$initViewObserver$1$3(this));
        k(r102.getShowTaskModeChooserDialog(), new TodoDetailAssigneeFragmentView$initViewObserver$1$4(this));
        k(r102.getTaskMode(), new TodoDetailAssigneeFragmentView$initViewObserver$1$5(this));
        ((CommonTitleBar) this.f442677b.findViewById(R.id.title_bar)).setLeftClickListener(new i(this));
        List<AssigneeBean> r103 = e().getAssignees().getValue();
        if (r103 == null) goto L5;
        int r104 = r103.size();
    L6:
        p(r104);
        this.f442677b.findViewById(R.id.text_button_add).setOnClickListener(new h(this));
        LinearLayoutManager r105 = new LinearLayoutManager(getContext());
        r105.setOrientation(1);
        ((RecyclerView) this.f442677b.findViewById(R.id.assignee_list)).setLayoutManager(r105);
        ((RecyclerView) this.f442677b.findViewById(R.id.assignee_list)).setAdapter((TodoAssigneeAdapter) this.f442682g.getValue());
        com.larksuite.framework.section.utils.a.d(this.f442677b.findViewById(R.id.layout_task_mode), true);
        TextView r106 = (TextView) this.f442677b.findViewById(R.id.text_task_mode);
        if (o() == false) goto L9;
        com.ss.android.lark.todo.impl.utils.i r107 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        int r108 = R.string.Todo_MultiOwners_RequireAnyoneComplete_Option;
    L10:
        r106.setText(r107.g(r108));
        this.f442677b.findViewById(R.id.layout_task_mode).setOnClickListener(new g(this));
        return;
    L9:
        r107 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r108 = R.string.Todo_MultiOwners_RequireEveryoneComplete_Option;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final boolean o() {
        TodoData r100 = e().getTodoDataLiveData().getValue();
        if (r100 == null) goto L5;
        TaskMode r101 = r100.getMode();
    L7:
        if (r101 != TaskMode.TASK_COMPLETE) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    public static final List n(TodoDetailAssigneeFragmentView r100) {
        return (List) r100.f442681f.getValue();
    }

    public final void p(int r100) {
        if (r100 <= 0) goto L5;
        ((TextView) this.f442677b.findViewById(R.id.text_title)).setText(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_Owner_Text) + " (" + r100 + ')');
        return;
    L5:
        ((TextView) this.f442677b.findViewById(R.id.text_title)).setText(com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_New_Owner_Text));
    }

    public TodoDetailAssigneeFragmentView(View r100, FragmentManager r101, com.larksuite.framework.section.e<p> r102) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "fragmentManager");
        Intrinsics.checkNotNullParameter(r102, "ability");
        super(r102);
        this.f442677b = r100;
        this.f442678c = r101;
        this.f442679d = r102;
        this.f442680e = LazyKt.lazy(new TodoDetailAssigneeFragmentView$assigneeListener$2(this));
        this.f442681f = LazyKt.lazy(new TodoDetailAssigneeFragmentView$assigneeFragments$2(this));
        this.f442682g = LazyKt.lazy(new TodoDetailAssigneeFragmentView$assigneeAdapter$2(this));
    }
}
