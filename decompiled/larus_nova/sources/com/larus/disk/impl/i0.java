package com.larus.disk.impl;

import android.content.Context;
import android.os.Build;
import android.system.Os;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f330730a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f330731b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f330732c;

    /* JADX INFO: loaded from: classes27.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f330733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f330734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f330735c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f330736d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f330733a == r101.f330733a) goto L12;
            return false;
        L12:
            if (Float.compare(this.f330734b, r101.f330734b) == 0) goto L15;
            return false;
        L15:
            if (this.f330735c == r101.f330735c) goto L18;
            return false;
        L18:
            if (this.f330736d == r101.f330736d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f330733a;
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + Float.floatToIntBits(this.f330734b)) * 31;
            if (this.f330735c == false) goto L5;
            int r102 = 1231;
        L7:
            return ((r101 + r102) * 31) + this.f330736d;
        L5:
            r102 = 1237;
            goto L7
        }

        public final String toString() {
            return "MonitorState(observationStartMs=" + this.f330733a + ", reportSampleRate=" + this.f330734b + ", reportSampled=" + this.f330735c + ", version=" + this.f330736d + ')';
        }

        public a(long r100, float r101, boolean r102, int r103) {
            this.f330733a = r100;
            this.f330734b = r101;
            this.f330735c = r102;
            this.f330736d = r103;
        }
    }

    public i0() {
    }

    static {
        f330730a = new i0();
        f330731b = new Object();
    }

    public static String[] b(Context r100) {
        LinkedHashSet r101 = new LinkedHashSet();
        a(r101, r100.getApplicationInfo().dataDir);
        File r102 = r100.getFilesDir().getParentFile();
        if (r102 == null) goto L5;
        String r103 = r102.getAbsolutePath();
    L6:
        a(r101, r103);
        if (Build.VERSION.SDK_INT < 24) goto L9;
        a(r101, r100.getApplicationInfo().deviceProtectedDataDir);
    L9:
        File[] r104 = r100.getExternalCacheDirs();
        int r105 = r104.length;
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L18;
        File r107 = r104[r106];
        i0 r108 = f330730a;
        if (r107 == null) goto L16;
        File r109 = r107.getParentFile();
        if (r109 == null) goto L16;
        String r110 = r109.getAbsolutePath();
    L17:
        r108.getClass();
        a(r101, r110);
        r106 = r106 + 1;
    L16:
        r110 = null;
        goto L17
    L18:
        File[] r111 = r100.getExternalFilesDirs(null);
        int r112 = r111.length;
        int r113 = 0;
    L19:
        if (r113 >= r112) goto L27;
        File r114 = r111[r113];
        i0 r115 = f330730a;
        if (r114 == null) goto L25;
        File r116 = r114.getParentFile();
        if (r116 == null) goto L25;
        String r117 = r116.getAbsolutePath();
    L26:
        r115.getClass();
        a(r101, r117);
        r113 = r113 + 1;
    L25:
        r117 = null;
        goto L26
    L27:
        a(r101, "/data/data/" + r100.getPackageName());
        return (String[]) CollectionsKt.take(r101, 12).toArray(new String[0]);
    L5:
        r103 = null;
        goto L6
    }

    public static Long c(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        a r101 = f330732c;
        if (r101 == null) goto L19;
        long r102 = r101.f330733a;
        long r103 = Os.stat(r100.getAbsolutePath()).st_atime;     // Catch: Throwable -> L21
        int r104 = l0.f330755d;     // Catch: Throwable -> L21
        long r105 = 0;
        if (r103 > 0) goto L9;
    L12:
        Long r106 = Long.valueOf(r105);     // Catch: Throwable -> L21
        if (r106.longValue() < r102) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L19;
        return r106;
    L16:
        r107 = false;
        goto L17
    L9:
        if (r103 <= 9223372036854775L) goto L11;
        r105 = Long.MAX_VALUE;
        goto L12
    L11:
        r105 = 1000 * r103;     // Catch: Throwable -> L21
    L19:
        return null;
    }

    public static void e(Context r110) {
        if (f330732c == null) goto L5;
        return;
    L5:
        Lazy r100 = d.f330625a;
        lu9.a r101 = d.a();
        if (r101.l() == true) goto L8;
        return;
    L8:
        Object r102 = f330731b;
        monitor-enter(r102);
    L63:
        th = move-exception;
        throw th;
    L11:
        if (f330732c == null) goto L14;
        monitor-exit(r102);
        return;
    L14:
        Context r103 = r110.getApplicationContext();     // Catch: Throwable -> L63
        if (r103 == null) goto L18;
        r110 = r103;
    L18:
        f330730a.getClass();     // Catch: Throwable -> L63
        String[] r104 = b(r110);     // Catch: Throwable -> L63
        boolean r105 = true;
        if (r104.length != 0) goto L21;
        boolean r106 = true;
    L22:
        if (r106 == false) goto L26;
        FLogger.f375446a.e("FileAccessMonitor", "native file usage monitor has no app storage root");     // Catch: Throwable -> L63
        monitor-exit(r102);
        return;
    L26:
        Float r107 = Float.valueOf(r101.s());     // Catch: Throwable -> L63
        float r108 = r107.floatValue();     // Catch: Throwable -> L63
        if (Float.isInfinite(r108) == false) goto L29;
    L31:
        boolean r109 = false;
    L32:
        Long r111 = null;
        if (r109 == true) goto L36;
        r107 = null;
    L36:
        float r112 = 0.0f;
        if (r107 == null) goto L67;
        r112 = RangesKt.coerceIn(r107.floatValue(), 0.0f, 1.0f);     // Catch: Throwable -> L63
    L67:
        boolean r113 = d.g(r112);     // Catch: Exception -> L41 Throwable -> L63
    L43:
        i0 r114 = f330730a;     // Catch: Throwable -> L63
        int r115 = RangesKt.coerceAtLeast(r101.t(), 0);     // Catch: Throwable -> L63
        r114.getClass();     // Catch: Throwable -> L63
        PolarisFileWrapper r116 = d(r110, r115);     // Catch: Throwable -> L63
        if (r116 == null) goto L54;
        Long r117 = Long.valueOf(r116.lastModified());     // Catch: Throwable -> L63
        if (r117.longValue() > 0) goto L50;
        r105 = false;
    L50:
        if (Boolean.valueOf(r105).booleanValue() == false) goto L52;
        r111 = r117;
    L52:
        if (r111 == null) goto L54;
        long r118 = r111.longValue();     // Catch: Throwable -> L63
    L55:
        long r119 = (RangesKt.coerceAtLeast(r118, 0) / 1000) * 1000;     // Catch: Throwable -> L63
        int r120 = NativeFileAccessMonitor.f330600a.d(r104, r119);     // Catch: Throwable -> L63
        if (r120 == 0) goto L60;
        FLogger.f375446a.e("FileAccessMonitor", "native file usage monitor start failed status=" + r120);     // Catch: Throwable -> L63
        monitor-exit(r102);
        return;
    L60:
        f330732c = new a(r119, r112, r113, RangesKt.coerceAtLeast(r101.t(), 0));     // Catch: Throwable -> L63
        FLogger.f375446a.i("FileAccessMonitor", "native open file usage monitor enabled");     // Catch: Throwable -> L63
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L63
        monitor-exit(r102);
        return;
    L54:
        r118 = System.currentTimeMillis();     // Catch: Throwable -> L63
        goto L55
    L41:
        e = move-exception;
        FLogger.f375446a.e("FileAccessMonitor", "resolve file usage report sampling failed", e);     // Catch: Throwable -> L63
        r113 = false;
        goto L43
    L29:
        if (Float.isNaN(r108) == true) goto L31;
        r109 = true;
        goto L32
    L21:
        r106 = false;
        goto L22
    }

    public static void a(Set r100, String r101) {
        if (r101 == null) goto L26;
        String r102 = null;
        if (StringsKt.startsWith$default(r101, File.separator, false, 2, null) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L27;
        String r103 = StringsKt.trimEnd(r101, new char[]{File.separatorChar});
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.length() <= 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L17;
        r102 = r103;
    L17:
        if (r102 == null) goto L29;
        r100.add(r102);
        r100.add(StringsKt.trimEnd(new PolarisFileWrapper(r102).getCanonicalPath(), new char[]{File.separatorChar}));     // Catch: SecurityException -> L21 IOException -> L22
    L31:
        return;
    L22:
        FLogger.f375446a.w("FileAccessMonitor", "resolve app storage root failed type=io");
        return;
    L21:
        FLogger.f375446a.w("FileAccessMonitor", "resolve app storage root failed type=permission");
        return;
    L29:
        return;
    L14:
        r104 = false;
        goto L15
    L27:
        return;
    }

    public static PolarisFileWrapper d(Context r100, int r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getNoBackupFilesDir(), "app_disk_access");
        if (r102.exists() == false) goto L5;
    L8:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102, "native_atime_start_v" + r101 + ".marker");
    L20:
        e = move-exception;
        FLogger.f375446a.e("FileAccessMonitor", "create file usage observation marker failed", e);
        return null;
    L18:
        e = move-exception;
        FLogger.f375446a.e("FileAccessMonitor", "create file usage observation marker denied", e);
        return null;
    L10:
        if (r103.exists() == true) goto L25;
        if (r103.createNewFile() == true) goto L25;
        if (r103.exists() == true) goto L25;
        FLogger.f375446a.e("FileAccessMonitor", "create file usage observation marker failed");     // Catch: SecurityException -> L18 IOException -> L20
    L27:
        return null;
    L25:
        return r103;
    L5:
        if (r102.mkdirs() == true) goto L8;
        FLogger.f375446a.e("FileAccessMonitor", "create file usage monitor directory failed");
        return null;
    }
}
