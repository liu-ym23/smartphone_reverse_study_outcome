package nda;

import com.obric.assistant.common.spi.IObricUIService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new c());
    }

    public static final IObricUIService a() {
        return (IObricUIService) a.getValue();
    }
}
