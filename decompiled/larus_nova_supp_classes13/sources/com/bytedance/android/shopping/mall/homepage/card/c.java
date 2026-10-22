package com.bytedance.android.shopping.mall.homepage.card;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewConfiguration;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final Handler a;
    public final b b;
    public boolean c;
    public final ViewConfiguration d;
    public float e;
    public float f;
    public final View g;
    public final View.OnLongClickListener h;
    public final Map<String, Object> i;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r0 = this.a;     // Catch: Throwable -> L4
            r0.c = r0.h.onLongClick(r0.g);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void a() {
        Object r0 = this.i.get("long_click_optimize");
        if ((r0 instanceof Boolean) == true) goto L6;
        r0 = null;
    L6:
        if (Intrinsics.areEqual((Boolean) r0, Boolean.TRUE) == false) goto L9;
        this.g.setOnLongClickListener(null);
        this.g.setOnTouchListener(new d(this));
        return;
    }

    public c(View r2, View.OnLongClickListener r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "targetView");
        Intrinsics.checkNotNullParameter(r3, "listener");
        Intrinsics.checkNotNullParameter(r4, "config");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.a = new Handler(Looper.getMainLooper());
        this.b = new b(this);
        this.d = ViewConfiguration.get(r2.getContext());
    }
}
