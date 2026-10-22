package xw9;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f565281a = null;

    static {
        f565281a = LazyKt.lazy(new f());
    }

    public static boolean a() {
        return !((Boolean) f565281a.getValue()).booleanValue();
    }
}
