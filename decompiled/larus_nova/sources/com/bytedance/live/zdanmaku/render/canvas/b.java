package com.bytedance.live.zdanmaku.render.canvas;

import android.graphics.Canvas;
import com.bytedance.live.artist.render.e;
import com.facebook.drawee.generic.RootDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b extends e implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Canvas f255887c;

    @Override // com.bytedance.live.artist.render.e
    public final void f() {
        Canvas r100 = this.f255887c;
        if (r100 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.zdanmaku.units.b r101 = (com.bytedance.android.livesdk.interactivity.zdanmaku.units.b) this;
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.save();
        r100.translate(r101.c().f254829d.f254847a, r101.c().f254829d.f254848b);
        RootDrawable r102 = r101.f141810d;
        if (r102 == null) goto L7;
        r102.draw(r100);
    L7:
        r100.restore();
        return;
    }

    public b() {
    }

    @Override // com.bytedance.live.zdanmaku.render.canvas.d
    public final void b(Canvas r100) {
        this.f255887c = r100;
    }
}
