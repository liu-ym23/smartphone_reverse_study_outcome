package com.bytedance.android.window.shop.widget.holderprocessor;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final long a;
    public long b;
    public final boolean c;
    public Map<String, String> d;
    public final Integer e;
    public boolean f;
    public long g;
    public final Integer h;

    public final String toString() {
        return "PerfData(start=" + this.a + ", end=" + this.b + ", isLynx=" + this.c + ", extraParams=" + this.d + ", position=" + this.e + ')';
    }

    public a(long r1, boolean r3, Integer r4, boolean r5, long r6, Integer r8) {
        this.a = r1;
        this.b = -1;
        this.c = r3;
        this.d = null;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r8;
    }
}
