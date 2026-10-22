package com.larus.suggest.impl.wcb.policy;

import com.larus.bmhome.chat.bean.NexPulseConf;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class o implements y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f369988b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f369989a;

    static {
        f369988b = new o();
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void a(com.larus.suggest.impl.wcb.request.f r100, NexPulseResponseData r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        Intrinsics.checkNotNullParameter(r101, "response");
        this.f369989a.a(r100, r101, r102);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final String b(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return this.f369989a.b(r100);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long c(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return this.f369989a.c(r100);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void d(com.larus.suggest.impl.wcb.request.f r100, NexPulseConf r101) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        this.f369989a.d(r100, r101);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long e(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return this.f369989a.e(r100);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long f(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return this.f369989a.f(r100);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long g(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return this.f369989a.g(r100);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void h(com.larus.suggest.impl.wcb.request.f r100, long r101, long r110) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        this.f369989a.h(r100, r101, r110);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final long i(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return this.f369989a.i(r100);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final String j(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return this.f369989a.j(r100);
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final v k(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return this.f369989a.k(r100);
    }

    public o() {
        this.f369989a = new w(new n());
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final boolean l(com.larus.suggest.impl.wcb.request.f r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        this.f369989a.getClass();
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        return false;
    }

    @Override // com.larus.suggest.impl.wcb.policy.y
    public final void m(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.f369989a.getClass();
        Intrinsics.checkNotNullParameter(r100, "conversationId");
    }
}
