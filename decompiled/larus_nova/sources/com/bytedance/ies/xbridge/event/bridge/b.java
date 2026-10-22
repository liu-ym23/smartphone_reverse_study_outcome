package com.bytedance.ies.xbridge.event.bridge;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f249480a;

    public interface a {
        void a(int r100);
    }

    /* JADX INFO: renamed from: com.bytedance.ies.xbridge.event.bridge.b$b, reason: collision with other inner class name */
    public static final class ViewTreeObserverOnGlobalLayoutListenerC3557b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f249481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Window f249482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int[] f249483c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f249484d;

        public ViewTreeObserverOnGlobalLayoutListenerC3557b(Context r100, Window r101, int[] r102, a r103) {
            this.f249481a = r100;
            this.f249482b = r101;
            this.f249483c = r102;
            this.f249484d = r103;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            int r100 = b.f249480a;
            int r101 = b.a(this.f249481a, this.f249482b);
            if (this.f249483c[0] == r101) goto L6;
            this.f249484d.a(r101);
            this.f249483c[0] = r101;
            return;
        }
    }

    static {
    }

    public static void c(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        FrameLayout r101 = (FrameLayout) r100.findViewById(R.id.content);
        Object r102 = r101.getTag(-8);
        if (r102 != null) goto L7;
        return;
    L7:
        r101.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) r102);
    }

    public static int a(Context r100, Window r101) {
        View r102 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L7:
        Rect r104 = new Rect();
        r102.getWindowVisibleDisplayFrame(r104);
        int r105 = Math.abs(r102.getBottom() - r104.bottom);
        Resources r106 = r100.getResources();
        int r107 = r106.getDimensionPixelSize(r106.getIdentifier("status_bar_height", "dimen", "android"));
        Resources r108 = r100.getResources();
        if (r105 > (r107 + r108.getDimensionPixelSize(r108.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android")))) goto L12;
        f249480a = r105;
        return 0;
    L12:
        return r105 - f249480a;
    }

    public static void b(Context r100, Window r101, a r102) {
        Intrinsics.checkNotNullParameter(r102, "listener");
        if (r100 == null) goto L11;
        if (r101 != null) goto L7;
        return;
    L7:
        if ((r101.getAttributes().flags & 512) == 0) goto L9;
        r101.clearFlags(512);
    L9:
        FrameLayout r103 = (FrameLayout) r101.findViewById(R.id.content);
        ViewTreeObserverOnGlobalLayoutListenerC3557b r104 = new ViewTreeObserverOnGlobalLayoutListenerC3557b(r100, r101, new int[]{a(r100, r101)}, r102);
        r103.getViewTreeObserver().addOnGlobalLayoutListener(r104);
        r103.setTag(-8, r104);
        return;
    }
}
