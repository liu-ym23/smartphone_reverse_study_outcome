package com.larus.bmhome.resource.access;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class d1 implements l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourcePhase f313629a;

    @Override // com.larus.bmhome.resource.access.l0
    public final String getKey() {
        return com.alipay.sdk.m.l.c.f25505j;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean h() {
        return false;
    }

    public d1() {
        this.f313629a = ResourcePhase.VALIDATE;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final List<String> f() {
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourcePhase d() {
        return this.f313629a;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final ResourceNodeCompletionMode g() {
        return ResourceNodeCompletionMode.BLOCKING;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final boolean e(h0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return true;
    }

    @Override // com.larus.bmhome.resource.access.l0
    public final Object c(h0 r100, Continuation<? super g> r101) {
        j0 r102 = r100.f313673c;
        if ((r102 instanceof j0.b) == false) goto L8;
        if (StringsKt.isBlank(((j0.b) r102).f313690b) == false) goto L21;
    L22:
        boolean r103 = false;
    L23:
        if (r103 == false) goto L26;
        return new g.a(0);
    L26:
        return new g.b(new r(com.alipay.sdk.m.l.c.f25505j, "invalid_resource_input", "resource input is invalid", null));
    L21:
        r103 = true;
        goto L23
    L8:
        if ((r102 instanceof j0.a) == false) goto L13;
        if (StringsKt.isBlank(((j0.a) r102).f313689b) == true) goto L22;
    L13:
        if ((r102 instanceof j0.c) == false) goto L18;
        if (StringsKt.isBlank(((j0.c) r102).f313695b) == true) goto L22;
    L18:
        if ((r102 instanceof j0.d) == false) goto L28;
        if (StringsKt.isBlank(((j0.d) r102).f313696b) == true) goto L22;
    L28:
        throw new NoWhenBranchMatchedException();
    }
}
