package com.larus.avlink.gallery.processor;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.larus.dora.api.model.MediaInfo;
import com.larus.utils.logger.FLogger;
import com.ss.android.ttvecamera.TECameraUtils;
import com.tencent.qqmusic.third.api.contract.Keys;
import defpackage.j0;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f292674a = 0;

    public static final class a {
        public static boolean a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "fileName");
            if (StringsKt.endsWith(r100, ".pack", true) == false) goto L5;
            return true;
        L5:
            if (StringsKt.endsWith(r100, ".zip", true) == true) goto L10;
            return false;
        L10:
            return true;
        }

        public static File b(PolarisFileWrapper r110) {
            Intrinsics.checkNotNullParameter(r110, MapBundleKey.MapObjKey.OBJ_DIR);
            List r111 = SequencesKt.toList(SequencesKt.filter(FilesKt.walkTopDown(r110), new d()));
            ArrayList r100 = new ArrayList();
            Iterator r101 = r111.iterator();
        L3:
            boolean r102 = false;
            if (r101.hasNext() == false) goto L10;
            Object r103 = r101.next();
            if (((File) r103).length() > 0) goto L8;
            r102 = true;
        L8:
            if (r102 == false) goto L3;
            r100.add(r103);
            goto L3
        L10:
            Iterator r104 = r100.iterator();
        L12:
            if (r104.hasNext() == false) goto L14;
            File r105 = (File) r104.next();
            FLogger.f375446a.w("DownloadArchiveProcessor", "Skip empty image pack file: " + r105.getAbsolutePath());
            goto L12
        L14:
            Iterator r112 = r111.iterator();
        L16:
            if (r112.hasNext() == false) goto L23;
            Object r106 = r112.next();
            if (((File) r106).length() <= 0) goto L20;
            boolean r107 = true;
        L21:
            if (r107 == false) goto L16;
        L25:
            return (File) r106;
        L20:
            r107 = false;
            goto L21
        L23:
            r106 = null;
            goto L25
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final File f292675a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f292675a, ((a) r100).f292675a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f292675a.hashCode();
            }

            public final String toString() {
                return "Incomplete(file=" + this.f292675a + ')';
            }

            public a(File r100) {
                Intrinsics.checkNotNullParameter(r100, "file");
                this.f292675a = r100;
            }
        }

        /* JADX INFO: renamed from: com.larus.avlink.gallery.processor.e$b$b, reason: collision with other inner class name */
        public static final class C3993b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C3993b f292676a = null;

            static {
                f292676a = new C3993b();
            }

            public C3993b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final File f292677a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f292677a, ((c) r100).f292677a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f292677a.hashCode();
            }

            public final String toString() {
                return "Ready(file=" + this.f292677a + ')';
            }

            public c(File r100) {
                Intrinsics.checkNotNullParameter(r100, "file");
                this.f292677a = r100;
            }
        }

        public b() {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f292678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f292679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f292680c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f292681d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f292678a, r101.f292678a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f292679b, r101.f292679b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f292680c, r101.f292680c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f292681d, r101.f292681d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f292678a.hashCode() * 31) + this.f292679b.hashCode()) * 31) + this.f292680c.hashCode()) * 31) + this.f292681d.hashCode();
        }

        public final String toString() {
            return "Result(displayableFilePath=" + this.f292678a + ", downloadFilePath=" + this.f292679b + ", processingInputFilePath=" + this.f292680c + ", processingDirPath=" + this.f292681d + ')';
        }

        public c(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "displayableFilePath");
            Intrinsics.checkNotNullParameter(r101, "downloadFilePath");
            Intrinsics.checkNotNullParameter(r102, "processingInputFilePath");
            Intrinsics.checkNotNullParameter(r103, "processingDirPath");
            this.f292678a = r100;
            this.f292679b = r101;
            this.f292680c = r102;
            this.f292681d = r103;
        }
    }

    static {
    }

    public e() {
    }

    public static File b(PolarisFileWrapper r100) {
        Iterator<File> r101 = FilesKt.walkTopDown(r100).iterator();
    L3:
        File r102 = null;
        if (r101.hasNext() == false) goto L15;
        File r103 = r101.next();
        File r104 = r103;
        boolean r105 = false;
        if (r104.isFile() == false) goto L12;
        String r106 = r104.getName();
        Locale r107 = Locale.ROOT;
        if (StringsKt.endsWith$default(r106.toLowerCase(r107), ".jpeg", false, 2, null) == false) goto L10;
    L11:
        r105 = true;
        goto L12
    L10:
        if (StringsKt.endsWith$default(r104.getName().toLowerCase(r107), ".jpg", false, 2, null) == true) goto L11;
    L12:
        if (r105 == false) goto L3;
        r102 = r103;
    L15:
        return r102;
    }

    public static Pair a(String r100, MediaInfo r101) {
        int r102 = 1080;
        int r103 = TECameraUtils.CAPTURE_NORMAL;
        MatchResult r104 = Regex.find$default(new Regex("(\\d+)x(\\d+)"), r100, 0, 2, null);     // Catch: Exception -> L21
        if (r104 != null) goto L6;
        MatchResult r105 = Regex.find$default(new Regex("_(\\d{3,4})_(\\d{3,4})(?:\\.|$)"), r100, 0, 2, null);     // Catch: Exception -> L21
        if (r105 != null) goto L10;
        Integer r106 = r101.getWidth();     // Catch: Exception -> L21
        if (r106 == null) goto L14;
        int r107 = r106.intValue();     // Catch: Exception -> L21
    L15:
        Integer r108 = r101.getHeight();     // Catch: Exception -> L21
        if (r108 == null) goto L18;
        int r109 = r108.intValue();     // Catch: Exception -> L21
    L31:
        return new Pair(Integer.valueOf(r107), Integer.valueOf(r109));
    L18:
        r109 = 1080;
        goto L31
    L14:
        r107 = TECameraUtils.CAPTURE_NORMAL;
        goto L15
    L10:
        return new Pair(Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r105.getGroupValues(), 2))), Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r105.getGroupValues(), 1))));
    L6:
        return new Pair(Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r104.getGroupValues(), 2))), Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r104.getGroupValues(), 1))));
    L21:
        e = move-exception;
        FLogger.f375446a.e("DownloadArchiveProcessor", "Error extracting dimensions: " + e.getMessage(), e);
        Integer r110 = r101.getWidth();
        if (r110 == null) goto L25;
        r103 = r110.intValue();
    L25:
        Integer r111 = r101.getHeight();
        if (r111 == null) goto L29;
        r102 = r111.intValue();
    L29:
        return new Pair(Integer.valueOf(r103), Integer.valueOf(r102));
    }

    public static File d(PolarisFileWrapper r100, String r101) {
        File r102 = r100.getCanonicalFile();
        File r103 = new PolarisFileWrapper(r102, r101).getCanonicalFile();
        if (StringsKt.startsWith$default(r103.getPath(), r102.getPath() + File.separator, false, 2, null) == false) goto L7;
        Intrinsics.checkNotNull(r103);
        return r103;
    L7:
        throw new IOException("Unsafe zip entry path: " + r101);
    }

    public static boolean e(File r100, String r101) {
        if (r100.length() > 0) goto L6;
        return false;
    L6:
        if (StringsKt.endsWith(r101, ".zip", true) == true) goto L20;
        return true;
    L20:
        PolarisZipFileWrapper r102 = new PolarisZipFileWrapper(r100);     // Catch: Exception -> L19
        boolean r103 = r102.entries().hasMoreElements();     // Catch: Throwable -> L13
        goto L25
    L11:
        CloseableKt.closeFinally(r102, null);     // Catch: Exception -> L19
        return r103;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);     // Catch: Exception -> L19
        throw th;     // Catch: Exception -> L19
    L25:
        return false;
    }

    public static String c(String r100, int r101, int r102, boolean r110, MediaInfo r111) {
        long r103 = 0;
        if (r110 == false) goto L8;
        Number r104 = r111.getDuration();
        if (r104 != null) goto L7;
        r104 = Double.valueOf(5000.0d);
    L7:
        long r105 = r104.longValue();
    L9:
        Long r106 = r111.getCreateTime();
        if (r106 == null) goto L13;
        r103 = r106.longValue();
    L13:
        if (r103 >= 1735660800000L) goto L15;
        Long r112 = Long.valueOf(System.currentTimeMillis());
    L16:
        if (r110 == false) goto L18;
        String r113 = ".mp4";
    L20:
        return "media_" + r100 + "_0_" + r105 + '_' + r102 + '_' + r101 + '_' + r112 + r113;
    L18:
        r113 = ".jpeg";
        goto L20
    L15:
        r112 = r111.getCreateTime();
        goto L16
    L8:
        r105 = 0;
        goto L9
    }

    public static c f(String r210, String r211, String r212, MediaInfo r213, boolean r214) {
        Intrinsics.checkNotNullParameter(r211, "sourceFileName");
        Intrinsics.checkNotNullParameter(r212, "mediaId");
        Intrinsics.checkNotNullParameter(r213, Keys.API_PARAM_KEY_MEDIA_INFO);
        if (r210 == null) goto L162;
        PolarisFileWrapper r100 = new PolarisFileWrapper(r210);
        if (r100.exists() == true) goto L8;
        FLogger.f375446a.w("DownloadArchiveProcessor", "Archive source file not found: ".concat(r210));
        return null;
    L8:
        int r101 = j0.f496744a;
        j0.a.d(r100.getAbsolutePath(), r211, r212);
        com.larus.avlink.gallery.e.f292493a.getClass();
        Intrinsics.checkNotNullParameter(r212, "mediaId");
        PolarisFileWrapper r102 = new PolarisFileWrapper(com.larus.avlink.gallery.e.f(), r212);
        r102.mkdirs();
        final PolarisFileWrapper r103 = new PolarisFileWrapper(r102, "unpacked");
        if (r103.exists() == false) goto L11;
        FilesKt.deleteRecursively(r103);
    L11:
        r103.mkdirs();
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("Archive source file: ");
        r105.append(r100.getAbsolutePath());
        String r110 = ", size=";
        r105.append(", size=");
        r105.append(r100.length());
        char r111 = 'B';
        r105.append('B');
        r104.i("DownloadArchiveProcessor", r105.toString());
        if (StringsKt.endsWith(r211, ".zip", true) == false) goto L95;
        PolarisZipFileWrapper r112 = new PolarisZipFileWrapper(r100);
        Enumeration<? extends ZipEntry> r106 = r112.entries();     // Catch: Throwable -> L88
    L15:
        if (r106.hasMoreElements() == false) goto L83;
        ZipEntry r113 = r106.nextElement();     // Catch: Throwable -> L81
        FLogger r114 = FLogger.f375446a;     // Catch: Throwable -> L81
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L81
        r107.append("Zip entry: ");     // Catch: Throwable -> L81
        r107.append(r113.getName());     // Catch: Throwable -> L81
        r107.append(", isDirectory=");     // Catch: Throwable -> L81
        r107.append(r113.isDirectory());     // Catch: Throwable -> L81
        r107.append(r110);     // Catch: Throwable -> L81
        PolarisZipFileWrapper r115 = r112;
        r107.append(r113.getSize());     // Catch: Throwable -> L79
        r107.append(", compressedSize=");     // Catch: Throwable -> L79
        r107.append(r113.getCompressedSize());     // Catch: Throwable -> L79
        r107.append(", method=");     // Catch: Throwable -> L79
        r107.append(r113.getMethod());     // Catch: Throwable -> L79
        r114.i("DownloadArchiveProcessor", r107.toString());     // Catch: Throwable -> L79
        File r108 = d(r103, r113.getName());     // Catch: Throwable -> L76
        if (r113.isDirectory() == false) goto L26;
        r108.mkdirs();     // Catch: Throwable -> L79
    L24:
        PolarisFileWrapper r116 = r102;
        String r117 = r110;
        PolarisZipFileWrapper r118 = r115;
    L51:
        r112 = r118;
        r110 = r117;
        r102 = r116;
        r111 = 'B';
        goto L15
    L26:
        if (r108.exists() == true) goto L28;
    L32:
        boolean r119 = false;
    L33:
        if (r119 == false) goto L35;
        r114.w("DownloadArchiveProcessor", "Skip zero-byte duplicate zip entry: " + r113.getName() + ", existingSize=" + r108.length() + r111);     // Catch: Throwable -> L79
        goto L24
    L35:
        File r120 = r108.getParentFile();     // Catch: Throwable -> L79
        if (r120 == null) goto L166;
        r120.mkdirs();     // Catch: Throwable -> L79
    L166:
        InputStream r121 = r115.getInputStream(r113);     // Catch: Throwable -> L74
        PolarisFileOutputStreamWrapper r122 = new PolarisFileOutputStreamWrapper(r108);     // Catch: Throwable -> L64
        byte[] r109 = new byte[262144];     // Catch: Throwable -> L54
        int r123 = r121.read(r109);     // Catch: Throwable -> L54
        r118 = r115;
        long r124 = 0;
    L44:
        if (r123 < 0) goto L47;
        String r125 = r110;
        r122.write(r109, 0, r123);     // Catch: Throwable -> L52
        r124 = r124 + ((long) r123);     // Catch: Throwable -> L52
        r123 = r121.read(r109);     // Catch: Throwable -> L52
        r110 = r125;
        r102 = r102;
    L52:
        th = th;
    L56:
        Throwable r126 = th;
        throw r126;     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        CloseableKt.closeFinally(r122, r126);     // Catch: Throwable -> L62
        throw th;     // Catch: Throwable -> L62
    L62:
        th = th;
    L66:
        Throwable r127 = th;
        throw r127;     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        CloseableKt.closeFinally(r121, r127);     // Catch: Throwable -> L72
        throw th;     // Catch: Throwable -> L72
    L72:
        th = th;
    L78:
        Throwable r128 = th;
        PolarisZipFileWrapper r129 = r118;
    L182:
        throw r128;     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        CloseableKt.closeFinally(r129, r128);
        throw th;
    L47:
        r116 = r102;
        r117 = r110;
        Unit r130 = Unit.INSTANCE;     // Catch: Throwable -> L52
        CloseableKt.closeFinally(r122, null);     // Catch: Throwable -> L62
        CloseableKt.closeFinally(r121, null);     // Catch: Throwable -> L72
        FLogger.f375446a.i("DownloadArchiveProcessor", "Extracted zip entry: " + r113.getName() + ", writtenBytes=" + r124);     // Catch: Throwable -> L72
    L54:
        th = th;
        r118 = r115;
    L64:
        th = th;
        r118 = r115;
    L74:
        th = move-exception;
        r128 = th;
        r129 = r115;
        goto L182
    L28:
        if (r108.length() <= 0) goto L32;
        if (r113.getSize() != 0) goto L32;
        r119 = true;
    L76:
        th = th;
        r118 = r115;
    L79:
        th = move-exception;
        r128 = th;
        r129 = r115;
    L81:
        th = move-exception;
        r128 = th;
        r129 = r112;
        goto L182
    L83:
        PolarisFileWrapper r131 = r102;
        PolarisZipFileWrapper r132 = r112;
        Unit r133 = Unit.INSTANCE;     // Catch: Throwable -> L86
        CloseableKt.closeFinally(r132, null);
    L98:
        FLogger r134 = FLogger.f375446a;
        r134.i("DownloadArchiveProcessor", "Successfully extracted archive: " + r211 + " to " + r103.getAbsolutePath());
        List r135 = SequencesKt.toList(SequencesKt.map(SequencesKt.take(SequencesKt.filter(FilesKt.walkTopDown(r103), new com.larus.avlink.gallery.processor.b()), 20), new com.larus.avlink.gallery.processor.c(r103)));
        StringBuilder r136 = new StringBuilder("Archive extracted files: ");
        r136.append(r135);
        r134.i("DownloadArchiveProcessor", r136.toString());
        if (r214 == false) goto L104;
        File r137 = a.b(r103);
        if (r137 != null) goto L105;
        r134.w("DownloadArchiveProcessor", "No non-empty inner image pack found in live photo archive: ".concat(r211));
        return null;
    L105:
        File r138 = b(r103);
        if (r138 == null) goto L108;
    L107:
        File r139 = r138;
        if (r139 != null) goto L163;
        return null;
    L163:
        int r140 = j0.f496744a;     // Catch: Exception -> L144
        j0.a.d(r139.getAbsolutePath(), r139.getName(), r212);     // Catch: Exception -> L144
        boolean r141 = StringsKt.endsWith$default(r139.getName().toLowerCase(Locale.ROOT), ".mp4", false, 2, null);     // Catch: Exception -> L144
        Pair r142 = a(r139.getName(), r213);     // Catch: Exception -> L144
        String r143 = c(r212, ((Number) r142.getFirst()).intValue(), ((Number) r142.getSecond()).intValue(), r141, r213);     // Catch: Exception -> L144
        com.larus.avlink.gallery.e.f292493a.getClass();     // Catch: Exception -> L144
        PolarisFileWrapper r144 = com.larus.avlink.gallery.e.g();     // Catch: Exception -> L144
        r144.mkdirs();     // Catch: Exception -> L144
        PolarisFileWrapper r145 = new PolarisFileWrapper(r144, r143);     // Catch: Exception -> L144
        FilesKt.copyTo$default(r139, r145, true, 0, 4, null);     // Catch: Exception -> L144
        FLogger.f375446a.i("DownloadArchiveProcessor", "Prepared displayable file: " + r145.getAbsolutePath());     // Catch: Exception -> L144
        String r146 = r145.getAbsolutePath();     // Catch: Exception -> L144
    L146:
        if (r146 != null) goto L150;
        return null;
    L150:
        if (r214 == false) goto L152;
        String r147 = r100.getAbsolutePath();
    L153:
        Intrinsics.checkNotNull(r147);
        return new c(r146, r147, r137.getAbsolutePath(), r131.getAbsolutePath());
    L152:
        r147 = r137.getAbsolutePath();
    L144:
        e = move-exception;
        FLogger.f375446a.e("DownloadArchiveProcessor", "Error preparing displayable file: " + e.getMessage(), e);
        r146 = null;
        goto L146
    L108:
        if (r214 == true) goto L196;
    L125:
        Iterator<File> r148 = FilesKt.walkTopDown(r103).iterator();
    L127:
        if (r148.hasNext() == false) goto L136;
        File r149 = r148.next();
        File r150 = r149;
        if (r150.isFile() == true) goto L131;
    L133:
        boolean r151 = false;
    L134:
        if (r151 == false) goto L127;
    L137:
        r138 = r149;
        goto L107
    L131:
        if (StringsKt.endsWith$default(r150.getName().toLowerCase(Locale.ROOT), ".mp4", false, 2, null) == false) goto L133;
        r151 = true;
        goto L134
    L136:
        r149 = null;
        goto L137
    L196:
        PolarisFileWrapper r152 = new PolarisFileWrapper(r103, "live_photo_image_pack_unpacked");     // Catch: Exception -> L121
        r152.mkdirs();     // Catch: Exception -> L121
        PolarisFileInputStreamWrapper r153 = new PolarisFileInputStreamWrapper(r137);     // Catch: Exception -> L121
        ja8.f.a(r153, r152.getAbsolutePath());     // Catch: Throwable -> L114
    L112:
        CloseableKt.closeFinally(r153, null);     // Catch: Exception -> L121
        r138 = b(r152);     // Catch: Exception -> L121
    L123:
        if (r138 == null) goto L125;
    L114:
        th = move-exception;
        throw th;     // Catch: Throwable -> L117
    L117:
        th = move-exception;
        CloseableKt.closeFinally(r153, th);     // Catch: Exception -> L121
        throw th;     // Catch: Exception -> L121
    L121:
        e = move-exception;
        FLogger.f375446a.e("DownloadArchiveProcessor", "Error unpacking live photo image pack: " + e.getMessage(), e);
        r138 = null;
        goto L123
    L104:
        r137 = r100;
    L86:
        th = th;
        r129 = r132;
    L90:
        r128 = th;
    L88:
        th = th;
        r129 = r112;
        goto L90
    L95:
        r131 = r102;
        PolarisFileInputStreamWrapper r154 = new PolarisFileInputStreamWrapper(r100);
        ja8.f.a(r154, r103.getAbsolutePath());     // Catch: Throwable -> L155
        Unit r155 = Unit.INSTANCE;     // Catch: Throwable -> L155
        CloseableKt.closeFinally(r154, null);
    L155:
        th = move-exception;
        throw th;     // Catch: Throwable -> L158
    L158:
        th = move-exception;
        CloseableKt.closeFinally(r154, th);
        throw th;
    L162:
        return null;
    }
}
