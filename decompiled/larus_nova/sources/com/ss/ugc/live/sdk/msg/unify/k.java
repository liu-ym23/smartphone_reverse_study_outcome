package com.ss.ugc.live.sdk.msg.unify;

import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWUplinkPacket;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f458427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UMGWUplinkPacket f458428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f458429c;

    public k(UMGWUplinkPacket r100, c r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "uplinkPacket");
        Intrinsics.checkNotNullParameter(r101, "bridge");
        this.f458428b = r100;
        this.f458429c = r102;
    }
}
