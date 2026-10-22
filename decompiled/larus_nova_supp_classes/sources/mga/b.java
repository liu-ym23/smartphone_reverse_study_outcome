package mga;

import com.obric.assistant.spi.essentialtask.IObricEssentialTaskService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
    }

    public static final IObricEssentialTaskService a() {
        return (IObricEssentialTaskService) a.getValue();
    }
}
