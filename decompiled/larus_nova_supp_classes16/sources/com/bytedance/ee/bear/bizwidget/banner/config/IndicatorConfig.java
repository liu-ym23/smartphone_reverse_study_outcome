package com.bytedance.ee.bear.bizwidget.banner.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class IndicatorConfig {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public a k;
    public boolean l;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
        public static final int CENTER = 1;
        public static final int LEFT = 0;
        public static final int RIGHT = 2;
    }

    public static class a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public a(int r1, int r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public final a a() {
        if (this.k != null) goto L6;
        int r1 = pv4.a.d;
        this.k = new a(r1, r1, r1, r1);
    L6:
        return this.k;
    }

    public IndicatorConfig() {
        this.c = 1;
        this.d = pv4.a.c;
        this.e = pv4.a.a;
        this.f = pv4.a.b;
        this.g = -1996488705;
        this.h = 16777215;
        this.i = pv4.a.f;
        this.j = pv4.a.e;
        this.l = true;
    }
}
