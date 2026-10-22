package com.google.common.primitives;

import com.bytedance.bdlocation.exception.BDLocationException;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Comparator;
import kotlin.UByte;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes23.dex */
final enum UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator extends Enum<UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator> implements Comparator<byte[]> {
    static final boolean BIG_ENDIAN = false;
    static final int BYTE_ARRAY_BASE_OFFSET = 0;
    public static final UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[] f275654a = null;
    static final Unsafe theUnsafe = null;

    public class a implements PrivilegedExceptionAction<Unsafe> {
        public a() {
        }

        public static Unsafe a() throws Exception {
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

        @Override // java.security.PrivilegedExceptionAction
        public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
            return a();
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
    }

    static {
        UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator r100 = new UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator();
        INSTANCE = r100;
        f275654a = new UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[]{r100};
        BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
        Unsafe r101 = a();
        theUnsafe = r101;
        int r102 = r101.arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = r102;
        if (BDLocationException.ERROR_RESTRICTED_MODE_ON.equals(System.getProperty("sun.arch.data.model")) == false) goto L10;
        if ((r102 % 8) != 0) goto L10;
        if (r101.arrayIndexScale(byte[].class) != 1) goto L10;
        return;
    L10:
        throw new Error();
    }

    public UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator() {
        super("INSTANCE", 0);
    }

    public static UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[] values() {
        return (UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[]) f275654a.clone();
    }

    public static Unsafe a() {
        return Unsafe.getUnsafe();
    L4:
        return (Unsafe) AccessController.doPrivileged(new a());
    L6:
        e = move-exception;
        throw new RuntimeException("Could not initialize intrinsics", e.getCause());
    }

    public static UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator valueOf(String r100) {
        return (UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator) r27.a.a(UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.class, r100);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(byte[] r110, byte[] r111) {
        int r100 = Math.min(r110.length, r111.length);
        int r101 = r100 & (-8);
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L13;
        Unsafe r103 = theUnsafe;
        int r104 = BYTE_ARRAY_BASE_OFFSET;
        long r105 = r102;
        long r106 = r103.getLong(r110, ((long) r104) + r105);
        long r107 = r103.getLong(r111, ((long) r104) + r105);
        if (r106 != r107) goto L7;
        r102 = r102 + 8;
        goto L3
    L7:
        if (BIG_ENDIAN == true) goto L9;
        int r112 = Long.numberOfTrailingZeros(r106 ^ r107) & (-8);
        return ((int) ((r106 >>> r112) & 255)) - ((int) ((r107 >>> r112) & 255));
    L9:
        return UnsignedLongs.a(r106, r107);
    L13:
        if (r102 >= r100) goto L19;
        int r108 = (r110[r102] & UByte.MAX_VALUE) - (r111[r102] & UByte.MAX_VALUE);
        if (r108 != 0) goto L16;
        r102 = r102 + 1;
        goto L13
    L16:
        return r108;
    L19:
        return r110.length - r111.length;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(byte[] r100, byte[] r101) {
        return compare2(r100, r101);
    }
}
