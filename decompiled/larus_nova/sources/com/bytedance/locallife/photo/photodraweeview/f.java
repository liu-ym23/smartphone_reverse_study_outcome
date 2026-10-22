package com.bytedance.locallife.photo.photodraweeview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.photo.internal.photodraweeview.DismissAnimationType;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes21.dex */
public final class f extends ux6.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final vx6.b f262108j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.locallife.photo.photodraweeview.a f262109k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f262110l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.locallife.photo.photopage.view.a f262111m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f262112n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f262113o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f262114p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f262115q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RecyclerView.LayoutManager f262116r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final g f262117s;

    public static final class a {
    }

    static {
    }

    @Override // ux6.c, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        this.f552004a.onDestroy();
        Activity r100 = em4.a.getActivity(getContext());     // Catch: Exception -> L8
        if (r100 == null) goto L6;
        ImmersionBar.with(r100, this).destroy();     // Catch: Exception -> L8
    L6:
        EventCenter.unregisterJsEventSubscriber("pdp_head_image_on_tab_change", this.f262117s);     // Catch: Exception -> L8
    L10:
        com.bytedance.locallife.photo.photodraweeview.a r101 = this.f262109k;
        if (r101 == null) goto L13;
        r101.onDialogDismiss();
    L13:
        Handler r102 = DialogLancet.resolveDialogHandler(this);
        if (r102 != null) goto L16;
    L18:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L21 Exception -> L23
    L27:
        DialogLancet.afterDialogDismiss(this);
        return;
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L21
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L21
        if (r103 == null) goto L27;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L16:
        if (Looper.myLooper() == r102.getLooper()) goto L18;
        r102.post(DialogLancet.createDismissRunnable(this));
        return;
    L8:
        e = move-exception;
        HostServiceUtilsKt.c().a(e);
        goto L10
    }

    @Override // ux6.c, android.app.Dialog
    public final void onBackPressed() {
        Activity r100 = em4.a.getActivity(getContext());
        if (r100 != null) goto L5;
    L7:
        super.onBackPressed();
        return;
    L5:
        if (r100.getRequestedOrientation() != 0) goto L7;
        r100.setRequestedOrientation(1);
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        this.f262112n = this.f552008e;
        if (this.f262108j == null) goto L10;
        Intrinsics.checkNotNullParameter("dialog_show", "event");
    L10:
        com.bytedance.locallife.photo.photodraweeview.a r100 = this.f262109k;
        if (r100 == null) goto L22;
        r100.a();
    L22:
        Activity r101 = em4.a.getActivity(getContext());     // Catch: Exception -> L18
        if (r101 == null) goto L16;
        ImmersionBar.with(r101, this).statusBarColor(R.color.Transparent).statusBarDarkFont(false).init();     // Catch: Exception -> L18
    L16:
        EventCenter.registerJsEventSubscriber("pdp_head_image_on_tab_change", this.f262117s);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        HostServiceUtilsKt.c().a(e);
        return;
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // ux6.c, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.f262110l == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 30) goto L18;
        Window r101 = getWindow();
        if (r101 == null) goto L19;
        View r102 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L13;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L13;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L13:
        WindowInsetsControllerCompat r104 = ViewCompat.getWindowInsetsController(r102);
        if (r104 == null) goto L20;
        r104.setSystemBarsBehavior(2);
        r101.setStatusBarColor(0);
        r104.hide(WindowInsetsCompat.Type.statusBars());
        return;
    L20:
        return;
    L19:
        return;
    }

    public f(Context r100, PoiPhotoTransitionPagerAdapter r101, boolean r102, com.bytedance.locallife.photo.photodraweeview.a r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = true;
    L6:
        if ((r104 & 8) == 0) goto L8;
        int r105 = R.drawable.poi_ic_close;
    L10:
        if ((r104 & 32) == 0) goto L12;
        r103 = null;
    L12:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "transitionAdapter");
        super(r100, r101);
        this.f262108j = null;
        this.f262109k = r103;
        this.f262110l = false;
        this.f262112n = -1;
        this.f552005b.addOnScrollListener(new PoiPreviewDialog$1(this));
        if (r102 == false) goto L17;
        ImageView r106 = new ImageView(r100);
        r106.setImageResource(r105);
        r106.setContentDescription("关闭");
        r106.setOnClickListener(new e(this));
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);
        Resources r108 = Resources.getSystem();
        r107.leftMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics())));
        Resources r109 = Resources.getSystem();
        r107.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 60, WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics())));
        FrameLayout r110 = this.f552006c;
        if (r110 == null) goto L17;
        r110.addView(r106, r107);
    L17:
        Intrinsics.checkNotNullParameter(DismissAnimationType.BG_ALPHA_IMG_ALPHA, "<set-?>");
        this.f262117s = new g(r101, this);
        return;
    L8:
        r105 = 0;
        goto L10
    }
}
