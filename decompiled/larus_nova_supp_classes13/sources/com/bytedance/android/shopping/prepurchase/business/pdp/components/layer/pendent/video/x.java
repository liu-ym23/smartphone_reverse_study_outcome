package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import com.bytedance.android.shopping.api.video.AVScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class x {
    public final com.bytedance.android.shopping.anchorv4.video.f a;
    public final Boolean b;
    public final Boolean c;
    public final AVScene d;
    public final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b e;
    public final boolean f;
    public x73.c g;
    public final Float h;

    public x(com.bytedance.android.shopping.anchorv4.video.f r2, Boolean r3, Boolean r4, AVScene r5, com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r6, boolean r7, x73.c r8, Float r9) {
        Intrinsics.checkNotNullParameter(r2, "playerStateManager");
        Intrinsics.checkNotNullParameter(r5, "avScene");
        Intrinsics.checkNotNullParameter(r6, "videoModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
