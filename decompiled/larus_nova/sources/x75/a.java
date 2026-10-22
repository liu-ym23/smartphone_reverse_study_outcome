package x75;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.drive.render.j;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, j> f562822a = null;

    static {
        f562822a = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final j a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return null;
    L12:
        return f562822a.get(r100);
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @JvmStatic
    public static final String b(j r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        String r101 = UUID.randomUUID().toString();
        f562822a.put(r101, r100);
        return r101;
    }
}
