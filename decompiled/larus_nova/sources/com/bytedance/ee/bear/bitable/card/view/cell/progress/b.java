package com.bytedance.ee.bear.bitable.card.view.cell.progress;

import android.app.Dialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.camera.video.AudioStats;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableTextFieldEditor;
import com.bytedance.ee.bear.bitable.common.WatermarkUtils;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.m0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;
import yp4.g;
import yp4.h;
import yp4.j;

/* JADX INFO: loaded from: classes15.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f207962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitableAnalytic f207963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f207964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Dialog f207965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CommonActionPanelLayout f207966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AppCompatSeekBar f207967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BitableTextFieldEditor f207968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f207969h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.view.cell.number.a f207970i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f207971j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup f207972k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f207973l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FieldConfigMetaModel.CommonColor f207974m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Double f207975n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Double f207976o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Double f207977p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f207978q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f207979r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f207980s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f207981t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f207982u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public a f207983v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f207984w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f207985x;

    public interface a {
        void a();

        String getPanelTitle();

        void h1(Double r100, String r101);
    }

    public final void c() {
        this.f207980s = false;
        com.bytedance.ee.bear.bitable.card.view.cell.number.a r100 = this.f207970i;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.f207923c != true) goto L7;
    L8:
        if (r101 == false) goto L11;
        if (r100 == null) goto L11;
        r100.c(false);
    L11:
        BitableTextFieldEditor r102 = this.f207968g;
        if (r102 == null) goto L14;
        r102.clearFocus();
    L14:
        TextView r103 = this.f207969h;
        if (r103 == null) goto L17;
        r103.setVisibility(0);
    L17:
        Double r104 = this.f207977p;
        if (r104 == null) goto L21;
        double r105 = r104.doubleValue();
        String r106 = j.e(this.f207973l, r105);
        if (r106 == null) goto L21;
    L22:
        TextView r107 = this.f207969h;
        if (r107 == null) goto L25;
        r107.setText(Editable.Factory.getInstance().newEditable(r106));
    L25:
        j(false);
        return;
    L21:
        r106 = "";
    L7:
        r101 = false;
        goto L8
    }

    public final void dismiss() {
        com.bytedance.ee.bear.bitable.card.view.cell.number.a r100 = this.f207970i;
        if (r100 != null) goto L5;
    L13:
        a r101 = this.f207983v;
        if (r101 == null) goto L16;
        r101.h1(this.f207977p, this.f207984w);
    L16:
        c();
        Dialog r102 = this.f207965d;
        if (r102 == null) goto L35;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L21;
    L23:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L26 Exception -> L28
    L32:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L26:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L28:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L26
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L26
        if (r104 == null) goto L32;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L26
        goto L32
    L21:
        if (Looper.myLooper() == r103.getLooper()) goto L23;
        r103.post(DialogLancet.createDismissRunnable(r102));
        return;
    L35:
        return;
    L5:
        if (r100 == null) goto L9;
        boolean r105 = true;
        if (r100.f207923c != true) goto L9;
    L10:
        if (r105 == false) goto L13;
        if (r100 == null) goto L13;
        r100.c(false);
    L9:
        r105 = false;
        goto L10
    }

    public final void e() {
        Double r100 = this.f207977p;
        if (r100 == null) goto L24;
        BigDecimal r101 = BigDecimal.valueOf(r100.doubleValue());
        Double r102 = this.f207976o;
        if (r102 == null) goto L7;
        BigDecimal r103 = BigDecimal.valueOf(r102.doubleValue());
    L9:
        if (r101.compareTo(r103) != 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L16;
        AppCompatSeekBar r105 = this.f207967f;
        if (r105 == null) goto L25;
        r105.setProgress(this.f207979r - this.f207978q);
        return;
    L25:
        return;
    L16:
        AppCompatSeekBar r106 = this.f207967f;
        if (r106 == null) goto L27;
        Double r107 = this.f207977p;
        if (r107 == null) goto L21;
        double r108 = r107.doubleValue();
    L22:
        r106.setProgress((int) (r108 - ((double) this.f207978q)));
        return;
    L21:
        r108 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L22
    L27:
        return;
    L11:
        r104 = false;
        goto L12
    L7:
        r103 = null;
        goto L9
    }

    public final void i() {
        AppCompatSeekBar r100 = this.f207967f;
        Integer r101 = null;
        if (r100 == null) goto L5;
        Drawable r102 = r100.getProgressDrawable();
    L6:
        LayerDrawable r103 = (LayerDrawable) r102;
        if (r103 == null) goto L23;
        int r104 = r103.getNumberOfLayers();
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L28;
        if (r103.getId(r105) == 16908301) goto L12;
        r105 = r105 + 1;
        goto L9
    L12:
        Double r106 = this.f207977p;
        if (r106 == null) goto L19;
        r106.doubleValue();
        Double r107 = this.f207977p;
        if (r107 == null) goto L17;
        double r108 = r107.doubleValue();
    L18:
        int r109 = this.f207978q;
        r101 = Integer.valueOf(j.c(((r108 - ((double) r109)) * ((double) 100)) / ((double) (this.f207979r - r109)), this.f207974m));
        goto L19
    L17:
        r108 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L19:
        Drawable r110 = r103.getDrawable(r105);
        if (r101 == null) goto L26;
        r110.setColorFilter(r101.intValue(), PorterDuff.Mode.SRC_ATOP);
        return;
    L26:
        return;
    L28:
        return;
    L23:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public void show() {
        if (this.f207965d != null) goto L63;
        CommonActionPanelLayout r100 = new CommonActionPanelLayout(this.f207962a);
        a r101 = this.f207983v;
        if (r101 == null) goto L7;
        String r102 = r101.getPanelTitle();
    L8:
        r100.setTitle(r102);
        r100.setPanelBackgroundColor(R.color.bg_float);
        int r103 = 0;
        r100.setDividerVisible(false);
        r100.setLeftIconVisible(false);
        r100.h(this.f207962a.getString(R.string.Bitable_Common_ButtonDone), Integer.valueOf(R.color.primary_fill_default));
        r100.setOnActionListener(new c(this));
        this.f207966e = r100;
        View r104 = LayoutInflater.from(this.f207962a).inflate(R.layout.bitable_card_progress_edit_panel, null);
        ViewGroup.MarginLayoutParams r105 = new ViewGroup.MarginLayoutParams(-1, -2);
        this.f207967f = (AppCompatSeekBar) r104.findViewById(R.id.seekbar);
        this.f207968g = (BitableTextFieldEditor) r104.findViewById(R.id.progress_edt);
        this.f207969h = (TextView) r104.findViewById(R.id.unfocused_progress_tip);
        this.f207971j = (ViewGroup) r104.findViewById(R.id.edit_layout);
        this.f207972k = (ViewGroup) r104.findViewById(R.id.numberPlaceHolder);
        rcb.c.b(this.f207968g);
        Double r106 = this.f207975n;
        if (r106 == null) goto L11;
        this.f207978q = (int) Math.floor(r106.doubleValue());
    L11:
        Double r107 = this.f207976o;
        if (r107 == null) goto L14;
        this.f207979r = (int) Math.ceil(r107.doubleValue());
    L14:
        AppCompatSeekBar r108 = this.f207967f;
        if (r108 == null) goto L17;
        r108.setMax(this.f207979r - this.f207978q);
    L17:
        BitableTextFieldEditor r109 = this.f207968g;
        if (r109 == null) goto L20;
        r109.addTextChangedListener(new yp4.d(this));
    L20:
        AppCompatSeekBar r110 = this.f207967f;
        if (r110 == null) goto L23;
        r110.setOnSeekBarChangeListener(new yp4.e(this));
    L23:
        BitableTextFieldEditor r111 = this.f207968g;
        if (r111 == null) goto L26;
        r111.setOnFocusChangeListener(new yp4.f(this));
    L26:
        BitableTextFieldEditor r112 = this.f207968g;
        if (r112 == null) goto L29;
        r112.setOnClickListener(new g(this));
    L29:
        TextView r113 = this.f207969h;
        if (r113 == null) goto L32;
        r113.setOnClickListener(new h(this));
    L32:
        CommonActionPanelLayout r114 = this.f207966e;
        if (r114 == null) goto L35;
        r114.addView(r104, r105);
    L35:
        Object r115 = r104.getParent();
        if ((r115 instanceof View) == false) goto L38;
        View r116 = (View) r115;
    L39:
        if (r116 == null) goto L42;
        r116.setMinimumHeight((int) (((double) n.r(this.f207962a)) * 0.25d));
    L42:
        if (ku5.c.k(this.f207962a) == false) goto L44;
        int r117 = R.style.CustomPadBottomSheetDialog;
    L45:
        CommonActionPanelLayout r118 = this.f207966e;
        if (r118 == null) goto L60;
        Dialog r119 = new Dialog(this.f207962a, r117);
        r119.setContentView(r118);
        Window r120 = r119.getWindow();
        if (r120 == null) goto L54;
        r118.measure(0, 0);
        WindowManager.LayoutParams r121 = r120.getAttributes();
        r121.width = -1;
        r121.dimAmount = 0.0f;
        int r122 = r118.getMeasuredHeight() + m0.a(r119.getContext());
        ViewGroup r123 = this.f207972k;
        if (r123 == null) goto L52;
        r103 = r123.getMeasuredHeight();
    L52:
        int r124 = r122 - r103;
        this.f207981t = r124;
        this.f207982u = r122;
        r121.height = r124 + m0.a(r120.getContext());
        r121.gravity = 80;
        r120.setAttributes(r121);
    L54:
        if (com.bytedance.ee.bear.bitable.utils.g.b() == false) goto L56;
        WatermarkUtils.a(null, r119);
    L57:
        this.f207965d = r119;
        r119.setOnDismissListener(new d(this));
        Dialog r125 = this.f207965d;
        if (r125 == null) goto L60;
        r125.setOnShowListener(new yp4.c(this));
        goto L60
    L56:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(r119);
    L60:
        ViewGroup r126 = this.f207972k;
        if (r126 == null) goto L63;
        r126.setVisibility(8);
        goto L63
    L44:
        r117 = R.style.CustomBottomSheetDialog;
        goto L45
    L38:
        r116 = null;
        goto L39
    L7:
        r102 = null;
    L63:
        Dialog r127 = this.f207965d;
        if (r127 != null) goto L66;
    L70:
        this.f207984w = "none";
        TextView r128 = this.f207969h;
        if (r128 == null) goto L73;
        r128.setVisibility(8);
    L73:
        BitableTextFieldEditor r129 = this.f207968g;
        if (r129 == null) goto L76;
        r129.requestFocus();
    L76:
        e();
        i();
        return;
    L66:
        if (DialogLancet.shouldBlockDialogShow(r127) == false) goto L79;
        DialogLancet.handleBlockedDialogShow(r127);
        goto L70
    L79:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L78
    L69:
        DialogLancet.beforeDialogShow(r127);
        r127.show();
        DialogLancet.afterDialogShow(r127);
        goto L70
    }

    public final Context getContext() {
        return this.f207962a;
    }

    public static final void a(b r100) {
        if (r100.f207980s == true) goto L33;
        boolean r101 = false;
        if (r100.f207970i != null) goto L8;
        com.bytedance.ee.bear.bitable.card.view.cell.number.a r102 = new com.bytedance.ee.bear.bitable.card.view.cell.number.a(r100.f207962a, false);
        r100.f207970i = r102;
        r102.f207924d = new yp4.a(r100);
        r102.f207925e = new yp4.b(r100);
    L8:
        com.bytedance.ee.bear.bitable.card.view.cell.number.a r103 = r100.f207970i;
        if (r103 != null) goto L11;
    L13:
        if (r101 == false) goto L20;
        if (r103 == null) goto L20;
        ViewGroup r104 = r100.f207971j;
        BitableTextFieldEditor r105 = r100.f207968g;
        if (r105 == null) goto L18;
        Editable r106 = r105.getText();
    L19:
        r103.d(r104, r106);
        goto L20
    L18:
        r106 = null;
    L20:
        Double r107 = r100.f207977p;
        if (r107 == null) goto L24;
        String r108 = j.l(BigDecimal.valueOf(r107.doubleValue()).toPlainString());
        if (r108 == null) goto L24;
    L25:
        BitableTextFieldEditor r109 = r100.f207968g;
        if (r109 == null) goto L28;
        r109.setText(Editable.Factory.getInstance().newEditable(r108));
    L28:
        BitableTextFieldEditor r110 = r100.f207968g;
        if (r110 == null) goto L31;
        r110.setSelection(String.valueOf(r110.getText()).length());
    L31:
        r100.f207980s = true;
        r100.j(true);
        return;
    L24:
        r108 = "";
        goto L25
    L11:
        if (r103.f207923c == true) goto L13;
        r101 = true;
        goto L13
    }

    public final void j(boolean r100) {
        Dialog r101 = this.f207965d;
        Context r102 = null;
        if (r101 == null) goto L7;
        Window r103 = r101.getWindow();
        if (r103 == null) goto L7;
        WindowManager.LayoutParams r104 = r103.getAttributes();
    L8:
        Dialog r105 = this.f207965d;
        if (r105 == null) goto L11;
        r102 = r105.getContext();
    L11:
        if (r104 == null) goto L22;
        if (r102 == null) goto L23;
        if (r100 == false) goto L15;
        int r106 = this.f207982u;
    L16:
        r104.height = r106;
        r104.height = r106 + m0.a(r102);
        Dialog r107 = this.f207965d;
        if (r107 == null) goto L24;
        Window r108 = r107.getWindow();
        if (r108 == null) goto L25;
        r108.setAttributes(r104);
        return;
    L25:
        return;
    L24:
        return;
    L15:
        r106 = this.f207981t;
        goto L16
    L23:
        return;
    L22:
        return;
    L7:
        r104 = null;
        goto L8
    }

    public b(Context r100, BitableAnalytic r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f207962a = r100;
        this.f207963b = r101;
        this.f207964c = "ProgressEditPanel";
        this.f207979r = 100;
        this.f207984w = "none";
    }

    public void d(Double r100, boolean r101) {
        this.f207977p = r100;
    }
}
