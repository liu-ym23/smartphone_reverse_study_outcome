package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Log;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CronetProvider {
    private static final String GMS_CORE_CRONET_PROVIDER_CLASS = "com.google.android.gms.net.GmsCoreCronetProvider";
    private static final String JAVA_CRONET_PROVIDER_CLASS = "com.ttnet.org.chromium.net.impl.JavaCronetProvider";
    private static final String NATIVE_CRONET_PROVIDER_CLASS = "com.ttnet.org.chromium.net.impl.NativeCronetProvider";
    private static final String PLAY_SERVICES_CRONET_PROVIDER_CLASS = "com.google.android.gms.net.PlayServicesCronetProvider";
    public static final String PROVIDER_NAME_APP_PACKAGED = "App-Packaged-Cronet-Provider";
    public static final String PROVIDER_NAME_FALLBACK = "Fallback-Cronet-Provider";
    private static final String RES_KEY_CRONET_IMPL_CLASS = "CronetProviderClassName";
    private static final String TAG = null;
    protected final Context mContext;

    public abstract CronetEngine.Builder createBuilder(boolean r100);

    public abstract String getName();

    public abstract String getVersion();

    public abstract boolean isEnabled();

    static {
        TAG = "CronetProvider";
    }

    public String toString() {
        return "[class=" + getClass().getName() + ", name=" + getName() + ", version=" + getVersion() + ", enabled=" + isEnabled() + "]";
    }

    public CronetProvider(Context r100) {
        if (r100 == null) goto L7;
        this.mContext = r100;
        return;
    L7:
        throw new IllegalArgumentException("Context must not be null");
    }

    public static List<CronetProvider> getAllProviders(Context r100) {
        LinkedHashSet r101 = new LinkedHashSet();
        addCronetProviderImplByClassName(r100, NATIVE_CRONET_PROVIDER_CLASS, r101, false);
        return Collections.unmodifiableList(new ArrayList(r101));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_ttnet_org_chromium_net_CronetProvider_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    private static boolean addCronetProviderFromResourceFile(Context r100, Set<CronetProvider> r101) {
        int r102 = r100.getResources().getIdentifier(RES_KEY_CRONET_IMPL_CLASS, "string", r100.getPackageName());
        boolean r103 = false;
        if (r102 != 0) goto L5;
        return false;
    L5:
        String r104 = r100.getResources().getString(r102);
        if (r104 != null) goto L8;
    L19:
        return r103;
    L8:
        if (r104.equals(PLAY_SERVICES_CRONET_PROVIDER_CLASS) == true) goto L19;
        if (r104.equals(GMS_CORE_CRONET_PROVIDER_CLASS) == true) goto L19;
        if (r104.equals(JAVA_CRONET_PROVIDER_CLASS) == true) goto L19;
        if (r104.equals(NATIVE_CRONET_PROVIDER_CLASS) == true) goto L19;
        r103 = true;
        if (addCronetProviderImplByClassName(r100, r104, r101, true) == true) goto L19;
        goto L19
    }

    private static void logReflectiveOperationException(String r100, boolean r101, Exception r102) {
        if (r101 == false) goto L5;
        return;
    L5:
        if (Log.isLoggable(TAG, 3) == true) goto L7;
        return;
    }

    private static boolean addCronetProviderImplByClassName(Context r100, String r101, Set<CronetProvider> r102, boolean r103) {
        r102.add((CronetProvider) INVOKEVIRTUAL_com_ttnet_org_chromium_net_CronetProvider_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100.getClassLoader(), r101).asSubclass(CronetProvider.class).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r100}));     // Catch: ClassNotFoundException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 InvocationTargetException -> L11 InstantiationException -> L13
        return true;
    L5:
        e = move-exception;
        logReflectiveOperationException(r101, r103, e);
    L15:
        return false;
    L7:
        e = move-exception;
        logReflectiveOperationException(r101, r103, e);
    L13:
        e = move-exception;
        logReflectiveOperationException(r101, r103, e);
    L9:
        e = move-exception;
        logReflectiveOperationException(r101, r103, e);
    L11:
        e = move-exception;
        logReflectiveOperationException(r101, r103, e);
        goto L15
    }
}
