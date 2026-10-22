package nda;

import com.obric.assistant.common.spi.IObricUIService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f518827a = null;

    static {
        f518827a = LazyKt.lazy(new c());
    }

    public static final IObricUIService a() {
        return (IObricUIService) f518827a.getValue();
    }
}
