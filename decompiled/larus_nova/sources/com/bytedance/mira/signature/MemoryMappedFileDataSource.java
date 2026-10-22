package com.bytedance.mira.signature;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.bytedance.mira.compat.p.HackHelper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.OSUtil;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.security.DigestException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
class MemoryMappedFileDataSource implements DataSource {
    private static final long MEMORY_PAGE_SIZE_BYTES = 0;
    private final FileDescriptor mFd;
    private final long mFilePosition;
    private final long mSize;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        MEMORY_PAGE_SIZE_BYTES = Os.sysconf(OsConstants._SC_PAGESIZE);
    }

    @Override // com.bytedance.mira.signature.DataSource
    public long size() {
        return this.mSize;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_signature_MemoryMappedFileDataSource_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public MemoryMappedFileDataSource(FileDescriptor r100, long r101, long r102) {
        this.mFd = r100;
        this.mFilePosition = r101;
        this.mSize = r102;
    }

    @Override // com.bytedance.mira.signature.DataSource
    public void feedIntoDataDigester(DataDigester r210, long r211, int r212) throws IOException, DigestException {
        long r100 = this.mFilePosition + r211;
        long r101 = MEMORY_PAGE_SIZE_BYTES;
        long r110 = (r100 / r101) * r101;
        int r102 = (int) (r100 - r110);
        long r103 = r212 + r102;
    L59:
        e = e;
        long r104 = 0;
    L62:
        throw new IOException("Failed to mmap " + r103 + " bytes", e);     // Catch: Throwable -> L63
    L63:
        th = th;
    L65:
        if (r104 != 0) goto L77;
    L67:
        throw th;
    L77:
        Os.munmap(r104, r103);     // Catch: ErrnoException -> L69
    L57:
        th = th;
        r104 = 0;
        goto L65
    L4:
        ByteBuffer r105 = null;
        if (OSUtil.isAndroidMHigher() == true) goto L79;
    L12:
        int r106 = 0;
    L13:
        r104 = Os.mmap(0, r103, OsConstants.PROT_READ, OsConstants.MAP_SHARED | r106, this.mFd, r110);     // Catch: Throwable -> L57 ErrnoException -> L59
    L55:
        e = e;
        goto L62
    L16:
        if (OSUtil.isAndroidNP() == true) goto L83;
        Constructor r107 = HackHelper.getConstructor(INVOKESTATIC_com_bytedance_mira_signature_MemoryMappedFileDataSource_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("java.nio.DirectByteBuffer"), new Class[]{Long.TYPE, Integer.TYPE});     // Catch: Exception -> L40 InvocationTargetException -> L42 InstantiationException -> L44 IllegalAccessException -> L46 ClassNotFoundException -> L48 Throwable -> L63
        if (r107 != null) goto L37;
    L50:
        r210.consume(r105);     // Catch: ErrnoException -> L55 Throwable -> L63
        if (r104 == 0) goto L85;
        Os.munmap(r104, r103);     // Catch: ErrnoException -> L68
        return;
    L86:
        return;
    L85:
        return;
    L37:
        if (r107.isAccessible() == false) goto L50;
        ByteBuffer r108 = (ByteBuffer) r107.newInstance(new Object[]{Long.valueOf(((long) r102) + r104), Integer.valueOf(r212)});     // Catch: Exception -> L40 InvocationTargetException -> L42 InstantiationException -> L44 IllegalAccessException -> L46 ClassNotFoundException -> L48 Throwable -> L63
    L22:
        r105 = r108;
        goto L50
    L48:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L55 Throwable -> L63
    L46:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L55 Throwable -> L63
    L44:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L55 Throwable -> L63
    L42:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L55 Throwable -> L63
    L40:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L55 Throwable -> L63
        goto L50
    L83:
        Constructor r109 = HackHelper.getConstructor(INVOKESTATIC_com_bytedance_mira_signature_MemoryMappedFileDataSource_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("java.nio.DirectByteBuffer"), new Class[]{Integer.TYPE, Long.TYPE, FileDescriptor.class, Runnable.class, Boolean.TYPE});     // Catch: Exception -> L23 InvocationTargetException -> L25 InstantiationException -> L27 IllegalAccessException -> L29 ClassNotFoundException -> L31 Throwable -> L63
        if (r109 == null) goto L50;
        if (r109.isAccessible() == false) goto L50;
        r108 = (ByteBuffer) r109.newInstance(new Object[]{Integer.valueOf(r212), Long.valueOf(((long) r102) + r104), this.mFd, null, Boolean.TRUE});     // Catch: Exception -> L23 InvocationTargetException -> L25 InstantiationException -> L27 IllegalAccessException -> L29 ClassNotFoundException -> L31 Throwable -> L63
    L31:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L55 Throwable -> L63
    L29:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L55 Throwable -> L63
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L55 Throwable -> L63
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L55 Throwable -> L63
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: ErrnoException -> L55 Throwable -> L63
        goto L50
    L79:
        r106 = ((Integer) FieldUtils.readField(HackHelper.getField(OsConstants.class, "MAP_POPULATE"), null)).intValue();     // Catch: Exception -> L8 IllegalAccessException -> L10 Throwable -> L57
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L57 ErrnoException -> L59
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L57 ErrnoException -> L59
        goto L12
    }
}
