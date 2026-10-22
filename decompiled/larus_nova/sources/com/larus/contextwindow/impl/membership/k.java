package com.larus.contextwindow.impl.membership;

import com.larus.platform.api.m4;
import com.larus.platform.service.AccountService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f330394a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f330395b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f330396c = null;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        @Override // com.larus.platform.api.b
        public final void a(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Lazy<MembershipQuotaRepository> r101 = MembershipQuotaRepository.f330347k;
            MembershipQuotaRepository.b.a().b();
        }

        @Override // com.larus.platform.api.b
        public final void b(com.larus.platform.api.c r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Lazy<MembershipQuotaRepository> r101 = MembershipQuotaRepository.f330347k;
            MembershipQuotaRepository.b.a().b();
        }
    }

    public static final class b implements m4 {
        public b() {
        }

        @Override // com.larus.platform.api.m4
        public final void S1() {
            Lazy<MembershipQuotaRepository> r100 = MembershipQuotaRepository.f330347k;
            MembershipQuotaRepository.b.a().b();
        }

        @Override // com.larus.platform.api.m4
        public final void b1() {
            Lazy<MembershipQuotaRepository> r100 = MembershipQuotaRepository.f330347k;
            MembershipQuotaRepository.b.a().b();
        }
    }

    static {
        f330394a = new AtomicBoolean(false);
        f330395b = new a();
        f330396c = new b();
    }

    public static void a() {
        if (f330394a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        AccountService r100 = AccountService.f365697a;
        r100.E(f330395b);
        r100.H(f330396c);
    }
}
