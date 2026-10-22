package com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.model.toolbar.insertblock.InsertNewBlock;
import com.bytedance.ee.bear.edit.component.toolbar2.a0;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.insets.WindowInsetsUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sa5.m;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 B2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001BB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010$\u001a\u00020\u001dH\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u001dH\u0014J\u0012\u0010+\u001a\u00020,2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020!H\u0002J\u0006\u00102\u001a\u00020!J\u001a\u00103\u001a\u00020\u001d2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u001bH\u0002J\u0018\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u00106\u001a\u00020\u001bH\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\u0018\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\b\u0010A\u001a\u00020&H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/insertblock/InsertNewBlockFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "Lcom/bytedance/ee/bear/edit/component/toolbar2/IDocToolbarV2Compat$ToolbarV2DialogDismissHandler;", "<init>", "()V", "dragView", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/insertblock/InsertNewBlockDragView;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "allTitle", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "viewModel", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/insertblock/InsertNewBlockViewModel;", "backPressDispatcher", "Lcom/bytedance/ee/bear/facade/common/BackPressDispatcher;", "clickData", "", "magicWindowHeight", "", "insertNewBlockRegistry", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/insertblock/InsertNewBlockRegistry;", "getInsertNewBlockRegistry", "()Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/insertblock/InsertNewBlockRegistry;", "insertNewBlockRegistry$delegate", "Lkotlin/Lazy;", "onItemClick", "Landroid/view/View$OnClickListener;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", LiveCommonConstants.REASON_ON_DEDTROY, "onBackPressed", "", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onFloatDismiss", "onCreateDialog", "Landroid/app/Dialog;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initDragView", "contentView", "getContentView", "updateView", "insertNewBlock", "Lcom/bytedance/ee/bear/document/model/toolbar/insertblock/InsertNewBlock;", "onClickListener", "generateItemView", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/insertblock/InsertNewBlockItemView;", "data", "Lcom/bytedance/ee/bear/document/model/toolbar/insertblock/InsertNewBlock$ChildData;", "generateItemLayoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "scrollView", "Landroid/widget/HorizontalScrollView;", "updateItemTint", "itemView", "shouldHandleKeyboard", "Companion", "docs-edit-toolbar-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InsertNewBlockFragment extends BaseAntiScreenshotsDialogFragment implements sa5.d, a0.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.e f226300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f226301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BaseTitleBar f226302j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public InsertNewBlockViewModel f226303k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public sa5.b f226304l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f226305m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f226306n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f226307o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final g f226308p;

    public static final class a {
    }

    public static final class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InsertNewBlockFragment f226309c;

        public b(InsertNewBlockFragment r100) {
            this.f226309c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            this.f226309c.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InsertNewBlockFragment f226310a;

        public c(InsertNewBlockFragment r100) {
            this.f226310a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            InsertNewBlock r101 = (InsertNewBlock) r100;
            if (r101 == null) goto L6;
            InsertNewBlockFragment r102 = this.f226310a;
            InsertNewBlockFragment.Z90(r102, r101, r102.f226308p);
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InsertNewBlockFragment f226311a;

        public d(InsertNewBlockFragment r100) {
            this.f226311a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f226311a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e implements ViewTreeObserver.OnDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InsertNewBlockFragment f226312a;

        public e(InsertNewBlockFragment r100) {
            this.f226312a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.e r100 = this.f226312a.f226300h;
            if (r100 == null) goto L5;
            r100.f226329a = new float[]{n.t() * 0.2f, n.t() * 0.6928f, n.t() * 0.9f};
        L5:
            com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.e r101 = this.f226312a.f226300h;
            if (r101 == null) goto L9;
            r101.a(r101.f226329a[1]);
            return;
        }
    }

    public static final class f implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InsertNewBlockFragment f226313a;

        public f(InsertNewBlockFragment r100) {
            this.f226313a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            this.f226313a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InsertNewBlockFragment f226314a;

        public g(InsertNewBlockFragment r100) {
            this.f226314a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            InsertNewBlockFragment r101 = this.f226314a;
            r101.f226305m = r100.getTag().toString();
            this.f226314a.dismissAllowingStateLoss();     // Catch: Exception -> L5
        L9:
            InsertNewBlockViewModel r102 = this.f226314a.f226303k;
            if (r102 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r102 = null;
        L12:
            InsertNewBlockViewModel.a r103 = r102.getDelegate();
            if (r103 == null) goto L18;
            String r104 = r100.getTag().toString();
            AbsInsertNewBlockPlugin.c(((com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.a) r103).f226318a, r104, "");
            return;
        L18:
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r105 = DialogFragmentLancet.sLastShowStack;
            if (r105 == null) goto L9;
            com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void Y90() {
        tt5.a.h("InsertNewBlockFragment", "onFloatDismiss: " + this.f226305m);
        InsertNewBlockViewModel r100 = this.f226303k;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r100 = null;
    L5:
        r100.clearInsertNewBlockData();
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0.b
    public final boolean f9() {
        tt5.a.h("InsertNewBlockFragment", "onDismiss: " + this.f226305m);
        InsertNewBlockData r100 = ((i) this.f226307o.getValue()).a(this.f226305m);
        if (r100 != null) goto L5;
    L17:
        return true;
    L5:
        if (r100.getShouldShowInputMethodAfterClick() == true) goto L17;
        InsertNewBlockViewModel r101 = this.f226303k;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L9:
        String r102 = this.f226305m;
        if (r102 != null) goto L12;
        r102 = "";
    L12:
        InsertNewBlock.ChildData r103 = r101.getChildDataById(r102);
        if (r103 == null) goto L15;
        boolean r104 = Intrinsics.areEqual(r103.getShouldShowInputMethodAfterClick(), Boolean.TRUE);
    L16:
        if (r104 == true) goto L17;
        return false;
    L15:
        r104 = false;
        goto L16
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        tt5.a.h("InsertNewBlockFragment", "back press dismissAllowingStateLoss");
        dismissAllowingStateLoss();     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L13;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return true;
    L13:
        return true;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        sa5.b r100 = this.f226304l;
        if (r100 == null) goto L5;
        r100.d(this);
    L5:
        super.onDestroy();
        InsertNewBlockViewModel r101 = this.f226303k;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L8:
        InsertNewBlockViewModel.a r102 = r101.getDelegate();
        if (r102 == null) goto L12;
        AbsInsertNewBlockPlugin.c(((com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.a) r102).f226318a, "close", "");
        return;
    }

    public InsertNewBlockFragment() {
        this.f226306n = -1;
        this.f226307o = LazyKt.lazy(InsertNewBlockFragment$insertNewBlockRegistry$2.INSTANCE);
        this.f226308p = new g(this);
    }

    public final View getContentView() {
        InsertNewBlockViewModel r100 = null;
        View r101 = View.inflate(getActivity(), R.layout.core_doc_insert_new_block_fragment, null);
        if (ForsetiHelper.s(this) == false) goto L7;
        r101.setBackgroundColor(0);
        View r102 = r101.findViewById(R.id.core_top_placeholder);
        if (r102 == null) goto L7;
        r102.setVisibility(8);
    L7:
        this.f226301i = (ViewGroup) r101.findViewById(R.id.container);
        BaseTitleBar r103 = (BaseTitleBar) r101.findViewById(R.id.core_inb_all_title);
        this.f226302j = r103;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("allTitle");
        r103 = null;
    L10:
        r103.setLeftClickListener(new b(this));
        InsertNewBlockViewModel r104 = (InsertNewBlockViewModel) q.a(this, InsertNewBlockViewModel.class);
        this.f226303k = r104;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r100.getInsertNewBlockLiveData().observe(this, new c(this));
        ViewParent r105 = r101.getParent();
        if (r105 == null) goto L17;
        ((ViewGroup) r105).removeAllViews();
    L17:
        r101.setOnClickListener(new d(this));
        if (ForsetiHelper.s(this) == false) goto L20;
        r101.setFitsSystemWindows(false);
        ((UDShadowLayout) r101.findViewById(R.id.core_inb_drag_layout)).c(R.style.UDShadow_None);
        Intrinsics.checkNotNull(r101);
        return r101;
    L20:
        gx4.c r106 = gx4.c.b.f483116a;
        tt5.a.h("ToolbarCompatHelper", "doCompat2 sEntity=" + r106.f483112a + " " + r106.f483113b);
        View r107 = r106.b(r101, -1, true);
        Intrinsics.checkNotNull(r107);
        return r107;
    L13:
        r100 = r104;
        goto L14
    }

    public final void aa0(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onDismiss(r100);
        tt5.a.h("InsertNewBlockFragment", "onDismiss: " + this.f226305m);
        InsertNewBlockViewModel r101 = this.f226303k;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r101 = null;
    L5:
        r101.clearInsertNewBlockData();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        if (n.D(getActivity()) == false) goto L17;
        Dialog r101 = getDialog();
        if (r101 == null) goto L9;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        WindowManager.LayoutParams r103 = r102.getAttributes();
    L10:
        if (r103 == null) goto L12;
        r103.height = this.f226306n;
    L12:
        Dialog r104 = getDialog();
        if (r104 == null) goto L17;
        Window r105 = r104.getWindow();
        if (r105 == null) goto L17;
        r105.setAttributes(r103);
    L9:
        r103 = null;
    L17:
        com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.e r106 = this.f226300h;
        if (r106 == null) goto L25;
        View r107 = r106.f226330b;
        if (r107 == null) goto L26;
        ViewTreeObserver r108 = r107.getViewTreeObserver();
        if (r108 == null) goto L27;
        r108.addOnDrawListener(new e(this));
        return;
    L27:
        return;
    L26:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        sa5.b r101 = (sa5.b) m.a.a(getActivity(), sa5.b.class);
        this.f226304l = r101;
        if (r101 == null) goto L6;
        r101.e(this);
    L6:
        if (n.D(getActivity()) == false) goto L8;
        int r102 = n.t();
    L9:
        this.f226306n = r102;
        return;
    L8:
        r102 = n.v();
        goto L9
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        setStyle(0, R.style.ToolbarCoreInsertNewBlockDialogStyle);
        if (r100 != null) goto L5;
        r100 = new Bundle();
    L5:
        Dialog r101 = super.onCreateDialog(r100);
        View r102 = getContentView();
        r101.setContentView(r102);
        Window r103 = r101.getWindow();
        if (r103 == null) goto L12;
        WindowManager.LayoutParams r104 = r103.getAttributes();
        r104.width = -1;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.common_panel_support_landscape") == false) goto L10;
        int r105 = Math.min(n.t(), n.p(getContext()));
    L11:
        r104.height = r105;
        r104.flags = (r104.flags | 8) | 256;
        r104.gravity = 80;
        goto L12
    L10:
        r105 = n.t();
    L12:
        r101.setOnCancelListener(new f(this));
        View r106 = r102.findViewById(R.id.core_inb_bg);
        r106.setOnClickListener(com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.f.f226335a);
        r106.post(new com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.g(this, r106, r102));
        return r101;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        aa0(r100);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public static final void Z90(InsertNewBlockFragment r110, InsertNewBlock r111, View.OnClickListener r210) {
        if (r111 == null) goto L5;
        r110.getClass();
        int r100 = 0;
        if (ForsetiHelper.s(r110) == false) goto L24;
        View r101 = r110.getView();
        if (r101 == null) goto L19;
        int r102 = r101.getWidth();
    L20:
        if (r102 > 0) goto L24;
        tt5.a.k("InsertNewBlockFragment", " updateView in forseti, width <= 0");
        View r103 = r110.getView();
        if (r103 == null) goto L135;
        r103.post(new h(r110, r111, r210));
        return;
    L135:
        return;
    L19:
        r102 = 0;
    L24:
        BaseTitleBar r104 = r110.f226302j;
        ViewGroup r105 = null;
        if (r104 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("allTitle");
        r104 = null;
    L27:
        r104.setTitle(r111.getTitle());
        if (r111.getChildren().length != 0) goto L30;
        boolean r106 = true;
    L31:
        if (r106 == false) goto L33;
        tt5.a.h("InsertNewBlockFragment", " insertNewBlock.children size < 2");
        return;
    L33:
        InsertNewBlock.Children[] r107 = r111.getChildren();
        int r108 = r107.length;
        int r109 = 0;
    L34:
        if (r109 >= r108) goto L139;
        InsertNewBlock.Children r112 = r107[r109];
        View r113 = View.inflate(r110.getActivity(), R.layout.core_doc_toolbar_insert_new_block_container, r105);
        HorizontalScrollView r114 = (HorizontalScrollView) r113.findViewById(R.id.scroll_view);
        TextView r115 = (TextView) r113.findViewById(R.id.core_inb_title);
        LinearLayout r116 = (LinearLayout) r113.findViewById(R.id.core_inb_container);
        String r117 = r112.getSubTitle();
        if (r117 != null) goto L38;
    L41:
        boolean r118 = true;
    L42:
        if (r118 == false) goto L44;
        r115.setVisibility(8);
    L45:
        InsertNewBlock.ChildData[] r119 = r112.data;
        int r120 = r119.length;
        int r121 = 0;
    L46:
        if (r121 >= r120) goto L117;
        InsertNewBlock.ChildData r122 = r119[r121];
        Intrinsics.checkNotNull(r122);
        InsertNewBlockItemView r123 = new InsertNewBlockItemView(r110.getActivity());
        r123.setTag(r122.getId());
        InsertNewBlockData r124 = ((i) r110.f226307o.getValue()).a(r122.getId());
        if (r124 == null) goto L51;
        r123.setIcon(r124.getIconId());
    L56:
        r123.setText(r122.getName());
        r123.setBadge(r122.isShowBadge());
        r123.setOnClickListener(r210);
        if (r122.isAdminLimit() == false) goto L59;
        float r125 = 0.5f;
    L60:
        r123.setAlpha(r125);
        if (ForsetiHelper.s(r110) == false) goto L74;
        View r126 = r110.getView();
        if (r126 == null) goto L73;
        Integer r127 = Integer.valueOf(r126.getWidth());
        if (r127.intValue() <= 0) goto L67;
        boolean r128 = true;
    L68:
        if (r128 == true) goto L71;
        r127 = null;
    L71:
        if (r127 == null) goto L73;
        int r129 = r127.intValue();
    L75:
        int r130 = (int) (r129 / 5.5f);
        if (n.D(r110.getActivity()) == false) goto L78;
        r130 = (int) (n.t() / 5.5f);
    L78:
        int r131 = n.d(16) - ((r130 - n.d(49)) / 2);
        if (r131 <= 0) goto L81;
        int r132 = r130 - ((int) (r131 / 5.5f));
        r114.setPadding(r131, 0, r131, 0);
    L82:
        r116.addView(r123, new RelativeLayout.LayoutParams(r132, -2));
        InsertNewBlockData r133 = ((i) r110.f226307o.getValue()).a(r122.getId());
        if (TextUtils.isEmpty(r122.getIconId()) == false) goto L85;
    L87:
        if (r133 == null) goto L92;
        if (r133.getUseSrcImg() != true) goto L92;
        boolean r134 = true;
    L93:
        if (r134 == false) goto L95;
        ViewGroup r135 = null;
        r123.f226315a.setImageTintList(null);
    L96:
        if (r133 == null) goto L103;
        if (r133.getBgDrawableRes() == 0) goto L103;
        if (TextUtils.isEmpty(r122.getBackgroundColor()) == false) goto L103;
        r123.setIconBackground(r133.getBgDrawableRes());
    L103:
        if (TextUtils.isEmpty(r122.getBackgroundColor()) == true) goto L105;
        r123.setIconBackgroundTint(r122.getBackgroundColor());
    L110:
        if (TextUtils.isEmpty(r122.getIconColor()) == true) goto L112;
        r123.setIconImageTint(r122.getIconColor());
    L116:
        r121 = r121 + 1;
        r105 = r135;
        r107 = r107;
        goto L46
    L112:
        if (r133 == null) goto L116;
        if (r133.getIconColorId() == 0) goto L116;
        r123.setIconImageTint(r133.getIconColorId());
        goto L116
    L105:
        if (r133 == null) goto L110;
        if (r133.getBackgroundColorId() == 0) goto L110;
        r123.setIconBackgroundTint(r133.getBackgroundColorId());
        goto L110
    L95:
        r135 = null;
    L92:
        r134 = false;
        goto L93
    L85:
        if (TextUtils.isEmpty(r122.getIconColor()) == false) goto L87;
        r123.f226315a.setImageTintList(null);
        r135 = null;
        goto L96
    L81:
        r132 = r130 - ((int) (Math.abs(r131) / 5.5f));
        r114.setPadding(0, 0, 0, 0);
        goto L82
    L67:
        r128 = false;
    L73:
        r129 = n.v();
        goto L75
    L74:
        r129 = n.v();
        goto L75
    L59:
        r125 = 1.0f;
        goto L60
    L51:
        if (TextUtils.isEmpty(r122.getIconId()) == true) goto L56;
        FragmentActivity r136 = r110.getActivity();
        String r137 = r122.getIconId();
        if (r137 != null) goto L55;
        r137 = "";
    L55:
        r123.setIcon(n.n(r136, r137));
        goto L56
    L117:
        InsertNewBlock.Children[] r138 = r107;
        ViewGroup r139 = r105;
        ViewGroup r140 = r110.f226301i;
        if (r140 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException(KtvSubElement.CONTAINER);
        r140 = r139;
    L120:
        r140.addView(r113);
        r109 = r109 + 1;
        r105 = r139;
        r100 = 0;
        r107 = r138;
        goto L34
    L44:
        r115.setVisibility(r100);
        r115.setText(r112.getSubTitle());
        goto L45
    L38:
        if (r117.length() == 0) goto L41;
        r118 = false;
        goto L42
    L139:
        return;
    L30:
        r106 = false;
        goto L31
    L5:
        if (r110.getDialog() == null) goto L121;
        Dialog r141 = r110.getDialog();
        Intrinsics.checkNotNull(r141);
        if (r141.isShowing() == false) goto L132;
        r110.dismissAllowingStateLoss();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r142 = DialogFragmentLancet.sLastShowStack;
        if (r142 == null) goto L133;
        com.bytedance.crash.d.d(r142, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L133:
        return;
    L132:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (ForsetiHelper.s(this) == true) goto L8;
        Dialog r103 = getDialog();
        if (r103 == null) goto L8;
        com.ss.android.lark.insets.f r104 = WindowInsetsUtils.a(r103);
        r104.i(n.h(getContext(), R.color.bg_body));
        r104.o(true);
        r104.r(true);
    L8:
        if (ForsetiHelper.s(this) == true) goto L12;
        return null;
    L12:
        return getContentView();
    }
}
