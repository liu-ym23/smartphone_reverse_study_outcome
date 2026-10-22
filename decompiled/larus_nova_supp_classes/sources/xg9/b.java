package xg9;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
    }

    public static Keva a() {
        return (Keva) a.getValue();
    }
}
