package o5;

import com.bytedance.ai.resource.IAIPackageNetService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f522025a = null;

    static {
        f522025a = LazyKt.lazy(new a());
    }

    public static IAIPackageNetService a() {
        return (IAIPackageNetService) f522025a.getValue();
    }
}
