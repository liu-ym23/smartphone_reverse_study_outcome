package com.ss.ugc.effectplatform.util;

import android.util.SparseArray;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class GPUUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, float[]> f458011a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseArray<float[]> f458012b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f458013c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f458014d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f458015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f458016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f458017c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f458018d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f458019e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f458020f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public double f458021g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f458022h;

        public final String toString() {
            return "GPUInfo{renderer='" + this.f458015a + "', version='" + this.f458016b + "', vendor='" + this.f458017c + "', maxFreq=" + this.f458018d + ", minFreq=" + this.f458019e + ", glVer=" + this.f458020f + ", alusOrThroughput=" + this.f458021g + com.alipay.sdk.m.u.i.f25855d;
        }

        public a() {
            this.f458015a = "unknown";
            this.f458016b = "unknown";
            this.f458017c = "unknown";
            this.f458020f = -1;
            this.f458021g = -1.0d;
            this.f458022h = "unknown";
        }
    }

    static {
        HashMap<String, float[]> r100 = new HashMap();
        f458011a = r100;
        SparseArray<float[]> r101 = new SparseArray();
        f458012b = r101;
        f458013c = PatternProtector.compile("\\d+$");
        f458014d = LazyKt.lazy(GPUUtils$gpuInfo$2.INSTANCE);
        r100.put("mali-g72", new float[]{850.0f, 850.0f, 27.2f});
        r100.put("mali-g71", new float[]{850.0f, 850.0f, 27.2f});
        r100.put("mali-t880", new float[]{850.0f, 850.0f, 13.6f});
        r100.put("mali-t860", new float[]{650.0f, 650.0f, 10.4f});
        r100.put("mali-t760", new float[]{650.0f, 650.0f, 10.4f});
        r100.put("mali-g51", new float[]{650.0f, 650.0f, 3.9f});
        r100.put("mali-t830", new float[]{650.0f, 650.0f, 2.6f});
        r100.put("mali-t820", new float[]{650.0f, 650.0f, 2.6f});
        r100.put("mali-t720", new float[]{650.0f, 650.0f, 5.2f});
        r100.put("mali-t470", new float[]{250.0f, 650.0f, 0.65f});
        r100.put("mali-t450", new float[]{270.0f, 650.0f, 5.2f});
        r100.put("mali-t400", new float[]{210.0f, 500.0f, 2.0f});
        r100.put("mali-400 mp", new float[]{210.0f, 500.0f, 2.0f});
        r100.put("mali-450 mp", new float[]{210.0f, 500.0f, 2.6f});
        r101.put(200, new float[]{200.0f, 245.0f, 8.0f});
        r101.put(203, new float[]{245.0f, 294.0f, 16.0f});
        r101.put(205, new float[]{225.0f, 245.0f, 16.0f});
        r101.put(220, new float[]{266.0f, 266.0f, 32.0f});
        r101.put(225, new float[]{400.0f, 400.0f, 32.0f});
        r101.put(302, new float[]{400.0f, 400.0f, 24.0f});
        r101.put(304, new float[]{400.0f, 400.0f, 24.0f});
        r101.put(305, new float[]{400.0f, 450.0f, 24.0f});
        r101.put(306, new float[]{400.0f, 400.0f, 24.0f});
        r101.put(308, new float[]{500.0f, 500.0f, 24.0f});
        r101.put(320, new float[]{450.0f, 450.0f, 96.0f});
        r101.put(330, new float[]{578.0f, 578.0f, 128.0f});
        r101.put(405, new float[]{550.0f, 550.0f, 48.0f});
        r101.put(418, new float[]{600.0f, 600.0f, 128.0f});
        r101.put(420, new float[]{600.0f, 600.0f, 128.0f});
        r101.put(430, new float[]{500.0f, 650.0f, 192.0f});
        r101.put(505, new float[]{450.0f, 450.0f, 48.0f});
        r101.put(506, new float[]{650.0f, 650.0f, 96.0f});
        r101.put(508, new float[]{850.0f, 850.0f, 96.0f});
        r101.put(510, new float[]{600.0f, 600.0f, 128.0f});
        r101.put(512, new float[]{600.0f, 850.0f, 128.0f});
        r101.put(530, new float[]{650.0f, 650.0f, 256.0f});
        r101.put(540, new float[]{710.0f, 710.0f, 256.0f});
    }

    public static int a(String r100) {
        Matcher r101 = f458013c.matcher(r100);
        if (r101.find() == false) goto L9;
        boolean r102 = false;
        String r103 = r101.group(0);
        if (r103.length() <= 0) goto L7;
        r102 = true;
    L7:
        if (r102 == false) goto L9;
        return CastIntegerProtector.parseInt(r103);
    L9:
        return -1;
    }

    public static double b(String r100) {
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L17;
        float[] r102 = null;
        if (StringsKt.startsWith$default(r100.toLowerCase(), "mali", false, 2, null) == false) goto L11;
        r102 = f458011a.get(r100);
    L13:
        if (r102 == null) goto L17;
        return r102[2];
    L11:
        if (StringsKt.contains$default(r100.toLowerCase(), "adreno", false, 2, null) == false) goto L13;
        r102 = f458012b.get(a(r100));
    L17:
        return -1;
    L5:
        r101 = false;
        goto L6
    }

    public static int c(String r110, String r111) {
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        int r101 = -1;
        if (r100 == false) goto L9;
        return -1;
    L9:
        BufferedReader r102 = null;
        if (StringsKt.startsWith$default(r110.toLowerCase(), "mali", false, 2, null) == false) goto L19;
        float[] r112 = f458011a.get(r110);
        if (r112 != null) goto L14;
        return 850;
    L14:
        if (Intrinsics.areEqual(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, r111) == false) goto L16;
        float r113 = r112[0];
    L25:
        int r114 = (int) r113;
    L101:
        return r114;
    L16:
        r113 = r112[1];
        goto L25
    L19:
        if (StringsKt.startsWith$default(r110.toLowerCase(), "adreno", false, 2, null) == false) goto L100;
        int r115 = a(r110);
        if (r115 <= 0) goto L27;
        float[] r103 = f458012b.get(r115);
        if (r103 == null) goto L27;
        r113 = r103[1];
    L27:
        File[] r104 = new PolarisFileWrapper("/sys/class/devfreq/").listFiles(j.f458039a);
        if (r104 != null) goto L30;
    L36:
        boolean r105 = true;
    L37:
        if (r105 == false) goto L39;
        r114 = r115 + 200;
        goto L101
    L39:
        int r116 = r104.length;
        int r106 = 0;
    L40:
        if (r106 >= r116) goto L104;
        BufferedReader r107 = new BufferedReader(new PolarisFileReaderWrapper(new PolarisFileWrapper(r104[r106], r111.concat("_freq"))));     // Catch: Throwable -> L65 Exception -> L69
    L85:
        String r108 = r107.readLine();     // Catch: Throwable -> L62 Exception -> L64
        int r109 = r108.length() - 1;     // Catch: Throwable -> L62 Exception -> L64
        int r117 = 0;
        boolean r118 = false;
    L44:
        if (r117 > r109) goto L59;
        if (r118 == true) goto L47;
        int r119 = r117;
    L49:
        if (r108.charAt(r119) > ' ') goto L51;
        boolean r120 = true;
    L52:
        if (r118 == false) goto L53;
        if (r120 == false) goto L59;
        r109 = r109 - 1;     // Catch: Throwable -> L62 Exception -> L64
        goto L44
    L53:
        if (r120 == false) goto L54;
        r117 = r117 + 1;     // Catch: Throwable -> L62 Exception -> L64
        goto L44
    L54:
        r118 = true;
        goto L44
    L51:
        r120 = false;
        goto L52
    L47:
        r119 = r109;
    L59:
        int r121 = Integer.parseInt(r108.subSequence(r117, r109 + 1).toString()) / 1000000;     // Catch: Throwable -> L62 Exception -> L64
        r107.close();     // Catch: IOException -> L74
        return r121;
    L103:
        return r121;
    L62:
        th = th;
        r102 = r107;
    L66:
        if (r102 != null) goto L77;
    L68:
        throw th;
    L77:
        r102.close();     // Catch: IOException -> L75
    L70:
        if (r107 == null) goto L72;
        r107.close();     // Catch: IOException -> L76
    L72:
        r106 = r106 + 1;
    L69:
        r107 = null;
    L65:
        th = th;
        goto L66
    L104:
        return r101;
    L30:
        if (r104.length != 0) goto L32;
        boolean r122 = true;
    L33:
        if (r122 == true) goto L36;
        r105 = false;
        goto L37
    L32:
        r122 = false;
        goto L33
    L100:
        return -1;
    L5:
        r100 = false;
        goto L6
    }
}
