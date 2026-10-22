package com.tencent.open.log;

import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes31.dex */
public class d {

    public static final class a {
        public static final boolean a(int r100, int r101) {
            if (r101 != (r100 & r101)) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class b {
        public static boolean a() {
            String r100 = Environment.getExternalStorageState();
            if ("mounted".equals(r100) == false) goto L5;
        L8:
            return true;
        L5:
            if ("mounted_ro".equals(r100) == true) goto L8;
            return false;
        }

        public static c b() {
            if (a() == true) goto L7;
            return null;
        L7:
            return c.b(Environment.getExternalStorageDirectory());
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private File f461813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f461814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f461815c;

        public c() {
        }

        public String toString() {
            return String.format("[%s : %d / %d]", new Object[]{a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b())});
        }

        public File a() {
            return this.f461813a;
        }

        public long b() {
            return this.f461814b;
        }

        public long c() {
            return this.f461815c;
        }

        public static c b(File r100) {
            c r101 = new c();
            r101.a(r100);
            StatFs r102 = new StatFs(r100.getAbsolutePath());
            long r103 = r102.getBlockSize();
            long r104 = r102.getBlockCount();
            long r105 = r102.getAvailableBlocks();
            r101.a(r104 * r103);
            r101.b(r105 * r103);
            return r101;
        }

        public void a(long r100) {
            this.f461814b = r100;
        }

        public void a(File r100) {
            this.f461813a = r100;
        }

        public void b(long r100) {
            this.f461815c = r100;
        }
    }

    /* JADX INFO: renamed from: com.tencent.open.log.d$d, reason: collision with other inner class name */
    public static final class C5545d {
        public static SimpleDateFormat a(String r100) {
            return new SimpleDateFormat(r100);
        }
    }

    public static boolean a(Bundle r100) {
        if (r100.containsKey("access_token") == false) goto L5;
    L18:
        return true;
    L5:
        if (r100.containsKey("pay_token") == true) goto L18;
        if (r100.containsKey("pfkey") == true) goto L18;
        if (r100.containsKey("expires_in") == true) goto L18;
        if (r100.containsKey("openid") == true) goto L18;
        if (r100.containsKey("proxy_code") == true) goto L18;
        if (r100.containsKey("proxy_expires_in") == true) goto L18;
        return false;
    }

    public static Bundle b(Bundle r100) {
        if (a(r100) == true) goto L5;
        return r100;
    L5:
        Bundle r101 = new Bundle(r100);
        r101.remove("access_token");
        r101.remove("pay_token");
        r101.remove("pfkey");
        r101.remove("expires_in");
        r101.remove("openid");
        r101.remove("proxy_code");
        r101.remove("proxy_expires_in");
        return r101;
    }

    public static boolean a(String r100) {
        if (r100.contains("access_token") == false) goto L5;
    L18:
        return true;
    L5:
        if (r100.contains("pay_token") == true) goto L18;
        if (r100.contains("pfkey") == true) goto L18;
        if (r100.contains("expires_in") == true) goto L18;
        if (r100.contains("openid") == true) goto L18;
        if (r100.contains("proxy_code") == true) goto L18;
        if (r100.contains("proxy_expires_in") == true) goto L18;
        return false;
    }
}
