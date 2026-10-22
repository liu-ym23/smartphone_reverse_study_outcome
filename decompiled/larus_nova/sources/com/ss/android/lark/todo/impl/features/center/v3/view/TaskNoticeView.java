package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import com.bytedance.lark.pb.basic.v1.RichText;
import com.bytedance.lark.pb.todo.v1.TodoLaunchScreen;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView;
import com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel;
import com.ss.android.lark.todo.impl.features.center.v3.viewmodel.TaskNoticeViewModel;
import com.ss.android.lark.todo.impl.features.common.helper.LanguageHelper;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0014\u0010\u0016\u001a\u00020\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskNoticeView;", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/ISubView;", "view", "Landroid/view/View;", "viewLifecycle", "Landroidx/lifecycle/Lifecycle;", "viewModel", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "Lcom/ss/android/lark/todo/impl/features/center/v3/viewstate/TaskNoticeState;", "Lcom/ss/android/lark/todo/impl/features/center/v3/action/TaskNoticeViewAction;", "<init>", "(Landroid/view/View;Landroidx/lifecycle/Lifecycle;Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;)V", "getView", "()Landroid/view/View;", "getViewLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getViewModel", "()Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "initViewAction", "", "initViewObserver", "initViewState", "displayNoticeBanner", "todoLaunchScreen", "Lcom/bytedance/lark/pb/todo/v1/TodoLaunchScreen;", "handleNoticeAction", "action", "Lcom/bytedance/lark/pb/todo/v1/CustomComplete;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskNoticeView implements ISubView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f441976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lifecycle f441977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SubViewModel<t7c.e, m7c.k> f441978c;

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView
    public final void MD() {
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView
    public final void S10() {
    }

    @Override // com.larksuite.arch.jack.i
    public final LifecycleOwner getLifecycleOwner() {
        return this;
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.i getLifecycleOwnerHolder() {
        return this;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView
    public final void oM() {
        com.larksuite.arch.jack.f.a.e(this, this.f441978c, TaskNoticeView$initViewState$1.INSTANCE, new TaskNoticeView$initViewState$2(this));
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return b();
    }

    public final Lifecycle b() {
        return this.f441977b;
    }

    public static final void a(TaskNoticeView r100, TodoLaunchScreen r101) {
        if (r101 == null) goto L28;
        r100.getClass();
        if (r101.status != TodoLaunchScreen.TodoLaunchStatus.Enable) goto L27;
        ((UDNotice) r100.f441976a.findViewById(R.id.todo_notice_view)).setVisibility(0);
        Lazy r102 = LanguageHelper.f442435a;
        Map<String, RichText> r103 = r101.i18n_rich_texts;
        Intrinsics.checkNotNullParameter(r103, "map");
        Object r104 = LanguageHelper.c(r103);
        if (r104 == null) goto L10;
    L20:
        RichText r105 = (RichText) r104;
        if (r105 != null) goto L23;
        ((UDNotice) r100.f441976a.findViewById(R.id.todo_notice_view)).setVisibility(8);
        return;
    L23:
        ((UDNotice) r100.f441976a.findViewById(R.id.todo_notice_view)).setText(com.ss.android.lark.widget.richtext.i.g(j8c.c.a(r105), true));
        ((UDNotice) r100.f441976a.findViewById(R.id.todo_notice_view)).i6(r101.enable_exit.booleanValue());
        ((UDNotice) r100.f441976a.findViewById(R.id.todo_notice_view)).setIconButtonListener(new a1(r100, r101));
        ((UDNotice) r100.f441976a.findViewById(R.id.todo_notice_view)).k6(r101.enable_button.booleanValue());
        if (r101.enable_button.booleanValue() == false) goto L26;
        ((UDNotice) r100.f441976a.findViewById(R.id.todo_notice_view)).setTextButtonPosition(UDNotice.TextButtonPosition.AUTO);
        ((UDNotice) r100.f441976a.findViewById(R.id.todo_notice_view)).setTextButton(LanguageHelper.b(r101.button_i18n_texts));
    L26:
        ((UDNotice) r100.f441976a.findViewById(R.id.todo_notice_view)).setTextButtonListener(new b1(r100, r101));
        return;
    L10:
        if ((!r103.isEmpty()) == false) goto L12;
        String r106 = (String) ListProtector.get(new ArrayList(r103.keySet()), 0);
    L14:
        if (r103.get("en_us") != null) goto L16;
        RichText r107 = r103.get(r106);
    L17:
        if (r107 != null) goto L19;
        r107 = null;
    L19:
        r104 = r107;
        goto L20
    L16:
        r107 = r103.get("en_us");
        goto L17
    L12:
        r106 = "en_us";
        goto L14
    L27:
        ((UDNotice) r100.f441976a.findViewById(R.id.todo_notice_view)).setVisibility(8);
        return;
    L28:
        ((UDNotice) r100.f441976a.findViewById(R.id.todo_notice_view)).setVisibility(8);
    }

    public TaskNoticeView(View r100, Lifecycle r101, TaskNoticeViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "viewLifecycle");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        this.f441976a = r100;
        this.f441977b = r101;
        this.f441978c = r102;
    }

    @Override // com.larksuite.arch.jack.f
    public final <S extends com.larksuite.arch.jack.j> com.larksuite.arch.jack.c nH(JackViewModel<S> r100, com.larksuite.arch.jack.l<S> r101, Function1<? super S, Unit> r102) {
        return ISubView.a.e(this, r100, r101, r102);
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c Ik(JackViewModel r100, PropertyReference1Impl r101, com.larksuite.arch.jack.l r102, Function1 r103) {
        return ISubView.a.b(this, r100, r101, r102, r103);
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c Ki(JackViewModel r100, PropertyReference1Impl r101, PropertyReference1Impl r102, com.larksuite.arch.jack.l r103, Function1 r104) {
        return ISubView.a.c(this, r100, r101, r102, r103, r104);
    }

    @Override // com.larksuite.arch.jack.f
    public final com.larksuite.arch.jack.c O60(FilePickerViewModel r100, PropertyReference1Impl r101, PropertyReference1Impl r102, PropertyReference1Impl r103, com.larksuite.arch.jack.l r104, Function1 r105) {
        return ISubView.a.d(this, r100, r101, r102, r103, r104, r105);
    }
}
