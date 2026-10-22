package com.larus.business.debug.base.audio.module;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.media.MediaScene;
import com.larus.platform.model.NotificationBusiness;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Regex f320011d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<String> f320012e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<String> f320013f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<String> f320014g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set<String> f320015h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f320016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f320017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f320018c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f320019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f320020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f320021c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f320019a == r101.f320019a) goto L12;
            return false;
        L12:
            if (this.f320020b == r101.f320020b) goto L15;
            return false;
        L15:
            if (this.f320021c == r101.f320021c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f320019a;
            return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f320020b) * 31) + this.f320021c;
        }

        public final String toString() {
            return "CleanupResult(deletedBytes=" + this.f320019a + ", deletedFiles=" + this.f320020b + ", failedDeletions=" + this.f320021c + ')';
        }

        public a(long r100, int r101, int r102) {
            this.f320019a = r100;
            this.f320020b = r101;
            this.f320021c = r102;
        }
    }

    public static final class b {
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f320022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f320023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f320024c;

        public c() {
            this.f320022a = 0;
            this.f320023b = 0;
            this.f320024c = 0;
        }
    }

    static {
        f320011d = new Regex("\\d{4}_\\d{4}_\\d{2}_\\d{2}_\\d{2}");
        f320012e = SetsKt.setOf(new String[]{"av-dump", "speech-dump", "rtc-dump", "quic-dump", "mmt-dump"});
        f320013f = SetsKt.setOf(new String[]{"av-dump", NotificationBusiness.REALTIME_CALL});
        f320014g = SetsKt.setOf(new String[]{"tts", "asr", "aec", "loudness", MediaScene.STREAM_PLAYER, MediaScene.DORA, "dorasi", "rtc-dump", "quic-dump", "speech-dump", "speech_aec", "mmt-dump"});
        f320015h = SetsKt.setOf(new String[]{"tts_info.log", "asr_info.log"});
    }

    public static a c(File r100) {
        Intrinsics.checkNotNullParameter(r100, "audioRoot");
        if (r100.isDirectory() == false) goto L5;
        c r101 = new c();
        Iterator r102 = ((ArrayList) h(r100)).iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        f((File) r102.next(), r101);
        goto L8
    L10:
        Iterator r103 = SetsKt.plus(f320013f, f320014g).iterator();
    L12:
        if (r103.hasNext() == false) goto L29;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100, (String) r103.next());
        if (r104.isDirectory() == false) goto L12;
        if (k(r104, r100) == false) goto L12;
        File[] r105 = r104.listFiles();
        if (r105 == null) goto L25;
        boolean r106 = true;
        if (r105.length != 0) goto L22;
        boolean r107 = true;
    L23:
        if (r107 != true) goto L25;
    L26:
        if (r106 == false) goto L12;
        r104.delete();
        goto L12
    L22:
        r107 = false;
    L25:
        r106 = false;
        goto L26
    L29:
        return new a(r101.f320022a, r101.f320023b, r101.f320024c);
    L5:
        return new a(0, 0, 0);
    }

    public static List h(File r100) {
        Set<String> r101 = f320014g;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L3:
        boolean r104 = false;
        PolarisFileWrapper r105 = null;
        if (r103.hasNext() == false) goto L16;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r100, (String) r103.next());
        if (r106.isDirectory() == true) goto L8;
    L12:
        if (r104 == false) goto L14;
        r105 = r106;
    L14:
        if (r105 == null) goto L3;
        r102.add(r105);
        goto L3
    L8:
        if (j(r106) == true) goto L12;
        if (k(r106, r100) == false) goto L12;
        r104 = true;
        goto L12
    L16:
        Set<String> r107 = f320015h;
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L18:
        if (r109.hasNext() == false) goto L32;
        PolarisFileWrapper r110 = new PolarisFileWrapper(r100, (String) r109.next());
        if (r110.isFile() == true) goto L22;
    L26:
        boolean r111 = false;
    L27:
        if (r111 == true) goto L30;
        r110 = null;
    L30:
        if (r110 == null) goto L18;
        r108.add(r110);
        goto L18
    L22:
        if (j(r110) == true) goto L26;
        if (k(r110, r100) == false) goto L26;
        r111 = true;
        goto L27
    L32:
        List r112 = CollectionsKt.plus(CollectionsKt.plus(i(r100), r102), r108);
        HashSet r113 = new HashSet();
        ArrayList r114 = new ArrayList();
        Iterator r115 = r112.iterator();
    L34:
        if (r115.hasNext() == false) goto L38;
        Object r116 = r115.next();
        if (r113.add(((File) r116).getAbsolutePath()) == false) goto L34;
        r114.add(r116);
        goto L34
    L38:
        return r114;
    }

    public static List i(File r110) {
        File[] r100 = r110.listFiles();
        if (r100 != null) goto L5;
        r100 = new File[0];
    L5:
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L6:
        boolean r104 = true;
        if (r103 >= r102) goto L48;
        File r105 = r100[r103];
        Intrinsics.checkNotNull(r105);
        if (r105.isDirectory() == true) goto L11;
    L44:
        r104 = false;
    L45:
        if (r104 == false) goto L47;
        r101.add(r105);
    L47:
        r103 = r103 + 1;
        goto L6
    L11:
        if (j(r105) == true) goto L44;
        if (l(r105, r110) == false) goto L44;
        if (f320011d.matches(r105.getName()) == false) goto L44;
        File[] r106 = r105.listFiles();
        if (r106 == null) goto L44;
        if (r106.length != 0) goto L23;
        boolean r107 = true;
    L25:
        if ((!r107) == false) goto L44;
        int r108 = r106.length;
        int r109 = 0;
    L27:
        if (r109 >= r108) goto L41;
        File r111 = r106[r109];
        if (r111.isDirectory() == false) goto L37;
        Intrinsics.checkNotNull(r111);
        if (j(r111) == true) goto L37;
        if (k(r111, r105) == false) goto L37;
        if (f320012e.contains(r111.getName()) == false) goto L37;
        boolean r112 = true;
    L38:
        if (r112 == false) goto L39;
        r109 = r109 + 1;
        goto L27
    L39:
        boolean r113 = false;
    L42:
        if (r113 == false) goto L44;
    L37:
        r112 = false;
        goto L38
    L41:
        r113 = true;
        goto L42
    L23:
        r107 = false;
        goto L25
    L48:
        Set<String> r114 = f320013f;
        ArrayList r115 = new ArrayList();
        Iterator<T> r116 = r114.iterator();
    L50:
        if (r116.hasNext() == false) goto L83;
        PolarisFileWrapper r117 = new PolarisFileWrapper(r110, (String) r116.next());
        if (j(r117) == false) goto L54;
    L81:
        List r118 = CollectionsKt.emptyList();
    L82:
        CollectionsKt.addAll(r115, r118);
        goto L50
    L54:
        if (l(r117, r110) == false) goto L81;
        File[] r119 = r117.listFiles();
        if (r119 != null) goto L59;
        r119 = new File[0];
    L59:
        int r120 = r119.length;
        int r121 = 0;
    L60:
        if (r121 >= r120) goto L65;
        if (r119[r121].isFile() == true) goto L63;
        r121 = r121 + 1;
        goto L60
    L63:
        boolean r122 = true;
    L66:
        if (r122 == false) goto L68;
        r118 = CollectionsKt.listOf(r117);
        goto L82
    L68:
        ArrayList r123 = new ArrayList();
        int r124 = r119.length;
        int r125 = 0;
    L69:
        if (r125 >= r124) goto L79;
        File r126 = r119[r125];
        if (r126.isDirectory() == false) goto L75;
        Intrinsics.checkNotNull(r126);
        if (k(r126, r117) == false) goto L75;
        boolean r127 = true;
    L76:
        if (r127 == false) goto L78;
        r123.add(r126);
    L78:
        r125 = r125 + 1;
    L75:
        r127 = false;
        goto L76
    L79:
        r118 = r123;
        goto L82
    L65:
        r122 = false;
        goto L66
    L83:
        List r128 = CollectionsKt.plus(r101, r115);
        HashSet r129 = new HashSet();
        ArrayList r130 = new ArrayList();
        Iterator r131 = r128.iterator();
    L85:
        if (r131.hasNext() == false) goto L89;
        Object r132 = r131.next();
        if (r129.add(((File) r132).getAbsolutePath()) == false) goto L85;
        r130.add(r132);
        goto L85
    L89:
        return r130;
    }

    public static boolean j(File r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        if (Intrinsics.areEqual(r100.getCanonicalFile().getAbsolutePath(), r100.getAbsoluteFile().getAbsolutePath()) == true) goto L5;
        boolean r102 = true;
    L6:
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L8
    L10:
        Boolean r104 = Boolean.TRUE;
        if (Result.m9455isFailureimpl(r103) == false) goto L14;
        r103 = r104;
    L14:
        return ((Boolean) r103).booleanValue();
    L5:
        r102 = false;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final a b(PolarisFileWrapper r110) {
        Intrinsics.checkNotNullParameter(r110, "audioRoot");
        if (r110.isDirectory() == false) goto L5;
        c r100 = new c();
        List r101 = CollectionsKt.toMutableList(CollectionsKt.sortedWith(i(r110), new t(this)));
        if (this.f320016a <= 0) goto L17;
        ArrayList r102 = new ArrayList();
    L10:
        if (r101.size() <= this.f320016a) goto L16;
        File r103 = (File) ListProtector.remove(r101, 0);
        if (f(r103, r100) == true) goto L10;
        if (r103.exists() == false) goto L10;
        r102.add(r103);
        goto L10
    L16:
        r101 = CollectionsKt.toMutableList(CollectionsKt.sortedWith(CollectionsKt.plus(r101, r102), new u(this)));
    L17:
        List r104 = r101;
        ArrayList r105 = new ArrayList();
        Iterator r106 = r104.iterator();
    L19:
        if (r106.hasNext() == false) goto L23;
        Object r107 = r106.next();
        if (((File) r107).exists() == false) goto L19;
        r105.add(r107);
        goto L19
    L23:
        Iterator r108 = r105.iterator();
    L25:
        if (r108.hasNext() == false) goto L33;
        File r109 = (File) r108.next();
        if (this.f320017b <= 0) goto L25;
        List r111 = CollectionsKt.toMutableList(CollectionsKt.sortedWith(m(r109, false), new v()));
    L31:
        if (r111.size() <= this.f320017b) goto L25;
        e((File) ListProtector.remove(r111, 0), r100);
        goto L31
    L33:
        ArrayList r112 = new ArrayList();
        Iterator r113 = r104.iterator();
    L35:
        if (r113.hasNext() == false) goto L40;
        Object r114 = r113.next();
        if (((File) r114).exists() == false) goto L35;
        r112.add(r114);
        goto L35
    L40:
        if (this.f320018c <= 0) goto L66;
        ArrayList r115 = new ArrayList();
        Iterator r116 = r112.iterator();
    L44:
        if (r116.hasNext() == false) goto L46;
        CollectionsKt.addAll(r115, m((File) r116.next(), false));
        goto L44
    L46:
        ArrayList r117 = new ArrayList();
        Iterator r118 = r115.iterator();
    L48:
        if (r118.hasNext() == false) goto L52;
        Object r119 = r118.next();
        if (((File) r119).exists() == false) goto L48;
        r117.add(r119);
        goto L48
    L52:
        List r120 = CollectionsKt.toMutableList(CollectionsKt.sortedWith(r117, new w()));
        Iterator r121 = r120.iterator();
        long r122 = 0;
    L54:
        if (r121.hasNext() == false) goto L60;
        long r123 = ((File) r121.next()).length();
        if (r123 > (Long.MAX_VALUE - r122)) goto L57;
        r122 = r122 + r123;
        goto L54
    L57:
        r122 = Long.MAX_VALUE;
    L60:
        if (r122 <= this.f320018c) goto L66;
        if ((!r120.isEmpty()) == false) goto L66;
        File r124 = (File) ListProtector.remove(r120, 0);
        long r125 = r124.length();
        if (e(r124, r100) == false) goto L60;
        r122 = RangesKt.coerceAtLeast(r122 - r125, 0);
    L66:
        Iterator r126 = r104.iterator();
    L68:
        if (r126.hasNext() == false) goto L85;
        File r127 = (File) r126.next();
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L72
        Object r129 = Result.m9449constructorimpl(r127.getCanonicalFile());     // Catch: Throwable -> L72
    L75:
        if (Result.m9455isFailureimpl(r129) == false) goto L77;
        r129 = null;
    L77:
        File r130 = (File) r129;
        if (r130 == null) goto L68;
        if (Intrinsics.areEqual(r130.getAbsolutePath(), r127.getAbsoluteFile().getAbsolutePath()) == false) goto L68;
        d(r127, r130);
    L72:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L75
    L85:
        return new a(r100.f320022a, r100.f320023b, r100.f320024c);
    L5:
        return new a(0, 0, 0);
    }

    public static final long a(s r100, File r101) {
        r100.getClass();
        Iterator r102 = m(r101, false).iterator();
        if (r102.hasNext() == true) goto L5;
        Long r103 = null;
    L12:
        if (r103 == null) goto L15;
        return r103.longValue();
    L15:
        return r101.lastModified();
    L5:
        Long r104 = Long.valueOf(((File) r102.next()).lastModified());
    L7:
        if (r102.hasNext() == false) goto L11;
        Long r105 = Long.valueOf(((File) r102.next()).lastModified());
        if (r104.compareTo(r105) >= 0) goto L7;
        r104 = r105;
        goto L7
    L11:
        r103 = r104;
        goto L12
    }

    public static void d(File r100, File r101) {
        if (r100.isDirectory() == true) goto L5;
        return;
    L5:
        File[] r102 = r100.listFiles();
        boolean r103 = false;
        if (r102 != null) goto L8;
        r102 = new File[0];
    L8:
        ArrayList r104 = new ArrayList();
        int r105 = r102.length;
        int r106 = 0;
    L9:
        boolean r107 = true;
        if (r106 >= r105) goto L22;
        File r108 = r102[r106];
        if (r108.isDirectory() == false) goto L18;
        Intrinsics.checkNotNull(r108);
        if (j(r108) == true) goto L18;
        if (k(r108, r101) == false) goto L18;
    L19:
        if (r107 == false) goto L21;
        r104.add(r108);
    L21:
        r106 = r106 + 1;
    L18:
        r107 = false;
        goto L19
    L22:
        Iterator r109 = r104.iterator();
    L24:
        if (r109.hasNext() == false) goto L26;
        File r110 = (File) r109.next();
        Intrinsics.checkNotNull(r110);
        d(r110, r101);
        goto L24
    L26:
        File[] r111 = r100.listFiles();
        if (r111 != null) goto L29;
    L34:
        if (r103 == false) goto L41;
        r100.delete();
        return;
    L41:
        return;
    L29:
        if (r111.length != 0) goto L31;
        boolean r112 = true;
    L32:
        if (r112 != true) goto L34;
        r103 = true;
        goto L34
    L31:
        r112 = false;
        goto L32
    }

    public static boolean e(File r110, c r111) {
        if (r110.exists() == true) goto L5;
        return true;
    L5:
        long r100 = r110.length();
        if (r110.delete() == false) goto L8;
    L11:
        long r101 = r111.f320022a;
        long r102 = Long.MAX_VALUE;
        if (r100 > (Long.MAX_VALUE - r101)) goto L15;
        r102 = r101 + r100;
    L15:
        r111.f320022a = r102;
        r111.f320023b++;
        return true;
    L8:
        if (r110.exists() == false) goto L11;
        r111.f320024c++;
        return false;
    }

    public static boolean f(File r100, c r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(r100.getCanonicalFile());     // Catch: Throwable -> L4
    L7:
        if (Result.m9452exceptionOrNullimpl(r103) != null) goto L13;
        File r104 = (File) r103;
        if (Intrinsics.areEqual(r104.getAbsolutePath(), r100.getAbsoluteFile().getAbsolutePath()) == true) goto L11;
        return false;
    L11:
        Intrinsics.checkNotNull(r104);
        return g(r100, r104, r101);
    L13:
        r101.f320024c++;
        return false;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static boolean k(File r100, File r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(r101.getCanonicalFile());     // Catch: Throwable -> L4
    L7:
        if (Result.m9452exceptionOrNullimpl(r103) != null) goto L17;
        File r104 = (File) r103;
        Object r105 = Result.m9449constructorimpl(r100.getCanonicalFile());     // Catch: Throwable -> L11
    L14:
        if (Result.m9452exceptionOrNullimpl(r105) != null) goto L17;
        return StringsKt.startsWith$default(((File) r105).getPath(), StringsKt.trimEnd(r104.getPath(), new char[]{File.separatorChar}) + File.separator, false, 2, null);
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L17:
        return false;
    L4:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static boolean l(File r100, File r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(r101.getCanonicalFile());     // Catch: Throwable -> L4
    L7:
        if (Result.m9452exceptionOrNullimpl(r103) != null) goto L25;
        File r104 = (File) r103;
        Object r105 = Result.m9449constructorimpl(r100.getCanonicalFile());     // Catch: Throwable -> L11
    L14:
        if (Result.m9452exceptionOrNullimpl(r105) != null) goto L26;
        File r106 = (File) r105;
        if (Intrinsics.areEqual(r106, r104) == false) goto L18;
    L19:
        return true;
    L18:
        if (StringsKt.startsWith$default(r106.getPath(), StringsKt.trimEnd(r104.getPath(), new char[]{File.separatorChar}) + File.separator, false, 2, null) == true) goto L19;
        return false;
    L26:
        return false;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L25:
        return false;
    L4:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static List m(File r100, boolean r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(r100.getCanonicalFile());     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r103) == false) goto L9;
        r103 = null;
    L9:
        File r104 = (File) r103;
        if (r104 != null) goto L14;
        return CollectionsKt.emptyList();
    L14:
        if (Intrinsics.areEqual(r104.getAbsolutePath(), r100.getAbsoluteFile().getAbsolutePath()) == true) goto L18;
        return CollectionsKt.emptyList();
    L18:
        return n(r100, r104, r101);
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public s(int r100, int r101, long r102) {
        this.f320016a = r100;
        this.f320017b = r101;
        this.f320018c = r102;
    }

    public static boolean g(File r100, File r101, c r110) {
        if (r100.exists() == true) goto L51;
        return true;
    L51:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(r100.getCanonicalFile());     // Catch: Throwable -> L7
    L10:
        if (Result.m9452exceptionOrNullimpl(r103) != null) goto L49;
        File r104 = (File) r103;
        if (Intrinsics.areEqual(r104, r101) == true) goto L17;
        Intrinsics.checkNotNull(r104);
        if (k(r104, r101) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(r104.getAbsolutePath(), r100.getAbsoluteFile().getAbsolutePath()) == true) goto L20;
        return false;
    L20:
        if (r100.isDirectory() == false) goto L32;
        File[] r105 = r100.listFiles();
        if (r105 != null) goto L24;
        r105 = new File[0];
    L24:
        int r106 = r105.length;
        int r107 = 0;
        boolean r108 = true;
    L25:
        if (r107 >= r106) goto L33;
        File r109 = r105[r107];
        Intrinsics.checkNotNull(r109);
        if (k(r109, r101) == true) goto L29;
    L30:
        r108 = false;
    L31:
        r107 = r107 + 1;
        goto L25
    L29:
        if (g(r109, r101, r110) == true) goto L31;
    L33:
        if (r108 == true) goto L35;
    L48:
        return r108;
    L35:
        if (r100.exists() == false) goto L48;
        if (r100.isFile() == false) goto L42;
        return e(r100, r110);
    L42:
        if (r100.delete() == false) goto L44;
        return true;
    L44:
        if (r100.exists() == false) goto L57;
        r110.f320024c++;
        return false;
    L57:
        return true;
    L32:
        r108 = true;
        goto L33
    L49:
        r110.f320024c++;
        return false;
    L7:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static List n(File r100, File r101, boolean r102) {
        ArrayList r103 = new ArrayList();
        File[] r104 = r100.listFiles();
        if (r104 == null) goto L5;
        int r105 = r104.length;
        int r106 = 0;
    L11:
        if (r106 >= r105) goto L24;
        File r107 = r104[r106];
        Intrinsics.checkNotNull(r107);
        if (j(r107) == true) goto L23;
        if (k(r107, r101) == false) goto L23;
        if (r107.isDirectory() == false) goto L21;
        CollectionsKt.addAll(r103, n(r107, r101, r102));
        goto L23
    L21:
        if (r107.isFile() == false) goto L23;
        r103.add(r107);
    L23:
        r106 = r106 + 1;
        goto L11
    L24:
        return r103;
    L5:
        if ((!r102) == false) goto L9;
        return CollectionsKt.emptyList();
    L9:
        throw new IllegalStateException("Unable to enumerate an audio diagnostic directory".toString());
    }
}
