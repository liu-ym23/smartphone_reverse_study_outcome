package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes23.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f275897a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f275898b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f275899c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f275900d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f275901e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f275902f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f275903g = false;

    public class a implements PrivilegedExceptionAction<Unsafe> {
        public a() {
        }

        public static Unsafe a() throws Exception {
            Field[] r100 = Unsafe.class.getDeclaredFields();
            int r101 = r100.length;
            int r102 = 0;
        L4:
            if (r102 >= r101) goto L10;
            Field r103 = r100[r102];
            r103.setAccessible(true);
            Object r104 = r103.get(null);
            if (Unsafe.class.isInstance(r104) == true) goto L8;
            r102 = r102 + 1;
            goto L4
        L8:
            return (Unsafe) Unsafe.class.cast(r104);
        L10:
            return null;
        }

        @Override // java.security.PrivilegedExceptionAction
        public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
            return a();
        }
    }

    public static final class b extends e {
        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final boolean l() {
            return false;
        }

        public b(Unsafe r100) {
            super(r100);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final byte d(long r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final long g(long r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final byte e(Object r100, long r101) {
            if (i.f275903g == false) goto L6;
            e r102 = i.f275898b;
            return (byte) ((r102.f(r100, (-4) & r101) >>> ((int) (((~r101) & 3) << 3))) & 255);
        L6:
            e r103 = i.f275898b;
            return (byte) ((r103.f(r100, (-4) & r101) >>> ((int) ((r101 & 3) << 3))) & 255);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final void c(long r100, byte[] r101, long r102, long r103) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class c extends e {
        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final boolean l() {
            return false;
        }

        public c(Unsafe r100) {
            super(r100);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final byte d(long r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final long g(long r100) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final byte e(Object r100, long r101) {
            if (i.f275903g == false) goto L6;
            e r102 = i.f275898b;
            return (byte) ((r102.f(r100, (-4) & r101) >>> ((int) (((~r101) & 3) << 3))) & 255);
        L6:
            e r103 = i.f275898b;
            return (byte) ((r103.f(r100, (-4) & r101) >>> ((int) ((r101 & 3) << 3))) & 255);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final void c(long r100, byte[] r101, long r102, long r103) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class d extends e {
        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final boolean l() {
            Unsafe r100 = this.f275904a;
            if (r100 != null) goto L18;
        L4:
            boolean r101 = false;
        L11:
            if (r101 == true) goto L20;
            return false;
        L20:
            Class<?> r102 = this.f275904a.getClass();     // Catch: Throwable -> L15
            Class<?> r103 = Long.TYPE;     // Catch: Throwable -> L15
            r102.getMethod("getByte", new Class[]{r103});     // Catch: Throwable -> L15
            r102.getMethod("putByte", new Class[]{r103, Byte.TYPE});     // Catch: Throwable -> L15
            r102.getMethod("getInt", new Class[]{r103});     // Catch: Throwable -> L15
            r102.getMethod("putInt", new Class[]{r103, Integer.TYPE});     // Catch: Throwable -> L15
            r102.getMethod("getLong", new Class[]{r103});     // Catch: Throwable -> L15
            r102.getMethod("putLong", new Class[]{r103, r103});     // Catch: Throwable -> L15
            r102.getMethod("copyMemory", new Class[]{r103, r103, r103});     // Catch: Throwable -> L15
            r102.getMethod("copyMemory", new Class[]{Object.class, r103, Object.class, r103, r103});     // Catch: Throwable -> L15
            return true;
        L15:
            th = move-exception;
            i.a(th);
            return false;
        L18:
            Class<?> r104 = r100.getClass();     // Catch: Throwable -> L9
            r104.getMethod("objectFieldOffset", new Class[]{Field.class});     // Catch: Throwable -> L9
            r104.getMethod("getLong", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L9
            if (i.d() == null) goto L4;
            r101 = true;
        L9:
            th = move-exception;
            i.a(th);
            goto L4
        }

        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final boolean k() {
            if (super.k() == true) goto L10;
            return false;
        L10:
            Class<?> r100 = this.f275904a.getClass();     // Catch: Throwable -> L7
            Class<?> r101 = Long.TYPE;     // Catch: Throwable -> L7
            r100.getMethod("getByte", new Class[]{Object.class, r101});     // Catch: Throwable -> L7
            r100.getMethod("putByte", new Class[]{Object.class, r101, Byte.TYPE});     // Catch: Throwable -> L7
            r100.getMethod("getBoolean", new Class[]{Object.class, r101});     // Catch: Throwable -> L7
            r100.getMethod("putBoolean", new Class[]{Object.class, r101, Boolean.TYPE});     // Catch: Throwable -> L7
            r100.getMethod("getFloat", new Class[]{Object.class, r101});     // Catch: Throwable -> L7
            r100.getMethod("putFloat", new Class[]{Object.class, r101, Float.TYPE});     // Catch: Throwable -> L7
            r100.getMethod("getDouble", new Class[]{Object.class, r101});     // Catch: Throwable -> L7
            r100.getMethod("putDouble", new Class[]{Object.class, r101, Double.TYPE});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            i.a(th);
            return false;
        }

        public d(Unsafe r100) {
            super(r100);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final byte d(long r100) {
            return this.f275904a.getByte(r100);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final long g(long r100) {
            return this.f275904a.getLong(r100);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final byte e(Object r100, long r101) {
            return this.f275904a.getByte(r100, r101);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.i.e
        public final void c(long r110, byte[] r111, long r112, long r113) {
            this.f275904a.copyMemory(null, r110, r111, i.f275901e + r112, r113);
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Unsafe f275904a;

        public abstract void c(long r100, byte[] r101, long r102, long r103);

        public abstract byte d(long r100);

        public abstract byte e(Object r100, long r101);

        public abstract long g(long r100);

        public abstract boolean l();

        public boolean k() {
            Unsafe r100 = this.f275904a;
            if (r100 != null) goto L10;
            return false;
        L10:
            Class<?> r101 = r100.getClass();     // Catch: Throwable -> L7
            r101.getMethod("objectFieldOffset", new Class[]{Field.class});     // Catch: Throwable -> L7
            r101.getMethod("arrayBaseOffset", new Class[]{Class.class});     // Catch: Throwable -> L7
            r101.getMethod("arrayIndexScale", new Class[]{Class.class});     // Catch: Throwable -> L7
            Class<?> r102 = Long.TYPE;     // Catch: Throwable -> L7
            r101.getMethod("getInt", new Class[]{Object.class, r102});     // Catch: Throwable -> L7
            r101.getMethod("putInt", new Class[]{Object.class, r102, Integer.TYPE});     // Catch: Throwable -> L7
            r101.getMethod("getLong", new Class[]{Object.class, r102});     // Catch: Throwable -> L7
            r101.getMethod("putLong", new Class[]{Object.class, r102, r102});     // Catch: Throwable -> L7
            r101.getMethod("getObject", new Class[]{Object.class, r102});     // Catch: Throwable -> L7
            r101.getMethod("putObject", new Class[]{Object.class, r102, Object.class});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            i.a(th);
            return false;
        }

        public e(Unsafe r100) {
            this.f275904a = r100;
        }

        public final int a(Class<?> r100) {
            return this.f275904a.arrayBaseOffset(r100);
        }

        public final int b(Class<?> r100) {
            return this.f275904a.arrayIndexScale(r100);
        }

        public final long j(Field r100) {
            return this.f275904a.objectFieldOffset(r100);
        }

        public final int f(Object r100, long r101) {
            return this.f275904a.getInt(r100, r101);
        }

        public final long h(Object r100, long r101) {
            return this.f275904a.getLong(r100, r101);
        }

        public final Object i(Object r100, long r101) {
            return this.f275904a.getObject(r100, r101);
        }
    }

    public i() {
    }

    public static Unsafe h() {
        return (Unsafe) AccessController.doPrivileged(new a());
    L4:
        return null;
    }

    static {
        Unsafe r100 = h();
        f275897a = com.google.crypto.tink.shaded.protobuf.a.f275855a;
        boolean r101 = e(Long.TYPE);
        boolean r102 = e(Integer.TYPE);
        if (r100 != null) goto L6;
    L11:
        e r103 = null;
    L13:
        f275898b = r103;
        boolean r104 = false;
        if (r103 != null) goto L16;
        boolean r105 = false;
    L17:
        f275899c = r105;
        if (r103 != null) goto L20;
        boolean r106 = false;
    L21:
        f275900d = r106;
        f275901e = b(byte[].class);
        b(boolean[].class);
        c(boolean[].class);
        b(int[].class);
        c(int[].class);
        b(long[].class);
        c(long[].class);
        b(float[].class);
        c(float[].class);
        b(double[].class);
        c(double[].class);
        b(Object[].class);
        c(Object[].class);
        Field r107 = d();
        if (r107 == null) goto L26;
        if (r103 == null) goto L26;
        long r108 = r103.j(r107);
    L27:
        f275902f = r108;
        if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) goto L30;
        r104 = true;
    L30:
        f275903g = r104;
        return;
    L26:
        r108 = -1;
        goto L27
    L20:
        r106 = r103.k();
        goto L21
    L16:
        r105 = r103.l();
        goto L17
    L6:
        if (com.google.crypto.tink.shaded.protobuf.a.b() == false) goto L12;
        if (r101 == false) goto L9;
        r103 = new c(r100);
        goto L13
    L9:
        if (r102 == false) goto L11;
        r103 = new b(r100);
        goto L13
    L12:
        r103 = new d(r100);
        goto L13
    }

    public static Field d() {
        if (com.google.crypto.tink.shaded.protobuf.a.b() == false) goto L21;
        Field r100 = Buffer.class.getDeclaredField("effectiveDirectAddress");     // Catch: Throwable -> L7
    L8:
        if (r100 == null) goto L21;
        return r100;
    L7:
        r100 = null;
    L21:
        Field r101 = Buffer.class.getDeclaredField("address");     // Catch: Throwable -> L13
    L14:
        if (r101 != null) goto L16;
        return null;
    L16:
        if (r101.getType() == Long.TYPE) goto L18;
        return null;
    L18:
        return r101;
    L13:
        r101 = null;
        goto L14
    }

    public static void a(Throwable r100) {
        Logger.getLogger(i.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + r100);
    }

    public static int b(Class<?> r100) {
        if (f275900d == true) goto L7;
        return -1;
    L7:
        return f275898b.a(r100);
    }

    public static void c(Class r100) {
        if (f275900d == false) goto L6;
        f275898b.b(r100);
        return;
    }

    public static boolean e(Class<?> r110) {
        if (com.google.crypto.tink.shaded.protobuf.a.b() == true) goto L8;
        return false;
    L8:
        Class<?> r100 = f275897a;     // Catch: Throwable -> L7
        Class<?> r101 = Boolean.TYPE;     // Catch: Throwable -> L7
        r100.getMethod("peekLong", new Class[]{r110, r101});     // Catch: Throwable -> L7
        r100.getMethod("pokeLong", new Class[]{r110, Long.TYPE, r101});     // Catch: Throwable -> L7
        Class<?> r102 = Integer.TYPE;     // Catch: Throwable -> L7
        r100.getMethod("pokeInt", new Class[]{r110, r102, r101});     // Catch: Throwable -> L7
        r100.getMethod("peekInt", new Class[]{r110, r101});     // Catch: Throwable -> L7
        r100.getMethod("pokeByte", new Class[]{r110, Byte.TYPE});     // Catch: Throwable -> L7
        r100.getMethod("peekByte", new Class[]{r110});     // Catch: Throwable -> L7
        r100.getMethod("pokeByteArray", new Class[]{r110, byte[].class, r102, r102});     // Catch: Throwable -> L7
        r100.getMethod("peekByteArray", new Class[]{r110, byte[].class, r102, r102});     // Catch: Throwable -> L7
        return true;
    L7:
        return false;
    }

    public static byte f(long r100) {
        return f275898b.d(r100);
    }

    public static byte g(byte[] r100, long r101) {
        return f275898b.e(r100, f275901e + r101);
    }
}
