package com.bytedance.awemeopen.domain.young.feed;

import android.content.Context;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class YoungFeedDomain {
    public YoungFeedDomain() {
    }

    public static void a(final Context r100, final a r101, final Function1 r102, final Function3 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "filter");
        Intrinsics.checkNotNullParameter(r103, "callback");
        AoPool.a(new YoungFeedDomain$loadMoreFeed$1(r100, r101, r102, r103));
    }

    public static void b(final Context r100, final a r101, final Function1 r102, final Function4 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "filter");
        Intrinsics.checkNotNullParameter(r103, "callback");
        AoPool.a(new YoungFeedDomain$refreshFeed$1(r100, r101, r102, r103));
    }
}
