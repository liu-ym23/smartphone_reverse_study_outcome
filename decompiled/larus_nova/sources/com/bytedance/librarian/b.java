package com.bytedance.librarian;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import cf6.i;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import dalvik.system.BaseDexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f254579n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f254580o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f254581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f254582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, a> f254583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PolarisFileWrapper f254584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PolarisFileWrapper f254585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f254586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ZipFile[] f254587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f254588h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ApplicationInfo f254589i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, String> f254590j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String[] f254591k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f254592l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String[] f254593m;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f254594a;

        public final String toString() {
            return Boolean.toString(this.f254594a);
        }

        public a() {
            this.f254594a = false;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.librarian.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes6.dex */
    public class C3622b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RandomAccessFile f254595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public FileLock f254596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public FileChannel f254597c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final File f254598d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ b f254599e;

        public final void a() {
            FileLock r100 = this.f254596b;
            if (r100 != null) goto L8;
        L5:
            this.f254599e.f254582b.a("released lock " + this.f254598d.getPath());
            this.f254599e.b(this.f254597c);
            this.f254599e.b(this.f254595a);
            return;
        L8:
            r100.release();     // Catch: IOException -> L7
            goto L5
        }

        public final void b() throws IOException {
            RandomAccessFile r100 = new RandomAccessFile(this.f254598d, "rw");
            this.f254595a = r100;
            this.f254597c = r100.getChannel();     // Catch: IOException -> L10
            this.f254599e.f254582b.a("blocking on lock " + this.f254598d.getPath());     // Catch: IOException -> L7
            this.f254596b = this.f254597c.lock();     // Catch: IOException -> L7
            this.f254599e.f254582b.a("acquired on lock " + this.f254598d.getPath());     // Catch: IOException -> L10
            return;
        L7:
            e = move-exception;
            this.f254599e.b(this.f254597c);     // Catch: IOException -> L10
            throw e;     // Catch: IOException -> L10
        L10:
            e = move-exception;
            this.f254599e.b(this.f254595a);
            throw e;
        }

        public C3622b(b r100, PolarisFileWrapper r101) {
            this.f254599e = r100;
            this.f254598d = r101;
        }
    }

    static {
        f254580o = new String[]{"log", "m", "stdc++", "dl", "c", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "android", "jnigraphics", "EGL", "GLESv1_CM", "GLESv2", "GLESv3", "OpenSLES", "OpenMAXAL"};
        Context r100 = com.bytedance.librarian.a.f254575a;
        com.bytedance.librarian.a.f254575a = null;
        if (r100 == null) goto L35;
        ApplicationInfo r101 = r100.getApplicationInfo();
        File r102 = r100.getDir("librarian", 0);
        if (r102.exists() == true) goto L8;
        r102.mkdirs();
    L8:
        if (com.bytedance.librarian.a.f254576b == null) goto L10;
        String r103 = com.bytedance.librarian.a.f254576b;
    L11:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r102, r103 + "." + (new PolarisFileWrapper(r101.sourceDir).lastModified() >> 8));
        File[] r105 = r102.listFiles();
        if (r105 == null) goto L25;
        int r106 = r105.length;
        int r107 = 0;
    L14:
        if (r107 >= r106) goto L25;
        File r108 = r105[r107];
        if (r104.getName().equals(r108.getName()) == true) goto L24;
        File[] r109 = r108.listFiles();
        if (r109 == null) goto L23;
        int r110 = r109.length;
        int r111 = 0;
    L21:
        if (r111 >= r110) goto L23;
        r109[r111].delete();
        r111 = r111 + 1;
    L23:
        r108.delete();
    L24:
        r107 = r107 + 1;
    L25:
        r104.mkdirs();
        if (r104.exists() == false) goto L32;
        c r112 = com.bytedance.librarian.a.f254577c;
        if (r112 != null) goto L31;
        r112 = new c();
    L31:
        f254579n = new b(r101, r104, r112);
        return;
    L32:
        f254579n = null;
        return;
    L10:
        r103 = "default.version";
        goto L11
    L35:
        throw new LibrarianUnsatisfiedLinkError("you should call init first or use loadLibraryForModule.");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("dalvik.system.VMRuntime");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("dalvik.system.VMRuntime");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("dalvik.system.VMRuntime");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("dalvik.system.VMRuntime");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("dalvik.system.VMRuntime");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("dalvik.system.VMRuntime");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("dalvik.system.VMRuntime");
    }

    public static String f(String r100) {
        return "lib" + r100 + ".so";
    }

    public final void b(Closeable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        this.f254582b.c("failed to close resource", e);
    }

    public final boolean c(PolarisFileWrapper r100) throws IOException {
        d(r100.getName());
        String r101 = "lib/" + this.f254592l + HTTP.URL_DEFAULT + r100.getName();
        ZipFile[] r102 = this.f254587g;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L14;
        ZipFile r105 = r102[r104];
        ZipEntry r106 = r105.getEntry(r101);
        if (r106 != null) goto L7;
        r104 = r104 + 1;
        goto L3
    L7:
        InputStream r107 = r105.getInputStream(r106);
        k(r107, r100);     // Catch: Throwable -> L11
        this.f254582b.a("get lib file " + r100.getPath() + " from " + r101 + " of " + r105.getName());     // Catch: Throwable -> L11
        b(r107);
        return true;
    L11:
        th = move-exception;
        b(r107);
        throw th;
    L14:
        return false;
    }

    public final void d(String r110) {
        if (this.f254592l == null) goto L5;
        return;
    L5:
        String[] r100 = this.f254591k;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L27;
        String r104 = r100[r103];
        if (this.f254588h != null) goto L10;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L26;
        String r106 = "lib/" + r104 + HTTP.URL_DEFAULT + r110;
        ZipFile[] r107 = this.f254587g;
        int r108 = r107.length;
        int r109 = 0;
    L18:
        if (r109 >= r108) goto L26;
        ZipFile r111 = r107[r109];
        if (r111 == null) goto L25;
        if (r111.getEntry(r106) == null) goto L25;
        this.f254592l = r104;
        this.f254582b.a("ensure that abi is " + r104);
        return;
    L25:
        r109 = r109 + 1;
    L26:
        r103 = r103 + 1;
        goto L6
    L10:
        String r112 = (String) ((HashMap) this.f254590j).get(r104);
        String r113 = this.f254588h;
        if (r112 != null) goto L14;
        r112 = r104;
    L14:
        r105 = r113.equals(r112);
        goto L15
    L27:
        StringBuilder r114 = new StringBuilder("can not ensure abi for ");
        r114.append(r110);
        r114.append(", check ");
        r114.append(this.f254588h);
        r114.append(", apks ");
        StringBuilder r115 = new StringBuilder("[");
        ZipFile[] r116 = this.f254587g;
        int r117 = r116.length;
    L28:
        if (r102 >= r117) goto L33;
        ZipFile r118 = r116[r102];
        if (r118 == null) goto L32;
        String r119 = r118.getName();
        PolarisFileWrapper r120 = new PolarisFileWrapper(r119);
        r115.append(r119);
        r115.append("#");
        r115.append(r118.size());
        r115.append(":");
        r115.append(r120.length());
        r115.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
    L32:
        r102 = r102 + 1;
        goto L28
    L33:
        r115.append("]");
        r114.append(r115.toString());
        throw new LibrarianUnsatisfiedLinkError(r114.toString());
    }

    public final void e(PolarisFileWrapper r100) {
        String r101 = r100.getName();
        monitor-enter(this);
        C3622b r102 = new C3622b(this, this.f254584d);     // Catch: Throwable -> L19
        r102.b();     // Catch: Throwable -> L12 IOException -> L14
        if (c(r100) == false) goto L11;
        r102.a();     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L11:
        throw new LibrarianUnsatisfiedLinkError("fail to extract " + r101);     // Catch: Throwable -> L12 IOException -> L14
    L12:
        th = move-exception;
        r102.a();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L14:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to extract " + r101, e);     // Catch: Throwable -> L12
    L19:
        th = move-exception;
        throw th;
    }

    public final void h(String r100) {
        Map<String, a> r101 = this.f254583c;
        monitor-enter(r101);
        a r102 = (a) ((HashMap) this.f254583c).get(r100);     // Catch: Throwable -> L24
        if (r102 != null) goto L7;
        r102 = new a();     // Catch: Throwable -> L24
        ((HashMap) this.f254583c).put(r100, r102);     // Catch: Throwable -> L24
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L24
        monitor-enter(r102);
    L21:
        th = move-exception;
        throw th;
    L14:
        if (r102.f254594a == false) goto L18;
        this.f254582b.a("lib was already loaded before: " + r100);     // Catch: Throwable -> L21
        monitor-exit(r102);     // Catch: Throwable -> L21
        return;
    L18:
        i(r100);     // Catch: Throwable -> L21
        r102.f254594a = true;     // Catch: Throwable -> L21
        monitor-exit(r102);     // Catch: Throwable -> L21
        return;
    L7:
        if (r102.f254594a == false) goto L11;
        monitor-exit(r101);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public final void i(String r110) {
        int r100 = Build.VERSION.SDK_INT;
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f254581a, f(r110));
        if (j(r110, "preload") == false) goto L5;
        return;
    L5:
        boolean r102 = false;
        if (r101.exists() == false) goto L11;
        if (g(r101, r110, false) == false) goto L11;
        return;
    L11:
        if (this.f254586f == true) goto L43;
        monitor-enter(this);
    L201:
        th = move-exception;
        throw th;
    L15:
        if (this.f254586f == false) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L201
        goto L43
    L18:
        PolarisFileWrapper r103 = new PolarisFileWrapper(this.f254589i.sourceDir);     // Catch: Throwable -> L201
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L201
        r104.add(r103);     // Catch: Throwable -> L201
        String[] r105 = this.f254589i.splitSourceDirs;     // Catch: Throwable -> L201
        if (r105 != null) goto L21;
    L25:
        ZipFile[] r106 = new ZipFile[r104.size()];     // Catch: Throwable -> L201
        Iterator r107 = r104.iterator();     // Catch: Throwable -> L201
        int r108 = 0;
    L27:
        if (r107.hasNext() == false) goto L35;
        File r111 = (File) r107.next();     // Catch: Throwable -> L201
        int r112 = r108 + 1;
        r106[r108] = new PolarisZipFileWrapper(r111);     // Catch: IOException -> L32 Throwable -> L201
    L34:
        r108 = r112;
    L32:
        e = move-exception;
        new LibrarianUnsatisfiedLinkError("fail to get zip file " + r111.getName() + ", size " + r111.length() + ", exists " + r111.exists(), e).printStackTrace();     // Catch: Throwable -> L201
        goto L34
    L35:
        this.f254587g = r106;     // Catch: Throwable -> L201
        this.f254585e = new PolarisFileWrapper(this.f254589i.nativeLibraryDir);     // Catch: Throwable -> L201
        HashMap r109 = new HashMap();     // Catch: Throwable -> L201
        this.f254590j = r109;     // Catch: Throwable -> L201
        r109.put("arm64-v8a", "arm64");     // Catch: Throwable -> L201
        ((HashMap) this.f254590j).put("armeabi-v7a", "arm");     // Catch: Throwable -> L201
        ((HashMap) this.f254590j).put("armeabi", "arm");     // Catch: Throwable -> L201
        Class r113 = a();     // Catch: Exception -> L38 Throwable -> L201
        String r114 = (String) r113.getDeclaredMethod("vmInstructionSet", new Class[0]).invoke(r113.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0]);     // Catch: Exception -> L38 Throwable -> L201
    L40:
        this.f254588h = r114;     // Catch: Throwable -> L201
        this.f254582b.a("vm instruction set: " + this.f254588h);     // Catch: Throwable -> L201
        this.f254591k = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L201
        this.f254586f = true;     // Catch: Throwable -> L201
        monitor-exit(this);     // Catch: Throwable -> L201
        goto L43
    L38:
        e = move-exception;
        this.f254582b.c("fail to process vm abi previously", new LibrarianUnsatisfiedLinkError("reflect err", e));     // Catch: Throwable -> L201
        r114 = null;
        goto L40
    L21:
        if (r105.length == 0) goto L25;
        int r115 = r105.length;     // Catch: Throwable -> L201
        int r116 = 0;
    L23:
        if (r116 >= r115) goto L25;
        r104.add(new PolarisFileWrapper(r105[r116]));     // Catch: Throwable -> L201
        r116 = r116 + 1;     // Catch: Throwable -> L201
    L43:
        if (r100 >= 23) goto L45;
        boolean r117 = true;
    L46:
        if (r117 == false) goto L126;
        String r118 = this.f254588h;
        if (r118 != null) goto L51;
    L53:
        boolean r119 = false;
    L54:
        if (r119 == false) goto L126;
        this.f254582b.a("try to opt native lib dirs on L");
        BaseDexClassLoader r120 = (BaseDexClassLoader) b.class.getClassLoader();     // Catch: Exception -> L123
        Field r121 = BaseDexClassLoader.class.getDeclaredField("pathList");     // Catch: Exception -> L123
        r121.setAccessible(true);     // Catch: Exception -> L123
        Object r122 = r121.get(r120);     // Catch: Exception -> L123
        Field r123 = r122.getClass().getDeclaredField("nativeLibraryDirectories");     // Catch: Exception -> L123
        r123.setAccessible(true);     // Catch: Exception -> L123
        File[] r124 = (File[]) r123.get(r122);     // Catch: Exception -> L123
        int r125 = r124.length;     // Catch: Exception -> L123
        File[] r126 = new File[r125];     // Catch: Exception -> L123
        System.arraycopy(r124, 0, r126, 0, r125);     // Catch: Exception -> L123
        int r127 = 0;
        int r128 = -1;
        int r129 = -1;
        int r130 = -1;
    L58:
        if (r127 >= r125) goto L69;
        File r131 = r126[r127];     // Catch: Exception -> L123
        if (this.f254581a.equals(r131) == false) goto L63;
        r128 = r127;
    L68:
        r127 = r127 + 1;     // Catch: Exception -> L123
        goto L58
    L63:
        if (this.f254585e.equals(r131) == false) goto L66;
        r130 = r127;
        goto L68
    L66:
        if (new PolarisFileWrapper(r131, f(r110)).exists() == false) goto L68;
        r129 = r127;
        goto L68
    L69:
        if (r128 == (-1)) goto L76;
        File[] r132 = new File[r125];     // Catch: Exception -> L123
        if (r128 == 0) goto L74;
        File r133 = r126[0];     // Catch: Exception -> L123
        r126[0] = r126[r128];     // Catch: Exception -> L123
        r126[r128] = r133;     // Catch: Exception -> L123
    L74:
        int r134 = 1;
    L77:
        if (r129 == (-1)) goto L82;
        if (r134 == r129) goto L81;
        File r135 = r126[r134];     // Catch: Exception -> L123
        r126[r134] = r126[r129];     // Catch: Exception -> L123
        r126[r129] = r135;     // Catch: Exception -> L123
    L81:
        r134 = r134 + 1;     // Catch: Exception -> L123
    L82:
        if (r130 == (-1)) goto L87;
        if (r134 == r130) goto L86;
        File r136 = r126[r134];     // Catch: Exception -> L123
        r126[r134] = r126[r130];     // Catch: Exception -> L123
        r126[r130] = r136;     // Catch: Exception -> L123
    L86:
        r134 = r134 + 1;     // Catch: Exception -> L123
    L87:
        int r137 = r125 - this.f254593m.length;     // Catch: Exception -> L123
    L88:
        if (r137 >= r125) goto L210;
        String r138 = r126[r137].getAbsolutePath();     // Catch: Exception -> L123
        String[] r139 = this.f254593m;     // Catch: Exception -> L123
        int r140 = r139.length;     // Catch: Exception -> L123
        int r141 = 0;
    L90:
        if (r141 >= r140) goto L95;
        int r142 = r134;
        if (r139[r141].equals(r138) == true) goto L93;
        r141 = r141 + 1;     // Catch: Exception -> L123
        r134 = r142;
        goto L90
    L93:
        boolean r143 = true;
    L96:
        if (r143 == true) goto L113;
        int r144 = r142;
    L100:
        if (r144 >= (r125 - 2)) goto L113;
        String r145 = r126[r144].getAbsolutePath();     // Catch: Exception -> L123
        String[] r146 = this.f254593m;     // Catch: Exception -> L123
        int r147 = r146.length;     // Catch: Exception -> L123
        int r148 = 0;
    L102:
        if (r148 >= r147) goto L107;
        int r149 = r147;
        if (r146[r148].equals(r145) == true) goto L105;
        r148 = r148 + 1;     // Catch: Exception -> L123
        r147 = r149;
        goto L102
    L105:
        boolean r150 = true;
    L108:
        if (r150 == false) goto L112;
        if (r137 == r144) goto L112;
        File r151 = r126[r137];     // Catch: Exception -> L123
        r126[r137] = r126[r144];     // Catch: Exception -> L123
        r126[r144] = r151;     // Catch: Exception -> L123
    L112:
        r144 = r144 + 1;
        goto L100
    L107:
        r150 = false;
    L113:
        r137 = r137 + 1;
        r134 = r142;
        goto L88
    L95:
        r142 = r134;
        r143 = false;
        goto L96
    L210:
        if (r128 != (-1)) goto L117;
        System.arraycopy(r126, 0, r132, 1, r125);     // Catch: Exception -> L121
    L119:
        r123.set(r122, r132);     // Catch: Exception -> L121
        this.f254582b.a("success to insert path " + r120);     // Catch: Exception -> L121
        r102 = true;
        goto L126
    L117:
        System.arraycopy(r126, 0, r132, 0, r125);     // Catch: Exception -> L121
    L121:
        e = e;
    L125:
        this.f254582b.c("fail to insert path", new LibrarianUnsatisfiedLinkError("opt lib dir err", e));
        r102 = false;
        goto L126
    L76:
        r132 = new File[r125 + 1];     // Catch: Exception -> L123
        r132[0] = this.f254581a;     // Catch: Exception -> L123
        r134 = 0;
    L123:
        e = e;
        goto L125
    L51:
        if (r118.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) == false) goto L53;
        r119 = true;
    L126:
        if (r102 == true) goto L128;
    L130:
        PolarisFileWrapper r152 = new PolarisFileWrapper(this.f254585e, f(r110));
        if (r152.exists() == true) goto L133;
        this.f254582b.b("file is not exist: " + r152.getPath());
    L161:
        boolean r153 = false;
    L162:
        if (r153 == true) goto L212;
        e(r101);
        r152 = r101;
    L212:
        i r154 = new i(r152);     // Catch: Throwable -> L189
        List<String> r155 = r154.a();     // Catch: Throwable -> L187
        Collections.sort(r155);     // Catch: Throwable -> L187
        b(r154);     // Catch: IOException -> L193
        Iterator<String> r156 = r155.iterator();     // Catch: IOException -> L193
    L169:
        if (r156.hasNext() == false) goto L180;
        String r157 = r156.next();     // Catch: IOException -> L193
        String r158 = r157.substring(3, r157.length() - 3);     // Catch: IOException -> L193
        String[] r159 = f254580o;     // Catch: IOException -> L193
        int r160 = r159.length;     // Catch: IOException -> L193
        int r161 = 0;
    L171:
        if (r161 >= r160) goto L176;
        if (r159[r161].equals(r158) == true) goto L174;
        r161 = r161 + 1;     // Catch: IOException -> L193
        goto L171
    L174:
        boolean r162 = true;
    L177:
        if (r162 == true) goto L169;
        this.f254582b.a("to load depended lib " + r158);     // Catch: IOException -> L193
        h(r158);     // Catch: IOException -> L193
        goto L169
    L176:
        r162 = false;
        goto L177
    L180:
        if (r152 != r101) goto L182;
    L185:
        g(r101, r110, true);
        return;
    L182:
        if (j(r110, "after loading dep libs") == false) goto L184;
        return;
    L184:
        e(r101);
    L187:
        th = th;
        Closeable r163 = r154;
    L191:
        b(r163);     // Catch: IOException -> L193
        throw th;     // Catch: IOException -> L193
    L193:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to load depended lib", e);
    L189:
        th = th;
        r163 = null;
        goto L191
    L133:
        d(r152.getName());
        String r164 = "lib/" + this.f254592l + HTTP.URL_DEFAULT + r152.getName();
        ZipFile[] r165 = this.f254587g;
        int r166 = r165.length;
        int r167 = 0;
    L134:
        long r168 = 0;
        if (r167 >= r166) goto L140;
        ZipEntry r169 = r165[r167].getEntry(r164);
        if (r169 != null) goto L138;
        r167 = r167 + 1;
        goto L134
    L138:
        long r170 = r169.getCrc();
    L141:
        byte[] r171 = new byte[8192];
        CheckedInputStream r172 = new CheckedInputStream(new PolarisFileInputStreamWrapper(r152), new CRC32());     // Catch: Throwable -> L151 IOException -> L153
    L221:
    L149:
        e = e;
    L208:
        this.f254582b.c("fail to check sum for " + r152.getPath(), e);     // Catch: Throwable -> L196
    L146:
        b(r172);
        if (r170 != r168) goto L160;
        this.f254582b.a(r164 + " compare crc ok: entry is " + r170 + ", file is " + r168);
        r153 = true;
        goto L162
    L160:
        this.f254582b.b(r164 + " crc is wrong: entry is " + r170 + ", file is " + r168);
    L196:
        th = th;
        CheckedInputStream r173 = r172;
    L198:
        r172 = r173;
    L199:
        b(r172);
        throw th;
    L147:
        th = th;
        goto L199
    L144:
        if (r172.read(r171) >= 0) goto L221;
        r168 = r172.getChecksum().getValue();     // Catch: Throwable -> L147 IOException -> L149
    L153:
        e = e;
        r172 = null;
    L151:
        th = th;
        r173 = null;
        goto L198
    L140:
        r170 = 0;
        goto L141
    L128:
        if (j(r110, "lollipop") == false) goto L130;
        return;
    L45:
        r117 = false;
        goto L46
    }

    public final boolean j(String r100, String r101) {
        this.f254582b.getClass();     // Catch: UnsatisfiedLinkError -> L6
        System.loadLibrary(r100);     // Catch: UnsatisfiedLinkError -> L6
        this.f254582b.a("loaded the origin lib " + r100 + ", tag: " + r101);     // Catch: UnsatisfiedLinkError -> L6
        return true;
    L6:
        e = move-exception;
        this.f254582b.c("fail to load " + r100 + ", tag: " + r101, e);
        return false;
    }

    public final void k(InputStream r100, PolarisFileWrapper r101) throws IOException {
        File r102 = File.createTempFile("tmp-", r101.getName(), r101.getParentFile());
        this.f254582b.a("extracting " + r102.getPath());
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r102);
        byte[] r104 = new byte[8192];     // Catch: Throwable -> L17
        int r105 = r100.read(r104);     // Catch: Throwable -> L17
    L5:
        if (r105 == (-1)) goto L8;
        r103.write(r104, 0, r105);     // Catch: Throwable -> L17
        r105 = r100.read(r104);     // Catch: Throwable -> L17
        goto L5
    L8:
        if (r102.setReadOnly() == false) goto L16;
        this.f254582b.a("renaming to " + r101.getPath());     // Catch: Throwable -> L17
        if (r102.renameTo(r101) == false) goto L14;
        b(r103);
        r102.delete();
        return;
    L14:
        throw new IOException("failed to rename \"" + r102.getAbsolutePath() + "\" to \"" + r101.getAbsolutePath() + "\"");     // Catch: Throwable -> L17
    L16:
        throw new IOException("failed to mark readonly \"" + r102.getAbsolutePath() + "\" (tmp of \"" + r101.getAbsolutePath() + "\")");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        b(r103);
        r102.delete();
        throw th;
    }

    public b(ApplicationInfo r100, PolarisFileWrapper r101, c r102) {
        this.f254593m = new String[]{"/system/lib64", "/vendor/lib64"};
        this.f254581a = r101;
        this.f254582b = r102;
        this.f254589i = r100;
        this.f254584d = new PolarisFileWrapper(r101, "process.lock");
        this.f254583c = new HashMap();
    }

    public final boolean g(PolarisFileWrapper r100, String r101, boolean r102) {
        c r103 = this.f254582b;     // Catch: UnsatisfiedLinkError -> L6
        String r104 = r100.getPath();     // Catch: UnsatisfiedLinkError -> L6
        r103.getClass();     // Catch: UnsatisfiedLinkError -> L6
        System.load(r104);     // Catch: UnsatisfiedLinkError -> L6
        this.f254582b.a("loaded the extracted lib " + r101);     // Catch: UnsatisfiedLinkError -> L6
        return true;
    L6:
        e = move-exception;
        if (r102 == true) goto L11;
        this.f254582b.c("fail to load " + r100.getName() + ", out lib exists", e);
        return false;
    L11:
        throw new LibrarianUnsatisfiedLinkError("finally fail to load " + r100.getPath(), e);
    }
}
