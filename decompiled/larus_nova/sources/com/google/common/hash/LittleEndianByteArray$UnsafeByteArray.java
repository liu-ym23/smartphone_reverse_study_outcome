package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes23.dex */
abstract enum LittleEndianByteArray$UnsafeByteArray extends Enum<LittleEndianByteArray$UnsafeByteArray> {
    public static final LittleEndianByteArray$UnsafeByteArray UNSAFE_BIG_ENDIAN = null;
    public static final LittleEndianByteArray$UnsafeByteArray UNSAFE_LITTLE_ENDIAN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f275569a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f275570b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ LittleEndianByteArray$UnsafeByteArray[] f275571c = null;

    public LittleEndianByteArray$UnsafeByteArray() {
        throw null;
    }

    public abstract /* synthetic */ long getLongLittleEndian(byte[] r100, int r101);

    public abstract /* synthetic */ void putLongLittleEndian(byte[] r100, int r101, long r102);

    static {
        final String r100 = "UNSAFE_LITTLE_ENDIAN";
        final int r101 = 0;
        LittleEndianByteArray$UnsafeByteArray r102 = new AnonymousClass1(r100, r101);
        UNSAFE_LITTLE_ENDIAN = r102;
        final String r103 = "UNSAFE_BIG_ENDIAN";
        final int r104 = 1;
        LittleEndianByteArray$UnsafeByteArray r105 = new AnonymousClass2(r103, r104);
        UNSAFE_BIG_ENDIAN = r105;
        f275571c = new LittleEndianByteArray$UnsafeByteArray[]{r102, r105};
        Unsafe r106 = a();
        f275569a = r106;
        f275570b = r106.arrayBaseOffset(byte[].class);
        if (r106.arrayIndexScale(byte[].class) != 1) goto L6;
        return;
    L6:
        throw new AssertionError();
    }

    public static /* synthetic */ Unsafe b() throws Exception {
        Field[] r100 = Unsafe.class.getDeclaredFields();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        Field r103 = r100[r102];
        r103.setAccessible(true);
        Object r104 = r103.get(null);
        if (Unsafe.class.isInstance(r104) == true) goto L7;
        r102 = r102 + 1;
        goto L3
    L7:
        return (Unsafe) Unsafe.class.cast(r104);
    L10:
        throw new NoSuchFieldError("the Unsafe");
    }

    public static LittleEndianByteArray$UnsafeByteArray[] values() {
        return (LittleEndianByteArray$UnsafeByteArray[]) f275571c.clone();
    }

    public static Unsafe a() {
        return Unsafe.getUnsafe();
    L4:
        return (Unsafe) AccessController.doPrivileged(new i());
    L6:
        e = move-exception;
        throw new RuntimeException("Could not initialize intrinsics", e.getCause());
    }

    public static /* synthetic */ int access$100() {
        return f275570b;
    }

    public static /* synthetic */ Unsafe access$200() {
        return f275569a;
    }

    public static LittleEndianByteArray$UnsafeByteArray valueOf(String r100) {
        return (LittleEndianByteArray$UnsafeByteArray) r27.a.a(LittleEndianByteArray$UnsafeByteArray.class, r100);
    }

    public LittleEndianByteArray$UnsafeByteArray(String r100, int r101, h r102) {
        super(r100, r101);
    }
}
