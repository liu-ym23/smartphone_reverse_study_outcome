package com.obric.oui.panel;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.oui.panel.anim.AnimController$AnimProcessType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pla.f;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/panel/OBasicPanelFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "<init>", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OBasicPanelFragment extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f402067i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f402068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f402069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f402070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f402071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f402072h;

    public static final class a extends BottomSheetBehavior.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OBasicPanelFragment f402073a;

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public final void a(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        }

        public a(OBasicPanelFragment r100) {
            this.f402073a = r100;
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public final void b(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            if (r101 != 5) goto L6;
            OBasicPanelFragment r102 = this.f402073a;
            int r103 = OBasicPanelFragment.f402067i;
            r102.T90();
            return;
        }
    }

    public OBasicPanelFragment() {
        this.f402068d = -1;
        this.f402069e = true;
        this.f402070f = true;
        this.f402071g = true;
        this.f402072h = R.style.OBasicPanel;
        AnimController$AnimProcessType r100 = AnimController$AnimProcessType.NONE;
        new a(this);
    }

    public final void T90() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L11;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void U90() {
        Dialog r100 = getDialog();
        if (r100 == null) goto L10;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L11;
        S90(r101);
        return;
    L11:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        U90();     // Catch: Exception -> L13
        Dialog r100 = getDialog();     // Catch: Exception -> L13
        if ((r100 instanceof BottomSheetDialog) == false) goto L18;
        boolean r101 = ((BottomSheetDialog) r100).J0().f402009l;     // Catch: Exception -> L13
    L18:
        super.dismiss();     // Catch: Exception -> L7
    L11:
        Unit r102 = Unit.INSTANCE;     // Catch: Exception -> L13
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Exception -> L13
        Throwable r103 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L13
        if (r103 == null) goto L11;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        f.a(Intrinsics.stringPlus("Try exception occur ", e.getMessage()));
        Unit r104 = Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        U90();
        super.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L12;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void S90(Window r100) {
        r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L8;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r101 = ThreadMethodProxy.currentThread();
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        U90();
        super.onCancel(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r100) {
        OBasePanelDialog r101 = new OBasePanelDialog(requireContext(), this.f402072h);
        r101.f402049j = this.f402068d;
        r101.f402050k = false;
        r101.f402051l = false;
        r101.f402052m = false;
        r101.f402053n = this.f402069e;
        r101.f402054o = false;
        r101.f402055p = null;
        r101.A = null;
        r101.B = null;
        r101.C = this.f402070f;
        r101.f402056q = false;
        r101.f402057r = null;
        r101.f402058s = false;
        r101.f402059t = false;
        r101.f402060u = null;
        r101.f402063x = null;
        r101.f402064y = null;
        r101.f402065z = this.f402071g;
        r101.f402061v = false;
        r101.f402062w = false;
        return r101;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        if (r102 == null) goto L7;
        r102.setOnShowListener(new c(this));
        return;
    }
}
