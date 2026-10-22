package com.bytedance.ee.bear.document.offline.sync.preloadtask;

import android.os.SystemClock;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.offline.sync.h0;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.preload.v2.task.OneTimeTask;
import fo5.d;
import io.reactivex.Flowable;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import o1c.b;
import o1c.c;
import q25.f;
import q25.g;
import q25.h;
import q25.i;
import r25.e;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\fH\u0002J\u0018\u0010#\u001a\u00020\u001c2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0018\u0010%\u001a\u00020\u001c2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J'\u0010&\u001a\u00020\u00042\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0002\u0010)J'\u0010*\u001a\u00020\u00042\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0002\u0010)J\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0,2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/preloadtask/DocsDataPreloadTask;", "Lcom/ss/android/lark/preload/v2/task/OneTimeTask;", "", "Lcom/bytedance/ee/bear/contract/offline/OfflineDoc;", "", "Lcom/bytedance/ee/bear/document/offline/sync/htmlcache/IPreloadStateCallback;", "ssrOnly", "limit", "", "<init>", "(ZI)V", "TAG", "", "remainToPreloadCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "startTimes", "Ljava/util/concurrent/ConcurrentHashMap;", "", "biz", "Lcom/ss/android/lark/appreciablelib/Biz;", "getBiz", "()Lcom/ss/android/lark/appreciablelib/Biz;", "value", "isInterrupted", "()Z", "setInterrupted", "(Z)V", "onTaskStart", "", "doc", "onTaskSuccess", "onTaskFail", "code", "onTaskFinish", "reqId", "doPreloadExt", "params", "doPreload", "getCacheExt", "extra", "", "(Ljava/util/List;Ljava/lang/Object;)Ljava/lang/Boolean;", "getCache", "getCacheKeys", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocsDataPreloadTask extends OneTimeTask<List<? extends OfflineDoc>, Boolean> implements f {
    public final boolean p;
    public final int q;
    public final String r;
    public AtomicInteger s;
    public final ConcurrentHashMap<String, Long> t;
    public final Biz u;
    public boolean v;

    public final Biz getBiz() {
        return this.u;
    }

    public final boolean isInterrupted() {
        return this.v;
    }

    @Override // q25.f
    public final void a(OfflineDoc r7) {
        Intrinsics.checkNotNullParameter(r7, "doc");
        a.h(this.r, "onTaskSuccess, id = " + r7.getReqId() + ", from = " + r7.getFrom_source());
        Long r0 = this.t.get(r7.getReqId());
        if (r0 == null) goto L5;
        r0.longValue();
        long r1 = System.currentTimeMillis() - r0.longValue();
    L6:
        b r2 = ((o1c.a) this).n;
        if (r2 == null) goto L9;
        Set r3 = SetsKt.setOf(r7.getToken());
        r7.getFrom_source();
        r2.a(this, r3);
    L9:
        c.a r4 = ((o1c.a) this).k;
        if (r4 == null) goto L12;
        r4.e(this, 1);
    L12:
        c.a r5 = ((o1c.a) this).k;
        if (r5 == null) goto L15;
        r5.b(this, 1, MapsKt.mapOf(new Pair[]{TuplesKt.to("executeTime", Long.valueOf(r1)), TuplesKt.to("source_type", r7.getFrom_source())}));
    L15:
        h(r7.getReqId());
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // q25.f
    public final void c(OfflineDoc r4) {
        Intrinsics.checkNotNullParameter(r4, "doc");
        a.h(this.r, "onTaskStart, id = " + r4.getReqId() + ", from = " + r4.getFrom_source());
        this.t.put(r4.getReqId(), Long.valueOf(System.currentTimeMillis()));
    }

    public final /* bridge */ /* synthetic */ void d(Object r1) {
        g((List) r1);
    }

    public final void e(Object r3) {
        ((o1c.a) this).m = SystemClock.elapsedRealtime();
        g((List) r3);
    }

    public final Set f(Object r3) {
        List r4 = (List) r3;
        HashSet r0 = new HashSet();
        if (r4 == null) goto L8;
        Iterator r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        r0.add(((OfflineDoc) r5.next()).getToken());
    L8:
        return r0;
    }

    public final void g(final List<? extends OfflineDoc> r11) {
        if (r11 == null) goto L50;
        a.h(this.r, "doPreload, count = " + r11.size());
        this.s = new AtomicInteger(r11.size());
        Long r0 = h0.j;
        h0 r1 = h0.b.a;
        String r2 = ((o1c.a) this).a;
        r1.getClass();
        if (r2 == null) goto L7;
        ((ConcurrentHashMap) r1.h).put(r2, new WeakReference(this));
    L7:
        if (this.p == true) goto L9;
        final int r3 = this.q;
        if (r1.g == false) goto L26;
        a.h("PreloadManager", "preloadClientVar disablePreload");
        return;
    L26:
        a.h("PreloadManager", "preloadClientVar. docList: " + hu5.a.c(r11));
        q25.a r4 = r1.c;
        if (r4 == null) goto L56;
        Iterator<? extends OfflineDoc> r6 = r11.iterator();
    L30:
        if (r6.hasNext() == false) goto L34;
        OfflineDoc r7 = r6.next();
        if (r7.getReqId() == null) goto L30;
        ((ConcurrentHashMap) r4.g).put(r7.getReqId(), -2);
        goto L30
    L34:
        r4.e(r11);
        final i r8 = r4.d;
        if (r8 == null) goto L37;
        a.h("PreloadHtmlCacheExecutor", "SSR preload docList " + r11.size());
        Flowable.just(Boolean.TRUE).subscribeOn(d.a()).subscribe(new g(r8, r11, r3), new h());
    L38:
        final e r5 = r4.c;
        r5.getClass();
        Flowable.just(Boolean.TRUE).subscribeOn(d.a()).subscribe(new r25.c(r5, r11, r3), new r25.d());
        return;
    L37:
        a.h("ClientVarHtmlCache", "Not support preload ssr because mHtmlCacheExecutor is null.");
        goto L38
    L56:
        return;
    L9:
        if (r1.g == false) goto L11;
        a.h("PreloadManager", "preloadSSR disablePreload");
        return;
    L11:
        a.h("PreloadManager", "preloadSSR. docList: " + hu5.a.c(r11));
        q25.a r9 = r1.c;
        if ((r9 instanceof q25.a) == false) goto L52;
        r9.getClass();
        a.h("ClientVarHtmlCache", "preloadSSROnly " + r11.size());
        Iterator<? extends OfflineDoc> r10 = r11.iterator();
    L14:
        final int r12 = -1;
        if (r10.hasNext() == false) goto L19;
        OfflineDoc r13 = r10.next();
        if (r13.getReqId() == null) goto L14;
        ((ConcurrentHashMap) r9.g).put(r13.getReqId(), -1);
        goto L14
    L19:
        r9.e(r11);
        final i r14 = r9.d;
        if (r14 == null) goto L22;
        a.h("PreloadHtmlCacheExecutor", "SSR preload docList " + r11.size());
        Flowable.just(Boolean.TRUE).subscribeOn(d.a()).subscribe(new g(r14, r11, r12), new h());
        return;
    L22:
        a.h("ClientVarHtmlCache", "Not support preload ssr because mHtmlCacheExecutor is null.");
        return;
    L52:
        return;
    }

    public final void h(String r2) {
        this.t.remove(r2);
        AtomicInteger r3 = this.s;
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.decrementAndGet());
    L6:
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.intValue() != 0) goto L15;
        a.h(this.r, "all tasks completed");
        Long r5 = h0.j;
        h0 r6 = h0.b.a;
        String r0 = ((o1c.a) this).a;
        if (r0 == null) goto L13;
        ((ConcurrentHashMap) r6.h).remove(r0);
        return;
    L13:
        r6.getClass();
        return;
    L15:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final Object j(Object r10) {
        if ((r10 instanceof y25.a) == false) goto L5;
        y25.a r11 = (y25.a) r10;
    L6:
        if (r11 == null) goto L26;
        String r0 = r11.b;
        if (r0 == null) goto L26;
        Set r1 = SetsKt.setOf(r0);
        boolean r2 = r11.c;
        c.a r3 = ((o1c.a) this).k;
        if (r3 == null) goto L13;
        r3.k(this, r2, MapsKt.mapOf(TuplesKt.to("source_type", r11.a)));
    L13:
        b r4 = ((o1c.a) this).n;
        if (r4 != null) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r2 == false) goto L24;
        if (r5 == true) goto L24;
        c.a r6 = ((o1c.a) this).k;
        if (r6 == null) goto L24;
        r6.m(this, MapsKt.mapOf(new Pair[]{TuplesKt.to("source_type", r11.a), TuplesKt.to("unique_id", r11.b), TuplesKt.to("first_hit_interval", Long.valueOf(SystemClock.elapsedRealtime() - ((o1c.a) this).m))}));
    L24:
        a.b(this.r, "getCache: hitCache = " + r2 + ", hasHit = " + r5);
        return Boolean.valueOf(r2);
    L16:
        if (r4.c(this, r1) != true) goto L18;
        r5 = true;
    L26:
        return Boolean.FALSE;
    L5:
        r11 = null;
        goto L6
    }

    public final void k(boolean r2) {
        if (this.v == r2) goto L5;
        Long r0 = h0.j;
        q25.a r1 = h0.b.a.c;
    L5:
        this.v = r2;
    }

    public DocsDataPreloadTask(boolean r1, int r2) {
        this.p = r1;
        this.q = r2;
        this.r = "DocsDataPreloadTask_" + ((o1c.a) this).a;
        this.t = new ConcurrentHashMap();
        this.u = Biz.Docs;
    }

    @Override // q25.f
    public final void b(OfflineDoc r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "doc");
        a.h(this.r, "onTaskFail, code = " + r5 + ", id = " + r4.getReqId() + ", from = " + r4.getFrom_source());
        h(r4.getReqId());
    }
}
