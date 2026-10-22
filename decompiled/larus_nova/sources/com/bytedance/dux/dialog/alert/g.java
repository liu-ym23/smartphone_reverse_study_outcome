package com.bytedance.dux.dialog.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.dux.button.DuxButton;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g extends ql4.b<d> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f204938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f204939h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f204940i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f204941j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f204942k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DialogInterface.OnClickListener f204943l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ButtonStyleController.TextColorType f204944m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f204945n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DialogInterface.OnClickListener f204946o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ButtonStyleController.TextColorType f204947p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f204948q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f204949r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f204950s;

    @Override // ql4.b
    public final d b() {
        final d r100 = new d(this.f204938g);
        e(this.f204939h, new DuxAlertDialogBuilder$createDialog$1(r100));
        e(this.f204940i, new DuxAlertDialogBuilder$createDialog$2(r100, this));
        this.f204941j.getClass();
        r100.f204935r = this.f204948q;
        if (this.f533771d == true) goto L5;
        this.f533771d = false;
        this.f533768a = null;
    L5:
        r100.setOnShowListener(null);
        r100.setOnDismissListener(null);
        r100.setOnCancelListener(this.f533769b);
        final ButtonStyleController r101 = new ButtonStyleController(this.f204938g);
        Intrinsics.checkNotNullParameter(r101, "controller");
        r100.f204933p = r101;
        FrameLayout r102 = r100.f204932o;
        if (r102 == null) goto L8;
        Context r103 = r100.getContext();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "parent");
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-1, -2);
        View r105 = LayoutInflater.from(r103).inflate(R.layout.dux_dialog_button_horizontal_new, r102, false);
        r102.addView(r105, r104);
        r101.f204912b = (DuxButton) r105.findViewById(R.id.actionPositive);
        r101.f204913c = (DuxButton) r105.findViewById(R.id.actionNegative);
        r101.f204916f = r105.findViewById(R.id.divider_line_middle);
        r101.f204914d = (DuxButton) r105.findViewById(R.id.actionNeutral);
        r101.f204915e = r105.findViewById(R.id.divider_line_neutral);
        r101.f204918h = (FrameLayout) r105.findViewById(R.id.custom_container);
        r101.f204919i = (LinearLayout) r105.findViewById(R.id.bottom_container_primary);
    L8:
        e(this.f204945n, new DuxAlertDialogBuilder$createDialog$6(r101, this));
        e(this.f204942k, new DuxAlertDialogBuilder$createDialog$7(r101, this));
        e(null, new DuxAlertDialogBuilder$createDialog$8(r101, this));
        return r100;
    }

    public g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f204938g = r100;
        this.f204941j = "";
        this.f204948q = true;
        this.f204950s = Integer.MAX_VALUE;
        this.f533770c = false;
    }

    public static void e(CharSequence r100, Function1 r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        Intrinsics.checkNotNull(r100);
        r101.invoke(r100);
        return;
    }

    public static void d(g r100, CharSequence r101, DialogInterface.OnClickListener r102) {
        Intrinsics.checkNotNullParameter(r101, "text");
        r100.f204942k = r101;
        r100.f204943l = r102;
        r100.f204944m = null;
    }
}
