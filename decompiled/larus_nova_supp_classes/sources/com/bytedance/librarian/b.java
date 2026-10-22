package com.bytedance.librarian;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import cf6.i;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import dalvik.system.BaseDexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static final b n = null;
    public static final String[] o = null;
    public final File a;
    public final c b;
    public final Map<String, a> c;
    public final PolarisFileWrapper d;
    public PolarisFileWrapper e;
    public volatile boolean f;
    public ZipFile[] g;
    public String h;
    public final ApplicationInfo i;
    public Map<String, String> j;
    public String[] k;
    public String l;
    public final String[] m;

    public static class a {
        public boolean a;

        public final String toString() {
            return Boolean.toString(this.a);
        }

        public a() {
            this.a = false;
        }
    }

    static {
        o = new String[]{"log", "m", "stdc++", "dl", "c", "z", "android", "jnigraphics", "EGL", "GLESv1_CM", "GLESv2", "GLESv3", "OpenSLES", "OpenMAXAL"};
        Context r0 = com.bytedance.librarian.a.a;
        com.bytedance.librarian.a.a = null;
        if (r0 == null) goto L35;
        ApplicationInfo r2 = r0.getApplicationInfo();
        File r1 = r0.getDir("librarian", 0);
        if (r1.exists() == true) goto L8;
        r1.mkdirs();
    L8:
        if (com.bytedance.librarian.a.b == null) goto L10;
        String r3 = com.bytedance.librarian.a.b;
    L11:
        PolarisFileWrapper r5 = new PolarisFileWrapper(r1, r3 + "." + (new PolarisFileWrapper(r2.sourceDir).lastModified() >> 8));
        File[] r4 = r1.listFiles();
        if (r4 == null) goto L25;
        int r6 = r4.length;
        int r7 = 0;
    L14:
        if (r7 >= r6) goto L25;
        File r8 = r4[r7];
        if (r5.getName().equals(r8.getName()) == true) goto L24;
        File[] r9 = r8.listFiles();
        if (r9 == null) goto L23;
        int r10 = r9.length;
        int r11 = 0;
    L21:
        if (r11 >= r10) goto L23;
        r9[r11].delete();
        r11 = r11 + 1;
    L23:
        r8.delete();
    L24:
        r7 = r7 + 1;
    L25:
        r5.mkdirs();
        if (r5.exists() == false) goto L32;
        c r12 = com.bytedance.librarian.a.c;
        if (r12 != null) goto L31;
        r12 = new c();
    L31:
        n = new b(r2, r5, r12);
        return;
    L32:
        n = null;
        return;
    L10:
        r3 = "default.version";
        goto L11
    L35:
        throw new LibrarianUnsatisfiedLinkError("you should call init first or use loadLibraryForModule.");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("dalvik.system.VMRuntime");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("dalvik.system.VMRuntime");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("dalvik.system.VMRuntime");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("dalvik.system.VMRuntime");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("dalvik.system.VMRuntime");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static String f(String r2) {
        return "lib" + r2 + ".so";
    }

    public final void b(Closeable r3) {
        if (r3 != null) goto L9;
        return;
    L9:
        r3.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        this.b.c("failed to close resource", e);
    }

    public final boolean c(PolarisFileWrapper r8) throws IOException {
        d(r8.getName());
        String r0 = "lib/" + this.l + "/" + r8.getName();
        ZipFile[] r1 = this.g;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L14;
        ZipFile r5 = r1[r4];
        ZipEntry r6 = r5.getEntry(r0);
        if (r6 != null) goto L7;
        r4 = r4 + 1;
        goto L3
    L7:
        InputStream r3 = r5.getInputStream(r6);
        k(r3, r8);     // Catch: Throwable -> L11
        this.b.a("get lib file " + r8.getPath() + " from " + r0 + " of " + r5.getName());     // Catch: Throwable -> L11
        b(r3);
        return true;
    L11:
        th = move-exception;
        b(r3);
        throw th;
    L14:
        return false;
    }

    public final void d(String r11) {
        if (this.l == null) goto L5;
        return;
    L5:
        String[] r0 = this.k;
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L27;
        String r4 = r0[r3];
        if (this.h != null) goto L10;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L26;
        String r6 = "lib/" + r4 + "/" + r11;
        ZipFile[] r7 = this.g;
        int r8 = r7.length;
        int r9 = 0;
    L18:
        if (r9 >= r8) goto L26;
        ZipFile r10 = r7[r9];
        if (r10 == null) goto L25;
        if (r10.getEntry(r6) == null) goto L25;
        this.l = r4;
        this.b.a("ensure that abi is " + r4);
        return;
    L25:
        r9 = r9 + 1;
    L26:
        r3 = r3 + 1;
        goto L6
    L10:
        String r12 = (String) ((HashMap) this.j).get(r4);
        String r13 = this.h;
        if (r12 != null) goto L14;
        r12 = r4;
    L14:
        r5 = r13.equals(r12);
        goto L15
    L27:
        StringBuilder r14 = new StringBuilder("can not ensure abi for ");
        r14.append(r11);
        r14.append(", check ");
        r14.append(this.h);
        r14.append(", apks ");
        StringBuilder r15 = new StringBuilder("[");
        ZipFile[] r16 = this.g;
        int r17 = r16.length;
    L28:
        if (r2 >= r17) goto L33;
        ZipFile r18 = r16[r2];
        if (r18 == null) goto L32;
        String r19 = r18.getName();
        PolarisFileWrapper r20 = new PolarisFileWrapper(r19);
        r15.append(r19);
        r15.append("#");
        r15.append(r18.size());
        r15.append(":");
        r15.append(r20.length());
        r15.append("|");
    L32:
        r2 = r2 + 1;
        goto L28
    L33:
        r15.append("]");
        r14.append(r15.toString());
        throw new LibrarianUnsatisfiedLinkError(r14.toString());
    }

    public final void e(PolarisFileWrapper r6) {
        String r2 = r6.getName();
        monitor-enter(this);
        b r3 = new b(this, this.d);     // Catch: Throwable -> L19
        r3.b();     // Catch: Throwable -> L12 IOException -> L14
        if (c(r6) == false) goto L11;
        r3.a();     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L11:
        throw new LibrarianUnsatisfiedLinkError("fail to extract " + r2);     // Catch: Throwable -> L12 IOException -> L14
    L12:
        th = move-exception;
        r3.a();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L14:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to extract " + r2, e);     // Catch: Throwable -> L12
    L19:
        th = move-exception;
        throw th;
    }

    public final void h(String r5) {
        Map<String, a> r1 = this.c;
        monitor-enter(r1);
        a r2 = (a) ((HashMap) this.c).get(r5);     // Catch: Throwable -> L24
        if (r2 != null) goto L7;
        r2 = new a();     // Catch: Throwable -> L24
        ((HashMap) this.c).put(r5, r2);     // Catch: Throwable -> L24
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L24
        monitor-enter(r2);
    L21:
        th = move-exception;
        throw th;
    L14:
        if (r2.a == false) goto L18;
        this.b.a("lib was already loaded before: " + r5);     // Catch: Throwable -> L21
        monitor-exit(r2);     // Catch: Throwable -> L21
        return;
    L18:
        i(r5);     // Catch: Throwable -> L21
        r2.a = true;     // Catch: Throwable -> L21
        monitor-exit(r2);     // Catch: Throwable -> L21
        return;
    L7:
        if (r2.a == false) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public final void i(String r19) {
        int r3 = Build.VERSION.SDK_INT;
        PolarisFileWrapper r4 = new PolarisFileWrapper(this.a, f(r19));
        if (j(r19, "preload") == false) goto L5;
        return;
    L5:
        boolean r5 = false;
        if (r4.exists() == false) goto L11;
        if (g(r4, r19, false) == false) goto L11;
        return;
    L11:
        if (this.f == true) goto L43;
        monitor-enter(this);
    L201:
        th = move-exception;
        throw th;
    L15:
        if (this.f == false) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L201
        goto L43
    L18:
        PolarisFileWrapper r0 = new PolarisFileWrapper(this.i.sourceDir);     // Catch: Throwable -> L201
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L201
        r8.add(r0);     // Catch: Throwable -> L201
        String[] r1 = this.i.splitSourceDirs;     // Catch: Throwable -> L201
        if (r1 != null) goto L21;
    L25:
        ZipFile[] r9 = new ZipFile[r8.size()];     // Catch: Throwable -> L201
        Iterator r10 = r8.iterator();     // Catch: Throwable -> L201
        int r2 = 0;
    L27:
        if (r10.hasNext() == false) goto L35;
        File r11 = (File) r10.next();     // Catch: Throwable -> L201
        int r12 = r2 + 1;
        r9[r2] = new PolarisZipFileWrapper(r11);     // Catch: IOException -> L32 Throwable -> L201
    L34:
        r2 = r12;
    L32:
        e = move-exception;
        new LibrarianUnsatisfiedLinkError("fail to get zip file " + r11.getName() + ", size " + r11.length() + ", exists " + r11.exists(), e).printStackTrace();     // Catch: Throwable -> L201
        goto L34
    L35:
        this.g = r9;     // Catch: Throwable -> L201
        this.e = new PolarisFileWrapper(this.i.nativeLibraryDir);     // Catch: Throwable -> L201
        HashMap r6 = new HashMap();     // Catch: Throwable -> L201
        this.j = r6;     // Catch: Throwable -> L201
        r6.put("arm64-v8a", "arm64");     // Catch: Throwable -> L201
        ((HashMap) this.j).put("armeabi-v7a", "arm");     // Catch: Throwable -> L201
        ((HashMap) this.j).put("armeabi", "arm");     // Catch: Throwable -> L201
        Class r7 = a();     // Catch: Exception -> L38 Throwable -> L201
        String r13 = (String) r7.getDeclaredMethod("vmInstructionSet", new Class[0]).invoke(r7.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0]);     // Catch: Exception -> L38 Throwable -> L201
    L40:
        this.h = r13;     // Catch: Throwable -> L201
        this.b.a("vm instruction set: " + this.h);     // Catch: Throwable -> L201
        this.k = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L201
        this.f = true;     // Catch: Throwable -> L201
        monitor-exit(this);     // Catch: Throwable -> L201
        goto L43
    L38:
        e = move-exception;
        this.b.c("fail to process vm abi previously", new LibrarianUnsatisfiedLinkError("reflect err", e));     // Catch: Throwable -> L201
        r13 = null;
        goto L40
    L21:
        if (r1.length == 0) goto L25;
        int r14 = r1.length;     // Catch: Throwable -> L201
        int r15 = 0;
    L23:
        if (r15 >= r14) goto L25;
        r8.add(new PolarisFileWrapper(r1[r15]));     // Catch: Throwable -> L201
        r15 = r15 + 1;     // Catch: Throwable -> L201
    L43:
        if (r3 >= 23) goto L45;
        boolean r16 = true;
    L46:
        if (r16 == false) goto L126;
        String r17 = this.h;
        if (r17 != null) goto L51;
    L53:
        boolean r18 = false;
    L54:
        if (r18 == false) goto L126;
        this.b.a("try to opt native lib dirs on L");
        BaseDexClassLoader r20 = (BaseDexClassLoader) b.class.getClassLoader();     // Catch: Exception -> L123
        Field r21 = BaseDexClassLoader.class.getDeclaredField("pathList");     // Catch: Exception -> L123
        r21.setAccessible(true);     // Catch: Exception -> L123
        Object r22 = r21.get(r20);     // Catch: Exception -> L123
        Field r23 = r22.getClass().getDeclaredField("nativeLibraryDirectories");     // Catch: Exception -> L123
        r23.setAccessible(true);     // Catch: Exception -> L123
        File[] r24 = (File[]) r23.get(r22);     // Catch: Exception -> L123
        int r110 = r24.length;     // Catch: Exception -> L123
        File[] r111 = new File[r110];     // Catch: Exception -> L123
        System.arraycopy(r24, 0, r111, 0, r110);     // Catch: Exception -> L123
        int r112 = 0;
        int r113 = -1;
        int r114 = -1;
        int r115 = -1;
    L58:
        if (r112 >= r110) goto L69;
        File r25 = r111[r112];     // Catch: Exception -> L123
        if (this.a.equals(r25) == false) goto L63;
        r113 = r112;
    L68:
        r112 = r112 + 1;     // Catch: Exception -> L123
        goto L58
    L63:
        if (this.e.equals(r25) == false) goto L66;
        r115 = r112;
        goto L68
    L66:
        if (new PolarisFileWrapper(r25, f(r19)).exists() == false) goto L68;
        r114 = r112;
        goto L68
    L69:
        if (r113 == (-1)) goto L76;
        File[] r26 = new File[r110];     // Catch: Exception -> L123
        if (r113 == 0) goto L74;
        File r28 = r111[0];     // Catch: Exception -> L123
        r111[0] = r111[r113];     // Catch: Exception -> L123
        r111[r113] = r28;     // Catch: Exception -> L123
    L74:
        int r29 = 1;
    L77:
        if (r114 == (-1)) goto L82;
        if (r29 == r114) goto L81;
        File r30 = r111[r29];     // Catch: Exception -> L123
        r111[r29] = r111[r114];     // Catch: Exception -> L123
        r111[r114] = r30;     // Catch: Exception -> L123
    L81:
        r29 = r29 + 1;     // Catch: Exception -> L123
    L82:
        if (r115 == (-1)) goto L87;
        if (r29 == r115) goto L86;
        File r31 = r111[r29];     // Catch: Exception -> L123
        r111[r29] = r111[r115];     // Catch: Exception -> L123
        r111[r115] = r31;     // Catch: Exception -> L123
    L86:
        r29 = r29 + 1;     // Catch: Exception -> L123
    L87:
        int r32 = r110 - this.m.length;     // Catch: Exception -> L123
    L88:
        if (r32 >= r110) goto L210;
        String r116 = r111[r32].getAbsolutePath();     // Catch: Exception -> L123
        String[] r117 = this.m;     // Catch: Exception -> L123
        int r118 = r117.length;     // Catch: Exception -> L123
        int r33 = 0;
    L90:
        if (r33 >= r118) goto L95;
        int r119 = r29;
        if (r117[r33].equals(r116) == true) goto L93;
        r33 = r33 + 1;     // Catch: Exception -> L123
        r29 = r119;
        goto L90
    L93:
        boolean r34 = true;
    L96:
        if (r34 == true) goto L113;
        int r35 = r119;
    L100:
        if (r35 >= (r110 - 2)) goto L113;
        String r36 = r111[r35].getAbsolutePath();     // Catch: Exception -> L123
        String[] r120 = this.m;     // Catch: Exception -> L123
        int r121 = r120.length;     // Catch: Exception -> L123
        int r122 = 0;
    L102:
        if (r122 >= r121) goto L107;
        int r123 = r121;
        if (r120[r122].equals(r36) == true) goto L105;
        r122 = r122 + 1;     // Catch: Exception -> L123
        r121 = r123;
        goto L102
    L105:
        boolean r37 = true;
    L108:
        if (r37 == false) goto L112;
        if (r32 == r35) goto L112;
        File r38 = r111[r32];     // Catch: Exception -> L123
        r111[r32] = r111[r35];     // Catch: Exception -> L123
        r111[r35] = r38;     // Catch: Exception -> L123
    L112:
        r35 = r35 + 1;
        goto L100
    L107:
        r37 = false;
    L113:
        r32 = r32 + 1;
        r29 = r119;
        goto L88
    L95:
        r119 = r29;
        r34 = false;
        goto L96
    L210:
        if (r113 != (-1)) goto L117;
        System.arraycopy(r111, 0, r26, 1, r110);     // Catch: Exception -> L121
    L119:
        r23.set(r22, r26);     // Catch: Exception -> L121
        this.b.a("success to insert path " + r20);     // Catch: Exception -> L121
        r5 = true;
        goto L126
    L117:
        System.arraycopy(r111, 0, r26, 0, r110);     // Catch: Exception -> L121
    L121:
        e = e;
    L125:
        this.b.c("fail to insert path", new LibrarianUnsatisfiedLinkError("opt lib dir err", e));
        r5 = false;
        goto L126
    L76:
        r26 = new File[r110 + 1];     // Catch: Exception -> L123
        r26[0] = this.a;     // Catch: Exception -> L123
        r29 = 0;
    L123:
        e = e;
        goto L125
    L51:
        if (r17.contains("64") == false) goto L53;
        r18 = true;
    L126:
        if (r5 == true) goto L128;
    L130:
        PolarisFileWrapper r39 = new PolarisFileWrapper(this.e, f(r19));
        if (r39.exists() == true) goto L133;
        this.b.b("file is not exist: " + r39.getPath());
    L161:
        boolean r40 = false;
    L162:
        if (r40 == true) goto L212;
        e(r4);
        r39 = r4;
    L212:
        Closeable r41 = new i(r39);     // Catch: Throwable -> L189
        List r42 = r41.a();     // Catch: Throwable -> L187
        Collections.sort(r42);     // Catch: Throwable -> L187
        b(r41);     // Catch: IOException -> L193
        Iterator r43 = r42.iterator();     // Catch: IOException -> L193
    L169:
        if (r43.hasNext() == false) goto L180;
        String r44 = (String) r43.next();     // Catch: IOException -> L193
        String r45 = r44.substring(3, r44.length() - 3);     // Catch: IOException -> L193
        String[] r46 = o;     // Catch: IOException -> L193
        int r47 = r46.length;     // Catch: IOException -> L193
        int r48 = 0;
    L171:
        if (r48 >= r47) goto L176;
        if (r46[r48].equals(r45) == true) goto L174;
        r48 = r48 + 1;     // Catch: IOException -> L193
        goto L171
    L174:
        boolean r49 = true;
    L177:
        if (r49 == true) goto L169;
        this.b.a("to load depended lib " + r45);     // Catch: IOException -> L193
        h(r45);     // Catch: IOException -> L193
        goto L169
    L176:
        r49 = false;
        goto L177
    L180:
        if (r39 != r4) goto L182;
    L185:
        g(r4, r19, true);
        return;
    L182:
        if (j(r19, "after loading dep libs") == false) goto L184;
        return;
    L184:
        e(r4);
    L187:
        th = th;
        Closeable r50 = r41;
    L191:
        b(r50);     // Catch: IOException -> L193
        throw th;     // Catch: IOException -> L193
    L193:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to load depended lib", e);
    L189:
        th = th;
        r50 = null;
        goto L191
    L133:
        d(r39.getName());
        String r51 = "lib/" + this.l + "/" + r39.getName();
        ZipFile[] r52 = this.g;
        int r53 = r52.length;
        int r54 = 0;
    L134:
        long r55 = 0;
        if (r54 >= r53) goto L140;
        ZipEntry r124 = r52[r54].getEntry(r51);
        if (r124 != null) goto L138;
        r54 = r54 + 1;
        goto L134
    L138:
        long r56 = r124.getCrc();
    L141:
        byte[] r57 = new byte[8192];
        CheckedInputStream r125 = new CheckedInputStream(new PolarisFileInputStreamWrapper(r39), new CRC32());     // Catch: Throwable -> L151 IOException -> L153
    L221:
    L149:
        e = e;
    L208:
        this.b.c("fail to check sum for " + r39.getPath(), e);     // Catch: Throwable -> L196
    L146:
        b(r125);
        if (r56 != r55) goto L160;
        this.b.a(r51 + " compare crc ok: entry is " + r56 + ", file is " + r55);
        r40 = true;
        goto L162
    L160:
        this.b.b(r51 + " crc is wrong: entry is " + r56 + ", file is " + r55);
    L196:
        th = th;
        CheckedInputStream r58 = r125;
    L198:
        r125 = r58;
    L199:
        b(r125);
        throw th;
    L147:
        th = th;
        goto L199
    L144:
        if (r125.read(r57) >= 0) goto L221;
        r55 = r125.getChecksum().getValue();     // Catch: Throwable -> L147 IOException -> L149
    L153:
        e = e;
        r125 = null;
    L151:
        th = th;
        r58 = null;
        goto L198
    L140:
        r56 = 0;
        goto L141
    L128:
        if (j(r19, "lollipop") == false) goto L130;
        return;
    L45:
        r16 = false;
        goto L46
    }

    public final boolean j(String r6, String r7) {
        this.b.getClass();     // Catch: UnsatisfiedLinkError -> L6
        System.loadLibrary(r6);     // Catch: UnsatisfiedLinkError -> L6
        this.b.a("loaded the origin lib " + r6 + ", tag: " + r7);     // Catch: UnsatisfiedLinkError -> L6
        return true;
    L6:
        e = move-exception;
        this.b.c("fail to load " + r6 + ", tag: " + r7, e);
        return false;
    }

    public final void k(InputStream r6, PolarisFileWrapper r7) throws IOException {
        File r0 = File.createTempFile("tmp-", r7.getName(), r7.getParentFile());
        this.b.a("extracting " + r0.getPath());
        PolarisFileOutputStreamWrapper r1 = new PolarisFileOutputStreamWrapper(r0);
        byte[] r2 = new byte[8192];     // Catch: Throwable -> L17
        int r3 = r6.read(r2);     // Catch: Throwable -> L17
    L5:
        if (r3 == (-1)) goto L8;
        r1.write(r2, 0, r3);     // Catch: Throwable -> L17
        r3 = r6.read(r2);     // Catch: Throwable -> L17
        goto L5
    L8:
        if (r0.setReadOnly() == false) goto L16;
        this.b.a("renaming to " + r7.getPath());     // Catch: Throwable -> L17
        if (r0.renameTo(r7) == false) goto L14;
        b(r1);
        r0.delete();
        return;
    L14:
        throw new IOException("failed to rename \"" + r0.getAbsolutePath() + "\" to \"" + r7.getAbsolutePath() + "\"");     // Catch: Throwable -> L17
    L16:
        throw new IOException("failed to mark readonly \"" + r0.getAbsolutePath() + "\" (tmp of \"" + r7.getAbsolutePath() + "\")");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        b(r1);
        r0.delete();
        throw th;
    }

    public b(ApplicationInfo r3, PolarisFileWrapper r4, c r5) {
        this.m = new String[]{"/system/lib64", "/vendor/lib64"};
        this.a = r4;
        this.b = r5;
        this.i = r3;
        this.d = new PolarisFileWrapper(r4, "process.lock");
        this.c = new HashMap();
    }

    public final boolean g(PolarisFileWrapper r4, String r5, boolean r6) {
        c r1 = this.b;     // Catch: UnsatisfiedLinkError -> L6
        String r2 = r4.getPath();     // Catch: UnsatisfiedLinkError -> L6
        r1.getClass();     // Catch: UnsatisfiedLinkError -> L6
        System.load(r2);     // Catch: UnsatisfiedLinkError -> L6
        this.b.a("loaded the extracted lib " + r5);     // Catch: UnsatisfiedLinkError -> L6
        return true;
    L6:
        e = move-exception;
        if (r6 == true) goto L11;
        this.b.c("fail to load " + r4.getName() + ", out lib exists", e);
        return false;
    L11:
        throw new LibrarianUnsatisfiedLinkError("finally fail to load " + r4.getPath(), e);
    }
}
