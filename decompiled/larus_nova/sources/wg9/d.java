package wg9;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f559608a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f559609b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f559610c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f559611d = null;

    static {
        f559608a = new AtomicInteger(0);
        int r100 = Runtime.getRuntime().availableProcessors();
        f559609b = r100 + 1;
        f559610c = (r100 * 2) + 1;
        f559611d = LazyKt.lazy(new b());
    }
}
