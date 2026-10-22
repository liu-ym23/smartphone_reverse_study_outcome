package wi8;

import com.larus.platform.model.chat.v;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f559858a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f559859b = null;

    static {
        f559858a = LazyKt.lazy(new b());
        f559859b = LazyKt.lazy(new c());
    }

    public static v a() {
        return (v) f559858a.getValue();
    }
}
