package com.bytedance.livesdk.ktvcommon.midi.controller;

import al6.d;
import al6.e;
import androidx.camera.video.AudioStats;
import bl6.f;
import bl6.g;
import bl6.i;
import bl6.j;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.utils.u2;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.livesdk.ktvcommon.midi.model.HitType;
import com.bytedance.livesdk.ktvimpl.base.midi.KaraokeMidiComponentV2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.TypesJVMKt;
import zk6.h;
import zk6.k;
import zk6.o;

/* JADX INFO: loaded from: classes20.dex */
public final class MidiControllerImpl implements zk6.b, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f256007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.bytedance.livesdk.ktvcommon.midi.controller.a> f256008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double[] f256009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f256010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f256011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<f> f256012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f256013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f256014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f256015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public bl6.b f256016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f256017k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f256018l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f256019m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f256020n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f256021o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f256022p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f256023q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f256024r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f256025s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f256026t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final k f256027u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f256028v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final al6.g f256029w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final al6.h f256030x;

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MidiControllerImpl f256031a;

        public a(MidiControllerImpl r100) {
            this.f256031a = r100;
        }

        @Override // com.bytedance.livesdk.ktvcommon.midi.controller.c
        public final void a(b r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            boolean r101 = false;
            this.f256031a.f256011e = false;
            if (r100.f256035d == false) goto L18;
            String r102 = r100.f256033b;
            if (r102 == null) goto L18;
            if (r102.length() <= 0) goto L9;
            boolean r103 = true;
        L10:
            if (r103 != true) goto L18;
            String r104 = r100.f256034c;
            if (r104 == null) goto L18;
            if (r104.length() <= 0) goto L16;
            r101 = true;
        L16:
            if (r101 != true) goto L18;
            this.f256031a.i(r100.f256033b, r100.f256034c);
            return;
        L9:
            r103 = false;
        L18:
            int r105 = cl6.a.f24110a;
            String r106 = "Failed to download music files, mid: " + r100.f256032a;
            Intrinsics.checkNotNullParameter("KTV-Midi-Controller", "tag");
            Intrinsics.checkNotNullParameter(r106, "msg");
            jy0.b.b("KTV-Midi-Controller", r106, null);
        }
    }

    @Override // zk6.o
    public final void e() {
    }

    @Override // zk6.o
    public final void d() {
        if (this.f256014h == true) goto L5;
        return;
    L5:
        this.f256028v.g(this.f256009c);
        double[] r100 = this.f256009c;
        int r101 = r100.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L15;
        if (r100[r102] != AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L13;
        r102 = r102 + 1;
        goto L7
    L13:
        boolean r104 = false;
    L16:
        this.f256015i += this.f256007a;
        List<f> r105 = this.f256012f;
        if (r105 != null) goto L20;
        return;
    L20:
        if (r104 == true) goto L223;
        al6.g r106 = this.f256029w;
        int r107 = this.f256013g;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r105, DBDefinition.SEGMENT_TABLE_NAME);
        int r108 = CollectionsKt.getLastIndex(r105);
        if (r107 < 0) goto L26;
        if (r108 < r107) goto L26;
        ((f) ListProtector.get(r105, r107)).getClass();
        throw null;
    L26:
        int r109 = r107 + 1;
        if (r109 < r105.size()) goto L228;
        Pair r110 = TuplesKt.to(null, null);
        Integer r111 = (Integer) r110.component1();
        Integer r112 = (Integer) r110.component2();
        if (r112 != null) goto L31;
    L33:
        if (r111 == null) goto L223;
        al6.h r113 = this.f256030x;
        double[] r114 = this.f256009c;
        int r115 = this.f256020n;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r114, "scoreInfoArr");
        r113.f4154g.getClass();
        Intrinsics.checkNotNullParameter(r114, "scoreInfoArr");
        if (r114.length < 13) goto L37;
        boolean r116 = true;
    L38:
        if (r116 == false) goto L222;
        float r117 = (float) (Math.rint(r114[0] * 100.0d) / 100.0d);
        Math.rint(r114[1] * 100.0d);
        double r118 = r114[2];
        float r119 = (float) r114[3];
        double r120 = r114[4];
        double r121 = r114[5];
        double r122 = r114[6];
        float r123 = (float) r114[7];
        double r124 = r114[8];
        double r125 = r114[9];
        double r126 = r114[10];
        int r127 = (int) r114[11];
        float r128 = (float) r114[12];
        bl6.b r129 = r113.f4150c;
        if (r129 == null) goto L42;
        float r130 = r129.f19442c;
    L43:
        float r131 = RangesKt.coerceIn(r117 * r130, 0.0f, 100.0f);
        bl6.b r132 = r113.f4150c;
        if (r132 != null) goto L46;
    L48:
        bl6.b r133 = r113.f4155h.f4135a;
        if (r133 == null) goto L51;
        Map<String, i> r134 = r133.b();
    L52:
        if (r134 != null) goto L54;
        r134 = bl6.h.f19492a;
    L55:
        i r135 = r134.get("Perfect");
        if (r135 == null) goto L58;
        Integer r136 = r135.b();
    L59:
        if (r136 != null) goto L61;
    L65:
        i r137 = r134.get("Great");
        if (r137 == null) goto L68;
        Integer r138 = r137.b();
    L69:
        if (r138 != null) goto L71;
    L77:
        i r139 = r134.get("Good");
        if (r139 == null) goto L80;
        Integer r140 = r139.b();
    L81:
        if (r140 != null) goto L83;
    L89:
        HitType r141 = HitType.NONE;
    L90:
        al6.b r142 = r113.f4152e;
        r142.getClass();
        Intrinsics.checkNotNullParameter(r141, "hitType");
        if (r127 != r115) goto L93;
        int r143 = 0;
    L101:
        float r144 = ((float) Math.rint(r131 * 100.0f)) / 100.0f;
        r113.f4151d.put(Integer.valueOf(r127), Float.valueOf(r144));
        r113.f4148a = ((float) Math.rint(CollectionsKt.sumOfFloat(((LinkedHashMap) r113.f4151d).values()) * 100.0f)) / 100.0f;
        if ((!r113.f4151d.isEmpty()) == false) goto L104;
        float r145 = ((float) Math.rint((r113.f4148a / r113.f4151d.size()) * 100.0f)) / 100.0f;
    L105:
        r113.f4149b = r145;
        if (r127 <= r115) goto L127;
        e r146 = r113.f4153f;
        r146.getClass();
        Intrinsics.checkNotNullParameter(r141, "hitType");
        int r147 = d.f4139a[r141.ordinal()];
        if (r147 != 1) goto L110;
        j r148 = r146.f4140a;
        j r149 = j.a(r148, 0, 0, r148.f19495c + 1, 0, 0, 27);
    L126:
        r146.f4140a = r149;
        goto L127
    L110:
        if (r147 != 2) goto L112;
        j r150 = r146.f4140a;
        r149 = j.a(r150, 0, r150.f19494b + 1, 0, 0, 0, 29);
        goto L126
    L112:
        if (r147 == 3) goto L114;
        r149 = r146.f4140a;
        goto L126
    L114:
        if (r143 != 1) goto L116;
        j r151 = r146.f4140a;
        r149 = j.a(r151, r151.f19493a + 1, 0, 0, 0, 0, 30);
        goto L126
    L116:
        int r152 = r146.f4141b;
        if (2 > r143) goto L121;
        if (r152 <= r143) goto L121;
        j r153 = r146.f4140a;
        r149 = j.a(r153, 0, 0, 0, r153.f19496d + 1, 0, 23);
    L121:
        if (r143 < r152) goto L123;
        j r154 = r146.f4140a;
        r149 = j.a(r154, 0, 0, 0, 0, r154.f19497e + 1, 15);
        goto L126
    L123:
        r149 = r146.f4140a;
    L127:
        bl6.e r155 = new bl6.e(r144, r113.f4149b, r113.f4148a, r119, r123, r127, r128, r141, r143, 512);
        int r156 = r155.f19485f;
        float r157 = r155.f19480a;
        int r158 = this.f256020n;
        int r159 = -1;
        if (r156 > r158) goto L135;
        if (r156 == 0) goto L131;
    L134:
        boolean r160 = false;
    L136:
        if (r160 == false) goto L142;
        Iterator<com.bytedance.livesdk.ktvcommon.midi.controller.a> r161 = this.f256008b.iterator();
    L140:
        if (r161.hasNext() == false) goto L142;
        r161.next().c(r155);
    L142:
        int r162 = this.f256015i;
        Iterator<com.bytedance.livesdk.ktvcommon.midi.controller.a> r163 = this.f256008b.iterator();
    L144:
        if (r163.hasNext() == false) goto L146;
        r163.next().e(r162, r155);
        goto L144
    L146:
        float r164 = Math.abs(r155.f19483d - r155.f19484e);
        bl6.b r165 = this.f256016j;
        if (r165 == null) goto L149;
        Float r166 = r165.f19451l;
    L150:
        if (r166 != null) goto L152;
        HitType r167 = r155.f19487h;
        if (r167 != HitType.MISS) goto L157;
    L159:
        boolean r168 = false;
    L161:
        if (r168 == this.f256019m) goto L163;
        boolean r169 = true;
    L164:
        int r170 = r155.f19485f;
        float r171 = r155.f19480a;
        int r172 = this.f256020n;
        if (r170 > r172) goto L172;
        if (r170 == 0) goto L168;
    L171:
        boolean r173 = false;
    L173:
        bl6.b r174 = this.f256016j;
        if (r174 == null) goto L178;
        Integer r175 = r174.f19450k;
        if (r175 == null) goto L178;
        int r176 = r175.intValue();
    L179:
        if (r176 > 0) goto L181;
    L184:
        boolean r177 = true;
    L185:
        if (r169 == true) goto L187;
        if (r173 == true) goto L187;
    L201:
        List<f> r178 = this.f256012f;
        if (r178 == null) goto L220;
        int r179 = r178.size();
        int r180 = RangesKt.coerceAtLeast(this.f256013g + 1, 0);
        bl6.b r181 = this.f256016j;
        if (r181 == null) goto L209;
        Integer r182 = r181.a();
        if (r182 == null) goto L209;
        float r183 = r182.intValue() / 100.0f;
    L211:
        if (this.f256021o == true) goto L220;
        if (r179 <= 0) goto L220;
        if (r180 < (r179 * r183)) goto L220;
        Iterator<com.bytedance.livesdk.ktvcommon.midi.controller.a> r184 = this.f256008b.iterator();
    L217:
        if (r184.hasNext() == false) goto L219;
        com.bytedance.livesdk.ktvcommon.midi.controller.a r185 = r184.next();
        float r186 = this.f256030x.f4149b;
        r185.a();
        goto L217
    L219:
        j();
        this.f256021o = true;
    L209:
        r183 = 0.3f;
    L220:
        this.f256020n = r155.f19485f;
        this.f256013g = r111.intValue();
    L187:
        if (r177 == false) goto L201;
        this.f256019m = r168;
        this.f256018l = this.f256015i;
        if (r173 == true) goto L191;
    L193:
        Iterator<com.bytedance.livesdk.ktvcommon.midi.controller.a> r187 = this.f256008b.iterator();
    L195:
        if (r187.hasNext() == false) goto L201;
        com.bytedance.livesdk.ktvcommon.midi.controller.a r188 = r187.next();
        int r189 = cl6.b.f24111a;
        Integer r190 = Integer.valueOf(r159);
        String r191 = this.f256024r;
        Intrinsics.checkNotNullParameter(r155, "info");
        if (r190 == null) goto L199;
        int r192 = r190.intValue();
    L200:
        r188.d("ktv_midi_sei", new bl6.d(r155.f19483d, r155.f19484e, r155.f19481b, r155.f19485f, r192, r155.f19488i, r191));
        goto L195
    L199:
        r192 = r155.f19487h.getValue();
        goto L200
    L191:
        if (r155.f19485f < 0) goto L193;
        r159 = r155.f19487h.getValue();
        goto L193
    L181:
        if ((this.f256015i - this.f256018l) >= r176) goto L184;
        r177 = false;
    L178:
        r176 = 0;
        goto L179
    L168:
        if (r171 <= 0.0f) goto L171;
        if (r172 != (-1)) goto L171;
    L172:
        r173 = true;
        goto L173
    L163:
        r169 = false;
        goto L164
    L157:
        if (r167 == HitType.NONE) goto L159;
    L158:
        r168 = true;
        goto L161
    L152:
        if (r164 >= r166.floatValue()) goto L159;
    L149:
        r166 = null;
        goto L150
    L131:
        if (r157 <= 0.0f) goto L134;
        if (r158 != (-1)) goto L134;
    L135:
        r160 = true;
        goto L136
    L104:
        r145 = r144;
        goto L105
    L93:
        if (r127 > r115) goto L95;
    L100:
        r142.f4138c = r141;
        r143 = r142.f4136a;
        goto L101
    L95:
        if (r141 == HitType.PERFECT) goto L97;
    L99:
        r142.f4136a = 1;
        goto L100
    L97:
        if (r142.f4138c != r141) goto L99;
        int r193 = r142.f4136a + 1;
        r142.f4136a = r193;
        r142.f4137b = Math.max(r142.f4137b, r193);
        goto L100
    L83:
        if (r139.a() == null) goto L89;
        Integer r194 = r139.b();
        Intrinsics.checkNotNull(r194);
        if (r131 < r194.intValue()) goto L89;
        Integer r195 = r139.a();
        Intrinsics.checkNotNull(r195);
        if (r131 > r195.intValue()) goto L89;
        r141 = HitType.GOOD;
        goto L90
    L80:
        r140 = null;
        goto L81
    L71:
        if (r137.a() == null) goto L77;
        Integer r196 = r137.b();
        Intrinsics.checkNotNull(r196);
        if (r131 < r196.intValue()) goto L77;
        Integer r197 = r137.a();
        Intrinsics.checkNotNull(r197);
        if (r131 > r197.intValue()) goto L77;
        r141 = HitType.GREAT;
        goto L90
    L68:
        r138 = null;
        goto L69
    L61:
        if (r135.a() == null) goto L65;
        Integer r198 = r135.b();
        Intrinsics.checkNotNull(r198);
        if (r131 < r198.intValue()) goto L65;
        r141 = HitType.PERFECT;
        goto L90
    L58:
        r136 = null;
        goto L59
    L54:
        Map<String, i> r199 = bl6.h.f19492a;
        goto L55
    L51:
        r134 = null;
        goto L52
    L46:
        if (r132.f19443d != true) goto L48;
        r131 = r132.f19444e;
        goto L48
    L42:
        r130 = 1.2f;
        goto L43
    L222:
        throw new IllegalArgumentException(("Invalid score info array length: " + r114.length).toString());
    L37:
        r116 = false;
        goto L38
    L31:
        if (r112.intValue() <= this.f256013g) goto L33;
        this.f256013g = r112.intValue();
        goto L33
    L228:
        f r200 = (f) ListProtector.get(r105, r109);
        Intrinsics.checkNotNullParameter(r200, MonitorConstants.SEGMENT);
        r200.getClass();
        throw null;
    L223:
        al6.g r201 = this.f256029w;
        int r202 = this.f256013g;
        r201.getClass();
        Intrinsics.checkNotNullParameter(r105, DBDefinition.SEGMENT_TABLE_NAME);
        if (r202 >= CollectionsKt.getLastIndex(r105)) goto L226;
        return;
    L226:
        ((f) CollectionsKt.last(r105)).getClass();
        throw null;
    L11:
        r103 = false;
        goto L12
    L15:
        r104 = true;
        goto L16
    }

    public final void j() {
        if (this.f256026t == true) goto L25;
        int r100 = 0;
        if (this.f256025s.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        if (this.f256022p.length() != 0) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L15;
        return;
    L15:
        if (this.f256023q.length() != 0) goto L17;
        boolean r103 = true;
    L18:
        if (r103 == true) goto L28;
        long r104 = RangesKt.coerceAtLeast(this.f256013g + 1, 0);
        List<f> r105 = this.f256012f;
        if (r105 == null) goto L23;
        r100 = r105.size();
    L23:
        final double r106 = this.f256030x.f4149b;
        int r107 = com.bytedance.livesdk.ktvcommon.api.h.f255903a;
        long r108 = u2.a(this.f256022p);
        long r109 = u2.a(this.f256023q);
        long r110 = u2.a(this.f256024r);
        String r111 = this.f256025s;
        Function1<com.bytedance.livesdk.ktvcommon.api.b, Unit> r112 = new MidiControllerImpl$reportIfNeeded$1(this, r106);
        MidiControllerImpl$reportIfNeeded$2 r113 = MidiControllerImpl$reportIfNeeded$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r112, "onSuccess");
        Intrinsics.checkNotNullParameter(r113, LynxVideoManagerLite.EVENT_ON_ERROR);
        an0.b r114 = an0.b.f4492a;
        uz0.c r115 = new uz0.c();
        r114.getClass();
        Intrinsics.checkNotNullParameter(r115, "$this$beforeConfigureRequest");
        uz0.f r116 = new uz0.f(r115.f552161b);
        r116.a("song_id", Long.valueOf(r108).toString());
        r116.a("room_id", Long.valueOf(r109).toString());
        r116.a(com.bytedance.android.ec.core.event.a.KEY_SCORE, Double.valueOf(r106).toString());
        r116.a("singer_id", Long.valueOf(r110).toString());
        r116.a("singer_open_id", r111);
        r116.a("total_lyric_count", Long.valueOf(r100).toString());
        r116.a("sung_lyric_count", Long.valueOf(r104).toString());
        Intrinsics.checkNotNullParameter(r115, "$this$afterConfigureRequest");
        Observable r117 = ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.MultiLink, "/webcast/ktv/report_midi_score/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.livesdk.ktvcommon.api.b.class)), Extra.class, r115.f552163d, r115.f552160a, r115.f552161b, r115.f552162c);
        int r118 = p.f267522a;
        r117.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.livesdk.ktvcommon.api.f(r112), new com.bytedance.livesdk.ktvcommon.api.g(r113));
        return;
    L28:
        return;
    L17:
        r103 = false;
        goto L18
    L12:
        r102 = false;
        goto L13
    L7:
        r101 = false;
        goto L8
    }

    @Override // zk6.d
    public final void pauseMusic() {
        if (this.f256014h == false) goto L6;
        this.f256014h = false;
        this.f256027u.e(this);
        int r100 = cl6.a.f24110a;
        cl6.a.a("Music paused at " + this.f256015i + " ms");
        return;
    }

    @Override // zk6.c
    public final g c() {
        return this.f256017k;
    }

    @Override // zk6.a
    public final void a(KaraokeMidiComponentV2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f256008b.contains(r100) == true) goto L6;
        this.f256008b.add(r100);
        return;
    }

    @Override // zk6.c
    public final f f(int r100) {
        List<f> r101 = this.f256012f;
        if (r101 == null) goto L21;
        al6.g r102 = this.f256029w;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, DBDefinition.SEGMENT_TABLE_NAME);
        if (r102.f4142a != r101) goto L30;
        int[] r103 = r102.f4143b;
        if (r103 == null) goto L30;
        if (r102.f4144c == null) goto L30;
        Intrinsics.checkNotNull(r103);
        int[] r104 = r102.f4144c;
        Intrinsics.checkNotNull(r104);
        int r105 = -1;
        int r106 = r103.length - 1;
        int r107 = 0;
    L11:
        if (r107 > r106) goto L16;
        int r108 = (r107 + r106) >>> 1;
        if (r103[r108] <= r100) goto L14;
        r106 = r108 - 1;
        goto L11
    L14:
        r107 = r108 + 1;
        r105 = r108;
        goto L11
    L16:
        if (r105 < 0) goto L21;
        if (r100 > r104[r105]) goto L21;
        return (f) ListProtector.get(r101, r105);
    L30:
        return r102.f4147f.b(r101, r100);
    L21:
        return null;
    }

    @Override // zk6.d
    public final void g(int r100) {
        int r101 = Math.abs(this.f256015i - r100);
        bl6.b r102 = this.f256016j;
        if (r102 == null) goto L7;
        Integer r103 = r102.f19447h;
        if (r103 == null) goto L7;
        int r104 = r103.intValue();
    L8:
        bl6.b r105 = this.f256016j;
        int r106 = 0;
        if (r105 == null) goto L13;
        Boolean r107 = r105.f19449j;
        if (r107 == null) goto L13;
        boolean r108 = r107.booleanValue();
    L14:
        if (r108 == false) goto L16;
    L17:
        if (r101 < r104) goto L54;
        this.f256015i = r100;
        int r109 = cl6.a.f24110a;
        cl6.a.a("Seek to " + r100 + " ms");
        List<f> r110 = this.f256012f;
        if (r110 == null) goto L55;
        al6.g r111 = this.f256029w;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r110, DBDefinition.SEGMENT_TABLE_NAME);
        if (r111.f4142a != r110) goto L37;
        int[] r112 = r111.f4143b;
        if (r112 == null) goto L37;
        if (r111.f4144c == null) goto L37;
        Intrinsics.checkNotNull(r112);
        int[] r113 = r111.f4144c;
        Intrinsics.checkNotNull(r113);
        int r114 = -1;
        int r115 = r112.length - 1;
    L28:
        if (r106 > r115) goto L33;
        int r116 = (r106 + r115) >>> 1;
        if (r112[r116] <= r100) goto L31;
        r115 = r116 - 1;
        goto L28
    L31:
        r106 = r116 + 1;
        r114 = r116;
        goto L28
    L33:
        if (r114 >= 0) goto L35;
    L43:
        Integer r117 = null;
    L44:
        if (r117 == null) goto L46;
        this.f256013g = r117.intValue();
    L46:
        this.f256028v.f(r100);
        return;
    L35:
        if (r100 > r113[r114]) goto L43;
        r117 = Integer.valueOf(r114);
    L37:
        f r118 = r111.f4147f.b(r110, r100);
        if (r118 == null) goto L43;
        int r119 = r110.indexOf(r118);
        if (r119 < 0) goto L43;
        r117 = Integer.valueOf(r119);
        goto L44
    L55:
        return;
    L54:
        return;
    L16:
        if (r100 >= this.f256015i) goto L17;
        return;
    L13:
        r108 = false;
    L7:
        r104 = 1800;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.List<bl6.f>] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.ArrayList] */
    @Override // zk6.c
    public final List<f> b(int r110, int r111) {
        List<f> r100 = this.f256012f;
        if (r100 == null) goto L52;
        al6.g r101 = this.f256029w;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, DBDefinition.SEGMENT_TABLE_NAME);
        if (r101.f4142a != r100) goto L49;
        int[] r102 = r101.f4143b;
        if (r102 == null) goto L49;
        if (r101.f4144c == null) goto L49;
        Intrinsics.checkNotNull(r102);
        int[] r103 = r101.f4144c;
        Intrinsics.checkNotNull(r103);
        int r104 = r102.length - 1;
        int r105 = r102.length;
        int r106 = 0;
    L11:
        if (r106 > r104) goto L16;
        int r107 = (r106 + r104) >>> 1;
        if (r102[r107] < r110) goto L14;
        r104 = r107 - 1;
        r105 = r107;
        goto L11
    L14:
        r106 = r107 + 1;
        goto L11
    L16:
        int r108 = Math.max(0, r105 - 1);
        ?? r109 = new ArrayList();
        int r112 = r102.length;
    L17:
        if (r108 >= r112) goto L50;
        boolean r113 = r101.f4145d;
        if (r113 == false) goto L24;
        if (r102[r108] > r111) goto L25;
    L26:
        boolean r114 = false;
    L27:
        if (r114 == true) goto L50;
        if (r113 == false) goto L33;
        if (r102[r108] <= r111) goto L34;
    L35:
        boolean r115 = false;
    L37:
        if (r101.f4146e == false) goto L42;
        if (r103[r108] >= r110) goto L43;
    L44:
        boolean r116 = false;
    L45:
        if (r115 == false) goto L48;
        if (r116 == false) goto L48;
        r109.add(ListProtector.get(r100, r108));
    L48:
        r108 = r108 + 1;
    L43:
        r116 = true;
        goto L45
    L42:
        if (r103[r108] <= r110) goto L44;
    L34:
        r115 = true;
        goto L37
    L33:
        if (r102[r108] >= r111) goto L35;
    L25:
        r114 = true;
        goto L27
    L24:
        if (r102[r108] < r111) goto L26;
    L50:
        if (r109 == 0) goto L52;
        return r109;
    L49:
        r109 = r101.f4147f.a(r100, r110, r111);
    L52:
        return CollectionsKt.emptyList();
    }

    public final void i(String r100, String r101) {
        if (this.f256012f == null) goto L5;
    L9:
        cl6.a.a("MIDI segments already loaded or loading, skip loading");
        return;
    L5:
        if (this.f256010d == true) goto L9;
        this.f256010d = true;
        this.f256028v.b(r100, r101, new MidiControllerImpl$loadAndInitMidiSegments$1(this));
    }

    public MidiControllerImpl(k r100, String r101, h r102) {
        al6.g r103 = new al6.g();
        al6.h r104 = new al6.h();
        Intrinsics.checkNotNullParameter(r100, "platform");
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "midiDataManager");
        Intrinsics.checkNotNullParameter(r103, "playbackEngine");
        Intrinsics.checkNotNullParameter(r104, "scoreEngine");
        this.f256027u = r100;
        this.f256028v = r102;
        this.f256029w = r103;
        this.f256030x = r104;
        this.f256007a = 33;
        this.f256008b = new CopyOnWriteArrayList();
        this.f256009c = new double[13];
        this.f256013g = -1;
        HitType r105 = HitType.NONE;
        this.f256018l = -1;
        this.f256020n = -1;
        r102.d();
        r102.c(r101, new MidiControllerImpl$fetchMidiConfig$1(this));
        this.f256022p = "";
        this.f256023q = "";
        this.f256024r = "";
        this.f256025s = "";
    }

    @Override // zk6.d
    public final void h(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        Intrinsics.checkNotNullParameter(r101, "midiUrl");
        Intrinsics.checkNotNullParameter(r102, "lyricUrl");
        if (this.f256012f == null) goto L9;
        if (this.f256014h == true) goto L20;
        this.f256014h = true;
        this.f256021o = false;
        this.f256027u.b(this.f256007a, this);
        return;
    L20:
        return;
    L9:
        if (this.f256011e == false) goto L13;
        cl6.a.a("MIDI file is downloading, skip loading");
        return;
    L13:
        if (this.f256027u.c(r101, r100) == true) goto L15;
    L18:
        this.f256011e = true;
        this.f256028v.e(r100, r101, r102, new a(this));
        return;
    L15:
        if (this.f256027u.f(r102, r100) == false) goto L18;
        i(this.f256027u.d(r101, r100), this.f256027u.a(r102, r100));
    }
}
