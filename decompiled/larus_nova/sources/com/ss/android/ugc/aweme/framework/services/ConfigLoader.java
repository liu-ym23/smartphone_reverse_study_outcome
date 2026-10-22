package com.ss.android.ugc.aweme.framework.services;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
class ConfigLoader {
    private static final Map<String, List<CacheItem>> CLASSES = null;
    private static final String[] DIRS = null;

    /* JADX INFO: loaded from: classes40.dex */
    public static class CacheItem {
        public Object cacheService;
        public final String className;
        public final boolean persistence;

        public static CacheItem fromConfig(String r100) {
            if (r100 != null) goto L4;
            return null;
        L4:
            if ("".equals(r100) == true) goto L12;
            String[] r101 = r100.split(":");
            boolean r102 = false;
            String r103 = r101[0];
            if (r101.length <= 1) goto L9;
            r102 = Boolean.parseBoolean(r101[1]);
        L9:
            return new CacheItem(r103, r102);
        L12:
            return null;
        }

        public CacheItem(String r100, boolean r101) {
            this.className = r100;
            this.persistence = r101;
        }
    }

    /* JADX INFO: loaded from: classes40.dex */
    public static class ConfigIterator<T> implements Iterator<T> {
        private Class mClass;
        private ClassLoader mClassLoader;
        private List<CacheItem> mClasses;
        private int mIndex;

        public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
            return Class.forName(r100, r101, r102);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            List<CacheItem> r100 = this.mClasses;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (this.mIndex >= r100.size()) goto L7;
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            CacheItem r100 = (CacheItem) ListProtector.get(this.mClasses, this.mIndex);
            this.mIndex++;
            monitor-enter(r100);
            boolean r101 = r100.persistence;     // Catch: Throwable -> L17
            if (r101 == false) goto L10;
            T r102 = (T) r100.cacheService;
            if (r102 == null) goto L10;
            monitor-exit(r100);     // Catch: Throwable -> L17
            return r102;
        L10:
            if (r101 == false) goto L14;
            T r103 = newService(r100);     // Catch: Throwable -> L17
            r100.cacheService = r103;     // Catch: Throwable -> L17
            monitor-exit(r100);     // Catch: Throwable -> L17
            return r103;
        L14:
            monitor-exit(r100);     // Catch: Throwable -> L17
            return newService(r100);
        L17:
            th = move-exception;
            throw th;
        }

        private T newService(CacheItem r100) {
            Class<?> r101 = INVOKESTATIC_com_ss_android_ugc_aweme_framework_services_ConfigLoader$ConfigIterator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100.className, false, this.mClassLoader);     // Catch: ClassNotFoundException -> L21
            if (this.mClass.isAssignableFrom(r101) == false) goto L20;
            Constructor<T> r102 = r101.getDeclaredConstructor(new Class[0]);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 InstantiationException -> L16
            r102.setAccessible(true);     // Catch: InvocationTargetException -> L7 NoSuchMethodException -> L10 IllegalAccessException -> L13 InstantiationException -> L16
            return r102.newInstance(new Object[0]);
        L13:
            e = move-exception;
            throw new RuntimeException(e);
        L16:
            e = move-exception;
            throw new RuntimeException(e);
        L10:
            e = move-exception;
            throw new RuntimeException(e);
        L7:
            e = move-exception;
            throw new RuntimeException(e);
        L20:
            throw new RuntimeException(new ClassCastException("source: " + r101.getName() + ", dest: " + this.mClass.getName()));
        L21:
            e = move-exception;
            throw new RuntimeException(e);
        }

        public ConfigIterator(List<CacheItem> r100, Class<T> r101, ClassLoader r102) {
            this.mIndex = 0;
            this.mClassLoader = r102;
            this.mClass = r101;
            this.mClasses = r100;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_ss_android_ugc_aweme_framework_services_ConfigLoader$ConfigIterator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r105;
        L8:
            th = move-exception;
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r106;
        L17:
            th = move-exception;
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
    }

    public ConfigLoader() {
    }

    static {
        DIRS = new String[]{"services/", "services/AwemeLive/", "services/AwemeIM/", "services/AwemeReactNative/", "services/AwemePush/", "services/AwemeShare/", "services/AwemeMain/", "services/AwemePlugin/", "services/SdkDebugger/", "services/AwemeMusic/", "services/AwemeVideo/", "services/AwemeFramework/", "services/AwemeCommerce/"};
        CLASSES = Collections.synchronizedMap(new LinkedHashMap());
        addCache("com.bytedance.geckox.settings.IGeckoRegister", "com.bytedance.android.ec.core.gecko.ECGeckoRegister");
    }

    private static void closeQuietly(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static <T> Iterator<T> iterator(Class<T> r100) {
        ClassLoader r101 = r100.getClassLoader();
        return new ConfigIterator(loadClasses(r100, r101), r100, r101);
    }

    private static List<CacheItem> parse(URL r100) {
        LinkedList r101 = new LinkedList();
        BufferedReader r102 = null;
        InputStream r103 = r100.openStream();     // Catch: Throwable -> L23 IOException -> L25
        InputStreamReader r104 = new InputStreamReader(r103);     // Catch: Throwable -> L19 IOException -> L21
    L41:
        BufferedReader r105 = new BufferedReader(r104);     // Catch: Throwable -> L15 IOException -> L17
        String r106 = r105.readLine();     // Catch: IOException -> L13 Throwable -> L30
    L7:
        if (r106 == null) goto L28;
        CacheItem r107 = CacheItem.fromConfig(r106);     // Catch: IOException -> L13 Throwable -> L30
        if (r107 == null) goto L11;
        r101.add(r107);     // Catch: IOException -> L13 Throwable -> L30
    L11:
        r106 = r105.readLine();     // Catch: IOException -> L13 Throwable -> L30
    L28:
        closeQuietly(r105);
        closeQuietly(r104);
        closeQuietly(r103);
        return r101;
    L13:
        IOException e100 = e;
    L27:
        e100.printStackTrace();     // Catch: Throwable -> L30
    L30:
        th = th;
        r102 = r105;
    L32:
        closeQuietly(r102);
        closeQuietly(r104);
        closeQuietly(r103);
        throw th;
    L17:
        e = move-exception;
        r105 = null;
        e100 = e;
    L15:
        th = th;
    L21:
        e = move-exception;
        r105 = null;
        e100 = e;
        r104 = null;
    L19:
        th = th;
        r104 = null;
        goto L32
    L25:
        e = move-exception;
        r104 = null;
        r105 = null;
        e100 = e;
        r103 = null;
    L23:
        th = th;
        r103 = null;
        r104 = null;
        goto L32
    }

    private static List<CacheItem> parseSafely(URL r100) {
        int r101 = 0;
    L4:
        if (r101 >= 3) goto L18;
        return parse(r100);
    L7:
        e = move-exception;
        if (r101 >= 2) goto L16;
        Thread.sleep(2);     // Catch: InterruptedException -> L13
    L15:
        r101 = r101 + 1;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L16:
        throw e;
    L18:
        return new LinkedList();
    }

    private static void addCache(String r100, String r101) {
        String[] r102 = r101.split("\n");
        ArrayList r103 = new ArrayList();
        int r104 = r102.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r103.add(CacheItem.fromConfig(r102[r105]));
        r105 = r105 + 1;
        goto L3
    L5:
        CLASSES.put(r100, r103);
    }

    private static <T> List<CacheItem> loadClasses(Class<T> r100, ClassLoader r101) {
        Map<String, List<CacheItem>> r102 = CLASSES;
        monitor-enter(r102);
        List<CacheItem> r103 = r102.get(r100.getName());     // Catch: Throwable -> L28
        if (r103 == null) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L28
        return r103;
    L8:
        monitor-exit(r102);     // Catch: Throwable -> L28
        LinkedList r104 = new LinkedList();
        String[] r105 = DIRS;
        int r106 = r105.length;
        int r107 = 0;
    L10:
        if (r107 >= r106) goto L17;
        Enumeration<URL> r108 = getUrls(r100, r101, r105[r107]);
    L12:
        if (r108 == null) goto L16;
        if (r108.hasMoreElements() == false) goto L16;
        r104.addAll(parseSafely(r108.nextElement()));
    L16:
        r107 = r107 + 1;
        goto L10
    L17:
        Map<String, List<CacheItem>> r109 = CLASSES;
        monitor-enter(r109);
    L25:
        th = move-exception;
        throw th;
    L20:
        if (r109.containsKey(r100.getName()) == true) goto L22;
        r109.put(r100.getName(), r104);     // Catch: Throwable -> L25
        List<CacheItem> r110 = r104;
    L23:
        monitor-exit(r109);     // Catch: Throwable -> L25
        return r110;
    L22:
        r110 = r109.get(r100.getName());     // Catch: Throwable -> L25
    L28:
        th = move-exception;
        throw th;
    }

    private static Enumeration<URL> getUrls(Class r100, ClassLoader r101, String r102) {
        String r103 = r102 + r100.getName();
        if (r101 == null) goto L16;
        return r101.getResources(r103);
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L16:
        return ClassLoader.getSystemResources(r103);
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
