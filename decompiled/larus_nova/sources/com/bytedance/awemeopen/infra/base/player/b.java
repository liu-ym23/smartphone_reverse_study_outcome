package com.bytedance.awemeopen.infra.base.player;

import com.bytedance.awemeopen.servicesapi.player.AoPlayerService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f198737a = 0;

    static {
    }

    public static void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "aoPlayerInitConfig");
        int r101 = j64.b.f497514a;
        AoPlayerService r102 = (AoPlayerService) j64.b.a(AoPlayerService.class);
        Intrinsics.checkNotNullParameter(r100.f198739a, "<set-?>");
        Intrinsics.checkNotNullParameter(r100.f198740b, "<set-?>");
        Intrinsics.checkNotNullParameter(r100.f198741c, "<set-?>");
        Intrinsics.checkNotNullParameter(r100.f198742d, "<set-?>");
        r102.L0();
    }
}
