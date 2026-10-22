package j64;

import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import java.lang.reflect.Proxy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final <T extends IBdpService> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        T r101 = (T) BdpManager.getInst().getService(r100);
        if (r101 != null) goto L5;
        return r101;
    L5:
        if (Proxy.isProxyClass(r101.getClass()) == false) goto L9;
        return null;
    L9:
        return r101;
    }
}
