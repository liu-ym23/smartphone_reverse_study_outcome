package com.larksuite.rucket.job.impl;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.RucketJobImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class FutureRucketJob<T> extends RucketJobImpl<T> {
    public FutureRucketJob() {
    }

    public final void b(RucketJob<T> r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        r100.setNextJob(nextJob());
        r100.setPrevJob(prevJob());
        RucketJob.error$default(RucketJob.then$default(r100, null, new FutureRucketJob$setOrigin$1(this, null), 1, null), null, new FutureRucketJob$setOrigin$2(this, null), 1, null);
    }
}
