package ms.bd.c;

import androidx.core.view.InputDeviceCompat;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class r0 implements j0 {
    public static final String A = null;
    public static final String B = null;
    public static final String C = null;
    public static final String D = null;
    public static final String E = null;
    public static final String F = null;
    public static volatile r0 G;
    public static final HashMap H = null;
    public static final AtomicInteger I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final HashMap f515304J = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f515305b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f515306c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f515307d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f515308e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f515309f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f515310g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f515311h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f515312i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f515313j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f515314k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f515315l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f515316m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f515317n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AtomicInteger f515318o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AtomicInteger f515319p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AtomicInteger f515320q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final AtomicInteger f515321r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final AtomicInteger f515322s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final AtomicInteger f515323t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f515324u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f515325v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f515326w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f515327x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f515328y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f515329z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f515330a;

    static {
        f515324u = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "dc4870", new byte[]{99, 100, 85});
        f515325v = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "1e5945", new byte[]{53, 114, 66});
        f515326w = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "5b61e0", new byte[]{39, 109, 65});
        f515327x = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "91ee37", new byte[]{59, 62, 18});
        f515328y = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "f39636", new byte[]{113, 35, 79});
        f515329z = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "9a6810", new byte[]{59, 96, 64});
        A = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "85e760", new byte[]{58, 62, 18});
        B = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "edbd4b", new byte[]{112, 118, 21});
        C = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "9b74bf", new byte[]{44, 115, 71});
        D = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "137299", new byte[]{35, 57, 79});
        E = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "b54cc7", new byte[]{99, 54, 85, 26});
        F = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "01bb30", new byte[]{44, 43, 3});
        f515305b = 257;
        f515306c = -1;
        f515307d = new AtomicBoolean(false);
        new AtomicBoolean(true);
        f515308e = 2;
        f515309f = 255;
        f515310g = 5;
        f515311h = 5;
        f515312i = 5;
        f515313j = 5;
        f515314k = 3;
        f515315l = 20;
        f515316m = 50;
        f515317n = 5000;
        f515318o = new AtomicInteger(0);
        f515319p = new AtomicInteger(0);
        f515320q = new AtomicInteger(0);
        f515321r = new AtomicInteger(0);
        f515322s = new AtomicInteger(0);
        f515323t = new AtomicInteger(0);
        H = new HashMap();
        I = new AtomicInteger(o0.f515254b.f515271a);
        f515304J = new HashMap();
    }

    public static r0 a() {
        if (G != null) goto L15;
        monitor-enter(r0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (G != null) goto L9;
        G = new r0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0.class);     // Catch: Throwable -> L11
    L15:
        return G;
    }

    public r0() {
        k0.a().f515179b = this;
    }

    public final void b(String r210, int r211) {
        int r100 = n0.f515231b.f515238a;
        int r101 = o0.f515255c.f515271a;
        if (r211 != i0.f515158b.f515162a) goto L5;
    L7:
        if (r210 != null) goto L10;
    L124:
        l0 r102 = null;
    L125:
        int r110 = 0;
    L129:
        if (r102 != null) goto L131;
    L279:
        if (r102 != null) goto L281;
    L283:
        if (r110 > 0) goto L285;
    L292:
        if (r102 != null) goto L294;
    L296:
        AtomicInteger r103 = f515323t;
        if (r103.decrementAndGet() < f515308e) goto L299;
        k0.a().b(i0.f515160d, null);
        boolean r104 = false;
        r103.set(0);
    L300:
        f515307d.set(r104);
        return;
    L299:
        r104 = false;
        goto L300
    L294:
        if (r101 <= r102.f515202n) goto L296;
        r102.f515202n = r101;
        goto L296
    L285:
        if (r100 != n0.f515232c.f515238a) goto L287;
    L288:
        if (r102 != null) goto L290;
    L291:
        p2.a(134217732, r110, r101, null, null);
        goto L292
    L290:
        if (r102.f515202n >= r101) goto L292;
    L287:
        if (r100 != n0.f515233d.f515238a) goto L292;
    L281:
        if (r102.f515192d != p0.f515276c.f515279a) goto L283;
        I.set(r101);
        goto L283
    L131:
        if (r101 < o0.f515257e.f515271a) goto L279;
        int r105 = r102.f515190b;
        n0 r106 = n0.f515235f;
        if (r105 == r106.f515238a) goto L135;
    L137:
        o0 r107 = o0.f515258f;
        r107.getClass();
        if (r102.f515192d != p0.f515276c.f515279a) goto L140;
        int r108 = I.get();
    L142:
        if (r102.f515192d != p0.f515277d.f515279a) goto L157;
        if (r102.f515201m < r102.f515199k) goto L147;
    L165:
        boolean r109 = false;
    L167:
        g0 r111 = g0.f515143b;
        int r112 = r107.f515271a;
        if (r109 == true) goto L170;
        boolean r113 = true;
        boolean r114 = false;
    L190:
        if (r112 < o0.f515260h.f515271a) goto L277;
        r102.f515201m++;
        r102.f515200l = System.currentTimeMillis();
        o0.f515261i.getClass();
        int r115 = f515306c;
        if (r114 == true) goto L195;
    L227:
        int r116 = 0;
    L229:
        if (r116 == 0) goto L231;
        o0 r117 = o0.f515262j;
    L276:
        int r118 = r117.f515271a;
    L278:
        r101 = r118;
        goto L279
    L231:
        if (r102.f515190b != r106.f515238a) goto L233;
        r117 = o0.f515263k;
        goto L276
    L233:
        o0.f515264l.getClass();
        int r119 = r111.ordinal();
        if (r119 == 2) goto L247;
        if (r119 == 3) goto L245;
        if (r119 != 4) goto L238;
        g0 r120 = g0.f515146e;
    L246:
        boolean r121 = false;
    L248:
        int r122 = r120.f515149a;
        if (r113 == false) goto L251;
        int r123 = 134217731;
    L252:
        r115 = ((Integer) p2.a(r123, r122, r102.f515194f, r102.f515193e, r102.f515197i)).intValue();
    L253:
        if (r115 != 0) goto L274;
        o0 r124 = o0.f515266n;
        r124.getClass();
        if (r121 == true) goto L258;
        r118 = r124.f515271a;
        goto L278
    L258:
        if (this.f515330a == null) goto L260;
    L269:
        Object r125 = this.f515330a;
        if (r125 != null) goto L272;
        o0 r126 = o0.f515267o;
    L273:
        r118 = r126.f515271a;
        goto L278
    L272:
        p2.a(InputDeviceCompat.SOURCE_HDMI, r102.f515194f, ((Long) r125).longValue(), r102.f515193e, d2.f515131b.f515132a);
        r126 = o0.f515268p;
        goto L273
    L260:
        monitor-enter(r0.class);
    L266:
        th = move-exception;
        throw th;
    L262:
        if (this.f515330a != null) goto L264;
        this.f515330a = p2.a(50331651, 0, 0, null, null);     // Catch: Throwable -> L266
    L264:
        monitor-exit(r0.class);     // Catch: Throwable -> L266
        goto L269
    L274:
        r118 = o0.f515265m.f515271a;
        goto L278
    L251:
        r123 = 134217730;
        goto L252
    L238:
        if (r119 != 5) goto L240;
        r120 = g0.f515147f;
        goto L246
    L240:
        if (r119 == 6) goto L242;
        r121 = false;
        goto L253
    L242:
        r120 = g0.f515148g;
        goto L246
    L245:
        r120 = g0.f515145d;
        goto L246
    L247:
        r120 = g0.f515146e;
        r121 = true;
        goto L248
    L195:
        if (r102.f515202n >= o0.f515263k.f515271a) goto L227;
        if (r102.f515201m > 3) goto L228;
        int r127 = ((q0[]) q0.f515297f.clone())[r102.f515191c].ordinal();
        if (r127 == 1) goto L204;
        if (r127 != 2) goto L228;
    L204:
        int r128 = r102.f515195g;
        int r129 = r102.f515190b;
        m0 r130 = m0.f515209b;
        r130.getClass();
        int r131 = ((n0[]) n0.f515237h.clone())[r129].ordinal();
        if (r131 == 1) goto L215;
        if (r131 == 2) goto L214;
        if (r131 == 3) goto L213;
        if (r131 == 4) goto L212;
        if (r131 == 5) goto L211;
        int r132 = r130.f515215a;
    L218:
        if (r132 == r130.f515215a) goto L228;
        if (r102.f515191c != q0.f515294c.f515298a) goto L226;
        if (r102.f515189a >= f515305b) goto L226;
        r128 = 1;
    L226:
        if (((Integer) p2.a(134217729, r132, r128, r102.f515196h, r102.f515198j)).intValue() != 0) goto L228;
    L211:
        m0 r133 = m0.f515214g;
    L216:
        r132 = r133.f515215a;
        goto L218
    L212:
        r133 = m0.f515213f;
        goto L216
    L213:
        r133 = m0.f515211d;
        goto L216
    L214:
        r133 = m0.f515212e;
        goto L216
    L215:
        r133 = m0.f515210c;
    L228:
        r116 = r115;
        goto L229
    L277:
        r118 = o0.f515259g.f515271a;
        goto L278
    L170:
        int r134 = ((n0[]) n0.f515237h.clone())[r102.f515190b].ordinal();
        if (r134 == 1) goto L183;
        if (r134 == 2) goto L180;
        if (r134 == 3) goto L179;
        if (r134 == 4) goto L178;
        if (r134 == 5) goto L177;
        g0 r135 = r111;
        r113 = true;
    L184:
        r114 = false;
    L185:
        if (r135 == r111) goto L188;
        r112 = o0.f515260h.f515271a;
    L188:
        r111 = r135;
        goto L190
    L177:
        r135 = g0.f515148g;
    L181:
        r113 = false;
    L182:
        r114 = true;
        goto L185
    L178:
        r135 = g0.f515147f;
        r113 = true;
        goto L182
    L179:
        r135 = g0.f515145d;
        goto L181
    L180:
        r135 = g0.f515146e;
        goto L181
    L183:
        r135 = g0.f515144c;
        r113 = false;
        goto L184
    L147:
        if ((System.currentTimeMillis() - r102.f515200l) < f515317n) goto L165;
        if (r108 != o0.f515268p.f515271a) goto L152;
    L166:
        r109 = true;
        goto L167
    L152:
        if (r108 == o0.f515266n.f515271a) goto L166;
        if (r108 == o0.f515270r.f515271a) goto L166;
    L157:
        if (r108 == o0.f515254b.f515271a) goto L166;
        if (r108 == o0.f515262j.f515271a) goto L166;
        if (r108 == o0.f515269q.f515271a) goto L166;
        if (r108 != o0.f515267o.f515271a) goto L165;
    L140:
        r108 = r102.f515202n;
        goto L142
    L135:
        if (r211 == i0.f515159c.f515162a) goto L137;
    L10:
        if (r211 != i0.f515159c.f515162a) goto L312;
        r102 = (l0) f515304J.get(r210);
        if (r102 == null) goto L125;
        int r136 = r102.f515194f;
    L14:
        r110 = r136;
        goto L129
    L312:
        JSONObject r137 = new JSONObject(r210);     // Catch: Exception -> L126
        int r138 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r137, f515324u));     // Catch: Exception -> L126
        int r139 = f515305b;     // Catch: Exception -> L126
        if (r138 < (r139 - 1)) goto L124;
        if (r138 > r139) goto L124;
        String r140 = JSONObjectProtectorUtils.getString(r137, f515325v);     // Catch: Exception -> L126
        if (r140 == null) goto L124;
        l0 r141 = (l0) H.get(r140);     // Catch: Exception -> L126
        if (r141 == null) goto L25;
        r101 = r141.f515202n;     // Catch: Exception -> L123
        r102 = r141;
        goto L125
    L25:
        r100 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r137, f515326w));     // Catch: Exception -> L123
        String r142 = JSONObjectProtectorUtils.getString(r137, E);     // Catch: Exception -> L123
        String r143 = "";
        if (r100 != n0.f515232c.f515238a) goto L32;
        if (f515318o.get() > f515310g) goto L122;
        String r144 = "";
        String r145 = "";
        int r146 = 0;
        int r147 = 0;
    L74:
        String r148 = JSONObjectProtectorUtils.getString(r137, f515329z);     // Catch: Exception -> L123
        if (r148 == null) goto L122;
        if (r148.length() > f515315l) goto L122;
        int r149 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r137, A));     // Catch: Exception -> L123
        if (r149 > 0) goto L310;
    L121:
        r110 = r149;
        r102 = r141;
        goto L129
    L310:
    L119:
        int r212 = r149;
    L120:
        int r150 = r212;
        l0 r151 = r141;
    L127:
        r136 = r150;
        r102 = r151;
    L128:
        r101 = o0.f515256d.f515271a;
        goto L14
    L82:
        if (r149 > f515309f) goto L121;
        int r152 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r137, f515328y));     // Catch: Exception -> L119
        if (r152 >= p0.f515278e.f515279a) goto L121;
        if (r152 <= p0.f515275b.f515279a) goto L121;
        int r213 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r137, F));     // Catch: Exception -> L91
    L92:
        if (r213 < 0) goto L121;
        r212 = r149;
        l0 r153 = new l0(r138, r100, r146, r152, r148, r212, r147, r145, r142, r144, r213);     // Catch: Exception -> L302
        H.put(r140, r153);     // Catch: Exception -> L118
        if (r100 != n0.f515232c.f515238a) goto L101;
        AtomicInteger r154 = f515318o;     // Catch: Exception -> L118
    L115:
        r154.incrementAndGet();     // Catch: Exception -> L118
    L116:
        r110 = r212;
        r101 = o0.f515257e.f515271a;     // Catch: Exception -> L118
        r102 = r153;
        goto L129
    L101:
        if (r100 != n0.f515233d.f515238a) goto L104;
        r154 = f515319p;     // Catch: Exception -> L118
        goto L115
    L104:
        if (r100 != n0.f515234e.f515238a) goto L107;
        r154 = f515320q;     // Catch: Exception -> L118
        goto L115
    L107:
        if (r100 != n0.f515235f.f515238a) goto L113;
        HashMap r155 = f515304J;     // Catch: Exception -> L118
        if (r155.get(r142) != null) goto L111;
        r155.put(r142, r153);     // Catch: Exception -> L118
    L111:
        r154 = f515321r;     // Catch: Exception -> L118
        goto L115
    L113:
        if (r100 != n0.f515236g.f515238a) goto L116;
        r154 = f515322s;     // Catch: Exception -> L118
    L118:
        r102 = r153;
        r136 = r212;
    L91:
        r213 = 1;
    L122:
        r102 = r141;
        goto L125
    L32:
        if (r100 != n0.f515233d.f515238a) goto L37;
        if (f515319p.get() > f515311h) goto L122;
    L55:
        int r156 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r137, f515327x));     // Catch: Exception -> L123
        if (r156 >= q0.f515296e.f515298a) goto L122;
        if (r156 <= q0.f515293b.f515298a) goto L122;
        int r157 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r137, B));     // Catch: Exception -> L123
        if (r157 < 0) goto L122;
        if (r156 != q0.f515295d.f515298a) goto L70;
        r143 = JSONObjectProtectorUtils.getString(r137, C);     // Catch: Exception -> L123
        if (r143 == null) goto L122;
        if (r143.isEmpty() == true) goto L122;
    L70:
        String r158 = JSONObjectProtectorUtils.getString(r137, D);     // Catch: Exception -> L123
        if (r158 == null) goto L122;
        r144 = r143;
        r147 = r157;
        r145 = r158;
        r146 = r156;
        goto L74
    L37:
        if (r100 != n0.f515234e.f515238a) goto L42;
        if (f515320q.get() <= f515312i) goto L55;
    L42:
        if (r100 != n0.f515235f.f515238a) goto L51;
        if (f515321r.get() > f515313j) goto L122;
        if (r142 == null) goto L122;
        if (r142.length() <= f515316m) goto L55;
    L51:
        if (r100 != n0.f515236g.f515238a) goto L122;
        if (f515322s.get() <= f515314k) goto L55;
    L123:
        r151 = r141;
        r150 = 0;
    L126:
        r150 = 0;
        r151 = null;
        goto L127
    L5:
        if (r211 == i0.f515159c.f515162a) goto L7;
        goto L7
    }
}
