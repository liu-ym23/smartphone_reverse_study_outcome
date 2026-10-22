package jv7;

import androidx.collection.SieveCacheKt;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.sva.sdk.controller.Global;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f500563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public static final Method f500564b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public static Method f500565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public static final Method f500566d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public static final Object f500567e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public static Method f500568f;

    static {
        if (System.getProperty("java.specification.version", "99").startsWith("1.") == false) goto L13;
        f500564b = ByteBuffer.class.getMethod("cleaner", new Class[0]);     // Catch: Exception -> L11
        f500565c = a("sun.misc.Cleaner").getMethod(Global.RECORDING_TYPE_CLEAN, new Class[0]);     // Catch: Exception -> L11
        return;
    L13:
        Class r100 = a("sun.misc.Unsafe");     // Catch: Exception -> L8
    L9:
        f500566d = r100.getMethod("invokeCleaner", new Class[]{ByteBuffer.class});     // Catch: Exception -> L11
        Field r101 = r100.getDeclaredField("theUnsafe");     // Catch: Exception -> L11
        r101.setAccessible(true);     // Catch: Exception -> L11
        f500567e = r101.get(null);     // Catch: Exception -> L11
        return;
    L8:
        r100 = a("jdk.internal.misc.Unsafe");     // Catch: Exception -> L11
    }

    public static boolean b() {
        Method r100 = f500565c;
        if (r100 == null) goto L7;
        if (f500564b == null) goto L7;
    L13:
        return true;
    L7:
        if (f500566d == null) goto L11;
        if (f500567e != null) goto L13;
    L11:
        if (f500568f == null) goto L14;
        if (r100 != null) goto L13;
    L14:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    public static void c(MappedByteBuffer r100) throws ReflectiveOperationException {
        Method r101 = f500564b;
        if (r101 != null) goto L5;
    L8:
        Method r102 = f500568f;
        if (r102 != null) goto L11;
    L16:
        Method r103 = f500566d;
        if (r103 == null) goto L23;
        Object r104 = f500567e;
        if (r104 == null) goto L24;
        r103.setAccessible(true);
        r103.invoke(r104, new Object[]{r100});
        return;
    L24:
        return;
    L23:
        return;
    L11:
        if (f500565c == null) goto L16;
        r102.setAccessible(true);
        f500565c.setAccessible(true);
        Object r105 = f500568f.invoke(r100, new Object[0]);
        if (r105 == null) goto L22;
        f500565c.invoke(r105, new Object[0]);
        return;
    L22:
        return;
    L5:
        if (f500565c == null) goto L8;
        r101.setAccessible(true);
        f500565c.setAccessible(true);
        f500565c.invoke(r101.invoke(r100, new Object[0]), new Object[0]);
    }

    public static MappedByteBuffer d(File r100, long r110, long r111) throws IOException {
        RandomAccessFile r101 = null;
        if (r111 < SieveCacheKt.NodeLinkMask) goto L16;
        return null;
    L16:
        RandomAccessFile r102 = new RandomAccessFile(r100, "r");     // Catch: Throwable -> L11
        MappedByteBuffer r103 = r102.getChannel().map(FileChannel.MapMode.READ_ONLY, r110, r111);     // Catch: Throwable -> L9
        iv7.b.a(r102);
        return r103;
    L9:
        th = th;
        r101 = r102;
    L12:
        iv7.b.a(r101);
        throw th;
    L11:
        th = th;
        goto L12
    }
}
