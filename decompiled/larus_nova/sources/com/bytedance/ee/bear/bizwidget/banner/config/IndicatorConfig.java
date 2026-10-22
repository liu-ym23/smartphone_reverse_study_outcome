package com.bytedance.ee.bear.bizwidget.banner.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes16.dex */
public final class IndicatorConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f216340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f216341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f216342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f216343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f216344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f216345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f216346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f216347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f216348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f216349j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f216350k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f216351l;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
        public static final int CENTER = 1;
        public static final int LEFT = 0;
        public static final int RIGHT = 2;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f216352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f216353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f216354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f216355d;

        public a(int r100, int r101, int r102, int r103) {
            this.f216352a = r100;
            this.f216353b = r101;
            this.f216354c = r102;
            this.f216355d = r103;
        }
    }

    public final a a() {
        if (this.f216350k != null) goto L6;
        int r100 = pv4.a.f530816d;
        this.f216350k = new a(r100, r100, r100, r100);
    L6:
        return this.f216350k;
    }

    public IndicatorConfig() {
        this.f216342c = 1;
        this.f216343d = pv4.a.f530815c;
        this.f216344e = pv4.a.f530813a;
        this.f216345f = pv4.a.f530814b;
        this.f216346g = -1996488705;
        this.f216347h = 16777215;
        this.f216348i = pv4.a.f530818f;
        this.f216349j = pv4.a.f530817e;
        this.f216351l = true;
    }
}
