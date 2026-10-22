package com.bytedance.locallife.dito;

import com.bytedance.locallife.dito.config.DefaultDitoPresetSizeCacheConfig;
import com.bytedance.locallife.dito.config.b;
import com.bytedance.locallife.dito.config.e;
import com.bytedance.locallife.dito.config.f;
import com.bytedance.locallife.dito.config.g;
import com.bytedance.locallife.dito.config.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import rq6.c;
import sq6.d;

/* JADX INFO: loaded from: classes21.dex */
public final class Dito {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Dito f257280a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f257281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final bq6.a f257282c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f257283d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f257284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f257285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f257286g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f257287h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f257288i = null;

    public static class a {
        public a() {
        }

        public <T> T a(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            if (Intrinsics.areEqual(r100, d.class) == false) goto L6;
            Object r101 = sq6.a.f543073a;
        L24:
            if (r101 != null) goto L27;
            return null;
        L27:
            return (T) r101;
        L6:
            if (Intrinsics.areEqual(r100, c.class) == false) goto L9;
            r101 = rq6.d.f538929a;
            goto L24
        L9:
            if (Intrinsics.areEqual(r100, com.bytedance.locallife.dito.core.manager.c.class) == false) goto L12;
            r101 = (com.bytedance.locallife.dito.core.manager.c) Dito.f257288i.getValue();
            goto L24
        L12:
            if (Intrinsics.areEqual(r100, g.class) == false) goto L15;
            r101 = DefaultDitoPresetSizeCacheConfig.f257740a;
            goto L24
        L15:
            if (Intrinsics.areEqual(r100, f.class) == false) goto L18;
            r101 = com.bytedance.locallife.dito.config.c.f257742a;
            goto L24
        L18:
            if (Intrinsics.areEqual(r100, i.class) == false) goto L21;
            r101 = com.bytedance.locallife.dito.config.d.f257743a;
            goto L24
        L21:
            if (Intrinsics.areEqual(r100, e.class) == false) goto L23;
            r101 = b.f257741a;
            goto L24
        L23:
            r101 = null;
            goto L24
        }
    }

    public Dito() {
    }

    static {
        f257280a = new Dito();
        f257282c = new bq6.a();
        f257283d = LazyKt.lazy(Dito$defaultDitoSettings$2.INSTANCE);
        f257284e = true;
        f257286g = LazyKt.lazy(LazyThreadSafetyMode.NONE, Dito$defaultConfig$2.INSTANCE);
        f257287h = LazyKt.lazy(Dito$gson$2.INSTANCE);
        f257288i = LazyKt.lazy(Dito$defaultDitoNodeMerger$2.INSTANCE);
    }

    public static a a() {
        if (f257284e == true) goto L5;
        a r100 = f257285f;
        if (r100 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    L10:
        return r100;
    L5:
        return (a) f257286g.getValue();
    }
}
