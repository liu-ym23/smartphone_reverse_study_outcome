package com.ss.android.ttve.nativePort;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.vesdk.runtime.VESafelyLibsLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public final class TECodecNativeLibsLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile LoadStatus f449953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f449954b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList<Object> f449955c = null;

    public static final enum LoadStatus extends Enum<LoadStatus> {
        public static final LoadStatus LOADED = null;
        public static final LoadStatus LOADING = null;
        public static final LoadStatus NOT_LOAD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadStatus[] f449956a = null;

        static {
            LoadStatus r100 = new LoadStatus("NOT_LOAD", 0);
            NOT_LOAD = r100;
            LoadStatus r101 = new LoadStatus("LOADING", 1);
            LOADING = r101;
            LoadStatus r102 = new LoadStatus("LOADED", 2);
            LOADED = r102;
            f449956a = new LoadStatus[]{r100, r101, r102};
        }

        public static LoadStatus[] values() {
            return (LoadStatus[]) f449956a.clone();
        }

        public static LoadStatus valueOf(String r100) {
            return (LoadStatus) r27.a.a(LoadStatus.class, r100);
        }

        public LoadStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {
        public a() {
        }

        public final boolean a(List<String> r100) {
            LoadStatus r101 = TECodecNativeLibsLoader.f449953a;
            System.currentTimeMillis();
            Iterator<String> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L10;
            String r103 = r102.next();
            System.currentTimeMillis();
            qgc.a.a(3, "Start loadLibrary " + r103);
            LoadStatus r104 = TECodecNativeLibsLoader.f449953a;
            if (VESafelyLibsLoader.loadLibrary(r103, null) == false) goto L8;
            System.currentTimeMillis();
            System.currentTimeMillis();
            goto L4
        L8:
            return false;
        L10:
            return true;
        }
    }

    public TECodecNativeLibsLoader() {
    }

    public static void c() {
        int r100 = 0;
        a().getDeclaredMethod("loadAllLibs", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        if (f449953a != LoadStatus.LOADED) goto L9;
        return;
    L9:
        List<String> r101 = b();
        ArrayList r102 = (ArrayList) r101;
        String[] r103 = new String[r102.size()];
    L11:
        if (r100 >= r102.size()) goto L21;
        if (((String) ListProtector.get(r101, r100)).contentEquals("c++_shared") == true) goto L20;
        if (((String) ListProtector.get(r101, r100)).contentEquals("ttboringssl") == true) goto L20;
        if (((String) ListProtector.get(r101, r100)).contentEquals("ttcrypto") == true) goto L20;
        r103[r100] = "lib" + ((String) ListProtector.get(r101, r100)) + ".so";
    L20:
        r100 = r100 + 1;
        goto L11
    L21:
        f449953a = LoadStatus.LOADING;
        if (f449954b.a(r101) == true) goto L25;
        f449953a = LoadStatus.NOT_LOAD;
        return;
    L25:
        f449953a = LoadStatus.LOADED;
    }

    static {
        f449953a = LoadStatus.NOT_LOAD;
        f449954b = new a();
        f449955c = new ArrayList();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.ss.android.ttve.nativePort.TENativeLibsLoader");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.ttve.nativePort.TENativeLibsLoader");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.ttve.nativePort.TENativeLibsLoader");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.ss.android.ttve.nativePort.TENativeLibsLoader");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.ttve.nativePort.TENativeLibsLoader");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.ttve.nativePort.TENativeLibsLoader");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.ttve.nativePort.TENativeLibsLoader");
    }

    public static List<String> b() {
        ArrayList r100 = new ArrayList();
        r100.add("c++_shared");
        r100.add("iesapplogger");
        r100.add("bytevc0");
        r100.add("ByteVC1_dec");
        r100.add("fdk-aac");
        ArrayList r101 = new ArrayList();
        r101.add("ttcrypto");     // Catch: Exception -> L6
        r101.add("ttboringssl");     // Catch: Exception -> L6
        r101.add("ttffmpeg");     // Catch: Exception -> L6
    L4:
        r100.addAll(r101);
        r100.add("yuv");
        r100.add("ttheif_enc");
        r100.add("ttvesdk");
        return r100;
    }

    public static synchronized void d() {
        monitor-enter(TECodecNativeLibsLoader.class);
        c();     // Catch: Throwable -> L7
        monitor-exit(TECodecNativeLibsLoader.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
