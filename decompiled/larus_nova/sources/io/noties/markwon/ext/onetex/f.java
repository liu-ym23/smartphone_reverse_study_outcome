package io.noties.markwon.ext.onetex;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f492402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f492403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f492404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f492405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ExecutorService f492406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f492407f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f492408g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f492409h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f492410i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f492411j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f492412k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f492413l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f492414m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f492415n;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f492416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f492417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f492418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f492419d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f492420e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<String> f492421f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f492422g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f492423h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f492424i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f492425j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f492426k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f492427l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final t f492428m;

        public a(t r100) {
            this.f492428m = r100;
            this.f492416a = true;
            this.f492418c = true;
            this.f492421f = CollectionsKt.emptyList();
            this.f492427l = 5000;
        }
    }

    public f(a r100) {
        this.f492402a = r100.f492428m;
        this.f492403b = r100.f492416a;
        this.f492404c = r100.f492417b;
        this.f492405d = r100.f492418c;
        LaTexHelper.f492379d.getClass();
        Lazy r101 = LaTexHelper.f492378c;
        KProperty r102 = LaTexHelper.f492376a[0];
        this.f492406e = (ThreadPoolExecutor) r101.getValue();
        this.f492407f = r100.f492419d;
        this.f492408g = r100.f492420e;
        this.f492409h = r100.f492421f;
        this.f492410i = r100.f492422g;
        this.f492411j = r100.f492423h;
        this.f492412k = r100.f492425j;
        this.f492413l = r100.f492424i;
        this.f492414m = r100.f492426k;
        this.f492415n = r100.f492427l;
    }
}
