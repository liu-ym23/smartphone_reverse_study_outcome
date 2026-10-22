package com.larus.im.internal.rtcsdk.impl;

import com.ss.bytertc.engine.video.IVideoFrame;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class t1 implements com.larus.im.service.audio.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IVideoFrame f349994a;

    public t1(IVideoFrame r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        this.f349994a = r100;
    }
}
