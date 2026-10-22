package com.bytedance.applet.debug.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.bytedance.common.utility.UIUtils;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x {
    public final Context a;
    public final View b;
    public final boolean c;
    public final int d;
    public final int e;
    public int f;
    public int g;
    public int h;
    public final WindowManager.LayoutParams i;
    public WindowManager j;
    public final int k;
    public int l;
    public final Handler m;
    public float n;
    public float o;
    public float p;
    public float q;
    public long r;
    public long s;
    public boolean t;
    public boolean u;
    public int v;
    public final long w;
    public final long x;
    public final long y;
    public a z;

    public interface a {
        void a(View r1);

        void onClick(View r1);

        void onLongClick(View r1);
    }

    public final void a() {
        WindowManager.LayoutParams r0 = this.i;
        r0.x = this.d;
        if (this.c == false) goto L5;
        int r1 = (int) UIUtils.dip2Px(this.a, 68.0f);
    L6:
        r0.y = r1;
        if (this.c == false) goto L10;
        r0.flags |= 16;
        return;
    L10:
        return;
    L5:
        r1 = this.f / 3;
        goto L6
    }

    public final void b(View r4) {
        WindowManager r0 = this.j;     // Catch: Exception -> L6
        if (r0 == null) goto L11;
        r0.removeViewImmediate(r4);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        FLogger.a.i("AppletDebugActivity", "removeWindowView error " + e.getMessage());
    }

    public x(Context r4, View r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "floatingView");
        this.a = r4;
        this.b = r5;
        this.c = false;
        this.d = r4.getResources().getDimensionPixelSize(2131165925);
        this.e = r4.getResources().getDimensionPixelSize(2131165925);
        this.f = com.larus.utils.i.c(r4);
        this.g = com.larus.utils.i.d(r4);
        this.h = com.larus.utils.i.e(r4);
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams();
        this.i = r0;
        this.k = ViewConfiguration.get(r4).getScaledTouchSlop();
        this.m = new Handler(Looper.getMainLooper());
        this.n = -1.0f;
        this.o = -1.0f;
        this.p = -1.0f;
        this.q = -1.0f;
        this.u = true;
        this.w = 500;
        this.x = 300;
        this.y = 200;
        r0.type = 2;
        r0.flags = 552;
        r0.format = 1;
        r0.gravity = 8388659;
        r0.width = -2;
        r0.height = -2;
        r5.setOnTouchListener(new a0(this));
        a();
    }
}
