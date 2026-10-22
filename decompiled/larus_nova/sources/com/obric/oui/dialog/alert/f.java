package com.obric.oui.dialog.alert;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.text.OTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.net.NetError;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Deprecated(message = "已废弃, 请用 com/obric/oui/dialog/v2 下面的版本")
public final class f extends AbstractDialog {
    public static final /* synthetic */ int N = 0;
    public final String G;
    public final FrameLayout H;
    public final TextView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final TextView f400603J;
    public final FrameLayout K;
    public h L;
    public final FrameLayout M;

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public final int f() {
        return R.layout.o_alert_dialog;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        int r100 = DialogAnimStyle.f400636a;
        com.obric.oui.animation.easy.b r101 = DialogAnimStyle.d(g(), getWindow(), !this.f400658l, true);
        com.obric.oui.animation.easy.b.d(r101, new OAlertDialog$performExitAnimation$1$1(this), new OAlertDialog$performExitAnimation$1$2(this), 1);
        r101.e();
    }

    public final int l() {
        FrameLayout r100 = this.K;
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        Intrinsics.checkNotNull(r100);
        r100.measure(0, 0);
        FrameLayout r102 = this.K;
        Intrinsics.checkNotNull(r102);
        if (r102.getVisibility() != 0) goto L8;
        FrameLayout r103 = this.K;
        Intrinsics.checkNotNull(r103);
        int r104 = r103.getMeasuredHeight();
    L9:
        int r105 = vma.c.f556351a;
        FrameLayout r106 = this.K;
        Intrinsics.checkNotNull(r106);
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 != null) goto L13;
    L11:
        r107 = null;
    L14:
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        if (r108 == null) goto L19;
        r101 = r108.topMargin;
    L19:
        return r104 + r101;
    L13:
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r104 = 0;
        goto L9
    }

    public final int m() {
        FrameLayout r100 = this.H;
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        Intrinsics.checkNotNull(r100);
        r100.measure(0, 0);
        FrameLayout r102 = this.H;
        Intrinsics.checkNotNull(r102);
        if (r102.getVisibility() != 0) goto L8;
        FrameLayout r103 = this.H;
        Intrinsics.checkNotNull(r103);
        int r104 = r103.getMeasuredHeight();
    L9:
        int r105 = vma.c.f556351a;
        FrameLayout r106 = this.H;
        Intrinsics.checkNotNull(r106);
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 != null) goto L13;
    L11:
        r107 = null;
    L14:
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        if (r108 == null) goto L19;
        r101 = r108.topMargin;
    L19:
        return r104 + r101;
    L13:
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r104 = 0;
        goto L9
    }

    public final int n() {
        TextView r100 = this.f400603J;
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        Intrinsics.checkNotNull(r100);
        r100.measure(0, 0);
        TextView r102 = this.f400603J;
        Intrinsics.checkNotNull(r102);
        if (r102.getVisibility() != 0) goto L8;
        TextView r103 = this.f400603J;
        Intrinsics.checkNotNull(r103);
        int r104 = r103.getMeasuredHeight();
    L9:
        int r105 = vma.c.f556351a;
        TextView r106 = this.f400603J;
        Intrinsics.checkNotNull(r106);
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 != null) goto L13;
    L11:
        r107 = null;
    L14:
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        if (r108 == null) goto L19;
        r101 = r108.topMargin;
    L19:
        return r104 + r101;
    L13:
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r104 = 0;
        goto L9
    }

    public final int o() {
        TextView r100 = this.I;
        int r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        Intrinsics.checkNotNull(r100);
        r100.measure(0, 0);
        TextView r102 = this.I;
        Intrinsics.checkNotNull(r102);
        if (r102.getVisibility() != 0) goto L8;
        TextView r103 = this.I;
        Intrinsics.checkNotNull(r103);
        int r104 = r103.getMeasuredHeight();
    L9:
        int r105 = vma.c.f556351a;
        TextView r106 = this.I;
        Intrinsics.checkNotNull(r106);
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 != null) goto L13;
    L11:
        r107 = null;
    L14:
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        if (r108 == null) goto L19;
        r101 = r108.topMargin;
    L19:
        return r104 + r101;
    L13:
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r104 = 0;
        goto L9
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        g().post(new e(this));
        h r100 = this.L;
        if ((r100 instanceof ButtonStyleController) == false) goto L8;
        if (r100 == null) goto L7;
        ButtonStyleController r101 = (ButtonStyleController) r100;
        goto L8
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.dialog.alert.ButtonStyleController");
    L8:
        TextView r102 = this.f400603J;
        if (r102 == null) goto L13;
        r102.postDelayed(new d(this), 1000);
        return;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L44;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Context r100 = getContext();
        FrameLayout r101 = this.M;
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.getVisibility() == 0) goto L13;
        return;
    L13:
        if (pla.e.a(r100) == false) goto L47;
        zma.a r102 = zma.a.f572881a;     // Catch: Exception -> L38
        int r103 = zma.a.e(r100);     // Catch: Exception -> L38
        if (this.f400647a == false) goto L17;
        r103 = r103 - pla.d.c(r100, 16);     // Catch: Exception -> L38
    L17:
        int r104 = m();     // Catch: Exception -> L38
        int r105 = o();     // Catch: Exception -> L38
        int r106 = n();     // Catch: Exception -> L38
        int r107 = l();     // Catch: Exception -> L38
        FrameLayout r108 = this.M;     // Catch: Exception -> L38
        if (r108 == null) goto L29;
        int r110 = vma.c.f556351a;     // Catch: Exception -> L38
        Intrinsics.checkNotNull(r108);     // Catch: Exception -> L38
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();     // Catch: Exception -> L38
        if (r109 != null) goto L24;
    L26:
        r109 = null;
    L27:
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r109;     // Catch: Exception -> L38
        if (r111 == null) goto L29;
        int r112 = r111.topMargin;     // Catch: Exception -> L38
    L31:
        int r113 = pla.d.i(r100);     // Catch: Exception -> L38
        int r114 = pla.d.c(r100, 300);     // Catch: Exception -> L38
        int r115 = pla.d.c(r100, 440);     // Catch: Exception -> L38
        if (r113 <= r114) goto L34;
        r114 = r113 + NetError.ERR_SSL_SERVER_CERT_CHANGED;     // Catch: Exception -> L38
    L34:
        int r116 = (((((r114 - r103) - r104) - r105) - r106) - r107) - r112;     // Catch: Exception -> L38
        int r117 = RangesKt.coerceIn(r116, 0, r114 - pla.d.c(r100, 52));     // Catch: Exception -> L38
        r101.measure(View.MeasureSpec.makeMeasureSpec(r115, Integer.MIN_VALUE), 0);     // Catch: Exception -> L38
        int r118 = r101.getMeasuredHeight();     // Catch: Exception -> L38
        wma.b.a(this.G, "adjustContentHeight, maxHeight: " + r114 + ", HORIZONTAL_MAX_HEIGHT: 300, availableHeight: " + r116 + ", measured BodyHeight: " + r118 + ", maxBodyHeight: " + r117 + ", iconPanelVerticalSpace: " + r104 + ", titleVerticalSpace: " + r105 + ", messageVerticalSpace: " + r106 + ", buttonVerticalSpace: " + r107 + ", bodyMarginSpace: " + r112);     // Catch: Exception -> L38
        if (r118 <= r117) goto L48;
        wma.b.d(this.G, "adjustContentHeight, from: " + r118 + " to: " + r117);     // Catch: Exception -> L38
        ViewGroup.LayoutParams r119 = r101.getLayoutParams();     // Catch: Exception -> L38
        r119.height = r117;     // Catch: Exception -> L38
        r101.setLayoutParams(r119);     // Catch: Exception -> L38
        return;
    L48:
        return;
    L24:
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
    L29:
        r112 = 0;
    L38:
        e = move-exception;
        wma.b.c(this.G, "adjustContentHeight error", e);
        return;
    L47:
        return;
    L44:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.G = "OAlertDialog";
        this.H = (FrameLayout) findViewById(R.id.iconPanel);
        TextView r101 = (TextView) findViewById(R.id.textTitle);
        OTextView r102 = null;
        if (r101 != null) goto L6;
        r101 = null;
    L12:
        this.I = r101;
        TextView r103 = (TextView) findViewById(R.id.textSubTitle);
        if ((r103 instanceof OTextView) == false) goto L15;
        r102 = (OTextView) r103;
    L15:
        if (r102 == null) goto L18;
        r102.setEnableAutoAlignLeft(true);
    L18:
        this.f400603J = r103;
        this.K = (FrameLayout) findViewById(R.id.button_container);
        this.M = (FrameLayout) findViewById(R.id.body_container);
        return;
    L6:
        if ((r101 instanceof OTextView) == false) goto L8;
        OTextView r104 = (OTextView) r101;
    L9:
        if (r104 == null) goto L12;
        r104.setEnableAutoAlignLeft(true);
        goto L12
    L8:
        r104 = null;
        goto L9
    }

    public static void k(f r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        super.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        if (this.f400657k == false) goto L5;
        g().setAlpha(0.0f);
    L5:
        super.onCreate(r100);
        h r101 = this.L;
        if (r101 == null) goto L10;
        r101.a(this);
        return;
    }
}
