package com.larus.audio.call.aec;

import android.os.SystemClock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes24.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<k> f289011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f289012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f289013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f289014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f289015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f289016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f289017g;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((Long) ((Pair) r100).getSecond(), (Long) ((Pair) r101).getSecond());
        }
    }

    static {
    }

    public final synchronized void f() {
        monitor-enter(this);
        com.larus.audio.call.util.e.f289645a.i("AecRefSentence", "onResume");     // Catch: Throwable -> L6
        long r100 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L6
        this.f289015e = r100;     // Catch: Throwable -> L6
        e(r100 - this.f289014d);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final long a() {
        k r100 = this.f289012b;
        if (r100 != null) goto L10;
        r100 = (k) ((ConcurrentLinkedQueue) this.f289011a).peek();
        if (r100 != null) goto L10;
        return -1;
    L10:
        return r100.f289008a;
    }

    public final boolean d() {
        if ((!this.f289011a.isEmpty()) == false) goto L5;
        return true;
    L5:
        if (this.f289012b != null) goto L10;
        return false;
    L10:
        return true;
    }

    public final k g() {
        if (a() != (-1)) goto L7;
        com.larus.audio.call.util.e.f289645a.v("AecRefSentence", "[REF][POP_BLOCK][NO_FIRST_BLOCK]");
        return null;
    L7:
        if (this.f289013c != (-1)) goto L13;
        long r100 = SystemClock.elapsedRealtimeNanos() - a();
        if (r100 <= 300000000) goto L11;
        com.larus.audio.call.util.e.f289645a.e("AecRefSentence", "[REF][POP_BLOCK][NOT_FIRST_FRAME_AFTER][" + (r100 / ((long) 1000000)) + "}ms]");
    L12:
        return null;
    L11:
        com.larus.audio.call.util.e.f289645a.v("AecRefSentence", "[REF][POP_BLOCK][NOT_FIRST_FRAME_AFTER][" + (r100 / ((long) 1000000)) + "}ms]");
        goto L12
    L13:
        byte[] r101 = new byte[0];
        ArrayList r102 = new ArrayList();
        k r103 = this.f289012b;
        this.f289012b = null;
        String r104 = "][ratio:";
        if (r103 == null) goto L20;
        r102.add(r103);
        byte[] r110 = r103.f289010c;
        int r111 = r110.length + 0;
        byte[] r105 = ArraysKt.plus(r101, r110);
        if ((r103.f289010c.length % 2) != 1) goto L18;
        com.larus.audio.call.util.e.f289645a.e("AecRefSentence", "[REF][POP_BLOCK][PENDING][BLOCK_SIZE_ERROR][pendingSize:" + r103.f289010c.length + ']');
        String r106 = "AecRefSentence";
    L19:
        r101 = r105;
    L21:
        k r107 = (k) ((ConcurrentLinkedQueue) this.f289011a).peek();
    L22:
        if (r107 == null) goto L33;
        if (r103 == null) goto L27;
        ArrayList r112 = r102;
        if (r103.f289009b != r107.f289008a) goto L34;
    L28:
        ((ConcurrentLinkedQueue) this.f289011a).poll();
        r112.add(r107);
        byte[] r108 = r107.f289010c;
        r111 = r111 + r108.length;
        r101 = ArraysKt.plus(r101, r108);
        if ((r107.f289010c.length % 2) != 1) goto L31;
        com.larus.audio.call.util.e.f289645a.e(r106, "[REF][POP_BLOCK][Q][BLOCK_SIZE_ERROR][append Size:" + r107.f289010c.length + ']');
    L32:
        r103 = r107;
        r107 = (k) ((ConcurrentLinkedQueue) this.f289011a).peek();
        r104 = r104;
        r102 = r112;
        goto L22
    L31:
        com.larus.audio.call.util.e r109 = com.larus.audio.call.util.e.f289645a;
        StringBuilder r113 = new StringBuilder("[REF][POP_BLOCK][Q][");
        SimpleDateFormat r114 = c.f288964a;
        r113.append(c.a(r107.f289008a));
        r113.append(" - ");
        r113.append(c.a(r107.f289009b));
        r113.append("][");
        r113.append(r107.f289010c.length);
        r113.append(r104);
        r113.append((r107.f289009b - r107.f289008a) / ((long) r107.f289010c.length));
        r113.append(']');
        r109.v(r106, r113.toString());
    L34:
        if (r103 == null) goto L36;
        if (r107 == null) goto L42;
        com.larus.audio.call.util.e r115 = com.larus.audio.call.util.e.f289645a;
        StringBuilder r116 = new StringBuilder("[REF][POP_BLOCK][HAS_GAP][");
        SimpleDateFormat r117 = c.f288964a;
        r116.append(c.a(r103.f289009b));
        r116.append("]-[");
        r116.append(c.a(r107.f289008a));
        r116.append(']');
        r115.e(r106, r116.toString());
    L42:
        byte[] r118 = new byte[r111];
        Iterator r119 = r112.iterator();
        int r120 = 0;
    L44:
        if (r119.hasNext() == false) goto L46;
        k r121 = (k) r119.next();
        byte[] r122 = r121.f289010c;
        System.arraycopy(r122, 0, r118, r120, r122.length);
        r120 = r120 + r121.f289010c.length;
        goto L44
    L46:
        long r123 = ((k) CollectionsKt.first(r112)).f289008a;
        long r124 = r103.f289009b;
        com.larus.audio.call.util.e r125 = com.larus.audio.call.util.e.f289645a;
        StringBuilder r126 = new StringBuilder("[REF][POP_BLOCK][RES][");
        r126.append(c.a(r123));
        r126.append('-');
        r126.append(c.a(r124));
        r126.append("][");
        long r127 = r124 - r123;
        r126.append(r127);
        r126.append("][");
        r126.append(r111);
        r126.append(']');
        r126.append(r127 / ((long) r111));
        r125.v(r106, r126.toString());
        return new k(r123, r124, r118);
    L36:
        if (this.f289017g == true) goto L53;
        com.larus.audio.call.util.e.f289645a.v(r106, "[REF][POP_BLOCK][EMPTY]");
        return null;
    L53:
        return null;
    L27:
        r112 = r102;
        goto L28
    L33:
        r112 = r102;
        goto L34
    L18:
        com.larus.audio.call.util.e r128 = com.larus.audio.call.util.e.f289645a;
        StringBuilder r129 = new StringBuilder("[REF][POP_BLOCK][PENDING][");
        SimpleDateFormat r130 = c.f288964a;
        r129.append(c.a(r103.f289008a));
        r129.append(" - ");
        r129.append(c.a(r103.f289009b));
        r129.append("][");
        r129.append(r103.f289010c.length);
        r129.append("][ratio:");
        r129.append((r103.f289009b - r103.f289008a) / ((long) r103.f289010c.length));
        r129.append(']');
        r106 = "AecRefSentence";
        r128.v(r106, r129.toString());
        goto L19
    L20:
        r106 = "AecRefSentence";
        r103 = null;
        r111 = 0;
        goto L21
    }

    public static final void c(List<Pair<String, Object>> r110) {
        List<Pair<String, Object>> r111 = r110;
        String r100 = SequencesKt.joinToString$default(SequencesKt.sortedWith(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(r111), new l()), new m()), new b()), " - ", null, null, 0, null, new n(), 30, null);
        String r112 = SequencesKt.joinToString$default(SequencesKt.filter(CollectionsKt.asSequence(r111), new o()), " - ", null, null, 0, null, new p(), 30, null);
        com.larus.audio.call.util.e.f289645a.i("AecRefSentence", "[REF][POP][DETAIL][" + r100 + "][" + r112 + ']');
    }

    public final void e(long r100) {
        k r101 = g();
        this.f289012b = r101;
        if (r101 == null) goto L5;
        this.f289012b = k.a(r101, r101.f289008a + r100, r101.f289009b + r100);
    L5:
        ArrayList r102 = new ArrayList();
    L7:
        if ((!((ConcurrentLinkedQueue) this.f289011a).isEmpty()) == false) goto L13;
        k r103 = (k) ((ConcurrentLinkedQueue) this.f289011a).poll();
        if (r103 == null) goto L7;
        r102.add(k.a(r103, r103.f289008a + r100, r103.f289009b + r100));
        goto L7
    L13:
        if ((!r102.isEmpty()) == false) goto L21;
        ((ConcurrentLinkedQueue) this.f289011a).addAll(r102);
        return;
    }

    public q(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "sentenceId");
        Intrinsics.checkNotNullParameter(r102, "scene");
        this.f289011a = new ConcurrentLinkedQueue();
        this.f289013c = -1;
        this.f289014d = -1;
        this.f289015e = -1;
    }

    public final synchronized void b(long r210, long r310, byte[] r311) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r311, "outRefData");     // Catch: Throwable -> L67
        k r100 = g();     // Catch: Throwable -> L67
        if (r100 != null) goto L12;
        if (this.f289017g == true) goto L9;
        this.f289017g = true;     // Catch: Throwable -> L67
        com.larus.audio.call.util.e.f289645a.i("AecRefSentence", "[REF][POP][NO_REF]");     // Catch: Throwable -> L67
    L9:
        monitor-exit(this);
        return;
    L12:
        this.f289017g = false;     // Catch: Throwable -> L67
        Pair[] r101 = new Pair[5];     // Catch: Throwable -> L67
        r101[0] = TuplesKt.to("s_start", Long.valueOf(a()));     // Catch: Throwable -> L67
        k r102 = (k) CollectionsKt.lastOrNull(this.f289011a);     // Catch: Throwable -> L67
        if (r102 != null) goto L17;
        r102 = this.f289012b;     // Catch: Throwable -> L67
        if (r102 != null) goto L17;
        long r103 = -1;
    L19:
        r101[1] = TuplesKt.to("s_end", Long.valueOf(r103));     // Catch: Throwable -> L67
        r101[2] = TuplesKt.to("out_start", Long.valueOf(r210));     // Catch: Throwable -> L67
        r101[3] = TuplesKt.to("out_end", Long.valueOf(r310));     // Catch: Throwable -> L67
        r101[4] = TuplesKt.to("out_size", Integer.valueOf(r311.length));     // Catch: Throwable -> L67
        List r104 = CollectionsKt.mutableListOf(r101);     // Catch: Throwable -> L67
        long r110 = r210;
        long r111 = r110;
        int r105 = 0;
        int r106 = 0;
    L20:
        if (r100 == null) goto L65;
        r104.add(TuplesKt.to("block_" + r105 + "_start", Long.valueOf(r100.f289008a)));     // Catch: Throwable -> L67
        r104.add(TuplesKt.to("block_" + r105 + "_end", Long.valueOf(r100.f289009b)));     // Catch: Throwable -> L67
        r104.add(TuplesKt.to("block_" + r105 + "_size", Integer.valueOf(r100.f289010c.length)));     // Catch: Throwable -> L67
        int r107 = r105 + 1;     // Catch: Throwable -> L67
        long r112 = r100.f289008a;     // Catch: Throwable -> L67
        if (r310 < r112) goto L23;
        List r108 = r104;
        if (r110 < r100.f289009b) goto L31;
        com.larus.audio.call.util.e.f289645a.e("AecRefSentence", "[REF][POP][AFTER_REF]");     // Catch: Throwable -> L67
        r100 = g();     // Catch: Throwable -> L67
        r108 = r108;
    L64:
        r105 = r107;
        r104 = r108;
        goto L20
    L31:
        if (r112 != r110) goto L34;
    L36:
        int r109 = 0;
    L39:
        if (r100.f289009b < r310) goto L41;
        com.larus.audio.call.util.e.f289645a.i("AecRefSentence", "[REF][POP][IN_REF]");     // Catch: Throwable -> L67
        int r113 = r311.length - r106;     // Catch: Throwable -> L67
        long r114 = r310;
        boolean r115 = true;
    L43:
        if ((r113 % 2) != 1) goto L45;
        com.larus.audio.call.util.e r116 = com.larus.audio.call.util.e.f289645a;     // Catch: Throwable -> L67
        boolean r211 = r115;
        StringBuilder r117 = new StringBuilder();     // Catch: Throwable -> L67
        long r212 = r114;
        r117.append("[REF][POP][LENGTH_ERROR][srcPos:");     // Catch: Throwable -> L67
        r117.append(r109);     // Catch: Throwable -> L67
        r117.append("][destPos:");     // Catch: Throwable -> L67
        r117.append(r106);     // Catch: Throwable -> L67
        r117.append("][length:");     // Catch: Throwable -> L67
        r117.append(r113);     // Catch: Throwable -> L67
        r117.append("][refSize:");     // Catch: Throwable -> L67
        r117.append(r100.f289010c.length);     // Catch: Throwable -> L67
        r117.append("][outSize:");     // Catch: Throwable -> L67
        r117.append(r311.length);     // Catch: Throwable -> L67
        r117.append("][refStart:");     // Catch: Throwable -> L67
        r117.append(r100.f289008a);     // Catch: Throwable -> L67
        r117.append("][outStart:");     // Catch: Throwable -> L67
        r117.append(r111);     // Catch: Throwable -> L67
        r117.append("][outEnd:");     // Catch: Throwable -> L67
        r117.append(r310);     // Catch: Throwable -> L67
        r117.append(']');     // Catch: Throwable -> L67
        r116.e("AecRefSentence", r117.toString());     // Catch: Throwable -> L67
    L52:
        int r118 = r113;
        System.arraycopy(r100.f289010c, r109, r311, r106, r118);     // Catch: Throwable -> L67
        r106 = r106 + r118;     // Catch: Throwable -> L67
        int r119 = r118 + r109;     // Catch: Throwable -> L67
        if (r119 >= r100.f289010c.length) goto L55;
        com.larus.audio.call.util.e r120 = com.larus.audio.call.util.e.f289645a;     // Catch: Throwable -> L67
        r120.i("AecRefSentence", "[PENDING][BEFORE][duration:" + (r100.f289009b - r100.f289008a) + "][size:" + r100.f289010c.length + "][ratio:" + ((r100.f289009b - r100.f289008a) / ((long) r100.f289010c.length)) + ']');     // Catch: Throwable -> L67
        long r121 = r100.f289009b;     // Catch: Throwable -> L67
        byte[] r122 = r100.f289010c;     // Catch: Throwable -> L67
        this.f289012b = new k(r212, r121, ArraysKt.copyOfRange(r122, r119, r122.length));     // Catch: Throwable -> L67
        StringBuilder r123 = new StringBuilder();     // Catch: Throwable -> L67
        r123.append("[PENDING][AFTER][duration:");     // Catch: Throwable -> L67
        k r124 = this.f289012b;     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r124);     // Catch: Throwable -> L67
        long r125 = r124.f289009b;     // Catch: Throwable -> L67
        k r126 = this.f289012b;     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r126);     // Catch: Throwable -> L67
        r123.append(r125 - r126.f289008a);     // Catch: Throwable -> L67
        r123.append("][size:");     // Catch: Throwable -> L67
        k r127 = this.f289012b;     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r127);     // Catch: Throwable -> L67
        r123.append(r127.f289010c.length);     // Catch: Throwable -> L67
        r123.append("][ratio:");     // Catch: Throwable -> L67
        k r128 = this.f289012b;     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r128);     // Catch: Throwable -> L67
        long r129 = r128.f289009b;     // Catch: Throwable -> L67
        k r130 = this.f289012b;     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r130);     // Catch: Throwable -> L67
        long r131 = r129 - r130.f289008a;     // Catch: Throwable -> L67
        k r132 = this.f289012b;     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r132);     // Catch: Throwable -> L67
        r123.append(r131 / ((long) r132.f289010c.length));     // Catch: Throwable -> L67
        r123.append(']');     // Catch: Throwable -> L67
        r120.i("AecRefSentence", r123.toString());     // Catch: Throwable -> L67
    L55:
        if (r211 == true) goto L56;
        r100 = g();     // Catch: Throwable -> L67
        if (r100 != null) goto L62;
        c(r108);     // Catch: Throwable -> L67
    L63:
        r111 = r210;
        r110 = r212;
        goto L64
    L62:
        com.larus.audio.call.util.e.f289645a.e("AecRefSentence", "[REF][POP][CONTINUE]");     // Catch: Throwable -> L67
        goto L63
    L56:
        c(r108);     // Catch: Throwable -> L67
        monitor-exit(this);
        return;
    L45:
        r212 = r114;
        r211 = r115;
        if ((r109 + r113) <= r100.f289010c.length) goto L48;
    L51:
        c(r108);     // Catch: Throwable -> L67
        com.larus.audio.call.util.e.f289645a.e("AecRefSentence", "[REF][POP][COPY_ERROR][src_dur:" + (r100.f289009b - r100.f289008a) + "][src_size:" + r100.f289010c.length + "][out_dur:" + (r310 - r111) + "][out_size:" + r311.length + ']');     // Catch: Throwable -> L67
        goto L52
    L48:
        if ((r106 + r113) <= r311.length) goto L52;
    L41:
        com.larus.audio.call.util.e.f289645a.w("AecRefSentence", "[REF][POP][PART_REF_L]");     // Catch: Throwable -> L67
        r114 = r100.f289009b;     // Catch: Throwable -> L67
        r113 = r100.f289010c.length - r109;     // Catch: Throwable -> L67
        r115 = false;
        goto L43
    L34:
        if (r110 >= r112) goto L37;
        com.larus.audio.call.util.e.f289645a.w("AecRefSentence", "[REF][POP][PART_REF_R]");     // Catch: Throwable -> L67
        int r133 = r.f289018a;     // Catch: Throwable -> L67
        int r134 = (int) ((((long) r311.length) * (r100.f289008a - r111)) / (r310 - r111));     // Catch: Throwable -> L67
        r106 = r134 - (r134 % 2);     // Catch: Throwable -> L67
        goto L36
    L37:
        com.larus.audio.call.util.e.f289645a.w("AecRefSentence", "[REF][POP][REMAIN_REF][may paused]");     // Catch: Throwable -> L67
        int r135 = r.f289018a;     // Catch: Throwable -> L67
        long r136 = r100.f289010c.length;     // Catch: Throwable -> L67
        long r137 = r100.f289008a;     // Catch: Throwable -> L67
        int r138 = (int) ((r136 * (r110 - r137)) / (r100.f289009b - r137));     // Catch: Throwable -> L67
        r109 = r138 - (r138 % 2);     // Catch: Throwable -> L67
        r106 = 0;
        goto L39
    L23:
        com.larus.audio.call.util.e.f289645a.e("AecRefSentence", "[REF][POP][AHEAD_REF]");     // Catch: Throwable -> L67
        this.f289012b = r100;     // Catch: Throwable -> L67
        c(r104);     // Catch: Throwable -> L67
        monitor-exit(this);
        return;
    L65:
        monitor-exit(this);
        return;
    L17:
        r103 = r102.f289009b;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        throw th;
    }
}
