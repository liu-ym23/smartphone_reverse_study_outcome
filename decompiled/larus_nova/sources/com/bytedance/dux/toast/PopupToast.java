package com.bytedance.dux.toast;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import em4.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class PopupToast implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f205821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f205822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f205823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f205824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f205825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f205826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f205827g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f205828h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f205829i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f205830j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f205831k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function1<? super Boolean, Unit> f205832l;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PopupToast f205833a;

        public a(PopupToast r100) {
            this.f205833a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f205833a.d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void d() {
        if (this.f205821a.isShowing() == false) goto L11;
        h r100 = this.f205821a;     // Catch: Exception -> L8
        if (r100.f205841a == false) goto L12;
        c(r100);     // Catch: Exception -> L8
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.dux.toast.e
    public final void dismiss() {
        d();     // Catch: Exception -> L4
        Unit r100 = Unit.INSTANCE;     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        k.a("Try exception occur " + e.getMessage());
        Unit r101 = Unit.INSTANCE;
    }

    public static View b(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void c(h r100) {
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

    public PopupToast(Context r100, View r101) {
        this.f205825e = r101;
        this.f205827g = new Handler();
        this.f205828h = new a(this);
        this.f205831k = -1;
        this.f205832l = PopupToast$isToastShowing$1.INSTANCE;
        LayoutInflater r102 = LayoutInflater.from(r100);
        Intrinsics.checkNotNull(r100);
        h r103 = new h(r100);
        this.f205821a = r103;
        View r104 = null;
        View r105 = r102.inflate(R.layout.dux_popup_toast, null);     // Catch: Throwable -> L21
        this.f205824d = r105;     // Catch: Throwable -> L21
        if (r105 == null) goto L6;
        ImageView r106 = (ImageView) r105.findViewById(R.id.icon);     // Catch: Throwable -> L21
    L7:
        this.f205822b = r106;     // Catch: Throwable -> L21
        if (r105 == null) goto L10;
        TextView r107 = (TextView) r105.findViewById(R.id.text);     // Catch: Throwable -> L21
    L11:
        this.f205823c = r107;     // Catch: Throwable -> L21
        if (r105 == null) goto L14;
        r104 = r105.findViewById(R.id.toast_container);     // Catch: Throwable -> L21
    L14:
        this.f205826f = r104;     // Catch: Throwable -> L21
        if (r101 == null) goto L17;
        r103.setContentView(r101);     // Catch: Throwable -> L21
    L19:
        Window r108 = r103.getWindow();     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L21
        r108.addFlags(8);     // Catch: Throwable -> L21
        Window r109 = r103.getWindow();     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L21
        r109.addFlags(32);     // Catch: Throwable -> L21
        Window r110 = r103.getWindow();     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L21
        r110.addFlags(16);     // Catch: Throwable -> L21
        Window r111 = r103.getWindow();     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L21
        r111.setLayout(-2, -2);     // Catch: Throwable -> L21
        Window r112 = r103.getWindow();     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L21
        View r113 = b(r112);     // Catch: Throwable -> L21
        float r114 = 10;
        Resources r115 = Resources.getSystem();     // Catch: Throwable -> L21
        int r116 = MathKt.roundToInt(TypedValue.applyDimension(1, r114, WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics())));     // Catch: Throwable -> L21
        Resources r117 = Resources.getSystem();     // Catch: Throwable -> L21
        int r118 = MathKt.roundToInt(TypedValue.applyDimension(1, r114, WindowDisplayMetricsOverride.apply(r117, r117.getDisplayMetrics())));     // Catch: Throwable -> L21
        Resources r119 = Resources.getSystem();     // Catch: Throwable -> L21
        int r120 = MathKt.roundToInt(TypedValue.applyDimension(1, r114, WindowDisplayMetricsOverride.apply(r119, r119.getDisplayMetrics())));     // Catch: Throwable -> L21
        Integer r121 = 10;     // Catch: Throwable -> L21
        float r122 = r121.floatValue();     // Catch: Throwable -> L21
        Resources r123 = Resources.getSystem();     // Catch: Throwable -> L21
        r113.setPadding(r116, r118, r120, MathKt.roundToInt(TypedValue.applyDimension(1, r122, WindowDisplayMetricsOverride.apply(r123, r123.getDisplayMetrics()))));     // Catch: Throwable -> L21
        Window r124 = r103.getWindow();     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r124);     // Catch: Throwable -> L21
        b(r124).setTag("ignore_eye_protection");     // Catch: Throwable -> L21
        Window r125 = r103.getWindow();     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r125);     // Catch: Throwable -> L21
        r125.setGravity(17);     // Catch: Throwable -> L21
        return;
    L17:
        if (r105 == null) goto L19;
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L21
        r103.setContentView(r105);     // Catch: Throwable -> L21
        goto L19
    L10:
        r107 = null;
        goto L11
    L6:
        r106 = null;
    }

    @Override // com.bytedance.dux.toast.e
    public final void a(int r100, int r101) {
        e(0, r101, r100);     // Catch: Exception -> L5
        Unit r102 = Unit.INSTANCE;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        k.a("Try exception occur " + e.getMessage());
        Unit r103 = Unit.INSTANCE;
    }

    public final void e(int r100, int r101, int r102) {
        if (r102 < (-1)) goto L52;
        if (r102 == 0) goto L54;
        ImageView r103 = this.f205822b;
        if (r103 == null) goto L10;
        r103.setVisibility(8);
    L10:
        boolean r104 = true;
        if (TextUtils.isEmpty(null) == true) goto L17;
        TextView r105 = this.f205823c;
        if (r105 == null) goto L16;
        r105.setText(null);
    L16:
        boolean r106 = true;
    L18:
        if (r100 == 0) goto L22;
        TextView r107 = this.f205823c;
        if (r107 == null) goto L29;
        r107.setCompoundDrawablesWithIntrinsicBounds(r100, 0, 0, 0);
    L29:
        if (r104 == false) goto L31;
    L33:
        this.f205827g.removeCallbacks(this.f205828h);
        d();
        Window r108 = this.f205821a.getWindow();     // Catch: Exception -> L44
        Intrinsics.checkNotNull(r108);     // Catch: Exception -> L44
        r108.setGravity(r101);     // Catch: Exception -> L44
        Window r109 = this.f205821a.getWindow();     // Catch: Exception -> L44
        Intrinsics.checkNotNull(r109);     // Catch: Exception -> L44
        WindowManager.LayoutParams r110 = r109.getAttributes();     // Catch: Exception -> L44
        r110.x = this.f205829i;     // Catch: Exception -> L44
        r110.y = this.f205830j;     // Catch: Exception -> L44
        Window r111 = this.f205821a.getWindow();     // Catch: Exception -> L44
        Intrinsics.checkNotNull(r111);     // Catch: Exception -> L44
        r111.setWindowAnimations(R.style.ToastPopupAnim);     // Catch: Exception -> L44
        h r112 = this.f205821a;     // Catch: Exception -> L44
        if (DialogLancet.shouldBlockDialogShow(r112) == false) goto L50;
        DialogLancet.handleBlockedDialogShow(r112);     // Catch: Exception -> L44
    L40:
        this.f205821a.setOnDismissListener(new f(this));     // Catch: Exception -> L44
        this.f205821a.setOnShowListener(new g(this));     // Catch: Exception -> L44
        if (r102 == (-1)) goto L53;
        this.f205827g.postDelayed(this.f205828h, r102);     // Catch: Exception -> L44
        return;
    L53:
        return;
    L50:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L47
    L39:
        DialogLancet.beforeDialogShow(r112);     // Catch: Exception -> L44
        r112.show();     // Catch: Exception -> L44
        DialogLancet.afterDialogShow(r112);     // Catch: Exception -> L44
    L44:
        e = move-exception;
        e.printStackTrace();
        k.a("error occur show popup toast, message = " + e.getMessage());
        return;
    L31:
        if (this.f205825e != null) goto L33;
        return;
    L22:
        int r113 = this.f205831k;
        if (r113 < 0) goto L28;
        View r114 = this.f205826f;
        if (r114 == null) goto L28;
        r114.setMinimumHeight(r113);
    L28:
        r104 = r106;
        goto L29
    L17:
        r106 = false;
        goto L18
    L54:
        return;
    }
}
