package nca;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes32.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f518674a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f518675b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f518676c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f518677d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f518678e = null;

    static {
        f518674a = new AtomicInteger(0);
        f518675b = LazyKt.lazy(new a());
        f518676c = LazyKt.lazy(new l());
        f518677d = LazyKt.lazy(new w());
        f518678e = LazyKt.lazy(new h0());
    }

    public static void a(Map r100, Class r101, Function1 r102) {
        if (r100.containsKey(r101) == true) goto L7;
        r100.put(r101, TuplesKt.to(Integer.valueOf(f518674a.getAndIncrement()), r102));
        return;
    L7:
        throw new IllegalArgumentException("is already added: " + r101);
    }
}
