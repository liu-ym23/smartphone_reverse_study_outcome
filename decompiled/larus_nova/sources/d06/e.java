package d06;

import androidx.camera.video.AudioStats;
import com.bytedance.helios.api.config.ApiSampleRateConfig;
import com.bytedance.helios.api.config.DefaultSampleRateConfig;
import com.bytedance.helios.api.config.ResourceSampleRateConfig;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.helios.sdk.HeliosEnvImpl;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import gz5.w;
import gz5.y;
import hz5.k;
import hz5.l;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import jz5.h;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements gz5.a.InterfaceC6085a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Calendar f466214a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f466215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, a> f466216c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Integer, a> f466217d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f466218e = null;

    public e() {
    }

    static {
        f466218e = new e();
        f466214a = Calendar.getInstance();
        f466216c = new LinkedHashMap();
        f466217d = new LinkedHashMap();
    }

    public final String c() {
        fz5.b.InterfaceC5970b r100 = HeliosEnvImpl.get().f245459b;
        String r101 = "";
        if (r100 != null) goto L5;
        String r102 = "";
    L6:
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
    L17:
        h r104 = e06.d.f470643a;
        h r105 = e06.d.f470643a;
        if (r105 == null) goto L23;
        String r106 = r105.getString("random_device_id", "");
        if (r106 == null) goto L23;
        r101 = r106;
    L23:
        if (StringsKt.isBlank(r101) == false) goto L28;
        r101 = UUID.randomUUID().toString();
        if (r105 == null) goto L28;
        r105.putString("random_device_id", r101);
    L28:
        return r101;
    L14:
        if (Intrinsics.areEqual(r102, "0") == true) goto L17;
        if (Intrinsics.areEqual(r102, "-1") == true) goto L17;
        return r102;
    L8:
        if (StringsKt.isBlank(r102) == true) goto L11;
        r103 = false;
        goto L12
    L5:
        r102 = r100.getDeviceId();
        goto L6
    }

    public static boolean d(double r100) {
        if (r100 > 0) goto L6;
        return false;
    L6:
        if (r100 < 1) goto L9;
    L10:
        return true;
    L9:
        if (Random.Default.nextDouble(AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d) < r100) goto L10;
        return false;
    }

    @Override // gz5.a.InterfaceC6085a
    public final void onNewSettings(y r210) {
        w r100 = r210.y();
        String r101 = c();
        StringBuilder r102 = new StringBuilder();
        Calendar r103 = f466214a;
        r102.append(r103.get(1));
        r102.append('-');
        r102.append(r103.get(2) + 1);
        r102.append('-');
        r102.append(r103.get(5));
        String r104 = r102.toString();
        h r105 = e06.d.f470643a;
        h r106 = e06.d.f470643a;
        String r107 = "";
        if (r106 == null) goto L7;
        String r108 = r106.getString("sample_rate_date", "");
        if (r108 == null) goto L7;
        r107 = r108;
    L7:
        if (r101 != null) goto L9;
        byte[] r109 = null;
    L10:
        if (r109 == null) goto L80;
        long r110 = Math.abs(b.a(r109));
        DefaultSampleRateConfig r111 = r100.e();
        f466215b = new c(b(r110, r100.c()), b(r110, r100.d()), b(r110, r100.h()), b(r110, r100.g()), b(r110, r100.b()), b(r110, r100.k()), new a(b(r110, r111.getMonitorNormal()), b(r110, r111.getMonitorError()), b(r110, r111.getInterceptError()), b(r110, r111.getNormalRate()), r111.getLocalSampleRate()));
        ((LinkedHashMap) f466216c).clear();
        List<ResourceSampleRateConfig> r112 = r100.j();
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r114 = r112.iterator();
    L13:
        if (r114.hasNext() == false) goto L15;
        ResourceSampleRateConfig r115 = (ResourceSampleRateConfig) r114.next();
        f466216c.put(r115.getResourceId(), new a(b(r110, r115.getMonitorNormal()), b(r110, r115.getMonitorError()), b(r110, r115.getInterceptError()), b(r110, r115.getNormalRate()), r115.getLocalSampleRate()));
        r113.add(Unit.INSTANCE);
        r104 = r104;
        goto L13
    L15:
        String r116 = r104;
        ((LinkedHashMap) f466217d).clear();
        List<ApiSampleRateConfig> r117 = r100.a();
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator<T> r119 = r117.iterator();
    L17:
        if (r119.hasNext() == false) goto L24;
        ApiSampleRateConfig r120 = (ApiSampleRateConfig) r119.next();
        a r121 = new a(b(r110, r120.getMonitorNormal()), b(r110, r120.getMonitorError()), b(r110, r120.getInterceptError()), b(r110, r120.getNormalRate()), r120.getLocalSampleRate());
        Iterator<T> r122 = r120.getApiIds().iterator();
    L20:
        if (r122.hasNext() == false) goto L22;
        f466217d.put(Integer.valueOf(((Number) r122.next()).intValue()), r121);
        goto L20
    L22:
        r118.add(Unit.INSTANCE);
        goto L17
    L24:
        if (r100.f() == false) goto L72;
        String r123 = r116;
        if ((!Intrinsics.areEqual(r123, r107)) == false) goto L71;
        h r124 = e06.d.f470643a;
        h r125 = e06.d.f470643a;
        if (r125 == null) goto L30;
        r125.putString("sample_rate_date", r123);
    L30:
        hz5.a r126 = new hz5.a("helios_sample_rate");
        r126.a("date", r123);
        c r127 = f466215b;
        if (r127 == null) goto L33;
        Boolean r128 = Boolean.valueOf(r127.f466202a);
    L34:
        r126.a("app_ops_config", r128);
        c r129 = f466215b;
        if (r129 == null) goto L37;
        Boolean r130 = Boolean.valueOf(r129.f466203b);
    L38:
        r126.a("auto_start_config", r130);
        c r131 = f466215b;
        if (r131 == null) goto L43;
        a r132 = r131.f466208g;
        if (r132 == null) goto L43;
        Boolean r133 = Boolean.valueOf(r132.f466197a);
    L44:
        r126.a("default_monitor_normal", r133);
        c r134 = f466215b;
        if (r134 == null) goto L49;
        a r135 = r134.f466208g;
        if (r135 == null) goto L49;
        Boolean r136 = Boolean.valueOf(r135.f466198b);
    L50:
        r126.a("default_monitor_error", r136);
        c r137 = f466215b;
        if (r137 == null) goto L55;
        a r138 = r137.f466208g;
        if (r138 == null) goto L55;
        Boolean r139 = Boolean.valueOf(r138.f466199c);
    L56:
        r126.a("default_intercept_error", r139);
        c r140 = f466215b;
        if (r140 == null) goto L61;
        a r141 = r140.f466208g;
        if (r141 == null) goto L61;
        Boolean r142 = Boolean.valueOf(r141.f466200d);
    L62:
        r126.a("default_normal_rate", r142);
        Iterator r143 = ((LinkedHashMap) f466216c).entrySet().iterator();
    L64:
        if (r143.hasNext() == false) goto L66;
        Map.Entry r144 = (Map.Entry) r143.next();
        r126.a(((String) r144.getKey()) + "_monitor_normal", Boolean.valueOf(((a) r144.getValue()).f466197a));
        r126.a(((String) r144.getKey()) + "_monitor_error", Boolean.valueOf(((a) r144.getValue()).f466198b));
        r126.a(((String) r144.getKey()) + "_intercept_error", Boolean.valueOf(((a) r144.getValue()).f466199c));
        r126.a(((String) r144.getKey()) + "_normal_rate", Boolean.valueOf(((a) r144.getValue()).f466200d));
        goto L64
    L66:
        Iterator r145 = ((LinkedHashMap) f466217d).entrySet().iterator();
    L68:
        if (r145.hasNext() == false) goto L70;
        Map.Entry r146 = (Map.Entry) r145.next();
        r126.a(((Number) r146.getKey()).intValue() + "_monitor_normal", Boolean.valueOf(((a) r146.getValue()).f466197a));
        r126.a(((Number) r146.getKey()).intValue() + "_monitor_error", Boolean.valueOf(((a) r146.getValue()).f466198b));
        r126.a(((Number) r146.getKey()).intValue() + "_intercept_error", Boolean.valueOf(((a) r146.getValue()).f466199c));
        r126.a(((Number) r146.getKey()).intValue() + "_normal_rate", Boolean.valueOf(((a) r146.getValue()).f466200d));
        goto L68
    L70:
        String r147 = r101;
        r126.f487682d.put("device_id", r147);
        r126.f487682d.put("hash_code", Long.valueOf(r110));
        l.b(r126);
    L73:
        com.bytedance.helios.common.utils.d.f().postDelayed(new d(r147, r110, r123, r107, r100), 10000);
        return;
    L61:
        r142 = null;
    L55:
        r139 = null;
    L49:
        r136 = null;
    L43:
        r133 = null;
        goto L44
    L37:
        r130 = null;
        goto L38
    L33:
        r128 = null;
        goto L34
    L71:
        r147 = r101;
        goto L73
    L72:
        r147 = r101;
        r123 = r116;
        goto L73
    L80:
        return;
    L9:
        r109 = r101.getBytes(Charsets.UTF_8);
        goto L10
    }

    public static boolean b(long r110, double r210) {
        if (r210 > 0) goto L6;
        return false;
    L6:
        if (r210 < 1) goto L8;
        return true;
    L8:
        String r100 = StringsKt.replace$default(new BigDecimal(String.valueOf(r210)).toPlainString(), "0.", "", false, 4, null);
        long r101 = CastLongProtector.parseLong(r100);
        long r102 = 1;
        int r111 = 0;
    L9:
        if (r111 >= r100.length()) goto L11;
        r102 = r102 * ((long) 10);
        r111 = r111 + 1;
        goto L9
    L11:
        long r112 = r101;
        long r113 = r102;
    L13:
        if (r113 == 0) goto L15;
        long r114 = r113;
        r113 = r112 % r113;
        r112 = r114;
        goto L13
    L15:
        long r103 = r101 / r112;
        long r104 = r102 / r112;
        long r115 = r110 % r104;
        int r105 = f466214a.get(6);
        long r106 = (r105 % (r104 / r103)) * r103;
        StringBuilder r116 = new StringBuilder("generateSampleRate hashCode=");
        r116.append(r110);
        r116.append(" sampleRateValue=");
        r116.append(r103);
        r116.append('/');
        r116.append(r104);
        r116.append('(');
        r116.append(r210);
        r116.append(") dayOfYear=");
        r116.append(r105);
        r116.append(" range=");
        r116.append(r106);
        r116.append('-');
        long r107 = r103 + r106;
        r116.append(r107);
        k.d("Helios-Common-Env", r116.toString());
        if (r115 >= r106) goto L18;
    L20:
        return false;
    L18:
        if (r115 >= r107) goto L20;
        return true;
    }

    public static boolean e(PrivacyEvent r100, a r101) {
        if (d(r101.f466201e) == true) goto L7;
        r100.f245378o = r100.f245378o + "local_sample_rate";
        return false;
    L7:
        if (Intrinsics.areEqual(r100.f245379p, "SensitiveApiInterceptException") == false) goto L11;
        r100.f245384u.remove("api_call");
        r100.f245378o = r100.f245378o + "intercept_error";
        return r101.f466199c;
    L11:
        if ((!r100.f245389z.getHitControlConfigs().isEmpty()) == false) goto L13;
    L18:
        r100.f245384u.remove("api_call");
        r100.f245378o = r100.f245378o + "monitor_error";
        return r101.f466198b;
    L13:
        if ((!r100.f245389z.getRuleModels().isEmpty()) == true) goto L18;
        if ((!CollectionsKt.intersect(HeliosEnvImpl.get().f245470m.p(), r100.f245384u).isEmpty()) == true) goto L18;
        r100.f245378o = r100.f245378o + "monitor_normal";
        r100.f245384u.add("api_call");
        return r101.f466197a;
    }
}
