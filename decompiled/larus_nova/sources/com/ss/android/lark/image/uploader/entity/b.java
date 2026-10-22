package com.ss.android.lark.image.uploader.entity;

import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f426387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f426388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f426389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f426390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Biz f426391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Scene f426392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f426393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f426394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f426395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f426396j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageInfo f426397k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f426398l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.ss.android.lark.image.uploader.entity.a f426399m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public glb.a f426400n;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f426401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Biz f426402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Scene f426403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f426404d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f426405e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f426406f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f426407g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f426408h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f426409i;

        public final b b() {
            return new b(this.f426401a, this.f426407g, this.f426406f, this.f426408h, this.f426402b, this.f426403c, this.f426404d, this.f426405e, this.f426409i);
        }

        public a() {
            this.f426401a = "";
        }

        public final void a(Biz r100) {
            Intrinsics.checkNotNullParameter(r100, "biz");
            this.f426402b = r100;
        }

        public final void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            this.f426401a = r100;
        }

        public final void d(Scene r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            this.f426403c = r100;
        }
    }

    public final String toString() {
        return "UploadImage_" + this.f426387a;
    }

    public b(String r100, boolean r101, boolean r102, boolean r103, Biz r104, Scene r105, int r106, String r107, boolean r108) {
        this.f426387a = r100;
        this.f426388b = r101;
        this.f426389c = r102;
        this.f426390d = r103;
        this.f426391e = r104;
        this.f426392f = r105;
        this.f426393g = r106;
        this.f426394h = r107;
        this.f426395i = r108;
        this.f426396j = r100;
    }
}
