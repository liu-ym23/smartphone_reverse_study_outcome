package com.larus.bmhome.resource.access;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l implements l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourcePhase f313698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f313699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f313700c;

    @Override // com.larus.bmhome.resource.access.l0
    public final String getKey() {
        return "remote_direct";
    }

    public l() {
        this.f313698a = ResourcePhase.REMOTE_DIRECT;
        this.f313699b = CollectionsKt.listOf("remote_policy");
        this.f313700c = true;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourcePhase d() {
        return this.f313698a;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final List<String> f() {
        return this.f313699b;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourceNodeCompletionMode g() {
        return ResourceNodeCompletionMode.BLOCKING;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean h() {
        return this.f313700c;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean e(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.f313678h == null) goto L5;
    L7:
        return false;
    L5:
        if (s.a(r100.f313673c.getType()) == false) goto L7;
        return true;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final Object c(h0 r100, Continuation<? super g> r110) {
        j0 r101 = r100.f313673c;
        if ((r101 instanceof j0.d) == false) goto L6;
        f0 r111 = new f0(r100.f313671a.f313764c, r101, ((j0.d) r101).f313696b, null, null, null, 56);
    L15:
        if (r111 == null) goto L18;
        return new g.d(r111);
    L18:
        return g.e.f313653a;
    L6:
        if ((r101 instanceof j0.c) == false) goto L8;
    L14:
        r111 = null;
        goto L15
    L8:
        if ((r101 instanceof j0.b) == true) goto L14;
        if ((r101 instanceof j0.a) == true) goto L14;
        throw new NoWhenBranchMatchedException();
    }
}
