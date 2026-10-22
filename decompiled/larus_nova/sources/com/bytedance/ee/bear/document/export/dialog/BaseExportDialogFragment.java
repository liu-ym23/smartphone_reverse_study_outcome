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
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.widgets.OpenLoadingView;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.k;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.i;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.utils.h;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.lark.android.encryption.CipherManager;
import i15.b;
import i15.c;
import i15.f;
import jg5.e;
import okhttp3.internal.http2.StreamResetException;
import rw4.n;

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseExportDialogFragment<ExportViewModel extends BaseExportViewModel> extends BaseAntiScreenshotsDialogFragment implements rw4.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f219700o = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ExportViewModel f219701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f219702i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CommonActionPanelLayout f219703j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OpenLoadingView f219704k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public n f219705l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f219706m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewGroup f219707n;

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseExportDialogFragment f219708c;

        public a(BaseExportDialogFragment r100) {
            this.f219708c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            if (this.f219708c.f219702i.getVisibility() != 0) goto L14;
            this.f219708c.onCancel();
            this.f219708c.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L15;
            d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L15:
            return;
        }
    }

    public abstract String ba0();

    public int ca0() {
        return -1;
    }

    public abstract void da0(LayoutInflater r100, ViewGroup r101);

    public abstract ExportViewModel ea0();

    public void ga0(Configuration r100) {
    }

    public final void fa0() {
        n r100 = this.f219705l;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f219706m == true) goto L10;
        this.f219706m = true;
        this.f219701h.reportExportCanceled(ia0(r100));
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        tt5.a.b("BaseExportDialogFragmen", LiveCommonConstants.REASON_ON_DEDTROY);
        super.onDestroy();
        this.f219701h.onDestroy();
    }

    @Override // rw4.a
    public final void onExportStart() {
        ViewGroup r100 = (ViewGroup) getView();
        if (r100 == null) goto L9;
        Context r101 = getContext();
        if (r101 == null) goto L10;
        OpenLoadingView r102 = new OpenLoadingView(r101);
        this.f219704k = r102;
        r102.setCancelClickListener(new b(this));
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        r103.gravity = 17;
        r100.addView(this.f219704k, r103);
        return;
    L10:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Window r100 = getDialog().getWindow();
        WindowManager.LayoutParams r101 = r100.getAttributes();
        r101.gravity = 80;
        r101.windowAnimations = R.style.ActionSheetWindowStyle;
        r101.y = k.e(getContext());
        r101.flags |= Integer.MIN_VALUE;
        r100.setAttributes(r101);
        ha0(getActivity().getResources().getConfiguration());
        r100.setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // rw4.a
    public final void onStartDownload() {
        if (isAdded() == true) goto L6;
        tt5.a.b("BaseExportDialogFragmen", "onStartDownload, is detach");
        return;
    L6:
        OpenLoadingView r100 = this.f219704k;
        if (r100 == null) goto L10;
        r100.setProgress(20);
        return;
    }

    @Override // rw4.a
    public final void onStartPolling() {
        if (isAdded() == true) goto L6;
        tt5.a.b("BaseExportDialogFragmen", "onStartPolling, is detach");
        return;
    L6:
        OpenLoadingView r100 = this.f219704k;
        if (r100 == null) goto L10;
        r100.setProgress(10);
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

    public static void Z90(BaseExportDialogFragment r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static String ia0(n r100) {
        if (r100.equals(n.f539701c) == false) goto L7;
        return EffectConfiguration.KEY_SEARCH_WORD;
    L7:
        if (r100.equals(n.f539705g) == false) goto L11;
        return "excel";
    L11:
        if (r100.equals(n.f539706h) == false) goto L15;
        return ExportFileExtension.PPTX;
    L15:
        if (r100.equals(n.f539702d) == false) goto L19;
        return ExportFileExtension.PDF;
    L19:
        if (r100.equals(n.f539708j) == false) goto L23;
        return "markdown";
    L23:
        if (r100.equals(n.f539707i) == false) goto L26;
        return "txt";
    L26:
        return "unknown";
    }

    public final void ha0(Configuration r100) {
        Window r101 = getDialog().getWindow();
        if (2 != r100.orientation) goto L5;
        r101.setLayout((int) (com.bytedance.ee.util.ui.n.q(getActivity()) * 0.7f), -1);
    L6:
        ga0(r100);
        return;
    L5:
        r101.setLayout(-1, -1);
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r100) {
        super.onCancel(r100);
        fa0();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        ha0(r100);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f219701h = (ExportViewModel) ea0();
    }

    @Override // rw4.a
    public final void onDownloading(int r100) {
        if (isAdded() == true) goto L6;
        tt5.a.b("BaseExportDialogFragmen", "onDownloading, is detach");
        return;
    L6:
        OpenLoadingView r101 = this.f219704k;
        if (r101 == null) goto L10;
        r101.setProgress((int) ((((double) r100) * 0.8d) + 20.0d));
        return;
    }

    @Override // rw4.a
    public final void onPolling(int r100) {
        if (isAdded() == true) goto L6;
        tt5.a.b("BaseExportDialogFragmen", "onPolling, is detach");
        return;
    L6:
        OpenLoadingView r101 = this.f219704k;
        if (r101 == null) goto L10;
        r101.setProgress(Math.min((r100 * 5) + 10, 20));
        return;
    }

    @Override // rw4.a
    public final void onSuccess(Uri r100) {
        if (isAdded() == true) goto L6;
        tt5.a.b("BaseExportDialogFragmen", "onExportSuccess, is detach");
        return;
    L6:
        this.f219701h.reportExportSuccess(ia0(this.f219705l));
        OpenLoadingView r101 = this.f219704k;
        if (r101 == null) goto L9;
        r101.setProgress(100);
    L9:
        i.j(getContext(), r100, null);
        Z90(this);
    }

    public final void aa0(final n r100, final String r101) {
        this.f219702i.setVisibility(8);
        if (CipherManager.d() != 1) goto L6;
        Toast.showText(getContext(), getString(R.string.CreationMobile_ECM_SecuritySettingKAToast), 1, true);
        CipherManager.h();
        return;
    L6:
        FragmentActivity r102 = getActivity();
        if (r102 != null) goto L10;
        tt5.a.k("BaseExportDialogFragmen", "exportDocument activity is null");
        return;
    L10:
        h.g(r102, new c(this, r100, r101), com.ss.android.lark.utils.n.a(), new Token(ba0()), new String[0]);
    }

    @Override // rw4.a
    public final void onFail(int r100, Throwable r101) {
        if (isAdded() == true) goto L7;
        tt5.a.b("BaseExportDialogFragmen", "onExportFail, is detach");
        return;
    L7:
        if ((r101 instanceof StreamResetException) == false) goto L9;
        return;
    L9:
        this.f219701h.reportExportFailed(ia0(this.f219705l));
        boolean r102 = r101 instanceof NetService.ServerErrorException;
        int r103 = R.string.Doc_Document_ExportError;
        if (r102 == false) goto L50;
        NetService.ServerErrorException r104 = (NetService.ServerErrorException) r101;
        int r105 = r104.getCode();
        if (r105 != 107) goto L14;
        r103 = R.string.CreationMobile_DocX_export_failed_TooLarge;
    L40:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.f499003a.g() == false) goto L46;
        ErrorResponse r106 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).e(this.f219701h.getToken(), -1, "EXPORT", r101);
        if (r106.getHasHandledUiAction() == false) goto L50;
        r106.getCallback().a(getContext(), r106);
        return;
    L46:
        String r107 = ((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.d.class)).f(this.f219701h.getToken(), "CCM_EXPORT", r104.getCode());
        if (TextUtils.isEmpty(r107) == true) goto L50;
        Toast.showFailureText(eu5.b.f474075a, r107, 0);
        Z90(this);
        return;
    L14:
        if (r105 != 126) goto L16;
    L38:
        r103 = R.string.CreationMobile_export_export_unit;
        goto L40
    L16:
        if (r105 != 1002) goto L18;
    L37:
        r103 = R.string.CreationMobile_DocX_export_failed_NoPermission;
        goto L40
    L18:
        if (r105 == 1004) goto L40;
        if (r105 != 1006) goto L22;
    L36:
        r103 = R.string.CreationMobile_DocX_export_failed_deleted;
        goto L40
    L22:
        if (r105 == 1014) goto L40;
        if (r105 == 1016) goto L38;
        if (r105 == 6000) goto L40;
        if (r105 != 6014) goto L30;
        r103 = R.string.LarkCCM_Sheets_Protect_CantExport_Toast;
        goto L40
    L30:
        if (r105 == 123) goto L36;
        if (r105 == 124) goto L40;
        switch(r105) {
            case 109: goto L40;
            case 110: goto L37;
            case 111: goto L36;
            case 112: goto L40;
            default: goto L34;
        };
    L34:
        r103 = R.string.CreationMobile_export_failed_retry;
    L50:
        Toast.showFailureText(getContext(), r103);
        Z90(this);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        r100.setOnClickListener(new a(this));
        this.f219702i = (FrameLayout) r100.findViewById(R.id.export_root);
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).p(this.f219702i);
        this.f219703j = (CommonActionPanelLayout) r100.findViewById(R.id.panel_layout);
        final int r102 = getResources().getDimensionPixelSize(R.dimen.document_export_default_height);
        float r103 = r102;
        this.f219703j.l(0.0f, r103, r103);
        this.f219703j.setOnActionListener(new f(this));
        j.c(new i15.a(this, r102));
        int r104 = ca0();
        if (r104 == (-1)) goto L5;
        this.f219703j.setTitle(getResources().getString(r104));
    L5:
        this.f219707n = (ViewGroup) r100.findViewById(R.id.export_container);
        da0(getLayoutInflater(), this.f219707n);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.document_export_dialog_fragment, r101, false);
    }
}
