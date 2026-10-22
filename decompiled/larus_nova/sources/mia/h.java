package mia;

import android.content.Context;
import android.content.res.Resources;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes33.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f514129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f514130b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f514131c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f514132d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f514133e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f514134f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f514135g = null;

    static {
        f514130b = LazyKt.lazy(new b());
        f514131c = LazyKt.lazy(new c());
        f514132d = LazyKt.lazy(new d());
        f514133e = LazyKt.lazy(new e());
        f514134f = LazyKt.lazy(new f());
        f514135g = LazyKt.lazy(new g());
    }

    public final Context getContext() {
        return f514129a;
    }

    public static float a(int r100) {
        Context r101 = f514129a;
        if (r101 == null) goto L7;
        Resources r102 = r101.getResources();
        if (r102 == null) goto L7;
        return r102.getDimension(r100);
    L7:
        return 0.0f;
    }
}
