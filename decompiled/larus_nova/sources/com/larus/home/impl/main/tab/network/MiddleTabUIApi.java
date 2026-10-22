package com.larus.home.impl.main.tab.network;

import kotlin.Deprecated;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes29.dex */
public final class MiddleTabUIApi {
    static {
    }

    @Deprecated(message = "TabBarConfigApi instead")
    public static Object a(Continuation r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MiddleTabUIApi$fetchLottieDownloadInfo$2(null), r100);
    }
}
