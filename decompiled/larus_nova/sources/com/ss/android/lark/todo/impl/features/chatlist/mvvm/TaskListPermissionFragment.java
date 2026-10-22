package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberRole;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.utils.TodoImServices;
import com.ss.android.lark.utils.q0;
import com.suite.lark.emm.design.edittext.SCEditText;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00100\u001a\u00020\u001aH\u0002J\u0010\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u001aH\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u00066"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TaskListPermissionFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "sendBtnFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getSendBtnFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setSendBtnFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "noteTextFromXml", "Lcom/suite/lark/emm/design/edittext/SCEditText;", "getNoteTextFromXml", "()Lcom/suite/lark/emm/design/edittext/SCEditText;", "setNoteTextFromXml", "(Lcom/suite/lark/emm/design/edittext/SCEditText;)V", "permissionFormerTxtFromXml", "Landroid/widget/TextView;", "getPermissionFormerTxtFromXml", "()Landroid/widget/TextView;", "setPermissionFormerTxtFromXml", "(Landroid/widget/TextView;)V", "descriptionTxtFromXml", "getDescriptionTxtFromXml", "setDescriptionTxtFromXml", "clearFromXmlViewCache", "", "onDestroyView", "taskListId", "", "owner", "Lcom/bytedance/lark/pb/todo/v1/TodoUser;", "viewModel", "Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TaskListPermissionViewModel;", "getViewModel", "()Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TaskListPermissionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initObserver", "initPermissionView", "role", "Lcom/bytedance/lark/pb/todo/v1/TodoItemMemberRole;", "initDescriptionView", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskListPermissionFragment extends BaseFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f442310k = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UDButton f442311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SCEditText f442312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f442313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f442314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f442315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TodoUser f442316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f442317j;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f442318a = null;

        static {
            int[] r100 = new int[TodoItemMemberRole.values().length];
            r100[TodoItemMemberRole.WRITER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f442318a = r100;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f442319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TaskListPermissionFragment f442320b;

        public c(TaskListPermissionFragment r100) {
            this.f442320b = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = this.f442319a;
            long r102 = System.currentTimeMillis();
            this.f442319a = r102;
            if ((r102 - r101) >= 500) goto L5;
            return;
        L5:
            TaskListPermissionFragment r103 = this.f442320b;
            int r104 = TaskListPermissionFragment.f442310k;
            ((TaskListPermissionViewModel) r103.f442317j.getValue()).applyContainerPermission();
            this.f442320b.T90().clearFocus();
            Context r105 = this.f442320b.getContext();
            InputMethodManager r106 = null;
            if (r105 == null) goto L8;
            Object r107 = r105.getSystemService("input_method");
        L10:
            if ((r107 instanceof InputMethodManager) == false) goto L12;
            r106 = (InputMethodManager) r107;
        L12:
            if (r106 == null) goto L15;
            r106.hideSoftInputFromWindow(this.f442320b.T90().getWindowToken(), 0);
            return;
        L15:
            return;
        L8:
            r107 = null;
            goto L10
        }
    }

    public static final class d extends q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskListPermissionFragment f442321a;

        public d(TaskListPermissionFragment r100) {
            this.f442321a = r100;
        }

        @Override // com.ss.android.lark.utils.q0, android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            TaskListPermissionFragment r101 = this.f442321a;
            int r102 = TaskListPermissionFragment.f442310k;
            TaskListPermissionViewModel r103 = (TaskListPermissionViewModel) r101.f442317j.getValue();
            if (r100 == null) goto L6;
            String r104 = r100.toString();
            if (r104 == null) goto L6;
        L7:
            r103.setNote(r104);
            return;
        L6:
            r104 = "";
            goto L7
        }
    }

    static {
    }

    public final TextView S90() {
        View r100 = this.f442314g;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.description_txt);
    L8:
        this.f442314g = (TextView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (TextView) r100;
    }

    public final SCEditText T90() {
        View r100 = this.f442312e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.note_text);
    L8:
        this.f442312e = (SCEditText) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (SCEditText) r100;
    }

    public final TextView U90() {
        View r100 = this.f442313f;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.permission_former_txt);
    L8:
        this.f442313f = (TextView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (TextView) r100;
    }

    public TaskListPermissionFragment() {
        this.f442317j = LazyKt.lazy(new TaskListPermissionFragment$viewModel$2(this));
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f442311d = null;
        this.f442312e = null;
        this.f442313f = null;
        this.f442314g = null;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        String r112 = TodoDependencyHolder.a().loginDependency().getUserId();
        Chatter r113 = TodoImServices.a().ue(r112);
        if (r113 == null) goto L11;
        TodoUser r100 = this.f442316i;
        if (r100 == null) goto L11;
        String r101 = r100.user_id;
        SpannableStringBuilder r102 = new SpannableStringBuilder();
        com.ss.android.lark.todo.impl.utils.i r103 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        HashMap r104 = new HashMap();
        r104.put("user", r112);
        r104.put("Owner", r101);
        Unit r105 = Unit.INSTANCE;
        r102.append(com.ss.android.lark.todo.impl.utils.i.e(R.string.Todo_List_NoPermission_EmptyDesc, r104));
        int r106 = StringsKt.indexOf$default(r102, r112, 0, false, 6, null);
        String r114 = r113.getLocalizedName();
        r102.replace(r106, r112.length() + r106, r114);
        r102.setSpan(new ForegroundColorSpan(r103.a(R.color.text_title)), r106, r114.length() + r106, 33);
        Intrinsics.checkNotNull(r101);
        int r115 = StringsKt.indexOf$default(r102, r101, 0, false, 6, null);
        TodoUser r116 = this.f442316i;
        if (r116 == null) goto L21;
        String r117 = r116.name;
        r102.replace(r115, r101.length() + r115, r117);
        r102.setSpan(new h8c.d(r101, R.color.primary_fill_default), r115, r117.length() + r115, 33);
        S90().setText(r102);
        S90().setMovementMethod(LinkMovementMethod.getInstance());
        S90().setHighlightColor(r103.a(R.color.transparent));
        goto L11
    L21:
        throw new IllegalArgumentException("Required value was null.".toString());
    L11:
        ((TaskListPermissionViewModel) this.f442317j.getValue()).getRole().observe(getViewLifecycleOwner(), new q(this));
        View r118 = this.f442311d;
        if (r118 != null) goto L18;
        View r119 = getView();
        if (r119 == null) goto L16;
        r118 = r119.findViewById(R.id.send_btn);
    L17:
        this.f442311d = (UDButton) r118;
        goto L18
    L16:
        r118 = null;
    L18:
        ((UDButton) r118).setOnClickListener(new c(this));
        T90().addTextChangedListener(new d(this));
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Bundle r103 = getArguments();
        String r104 = "";
        if (r103 == null) goto L8;
        String r105 = r103.getString("task_list_no_permission_container_id", "");
        if (r105 == null) goto L8;
        r104 = r105;
    L8:
        this.f442315h = r104;
        Bundle r106 = getArguments();
        if (r106 == null) goto L11;
        Serializable r107 = r106.getSerializable("task_list_no_permission_owner_id");
    L13:
        if ((r107 instanceof TodoUser) == false) goto L15;
        TodoUser r108 = (TodoUser) r107;
    L16:
        this.f442316i = r108;
        return r100.inflate(R.layout.task_list_permission_fragment, null, false);
    L15:
        r108 = null;
        goto L16
    L11:
        r107 = null;
        goto L13
    }
}
