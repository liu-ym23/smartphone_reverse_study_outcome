package to5;

import android.os.SystemClock;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.tts.ITtsRecorder$ETtsViewType;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.m3u8.TtsM3U8Bean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final int a;
    public final String b;
    public final List<to5.b> c;
    public TtsM3U8Bean d;
    public boolean e;
    public boolean f;
    public String g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public long l;

    /* JADX INFO: renamed from: to5.a$a, reason: collision with other inner class name */
    public static final class C0314a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[IPlayer.State.values().length];
            r0[IPlayer.State.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L60:
            r0[IPlayer.State.PREPARING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L68:
            r0[IPlayer.State.PREPARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L44:
            r0[IPlayer.State.STOPPED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L48:
            r0[IPlayer.State.PLAYING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L58:
            r0[IPlayer.State.BUFFERING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L66:
            r0[IPlayer.State.PAUSED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L50:
            r0[IPlayer.State.ENDED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L62:
            r0[IPlayer.State.ERROR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
        L15:
            a = r0;
            int[] r1 = new int[TtsLoadScene.values().length];
            r1[TtsLoadScene.SWITCH_TONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L54:
            r1[TtsLoadScene.SEEK_BACKWARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L18:
            b = r1;
            int[] r2 = new int[ITtsRecorder$ETtsViewType.values().length];
            r2[ITtsRecorder$ETtsViewType.MODAL_PLAYER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L36
        L40:
            r2[ITtsRecorder$ETtsViewType.FULLSCREEN_PLAYER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L37
        L46:
            r2[ITtsRecorder$ETtsViewType.PLAYLIST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L38
        L56:
            r2[ITtsRecorder$ETtsViewType.FLOAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L39
        L23:
            c = r2;
        }
    }

    static {
    }

    public final void a() {
        to5.b r0 = (to5.b) CollectionsKt.lastOrNull(this.c);
        if (r0 == null) goto L6;
        r0.a();
    L6:
        if (((ArrayList) this.c).isEmpty() == true) goto L17;
        Iterator r1 = ((ArrayList) this.c).iterator();
        long r4 = 0;
    L10:
        if (r1.hasNext() == false) goto L16;
        to5.b r6 = (to5.b) r1.next();
        if ((r6 instanceof g) == false) goto L14;
        long r7 = r6.b - r6.a;
    L15:
        r4 = r4 + r7;
        goto L10
    L14:
        r7 = 0;
        goto L15
    L16:
        long r5 = RangesKt.coerceAtLeast(r4 / ((long) CCMLynxCardView.ViewType.BANNER), 0);
        HashMap r2 = new HashMap();
        r2.put("play_file_id", this.b);
        r2.put("play_time", Long.valueOf(r5));
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_docs_tts_plat_stop_view", r2);
    L17:
        f();
        ((ArrayList) this.c).clear();
        this.e = false;
        this.f = false;
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = null;
        this.k = null;
        this.l = 0;
    }

    public final void b() {
        to5.b r0 = (to5.b) CollectionsKt.lastOrNull(this.c);
        if (r0 == null) goto L5;
        r0.a();
    L5:
        e r1 = new e();
        r1.a = SystemClock.elapsedRealtime();
        ((ArrayList) this.c).add(r1);
    }

    public final void f() {
        String r1 = this.g;
        if (r1 != null) goto L5;
        return;
    L5:
        String r2 = this.h;
        if (r2 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r1, this.j) == true) goto L11;
    L13:
        this.j = r1;
        this.k = r2;
        if (this.f == false) goto L17;
        String r3 = "error";
    L20:
        TtsM3U8Bean r4 = this.d;
        if (r4 != null) goto L23;
        double r11 = 0.0d;
    L35:
        Iterator r5 = ((ArrayList) this.c).iterator();
        long r13 = 0;
    L37:
        if (r5.hasNext() == false) goto L46;
        to5.b r10 = (to5.b) r5.next();
        if ((r10 instanceof i) == false) goto L41;
        to5.b r9 = r10;
    L42:
        if (r9 == null) goto L44;
        long r7 = r9.b - r9.a;
    L45:
        r13 = r13 + r7;
        goto L37
    L44:
        r7 = 0;
        goto L45
    L41:
        r9 = null;
        goto L42
    L46:
        double r8 = RangesKt.coerceAtLeast(r13 / 1000.0d, 0.0d);
        Iterator r6 = ((ArrayList) this.c).iterator();
        long r14 = 0;
    L48:
        if (r6.hasNext() == false) goto L57;
        to5.b r12 = (to5.b) r6.next();
        if ((r12 instanceof j) == true) goto L51;
        if (r14 <= 0) goto L48;
        if ((r12 instanceof h) == false) goto L48;
        long r15 = r12.a;
    L58:
        double r16 = RangesKt.coerceAtLeast((r15 - r14) / 1000.0d, 0.0d);
        Iterator r17 = ((ArrayList) this.c).iterator();
        long r18 = 0;
    L60:
        if (r17.hasNext() == false) goto L70;
        to5.b r19 = (to5.b) r17.next();
        if ((r19 instanceof h) == false) goto L65;
        r18 = r19.a;
        goto L60
    L65:
        if (r18 <= 0) goto L60;
        if ((r19 instanceof g) == false) goto L60;
        long r20 = r19.a;
    L71:
        double r21 = RangesKt.coerceAtLeast((r20 - r18) / 1000.0d, 0.0d);
        Iterator r22 = ((ArrayList) this.c).iterator();
        long r110 = 0;
    L73:
        if (r22.hasNext() == false) goto L83;
        to5.b r111 = (to5.b) r22.next();
        r22 = r22;
        if ((r111 instanceof k) == true) goto L76;
        if (r110 > 0) goto L80;
    L82:
        r2 = r2;
        r3 = r3;
        goto L73
    L80:
        if ((r111 instanceof g) == false) goto L82;
        long r112 = r111.a;
    L84:
        double r23 = RangesKt.coerceAtLeast((r112 - r110) / 1000.0d, 0.0d);
        HashMap r113 = new HashMap();
        r113.put("file_id", this.b);
        r113.put("source", r1);
        r113.put("timre_cost_time", Double.valueOf(RangesKt.coerceAtLeast(this.l / 1000.0d, 0.0d)));
        r113.put("m3u8_cost_time", Double.valueOf(r8));
        r113.put("prepare_cost_time", Double.valueOf(r16));
        r113.put("play_cost_time", Double.valueOf(r21));
        r113.put("total_cost_time", Double.valueOf(r23));
        r113.put("total_duration", Double.valueOf(r11));
        Serializable r0 = (Serializable) r113.put("result", r3);
        r113.put("stage", r2);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_docs_tts_play_stage", r113);
        return;
    L76:
        r110 = r111.a;
        goto L73
    L83:
        r112 = 0;
        goto L84
    L70:
        r20 = 0;
        goto L71
    L51:
        r14 = r12.a;
        goto L48
    L57:
        r15 = 0;
        goto L58
    L23:
        if (r4.isSegmentComplete == false) goto L28;
        long r114 = r4.segmentSumDurationMs;
        if (r114 <= 0) goto L28;
        long r115 = r4.segmentFirstOffsetMs + r114;
    L33:
        r11 = RangesKt.coerceAtLeast(r115 / 1000.0d, 0.0d);
    L28:
        if (r4.isServerComplete == false) goto L32;
        r115 = r4.serverRealDurationMs;
        if (r115 > 0) goto L33;
    L32:
        r115 = r4.serverPredictDurationMs;
        goto L33
    L17:
        if (this.e == true) goto L19;
        r3 = DocFeed$Value$Result.CANCEL;
        goto L20
    L19:
        r3 = "success";
        goto L20
    L11:
        if (Intrinsics.areEqual(r2, this.k) == false) goto L13;
    }

    public final int getType() {
        return this.a;
    }

    public final void c(to5.b r4) {
        to5.b r0 = (to5.b) CollectionsKt.lastOrNull(this.c);
        Class<?> r1 = r4.getClass();
        if (r0 == null) goto L5;
        Class<?> r2 = r0.getClass();
    L7:
        if (Intrinsics.areEqual(r1, r2) == false) goto L9;
        return;
    L9:
        if (r0 == null) goto L11;
        r0.a();
    L11:
        r4.a = SystemClock.elapsedRealtime();
        ((ArrayList) this.c).add(r4);
        if ((r4 instanceof k) == false) goto L15;
        this.i = true;
        return;
    L15:
        if ((r4 instanceof g) == false) goto L21;
        this.e = true;
        this.h = "ending";
        if (this.i == false) goto L19;
        f();
    L19:
        this.g = "play";
        return;
    L21:
        if ((r4 instanceof c) == false) goto L24;
        f();
        return;
    L24:
        if ((r4 instanceof d) == false) goto L30;
        this.f = true;
        f();
        return;
    L30:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void d(ITtsRecorder$ETtsViewType r12) {
        Intrinsics.checkNotNullParameter(r12, ResourceData.KEY_TYPE);
        StringBuilder r0 = new StringBuilder();
        mo5.f r1 = ((mo5.e) org.koin.java.a.c(mo5.e.class, null, null, 6)).V6(false);
        if (r1 != null) goto L5;
    L20:
        ArrayList r5 = null;
    L22:
        if (r5 == null) goto L33;
        Iterator r6 = r5.iterator();
    L25:
        if (r6.hasNext() == false) goto L33;
        String r7 = (String) r6.next();
        if (r0.length() <= 0) goto L29;
        boolean r8 = true;
    L30:
        if (r8 == false) goto L32;
        r0.append(",");
    L32:
        r0.append(du5.b.g(r7));
        goto L25
    L29:
        r8 = false;
    L33:
        String r2 = r0.toString();
        int r13 = b.c[r12.ordinal()];
        if (r13 != 1) goto L36;
        HashMap r14 = new HashMap();
        r14.put("player_status", "half_screen");
        r14.put("play_file_id", this.b);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_docs_tts_player_view", r14);
        HashMap r15 = new HashMap();
        r15.put("play_list_status", "under_player");
        r15.put("play_list", r2);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_docs_tts_play_list_view", r15);
        return;
    L36:
        if (r13 != 2) goto L38;
        HashMap r16 = new HashMap();
        r16.put("player_status", "full_screen");
        r16.put("play_file_id", this.b);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_docs_tts_player_view", r16);
        return;
    L38:
        if (r13 != 3) goto L40;
        HashMap r17 = new HashMap();
        r17.put("play_list_status", "full_screen");
        r17.put("play_list", r2);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_docs_tts_play_list_view", r17);
        return;
    L40:
        if (r13 != 4) goto L56;
        HashMap r18 = new HashMap();
        r18.put("player_status", "mini_player");
        r18.put("play_file_id", this.b);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).n("ccm_docs_tts_player_view", r18);
        return;
    L56:
        return;
    L5:
        if (r1.a() == false) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L20;
        mo5.a r3 = r1.k();
        if (r3 == null) goto L20;
        List<mo5.g> r4 = mo5.h.d(r3);
        if (r4 == null) goto L20;
        r5 = new ArrayList();
        Iterator<T> r9 = r4.iterator();
    L15:
        if (r9.hasNext() == false) goto L22;
        String r10 = mo5.h.a((mo5.g) r9.next());
        if (r10 != null) goto L19;
        r10 = "";
    L19:
        r5.add(r10);
        goto L15
    }

    public final void e(IPlayer.State r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        switch(b.a[r2.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        to5.b r3 = null;
    L14:
        if (r3 != null) goto L16;
        return;
    L16:
        c(r3);
        return;
    L5:
        r3 = new d();
        goto L14
    L6:
        r3 = new c();
        goto L14
    L7:
        r3 = new f();
        goto L14
    L8:
        r3 = new g();
        goto L14
    L9:
        r3 = new g();
        goto L14
    L10:
        r3 = new l();
        goto L14
    L11:
        r3 = new h();
        goto L14
    L12:
        r3 = new k();
        goto L14
    L13:
        r3 = new l();
        goto L14
    }

    public a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        this.a = r3;
        this.b = du5.b.g(r2);
        this.c = new ArrayList();
    }
}
