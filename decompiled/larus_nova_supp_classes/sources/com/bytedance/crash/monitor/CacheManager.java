package com.bytedance.crash.monitor;

import ch4.c;
import com.bytedance.crash.i;
import com.bytedance.crash.util.g;
import com.bytedance.crash.util.h;
import com.bytedance.crash.util.s;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class CacheManager {
    public final PolarisFileWrapper a;
    public CachedString b;
    public CachedString c;
    public CachedString d;
    public CachedString e;
    public CachedVersion f;

    public static class CachedString implements Serializable {
        private static final long serialVersionUID = 1;
        private long mCreateTime;
        private String mValue;

        public CachedString() {
        }

        public static CachedString getCurrent(File r3, String r4) {
            CachedString r5 = (CachedString) s.a(new PolarisFileWrapper(r3, "current" + r4));
            if (r5 == null) goto L5;
            return r5;
        L5:
            return new CachedString();
        }

        public String getBefore(File r7, String r8, long r9) {
            if (r9 == 0) goto L35;
            long r2 = this.mCreateTime;
            if (r2 != 0) goto L7;
        L9:
            File[] r10 = CacheManager.f(r7, r8);
            if (r10 == null) goto L12;
            int r0 = r10.length;
            int r1 = 0;
        L14:
            if (r1 >= r0) goto L24;
            File r3 = r10[r1];
            if (r9 <= CacheManager.d(r3, r8)) goto L23;
            CachedString r4 = (CachedString) s.a(r3);
            if (r4 == null) goto L22;
            String r5 = r4.mValue;
            if (r5 == null) goto L22;
            return r5;
        L22:
            h.b(r3);
        L23:
            r1 = r1 + 1;
            goto L14
        L24:
            int r11 = r10.length - 1;
        L25:
            if (r11 < 0) goto L33;
            CachedString r12 = (CachedString) s.a(r10[r11]);
            if (r12 == null) goto L31;
            String r13 = r12.mValue;
            if (r13 == null) goto L31;
            return r13;
        L31:
            r10[r11].delete();
            r11 = r11 - 1;
            goto L25
        L33:
            return this.mValue;
        L12:
            return this.mValue;
        L7:
            if (r9 <= r2) goto L9;
        L35:
            return this.mValue;
        }

        public void update(File r7, String r8, String r9) {
            long r0 = System.currentTimeMillis();
            String r2 = this.mValue;
            if (r2 != null) goto L5;
        L8:
            this.mValue = r9;
            this.mCreateTime = r0;
            s.b(new PolarisFileWrapper(r7, "current" + r8), this);
            return;
        L5:
            if (r2.equals(r9) == false) goto L7;
            return;
        L7:
            CacheManager.a(r7, r8);
            s.b(new PolarisFileWrapper(r7, this.mCreateTime + r8), this);
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

        public static CachedVersion getCurrent(File r2) {
            CachedVersion r3 = (CachedVersion) s.a(new PolarisFileWrapper(r2, "current.ver"));
            if (r3 == null) goto L5;
            return r3;
        L5:
            return new CachedVersion();
        }

        public c getAfter(File r19, long r20) {
            long r1 = this.mCreateTime;
            c r3 = null;
            if (r1 != 0) goto L5;
        L7:
            long r8 = this.mVersionCode;
            if (r8 == 0) goto L12;
            String r14 = this.mName;
            if (r14 == null) goto L12;
            r3 = new c(r8, this.mUpdateVersionCode, this.mManifestCode, r14);
        L12:
            File[] r2 = CacheManager.f(r19, VER_SUFFIX);
            if (r2 == null) goto L27;
            int r6 = r2.length;
            int r7 = 0;
        L15:
            if (r7 >= r6) goto L27;
            File r9 = r2[r7];
            if (r20 >= CacheManager.d(r9, VER_SUFFIX)) goto L26;
            CachedVersion r10 = (CachedVersion) s.a(r9);
            if (r10 == null) goto L25;
            String r15 = r10.mName;
            if (r15 == null) goto L25;
            long r11 = r10.mVersionCode;
            if (r11 == 0) goto L25;
            r3 = new c(r11, r10.mUpdateVersionCode, r10.mManifestCode, r15);
        L25:
            h.b(r9);
        L26:
            r7 = r7 + 1;
        L27:
            return r3;
        L5:
            if (r20 <= r1) goto L7;
            return null;
        }

        public c getBefore(File r18, long r19) {
            if (r19 == 0) goto L30;
            long r3 = this.mCreateTime;
            if (r3 != 0) goto L7;
        L9:
            File[] r4 = CacheManager.f(r18, VER_SUFFIX);
            if (r4 == null) goto L27;
            int r5 = r4.length;
            int r6 = 0;
        L12:
            if (r6 >= r5) goto L35;
            File r7 = r4[r6];
            if (r19 <= CacheManager.d(r7, VER_SUFFIX)) goto L26;
            CachedVersion r8 = (CachedVersion) s.a(r7);
            if (r8 == null) goto L25;
            String r14 = r8.mName;
            if (r14 == null) goto L25;
            long r10 = r8.mVersionCode;
            if (r10 == 0) goto L25;
            long r12 = r8.mUpdateVersionCode;
            if (r12 == 0) goto L25;
            return new c(r10, r12, r8.mManifestCode, r14);
        L25:
            h.b(r7);
        L26:
            r6 = r6 + 1;
            goto L12
        L35:
            return null;
        L27:
            return null;
        L7:
            if (r19 <= r3) goto L9;
        L30:
            return new c(this.mVersionCode, this.mUpdateVersionCode, this.mManifestCode, this.mName);
        }

        public void update(File r18, long r19, long r21, long r23, String r25) {
            long r9 = System.currentTimeMillis();
            String r11 = this.mName;
            if (r11 != null) goto L5;
        L16:
            i.a().getClass();
        L17:
            this.mName = r25;
            this.mVersionCode = r19;
            this.mUpdateVersionCode = r21;
            this.mCreateTime = r9;
            this.mManifestCode = r23;
            s.b(new PolarisFileWrapper(r18, "current.ver"), this);
            return;
        L5:
            if (this.mVersionCode == 0) goto L16;
            if (r11.equals(r25) == true) goto L9;
        L15:
            i.a().getClass();
            CacheManager.a(r18, VER_SUFFIX);
            s.b(new PolarisFileWrapper(r18, this.mCreateTime + VER_SUFFIX), this);
            goto L17
        L9:
            if (this.mVersionCode != r19) goto L15;
            if (r23 != this.mManifestCode) goto L15;
            if (this.mUpdateVersionCode != r21) goto L15;
        }
    }

    public CacheManager(PolarisFileWrapper r2) {
        this.a = g.b(r2, "params");
    }

    public final String b(long r4) {
        return c(".aid").getBefore(this.a, ".aid", r4);
    }

    public final CachedString c(String r5) {
        switch(r5.hashCode()) {
            case 1466958: goto L15;
            case 1468859: goto L12;
            case 1469841: goto L9;
            case 1486178: goto L6;
            default: goto L17;
        };
    L17:
        byte r0 = -1;
    L18:
        if (r0 == 0) goto L37;
        if (r0 == 1) goto L32;
        if (r0 == 2) goto L27;
        if (this.c != null) goto L25;
        this.c = CachedString.getCurrent(this.a, ".chn");
    L25:
        return this.c;
    L27:
        if (this.e != null) goto L30;
        this.e = CachedString.getCurrent(this.a, r5);
    L30:
        return this.e;
    L32:
        if (this.d != null) goto L35;
        this.d = CachedString.getCurrent(this.a, r5);
    L35:
        return this.d;
    L37:
        if (this.b != null) goto L40;
        this.b = CachedString.getCurrent(this.a, r5);
    L40:
        return this.b;
    L6:
        if (r5.equals(".uid") == false) goto L17;
        r0 = 2;
        goto L18
    L9:
        if (r5.equals(".did") == false) goto L17;
        r0 = 0;
        goto L18
    L12:
        if (r5.equals(".chn") == false) goto L17;
        r0 = 3;
        goto L18
    L15:
        if (r5.equals(".aid") == false) goto L17;
        r0 = 1;
        goto L18
    }

    public final String e(long r4) {
        return c(".did").getBefore(this.a, ".did", r4);
    }

    public final long g(long r4) {
        String r5 = c(".uid").getBefore(this.a, ".uid", r4);
        if (r5 != null) goto L10;
    L8:
        return 0;
    L10:
        return Long.decode(r5).longValue();
    L6:
        th = move-exception;
        c.c(th);
        goto L8
    }

    public final void h(String r4) {
        c(".aid").update(this.a, ".aid", r4);
    }

    public CacheManager(PolarisFileWrapper r2, String r3) {
        this.a = g.b(g.b(r2, "params"), r3);
    }

    public static void a(File r10, String r11) {
        File[] r12 = f(r10, r11);
        if (r12 == null) goto L12;
        long r0 = System.currentTimeMillis();
        int r2 = r12.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L16;
        File r4 = r12[r3];
        long r5 = d(r4, r11);
        if (r5 <= r0) goto L9;
    L10:
        h.b(r4);
    L11:
        r3 = r3 + 1;
        goto L5
    L9:
        if ((r0 - r5) <= 1209600000) goto L11;
    L16:
        return;
    }

    public static long d(File r1, String r2) {
        String r3 = r1.getName();     // Catch: Throwable -> L4
        return CastLongProtector.parseLong(r3.substring(0, r3.length() - r2.length()));
    L4:
        th = move-exception;
        c.c(th);
        return -1;
    }

    public static File[] f(File r1, String r2) {
        File[] r3 = r1.listFiles(new a(r2));
        if (r3 == null) goto L5;
        Arrays.sort(r3, new b(r2));
    L5:
        return r3;
    }

    public final void i(long r12, long r14, long r16, String r18) {
        if (this.f != null) goto L5;
        this.f = CachedVersion.getCurrent(this.a);
    L5:
        this.f.update(this.a, r12, r14, r16, r18);
    }
}
