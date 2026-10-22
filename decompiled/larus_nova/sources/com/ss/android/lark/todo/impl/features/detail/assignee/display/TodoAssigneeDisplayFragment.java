package com.ss.android.lark.todo.impl.features.detail.assignee.display;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.larksuite.framework.utils.h0;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.todo.impl.utils.i;
import com.ss.android.lark.ui.CommonTitleBar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 [2\u00020\u0001:\u0001[B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0016J&\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u001a\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020D2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010M\u001a\u00020)H\u0002J\b\u0010N\u001a\u00020)H\u0002J\b\u0010O\u001a\u00020)H\u0002J\b\u0010P\u001a\u000209H\u0002J\u0010\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u000209H\u0002J\u0010\u0010S\u001a\u00020)2\u0006\u0010T\u001a\u000202H\u0002J\b\u0010U\u001a\u00020)H\u0002J\u0006\u0010V\u001a\u00020)J\"\u0010W\u001a\u00020)2\u0006\u00108\u001a\u0002092\u0006\u0010X\u001a\u0002092\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001e\u0010%\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b-\u0010.R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u0012\u0012\u0004\u0012\u00020504j\b\u0012\u0004\u0012\u000205`6X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u00100\u001a\u0004\b>\u0010?R\u0012\u0010A\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0004\n\u0002\u0010B¨\u0006\\"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/assignee/display/TodoAssigneeDisplayFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "failViewFromXml", "Lcom/larksuite/component/universe_design/emptystate/UDEmptyState;", "getFailViewFromXml", "()Lcom/larksuite/component/universe_design/emptystate/UDEmptyState;", "setFailViewFromXml", "(Lcom/larksuite/component/universe_design/emptystate/UDEmptyState;)V", "assigneeListFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getAssigneeListFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setAssigneeListFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "layoutTaskModeFromXml", "Landroid/widget/LinearLayout;", "getLayoutTaskModeFromXml", "()Landroid/widget/LinearLayout;", "setLayoutTaskModeFromXml", "(Landroid/widget/LinearLayout;)V", "textTaskModeFromXml", "Landroid/widget/TextView;", "getTextTaskModeFromXml", "()Landroid/widget/TextView;", "setTextTaskModeFromXml", "(Landroid/widget/TextView;)V", "titleBarFromXml", "Lcom/ss/android/lark/ui/CommonTitleBar;", "getTitleBarFromXml", "()Lcom/ss/android/lark/ui/CommonTitleBar;", "setTitleBarFromXml", "(Lcom/ss/android/lark/ui/CommonTitleBar;)V", "textButtonAddFromXml", "getTextButtonAddFromXml", "setTextButtonAddFromXml", "textTitleFromXml", "getTextTitleFromXml", "setTextTitleFromXml", "clearFromXmlViewCache", "", "onDestroyView", "mViewModel", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/display/TodoAssigneeDisplayViewModel;", "getMViewModel", "()Lcom/ss/android/lark/todo/impl/features/detail/assignee/display/TodoAssigneeDisplayViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mEditable", "", "mSelectedIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "customTitleText", "requestCode", "", "isNewTaskMode", "chatIdForAddAssignee", "mAdapter", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/display/TodoAssigneeDisplayAdapter;", "getMAdapter", "()Lcom/ss/android/lark/todo/impl/features/detail/assignee/display/TodoAssigneeDisplayAdapter;", "mAdapter$delegate", "initSuccess", "Ljava/lang/Boolean;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initObserver", "initTaskModeView", "initTitleBar", "generateAddRequestCode", "updateTitleCount", "memberCount", "displayTitleAction", "visible", "initRecyclerView", "setResultAndGoBack", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TodoAssigneeDisplayFragment extends BaseFragment {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f442633t = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UDEmptyState f442634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView f442635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f442636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f442637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CommonTitleBar f442638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f442639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f442640j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f442641k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f442642l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<String> f442643m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f442644n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f442645o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f442646p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f442647q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f442648r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Boolean f442649s;

    public static final class a {
    }

    static {
    }

    public final RecyclerView T90() {
        View r100 = this.f442635e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.assignee_list);
    L8:
        this.f442635e = (RecyclerView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (RecyclerView) r100;
    }

    public final TodoAssigneeDisplayViewModel U90() {
        return (TodoAssigneeDisplayViewModel) this.f442641k.getValue();
    }

    public final void V90() {
        if (Intrinsics.areEqual(this.f442649s, Boolean.TRUE) == true) goto L7;
        zab.a.a(this);
        return;
    L7:
        if (CollectionsKt.listOf(new Integer[]{20, 9}).contains(Integer.valueOf(this.f442645o)) == false) goto L9;
        Bundle r100 = new Bundle();
        r100.putBoolean("show_subtask_is_new_task_mode", this.f442646p);
        r100.putString("todo_add_member_chosen_data", "todo_add_member_chosen_data");
        h0.a.f285998a.b("todo_add_member_chosen_data", U90().getUserData());
        zab.a.b(this, -1, r100);
        return;
    L9:
        JSONArray r101 = new JSONArray();
        Iterator<UserBean> r102 = U90().getUserData().iterator();
    L11:
        if (r102.hasNext() == false) goto L13;
        UserBean r103 = r102.next();
        JSONObject r104 = new JSONObject();
        r104.put("id", r103.getId());
        r104.put("name", r103.getName());
        r101.add(r104);
        goto L11
    L13:
        JSONObject r105 = new JSONObject();
        r105.put("result_list", r101);
        JSONObject r106 = new JSONObject();
        r106.put("data", r105);
        Bundle r107 = new Bundle();
        r107.putString("todo_assignee_result_data", r106.toJSONString());
        zab.a.b(this, -1, r107);
    }

    public TodoAssigneeDisplayFragment() {
        final Function0<Fragment> r100 = new TodoAssigneeDisplayFragment$special$$inlined$viewModels$default$1(this);
        this.f442641k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TodoAssigneeDisplayViewModel.class), new TodoAssigneeDisplayFragment$special$$inlined$viewModels$default$2(r100), new TodoAssigneeDisplayFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f442643m = new ArrayList();
        this.f442645o = -1;
        this.f442646p = true;
        this.f442647q = "";
        this.f442648r = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new TodoAssigneeDisplayFragment$mAdapter$2(this));
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f442634d = null;
        this.f442635e = null;
        this.f442636f = null;
        this.f442637g = null;
        this.f442638h = null;
        this.f442639i = null;
        this.f442640j = null;
    }

    public final void W90(int r100) {
        boolean r101 = true;
        View r102 = null;
        if (r100 <= 0) goto L20;
        View r103 = this.f442640j;
        if (r103 != null) goto L10;
        View r104 = getView();
        if (r104 == null) goto L9;
        r102 = r104.findViewById(R.id.text_title);
    L9:
        this.f442640j = (TextView) r102;
        r103 = r102;
    L10:
        TextView r105 = (TextView) r103;
        StringBuilder r106 = new StringBuilder();
        String r107 = this.f442644n;
        if (r107 != null) goto L13;
    L16:
        if (r101 == true) goto L18;
        String r108 = this.f442644n;
    L19:
        r106.append(r108);
        r106.append(" (");
        r106.append(r100);
        r106.append(')');
        r105.setText(r106.toString());
        return;
    L18:
        r108 = i.f444291a.g(R.string.Todo_New_Owner_Text);
        goto L19
    L13:
        if (r107.length() == 0) goto L16;
        r101 = false;
        goto L16
    L20:
        View r109 = this.f442640j;
        if (r109 != null) goto L26;
        View r110 = getView();
        if (r110 == null) goto L25;
        r102 = r110.findViewById(R.id.text_title);
    L25:
        this.f442640j = (TextView) r102;
        r109 = r102;
    L26:
        TextView r111 = (TextView) r109;
        String r112 = this.f442644n;
        if (r112 != null) goto L29;
    L32:
        if (r101 == true) goto L34;
        String r113 = this.f442644n;
    L35:
        r111.setText(r113);
        return;
    L34:
        r113 = i.f444291a.g(R.string.Todo_New_Owner_Text);
        goto L35
    L29:
        if (r112.length() == 0) goto L32;
        r101 = false;
        goto L32
    }

    public static final void S90(TodoAssigneeDisplayFragment r100, boolean r101) {
        if (r100.f442649s != null) goto L18;
        r100.f442649s = Boolean.valueOf(r101);
        View r102 = r100.f442639i;
        if (r102 != null) goto L11;
        View r103 = r100.getView();
        if (r103 == null) goto L9;
        r102 = r103.findViewById(R.id.text_button_add);
    L10:
        r100.f442639i = (TextView) r102;
        goto L11
    L9:
        r102 = null;
    L11:
        TextView r104 = (TextView) r102;
        if (r100.f442642l == false) goto L15;
        if (r101 == false) goto L15;
        boolean r105 = true;
    L16:
        com.larksuite.framework.section.utils.a.d(r104, r105);
        Unit r106 = Unit.INSTANCE;
        return;
    L15:
        r105 = false;
        goto L16
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Bundle r102 = getArguments();
        View r103 = null;
        if (r102 == null) goto L5;
        Serializable r104 = r102.getSerializable("add_assignee_selected_ids");
    L7:
        if ((r104 instanceof ArrayList) == false) goto L9;
        ArrayList r105 = (ArrayList) r104;
    L10:
        if (r105 == null) goto L12;
        this.f442643m.addAll(r105);
    L12:
        Bundle r106 = getArguments();
        boolean r107 = false;
        if (r106 == null) goto L15;
        boolean r108 = r106.getBoolean("add_assignee_editable", false);
    L16:
        this.f442642l = r108;
        Bundle r109 = getArguments();
        if (r109 == null) goto L19;
        String r110 = r109.getString("add_member_custom_title");
    L20:
        this.f442644n = r110;
        Bundle r111 = getArguments();
        int r112 = -1;
        if (r111 == null) goto L23;
        r112 = r111.getInt("add_todo_user_request_code", -1);
    L23:
        this.f442645o = r112;
        Bundle r113 = getArguments();
        if (r113 == null) goto L26;
        boolean r114 = r113.getBoolean("show_subtask_is_new_task_mode", true);
    L27:
        this.f442646p = r114;
        Bundle r115 = getArguments();
        if (r115 == null) goto L31;
        String r116 = r115.getString("add_assignee_chat_id");
        if (r116 == null) goto L31;
    L32:
        this.f442647q = r116;
        View r117 = this.f442638h;
        if (r117 != null) goto L39;
        View r118 = getView();
        if (r118 == null) goto L37;
        r117 = r118.findViewById(R.id.title_bar);
    L38:
        this.f442638h = (CommonTitleBar) r117;
        goto L39
    L37:
        r117 = null;
    L39:
        ((CommonTitleBar) r117).setLeftClickListener(new g(this));
        ArrayList<UserBean> r119 = U90().getUserDataLv().getValue();
        if (r119 == null) goto L42;
        int r120 = r119.size();
    L43:
        W90(r120);
        View r121 = this.f442639i;
        if (r121 != null) goto L50;
        View r122 = getView();
        if (r122 == null) goto L48;
        r121 = r122.findViewById(R.id.text_button_add);
    L49:
        this.f442639i = (TextView) r121;
        goto L50
    L48:
        r121 = null;
    L50:
        ((TextView) r121).setOnClickListener(new f(this));
        LinearLayoutManager r123 = new LinearLayoutManager(getContext());
        r123.setOrientation(1);
        T90().setLayoutManager(r123);
        T90().setAdapter((TodoAssigneeDisplayAdapter) this.f442648r.getValue());
        View r124 = this.f442636f;
        if (r124 != null) goto L57;
        View r125 = getView();
        if (r125 == null) goto L55;
        r124 = r125.findViewById(R.id.layout_task_mode);
    L56:
        this.f442636f = (LinearLayout) r124;
        goto L57
    L55:
        r124 = null;
    L57:
        LinearLayout r126 = (LinearLayout) r124;
        if (this.f442645o != 9) goto L60;
        r107 = true;
    L60:
        com.larksuite.framework.section.utils.a.d(r126, r107);
        View r127 = this.f442637g;
        if (r127 != null) goto L67;
        View r128 = getView();
        if (r128 == null) goto L65;
        r127 = r128.findViewById(R.id.text_task_mode);
    L66:
        this.f442637g = (TextView) r127;
        goto L67
    L65:
        r127 = null;
    L67:
        TextView r129 = (TextView) r127;
        if (this.f442646p == false) goto L70;
        i r130 = i.f444291a;
        int r131 = R.string.Todo_MultiOwners_RequireAnyoneComplete_Option;
    L71:
        r129.setText(r130.g(r131));
        View r132 = this.f442636f;
        if (r132 != null) goto L77;
        View r133 = getView();
        if (r133 == null) goto L76;
        r103 = r133.findViewById(R.id.layout_task_mode);
    L76:
        this.f442636f = (LinearLayout) r103;
        r132 = r103;
    L77:
        ((LinearLayout) r132).setOnClickListener(new d(this));
        U90().getUserDataLv().observe(this, new c(this));
        U90().initData(this.f442643m);
        return;
    L70:
        r130 = i.f444291a;
        r131 = R.string.Todo_MultiOwners_RequireEveryoneComplete_Option;
        goto L71
    L42:
        r120 = 0;
    L31:
        r116 = "";
        goto L32
    L26:
        r114 = true;
        goto L27
    L19:
        r110 = null;
        goto L20
    L15:
        r108 = false;
        goto L16
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (CollectionsKt.listOf(new Integer[]{2, 8}).contains(Integer.valueOf(r100)) == true) goto L5;
        return;
    L5:
        if (r101 != (-1)) goto L16;
        if (r102 == null) goto L17;
        ArrayList<SearchBaseInfo> r103 = (ArrayList) h0.a.f285998a.a(r102.getStringExtra("todo_add_member_chosen_data"));
        if (r103 != null) goto L11;
        r103 = new ArrayList();
    L11:
        if (r103.isEmpty() == false) goto L13;
        return;
    L13:
        U90().addData(r103);
        return;
    L17:
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.todo_display_assignee_fragment, r101, false);
    }
}
