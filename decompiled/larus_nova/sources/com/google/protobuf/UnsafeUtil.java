package com.google.protobuf;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.ele.lancet.base.annotations.Skip;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes23.dex */
final class UnsafeUtil {
    private static final long BOOLEAN_ARRAY_BASE_OFFSET = 0;
    private static final long BOOLEAN_ARRAY_INDEX_SCALE = 0;
    private static final long BUFFER_ADDRESS_OFFSET = 0;
    private static final long BYTE_ARRAY_BASE_OFFSET = 0;
    private static final long DOUBLE_ARRAY_BASE_OFFSET = 0;
    private static final long DOUBLE_ARRAY_INDEX_SCALE = 0;
    private static final long FLOAT_ARRAY_BASE_OFFSET = 0;
    private static final long FLOAT_ARRAY_INDEX_SCALE = 0;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = false;
    private static final long INT_ARRAY_BASE_OFFSET = 0;
    private static final long INT_ARRAY_INDEX_SCALE = 0;
    private static final long LONG_ARRAY_BASE_OFFSET = 0;
    private static final long LONG_ARRAY_INDEX_SCALE = 0;
    private static final MemoryAccessor MEMORY_ACCESSOR = null;
    private static final long OBJECT_ARRAY_BASE_OFFSET = 0;
    private static final long OBJECT_ARRAY_INDEX_SCALE = 0;
    private static final Unsafe UNSAFE = null;
    private static final Logger logger = null;

    public static final class JvmMemoryAccessor extends MemoryAccessor {
        public JvmMemoryAccessor(Unsafe r100) {
            super(r100);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long r100) {
            return this.unsafe.getByte(r100);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long r100) {
            return this.unsafe.getInt(r100);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long r100) {
            return this.unsafe.getLong(r100);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field r100) {
            return getObject(this.unsafe.staticFieldBase(r100), this.unsafe.staticFieldOffset(r100));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object r100, long r101) {
            return this.unsafe.getBoolean(r100, r101);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object r100, long r101) {
            return this.unsafe.getByte(r100, r101);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object r100, long r101) {
            return this.unsafe.getDouble(r100, r101);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object r100, long r101) {
            return this.unsafe.getFloat(r100, r101);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long r100, byte r101) {
            this.unsafe.putByte(r100, r101);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long r100, int r101) {
            this.unsafe.putInt(r100, r101);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long r100, long r101) {
            this.unsafe.putLong(r100, r101);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object r100, long r101, boolean r102) {
            this.unsafe.putBoolean(r100, r101, r102);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object r100, long r101, byte r102) {
            this.unsafe.putByte(r100, r101, r102);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object r100, long r101, double r110) {
            this.unsafe.putDouble(r100, r101, r110);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object r100, long r101, float r102) {
            this.unsafe.putFloat(r100, r101, r102);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long r110, byte[] r111, long r112, long r113) {
            this.unsafe.copyMemory(null, r110, r111, UnsafeUtil.access$000() + r112, r113);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] r110, long r111, long r112, long r113) {
            this.unsafe.copyMemory(r110, UnsafeUtil.access$000() + r111, null, r112, r113);
        }
    }

    public static abstract class MemoryAccessor {
        Unsafe unsafe;

        public abstract void copyMemory(long r100, byte[] r101, long r102, long r103);

        public abstract void copyMemory(byte[] r100, long r101, long r102, long r103);

        public abstract boolean getBoolean(Object r100, long r101);

        public abstract byte getByte(long r100);

        public abstract byte getByte(Object r100, long r101);

        public abstract double getDouble(Object r100, long r101);

        public abstract float getFloat(Object r100, long r101);

        public abstract int getInt(long r100);

        public abstract long getLong(long r100);

        public abstract Object getStaticObject(java.lang.reflect.Field r100);

        public abstract void putBoolean(Object r100, long r101, boolean r102);

        public abstract void putByte(long r100, byte r101);

        public abstract void putByte(Object r100, long r101, byte r102);

        public abstract void putDouble(Object r100, long r101, double r102);

        public abstract void putFloat(Object r100, long r101, float r102);

        public abstract void putInt(long r100, int r101);

        public abstract void putLong(long r100, long r101);

        public MemoryAccessor(Unsafe r100) {
            this.unsafe = r100;
        }

        public final int arrayBaseOffset(Class<?> r100) {
            return this.unsafe.arrayBaseOffset(r100);
        }

        public final int arrayIndexScale(Class<?> r100) {
            return this.unsafe.arrayIndexScale(r100);
        }

        public final long objectFieldOffset(java.lang.reflect.Field r100) {
            return this.unsafe.objectFieldOffset(r100);
        }

        public final int getInt(Object r100, long r101) {
            return this.unsafe.getInt(r100, r101);
        }

        public final long getLong(Object r100, long r101) {
            return this.unsafe.getLong(r100, r101);
        }

        public final Object getObject(Object r100, long r101) {
            return this.unsafe.getObject(r100, r101);
        }

        public final void putInt(Object r100, long r101, int r102) {
            this.unsafe.putInt(r100, r101, r102);
        }

        public final void putLong(Object r100, long r101, long r110) {
            this.unsafe.putLong(r100, r101, r110);
        }

        public final void putObject(Object r100, long r101, Object r102) {
            this.unsafe.putObject(r100, r101, r102);
        }
    }

    private UnsafeUtil() {
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        logger = Logger.getLogger(UnsafeUtil.class.getName());
        UNSAFE = getUnsafe();
        MEMORY_ACCESSOR = getMemoryAccessor();
        HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
        HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
        BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset(byte[].class);
        BOOLEAN_ARRAY_BASE_OFFSET = arrayBaseOffset(boolean[].class);
        BOOLEAN_ARRAY_INDEX_SCALE = arrayIndexScale(boolean[].class);
        INT_ARRAY_BASE_OFFSET = arrayBaseOffset(int[].class);
        INT_ARRAY_INDEX_SCALE = arrayIndexScale(int[].class);
        LONG_ARRAY_BASE_OFFSET = arrayBaseOffset(long[].class);
        LONG_ARRAY_INDEX_SCALE = arrayIndexScale(long[].class);
        FLOAT_ARRAY_BASE_OFFSET = arrayBaseOffset(float[].class);
        FLOAT_ARRAY_INDEX_SCALE = arrayIndexScale(float[].class);
        DOUBLE_ARRAY_BASE_OFFSET = arrayBaseOffset(double[].class);
        DOUBLE_ARRAY_INDEX_SCALE = arrayIndexScale(double[].class);
        OBJECT_ARRAY_BASE_OFFSET = arrayBaseOffset(Object[].class);
        OBJECT_ARRAY_INDEX_SCALE = arrayIndexScale(Object[].class);
        BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
    }

    private static java.lang.reflect.Field bufferAddressField() {
        return field(Buffer.class, "address");
    }

    private static MemoryAccessor getMemoryAccessor() {
        Unsafe r100 = UNSAFE;
        if (r100 != null) goto L7;
        return null;
    L7:
        return new JvmMemoryAccessor(r100);
    }

    private static Unsafe getUnsafe() {
        return (Unsafe) AccessController.doPrivileged(new AnonymousClass1());
    L4:
        return null;
    }

    private static boolean supportsUnsafeArrayOperations() {
        Unsafe r100 = UNSAFE;
        if (r100 != null) goto L10;
        return false;
    L10:
        Class<?> r101 = r100.getClass();     // Catch: Throwable -> L7
        r101.getMethod("objectFieldOffset", new Class[]{java.lang.reflect.Field.class});     // Catch: Throwable -> L7
        r101.getMethod("arrayBaseOffset", new Class[]{Class.class});     // Catch: Throwable -> L7
        r101.getMethod("arrayIndexScale", new Class[]{Class.class});     // Catch: Throwable -> L7
        Class<?> r102 = Long.TYPE;     // Catch: Throwable -> L7
        r101.getMethod("getInt", new Class[]{Object.class, r102});     // Catch: Throwable -> L7
        r101.getMethod("putInt", new Class[]{Object.class, r102, Integer.TYPE});     // Catch: Throwable -> L7
        r101.getMethod("getLong", new Class[]{Object.class, r102});     // Catch: Throwable -> L7
        r101.getMethod("putLong", new Class[]{Object.class, r102, r102});     // Catch: Throwable -> L7
        r101.getMethod("getObject", new Class[]{Object.class, r102});     // Catch: Throwable -> L7
        r101.getMethod("putObject", new Class[]{Object.class, r102, Object.class});     // Catch: Throwable -> L7
        r101.getMethod("getByte", new Class[]{Object.class, r102});     // Catch: Throwable -> L7
        r101.getMethod("putByte", new Class[]{Object.class, r102, Byte.TYPE});     // Catch: Throwable -> L7
        r101.getMethod("getBoolean", new Class[]{Object.class, r102});     // Catch: Throwable -> L7
        r101.getMethod("putBoolean", new Class[]{Object.class, r102, Boolean.TYPE});     // Catch: Throwable -> L7
        r101.getMethod("getFloat", new Class[]{Object.class, r102});     // Catch: Throwable -> L7
        r101.getMethod("putFloat", new Class[]{Object.class, r102, Float.TYPE});     // Catch: Throwable -> L7
        r101.getMethod("getDouble", new Class[]{Object.class, r102});     // Catch: Throwable -> L7
        r101.getMethod("putDouble", new Class[]{Object.class, r102, Double.TYPE});     // Catch: Throwable -> L7
        return true;
    L7:
        th = move-exception;
        logger.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
        return false;
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        Unsafe r100 = UNSAFE;
        if (r100 != null) goto L10;
        return false;
    L10:
        Class<?> r101 = r100.getClass();     // Catch: Throwable -> L7
        r101.getMethod("objectFieldOffset", new Class[]{java.lang.reflect.Field.class});     // Catch: Throwable -> L7
        Class<?> r102 = Long.TYPE;     // Catch: Throwable -> L7
        r101.getMethod("getLong", new Class[]{Object.class, r102});     // Catch: Throwable -> L7
        r101.getMethod("getByte", new Class[]{r102});     // Catch: Throwable -> L7
        r101.getMethod("putByte", new Class[]{r102, Byte.TYPE});     // Catch: Throwable -> L7
        r101.getMethod("getInt", new Class[]{r102});     // Catch: Throwable -> L7
        r101.getMethod("putInt", new Class[]{r102, Integer.TYPE});     // Catch: Throwable -> L7
        r101.getMethod("getLong", new Class[]{r102});     // Catch: Throwable -> L7
        r101.getMethod("putLong", new Class[]{r102, r102});     // Catch: Throwable -> L7
        r101.getMethod("copyMemory", new Class[]{r102, r102, r102});     // Catch: Throwable -> L7
        r101.getMethod("copyMemory", new Class[]{Object.class, r102, Object.class, r102, r102});     // Catch: Throwable -> L7
        return true;
    L7:
        th = move-exception;
        logger.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
        return false;
    }

    public static /* synthetic */ long access$000() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    public static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    public static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_google_protobuf_UnsafeUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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

    public static long addressOffset(ByteBuffer r100) {
        return MEMORY_ACCESSOR.getLong(r100, BUFFER_ADDRESS_OFFSET);
    }

    private static int arrayBaseOffset(Class<?> r100) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS == true) goto L7;
        return -1;
    L7:
        return MEMORY_ACCESSOR.arrayBaseOffset(r100);
    }

    private static int arrayIndexScale(Class<?> r100) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS == true) goto L7;
        return -1;
    L7:
        return MEMORY_ACCESSOR.arrayIndexScale(r100);
    }

    private static long fieldOffset(java.lang.reflect.Field r100) {
        if (r100 == null) goto L7;
        MemoryAccessor r101 = MEMORY_ACCESSOR;
        if (r101 == null) goto L7;
        return r101.objectFieldOffset(r100);
    L7:
        return -1;
    }

    public static byte getByte(long r100) {
        return MEMORY_ACCESSOR.getByte(r100);
    }

    private static <T> Class<T> getClassForName(String r100) {
        return INVOKESTATIC_com_google_protobuf_UnsafeUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
    L4:
        return null;
    }

    public static int getInt(long r100) {
        return MEMORY_ACCESSOR.getInt(r100);
    }

    public static long getLong(long r100) {
        return MEMORY_ACCESSOR.getLong(r100);
    }

    public static Object getStaticObject(java.lang.reflect.Field r100) {
        return MEMORY_ACCESSOR.getStaticObject(r100);
    }

    public static long objectFieldOffset(java.lang.reflect.Field r100) {
        return MEMORY_ACCESSOR.objectFieldOffset(r100);
    }

    private static java.lang.reflect.Field field(Class<?> r100, String r101) {
        java.lang.reflect.Field r102 = r100.getDeclaredField(r101);     // Catch: Throwable -> L4
        r102.setAccessible(true);     // Catch: Throwable -> L4
        return r102;
    L4:
        return null;
    }

    public static boolean getBoolean(boolean[] r100, long r101) {
        return MEMORY_ACCESSOR.getBoolean(r100, BOOLEAN_ARRAY_BASE_OFFSET + (r101 * BOOLEAN_ARRAY_INDEX_SCALE));
    }

    public static byte getByte(byte[] r100, long r101) {
        return MEMORY_ACCESSOR.getByte(r100, BYTE_ARRAY_BASE_OFFSET + r101);
    }

    public static double getDouble(double[] r100, long r101) {
        return MEMORY_ACCESSOR.getDouble(r100, DOUBLE_ARRAY_BASE_OFFSET + (r101 * DOUBLE_ARRAY_INDEX_SCALE));
    }

    public static float getFloat(float[] r100, long r101) {
        return MEMORY_ACCESSOR.getFloat(r100, FLOAT_ARRAY_BASE_OFFSET + (r101 * FLOAT_ARRAY_INDEX_SCALE));
    }

    public static int getInt(int[] r100, long r101) {
        return MEMORY_ACCESSOR.getInt(r100, INT_ARRAY_BASE_OFFSET + (r101 * INT_ARRAY_INDEX_SCALE));
    }

    public static long getLong(long[] r100, long r101) {
        return MEMORY_ACCESSOR.getLong(r100, LONG_ARRAY_BASE_OFFSET + (r101 * LONG_ARRAY_INDEX_SCALE));
    }

    public static Object getObject(Object[] r100, long r101) {
        return MEMORY_ACCESSOR.getObject(r100, OBJECT_ARRAY_BASE_OFFSET + (r101 * OBJECT_ARRAY_INDEX_SCALE));
    }

    public static void putByte(long r100, byte r101) {
        MEMORY_ACCESSOR.putByte(r100, r101);
    }

    public static void putInt(long r100, int r101) {
        MEMORY_ACCESSOR.putInt(r100, r101);
    }

    public static void putLong(long r100, long r101) {
        MEMORY_ACCESSOR.putLong(r100, r101);
    }

    public static boolean getBoolean(Object r100, long r101) {
        return MEMORY_ACCESSOR.getBoolean(r100, r101);
    }

    public static byte getByte(Object r100, long r101) {
        return MEMORY_ACCESSOR.getByte(r100, r101);
    }

    public static double getDouble(Object r100, long r101) {
        return MEMORY_ACCESSOR.getDouble(r100, r101);
    }

    public static float getFloat(Object r100, long r101) {
        return MEMORY_ACCESSOR.getFloat(r100, r101);
    }

    public static int getInt(Object r100, long r101) {
        return MEMORY_ACCESSOR.getInt(r100, r101);
    }

    public static long getLong(Object r100, long r101) {
        return MEMORY_ACCESSOR.getLong(r100, r101);
    }

    public static Object getObject(Object r100, long r101) {
        return MEMORY_ACCESSOR.getObject(r100, r101);
    }

    public static void putBoolean(boolean[] r100, long r101, boolean r102) {
        MEMORY_ACCESSOR.putBoolean(r100, BOOLEAN_ARRAY_BASE_OFFSET + (r101 * BOOLEAN_ARRAY_INDEX_SCALE), r102);
    }

    public static void putByte(byte[] r100, long r101, byte r102) {
        MEMORY_ACCESSOR.putByte(r100, BYTE_ARRAY_BASE_OFFSET + r101, r102);
    }

    public static void putDouble(double[] r100, long r101, double r102) {
        MEMORY_ACCESSOR.putDouble(r100, DOUBLE_ARRAY_BASE_OFFSET + (r101 * DOUBLE_ARRAY_INDEX_SCALE), r102);
    }

    public static void putFloat(float[] r100, long r101, float r102) {
        MEMORY_ACCESSOR.putFloat(r100, FLOAT_ARRAY_BASE_OFFSET + (r101 * FLOAT_ARRAY_INDEX_SCALE), r102);
    }

    public static void putInt(int[] r100, long r101, int r102) {
        MEMORY_ACCESSOR.putInt(r100, INT_ARRAY_BASE_OFFSET + (r101 * INT_ARRAY_INDEX_SCALE), r102);
    }

    public static void putLong(long[] r100, long r101, long r102) {
        MEMORY_ACCESSOR.putLong(r100, LONG_ARRAY_BASE_OFFSET + (r101 * LONG_ARRAY_INDEX_SCALE), r102);
    }

    public static void putObject(Object[] r100, long r101, Object r102) {
        MEMORY_ACCESSOR.putObject(r100, OBJECT_ARRAY_BASE_OFFSET + (r101 * OBJECT_ARRAY_INDEX_SCALE), r102);
    }

    public static void putBoolean(Object r100, long r101, boolean r102) {
        MEMORY_ACCESSOR.putBoolean(r100, r101, r102);
    }

    public static void putByte(Object r100, long r101, byte r102) {
        MEMORY_ACCESSOR.putByte(r100, r101, r102);
    }

    public static void putDouble(Object r100, long r101, double r102) {
        MEMORY_ACCESSOR.putDouble(r100, r101, r102);
    }

    public static void putFloat(Object r100, long r101, float r102) {
        MEMORY_ACCESSOR.putFloat(r100, r101, r102);
    }

    public static void putInt(Object r100, long r101, int r102) {
        MEMORY_ACCESSOR.putInt(r100, r101, r102);
    }

    public static void putLong(Object r100, long r101, long r102) {
        MEMORY_ACCESSOR.putLong(r100, r101, r102);
    }

    public static void putObject(Object r100, long r101, Object r102) {
        MEMORY_ACCESSOR.putObject(r100, r101, r102);
    }

    public static void copyMemory(long r100, byte[] r110, long r111, long r112) {
        MEMORY_ACCESSOR.copyMemory(r100, r110, r111, r112);
    }

    public static void copyMemory(byte[] r100, long r101, long r110, long r111) {
        MEMORY_ACCESSOR.copyMemory(r100, r101, r110, r111);
    }

    public static void copyMemory(byte[] r100, long r101, byte[] r102, long r103, long r104) {
        System.arraycopy(r100, (int) r101, r102, (int) r103, (int) r104);
    }
}
