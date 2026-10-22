package y48;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f566100a = null;

    static {
        f566100a = LazyKt.lazy(new g());
    }

    public static boolean a() {
        return ((Boolean) f566100a.getValue()).booleanValue();
    }
}
