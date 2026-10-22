package com.suite.lark.platform.component.deviceperf;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.CarUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class DevicePerfUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f460569a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f460570b;

    public static final enum DevicePerfLevel extends Enum<DevicePerfLevel> {
        public static final DevicePerfLevel HIGH = null;
        public static final DevicePerfLevel LOW = null;
        public static final DevicePerfLevel MIDDLE = null;
        public static final DevicePerfLevel ULTRALOW = null;
        public static final DevicePerfLevel UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DevicePerfLevel[] f460571a = null;
        private final String value;

        static {
            DevicePerfLevel r100 = new DevicePerfLevel("UNKNOWN", 0, "unknown");
            UNKNOWN = r100;
            DevicePerfLevel r101 = new DevicePerfLevel("HIGH", 1, "high");
            HIGH = r101;
            DevicePerfLevel r102 = new DevicePerfLevel("MIDDLE", 2, "middle");
            MIDDLE = r102;
            DevicePerfLevel r103 = new DevicePerfLevel("LOW", 3, "low");
            LOW = r103;
            DevicePerfLevel r104 = new DevicePerfLevel("ULTRALOW", 4, "ultralow");
            ULTRALOW = r104;
            f460571a = new DevicePerfLevel[]{r100, r101, r102, r103, r104};
        }

        public static DevicePerfLevel[] values() {
            return (DevicePerfLevel[]) f460571a.clone();
        }

        public String getValue() {
            return this.value;
        }

        public static DevicePerfLevel fromValue(String r100) {
            r100.getClass();
            byte r101 = -1;
            switch(r100.hashCode()) {
                case -1754211288: goto L14;
                case 107348: goto L10;
                case 3202466: goto L6;
                default: goto L17;
            };
        L17:
            switch(r101) {
                case 0: goto L25;
                case 1: goto L23;
                case 2: goto L21;
                default: goto L19;
            };
        L19:
            return MIDDLE;
        L21:
            return HIGH;
        L23:
            return LOW;
        L25:
            return ULTRALOW;
        L6:
            if (r100.equals("high") == false) goto L17;
            r101 = 2;
            goto L17
        L10:
            if (r100.equals("low") == false) goto L17;
            r101 = 1;
            goto L17
        L14:
            if (r100.equals("ultralow") == false) goto L17;
            r101 = 0;
            goto L17
        }

        public static DevicePerfLevel valueOf(String r100) {
            return (DevicePerfLevel) r27.a.a(DevicePerfLevel.class, r100);
        }

        public DevicePerfLevel(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f460572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f460573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final double f460574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final double f460575d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final double f460576e;

        public final String toString() {
            return "DevicePerfScore{cpuScore=" + this.f460572a + ", gpuScore=" + this.f460573b + ", ioScore=" + this.f460574c + ", memoryScore=" + this.f460575d + ", overallScore=" + this.f460576e + '}';
        }

        public a(double r100, double r101, double r102, double r103, double r104) {
            this.f460572a = r100;
            this.f460573b = r101;
            this.f460574c = r102;
            this.f460575d = r103;
            this.f460576e = r104;
        }
    }

    public static JSONObject b() {
        JSONObject r100 = new JSONObject();
        r100.put("bytebench", c());     // Catch: Exception -> L5
        r100.put("device_perf_level", "middle");     // Catch: Exception -> L5
    L7:
        Log.i("DevicePerfUtils", "createDefaultByteBenchSetting is : " + r100);
        return r100;
    L5:
        e = move-exception;
        Log.w("DevicePerfUtils", "createDefaultByteBenchSetting exception!", e);
        goto L7
    }

    public static JSONObject c() {
        JSONObject r100 = new JSONObject();
        r100.put("cpu_score", 8.0d);     // Catch: Exception -> L5
        r100.put("gpu_score", 8.0d);     // Catch: Exception -> L5
        r100.put("io_score", 8.0d);     // Catch: Exception -> L5
        r100.put("memory_score", 8.0d);     // Catch: Exception -> L5
        r100.put("overall_score", 8.0d);     // Catch: Exception -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        Log.w("DevicePerfUtils", "createDefaultPerfScore exception!", e);
        goto L7
    }

    public static DevicePerfLevel d() {
        String[] r100 = CarUtils.f444655a;
        String r101 = "middle";
        String r102 = eac.a.a().getString("device_perf_level", "middle");
        if (TextUtils.equals(r102, "unknown") == false) goto L14;
        double r103 = e().f460576e;
        if (r103 < 8.3d) goto L8;
        r101 = "high";
    L16:
        return DevicePerfLevel.fromValue(r101);
    L8:
        if (r103 >= 7.3d) goto L16;
        if (r103 < 5.4d) goto L13;
        r101 = "low";
        goto L16
    L13:
        r101 = "ultralow";
        goto L16
    L14:
        r101 = r102;
        goto L16
    }

    public static a e() {
        String r100 = f460569a;
        monitor-enter(r100);
        String[] r101 = CarUtils.f444655a;     // Catch: Throwable -> L22
        String r102 = eac.a.a().getString("bytebench", "");     // Catch: Throwable -> L22
        if (TextUtils.equals(f460569a, r102) == true) goto L11;
        f460569a = r102;     // Catch: Throwable -> L22
        JSONObject r103 = new JSONObject(f460569a);     // Catch: Exception -> L9 Throwable -> L22
        f460570b = new a(r103.getDouble("cpu_score"), r103.getDouble("gpu_score"), r103.getDouble("io_score"), r103.getDouble("memory_score"), r103.getDouble("overall_score"));     // Catch: Exception -> L9 Throwable -> L22
    L9:
        e = move-exception;
        Log.e("DevicePerfUtils", "byte bench parse error!!", e, true);     // Catch: Throwable -> L22
    L11:
        a r104 = f460570b;     // Catch: Throwable -> L22
        if (r104 != null) goto L14;
    L15:
        JSONObject r105 = c();     // Catch: Throwable -> L22
        if (r105.length() <= 0) goto L18;
        eac.a.a().putString("bytebench", r105.toString());     // Catch: Throwable -> L22
        f460569a = r105.toString();     // Catch: Throwable -> L22
    L18:
        Log.i("DevicePerfUtils", "Local cal device score user default cpuScoreInLocal:8.0 memoryScoreInLocal:8.0 totalScoreLocal: 8.0");     // Catch: Throwable -> L22
        f460570b = new a(8.0d, 8.0d, 8.0d, 8.0d, 8.0d);     // Catch: Throwable -> L22
    L19:
        a r106 = f460570b;     // Catch: Throwable -> L22
        monitor-exit(r100);     // Catch: Throwable -> L22
        return r106;
    L14:
        if (r104.f460576e > AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
    L22:
        th = move-exception;
        throw th;
    }

    public static boolean f() {
        if (d().ordinal() < DevicePerfLevel.LOW.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(JSONObject r100) {
        boolean r101 = false;
        String r102 = (String) r100.get("device_perf_level");     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return false;
    L6:
        JSONObject r103 = (JSONObject) r100.get("bytebench");     // Catch: Exception -> L14
        if (r103 != null) goto L9;
    L13:
        r101 = true;
    L16:
        Log.i("DevicePerfUtils", "checkSetting is : " + r101);
        return r101;
    L9:
        if (JSONObjectProtectorUtils.getDouble(r103, "overall_score") != AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        if (r102.contains("low") == false) goto L13;
    L14:
        e = move-exception;
        Log.w("DevicePerfUtils", "checkSetts exception!", e);
        goto L16
    }
}
