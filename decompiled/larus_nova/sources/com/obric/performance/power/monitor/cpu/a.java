package com.obric.performance.power.monitor.cpu;

import androidx.camera.video.AudioStats;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.performance.power.monitor.utils.EnsureLoad;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Map<Integer, Long> f403807i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f403808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f403809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f403810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f403811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f403812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CPUInfo f403813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f403814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f403815h;

    /* JADX INFO: renamed from: com.obric.performance.power.monitor.cpu.a$a, reason: collision with other inner class name */
    public static final class C4684a {
    }

    static {
    }

    public final void a() {
        EnsureLoad.f403830a.getClass();
        if (EnsureLoad.f403831b == true) goto L5;
        return;
    L5:
        boolean r100 = false;
        if (this.f403808a == true) goto L19;
        int[] r101 = this.f403811d;
        if (r101 == null) goto L18;
        if (r101 != null) goto L11;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == false) goto L19;
        return;
    L11:
        if (r101.length != 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 != true) goto L16;
        r102 = true;
        goto L17
    L13:
        r103 = false;
        goto L14
    L18:
        return;
    L19:
        c r104 = this.f403815h;
        r104.f403816a = AudioStats.AUDIO_AMPLITUDE_NONE;
        r104.f403817b = AudioStats.AUDIO_AMPLITUDE_NONE;
        r104.f403818c = AudioStats.AUDIO_AMPLITUDE_NONE;
        r104.f403819d = AudioStats.AUDIO_AMPLITUDE_NONE;
        r104.f403820e = 0;
        r104.f403821f = 0;
        Map<Integer, Map<Long, Long>> r105 = r104.f403822g;
        if (r105 == null) goto L22;
        r105.clear();
    L22:
        r104.f403823h = 0;
        r104.f403824i = 0;
        Map<Integer, Long> r106 = r104.f403825j;
        if (r106 == null) goto L25;
        r106.clear();
    L25:
        Map<Integer, Map<Integer, Long>> r107 = r104.f403826k;
        if (r107 == null) goto L28;
        r107.clear();
    L28:
        boolean r110 = this.f403808a;
        boolean r108 = this.f403812e;
        int[] r111 = this.f403811d;
        boolean r112 = this.f403809b;
        CPUNative r109 = CPUNative.f403805a;
        long r113 = System.currentTimeMillis();
        CPUInfo r114 = CPUNative.dumpNativeCpuTime(r110, r108, r110, r111, r112, r112);
        r114.setRefreshTime(r113);
        r114.toString();
        CPUInfo r115 = this.f403813f;
        if (r115 == null) goto L142;
        this.f403815h.f403824i = System.currentTimeMillis() - r115.getRefreshTime();
        long r116 = r114.getProcCpu() - r115.getProcCpu();
        if (r116 <= 0) goto L41;
        c r117 = this.f403815h;
        r117.f403823h = r116;
        r117.f403817b = (r116 / r117.f403824i) / ((double) b());
        long r118 = r114.getDevCpu() - r115.getDevCpu();
        if (r118 <= 0) goto L41;
        c r119 = this.f403815h;
        r119.f403820e = r118;
        r119.f403816a = r119.f403823h / r118;
        long r120 = r114.getDevIdle() - r115.getDevIdle();
        if (1 <= r120) goto L37;
    L39:
        if (r100 == false) goto L41;
        c r121 = this.f403815h;
        r121.f403821f = r120;
        r121.f403819d = ((double) 1) - (r120 / r121.f403820e);
        goto L41
    L37:
        if (r120 > r118) goto L39;
        r100 = true;
    L41:
        Map<Integer, Map<Long, Long>> r122 = r114.getDevCpuFreqMap();
        if (r122 == null) goto L59;
        Map<Integer, Map<Long, Long>> r123 = r115.getDevCpuFreqMap();
        if (r123 == null) goto L59;
        LinkedHashMap r124 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, Map<Long, Long>>> r125 = r122.entrySet().iterator();
    L47:
        if (r125.hasNext() == false) goto L57;
        Map.Entry<Integer, Map<Long, Long>> r126 = r125.next();
        int r127 = r126.getKey().intValue();
        Map<Long, Long> r128 = r126.getValue();
        Map<Long, Long> r129 = r123.get(Integer.valueOf(r127));
        if (r129 == null) goto L47;
        Integer r130 = Integer.valueOf(r127);
        LinkedHashMap r131 = new LinkedHashMap();
        Iterator<Map.Entry<Long, Long>> r132 = r128.entrySet().iterator();
    L52:
        if (r132.hasNext() == false) goto L56;
        Map.Entry<Long, Long> r133 = r132.next();
        long r134 = r133.getKey().longValue();
        long r135 = r133.getValue().longValue();
        Long r136 = r129.get(Long.valueOf(r134));
        if (r136 == null) goto L52;
        r131.put(Long.valueOf(r134), Long.valueOf(r135 - r136.longValue()));
        goto L52
    L56:
        r124.put(r130, r131);
        goto L47
    L57:
        this.f403815h.f403822g = r124;
    L59:
        if (this.f403810c == false) goto L112;
        Map<Integer, Map<Long, Long>> r137 = this.f403815h.f403822g;
        if (r137 == null) goto L112;
        if (f403807i != null) goto L98;
        CPUMonitor$initPolicyMaxFreqMap$1 r138 = CPUMonitor$initPolicyMaxFreqMap$1.INSTANCE;
        monitor-enter(r138);
    L95:
        th = move-exception;
        throw th;
    L67:
        if (f403807i != null) goto L92;
        f403807i = new LinkedHashMap();     // Catch: Throwable -> L95
        Map<Integer, Integer> r139 = CPUNative.f403805a.a();     // Catch: Throwable -> L95
        if (r139 == null) goto L92;
        Iterator<Map.Entry<Integer, Integer>> r140 = r139.entrySet().iterator();     // Catch: Throwable -> L95
    L72:
        if (r140.hasNext() == false) goto L92;
        Map.Entry<Integer, Integer> r141 = r140.next();     // Catch: Throwable -> L95
        int r142 = r141.getKey().intValue();     // Catch: Throwable -> L95
        int r143 = r141.getValue().intValue();     // Catch: Throwable -> L95
        Map<Long, Long> r144 = r137.get(Integer.valueOf(r142));     // Catch: Throwable -> L95
        if (r144 == null) goto L72;
        Iterator<T> r145 = r144.entrySet().iterator();     // Catch: Throwable -> L95
        Long r146 = null;
        if (r145.hasNext() == true) goto L78;
        Object r147 = null;
    L87:
        Map.Entry r148 = (Map.Entry) r147;     // Catch: Throwable -> L95
        if (r148 == null) goto L90;
        r146 = (Long) r148.getKey();     // Catch: Throwable -> L95
    L90:
        if (r146 == null) goto L72;
        Integer r149 = Integer.valueOf(r142);     // Catch: Throwable -> L95
        Map<Integer, Long> r150 = f403807i;     // Catch: Throwable -> L95
        Intrinsics.checkNotNull(r150);     // Catch: Throwable -> L95
        r150.put(r149, Long.valueOf(((long) r143) * r146.longValue()));     // Catch: Throwable -> L95
        goto L72
    L78:
        r147 = r145.next();     // Catch: Throwable -> L95
        if (r145.hasNext() == false) goto L87;
        long r151 = ((Number) ((Map.Entry) r147).getKey()).longValue();     // Catch: Throwable -> L95
    L82:
        Object r152 = r145.next();     // Catch: Throwable -> L95
        long r153 = ((Number) ((Map.Entry) r152).getKey()).longValue();     // Catch: Throwable -> L95
        if (r151 >= r153) goto L86;
        r147 = r152;
        r151 = r153;
    L86:
        if (r145.hasNext() == true) goto L82;
    L92:
        Unit r154 = Unit.INSTANCE;     // Catch: Throwable -> L95
        monitor-exit(r138);
    L98:
        Iterator<Map.Entry<Integer, Map<Long, Long>>> r155 = r137.entrySet().iterator();
        double r156 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L100:
        if (r155.hasNext() == false) goto L111;
        Map.Entry<Integer, Map<Long, Long>> r157 = r155.next();
        int r158 = r157.getKey().intValue();
        Map<Long, Long> r159 = r157.getValue();
        Map<Integer, Long> r160 = f403807i;
        Intrinsics.checkNotNull(r160);
        Long r161 = (Long) ((LinkedHashMap) r160).get(Integer.valueOf(r158));
        if (r161 == null) goto L100;
        long r162 = r161.longValue();
        Iterator<Map.Entry<Long, Long>> r163 = r159.entrySet().iterator();
        long r164 = 0;
    L105:
        if (r163.hasNext() == false) goto L107;
        Map.Entry<Long, Long> r165 = r163.next();
        r164 = r164 + (r165.getKey().longValue() * r165.getValue().longValue());
        goto L105
    L107:
        double r166 = r164 / (r162 * this.f403815h.f403824i);
        if (r166 <= 1.0d) goto L110;
        r166 = 1.0d;
    L110:
        r156 = r156 + r166;
        goto L100
    L111:
        double r167 = r156 / ((double) r137.size());
        c r168 = this.f403815h;
        r168.f403818c = r168.f403816a * r167;
    L112:
        Map<Integer, Long> r169 = r114.getThreadCpuMap();
        if (r169 == null) goto L125;
        Map<Integer, Long> r170 = r115.getThreadCpuMap();
        if (r170 == null) goto L125;
        LinkedHashMap r171 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, Long>> r172 = r169.entrySet().iterator();
    L118:
        if (r172.hasNext() == false) goto L124;
        Map.Entry<Integer, Long> r173 = r172.next();
        int r174 = r173.getKey().intValue();
        long r175 = r173.getValue().longValue();
        Long r176 = r170.get(Integer.valueOf(r174));
        if (r176 == null) goto L118;
        long r177 = r175 - r176.longValue();
        if (r177 < 0) goto L118;
        r171.put(Integer.valueOf(r174), Long.valueOf(r177));
        goto L118
    L124:
        this.f403815h.f403825j = r171;
    L125:
        Map<Integer, Map<Integer, Long>> r178 = r114.getThreadCpuPolicyMap();
        if (r178 == null) goto L142;
        Map<Integer, Map<Integer, Long>> r179 = r115.getThreadCpuPolicyMap();
        if (r179 == null) goto L142;
        LinkedHashMap r180 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, Map<Integer, Long>>> r181 = r178.entrySet().iterator();
    L131:
        if (r181.hasNext() == false) goto L141;
        Map.Entry<Integer, Map<Integer, Long>> r182 = r181.next();
        int r183 = r182.getKey().intValue();
        Map<Integer, Long> r184 = r182.getValue();
        Map<Integer, Long> r185 = r179.get(Integer.valueOf(r183));
        if (r185 == null) goto L131;
        Integer r186 = Integer.valueOf(r183);
        LinkedHashMap r187 = new LinkedHashMap();
        Iterator<Map.Entry<Integer, Long>> r188 = r184.entrySet().iterator();
    L136:
        if (r188.hasNext() == false) goto L140;
        Map.Entry<Integer, Long> r189 = r188.next();
        int r190 = r189.getKey().intValue();
        long r191 = r189.getValue().longValue();
        Long r192 = r185.get(Integer.valueOf(r190));
        if (r192 == null) goto L136;
        r187.put(Integer.valueOf(r190), Long.valueOf(r191 - r192.longValue()));
        goto L136
    L140:
        r180.put(r186, r187);
        goto L131
    L141:
        this.f403815h.f403826k = r180;
    L142:
        this.f403813f = r114;
    }

    public final int b() {
        int r100 = this.f403814g;
        if (r100 < 0) goto L5;
        return r100;
    L5:
        String[] r101 = new PolarisFileWrapper("/sys/devices/system/cpu").list(new b());
        if (r101 == null) goto L8;
        int r102 = r101.length;
    L9:
        this.f403814g = r102;
        return r102;
    L8:
        r102 = 0;
        goto L9
    }

    public a(boolean r100, int[] r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 8) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 16) == 0) goto L11;
        r102 = false;
    L11:
        this.f403808a = r100;
        this.f403809b = false;
        this.f403810c = false;
        this.f403811d = r101;
        this.f403812e = r102;
        this.f403814g = -1;
        this.f403815h = new c(null);
    }
}
