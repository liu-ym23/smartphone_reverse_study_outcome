package com.ss.android.lark.security.compliance.infra.network.userscpoe;

import com.bytedance.lark.rustclient.api.h;
import com.ss.android.lark.passportc.api.j;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes38.dex */
@Singleton
public final class SCRequestGlobalImpl implements a, com.ss.android.lark.passportc.api.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f440454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f440455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f440456c;

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOnline(f0c.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.g
    public final j getPassport() {
        return this.f440454a;
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOnline(f0c.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f440456c = r100.f475032c.f475033a.userId;
    }

    @Override // com.ss.android.lark.security.compliance.infra.network.userscpoe.a
    public final <T> void a(com.ss.android.lark.security.compliance.infra.network.g r100, com.ss.android.lark.security.compliance.infra.network.d<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, Dispatchers.getIO(), null, new SCRequestGlobalImpl$async$1(this, r100, r101, null), 2, null);
    }

    @Inject
    public SCRequestGlobalImpl(h r100, final jdb.e r101, j r102) {
        Intrinsics.checkNotNullParameter(r100, "globalRust");
        Intrinsics.checkNotNullParameter(r101, "globalFG");
        Intrinsics.checkNotNullParameter(r102, "passport");
        this.f440454a = r102;
        this.f440455b = new d(new e(r100), new SCRequestGlobalImpl$requestManager$1(r101, this));
        r102.e(this);
    }
}
