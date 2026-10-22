package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.base.i;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.dialog.v2.alert.style.ImageStyleController;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g extends i<c> {
    public Function2<? super Context, ? super Integer, ? extends ButtonStyleController> A;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f400743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f400744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f400745i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f400746j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f400747k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f400748l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f400749m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f400750n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DialogInterface.OnClickListener f400751o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ButtonStyleController.TextColorType f400752p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f400753q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DialogInterface.OnClickListener f400754r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ButtonStyleController.TextColorType f400755s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f400756t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CharSequence f400757u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public f f400758v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f400759w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public zla.h f400760x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public zla.h f400761y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f400762z;

    @Override // com.obric.oui.dialog.base.i
    public final AbstractDialog b() {
        Context r100 = this.f400743g;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        final c r101 = new c(r100);
        boolean r102 = false;
        if (this.f400746j == false) goto L11;
        CharSequence r103 = this.f400744h;
        if (r103 == null) goto L28;
        TextView r104 = r101.f400739J;
        if (r104 == null) goto L28;
        r104.setVisibility(0);
        r104.setText(r103);
        r104.setPadding(0, pla.d.n(r104, 19), 0, pla.d.n(r104, 19));
    L28:
        CharSequence r105 = this.f400745i;
        Function1<CharSequence, Unit> r106 = new OAlertDialogBuilder$createDialog$1(r101, this);
        if (TextUtils.isEmpty(r105) == true) goto L31;
        Intrinsics.checkNotNull(r105);
        r106.invoke(r105);
    L31:
        zla.h r107 = this.f400761y;
        if (r107 != null) goto L34;
        Unit r108 = null;
    L36:
        if (r108 != null) goto L44;
        this.f400748l.getClass();
        Drawable r109 = this.f400747k;
        if (r109 != null) goto L40;
        ImageStyleController r110 = null;
    L41:
        if (r110 == null) goto L44;
        Intrinsics.checkNotNullParameter(r110, "controller");
        r101.I = r110;
        r110.a(r101.getContext(), r101);
        goto L44
    L40:
        r110 = new ImageStyleController(this.f400743g, 0);
        r110.f400770g = false;
        r110.f400771h = false;
        Intrinsics.checkNotNullParameter(r109, "drawable");
        r110.f400766c = r109;
        r110.f400768e = null;
        r110.f400767d = null;
        r110.f400769f = true;
    L44:
        r101.f400659m = this.f400759w;
        Function2<? super Context, ? super Integer, ? extends ButtonStyleController> r111 = this.A;
        if (r111 != null) goto L47;
        ButtonStyleController r112 = null;
    L48:
        if (r112 != null) goto L50;
        r112 = new zla.e(this.f400743g, this.f400749m);
    L50:
        Intrinsics.checkNotNullParameter(r112, "controller");
        r101.M = r112;
        zla.e r113 = (zla.e) r112;
        r113.a(r101.getContext(), r101);
        zla.h r114 = this.f400760x;
        if (r114 == null) goto L55;
        Intrinsics.checkNotNullParameter(r114, "controller");
        r101.P = r114;
        r101.N.setVisibility(0);
        r114.a(r101.getContext(), r101);
    L55:
        if (this.f400718d == false) goto L57;
    L60:
        r101.f400669w = null;
        r101.setOnShowListener(null);
        r101.setOnDismissListener(this.f400715a);
        r101.setOnCancelListener(null);
        r113.j(this.f400753q, this.f400754r, this.f400755s, this.f400756t);
        r113.h(this.f400750n, this.f400751o, this.f400752p);
        r113.i(this.f400757u, this.f400758v);
        return r101;
    L57:
        if (this.f400749m != 2) goto L59;
        r102 = true;
    L59:
        this.f400718d = r102;
        this.f400716b = null;
        goto L60
    L47:
        r112 = r111.invoke(this.f400743g, Integer.valueOf(this.f400749m));
        goto L48
    L34:
        Intrinsics.checkNotNullParameter(r107, "controller");
        r101.I = r107;
        r107.a(r101.getContext(), r101);
        r108 = Unit.INSTANCE;
        goto L36
    L11:
        CharSequence r115 = this.f400744h;
        boolean r116 = TextUtils.isEmpty(r115);
        TextView r117 = r101.f400739J;
        if (r117 == null) goto L18;
        if (r116 == false) goto L16;
        int r118 = 8;
    L17:
        r117.setVisibility(r118);
        r117.setText(r115);
        r117.setPadding(0, 0, 0, 0);
        goto L18
    L16:
        r118 = 0;
    L18:
        TextView r119 = r101.K;
        if (r119 == null) goto L28;
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();
        if (r120 == null) goto L63;
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;
        if (r116 == false) goto L26;
        int r122 = 0;
    L27:
        r121.topMargin = r122;
        goto L28
    L26:
        r122 = pla.d.n(r119, 8);
        goto L27
    L63:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f400743g = r100;
        this.f400748l = "";
        this.f400759w = true;
        this.f400717c = false;
    }

    public static void c(g r100) {
        r100.f400749m = 0;
        r100.f400756t = false;
    }

    public static void j(g r100) {
        r100.f400749m = 1;
        r100.f400756t = false;
    }

    public static void i(g r100, CharSequence r101) {
        r100.f400746j = false;
        r100.f400744h = r101;
    }

    public final void e(CharSequence r100, final Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f400750n = r100;
        this.f400751o = new e(r101);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.oui.dialog.v2.alert.f] */
    public final void f(CharSequence r100, final Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f400757u = r100;
        this.f400758v = new f(r101);
    }

    public final void h(CharSequence r100, final Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f400753q = r100;
        this.f400754r = new d(r101);
    }

    public final void d(CharSequence r100, DialogInterface.OnClickListener r101, ButtonStyleController.TextColorType r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f400750n = r100;
        this.f400751o = r101;
        this.f400752p = r102;
    }

    public final void g(CharSequence r100, DialogInterface.OnClickListener r101, ButtonStyleController.TextColorType r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f400753q = r100;
        this.f400754r = r101;
        this.f400755s = r102;
    }
}
