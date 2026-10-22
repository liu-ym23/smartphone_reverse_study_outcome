package com.larus.paging;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes29.dex */
public final class PageFetcherSnapshot<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Key f363688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PagingSource<Key, Value> f363689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0 f363690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Flow<Unit> f363691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f363692e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y0<Key, Value> f363693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w0<Key, Value> f363694g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f363695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p f363696i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f363697j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Channel<PageEvent<Value>> f363698k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e0.a<Key, Value> f363699l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CompletableJob f363700m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 f363701n;

    /* JADX INFO: renamed from: com.larus.paging.PageFetcherSnapshot$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Key", "", "Value", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f363702a = null;

        static {
            int[] r100 = new int[LoadType.values().length];
            r100[LoadType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LoadType.PREPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LoadType.APPEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f363702a = r100;
        }
    }

    public final Object e(Continuation<? super w0<Key, Value>> r100) {
        if ((r100 instanceof PageFetcherSnapshot$currentPagingState$1) == false) goto L7;
        PageFetcherSnapshot$currentPagingState$1 r101 = (PageFetcherSnapshot$currentPagingState$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r101.L$2;
        e0.a<Key, Value> r107 = (e0.a) r101.L$1;
        PageFetcherSnapshot<Key, Value> r108 = (PageFetcherSnapshot) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L24:
        w0<Key, Value> r109 = r107.f363828b.a(r108.f363696i.f363903a.f363908c);     // Catch: Throwable -> L21
        r106.unlock(null);
        return r109;
    L21:
        th = move-exception;
        r106.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r107 = this.f363699l;
        MutexImpl r110 = r107.f363827a;
        r101.L$0 = this;
        r101.L$1 = r107;
        r101.L$2 = r110;
        r101.label = 1;
        if (r110.a(null, r101) != r104) goto L17;
        return r104;
    L17:
        r108 = this;
        r106 = r110;
    L7:
        r101 = new PageFetcherSnapshot$currentPagingState$1(this, r100);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v28, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v8, types: [kotlinx.coroutines.sync.a] */
    public final Object f(Continuation<? super Unit> r110) {
        if ((r110 instanceof PageFetcherSnapshot$doInitialLoad$1) == false) goto L7;
        PageFetcherSnapshot$doInitialLoad$1 r100 = (PageFetcherSnapshot$doInitialLoad$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r103 = r100.label;
        switch(r103) {
            case 0: goto L29;
            case 1: goto L28;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L12;
            default: goto L11;
        };
    L12:
        kotlinx.coroutines.sync.a r104 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L15
    L101:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r104.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = th;
        kotlinx.coroutines.sync.a r105 = r104;
    L106:
        r105.unlock(null);
        throw th;
    L17:
        r105 = (kotlinx.coroutines.sync.a) r100.L$3;
        e0.a<Key, Value> r106 = (e0.a) r100.L$2;
        PagingSource.b r107 = (PagingSource.b) r100.L$1;
        PageFetcherSnapshot<Key, Value> r108 = (PageFetcherSnapshot) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L122:
        e0<Key, Value> r113 = r106.f363828b;     // Catch: Throwable -> L105
        u.a r109 = new u.a(((PagingSource.b.a) r107).f363728a);     // Catch: Throwable -> L105
        LoadType r114 = LoadType.REFRESH;     // Catch: Throwable -> L105
        r100.L$0 = r105;     // Catch: Throwable -> L105
        r100.L$1 = null;     // Catch: Throwable -> L105
        r100.L$2 = null;     // Catch: Throwable -> L105
        r100.L$3 = null;     // Catch: Throwable -> L105
        r100.label = 9;     // Catch: Throwable -> L105
        if (r108.i(r113, r114, r109, r100) != r102) goto L100;
        return r102;
    L100:
        r104 = r105;
    L105:
        th = th;
        goto L106
    L18:
        kotlinx.coroutines.sync.a r115 = (kotlinx.coroutines.sync.a) r100.L$3;
        e0.a<Key, Value> r116 = (e0.a) r100.L$2;
        PagingSource.b r117 = (PagingSource.b) r100.L$1;
        PageFetcherSnapshot<Key, Value> r118 = (PageFetcherSnapshot) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L120:
        w0<Key, Value> r119 = r116.f363828b.a(r118.f363696i.f363903a.f363908c);     // Catch: Throwable -> L86
        r115.unlock(null);
        PagingSource.b.c r120 = (PagingSource.b.c) r117;
        if (r120.f363730b != null) goto L84;
        r118.f363693f.c(LoadType.PREPEND, r119);
    L84:
        if (r120.f363731c != null) goto L112;
        r118.f363693f.c(LoadType.APPEND, r119);
    L112:
        return Unit.INSTANCE;
    L86:
        th = move-exception;
        r115.unlock(null);
        throw th;
    L19:
        kotlinx.coroutines.sync.a r121 = (kotlinx.coroutines.sync.a) r100.L$2;
        r117 = (PagingSource.b) r100.L$1;
        PageFetcherSnapshot<Key, Value> r122 = (PageFetcherSnapshot) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L65
        r103 = r121;
    L63:
        Unit r123 = Unit.INSTANCE;     // Catch: Throwable -> L65
        r103.unlock(null);
    L70:
        if (r122.f363693f == null) goto L112;
        PagingSource.b.c r124 = (PagingSource.b.c) r117;
        if (r124.f363730b != null) goto L74;
    L75:
        r116 = r122.f363699l;
        MutexImpl r125 = r116.f363827a;
        r100.L$0 = r122;
        r100.L$1 = r117;
        r100.L$2 = r116;
        r100.L$3 = r125;
        r100.label = 7;
        if (r125.a(null, r100) != r102) goto L78;
        return r102;
    L78:
        r115 = r125;
        r118 = r122;
        goto L120
    L74:
        if (r124.f363731c != null) goto L112;
    L22:
        kotlinx.coroutines.sync.a r126 = (kotlinx.coroutines.sync.a) r100.L$3;
        e0.a<Key, Value> r127 = (e0.a) r100.L$2;
        r107 = (PagingSource.b) r100.L$1;
        r108 = (PageFetcherSnapshot) r100.L$0;
        ResultKt.throwOnFailure(r111);
        kotlinx.coroutines.sync.a r128 = r126;
    L59:
        e0<Key, Value> r129 = r127.f363828b;     // Catch: Throwable -> L65
        Channel<PageEvent<Value>> r130 = r108.f363698k;     // Catch: Throwable -> L65
        PageEvent.Insert r131 = r129.e((PagingSource.b.c) r107, LoadType.REFRESH);     // Catch: Throwable -> L65
        r100.L$0 = r108;     // Catch: Throwable -> L65
        r100.L$1 = r107;     // Catch: Throwable -> L65
        r100.L$2 = r128;     // Catch: Throwable -> L65
        r100.L$3 = null;     // Catch: Throwable -> L65
        r100.label = 6;     // Catch: Throwable -> L65
        if (r130.send(r131, r100) != r102) goto L62;
        return r102;
    L62:
        r117 = r107;
        r122 = r108;
        r103 = r128;
        goto L63
    L23:
        kotlinx.coroutines.sync.a r132 = (kotlinx.coroutines.sync.a) r100.L$3;
        e0.a<Key, Value> r133 = (e0.a) r100.L$2;
        r107 = (PagingSource.b) r100.L$1;
        r108 = (PageFetcherSnapshot) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L124:
        e0<Key, Value> r134 = r133.f363828b;     // Catch: Throwable -> L89
        LoadType r135 = LoadType.REFRESH;     // Catch: Throwable -> L89
        boolean r136 = r134.insert(0, r135, (PagingSource.b.c) r107);     // Catch: Throwable -> L89
        r134.f363826l.c(r135, u.c.f363923c);     // Catch: Throwable -> L89
        if (((PagingSource.b.c) r107).f363730b != null) goto L51;
        r134.f363826l.c(LoadType.PREPEND, u.c.f363922b);     // Catch: Throwable -> L89
    L51:
        if (((PagingSource.b.c) r107).f363731c != null) goto L53;
        r134.f363826l.c(LoadType.APPEND, u.c.f363922b);     // Catch: Throwable -> L89
    L53:
        r132.unlock(null);
        if (r136 == false) goto L68;
        r127 = r108.f363699l;
        MutexImpl r137 = r127.f363827a;
        r100.L$0 = r108;
        r100.L$1 = r107;
        r100.L$2 = r127;
        r100.L$3 = r137;
        r100.label = 5;
        if (r137.a(null, r100) != r102) goto L58;
        return r102;
    L58:
        r128 = r137;
        goto L59
    L68:
        r117 = r107;
        r122 = r108;
    L89:
        th = move-exception;
        r132.unlock(null);
        throw th;
    L24:
        PageFetcherSnapshot<Key, Value> r138 = (PageFetcherSnapshot) r100.L$0;
        ResultKt.throwOnFailure(r111);
        r108 = r138;
    L42:
        r107 = (PagingSource.b) r111;
        if ((r107 instanceof PagingSource.b.c) == false) goto L93;
        r133 = r108.f363699l;
        r132 = r133.f363827a;
        r100.L$0 = r108;
        r100.L$1 = r107;
        r100.L$2 = r133;
        r100.L$3 = r132;
        r100.label = 4;
        if (r132.a(null, r100) != r102) goto L124;
        return r102;
    L93:
        if ((r107 instanceof PagingSource.b.a) == false) goto L109;
        r106 = r108.f363699l;
        r105 = r106.f363827a;
        r100.L$0 = r108;
        r100.L$1 = r107;
        r100.L$2 = r106;
        r100.L$3 = r105;
        r100.label = 8;
        if (r105.a(null, r100) != r102) goto L122;
        return r102;
    L109:
        if ((r107 instanceof PagingSource.b.C4455b) == false) goto L112;
        Job.DefaultImpls.cancel$default(r108.f363700m, null, 1, null);
        r108.f363689b.f363720a.a();
        goto L112
    L25:
        kotlinx.coroutines.sync.a r139 = (kotlinx.coroutines.sync.a) r100.L$1;
        PageFetcherSnapshot<Key, Value> r140 = (PageFetcherSnapshot) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L113
        r103 = r139;
    L37:
        Unit r141 = Unit.INSTANCE;     // Catch: Throwable -> L113
        r103.unlock(null);
        PagingSource.a<Key> r142 = r140.g(LoadType.REFRESH, r140.f363688a);
        PagingSource<Key, Value> r143 = r140.f363689b;
        r100.L$0 = r140;
        r100.L$1 = null;
        r100.label = 3;
        r111 = r143.c(r142, r100);
        if (r111 != r102) goto L41;
        return r102;
    L41:
        r108 = r140;
        goto L42
    L28:
        kotlinx.coroutines.sync.a r144 = (kotlinx.coroutines.sync.a) r100.L$2;
        e0.a<Key, Value> r145 = (e0.a) r100.L$1;
        PageFetcherSnapshot<Key, Value> r146 = (PageFetcherSnapshot) r100.L$0;
        ResultKt.throwOnFailure(r111);
        kotlinx.coroutines.sync.a r147 = r144;
    L33:
        e0<Key, Value> r148 = r145.f363828b;     // Catch: Throwable -> L113
        LoadType r149 = LoadType.REFRESH;     // Catch: Throwable -> L113
        r100.L$0 = r146;     // Catch: Throwable -> L113
        r100.L$1 = r147;     // Catch: Throwable -> L113
        r100.L$2 = null;     // Catch: Throwable -> L113
        r100.label = 2;     // Catch: Throwable -> L113
        if (r146.j(r148, r149, r100) != r102) goto L36;
        return r102;
    L36:
        r140 = r146;
        r103 = r147;
        goto L37
    L29:
        ResultKt.throwOnFailure(r111);
        r145 = this.f363699l;
        MutexImpl r150 = r145.f363827a;
        r100.L$0 = this;
        r100.L$1 = r145;
        r100.L$2 = r150;
        r100.label = 1;
        if (r150.a(null, r100) != r102) goto L32;
        return r102;
    L32:
        r146 = this;
        r147 = r150;
        goto L33
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L65:
        th = move-exception;
        r103.unlock(null);
        throw th;
    L113:
        th = move-exception;
        r103.unlock(null);
        throw th;
    L7:
        r100 = new PageFetcherSnapshot$doInitialLoad$1(this, r110);
        goto L8
    }

    public static final void d(PageFetcherSnapshot r110, CoroutineScope r111) {
        if (r110.f363690c.f363870f == Integer.MIN_VALUE) goto L8;
        Iterator r100 = CollectionsKt.listOf(new LoadType[]{LoadType.APPEND, LoadType.PREPEND}).iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        BuildersKt.launch$default(r111, null, null, new PageFetcherSnapshot$startConsumingHints$1$1(r110, (LoadType) r100.next(), null), 3, null);
    L8:
        BuildersKt.launch$default(r111, null, null, new PageFetcherSnapshot$startConsumingHints$2(r110, null), 3, null);
        BuildersKt.launch$default(r111, null, null, new PageFetcherSnapshot$startConsumingHints$3(r110, null), 3, null);
    }

    public final PagingSource.a<Key> g(LoadType r100, Key r101) {
        int r102 = PagingSource.a.f363721c;
        if (r100 != LoadType.REFRESH) goto L5;
        int r103 = this.f363690c.f363868d;
    L6:
        boolean r104 = this.f363690c.f363867c;
        Intrinsics.checkNotNullParameter(r100, "loadType");
        int r105 = PagingSource.a.b.C4454a.f363725a[r100.ordinal()];
        if (r105 == 1) goto L23;
        if (r105 != 2) goto L11;
        if (r101 == null) goto L21;
        return new PagingSource.a.c(r101, r103, r104);
    L21:
        throw new IllegalArgumentException("key cannot be null for prepend".toString());
    L11:
        if (r105 != 3) goto L17;
        if (r101 == null) goto L15;
        return new PagingSource.a.C4453a(r101, r103, r104);
    L15:
        throw new IllegalArgumentException("key cannot be null for append".toString());
    L17:
        throw new NoWhenBranchMatchedException();
    L23:
        return new PagingSource.a.d(r101, r103, r104);
    L5:
        r103 = this.f363690c.f363865a;
        goto L6
    }

    public final Object j(e0 r100, LoadType r101, ContinuationImpl r102) {
        u r103 = r100.f363826l.a(r101);
        u.b r104 = u.b.f363921b;
        if (Intrinsics.areEqual(r103, r104) == true) goto L10;
        r100.f363826l.c(r101, r104);
        Object r105 = this.f363698k.send(new PageEvent.b(r100.f363826l.d(), null), r102);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r105;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    public static final Object a(PageFetcherSnapshot r100, FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r101, LoadType r102, Continuation r103) {
        r100.getClass();
        Flow r104 = FlowExtKt.a(r101, new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(null, r100, r102));
        PageFetcherSnapshot$collectAsGenerationalViewportHints$3 r105 = new PageFetcherSnapshot$collectAsGenerationalViewportHints$3(r102, null);
        Intrinsics.checkNotNullParameter(r104, "<this>");
        Intrinsics.checkNotNullParameter(r105, WikiFolderPushPlugin.OPT);
        Object r106 = kotlinx.coroutines.flow.e.d(new kotlinx.coroutines.flow.c1(new FlowExtKt$simpleRunningReduce$1(r104, r105, null)), -1, 2).collect(new d0(r100, r102), r103);
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r106;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v70 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v22, types: [com.larus.paging.LoadType, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v36, types: [com.larus.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v38, types: [com.larus.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v43, types: [com.larus.paging.LoadType, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v45 */
    /* JADX WARN: Type inference failed for: r10v46 */
    /* JADX WARN: Type inference failed for: r10v47 */
    /* JADX WARN: Type inference failed for: r10v48 */
    /* JADX WARN: Type inference failed for: r10v49 */
    /* JADX WARN: Type inference failed for: r10v50 */
    /* JADX WARN: Type inference failed for: r10v51 */
    /* JADX WARN: Type inference failed for: r10v52 */
    /* JADX WARN: Type inference failed for: r10v53 */
    /* JADX WARN: Type inference failed for: r12v12, types: [com.larus.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v37, types: [com.larus.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v39 */
    /* JADX WARN: Type inference failed for: r12v43 */
    /* JADX WARN: Type inference failed for: r12v44 */
    /* JADX WARN: Type inference failed for: r12v45 */
    /* JADX WARN: Type inference failed for: r12v46 */
    /* JADX WARN: Type inference failed for: r12v47 */
    /* JADX WARN: Type inference failed for: r12v48 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r13v14, types: [com.larus.paging.f1] */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v30, types: [com.larus.paging.LoadType, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v36, types: [java.lang.Enum, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v38, types: [com.larus.paging.LoadType] */
    /* JADX WARN: Type inference failed for: r13v39, types: [java.lang.Enum, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v40 */
    /* JADX WARN: Type inference failed for: r13v45 */
    /* JADX WARN: Type inference failed for: r13v46 */
    /* JADX WARN: Type inference failed for: r13v47 */
    /* JADX WARN: Type inference failed for: r13v48 */
    /* JADX WARN: Type inference failed for: r13v49 */
    /* JADX WARN: Type inference failed for: r14v13, types: [com.larus.paging.LoadType, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v100 */
    /* JADX WARN: Type inference failed for: r1v101 */
    /* JADX WARN: Type inference failed for: r1v39, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Enum, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r1v99 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14, types: [T] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v28, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v32, types: [com.larus.paging.y] */
    /* JADX WARN: Type inference failed for: r2v35, types: [com.larus.paging.y] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v29, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v31, types: [com.larus.paging.f1] */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v50 */
    /* JADX WARN: Type inference failed for: r6v52 */
    /* JADX WARN: Type inference failed for: r6v56 */
    /* JADX WARN: Type inference failed for: r6v57 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26, types: [com.larus.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v38, types: [com.larus.paging.PageFetcherSnapshot] */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v42 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v44, types: [com.larus.paging.PageFetcherSnapshot] */
    /* JADX WARN: Type inference failed for: r8v50, types: [com.larus.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v53 */
    /* JADX WARN: Type inference failed for: r8v54, types: [com.larus.paging.PageFetcherSnapshot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v57 */
    /* JADX WARN: Type inference failed for: r8v62 */
    /* JADX WARN: Type inference failed for: r8v63 */
    /* JADX WARN: Type inference failed for: r8v64 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:192:0x05bb -> B:204:0x0609). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:194:0x05bf -> B:204:0x0609). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:196:0x05e4 -> B:241:0x05e7). Please report as a decompilation issue!!! */
    public static final Object b(PageFetcherSnapshot r110, LoadType r111, o r210, Continuation r211) {
        PageFetcherSnapshot r100 = r110;
        ?? r101 = r111;
        r110.getClass();
        if ((r211 instanceof PageFetcherSnapshot$doLoad$1) == false) goto L7;
        PageFetcherSnapshot$doLoad$1 r102 = (PageFetcherSnapshot$doLoad$1) r211;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r106 = true;
        r106 = true;
        r106 = true;
        switch(r102.label) {
            case 0: goto L38;
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L16;
            case 10: goto L13;
            case 11: goto L12;
            default: goto L11;
        };
    L12:
        int r107 = r102.I$1;
        int r108 = r102.I$0;
        kotlinx.coroutines.sync.a r109 = (kotlinx.coroutines.sync.a) r102.L$7;
        e0.a<Key, Value> r112 = (e0.a) r102.L$6;
        Ref.BooleanRef r113 = (Ref.BooleanRef) r102.L$5;
        Ref.ObjectRef r114 = (Ref.ObjectRef) r102.L$4;
        Ref.IntRef r115 = (Ref.IntRef) r102.L$3;
        o r116 = (o) r102.L$2;
        LoadType r117 = (LoadType) r102.L$1;
        PageFetcherSnapshot r118 = (PageFetcherSnapshot) r102.L$0;
        ResultKt.throwOnFailure(r104);
        ?? r119 = r117;
        ?? r120 = r118;
    L241:
        w0<Key, Value> r121 = r112.f363828b.a(r120.f363696i.f363903a.f363908c);     // Catch: Throwable -> L205
        r109.unlock(null);
        if (r108 == 0) goto L202;
        r120.f363693f.c(LoadType.PREPEND, r121);
    L202:
        if (r107 == 0) goto L204;
        r120.f363693f.c(LoadType.APPEND, r121);
    L204:
        ?? r122 = r119;
        ?? r123 = r120;
        Ref.BooleanRef r124 = r113;
        Ref.ObjectRef r125 = r114;
        Ref.IntRef r126 = r115;
        r106 = true;
    L85:
        Object r127 = r125.element;
        if (r127 == null) goto L214;
        PagingSource.a<Key> r128 = r123.g(r122, r127);
        PagingSource<Key, Value> r129 = r123.f363689b;
        r102.L$0 = r123;
        r102.L$1 = r122;
        r102.L$2 = r116;
        r102.L$3 = r126;
        r102.L$4 = r125;
        r102.L$5 = r124;
        r102.L$6 = r128;
        r102.L$7 = null;
        r102.L$8 = null;
        r102.label = 4;
        r104 = r129.c(r128, r102);
        if (r104 == r105) goto L251;
        Ref.ObjectRef r130 = r125;
        ?? r131 = r122;
        PagingSource.a<Key> r132 = r128;
        Ref.IntRef r133 = r126;
        Ref.BooleanRef r134 = r124;
        ?? r135 = r123;
        o r136 = r116;
        ?? r137 = r135;
    L91:
        PagingSource.b r138 = (PagingSource.b) r104;
        if ((r138 instanceof PagingSource.b.c) == false) goto L130;
        int r139 = a.f363702a[r131.ordinal()];
        if (r139 != 2) goto L96;
        Key r140 = ((PagingSource.b.c) r138).f363730b;
    L101:
        r137.f363689b.getClass();
        boolean r141 = Intrinsics.areEqual(r140, r130.element);
        if (((r141 ? 1 : 0) ^ (r106 ? 1 : 0)) == 0) goto L104;
        e0.a<Key, Value> r142 = r137.f363699l;
        kotlinx.coroutines.sync.a r143 = r142.f363827a;
        r102.L$0 = r137;
        r102.L$1 = r131;
        r102.L$2 = r136;
        r102.L$3 = r133;
        r102.L$4 = r130;
        r102.L$5 = r134;
        r102.L$6 = r132;
        r102.L$7 = r138;
        r102.L$8 = r142;
        r102.L$9 = r143;
        r102.label = 5;
        if (r143.a(null, r102) == r105) goto L252;
        Ref.ObjectRef r144 = r130;
        PagingSource.b r145 = r138;
        ?? r146 = r137;
        Ref.ObjectRef r147 = r144;
        ?? r148 = r131;
    L239:
        boolean r149 = r142.f363828b.insert(r136.f363901a, r148, (PagingSource.b.c) r145);     // Catch: Throwable -> L126
        r143.unlock(null);
        if (r149 == false) goto L214;
        PagingSource.b.c r150 = (PagingSource.b.c) r145;
        r133.element += r150.f363729a.size();
        if (r148 != LoadType.PREPEND) goto L121;
        if (r150.f363730b != null) goto L121;
    L124:
        r134.element = r106;
    L125:
        Ref.ObjectRef r151 = r147;
        ?? r152 = r146;
        r138 = r145;
        r130 = r151;
        ?? r153 = r148;
    L149:
        if (a.f363702a[r153.ordinal()] != 2) goto L151;
        LoadType r154 = LoadType.APPEND;
    L152:
        e0.a<Key, Value> r155 = r152.f363699l;
        MutexImpl r156 = r155.f363827a;
        r102.L$0 = r152;
        r102.L$1 = r153;
        r102.L$2 = r136;
        r102.L$3 = r133;
        r102.L$4 = r130;
        r102.L$5 = r134;
        r102.L$6 = r132;
        r102.L$7 = r138;
        r102.L$8 = r154;
        r102.L$9 = r155;
        r102.L$10 = r156;
        r102.label = 8;
        if (r156.a(null, r102) == r105) goto L254;
        Ref.ObjectRef r157 = r130;
        LoadType r158 = r154;
        e0.a<Key, Value> r159 = r155;
        ?? r160 = r153;
        o r161 = r136;
        Ref.IntRef r162 = r133;
        ?? r163 = r152;
        Ref.ObjectRef r164 = r157;
        ?? r165 = r156;
    L237:
        e0<Key, Value> r166 = r159.f363828b;     // Catch: Throwable -> L210
        PageEvent.a<Value> r167 = r166.c(r158, r161.f363902b);     // Catch: Throwable -> L210
        ?? r168 = r163;
        ?? r169 = r160;
        ?? r170 = r165;
        if (r167 == null) goto L164;
        r166.b(r167);     // Catch: Throwable -> L210
        Channel<PageEvent<Value>> r171 = r163.f363698k;     // Catch: Throwable -> L210
        r102.L$0 = r163;     // Catch: Throwable -> L210
        r102.L$1 = r160;     // Catch: Throwable -> L210
        r102.L$2 = r161;     // Catch: Throwable -> L210
        r102.L$3 = r162;     // Catch: Throwable -> L210
        r102.L$4 = r164;     // Catch: Throwable -> L210
        r102.L$5 = r134;     // Catch: Throwable -> L210
        r102.L$6 = r132;     // Catch: Throwable -> L210
        r102.L$7 = r138;     // Catch: Throwable -> L210
        r102.L$8 = r165;     // Catch: Throwable -> L210
        r102.L$9 = r166;     // Catch: Throwable -> L210
        r102.L$10 = null;     // Catch: Throwable -> L210
        r102.label = 9;     // Catch: Throwable -> L210
        if (r171.send(r167, r102) == r105) goto L255;
        PagingSource.b r172 = r138;
        e0<Key, Value> r173 = r166;
        r101 = r165;
        ?? r174 = r163;
        ?? r175 = r160;
    L162:
        Unit r176 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r168 = r174;
        r170 = r101;
        r166 = r173;
        r138 = r172;
        r169 = r175;
        goto L164
    L255:
        return r105;
    L164:
        PagingSource.a<Key> r177 = r132;
        ?? r178 = r168.h(r166, r169, r161.f363901a, r161.f363902b.a(r169) + r162.element);     // Catch: Throwable -> L210
        r164.element = r178;     // Catch: Throwable -> L210
        if (r178 == 0) goto L168;
    L174:
        PageEvent.Insert r179 = r166.e((PagingSource.b.c) r138, r169);     // Catch: Throwable -> L210
        Channel<PageEvent<Value>> r180 = r168.f363698k;     // Catch: Throwable -> L210
        r102.L$0 = r168;     // Catch: Throwable -> L210
        r102.L$1 = r169;     // Catch: Throwable -> L210
        r102.L$2 = r161;     // Catch: Throwable -> L210
        r102.L$3 = r162;     // Catch: Throwable -> L210
        r102.L$4 = r164;     // Catch: Throwable -> L210
        r102.L$5 = r134;     // Catch: Throwable -> L210
        r102.L$6 = r177;     // Catch: Throwable -> L210
        r102.L$7 = r138;     // Catch: Throwable -> L210
        r102.L$8 = r170;     // Catch: Throwable -> L210
        r102.L$9 = null;     // Catch: Throwable -> L210
        r102.L$10 = null;     // Catch: Throwable -> L210
        r102.label = 10;     // Catch: Throwable -> L210
        if (r180.send(r179, r102) == r105) goto L256;
        r119 = r169;
        ?? r181 = r170;
        r114 = r164;
        r115 = r162;
        r116 = r161;
        r113 = r134;
        r120 = r168;
    L178:
        Unit r182 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r181.unlock(null);
        if ((r177 instanceof PagingSource.a.c) == true) goto L182;
    L184:
        r108 = 0;
    L186:
        if ((r177 instanceof PagingSource.a.C4453a) == true) goto L188;
    L190:
        r107 = 0;
    L192:
        if (r120.f363693f == null) goto L204;
        if (r108 != 0) goto L195;
        if (r107 == 0) goto L204;
    L195:
        r112 = r120.f363699l;
        r109 = r112.f363827a;
        r102.L$0 = r120;
        r102.L$1 = r119;
        r102.L$2 = r116;
        r102.L$3 = r115;
        r102.L$4 = r114;
        r102.L$5 = r113;
        r102.L$6 = r112;
        r102.L$7 = r109;
        r102.L$8 = null;
        r102.I$0 = r108;
        r102.I$1 = r107;
        r102.label = 11;
        r119 = r119;
        r120 = r120;
        if (r109.a(null, r102) != r105) goto L241;
        return r105;
    L188:
        if (((PagingSource.b.c) r138).f363731c != null) goto L190;
        r107 = 1;
        goto L192
    L182:
        if (((PagingSource.b.c) r138).f363730b != null) goto L184;
        r108 = 1;
        goto L186
    L256:
        return r105;
    L168:
        if ((r166.f363826l.a(r169) instanceof u.a) == true) goto L174;
        ?? r183 = r166.f363826l;     // Catch: Throwable -> L210
        if (r134.element == false) goto L172;
        u.c r184 = u.c.f363922b;     // Catch: Throwable -> L210
    L173:
        r183.c(r169, r184);     // Catch: Throwable -> L210
        goto L174
    L172:
        r184 = u.c.f363923c;     // Catch: Throwable -> L210
    L210:
        th = th;
    L211:
        r165.unlock(null);
        throw th;
    L254:
        return r105;
    L151:
        r154 = LoadType.PREPEND;
    L121:
        if (r148 != LoadType.APPEND) goto L125;
        if (r150.f363731c != null) goto L125;
    L126:
        th = move-exception;
        r143.unlock(null);
        throw th;
    L252:
        return r105;
    L104:
        if (r131 != LoadType.PREPEND) goto L106;
        String r185 = "prevKey";
    L108:
        throw new IllegalStateException(StringsKt.trimMargin$default("The same value, " + r130.element + ", was passed as the " + r185 + " in two\n                            | sequential Pages loaded from a PagingSource. Re-using load keys in\n                            | PagingSource is often an error, and must be explicitly enabled by\n                            | overriding PagingSource.keyReuseSupported.\n                            ", null, r106 ? 1 : 0, null).toString());
    L106:
        r185 = "nextKey";
        goto L108
    L96:
        if (r139 != 3) goto L99;
        r140 = ((PagingSource.b.c) r138).f363731c;
        goto L101
    L99:
        throw new IllegalArgumentException("Use doInitialLoad for LoadType == REFRESH");
    L130:
        if ((r138 instanceof PagingSource.b.a) == false) goto L145;
        e0.a<Key, Value> r186 = r137.f363699l;
        kotlinx.coroutines.sync.a r187 = r186.f363827a;
        r102.L$0 = r137;
        r102.L$1 = r131;
        r102.L$2 = r136;
        r102.L$3 = r138;
        r102.L$4 = r186;
        r102.L$5 = r187;
        r102.L$6 = null;
        r102.label = 6;
        if (r187.a(null, r102) == r105) goto L253;
        PagingSource.b r188 = r138;
        o r189 = r136;
        ?? r190 = r137;
        ?? r191 = r131;
    L227:
        e0<Key, Value> r192 = r186.f363828b;     // Catch: Throwable -> L142
        u.a r193 = new u.a(((PagingSource.b.a) r188).f363728a);     // Catch: Throwable -> L142
        r102.L$0 = r191;     // Catch: Throwable -> L142
        r102.L$1 = r189;     // Catch: Throwable -> L142
        r102.L$2 = r187;     // Catch: Throwable -> L142
        r102.L$3 = r192;     // Catch: Throwable -> L142
        r102.L$4 = null;     // Catch: Throwable -> L142
        r102.L$5 = null;     // Catch: Throwable -> L142
        r102.label = 7;     // Catch: Throwable -> L142
        if (r190.i(r192, r191, r193, r102) == r105) goto L245;
        e0<Key, Value> r194 = r192;
        kotlinx.coroutines.sync.a r195 = r187;
        ?? r196 = r191;
    L139:
        r194.f363825k.put(r196, r189.f363902b);     // Catch: Throwable -> L25
        Unit r197 = Unit.INSTANCE;     // Catch: Throwable -> L25
        r195.unlock(null);
        return Unit.INSTANCE;
    L25:
        Throwable th10 = th;
        r187 = r195;
    L143:
        r187.unlock(null);
        throw th10;
    L245:
        return r105;
    L142:
        th10 = th;
        goto L143
    L253:
        return r105;
    L145:
        r152 = r137;
        r153 = r131;
        if ((r138 instanceof PagingSource.b.C4455b) == false) goto L149;
        Job.DefaultImpls.cancel$default(r137.f363700m, null, r106 ? 1 : 0, null);
        r137.f363689b.f363720a.a();
        return Unit.INSTANCE;
    L251:
        return r105;
    L214:
        return Unit.INSTANCE;
    L205:
        th = move-exception;
        r109.unlock(null);
        throw th;
    L13:
        kotlinx.coroutines.sync.a r198 = (kotlinx.coroutines.sync.a) r102.L$8;
        r138 = (PagingSource.b) r102.L$7;
        r177 = (PagingSource.a) r102.L$6;
        Ref.BooleanRef r199 = (Ref.BooleanRef) r102.L$5;
        Ref.ObjectRef r200 = (Ref.ObjectRef) r102.L$4;
        Ref.IntRef r201 = (Ref.IntRef) r102.L$3;
        o r1100 = (o) r102.L$2;
        LoadType r1101 = (LoadType) r102.L$1;
        PageFetcherSnapshot r1102 = (PageFetcherSnapshot) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L19
        r115 = r201;
        r116 = r1100;
        r113 = r199;
        r119 = r1101;
        r114 = r200;
        r120 = r1102;
        r181 = r198;
        goto L178
    L16:
        r173 = (e0) r102.L$9;
        kotlinx.coroutines.sync.a r202 = (kotlinx.coroutines.sync.a) r102.L$8;
        r172 = (PagingSource.b) r102.L$7;
        r132 = (PagingSource.a) r102.L$6;
        r134 = (Ref.BooleanRef) r102.L$5;
        r164 = (Ref.ObjectRef) r102.L$4;
        r162 = (Ref.IntRef) r102.L$3;
        r161 = (o) r102.L$2;
        LoadType r1103 = (LoadType) r102.L$1;
        PageFetcherSnapshot r1104 = (PageFetcherSnapshot) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L19
        r101 = r202;
        r175 = r1103;
        r174 = r1104;
        goto L162
    L21:
        kotlinx.coroutines.sync.a r203 = (kotlinx.coroutines.sync.a) r102.L$10;
        r159 = (e0.a) r102.L$9;
        r158 = (LoadType) r102.L$8;
        PagingSource.b r204 = (PagingSource.b) r102.L$7;
        PagingSource.a<Key> r205 = (PagingSource.a) r102.L$6;
        Ref.BooleanRef r206 = (Ref.BooleanRef) r102.L$5;
        Ref.ObjectRef r1105 = (Ref.ObjectRef) r102.L$4;
        Ref.IntRef r1106 = (Ref.IntRef) r102.L$3;
        o r1107 = (o) r102.L$2;
        LoadType r1108 = (LoadType) r102.L$1;
        PageFetcherSnapshot r1109 = (PageFetcherSnapshot) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r165 = r203;
        r138 = r204;
        r132 = r205;
        r134 = r206;
        r164 = r1105;
        r162 = r1106;
        r161 = r1107;
        r160 = r1108;
        r163 = r1109;
        goto L237
    L22:
        r194 = (e0) r102.L$3;
        r195 = (kotlinx.coroutines.sync.a) r102.L$2;
        r189 = (o) r102.L$1;
        LoadType r207 = (LoadType) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L25
        r196 = r207;
        goto L139
    L27:
        kotlinx.coroutines.sync.a r208 = (kotlinx.coroutines.sync.a) r102.L$5;
        r186 = (e0.a) r102.L$4;
        r188 = (PagingSource.b) r102.L$3;
        o r209 = (o) r102.L$2;
        LoadType r212 = (LoadType) r102.L$1;
        PageFetcherSnapshot r213 = (PageFetcherSnapshot) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r187 = r208;
        r189 = r209;
        r191 = r212;
        r190 = r213;
        goto L227
    L28:
        kotlinx.coroutines.sync.a r214 = (kotlinx.coroutines.sync.a) r102.L$9;
        r142 = (e0.a) r102.L$8;
        r145 = (PagingSource.b) r102.L$7;
        r132 = (PagingSource.a) r102.L$6;
        r134 = (Ref.BooleanRef) r102.L$5;
        r147 = (Ref.ObjectRef) r102.L$4;
        r133 = (Ref.IntRef) r102.L$3;
        r136 = (o) r102.L$2;
        LoadType r1110 = (LoadType) r102.L$1;
        PageFetcherSnapshot r1111 = (PageFetcherSnapshot) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r143 = r214;
        r146 = r1111;
        r148 = r1110;
        goto L239
    L29:
        PagingSource.a<Key> r215 = (PagingSource.a) r102.L$6;
        Ref.BooleanRef r216 = (Ref.BooleanRef) r102.L$5;
        r130 = (Ref.ObjectRef) r102.L$4;
        Ref.IntRef r217 = (Ref.IntRef) r102.L$3;
        o r218 = (o) r102.L$2;
        LoadType r219 = (LoadType) r102.L$1;
        PageFetcherSnapshot r1112 = (PageFetcherSnapshot) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r136 = r218;
        r131 = r219;
        r137 = r1112;
        r134 = r216;
        r133 = r217;
        r132 = r215;
        goto L91
    L30:
        Ref.ObjectRef r220 = (Ref.ObjectRef) r102.L$7;
        Object r221 = r102.L$6;
        kotlinx.coroutines.sync.a r222 = (kotlinx.coroutines.sync.a) r102.L$5;
        r125 = (Ref.ObjectRef) r102.L$4;
        r126 = (Ref.IntRef) r102.L$3;
        r116 = (o) r102.L$2;
        LoadType r1113 = (LoadType) r102.L$1;
        PageFetcherSnapshot r1114 = (PageFetcherSnapshot) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L33
        ?? r1115 = r1113;
        ?? r1116 = r1114;
    L81:
        ?? r223 = r221;
        kotlinx.coroutines.sync.a r224 = r222;
        ?? r1117 = r1115;
        ?? r1118 = r1116;
    L84:
        r224.unlock(null);
        r220.element = r223;
        r124 = new Ref.BooleanRef();
        r122 = r1117;
        r123 = r1118;
    L33:
        th = th;
    L217:
        r222.unlock(null);
        throw th;
    L35:
        r220 = (Ref.ObjectRef) r102.L$7;
        r224 = (kotlinx.coroutines.sync.a) r102.L$6;
        e0.a<Key, Value> r225 = (e0.a) r102.L$5;
        r125 = (Ref.ObjectRef) r102.L$4;
        r126 = (Ref.IntRef) r102.L$3;
        r116 = (o) r102.L$2;
        LoadType r1119 = (LoadType) r102.L$1;
        PageFetcherSnapshot r1120 = (PageFetcherSnapshot) r102.L$0;
        ResultKt.throwOnFailure(r104);
        ?? r1121 = r1119;
        ?? r1122 = r1120;
    L229:
        e0<Key, Value> r226 = r225.f363828b;     // Catch: Throwable -> L215
        Object r227 = r1122.h(r226, r1121, r116.f363901a, r116.f363902b.a(r1121) + r126.element);     // Catch: Throwable -> L215
        if (r227 == null) goto L83;
        r102.L$0 = r1122;     // Catch: Throwable -> L215
        r102.L$1 = r1121;     // Catch: Throwable -> L215
        r102.L$2 = r116;     // Catch: Throwable -> L215
        r102.L$3 = r126;     // Catch: Throwable -> L215
        r102.L$4 = r125;     // Catch: Throwable -> L215
        r102.L$5 = r224;     // Catch: Throwable -> L215
        r102.L$6 = r227;     // Catch: Throwable -> L215
        r102.L$7 = r220;     // Catch: Throwable -> L215
        r102.label = 3;     // Catch: Throwable -> L215
        if (r1122.j(r226, r1121, r102) == r105) goto L250;
        r222 = r224;
        r221 = r227;
        r1115 = r1121;
        r1116 = r1122;
        goto L81
    L250:
        return r105;
    L83:
        r223 = 0;
        r1117 = r1121;
        r1118 = r1122;
    L215:
        th = th;
        r222 = r224;
        goto L217
    L36:
        kotlinx.coroutines.sync.a r228 = (kotlinx.coroutines.sync.a) r102.L$5;
        e0.a<Key, Value> r229 = (e0.a) r102.L$4;
        Ref.IntRef r230 = (Ref.IntRef) r102.L$3;
        o r231 = (o) r102.L$2;
        LoadType r232 = (LoadType) r102.L$1;
        PageFetcherSnapshot r233 = (PageFetcherSnapshot) r102.L$0;
        ResultKt.throwOnFailure(r104);
        kotlinx.coroutines.sync.a r234 = r228;
        r100 = r233;
        Ref.IntRef r1123 = r230;
        e0.a<Key, Value> r235 = r229;
        ?? r236 = r232;
    L37:
        r126 = r1123;
        e0<Key, Value> r237 = r235.f363828b;     // Catch: Throwable -> L221
        int r238 = a.f363702a[r236.ordinal()];     // Catch: Throwable -> L221
        if (r238 == 1) goto L220;
        if (r238 != 2) goto L52;
        int r239 = (r237.f363818d + r231.f363902b.f363843c) - 1;     // Catch: Throwable -> L221
        if (r239 <= CollectionsKt.getLastIndex(r237.f363817c)) goto L65;
        r126.element += r100.f363690c.f363865a * (r239 - CollectionsKt.getLastIndex(r237.f363817c));     // Catch: Throwable -> L221
        r239 = CollectionsKt.getLastIndex(r237.f363817c);     // Catch: Throwable -> L221
    L65:
        if (r239 < 0) goto L70;
        int r1124 = 0;
    L67:
        r126.element += ((PagingSource.b.c) ((ArrayList) r237.f363817c).get(r1124)).f363729a.size();     // Catch: Throwable -> L221
        if (r1124 == r239) goto L70;
        r1124 = r1124 + 1;     // Catch: Throwable -> L221
    L70:
        Unit r240 = Unit.INSTANCE;     // Catch: Throwable -> L221
        r234.unlock(null);
        Ref.ObjectRef r241 = new Ref.ObjectRef();
        r225 = r100.f363699l;
        MutexImpl r242 = r225.f363827a;
        r102.L$0 = r100;
        r102.L$1 = r236;
        r102.L$2 = r231;
        r102.L$3 = r126;
        r102.L$4 = r241;
        r102.L$5 = r225;
        r102.L$6 = r242;
        r102.L$7 = r241;
        r102.label = 2;
        if (r242.a(null, r102) == r105) goto L249;
        r1122 = r100;
        r1121 = r236;
        r220 = r241;
        r224 = r242;
        r116 = r231;
        r125 = r220;
        goto L229
    L249:
        return r105;
    L52:
        if (r238 != 3) goto L70;
        int r243 = (r237.f363818d + r231.f363902b.f363844d) + 1;     // Catch: Throwable -> L221
        if (r243 >= 0) goto L57;
        r126.element += r100.f363690c.f363865a * (-r243);     // Catch: Throwable -> L221
        r243 = 0;
    L57:
        int r1125 = CollectionsKt.getLastIndex(r237.f363817c);     // Catch: Throwable -> L221
        if (r243 > r1125) goto L70;
    L59:
        r126.element += ((PagingSource.b.c) ((ArrayList) r237.f363817c).get(r243)).f363729a.size();     // Catch: Throwable -> L221
        if (r243 == r1125) goto L70;
        r243 = r243 + 1;     // Catch: Throwable -> L221
        goto L59
    L220:
        throw new IllegalStateException("Use doInitialLoad for LoadType == REFRESH");     // Catch: Throwable -> L221
    L221:
        th = move-exception;
        r234.unlock(null);
        throw th;
    L38:
        ResultKt.throwOnFailure(r104);
        if (r101 == LoadType.REFRESH) goto L41;
        boolean r244 = true;
    L42:
        if (r244 == false) goto L225;
        Ref.IntRef r245 = new Ref.IntRef();
        e0.a<Key, Value> r246 = r100.f363699l;
        MutexImpl r247 = r246.f363827a;
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.L$2 = r210;
        r102.L$3 = r245;
        r102.L$4 = r246;
        r102.L$5 = r247;
        r102.label = 1;
        if (r247.a(null, r102) == r105) goto L248;
        r1123 = r245;
        r235 = r246;
        r234 = r247;
        r231 = r210;
        r236 = r101;
        goto L37
    L248:
        return r105;
    L225:
        throw new IllegalArgumentException("Use doInitialLoad for LoadType == REFRESH".toString());
    L41:
        r244 = false;
        goto L42
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        th = th;
        r165 = r101;
    L7:
        r102 = new PageFetcherSnapshot$doLoad$1(r100, r211);
        goto L8
    }

    public static final Object c(PageFetcherSnapshot r100, final LoadType r101, final f1 r102, PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1.AnonymousClass1 r103) {
        r100.getClass();
        boolean r104 = true;
        if (a.f363702a[r101.ordinal()] != 1) goto L9;
        Object r105 = r100.f(r103);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        return r105;
    L26:
        return Unit.INSTANCE;
    L9:
        if (r102 == null) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L25;
        p r107 = r100.f363696i;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r101, "loadType");
        Intrinsics.checkNotNullParameter(r102, "viewportHint");
        if (r101 != LoadType.PREPEND) goto L16;
    L19:
        if (r104 == false) goto L23;
        r107.f363903a.a(null, new HintHandler$forceSetHint$2(r101, r102));
        return Unit.INSTANCE;
    L23:
        throw new IllegalArgumentException(("invalid load type for reset: " + r101).toString());
    L16:
        if (r101 == LoadType.APPEND) goto L19;
        r104 = false;
        goto L19
    L25:
        throw new IllegalStateException("Cannot retry APPEND / PREPEND load on PagingSource without ViewportHint".toString());
    L11:
        r106 = false;
        goto L12
    }

    public final Key h(e0<Key, Value> r100, LoadType r101, int r102, int r103) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "loadType");
        int r104 = e0.b.f363829a[r101.ordinal()];
        if (r104 == 1) goto L27;
        if (r104 != 2) goto L7;
        int r105 = r100.f363821g;
    L13:
        if (r102 == r105) goto L16;
        return null;
    L16:
        if ((r100.f363826l.a(r101) instanceof u.a) == false) goto L19;
        return null;
    L19:
        if (r103 < this.f363690c.f363866b) goto L22;
        return null;
    L22:
        if (r101 != LoadType.PREPEND) goto L25;
        return ((PagingSource.b.c) CollectionsKt.first(r100.f363817c)).f363730b;
    L25:
        return ((PagingSource.b.c) CollectionsKt.last(r100.f363817c)).f363731c;
    L7:
        if (r104 != 3) goto L10;
        r105 = r100.f363822h;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    L27:
        throw new IllegalArgumentException("Cannot get loadId for loadType: REFRESH");
    }

    public final Object i(e0 r100, LoadType r101, u.a r102, ContinuationImpl r103) {
        if (Intrinsics.areEqual(r100.f363826l.a(r101), r102) == true) goto L10;
        r100.f363826l.c(r101, r102);
        Object r104 = this.f363698k.send(new PageEvent.b(r100.f363826l.d(), null), r103);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r104;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PageFetcherSnapshot(Object r100, PagingSource r101, j0 r102, ConflatedEventBus$special$$inlined$mapNotNull$1 r103, boolean r104, x0 r105, w0 r106, Function0 r107) {
        Intrinsics.checkNotNullParameter(r101, "pagingSource");
        Intrinsics.checkNotNullParameter(r102, "config");
        Intrinsics.checkNotNullParameter(r103, "retryFlow");
        Intrinsics.checkNotNullParameter(r107, "invalidate");
        this.f363688a = r100;
        this.f363689b = r101;
        this.f363690c = r102;
        this.f363691d = r103;
        this.f363692e = r104;
        this.f363693f = r105;
        this.f363694g = r106;
        this.f363695h = r107;
        if (r102.f363870f != Integer.MIN_VALUE) goto L5;
    L8:
        boolean r108 = true;
    L9:
        if (r108 == false) goto L13;
        this.f363696i = new p();
        this.f363697j = new AtomicBoolean(false);
        this.f363698k = ChannelKt.Channel$default(-2, null, null, 6, null);
        this.f363699l = new e0.a(r102);
        CompletableJob r109 = JobKt.Job$default(null, 1, null);
        this.f363700m = r109;
        PageFetcherSnapshot$pageEventFlow$1 r110 = new PageFetcherSnapshot$pageEventFlow$1(this, null);
        Intrinsics.checkNotNullParameter(r109, "controller");
        Intrinsics.checkNotNullParameter(r110, "block");
        Flow r111 = SimpleChannelFlowKt.a(new CancelableChannelFlowKt$cancelableChannelFlow$1(r109, r110, null));
        this.f363701n = new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(new PageFetcherSnapshot$pageEventFlow$2(this, null), r111);
        return;
    L13:
        throw new IllegalArgumentException("PagingConfig.jumpThreshold was set, but the associated PagingSource has not marked support for jumps by overriding PagingSource.jumpingSupported to true.".toString());
    L5:
        if (r101.a() == true) goto L8;
        r108 = false;
        goto L9
    }
}
