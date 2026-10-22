package com.bytedance.live.artist.core;

import com.bytedance.live.artist.render.RenderEntity$prepareAsync$1;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EntityManager f254823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoreEngine f254824b;

    public b(CoreEngine r100) {
        this.f254824b = r100;
        this.f254823a = new EntityManager(this);
    }

    public final void a(RenderEntity$prepareAsync$1.AnonymousClass1 r100) {
        CoreEngine r101 = this.f254824b;
        if (r101.f254799f == false) goto L7;
        BuildersKt.launch$default(r101.f254797d, null, null, new CoreEngine$submitAsyncTask$1(r101, r100, null), 3, null);
        return;
    }
}
