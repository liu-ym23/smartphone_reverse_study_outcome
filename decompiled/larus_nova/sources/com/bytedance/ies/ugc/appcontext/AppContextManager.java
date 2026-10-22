package com.bytedance.ies.ugc.appcontext;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public final class AppContextManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f248843a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f248844b;

    static {
        f248843a = LazyKt.lazy(AppContextManager$STRING_APP_NAME$2.INSTANCE);
        f248844b = "unknown";
    }
}
