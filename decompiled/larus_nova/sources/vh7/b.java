package vh7;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> f554981a = null;

    static {
        f554981a = new ConcurrentHashMap();
    }

    public static final ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> a() {
        return f554981a;
    }
}
