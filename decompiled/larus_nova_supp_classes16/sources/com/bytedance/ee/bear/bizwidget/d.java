package com.bytedance.ee.bear.bizwidget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ee.bear.facade.common.widget.Toast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public final Context a;
    public boolean b;
    public final c c;
    public final Handler d;
    public int e;

    public final void a() {
        this.d.removeCallbacks(this.c);
        Toast.cancelLoading();
        this.b = false;
    }

    public final void b() {
        this.d.removeCallbacks(this.c);
        this.d.postDelayed(this.c, 300);
        this.b = true;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ee.bear.bizwidget.c] */
    public d(Context r3) {
        this.c = new c(this);
        this.d = new Handler(Looper.getMainLooper());
        this.e = -1;
        this.a = r3;
    }
}
