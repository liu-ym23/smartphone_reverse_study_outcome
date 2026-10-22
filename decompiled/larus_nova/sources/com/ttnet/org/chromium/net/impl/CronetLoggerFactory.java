package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class CronetLoggerFactory {
    private static final String CRONET_LOGGER_IMPL_CLASS = "com.google.net.cronet.telemetry.CronetLoggerImpl";
    private static final int SAMPLE_RATE_PER_SECOND = 1;
    private static final CronetLogger sDefaultLogger = null;
    private static CronetLogger sTestingLogger;

    /* JADX INFO: loaded from: classes41.dex */
    public static class SwapLoggerForTesting implements AutoCloseable {
        @Override // java.lang.AutoCloseable
        public void close() {
            CronetLoggerFactory.access$000(null);
        }

        public SwapLoggerForTesting(CronetLogger r100) {
            CronetLoggerFactory.access$000(r100);
        }
    }

    private CronetLoggerFactory() {
    }

    static {
        sDefaultLogger = new NoOpLogger();
    }

    private static Class<? extends CronetLogger> fetchLoggerImplClass() {
        return INVOKEVIRTUAL_com_ttnet_org_chromium_net_impl_CronetLoggerFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(CronetLoggerFactory.class.getClassLoader(), CRONET_LOGGER_IMPL_CLASS).asSubclass(CronetLogger.class);
    L5:
        return null;
    }

    public static CronetLogger createNoOpLogger() {
        return sDefaultLogger;
    }

    public static /* synthetic */ void access$000(CronetLogger r100) {
        setLoggerForTesting(r100);
    }

    private static void setLoggerForTesting(CronetLogger r100) {
        sTestingLogger = r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_ttnet_org_chromium_net_impl_CronetLoggerFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    public static CronetLogger createLogger(Context r100, CronetLogger.CronetSource r101) {
        CronetLogger r102 = sTestingLogger;
        if (r102 == null) goto L6;
        return r102;
    L6:
        if (CronetManifest.isAppOptedInForTelemetry(r100, r101) == false) goto L20;
        if (Build.VERSION.SDK_INT < 30) goto L20;
        Class<? extends CronetLogger> r103 = fetchLoggerImplClass();
        if (r103 != null) goto L21;
        return sDefaultLogger;
    L21:
        return r103.getConstructor(new Class[]{Integer.TYPE}).newInstance(new Object[]{1});
    L18:
        return sDefaultLogger;
    L20:
        return sDefaultLogger;
    }
}
