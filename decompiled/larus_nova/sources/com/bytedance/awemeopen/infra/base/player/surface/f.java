package com.bytedance.awemeopen.infra.base.player.surface;

import android.graphics.SurfaceTexture;
import android.view.View;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f198789a;

    public f(i r100) {
        this.f198789a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        i r101 = this.f198789a;
        if (Intrinsics.areEqual(r101.f198797e, r101.f198795c) == true) goto L7;
        i r102 = this.f198789a;
        SurfaceTexture r103 = r102.f198795c;
        if (r103 == null) goto L7;
        r102.f198793a.setSurfaceTexture(r103);
        r102.f198797e = r103;
    L7:
        AoLogger.g("TextureViewHolder", new Object[]{"onViewAttachedToWindow:" + r100 + ", preset texture: " + this.f198789a.f198795c});
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        AoLogger.g("TextureViewHolder", new Object[]{"onViewDetachedFromWindow:" + r100});
        i r101 = this.f198789a;
        SurfaceTexture r102 = r101.f198797e;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101.f198794b == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r101.f198793a.getSurfaceTexture(), r102) == true) goto L12;
        r101.f198793a.setSurfaceTexture(r102);
        return;
    }
}
