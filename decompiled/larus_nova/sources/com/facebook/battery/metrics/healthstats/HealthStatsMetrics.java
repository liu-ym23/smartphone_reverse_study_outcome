package com.facebook.battery.metrics.healthstats;

import android.os.health.HealthStats;
import android.os.health.PackageHealthStats;
import android.os.health.PidHealthStats;
import android.os.health.ProcessHealthStats;
import android.os.health.ServiceHealthStats;
import android.os.health.TimerStat;
import android.os.health.UidHealthStats;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.facebook.battery.metrics.core.SystemMetrics;
import com.facebook.battery.metrics.core.SystemMetricsLogger;
import com.facebook.battery.metrics.core.Utilities;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class HealthStatsMetrics extends SystemMetrics<HealthStatsMetrics> {
    static final int OP_DIFF = -1;
    static final int OP_SUM = 1;
    private static final String TAG = "HealthStatsMetrics";
    private static final SparseArray<String> sKeyNames = null;
    public String dataType;
    final SparseArray<Long> measurement;
    final SparseArray<ArrayMap<String, Long>> measurements;
    final SparseArray<ArrayMap<String, HealthStatsMetrics>> stats;
    final SparseArray<TimerMetrics> timer;
    final SparseArray<ArrayMap<String, TimerMetrics>> timers;

    public static class TimerMetrics {
        public int count;
        public long timeMs;

        public TimerMetrics() {
        }

        public int hashCode() {
            int r100 = this.count * 31;
            long r101 = this.timeMs;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public TimerMetrics(TimerStat r100) {
            this.count = r100.getCount();
            this.timeMs = r100.getTime();
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L18:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L18;
            TimerMetrics r101 = (TimerMetrics) r100;
            if (this.count == r101.count) goto L14;
            return false;
        L14:
            if (this.timeMs == r101.timeMs) goto L19;
            return false;
        L19:
            return true;
        }

        public TimerMetrics(TimerMetrics r100) {
            this.count = r100.count;
            this.timeMs = r100.timeMs;
        }

        public TimerMetrics(int r100, long r101) {
            this.count = r100;
            this.timeMs = r101;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sKeyNames = new SparseArray();
    }

    private static void readKeyNames() {
        Class[] r100 = {UidHealthStats.class, PidHealthStats.class, ProcessHealthStats.class, PackageHealthStats.class, ServiceHealthStats.class};     // Catch: ClassNotFoundException -> L13 IllegalAccessException -> L15
        Class<? extends Annotation> r101 = INVOKESTATIC_com_facebook_battery_metrics_healthstats_HealthStatsMetrics_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.health.HealthKeys$Constant");     // Catch: ClassNotFoundException -> L13 IllegalAccessException -> L15
        int r102 = 0;
    L4:
        if (r102 >= 5) goto L12;
        Field[] r103 = r100[r102].getFields();     // Catch: ClassNotFoundException -> L13 IllegalAccessException -> L15
        int r104 = r103.length;     // Catch: ClassNotFoundException -> L13 IllegalAccessException -> L15
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L11;
        Field r106 = r103[r105];     // Catch: ClassNotFoundException -> L13 IllegalAccessException -> L15
        if (r106.isAnnotationPresent(r101) == false) goto L10;
        sKeyNames.put(r106.getInt(null), r106.getName());     // Catch: ClassNotFoundException -> L13 IllegalAccessException -> L15
    L10:
        r105 = r105 + 1;
        goto L6
    L11:
        r102 = r102 + 1;
        goto L4
    L12:
        return;
    L13:
        e = move-exception;
        SystemMetricsLogger.wtf(TAG, "Unable to find constant annotation", e);
    L17:
        sKeyNames.put(-1, "Unable to read");
        return;
    L15:
        e = move-exception;
        SystemMetricsLogger.wtf(TAG, "Unable to read constant names", e);
        goto L17
    }

    public int hashCode() {
        String r100 = this.dataType;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((((((r101 * 31) + this.measurement.hashCode()) * 31) + this.timer.hashCode()) * 31) + this.measurements.hashCode()) * 31) + this.timers.hashCode()) * 31) + this.stats.hashCode();
    L5:
        r101 = 0;
        goto L7
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject r100 = new JSONObject();
        r100.put("type", this.dataType);
        int r101 = this.measurement.size();
        int r102 = 0;
        if (r101 <= 0) goto L8;
        JSONObject r103 = new JSONObject();
        int r104 = 0;
    L5:
        if (r104 >= r101) goto L7;
        r103.put(getKeyName(this.measurement.keyAt(r104)), this.measurement.valueAt(r104));
        r104 = r104 + 1;
        goto L5
    L7:
        r100.put("measurement", r103);
    L8:
        int r105 = this.timer.size();
        if (r105 <= 0) goto L14;
        JSONObject r106 = new JSONObject();
        int r107 = 0;
    L11:
        if (r107 >= r105) goto L13;
        r106.put(getKeyName(this.timer.keyAt(r107)), new JSONObject().put("count", this.timer.valueAt(r107).count).put("time_ms", this.timer.valueAt(r107).timeMs));
        r107 = r107 + 1;
        goto L11
    L13:
        r100.put(UploadTypeInf.TIMER, r106);
    L14:
        int r108 = this.measurements.size();
        if (r108 <= 0) goto L20;
        JSONObject r109 = new JSONObject();
        int r110 = 0;
    L17:
        if (r110 >= r108) goto L19;
        r109.put(getKeyName(this.measurements.keyAt(r110)), toJSONObject(this.measurements.valueAt(r110)));
        r110 = r110 + 1;
        goto L17
    L19:
        r100.put("measurements", r109);
    L20:
        int r111 = this.timers.size();
        if (r111 <= 0) goto L26;
        JSONObject r112 = new JSONObject();
        int r113 = 0;
    L23:
        if (r113 >= r111) goto L25;
        r112.put(getKeyName(this.timers.keyAt(r113)), toJSONObject(this.timers.valueAt(r113)));
        r113 = r113 + 1;
        goto L23
    L25:
        r100.put("timers", r112);
    L26:
        int r114 = this.stats.size();
        if (r114 <= 0) goto L32;
        JSONObject r115 = new JSONObject();
    L29:
        if (r102 >= r114) goto L31;
        r115.put(getKeyName(this.stats.keyAt(r102)), toJSONObject(this.stats.valueAt(r102)));
        r102 = r102 + 1;
        goto L29
    L31:
        r100.put("stats", r115);
    L32:
        return r100;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("HealthStatsMetrics {\n");
        r100.append(toJSONObject().toString(2));     // Catch: JSONException -> L5
    L6:
        r100.append("\n}");
        return r100.toString();
    L5:
        r100.append("<error>");
        goto L6
    }

    public HealthStatsMetrics() {
        this.measurement = new SparseArray();
        this.timer = new SparseArray();
        this.measurements = new SparseArray();
        this.timers = new SparseArray();
        this.stats = new SparseArray();
    }

    public HealthStatsMetrics(HealthStats r100) {
        this.measurement = new SparseArray();
        this.timer = new SparseArray();
        this.measurements = new SparseArray();
        this.timers = new SparseArray();
        this.stats = new SparseArray();
        set(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_facebook_battery_metrics_healthstats_HealthStatsMetrics_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static String getKeyName(int r100) {
        SparseArray<String> r101 = sKeyNames;
        if (r101.size() != 0) goto L6;
        readKeyNames();
    L6:
        return r101.get(r100, "Unknown");
    }

    private static <V> JSONObject toJSONObject(ArrayMap<String, V> r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        int r102 = 0;
        if (r100 != null) goto L5;
        int r103 = 0;
    L6:
        if (r102 >= r103) goto L15;
        V r104 = r100.valueAt(r102);
        if ((r104 instanceof TimerMetrics) == false) goto L11;
        TimerMetrics r105 = (TimerMetrics) r104;
        r101.put(r100.keyAt(r102), new JSONObject().put("count", r105.count).put("time_ms", r105.timeMs));
    L14:
        r102 = r102 + 1;
        goto L6
    L11:
        if ((r104 instanceof HealthStatsMetrics) == false) goto L13;
        r101.put(r100.keyAt(r102), ((HealthStatsMetrics) r104).toJSONObject());
        goto L14
    L13:
        r101.put(r100.keyAt(r102), r100.valueAt(r102));
        goto L14
    L15:
        return r101;
    L5:
        r103 = r100.size();
        goto L6
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L31:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L31;
        HealthStatsMetrics r101 = (HealthStatsMetrics) r100;
        String r102 = this.dataType;
        if (r102 == null) goto L16;
        if (r102.equals(r101.dataType) == true) goto L19;
    L17:
        return false;
    L19:
        if (Utilities.sparseArrayEquals(this.measurement, r101.measurement) == true) goto L21;
    L29:
        return false;
    L21:
        if (Utilities.sparseArrayEquals(this.measurements, r101.measurements) == false) goto L29;
        if (Utilities.sparseArrayEquals(this.timer, r101.timer) == false) goto L29;
        if (Utilities.sparseArrayEquals(this.timers, r101.timers) == false) goto L29;
        if (Utilities.sparseArrayEquals(this.stats, r101.stats) == false) goto L29;
        return true;
    L16:
        if (r101.dataType == null) goto L19;
        goto L17
    }

    public HealthStatsMetrics set(HealthStats r100) {
        this.dataType = r100.getDataType();
        this.measurement.clear();
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= r100.getMeasurementKeyCount()) goto L6;
        int r103 = r100.getMeasurementKeyAt(r102);
        this.measurement.put(r103, Long.valueOf(r100.getMeasurement(r103)));
        r102 = r102 + 1;
        goto L4
    L6:
        this.measurements.clear();
        int r104 = 0;
    L8:
        if (r104 >= r100.getMeasurementsKeyCount()) goto L14;
        int r105 = r100.getMeasurementsKeyAt(r104);
        ArrayMap<String, Long> r106 = new ArrayMap();
        Iterator<Map.Entry<String, Long>> r107 = r100.getMeasurements(r105).entrySet().iterator();
    L11:
        if (r107.hasNext() == false) goto L13;
        Map.Entry<String, Long> r108 = r107.next();
        r106.put(r108.getKey(), r108.getValue());
        goto L11
    L13:
        this.measurements.put(r105, r106);
        r104 = r104 + 1;
        goto L8
    L14:
        this.timer.clear();
        int r109 = 0;
    L16:
        if (r109 >= r100.getTimerKeyCount()) goto L18;
        int r110 = r100.getTimerKeyAt(r109);
        TimerMetrics r111 = new TimerMetrics(r100.getTimerCount(r110), r100.getTimerTime(r110));
        this.timer.put(r110, r111);
        r109 = r109 + 1;
        goto L16
    L18:
        this.timers.clear();
        int r112 = 0;
    L20:
        if (r112 >= r100.getTimersKeyCount()) goto L26;
        int r113 = r100.getTimersKeyAt(r112);
        ArrayMap<String, TimerMetrics> r114 = new ArrayMap();
        Iterator<Map.Entry<String, TimerStat>> r115 = r100.getTimers(r113).entrySet().iterator();
    L23:
        if (r115.hasNext() == false) goto L25;
        Map.Entry<String, TimerStat> r116 = r115.next();
        r114.put(r116.getKey(), new TimerMetrics(r116.getValue()));
        goto L23
    L25:
        this.timers.put(r113, r114);
        r112 = r112 + 1;
        goto L20
    L26:
        this.stats.clear();
    L28:
        if (r101 >= r100.getStatsKeyCount()) goto L34;
        int r117 = r100.getStatsKeyAt(r101);
        ArrayMap<String, HealthStatsMetrics> r118 = new ArrayMap();
        Iterator<Map.Entry<String, HealthStats>> r119 = r100.getStats(r117).entrySet().iterator();
    L31:
        if (r119.hasNext() == false) goto L33;
        Map.Entry<String, HealthStats> r120 = r119.next();
        r118.put(r120.getKey(), new HealthStatsMetrics(r120.getValue()));
        goto L31
    L33:
        this.stats.put(r117, r118);
        r101 = r101 + 1;
        goto L28
    L34:
        return this;
    }

    public HealthStatsMetrics(HealthStatsMetrics r100) {
        this.measurement = new SparseArray();
        this.timer = new SparseArray();
        this.measurements = new SparseArray();
        this.timers = new SparseArray();
        this.stats = new SparseArray();
        set(r100);
    }

    public HealthStatsMetrics set(HealthStatsMetrics r100) {
        this.dataType = r100.dataType;
        this.measurement.clear();
        int r101 = 0;
    L4:
        if (r101 >= r100.measurement.size()) goto L6;
        this.measurement.append(r100.measurement.keyAt(r101), r100.measurement.valueAt(r101));
        r101 = r101 + 1;
        goto L4
    L6:
        this.timer.clear();
        int r102 = 0;
    L8:
        if (r102 >= r100.timer.size()) goto L10;
        this.timer.append(r100.timer.keyAt(r102), new TimerMetrics(r100.timer.valueAt(r102)));
        r102 = r102 + 1;
        goto L8
    L10:
        this.measurements.clear();
        int r103 = 0;
    L12:
        if (r103 >= r100.measurements.size()) goto L14;
        ArrayMap<String, Long> r104 = new ArrayMap();
        r104.putAll(r100.measurements.valueAt(r103));
        this.measurements.append(r100.measurements.keyAt(r103), r104);
        r103 = r103 + 1;
        goto L12
    L14:
        this.timers.clear();
        int r105 = 0;
    L16:
        if (r105 >= r100.timers.size()) goto L22;
        ArrayMap<String, TimerMetrics> r106 = r100.timers.valueAt(r105);
        ArrayMap<String, TimerMetrics> r107 = new ArrayMap();
        int r108 = 0;
    L19:
        if (r108 >= r106.size()) goto L21;
        r107.put(r106.keyAt(r108), new TimerMetrics(r106.valueAt(r108)));
        r108 = r108 + 1;
        goto L19
    L21:
        this.timers.append(r100.timers.keyAt(r105), r107);
        r105 = r105 + 1;
        goto L16
    L22:
        this.stats.clear();
        int r109 = 0;
    L24:
        if (r109 >= r100.stats.size()) goto L30;
        ArrayMap<String, HealthStatsMetrics> r110 = r100.stats.valueAt(r109);
        ArrayMap<String, HealthStatsMetrics> r111 = new ArrayMap();
        int r112 = 0;
    L27:
        if (r112 >= r110.size()) goto L29;
        r111.put(r110.keyAt(r112), new HealthStatsMetrics(r110.valueAt(r112)));
        r112 = r112 + 1;
        goto L27
    L29:
        this.stats.append(r100.stats.keyAt(r109), r111);
        r109 = r109 + 1;
        goto L24
    L30:
        return this;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics set(SystemMetrics r100) {
        return set((HealthStatsMetrics) r100);
    }

    private static long compareSnapshotAge(HealthStatsMetrics r100, HealthStatsMetrics r101) {
        return r100.measurement.get(10001, 0L).longValue() - r101.measurement.get(10001, 0L).longValue();
    }

    private static boolean strEquals(String r100, String r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r100.equals(r101);
    }

    public HealthStatsMetrics diff(HealthStatsMetrics r100, HealthStatsMetrics r101) {
        if (r101 != null) goto L4;
        r101 = new HealthStatsMetrics();
    L4:
        r101.dataType = this.dataType;
        if (r100 != null) goto L7;
    L14:
        r101.set(this);
    L15:
        return r101;
    L7:
        if (compareSnapshotAge(this, r100) < 0) goto L14;
        if (strEquals(r100.dataType, this.dataType) == false) goto L13;
        op(-1, this.measurement, r100.measurement, r101.measurement);
        op(-1, this.measurements, r100.measurements, r101.measurements);
        op(-1, this.timer, r100.timer, r101.timer);
        op(-1, this.timers, r100.timers, r101.timers);
        op(-1, this.stats, r100.stats, r101.stats);
        goto L15
    L13:
        throw new IllegalArgumentException("Attempting to subtract different types of HealthStatMetrics: " + this.dataType + " and " + r100.dataType);
    }

    public HealthStatsMetrics sum(HealthStatsMetrics r100, HealthStatsMetrics r101) {
        if (r101 != null) goto L4;
        r101 = new HealthStatsMetrics();
    L4:
        r101.dataType = this.dataType;
        if (r100 != null) goto L8;
        r101.set(this);
    L10:
        return r101;
    L8:
        if (strEquals(r100.dataType, this.dataType) == false) goto L12;
        op(1, this.measurement, r100.measurement, r101.measurement);
        op(1, this.measurements, r100.measurements, r101.measurements);
        op(1, this.timer, r100.timer, r101.timer);
        op(1, this.timers, r100.timers, r101.timers);
        op(1, this.stats, r100.stats, r101.stats);
        goto L10
    L12:
        throw new IllegalArgumentException("Attempting to add different types of HealthStatMetrics: " + this.dataType + " and " + r100.dataType);
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics diff(SystemMetrics r100, SystemMetrics r101) {
        return diff((HealthStatsMetrics) r100, (HealthStatsMetrics) r101);
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics sum(SystemMetrics r100, SystemMetrics r101) {
        return sum((HealthStatsMetrics) r100, (HealthStatsMetrics) r101);
    }

    public static <K, V> ArrayMap<K, V> opArrayMaps(int r100, ArrayMap<K, V> r101, ArrayMap<K, V> r102) {
        int r103 = r101.size();
        ArrayMap<K, V> r104 = new ArrayMap();
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r106 >= r103) goto L13;
        K r107 = r101.keyAt(r106);
        if (r102 != null) goto L7;
        V r108 = null;
    L8:
        if (r108 != null) goto L10;
        V r109 = r101.valueAt(r106);
    L11:
        r104.put(r107, r109);
        r106 = r106 + 1;
        goto L3
    L10:
        r109 = (V) opValues(r100, r101.valueAt(r106), r108);
        goto L11
    L7:
        r108 = r102.get(r107);
        goto L8
    L13:
        if (r100 != 1) goto L22;
        if (r102 != null) goto L16;
        int r110 = 0;
    L17:
        if (r105 >= r110) goto L22;
        K r111 = r102.keyAt(r105);
        if (r101.get(r111) != null) goto L21;
        r104.put(r111, r102.valueAt(r105));
    L21:
        r105 = r105 + 1;
        goto L17
    L16:
        r110 = r102.size();
    L22:
        return r104;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <V> Object opValues(int r100, V r101, V r102) {
        if ((r101 instanceof Long) == false) goto L11;
        long r103 = ((Long) r101).longValue();
        if (r102 != 0) goto L7;
        long r104 = 0;
    L9:
        return Long.valueOf(r103 + r104);
    L7:
        r104 = ((long) r100) * ((Long) r102).longValue();
        goto L9
    L11:
        if ((r101 instanceof TimerMetrics) == false) goto L19;
        TimerMetrics r105 = (TimerMetrics) r101;
        TimerMetrics r106 = (TimerMetrics) r102;
        if (r102 == 0) goto L15;
        TimerMetrics r107 = new TimerMetrics();
        r107.count = r105.count + (r106.count * r100);
        r107.timeMs = r105.timeMs + (((long) r100) * r106.timeMs);
        return r107;
    L15:
        return new TimerMetrics(r105);
    L19:
        if ((r101 instanceof HealthStatsMetrics) == false) goto L27;
        if (r100 != 1) goto L25;
        return ((HealthStatsMetrics) r101).sum((HealthStatsMetrics) r102, null);
    L25:
        return ((HealthStatsMetrics) r101).diff((HealthStatsMetrics) r102, null);
    L27:
        if ((r101 instanceof ArrayMap) == false) goto L31;
        return opArrayMaps(r100, (ArrayMap) r101, (ArrayMap) r102);
    L31:
        throw new IllegalArgumentException("Handling unsupported values");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K> SparseArray<K> op(int r100, SparseArray<K> r101, SparseArray<K> r102, SparseArray<K> r103) {
        r103.clear();
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r105 >= r101.size()) goto L7;
        int r106 = r101.keyAt(r105);
        r103.put(r106, opValues(r100, r101.valueAt(r105), r102.get(r106)));
        r105 = r105 + 1;
        goto L4
    L7:
        if (r100 == 1) goto L9;
    L14:
        return r103;
    L9:
        if (r104 >= r102.size()) goto L14;
        int r107 = r102.keyAt(r104);
        if (r101.get(r107) != null) goto L13;
        r103.put(r107, r102.valueAt(r104));
    L13:
        r104 = r104 + 1;
        goto L9
    }
}
