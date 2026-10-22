package o5;

import com.bytedance.ai.resource.core.net.OpenPlatformNetApi;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f522026a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f522027b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f522028c = null;

    static {
        f522026a = LazyKt.lazy(new d());
        f522027b = LazyKt.lazy(new e());
        f522028c = LazyKt.lazy(new f());
    }

    public static OpenPlatformNetApi a() {
        return (OpenPlatformNetApi) f522027b.getValue();
    }
}
