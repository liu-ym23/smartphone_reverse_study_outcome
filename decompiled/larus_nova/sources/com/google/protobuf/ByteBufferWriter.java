package com.google.protobuf;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
final class ByteBufferWriter {
    private static final ThreadLocal<SoftReference<byte[]>> BUFFER = null;
    private static final float BUFFER_REALLOCATION_THRESHOLD = 0.5f;
    private static final long CHANNEL_FIELD_OFFSET = 0;
    private static final Class<?> FILE_OUTPUT_STREAM_CLASS = null;
    private static final int MAX_CACHED_BUFFER_SIZE = 16384;
    private static final int MIN_CACHED_BUFFER_SIZE = 1024;

    private ByteBufferWriter() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static boolean needToReallocate(int r100, int r101) {
        if (r101 < r100) goto L4;
    L6:
        return false;
    L4:
        if (r101 >= (r100 * 0.5f)) goto L6;
        return true;
    }

    static {
        BUFFER = new ThreadLocal();
        Class<?> r100 = safeGetClass("java.io.FileOutputStream");
        FILE_OUTPUT_STREAM_CLASS = r100;
        CHANNEL_FIELD_OFFSET = getChannelFieldOffset(r100);
    }

    public static void clearCachedBuffer() {
        BUFFER.set(null);
    }

    private static byte[] getBuffer() {
        SoftReference<byte[]> r100 = BUFFER.get();
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.get();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_google_protobuf_ByteBufferWriter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static long getChannelFieldOffset(Class<?> r100) {
        if (r100 != null) goto L10;
        return -1;
    L10:
        if (UnsafeUtil.hasUnsafeArrayOperations() == false) goto L12;
        return UnsafeUtil.objectFieldOffset(r100.getDeclaredField("channel"));
    L12:
        return -1;
    L13:
        return -1;
    }

    private static byte[] getOrCreateBuffer(int r100) {
        int r101 = Math.max(r100, 1024);
        byte[] r102 = getBuffer();
        if (r102 != null) goto L5;
    L6:
        r102 = new byte[r101];
        if (r101 > 16384) goto L9;
        setBuffer(r102);
    L9:
        return r102;
    L5:
        if (needToReallocate(r101, r102.length) == false) goto L9;
        goto L6
    }

    private static Class<?> safeGetClass(String r100) {
        return INVOKESTATIC_com_google_protobuf_ByteBufferWriter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
    L4:
        return null;
    }

    private static void setBuffer(byte[] r100) {
        BUFFER.set(new SoftReference(r100));
    }

    public static void write(ByteBuffer r100, OutputStream r101) throws IOException {
        int r102 = r100.position();
    L15:
        th = move-exception;
        r100.position(r102);
        throw th;
    L4:
        if (r100.hasArray() == false) goto L7;
        r101.write(r100.array(), r100.arrayOffset() + r100.position(), r100.remaining());     // Catch: Throwable -> L15
    L13:
        r100.position(r102);
        return;
    L7:
        if (writeToChannel(r100, r101) == true) goto L13;
        byte[] r103 = getOrCreateBuffer(r100.remaining());     // Catch: Throwable -> L15
    L10:
        if (r100.hasRemaining() == false) goto L13;
        int r104 = Math.min(r100.remaining(), r103.length);     // Catch: Throwable -> L15
        r100.get(r103, 0, r104);     // Catch: Throwable -> L15
        r101.write(r103, 0, r104);     // Catch: Throwable -> L15
        goto L10
    }

    private static boolean writeToChannel(ByteBuffer r100, OutputStream r101) throws IOException {
        long r102 = CHANNEL_FIELD_OFFSET;
        if (r102 >= 0) goto L5;
        return false;
    L5:
        if (FILE_OUTPUT_STREAM_CLASS.isInstance(r101) == false) goto L16;
        WritableByteChannel r103 = (WritableByteChannel) UnsafeUtil.getObject(r101, r102);     // Catch: ClassCastException -> L8
    L9:
        if (r103 == null) goto L17;
        r103.write(r100);
        return true;
    L17:
        return false;
    L8:
        r103 = null;
        goto L9
    L16:
        return false;
    }
}
