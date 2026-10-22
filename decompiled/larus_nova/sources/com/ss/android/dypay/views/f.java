package com.ss.android.dypay.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes34.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f408514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f408515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f408516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f408517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f408518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WeakReference<Context> f408519f;

    public final void b() {
        if (this.f408519f.get() != null) goto L5;
        return;
    L5:
        if ((this.f408519f.get() instanceof Activity) == false) goto L21;
        Context r100 = this.f408519f.get();
        if (r100 == null) goto L17;
        if (((Activity) r100).isFinishing() == true) goto L22;
        b r101 = this.f408514a;     // Catch: Exception -> L14
        if (r101 == null) goto L23;
        a(r101);     // Catch: Exception -> L14
        return;
    L23:
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L22:
        return;
    L17:
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }

    public f(Context r100) {
        WeakReference<Context> r101 = new WeakReference(r100);
        this.f408519f = r101;
        Context r102 = r101.get();
        if (r102 == null) goto L6;
        View r103 = LayoutInflater.from(r102).inflate(R.layout.dypay_loading_view_layout, null);
        this.f408515b = (LinearLayout) r103.findViewById(R.id.ll_dy_brand_loading);
        this.f408516c = (TextView) r103.findViewById(R.id.dy_brand_loading_message);
        this.f408517d = (TextView) r103.findViewById(R.id.dy_brand_loading_sub_message);
        this.f408518e = (ImageView) r103.findViewById(R.id.dy_brand_loading_iv_logo);
        b r104 = new b(r102);
        r104.f408508a = r103;
        r104.setContentView(r103);
        r104.setOnKeyListener(new a());
        r104.setCancelable(false);
        this.f408514a = r104;
        return;
    }

    public static void a(b r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
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

    public final void c(boolean r100) {
        Context r101 = this.f408519f.get();
        if (r101 == null) goto L23;
        if (r100 == false) goto L6;
        float r102 = 32.0f;
    L7:
        if (r100 == false) goto L9;
        float r103 = 24.0f;
    L10:
        ImageView r104 = this.f408518e;
        if (r104 == null) goto L13;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        Resources r106 = r101.getResources();
        r105.height = (int) TypedValue.applyDimension(1, r102, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()));
        ViewGroup.LayoutParams r107 = r104.getLayoutParams();
        Resources r108 = r101.getResources();
        r107.width = (int) TypedValue.applyDimension(1, r102, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()));
    L13:
        LinearLayout r109 = this.f408515b;
        if (r109 == null) goto L16;
        Resources r110 = r101.getResources();
        r109.setPadding(0, (int) TypedValue.applyDimension(1, r103, WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics())), 0, 0);
    L16:
        TextView r111 = this.f408516c;
        if (r111 == null) goto L24;
        if (r100 == false) goto L20;
        float r112 = 13.0f;
    L21:
        r111.setTextSize(r112);
        return;
    L20:
        r112 = 14.0f;
        goto L21
    L24:
        return;
    L9:
        r103 = 20.0f;
        goto L10
    L6:
        r102 = 52.0f;
        goto L7
    }
}
