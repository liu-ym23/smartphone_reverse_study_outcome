package com.bytedance.dux.panel;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.bytedance.dux.panel.anim.AnimController$AnimProcessType;
import com.bytedance.dux.panel.pad.Location;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import em4.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/dux/panel/DuxBasicPanelFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "<init>", "()V", "dux_release"}, k = 1, mv = {1, 7, 1})
public class DuxBasicPanelFragment extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f205323p = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f205324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f205325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.dux.panel.header.d f205326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Boolean> f205327g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f205328h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f205329i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f205330j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f205331k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f205332l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f205333m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f205334n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Location f205335o;

    public static final class a extends BottomSheetBehavior.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxBasicPanelFragment f205336a;

        @Override // com.bytedance.dux.panel.BottomSheetBehavior.d
        public final void a(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        }

        public a(DuxBasicPanelFragment r100) {
            this.f205336a = r100;
        }

        @Override // com.bytedance.dux.panel.BottomSheetBehavior.d
        public final void b(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            if (r101 != 5) goto L6;
            DuxBasicPanelFragment r102 = this.f205336a;
            int r103 = DuxBasicPanelFragment.f205323p;
            r102.T90();
            return;
        }
    }

    public static final class b implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxBasicPanelFragment f205337a;

        public b(DuxBasicPanelFragment r100) {
            this.f205337a = r100;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r100) {
            DuxBasicPanelFragment r101 = this.f205337a;
            int r102 = DuxBasicPanelFragment.f205323p;
            Dialog r103 = r101.getDialog();
            if (r103 == null) goto L8;
            Window r104 = r103.getWindow();
            if (r104 == null) goto L9;
            DuxBasicPanelFragment.S90(r104);
            return;
        L9:
            return;
        }
    }

    public DuxBasicPanelFragment() {
        this.f205324d = -1;
        this.f205325e = true;
        this.f205328h = true;
        this.f205332l = true;
        this.f205333m = R.style.DuxBasicPanel;
        this.f205335o = Location.CENTER;
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

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        Dialog r100 = getDialog();     // Catch: Exception -> L18
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();     // Catch: Exception -> L18
        if (r101 == null) goto L7;
        S90(r101);     // Catch: Exception -> L18
    L7:
        Dialog r102 = getDialog();     // Catch: Exception -> L18
        if ((r102 instanceof BottomSheetDialog) == false) goto L23;
        boolean r103 = ((BottomSheetDialog) r102).J0().f205263l;     // Catch: Exception -> L18
    L23:
        super.dismiss();     // Catch: Exception -> L12
    L16:
        Unit r104 = Unit.INSTANCE;     // Catch: Exception -> L18
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Exception -> L18
        Throwable r105 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L18
        if (r105 == null) goto L16;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L18
    L18:
        e = move-exception;
        k.a("Try exception occur " + e.getMessage());
        Unit r106 = Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        Dialog r100 = getDialog();
        if (r100 == null) goto L14;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L14;
        S90(r101);
    L14:
        super.dismissAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L16;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
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
        Dialog r101 = getDialog();
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        S90(r102);
    L7:
        super.onCancel(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r100) {
        DuxBasePanelDialog r101 = new DuxBasePanelDialog(requireContext(), this.f205333m);
        r101.f205304j = this.f205324d;
        r101.f205305k = false;
        r101.f205306l = false;
        r101.f205307m = false;
        r101.f205308n = this.f205325e;
        r101.f205309o = false;
        r101.f205310p = this.f205326f;
        r101.C = null;
        r101.D = null;
        r101.E = this.f205327g;
        r101.F = this.f205328h;
        r101.f205311q = this.f205330j;
        r101.f205312r = null;
        r101.f205313s = this.f205331k;
        r101.f205314t = false;
        r101.f205315u = null;
        r101.f205320z = null;
        r101.A = null;
        r101.B = this.f205332l;
        r101.f205316v = false;
        r101.f205317w = this.f205334n;
        r101.f205303J = null;
        Location r102 = this.f205335o;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f205318x = r102;
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
        if (r102 == null) goto L6;
        r102.setOnShowListener(new b(this));
        return;
    }
}
