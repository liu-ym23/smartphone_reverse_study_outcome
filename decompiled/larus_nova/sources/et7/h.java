package et7;

import android.content.Context;
import android.content.res.Resources;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes22.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f473931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f473932b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f473933c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f473934d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f473935e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f473936f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f473937g = null;

    static {
        f473932b = LazyKt.lazy(new b());
        f473933c = LazyKt.lazy(new c());
        f473934d = LazyKt.lazy(new d());
        f473935e = LazyKt.lazy(new e());
        f473936f = LazyKt.lazy(new f());
        f473937g = LazyKt.lazy(new g());
    }

    public final Context getContext() {
        return f473931a;
    }

    public static float a(int r100) {
        Context r101 = f473931a;
        if (r101 == null) goto L7;
        Resources r102 = r101.getResources();
        if (r102 == null) goto L7;
        return r102.getDimension(r100);
    L7:
        return 0.0f;
    }
}
