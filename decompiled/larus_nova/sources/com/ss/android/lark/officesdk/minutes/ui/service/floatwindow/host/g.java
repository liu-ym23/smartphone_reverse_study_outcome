package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g implements ComponentCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f436869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ hwb.c f436870b;

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        int r101 = r100.uiMode & 48;
        e r102 = this.f436869a;
        if (r101 != r102.f436863m) goto L5;
        return;
    L5:
        r102.f436863m = r101;
        int r103 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FLOAT, "onConfigurationChanged", "nightModeMask=" + r101 + ", recordingId=" + this.f436870b.f487443a, null, 8);
        this.f436869a.g(this.f436870b, r100);
    }

    public g(e r100, hwb.c r101) {
        this.f436869a = r100;
        this.f436870b = r101;
    }
}
