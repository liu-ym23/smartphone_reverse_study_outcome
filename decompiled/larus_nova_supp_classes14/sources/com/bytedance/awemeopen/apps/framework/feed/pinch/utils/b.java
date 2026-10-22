package com.bytedance.awemeopen.apps.framework.feed.pinch.utils;

import android.content.Context;
import android.view.GestureDetector;
import android.view.ViewConfiguration;
import com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public final a a;
    public float b;
    public float c;
    public boolean d;
    public boolean e;
    public float f;
    public float g;
    public float h;
    public boolean i;
    public final int j;
    public final int k;
    public float l;
    public float m;
    public int n;
    public GestureDetector o;
    public boolean p;

    public interface a {
        void a();

        void b();

        boolean c(b r1);
    }

    public final boolean a() {
        if (this.n == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public b(Context r5, r r6) {
        this.n = 0;
        this.a = r6;
        this.j = ViewConfiguration.get(r5).getScaledTouchSlop() * 2;
        r5.getResources();
        this.k = 1;
        int r0 = r5.getApplicationInfo().targetSdkVersion;
        if (r0 <= 18) goto L8;
        this.d = true;
        if (this.o != null) goto L8;
        this.o = new GestureDetector(r5, new com.bytedance.awemeopen.apps.framework.feed.pinch.utils.a(this), null);
    L8:
        if (r0 <= 22) goto L11;
        this.e = true;
        return;
    }
}
