package eq7;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends bq7.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f473506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f473507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Long, gq7.e> f473508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Long, e> f473509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final gq7.f f473510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f473511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final gq7.c f473512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f473513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<Long, gq7.d> f473514j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<Long, f> f473515k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<Long> f473516l;

    public final synchronized void a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f473506b == false) goto L9;
        long r100 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        ((bq7.a) this.f20047a).f20046f.getClass();     // Catch: Throwable -> L11
        if (((bq7.a) this.f20047a).f20046f.f15911a == false) goto L8;
        b(r100);     // Catch: Throwable -> L11
    L8:
        ((bq7.a) this.f20047a).f20046f.getClass();     // Catch: Throwable -> L11
        SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        this.f473507c = r100;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
    }

    public final void b(long r210) {
        long r100 = r210 - this.f473507c;
        ((bq7.a) this.f20047a).f20046f.getClass();
        char r101 = 0;
        int r102 = bq7.a.f20040h | 0;
        boolean r103 = hq7.a.f486512a;
        aq7.a r104 = ((bq7.a) this.f20047a).f20046f;
        if (r104.f15911a == false) goto L5;
    L8:
        gq7.f r105 = this.f473510f;
        if (((ArrayList) r105.f482275d).isEmpty() == true) goto L11;
    L19:
        c r110 = new c();
        int r111 = ((ArrayList) r105.f482277f).size();
        int r112 = 1;
        if (r102 == 0) goto L22;
        int r113 = r102;
        if ((r113 & 1) > 0) goto L64;
    L116:
        r105.f482271a = r110;
        c r106 = r110;
    L117:
        if (r106 == null) goto L125;
        c r107 = this.f473511g;
        if (r107 == null) goto L124;
        long r108 = r106.a() - r107.a();
        r106.f473520d = r108;
        if (r106.f473521e != 0) goto L124;
        r106.f473521e = r108;
    L124:
        ((bq7.a) this.f20047a).f20046f.getClass();
        ((bq7.a) this.f20047a).f20046f.getClass();
        ((bq7.a) this.f20047a).f20046f.getClass();
        this.f473511g = r106;
        long r109 = r106.f473520d;
        ((bq7.a) this.f20047a).f20046f.getClass();
        long r114 = r109;
    L126:
        int r115 = r113;
        d r116 = (d) this.f473512h.a(r115);
        if (r116 != null) goto L129;
        return;
    L129:
        d r117 = this.f473513i;
        long r118 = r116.f473529g;
        if (r117 != null) goto L132;
        long r119 = 0;
    L133:
        long r120 = r118 - r119;
        r116.f473532j = r120;
        if (r116.f473533k != 0) goto L137;
        r116.f473533k = r120;
    L137:
        if (r120 < 0) goto L142;
        if (r114 <= 0) goto L142;
        r116.f473534l = r120 / r114;
    L142:
        if (r120 >= 0) goto L144;
    L146:
        ((bq7.a) this.f20047a).f20046f.getClass();
        this.f473513i = r116;
        aq7.a r121 = ((bq7.a) this.f20047a).f20046f;
        if (r121.f15912b == false) goto L193;
        double r122 = r116.f473534l;
        r121.getClass();
        if (r122 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L193;
        ((bq7.a) this.f20047a).f20046f.getClass();
        ArrayList<Long> r123 = hq7.c.a();
        boolean r124 = hq7.a.f486512a;
        HashSet r125 = new HashSet();
        Iterator<Long> r126 = r123.iterator();
    L153:
        if (r126.hasNext() == false) goto L179;
        long r127 = r126.next().longValue();
        gq7.d r128 = (gq7.d) ((HashMap) this.f473514j).get(Long.valueOf(r127));
        if (r128 != null) goto L157;
        r128 = new gq7.d(r127);
        ((HashMap) this.f473514j).put(Long.valueOf(r127), r128);
    L157:
        f r129 = (f) r128.a(r115);
        if (r129 == null) goto L159;
        f r130 = (f) ((HashMap) this.f473515k).get(Long.valueOf(r127));
        long r131 = r129.f473529g;
        int r132 = r115;
        HashSet r211 = r125;
        if (r130 != null) goto L163;
        long r133 = 0;
    L164:
        long r134 = r131 - r133;
        r129.f473532j = r134;
        if (r129.f473533k != 0) goto L168;
        r129.f473533k = r134;
    L168:
        if (r134 < 0) goto L174;
        if (r114 <= 0) goto L174;
        r129.f473534l = r134 / r114;
    L174:
        if (r134 >= 0) goto L176;
    L178:
        ((bq7.a) this.f20047a).f20046f.getClass();
        ((HashMap) this.f473515k).put(Long.valueOf(r127), r129);
        r125 = r211;
        r126 = r126;
        r115 = r132;
        goto L153
    L176:
        if (r100 <= 0) goto L178;
        r129.f473535m = r134 / r100;
        goto L178
    L163:
        r133 = r130.f473529g;
        goto L164
    L159:
        r125.add(Long.valueOf(r127));
        boolean r135 = hq7.a.f486512a;
        goto L153
    L179:
        HashSet r212 = r125;
        Set r136 = ((HashMap) this.f473514j).keySet();
        if (r136 != null) goto L182;
    L189:
        Iterator r137 = r212.iterator();
    L191:
        if (r137.hasNext() == false) goto L245;
        long r138 = ((Long) r137.next()).longValue();
        ((HashMap) this.f473514j).remove(Long.valueOf(r138));
        ((HashMap) this.f473515k).remove(Long.valueOf(r138));
        goto L191
    L245:
        return;
    L182:
        if (r136.isEmpty() == true) goto L189;
        Iterator r139 = r136.iterator();
    L185:
        if (r139.hasNext() == false) goto L189;
        Long r140 = (Long) r139.next();
        if (r123.contains(r140) == true) goto L185;
        r212.add(r140);
        boolean r141 = hq7.a.f486512a;
    L193:
        ((bq7.a) this.f20047a).f20046f.getClass();
        return;
    L144:
        if (r100 <= 0) goto L146;
        r116.f473535m = r120 / r100;
        goto L146
    L132:
        r119 = r117.f473529g;
    L125:
        r114 = 0;
        goto L126
    L64:
        if (((ArrayList) r105.f482276e).size() != r111) goto L116;
        if ((r113 & 8) <= 0) goto L74;
        int r142 = 0;
        long r143 = 0;
    L68:
        if (r142 >= r111) goto L73;
        Integer r144 = (Integer) ListProtector.get(r105.f482277f, r142);
        if (r144 == null) goto L72;
        r143 = r143 + FileUtils.parseSystemPolicyTimeInSate((String) ListProtector.get(r105.f482276e, r142), r144.intValue());
    L72:
        r142 = r142 + 1;
        goto L68
    L73:
        r110.f473519c = r143 * 10;
        goto L116
    L74:
        int r145 = 0;
    L75:
        if (r145 >= r111) goto L116;
        Integer r146 = (Integer) ListProtector.get(r105.f482277f, r145);
        if (r146 == null) goto L114;
        String r147 = (String) ListProtector.get(r105.f482276e, r145);
        int r148 = r146.intValue();
        String r149 = FileUtils.parseFile(r147);
        if (r149 != null) goto L81;
        int r150 = r111;
    L111:
        LinkedHashMap r151 = null;
    L112:
        if (r151 == null) goto L115;
        ((ArrayList) r110.f473517a).add(r151);
    L115:
        r145 = r145 + 1;
        r111 = r150;
        r112 = 1;
        goto L75
    L81:
        String[] r152 = r149.split("\n");
        int r153 = r152.length;     // Catch: Throwable -> L107 Exception -> L108
        int r154 = 0;
        r151 = null;
    L84:
        if (r154 >= r153) goto L106;
        String r155 = r152[r154];     // Catch: Throwable -> L103 Exception -> L104
        if (r155.isEmpty() == true) goto L106;
        String[] r156 = r155.split(" ");     // Catch: Throwable -> L103 Exception -> L104
        if (r156.length <= r112) goto L106;
        if (r151 != null) goto L96;
        r151 = new LinkedHashMap();     // Catch: Throwable -> L94 Exception -> L104
    L96:
        r150 = r111;
        r151.put(Long.valueOf(Long.parseLong(r156[0])), Long.valueOf((r148 * 10) * Long.parseLong(r156[1])));     // Catch: Throwable -> L198 Exception -> L101
        r154 = r154 + 1;
        r111 = r150;
        r112 = 1;
        goto L84
    L101:
        e = e;
    L110:
        Log.getStackTraceString(e);     // Catch: Throwable -> L198
        boolean r157 = hq7.a.f486512a;     // Catch: Throwable -> L198
    L103:
        r150 = r111;
    L104:
        e = e;
        r150 = r111;
    L106:
        r150 = r111;
        goto L112
    L108:
        e = e;
        r150 = r111;
    L107:
        r150 = r111;
        goto L111
    L114:
        r150 = r111;
        goto L115
    L22:
        if (((ArrayList) r105.f482275d).size() != r111) goto L60;
        int r158 = 0;
    L24:
        if (r158 >= r111) goto L60;
        File r159 = (File) ListProtector.get(r105.f482275d, r158);
        int r160 = ((Integer) ListProtector.get(r105.f482277f, r158)).intValue();
        BufferedReader r161 = FileUtils.b(r159);
        if (r161 != null) goto L28;
        int r162 = r102;
        LinkedHashMap r163 = null;
    L57:
        if (r163 == null) goto L59;
        ((ArrayList) r110.f473517a).add(r163);
    L59:
        r158 = r158 + 1;
        r102 = r162;
        r101 = 0;
        goto L24
    L28:
        LinkedHashMap r164 = null;
    L208:
        String r165 = r161.readLine();     // Catch: Throwable -> L197 Exception -> L53
        if (r165 == null) goto L52;
        if (r165.isEmpty() == true) goto L52;
        String[] r166 = r165.split(" ");     // Catch: Throwable -> L197 Exception -> L53
        if (r166.length <= 1) goto L52;
        if (r164 != null) goto L40;
        LinkedHashMap r167 = new LinkedHashMap();     // Catch: Throwable -> L197 Exception -> L53
    L212:
        r162 = r102;
        r167.put(Long.valueOf(Long.parseLong(r166[r101])), Long.valueOf((r160 * 10) * Long.parseLong(r166[1])));     // Catch: Exception -> L45 Throwable -> L196
        r164 = r167;
        r102 = r162;
        r101 = 0;
        goto L208
    L45:
        e = e;
    L51:
        r164 = r167;
    L201:
        Log.getStackTraceString(e);     // Catch: Throwable -> L195
        boolean r168 = hq7.a.f486512a;     // Catch: Throwable -> L195
    L56:
        FileUtils.a(r161);
        r163 = r164;
    L48:
        r164 = r167;
        goto L56
    L49:
        e = e;
        r162 = r102;
    L47:
        r162 = r102;
        goto L48
    L40:
        r167 = r164;
    L53:
        e = e;
        r162 = r102;
    L52:
        r162 = r102;
    L60:
        r113 = r102;
        goto L116
    L11:
        if (((ArrayList) r105.f482276e).isEmpty() == false) goto L19;
        List<com.bytedance.watson.assist.utils.a.e> r169 = com.bytedance.watson.assist.utils.a.a();
        if (r169 != null) goto L15;
        r113 = r102;
        r106 = null;
        goto L117
    L15:
        Iterator<com.bytedance.watson.assist.utils.a.e> r170 = r169.iterator();
    L17:
        if (r170.hasNext() == false) goto L19;
        com.bytedance.watson.assist.utils.a.e r171 = r170.next();
        String r172 = "/sys/devices/system/cpu/cpufreq/" + r171.f272587a + "/stats/time_in_state";
        ((ArrayList) r105.f482276e).add(r172);
        ((ArrayList) r105.f482275d).add(new PolarisFileWrapper(r172));
        ((ArrayList) r105.f482277f).add(Integer.valueOf(r171.f272588b.size()));
        goto L17
    L5:
        if (r104.f15912b == true) goto L8;
        r113 = r102;
        goto L125
    }

    public b(Context r100, aq7.c r101) {
        super(r100, r101);
        this.f473506b = false;
        this.f473507c = 0;
        new gq7.e();
        new e();
        this.f473508d = new HashMap();
        this.f473509e = new HashMap();
        this.f473510f = new gq7.f();
        this.f473511g = new c();
        this.f473512h = new gq7.c();
        this.f473513i = new d();
        this.f473514j = new HashMap();
        this.f473515k = new HashMap();
        new ArrayList();
        new ArrayList();
        new a();
        this.f473516l = new ArrayList();
    }
}
