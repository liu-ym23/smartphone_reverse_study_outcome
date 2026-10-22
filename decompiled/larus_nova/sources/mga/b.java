package mga;

import com.obric.assistant.spi.essentialtask.IObricEssentialTaskService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f513818a = null;

    static {
        f513818a = LazyKt.lazy(new a());
    }

    public static final IObricEssentialTaskService a() {
        return (IObricEssentialTaskService) f513818a.getValue();
    }
}
