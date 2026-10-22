package nx9;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f521091a = null;

    static {
        f521091a = LazyKt.lazy(new b());
    }

    public static int a() {
        return ((Number) f521091a.getValue()).intValue();
    }
}
