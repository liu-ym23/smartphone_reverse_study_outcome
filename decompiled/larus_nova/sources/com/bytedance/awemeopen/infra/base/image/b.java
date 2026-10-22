package com.bytedance.awemeopen.infra.base.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f198620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f198621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f198622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f198623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.awemeopen.infra.base.image.a f198624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l64.c f198625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f198626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f198627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f198628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f198629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f198630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Uri f198631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView.ScaleType f198632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f198633n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f198634o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Bitmap.Config f198635p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f198636q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f198637r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f198638s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f198639t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f198640u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f198641v;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f198642a;

        public a(b r100) {
            this.f198642a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.awemeopen.infra.base.image.b$b, reason: collision with other inner class name */
    public class C2873b implements l64.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f198643a;

        @Override // l64.a
        public final void onSuccess() {
            com.bytedance.awemeopen.infra.base.image.a r100 = this.f198643a.f198624e;
            if (r100 == null) goto L6;
            r100.onSuccess();
            return;
        }

        public C2873b(b r100) {
            this.f198643a = r100;
        }

        @Override // l64.a
        public final void onFail(Exception r100) {
            com.bytedance.awemeopen.infra.base.image.a r101 = this.f198643a.f198624e;
            if (r101 == null) goto L6;
            r101.onFail();
            return;
        }
    }

    public final l64.b a() {
        l64.b r100 = new l64.b();
        r100.f507666a = this.f198620a;
        r100.f507667b = this.f198621b;
        r100.f507668c = this.f198622c;
        r100.f507671f = this.f198631l;
        r100.f507686u = new a(this);
        r100.f507687v = this.f198625f;
        r100.f507669d = this.f198623d;
        r100.f507670e = new C2873b(this);
        r100.f507672g = this.f198626g;
        r100.f507673h = this.f198627h;
        r100.f507674i = this.f198628i;
        r100.f507675j = this.f198629j;
        r100.f507676k = this.f198632m;
        r100.f507677l = this.f198633n;
        r100.f507678m = this.f198634o;
        r100.f507679n = this.f198635p;
        r100.f507680o = this.f198636q;
        r100.f507681p = this.f198637r;
        r100.f507682q = this.f198638s;
        r100.f507683r = this.f198639t;
        r100.f507684s = this.f198640u;
        r100.f507685t = this.f198641v;
        return r100;
    }

    public b(int r100) {
        this.f198633n = -1;
        this.f198634o = -1;
        this.f198635p = Bitmap.Config.RGB_565;
        this.f198641v = true;
        this.f198621b = r100;
    }

    public final void b(int r100) {
        this.f198626g = null;
        this.f198627h = r100;
    }

    public b(String r100) {
        this.f198633n = -1;
        this.f198634o = -1;
        this.f198635p = Bitmap.Config.RGB_565;
        this.f198641v = true;
        this.f198620a = r100;
    }

    public b(List<String> r100) {
        this.f198633n = -1;
        this.f198634o = -1;
        this.f198635p = Bitmap.Config.RGB_565;
        this.f198641v = true;
        this.f198622c = r100;
    }
}
