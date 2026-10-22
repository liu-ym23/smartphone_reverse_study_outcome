package com.bytedance.android.alog;

import android.content.Context;
import android.text.TextUtils;
import android.util.EventsUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class Alog {
    public static final int i = 0;
    public static final int j = 0;
    public static final int k = 0;
    public static final int l = 0;
    public static final int m = 0;
    public static final int n = 0;
    public static volatile List<d> o;
    public static final ArrayList<String> p = null;
    public static boolean q;
    public int a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public String f;
    public final String g;
    public long h;

    public static final enum AsymCrypt extends Enum<AsymCrypt> {
        public static final AsymCrypt EC_SECP256K1 = null;
        public static final AsymCrypt EC_SECP256R1 = null;
        public static final AsymCrypt NONE = null;
        public static final /* synthetic */ AsymCrypt[] a = null;
        private final int value;

        static {
            AsymCrypt r0 = new AsymCrypt("NONE", 0, 0);
            NONE = r0;
            AsymCrypt r1 = new AsymCrypt("EC_SECP256K1", 1, 1);
            EC_SECP256K1 = r1;
            AsymCrypt r3 = new AsymCrypt("EC_SECP256R1", 2, 2);
            EC_SECP256R1 = r3;
            a = new AsymCrypt[]{r0, r1, r3};
        }

        public static AsymCrypt[] values() {
            return (AsymCrypt[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static AsymCrypt valueOf(String r1) {
            return (AsymCrypt) r27.a.a(AsymCrypt.class, r1);
        }

        public AsymCrypt(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Compress extends Enum<Compress> {
        public static final Compress NONE = null;
        public static final Compress ZLIB = null;
        public static final Compress ZSTD = null;
        public static final /* synthetic */ Compress[] a = null;
        private final int value;

        static {
            Compress r0 = new Compress("NONE", 0, 0);
            NONE = r0;
            Compress r1 = new Compress("ZLIB", 1, 1);
            ZLIB = r1;
            Compress r3 = new Compress("ZSTD", 2, 2);
            ZSTD = r3;
            a = new Compress[]{r0, r1, r3};
        }

        public static Compress[] values() {
            return (Compress[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static Compress valueOf(String r1) {
            return (Compress) r27.a.a(Compress.class, r1);
        }

        public Compress(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Mode extends Enum<Mode> {
        public static final Mode SAFE = null;
        public static final Mode SPEED = null;
        public static final /* synthetic */ Mode[] a = null;
        private final int value;

        static {
            Mode r0 = new Mode("SPEED", 0, 0);
            SPEED = r0;
            Mode r1 = new Mode("SAFE", 1, 1);
            SAFE = r1;
            a = new Mode[]{r0, r1};
        }

        public static Mode[] values() {
            return (Mode[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static Mode valueOf(String r1) {
            return (Mode) r27.a.a(Mode.class, r1);
        }

        public Mode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum PrefixFormat extends Enum<PrefixFormat> {
        public static final PrefixFormat DEFAULT = null;
        public static final PrefixFormat LEGACY = null;
        public static final /* synthetic */ PrefixFormat[] a = null;
        private final int value;

        static {
            PrefixFormat r0 = new PrefixFormat("DEFAULT", 0, 0);
            DEFAULT = r0;
            PrefixFormat r1 = new PrefixFormat("LEGACY", 1, 1);
            LEGACY = r1;
            a = new PrefixFormat[]{r0, r1};
        }

        public static PrefixFormat[] values() {
            return (PrefixFormat[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static PrefixFormat valueOf(String r1) {
            return (PrefixFormat) r27.a.a(PrefixFormat.class, r1);
        }

        public PrefixFormat(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum SymCrypt extends Enum<SymCrypt> {
        public static final SymCrypt NONE = null;
        public static final SymCrypt TEA_16 = null;
        public static final SymCrypt TEA_32 = null;
        public static final SymCrypt TEA_64 = null;
        public static final /* synthetic */ SymCrypt[] a = null;
        private final int value;

        static {
            SymCrypt r0 = new SymCrypt("NONE", 0, 0);
            NONE = r0;
            SymCrypt r1 = new SymCrypt("TEA_16", 1, 1);
            TEA_16 = r1;
            SymCrypt r3 = new SymCrypt("TEA_32", 2, 2);
            TEA_32 = r3;
            SymCrypt r5 = new SymCrypt("TEA_64", 3, 3);
            TEA_64 = r5;
            a = new SymCrypt[]{r0, r1, r3, r5};
        }

        public static SymCrypt[] values() {
            return (SymCrypt[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static SymCrypt valueOf(String r1) {
            return (SymCrypt) r27.a.a(SymCrypt.class, r1);
        }

        public SymCrypt(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum TimeFormat extends Enum<TimeFormat> {
        public static final TimeFormat ISO_8601 = null;
        public static final TimeFormat RAW = null;
        public static final /* synthetic */ TimeFormat[] a = null;
        private final int value;

        static {
            TimeFormat r0 = new TimeFormat("RAW", 0, 0);
            RAW = r0;
            TimeFormat r1 = new TimeFormat("ISO_8601", 1, 1);
            ISO_8601 = r1;
            a = new TimeFormat[]{r0, r1};
        }

        public static TimeFormat[] values() {
            return (TimeFormat[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static TimeFormat valueOf(String r1) {
            return (TimeFormat) r27.a.a(TimeFormat.class, r1);
        }

        public TimeFormat(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static class a {
        public final Context a;
        public int b;
        public boolean c;
        public String d;
        public String e;
        public int f;
        public int g;
        public int h;
        public String i;
        public int j;
        public int k;
        public String l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public String s;
        public boolean t;

        public final Alog a() {
            if (this.d != null) goto L5;
            this.d = "default";
        L5:
            ArrayList<String> r2 = Alog.p;
            monitor-enter(r2);
            Iterator<String> r0 = r2.iterator();     // Catch: Throwable -> L43
        L8:
            String r4 = null;
            if (r0.hasNext() == false) goto L14;
            if (r0.next().equals(this.d) == false) goto L8;
            monitor-exit(r2);     // Catch: Throwable -> L43
            return null;
        L14:
            Alog.p.add(this.d);     // Catch: Throwable -> L43
            monitor-exit(r2);     // Catch: Throwable -> L43
            if (this.e != null) goto L23;
            File r1 = this.a.getExternalFilesDir(null);
            if (r1 == null) goto L21;
            this.e = r1.getPath() + "/alog";
            goto L23
        L21:
            this.e = this.a.getFilesDir() + "/alog";
        L23:
            if (this.i != null) goto L26;
            this.i = this.a.getFilesDir() + "/alog";
        L26:
            if (this.l != null) goto L35;
            Context r3 = this.a;
            r4 = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionName;     // Catch: Exception -> L30
        L32:
            if (TextUtils.isEmpty(r4) == false) goto L34;
            r4 = "unknown";
        L34:
            this.l = r4;
        L35:
            int r5 = (this.j / 4096) * 4096;
            this.j = r5;
            int r6 = (this.k / 4096) * 4096;
            this.k = r6;
            if (r5 >= 4096) goto L38;
            this.j = 4096;
        L38:
            int r7 = this.j;
            if (r6 >= (r7 * 2)) goto L42;
            this.k = r7 * 2;
        L42:
            return new Alog(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t);
        L43:
            th = move-exception;
            throw th;
        }

        public a(Context r4) {
            this.b = 0;
            this.c = false;
            this.d = null;
            this.e = null;
            this.f = 2097152;
            this.g = 20971520;
            this.h = 7;
            this.i = null;
            this.j = 65536;
            this.k = 196608;
            this.l = null;
            this.m = Alog.i;
            this.n = Alog.j;
            this.o = Alog.k;
            this.p = Alog.l;
            this.q = Alog.m;
            this.r = Alog.n;
            this.s = "b012e20c9aab1cb5257aca2069cb79a9339b3a2224f771c78d64972137936eaf0b2f7ebd8d46c2607e1d7fe7723d40b147b8ecfa8fe2eaeee05210c75822381a";
            this.t = false;
            Context r0 = r4.getApplicationContext();
            if (r0 == null) goto L5;
            r4 = r0;
        L5:
            this.a = r4;
        }

        public final void b(String r4) {
            if (TextUtils.isEmpty(r4) == false) goto L5;
            return;
        L5:
            if (r4.contains("-") == false) goto L8;
            r4 = r4.replace("-", XmlPullParser.NO_NAMESPACE);
        L8:
            if (r4.contains("_") == false) goto L11;
            r4 = r4.replace("_", XmlPullParser.NO_NAMESPACE);
        L11:
            if (TextUtils.isEmpty(r4) == true) goto L15;
            this.d = r4;
            return;
        }
    }

    private static native void nativeAsyncFlush(long r0);

    private static native long nativeCreate(int r0, boolean r1, String r2, String r3, int r4, int r5, int r6, String r7, int r8, int r9, String r10, int r11, int r12, int r13, int r14, int r15, int r16, String r17, boolean r18, long r19);

    private static native void nativeDestroy(long r0);

    private static native long nativeGetLegacyFlushFuncAddr();

    private static native long nativeGetLegacyGetLogFileDirFuncAddr();

    private static native long nativeGetLegacyWriteFuncAddr();

    private static native long nativeGetNativeInitFuncAddr();

    private static native long nativeGetNativeWriteAsyncFuncAddr();

    private static native long nativeGetNativeWriteFuncAddr();

    public static native void nativeSetDefaultInstance(long r0);

    private static native void nativeSetLevel(long r0, int r2);

    private static native void nativeSetSyslog(long r0, boolean r2);

    private static native void nativeSyncFlush(long r0);

    private static native void nativeTimedSyncFlush(long r0, int r2);

    private static native void nativeWrite(long r0, int r2, String r3, String r4);

    private static native void nativeWriteAsyncMsg(long r0, int r2, String r3, String r4, long r5, long r7);

    public final void b() {
        monitor-enter(this);
        long r0 = this.h;     // Catch: Throwable -> L8
        if (r0 == 0) goto L6;
        this.a = 6;     // Catch: Throwable -> L8
        nativeDestroy(r0);     // Catch: Throwable -> L8
        this.h = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    static {
        i = Mode.SAFE.getValue();
        j = TimeFormat.RAW.getValue();
        k = PrefixFormat.DEFAULT.getValue();
        l = Compress.ZSTD.getValue();
        m = SymCrypt.TEA_16.getValue();
        n = AsymCrypt.EC_SECP256K1.getValue();
        o = null;
        p = new ArrayList();
        q = false;
    }

    public final void a() {
        long r0 = this.h;
        if (r0 == 0) goto L6;
        nativeAsyncFlush(r0);
        return;
    }

    public final long c() {
        if (this.h != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyFlushFuncAddr();
    }

    public final long d() {
        if (this.h != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyGetLogFileDirFuncAddr();
    }

    public final long e() {
        if (this.h != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyWriteFuncAddr();
    }

    public final long f() {
        if (this.h != 0) goto L5;
        return 0;
    L5:
        return nativeGetNativeInitFuncAddr();
    }

    public final long g() {
        if (this.h != 0) goto L5;
        return 0;
    L5:
        return nativeGetNativeWriteAsyncFuncAddr();
    }

    public final long h() {
        if (this.h != 0) goto L5;
        return 0;
    L5:
        return nativeGetNativeWriteFuncAddr();
    }

    public final void l() {
        long r0 = this.h;
        if (r0 == 0) goto L6;
        nativeSyncFlush(r0);
        return;
    }

    public final void finalize() throws Throwable {
        super.finalize();     // Catch: Throwable -> L5
        b();
        return;
    L5:
        th = move-exception;
        b();
        throw th;
    }

    public static synchronized void i(nra.c r2) {
        monitor-enter(Alog.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (q == false) goto L8;
        monitor-exit(Alog.class);
        return;
    L8:
        r2.a();     // Catch: Throwable -> L11
        q = true;     // Catch: Throwable -> L11
        monitor-exit(Alog.class);
    }

    public final void j(int r6) {
        this.a = r6;
        long r0 = this.h;
        if (r0 == 0) goto L6;
        nativeSetLevel(r0, r6);
        return;
    }

    public final void k(boolean r6) {
        long r0 = this.h;
        if (r0 == 0) goto L6;
        nativeSetSyslog(r0, r6);
        return;
    }

    public final void m(int r6) {
        long r0 = this.h;
        if (r0 == 0) goto L6;
        nativeTimedSyncFlush(r0, r6);
        return;
    }

    public final void n(int r6, String r7, String r8) {
        if (this.h != 0) goto L5;
        return;
    L5:
        if (r6 < this.a) goto L21;
        if (r7 == null) goto L22;
        if (r8 != null) goto L9;
        return;
    L9:
        if (o == null) goto L17;
        f r0 = new f(r6, r7, r8);
        Iterator r9 = ((CopyOnWriteArrayList) o).iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        r0 = ((d) r9.next()).intercept();
        goto L12
    L14:
        if (r0 != null) goto L16;
        return;
    L16:
        nativeWrite(this.h, r0.a, r0.b, r0.c);
        return;
    L17:
        nativeWrite(this.h, r6, r7, r8);
        return;
    L22:
        return;
    }

    public final void o(int r13, String r14, String r15, long r16, long r18) {
        if (this.h != 0) goto L5;
        return;
    L5:
        if (r13 < this.a) goto L21;
        if (r14 == null) goto L22;
        if (r15 != null) goto L9;
        return;
    L9:
        if (o == null) goto L17;
        f r1 = new f(r13, r14, r15);
        Iterator r2 = ((CopyOnWriteArrayList) o).iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        r1 = ((d) r2.next()).intercept();
        goto L12
    L14:
        if (r1 != null) goto L16;
        return;
    L16:
        nativeWriteAsyncMsg(this.h, r1.a, r1.b, r1.c, r16, r18);
        return;
    L17:
        nativeWriteAsyncMsg(this.h, r13, r14, r15, r16, r18);
        return;
    L22:
        return;
    }

    public Alog(Context r23, int r24, boolean r25, String r26, String r28, int r29, int r210, int r30, String r31, int r32, int r33, String r34, int r35, int r36, int r37, int r38, int r39, int r40, String r41, boolean r42) {
        this.a = r24;
        this.b = r28;
        this.c = r31;
        this.d = r32;
        this.e = r33 / r32;
        this.f = null;
        this.g = r26;
        this.h = nativeCreate(r24, r25, r26, r28, r29, r210, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, TimeZone.getDefault().getRawOffset() / EventsUtils.FEAT_TYPE_SHUT_DOWN);
    }
}
