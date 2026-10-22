package com.google.crypto.tink.config.internal;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public final class TinkFipsUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f275744a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f275745b = null;

    public static abstract enum AlgorithmFipsCompatibility extends Enum<AlgorithmFipsCompatibility> {
        public static final AlgorithmFipsCompatibility ALGORITHM_NOT_FIPS = null;
        public static final AlgorithmFipsCompatibility ALGORITHM_REQUIRES_BORINGCRYPTO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AlgorithmFipsCompatibility[] f275746a = null;

        public AlgorithmFipsCompatibility() {
            throw null;
        }

        public abstract boolean isCompatible();

        static {
            final String r100 = "ALGORITHM_NOT_FIPS";
            final int r101 = 0;
            AlgorithmFipsCompatibility r102 = new AnonymousClass1(r100, r101);
            ALGORITHM_NOT_FIPS = r102;
            final String r103 = "ALGORITHM_REQUIRES_BORINGCRYPTO";
            final int r104 = 1;
            AlgorithmFipsCompatibility r105 = new AnonymousClass2(r103, r104);
            ALGORITHM_REQUIRES_BORINGCRYPTO = r105;
            f275746a = new AlgorithmFipsCompatibility[]{r102, r105};
        }

        public static AlgorithmFipsCompatibility[] values() {
            return (AlgorithmFipsCompatibility[]) f275746a.clone();
        }

        public static AlgorithmFipsCompatibility valueOf(String r100) {
            return (AlgorithmFipsCompatibility) r27.a.a(AlgorithmFipsCompatibility.class, r100);
        }

        public AlgorithmFipsCompatibility(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {
    }

    public TinkFipsUtil() {
    }

    static {
        f275744a = Logger.getLogger(TinkFipsUtil.class.getName());
        f275745b = new AtomicBoolean(false);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("org.conscrypt.Conscrypt");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("org.conscrypt.Conscrypt");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("org.conscrypt.Conscrypt");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("org.conscrypt.Conscrypt");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("org.conscrypt.Conscrypt");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("org.conscrypt.Conscrypt");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("org.conscrypt.Conscrypt");
    }
}
