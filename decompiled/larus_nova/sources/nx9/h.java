package nx9;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f521094a = null;

    static {
        f521094a = LazyKt.lazy(new g());
    }

    public static long a() {
        return ((Number) f521094a.getValue()).longValue();
    }
}
