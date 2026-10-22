package com.ss.android.lark.todo.impl.features.tasklist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.component.universe_design.edittext.UDTextInputLayout;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.IActionTitlebar$TextAction;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.dialog.CommonLoadingDialog;
import com.suite.lark.emm.design.edittext.SCUDEditText;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020 H\u0002J\b\u0010+\u001a\u00020 H\u0002J\b\u0010,\u001a\u00020\u0017H\u0002J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u001a\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020.2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00107\u001a\u00020\u0017H\u0002J\b\u00108\u001a\u00020\u0017H\u0002J\b\u00109\u001a\u00020\u0017H\u0002J\u0010\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020 H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b&\u0010'¨\u0006="}, d2 = {"Lcom/ss/android/lark/todo/impl/features/tasklist/TaskListNameFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "titleBarFromXml", "Lcom/ss/android/lark/ui/CommonTitleBar;", "getTitleBarFromXml", "()Lcom/ss/android/lark/ui/CommonTitleBar;", "setTitleBarFromXml", "(Lcom/ss/android/lark/ui/CommonTitleBar;)V", "edittextTaskListNameFromXml", "Lcom/suite/lark/emm/design/edittext/SCUDEditText;", "getEdittextTaskListNameFromXml", "()Lcom/suite/lark/emm/design/edittext/SCUDEditText;", "setEdittextTaskListNameFromXml", "(Lcom/suite/lark/emm/design/edittext/SCUDEditText;)V", "layoutTaskListNameFromXml", "Lcom/larksuite/component/universe_design/edittext/UDTextInputLayout;", "getLayoutTaskListNameFromXml", "()Lcom/larksuite/component/universe_design/edittext/UDTextInputLayout;", "setLayoutTaskListNameFromXml", "(Lcom/larksuite/component/universe_design/edittext/UDTextInputLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/ss/android/lark/todo/impl/features/tasklist/TaskListNameViewModel;", "getViewModel", "()Lcom/ss/android/lark/todo/impl/features/tasklist/TaskListNameViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "enableTitleAction", "", "loadingDialog", "Lcom/ss/android/lark/widget/dialog/CommonLoadingDialog;", "isInLoadingDialog", "titleAction", "Lcom/ss/android/lark/ui/IActionTitlebar$TextAction;", "getTitleAction", "()Lcom/ss/android/lark/ui/IActionTitlebar$TextAction;", "titleAction$delegate", "showTitleAction", "enableAction", "isRenameMode", "handleTitleAction", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initObserver", "initViewModel", "initView", "showMaxLimitWarning", "warning", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TaskListNameFragment extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommonTitleBar f444007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SCUDEditText f444008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UDTextInputLayout f444009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f444010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f444011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CommonLoadingDialog f444012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f444013j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f444014k;

    public static final class a {
    }

    static {
    }

    public final SCUDEditText T90() {
        View r100 = this.f444008e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.edittext_task_list_name);
    L8:
        this.f444008e = (SCUDEditText) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (SCUDEditText) r100;
    }

    public final CommonTitleBar U90() {
        View r100 = this.f444007d;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.title_bar);
    L8:
        this.f444007d = (CommonTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (CommonTitleBar) r100;
    }

    public final TaskListNameViewModel V90() {
        return (TaskListNameViewModel) this.f444010g.getValue();
    }

    public TaskListNameFragment() {
        final Function0<Fragment> r100 = new TaskListNameFragment$special$$inlined$viewModels$default$1(this);
        this.f444010g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TaskListNameViewModel.class), new TaskListNameFragment$special$$inlined$viewModels$default$2(r100), new TaskListNameFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f444012i = new CommonLoadingDialog();
        this.f444014k = LazyKt.lazy(new TaskListNameFragment$titleAction$2(this));
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f444007d = null;
        this.f444008e = null;
        this.f444009f = null;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        CommonTitleBar r102 = U90();
        r102.setLeftImageDrawable(null);
        r102.setLeftText(R.string.Todo_CreateNewListCancel_Button);
        r102.setLeftClickListener(new g(r102, this));
        r102.addAction((IActionTitlebar$TextAction) this.f444014k.getValue());
        T90().addTextChangedListener(new h(this));
        V90().isRenameModeLv().observe(this, new com.ss.android.lark.todo.impl.features.tasklist.a(this));
        V90().getTaskListNameLv().observe(this, new c(this));
        V90().getSuccessToastLv().observe(this, new d(this));
        V90().getErrorToastLv().observe(this, new e(this));
        V90().getFinishActivityLv().observe(this, new f(this));
        V90().initData(getArguments());
    }

    public static final void S90(TaskListNameFragment r100, boolean r101, boolean r102) {
        CommonTitleBar r103 = r100.U90();
        if (r102 == false) goto L5;
        int r104 = R.string.Todo_TaskListRenameSave_Button;
    L6:
        String r105 = UIHelper.getString(r104);
        if (r101 == false) goto L9;
        int r106 = R.color.primary_fill_default;
    L10:
        r103.setRightText(0, r105, UIHelper.getColor(r106));
        return;
    L9:
        r106 = R.color.text_disable;
        goto L10
    L5:
        r104 = R.string.Todo_CreateNewListCreate_Button;
        goto L6
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.task_list_create_activity, r101, false);
    }
}
