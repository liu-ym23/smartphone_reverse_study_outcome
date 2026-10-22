package haa;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f484425a = null;

    static {
        f484425a = LazyKt.lazy(new a());
    }

    public static final float a(float r100) {
        return r100 * ((Number) f484425a.getValue()).floatValue();
    }
}
