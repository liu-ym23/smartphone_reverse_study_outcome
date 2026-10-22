package com.ss.android.lark.widget.dialog.loadingdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.crash.d;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.widget.dialog.loadingdialog.view.AnnularView;
import com.ss.android.lark.widget.dialog.loadingdialog.view.BackgroundLayout;
import com.ss.android.lark.widget.dialog.loadingdialog.view.BarView;
import com.ss.android.lark.widget.dialog.loadingdialog.view.PieView;
import com.ss.android.lark.widget.dialog.loadingdialog.view.SpinView;

/* JADX INFO: loaded from: classes38.dex */
public final class LoadingDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f445780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f445781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f445782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f445783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f445784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f445785f;

    public static final enum Style extends Enum<Style> {
        public static final Style ANNULAR_DETERMINATE = null;
        public static final Style BAR_DETERMINATE = null;
        public static final Style PIE_DETERMINATE = null;
        public static final Style SPIN_INDETERMINATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f445786a = null;

        static {
            Style r100 = new Style("SPIN_INDETERMINATE", 0);
            SPIN_INDETERMINATE = r100;
            Style r101 = new Style("PIE_DETERMINATE", 1);
            PIE_DETERMINATE = r101;
            Style r102 = new Style("ANNULAR_DETERMINATE", 2);
            ANNULAR_DETERMINATE = r102;
            Style r103 = new Style("BAR_DETERMINATE", 3);
            BAR_DETERMINATE = r103;
            f445786a = new Style[]{r100, r101, r102, r103};
        }

        public static Style[] values() {
            return (Style[]) f445786a.clone();
        }

        public static Style valueOf(String r100) {
            return (Style) r27.a.a(Style.class, r100);
        }

        public Style(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f445787a = null;

        static {
            int[] r100 = new int[Style.values().length];
            f445787a = r100;
            r100[Style.SPIN_INDETERMINATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f445787a[Style.PIE_DETERMINATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f445787a[Style.ANNULAR_DETERMINATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f445787a[Style.BAR_DETERMINATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class b extends Dialog {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public gcc.a f445788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public gcc.b f445789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f445790c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TextView f445791d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public TextView f445792e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f445793f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f445794g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public FrameLayout f445795h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public BackgroundLayout f445796i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f445797j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f445798k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f445799l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f445800m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f445801n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f445802o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f445803p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ LoadingDialog f445804q;

        public final void b() {
            ViewGroup.LayoutParams r100 = this.f445796i.getLayoutParams();
            r100.width = UIUtils.dp2px(getContext(), this.f445797j);
            r100.height = UIUtils.dp2px(getContext(), this.f445798k);
            this.f445796i.setLayoutParams(r100);
        }

        public final void c() {
            ViewGroup.LayoutParams r100 = this.f445795h.getLayoutParams();
            r100.width = UIUtils.dp2px(getContext(), this.f445800m);
            r100.height = UIUtils.dp2px(getContext(), this.f445801n);
            this.f445795h.setLayoutParams(r100);
        }

        public final void a(float r100) {
            this.f445799l = r100;
            TextView r101 = this.f445791d;
            if (r101 == null) goto L6;
            r101.setTextSize(r100);
            this.f445791d.setVisibility(0);
            return;
        }

        @Override // android.app.Dialog
        public final void onCreate(Bundle r100) {
            super.onCreate(r100);
            requestWindowFeature(1);
            setContentView(R.layout.loading_dialog_layout);
            Window r101 = getWindow();
            r101.setBackgroundDrawable(new ColorDrawable(0));
            r101.addFlags(2);
            WindowManager.LayoutParams r102 = r101.getAttributes();
            r102.dimAmount = this.f445804q.f445781b;
            r102.gravity = 17;
            r101.setAttributes(r102);
            setCanceledOnTouchOutside(false);
            BackgroundLayout r103 = (BackgroundLayout) findViewById(R.id.background);
            this.f445796i = r103;
            r103.setBaseColor(this.f445804q.f445782c);
            this.f445796i.setCornerRadius(this.f445804q.f445783d);
            if (this.f445797j == 0) goto L5;
            b();
        L5:
            this.f445795h = (FrameLayout) findViewById(R.id.container);
            if (this.f445800m == 0) goto L8;
            c();
        L8:
            View r104 = this.f445790c;
            if (r104 == null) goto L12;
            this.f445795h.addView(r104, new ViewGroup.LayoutParams(-2, -2));
        L12:
            gcc.a r105 = this.f445788a;
            if (r105 == null) goto L15;
            this.f445804q.getClass();
            r105.setMax(0);
        L15:
            gcc.b r106 = this.f445789b;
            if (r106 == null) goto L18;
            r106.setAnimationSpeed(this.f445804q.f445785f);
        L18:
            this.f445791d = (TextView) findViewById(R.id.label);
            float r107 = this.f445799l;
            if (r107 == 0.0f) goto L21;
            a(r107);
        L21:
            String r108 = this.f445793f;
            int r109 = this.f445802o;
            this.f445793f = r108;
            this.f445802o = r109;
            TextView r110 = this.f445791d;
            if (r110 == null) goto L26;
            if (r108 == null) goto L25;
            r110.setText(r108);
            this.f445791d.setTextColor(r109);
            this.f445791d.setVisibility(0);
            goto L26
        L25:
            r110.setVisibility(8);
        L26:
            TextView r111 = (TextView) findViewById(R.id.details_label);
            this.f445792e = r111;
            String r112 = this.f445794g;
            int r113 = this.f445803p;
            this.f445794g = r112;
            this.f445803p = r113;
            if (r111 == null) goto L32;
            if (r112 == null) goto L30;
            r111.setText(r112);
            this.f445792e.setTextColor(r113);
            this.f445792e.setVisibility(0);
            return;
        L30:
            r111.setVisibility(8);
            return;
        }

        public b(LoadingDialog r100, Context r101) {
            this.f445804q = r100;
            super(r101);
            this.f445802o = -1;
            this.f445803p = -1;
        }
    }

    public final void a() {
        b r100 = this.f445780a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L27;
        b r101 = this.f445780a;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L16:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r103 == null) goto L20;
        d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L9:
        if (Looper.myLooper() == r102.getLooper()) goto L11;
        r102.post(DialogLancet.createDismissRunnable(r101));
        return;
    }

    public final boolean b() {
        b r100 = this.f445780a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isShowing() == false) goto L7;
        return true;
    }

    public final void d() {
        if (b() == true) goto L13;
        b r100 = this.f445780a;
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L11;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L11:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
        return;
    }

    public LoadingDialog(Context r100) {
        this.f445784e = r100;
        this.f445780a = new b(this, r100);
        this.f445781b = 0.0f;
        this.f445782c = j08.b.b(r100.getResources().getColor(R.color.lkui_N900), 0.7f);
        this.f445785f = 1;
        this.f445783d = 10.0f;
        c(Style.SPIN_INDETERMINATE);
    }

    public final void c(Style r100) {
        int r101 = a.f445787a[r100.ordinal()];
        if (r101 != 1) goto L5;
        View r102 = new SpinView(this.f445784e);
    L15:
        b r103 = this.f445780a;
        r103.getClass();
        if (r102 != null) goto L18;
        return;
    L18:
        if ((r102 instanceof gcc.a) == false) goto L21;
        r103.f445788a = (gcc.a) r102;
    L21:
        if ((r102 instanceof gcc.b) == false) goto L23;
        r103.f445789b = (gcc.b) r102;
    L23:
        r103.f445790c = r102;
        if (r103.isShowing() == false) goto L28;
        r103.f445795h.removeAllViews();
        ViewGroup.LayoutParams r104 = new ViewGroup.LayoutParams(-2, -2);
        r103.f445795h.addView(r102, r104);
        return;
    L28:
        return;
    L5:
        if (r101 != 2) goto L7;
        r102 = new PieView(this.f445784e);
        goto L15
    L7:
        if (r101 != 3) goto L9;
        r102 = new AnnularView(this.f445784e);
        goto L15
    L9:
        if (r101 == 4) goto L11;
        r102 = null;
        goto L15
    L11:
        r102 = new BarView(this.f445784e);
        goto L15
    }
}
