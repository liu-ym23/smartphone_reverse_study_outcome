package com.bytedance.ee.bear.middleground.permission.setting.permselect;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.CompatLandscapeBottomSheetDialogFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.SelectItemView;
import com.bytedance.ee.bear.widgets.t;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/setting/permselect/SelectPermTypeFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/CompatLandscapeBottomSheetDialogFragment;", "<init>", "()V", "willLock", "", "location", "", "isContainerSelected", "viewModel", "Lcom/bytedance/ee/bear/middleground/permission/setting/permselect/SelectPermTypeViewModel;", "permType", "", "hasClickConfirm", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroy", "setSelected", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectPermTypeFragment extends CompatLandscapeBottomSheetDialogFragment {
    public static final /* synthetic */ int q = 0;
    public boolean k;
    public String l;
    public boolean m;
    public SelectPermTypeViewModel n;
    public int o;
    public boolean p;

    public static final class a {
    }

    public static final class b extends t {
        public final /* synthetic */ SelectPermTypeFragment c;

        public b(SelectPermTypeFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
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

    public static final class c extends t {
        public final /* synthetic */ SelectPermTypeFragment c;

        public c(SelectPermTypeFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            SelectPermTypeFragment r3 = this.c;
            int r0 = SelectPermTypeFragment.q;
            r3.ea0(false);
        }
    }

    public static final class d extends t {
        public final /* synthetic */ SelectPermTypeFragment c;

        public d(SelectPermTypeFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            SelectPermTypeFragment r3 = this.c;
            int r0 = SelectPermTypeFragment.q;
            r3.ea0(true);
        }
    }

    public static final class e extends t {
        public final /* synthetic */ SelectPermTypeFragment c;

        public e(SelectPermTypeFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            String r4 = com.bytedance.ee.bear.middleground.permission.c.a;
            SelectPermTypeFragment r5 = this.c;
            com.bytedance.ee.bear.middleground.permission.c.M(false, r5.l, r5.k);
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r6 = DialogFragmentLancet.sLastShowStack;
            if (r6 == null) goto L12;
            com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class f extends t {
        public final /* synthetic */ SelectPermTypeFragment c;
        public final /* synthetic */ View d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r4) {
            SelectPermTypeFragment r5 = this.c;
            int r0 = 1;
            r5.p = true;
            String r1 = com.bytedance.ee.bear.middleground.permission.c.a;
            com.bytedance.ee.bear.middleground.permission.c.M(true, r5.l, r5.k);
            SelectPermTypeFragment r6 = this.c;
            if (((SelectItemView) this.d.findViewById(2131367730)).isSelected() == true) goto L6;
            r0 = 2;
        L6:
            r6.o = r0;
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r7 = DialogFragmentLancet.sLastShowStack;
            if (r7 == null) goto L16;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public f(SelectPermTypeFragment r1, View r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    static {
    }

    public SelectPermTypeFragment() {
        this.l = "";
    }

    public final void onDestroy() {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment*/.onDestroy();
        SelectPermTypeViewModel r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.reset();
    }

    public final void da0(DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r4, "dialog");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment*/.onDismiss(r4);
        SelectPermTypeViewModel r5 = this.n;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r5 = null;
    L5:
        r5.setPermType(this.o);
        SelectPermTypeViewModel r6 = this.n;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r6 = null;
    L8:
        r6.setDismiss(true);
        if (this.p == false) goto L11;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().k(this.o);
        return;
    L11:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().k(-1);
    }

    public final void ea0(boolean r7) {
        View r0 = getView();
        String r1 = null;
        if (r0 == null) goto L5;
        SelectItemView r2 = (SelectItemView) r0.findViewById(2131386540);
    L6:
        if (r2 == null) goto L8;
        r2.setSelected(!r7);
    L8:
        View r3 = getView();
        if (r3 == null) goto L11;
        SelectItemView r4 = (SelectItemView) r3.findViewById(2131367730);
    L12:
        if (r4 == null) goto L23;
        int r5 = 0;
        if (this.k == false) goto L17;
        if (r7 == false) goto L17;
        boolean r6 = true;
    L18:
        r4.a = r7;
        r4.b.setChecked(r7);
        TextView r8 = r4.d;
        if (r6 == true) goto L22;
        r5 = 8;
    L22:
        r8.setVisibility(r5);
    L17:
        r6 = false;
    L23:
        View r9 = getView();
        if (r9 == null) goto L26;
        SelectItemView r10 = (SelectItemView) r9.findViewById(2131367730);
    L27:
        if (r10 == null) goto L35;
        View r11 = getView();
        if (r11 == null) goto L33;
        Context r12 = r11.getContext();
        if (r12 == null) goto L33;
        r1 = r12.getString(2131887507);
    L33:
        r10.setDescription(r1);
        return;
    L35:
        return;
    L26:
        r10 = null;
        goto L27
    L11:
        r4 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final void onCreate(Bundle r4) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment*/.onCreate(r4);
        this.n = (SelectPermTypeViewModel) ViewModelProviders.of(requireActivity()).get(SelectPermTypeViewModel.class);
        Bundle r5 = getArguments();
        boolean r0 = false;
        if (r5 == null) goto L5;
        boolean r6 = r5.getBoolean("extra_will_lock", false);
    L6:
        this.k = r6;
        Bundle r7 = getArguments();
        String r1 = "";
        if (r7 == null) goto L12;
        String r8 = r7.getString("extra_location", "");
        if (r8 == null) goto L12;
        r1 = r8;
    L12:
        this.l = r1;
        Bundle r9 = getArguments();
        if (r9 == null) goto L15;
        r0 = r9.getBoolean("extra_is_container_selected", false);
    L15:
        this.m = r0;
        tt5.a.h("SelectPermTypeFragment", "will lock = " + this.k + ", isContainerSelected = " + this.m);
        return;
    L5:
        r6 = false;
        goto L6
    }

    public final void onDismiss(DialogInterface r2) {
        da0(r2);     // Catch: Throwable -> L5
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

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r3, r4);
        com.bytedance.ee.bear.middleground.permission.c.b0("ccm_permission_scope_change_view");
        ((BaseTitleBar) r3.findViewById(2131388775)).setLeftClickListener(new b(this));
        ((BaseTitleBar) r3.findViewById(2131388775)).setMainTitleSize(17.0f);
        ((BaseTitleBar) r3.findViewById(2131388775)).setTitle(2131887506);
        ea0(this.m);
        ((SelectItemView) r3.findViewById(2131386540)).setOnClickListener(new c(this));
        ((SelectItemView) r3.findViewById(2131367730)).setOnClickListener(new d(this));
        r3.findViewById(2131365115).setOnClickListener(new e(this));
        r3.findViewById(2131367640).setOnClickListener(new f(this, r3));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564190, r3, false);
    }
}
