package com.bytedance.navigation.kmp.capability.sensor.eskf;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import androidx.camera.video.AudioStats;
import bv5.j;
import bv5.k;
import bv5.l;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttm.player.C;
import com.ttnet.org.chromium.base.BaseSwitches;
import defpackage.m;
import faceverify.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class EskfDeviceHeadingSensor {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f265803n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PthreadHandlerThreadV2 f265804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f265805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SensorManager f265806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f265807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile com.bytedance.navigation.kmp.listener.b f265808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f265809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j f265810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h f265811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f265812i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f265813j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f265814k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile Function1<? super String, Unit> f265815l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f265816m;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EskfDeviceHeadingSensor f265817a;

        public b(EskfDeviceHeadingSensor r100) {
            this.f265817a = r100;
        }

        public final void c(double r100, double r101, double r102) {
            j r103 = this.f265817a.f265810g;
            if (r103 == null) goto L6;
            r103.f20914p = new double[]{r100, r101, r102};
            return;
        }

        public final void a(double r100, double r110, double r111, double r112, double r113, double r114) {
            j r101 = this.f265817a.f265810g;
            if (r101 == null) goto L6;
            r101.f20910l = new double[]{r100, r110, r111};
            r101.f20911m = new double[]{r112, r113, r114};
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(double r310, double r311, double r312, double r313, double r314, double r410, long r411) {
            j r100 = this.f265817a.f265810g;
            if (r100 == null) goto L382;
            r100.f20912n = new double[]{r310, r311, r312};
            r100.f20913o = new double[]{r313, r314, r410};
            r100.B.addLast(Long.valueOf(r411));
        L6:
            if ((!r100.B.isEmpty()) == false) goto L11;
            if ((r411 - r100.B.first().longValue()) <= C.NANOS_PER_SECOND) goto L11;
            r100.B.removeFirst();
        L11:
            if (r100.B.size() < 2) goto L24;
            double r110 = (r100.B.last().longValue() - r100.B.first().longValue()) * 1.0E-9d;
            if (Double.isInfinite(r110) == false) goto L16;
        L18:
            boolean r101 = false;
        L19:
            if (r101 == false) goto L24;
            if (r110 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L24;
            r100.B.size();
            goto L24
        L16:
            if (Double.isNaN(r110) == true) goto L18;
            r101 = true;
        L24:
            double[] r102 = r100.f20910l;
            if (r102 == null) goto L383;
            double[] r111 = r100.f20912n;
            if (r111 == null) goto L384;
            bv5.b r112 = r100.f20904f;
            if (r112 == null) goto L385;
            Long r113 = r100.f20918t;
            r100.f20918t = Long.valueOf(r411);
            if (r113 == null) goto L386;
            double r114 = (r411 - r113.longValue()) * 1.0E-9d;
            if (Double.isInfinite(r114) == false) goto L39;
        L41:
            boolean r103 = false;
        L42:
            if (r103 == true) goto L44;
        L47:
            r114 = r100.f20899a.f20867b;
        L48:
            Intrinsics.checkNotNullParameter(r102, "accM");
            Intrinsics.checkNotNullParameter(r111, "gyroM");
            double[] r104 = Arrays.copyOf(r102, r102.length);
            double[] r105 = Arrays.copyOf(r111, r111.length);
            if (Double.isInfinite(r114) == false) goto L51;
        L53:
            boolean r115 = false;
        L54:
            if (r115 == true) goto L56;
        L58:
            double r116 = r112.f20850j;
            k r117 = r112.f20848h;
            double[] r106 = r117.f20925a;
            double[] r107 = r117.f20926b;
            double[] r108 = r117.f20927c;
            double[] r109 = r117.f20928d;
            double[] r118 = r117.f20929e;
            double[] r119 = r117.f20930f;
            int r120 = bv5.e.f20864a;
            double[] r121 = bv5.e.r(bv5.e.f(bv5.e.n(r108), bv5.e.t(r104, r109)), r119);
            r112.f20848h = new k(bv5.e.r(bv5.e.r(r106, bv5.e.s(r107, r114)), bv5.e.s(r121, (0.5d * r114) * r114)), bv5.e.r(r107, bv5.e.s(r121, r114)), bv5.e.m(bv5.e.l(r108, bv5.e.o(bv5.e.s(bv5.e.t(r105, r118), r114)))), Arrays.copyOf(r109, r109.length), Arrays.copyOf(r118, r118.length), Arrays.copyOf(r119, r119.length));
            double[][] r122 = bv5.e.n(r108);
            double[][] r123 = bv5.e.n(bv5.e.o(bv5.e.s(bv5.e.t(r105, r118), r114)));
            double[][] r124 = bv5.e.e();
            int r125 = 0;
        L60:
            if (r125 >= 3) goto L62;
            int r126 = r125 + 3;
            r124[r125 + 0][r126] = r114;
            r124[r126][r125 + 15] = r114;
            r125 = r125 + 1;
            goto L60
        L62:
            int r127 = bv5.e.f20864a;
            double[][] r128 = bv5.e.g(r122, bv5.e.p(bv5.e.t(r104, r109)));
            int r129 = 0;
        L63:
            int r130 = 6;
            int r131 = 3;
            if (r129 >= 3) goto L69;
            int r132 = 0;
        L66:
            if (r132 >= r131) goto L68;
            r124[r131 + r129][r130 + r132] = (-r128[r129][r132]) * r114;
            r132 = r132 + 1;
            r130 = 6;
            r131 = 3;
            goto L66
        L68:
            r129 = r129 + 1;
            goto L63
        L69:
            int r133 = 0;
        L70:
            int r134 = 3;
            if (r133 >= 3) goto L76;
            int r135 = 0;
        L73:
            if (r135 >= r134) goto L75;
            r124[r134 + r133][r135 + 9] = (-r122[r133][r135]) * r114;
            r135 = r135 + 1;
            r134 = 3;
            goto L73
        L75:
            r133 = r133 + 1;
            goto L70
        L76:
            int r136 = bv5.e.f20864a;
            double[][] r137 = bv5.e.h(r123);
            int r138 = 0;
        L77:
            int r139 = 3;
            if (r138 >= 3) goto L83;
            int r140 = 0;
        L80:
            if (r140 >= r139) goto L82;
            r124[r138 + 6][r140 + 6] = r137[r138][r140];
            r140 = r140 + 1;
            r139 = 3;
            goto L80
        L82:
            r138 = r138 + 1;
            goto L77
        L83:
            int r141 = 0;
        L85:
            if (r141 >= 3) goto L87;
            r124[r141 + 6][r141 + 12] = -r114;
            r141 = r141 + 1;
            goto L85
        L87:
            int r142 = bv5.e.f20864a;
            double[][] r143 = bv5.e.i(18, 12);
            int r144 = 0;
        L89:
            if (r144 >= 3) goto L91;
            int r145 = r144 + 3;
            r143[r145][r144] = 1.0d;
            int r146 = r144 + 6;
            r143[r146][r145] = 1.0d;
            int r147 = r144 + 9;
            r143[r147][r146] = 1.0d;
            r143[r144 + 12][r147] = 1.0d;
            r144 = r144 + 1;
            goto L89
        L91:
            double r148 = r112.f20841a;
            double r149 = ((r148 * r148) * r114) * r114;
            double r150 = r112.f20842b;
            double r151 = ((r150 * r150) * r114) * r114;
            double r152 = r112.f20843c;
            double r153 = (r152 * r152) * r114;
            double r154 = r112.f20844d;
            double r155 = (r154 * r154) * r114;
            int r156 = bv5.e.f20864a;
            double[][] r157 = bv5.e.i(12, 12);
            double r412 = r114;
            int r158 = 3;
            int r159 = 0;
        L92:
            if (r159 >= r158) goto L94;
            r157[r159][r159] = r149;
            int r160 = r159 + 3;
            r157[r160][r160] = r151;
            int r161 = r159 + 6;
            r157[r161][r161] = r153;
            int r162 = r159 + 9;
            r157[r162][r162] = r155;
            r159 = r159 + 1;
            r158 = 3;
            goto L92
        L94:
            int r163 = bv5.e.f20864a;
            r112.f20849i = bv5.e.q(bv5.e.d(bv5.e.g(bv5.e.g(r124, r112.f20849i), bv5.e.h(r124)), bv5.e.g(bv5.e.g(r143, r157), bv5.e.h(r143))));
            l r164 = r112.f20845e;
            if (r164 != null) goto L97;
        L288:
            r100.f20905g += r412;
            if (r100.f20899a.f20890y == false) goto L348;
            double[] r165 = r100.f20914p;
            if (r165 == null) goto L348;
            int r166 = r165.length;
            int r167 = 0;
        L295:
            if (r167 >= r166) goto L305;
            double r168 = r165[r167];
            if (Double.isInfinite(r168) == false) goto L299;
        L301:
            boolean r169 = false;
        L302:
            if (r169 == false) goto L303;
            r167 = r167 + 1;
            goto L295
        L303:
            boolean r170 = false;
        L306:
            if (r170 == false) goto L348;
            double r171 = r100.f20905g;
            double r172 = r171 - r100.f20906h;
            bv5.f r173 = r100.f20899a;
            if (r172 < r173.A) goto L348;
            if ((r171 - r100.f20907i) < r173.B) goto L348;
            double[] r174 = r112.f20848h.f20927c;
            int r175 = bv5.e.f20864a;
            double[] r176 = bv5.e.b(r174);
            double r177 = r176[1];
            double r178 = r176[2];
            double r179 = bv5.c.a(r177);
            double r180 = bv5.c.a(r178);
            if (Double.isInfinite(r179) == false) goto L317;
        L319:
            boolean r181 = false;
        L320:
            if (r181 == true) goto L322;
        L345:
            Double r182 = null;
        L346:
            if (r182 == null) goto L348;
            r112.c(r182.doubleValue(), bv5.c.b(r100.f20899a.f20891z), bv5.c.b(r100.f20899a.C), "磁力计航向");
            r100.f20906h = r100.f20905g;
            goto L348
        L322:
            if (Double.isInfinite(r180) == false) goto L324;
        L326:
            boolean r183 = false;
        L327:
            if (r183 == false) goto L345;
            if (Math.abs(r179) > r100.f20899a.D) goto L345;
            if (Math.abs(r180) > r100.f20899a.D) goto L345;
            double[][] r184 = bv5.e.n(bv5.e.k(AudioStats.AUDIO_AMPLITUDE_NONE, r177, r178));
            double[] r185 = r184[0];
            double r186 = r185[0] * r165[0];
            double r187 = r185[1];
            double r188 = r165[1];
            double r189 = r185[2];
            double r210 = r165[2];
            double r190 = (r186 + (r187 * r188)) + (r189 * r210);
            double[] r191 = r184[1];
            double r192 = r191[0];
            double r211 = r165[0];
            double r193 = ((r192 * r211) + (r191[1] * r188)) + (r191[2] * r210);
            double[] r194 = r184[2];
            double[] r195 = {r190, r193, ((r194[0] * r211) + (r194[1] * r165[1])) + (r194[2] * r210)};
            double r196 = (r190 * r190) + (r193 * r193);
            if (Double.isInfinite(r196) == false) goto L337;
        L339:
            boolean r197 = false;
        L340:
            if (r197 == false) goto L345;
            if (r196 < 1.0E-6d) goto L345;
            r182 = Double.valueOf(bv5.e.c(bv5.e.k(bv5.e.u(Math.atan2(r195[0], r195[1]) - bv5.c.b(r100.f20899a.f20868c)), r177, r178)));
            goto L346
        L337:
            if (Double.isNaN(r196) == true) goto L339;
            r197 = true;
            goto L340
        L324:
            if (Double.isNaN(r180) == true) goto L326;
            r183 = true;
            goto L327
        L317:
            if (Double.isNaN(r179) == true) goto L319;
            r181 = true;
            goto L320
        L299:
            if (Double.isNaN(r168) == true) goto L301;
            r169 = true;
            goto L302
        L305:
            r170 = true;
        L348:
            r100.b(r112);
            r100.a(r112);
            return;
        L97:
            if (r164.f20931a == false) goto L288;
            r112.f20852l.addLast(new bv5.b.a(r116, Arrays.copyOf(r104, r104.length), Arrays.copyOf(r105, r105.length)));
            double r198 = r112.f20845e.f20933c;
            if (Double.isInfinite(r198) == false) goto L101;
        L103:
            boolean r199 = false;
        L104:
            if (r199 == false) goto L113;
            if (r198 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L113;
        L108:
            if ((!r112.f20852l.isEmpty()) == false) goto L113;
            if ((r116 - r112.f20852l.first().f20856a) <= r198) goto L113;
            r112.f20852l.removeFirst();
        L113:
            l r200 = r112.f20845e;
            if (r200 == null) goto L288;
            if (r200.f20931a == false) goto L288;
            if (r112.f20852l.size() < 2) goto L288;
            if ((r116 - r112.f20852l.first().f20856a) < (r200.f20933c * 0.8d)) goto L288;
            int r201 = r112.f20852l.size();
            double[][] r202 = new double[r201][];
            int r203 = 0;
        L126:
            if (r203 >= r201) goto L128;
            r202[r203] = new double[3];
            r203 = r203 + 1;
            goto L126
        L128:
            int r1100 = 3;
            double[][] r204 = new double[r201][];
            int r1101 = 0;
        L129:
            if (r1101 >= r201) goto L131;
            r204[r1101] = new double[r1100];
            r1101 = r1101 + 1;
            r1100 = 3;
            goto L129
        L131:
            Iterator<bv5.b.a> r1102 = r112.f20852l.iterator();
            int r1103 = 0;
        L133:
            if (r1102.hasNext() == false) goto L135;
            bv5.b.a r1104 = r1102.next();
            r202[r1103] = r1104.f20857b;
            r204[r1103] = r1104.f20858c;
            r1103 = r1103 + 1;
            goto L133
        L135:
            double[][] r1105 = new double[r201][];
            int r1106 = 0;
        L136:
            if (r1106 >= r201) goto L138;
            r1105[r1106] = new double[3];
            r1106 = r1106 + 1;
            goto L136
        L138:
            int r1107 = 3;
            double[][] r1108 = new double[r201][];
            int r1109 = 0;
        L139:
            if (r1109 >= r201) goto L142;
            r1108[r1109] = new double[r1107];
            r1109 = r1109 + 1;
            r1107 = 3;
            goto L139
        L142:
            if (r200.f20935e == false) goto L146;
            int r205 = 0;
        L144:
            if (r205 >= r201) goto L149;
            double[] r1110 = r1105[r205];
            double[] r1111 = r202[r205];
            double r1112 = r1111[0];
            k r206 = r112.f20848h;
            double[] r1113 = r206.f20928d;
            r1110[0] = r1112 - r1113[0];
            r1110[1] = r1111[1] - r1113[1];
            r1110[2] = r1111[2] - r1113[2];
            double[] r1114 = r1108[r205];
            double[] r1115 = r204[r205];
            double r1116 = r1115[0];
            double[] r207 = r206.f20929e;
            r1114[0] = r1116 - r207[0];
            r1114[1] = r1115[1] - r207[1];
            r1114[2] = r1115[2] - r207[2];
            r205 = r205 + 1;
        L149:
            int r208 = 0;
            double r209 = AudioStats.AUDIO_AMPLITUDE_NONE;
        L150:
            if (r208 >= r201) goto L152;
            double[] r212 = r1108[r208];
            double r1117 = r212[0];
            double r1118 = r212[1];
            double r213 = r212[2];
            double r1119 = Math.sqrt(((r1117 * r1117) + (r1118 * r1118)) + (r213 * r213));
            r209 = r209 + (r1119 * r1119);
            r208 = r208 + 1;
            goto L150
        L152:
            double r1120 = r201;
            double r214 = Math.sqrt(r209 / r1120);
            double[] r215 = new double[r201];
            int r216 = 0;
            double r1121 = AudioStats.AUDIO_AMPLITUDE_NONE;
        L153:
            if (r216 >= r201) goto L155;
            double[] r217 = r1105[r216];
            double r218 = r217[0];
            double r219 = r217[1];
            double r220 = r217[2];
            double r221 = Math.sqrt(((r218 * r218) + (r219 * r219)) + (r220 * r220));
            r215[r216] = r221;
            r1121 = r1121 + r221;
            r216 = r216 + 1;
            goto L153
        L155:
            double r1122 = r1121 / r1120;
            int r222 = 0;
            double r223 = AudioStats.AUDIO_AMPLITUDE_NONE;
        L156:
            if (r222 >= r201) goto L158;
            double r224 = r215[r222] - r1122;
            r223 = r223 + (r224 * r224);
            r222 = r222 + 1;
            goto L156
        L158:
            double r225 = Math.sqrt(r223 / r1120);
            int r226 = bv5.e.f20864a;
            double r227 = bv5.e.j(r112.f20848h.f20930f);
            if (Double.isInfinite(r227) == false) goto L161;
        L163:
            boolean r228 = false;
        L164:
            if (r228 == true) goto L166;
        L168:
            r227 = 9.81d;
        L169:
            double r1123 = Math.abs(r1122 - r227);
            double r229 = r200.f20934d;
            if (Double.isInfinite(r229) == false) goto L172;
        L174:
            boolean r230 = false;
        L175:
            if (r230 == true) goto L177;
        L180:
            boolean r231 = true;
        L182:
            if (r214 >= r200.f20937g) goto L184;
            boolean r232 = true;
        L186:
            if (r1123 >= r200.f20938h) goto L188;
            boolean r233 = true;
        L190:
            if (r225 >= r200.f20939i) goto L192;
            boolean r234 = true;
        L193:
            if (r232 == false) goto L197;
            if (r233 == false) goto L197;
            if (r234 == false) goto L197;
            boolean r235 = true;
        L199:
            if (r200.f20936f == false) goto L201;
            ((ArrayList) r112.f20854n).add(MapsKt.mapOf(new Pair[]{TuplesKt.to("t_s", Double.valueOf(r116)), TuplesKt.to("gyro_rms_rad_s", Double.valueOf(r214)), TuplesKt.to("acc_mean_err_mps2", Double.valueOf(r1123)), TuplesKt.to("acc_std_norm_mps2", Double.valueOf(r225)), TuplesKt.to("min_interval_ok", Boolean.valueOf(r231)), TuplesKt.to("zupt_threshold_ok", Boolean.valueOf(r235))}));
        L201:
            if (r231 == false) goto L288;
            if (r235 == false) goto L288;
            double[] r236 = {AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
            int r237 = 0;
        L206:
            if (r237 >= r201) goto L208;
            double r238 = r236[0];
            double[] r239 = r1105[r237];
            r236[0] = r238 + r239[0];
            r236[1] = r236[1] + r239[1];
            r236[2] = r236[2] + r239[2];
            r237 = r237 + 1;
            goto L206
        L208:
            r236[0] = r236[0] / r1120;
            r236[1] = r236[1] / r1120;
            r236[2] = r236[2] / r1120;
            if (r200.f20932b == false) goto L280;
            double r240 = r200.f20943m;
            int r241 = bv5.e.f20864a;
            double r242 = bv5.e.j(r236);
            if (Double.isInfinite(r242) == false) goto L213;
        L215:
            boolean r243 = false;
        L216:
            if (r243 == true) goto L218;
        L262:
            Pair r244 = null;
        L263:
            if (r244 == null) goto L288;
            double r245 = ((Number) r244.getFirst()).doubleValue();
            double r246 = ((Number) r244.getSecond()).doubleValue();
            double[] r247 = bv5.e.b(r112.f20848h.f20927c);
            double r248 = r247[1];
            double r1124 = bv5.e.u(r245 - r247[2]);
            double r249 = bv5.e.u(r246 - r248);
            if (Math.abs(r1124) > r200.f20944n) goto L288;
            if (Math.abs(r249) > r200.f20944n) goto L288;
            double[] r250 = r112.f20848h.f20926b;
            int r251 = 3;
            double[] r252 = {-r250[0], -r250[1], -r250[2], r1124, r249};
            double[][] r253 = bv5.e.i(5, 18);
            int r254 = 0;
        L271:
            if (r254 >= 3) goto L273;
            r253[r254][r254 + 3] = 1.0d;
            r254 = r254 + 1;
            goto L271
        L273:
            int r255 = 0;
        L274:
            if (r255 >= r251) goto L276;
            double[] r256 = new double[r251];
            r256 = {x0b0a: FILL_ARRAY_DATA  (LINE:117443338), data: [0, 0, 0} // fill-array;
            r256[r255] = 1.0E-6d;
            int r257 = bv5.e.f20864a;
            double[] r258 = bv5.e.m(bv5.e.l(r112.f20848h.f20927c, bv5.e.o(r256)));
            double[] r259 = r112.f20848h.f20927c;
            double[] r260 = new double[r251];
            r260[0] = -r256[0];
            r260[1] = -r256[1];
            r260[2] = -r256[2];
            double[] r261 = bv5.e.m(bv5.e.l(r259, bv5.e.o(r260)));
            double[] r262 = bv5.e.b(r258);
            double[] r263 = bv5.e.b(r261);
            double r264 = bv5.e.u(r262[2] - r263[2]) / 2.0E-6d;
            double r265 = bv5.e.u(r262[1] - r263[1]) / 2.0E-6d;
            int r266 = r255 + 6;
            r253[3][r266] = r264;
            r253[4][r266] = r265;
            r255 = r255 + 1;
            r251 = 3;
            goto L274
        L276:
            int r267 = bv5.e.f20864a;
            double[][] r268 = bv5.e.i(5, 5);
            int r269 = 0;
        L277:
            if (r269 >= 3) goto L279;
            double[] r270 = r268[r269];
            double r271 = r200.f20940j[r269];
            r270[r269] = r271 * r271;
            r269 = r269 + 1;
            goto L277
        L279:
            double[] r272 = r268[3];
            double r273 = r200.f20941k;
            r272[3] = r273 * r273;
            double[] r274 = r268[4];
            double r275 = r200.f20942l;
            r274[4] = r275 * r275;
            bv5.b.C0365b r276 = new bv5.b.C0365b(r252, r253, r268, Double.valueOf(r245), Double.valueOf(r246));
        L287:
            double[] r277 = (double[]) r276.f20859a;
            double[][] r278 = (double[][]) r276.f20860b;
            double[][] r279 = (double[][]) r276.f20861c;
            double r280 = ((Number) r276.f20862d).doubleValue();
            double r281 = ((Number) r276.f20863e).doubleValue();
            bv5.b.b(r112, r277, r278, r279, "ZUPT静止");
            r112.f20851k = r116;
            ((ArrayList) r112.f20853m).add(Double.valueOf(r116));
            ((ArrayList) r112.f20855o).add(MapsKt.mapOf(new Pair[]{TuplesKt.to("t_s", Double.valueOf(r116)), TuplesKt.to("roll_meas_rad", Double.valueOf(r280)), TuplesKt.to("pitch_meas_rad", Double.valueOf(r281))}));
            goto L288
        L218:
            if (r242 < 1.0E-6d) goto L262;
            double[] r282 = {r236[0] / r242, r236[1] / r242, r236[2] / r242};
            double[] r283 = {AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d};
            Intrinsics.checkNotNullParameter(r282, "from");
            Intrinsics.checkNotNullParameter(r283, RemoteMessageConst.TO);
            double[] r284 = Arrays.copyOf(r282, 3);
            double[] r285 = Arrays.copyOf(r283, 3);
            double r286 = bv5.e.j(r284);
            double r287 = bv5.e.j(r285);
            if (r286 >= 1.0E-12d) goto L223;
        L225:
            boolean r1125 = false;
        L226:
            if (r1125 == false) goto L261;
            r284[0] = r284[0] / r286;
            r284[1] = r284[1] / r286;
            r284[2] = r284[2] / r286;
            double r288 = r285[0] / r287;
            r285[0] = r288;
            double r1126 = r285[1] / r287;
            r285[1] = r1126;
            double r289 = r285[2] / r287;
            r285[2] = r289;
            double r290 = Math.max(-1.0d, Math.min(1.0d, ((r288 * r284[0]) + (r284[1] * r1126)) + (r284[2] * r289)));
            if (r290 <= 0.999999999999d) goto L231;
            double[] r291 = {1.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
        L237:
            char r292 = 1;
            char r1127 = 2;
        L239:
            double[] r293 = bv5.e.b(r291);
            double r294 = r293[r292];
            double r1128 = r293[r1127];
            if (Double.isInfinite(r294) == false) goto L242;
        L244:
            boolean r295 = false;
        L245:
            if (r295 == false) goto L262;
            if (Double.isInfinite(r1128) == false) goto L249;
        L251:
            boolean r296 = false;
        L252:
            if (r296 == false) goto L262;
            if (Math.abs(r294) > r240) goto L262;
            if (Math.abs(r1128) > r240) goto L262;
            r244 = TuplesKt.to(Double.valueOf(r1128), Double.valueOf(r294));
            goto L263
        L249:
            if (Double.isNaN(r1128) == true) goto L251;
            r296 = true;
            goto L252
        L242:
            if (Double.isNaN(r294) == true) goto L244;
            r295 = true;
            goto L245
        L231:
            if (r290 < (-0.999999999999d)) goto L233;
            double[] r297 = bv5.e.a(r284, r285);
            r292 = 1;
            r1127 = 2;
            r291 = bv5.e.m(new double[]{r290 + 1.0d, r297[0], r297[1], r297[2]});
            goto L239
        L233:
            if (Math.abs(r284[0]) >= Math.abs(r284[2])) goto L235;
            int r298 = 3;
            double[] r299 = bv5.e.a(r284, new double[]{1.0d, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE});
        L236:
            double r300 = bv5.e.j(r299);
            double[] r301 = new double[r298];
            r301[0] = r299[0] / r300;
            r301[1] = r299[1] / r300;
            r301[2] = r299[2] / r300;
            double r1129 = Math.sin(1.5707963267948966d);
            r291 = bv5.e.m(new double[]{Math.cos(1.5707963267948966d), r301[0] * r1129, r301[1] * r1129, r301[2] * r1129});
            goto L237
        L235:
            r298 = 3;
            r299 = bv5.e.a(r284, new double[]{AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d});
            goto L236
        L261:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L223:
            if (r287 < 1.0E-12d) goto L225;
            r1125 = true;
            goto L226
        L213:
            if (Double.isNaN(r242) == true) goto L215;
            r243 = true;
            goto L216
        L280:
            double[] r302 = r112.f20848h.f20926b;
            double[] r303 = {-r302[0], -r302[1], -r302[2]};
            int r304 = bv5.e.f20864a;
            int r305 = 3;
            double[][] r306 = bv5.e.i(3, 18);
            int r307 = 0;
        L281:
            if (r307 >= 3) goto L283;
            r306[r307][r307 + 3] = 1.0d;
            r307 = r307 + 1;
            goto L281
        L283:
            int r308 = bv5.e.f20864a;
            double[][] r309 = bv5.e.i(3, 3);
            int r315 = 0;
        L284:
            if (r315 >= r305) goto L286;
            double[] r316 = r309[r315];
            double r317 = r200.f20940j[r315];
            r316[r315] = r317 * r317;
            r315 = r315 + 1;
            r305 = 3;
            goto L284
        L286:
            r276 = new bv5.b.C0365b(r303, r306, r309, Double.valueOf(Double.NaN), Double.valueOf(Double.NaN));
        L197:
            r235 = false;
            goto L199
        L192:
            r234 = false;
            goto L193
        L188:
            r233 = false;
            goto L190
        L184:
            r232 = false;
            goto L186
        L177:
            if ((r116 - r112.f20851k) >= r200.f20934d) goto L180;
            r231 = false;
            goto L182
        L172:
            if (Double.isNaN(r229) == true) goto L174;
            r230 = true;
            goto L175
        L166:
            if (r227 < 0.001d) goto L168;
        L161:
            if (Double.isNaN(r227) == true) goto L163;
            r228 = true;
            goto L164
        L146:
            int r318 = 0;
        L147:
            if (r318 >= r201) goto L149;
            double[] r319 = r202[r318];
            r1105[r318] = Arrays.copyOf(r319, r319.length);
            double[] r320 = r204[r318];
            r1108[r318] = Arrays.copyOf(r320, r320.length);
            r318 = r318 + 1;
            goto L147
        L101:
            if (Double.isNaN(r198) == true) goto L103;
            r199 = true;
            goto L104
        L56:
            if (r114 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L58;
            r112.f20850j += r114;
            goto L58
        L51:
            if (Double.isNaN(r114) == true) goto L53;
            r115 = true;
            goto L54
        L44:
            if (r114 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L47;
            if (r114 <= r100.f20899a.f20866a) goto L48;
        L39:
            if (Double.isNaN(r114) == true) goto L41;
            r103 = true;
            goto L42
        L386:
            return;
        L385:
            return;
        L384:
            return;
        L383:
            return;
        }
    }

    static {
    }

    public final void e() {
        e r100 = this.f265807d;
        if (r100 == null) goto L10;
        SensorManager r101 = this.f265806c;
        if (r101 == null) goto L10;
        if (fna.g.d() == true) goto L9;
        r101.unregisterListener(r100);
        goto L10
    L9:
        r101.unregisterListener(r100);
        ona.b.c(new ona.a(r100.hashCode(), null));
    L10:
        this.f265807d = null;
        PthreadHandlerThreadV2 r102 = this.f265804a;
        if (r102 == null) goto L13;
        r102.quitSafely();
    L13:
        this.f265804a = null;
        this.f265805b = null;
        this.f265806c = null;
        this.f265810g = null;
        this.f265808e = null;
        this.f265809f = false;
        this.f265813j = 0;
        this.f265814k = 0;
    }

    public EskfDeviceHeadingSensor() {
        this.f265811h = new h();
        this.f265816m = new b(this);
    }

    public final void c(String r100) {
        Function1<? super String, Unit> r101 = this.f265815l;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f265815l = null;
        d37.i r102 = d37.i.f466749a;
        d37.i.c("EskfHeadingSensor fatal: " + r100);
        r101.invoke(r100);     // Catch: Throwable -> L8
        return;
    }

    public final boolean d(c37.b r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        if (this.f265809f == false) goto L5;
        return true;
    L5:
        Context r100 = m.f511444a.getContext();
        Object r101 = r100.getSystemService(w.BLOB_ELEM_TYPE_SENSOR);
        if ((r101 instanceof SensorManager) == false) goto L8;
        SensorManager r102 = (SensorManager) r101;
    L10:
        if (r102 != null) goto L41;
        d37.i r111 = d37.i.f466749a;
        d37.i.c("EskfHeadingSensor start: no SensorManager");
        return false;
    L41:
        c.f265819a.getClass();     // Catch: Throwable -> L38
        bv5.f r103 = c.a(r100);     // Catch: Throwable -> L38
        if (Build.VERSION.SDK_INT < 26) goto L17;
        Sensor r104 = r102.getDefaultSensor(35);
    L18:
        if (r104 != null) goto L20;
        r104 = r102.getDefaultSensor(1);
    L20:
        Sensor r105 = r102.getDefaultSensor(16);
        if (r105 != null) goto L23;
        r105 = r102.getDefaultSensor(4);
    L23:
        Sensor r106 = r102.getDefaultSensor(11);
        Sensor r107 = r102.getDefaultSensor(2);
        if (r104 == null) goto L36;
        if (r105 == null) goto L36;
        if (r106 == null) goto L36;
        j r108 = new j(r103, this.f265811h, new EskfDeviceHeadingSensor$start$e$1(this));
        r108.f20904f = null;
        r108.f20905g = AudioStats.AUDIO_AMPLITUDE_NONE;
        r108.f20906h = Double.NEGATIVE_INFINITY;
        r108.f20907i = Double.NEGATIVE_INFINITY;
        r108.f20908j = Double.NEGATIVE_INFINITY;
        r108.f20909k = false;
        r108.f20910l = null;
        r108.f20911m = null;
        r108.f20912n = null;
        r108.f20913o = null;
        r108.f20914p = null;
        r108.f20915q = Double.NaN;
        r108.f20916r = Double.NaN;
        r108.f20917s = null;
        r108.f20918t = null;
        r108.f20919u = null;
        r108.f20920v = null;
        r108.f20921w = null;
        r108.f20922x = null;
        r108.f20923y = Double.NaN;
        r108.f20924z = Double.NaN;
        r108.A.clear();
        r108.B.clear();
        r108.C.clear();
        bv5.h r109 = r108.f20903e;
        r109.f20894b = AudioStats.AUDIO_AMPLITUDE_NONE;
        r109.f20895c = 0;
        bv5.d r112 = r108.f20900b;
        if (r112 == null) goto L31;
        r112.onEvent("engine_start", MapsKt.mapOf(TuplesKt.to("accuracyStartThreshM", Double.valueOf(r108.f20899a.f20870e))));
    L31:
        this.f265810g = r108;
        PthreadHandlerThreadV2 r113 = new PthreadHandlerThreadV2("BDNav-Heading-Eskf");
        ThreadMethodProxy.start(r113);
        Handler r114 = new Handler(r113.getLooper());
        e r115 = new e(this);
        a(r102, r115, r104, r114);
        a(r102, r115, r105, r114);
        a(r102, r115, r106, r114);
        if (r107 == null) goto L34;
        a(r102, r115, r107, r114);
    L34:
        this.f265806c = r102;
        this.f265804a = r113;
        this.f265805b = r114;
        this.f265807d = r115;
        this.f265812i = r110.f22283a;
        this.f265813j = 0;
        this.f265814k = 0;
        this.f265809f = true;
        return true;
    L36:
        d37.i r116 = d37.i.f466749a;
        d37.i.c("EskfHeadingSensor start: missing required sensor acc=" + r104 + " gyro=" + r105 + " rotv=" + r106);
        return false;
    L17:
        r104 = null;
    L38:
        th = move-exception;
        d37.i r117 = d37.i.f466749a;
        d37.i.c("EskfHeadingSensor start: load config failed: " + th);
        return false;
    L8:
        r102 = null;
        goto L10
    }

    public static final void b(EskfDeviceHeadingSensor r110, SensorEvent r111) {
        r110.getClass();
        long r100 = SystemClock.elapsedRealtimeNanos();
        if ((r100 - r110.f265814k) < 100000000) goto L7;
        r110.f265814k = r100;
        r110.f265811h.onEvent("raw_imu", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", Integer.valueOf(r111.sensor.getType())), TuplesKt.to(BaseSwitches.V, CollectionsKt.joinToString$default(ArraysKt.take(r111.values, 6), ",", null, null, 0, null, null, 62, null))}));
        return;
    }

    public static void a(SensorManager r100, e r101, Sensor r102, Handler r103) {
        if (fna.g.d() == true) goto L6;
        Boolean r104 = Boolean.valueOf(r100.registerListener(r101, r102, 20000, r103));
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Boolean");
        r104.booleanValue();
        return;
    L6:
        Boolean r105 = Boolean.valueOf(r100.registerListener(r101, r102, 20000, r103));
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Boolean");
        r105.booleanValue();
        ona.b.a(new ona.a(r101.hashCode(), Integer.valueOf(r102.hashCode())));
    }
}
