package com.larus.audio.call.aec;

import android.media.AudioRecord;
import android.os.Handler;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes24.dex */
public final class j implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<z> f288989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f288990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f288991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f288992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f288993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f288994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f288995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f288996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f288997i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f288998j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> f288999k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f289000l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f289001m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f289002n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final v58.a f289003o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.larus.audio.call.play.b f289004p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f289005q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final f f289006r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b f289007s;

    @Override // com.larus.audio.call.aec.w
    public final synchronized void e() {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.larus.audio.call.aec.v
    public final void R1() {
        com.larus.audio.call.util.e.f289645a.i(this.f288993e, "[unMute]");
        this.f288995g = -1;
        z r100 = k(this.f288990b);
        this.f288990b = r100;
        if (r100 == null) goto L5;
        return;
    L5:
        if (this.f288989a.size() > 0) goto L7;
        return;
    L7:
        if (this.f288989a.size() <= 0) goto L17;
        z r101 = k(this.f288989a.poll());
        if (r101 == null) goto L7;
        this.f288990b = r101;
        return;
    }

    @Override // com.larus.audio.call.aec.w
    public final void d() {
        b r100 = this.f289007s;
        if (r100 == null) goto L11;
        Long r101 = r100.f288956a;
        Long r102 = r100.f288957b;
        r100.f288958c = true;
        if (r101 == null) goto L9;
        if (r102 == null) goto L9;
        com.larus.audio.call.util.e r103 = com.larus.audio.call.util.e.f289645a;
        StringBuilder r104 = new StringBuilder("[Ref] TTS End[");
        SimpleDateFormat r105 = c.f288964a;
        r104.append(c.b(r101.longValue()));
        r104.append(" - ");
        r104.append(c.b(r102.longValue()));
        r104.append("][");
        r104.append(r102.longValue() - r101.longValue());
        r104.append(']');
        r103.i("Aec_Consume", r104.toString());
        return;
    L9:
        com.larus.audio.call.util.e.f289645a.e("Aec_Consume", "[Ref][ERROR] TTS End; but no sentence");
        return;
    }

    public final z l() {
        z r100 = this.f288989a.poll();
        if (r100 != null) goto L5;
        return r100;
    L5:
        if (r100.f289022a == (-1)) goto L7;
        return r100;
    L7:
        if (r100.f289023b != (-1)) goto L12;
        this.f289001m = -1;
        return this.f288989a.poll();
    L12:
        return r100;
    }

    @Override // com.larus.audio.call.aec.w
    public final void release() {
        com.larus.audio.call.util.e.f289645a.i(this.f288993e, "[release]");
        this.f288994f = false;
        i("release", false);
        com.larus.audio.call.util.c.a(new AecProcessor$release$1(this, null));
    }

    public j() {
        this.f288989a = new ConcurrentLinkedQueue();
        this.f288993e = "AecProcessor" + hashCode();
        this.f288995g = -1;
        this.f288996h = -1;
        this.f288998j = 1;
        this.f288999k = new ConcurrentLinkedQueue();
        this.f289001m = -1;
        boolean r100 = com.larus.audio.call.f.d().f289138n;
        this.f289002n = r100;
        this.f289003o = com.larus.audio.call.f.b(true);
        this.f289004p = com.larus.audio.call.f.a(true, r100, null);
        this.f289005q = "";
        this.f289006r = new f();
        this.f289007s = new b();
    }

    public static z k(z r110) {
        long r100 = System.currentTimeMillis();
        if (r110 == null) goto L11;
        long r101 = r110.f289023b;
        if (r101 > r100) goto L7;
        return null;
    L7:
        long r102 = r110.f289022a;
        if (r100 <= r102) goto L11;
        byte[] r103 = r110.f289024c;
        return z.a(r110, r100, 0, ArraysKt.sliceArray(r103, RangesKt.until((int) (((r100 - r102) / (r101 - r102)) * r103.length), r103.length)), false, 10);
    L11:
        return null;
    }

    @Override // com.larus.audio.call.aec.w
    public final boolean a(com.larus.audio.call.plugins.m r100) {
        Intrinsics.checkNotNullParameter(r100, "onAudioDataReceived");
        if (this.f288994f == false) goto L6;
        com.larus.audio.call.util.e.f289645a.i(this.f288993e, "[init] return, already init");
        return true;
    L6:
        this.f289006r.b(this.f289003o, this.f289004p, this.f289002n, r100);
        this.f288994f = true;
        v58.a r101 = this.f289003o;
        int r102 = r101.f553277c;
        int r103 = 2;
        if (r102 != 2) goto L9;
        int r104 = 2;
    L10:
        int r105 = r101.f553276b;
        if (r105 == 12) goto L14;
        r103 = 1;
    L14:
        this.f288998j = r103;
        int r106 = AudioRecord.getMinBufferSize(r101.f553275a, r105, r102);
        int r107 = (((r106 * 1000) / this.f289003o.f553275a) / r104) / this.f288998j;
        this.f288991c = r107;
        this.f288992d = ((r107 * this.f289004p.f289297c) * r104) / 1000;
        com.larus.audio.call.util.e.f289645a.i(this.f288993e, "[init] audioBufferSize:" + r106 + ", totalTimeInMs" + this.f288991c + ", refDataSize" + this.f288992d);
        return true;
    L9:
        r104 = 1;
        goto L10
    }

    @Override // com.larus.audio.call.aec.w
    public final synchronized void c(byte[] r110) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "originData");     // Catch: Throwable -> L26
        if (this.f288994f == true) goto L7;
    L23:
        com.larus.audio.call.util.e.f289645a.i(this.f288993e, "[RefData] return, init:" + this.f288994f);     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L7:
        if (this.f289006r.f288974f == false) goto L23;
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L26
        int r101 = r.f289018a;     // Catch: Throwable -> L26
        boolean r102 = this.f289002n;     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r110, "array");     // Catch: Throwable -> L26
        long r103 = (r110.length * 1000) / (com.larus.audio.call.f.a(true, r102, null).f289297c * 2);     // Catch: Throwable -> L26
        long r104 = this.f288996h;     // Catch: Throwable -> L26
        if (r104 != (-1)) goto L14;
        this.f288996h = r100 + r103;     // Catch: Throwable -> L26
    L12:
        long r105 = r100;
        z r106 = new z(r105, r105 + r103, r110, false);     // Catch: Throwable -> L26
        b r111 = this.f289007s;     // Catch: Throwable -> L26
        if (r111 == null) goto L20;
        r111.b(r106);     // Catch: Throwable -> L26
    L20:
        this.f288989a.offer(r106);     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L14:
        if (r100 >= r104) goto L16;
        r100 = r104;
    L16:
        this.f288996h = r100 + r103;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.call.aec.w
    public final void f(String r110) {
        Intrinsics.checkNotNullParameter(r110, "caller");
        com.larus.audio.call.util.e r100 = com.larus.audio.call.util.e.f289645a;
        String r101 = this.f288993e;
        StringBuilder r102 = new StringBuilder("[resume][");
        r102.append(r110);
        r102.append("] sessionId: ");
        r102.append(this.f289005q);
        r102.append(", pendingData is null:");
        if (this.f288990b != null) goto L5;
        boolean r111 = true;
    L6:
        r102.append(r111);
        r100.i(r101, r102.toString());
        if (this.f288989a.size() <= 0) goto L9;
    L10:
        this.f289001m = System.currentTimeMillis();
        this.f288989a.offer(new z(-1, -1, new byte[]{0}, false));
        b r112 = this.f289007s;
        if (r112 == null) goto L20;
        long r103 = this.f289001m;
        Long r104 = r112.f288963h;
        if (r104 == null) goto L20;
        long r105 = r104.longValue();
        Long r106 = r112.f288957b;
        if (r106 == null) goto L20;
        long r107 = r106.longValue();
        if (r105 >= r107) goto L20;
        r112.f288957b = Long.valueOf(r107 + (r103 - r105));
        String r113 = b.c(CollectionsKt.plus(r112.d(), CollectionsKt.listOf(new Pair[]{TuplesKt.to("[pause:" + c.b(r105) + ']', Long.valueOf(r105)), TuplesKt.to("[resume:" + c.b(r103) + ']', Long.valueOf(r103))})));
        StringBuilder r108 = new StringBuilder("[Resume] ");
        r108.append(r113);
        r100.i("Aec_Consume", r108.toString());
    L20:
        f r114 = this.f289006r;
        ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> r109 = this.f288999k;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r109, "queue");
        r114.f288972d = r109;
        this.f289000l = false;
        return;
    L9:
        if (this.f288990b == null) goto L20;
    L5:
        r111 = false;
        goto L6
    }

    @Override // com.larus.audio.call.aec.w
    public final void g(Map<String, String> r100) {
        b r101 = this.f289007s;
        if (r101 == null) goto L6;
        r101.f288956a = 0L;
        r101.f288957b = null;
        r101.f288958c = false;
        r101.f288962g.clear();
        com.larus.audio.call.util.e.f289645a.i("Aec_Consume", "[Ref] TTS Start");
        return;
    }

    public final z j(z r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        long r100 = this.f289001m;
        if (r100 > 0) goto L8;
        return r110;
    L8:
        if (r110.f289025d == true) goto L12;
        long r101 = r110.f289023b - r110.f289022a;
        z r111 = z.a(r110, r100, r100 + r101, null, true, 4);
        this.f289001m += r101;
        return r111;
    L12:
        return r110;
    }

    @Override // com.larus.audio.call.aec.w
    public final byte[] b(byte[] r210, Long r211) {
        Intrinsics.checkNotNullParameter(r210, "originData");
        com.larus.audio.call.util.e r100 = com.larus.audio.call.util.e.f289645a;
        r100.i(this.f288993e, "calculateRefData with originalData " + r210.length);
        Intrinsics.checkNotNullParameter(r210, "originData");
        if (this.f288994f == true) goto L5;
    L93:
        r100.i(this.f288993e, "[calculateRefData] return, init:" + this.f288994f + ", skipAec: " + this.f289000l + ", model is init: " + this.f289006r.f288974f);
    L94:
        SAMICoreVoiceAssistantAudioData r101 = null;
    L95:
        if (r101 != null) goto L98;
        return null;
    L98:
        this.f288999k.offer(r101);
        f r102 = this.f289006r;
        Handler r103 = r102.f288977i;
        if (r103 == null) goto L102;
        r103.post(new d(r102));
    L102:
        return r101.refData;
    L5:
        if (this.f289000l == true) goto L93;
        f r104 = this.f289006r;
        if (r104 != null) goto L9;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == true) goto L93;
        r100.i(this.f288993e, "origData size is " + r210.length);
        long r106 = System.currentTimeMillis();
        int r107 = r.f289018a;
        boolean r108 = this.f289002n;
        Intrinsics.checkNotNullParameter(r210, "originData");
        int r109 = r210.length;
        v58.a r110 = com.larus.audio.call.f.b(r108);
        if (r110.f553276b != 12) goto L17;
        int r111 = 2;
    L18:
        int r112 = (r109 * 1000) / ((r110.f553275a * 2) * r111);
        if (r112 <= 0) goto L94;
        long r113 = this.f288995g;
        if (r113 != (-1)) goto L24;
        r100.i(this.f288993e, "[calculateRefData] lastEndTime:" + this.f288995g);
    L26:
        long r114 = r106;
    L27:
        this.f288995g = r114;
        int r115 = r.a(r210, this.f289002n);
        byte[] r116 = new byte[r115];
        int r117 = 0;
    L28:
        if (r117 >= r115) goto L30;
        r116[r117] = 0;
        r117 = r117 + 1;
        goto L28
    L30:
        Intrinsics.checkNotNullParameter(r116, "data");
        long r118 = r112;
        long r119 = r114 - r118;
        z r120 = this.f288990b;
        if (r120 != null) goto L37;
        r120 = l();
        if (r120 != null) goto L37;
        b r121 = this.f289007s;
        if (r121 == null) goto L92;
        r121.a(r119, r114, AecConsumeResult.EMPTY_QUEUE);
    L92:
        r101 = new SAMICoreVoiceAssistantAudioData();
        r101.data = r210;
        r101.refData = r116;
    L37:
        z r122 = j(r120);
        boolean r123 = false;
    L38:
        if (r122 == null) goto L56;
        if (r114 < r122.f289023b) goto L56;
        long r124 = r122.f289022a;
        if (r124 == r119) goto L46;
        if (r124 <= r119) goto L46;
        int r125 = (int) (((r124 - r119) * ((long) r115)) / r118);
    L47:
        byte[] r126 = r122.f289024c;
        int r127 = 0;
    L48:
        if (r125 >= r115) goto L55;
        if (r127 >= r126.length) goto L55;
        if (this.f288997i == true) goto L54;
        this.f288997i = true;
    L54:
        r116[r125] = r126[r127];
        r125 = r125 + 1;
        r127 = r127 + 1;
    L55:
        r122 = j(l());
        r123 = true;
    L46:
        r125 = 0;
    L56:
        if (r122 != null) goto L65;
        this.f288990b = null;
        if (r123 == false) goto L62;
        b r128 = this.f289007s;
        if (r128 == null) goto L92;
        r128.a(r119, r114, AecConsumeResult.SENTENCE_END);
        goto L92
    L62:
        b r129 = this.f289007s;
        if (r129 == null) goto L92;
        r129.a(r119, r114, AecConsumeResult.SENTENCE_END_NOVALID);
        goto L92
    L65:
        long r130 = r122.f289022a;
        if (r114 > r130) goto L68;
        if (r123 == false) goto L88;
        b r131 = this.f289007s;
        if (r131 == null) goto L91;
        r131.a(r119, r114, AecConsumeResult.SENTENCE_END_MORE_SENTENCE);
    L91:
        this.f288990b = r122;
        goto L92
    L88:
        b r132 = this.f289007s;
        if (r132 == null) goto L91;
        r132.a(r119, r114, AecConsumeResult.AHEAD_OF_SENTENCE);
        goto L91
    L68:
        if (r130 == r119) goto L72;
        if (r130 <= r119) goto L72;
        int r133 = (int) (((r130 - r119) * ((long) r115)) / r118);
    L73:
        byte[] r134 = r122.f289024c;
        int r135 = 0;
    L74:
        if (r133 >= r115) goto L81;
        if (r135 >= r134.length) goto L81;
        if (this.f288997i == true) goto L80;
        this.f288997i = true;
    L80:
        r116[r133] = r134[r135];
        r133 = r133 + 1;
        r135 = r135 + 1;
    L81:
        long r136 = r122.f289023b;
        byte[] r137 = r122.f289024c;
        this.f288990b = new z(r114, r136, ArraysKt.sliceArray(r137, RangesKt.until(r135, r137.length)), r122.f289025d);
        b r138 = this.f289007s;
        if (r138 == null) goto L92;
        r138.a(r119, r114, AecConsumeResult.SENTENCE_PART);
    L72:
        r133 = 0;
        goto L73
    L24:
        r106 = r113 + ((long) r112);
        r114 = 0;
        if (0 >= r106) goto L27;
    L17:
        r111 = 1;
        goto L18
    L9:
        if (r104.f288974f == true) goto L11;
        r105 = true;
        goto L12
    }

    @Override // com.larus.audio.call.aec.w
    public final void h(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        com.larus.audio.call.util.e r102 = com.larus.audio.call.util.e.f289645a;
        r102.i(this.f288993e, "[pause]:".concat(r100));
        this.f289000l = true;
        this.f288996h = -1;
        this.f288995g = -1;
        b r103 = this.f289007s;
        if (r103 == null) goto L13;
        long r104 = System.currentTimeMillis();
        Long r105 = r103.f288957b;
        if (r105 == null) goto L7;
        long r106 = r105.longValue();
    L9:
        if (r104 >= r106) goto L14;
        r103.f288963h = Long.valueOf(r104);
        String r107 = b.c(CollectionsKt.plus(r103.d(), CollectionsKt.listOf(TuplesKt.to("[pause:" + c.b(r104) + ']', Long.valueOf(r104)))));
        StringBuilder r108 = new StringBuilder("[Pause] ");
        r108.append(r107);
        r102.i("Aec_Consume", r108.toString());
        return;
    L14:
        return;
    L7:
        r106 = 0;
        goto L9
    }

    @Override // com.larus.audio.call.aec.w
    public final void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        com.larus.audio.call.util.e.f289645a.i(this.f288993e, "[clear] [" + r100 + "] fromAsr=" + r101);
        this.f288989a.clear();
        this.f288999k.clear();
        Handler r102 = this.f289006r.f288977i;
        if (r102 == null) goto L5;
        r102.removeCallbacksAndMessages(null);
    L5:
        this.f288990b = null;
        this.f288996h = -1;
        if (r101 == true) goto L8;
        this.f288995g = -1;
    L8:
        this.f289001m = -1;
    }
}
