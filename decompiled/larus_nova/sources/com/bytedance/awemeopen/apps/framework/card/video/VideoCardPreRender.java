package com.bytedance.awemeopen.apps.framework.card.video;

import com.bytedance.awemeopen.infra.base.player.AoVideoView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class VideoCardPreRender implements com.bytedance.awemeopen.apps.framework.player.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.awemeopen.infra.base.player.g f193857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f193858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f193859c;

    public VideoCardPreRender(com.bytedance.awemeopen.infra.base.player.g r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        this.f193857a = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.player.e
    public final void a(final com.bytedance.awemeopen.apps.framework.player.f r100) {
        Intrinsics.checkNotNullParameter(r100, "preRenderData");
        com.bytedance.awemeopen.infra.base.player.h r101 = r100.f197282a;
        if ((r101 instanceof AoVideoView) == false) goto L6;
        ((AoVideoView) r101).c(new VideoCardPreRender$addPreRenderData$1(r100, this));
        return;
    }
}
