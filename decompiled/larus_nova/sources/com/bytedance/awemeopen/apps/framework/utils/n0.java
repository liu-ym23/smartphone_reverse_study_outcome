package com.bytedance.awemeopen.apps.framework.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes14.dex */
public final class n0 {

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f197728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f197729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f197730c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f197731d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f197732e;

        @Override // java.lang.Runnable
        public final void run() {
            n0.b(this.f197728a, this.f197729b, this.f197730c, this.f197731d, this.f197732e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Context r100, int r101, String r102, int r103, int r104) {
            this.f197728a = r100;
            this.f197729b = r101;
            this.f197730c = r102;
            this.f197731d = r103;
            this.f197732e = r104;
        }
    }

    public static boolean c(Context r100) {
        if (AppCompatDelegate.getDefaultNightMode() != 2) goto L6;
        return true;
    L6:
        if (AppCompatDelegate.getDefaultNightMode() != 1) goto L10;
        return false;
    L10:
        return d(r100);
    }

    public static boolean d(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getResources() != null) goto L9;
        return false;
    L9:
        if (r100.getResources().getConfiguration() != null) goto L12;
        return false;
    L12:
        if ((r100.getResources().getConfiguration().uiMode & 48) != 32) goto L15;
        return true;
    L15:
        return false;
    }

    public static float a(Context r100, float r101) {
        if (r100 == null) goto L5;
        Resources r102 = r100.getResources();
        return (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
    L5:
        return 0.0f;
    }

    public static void e(View r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 != null) goto L8;
        return;
    L8:
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r103.leftMargin == (-3)) goto L12;
    L18:
        if (r101 == (-3)) goto L20;
        r103.bottomMargin = r101;
    L20:
        r100.setLayoutParams(r103);
        return;
    L12:
        if (r103.topMargin != (-3)) goto L18;
        if (r103.rightMargin != (-3)) goto L18;
        if (r103.bottomMargin != r101) goto L18;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(Context r100, int r101, String r110, int r111, int r112) {
        if (r100 != 0) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r110) == false) goto L7;
        return;
    L7:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L13;
        new Handler(Looper.getMainLooper()).post(new a(r100, r101, r110, r111, r112));
        return;
    L13:
        if ((r100 instanceof u) == false) goto L22;
        if (r111 != 1) goto L16;
        ((u) r100).b();
        return;
    L16:
        ((u) r100).a();
        return;
    L22:
        Toast r103 = Toast.makeText(r100, r110, r111);     // Catch: Exception -> L21
        if (r103 == null) goto L28;
        r103.setGravity(r112, 0, 0);     // Catch: Exception -> L21
        r103.show();     // Catch: Exception -> L21
        return;
    L28:
        return;
    L30:
        return;
    L9:
        r102 = false;
        goto L10
    }
}
