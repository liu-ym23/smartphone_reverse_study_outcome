package com.bytedance.android.shopping.mall.homepage.chunked;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECTrackDataDTO;
import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.entity.n;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.shopping.api.mall.model.ChunkedSectionData;
import com.bytedance.android.shopping.api.mall.model.ChunkedTrackAndRec;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.bytedance.android.shopping.mall.homepage.tools.l;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class HomepageChunkedCallback implements com.bytedance.android.ec.hybrid.data.utils.a.a<HomePageDTO> {
    public static final /* synthetic */ int o = 0;
    public final Lazy a;
    public final Lazy b;
    public final DataEngineWrapper c;
    public final Lazy d;
    public final AtomicInteger e;
    public final Handler f;
    public final Object g;
    public volatile HomePageDTO h;
    public volatile HomePageDTO i;
    public volatile int j;
    public volatile boolean k;
    public volatile Map<String, String> l;
    public volatile Map<String, String> m;
    public final b n;

    public static final class a {
    }

    public static final class b {
        public final Function0<HomePageDTO> a;
        public final Function2<HomePageDTO, Boolean, Unit> b;
        public final boolean c;
        public final DataEngineWrapper d;
        public final Function0<ECHybridListEngine> e;
        public final Function4<String, ECHybridNetworkVO, String, HomePageDTO, Unit> f;
        public final Function1<HomePageDTO, Unit> g;
        public final Function3<String, Throwable, ECHybridNetworkVO, Unit> h;
        public final Function1<HomePageDTO, Unit> i;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L24;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.i, r4.i) == true) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        public final int hashCode() {
            Function0<HomePageDTO> r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Function2<HomePageDTO, Boolean, Unit> r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            boolean r7 = this.c;
            ?? r8 = r7;
            if (r7 == false) goto L13;
            r8 = 1;
        L13:
            int r9 = (r6 + r8) * 31;
            DataEngineWrapper r10 = this.d;
            if (r10 == null) goto L16;
            int r11 = r10.hashCode();
        L17:
            int r12 = (r9 + r11) * 31;
            Function0<ECHybridListEngine> r13 = this.e;
            if (r13 == null) goto L20;
            int r14 = r13.hashCode();
        L21:
            int r15 = (r12 + r14) * 31;
            Function4<String, ECHybridNetworkVO, String, HomePageDTO, Unit> r16 = this.f;
            if (r16 == null) goto L24;
            int r17 = r16.hashCode();
        L25:
            int r18 = (r15 + r17) * 31;
            Function1<HomePageDTO, Unit> r19 = this.g;
            if (r19 == null) goto L28;
            int r20 = r19.hashCode();
        L29:
            int r21 = (r18 + r20) * 31;
            Function3<String, Throwable, ECHybridNetworkVO, Unit> r22 = this.h;
            if (r22 == null) goto L32;
            int r23 = r22.hashCode();
        L33:
            int r24 = (r21 + r23) * 31;
            Function1<HomePageDTO, Unit> r25 = this.i;
            if (r25 == null) goto L37;
            r1 = r25.hashCode();
        L37:
            return r24 + r1;
        L32:
            r23 = 0;
            goto L33
        L28:
            r20 = 0;
            goto L29
        L24:
            r17 = 0;
            goto L25
        L20:
            r14 = 0;
            goto L21
        L16:
            r11 = 0;
            goto L17
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Config(cacheDataGetter=" + this.a + ", checkHeaderCardType=" + this.b + ", notifyProcessor=" + this.c + ", dataEngineWrapper=" + this.d + ", listContainer=" + this.e + ", onRenderBack=" + this.f + ", onRequestSuccess=" + this.g + ", onRequestError=" + this.h + ", updateCache=" + this.i + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function0<HomePageDTO> r2, Function2<? super HomePageDTO, ? super Boolean, Unit> r3, boolean r4, DataEngineWrapper r5, Function0<ECHybridListEngine> r6, Function4<? super String, ? super ECHybridNetworkVO, ? super String, ? super HomePageDTO, Unit> r7, Function1<? super HomePageDTO, Unit> r8, Function3<? super String, ? super Throwable, ? super ECHybridNetworkVO, Unit> r9, Function1<? super HomePageDTO, Unit> r10) {
            Intrinsics.checkNotNullParameter(r2, "cacheDataGetter");
            Intrinsics.checkNotNullParameter(r3, "checkHeaderCardType");
            Intrinsics.checkNotNullParameter(r6, "listContainer");
            Intrinsics.checkNotNullParameter(r7, "onRenderBack");
            Intrinsics.checkNotNullParameter(r8, "onRequestSuccess");
            Intrinsics.checkNotNullParameter(r9, "onRequestError");
            Intrinsics.checkNotNullParameter(r10, "updateCache");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void e() {
        if (this.j != 1) goto L5;
    L8:
        f(new HomepageChunkedCallback$onFirstScreenSuccess$1(this));
    L9:
        this.k = true;
        return;
    L5:
        if (this.j != 2) goto L9;
        if (this.i == null) goto L9;
        goto L8
    }

    public HomepageChunkedCallback(b r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.n = r2;
        this.a = LazyKt.lazy(HomepageChunkedCallback$firstScreenImageOptEnable$2.INSTANCE);
        this.b = LazyKt.lazy(HomepageChunkedCallback$ioDispatchOptEnable$2.INSTANCE);
        this.c = r2.d;
        this.d = LazyKt.lazy(new HomepageChunkedCallback$_listContainer$2(this));
        this.e = new AtomicInteger(0);
        this.f = new Handler(Looper.getMainLooper());
        this.g = new Object();
    }

    public final void f(Function0<Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r3.invoke();
        return;
    L5:
        this.f.postAtFrontOfQueue(new c(r3));
    }

    public static final void d(HomepageChunkedCallback r10, boolean r11) {
        ECHybridListEngine r0 = (ECHybridListEngine) r10.d.getValue();
        if (r0 == null) goto L81;
        k r1 = r0.c.g;
        if (r1 == null) goto L126;
        ArrayList r2 = r1.c;
        if (r2 == null) goto L127;
        Iterator r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L128;
        i r4 = (i) r3.next();
        HomePageDTO r5 = r10.i;
        if (r5 == null) goto L10;
        List<ChunkedSectionData> r6 = r5.getChunkDataList();
        if (r6 == null) goto L10;
        Iterator<T> r7 = r6.iterator();
    L17:
        if (r7.hasNext() == false) goto L21;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(((ChunkedSectionData) r8).getChunkSectionId(), r4.a) == false) goto L17;
    L22:
        ChunkedSectionData r9 = (ChunkedSectionData) r8;
        if (r9 == null) goto L10;
        List<ChunkedTrackAndRec> r12 = r9.getChunkInfo();
        if (r12 == null) goto L10;
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L29:
        if (r14.hasNext() == false) goto L36;
        Object r15 = r14.next();
        if (((ChunkedTrackAndRec) r15).getId() == null) goto L33;
        boolean r16 = true;
    L34:
        if (r16 == false) goto L29;
        r13.add(r15);
        goto L29
    L33:
        r16 = false;
        goto L34
    L36:
        LinkedHashMap r17 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r13, 10)), 16));
        Iterator r18 = r13.iterator();
    L38:
        if (r18.hasNext() == false) goto L41;
        Object r19 = r18.next();
        String r20 = ((ChunkedTrackAndRec) r19).getId();
        Intrinsics.checkNotNull(r20);
        r17.put(r20, r19);
        goto L38
    L41:
        if (Intrinsics.areEqual(r4.a, "favorite_section") == false) goto L10;
        ArrayList r21 = r4.i;
        if (r21 == null) goto L71;
        Iterator r22 = r21.iterator();
    L46:
        if (r22.hasNext() == false) goto L71;
        ECHybridListItemVO r23 = (ECHybridListItemVO) r22.next();
        String r24 = r23.d;
        if (r24 == null) goto L46;
        ChunkedTrackAndRec r25 = (ChunkedTrackAndRec) r17.get(r24);
        if (r25 == null) goto L46;
        ECTrackDataDTO r26 = r25.getTrackData();
        if (r26 == null) goto L56;
        ECTrackDataDTO.Companion.getClass();
        r23.o = ECTrackDataDTO.a.b(r26, r23);
    L56:
        r23.q(r25.getRecommendInfo());
        String r27 = r23.d;
        String r28 = r25.getRecommendInfo();
        if (r27 == null) goto L46;
        if (r28 == null) goto L46;
        ECHybridListEngine r29 = (ECHybridListEngine) r10.d.getValue();
        if (r29 == null) goto L46;
        BaseViewHolder r30 = r29.e(r4.a, r27);
        if (r30 == null) goto L46;
        n r31 = r23.o;
        if (r31 == null) goto L66;
        HashMap r32 = r31.b;
    L67:
        if (r31 == null) goto L69;
        String r33 = r31.h;
    L70:
        r30.m4(new com.bytedance.android.ec.hybrid.list.entity.a(r28, r32, r33));
        goto L46
    L69:
        r33 = null;
        goto L70
    L66:
        r32 = null;
    L71:
        if (r11 == true) goto L10;
        ECHybridListEngine r34 = (ECHybridListEngine) r10.d.getValue();
        if (r34 == null) goto L10;
        ECHybridRecyclerView r35 = r34.b;
        if (r35 == null) goto L10;
        Iterator r36 = ((ArrayList) r35.K).iterator();
    L78:
        if (r36.hasNext() == false) goto L80;
        ((Runnable) r36.next()).run();
        goto L78
    L80:
        ((ArrayList) r35.K).clear();
        goto L10
    L21:
        r8 = null;
        goto L22
    L128:
        return;
    L127:
        return;
    L126:
        return;
    }

    public final void a(String r2, Object r3) {
        HomePageDTO r4 = (HomePageDTO) r3;
        Intrinsics.checkNotNullParameter(r2, "apiKey");
        Intrinsics.checkNotNullParameter(r2, "apiKey");
        this.n.g.invoke(r4);
        if (r4 == null) goto L6;
        Single.fromCallable(new com.bytedance.android.shopping.mall.homepage.chunked.b(this, r4)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe();
        return;
    }

    public final void b(String r3, ECHybridNetworkVO r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, "apiKey");
        Intrinsics.checkNotNullParameter(r5, "error");
        Intrinsics.checkNotNullParameter(r3, "apiKey");
        Intrinsics.checkNotNullParameter(r5, "error");
        this.n.h.invoke(r3, r5, r4);
    }

    public final void c(final String r7, final ECHybridNetworkVO r8, final String r9, Object r10) {
        final HomePageDTO r5 = (HomePageDTO) r10;
        Intrinsics.checkNotNullParameter(r7, "apiKey");
        Intrinsics.checkNotNullParameter(r9, "chunkedResult");
        Intrinsics.checkNotNullParameter(r7, "apiKey");
        Intrinsics.checkNotNullParameter(r9, "chunkedResult");
        this.n.b.invoke(r5, Boolean.FALSE);
        if (this.n.c == false) goto L11;
        if (r5 == null) goto L11;
        int r11 = l.i;
        if (Intrinsics.areEqual(r5.getChunkedSection(), "rendering_data") == false) goto L11;
        com.bytedance.android.shopping.mall.homepage.chunked.a r12 = new com.bytedance.android.shopping.mall.homepage.chunked.a(this, r5);
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L10;
        Schedulers.io().createWorker().schedule(r12);
        goto L11
    L10:
        r12.run();
    L11:
        final int r13 = this.e.incrementAndGet();
        DataEngineWrapper r0 = this.c;
        if (r0 == null) goto L14;
        r0.L(new HomepageChunkedCallback$updateFirstScreenMonitor$1(this, r13, r8, r5));
    L14:
        if (r5 == null) goto L16;
        String r14 = r5.getChunkedSection();
    L17:
        if (r14 == null) goto L91;
        int r1 = r14.hashCode();
        int r2 = 1;
        if (r1 == (-1727465091)) goto L65;
        if (r1 == 1738089522) goto L25;
        return;
    L25:
        if (r14.equals("tracking_data") == false) goto L86;
        this.i = r5;
        Object r15 = this.g;
        monitor-enter(r15);
    L61:
        th = move-exception;
        throw th;
    L29:
        if (this.m != null) goto L31;
        this.m = new LinkedHashMap();     // Catch: Throwable -> L61
    L31:
        List<ChunkedSectionData> r16 = r5.getChunkDataList();     // Catch: Throwable -> L61
        if (r16 == null) goto L55;
        Iterator<T> r17 = r16.iterator();     // Catch: Throwable -> L61
    L35:
        if (r17.hasNext() == false) goto L54;
        List<ChunkedTrackAndRec> r18 = ((ChunkedSectionData) r17.next()).getChunkInfo();     // Catch: Throwable -> L61
        if (r18 == null) goto L35;
        ArrayList r19 = new ArrayList();     // Catch: Throwable -> L61
        Iterator<T> r20 = r18.iterator();     // Catch: Throwable -> L61
    L40:
        if (r20.hasNext() == false) goto L47;
        Object r3 = r20.next();     // Catch: Throwable -> L61
        if (((ChunkedTrackAndRec) r3).getId() == null) goto L44;
        boolean r4 = true;
    L45:
        if (r4 == false) goto L40;
        r19.add(r3);     // Catch: Throwable -> L61
        goto L40
    L44:
        r4 = false;
        goto L45
    L47:
        LinkedHashMap r6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r19, 10)), 16));     // Catch: Throwable -> L61
        Iterator r21 = r19.iterator();     // Catch: Throwable -> L61
    L49:
        if (r21.hasNext() == false) goto L51;
        ChunkedTrackAndRec r110 = (ChunkedTrackAndRec) r21.next();     // Catch: Throwable -> L61
        String r22 = r110.getId();     // Catch: Throwable -> L61
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L61
        Pair r111 = TuplesKt.to(r22, r110.getRecommendInfo());     // Catch: Throwable -> L61
        r6.put(r111.getFirst(), r111.getSecond());     // Catch: Throwable -> L61
        goto L49
    L51:
        Map<String, String> r23 = this.m;     // Catch: Throwable -> L61
        if (r23 == null) goto L35;
        r23.putAll(r6);     // Catch: Throwable -> L61
        goto L35
    L54:
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L61
    L55:
        monitor-exit(r15);
        if (this.h != null) goto L59;
        return;
    L59:
        if (this.k == false) goto L88;
        f(new HomepageChunkedCallback$onTrackBack$1(this));
        return;
    L88:
        return;
    L86:
        return;
    L65:
        if (r14.equals("rendering_data") == false) goto L90;
        this.h = r5;
        if (this.i == null) goto L69;
        int r112 = l.i;
        l.a.a(r5, this.i);
        r2 = 2;
    L69:
        this.j = r2;
        f(new HomepageChunkedCallback$onRenderBack$1(this, r7, r8, r9, r5));
        return;
    L90:
        return;
    L91:
        return;
    L16:
        r14 = null;
        goto L17
    }
}
