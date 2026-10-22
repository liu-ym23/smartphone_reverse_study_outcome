package com.bytedance.awemeopen.apps.framework.player;

import android.view.Surface;
import com.bytedance.awemeopen.infra.base.player.AoVideoView;
import com.bytedance.awemeopen.infra.base.player.h;
import com.bytedance.awemeopen.infra.base.player.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f197282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f197283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f197284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Surface f197285d;

    public f(AoVideoView r100, j r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "request");
        this.f197282a = r100;
        this.f197283b = r101;
        this.f197284c = r102;
        this.f197285d = null;
    }
}
