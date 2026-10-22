package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView;
import com.ss.android.lark.todo.impl.features.center.v3.arch.SubViewModel;
import com.ss.android.lark.todo.impl.features.center.v3.type.TaskFieldType;
import com.ss.android.lark.todo.impl.features.center.v3.viewmodel.FilterSectionViewModel;
import com.ss.android.lark.todo.impl.features.detail.widget.KeyboardScrollView;
import com.ss.android.lark.utils.UIHelper;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 F2\u00020\u0001:\u0001FB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0002J\u001e\u0010#\u001a\u00020\u001c2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020&H\u0002J<\u0010(\u001a\u00020\u001c2\"\u0010)\u001a\u001e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00180*j\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0018`+2\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0018H\u0002J\b\u0010.\u001a\u00020\u001cH\u0002J\u0010\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u000205H\u0002J\u0018\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0002J\b\u00109\u001a\u00020\u001cH\u0002J\b\u0010:\u001a\u00020\u001cH\u0002J\u0010\u0010;\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0002J\u001e\u0010<\u001a\u00020\u00032\f\u0010=\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010>\u001a\u00020&H\u0002J,\u0010?\u001a\u00020\u00032\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00180*2\u0006\u0010>\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0018H\u0002J\u0018\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\r\"\u0004\b1\u00102R\u0014\u0010D\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u000f¨\u0006G"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/FilterSectionView;", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/ISubView;", "contentView", "Landroid/view/View;", "viewLifecycle", "Landroidx/lifecycle/Lifecycle;", "viewModel", "Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "Lcom/ss/android/lark/todo/impl/features/center/v3/viewstate/FilterSectionViewState;", "Lcom/ss/android/lark/todo/impl/features/center/v3/action/FilterSectionViewAction;", "<init>", "(Landroid/view/View;Landroidx/lifecycle/Lifecycle;Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;)V", "getContentView", "()Landroid/view/View;", "getViewLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getViewModel", "()Lcom/ss/android/lark/todo/impl/features/center/v3/arch/SubViewModel;", "iconDownDrawable", "Landroid/graphics/drawable/Drawable;", "iconUpDrawable", "mPopupWindow", "Landroid/widget/PopupWindow;", "isShowStatusPopupWindow", "", "isShowGroupFieldWindow", "isShowSortFieldWindow", "initView", "", "initViewAction", "initViewObserver", "initViewState", "setCompleteStatusClickListener", "selectStatus", "Lcom/bytedance/lark/pb/todo/v1/TaskCompleteStatusFieldFilterValue$TaskCompleteStatus;", "setGroupSectionClickListener", "groupFields", "", "Lcom/ss/android/lark/todo/impl/features/center/v3/type/TaskFieldType;", "selectGroup", "setSortFilterClickListener", "sortMap", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "selectSort", "selectSortIsAsc", "dismissPopupWindow", "currentPopupView", "getCurrentPopupView", "setCurrentPopupView", "(Landroid/view/View;)V", "setTransition", "view", "Landroid/view/ViewGroup;", "showPopupWindow", "fromView", "popupView", "doAfterPopupDismiss", "revertFilterSection", "getCompleteStatusPopupWindowView", "getGroupFiltersPopupWindowView", SlcCommonAction.KEY_PARAMS, "selectField", "getSortFiltersPopupWindowView", "fieldMap", "setItemViewSortIcon", "itemView", "isAsc", NewBroadcastMonitor.STAGE.LIFECYCLE, "getLifecycle", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterSectionView implements ISubView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f441838k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f441839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lifecycle f441840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SubViewModel<t7c.c, m7c.d> f441841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f441842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Drawable f441843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PopupWindow f441844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f441845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f441846h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f441847i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f441848j;

    public static final class a {
    }

    public static final class b implements KeyboardScrollView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FilterSectionView f441849a;

        public b(FilterSectionView r100) {
            this.f441849a = r100;
        }

        @Override // com.ss.android.lark.todo.impl.features.detail.widget.KeyboardScrollView.a
        public final void a(KeyboardScrollView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            View r101 = this.f441849a.f441839a.findViewById(R.id.filter_shader);
            boolean r102 = false;
            if (r100.getChildAt(0).getMeasuredWidth() <= (r100.getScrollX() + r100.getWidth())) goto L5;
            r102 = true;
        L5:
            com.larksuite.framework.section.utils.a.d(r101, r102);
        }
    }

    public static final class c implements PopupWindow.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f441850a;

        public c(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f441850a = r100;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final /* synthetic */ void onDismiss() {
            this.f441850a.invoke();
        }
    }

    static {
    }

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

    public final void f() {
        TextView r100 = (TextView) this.f441839a.findViewById(R.id.complete_status_text);
        com.ss.android.lark.todo.impl.utils.i r101 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r100.setTextColor(r101.a(R.color.icon_n2));
        ((TextView) this.f441839a.findViewById(R.id.complete_status_text)).setCompoundDrawables(null, null, this.f441842d, null);
        ((TextView) this.f441839a.findViewById(R.id.group_section_text)).setTextColor(r101.a(R.color.icon_n2));
        ((TextView) this.f441839a.findViewById(R.id.group_section_text)).setCompoundDrawables(null, null, this.f441842d, null);
        ((TextView) this.f441839a.findViewById(R.id.sort_filter_text)).setTextColor(r101.a(R.color.icon_n2));
        ((TextView) this.f441839a.findViewById(R.id.sort_filter_text)).setCompoundDrawables(null, null, this.f441842d, null);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.arch.ISubView
    public final void oM() {
        com.larksuite.arch.jack.f.a.e(this, this.f441841c, FilterSectionView$initViewState$1.INSTANCE, new FilterSectionView$initViewState$2(this));
        com.larksuite.arch.jack.f.a.e(this, this.f441841c, FilterSectionView$initViewState$3.INSTANCE, new FilterSectionView$initViewState$4(this));
        com.larksuite.arch.jack.f.a.e(this, this.f441841c, FilterSectionView$initViewState$5.INSTANCE, new FilterSectionView$initViewState$6(this));
        com.larksuite.arch.jack.f.a.e(this, this.f441841c, FilterSectionView$initViewState$7.INSTANCE, new FilterSectionView$initViewState$8(this));
        com.larksuite.arch.jack.f.a.e(this, this.f441841c, FilterSectionView$initViewState$9.INSTANCE, new FilterSectionView$initViewState$10(this));
        com.larksuite.arch.jack.f.a.e(this, this.f441841c, FilterSectionView$initViewState$11.INSTANCE, new FilterSectionView$initViewState$12(this));
        com.larksuite.arch.jack.f.a.e(this, this.f441841c, FilterSectionView$initViewState$13.INSTANCE, new FilterSectionView$initViewState$14(this));
    }

    public final void e() {
        ISubView.a.a(this);
        ((TextView) this.f441839a.findViewById(R.id.complete_status_text)).setCompoundDrawablePadding(y9c.d.b(this.f441839a.getContext(), 5.0f));
        ((TextView) this.f441839a.findViewById(R.id.group_section_text)).setCompoundDrawablePadding(y9c.d.b(this.f441839a.getContext(), 5.0f));
        ((TextView) this.f441839a.findViewById(R.id.sort_filter_text)).setCompoundDrawablePadding(y9c.d.b(this.f441839a.getContext(), 5.0f));
        ((KeyboardScrollView) this.f441839a.findViewById(R.id.filter_item_container)).setOnScrollChangeListener(new b(this));
        f();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f441840b;
    }

    public static final void a(FilterSectionView r100) {
        View r101 = r100.f441848j;
        LinearLayout r102 = null;
        if (r101 == null) goto L5;
        LinearLayout r103 = (LinearLayout) r101.findViewById(R.id.task_options_container);
    L6:
        if (r103 == null) goto L8;
        com.larksuite.framework.section.utils.a.d(r103, false);
    L8:
        View r104 = r100.f441848j;
        if (r104 == null) goto L11;
        r102 = (LinearLayout) r104.findViewById(R.id.task_options_container);
    L11:
        if (r102 == null) goto L14;
        r102.post(new g(r100));
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public FilterSectionView(View r100, Lifecycle r101, FilterSectionViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        Intrinsics.checkNotNullParameter(r101, "viewLifecycle");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        this.f441839a = r100;
        this.f441840b = r101;
        this.f441841c = r102;
        Context r103 = r100.getContext();
        com.ss.android.lark.todo.impl.utils.i r104 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        this.f441842d = UDIconUtils.getIconDrawable(r103, R.drawable.ud_icon_down_outlined, r104.a(R.color.icon_n2), new UDDimension.b(12));
        this.f441843e = UDIconUtils.getIconDrawable(r100.getContext(), R.drawable.ud_icon_up_outlined, r104.a(R.color.primary_fill_default), new UDDimension.b(12));
    }

    public static final void c(final FilterSectionView r100, View r101, View r102) {
        r100.f441848j = r102;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r102).setLayoutTransition(m8c.a.a(-UIHelper.dp2px(240.0f), 160));
        r102.findViewById(R.id.mask).setOnClickListener(new r(r100));
        PopupWindow r103 = new PopupWindow(r102, -1, -2, true);
        r100.f441844f = r103;
        r103.setAnimationStyle(0);
        Function0<Unit> r104 = new FilterSectionView$showPopupWindow$onDismissListener$1(r100);
        PopupWindow r105 = r100.f441844f;
        if (r105 == null) goto L5;
        r105.setOnDismissListener(new c(r104));
    L5:
        PopupWindow r106 = r100.f441844f;
        if (r106 == null) goto L8;
        r106.setOutsideTouchable(true);
    L8:
        PopupWindow r107 = r100.f441844f;
        if (r107 == null) goto L14;
        OverlaySource r108 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r107, r101, r108) == true) goto L14;
        r107.showAsDropDown(r101);
        PopupWindowLancet.trackAfterShow(r107, r108, r101);
    L14:
        r102.post(new s(r102));
    }

    @Override // com.larksuite.arch.jack.f
    public final <S extends com.larksuite.arch.jack.j> com.larksuite.arch.jack.c nH(JackViewModel<S> r100, com.larksuite.arch.jack.l<S> r101, Function1<? super S, Unit> r102) {
        return ISubView.a.e(this, r100, r101, r102);
    }

    public static final void b(FilterSectionView r100, LinkedHashMap r101, TaskFieldType r102, boolean r103) {
        ((TextView) r100.f441839a.findViewById(R.id.sort_filter_text)).setOnClickListener(new q(r100, r101, r102, r103));
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
