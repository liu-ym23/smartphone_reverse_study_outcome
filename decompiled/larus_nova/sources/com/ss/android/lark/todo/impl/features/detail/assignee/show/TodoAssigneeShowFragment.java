package com.ss.android.lark.todo.impl.features.detail.assignee.show;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator;
import com.larksuite.framework.utils.h0;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.todo.impl.features.detail.assignee.add.mvvm.TodoAssigneeAddActivity;
import com.ss.android.lark.todo.impl.features.detail.assignee.display.AssigneeBaseMeta;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.AssigneeBean;
import com.ss.android.lark.todo.impl.utils.i;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.IActionTitlebar$TextAction;
import com.ss.android.lark.utils.UIHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\"8\b\u0016\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00106\u001a\u00020\u0017H\u0002J\u0010\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020 H\u0002J\u0006\u0010<\u001a\u00020\u0017J\b\u0010=\u001a\u00020\u0017H\u0002J\"\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b#\u0010$R!\u00100\u001a\b\u0012\u0004\u0012\u000202018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u001e\u001a\u0004\b3\u00104R\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109¨\u0006E"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/assignee/show/TodoAssigneeShowFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "assigneeTabLayoutFromXml", "Lcom/larksuite/component/universe_design/tab/UDTabLayout;", "getAssigneeTabLayoutFromXml", "()Lcom/larksuite/component/universe_design/tab/UDTabLayout;", "setAssigneeTabLayoutFromXml", "(Lcom/larksuite/component/universe_design/tab/UDTabLayout;)V", "titleBarFromXml", "Lcom/ss/android/lark/ui/CommonTitleBar;", "getTitleBarFromXml", "()Lcom/ss/android/lark/ui/CommonTitleBar;", "setTitleBarFromXml", "(Lcom/ss/android/lark/ui/CommonTitleBar;)V", "assigneeViewPagerFromXml", "Landroidx/viewpager/widget/ViewPager;", "getAssigneeViewPagerFromXml", "()Landroidx/viewpager/widget/ViewPager;", "setAssigneeViewPagerFromXml", "(Landroidx/viewpager/widget/ViewPager;)V", "clearFromXmlViewCache", "", "onDestroyView", "mViewModel", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/show/TodoAssigneeShowViewModel;", "getMViewModel", "()Lcom/ss/android/lark/todo/impl/features/detail/assignee/show/TodoAssigneeShowViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mEditable", "", "assigneeListener", "com/ss/android/lark/todo/impl/features/detail/assignee/show/TodoAssigneeShowFragment$assigneeListener$2$1", "getAssigneeListener", "()Lcom/ss/android/lark/todo/impl/features/detail/assignee/show/TodoAssigneeShowFragment$assigneeListener$2$1;", "assigneeListener$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "assigneeFragments", "", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/list/AssigneeRecycleFragment;", "getAssigneeFragments", "()Ljava/util/List;", "assigneeFragments$delegate", "initObserver", "addAction", "com/ss/android/lark/todo/impl/features/detail/assignee/show/TodoAssigneeShowFragment$addAction$1", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/show/TodoAssigneeShowFragment$addAction$1;", "initTitleBar", "editable", "setResultAndGoBack", "initViewPager", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TodoAssigneeShowFragment extends BaseFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f442742l = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UDTabLayout f442743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CommonTitleBar f442744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewPager f442745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f442746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f442747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f442748i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f442749j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f442750k;

    public static final class a {
    }

    public static final class b extends IActionTitlebar$TextAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoAssigneeShowFragment f442752a;

        @Override // com.ss.android.lark.ui.IActionTitlebar$BaseAction, com.ss.android.lark.ui.IActionTitlebar$Action
        public final void performAction(View r100) {
            Intent r101 = new Intent();
            Context r102 = this.f442752a.getContext();
            if (r102 == null) goto L6;
            TodoAssigneeShowFragment r103 = this.f442752a;
            r101.setClass(r102, TodoAssigneeAddActivity.class);
            r101.putExtra("add_todo_user_request_code", 2);
            int r104 = TodoAssigneeShowFragment.f442742l;
            r101.putExtra("add_assignee_selected_ids", new ArrayList(r103.U90().getUserIds()));
            int r105 = TodoAssigneeAddActivity.f442586a;
            TodoAssigneeAddActivity.a.a(r103.getContext(), r103, r101, 2);
            return;
        }

        public b(TodoAssigneeShowFragment r100, String r101) {
            this.f442752a = r100;
            super(r101, R.color.primary_fill_default, 16);
        }
    }

    static {
    }

    public final UDTabLayout T90() {
        View r100 = this.f442743d;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.assignee_tabLayout);
    L8:
        this.f442743d = (UDTabLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (UDTabLayout) r100;
    }

    public final TodoAssigneeShowViewModel U90() {
        return (TodoAssigneeShowViewModel) this.f442746g.getValue();
    }

    public final CommonTitleBar V90() {
        View r100 = this.f442744e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.title_bar);
    L8:
        this.f442744e = (CommonTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (CommonTitleBar) r100;
    }

    public final void W90() {
        JSONArray r100 = new JSONArray();
        Iterator<AssigneeBean> r101 = U90().getUserData().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        AssigneeBean r102 = r101.next();
        JSONObject r103 = new JSONObject();
        r103.put("id", r102.getId());
        r103.put("name", r102.getName());
        r103.put("completedMilliTime", Long.valueOf(r102.getCompletedMilliTime()));
        r100.add(r103);
        goto L4
    L6:
        JSONObject r104 = new JSONObject();
        r104.put("result_list", r100);
        JSONObject r105 = new JSONObject();
        r105.put("data", r104);
        Bundle r106 = new Bundle();
        r106.putString("todo_assignee_result_data", r105.toJSONString());
        zab.a.b(this, -1, r106);
    }

    public TodoAssigneeShowFragment() {
        final Function0<Fragment> r100 = new TodoAssigneeShowFragment$special$$inlined$viewModels$default$1(this);
        this.f442746g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TodoAssigneeShowViewModel.class), new TodoAssigneeShowFragment$special$$inlined$viewModels$default$2(r100), new TodoAssigneeShowFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f442748i = LazyKt.lazy(new TodoAssigneeShowFragment$assigneeListener$2(this));
        this.f442749j = LazyKt.lazy(new TodoAssigneeShowFragment$assigneeFragments$2(this));
        this.f442750k = new b(this, UIHelper.getString(R.string.Todo_common_Add));
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f442743d = null;
        this.f442744e = null;
        this.f442745f = null;
    }

    public static final List S90(TodoAssigneeShowFragment r100) {
        return (List) r100.f442749j.getValue();
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ArrayList<AssigneeBaseMeta> r102 = new ArrayList();
        Bundle r103 = getArguments();
        View r104 = null;
        if (r103 == null) goto L5;
        Serializable r105 = r103.getSerializable("add_assignee_selected_users");
    L7:
        if ((r105 instanceof ArrayList) == false) goto L9;
        ArrayList r106 = (ArrayList) r105;
    L10:
        if (r106 == null) goto L12;
        r102.addAll(r106);
    L12:
        Bundle r107 = getArguments();
        boolean r108 = false;
        if (r107 == null) goto L15;
        r108 = r107.getBoolean("add_assignee_editable", false);
    L15:
        this.f442747h = r108;
        if (isActive() == false) goto L32;
        View r109 = this.f442745f;
        if (r109 != null) goto L25;
        View r110 = getView();
        if (r110 == null) goto L23;
        r109 = r110.findViewById(R.id.assignee_viewPager);
    L24:
        this.f442745f = (ViewPager) r109;
        goto L25
    L23:
        r109 = null;
    L25:
        final FragmentManager r111 = getChildFragmentManager();
        ((ViewPager) r109).setAdapter(new TodoAssigneeShowFragment$initViewPager$1(this, r111));
        UDTabLayout r112 = T90();
        View r113 = this.f442745f;
        if (r113 != null) goto L31;
        View r114 = getView();
        if (r114 == null) goto L30;
        r104 = r114.findViewById(R.id.assignee_viewPager);
    L30:
        this.f442745f = (ViewPager) r104;
        r113 = r104;
    L31:
        new UDTabLayoutCoordinator(r112, (ViewPager) r113).attach();
    L32:
        boolean r115 = this.f442747h;
        V90().setTitle(i.f444291a.g(R.string.Todo_New_Owner_Text));
        V90().setLeftClickListener(new c(this));
        if (r115 == false) goto L35;
        V90().addAction(this.f442750k);
    L36:
        U90().getUserDataLv().observe(this, new com.ss.android.lark.todo.impl.features.detail.assignee.show.b(this));
        U90().initData(r102, this.f442747h);
        return;
    L35:
        V90().removeAction(this.f442750k);
        goto L36
    L9:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r100 == 2) goto L5;
        return;
    L5:
        if (r101 != (-1)) goto L16;
        if (r102 == null) goto L17;
        String r103 = r102.getStringExtra("todo_add_member_chosen_data");
        ArrayList<SearchBaseInfo> r104 = (ArrayList) h0.a.f285998a.a(r103);
        if (r104 != null) goto L11;
        r104 = new ArrayList();
    L11:
        if (r104.isEmpty() == false) goto L13;
        return;
    L13:
        U90().addData(r104);
        return;
    L17:
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.todo_show_assignee_fragment, r101, false);
    }
}
