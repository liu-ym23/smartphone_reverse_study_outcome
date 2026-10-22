package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import com.bytedance.supervisor.token.Token;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.quality.BlankScreenConfig;
import com.ss.android.lark.officewebview.quality.PixelCopyCropRectConfig;
import com.ss.android.lark.officewebview.quality.WebViewOptimizeConfig;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f411229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f411230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f411231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f411232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f411233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f411234f;

    public c() {
        this.f411229a = 0.0f;
        this.f411230b = 0;
        this.f411231c = 0;
        this.f411232d = false;
        this.f411233e = 10;
        WebViewOptimizeConfig r100 = ixb.a.f496453a;
        if (r100 == null) goto L5;
        BlankScreenConfig r101 = r100.getBlankScreen();
    L6:
        if (r101 == null) goto L9;
        this.f411232d = r101.getEnableNearBlankPixelNormalize();
        this.f411233e = Math.max(0, Math.min(255, r101.getNearBlankPixelColorThreshold()));
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static Bitmap c(View r100) {
        if (r100.getWidth() != 0) goto L5;
        return null;
    L5:
        if (r100.getHeight() == 0) goto L16;
        int r101 = r100.getWidth();
        int r102 = r100.getHeight() - 0;
        if (r101 <= 0) goto L15;
        if (r102 <= 0) goto L17;
        Bitmap r103 = Bitmap.createBitmap(Math.max(1, r101 / 6), Math.max(1, r102 / 6), Bitmap.Config.ARGB_8888);
        Canvas r104 = new Canvas(r103);
        r104.scale(0.16666667f, 0.16666667f);
        r104.translate(0.0f, 0);
        r100.draw(r104);
        return r103;
    L17:
        return null;
    L15:
        return null;
    L16:
        return null;
    }

    public final void d(Bitmap r110) {
        int r100 = r110.getWidth() * r110.getHeight();
        int[] r111 = new int[r100];
        r110.getPixels(r111, 0, r110.getWidth(), 0, 0, r110.getWidth(), r110.getHeight());
        int r101 = r110.getWidth();
        int r102 = r110.getHeight();
        if (r110.isRecycled() == true) goto L5;
        r110.recycle();
    L5:
        j.e("CML_TAG_BlankScreenManager", "isBlankV1 pixels length " + r100 + " , width = " + r101 + " , height = " + r102);
        SparseArray r103 = new SparseArray();
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
    L7:
        if (r104 >= r101) goto L19;
        int r112 = 0;
    L9:
        if (r112 >= r102) goto L17;
        int r113 = r111[(r112 * r101) + r104];
        r105 = r105 + 1;
        int r114 = ((Integer) r103.get(r113, -1)).intValue();
        if (r114 >= 0) goto L13;
        int r115 = 1;
    L14:
        if (r115 <= r106) goto L16;
        r107 = r113;
        r106 = r115;
    L16:
        r103.put(r113, Integer.valueOf(r115));
        r112 = r112 + 1;
        goto L9
    L13:
        r115 = r114 + 1;
        goto L14
    L17:
        r104 = r104 + 1;
        goto L7
    L19:
        if (this.f411232d == false) goto L38;
        if (r105 <= 0) goto L38;
        int r108 = 0;
        int r116 = 0;
    L22:
        if (r108 >= r101) goto L37;
        int r117 = 0;
    L24:
        if (r117 >= r102) goto L36;
        int r118 = r111[(r117 * r101) + r108];
        if (Math.abs(Color.red(r118) - Color.red(r107)) <= this.f411233e) goto L28;
    L32:
        boolean r109 = false;
    L33:
        if (r109 == false) goto L35;
        r116 = r116 + 1;
    L35:
        r117 = r117 + 1;
        goto L24
    L28:
        if (Math.abs(Color.green(r118) - Color.green(r107)) > this.f411233e) goto L32;
        if (Math.abs(Color.blue(r118) - Color.blue(r107)) > this.f411233e) goto L32;
        r109 = true;
        goto L33
    L36:
        r108 = r108 + 1;
        goto L22
    L37:
        r106 = Math.max(r106, r116);
    L38:
        if (r105 != 0) goto L40;
        float r119 = 1.0f;
    L41:
        this.f411229a = r119;
        StringBuilder r120 = new StringBuilder("blank pixels percent = ");
        r120.append(r119);
        r120.append(", enableNearBlankPixelNormalize = ");
        r120.append(this.f411232d);
        r120.append(", nearBlankPixelColorThreshold = ");
        r120.append(this.f411233e);
        r120.append(", bucketSize = ");
        r120.append(r103.size());
        r120.append(", dominantBucketCount = ");
        r120.append(r106);
        r120.append(", dominantPixelRgb = ");
        r120.append("(" + Color.red(r107) + "," + Color.green(r107) + "," + Color.blue(r107) + ")");
        j.e("CML_TAG_BlankScreenManager", r120.toString());
        return;
    L40:
        r119 = r106 / r105;
        goto L41
    }

    public final void f(String r100) {
        j.b("CML_TAG_BlankScreenManager", "blank check error: " + r100);
        a r101 = this.f411234f;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public static Rect b(View r100, Window r110) {
        int[] r101 = new int[2];
        r100.getLocationInWindow(r101);
        int r102 = r101[0];
        Rect r103 = new Rect(r102, r101[1], r100.getWidth() + r102, r101[1] + r100.getHeight());
        View r111 = r110.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L7:
        Rect r105 = new Rect();
        if (r111 == null) goto L11;
        r111.getWindowVisibleDisplayFrame(r105);
    L11:
        if (r105.width() > 0) goto L13;
    L17:
        j.e("CML_TAG_BlankScreenManager", "pixel copy src rect by webview bounds, rect=" + r103 + ", webViewSize=" + r100.getWidth() + "x" + r100.getHeight() + ", locationInWindow=[" + r101[0] + "," + r101[1] + "], windowVisibleRect=" + r105);
        return r103;
    L13:
        if (r105.height() <= 0) goto L17;
        if (r103.intersect(r105) == true) goto L17;
        r103.setEmpty();
        goto L17
    }

    public static void a(View r100, Rect r101, PixelCopyCropRectConfig r102, String r110) {
        if (r102 != null) goto L6;
        j.e("CML_TAG_BlankScreenManager", "pixel copy crop rect empty, bizName=" + r110 + ", rect=" + r101.width() + "x" + r101.height());
        return;
    L6:
        Resources r103 = r100.getResources();
        float r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        int r105 = Math.round(r102.getLeftDp() * r104);
        int r106 = Math.round(r102.getTopDp() * r104);
        int r107 = Math.round(r102.getRightDp() * r104);
        int r108 = Math.round(r102.getBottomDp() * r104);
        r101.left += r105;
        r101.top += r106;
        r101.right -= r107;
        r101.bottom -= r108;
        j.e("CML_TAG_BlankScreenManager", "pixel copy crop rect, bizName=" + r110 + ", cropDp=[" + r102.getLeftDp() + "," + r102.getTopDp() + "," + r102.getRightDp() + "," + r102.getBottomDp() + "], cropPx=[" + r105 + "," + r106 + "," + r107 + "," + r108 + "], rect=" + r101.width() + "x" + r101.height());
    }

    public final void e(View r100, Window r110, PixelCopyCropRectConfig r111, String r112) {
        final long r101 = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 26) goto L38;
        f("pixel copy unsupported api");
        return;
    L38:
    L35:
        th = move-exception;
        j.b("CML_TAG_BlankScreenManager", "checkBlankScreenByPixelCopy error. " + th.getMessage());
        f(th.getMessage());
        return;
    L7:
        if (r100.isAttachedToWindow() == true) goto L9;
    L33:
        f("invalid webview for pixel copy");     // Catch: Throwable -> L35
        return;
    L9:
        if (r100.isShown() == false) goto L33;
        if (r100.getWidth() <= 0) goto L33;
        if (r100.getHeight() <= 0) goto L33;
        if (r110 != null) goto L18;
        f("window is null for pixel copy");     // Catch: Throwable -> L35
        return;
    L18:
        final Rect r102 = b(r100, r110);     // Catch: Throwable -> L35
        if (r102.width() > 0) goto L21;
    L31:
        f("src rect is invalid for pixel copy");     // Catch: Throwable -> L35
        return;
    L21:
        if (r102.height() <= 0) goto L31;
        a(r100, r102, r111, r112);     // Catch: Throwable -> L35
        if (r102.width() > 0) goto L26;
    L29:
        f("pixel copy crop rect is invalid");     // Catch: Throwable -> L35
        return;
    L26:
        if (r102.height() <= 0) goto L29;
        final Bitmap r103 = Bitmap.createBitmap(Math.max(1, r102.width() / 6), Math.max(1, r102.height() / 6), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L35
        wf7.b.f559487a.e(r110, r102, r103, new b(this, r103, r101, r102), new Handler(Looper.getMainLooper()), new Token("LARK-PSDA-chameleon-blank-check"));     // Catch: Throwable -> L35
    }
}
