package dc2;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Class<?>> f467848a = null;

    static {
        f467848a = new HashMap();
    }

    @JvmStatic
    public static final void a(String r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "valueType");
        ((HashMap) f467848a).put(r100, r101);
    }
}
