package lha;

import com.obric.assistant.system.IDeviceLockedStateService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f509308a = null;

    static {
        f509308a = LazyKt.lazy(new e());
    }

    public static final IDeviceLockedStateService a() {
        return (IDeviceLockedStateService) f509308a.getValue();
    }
}
