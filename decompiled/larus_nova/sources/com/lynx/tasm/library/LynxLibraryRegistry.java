package com.lynx.tasm.library;

import android.app.Application;
import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.IServiceProvider;
import el9.a;
import i8a.n;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public final class LynxLibraryRegistry {
    private static final String TAG = "LynxLibraryRegistry";
    private static final Set<String> sRegisteredGlobalProviders = null;
    private final LynxViewBuilder mBuilder;
    private final Context mContext;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sRegisteredGlobalProviders = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public Context getContextOrThrow() {
        Context r100 = this.mContext;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Context is only available in setupGlobal().");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_tasm_library_LynxLibraryRegistry_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static IServiceProvider createService(Class<? extends IServiceProvider> r100) {
        Object r101 = r100.getField("INSTANCE").get(null);     // Catch: Throwable -> L7 NoSuchFieldException -> L15
        if ((r101 instanceof IServiceProvider) == false) goto L16;
        return (IServiceProvider) r101;
    L7:
        th = move-exception;
        LLog.w(TAG, "Failed to read service singleton " + r100.getName() + ": " + th);
    L16:
        Constructor<? extends IServiceProvider> r102 = r100.getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L12
        r102.setAccessible(true);     // Catch: Throwable -> L12
        return r102.newInstance(new Object[0]);
    L12:
        th = move-exception;
        LLog.e(TAG, "Failed to create service " + r100.getName() + ": " + th);
        return null;
    }

    public void addBehaviors(List<com.lynx.tasm.behavior.a> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L13;
        LynxViewBuilder r101 = this.mBuilder;
        if (r101 == null) goto L9;
        r101.addBehaviors(r100);
        return;
    L9:
        LynxEnv.inst().addBehaviors(r100);
        return;
    }

    public void registerService(Class<? extends IServiceProvider> r100) {
        IServiceProvider r101 = createService(r100);
        if (r101 == null) goto L6;
        n.c().d(r101);
        return;
    }

    public void registerService(IServiceProvider r100) {
        n.c().d(r100);
    }

    private LynxLibraryRegistry(Context r100, LynxViewBuilder r101) {
        this.mContext = r100;
        this.mBuilder = r101;
    }

    private static void setup(LynxLibraryRegistry r100, String[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        String r104 = r101[r103];
        if (r104 == null) goto L10;
        if (r104.length() == 0) goto L10;
        setupProvider(r100, r104);
    L10:
        r103 = r103 + 1;
        goto L3
    }

    private static void setupGlobal(LynxLibraryRegistry r100, String[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L16;
        String r104 = r101[r103];
        if (r104 == null) goto L15;
        if (r104.length() == 0) goto L15;
        Set<String> r105 = sRegisteredGlobalProviders;
        if (r105.add(r104) == false) goto L15;
        if (setupProvider(r100, r104) == true) goto L15;
        r105.remove(r104);
    L15:
        r103 = r103 + 1;
        goto L3
    }

    private static boolean setupProvider(LynxLibraryRegistry r100, String r101) {
        Constructor r102 = INVOKESTATIC_com_lynx_tasm_library_LynxLibraryRegistry_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101).getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L9
        r102.setAccessible(true);     // Catch: Throwable -> L9
        Object r103 = r102.newInstance(new Object[0]);     // Catch: Throwable -> L9
        if ((r103 instanceof LynxLibraryProvider) == false) goto L7;
        ((LynxLibraryProvider) r103).register(r100);     // Catch: Throwable -> L9
        return true;
    L7:
        LLog.e(TAG, r101 + " does not implement LynxLibraryProvider");     // Catch: Throwable -> L9
    L11:
        return false;
    L9:
        th = move-exception;
        LLog.w(TAG, "Skip unavailable Lynx library provider " + r101 + ": " + th);
        goto L11
    }

    public void registerModule(String r100, Class<? extends LynxModule> r101) {
        registerModule(r100, r101, null);
    }

    public static void setup(LynxViewBuilder r100, String[] r101) {
        setup(new LynxLibraryRegistry(null, r100), r101);
    }

    public static void setupGlobal(Context r100, String[] r101) {
        setupGlobal(new LynxLibraryRegistry(r100, null), r101);
        Context r102 = r100.getApplicationContext();
        if ((r102 instanceof Application) == false) goto L6;
        n.c().b((Application) r102);
        return;
    }

    public void registerModule(String r100, Class<? extends LynxModule> r101, Object r102) {
        LynxViewBuilder r103 = this.mBuilder;
        if (r103 == null) goto L5;
        r103.registerModule(r100, r101, r102);
        return;
    L5:
        LynxEnv.inst().registerModule(r100, r101, r102);
    }
}
