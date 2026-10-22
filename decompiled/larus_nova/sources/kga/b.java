package kga;

import com.obric.assistant.spi.common.IObricUtilService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f503398a = null;

    static {
        f503398a = LazyKt.lazy(new a());
    }

    public static final IObricUtilService a() {
        return (IObricUtilService) f503398a.getValue();
    }
}
