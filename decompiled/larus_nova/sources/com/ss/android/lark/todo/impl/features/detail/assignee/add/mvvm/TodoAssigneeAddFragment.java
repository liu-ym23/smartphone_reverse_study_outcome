package com.ss.android.lark.todo.impl.features.detail.assignee.add.mvvm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.h0;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.Picker;
import com.ss.android.lark.picker.base.widget.business.ContactsSelectorBusiness;
import com.ss.android.lark.picker.config.ConfigKt;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.detail.assignee.add.adapter.AssigneeRecommendAdapter;
import com.ss.android.lark.todo.impl.flutterweb.bridge.a0;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import z5c.c2;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 u2\u00020\u0001:\u0001uB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000202H\u0016J&\u0010W\u001a\u0004\u0018\u00010X2\u0006\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\\2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u001a\u0010_\u001a\u0002022\u0006\u0010`\u001a\u00020X2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\b\u0010a\u001a\u000202H\u0002J\b\u0010b\u001a\u000202H\u0002J\b\u0010c\u001a\u000202H\u0002J\b\u0010d\u001a\u000202H\u0002J\b\u0010e\u001a\u000202H\u0002J\b\u0010f\u001a\u000202H\u0002J\b\u0010g\u001a\u000202H\u0002J\b\u0010h\u001a\u000202H\u0002J\b\u0010i\u001a\u00020>H\u0002J\b\u0010j\u001a\u000202H\u0002J\b\u0010m\u001a\u000202H\u0002J\b\u0010n\u001a\u00020EH\u0002J\b\u0010o\u001a\u000202H\u0002J\"\u0010p\u001a\u0002022\u0006\u0010F\u001a\u00020C2\u0006\u0010q\u001a\u00020C2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\b\u0010t\u001a\u000202H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u001e\u0010%\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001e\u0010(\u001a\u0004\u0018\u00010)8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b6\u00107R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010<\u001a\u0012\u0012\u0004\u0012\u00020>0=j\b\u0012\u0004\u0012\u00020>`?X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010J\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0004\n\u0002\u0010KR\u000e\u0010L\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010k\u001a\u00020E8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010l¨\u0006v"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/assignee/add/mvvm/TodoAssigneeAddFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "todoChatterPickerFromXml", "Lcom/ss/android/lark/picker/Picker;", "getTodoChatterPickerFromXml", "()Lcom/ss/android/lark/picker/Picker;", "setTodoChatterPickerFromXml", "(Lcom/ss/android/lark/picker/Picker;)V", "titleBarFromXml", "Lcom/ss/android/lark/ui/CommonTitleBar;", "getTitleBarFromXml", "()Lcom/ss/android/lark/ui/CommonTitleBar;", "setTitleBarFromXml", "(Lcom/ss/android/lark/ui/CommonTitleBar;)V", "layoutNextStepContainerFromXml", "Landroid/widget/LinearLayout;", "getLayoutNextStepContainerFromXml", "()Landroid/widget/LinearLayout;", "setLayoutNextStepContainerFromXml", "(Landroid/widget/LinearLayout;)V", "nextStepTextFromXml", "Landroid/widget/TextView;", "getNextStepTextFromXml", "()Landroid/widget/TextView;", "setNextStepTextFromXml", "(Landroid/widget/TextView;)V", "layoutStepBtnFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getLayoutStepBtnFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setLayoutStepBtnFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "layoutBatchAssignFromXml", "getLayoutBatchAssignFromXml", "setLayoutBatchAssignFromXml", "bottomBatchAssignButtonFromXml", "getBottomBatchAssignButtonFromXml", "setBottomBatchAssignButtonFromXml", "bottomBatchAssignIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getBottomBatchAssignIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setBottomBatchAssignIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "bottomBatchAssignTextFromXml", "getBottomBatchAssignTextFromXml", "setBottomBatchAssignTextFromXml", "clearFromXmlViewCache", "", "onDestroyView", "mViewModel", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/add/mvvm/TodoAssigneeAddViewModel;", "getMViewModel", "()Lcom/ss/android/lark/todo/impl/features/detail/assignee/add/mvvm/TodoAssigneeAddViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mRecommendAdapter", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/add/adapter/AssigneeRecommendAdapter;", "mSelectedIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mAssigneeChatId", "mConfirmText", "memberCount", "", "isSelectAll", "", "requestCode", DBDefinition.TASK_ID, "isCreateTodo", "isSinglePick", "isAssignee", "Ljava/lang/Boolean;", "supportChooseChat", "needShowBatchAssignView", "needShowNoSummaryToast", "needShowSubTaskLimitToast", "needShowNextStepView", "operatorRoleValue", "taskListId", "taskListOwner", "Lcom/bytedance/lark/pb/todo/v1/TodoUser;", "isSubTaskDetail", "customTitleText", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "viewHitPoint", "initObserver", "initAdapter", "bindAdapterLv", "initTitleBar", "bindTitleLv", "setResultAndGoBack", "initChatterPicker", "getTagNameByRequestCode", "initNextStepView", "isFlutterWebCall", "()Z", "initBatchAssignView", "isForSubTask", "handleSwitchToMultipleStatus", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TodoAssigneeAddFragment extends BaseFragment {
    public static final /* synthetic */ int I = 0;
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public String E;
    public TodoUser F;
    public boolean G;
    public String H;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Picker f442587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CommonTitleBar f442588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f442589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f442590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UDButton f442591h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f442592i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f442593j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AppCompatImageView f442594k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f442595l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f442596m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AssigneeRecommendAdapter f442597n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<String> f442598o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f442599p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f442600q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f442601r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f442602s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f442603t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f442604u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f442605v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f442606w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Boolean f442607x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f442608y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f442609z;

    public static final class a {
    }

    static {
    }

    public final LinearLayout T90() {
        View r100 = this.f442592i;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.layout_batch_assign);
    L8:
        this.f442592i = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    public final UDButton U90() {
        View r100 = this.f442591h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.layout_step_btn);
    L8:
        this.f442591h = (UDButton) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (UDButton) r100;
    }

    public final TodoAssigneeAddViewModel V90() {
        return (TodoAssigneeAddViewModel) this.f442596m.getValue();
    }

    public final CommonTitleBar W90() {
        View r100 = this.f442588e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.title_bar);
    L8:
        this.f442588e = (CommonTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (CommonTitleBar) r100;
    }

    public final Picker X90() {
        View r100 = this.f442587d;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.todo_chatter_picker);
    L8:
        this.f442587d = (Picker) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (Picker) r100;
    }

    public TodoAssigneeAddFragment() {
        final Function0<Fragment> r100 = new TodoAssigneeAddFragment$special$$inlined$viewModels$default$1(this);
        this.f442596m = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TodoAssigneeAddViewModel.class), new TodoAssigneeAddFragment$special$$inlined$viewModels$default$2(r100), new TodoAssigneeAddFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f442598o = new ArrayList();
        this.f442600q = UIHelper.getString(R.string.Lark_Legacy_ConfirmDone) + "(0)";
        this.f442603t = 2;
        this.E = "";
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Callback r100 = a0.f444156c;
        a0.a.a(null);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f442587d = null;
        this.f442588e = null;
        this.f442589f = null;
        this.f442590g = null;
        this.f442591h = null;
        this.f442592i = null;
        this.f442593j = null;
        this.f442594k = null;
        this.f442595l = null;
    }

    public static final void S90(TodoAssigneeAddFragment r100) {
        int r101 = r100.f442603t;
        if (r101 != 100) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L10;
        Callback r103 = a0.f444156c;
        a0.a.a(r100.V90().getChosenMembers());
        zab.a.b(r100, -1, new Bundle());
        return;
    L10:
        if (r101 != 5) goto L16;
        JSONArray r104 = new JSONArray();
        Iterator<SearchBaseInfo> r105 = r100.V90().getChosenMembers().iterator();
    L13:
        if (r105.hasNext() == false) goto L15;
        SearchBaseInfo r106 = r105.next();
        JSONObject r107 = new JSONObject();
        r107.put("id", r106.getId());
        r107.put("name", r106.getTitle());
        r104.add(r107);
        goto L13
    L15:
        JSONObject r108 = new JSONObject();
        r108.put("result_list", r104);
        JSONObject r109 = new JSONObject();
        r109.put("data", r108);
        Bundle r110 = new Bundle();
        r110.putString("todo_assignee_result_data", r109.toJSONString());
        zab.a.b(r100, -1, r110);
        return;
    L16:
        Bundle r111 = new Bundle();
        r111.putBoolean("add_select_mode_mode_is_single_pick", r100.f442606w);
        r111.putString("todo_add_member_chosen_data", "todo_add_member_chosen_data");
        h0.a.f285998a.b("todo_add_member_chosen_data", r100.V90().getChosenMembers());
        zab.a.b(r100, -1, r111);
        return;
    L5:
        r102 = false;
        goto L7
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        Serializable r101 = r100.getSerializable("add_assignee_selected_ids");
    L7:
        if ((r101 instanceof ArrayList) == false) goto L9;
        ArrayList r102 = (ArrayList) r101;
    L10:
        Bundle r103 = getArguments();
        if (r103 == null) goto L13;
        String r104 = r103.getString("add_todo_member_task_guid");
    L14:
        this.f442604u = r104;
        if (r102 == null) goto L17;
        this.f442598o.addAll(r102);
    L17:
        Bundle r105 = getArguments();
        boolean r106 = false;
        if (r105 == null) goto L20;
        boolean r107 = r105.getBoolean("add_assignee_is_create_todo", false);
    L21:
        this.f442605v = r107;
        Bundle r108 = getArguments();
        if (r108 == null) goto L24;
        Serializable r109 = r108.getSerializable("add_assignee_chat_id");
    L26:
        if ((r109 instanceof String) == false) goto L28;
        String r110 = (String) r109;
    L29:
        this.f442599p = r110;
        Bundle r111 = getArguments();
        if (r111 == null) goto L32;
        int r112 = r111.getInt("add_todo_user_request_code", 2);
    L33:
        this.f442603t = r112;
        Bundle r113 = getArguments();
        if (r113 == null) goto L36;
        String r114 = r113.getString("add_member_custom_title");
    L37:
        this.H = r114;
        Bundle r115 = getArguments();
        if (r115 == null) goto L40;
        boolean r116 = r115.getBoolean("add_task_owner_is_subtask_detail", false);
    L41:
        this.G = r116;
        Bundle r117 = getArguments();
        if (r117 == null) goto L44;
        boolean r118 = r117.getBoolean("add_task_owner_show_batch_assign", false);
    L45:
        this.f442609z = r118;
        Bundle r119 = getArguments();
        if (r119 == null) goto L48;
        boolean r120 = r119.getBoolean("add_task_owner_show_batch_assign_toast", false);
    L49:
        this.A = r120;
        Bundle r121 = getArguments();
        if (r121 == null) goto L52;
        boolean r122 = r121.getBoolean("add_task_owner_show_subtask_limit_toast", false);
    L53:
        this.B = r122;
        Bundle r123 = getArguments();
        if (r123 == null) goto L56;
        int r124 = r123.getInt("task_list_operator_role_type", 0);
    L57:
        this.D = r124;
        Bundle r125 = getArguments();
        if (r125 == null) goto L60;
        boolean r126 = r125.getBoolean("add_task_list_collaborator", false);
    L61:
        this.C = r126;
        Bundle r127 = getArguments();
        if (r127 == null) goto L65;
        String r128 = r127.getString("task_list_members_container_id");
        if (r128 == null) goto L65;
    L66:
        this.E = r128;
        Bundle r129 = getArguments();
        if (r129 == null) goto L69;
        Serializable r130 = r129.getSerializable("task_list_container_owner");
    L71:
        if ((r130 instanceof TodoUser) == false) goto L73;
        TodoUser r131 = (TodoUser) r130;
    L74:
        this.F = r131;
        Bundle r132 = getArguments();
        if (r132 == null) goto L77;
        boolean r133 = r132.getBoolean("task_list_manage_panel_invite", false);
    L79:
        if (this.C == false) goto L84;
        if (r133 == true) goto L84;
        String r134 = TodoDependencyHolder.a().loginDependency().getUserId();
        if (this.f442598o.contains(r134) == true) goto L84;
        this.f442598o.add(r134);
    L84:
        int r135 = this.f442603t;
        if (r135 == 6) goto L93;
        if (r135 == 7) goto L93;
        if (r135 == 10) goto L93;
        if (r135 == 11) goto L93;
        if (r135 == 18) goto L93;
        boolean r136 = false;
    L94:
        this.f442606w = r136;
        if (r135 != 100) goto L97;
        boolean r137 = true;
    L98:
        if (r137 == false) goto L112;
        Bundle r138 = getArguments();
        if (r138 == null) goto L102;
        boolean r139 = r138.getBoolean("show_contact_picker_is_single", false);
    L103:
        this.f442606w = r139;
        Bundle r140 = getArguments();
        if (r140 == null) goto L106;
        Boolean r141 = Boolean.valueOf(r140.getBoolean("show_contact_picker_is_assignee", false));
    L107:
        this.f442607x = r141;
        Bundle r142 = getArguments();
        if (r142 == null) goto L110;
        boolean r143 = r142.getBoolean("show_contact_picker_support_choose_chat", false);
    L111:
        this.f442608y = r143;
        goto L112
    L110:
        r143 = false;
        goto L111
    L106:
        r141 = Boolean.FALSE;
        goto L107
    L102:
        r139 = false;
    L112:
        this.f442597n = new AssigneeRecommendAdapter(this.f442606w, new d(this));
        V90().getShowDataLv().observe(this, new com.ss.android.lark.todo.impl.features.detail.assignee.add.mvvm.a(this));
        V90().getNameFormatRuleLv().observe(this, new b(this));
        View r144 = this.f442589f;
        if (r144 != null) goto L119;
        View r145 = getView();
        if (r145 == null) goto L117;
        r144 = r145.findViewById(R.id.layout_next_step_container);
    L118:
        this.f442589f = (LinearLayout) r144;
        goto L119
    L117:
        r144 = null;
    L119:
        com.larksuite.framework.section.utils.a.d((LinearLayout) r144, this.C);
        if (this.C == false) goto L123;
        V90().getChosenMembersLv().observe(this, new g(this));
    L123:
        W90().setLeftText(CommonTitleBarConstants.TEXT_CANCEL);
        W90().setLeftImageDrawable(null);
        W90().setLeftClickListener(new i(this));
        CommonTitleBar r146 = W90();
        String r147 = this.H;
        if (r147 != null) goto L126;
    L129:
        boolean r148 = true;
    L131:
        if (r148 == true) goto L133;
        String r149 = this.H;
    L144:
        r146.setTitle(r149);
        CommonTitleBar r150 = W90();
        if (this.f442606w == false) goto L147;
    L149:
        boolean r151 = false;
    L150:
        r150.setRightVisible(r151);
        W90().addAction(new j(this, this.f442600q));
        V90().getChosenMembersLv().observe(this, new c(this));
        int r152 = this.f442603t;
        if (r152 == 7) goto L157;
        if (r152 == 6) goto L154;
    L156:
        boolean r153 = false;
    L159:
        if (r153 == false) goto L211;
        T90().setVisibility(0);
        Context r154 = getContext();
        if (r154 != null) goto L163;
    L210:
        T90().setOnClickListener(new e(this));
    L212:
        Picker r155 = X90();
        FragmentActivity r156 = requireActivity();
        Intrinsics.checkNotNull(r156, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        if (this.f442603t != 100) goto L215;
        boolean r157 = true;
    L216:
        if (r157 == false) goto L218;
        final boolean r158 = this.f442608y;
    L219:
        r155.scene(PickerStatistics.Scene.Unknown);
        ContactsSelectorBusiness r159 = new ContactsSelectorBusiness();
        AssigneeRecommendAdapter r160 = this.f442597n;
        Intrinsics.checkNotNull(r160, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.Adapter<*>");
        r155.attachCustomBusiness(r159.addFooterList(r160));
        r155.init2(ConfigKt.pickerConfig(new Dependency(r156, getChildFragmentManager()), new Permissions(CollectionsKt.emptyList()), new TodoAssigneeAddFragment$initChatterPicker$config$1(this, r158)));
        V90().getFinishLv().observe(this, new h(this));
        V90().initData(this.f442599p, this.f442598o, this.f442606w, this.f442603t, this.f442604u, this.f442607x);
        if (CollectionsKt.listOf(new Integer[]{6, 2, 7, 8}).contains(Integer.valueOf(this.f442603t)) == false) goto L237;
        a9c.b r161 = a9c.b.f2313a;
        boolean r162 = this.f442605v;
        int r163 = this.f442603t;
        if (r163 == 7) goto L224;
        if (r163 == 8) goto L224;
    L225:
        boolean r164 = this.G;
        if (r162 == false) goto L230;
        if (r106 == false) goto L229;
        s5c.a r165 = c2.f570166d;
    L235:
        r165.getClass();
        a9c.b.b(r161, "todo_task_owner_select_view", s5c.d.b.c(r165), 4);
        return;
    L229:
        r165 = c2.f570165c;
        goto L235
    L230:
        if (r106 == false) goto L232;
        r165 = c2.f570166d;
        goto L235
    L232:
        if (r164 == false) goto L234;
        r165 = c2.f570168f;
        goto L235
    L234:
        r165 = c2.f570167e;
    L224:
        r106 = true;
        goto L225
    L237:
        return;
    L218:
        r158 = this.C;
        goto L219
    L215:
        r157 = false;
        goto L216
    L163:
        if (this.A == false) goto L165;
    L188:
        View r166 = this.f442593j;
        if (r166 != null) goto L195;
        View r167 = getView();
        if (r167 == null) goto L193;
        r166 = r167.findViewById(R.id.bottom_batch_assign_button);
    L194:
        this.f442593j = (LinearLayout) r166;
        goto L195
    L193:
        r166 = null;
    L195:
        ((LinearLayout) r166).setBackgroundResource(R.color.transparent);
        View r168 = this.f442594k;
        if (r168 != null) goto L202;
        View r169 = getView();
        if (r169 == null) goto L200;
        r168 = r169.findViewById(R.id.bottom_batch_assign_icon);
    L201:
        this.f442594k = (AppCompatImageView) r168;
        goto L202
    L200:
        r168 = null;
    L202:
        ((AppCompatImageView) r168).setImageDrawable(UDIconUtils.getIconDrawable(r154, R.drawable.ud_icon_team_add_outlined, UDColorUtils.getColor(r154, R.color.icon_disable)));
        View r170 = this.f442595l;
        if (r170 != null) goto L209;
        View r171 = getView();
        if (r171 == null) goto L207;
        View r172 = r171.findViewById(R.id.bottom_batch_assign_text);
    L208:
        this.f442595l = (TextView) r172;
        r170 = r172;
        goto L209
    L207:
        r172 = null;
    L209:
        ((TextView) r170).setTextColor(com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.text_disabled));
        goto L210
    L165:
        if (this.B == true) goto L188;
        View r173 = this.f442593j;
        if (r173 != null) goto L173;
        View r174 = getView();
        if (r174 == null) goto L171;
        r173 = r174.findViewById(R.id.bottom_batch_assign_button);
    L172:
        this.f442593j = (LinearLayout) r173;
        goto L173
    L171:
        r173 = null;
    L173:
        ((LinearLayout) r173).setBackgroundResource(R.drawable.item_bg_selector_c11);
        View r175 = this.f442594k;
        if (r175 != null) goto L180;
        View r176 = getView();
        if (r176 == null) goto L178;
        r175 = r176.findViewById(R.id.bottom_batch_assign_icon);
    L179:
        this.f442594k = (AppCompatImageView) r175;
        goto L180
    L178:
        r175 = null;
    L180:
        com.ss.android.lark.todo.impl.utils.i r177 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        ((AppCompatImageView) r175).setImageDrawable(UDIconUtils.getIconDrawable(r154, R.drawable.ud_icon_team_add_outlined, r177.a(R.color.text_link_normal)));
        View r178 = this.f442595l;
        if (r178 != null) goto L187;
        View r179 = getView();
        if (r179 == null) goto L185;
        View r180 = r179.findViewById(R.id.bottom_batch_assign_text);
    L186:
        this.f442595l = (TextView) r180;
        r178 = r180;
        goto L187
    L185:
        r180 = null;
    L187:
        ((TextView) r178).setTextColor(r177.a(R.color.text_link_normal));
        goto L210
    L211:
        T90().setVisibility(8);
        goto L212
    L154:
        if (this.f442609z == false) goto L156;
    L157:
        r153 = true;
        goto L159
    L147:
        if (this.C == true) goto L149;
        r151 = true;
        goto L150
    L133:
        int r181 = this.f442603t;
        if (r181 != 3) goto L136;
        int r182 = R.string.Todo_AddFollower_Button;
    L143:
        r149 = UIHelper.getString(r182);
        goto L144
    L136:
        if (r181 == 16) goto L141;
        if (r181 == 10) goto L140;
        if (r181 == 11) goto L140;
        r182 = R.string.Todo_TaskDetails_AddAnOwner_Button;
    L140:
        r182 = R.string.Todo_Task_ProbabilityAtPersonHint;
        goto L143
    L141:
        r182 = R.string.Todo_ShareList_InviteCollaborators_Title;
        goto L143
    L126:
        if (r147.length() == 0) goto L129;
        r148 = false;
        goto L131
    L97:
        r137 = false;
    L93:
        r136 = true;
        goto L94
    L77:
        r133 = false;
        goto L79
    L73:
        r131 = null;
        goto L74
    L69:
        r130 = null;
    L65:
        r128 = "";
        goto L66
    L60:
        r126 = false;
        goto L61
    L56:
        r124 = 0;
        goto L57
    L52:
        r122 = false;
        goto L53
    L48:
        r120 = false;
        goto L49
    L44:
        r118 = false;
        goto L45
    L40:
        r116 = false;
        goto L41
    L36:
        r114 = null;
        goto L37
    L32:
        r112 = 2;
        goto L33
    L28:
        r110 = null;
        goto L29
    L24:
        r109 = null;
        goto L26
    L20:
        r107 = false;
        goto L21
    L13:
        r104 = null;
        goto L14
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r100 == 16) goto L5;
        return;
    L5:
        if (r101 != (-1)) goto L19;
        boolean r103 = false;
        if (r102 != null) goto L9;
    L11:
        if (r103 == false) goto L20;
        Bundle r104 = new Bundle();
        if (r102 == null) goto L15;
        Serializable r105 = r102.getSerializableExtra("task_list_collaborator_members");
    L16:
        r104.putSerializable("task_list_collaborator_members", r105);
        zab.a.b(this, -1, r104);
        return;
    L15:
        r105 = null;
        goto L16
    L20:
        return;
    L9:
        if (r102.getBooleanExtra("task_list_invite_finish", false) != true) goto L11;
        r103 = true;
        goto L11
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.todo_assignee_add_fragment, r101, false);
    }
}
