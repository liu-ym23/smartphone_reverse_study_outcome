package com.bytedance.crash.monitor;

import com.bytedance.crash.util.s;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class CacheManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PolarisFileWrapper f203256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CachedString f203257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CachedString f203258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CachedString f203259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CachedString f203260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CachedVersion f203261f;

    public static class CachedString implements Serializable {
        private static final long serialVersionUID = 1;
        private long mCreateTime;
        private String mValue;

        public CachedString() {
        }

        public static CachedString getCurrent(File r100, String r101) {
            CachedString r102 = (CachedString) s.a(new PolarisFileWrapper(r100, "current" + r101));
            if (r102 == null) goto L5;
            return r102;
        L5:
            return new CachedString();
        }

        public String getBefore(File r100, String r101, long r102) {
            if (r102 == 0) goto L35;
            long r103 = this.mCreateTime;
            if (r103 != 0) goto L7;
        L9:
            File[] r104 = CacheManager.f(r100, r101);
            if (r104 == null) goto L12;
            int r105 = r104.length;
            int r106 = 0;
        L14:
            if (r106 >= r105) goto L24;
            File r107 = r104[r106];
            if (r102 <= CacheManager.d(r107, r101)) goto L23;
            CachedString r108 = (CachedString) s.a(r107);
            if (r108 == null) goto L22;
            String r109 = r108.mValue;
            if (r109 == null) goto L22;
            return r109;
        L22:
            com.bytedance.crash.util.h.b(r107);
        L23:
            r106 = r106 + 1;
            goto L14
        L24:
            int r110 = r104.length - 1;
        L25:
            if (r110 < 0) goto L33;
            CachedString r111 = (CachedString) s.a(r104[r110]);
            if (r111 == null) goto L31;
            String r112 = r111.mValue;
            if (r112 == null) goto L31;
            return r112;
        L31:
            r104[r110].delete();
            r110 = r110 - 1;
            goto L25
        L33:
            return this.mValue;
        L12:
            return this.mValue;
        L7:
            if (r102 <= r103) goto L9;
        L35:
            return this.mValue;
        }

        public void update(File r100, String r101, String r102) {
            long r103 = System.currentTimeMillis();
            String r104 = this.mValue;
            if (r104 != null) goto L5;
        L8:
            this.mValue = r102;
            this.mCreateTime = r103;
            s.b(new PolarisFileWrapper(r100, "current" + r101), this);
            return;
        L5:
            if (r104.equals(r102) == false) goto L7;
            return;
        L7:
            CacheManager.a(r100, r101);
            s.b(new PolarisFileWrapper(r100, this.mCreateTime + r101), this);
            goto L8
        }
    }

    public static class CachedVersion implements Serializable {
        public static final int VERSION_NEW = 2;
        public static final int VERSION_NO_CHANGE = 0;
        public static final int VERSION_UPDATE = 1;
        private static final String VER_SUFFIX = ".ver";
        private static final long serialVersionUID = 1;
        private long mCreateTime;
        private long mManifestCode;
        private String mName;
        private long mUpdateVersionCode;
        private long mVersionCode;

        public CachedVersion() {
        }

        public static CachedVersion getCurrent(File r100) {
            CachedVersion r101 = (CachedVersion) s.a(new PolarisFileWrapper(r100, "current.ver"));
            if (r101 == null) goto L5;
            return r101;
        L5:
            return new CachedVersion();
        }

        public c getAfter(File r110, long r210) {
            long r100 = this.mCreateTime;
            c r101 = null;
            if (r100 != 0) goto L5;
        L7:
            long r102 = this.mVersionCode;
            if (r102 == 0) goto L12;
            String r111 = this.mName;
            if (r111 == null) goto L12;
            r101 = new c(r102, this.mUpdateVersionCode, this.mManifestCode, r111);
        L12:
            File[] r103 = CacheManager.f(r110, VER_SUFFIX);
            if (r103 == null) goto L27;
            int r104 = r103.length;
            int r105 = 0;
        L15:
            if (r105 >= r104) goto L27;
            File r106 = r103[r105];
            if (r210 >= CacheManager.d(r106, VER_SUFFIX)) goto L26;
            CachedVersion r107 = (CachedVersion) s.a(r106);
            if (r107 == null) goto L25;
            String r112 = r107.mName;
            if (r112 == null) goto L25;
            long r113 = r107.mVersionCode;
            if (r113 == 0) goto L25;
            r101 = new c(r113, r107.mUpdateVersionCode, r107.mManifestCode, r112);
        L25:
            com.bytedance.crash.util.h.b(r106);
        L26:
            r105 = r105 + 1;
        L27:
            return r101;
        L5:
            if (r210 <= r100) goto L7;
            return null;
        }

        public c getBefore(File r110, long r111) {
            if (r111 == 0) goto L30;
            long r100 = this.mCreateTime;
            if (r100 != 0) goto L7;
        L9:
            File[] r101 = CacheManager.f(r110, VER_SUFFIX);
            if (r101 == null) goto L27;
            int r102 = r101.length;
            int r103 = 0;
        L12:
            if (r103 >= r102) goto L35;
            File r104 = r101[r103];
            if (r111 <= CacheManager.d(r104, VER_SUFFIX)) goto L26;
            CachedVersion r105 = (CachedVersion) s.a(r104);
            if (r105 == null) goto L25;
            String r112 = r105.mName;
            if (r112 == null) goto L25;
            long r113 = r105.mVersionCode;
            if (r113 == 0) goto L25;
            long r114 = r105.mUpdateVersionCode;
            if (r114 == 0) goto L25;
            return new c(r113, r114, r105.mManifestCode, r112);
        L25:
            com.bytedance.crash.util.h.b(r104);
        L26:
            r103 = r103 + 1;
            goto L12
        L35:
            return null;
        L27:
            return null;
        L7:
            if (r111 <= r100) goto L9;
        L30:
            return new c(this.mVersionCode, this.mUpdateVersionCode, this.mManifestCode, this.mName);
        }

        public void update(File r110, long r111, long r210, long r211, String r212) {
            long r100 = System.currentTimeMillis();
            String r112 = this.mName;
            if (r112 != null) goto L5;
        L16:
            com.bytedance.crash.i.a().getClass();
        L17:
            this.mName = r212;
            this.mVersionCode = r111;
            this.mUpdateVersionCode = r210;
            this.mCreateTime = r100;
            this.mManifestCode = r211;
            s.b(new PolarisFileWrapper(r110, "current.ver"), this);
            return;
        L5:
            if (this.mVersionCode == 0) goto L16;
            if (r112.equals(r212) == true) goto L9;
        L15:
            com.bytedance.crash.i.a().getClass();
            CacheManager.a(r110, VER_SUFFIX);
            s.b(new PolarisFileWrapper(r110, this.mCreateTime + VER_SUFFIX), this);
            goto L17
        L9:
            if (this.mVersionCode != r111) goto L15;
            if (r211 != this.mManifestCode) goto L15;
            if (this.mUpdateVersionCode != r210) goto L15;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f203262a;

        public a(String r100) {
            this.f203262a = r100;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r100, String r101) {
            if (r101.endsWith(this.f203262a) == true) goto L5;
        L7:
            return false;
        L5:
            if (r101.startsWith("current") == true) goto L7;
            return true;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class b implements Comparator<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f203263a;

        public b(String r100) {
            this.f203263a = r100;
        }

        @Override // java.util.Comparator
        public final int compare(File r100, File r101) {
            return Long.compare(CacheManager.d(r101, this.f203263a), CacheManager.d(r100, this.f203263a));
        }
    }

    public CacheManager(PolarisFileWrapper r100) {
        this.f203256a = com.bytedance.crash.util.g.b(r100, "params");
    }

    public final String b(long r100) {
        return c(".aid").getBefore(this.f203256a, ".aid", r100);
    }

    public final CachedString c(String r100) {
        switch(r100.hashCode()) {
            case 1466958: goto L15;
            case 1468859: goto L12;
            case 1469841: goto L9;
            case 1486178: goto L6;
            default: goto L17;
        };
    L17:
        byte r101 = -1;
    L18:
        if (r101 == 0) goto L37;
        if (r101 == 1) goto L32;
        if (r101 == 2) goto L27;
        if (this.f203258c != null) goto L25;
        this.f203258c = CachedString.getCurrent(this.f203256a, ".chn");
    L25:
        return this.f203258c;
    L27:
        if (this.f203260e != null) goto L30;
        this.f203260e = CachedString.getCurrent(this.f203256a, r100);
    L30:
        return this.f203260e;
    L32:
        if (this.f203259d != null) goto L35;
        this.f203259d = CachedString.getCurrent(this.f203256a, r100);
    L35:
        return this.f203259d;
    L37:
        if (this.f203257b != null) goto L40;
        this.f203257b = CachedString.getCurrent(this.f203256a, r100);
    L40:
        return this.f203257b;
    L6:
        if (r100.equals(".uid") == false) goto L17;
        r101 = 2;
        goto L18
    L9:
        if (r100.equals(".did") == false) goto L17;
        r101 = 0;
        goto L18
    L12:
        if (r100.equals(".chn") == false) goto L17;
        r101 = 3;
        goto L18
    L15:
        if (r100.equals(".aid") == false) goto L17;
        r101 = 1;
        goto L18
    }

    public final String e(long r100) {
        return c(".did").getBefore(this.f203256a, ".did", r100);
    }

    public final long g(long r100) {
        String r101 = c(".uid").getBefore(this.f203256a, ".uid", r100);
        if (r101 != null) goto L10;
    L8:
        return 0;
    L10:
        return Long.decode(r101).longValue();
    L6:
        th = move-exception;
        ch4.c.c(th);
        goto L8
    }

    public final void h(String r100) {
        c(".aid").update(this.f203256a, ".aid", r100);
    }

    public CacheManager(PolarisFileWrapper r100, String r101) {
        this.f203256a = com.bytedance.crash.util.g.b(com.bytedance.crash.util.g.b(r100, "params"), r101);
    }

    public static void a(File r110, String r111) {
        File[] r112 = f(r110, r111);
        if (r112 == null) goto L12;
        long r100 = System.currentTimeMillis();
        int r101 = r112.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L16;
        File r103 = r112[r102];
        long r104 = d(r103, r111);
        if (r104 <= r100) goto L9;
    L10:
        com.bytedance.crash.util.h.b(r103);
    L11:
        r102 = r102 + 1;
        goto L5
    L9:
        if ((r100 - r104) <= 1209600000) goto L11;
    L16:
        return;
    }

    public static long d(File r100, String r101) {
        String r102 = r100.getName();     // Catch: Throwable -> L4
        return CastLongProtector.parseLong(r102.substring(0, r102.length() - r101.length()));
    L4:
        th = move-exception;
        ch4.c.c(th);
        return -1;
    }

    public static File[] f(File r100, String r101) {
        File[] r102 = r100.listFiles(new a(r101));
        if (r102 == null) goto L5;
        Arrays.sort(r102, new b(r101));
    L5:
        return r102;
    }

    public final void i(long r110, long r111, long r112, String r113) {
        if (this.f203261f != null) goto L5;
        this.f203261f = CachedVersion.getCurrent(this.f203256a);
    L5:
        this.f203261f.update(this.f203256a, r110, r111, r112, r113);
    }
}
