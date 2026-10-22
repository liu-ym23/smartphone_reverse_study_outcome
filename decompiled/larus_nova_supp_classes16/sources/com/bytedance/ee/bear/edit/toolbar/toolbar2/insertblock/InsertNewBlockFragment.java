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
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.model.toolbar.insertblock.InsertNewBlock;
import com.bytedance.ee.bear.edit.component.toolbar2.a0;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.n;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 B2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001BB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010$\u001a\u00020\u001dH\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u001dH\u0014J\u0012\u0010+\u001a\u00020,2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020!H\u0002J\u0006\u00102\u001a\u00020!J\u001a\u00103\u001a\u00020\u001d2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u001bH\u0002J\u0018\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u00106\u001a\u00020\u001bH\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\u0018\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\b\u0010A\u001a\u00020&H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/insertblock/InsertNewBlockFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "Lcom/bytedance/ee/bear/edit/component/toolbar2/IDocToolbarV2Compat$ToolbarV2DialogDismissHandler;", "<init>", "()V", "dragView", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/insertblock/InsertNewBlockDragView;", "container", "Landroid/view/ViewGroup;", "allTitle", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "viewModel", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/insertblock/InsertNewBlockViewModel;", "backPressDispatcher", "Lcom/bytedance/ee/bear/facade/common/BackPressDispatcher;", "clickData", "", "magicWindowHeight", "", "insertNewBlockRegistry", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/insertblock/InsertNewBlockRegistry;", "getInsertNewBlockRegistry", "()Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/insertblock/InsertNewBlockRegistry;", "insertNewBlockRegistry$delegate", "Lkotlin/Lazy;", "onItemClick", "Landroid/view/View$OnClickListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "onDestroy", "onBackPressed", "", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onFloatDismiss", "onCreateDialog", "Landroid/app/Dialog;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initDragView", "contentView", "getContentView", "updateView", "insertNewBlock", "Lcom/bytedance/ee/bear/document/model/toolbar/insertblock/InsertNewBlock;", "onClickListener", "generateItemView", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/insertblock/InsertNewBlockItemView;", "data", "Lcom/bytedance/ee/bear/document/model/toolbar/insertblock/InsertNewBlock$ChildData;", "generateItemLayoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "scrollView", "Landroid/widget/HorizontalScrollView;", "updateItemTint", "itemView", "shouldHandleKeyboard", "Companion", "docs-edit-toolbar-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InsertNewBlockFragment extends BaseAntiScreenshotsDialogFragment implements sa5.d, a0.b {
    public com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.e h;
    public ViewGroup i;
    public BaseTitleBar j;
    public InsertNewBlockViewModel k;
    public sa5.b l;
    public String m;
    public int n;
    public final Lazy o;
    public final g p;

    public static final class a {
    }

    public static final class b extends t {
        public final /* synthetic */ InsertNewBlockFragment c;

        public b(InsertNewBlockFragment r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ InsertNewBlockFragment a;

        public c(InsertNewBlockFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            InsertNewBlock r4 = (InsertNewBlock) r3;
            if (r4 == null) goto L6;
            InsertNewBlockFragment r0 = this.a;
            InsertNewBlockFragment.Z90(r0, r4, r0.p);
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ InsertNewBlockFragment a;

        public d(InsertNewBlockFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e implements ViewTreeObserver.OnDrawListener {
        public final /* synthetic */ InsertNewBlockFragment a;

        public e(InsertNewBlockFragment r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.e r0 = this.a.h;
            if (r0 == null) goto L5;
            r0.a = new float[]{n.t() * 0.2f, n.t() * 0.6928f, n.t() * 0.9f};
        L5:
            com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.e r1 = this.a.h;
            if (r1 == null) goto L9;
            r1.a(r1.a[1]);
            return;
        }
    }

    public static final class f implements DialogInterface.OnCancelListener {
        public final /* synthetic */ InsertNewBlockFragment a;

        public f(InsertNewBlockFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ InsertNewBlockFragment a;

        public g(InsertNewBlockFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            InsertNewBlockFragment r0 = this.a;
            r0.m = r3.getTag().toString();
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
        L9:
            InsertNewBlockViewModel r1 = this.a.k;
            if (r1 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r1 = null;
        L12:
            InsertNewBlockViewModel.a r2 = r1.getDelegate();
            if (r2 == null) goto L18;
            String r4 = r3.getTag().toString();
            AbsInsertNewBlockPlugin.c(((com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.a) r2).a, r4, "");
            return;
        L18:
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L9;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void Y90() {
        tt5.a.h("InsertNewBlockFragment", "onFloatDismiss: " + this.m);
        InsertNewBlockViewModel r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.clearInsertNewBlockData();
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0.b
    public final boolean f9() {
        tt5.a.h("InsertNewBlockFragment", "onDismiss: " + this.m);
        InsertNewBlockData r0 = ((i) this.o.getValue()).a(this.m);
        if (r0 != null) goto L5;
    L17:
        return true;
    L5:
        if (r0.getShouldShowInputMethodAfterClick() == true) goto L17;
        InsertNewBlockViewModel r1 = this.k;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L9:
        String r2 = this.m;
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        InsertNewBlock.ChildData r3 = r1.getChildDataById(r2);
        if (r3 == null) goto L15;
        boolean r4 = Intrinsics.areEqual(r3.getShouldShowInputMethodAfterClick(), Boolean.TRUE);
    L16:
        if (r4 == true) goto L17;
        return false;
    L15:
        r4 = false;
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
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L13;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return true;
    L13:
        return true;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        sa5.b r0 = this.l;
        if (r0 == null) goto L5;
        r0.d(this);
    L5:
        super.onDestroy();
        InsertNewBlockViewModel r1 = this.k;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L8:
        InsertNewBlockViewModel.a r2 = r1.getDelegate();
        if (r2 == null) goto L12;
        AbsInsertNewBlockPlugin.c(((com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.a) r2).a, "close", "");
        return;
    }

    public InsertNewBlockFragment() {
        this.n = -1;
        this.o = LazyKt.lazy(InsertNewBlockFragment$insertNewBlockRegistry$2.INSTANCE);
        this.p = new g(this);
    }

    public final View getContentView() {
        InsertNewBlockViewModel r2 = null;
        View r0 = View.inflate(getActivity(), 2131559939, null);
        if (ForsetiHelper.s(this) == false) goto L7;
        r0.setBackgroundColor(0);
        View r1 = r0.findViewById(2131367970);
        if (r1 == null) goto L7;
        r1.setVisibility(8);
    L7:
        this.i = (ViewGroup) r0.findViewById(2131367728);
        BaseTitleBar r3 = r0.findViewById(2131367962);
        this.j = r3;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("allTitle");
        r3 = null;
    L10:
        r3.setLeftClickListener(new b(this));
        InsertNewBlockViewModel r4 = (InsertNewBlockViewModel) q.a(this, InsertNewBlockViewModel.class);
        this.k = r4;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r2.getInsertNewBlockLiveData().observe(this, new c(this));
        ViewParent r5 = r0.getParent();
        if (r5 == null) goto L17;
        ((ViewGroup) r5).removeAllViews();
    L17:
        r0.setOnClickListener(new d(this));
        if (ForsetiHelper.s(this) == false) goto L20;
        r0.setFitsSystemWindows(false);
        r0.findViewById(2131367966).c(2131953869);
        Intrinsics.checkNotNull(r0);
        return r0;
    L20:
        gx4.c r6 = gx4.c.b.a;
        tt5.a.h("ToolbarCompatHelper", "doCompat2 sEntity=" + r6.a + " " + r6.b);
        View r7 = r6.b(r0, -1, true);
        Intrinsics.checkNotNull(r7);
        return r7;
    L13:
        r2 = r4;
        goto L14
    }

    public final void aa0(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onDismiss(r2);
        tt5.a.h("InsertNewBlockFragment", "onDismiss: " + this.m);
        InsertNewBlockViewModel r3 = this.k;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L5:
        r3.clearInsertNewBlockData();
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        if (n.D(getActivity()) == false) goto L17;
        Dialog r3 = getDialog();
        if (r3 == null) goto L9;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L9;
        WindowManager.LayoutParams r5 = r4.getAttributes();
    L10:
        if (r5 == null) goto L12;
        r5.height = this.n;
    L12:
        Dialog r0 = getDialog();
        if (r0 == null) goto L17;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L17;
        r1.setAttributes(r5);
    L9:
        r5 = null;
    L17:
        com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.e r6 = this.h;
        if (r6 == null) goto L25;
        View r7 = r6.b;
        if (r7 == null) goto L26;
        ViewTreeObserver r8 = r7.getViewTreeObserver();
        if (r8 == null) goto L27;
        r8.addOnDrawListener(new e(this));
        return;
    L27:
        return;
    L26:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        sa5.b r3 = (sa5.b) m.a.a(getActivity(), sa5.b.class);
        this.l = r3;
        if (r3 == null) goto L6;
        r3.e(this);
    L6:
        if (n.D(getActivity()) == false) goto L8;
        int r4 = n.t();
    L9:
        this.n = r4;
        return;
    L8:
        r4 = n.v();
        goto L9
    }

    public final Dialog onCreateDialog(Bundle r5) {
        setStyle(0, 2131953779);
        if (r5 != null) goto L5;
        r5 = new Bundle();
    L5:
        Dialog r6 = super.onCreateDialog(r5);
        View r0 = getContentView();
        r6.setContentView(r0);
        Window r1 = r6.getWindow();
        if (r1 == null) goto L12;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.common_panel_support_landscape") == false) goto L10;
        int r3 = Math.min(n.t(), n.p(getContext()));
    L11:
        r2.height = r3;
        r2.flags = (r2.flags | 8) | 256;
        r2.gravity = 80;
        goto L12
    L10:
        r3 = n.t();
    L12:
        r6.setOnCancelListener(new f(this));
        View r4 = r0.findViewById(2131367963);
        r4.setOnClickListener(com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.f.a);
        r4.post(new com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.g(this, r4, r0));
        return r6;
    }

    public final void onDismiss(DialogInterface r2) {
        aa0(r2);     // Catch: Throwable -> L5
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

    public static final void Z90(InsertNewBlockFragment r18, InsertNewBlock r19, View.OnClickListener r20) {
        if (r19 == null) goto L5;
        r18.getClass();
        int r4 = 0;
        if (ForsetiHelper.s(r18) == false) goto L24;
        View r3 = r18.getView();
        if (r3 == null) goto L19;
        int r5 = r3.getWidth();
    L20:
        if (r5 > 0) goto L24;
        tt5.a.k("InsertNewBlockFragment", " updateView in forseti, width <= 0");
        View r6 = r18.getView();
        if (r6 == null) goto L135;
        r6.post(new h(r18, r19, r20));
        return;
    L135:
        return;
    L19:
        r5 = 0;
    L24:
        BaseTitleBar r7 = r18.j;
        ViewGroup r8 = null;
        if (r7 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("allTitle");
        r7 = null;
    L27:
        r7.setTitle(r19.getTitle());
        if (r19.getChildren().length != 0) goto L30;
        boolean r9 = true;
    L31:
        if (r9 == false) goto L33;
        tt5.a.h("InsertNewBlockFragment", " insertNewBlock.children size < 2");
        return;
    L33:
        InsertNewBlock.Children[] r1 = r19.getChildren();
        int r10 = r1.length;
        int r11 = 0;
    L34:
        if (r11 >= r10) goto L139;
        InsertNewBlock.Children r12 = r1[r11];
        View r13 = View.inflate(r18.getActivity(), 2131559949, r8);
        HorizontalScrollView r14 = (HorizontalScrollView) r13.findViewById(2131385238);
        TextView r16 = (TextView) r13.findViewById(2131367967);
        LinearLayout r17 = (LinearLayout) r13.findViewById(2131367964);
        String r110 = r12.getSubTitle();
        if (r110 != null) goto L38;
    L41:
        boolean r111 = true;
    L42:
        if (r111 == false) goto L44;
        r16.setVisibility(8);
    L45:
        InsertNewBlock.ChildData[] r21 = r12.data;
        int r112 = r21.length;
        int r113 = 0;
    L46:
        if (r113 >= r112) goto L117;
        InsertNewBlock.ChildData r114 = r21[r113];
        Intrinsics.checkNotNull(r114);
        InsertNewBlockItemView r115 = new InsertNewBlockItemView(r18.getActivity());
        r115.setTag(r114.getId());
        InsertNewBlockData r22 = ((i) r18.o.getValue()).a(r114.getId());
        if (r22 == null) goto L51;
        r115.setIcon(r22.getIconId());
    L56:
        r115.setText(r114.getName());
        r115.setBadge(r114.isShowBadge());
        r115.setOnClickListener(r20);
        if (r114.isAdminLimit() == false) goto L59;
        float r23 = 0.5f;
    L60:
        r115.setAlpha(r23);
        if (ForsetiHelper.s(r18) == false) goto L74;
        View r24 = r18.getView();
        if (r24 == null) goto L73;
        Integer r26 = Integer.valueOf(r24.getWidth());
        if (r26.intValue() <= 0) goto L67;
        boolean r27 = true;
    L68:
        if (r27 == true) goto L71;
        r26 = null;
    L71:
        if (r26 == null) goto L73;
        int r28 = r26.intValue();
    L75:
        int r29 = (int) (r28 / 5.5f);
        if (n.D(r18.getActivity()) == false) goto L78;
        r29 = (int) (n.t() / 5.5f);
    L78:
        int r30 = n.d(16) - ((r29 - n.d(49)) / 2);
        if (r30 <= 0) goto L81;
        int r31 = r29 - ((int) (r30 / 5.5f));
        r14.setPadding(r30, 0, r30, 0);
    L82:
        r17.addView(r115, new RelativeLayout.LayoutParams(r31, -2));
        InsertNewBlockData r32 = ((i) r18.o.getValue()).a(r114.getId());
        if (TextUtils.isEmpty(r114.getIconId()) == false) goto L85;
    L87:
        if (r32 == null) goto L92;
        if (r32.getUseSrcImg() != true) goto L92;
        boolean r33 = true;
    L93:
        if (r33 == false) goto L95;
        ViewGroup r2 = null;
        r115.a.setImageTintList(null);
    L96:
        if (r32 == null) goto L103;
        if (r32.getBgDrawableRes() == 0) goto L103;
        if (TextUtils.isEmpty(r114.getBackgroundColor()) == false) goto L103;
        r115.setIconBackground(r32.getBgDrawableRes());
    L103:
        if (TextUtils.isEmpty(r114.getBackgroundColor()) == true) goto L105;
        r115.setIconBackgroundTint(r114.getBackgroundColor());
    L110:
        if (TextUtils.isEmpty(r114.getIconColor()) == true) goto L112;
        r115.setIconImageTint(r114.getIconColor());
    L116:
        r113 = r113 + 1;
        r8 = r2;
        r1 = r1;
        goto L46
    L112:
        if (r32 == null) goto L116;
        if (r32.getIconColorId() == 0) goto L116;
        r115.setIconImageTint(r32.getIconColorId());
        goto L116
    L105:
        if (r32 == null) goto L110;
        if (r32.getBackgroundColorId() == 0) goto L110;
        r115.setIconBackgroundTint(r32.getBackgroundColorId());
        goto L110
    L95:
        r2 = null;
    L92:
        r33 = false;
        goto L93
    L85:
        if (TextUtils.isEmpty(r114.getIconColor()) == false) goto L87;
        r115.a.setImageTintList(null);
        r2 = null;
        goto L96
    L81:
        r31 = r29 - ((int) (Math.abs(r30) / 5.5f));
        r14.setPadding(0, 0, 0, 0);
        goto L82
    L67:
        r27 = false;
    L73:
        r28 = n.v();
        goto L75
    L74:
        r28 = n.v();
        goto L75
    L59:
        r23 = 1.0f;
        goto L60
    L51:
        if (TextUtils.isEmpty(r114.getIconId()) == true) goto L56;
        FragmentActivity r34 = r18.getActivity();
        String r36 = r114.getIconId();
        if (r36 != null) goto L55;
        r36 = "";
    L55:
        r115.setIcon(n.n(r34, r36));
        goto L56
    L117:
        InsertNewBlock.Children[] r116 = r1;
        ViewGroup r37 = r8;
        ViewGroup r38 = r18.i;
        if (r38 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("container");
        r38 = r37;
    L120:
        r38.addView(r13);
        r11 = r11 + 1;
        r8 = r37;
        r4 = 0;
        r1 = r116;
        goto L34
    L44:
        r16.setVisibility(r4);
        r16.setText(r12.getSubTitle());
        goto L45
    L38:
        if (r110.length() == 0) goto L41;
        r111 = false;
        goto L42
    L139:
        return;
    L30:
        r9 = false;
        goto L31
    L5:
        if (r18.getDialog() == null) goto L121;
        Dialog r39 = r18.getDialog();
        Intrinsics.checkNotNull(r39);
        if (r39.isShowing() == false) goto L132;
        r18.dismissAllowingStateLoss();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L133;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L133:
        return;
    L132:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        if (ForsetiHelper.s(this) == true) goto L8;
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        com.ss.android.lark.insets.f r5 = WindowInsetsUtils.a(r4);
        r5.i(n.h(getContext(), 2131100548));
        r5.o(true);
        r5.r(true);
    L8:
        if (ForsetiHelper.s(this) == true) goto L12;
        return null;
    L12:
        return getContentView();
    }
}
