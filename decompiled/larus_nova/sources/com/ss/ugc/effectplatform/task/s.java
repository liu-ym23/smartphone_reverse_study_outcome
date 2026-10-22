package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.model.net.EffectListResponse;

/* JADX INFO: loaded from: classes36.dex */
public final class s implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f457929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f457930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f457931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f457932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ EffectListResponse f457933e;

    @Override // com.ss.ugc.effectplatform.task.r
    public final void onSuccess() {
        t.q(this.f457929a, this.f457930b, this.f457931c, this.f457932d, this.f457933e);
    }

    public s(t r100, long r101, long r102, long r103, EffectListResponse r104) {
        this.f457929a = r100;
        this.f457930b = r101;
        this.f457931c = r102;
        this.f457932d = r103;
        this.f457933e = r104;
    }
}
