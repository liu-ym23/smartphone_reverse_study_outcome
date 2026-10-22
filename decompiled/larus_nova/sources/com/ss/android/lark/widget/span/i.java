package com.ss.android.lark.widget.span;

import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i extends k implements Drawable.Callback {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f448689d;

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        this.f448689d.invoke();
        invalidateSelf();
    }

    public i(e r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r101, "onInvalidate");
        super(r100);
        this.f448689d = r101;
        r100.setCallback(this);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "who");
        Intrinsics.checkNotNullParameter(r101, "what");
        unscheduleSelf(r101);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "who");
        Intrinsics.checkNotNullParameter(r101, "what");
        scheduleSelf(r101, r102);
    }
}
