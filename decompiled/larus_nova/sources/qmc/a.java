package qmc;

import com.alipay.sdk.m.p.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import omc.b;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Class<?>> f533977a = null;

    /* JADX INFO: renamed from: qmc.a$a, reason: collision with other inner class name */
    public static final class C7364a {
        @JvmStatic
        public static void a(String r100, Class r101) {
            Intrinsics.checkNotNullParameter(r100, e.f25671s);
            Intrinsics.checkNotNullParameter(r101, "dataType");
            ((ConcurrentHashMap) a.f533977a).put(r100, r101);
        }
    }

    static {
        f533977a = new ConcurrentHashMap();
    }
}
