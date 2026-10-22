package com.ss.ugc.effectplatform.task;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
public final class z implements com.ss.ugc.effectplatform.download.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f458004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f458005b;

    @Override // com.ss.ugc.effectplatform.download.e
    public final void onStart() {
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [V, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r1v3, types: [V, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r2v1, types: [V, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Exception] */
    @Override // com.ss.ugc.effectplatform.download.e
    public final void a(com.ss.ugc.effectplatform.download.g r100) {
        if (r100.a() == false) goto L5;
        a0.b<Long> r101 = this.f458004a.f457995f;
        r101.f1239a = Long.valueOf(r100.f457387d);
        a0.b<Long> r102 = this.f458004a.f457994e;
        r102.f1239a = Long.valueOf(r100.f457384a);
        long r103 = r100.f457388e;
        int r104 = elc.a.f473043a;
        long r105 = r103 / ((long) 1024);
        a0.b<Long> r106 = this.f458004a.f457996g;
        r106.f1239a = Long.valueOf(r105);
        this.f458004a.f457997h.setZipSize(r105);
        return;
    L5:
        Ref.ObjectRef r107 = this.f458005b;
        r107.element = r100.f457389f;
    }

    public z(y r100, Ref.ObjectRef r101) {
        this.f458004a = r100;
        this.f458005b = r101;
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.a
    public final void onProgress(int r100, long r101) {
        y r102 = this.f458004a;
        r102.g(r102, r100, r101);
    }
}
