package com.google.common.hash;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class Striped64 extends Number {
    static final int NCPU = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f275596a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f275597b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f275598c = 0;
    static final Random rng = null;
    static final ThreadLocal<int[]> threadHashCode = null;
    volatile transient long base;
    volatile transient int busy;

    @CheckForNull
    volatile transient b[] cells;

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

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Unsafe f275599b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final long f275600c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f275601a;

        static {
            Unsafe r100 = Striped64.access$000();     // Catch: Exception -> L4
            f275599b = r100;     // Catch: Exception -> L4
            f275600c = r100.objectFieldOffset(b.class.getDeclaredField(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY));     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            throw new Error(e);
        }

        public b(long r100) {
            this.f275601a = r100;
        }

        public final boolean a(long r100, long r110) {
            return f275599b.compareAndSwapLong(this, f275600c, r100, r110);
        }
    }

    abstract long fn(long r100, long r101);

    static {
        threadHashCode = new ThreadLocal();
        rng = new Random();
        NCPU = Runtime.getRuntime().availableProcessors();
        Unsafe r100 = a();     // Catch: Exception -> L5
        f275596a = r100;     // Catch: Exception -> L5
        f275597b = r100.objectFieldOffset(Striped64.class.getDeclaredField("base"));     // Catch: Exception -> L5
        f275598c = r100.objectFieldOffset(Striped64.class.getDeclaredField("busy"));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new Error(e);
    }

    final boolean casBusy() {
        return f275596a.compareAndSwapInt(this, f275598c, 0, 1);
    }

    public static Unsafe a() {
        return Unsafe.getUnsafe();
    L4:
        return (Unsafe) AccessController.doPrivileged(new a());
    L6:
        e = move-exception;
        throw new RuntimeException("Could not initialize intrinsics", e.getCause());
    }

    static /* synthetic */ Unsafe access$000() {
        return a();
    }

    public Striped64() {
    }

    final void internalReset(long r100) {
        b[] r101 = this.cells;
        this.base = r100;
        if (r101 == null) goto L10;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        b r104 = r101[r103];
        if (r104 == null) goto L9;
        r104.f275601a = r100;
    L9:
        r103 = r103 + 1;
        goto L5
    L14:
        return;
    }

    final boolean casBase(long r100, long r110) {
        return f275596a.compareAndSwapLong(this, f275597b, r100, r110);
    }

    final void retryUpdate(long r110, @CheckForNull int[] r111, boolean r210) {
        if (r111 != null) goto L8;
        int[] r100 = new int[1];
        threadHashCode.set(r100);
        int r101 = rng.nextInt();
        if (r101 != 0) goto L7;
        r101 = 1;
    L7:
        r100[0] = r101;
    L9:
        int r102 = r101;
        boolean r103 = false;
        boolean r104 = r210;
    L10:
        b[] r105 = this.cells;
        if (r105 == null) goto L66;
        int r112 = r105.length;
        if (r112 <= 0) goto L66;
        b r113 = r105[(r112 - 1) & r102];
        if (r113 == null) goto L17;
        if (r104 == false) goto L39;
        long r114 = r113.f275601a;
        if (r113.a(r114, fn(r114, r110)) == true) goto L119;
        if (r112 >= NCPU) goto L37;
        if (this.cells != r105) goto L37;
        if (r103 == false) goto L49;
        if (this.busy != 0) goto L64;
        if (casBusy() == false) goto L64;
        if (this.cells != r105) goto L60;
        b[] r106 = new b[r112 << 1];     // Catch: Throwable -> L61
        int r115 = 0;
    L57:
        if (r115 >= r112) goto L59;
        r106[r115] = r105[r115];     // Catch: Throwable -> L61
        r115 = r115 + 1;     // Catch: Throwable -> L61
        goto L57
    L59:
        this.cells = r106;     // Catch: Throwable -> L61
    L60:
        this.busy = 0;
        r103 = false;
    L61:
        th = move-exception;
        this.busy = 0;
        throw th;
    L64:
        int r107 = r102 ^ (r102 << 13);
        int r108 = r107 ^ (r107 >>> 17);
        r102 = r108 ^ (r108 << 5);
        r100[0] = r102;
        goto L10
    L49:
        r103 = true;
    L37:
        r103 = false;
        goto L64
    L119:
        return;
    L39:
        r104 = true;
        goto L64
    L17:
        if (this.busy != 0) goto L37;
        b r109 = new b(r110);
        if (this.busy != 0) goto L37;
        if (casBusy() == false) goto L37;
        b[] r116 = this.cells;     // Catch: Throwable -> L34
        if (r116 == null) goto L30;
        int r117 = r116.length;     // Catch: Throwable -> L34
        if (r117 <= 0) goto L30;
        int r118 = (r117 - 1) & r102;     // Catch: Throwable -> L34
        if (r116[r118] != null) goto L30;
        r116[r118] = r109;     // Catch: Throwable -> L34
        boolean r119 = true;
    L31:
        this.busy = 0;
        if (r119 == false) goto L10;
        return;
    L30:
        r119 = false;
    L34:
        th = move-exception;
        this.busy = 0;
        throw th;
    L66:
        if (this.busy != 0) goto L82;
        if (this.cells != r105) goto L82;
        if (casBusy() == false) goto L82;
    L79:
        th = move-exception;
        this.busy = 0;
        throw th;
    L72:
        if (this.cells != r105) goto L75;
        b[] r120 = new b[2];     // Catch: Throwable -> L79
        r120[r102 & 1] = new b(r110);     // Catch: Throwable -> L79
        this.cells = r120;     // Catch: Throwable -> L79
        boolean r121 = true;
    L76:
        this.busy = 0;
        if (r121 == false) goto L10;
        return;
    L75:
        r121 = false;
    L82:
        long r122 = this.base;
        if (casBase(r122, fn(r122, r110)) == false) goto L10;
        return;
    L8:
        r101 = r111[0];
        r100 = r111;
        goto L9
    }
}
