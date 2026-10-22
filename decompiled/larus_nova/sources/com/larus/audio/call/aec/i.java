package com.larus.audio.call.aec;

import android.os.Handler;
import android.os.SystemClock;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class i implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f288980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> f288981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f288982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f288983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f288984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f288985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f288986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f288987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f288988i;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.audio.call.aec.w
    public final void d() {
        if (this.f288983d != null) goto L6;
        com.larus.audio.call.util.e.f289645a.e("AecProcessor2", "[onRefSentenceEnded] refSentence is null");
        return;
    L6:
        com.larus.audio.call.util.e r100 = com.larus.audio.call.util.e.f289645a;
        r100.i("AecProcessor2", "[onRefSentenceEnded]");
        q r101 = this.f288983d;
        if (r101 == null) goto L10;
        r100.i("AecRefSentence", "onDataEnd");
        r101.f289016f = true;
        return;
    }

    @Override // com.larus.audio.call.aec.w
    public final void e() {
        if (this.f288983d != null) goto L6;
        com.larus.audio.call.util.e.f289645a.e("AecProcessor2", "[onRefSentencePlayFirstFrame] refSentence is null");
        return;
    L6:
        com.larus.audio.call.util.e r100 = com.larus.audio.call.util.e.f289645a;
        r100.i("AecProcessor2", "[onRefSentencePlayFirstFrame]");
        q r101 = this.f288983d;
        if (r101 != null) goto L9;
        return;
    L9:
        monitor-enter(r101);
        r101.f289013c = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L21
        long r102 = r101.a();     // Catch: Throwable -> L21
        if (r102 != (-1)) goto L18;
        r100.e("AecRefSentence", "onFirstFrame:NO_REF");     // Catch: Throwable -> L21
        if (com.larus.audio.call.f.c().appContext().g() == true) goto L17;
        monitor-exit(r101);
        return;
    L17:
        throw new IllegalStateException("no ref when first frame");     // Catch: Throwable -> L21
    L18:
        long r103 = r101.f289013c - r102;     // Catch: Throwable -> L21
        StringBuilder r104 = new StringBuilder("onFirstFrame:");     // Catch: Throwable -> L21
        SimpleDateFormat r105 = c.f288964a;     // Catch: Throwable -> L21
        r104.append(c.a(r101.f289013c));     // Catch: Throwable -> L21
        r104.append(", firstBlock:");     // Catch: Throwable -> L21
        r104.append(c.a(r102));     // Catch: Throwable -> L21
        r104.append(", gap:");     // Catch: Throwable -> L21
        r104.append(r103 / ((long) 1000000));     // Catch: Throwable -> L21
        r104.append("ms");     // Catch: Throwable -> L21
        r100.i("AecRefSentence", r104.toString());     // Catch: Throwable -> L21
        r101.e(r103);     // Catch: Throwable -> L21
        monitor-exit(r101);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public final boolean k() {
        return ((Boolean) this.f288988i.getValue()).booleanValue();
    }

    @Override // com.larus.audio.call.aec.w
    public final void release() {
        com.larus.audio.call.util.e r100 = com.larus.audio.call.util.e.f289645a;
        StringBuilder r101 = new StringBuilder("[release][true][");
        if (this.f288983d == null) goto L5;
        boolean r102 = true;
    L6:
        r101.append(r102);
        r101.append(']');
        r100.i("AecProcessor2", r101.toString());
        this.f288980a.set(false);
        i("release", false);
        com.larus.audio.call.util.c.a(new AecProcessor2$release$1(this, null));
        return;
    L5:
        r102 = false;
        goto L6
    }

    public i() {
        this.f288980a = new AtomicBoolean(false);
        this.f288981b = new ConcurrentLinkedQueue();
        this.f288982c = new f();
        this.f288984e = -1;
        this.f288985f = -1;
        this.f288987h = true;
        this.f288988i = LazyKt.lazy(new h());
    }

    @Override // com.larus.audio.call.aec.w
    public final boolean a(com.larus.audio.call.plugins.m r100) {
        Intrinsics.checkNotNullParameter(r100, "onAudioDataReceived");
        if (this.f288980a.compareAndSet(false, true) == true) goto L5;
        return true;
    L5:
        this.f288982c.b(com.larus.audio.call.f.b(true), com.larus.audio.call.f.a(true, k(), null), k(), r100);
        f r101 = this.f288982c;
        ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> r102 = this.f288981b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "queue");
        r101.f288972d = r102;
        boolean r103 = this.f288982c.f288974f;
        com.larus.audio.call.util.e.f289645a.i("AecProcessor2", "[init]:" + r103);
        return r103;
    }

    @Override // com.larus.audio.call.aec.w
    public final void c(byte[] r210) {
        Intrinsics.checkNotNullParameter(r210, "data");
        if (this.f288983d != null) goto L6;
        com.larus.audio.call.util.e.f289645a.e("AecProcessor2", "[onReceiveRefData] refSentence is null");
        return;
    L6:
        com.larus.audio.call.util.e r100 = com.larus.audio.call.util.e.f289645a;
        r100.i("AecProcessor2", "[onReceiveRefData]");
        q r101 = this.f288983d;
        if (r101 == null) goto L54;
        int r102 = r.f289018a;
        boolean r103 = k();
        Intrinsics.checkNotNullParameter(r210, "array");
        long r104 = ((((long) r210.length) * 1000000) * ((long) 1000)) / ((long) (com.larus.audio.call.f.a(true, r103, null).f289297c * 2));
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r210, "data");     // Catch: Throwable -> L51
        if (r101.f289016f == false) goto L15;
        r100.e("AecRefSentence", "[REF][APPEND][AFTER_END]");     // Catch: Throwable -> L51
        monitor-exit(r101);
        return;
    L15:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L51
        long r111 = r101.a();     // Catch: Throwable -> L51
        k r105 = (k) CollectionsKt.lastOrNull(r101.f289011a);     // Catch: Throwable -> L51
        if (r105 != null) goto L20;
        r105 = r101.f289012b;     // Catch: Throwable -> L51
        if (r105 != null) goto L20;
        long r106 = -1;
    L23:
        if (r111 <= 0) goto L25;
        boolean r211 = true;
    L27:
        if (r211 == true) goto L29;
        long r107 = r104 + r110;     // Catch: Throwable -> L51
        r100.w("AecRefSentence", "[REF][FIRST][" + c.a(r110) + " - " + c.a(r107) + ']');     // Catch: Throwable -> L51
    L45:
        long r108 = r107;
        long r109 = r110;
    L48:
        ((ConcurrentLinkedQueue) r101.f289011a).offer(new k(r109, r108, r210));     // Catch: Throwable -> L51
        monitor-exit(r101);
        return;
    L29:
        long r112 = r101.f289014d;     // Catch: Throwable -> L51
        if (r112 <= r101.f289015e) goto L32;
        boolean r113 = true;
    L33:
        if (r113 == false) goto L39;
        if (r112 > r106) goto L37;
        long r114 = r104 + r106;     // Catch: Throwable -> L51
        r100.i("AecRefSentence", "[REF][APPEND][PAUSE][" + c.a(r111) + " - " + c.a(r106) + " - " + c.a(r114) + "][NOW:" + c.a(r110) + ']');     // Catch: Throwable -> L51
    L47:
        r108 = r114;
        r109 = r106;
        goto L48
    L37:
        long r115 = r104 + r110;     // Catch: Throwable -> L51
        r100.e("AecRefSentence", "[REF][RESET][PAUSE][" + c.a(r110) + " - " + c.a(r115) + ']');     // Catch: Throwable -> L51
        r107 = r115;
        goto L45
    L39:
        if (r101.f289013c != (-1)) goto L41;
        long r116 = 0;
    L43:
        if (r116 <= 0) goto L46;
        r100.e("AecRefSentence", "[REF][RESET][GAP][" + c.a(r111) + " - " + c.a(r106) + "][NOW:" + c.a(r110) + ']');     // Catch: Throwable -> L51
        r107 = r104 + r110;     // Catch: Throwable -> L51
        goto L45
    L46:
        r114 = r104 + r106;     // Catch: Throwable -> L51
        r100.i("AecRefSentence", "[REF][APPEND][" + c.a(r111) + " - " + c.a(r106) + " - " + c.a(r114) + "][NOW:" + c.a(r110) + ']');     // Catch: Throwable -> L51
        goto L47
    L41:
        r116 = r110 - r106;     // Catch: Throwable -> L51
        goto L43
    L32:
        r113 = false;
        goto L33
    L25:
        r211 = false;
    L20:
        r106 = r105.f289009b;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.call.aec.w
    public final synchronized void f(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "reason");     // Catch: Throwable -> L18
        com.larus.audio.call.util.e r101 = com.larus.audio.call.util.e.f289645a;     // Catch: Throwable -> L18
        StringBuilder r102 = new StringBuilder("[resume][");     // Catch: Throwable -> L18
        r102.append(r100);     // Catch: Throwable -> L18
        r102.append("][");     // Catch: Throwable -> L18
        boolean r103 = true;
        if (this.f288983d == null) goto L7;
        boolean r104 = true;
    L8:
        r102.append(r104);     // Catch: Throwable -> L18
        r102.append(']');     // Catch: Throwable -> L18
        r101.i("AecProcessor2", r102.toString());     // Catch: Throwable -> L18
        this.f288987h = false;     // Catch: Throwable -> L18
        q r105 = this.f288983d;     // Catch: Throwable -> L18
        if (r105 != null) goto L11;
    L16:
        monitor-exit(this);
        return;
    L11:
        if (r105.f289014d > r105.f289015e) goto L14;
        r103 = false;
    L14:
        if (r103 == false) goto L16;
        r105.f();     // Catch: Throwable -> L18
        goto L16
    L7:
        r104 = false;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.call.aec.w
    public final void g(Map<String, String> r100) {
        String r101 = "";
        if (r100 == null) goto L6;
        String r102 = r100.get("sentence_id");
        if (r102 == null) goto L6;
    L7:
        if (r100 == null) goto L10;
        String r103 = r100.get(MusicAppletPage.KEY_MESSAGE_ID);
        if (r103 == null) goto L10;
    L11:
        if (r100 == null) goto L16;
        String r104 = r100.get("tts_content_scene");
        if (r104 == null) goto L16;
        r101 = r104;
    L16:
        com.larus.audio.call.util.e.f289645a.i("AecProcessor2", "[onRefSentenceStart] sentenceId: " + r102 + ", messageId: " + r103 + ", scene: " + r101);
        this.f288983d = new q(r103, r102, r101);
        return;
    L10:
        r103 = "";
    L6:
        r102 = "";
        goto L7
    }

    @Override // com.larus.audio.call.aec.w
    public final synchronized byte[] b(byte[] r110, Long r111) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "micData");     // Catch: Throwable -> L38
        if (this.f288980a.get() == true) goto L7;
    L35:
        com.larus.audio.call.util.e.f289645a.e("AecProcessor2", "[CalcRefData] return, init:" + this.f288980a.get() + ", modelInit:" + this.f288982c.f288974f);     // Catch: Throwable -> L38
        monitor-exit(this);
        return null;
    L7:
        if (this.f288982c.f288974f == false) goto L35;
        if (this.f288987h == false) goto L14;
        com.larus.audio.call.util.e.f289645a.e("AecProcessor2", "[CalcRefData][isAecPaused]");     // Catch: Throwable -> L38
        monitor-exit(this);
        return null;
    L14:
        long r100 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L38
        int r101 = r.f289018a;     // Catch: Throwable -> L38
        boolean r102 = k();     // Catch: Throwable -> L38
        Intrinsics.checkNotNullParameter(r110, "originData");     // Catch: Throwable -> L38
        v58.a r103 = com.larus.audio.call.f.b(r102);     // Catch: Throwable -> L38
        if (r103.f553276b != 12) goto L17;
        int r104 = 2;
    L18:
        long r105 = ((((long) r110.length) * 1000000) * ((long) 1000)) / ((long) ((r103.f553275a * 2) * r104));     // Catch: Throwable -> L38
        int r106 = r.a(r110, k());     // Catch: Throwable -> L38
        byte[] r112 = new byte[r106];     // Catch: Throwable -> L38
        if (r105 > 0) goto L26;
        com.larus.audio.call.util.e.f289645a.e("AecProcessor2", "[CalcRefData][INVALID], micDuration:" + r105 + ", refSize: " + r106);     // Catch: Throwable -> L38
        ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> r113 = this.f288981b;     // Catch: Throwable -> L38
        SAMICoreVoiceAssistantAudioData r107 = new SAMICoreVoiceAssistantAudioData();     // Catch: Throwable -> L38
        r107.data = r110;     // Catch: Throwable -> L38
        r107.refData = r112;     // Catch: Throwable -> L38
        r113.offer(r107);     // Catch: Throwable -> L38
        f r114 = this.f288982c;     // Catch: Throwable -> L38
        Handler r115 = r114.f288977i;     // Catch: Throwable -> L38
        if (r115 == null) goto L23;
        r115.post(new d(r114));     // Catch: Throwable -> L38
    L23:
        monitor-exit(this);
        return r112;
    L26:
        Pair<Long, Long> r116 = j(r111, r100, r105);     // Catch: Throwable -> L38
        q r108 = this.f288983d;     // Catch: Throwable -> L38
        if (r108 == null) goto L29;
        r108.b(r116.getFirst().longValue(), r116.getSecond().longValue(), r112);     // Catch: Throwable -> L38
    L29:
        ConcurrentLinkedQueue<SAMICoreVoiceAssistantAudioData> r109 = this.f288981b;     // Catch: Throwable -> L38
        SAMICoreVoiceAssistantAudioData r117 = new SAMICoreVoiceAssistantAudioData();     // Catch: Throwable -> L38
        r117.data = r110;     // Catch: Throwable -> L38
        r117.refData = r112;     // Catch: Throwable -> L38
        r109.offer(r117);     // Catch: Throwable -> L38
        f r118 = this.f288982c;     // Catch: Throwable -> L38
        Handler r119 = r118.f288977i;     // Catch: Throwable -> L38
        if (r119 == null) goto L32;
        r119.post(new d(r118));     // Catch: Throwable -> L38
    L32:
        this.f288984e = r116.getFirst().longValue();     // Catch: Throwable -> L38
        this.f288985f = r116.getSecond().longValue();     // Catch: Throwable -> L38
        monitor-exit(this);
        return r112;
    L17:
        r104 = 1;
    L38:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.call.aec.w
    public final synchronized void h(String r110, boolean r111) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "reason");     // Catch: Throwable -> L23
        long r100 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L23
        com.larus.audio.call.util.e r101 = com.larus.audio.call.util.e.f289645a;     // Catch: Throwable -> L23
        StringBuilder r102 = new StringBuilder("[pause-start][");     // Catch: Throwable -> L23
        r102.append(r110);     // Catch: Throwable -> L23
        r102.append("][pauseRef:");     // Catch: Throwable -> L23
        r102.append(r111);     // Catch: Throwable -> L23
        r102.append("][hasSentence:");     // Catch: Throwable -> L23
        q r103 = this.f288983d;     // Catch: Throwable -> L23
        boolean r104 = false;
        if (r103 != null) goto L7;
    L9:
        boolean r105 = false;
    L10:
        r102.append(r105);     // Catch: Throwable -> L23
        r102.append("][");     // Catch: Throwable -> L23
        r102.append(r100);     // Catch: Throwable -> L23
        r102.append(']');     // Catch: Throwable -> L23
        r101.i("AecProcessor2", r102.toString());     // Catch: Throwable -> L23
        this.f288987h = true;     // Catch: Throwable -> L23
        this.f288984e = -1;     // Catch: Throwable -> L23
        this.f288985f = -1;     // Catch: Throwable -> L23
        if (r111 == false) goto L15;
        q r106 = this.f288983d;     // Catch: Throwable -> L23
        if (r106 == null) goto L15;
        r101.i("AecRefSentence", "onPause");     // Catch: Throwable -> L23
        r106.f289014d = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L23
    L15:
        StringBuilder r107 = new StringBuilder("[pause-end][");     // Catch: Throwable -> L23
        r107.append(r110);     // Catch: Throwable -> L23
        r107.append("][pauseRef:");     // Catch: Throwable -> L23
        r107.append(r111);     // Catch: Throwable -> L23
        r107.append("][hasSentence:");     // Catch: Throwable -> L23
        q r112 = this.f288983d;     // Catch: Throwable -> L23
        if (r112 != null) goto L18;
    L20:
        r107.append(r104);     // Catch: Throwable -> L23
        r107.append("][");     // Catch: Throwable -> L23
        r107.append(r100);     // Catch: Throwable -> L23
        r107.append(']');     // Catch: Throwable -> L23
        r101.i("AecProcessor2", r107.toString());     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L18:
        if (r112.d() != true) goto L20;
        r104 = true;
        goto L20
    L7:
        if (r103.d() != true) goto L9;
        r105 = true;
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.call.aec.w
    public final void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        com.larus.audio.call.util.e r102 = com.larus.audio.call.util.e.f289645a;
        StringBuilder r103 = new StringBuilder("[clearData][");
        r103.append(r100);
        r103.append("][continueRecord:");
        r103.append(r101);
        r103.append("][hasSentence:");
        q r104 = this.f288983d;
        if (r104 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        r103.append(r105);
        r103.append(']');
        r102.i("AecProcessor2", r103.toString());
        q r106 = this.f288983d;
        if (r106 == null) goto L11;
        r102.i("AecRefSentence", "onDataEnd");
        r106.f289016f = true;
    L11:
        if (r101 == true) goto L14;
        this.f288984e = -1;
        this.f288985f = -1;
        return;
    L14:
        return;
    L5:
        if (r104.d() != true) goto L7;
        r105 = true;
        goto L8
    }

    public final Pair<Long, Long> j(Long r100, long r101, long r110) {
        if (this.f288984e == (-1)) goto L12;
        long r102 = this.f288985f;
        if (r102 == (-1)) goto L12;
        long r111 = r110 + r102;
        long r103 = r111 - r101;
        if (r103 <= this.f288986g) goto L11;
        com.larus.audio.call.util.e.f289645a.e("AecProcessor2", "[FATAL][CalcRefData] return, endTime-now Gap:" + r103 + ", maxGap:" + this.f288986g);
    L11:
        return TuplesKt.to(Long.valueOf(r102), Long.valueOf(r111));
    L12:
        if (r100 == null) goto L14;
        long r104 = r101 - r100.longValue();
    L15:
        this.f288986g = r104;
        com.larus.audio.call.util.e.f289645a.i("AecProcessor2", "MAX_GAP: " + this.f288986g);
        return TuplesKt.to(Long.valueOf(r101 - r110), Long.valueOf(r101));
    L14:
        r104 = 20000000;
        goto L15
    }
}
