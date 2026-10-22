package com.larus.audio.call.aec;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f288956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f288957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f288958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f288959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f288960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AecConsumeResult f288961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArrayList<Pair<Long, Long>> f288962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f288963h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.audio.call.aec.b$b, reason: collision with other inner class name */
    public static final class C3961b<T> implements Comparator {
        public C3961b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((Long) ((Pair) r100).getSecond(), (Long) ((Pair) r101).getSecond());
        }
    }

    static {
    }

    public final List<Pair<String, Long>> d() {
        Long r100 = this.f288956a;
        Long r101 = this.f288957b;
        if (r100 == null) goto L7;
        if (r101 == null) goto L7;
        StringBuilder r102 = new StringBuilder("[sentence-start:");
        SimpleDateFormat r103 = c.f288964a;
        r102.append(c.b(r100.longValue()));
        List r104 = CollectionsKt.listOf(new Pair[]{TuplesKt.to(r102.toString(), r100), TuplesKt.to("sentence-end:" + c.b(r101.longValue()) + ']', r101)});
    L8:
        List r105 = r104;
        CopyOnWriteArrayList<Pair<Long, Long>> r106 = this.f288962g;
        ArrayList r107 = new ArrayList();
        Iterator<Pair<Long, Long>> r108 = r106.iterator();
    L10:
        if (r108.hasNext() == false) goto L12;
        Pair<Long, Long> r109 = r108.next();
        CollectionsKt.addAll(r107, CollectionsKt.listOf(new Pair[]{TuplesKt.to("[gap-start:" + r109.getFirst().longValue(), r109.getFirst()), TuplesKt.to("gap-end:" + r109.getSecond().longValue() + ']', r109.getSecond())}));
        goto L10
    L12:
        List<Pair<String, Long>> r110 = CollectionsKt.plus(r105, r107);
        if (this.f288959d <= 0) goto L17;
        StringBuilder r111 = new StringBuilder("[last-audio-start:");
        SimpleDateFormat r112 = c.f288964a;
        r111.append(c.b(this.f288959d));
        return CollectionsKt.plus(r110, CollectionsKt.listOf(new Pair[]{TuplesKt.to(r111.toString(), Long.valueOf(this.f288959d)), TuplesKt.to("last-audio-end:" + c.b(this.f288960e) + ']', Long.valueOf(this.f288960e))}));
    L17:
        return r110;
    L7:
        r104 = CollectionsKt.emptyList();
        goto L8
    }

    public b() {
        this.f288958c = true;
        this.f288962g = new CopyOnWriteArrayList();
    }

    public static String c(List r100) {
        return CollectionsKt.joinToString$default(CollectionsKt.sortedWith(r100, new C3961b()), " - ", null, null, 0, null, new com.larus.audio.call.aec.a(), 30, null);
    }

    public final void b(z r210) {
        Intrinsics.checkNotNullParameter(r210, "data");
        Long r100 = this.f288956a;
        Long r101 = this.f288957b;
        if (r100 != null) goto L5;
    L23:
        com.larus.audio.call.util.e.f289645a.e("Aec_Consume", "[ERROR][Ref][enqueueTtsData] but no start sentence");
        return;
    L5:
        if (this.f288958c == true) goto L23;
        if (r100.longValue() == 0) goto L19;
        if (r101 == null) goto L19;
        if (r210.f289022a >= this.f288960e) goto L14;
        StringBuilder r102 = new StringBuilder("[last-audio-start:");
        SimpleDateFormat r103 = c.f288964a;
        r102.append(c.b(this.f288959d));
        String r104 = c(CollectionsKt.listOf(new Pair[]{TuplesKt.to(r102.toString(), Long.valueOf(this.f288959d)), TuplesKt.to("last-audio-end:" + c.b(this.f288960e) + ']', Long.valueOf(this.f288960e)), TuplesKt.to("[sentence-start:" + c.b(r100.longValue()), r100), TuplesKt.to("sentence-end:" + c.b(r101.longValue()) + ']', r101), TuplesKt.to("[new-part-start:" + c.b(r210.f289022a), Long.valueOf(r210.f289022a)), TuplesKt.to("new-part-end:" + c.b(r210.f289023b) + ']', Long.valueOf(r210.f289023b))}));
        com.larus.audio.call.util.e r105 = com.larus.audio.call.util.e.f289645a;
        StringBuilder r106 = new StringBuilder("[Ref][ERROR][CONTINUE][TTS DELAY], ");
        r106.append(r104);
        r105.e("Aec_Consume", r106.toString());
    L18:
        this.f288957b = Long.valueOf(r210.f289023b);
        return;
    L14:
        long r107 = r101.longValue();
        long r110 = r210.f289022a;
        if (r107 >= r110) goto L17;
        this.f288962g.add(TuplesKt.to(r101, Long.valueOf(r110)));
        StringBuilder r108 = new StringBuilder("[last-audio-start:");
        SimpleDateFormat r109 = c.f288964a;
        r108.append(c.b(this.f288959d));
        String r111 = c(CollectionsKt.listOf(new Pair[]{TuplesKt.to(r108.toString(), Long.valueOf(this.f288959d)), TuplesKt.to("last-audio-end:" + c.b(this.f288960e) + ']', Long.valueOf(this.f288960e)), TuplesKt.to("[sentence-start:" + c.b(r100.longValue()), r100), TuplesKt.to("sentence-end:" + c.b(r101.longValue()) + ']', r101), TuplesKt.to("[new-part-start:" + c.b(r210.f289022a), Long.valueOf(r210.f289022a)), TuplesKt.to("new-part-end:" + c.b(r210.f289023b) + ']', Long.valueOf(r210.f289023b))}));
        com.larus.audio.call.util.e r112 = com.larus.audio.call.util.e.f289645a;
        StringBuilder r113 = new StringBuilder("[Ref][ERROR][CONTINUE][TTS GAP], ");
        r113.append(r111);
        r112.e("Aec_Consume", r113.toString());
        goto L18
    L17:
        StringBuilder r114 = new StringBuilder("[last-audio-start:");
        SimpleDateFormat r115 = c.f288964a;
        r114.append(c.b(this.f288959d));
        String r116 = c(CollectionsKt.listOf(new Pair[]{TuplesKt.to(r114.toString(), Long.valueOf(this.f288959d)), TuplesKt.to("last-audio-end:" + c.b(this.f288960e) + ']', Long.valueOf(this.f288960e)), TuplesKt.to("[sentence-start:" + c.b(r100.longValue()), r100), TuplesKt.to("sentence-end:" + c.b(r101.longValue()) + ']', r101), TuplesKt.to("[new-part-start:" + c.b(r210.f289022a), Long.valueOf(r210.f289022a)), TuplesKt.to("new-part-end:" + c.b(r210.f289023b) + ']', Long.valueOf(r210.f289023b))}));
        com.larus.audio.call.util.e r117 = com.larus.audio.call.util.e.f289645a;
        StringBuilder r118 = new StringBuilder("[Ref][CONTINUE], ");
        r118.append(r116);
        r117.i("Aec_Consume", r118.toString());
    L19:
        this.f288956a = Long.valueOf(r210.f289022a);
        this.f288957b = Long.valueOf(r210.f289023b);
        com.larus.audio.call.util.e r119 = com.larus.audio.call.util.e.f289645a;
        StringBuilder r120 = new StringBuilder("[Ref][SentenceStart][");
        SimpleDateFormat r121 = c.f288964a;
        r120.append(c.b(r210.f289022a));
        r120.append(" - ");
        r120.append(c.b(r210.f289023b));
        r120.append("][");
        r120.append(r210.f289023b - r210.f289022a);
        r120.append(']');
        r119.i("Aec_Consume", r120.toString());
        if (r210.f289022a >= this.f288960e) goto L26;
        String r122 = c(CollectionsKt.listOf(new Pair[]{TuplesKt.to("[last-audio-start:" + c.b(this.f288959d), Long.valueOf(this.f288959d)), TuplesKt.to("last-audio-end:" + c.b(this.f288960e) + ']', Long.valueOf(this.f288960e)), TuplesKt.to("[sentence-start:" + c.b(r210.f289022a), Long.valueOf(r210.f289022a)), TuplesKt.to("sentence-end:" + c.b(r210.f289023b) + ']', Long.valueOf(r210.f289023b))}));
        StringBuilder r123 = new StringBuilder("[Ref][ERROR][START][TTS DELAY], ");
        r123.append(r122);
        r119.e("Aec_Consume", r123.toString());
        return;
    }

    public final void a(long r100, long r110, AecConsumeResult r111) {
        Intrinsics.checkNotNullParameter(r111, "result");
        if (this.f288960e <= r100) goto L10;
        com.larus.audio.call.util.e r101 = com.larus.audio.call.util.e.f289645a;
        StringBuilder r102 = new StringBuilder("[Mic][WRONG SCOPE], LAST[");
        SimpleDateFormat r103 = c.f288964a;
        r102.append(c.b(this.f288959d));
        r102.append(" - ");
        r102.append(c.b(this.f288960e));
        r102.append("]【");
        AecConsumeResult r104 = this.f288961f;
        if (r104 == null) goto L7;
        String r105 = r104.getMessage();
    L8:
        r102.append(r105);
        r102.append("】, NEW[");
        r102.append(c.b(r100));
        r102.append(" - ");
        r102.append(c.b(r110));
        r102.append("]【");
        r102.append(r111.getMessage());
        r102.append(12305);
        r101.e("Aec_Consume", r102.toString());
    L12:
        this.f288959d = r100;
        this.f288960e = r110;
        this.f288961f = r111;
        return;
    L7:
        r105 = null;
        goto L8
    L10:
        if (this.f288961f == r111) goto L12;
        String r106 = c(CollectionsKt.plus(d(), CollectionsKt.listOf(new Pair[]{TuplesKt.to("[audio-start:" + c.b(r100), Long.valueOf(r100)), TuplesKt.to("audio-end:" + c.b(r110) + ']', Long.valueOf(r110))})));
        com.larus.audio.call.util.e.f289645a.i("Aec_Consume", "[Mic]【" + r111.getMessage() + 12305 + r106 + ' ');
        goto L12
    }
}
