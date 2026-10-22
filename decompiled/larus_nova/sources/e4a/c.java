package e4a;

import android.content.Context;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final Context getContext(IBDXBridgeContext r100) {
        return (Context) a(r100, Context.class);
    }

    @JvmStatic
    public static final a36.c getIdentifier(IBDXBridgeContext r100) {
        return (a36.c) a(r100, a36.c.class);
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
}
