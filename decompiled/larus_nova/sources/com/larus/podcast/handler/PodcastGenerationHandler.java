package com.larus.podcast.handler;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes31.dex */
public final class PodcastGenerationHandler {

    public static final class a {
    }

    static {
    }

    public static void a(vr9.a r110, Function0 r111, Function0 r112) {
        Intrinsics.checkNotNullParameter(r110, "podcastGenerateContext");
        FLogger.f375446a.i("PodcastMenuHandler", "handleAction...");
        CoroutineScope r100 = r110.f556936b;
        if (r100 == null) goto L6;
        BuildersKt.launch$default(r100, Dispatchers.getIO(), null, new PodcastGenerationHandler$generatePodcast$1$1(r110, r110, r112, r111, null), 2, null);
        return;
    }
}
