package x6c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.thirdshare.base.export.downgrade.CtaBtnStyle;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends com.larksuite.component.ui.dialog.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f562757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f562758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CtaBtnStyle f562759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f562760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Runnable f562761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f562762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Runnable f562763g;

    public static void c(LKUIDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // com.larksuite.component.ui.dialog.d.a
    public final void b(final LKUIDialog r110) {
        TextView r100 = (TextView) r110.findViewById(R.id.sdpTitleTv);
        TextView r101 = (TextView) r110.findViewById(R.id.sdpContentTv);
        LinearLayout r102 = (LinearLayout) r110.findViewById(R.id.sdpCtaLl);
        TextView r103 = (TextView) r110.findViewById(R.id.sdpCtaTv);
        View r104 = r110.findViewById(R.id.sdpCtaLogoView);
        TextView r105 = (TextView) r110.findViewById(R.id.sdpCancelTv);
        r100.setText(this.f562757a);
        if (TextUtils.isEmpty(this.f562758b) == false) goto L5;
        r101.setVisibility(8);
    L6:
        StateListDrawable r106 = new StateListDrawable();
        float r107 = UIHelper.dp2px(6.0f);
        GradientDrawable r108 = new GradientDrawable();
        r108.setCornerRadius(r107);
        r108.setColor(this.f562759c.getPressedColor(this.f562760d));
        GradientDrawable r109 = new GradientDrawable();
        r109.setCornerRadius(r107);
        r109.setColor(this.f562759c.getNormalColor(this.f562760d));
        r106.addState(new int[]{android.R.attr.state_pressed}, r108);
        r106.addState(StateSet.WILD_CARD, r109);
        r102.setBackground(r106);
        Drawable r111 = this.f562759c.getLogoDrawable(this.f562760d);
        if (r111 == null) goto L9;
        r104.setBackground(r111);
        r104.setVisibility(0);
    L10:
        r103.setTextColor(this.f562759c.getTextColor(this.f562760d));
        r103.setText(this.f562759c.getText(this.f562760d));
        final Runnable r112 = this.f562761e;
        r102.setOnClickListener(new b(r110, r112));
        if (TextUtils.isEmpty(this.f562762f) == false) goto L13;
        r105.setText(UIHelper.getString(R.string.Lark_Invitation_TeamCodeClose));
    L14:
        final Runnable r113 = this.f562763g;
        r105.setOnClickListener(new c(r110, r113));
        return;
    L13:
        r105.setText(this.f562762f);
        goto L14
    L9:
        r104.setVisibility(8);
        goto L10
    L5:
        r101.setText(this.f562758b);
        goto L6
    }

    public d(String r100, String r101, CtaBtnStyle r102, Context r103, u6c.a r104, u6c.b r105) {
        this.f562757a = r100;
        this.f562758b = r101;
        this.f562759c = r102;
        this.f562760d = r103;
        this.f562761e = r104;
        this.f562762f = "";
        this.f562763g = r105;
    }
}
