package com.bytedance.awemeopen.infra.base.player.surface;

import android.content.Context;
import android.graphics.SurfaceTexture;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j extends AbsSurfaceSource {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SurfaceTexture f198800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f198801f;

    public j() {
        this(null, null, 7);
    }

    @Override // com.bytedance.awemeopen.infra.base.player.surface.AbsSurfaceSource
    public final i a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "c");
        return new i(r100, this.f198800e, this.f198801f);
    }

    public j(SurfaceTexture r100, Function0 r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = null;
    L8:
        super(null);
        this.f198800e = r100;
        this.f198801f = r101;
    }
}
