package vx7;

import a36.c;
import android.content.Context;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import m16.b;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f557494a = 0;

    static {
    }

    @JvmStatic
    public static final Context getContext(IBDXBridgeContext r100) {
        return (Context) a(r100, Context.class);
    }

    @JvmStatic
    public static final c getIdentifier(IBDXBridgeContext r100) {
        return (c) a(r100, c.class);
    }

    @JvmStatic
    public static final <T> T a(IBDXBridgeContext r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "service");
        if (r100 == null) goto L5;
        b r102 = (b) r100.getService(b.class);
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
