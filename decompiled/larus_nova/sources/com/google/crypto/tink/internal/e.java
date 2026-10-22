package com.google.crypto.tink.internal;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275756a = null;

    public class a extends ThreadLocal<SecureRandom> {
        @Override // java.lang.ThreadLocal
        public final SecureRandom initialValue() {
            SecureRandom r100 = SecureRandom.getInstance("SHA1PRNG", "GmsCore_OpenSSL");     // Catch: GeneralSecurityException -> L5
        L23:
            r100.nextLong();
            return r100;
        L22:
            r100 = new SecureRandom();
        L5:
            r100 = SecureRandom.getInstance("SHA1PRNG", "AndroidOpenSSL");     // Catch: GeneralSecurityException -> L7
        L7:
            r100 = SecureRandom.getInstance("SHA1PRNG", "Conscrypt");     // Catch: GeneralSecurityException -> L9
        L9:
            r100 = SecureRandom.getInstance("SHA1PRNG", (Provider) e.a().getMethod("newProvider", new Class[0]).invoke(null, new Object[0]));     // Catch: GeneralSecurityException -> L22
            goto L23
        L19:
            e = e;
        L21:
            throw new GeneralSecurityException("Failed to get Conscrypt provider", e);     // Catch: GeneralSecurityException -> L22
        L11:
            e = e;
        L15:
            e = e;
        L17:
            e = e;
        L13:
            e = e;
            goto L21
        }

        public a() {
        }
    }

    static {
        f275756a = new a();
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
