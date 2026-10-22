package ebb;

import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.keva.KevaImpl;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Object f471981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f471982b;

    static {
    }

    public e() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("libcore.io.Libcore");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("libcore.io.Libcore");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("libcore.io.Libcore");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("libcore.io.Libcore");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("libcore.io.Libcore");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("libcore.io.Libcore");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("libcore.io.Libcore");
    }

    public static List b(File r100) {
        ArrayList r101 = new ArrayList();
        if (r100.exists() == true) goto L5;
    L21:
        return r101;
    L5:
        if (r100.isDirectory() == false) goto L21;
        File[] r102 = r100.listFiles();
        if (r102 != null) goto L10;
        return r101;
    L10:
        int r103 = r102.length;
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L21;
        File r105 = r102[r104];
        if (r105.exists() == false) goto L20;
        if (r105.isFile() == false) goto L18;
        Intrinsics.checkNotNull(r105);
        r101.add(r105);
    L18:
        if (r105.isDirectory() == false) goto L20;
        r101.addAll(b(r105));
    L20:
        r104 = r104 + 1;
        goto L11
    }

    public static long f(File r100) {
        Intrinsics.checkNotNullParameter(r100, DocumentType.FOLDER_NAME);
        long r101 = 0;
        File[] r102 = r100.listFiles();     // Catch: Throwable -> L15
        if (r102 == null) goto L6;
        Iterator r103 = ArrayIteratorKt.iterator(r102);     // Catch: Throwable -> L15
    L9:
        if (r103.hasNext() == false) goto L17;
        File r104 = (File) r103.next();     // Catch: Throwable -> L15
        if (r104.isDirectory() == false) goto L13;
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L15
        long r105 = f(r104);     // Catch: Throwable -> L15
    L14:
        r101 = r101 + r105;
        goto L9
    L13:
        r105 = r104.length();     // Catch: Throwable -> L15
    L17:
        return r101;
    L6:
        return r100.length();
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    public static long g(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        boolean r101 = false;
        Field r102 = null;
        if (f471981a != null) goto L6;
    L7:
        Field r103 = a().getDeclaredField("os");     // Catch: Throwable -> L35
        if (r103.isAccessible() == true) goto L10;
        r103.setAccessible(true);     // Catch: Throwable -> L35
    L10:
        Object r104 = r103.get(null);     // Catch: Throwable -> L35
        f471981a = r104;     // Catch: Throwable -> L35
        if (r104 == null) goto L13;
        Method r105 = r104.getClass().getMethod("lstat", new Class[]{String.class});     // Catch: Throwable -> L35
    L14:
        f471982b = r105;     // Catch: Throwable -> L35
    L16:
        if (r100.exists() == true) goto L19;
        return 0;
    L19:
        Method r106 = f471982b;     // Catch: Throwable -> L35
        if (r106 == null) goto L22;
        Object r107 = r106.invoke(f471981a, new Object[]{r100.getAbsolutePath()});     // Catch: Throwable -> L35
    L23:
        if (r107 == null) goto L25;
        r102 = r107.getClass().getDeclaredField("st_atime");     // Catch: Throwable -> L35
    L25:
        if (r102 != null) goto L27;
    L29:
        if (r101 == false) goto L31;
        r102.setAccessible(true);     // Catch: Throwable -> L35
    L31:
        if (r102 == null) goto L34;
        return r102.getLong(r107) * ((long) 1000);
    L34:
        return r100.lastModified();
    L27:
        if (r102.isAccessible() == true) goto L29;
        r101 = true;
        goto L29
    L22:
        r107 = null;
        goto L23
    L13:
        r105 = null;
        goto L14
    L6:
        if (f471982b != null) goto L16;
    L36:
        return r100.lastModified();
    }

    public static List c(String r100, int r110) {
        List r101 = b(new PolarisFileWrapper(r100));
        Intrinsics.checkNotNullParameter(r101, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        ArrayList r102 = new ArrayList();
        ArrayList r103 = (ArrayList) r101;
        if (r103.isEmpty() == true) goto L19;
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        File r106 = (File) r105.next();
        r104.put(r106.getAbsolutePath(), Long.valueOf(g(r106)));
        goto L7
    L9:
        Collections.sort(r101, new d(r104));
        int r107 = 0;
        String r108 = com.larksuite.framework.utils.e.c(new Date(g((File) ListProtector.get(r101, 0))), "yyyy-MM-dd");
        Iterator r109 = r103.iterator();
    L11:
        if (r109.hasNext() == false) goto L18;
        String r111 = com.larksuite.framework.utils.e.c(new Date(g((File) r109.next())), "yyyy-MM-dd");
        if (TextUtils.equals(r111, r108) == true) goto L15;
        r110 = r110 - 1;
        r108 = r111;
    L15:
        if (r110 <= 0) goto L18;
        r107 = r107 + 1;
    L18:
        r102.addAll(r103.subList(r107, r103.size()));
    L19:
        return r102;
    }

    public static List d(String r100, int r101) {
        ArrayList r102 = new ArrayList();
        ArrayList r103 = (ArrayList) b(new PolarisFileWrapper(r100));
        if (r103.isEmpty() == false) goto L5;
        return r102;
    L5:
        Iterator r104 = r103.iterator();
    L7:
        if (r104.hasNext() == false) goto L11;
        File r105 = (File) r104.next();
        if ((Math.abs(System.currentTimeMillis() - g(r105)) - (((long) r101) * 86400000)) <= 0) goto L7;
        r102.add(r105);
        goto L7
    L11:
        return r102;
    }

    public static List e(VFSFile r100, String r101) {
        ArrayList r102 = new ArrayList();
        if (r100.exists() == true) goto L5;
    L23:
        return r102;
    L5:
        if (r100.isDirectory() == false) goto L23;
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return r102;
    L10:
        File[] r103 = r100.listFiles();
        if (r103 != null) goto L13;
        return r102;
    L13:
        int r104 = r103.length;
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L23;
        File r106 = r103[r105];
        if (r106.exists() == false) goto L22;
        if (r106.isFile() == false) goto L22;
        String r107 = r106.getName();
        Intrinsics.checkNotNull(r101);
        if (StringsKt.startsWith$default(r107, r101, false, 2, null) == false) goto L22;
        Intrinsics.checkNotNull(r106);
        r102.add(r106);
    L22:
        r105 = r105 + 1;
        goto L14
    }
}
