package com.bytedance.awemeopen.apps.framework.player;

import android.view.Surface;
import com.bytedance.awemeopen.infra.base.player.AoVideoView;
import com.bytedance.awemeopen.infra.base.player.h;
import com.bytedance.awemeopen.infra.base.player.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public final h a;
    public final j b;
    public final int c;
    public Surface d;

    public f(AoVideoView r2, j r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = null;
    }
}
