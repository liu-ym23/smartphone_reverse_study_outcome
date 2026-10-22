package com.larus.drive.biz.impl.dialog;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.drive.biz.impl.databinding.LarusDialogDriveInputConfirmBinding;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m79.e;
import m79.f;
import m79.g;
import v19.h;
import v19.l5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u000201B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0002J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0014H\u0002J\u0012\u0010,\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010\u0018H\u0002J\u000e\u0010-\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010.\u001a\u00020\u00142\b\u0010/\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/drive/biz/impl/dialog/DriveInputConfirmDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusDialogDriveInputConfirmBinding;", "titleText", "", "defaultInput", "hintText", "confirmText", "cancelText", "emptyInputWarningText", "callback", "Lcom/larus/drive/biz/impl/dialog/IDriveInputConfirmDialogCallback;", "translationAnimator", "Landroid/animation/ValueAnimator;", "isResettingText", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", LiveCommonConstants.REASON_ON_DEDTROY, "setupView", WidgetCostModule.TYPE_ON_START, "setupKeyboardAdjust", "adjustForIme", "insets", "Landroidx/core/view/WindowInsetsCompat;", "animateTranslationY", "view", RemoteMessageConst.TO, "", "onCancel", "dialog", "Landroid/content/DialogInterface;", "dismissSafely", "showKeyboard", "setCallback", "setHint", "value", "Companion", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveInputConfirmDialog extends DialogFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f341173n = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogDriveInputConfirmBinding f341174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f341175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f341176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f341177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f341178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f341179i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f341180j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f341181k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f341182l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f341183m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f341184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f341185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f341186c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f341187d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f341188e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f341189f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public g f341190g;

        public a() {
        }

        public final DriveInputConfirmDialog a() {
            DriveInputConfirmDialog r100 = new DriveInputConfirmDialog();
            Bundle r101 = new Bundle();
            r101.putString("arg_title", this.f341184a);
            r101.putString("arg_default", this.f341185b);
            r101.putString("arg_hint", this.f341186c);
            r101.putString("arg_confirm", this.f341187d);
            r101.putString("arg_cancel", this.f341188e);
            r101.putString("arg_empty_input_warning", this.f341189f);
            r100.setArguments(r101);
            g r102 = this.f341190g;
            if (r102 == null) goto L5;
            Intrinsics.checkNotNullParameter(r102, "callback");
            r100.f341181k = r102;
        L5:
            return r100;
        }
    }

    public static final class b {
    }

    static {
    }

    public final void T90() {
        FragmentActivity r100 = getActivity();     // Catch: Throwable -> L23
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L29;
        Dialog r103 = getDialog();     // Catch: Throwable -> L23
        if (r103 != null) goto L12;
    L14:
        r101 = false;
    L15:
        if (r101 == false) goto L30;
        dismiss();     // Catch: Exception -> L18 Throwable -> L23
    L32:
        return;
    L18:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L23
        Throwable r104 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L23
        if (r104 == null) goto L31;
        d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L23
        return;
    L31:
        return;
    L30:
        return;
    L12:
        if (r103.isShowing() != true) goto L14;
    L29:
        return;
    L5:
        if (r100.isFinishing() == true) goto L7;
        r102 = true;
    L23:
        th = move-exception;
        FLogger.f375446a.e("DriveInputConfirmDialog", "dismissSafely error", th);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ValueAnimator r100 = this.f341182l;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L13;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L14;
        View r102 = r101.getDecorView();
        if (c.f346345e == false) goto L11;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == c.f346341a) goto L11;
        c.a(r103, "getDecorView");
    L11:
        WindowInsetsControllerCompat r104 = WindowCompat.getInsetsController(r101, r102);
        boolean r105 = h.f552477a;
        boolean r106 = !h.a(null);
        r104.setAppearanceLightStatusBars(r106);
        r104.setAppearanceLightNavigationBars(r106);
        r101.setLayout(-1, -1);
        r101.clearFlags(2);
        r101.addFlags(Integer.MIN_VALUE);
        r101.addFlags(512);
        return;
    L14:
        return;
    }

    public DriveInputConfirmDialog() {
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onCancel(r100);
        g r101 = this.f341181k;
        if (r101 == null) goto L6;
        r101.d();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(2, R.style.FullScreenDialogCreationTheme);
        Bundle r101 = getArguments();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getString("arg_title");
    L6:
        this.f341175e = r103;
        if (r101 == null) goto L9;
        String r104 = r101.getString("arg_default");
    L10:
        this.f341176f = r104;
        if (r101 == null) goto L13;
        String r105 = r101.getString("arg_hint");
    L14:
        this.f341177g = r105;
        if (r101 == null) goto L17;
        String r106 = r101.getString("arg_confirm");
    L18:
        this.f341178h = r106;
        if (r101 == null) goto L21;
        String r107 = r101.getString("arg_cancel");
    L22:
        this.f341179i = r107;
        if (r101 == null) goto L25;
        r102 = r101.getString("arg_empty_input_warning");
    L25:
        this.f341180j = r102;
        setCancelable(false);
        return;
    L21:
        r107 = null;
        goto L22
    L17:
        r106 = null;
        goto L18
    L13:
        r105 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final void S90(final View r100, float r101) {
        float r102 = r100.getTranslationY();
        if (Math.abs(r102 - r101) >= 1.0f) goto L6;
        r100.setTranslationY(r101);
        return;
    L6:
        ValueAnimator r103 = this.f341182l;
        if (r103 == null) goto L9;
        r103.cancel();
    L9:
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{r102, r101});
        r104.setDuration(200);
        r104.setInterpolator(new l5());
        r104.addUpdateListener(new e(r100));
        r104.start();
        this.f341182l = r104;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.inflate(R.layout.larus_dialog_drive_input_confirm, r110, false);
        int r112 = R.id.larus_drive_confirm_dialog_cancel;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r101, R.id.larus_drive_confirm_dialog_cancel);
        if (r102 == null) goto L105;
        r112 = R.id.larus_drive_confirm_dialog_confirm;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r101, R.id.larus_drive_confirm_dialog_confirm);
        if (r103 == null) goto L105;
        r112 = R.id.larus_drive_confirm_dialog_container;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r101, R.id.larus_drive_confirm_dialog_container);
        if (r104 == null) goto L105;
        r112 = R.id.larus_drive_confirm_dialog_input;
        EditText r105 = (EditText) ViewBindings.findChildViewById(r101, R.id.larus_drive_confirm_dialog_input);
        if (r105 == null) goto L105;
        r112 = R.id.larus_drive_confirm_dialog_title;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r101, R.id.larus_drive_confirm_dialog_title);
        if (r106 == null) goto L105;
        this.f341174d = new LarusDialogDriveInputConfirmBinding((FrameLayout) r101, r102, r103, r104, r105, r106);
        Dialog r107 = getDialog();
        if (r107 == null) goto L17;
        Window r108 = r107.getWindow();
        if (r108 == null) goto L17;
        r108.setBackgroundDrawable(new ColorDrawable(0));
        WindowCompat.setDecorFitsSystemWindows(r108, false);
    L17:
        String r109 = this.f341175e;
        if (r109 == null) goto L24;
        LarusDialogDriveInputConfirmBinding r113 = this.f341174d;
        if (r113 == null) goto L24;
        TextView r114 = r113.f341106f;
        if (r114 == null) goto L24;
        r114.setText(r109);
    L24:
        String r115 = this.f341178h;
        if (r115 == null) goto L31;
        LarusDialogDriveInputConfirmBinding r116 = this.f341174d;
        if (r116 == null) goto L31;
        TextView r117 = r116.f341103c;
        if (r117 == null) goto L31;
        r117.setText(r115);
    L31:
        String r118 = this.f341179i;
        if (r118 == null) goto L38;
        LarusDialogDriveInputConfirmBinding r119 = this.f341174d;
        if (r119 == null) goto L38;
        TextView r120 = r119.f341102b;
        if (r120 == null) goto L38;
        r120.setText(r118);
    L38:
        String r121 = this.f341176f;
        if (r121 == null) goto L45;
        LarusDialogDriveInputConfirmBinding r122 = this.f341174d;
        if (r122 == null) goto L45;
        EditText r123 = r122.f341105e;
        if (r123 == null) goto L45;
        r123.setText(r121);
    L45:
        String r124 = this.f341177g;
        if (r124 == null) goto L52;
        LarusDialogDriveInputConfirmBinding r125 = this.f341174d;
        if (r125 == null) goto L52;
        EditText r126 = r125.f341105e;
        if (r126 == null) goto L52;
        r126.setHint(r124);
    L52:
        LarusDialogDriveInputConfirmBinding r127 = this.f341174d;
        if (r127 == null) goto L57;
        EditText r128 = r127.f341105e;
        if (r128 == null) goto L57;
        r128.addTextChangedListener(new f(this));
    L57:
        LarusDialogDriveInputConfirmBinding r129 = this.f341174d;
        if (r129 == null) goto L62;
        TextView r130 = r129.f341102b;
        if (r130 == null) goto L62;
        r130.setOnClickListener(new m79.b(this));
    L62:
        LarusDialogDriveInputConfirmBinding r131 = this.f341174d;
        if (r131 == null) goto L67;
        TextView r132 = r131.f341103c;
        if (r132 == null) goto L67;
        r132.setOnClickListener(new m79.c(this));
    L67:
        LarusDialogDriveInputConfirmBinding r133 = this.f341174d;
        if (r133 == null) goto L72;
        LinearLayout r134 = r133.f341104d;
        if (r134 == null) goto L72;
        r134.setClickable(true);
    L72:
        LarusDialogDriveInputConfirmBinding r135 = this.f341174d;
        if (r135 == null) goto L77;
        EditText r136 = r135.f341105e;
        if (r136 == null) goto L77;
        r136.requestFocus();
    L77:
        Dialog r137 = getDialog();
        if (r137 == null) goto L82;
        Window r138 = r137.getWindow();
        if (r138 == null) goto L82;
        r138.setSoftInputMode(5);
    L82:
        LarusDialogDriveInputConfirmBinding r139 = this.f341174d;
        if (r139 == null) goto L85;
        EditText r140 = r139.f341105e;
    L86:
        if (r140 != null) goto L106;
    L94:
        LarusDialogDriveInputConfirmBinding r141 = this.f341174d;
        if (r141 == null) goto L100;
        FrameLayout r142 = r141.f341101a;
        if (r142 == null) goto L100;
        ViewCompat.setOnApplyWindowInsetsListener(r142, new m79.d(this));
    L100:
        LarusDialogDriveInputConfirmBinding r143 = this.f341174d;
        if (r143 != null) goto L103;
        return null;
    L103:
        return r143.f341101a;
    L106:
        InputMethodManager r144 = (InputMethodManager) ContextCompat.getSystemService(requireContext(), InputMethodManager.class);     // Catch: Throwable -> L92
        if (r144 == null) goto L94;
        r144.showSoftInput(r140, 1);     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        FLogger.f375446a.e("DriveInputConfirmDialog", "showKeyboard error", th);
        goto L94
    L85:
        r140 = null;
    L105:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r112)));
    }
}
