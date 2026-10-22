package com.bytedance.ee.bear.document.print;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.widgets.OpenLoadingView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000e\u001a\u00020\b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\nJ\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\bH\u0016J\u0018\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020 H\u0002J\u0010\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/document/print/PrintExportLoadingDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "loadingView", "Lcom/bytedance/ee/bear/widgets/OpenLoadingView;", "cancelListener", "Lkotlin/Function0;", "", "currentProgress", "", "cancelDispatched", "", "restoredFromSavedState", "setCancelListener", "listener", "setProgress", "progress", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "onDestroyView", "onDestroy", "resetWindowSize", "activity", "Landroidx/fragment/app/FragmentActivity;", "configuration", "dispatchCancel", "dismissIfUnobserved", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrintExportLoadingDialogFragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int m = 0;
    public OpenLoadingView h;
    public Function0<Unit> i;
    public int j;
    public boolean k;
    public boolean l;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PrintExportLoadingDialogFragment a;

        public c(PrintExportLoadingDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            PrintExportLoadingDialogFragment r3 = this.a;
            int r0 = PrintExportLoadingDialogFragment.m;
            r3.Z90(true);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        this.i = null;
        super.onDestroy();
    }

    public final void onDestroyView() {
        this.h = null;
        super.onDestroyView();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (this.l == true) goto L5;
    L13:
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L29;
        Dialog r1 = getDialog();
        if (r1 == null) goto L27;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L30;
        WindowManager.LayoutParams r3 = r2.getAttributes();
        r3.gravity = 80;
        r3.windowAnimations = 2131951623;
        r3.y = com.bytedance.ee.util.ui.k.e(r0);
        r3.flags |= ShareItemModel.SRC_TINT_UNDEFINED;
        r2.setAttributes(r3);
        aa0(r0, r0.getResources().getConfiguration());
        r2.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L30:
        return;
    L27:
        return;
    L29:
        return;
    L5:
        if (this.i != null) goto L13;
        tt5.a.k("PrintExportLoadingDialog", "dismiss restored print loading without coordinator");
        this.k = true;
        dismissAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L25;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public PrintExportLoadingDialogFragment() {
    }

    public final void Z90(boolean r3) {
        if (this.k == false) goto L5;
        return;
    L5:
        Function0<Unit> r0 = this.i;
        if (r0 == null) goto L8;
        this.k = true;
        r0.invoke();
        return;
    L8:
        if (r3 == false) goto L20;
        this.k = true;
        dismissAllowingStateLoss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L21;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L21:
        return;
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onCancel(r2);
        Z90(false);
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        aa0(r0, r2);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (r1 == null) goto L5;
        boolean r2 = true;
    L6:
        this.l = r2;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        Z90(false);     // Catch: Throwable -> L5
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

    public final void aa0(FragmentActivity r4, Configuration r5) {
        Dialog r0 = getDialog();
        if (r0 == null) goto L13;
        Window r1 = r0.getWindow();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r5.orientation != 2) goto L10;
        int r6 = (int) (com.bytedance.ee.util.ui.n.q(r4) * 0.7f);
    L11:
        r1.setLayout(r6, -1);
        return;
    L10:
        r6 = -1;
        goto L11
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        FrameLayout r6 = (FrameLayout) r4.findViewById(2131371974);
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).p(r6);
        r6.setVisibility(8);
        r4.setOnClickListener(b.a);
        View r7 = new OpenLoadingView(r4.getContext());
        r7.setTitle(2131889215);
        r7.setProgress(this.j);
        r7.setCancelClickListener(new c(this));
        this.h = r7;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 17;
        ((ViewGroup) r4).addView(r7, r0);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560118, r3, false);
    }
}
