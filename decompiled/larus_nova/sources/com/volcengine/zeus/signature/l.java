package com.volcengine.zeus.signature;

import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.util.FieldUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.security.DigestException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class l implements k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f462906d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileDescriptor f462907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f462908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f462909c;

    static {
        f462906d = Os.sysconf(OsConstants._SC_PAGESIZE);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class b() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("java.nio.DirectByteBuffer");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("java.nio.DirectByteBuffer");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("java.nio.DirectByteBuffer");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("java.nio.DirectByteBuffer");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("java.nio.DirectByteBuffer");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("java.nio.DirectByteBuffer");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("java.nio.DirectByteBuffer");
    }

    @Override // com.volcengine.zeus.signature.k
    public final long size() {
        return this.f462909c;
    }

    public l(FileDescriptor r100, long r101, long r102) {
        this.f462907a = r100;
        this.f462908b = r101;
        this.f462909c = r102;
    }

    @Override // com.volcengine.zeus.signature.k
    public final void a(j r210, long r211, int r212) throws IOException, DigestException {
        long r100 = this.f462908b + r211;
        long r101 = f462906d;
        long r110 = (r100 / r101) * r101;
        int r102 = (int) (r100 - r110);
        long r103 = r212 + r102;
    L69:
        e = e;
        long r104 = 0;
    L74:
        throw new IOException("Failed to mmap " + r103 + " bytes", e);     // Catch: Throwable -> L75
    L75:
        th = th;
    L77:
        if (r104 != 0) goto L88;
    L79:
        throw th;
    L88:
        Os.munmap(r104, r103);     // Catch: ErrnoException -> L81
    L12:
        th = th;
        r104 = 0;
        goto L77
    L5:
        if (Build.VERSION.SDK_INT <= 23) goto L7;
        boolean r105 = true;
    L8:
        ByteBuffer r106 = null;
        if (r105 == true) goto L91;
    L18:
        int r107 = 0;
    L19:
        r104 = Os.mmap(0, r103, OsConstants.PROT_READ, OsConstants.MAP_SHARED | r107, this.f462907a, r110);     // Catch: Throwable -> L12 ErrnoException -> L69
    L86:
        int r108 = Build.VERSION.SDK_INT;     // Catch: ErrnoException -> L67 Throwable -> L75
        if (r108 >= 24) goto L24;
    L26:
        boolean r109 = false;
    L28:
        if (r109 == false) goto L95;
        Constructor r111 = zpc.a.a(b(), new Class[]{Integer.TYPE, Long.TYPE, FileDescriptor.class, Runnable.class, Boolean.TYPE});     // Catch: Exception -> L35 InvocationTargetException -> L37 InstantiationException -> L39 IllegalAccessException -> L41 ClassNotFoundException -> L43 Throwable -> L75
        if (r111 != null) goto L32;
    L62:
        r210.consume(r106);     // Catch: ErrnoException -> L67 Throwable -> L75
        if (r104 == 0) goto L97;
        Os.munmap(r104, r103);     // Catch: ErrnoException -> L80
        return;
    L98:
        return;
    L97:
        return;
    L32:
        if (r111.isAccessible() == false) goto L62;
        ByteBuffer r112 = (ByteBuffer) r111.newInstance(new Object[]{Integer.valueOf(r212), Long.valueOf(((long) r102) + r104), this.f462907a, null, Boolean.TRUE});     // Catch: Exception -> L35 InvocationTargetException -> L37 InstantiationException -> L39 IllegalAccessException -> L41 ClassNotFoundException -> L43 Throwable -> L75
    L51:
        r106 = r112;
        goto L62
    L43:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L67 Throwable -> L75
    L41:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L67 Throwable -> L75
    L39:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L67 Throwable -> L75
    L37:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L67 Throwable -> L75
    L35:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L67 Throwable -> L75
        goto L62
    L95:
        Constructor r113 = zpc.a.a(b(), new Class[]{Long.TYPE, Integer.TYPE});     // Catch: Exception -> L52 InvocationTargetException -> L54 InstantiationException -> L56 IllegalAccessException -> L58 ClassNotFoundException -> L60 Throwable -> L75
        if (r113 == null) goto L62;
        if (r113.isAccessible() == false) goto L62;
        r112 = (ByteBuffer) r113.newInstance(new Object[]{Long.valueOf(((long) r102) + r104), Integer.valueOf(r212)});     // Catch: Exception -> L52 InvocationTargetException -> L54 InstantiationException -> L56 IllegalAccessException -> L58 ClassNotFoundException -> L60 Throwable -> L75
    L60:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L67 Throwable -> L75
    L58:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L67 Throwable -> L75
    L56:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L67 Throwable -> L75
    L54:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L67 Throwable -> L75
    L52:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L67 Throwable -> L75
        goto L62
    L24:
        if (r108 > 28) goto L26;
        r109 = true;
    L67:
        e = e;
        goto L74
    L91:
        r107 = ((Integer) FieldUtils.readField(zpc.a.b(OsConstants.class, "MAP_POPULATE"), null)).intValue();     // Catch: Throwable -> L12 Exception -> L14 IllegalAccessException -> L16
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12 ErrnoException -> L69
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12 ErrnoException -> L69
        goto L18
    L7:
        r105 = false;
        goto L8
    }
}
