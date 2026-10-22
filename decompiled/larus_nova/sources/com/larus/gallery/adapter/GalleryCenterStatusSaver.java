package com.larus.gallery.adapter;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.gallery.api.DisplayGravity;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes29.dex */
public final class GalleryCenterStatusSaver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f343653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f343654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateFlowImpl f343655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b1 f343656d;

    public final void a(boolean r110) {
        FLogger.f375446a.i("GalleryCenterStatusSaver", "updateCurrentCenterMode: isCenterMode " + r110);
        this.f343654b = r110;
        BuildersKt.launch$default(this.f343653a, null, null, new GalleryCenterStatusSaver$updateCurrentCenterMode$1(this, r110, null), 3, null);
    }

    public GalleryCenterStatusSaver(LifecycleCoroutineScope r100, com.larus.gallery.api.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f343653a = r100;
        boolean r102 = true;
        this.f343654b = true;
        StateFlowImpl r103 = j1.a(Boolean.TRUE);
        this.f343655c = r103;
        this.f343656d = kotlinx.coroutines.flow.e.b(r103);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f343819c == DisplayGravity.CENTER) goto L8;
        r102 = false;
    L8:
        a(r102);
    }
}
