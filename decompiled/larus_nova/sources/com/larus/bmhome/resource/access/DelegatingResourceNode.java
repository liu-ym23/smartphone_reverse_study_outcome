package com.larus.bmhome.resource.access;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class DelegatingResourceNode implements l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResourcePhase f313569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f313570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f313571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ResourceNodeCompletionMode f313572e;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            ((ResourceNodeHandler) r100).getPriority();
            ((ResourceNodeHandler) r101).getPriority();
            return ComparisonsKt.compareValues(0, 0);
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f313573a;

        public b(a r100) {
            this.f313573a = r100;
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f313573a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(((ResourceNodeHandler) r100).getKey(), ((ResourceNodeHandler) r101).getKey());
        }
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final Object c(h0 r100, Continuation<? super g> r101) {
        return a(this, r100, r101);
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourcePhase d() {
        return this.f313569b;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final List<String> f() {
        return this.f313570c;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourceNodeCompletionMode g() {
        return this.f313572e;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final String getKey() {
        return this.f313568a;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean h() {
        return this.f313571d;
    }

    public final ResourceNodeHandler b(h0 r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        Set r102 = ServiceManager.get().getServices(ResourceNodeHandler.class, true);     // Catch: Throwable -> L18
        if (r102 != null) goto L5;
        r102 = SetsKt.emptySet();     // Catch: Throwable -> L18
    L5:
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L18
        Iterator r104 = r102.iterator();     // Catch: Throwable -> L18
    L7:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();     // Catch: Throwable -> L18
        ResourceNodeHandler r106 = (ResourceNodeHandler) r105;     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(r106.a(), this.f313568a) == true) goto L11;
    L13:
        boolean r107 = false;
    L14:
        if (r107 == false) goto L7;
        r103.add(r105);     // Catch: Throwable -> L18
        goto L7
    L11:
        if (r106.b(r100) == false) goto L13;
        r107 = true;
        goto L14
    L16:
        Object r108 = Result.m9449constructorimpl((ResourceNodeHandler) CollectionsKt.maxWithOrNull(r103, new b(new a())));     // Catch: Throwable -> L18
    L20:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L24;
        FLogger.f375446a.e("ResourceAccessPipeline", "[findHandler] collect handler failed, node=" + this.f313568a, r109);
    L24:
        if (Result.m9455isFailureimpl(r108) == false) goto L27;
        r108 = null;
    L27:
        return (ResourceNodeHandler) r108;
    L18:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean e(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (b(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static Object a(DelegatingResourceNode r100, h0 r110, Continuation<? super g> r111) {
        if ((r111 instanceof DelegatingResourceNode$execute$1) == false) goto L7;
        DelegatingResourceNode$execute$1 r101 = (DelegatingResourceNode$execute$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        DelegatingResourceNode r105 = (DelegatingResourceNode) r101.L$2;
        ResourceNodeHandler r113 = (ResourceNodeHandler) r101.L$1;
        DelegatingResourceNode r106 = (DelegatingResourceNode) r101.L$0;
        ResultKt.throwOnFailure(r112);
        DelegatingResourceNode r114 = r105;
        r100 = r106;
        Object r107 = r112;
        ResourceNodeHandler r115 = r113;
    L22:
        g r108 = (g) r107;
        String r109 = r100.f313568a;
        String r116 = r115.getKey();
        r114.getClass();
        Map r117 = MapsKt.mapOf(TuplesKt.to(r109 + "_handler", r116));
        if ((r108 instanceof g.a) == false) goto L26;
        i0 r118 = ((g.a) r108).f313649a;
        Map r119 = MapsKt.plus(r118.f313687g, r117);
        j0 r120 = r118.f313681a;
        mr9.c r121 = r118.f313682b;
        Long r122 = r118.f313683c;
        mr9.h r123 = r118.f313684d;
        String r124 = r118.f313685e;
        f0 r125 = r118.f313686f;
        Intrinsics.checkNotNullParameter(r119, "attributes");
        i0 r126 = new i0(r120, r121, r122, r123, r124, r125, r119);
        Intrinsics.checkNotNullParameter(r126, "update");
        return new g.a(r126);
    L26:
        if ((r108 instanceof g.d) == false) goto L29;
        f0 r127 = ((g.d) r108).f313652a;
        f0 r128 = f0.a(r127, MapsKt.plus(r127.f313648f, r117));
        Intrinsics.checkNotNullParameter(r128, "artifact");
        return new g.d(r128);
    L29:
        if ((r108 instanceof g.b) == false) goto L31;
        return r108;
    L31:
        if ((r108 instanceof g.c) == false) goto L33;
        return r108;
    L33:
        if (Intrinsics.areEqual(r108, g.e.f313653a) == false) goto L36;
        return r108;
    L36:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r115 = r100.b(r110);
        if (r115 == null) goto L17;
        FLogger.f375446a.i("ResourceAccessPipeline", "[execute] node=" + r100.f313568a + " hit handler=" + r115.getKey());
        r101.L$0 = r100;
        r101.L$1 = r115;
        r101.L$2 = r100;
        r101.label = 1;
        Object r129 = r115.c(r110, r101);
        if (r129 != r103) goto L21;
        return r103;
    L21:
        r107 = r129;
        r114 = r100;
        goto L22
    L17:
        return g.e.f313653a;
    L7:
        r101 = new DelegatingResourceNode$execute$1(r100, r111);
        goto L8
    }

    public DelegatingResourceNode(String r100, ResourcePhase r101, List<String> r102, boolean r103, ResourceNodeCompletionMode r104) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "phase");
        Intrinsics.checkNotNullParameter(r102, "dependsOn");
        Intrinsics.checkNotNullParameter(r104, "completionMode");
        this.f313568a = r100;
        this.f313569b = r101;
        this.f313570c = r102;
        this.f313571d = r103;
        this.f313572e = r104;
    }

    public /* synthetic */ DelegatingResourceNode(String r100, ResourcePhase r101, List r102, boolean r110, int r111) {
        if ((r111 & 4) == 0) goto L5;
        r102 = CollectionsKt.emptyList();
    L5:
        List r103 = r102;
        if ((r111 & 8) == 0) goto L8;
        boolean r104 = false;
    L10:
        if ((r111 & 16) == 0) goto L12;
        ResourceNodeCompletionMode r105 = ResourceNodeCompletionMode.BLOCKING;
    L13:
        this(r100, r101, r103, r104, r105);
        return;
    L12:
        r105 = null;
        goto L13
    L8:
        r104 = r110;
        goto L10
    }
}
