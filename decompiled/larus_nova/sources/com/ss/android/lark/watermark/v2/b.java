package com.ss.android.lark.watermark.v2;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.larksuite.framework.utils.RomUtils;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements q<Activity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f445534a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f445535b = null;

    public b() {
    }

    static {
        f445534a = new b();
        f445535b = m.f445553a;
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
    public final /* bridge */ /* synthetic */ void a(Activity r100) {
        d(r100);
    }

    public final void d(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        View r101 = c(r100.getWindow());
        if ((r101 instanceof FrameLayout) == false) goto L8;
        FrameLayout r102 = (FrameLayout) r101;
        if ((r102.getForeground() instanceof u) == false) goto L9;
        r102.setForeground(null);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.watermark.v2.q
    public final boolean b(u r100, Activity r110) {
        Activity r111 = r110;
        Intrinsics.checkNotNullParameter(r100, "drawable");
        Intrinsics.checkNotNullParameter(r111, PickerReporterConstants.KEY.TARGET);
        View r101 = c(r111.getWindow());
        int r102 = 0;
        if ((r101 instanceof FrameLayout) == false) goto L19;
        f445535b.getClass();
        if (RomUtils.h() == true) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L18;
        FrameLayout r104 = (FrameLayout) r101;
        int r105 = r104.getChildCount();
    L12:
        if (r102 >= r105) goto L17;
        if (Intrinsics.areEqual(r104.getChildAt(r102).getClass().getName(), "com.android.internal.widget.MiuiDecorCaptionView") == true) goto L24;
        r102 = r102 + 1;
        goto L12
    L24:
        return f445535b.c(r100, r111);
    L17:
        r104.setOnHierarchyChangeListener(new a(r111, r100));
    L18:
        ((FrameLayout) r101).setForeground(r100);
        Log.i("watermark", "ActivityDecorViewBinder.bind:true,activity is " + r111);
        r102 = 1;
    L21:
        return r102;
    L7:
        if (Build.VERSION.SDK_INT <= 29) goto L9;
        r103 = true;
        goto L10
    L19:
        Log.i("watermark", "ActivityDecorViewBinder.bind:false");
        goto L21
    }
}
