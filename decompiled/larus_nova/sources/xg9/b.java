package xg9;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f563815a = null;

    static {
        f563815a = LazyKt.lazy(new a());
    }

    public static Keva a() {
        return (Keva) f563815a.getValue();
    }
}
