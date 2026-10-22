package android.ss.com.vboost.h;

import android.ss.com.vboost.utils.LogUtil;
import android.ss.com.vboost.utils.RomUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f76a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f77b;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f78a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f79b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f80c = null;
        public static final a d = null;
        public static final a e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f81f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ a[] f82g = null;

        static {
            a r0 = new a("UNINITED", 0, 0);
            f78a = r0;
            a r1 = new a("QCOM", 1, 1);
            f79b = r1;
            a r3 = new a("MTK", 2, 2);
            f80c = r3;
            a r5 = new a("CHRY", 3, 3);
            d = r5;
            a r7 = new a("SAMSUNG", 4, 4);
            e = r7;
            a r9 = new a("UNKNOWN", 5, 5);
            f81f = r9;
            f82g = new a[]{r0, r1, r3, r5, r7, r9};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) r27.a.a(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f82g.clone();
        }
    }

    static {
        f77b = a.f78a;
    }

    public static int a() {
        int r0 = Runtime.getRuntime().availableProcessors();
        RandomAccessFile r2 = new RandomAccessFile("/sys/devices/system/cpu/possible", "r");     // Catch: Throwable -> L9 IOException -> L11
        String r1 = r2.readLine();     // Catch: Throwable -> L9 IOException -> L11
        r2.close();     // Catch: Throwable -> L9 IOException -> L11
        if (r1 == null) goto L13;
        String[] r3 = r1.split("-");     // Catch: Throwable -> L9 IOException -> L11
        if (r3.length != 2) goto L13;
        r0 = CastIntegerProtector.parseInt(r3[1]) + 1;
    L13:
        if (r0 > 0) goto L18;
        return 8;
    L18:
        return r0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static int a(int r2) {
        return a("/sys/devices/system/cpu/cpu" + r2 + "/cpufreq/cpuinfo_max_freq");
    }

    private static int a(String r2) {
        if (r2 != null) goto L11;
    L9:
        return -1;
    L11:
        RandomAccessFile r0 = new RandomAccessFile(r2, "r");     // Catch: Throwable -> L5 IOException -> L7
        String r3 = r0.readLine();     // Catch: Throwable -> L5 IOException -> L7
        r0.close();     // Catch: Throwable -> L5 IOException -> L7
        return CastIntegerProtector.parseInt(r3);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static a b() {
        if (f77b != a.f78a) goto L5;
        String r0 = RomUtils.getSystemProperty("ro.hardware");
        if (r0 != null) goto L10;
    L8:
        a r1 = a.f81f;
    L34:
        f77b = r1;
        LogUtil.debug(f76a, "hardware platform type: " + r1);
        return r1;
    L10:
        if (r0.startsWith("qcom") == false) goto L12;
    L33:
        r1 = a.f79b;
        goto L34
    L12:
        if (r0.startsWith("msm") == true) goto L33;
        if (r0.startsWith("qsc") == true) goto L33;
        if (r0.startsWith("sdm") == true) goto L33;
        if (r0.startsWith("mt") == false) goto L22;
        r1 = a.f80c;
        goto L34
    L22:
        if (r0.startsWith("kirin") == false) goto L24;
    L32:
        r1 = a.d;
        goto L34
    L24:
        if (r0.startsWith("hi") == true) goto L32;
        String r2 = RomUtils.getSystemProperty("ro.hardware.egl");
        if (r2 != null) goto L29;
    L31:
        LogUtil.warn(f76a, "Unknown hardware platform!");
        goto L8
    L29:
        if (r2.toLowerCase().equals("adreno") == false) goto L31;
    L5:
        return f77b;
    }

    public static int c() {
        File[] r0 = new File("/sys/devices/system/cpu/cpufreq").listFiles();
        int r1 = 2;
        if (r0 != null) goto L5;
    L15:
        LogUtil.debug(f76a, "number of cluster:" + r1);
        return r1;
    L5:
        if (r0.length <= 0) goto L15;
        int r2 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r2) goto L12;
        if (r0[r3].getName().startsWith("policy") == false) goto L11;
        r4 = r4 + 1;
    L11:
        r3 = r3 + 1;
        goto L7
    L12:
        if (r4 == 0) goto L15;
        r1 = r4;
        goto L15
    }
}
