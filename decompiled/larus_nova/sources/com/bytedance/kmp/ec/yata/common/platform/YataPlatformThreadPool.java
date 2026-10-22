package com.bytedance.kmp.ec.yata.common.platform;

import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "SDK内部工具类")
public final class YataPlatformThreadPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f251503a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f251504b = null;

    static {
        f251503a = LazyKt.lazy(YataPlatformThreadPool$logThread$2.INSTANCE);
        f251504b = LazyKt.lazy(YataPlatformThreadPool$bgThread$2.INSTANCE);
    }
}
