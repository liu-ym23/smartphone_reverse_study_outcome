package wu6;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f561439a = 0;

    static {
    }

    @JvmStatic
    public static final <T> T a(IBDXBridgeContext r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "service");
        if (r100 == null) goto L5;
        m16.b r102 = (m16.b) r100.getService(m16.b.class);
    L6:
        if (r102 == null) goto L11;
        T r103 = (T) r102.c(r101);
        if (r103 == null) goto L11;
        return r103;
    L11:
        if (r100 != null) goto L13;
        return null;
    L13:
        return (T) r100.getService(r101);
    L5:
        r102 = null;
        goto L6
    }

    @JvmStatic
    public static final <T> T b(g66.c r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "service");
        if (r100 == null) goto L5;
        m16.b r102 = (m16.b) r100.c(m16.b.class);
    L6:
        if (r102 == null) goto L11;
        T r103 = (T) r102.c(r101);
        if (r103 == null) goto L11;
        return r103;
    L11:
        if (r100 != null) goto L13;
        return null;
    L13:
        return (T) r100.c(r101);
    L5:
        r102 = null;
        goto L6
    }
}
