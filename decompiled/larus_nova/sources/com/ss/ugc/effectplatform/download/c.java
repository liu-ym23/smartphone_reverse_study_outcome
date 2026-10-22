package com.ss.ugc.effectplatform.download;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f457372a;

    @Override // com.ss.ugc.effectplatform.bridge.network.a
    public final void onProgress(int r100, long r101) {
    }

    @Override // com.ss.ugc.effectplatform.download.e
    public final void onStart() {
    }

    public c(Ref.ObjectRef r100) {
        this.f457372a = r100;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Exception] */
    @Override // com.ss.ugc.effectplatform.download.e
    public final void a(g r100) {
        if (r100.a() == true) goto L6;
        Ref.ObjectRef r101 = this.f457372a;
        r101.element = r100.f457389f;
        return;
    }
}
