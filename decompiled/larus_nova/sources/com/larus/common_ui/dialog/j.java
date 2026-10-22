package com.larus.common_ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes27.dex */
public final class j extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f327320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<View> f327321b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f327322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f327323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f327324c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f327325d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f327326e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f327327f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public p0 f327328g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f327329h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f327330i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f327331j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public u f327332k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f327333l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public View f327334m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final float f327335n;

        public final j a() {
            return new j(this.f327322a, new b(this.f327323b, this.f327324c, null, this.f327325d, null, this.f327326e, this.f327327f, this.f327328g, this.f327329h, this.f327330i, this.f327331j, this.f327332k, this.f327333l, null, null, this.f327334m, this.f327335n));
        }

        public final void f() {
            Context r100 = this.f327322a;
            if ((r100 instanceof Activity) == false) goto L5;
            Activity r101 = (Activity) r100;
        L6:
            if (r101 != null) goto L8;
        L12:
            j r102 = a();
            if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L19;
            DialogLancet.handleBlockedDialogShow(r102);
            return;
        L19:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
        L16:
            DialogLancet.beforeDialogShow(r102);
            r102.show();
            DialogLancet.afterDialogShow(r102);
            return;
        L8:
            if (r101.isFinishing() == false) goto L10;
            return;
        L10:
            if (r101.isDestroyed() == false) goto L12;
            return;
        L5:
            r101 = null;
            goto L6
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f327322a = r100;
            this.f327323b = "";
            this.f327324c = "";
            this.f327333l = true;
            this.f327335n = 0.2f;
        }

        public final void d(CharSequence r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f327324c = r100;
        }

        public final void e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.f327323b = r100;
        }

        public static void b(a r100, u r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "listener");
            Intrinsics.checkNotNullParameter(r102, "text");
            r100.f327332k = r101;
            r100.f327329h = r102;
            r100.f327331j = false;
        }

        public final void c(p0 r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            Intrinsics.checkNotNullParameter(r101, "text");
            this.f327328g = r100;
            this.f327325d = r101;
            this.f327327f = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f327336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f327337b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f327338c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f327339d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f327340e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f327341f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Integer f327342g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f327343h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final p0 f327344i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f327345j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Integer f327346k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f327347l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final u f327348m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f327349n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Function0<Boolean> f327350o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final l1 f327351p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final View f327352q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final float f327353r;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f327336a, r101.f327336a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f327337b, r101.f327337b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f327338c, r101.f327338c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f327339d, r101.f327339d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f327340e, r101.f327340e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f327341f, r101.f327341f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f327342g, r101.f327342g) == true) goto L30;
            return false;
        L30:
            if (this.f327343h == r101.f327343h) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f327344i, r101.f327344i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f327345j, r101.f327345j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f327346k, r101.f327346k) == true) goto L42;
            return false;
        L42:
            if (this.f327347l == r101.f327347l) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.f327348m, r101.f327348m) == true) goto L48;
            return false;
        L48:
            if (this.f327349n == r101.f327349n) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.f327350o, r101.f327350o) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.f327351p, r101.f327351p) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.f327352q, r101.f327352q) == true) goto L60;
            return false;
        L60:
            if (Float.compare(this.f327353r, r101.f327353r) == 0) goto L62;
            return false;
        L62:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f327336a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            CharSequence r104 = this.f327337b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.f327338c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.f327339d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f327340e;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            Integer r116 = this.f327341f;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            Integer r119 = this.f327342g;
            if (r119 != null) goto L29;
            int r120 = 0;
        L30:
            int r121 = (r118 + r120) * 31;
            int r122 = 1231;
            if (this.f327343h == false) goto L33;
            int r123 = 1231;
        L34:
            int r124 = (r121 + r123) * 31;
            p0 r125 = this.f327344i;
            if (r125 != null) goto L37;
            int r126 = 0;
        L38:
            int r127 = (r124 + r126) * 31;
            String r128 = this.f327345j;
            if (r128 != null) goto L41;
            int r129 = 0;
        L42:
            int r130 = (r127 + r129) * 31;
            Integer r131 = this.f327346k;
            if (r131 != null) goto L45;
            int r132 = 0;
        L46:
            int r133 = (r130 + r132) * 31;
            if (this.f327347l == false) goto L49;
            int r134 = 1231;
        L50:
            int r135 = (r133 + r134) * 31;
            u r136 = this.f327348m;
            if (r136 != null) goto L53;
            int r137 = 0;
        L54:
            int r138 = (r135 + r137) * 31;
            if (this.f327349n == true) goto L58;
            r122 = 1237;
        L58:
            int r139 = (r138 + r122) * 31;
            Function0<Boolean> r140 = this.f327350o;
            if (r140 != null) goto L61;
            int r141 = 0;
        L62:
            int r142 = (r139 + r141) * 31;
            l1 r143 = this.f327351p;
            if (r143 != null) goto L65;
            int r144 = 0;
        L66:
            int r145 = (r142 + r144) * 31;
            View r146 = this.f327352q;
            if (r146 == null) goto L71;
            r101 = r146.hashCode();
        L71:
            return ((r145 + r101) * 31) + Float.floatToIntBits(this.f327353r);
        L65:
            r144 = r143.hashCode();
            goto L66
        L61:
            r141 = r140.hashCode();
            goto L62
        L53:
            r137 = r136.hashCode();
            goto L54
        L49:
            r134 = 1237;
            goto L50
        L45:
            r132 = r131.hashCode();
            goto L46
        L41:
            r129 = r128.hashCode();
            goto L42
        L37:
            r126 = r125.hashCode();
            goto L38
        L33:
            r123 = 1237;
            goto L34
        L29:
            r120 = r119.hashCode();
            goto L30
        L25:
            r117 = r116.hashCode();
            goto L26
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Model(title=" + this.f327336a + ", message=" + this.f327337b + ", messageColor=" + this.f327338c + ", linkTextColor=" + this.f327339d + ", confirmText=" + this.f327340e + ", confirmTextColor=" + this.f327341f + ", confirmButtonColor=" + this.f327342g + ", confirmBold=" + this.f327343h + ", confirmClickListener=" + this.f327344i + ", cancelText=" + this.f327345j + ", cancelTextColor=" + this.f327346k + ", cancelBold=" + this.f327347l + ", cancelClickListener=" + this.f327348m + ", canceledOnTouchOutside=" + this.f327349n + ", backListener=" + this.f327350o + ", whiteClickListener=" + this.f327351p + ", alignTargetView=" + this.f327352q + ", dimAmount=" + this.f327353r + ')';
        }

        public b(String r100, CharSequence r101, Integer r102, String r103, Integer r104, Integer r105, boolean r106, p0 r110, String r111, Integer r112, boolean r113, u r114, boolean r115, Function0 r116, l1 r117, View r118, float r119) {
            this.f327336a = r100;
            this.f327337b = r101;
            this.f327338c = r102;
            this.f327339d = null;
            this.f327340e = r103;
            this.f327341f = r104;
            this.f327342g = r105;
            this.f327343h = r106;
            this.f327344i = r110;
            this.f327345j = r111;
            this.f327346k = r112;
            this.f327347l = r113;
            this.f327348m = r114;
            this.f327349n = r115;
            this.f327350o = r116;
            this.f327351p = r117;
            this.f327352q = r118;
            this.f327353r = r119;
        }
    }

    public static void a(j r100) {
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

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        setContentView(R.layout.larus_dialog_common_aligned);
        Window r100 = getWindow();
        if (r100 == null) goto L5;
        r100.setBackgroundDrawable(new ColorDrawable(0));
    L5:
        Window r101 = getWindow();
        if (r101 == null) goto L8;
        r101.addFlags(2);
    L8:
        Window r102 = getWindow();
        if (r102 == null) goto L11;
        r102.setDimAmount(this.f327320a.f327353r);
    L11:
        setCanceledOnTouchOutside(this.f327320a.f327349n);
        setOnKeyListener(new f(this));
        Window r103 = getWindow();
        if (r103 == null) goto L20;
        View r104 = r103.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L18;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r105 = ThreadMethodProxy.currentThread();
        if (r105 == com.larus.home.impl.utils.c.f346341a) goto L18;
        com.larus.home.impl.utils.c.a(r105, "getDecorView");
    L18:
        if (r104 == null) goto L20;
        r104.setOnTouchListener(new g(this));
    L20:
        TextView r106 = (TextView) findViewById(R.id.dialog_title);
        TextView r107 = (TextView) findViewById(R.id.dialog_message);
        TextView r108 = (TextView) findViewById(R.id.confirm);
        TextView r109 = (TextView) findViewById(R.id.cancel);
        r106.setText(this.f327320a.f327336a);
        String r111 = this.f327320a.f327336a;
        if (r111 != null) goto L23;
    L26:
        boolean r112 = true;
    L28:
        if (r112 == false) goto L30;
        int r113 = 8;
    L31:
        r106.setVisibility(r113);
        r107.setText(this.f327320a.f327337b);
        CharSequence r114 = this.f327320a.f327337b;
        if (r114 != null) goto L34;
    L37:
        boolean r115 = true;
    L38:
        if (r115 == false) goto L40;
        int r116 = 8;
    L41:
        r107.setVisibility(r116);
        if ((this.f327320a.f327337b instanceof SpannableString) == false) goto L44;
        r107.setMovementMethod(LinkMovementMethod.getInstance());
        r107.setHighlightColor(0);
    L44:
        Integer r117 = this.f327320a.f327339d;
        if (r117 == null) goto L47;
        r107.setLinkTextColor(r117.intValue());
    L47:
        Integer r118 = this.f327320a.f327338c;
        if (r118 == null) goto L50;
        r107.setTextColor(r118.intValue());
    L50:
        r108.setText(this.f327320a.f327340e);
        Integer r119 = this.f327320a.f327341f;
        if (r119 == null) goto L53;
        r108.setTextColor(r119.intValue());
    L53:
        Integer r120 = this.f327320a.f327342g;
        if (r120 == null) goto L57;
        r108.setBackgroundTintList(ColorStateList.valueOf(r120.intValue()));
    L57:
        if (this.f327320a.f327343h == false) goto L59;
        r108.setTypeface(Typeface.DEFAULT_BOLD);
    L59:
        r108.setOnClickListener(new h(this));
        b r121 = this.f327320a;
        if (r121.f327348m == null) goto L77;
        String r122 = r121.f327345j;
        if (r122 != null) goto L64;
    L67:
        boolean r123 = true;
    L68:
        if (r123 == true) goto L77;
        r109.setText(this.f327320a.f327345j);
        Integer r124 = this.f327320a.f327346k;
        if (r124 == null) goto L74;
        r109.setTextColor(r124.intValue());
    L74:
        if (this.f327320a.f327347l == false) goto L76;
        r109.setTypeface(Typeface.DEFAULT_BOLD);
    L76:
        r109.setOnClickListener(new i(this));
    L84:
        if (this.f327320a.f327352q != null) goto L86;
        WeakReference<View> r125 = null;
    L87:
        this.f327321b = r125;
        Intrinsics.checkNotNull(r106);
        Intrinsics.checkNotNull(r107);
        WeakReference<View> r126 = this.f327321b;
        if (r126 == null) goto L90;
        View r127 = r126.get();
    L91:
        Window r128 = getWindow();
        if (r128 == null) goto L124;
        Resources r129 = getContext().getResources();
        int r130 = Math.min(WindowDisplayMetricsOverride.apply(r129, r129.getDisplayMetrics()).widthPixels - (r129.getDimensionPixelSize(v19.c.b(R.attr.larus_dp_32, null, R.dimen.larus_dp_32)) * 2), r129.getDimensionPixelSize(v19.c.b(R.attr.larus_dp_400, null, R.dimen.larus_dp_400)));
        if (r127 != null) goto L97;
    L121:
        WindowManager.LayoutParams r131 = r128.getAttributes();
        r131.width = r130;
        r131.height = -2;
        r131.gravity = 17;
        r128.setAttributes(r131);
        return;
    L97:
        if (r127.isShown() == false) goto L121;
        if (r127.getWindowToken() == null) goto L121;
        Resources r132 = getContext().getResources();
        int[] r133 = new int[2];
        r127.getLocationOnScreen(r133);
        float r134 = r133[1] + (r127.getHeight() / 2.0f);
        int r135 = r130 - (r132.getDimensionPixelSize(v19.c.b(R.attr.larus_dp_24, null, R.dimen.larus_dp_24)) * 2);
        String r136 = this.f327320a.f327336a;
        if (r136 != null) goto L104;
    L107:
        boolean r137 = true;
    L108:
        float r138 = 0.0f;
        if (r137 == true) goto L111;
        int r139 = r132.getDimensionPixelSize(v19.c.b(R.attr.larus_dp_24, null, R.dimen.larus_dp_24));
        r106.measure(View.MeasureSpec.makeMeasureSpec(r135, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        r138 = (r139 + r106.getMeasuredHeight()) + 0.0f;
    L111:
        CharSequence r140 = this.f327320a.f327337b;
        if (r140 != null) goto L114;
    L117:
        boolean r141 = true;
    L118:
        if (r141 == true) goto L120;
        int r142 = r132.getDimensionPixelSize(v19.c.b(R.attr.larus_dp_8, null, R.dimen.larus_dp_8));
        r107.measure(View.MeasureSpec.makeMeasureSpec(r135, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        r138 = r138 + (r142 + r107.getMeasuredHeight());
    L120:
        float r143 = (r138 + r132.getDimensionPixelSize(v19.c.b(R.attr.larus_dp_24, null, R.dimen.larus_dp_24))) + (r132.getDimensionPixelSize(v19.c.b(R.attr.larus_dp_56, null, R.dimen.larus_dp_56)) / 2.0f);
        com.larus.utils.i0.f375410a.getClass();
        int r144 = MathKt.roundToInt((r134 - com.larus.utils.i0.g()) - r143);
        WindowManager.LayoutParams r145 = r128.getAttributes();
        r145.width = r130;
        r145.height = -2;
        r145.gravity = 49;
        r145.y = r144;
        r128.setAttributes(r145);
        return;
    L114:
        if (r140.length() == 0) goto L117;
        r141 = false;
        goto L118
    L104:
        if (r136.length() == 0) goto L107;
        r137 = false;
        goto L108
    L124:
        return;
    L90:
        r127 = null;
        goto L91
    L86:
        r125 = new WeakReference(this.f327320a.f327352q);
        goto L87
    L64:
        if (r122.length() == 0) goto L67;
        r123 = false;
    L77:
        r109.setVisibility(8);
        ViewGroup.LayoutParams r146 = r108.getLayoutParams();
        if ((r146 instanceof ViewGroup.MarginLayoutParams) == false) goto L80;
        ViewGroup.MarginLayoutParams r147 = (ViewGroup.MarginLayoutParams) r146;
    L81:
        if (r147 == null) goto L84;
        r147.bottomMargin = getContext().getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_16, getContext(), R.dimen.larus_dp_16));
        r108.setLayoutParams(r147);
        goto L84
    L80:
        r147 = null;
        goto L81
    L40:
        r116 = 0;
        goto L41
    L34:
        if (r114.length() == 0) goto L37;
        r115 = false;
        goto L38
    L30:
        r113 = 0;
        goto L31
    L23:
        if (r111.length() == 0) goto L26;
        r112 = false;
        goto L28
    }

    public j(Context r100, b r101) {
        super(r100);
        this.f327320a = r101;
        requestWindowFeature(1);
        setCancelable(true);
    }
}
