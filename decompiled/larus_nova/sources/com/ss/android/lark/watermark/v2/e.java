package com.ss.android.lark.watermark.v2;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.watermark.userscope.ToolsV3Kt;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements q<Dialog> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f445543a = null;

    static {
        f445543a = new e();
    }

    public e() {
    }

    public static View c(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // com.ss.android.lark.watermark.v2.q
    public final void a(Dialog r100) {
        Dialog r101 = r100;
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (r101.isShowing() == false) goto L12;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        View r103 = c(r102);
    L9:
        if ((r103 instanceof FrameLayout) == false) goto L13;
        ((FrameLayout) r103).setForeground(null);
        return;
    L13:
        return;
    L7:
        r103 = null;
        goto L9
    }

    @Override // com.ss.android.lark.watermark.v2.q
    public final boolean b(u r100, Dialog r101) {
        Dialog r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "drawable");
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        Window r103 = r102.getWindow();
        if (r103 != null) goto L13;
        Log.i("watermark", "DialogDecorViewBinder.bind:window is null, return false");
        return false;
    L13:
        View r104 = c(r103);     // Catch: Exception -> L9
        if ((r104 instanceof FrameLayout) == false) goto L11;
        ((FrameLayout) r104).setForeground(r100);     // Catch: Exception -> L9
        Log.i("watermark", "DialogDecorViewBinder.bind:true");     // Catch: Exception -> L9
        return true;
    L11:
        Log.i("watermark", "DialogDecorViewBinder.bind:exception exit ,return false");
        return false;
    L9:
        e = move-exception;
        Log.i("watermark", "WatermarkBinder.bind: Exception is " + e.getMessage());
        ToolsV3Kt.c("event_name_scs_watermark_dialog_bind_crash", null, 0, 30);
        goto L11
    }
}
