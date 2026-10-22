package com.bytedance.awemeopen.apps.framework.card.video;

import com.bytedance.awemeopen.infra.base.player.AoVideoView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class VideoCardPreRender implements com.bytedance.awemeopen.apps.framework.player.e {
    public final com.bytedance.awemeopen.infra.base.player.g a;
    public boolean b;
    public boolean c;

    public VideoCardPreRender(com.bytedance.awemeopen.infra.base.player.g r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        this.a = r2;
    }

    @Override // com.bytedance.awemeopen.apps.framework.player.e
    public final void a(final com.bytedance.awemeopen.apps.framework.player.f r3) {
        Intrinsics.checkNotNullParameter(r3, "preRenderData");
        AoVideoView r0 = r3.a;
        if ((r0 instanceof AoVideoView) == false) goto L6;
        r0.c(new VideoCardPreRender$addPreRenderData$1(r3, this));
        return;
    }
}
