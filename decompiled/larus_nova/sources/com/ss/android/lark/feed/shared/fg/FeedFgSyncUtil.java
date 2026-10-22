package com.ss.android.lark.feed.shared.fg;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedFgSyncUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f421177a = null;

    static {
        f421177a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, FeedFgSyncUtil$enableFeedGroup$2.INSTANCE);
    }
}
