package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberRole;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.chatlist.adapter.TaskListMembersAdapter;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import com.suite.lark.emm.design.edittext.SCEditText;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 k2\u00020\u0001:\u0001kB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020DH\u0016J&\u0010U\u001a\u0004\u0018\u0001082\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\u001a\u0010\\\u001a\u00020D2\u0006\u0010]\u001a\u0002082\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\b\u0010^\u001a\u00020DH\u0002J\b\u0010_\u001a\u00020DH\u0002J\b\u0010`\u001a\u00020DH\u0002J\b\u0010a\u001a\u00020DH\u0002J\b\u0010b\u001a\u00020DH\u0002J\b\u0010c\u001a\u00020DH\u0002J\b\u0010d\u001a\u00020DH\u0002J\"\u0010e\u001a\u00020D2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020g2\b\u0010i\u001a\u0004\u0018\u00010jH\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001e\u0010\u001f\u001a\u0004\u0018\u00010 8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001e\u0010(\u001a\u0004\u0018\u00010)8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u0010\u0015R\u001e\u00101\u001a\u0004\u0018\u0001028FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u0004\u0018\u0001088FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001e\u0010=\u001a\u0004\u0018\u00010>8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001b\u0010F\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bH\u0010IR\u000e\u0010L\u001a\u00020MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020QX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020TX\u0082.¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TaskListMembersFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "noteTextFromXml", "Lcom/suite/lark/emm/design/edittext/SCEditText;", "getNoteTextFromXml", "()Lcom/suite/lark/emm/design/edittext/SCEditText;", "setNoteTextFromXml", "(Lcom/suite/lark/emm/design/edittext/SCEditText;)V", "todoRefactorPtrLayoutFromXml", "Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;", "getTodoRefactorPtrLayoutFromXml", "()Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;", "setTodoRefactorPtrLayoutFromXml", "(Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;)V", "todoLottieLoadingContainerFromXml", "Landroid/widget/LinearLayout;", "getTodoLottieLoadingContainerFromXml", "()Landroid/widget/LinearLayout;", "setTodoLottieLoadingContainerFromXml", "(Landroid/widget/LinearLayout;)V", "todoLottieLoadingAnimFromXml", "Lcom/airbnb/lottie/LottieAnimationView;", "getTodoLottieLoadingAnimFromXml", "()Lcom/airbnb/lottie/LottieAnimationView;", "setTodoLottieLoadingAnimFromXml", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "todoLoadingErrorLlFromXml", "getTodoLoadingErrorLlFromXml", "setTodoLoadingErrorLlFromXml", "titleBarFromXml", "Lcom/ss/android/lark/ui/CommonTitleBar;", "getTitleBarFromXml", "()Lcom/ss/android/lark/ui/CommonTitleBar;", "setTitleBarFromXml", "(Lcom/ss/android/lark/ui/CommonTitleBar;)V", "inviteContainerFromXml", "getInviteContainerFromXml", "setInviteContainerFromXml", "noteCheckboxFromXml", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getNoteCheckboxFromXml", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "setNoteCheckboxFromXml", "(Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;)V", "sendContainerFromXml", "getSendContainerFromXml", "setSendContainerFromXml", "inviteButtonFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getInviteButtonFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setInviteButtonFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "maskFromXml", "Landroid/view/View;", "getMaskFromXml", "()Landroid/view/View;", "setMaskFromXml", "(Landroid/view/View;)V", "taskListMembersFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getTaskListMembersFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setTaskListMembersFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TaskListMembersViewModel;", "getViewModel", "()Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TaskListMembersViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isInvite", "", "operatorRole", "Lcom/bytedance/lark/pb/todo/v1/TodoItemMemberRole;", "operatorId", "", "taskListId", "adapter", "Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TaskListMembersAdapter;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initObserver", "startLoading", "initView", "initTitleBarView", "initLoadMoreView", "initInviteView", "initRecyclerView", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TaskListMembersFragment extends BaseFragment {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f442289v = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SCEditText f442290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LKUIPtrClassicFrameLayout f442291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f442292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LottieAnimationView f442293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f442294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CommonTitleBar f442295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f442296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public UDCheckBox f442297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f442298l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public UDButton f442299m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f442300n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RecyclerView f442301o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f442302p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f442303q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TodoItemMemberRole f442304r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f442305s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f442306t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TaskListMembersAdapter f442307u;

    public static final class a {
    }

    static {
    }

    public final SCEditText S90() {
        View r100 = this.f442290d;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.note_text);
    L8:
        this.f442290d = (SCEditText) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (SCEditText) r100;
    }

    public final CommonTitleBar T90() {
        View r100 = this.f442295i;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.title_bar);
    L8:
        this.f442295i = (CommonTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (CommonTitleBar) r100;
    }

    public final LinearLayout U90() {
        View r100 = this.f442294h;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.todo_loading_error_ll);
    L8:
        this.f442294h = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    public final LottieAnimationView V90() {
        View r100 = this.f442293g;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.todo_lottie_loading_anim);
    L8:
        this.f442293g = (LottieAnimationView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LottieAnimationView) r100;
    }

    public final LinearLayout W90() {
        View r100 = this.f442292f;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.todo_lottie_loading_container);
    L8:
        this.f442292f = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    public final LKUIPtrClassicFrameLayout X90() {
        View r100 = this.f442291e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.todo_refactor_ptr_layout);
    L8:
        this.f442291e = (LKUIPtrClassicFrameLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LKUIPtrClassicFrameLayout) r100;
    }

    public final TaskListMembersViewModel Y90() {
        return (TaskListMembersViewModel) this.f442302p.getValue();
    }

    public TaskListMembersFragment() {
        this.f442302p = LazyKt.lazy(new TaskListMembersFragment$viewModel$2(this));
        this.f442304r = TodoItemMemberRole.NONE;
        this.f442305s = TodoDependencyHolder.a().loginDependency().getUserId();
        this.f442306t = "";
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f442290d = null;
        this.f442291e = null;
        this.f442292f = null;
        this.f442293g = null;
        this.f442294h = null;
        this.f442295i = null;
        this.f442296j = null;
        this.f442297k = null;
        this.f442298l = null;
        this.f442299m = null;
        this.f442300n = null;
        this.f442301o = null;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Bundle r102 = getArguments();
        boolean r103 = false;
        if (r102 == null) goto L5;
        boolean r104 = r102.getBoolean("task_list_members_is_invite", false);
    L6:
        this.f442303q = r104;
        Bundle r105 = getArguments();
        if (r105 == null) goto L9;
        int r106 = r105.getInt("task_list_operator_role_type", 0);
    L10:
        TodoItemMemberRole r107 = TodoItemMemberRole.fromValue(r106);
        if (r107 != null) goto L13;
        r107 = TodoItemMemberRole.NONE;
    L13:
        this.f442304r = r107;
        Bundle r108 = getArguments();
        if (r108 == null) goto L17;
        String r109 = r108.getString("task_list_members_container_id");
        if (r109 == null) goto L17;
    L18:
        this.f442306t = r109;
        TaskListMembersAdapter r110 = new TaskListMembersAdapter(this.f442304r, this.f442303q);
        this.f442307u = r110;
        r110.f442189d = new p(this);
        LinearLayoutManager r111 = new LinearLayoutManager(getContext());
        r111.setOrientation(1);
        View r112 = this.f442301o;
        View r113 = null;
        if (r112 != null) goto L25;
        View r114 = getView();
        if (r114 == null) goto L23;
        r112 = r114.findViewById(R.id.task_list_members);
    L24:
        this.f442301o = (RecyclerView) r112;
        goto L25
    L23:
        r112 = null;
    L25:
        ((RecyclerView) r112).setLayoutManager(r111);
        View r115 = this.f442301o;
        if (r115 != null) goto L32;
        View r116 = getView();
        if (r116 == null) goto L30;
        r115 = r116.findViewById(R.id.task_list_members);
    L31:
        this.f442301o = (RecyclerView) r115;
        goto L32
    L30:
        r115 = null;
    L32:
        RecyclerView r117 = (RecyclerView) r115;
        TaskListMembersAdapter r118 = this.f442307u;
        if (r118 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r118 = null;
    L35:
        r117.setAdapter(r118);
        View r119 = this.f442296j;
        if (r119 != null) goto L42;
        View r120 = getView();
        if (r120 == null) goto L40;
        r119 = r120.findViewById(R.id.invite_container);
    L41:
        this.f442296j = (LinearLayout) r119;
        goto L42
    L40:
        r119 = null;
    L42:
        com.larksuite.framework.section.utils.a.d((LinearLayout) r119, this.f442303q);
        if (this.f442303q == false) goto L52;
        TaskListMembersViewModel r121 = Y90();
        View r122 = this.f442297k;
        if (r122 != null) goto L51;
        View r123 = getView();
        if (r123 == null) goto L49;
        r122 = r123.findViewById(R.id.note_checkbox);
    L50:
        this.f442297k = (UDCheckBox) r122;
        goto L51
    L49:
        r122 = null;
    L51:
        r121.setSendNote(((UDCheckBox) r122).isChecked());
    L52:
        View r124 = this.f442297k;
        if (r124 != null) goto L59;
        View r125 = getView();
        if (r125 == null) goto L57;
        r124 = r125.findViewById(R.id.note_checkbox);
    L58:
        this.f442297k = (UDCheckBox) r124;
        goto L59
    L57:
        r124 = null;
    L59:
        ((UDCheckBox) r124).setOnCheckedChangeListener(new e(this));
        S90().addTextChangedListener(new f(this));
        View r126 = this.f442299m;
        if (r126 != null) goto L66;
        View r127 = getView();
        if (r127 == null) goto L64;
        r126 = r127.findViewById(R.id.invite_button);
    L65:
        this.f442299m = (UDButton) r126;
        goto L66
    L64:
        r126 = null;
    L66:
        ((UDButton) r126).setOnClickListener(new d(this));
        View r128 = this.f442300n;
        if (r128 != null) goto L72;
        View r129 = getView();
        if (r129 == null) goto L71;
        r113 = r129.findViewById(R.id.mask);
    L71:
        this.f442300n = r113;
        r128 = r113;
    L72:
        r128.setOnTouchListener(new g(this));
        if (this.f442303q == false) goto L81;
        Context r130 = getContext();
        if (r130 != null) goto L77;
    L79:
        if (r103 == false) goto L81;
        KeyboardUtils.showKeyboard(S90());
        goto L81
    L77:
        if (ForsetiConfig.a(r130) == true) goto L79;
        r103 = true;
    L81:
        ChatWindowPtrLoadingHeader r131 = new ChatWindowPtrLoadingHeader(getContext());
        X90().setFooterView(r131);
        X90().addPtrUIHandler(r131);
        X90().setMode(LKUIPtrFrameLayout.Mode.NONE);
        X90().setPtrHandler(new i(this));
        U90().setOnClickListener(new h(this));
        if (this.f442303q == false) goto L84;
        T90().setTitle(R.string.Todo_ShareList_InviteCollaborators_Title);
    L85:
        T90().setLeftClickListener(new n(this));
        if (this.f442303q == true) goto L88;
        T90().addAction(new o(this));
    L88:
        Y90().getMembers().observe(this, new j(this));
        Y90().getHasMore().observe(this, new k(this));
        Y90().getLoadingStatus().observe(this, new l(this));
        Y90().getFinish().observe(this, new m(this));
        return;
    L84:
        T90().setTitle(R.string.Todo_ListCard_Collaborators_Text);
    L17:
        r109 = "";
        goto L18
    L9:
        r106 = 0;
        goto L10
    L5:
        r104 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r100 == 16) goto L5;
        return;
    L5:
        if (r101 == (-1)) goto L7;
        return;
    L7:
        if (this.f442303q == true) goto L12;
        KeyboardUtils.hideKeyboard(S90().getContext());
        zab.a.a(this);
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.task_list_members_activity, r101, false);
    }
}
