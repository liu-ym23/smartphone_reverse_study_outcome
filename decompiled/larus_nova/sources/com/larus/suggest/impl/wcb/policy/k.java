package com.larus.suggest.impl.wcb.policy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lx9.d f369974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f369975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f369976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f369977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f369978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f369979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f369980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MainConversationDisplayFrequencyPolicy f369981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f369982i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f369983j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f369984k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f f369985l;

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final c a() {
        return this.f369980g;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final b b() {
        return this.f369976c;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final d0 c() {
        return this.f369979f;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final d d() {
        return this.f369982i;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final a e() {
        return this.f369983j;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final b0 f() {
        return this.f369978e;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final e g() {
        return this.f369984k;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final t getDisplay() {
        return this.f369981h;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final lx9.d getKey() {
        return this.f369974a;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final int getScene() {
        return this.f369975b;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final y h() {
        return this.f369977d;
    }

    @Override // com.larus.suggest.impl.wcb.policy.z
    public final f i() {
        return this.f369985l;
    }

    public k(lx9.d r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f369974a = r100;
        this.f369975b = r101;
        this.f369976c = b.f369961a;
        this.f369977d = i.f369970b;
        this.f369978e = j.f369973a;
        this.f369979f = l.f369986a;
        this.f369980g = c.f369962a;
        this.f369981h = MainConversationDisplayFrequencyPolicy.f369952a;
        this.f369982i = d.f369966a;
        this.f369983j = a.f369956a;
        this.f369984k = e.f369967a;
        this.f369985l = f.f369969a;
    }
}
