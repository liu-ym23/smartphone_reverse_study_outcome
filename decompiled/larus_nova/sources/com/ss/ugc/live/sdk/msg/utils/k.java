package com.ss.ugc.live.sdk.msg.utils;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mmc.c f458483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g<?, Throwable> f458484b;

    /* JADX WARN: Multi-variable type inference failed */
    public k(mmc.c r100, g<?, ? extends Throwable> r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "result");
        this.f458483a = r100;
        this.f458484b = r101;
    }
}
