package rha;

import com.larus.common.apphost.AppHost;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes33.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f537820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f537821b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f537822c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f537823d = null;

    static {
        f537820a = LazyKt.lazy(new b());
        f537821b = LazyKt.lazy(new c());
        f537822c = LazyKt.lazy(new d());
        f537823d = LazyKt.lazy(new e());
    }

    public static String a(int r100) {
        return AppHost.f326268a.getApplication().getString(r100);
    }
}
