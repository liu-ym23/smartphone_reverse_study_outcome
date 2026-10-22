package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.model.net.EffectListResponse;

/* JADX INFO: loaded from: classes36.dex */
public final class FetchEffectListByIdsTask$onSuccess$4 implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FetchEffectListByIdsTask f457604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EffectListResponse f457605b;

    @Override // com.ss.ugc.effectplatform.task.r
    public final void onSuccess() {
        this.f457604a.e(new FetchEffectListByIdsTask$onSuccess$4$onSuccess$1(this));
    }

    public FetchEffectListByIdsTask$onSuccess$4(FetchEffectListByIdsTask r100, EffectListResponse r101) {
        this.f457604a = r100;
        this.f457605b = r101;
    }
}
