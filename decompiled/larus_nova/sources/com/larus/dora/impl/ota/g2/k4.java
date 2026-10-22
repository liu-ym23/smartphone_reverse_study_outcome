package com.larus.dora.impl.ota.g2;

import androidx.collection.SieveCacheKt;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class k4 {
    private static final a Companion = null;
    public static final String LEGACY_LOCAL_PACKAGE_FILE_NAME = "package.bin";
    public static final String TAG = "G2OtaStorage";
    private final Function1<String, Long> availableBytes;
    private final Function0<Long> clock;
    private final File root;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b {
        private final String directory;
        private final long downloadedBytes;
        private final String fileName;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.directory, r101.directory) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L15;
            return false;
        L15:
            if (this.downloadedBytes == r101.downloadedBytes) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.directory.hashCode() * 31) + this.fileName.hashCode()) * 31;
            long r101 = this.downloadedBytes;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "DownloadTarget(directory=" + this.directory + ", fileName=" + this.fileName + ", downloadedBytes=" + this.downloadedBytes + ')';
        }

        public final String a() {
            return this.directory;
        }

        public final long b() {
            return this.downloadedBytes;
        }

        public final String c() {
            return this.fileName;
        }

        public b(String r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "directory");
            Intrinsics.checkNotNullParameter(r101, "fileName");
            this.directory = r100;
            this.fileName = r101;
            this.downloadedBytes = r102;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public interface c {

        public static final class a implements c {
            public static final a INSTANCE = null;

            static {
                INSTANCE = new a();
            }

            public a() {
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                a r101 = (a) r100;
                return true;
            }

            public final int hashCode() {
                return -1618202342;
            }

            public final String toString() {
                return "DirectoryUnavailable";
            }
        }

        public static final class b implements c {
            public static final b INSTANCE = null;

            static {
                INSTANCE = new b();
            }

            public b() {
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                b r101 = (b) r100;
                return true;
            }

            public final int hashCode() {
                return -1926672212;
            }

            public final String toString() {
                return "InsufficientSpace";
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.impl.ota.g2.k4$c$c, reason: collision with other inner class name */
        public static final class C4276c implements c {
            public static final C4276c INSTANCE = null;

            static {
                INSTANCE = new C4276c();
            }

            public C4276c() {
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4276c) == true) goto L9;
                return false;
            L9:
                C4276c r101 = (C4276c) r100;
                return true;
            }

            public final int hashCode() {
                return 400707846;
            }

            public final String toString() {
                return "InvalidPackage";
            }
        }

        public static final class d implements c {
            private final b target;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.target, ((d) r100).target) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.target.hashCode();
            }

            public final String toString() {
                return "Ready(target=" + this.target + ')';
            }

            public final b a() {
                return this.target;
            }

            public d(b r100) {
                Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
                this.target = r100;
            }
        }
    }

    static {
        Companion = new a();
    }

    public k4(File r100) {
        G2OtaStorage$1 r101 = G2OtaStorage$1.INSTANCE;
        G2OtaStorage$2 r102 = G2OtaStorage$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "clock");
        Intrinsics.checkNotNullParameter(r102, "availableBytes");
        this.root = r100;
        this.clock = r101;
        this.availableBytes = r102;
    }

    public static String g(PolarisFileWrapper r110) {
        MessageDigest r100 = MessageDigest.getInstance("MD5");
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r110);
        byte[] r111 = new byte[8192];     // Catch: Throwable -> L10
    L4:
        int r102 = r101.read(r111);     // Catch: Throwable -> L10
        if (r102 < 0) goto L7;
        r100.update(r111, 0, r102);     // Catch: Throwable -> L10
        goto L4
    L7:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r101, null);
        return ArraysKt.joinToString$default(r100.digest(), "", null, null, 0, null, new j4(), 30, null);
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);
        throw th;
    }

    public final PolarisFileWrapper b(e r100) {
        return new PolarisFileWrapper(new PolarisFileWrapper(this.root, Integer.toString(r100.a(), CharsKt.checkRadix(16))), j0.d(r100));
    }

    public final boolean c(PolarisFileWrapper r100) {
        if (f(r100, this.root) == true) goto L6;
        return false;
    L6:
        if (r100.exists() == true) goto L11;
        if (r100.mkdirs() == true) goto L11;
        return false;
    L11:
        if (r100.isDirectory() == true) goto L13;
        return false;
    L13:
        if (r100.canWrite() == false) goto L17;
        return true;
    L17:
        return false;
    }

    public final boolean delete(e5 r100) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        boolean r101 = true;
        if (k(r100, true) == true) goto L5;
        return false;
    L5:
        d5 r102 = r100.h();
        PolarisFileWrapper r103 = h(r102);
        if (f(r103, this.root) == true) goto L8;
        return false;
    L8:
        String r104 = r100.g();
        Iterator r105 = SetsKt.setOf(new String[]{r104, DownloadUtils.getTempFileName(r104), LEGACY_LOCAL_PACKAGE_FILE_NAME, DownloadUtils.getTempFileName(LEGACY_LOCAL_PACKAGE_FILE_NAME)}).iterator();
    L9:
        boolean r106 = true;
    L11:
        if (r105.hasNext() == false) goto L23;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r103, (String) r105.next());
        if (r107.exists() == true) goto L15;
    L18:
        boolean r108 = true;
    L19:
        if (r108 == false) goto L22;
        if (r106 == true) goto L9;
    L22:
        r106 = false;
        goto L11
    L15:
        if (r107.delete() == true) goto L18;
        r108 = false;
        goto L19
    L23:
        File[] r109 = r103.listFiles();
        if (r109 != null) goto L26;
    L31:
        boolean r110 = false;
    L32:
        if (r110 == false) goto L34;
        r103.delete();
    L34:
        PolarisFileWrapper r111 = b(r102.a());
        File[] r112 = r111.listFiles();
        if (r112 != null) goto L37;
    L42:
        r101 = false;
    L43:
        if (r101 == false) goto L45;
        r111.delete();
    L45:
        g49.d.d(TAG, "delete device=" + j0.d(r102.a()) + " package=" + r102.c() + " files=" + r106);
        return r106;
    L37:
        if (r112.length != 0) goto L39;
        boolean r113 = true;
    L40:
        if (r113 != true) goto L42;
    L39:
        r113 = false;
        goto L40
    L26:
        if (r109.length != 0) goto L28;
        boolean r114 = true;
    L29:
        if (r114 != true) goto L31;
        r110 = true;
        goto L32
    L28:
        r114 = false;
        goto L29
    }

    public final PolarisFileWrapper h(d5 r110) {
        String r100 = CollectionsKt.joinToString$default(ArraysKt.take(MessageDigest.getInstance("SHA-256").digest((r110.c() + ':' + r110.f() + ':' + r110.getType() + ':' + r110.e() + ':' + r110.d().toLowerCase(Locale.ROOT) + ':' + r110.b()).getBytes(Charsets.UTF_8)), 8), "", null, null, 0, null, new i4(), 30, null);
        return new PolarisFileWrapper(b(r110.a()), r110.c() + '-' + r100);
    }

    public final c i(e5 r110) {
        Intrinsics.checkNotNullParameter(r110, "spec");
        if (k(r110, false) == false) goto L5;
        PolarisFileWrapper r100 = h(r110.h());
        if (c(r100) == false) goto L9;
        String r101 = r110.g();
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100, r101);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100, DownloadUtils.getTempFileName(r101));
        a(r100, SetsKt.setOf(new String[]{r102.getName(), r103.getName()}));
        Long r104 = null;
        if (r103.isFile() == true) goto L13;
    L22:
        Long r105 = Long.valueOf(r102.length());
        r105.longValue();
        if (r102.isFile() == true) goto L26;
        r105 = null;
    L26:
        if (r105 == null) goto L28;
        long r106 = r105.longValue();
    L29:
        Long r107 = Long.valueOf(r103.length());
        r107.longValue();
        if (r103.isFile() == false) goto L32;
        r104 = r107;
    L32:
        if (r104 == null) goto L34;
        long r111 = r104.longValue();
    L35:
        long r108 = RangesKt.coerceAtMost(Math.max(r106, r111), r110.h().e());
        long r109 = RangesKt.coerceAtLeast(r110.h().e() - r108, 0) + j0.G2_OTA_SPACE_RESERVE_BYTES;
        long r112 = d(r100, "available space failed");
        if (r112 > r109) goto L39;
        g49.d.e(TAG, "prepare insufficient device=" + j0.d(r110.h().a()) + " remaining=" + (r110.h().e() - r108) + " free=" + r112);
        return c.b.INSTANCE;
    L39:
        c.d r113 = new c.d(new b(r100.getAbsolutePath(), r101, r108));
        if (r103.isFile() == false) goto L42;
        r103.setLastModified(this.clock.invoke().longValue());
    L42:
        return r113;
    L34:
        r111 = 0;
        goto L35
    L28:
        r106 = 0;
        goto L29
    L13:
        if (r103.lastModified() <= 0) goto L22;
        if ((this.clock.invoke().longValue() - r103.lastModified()) <= 604800000) goto L22;
        StringBuilder r114 = new StringBuilder("cleanup expired partial deviceDir=");
        File r115 = r103.getParentFile();
        if (r115 == null) goto L20;
        String r116 = r115.getName();
    L21:
        r114.append(r116);
        r114.append(" deleted=");
        r114.append(r103.delete());
        g49.d.d(TAG, r114.toString());
        goto L22
    L20:
        r116 = null;
        goto L21
    L9:
        return c.a.INSTANCE;
    L5:
        return c.C4276c.INSTANCE;
    }

    public final b j(e5 r110) {
        Intrinsics.checkNotNullParameter(r110, "spec");
        Long r100 = null;
        if (k(r110, false) == true) goto L5;
        return null;
    L5:
        PolarisFileWrapper r101 = h(r110.h());
        if (f(r101, this.root) == true) goto L8;
        return null;
    L8:
        String r102 = r110.g();
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101, r102);
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101, DownloadUtils.getTempFileName(r102));
        String r105 = r101.getAbsolutePath();
        Long r106 = Long.valueOf(r103.length());
        r106.longValue();
        if (r103.isFile() == true) goto L12;
        r106 = null;
    L12:
        long r107 = 0;
        if (r106 == null) goto L15;
        long r108 = r106.longValue();
    L16:
        Long r109 = Long.valueOf(r104.length());
        r109.longValue();
        if (r104.isFile() == false) goto L19;
        r100 = r109;
    L19:
        if (r100 == null) goto L22;
        r107 = r100.longValue();
    L22:
        return new b(r105, r102, RangesKt.coerceAtMost(Math.max(r108, r107), r110.h().e()));
    L15:
        r108 = 0;
        goto L16
    }

    public final boolean l(e5 r100) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        b r101 = j(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101.a(), r101.c());
        if (r102.isFile() == true) goto L8;
    L22:
        return false;
    L8:
        if (r102.length() != r100.h().e()) goto L22;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(StringsKt.equals(g(r102), r100.h().d(), true)));     // Catch: Throwable -> L12
    L14:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L17;
        g49.d.b(TAG, "validate failed device=" + j0.d(r100.h().a()) + " error=" + r105.getClass().getSimpleName());
    L17:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r104) == false) goto L21;
        r104 = r106;
    L21:
        return ((Boolean) r104).booleanValue();
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static void a(PolarisFileWrapper r100, Set r101) {
        File[] r102 = r100.listFiles();
        if (r102 == null) goto L12;
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L17;
        File r105 = r102[r104];
        if (r105.isFile() == false) goto L11;
        if (r101.contains(r105.getName()) == true) goto L11;
        g49.d.d(TAG, "cleanup deviceDir=" + r100.getName() + " deleted=" + r105.delete());
    L11:
        r104 = r104 + 1;
        goto L5
    L17:
        return;
    }

    public static boolean f(PolarisFileWrapper r100, File r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        String r103 = r101.getCanonicalPath();     // Catch: Throwable -> L9
        String r104 = r100.getCanonicalPath();     // Catch: Throwable -> L9
        if (Intrinsics.areEqual(r104, r103) == true) goto L6;
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L9
        boolean r105 = false;
        if (StringsKt.startsWith$default(r104, r103 + File.separator, false, 2, null) == true) goto L6;
    L7:
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r105));     // Catch: Throwable -> L9
    L11:
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r106) == false) goto L15;
        r106 = r107;
    L15:
        return ((Boolean) r106).booleanValue();
    L6:
        r105 = true;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static boolean k(e5 r100, boolean r101) {
        if (r100.h().c() > 0) goto L5;
        return false;
    L5:
        if (r100.h().c() <= SieveCacheKt.NodeLinkMask) goto L7;
        return false;
    L7:
        if (r100.h().e() > 0) goto L9;
        return false;
    L9:
        if (r100.h().e() > SieveCacheKt.NodeLinkMask) goto L41;
        int r102 = r100.h().getType();
        if (1 <= r102) goto L13;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == true) goto L18;
        return false;
    L18:
        if ((!StringsKt.isBlank(r100.h().f())) == true) goto L20;
        return false;
    L20:
        if (r100.h().d().length() == 32) goto L22;
        return false;
    L22:
        if ((!StringsKt.isBlank(r100.g())) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(r100.h().b(), r100.g()) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(new PolarisFileWrapper(r100.g()).getName(), r100.g()) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(r100.g(), ".") == false) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(r100.g(), DownloadConstants.VULNERABILITY_PATH) == true) goto L49;
        if (r101 == true) goto L35;
        if (StringsKt.contains(r100.g(), r100.h().a().b(), true) == false) goto L35;
        return false;
    L35:
        if ((!StringsKt.isBlank(r100.i())) == false) goto L51;
        return true;
    L51:
        return false;
    L49:
        return false;
    L13:
        if (r102 >= 3) goto L15;
        r103 = true;
        goto L16
    L41:
        return false;
    }

    public final long d(PolarisFileWrapper r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(Long.valueOf(this.availableBytes.invoke(r100.getAbsolutePath()).longValue()));     // Catch: Throwable -> L4
    L6:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L10;
        g49.d.b(TAG, r101 + " error=" + r104.getClass().getSimpleName());
    L10:
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        r103 = 0L;
    L13:
        return ((Number) r103).longValue();
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final boolean e(e5 r110, long r111) {
        Intrinsics.checkNotNullParameter(r110, "spec");
        boolean r100 = false;
        if (k(r110, false) == true) goto L5;
        return false;
    L5:
        PolarisFileWrapper r101 = h(r110.h());
        if (c(r101) == true) goto L8;
        return false;
    L8:
        a(r101, SetsKt.setOf(new String[]{r110.g(), DownloadUtils.getTempFileName(r110.g())}));
        long r102 = RangesKt.coerceAtLeast(r110.h().e() - r111, 0);
        long r103 = j0.G2_OTA_SPACE_RESERVE_BYTES + r102;
        long r104 = d(r101, "dynamic space check failed");
        if (r104 <= r103) goto L11;
        r100 = true;
    L11:
        g49.d.d(TAG, "space_check device=" + j0.d(r110.h().a()) + " downloaded=" + r111 + " remaining=" + r102 + " free=" + r104 + " sufficient=" + r100);
        return r100;
    }
}
