package com.bytedance.ee.bear.document.export.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.widgets.OpenLoadingView;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.k;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.i;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.utils.h;
import com.ss.lark.android.encryption.CipherManager;
import i15.b;
import i15.c;
import i15.f;
import jg5.e;
import okhttp3.internal.http2.StreamResetException;
import rw4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseExportDialogFragment<ExportViewModel extends BaseExportViewModel> extends BaseAntiScreenshotsDialogFragment implements rw4.a {
    public static final /* synthetic */ int o = 0;
    public ExportViewModel h;
    public FrameLayout i;
    public CommonActionPanelLayout j;
    public OpenLoadingView k;
    public n l;
    public boolean m;
    public ViewGroup n;

    public class a extends t {
        public final /* synthetic */ BaseExportDialogFragment c;

        public a(BaseExportDialogFragment r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            if (this.c.i.getVisibility() != 0) goto L14;
            this.c.onCancel();
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L15;
            d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L15:
            return;
        }
    }

    public abstract String ba0();

    public int ca0() {
        return -1;
    }

    public abstract void da0(LayoutInflater r1, ViewGroup r2);

    public abstract ExportViewModel ea0();

    public void ga0(Configuration r1) {
    }

    public final void fa0() {
        n r0 = this.l;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.m == true) goto L10;
        this.m = true;
        this.h.reportExportCanceled(ia0(r0));
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public void onDestroy() {
        tt5.a.b("BaseExportDialogFragmen", "onDestroy");
        super.onDestroy();
        this.h.onDestroy();
    }

    @Override // rw4.a
    public final void onExportStart() {
        ViewGroup r0 = (ViewGroup) getView();
        if (r0 == null) goto L9;
        Context r1 = getContext();
        if (r1 == null) goto L10;
        OpenLoadingView r2 = new OpenLoadingView(r1);
        this.k = r2;
        r2.setCancelClickListener(new b(this));
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
        r3.gravity = 17;
        r0.addView(this.k, r3);
        return;
    L10:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Window r0 = getDialog().getWindow();
        WindowManager.LayoutParams r1 = r0.getAttributes();
        r1.gravity = 80;
        r1.windowAnimations = 2131951623;
        r1.y = k.e(getContext());
        r1.flags |= ShareItemModel.SRC_TINT_UNDEFINED;
        r0.setAttributes(r1);
        ha0(getActivity().getResources().getConfiguration());
        r0.setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // rw4.a
    public final void onStartDownload() {
        if (isAdded() == true) goto L6;
        tt5.a.b("BaseExportDialogFragmen", "onStartDownload, is detach");
        return;
    L6:
        OpenLoadingView r0 = this.k;
        if (r0 == null) goto L10;
        r0.setProgress(20);
        return;
    }

    @Override // rw4.a
    public final void onStartPolling() {
        if (isAdded() == true) goto L6;
        tt5.a.b("BaseExportDialogFragmen", "onStartPolling, is detach");
        return;
    L6:
        OpenLoadingView r0 = this.k;
        if (r0 == null) goto L10;
        r0.setProgress(10);
        return;
    }

    public BaseExportDialogFragment() {
    }

    public void onCancel() {
        fa0();
    }

    @Override // rw4.a
    public final void onDismiss() {
        Z90(this);
    }

    public static void Z90(BaseExportDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static String ia0(n r1) {
        if (r1.equals(n.c) == false) goto L7;
        return "word";
    L7:
        if (r1.equals(n.g) == false) goto L11;
        return "excel";
    L11:
        if (r1.equals(n.h) == false) goto L15;
        return "pptx";
    L15:
        if (r1.equals(n.d) == false) goto L19;
        return "pdf";
    L19:
        if (r1.equals(n.j) == false) goto L23;
        return "markdown";
    L23:
        if (r1.equals(n.i) == false) goto L26;
        return "txt";
    L26:
        return "unknown";
    }

    public final void ha0(Configuration r5) {
        Window r0 = getDialog().getWindow();
        if (2 != r5.orientation) goto L5;
        r0.setLayout((int) (com.bytedance.ee.util.ui.n.q(getActivity()) * 0.7f), -1);
    L6:
        ga0(r5);
        return;
    L5:
        r0.setLayout(-1, -1);
        goto L6
    }

    public void onCancel(DialogInterface r1) {
        super.onCancel(r1);
        fa0();
    }

    public final void onConfigurationChanged(Configuration r1) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r1);
        ha0(r1);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.h = (ExportViewModel) ea0();
    }

    @Override // rw4.a
    public final void onDownloading(int r6) {
        if (isAdded() == true) goto L6;
        tt5.a.b("BaseExportDialogFragmen", "onDownloading, is detach");
        return;
    L6:
        OpenLoadingView r0 = this.k;
        if (r0 == null) goto L10;
        r0.setProgress((int) ((((double) r6) * 0.8d) + 20.0d));
        return;
    }

    @Override // rw4.a
    public final void onPolling(int r3) {
        if (isAdded() == true) goto L6;
        tt5.a.b("BaseExportDialogFragmen", "onPolling, is detach");
        return;
    L6:
        OpenLoadingView r0 = this.k;
        if (r0 == null) goto L10;
        r0.setProgress(Math.min((r3 * 5) + 10, 20));
        return;
    }

    @Override // rw4.a
    public final void onSuccess(Uri r3) {
        if (isAdded() == true) goto L6;
        tt5.a.b("BaseExportDialogFragmen", "onExportSuccess, is detach");
        return;
    L6:
        this.h.reportExportSuccess(ia0(this.l));
        OpenLoadingView r0 = this.k;
        if (r0 == null) goto L9;
        r0.setProgress(100);
    L9:
        i.j(getContext(), r3, null);
        Z90(this);
    }

    public final void aa0(final n r4, final String r5) {
        this.i.setVisibility(8);
        if (CipherManager.d() != 1) goto L6;
        Toast.showText(getContext(), getString(2131887290), 1, true);
        CipherManager.h();
        return;
    L6:
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L10;
        tt5.a.k("BaseExportDialogFragmen", "exportDocument activity is null");
        return;
    L10:
        h.g(r0, new c(this, r4, r5), com.ss.android.lark.utils.n.a(), new Token(ba0()), new String[0]);
    }

    @Override // rw4.a
    public final void onFail(int r5, Throwable r6) {
        if (isAdded() == true) goto L7;
        tt5.a.b("BaseExportDialogFragmen", "onExportFail, is detach");
        return;
    L7:
        if ((r6 instanceof StreamResetException) == false) goto L9;
        return;
    L9:
        this.h.reportExportFailed(ia0(this.l));
        int r0 = 2131887702;
        if ((r6 instanceof NetService.ServerErrorException) == false) goto L50;
        NetService.ServerErrorException r7 = (NetService.ServerErrorException) r6;
        int r1 = r7.getCode();
        if (r1 != 107) goto L14;
        r0 = 2131887150;
    L40:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.a.g() == false) goto L46;
        ErrorResponse r8 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).e(this.h.getToken(), -1, "EXPORT", r6);
        if (r8.getHasHandledUiAction() == false) goto L50;
        r8.getCallback().a(getContext(), r8);
        return;
    L46:
        String r9 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.d.class)).f(this.h.getToken(), "CCM_EXPORT", r7.getCode());
        if (TextUtils.isEmpty(r9) == true) goto L50;
        Toast.showFailureText(eu5.b.a, r9, 0);
        Z90(this);
        return;
    L14:
        if (r1 != 126) goto L16;
    L38:
        r0 = 2131887553;
        goto L40
    L16:
        if (r1 != 1002) goto L18;
    L37:
        r0 = 2131887149;
        goto L40
    L18:
        if (r1 == 1004) goto L40;
        if (r1 != 1006) goto L22;
    L36:
        r0 = 2131887151;
        goto L40
    L22:
        if (r1 == 1014) goto L40;
        if (r1 == 1016) goto L38;
        if (r1 == 6000) goto L40;
        if (r1 != 6014) goto L30;
        r0 = 2131889749;
        goto L40
    L30:
        if (r1 == 123) goto L36;
        if (r1 == 124) goto L40;
        switch(r1) {
            case 109: goto L40;
            case 110: goto L37;
            case 111: goto L36;
            case 112: goto L40;
            default: goto L34;
        };
    L34:
        r0 = 2131887554;
    L50:
        Toast.showFailureText(getContext(), r0);
        Z90(this);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public void onViewCreated(View r4, Bundle r5) {
        r4.setOnClickListener(new a(this));
        this.i = (FrameLayout) r4.findViewById(2131371974);
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).p(this.i);
        this.j = r4.findViewById(2131381877);
        final int r6 = getResources().getDimensionPixelSize(2131165842);
        float r2 = r6;
        this.j.l(0.0f, r2, r2);
        this.j.setOnActionListener(new f(this));
        j.c(new i15.a(this, r6));
        int r7 = ca0();
        if (r7 == (-1)) goto L5;
        this.j.setTitle(getResources().getString(r7));
    L5:
        this.n = (ViewGroup) r4.findViewById(2131371947);
        da0(getLayoutInflater(), this.n);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131560118, r3, false);
    }
}
