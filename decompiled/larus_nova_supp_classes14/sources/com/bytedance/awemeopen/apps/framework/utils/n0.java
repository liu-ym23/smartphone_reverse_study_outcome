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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n0 {

    public static class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;

        @Override // java.lang.Runnable
        public final void run() {
            n0.b(this.a, this.b, this.c, this.d, this.e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Context r1, int r2, String r3, int r4, int r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static boolean c(Context r3) {
        if (AppCompatDelegate.getDefaultNightMode() != 2) goto L6;
        return true;
    L6:
        if (AppCompatDelegate.getDefaultNightMode() != 1) goto L10;
        return false;
    L10:
        return d(r3);
    }

    public static boolean d(Context r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.getResources() != null) goto L9;
        return false;
    L9:
        if (r2.getResources().getConfiguration() != null) goto L12;
        return false;
    L12:
        if ((r2.getResources().getConfiguration().uiMode & 48) != 32) goto L15;
        return true;
    L15:
        return false;
    }

    public static float a(Context r1, float r2) {
        if (r1 == null) goto L5;
        Resources r3 = r1.getResources();
        return (r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f;
    L5:
        return 0.0f;
    }

    public static void e(View r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 != null) goto L8;
        return;
    L8:
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1.leftMargin == (-3)) goto L12;
    L18:
        if (r4 == (-3)) goto L20;
        r1.bottomMargin = r4;
    L20:
        r3.setLayoutParams(r1);
        return;
    L12:
        if (r1.topMargin != (-3)) goto L18;
        if (r1.rightMargin != (-3)) goto L18;
        if (r1.bottomMargin != r4) goto L18;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(Context r8, int r9, String r10, int r11, int r12) {
        if (r8 != 0) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return;
    L7:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        new Handler(Looper.getMainLooper()).post(new a(r8, r9, r10, r11, r12));
        return;
    L13:
        if ((r8 instanceof u) == false) goto L22;
        if (r11 != 1) goto L16;
        ((u) r8).b();
        return;
    L16:
        ((u) r8).a();
        return;
    L22:
        Toast r13 = Toast.makeText(r8, r10, r11);     // Catch: Exception -> L21
        if (r13 == null) goto L28;
        r13.setGravity(r12, 0, 0);     // Catch: Exception -> L21
        r13.show();     // Catch: Exception -> L21
        return;
    L28:
        return;
    L30:
        return;
    L9:
        r0 = false;
        goto L10
    }
}
